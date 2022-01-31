package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String ATTR_NAME = "name";
  private static final String ATTR_PATH = "path";
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final File DEVICE_ROOT = new File("/");
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  private static final String TAG_CACHE_PATH = "cache-path";
  private static final String TAG_EXTERNAL = "external-path";
  private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
  private static final String TAG_EXTERNAL_FILES = "external-files-path";
  private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
  private static final String TAG_FILES_PATH = "files-path";
  private static final String TAG_ROOT_PATH = "root-path";
  private static HashMap<String, a> sCache = new HashMap();
  private a mStrategy;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (str == null) {
        break label40;
      }
      paramFile = new File(paramFile, str);
    }
    label40:
    for (;;)
    {
      i += 1;
      break;
      return paramFile;
    }
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static a getPathStrategy(Context paramContext, String paramString)
  {
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
      return locala1;
    }
    catch (IOException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
      paramContext = finally;
      throw paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
    }
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return getPathStrategy(paramContext, paramString).i(paramFile);
  }
  
  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException("Invalid mode: ".concat(String.valueOf(paramString)));
  }
  
  private static a parsePathStrategy(Context paramContext, String paramString)
  {
    FileProvider.b localb = new FileProvider.b(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser == null) {
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    for (;;)
    {
      try
      {
        Object localObject2 = paramString.getCanonicalFile();
        Object localObject1;
        localb.zE.put(localObject1, localObject2);
        int i = localXmlResourceParser.next();
        if (i != 1)
        {
          if (i != 2) {
            continue;
          }
          paramString = localXmlResourceParser.getName();
          localObject1 = localXmlResourceParser.getAttributeValue(null, "name");
          localObject2 = localXmlResourceParser.getAttributeValue(null, "path");
          if ("root-path".equals(paramString))
          {
            paramString = DEVICE_ROOT;
            if (paramString != null)
            {
              paramString = buildPath(paramString, new String[] { localObject2 });
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                continue;
              }
              throw new IllegalArgumentException("Name must not be empty");
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
              paramString = b.N(paramContext);
              if (paramString.length <= 0) {
                break label320;
              }
              paramString = paramString[0];
              continue;
            }
            if ("external-cache-path".equals(paramString))
            {
              paramString = b.O(paramContext);
              if (paramString.length <= 0) {
                break label320;
              }
              paramString = paramString[0];
              continue;
            }
            if ((Build.VERSION.SDK_INT < 21) || (!"external-media-path".equals(paramString))) {
              break label320;
            }
            paramString = paramContext.getExternalMediaDirs();
            if (paramString.length <= 0) {
              break label320;
            }
            paramString = paramString[0];
            continue;
          }
          continue;
        }
        else
        {
          return localb;
        }
      }
      catch (IOException paramContext)
      {
        throw new IllegalArgumentException("Failed to resolve canonical path for ".concat(String.valueOf(paramString)), paramContext);
      }
      label320:
      paramString = null;
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.mStrategy.c(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.mStrategy.c(paramUri);
    int i = paramUri.getName().lastIndexOf('.');
    if (i >= 0)
    {
      paramUri = paramUri.getName().substring(i + 1);
      paramUri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramUri);
      if (paramUri != null) {
        return paramUri;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    return ParcelFileDescriptor.open(this.mStrategy.c(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.mStrategy.c(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = COLUMNS;
    }
    paramArrayOfString2 = new String[paramUri.length];
    paramArrayOfString1 = new Object[paramUri.length];
    int m = paramUri.length;
    int j = 0;
    int i = 0;
    int k;
    if (j < m)
    {
      paramString2 = paramUri[j];
      if ("_display_name".equals(paramString2))
      {
        paramArrayOfString2[i] = "_display_name";
        k = i + 1;
        paramArrayOfString1[i] = paramString1.getName();
        i = k;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if ("_size".equals(paramString2))
      {
        paramArrayOfString2[i] = "_size";
        k = i + 1;
        paramArrayOfString1[i] = Long.valueOf(paramString1.length());
        i = k;
        continue;
        paramUri = copyOf(paramArrayOfString2, i);
        paramArrayOfString1 = copyOf(paramArrayOfString1, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramArrayOfString1);
        return paramUri;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
  
  static abstract interface a
  {
    public abstract File c(Uri paramUri);
    
    public abstract Uri i(File paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */