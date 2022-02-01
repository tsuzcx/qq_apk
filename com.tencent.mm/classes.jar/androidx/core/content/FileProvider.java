package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String ATTR_NAME = "name";
  private static final String ATTR_PATH = "path";
  private static final String[] COLUMNS;
  private static final File DEVICE_ROOT;
  private static final String DISPLAYNAME_FIELD = "displayName";
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  private static final String TAG_CACHE_PATH = "cache-path";
  private static final String TAG_EXTERNAL = "external-path";
  private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
  private static final String TAG_EXTERNAL_FILES = "external-files-path";
  private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
  private static final String TAG_FILES_PATH = "files-path";
  private static final String TAG_ROOT_PATH = "root-path";
  private static HashMap<String, a> sCache;
  private a mStrategy;
  
  static
  {
    AppMethodBeat.i(195597);
    COLUMNS = new String[] { "_display_name", "_size" };
    DEVICE_ROOT = new File("/");
    sCache = new HashMap();
    AppMethodBeat.o(195597);
  }
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    AppMethodBeat.i(195572);
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (str == null) {
        break label50;
      }
      paramFile = new File(paramFile, str);
    }
    label50:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(195572);
      return paramFile;
    }
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(195586);
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    AppMethodBeat.o(195586);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(195579);
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    AppMethodBeat.o(195579);
    return arrayOfString;
  }
  
  private static a getPathStrategy(Context paramContext, String paramString)
  {
    AppMethodBeat.i(195544);
    a locala1;
    synchronized (sCache)
    {
      a locala2 = (a)sCache.get(paramString);
      locala1 = locala2;
      if (locala2 != null) {}
    }
    try
    {
      locala1 = parsePathStrategy(paramContext, paramString);
      sCache.put(paramString, locala1);
      AppMethodBeat.o(195544);
      return locala1;
    }
    catch (IOException paramContext)
    {
      paramContext = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
      AppMethodBeat.o(195544);
      throw paramContext;
      paramContext = finally;
      AppMethodBeat.o(195544);
      throw paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      paramContext = new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
      AppMethodBeat.o(195544);
      throw paramContext;
    }
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    AppMethodBeat.i(195523);
    paramContext = getPathStrategy(paramContext, paramString).l(paramFile);
    AppMethodBeat.o(195523);
    return paramContext;
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString1, File paramFile, String paramString2)
  {
    AppMethodBeat.i(195533);
    paramContext = getUriForFile(paramContext, paramString1, paramFile).buildUpon().appendQueryParameter("displayName", paramString2).build();
    AppMethodBeat.o(195533);
    return paramContext;
  }
  
  private static int modeToMode(String paramString)
  {
    AppMethodBeat.i(195565);
    int i;
    if ("r".equals(paramString)) {
      i = 268435456;
    }
    for (;;)
    {
      AppMethodBeat.o(195565);
      return i;
      if (("w".equals(paramString)) || ("wt".equals(paramString)))
      {
        i = 738197504;
      }
      else if ("wa".equals(paramString))
      {
        i = 704643072;
      }
      else if ("rw".equals(paramString))
      {
        i = 939524096;
      }
      else
      {
        if (!"rwt".equals(paramString)) {
          break;
        }
        i = 1006632960;
      }
    }
    paramString = new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(195565);
    throw paramString;
  }
  
  private static a parsePathStrategy(Context paramContext, String paramString)
  {
    AppMethodBeat.i(195560);
    b localb = new b(paramString);
    Object localObject1 = paramContext.getPackageManager().resolveContentProvider(paramString, 128);
    if (localObject1 == null)
    {
      paramContext = new IllegalArgumentException("Couldn't find meta-data for provider with authority ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(195560);
      throw paramContext;
    }
    localObject1 = ((ProviderInfo)localObject1).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localObject1 == null)
    {
      paramContext = new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
      AppMethodBeat.o(195560);
      throw paramContext;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = paramString.getCanonicalFile();
        Object localObject2;
        localb.bqb.put(localObject2, localObject3);
        int i = ((XmlResourceParser)localObject1).next();
        if (i != 1)
        {
          if (i != 2) {
            continue;
          }
          paramString = ((XmlResourceParser)localObject1).getName();
          localObject2 = ((XmlResourceParser)localObject1).getAttributeValue(null, "name");
          localObject3 = ((XmlResourceParser)localObject1).getAttributeValue(null, "path");
          if ("root-path".equals(paramString))
          {
            paramString = DEVICE_ROOT;
            if (paramString != null)
            {
              paramString = buildPath(paramString, new String[] { localObject3 });
              if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                continue;
              }
              paramContext = new IllegalArgumentException("Name must not be empty");
              AppMethodBeat.o(195560);
              throw paramContext;
            }
          }
          else
          {
            if ("files-path".equals(paramString))
            {
              paramString = paramContext.getFilesDir();
              continue;
            }
            if ("cache-path".equals(paramString))
            {
              paramString = paramContext.getCacheDir();
              continue;
            }
            if ("external-path".equals(paramString))
            {
              paramString = Environment.getExternalStorageDirectory();
              continue;
            }
            if ("external-files-path".equals(paramString))
            {
              paramString = a.aa(paramContext);
              if (paramString.length <= 0) {
                break label385;
              }
              paramString = paramString[0];
              continue;
            }
            if ("external-cache-path".equals(paramString))
            {
              paramString = a.ab(paramContext);
              if (paramString.length <= 0) {
                break label385;
              }
              paramString = paramString[0];
              continue;
            }
            if ((Build.VERSION.SDK_INT < 21) || (!"external-media-path".equals(paramString))) {
              break label385;
            }
            paramString = paramContext.getExternalMediaDirs();
            if (paramString.length <= 0) {
              break label385;
            }
            paramString = paramString[0];
            continue;
          }
          continue;
        }
        AppMethodBeat.o(195560);
      }
      catch (IOException paramContext)
      {
        paramContext = new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramString)), paramContext);
        AppMethodBeat.o(195560);
        throw paramContext;
      }
      return localb;
      label385:
      paramString = null;
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    AppMethodBeat.i(195610);
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported)
    {
      paramContext = new SecurityException("Provider must not be exported");
      AppMethodBeat.o(195610);
      throw paramContext;
    }
    if (!paramProviderInfo.grantUriPermissions)
    {
      paramContext = new SecurityException("Provider must grant uri permissions");
      AppMethodBeat.o(195610);
      throw paramContext;
    }
    this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority.split(";")[0]);
    AppMethodBeat.o(195610);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(195661);
    if (this.mStrategy.e(paramUri).delete())
    {
      AppMethodBeat.o(195661);
      return 1;
    }
    AppMethodBeat.o(195661);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    AppMethodBeat.i(195629);
    paramUri = this.mStrategy.e(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null)
      {
        AppMethodBeat.o(195629);
        return paramUri;
      }
    }
    AppMethodBeat.o(195629);
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(195639);
    paramUri = new UnsupportedOperationException("No external inserts");
    AppMethodBeat.o(195639);
    throw paramUri;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    AppMethodBeat.i(195671);
    paramUri = ParcelFileDescriptor.open(this.mStrategy.e(paramUri), modeToMode(paramString));
    AppMethodBeat.o(195671);
    return paramUri;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(195621);
    paramArrayOfString2 = this.mStrategy.e(paramUri);
    paramString1 = paramUri.getQueryParameter("displayName");
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
    }
    String[] arrayOfString = new String[paramUri.length];
    paramString2 = new Object[paramUri.length];
    int i = 0;
    int m = paramUri.length;
    int j = 0;
    if (j < m)
    {
      paramArrayOfString1 = paramUri[j];
      if ("_display_name".equals(paramArrayOfString1))
      {
        arrayOfString[i] = "_display_name";
        if (paramString1 == null)
        {
          paramArrayOfString1 = paramArrayOfString2.getName();
          label97:
          paramString2[i] = paramArrayOfString1;
          i += 1;
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      paramArrayOfString1 = paramString1;
      break label97;
      if ("_size".equals(paramArrayOfString1))
      {
        arrayOfString[i] = "_size";
        int k = i + 1;
        paramString2[i] = Long.valueOf(paramArrayOfString2.length());
        i = k;
        continue;
        paramUri = copyOf(arrayOfString, i);
        paramArrayOfString1 = copyOf(paramString2, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        AppMethodBeat.o(195621);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(195650);
    paramUri = new UnsupportedOperationException("No external updates");
    AppMethodBeat.o(195650);
    throw paramUri;
  }
  
  static abstract interface a
  {
    public abstract File e(Uri paramUri);
    
    public abstract Uri l(File paramFile);
  }
  
  static final class b
    implements FileProvider.a
  {
    private final String bqa;
    final HashMap<String, File> bqb;
    
    b(String paramString)
    {
      AppMethodBeat.i(195620);
      this.bqb = new HashMap();
      this.bqa = paramString;
      AppMethodBeat.o(195620);
    }
    
    public final File e(Uri paramUri)
    {
      AppMethodBeat.i(195647);
      Object localObject2 = paramUri.getEncodedPath();
      int i = ((String)localObject2).indexOf('/', 1);
      Object localObject1 = Uri.decode(((String)localObject2).substring(1, i));
      localObject2 = Uri.decode(((String)localObject2).substring(i + 1));
      localObject1 = (File)this.bqb.get(localObject1);
      if (localObject1 == null)
      {
        paramUri = new IllegalArgumentException("Unable to find configured root for ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(195647);
        throw paramUri;
      }
      paramUri = new File((File)localObject1, (String)localObject2);
      try
      {
        localObject2 = paramUri.getCanonicalFile();
        if (!((File)localObject2).getPath().startsWith(((File)localObject1).getPath()))
        {
          paramUri = new SecurityException("Resolved path jumped beyond configured root");
          AppMethodBeat.o(195647);
          throw paramUri;
        }
      }
      catch (IOException localIOException)
      {
        paramUri = new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramUri)));
        AppMethodBeat.o(195647);
        throw paramUri;
      }
      AppMethodBeat.o(195647);
      return localObject2;
    }
    
    public final Uri l(File paramFile)
    {
      AppMethodBeat.i(195636);
      for (;;)
      {
        String str1;
        try
        {
          str1 = paramFile.getCanonicalPath();
          paramFile = null;
          Iterator localIterator = this.bqb.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Map.Entry localEntry2 = (Map.Entry)localIterator.next();
            String str2 = ((File)localEntry2.getValue()).getPath();
            if (!str1.startsWith(str2)) {
              break label283;
            }
            Map.Entry localEntry1 = localEntry2;
            if (paramFile != null)
            {
              if (str2.length() <= ((File)paramFile.getValue()).getPath().length()) {
                break label283;
              }
              localEntry1 = localEntry2;
            }
            paramFile = localEntry1;
            continue;
          }
          if (paramFile != null) {
            break label162;
          }
        }
        catch (IOException localIOException)
        {
          paramFile = new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramFile)));
          AppMethodBeat.o(195636);
          throw paramFile;
        }
        paramFile = new IllegalArgumentException("Failed to find configured root that contains ".concat(String.valueOf(str1)));
        AppMethodBeat.o(195636);
        throw paramFile;
        label162:
        Object localObject = ((File)paramFile.getValue()).getPath();
        if (((String)localObject).endsWith("/")) {}
        for (localObject = str1.substring(((String)localObject).length());; localObject = str1.substring(((String)localObject).length() + 1))
        {
          paramFile = Uri.encode((String)paramFile.getKey()) + '/' + Uri.encode((String)localObject, "/");
          paramFile = new Uri.Builder().scheme("content").authority(this.bqa).encodedPath(paramFile).build();
          AppMethodBeat.o(195636);
          return paramFile;
        }
        label283:
        localObject = paramFile;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */