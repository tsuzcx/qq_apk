package android.support.v4.content;

import android.net.Uri;
import android.net.Uri.Builder;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class FileProvider$b
  implements FileProvider.a
{
  private final String zD;
  final HashMap<String, File> zE = new HashMap();
  
  FileProvider$b(String paramString)
  {
    this.zD = paramString;
  }
  
  public final File c(Uri paramUri)
  {
    Object localObject2 = paramUri.getEncodedPath();
    int i = ((String)localObject2).indexOf('/', 1);
    Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
    localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
    localObject1 = (File)this.zE.get(localObject1);
    if (localObject1 == null) {
      throw new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(paramUri)));
    }
    paramUri = new File((File)localObject1, (String)localObject2);
    try
    {
      localObject2 = paramUri.getCanonicalFile();
      if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath())) {
        throw new SecurityException("Resolved path jumped beyond configured root");
      }
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramUri)));
    }
    return localObject2;
  }
  
  public final Uri i(File paramFile)
  {
    for (;;)
    {
      String str1;
      try
      {
        str1 = paramFile.getCanonicalPath();
        paramFile = null;
        Iterator localIterator = this.zE.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator.next();
          String str2 = ((File)localEntry2.getValue()).getPath();
          if (!str1.startsWith(str2)) {
            break label257;
          }
          Map.Entry localEntry1 = localEntry2;
          if (paramFile != null)
          {
            if (str2.length() <= ((File)paramFile.getValue()).getPath().length()) {
              break label257;
            }
            localEntry1 = localEntry2;
          }
          paramFile = localEntry1;
          continue;
        }
        if (paramFile != null) {
          break label143;
        }
      }
      catch (IOException localIOException)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramFile)));
      }
      throw new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(str1)));
      label143:
      Object localObject = ((File)paramFile.getValue()).getPath();
      if (((String)localObject).endsWith("/")) {}
      for (localObject = str1.substring(((String)localObject).length());; localObject = str1.substring(((String)localObject).length() + 1))
      {
        paramFile = Uri.encode((String)paramFile.getKey()) + '/' + Uri.encode((String)localObject, "/");
        return new Uri.Builder().scheme("content").authority(this.zD).encodedPath(paramFile).build();
      }
      label257:
      localObject = paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.content.FileProvider.b
 * JD-Core Version:    0.7.0.1
 */