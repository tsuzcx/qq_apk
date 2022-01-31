package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.util.HashMap;

public class FileProvider
  extends ContentProvider
{
  private static final String[] yY = { "_display_name", "_size" };
  private static final File yZ = new File("/");
  private static HashMap<String, a> za = new HashMap();
  private a zb;
  
  private static File a(File paramFile, String... paramVarArgs)
  {
    int i = 0;
    if (i <= 0)
    {
      String str = paramVarArgs[0];
      if (str == null) {
        break label33;
      }
      paramFile = new File(paramFile, str);
    }
    label33:
    for (;;)
    {
      i += 1;
      break;
      return paramFile;
    }
  }
  
  /* Error */
  private static a f(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 44	android/support/v4/content/FileProvider:za	Ljava/util/HashMap;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: getstatic 44	android/support/v4/content/FileProvider:za	Ljava/util/HashMap;
    //   11: aload_1
    //   12: invokevirtual 60	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 6	android/support/v4/content/FileProvider$a
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: ifnonnull +373 -> 398
    //   28: new 9	android/support/v4/content/FileProvider$b
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 61	android/support/v4/content/FileProvider$b:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload_0
    //   39: invokevirtual 67	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   42: aload_1
    //   43: sipush 128
    //   46: invokevirtual 73	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   49: aload_0
    //   50: invokevirtual 67	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   53: ldc 75
    //   55: invokevirtual 81	android/content/pm/ProviderInfo:loadXmlMetaData	(Landroid/content/pm/PackageManager;Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
    //   58: astore 6
    //   60: aload 6
    //   62: ifnonnull +50 -> 112
    //   65: new 83	java/lang/IllegalArgumentException
    //   68: dup
    //   69: ldc 85
    //   71: invokespecial 86	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   74: athrow
    //   75: astore_0
    //   76: new 83	java/lang/IllegalArgumentException
    //   79: dup
    //   80: ldc 88
    //   82: aload_0
    //   83: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_0
    //   88: aload 5
    //   90: monitorexit
    //   91: aload_0
    //   92: athrow
    //   93: aload_3
    //   94: invokevirtual 95	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   97: astore 8
    //   99: aload 4
    //   101: getfield 98	android/support/v4/content/FileProvider$b:zd	Ljava/util/HashMap;
    //   104: aload 7
    //   106: aload 8
    //   108: invokevirtual 102	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   111: pop
    //   112: aload 6
    //   114: invokeinterface 108 1 0
    //   119: istore_2
    //   120: iload_2
    //   121: iconst_1
    //   122: if_icmpeq +263 -> 385
    //   125: iload_2
    //   126: iconst_2
    //   127: if_icmpne -15 -> 112
    //   130: aload 6
    //   132: invokeinterface 112 1 0
    //   137: astore_3
    //   138: aload 6
    //   140: aconst_null
    //   141: ldc 114
    //   143: invokeinterface 118 3 0
    //   148: astore 7
    //   150: aload 6
    //   152: aconst_null
    //   153: ldc 120
    //   155: invokeinterface 118 3 0
    //   160: astore 8
    //   162: ldc 122
    //   164: aload_3
    //   165: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +55 -> 223
    //   171: getstatic 38	android/support/v4/content/FileProvider:yZ	Ljava/io/File;
    //   174: astore_3
    //   175: aload_3
    //   176: ifnull -64 -> 112
    //   179: aload_3
    //   180: iconst_1
    //   181: anewarray 22	java/lang/String
    //   184: dup
    //   185: iconst_0
    //   186: aload 8
    //   188: aastore
    //   189: invokestatic 128	android/support/v4/content/FileProvider:a	(Ljava/io/File;[Ljava/lang/String;)Ljava/io/File;
    //   192: astore_3
    //   193: aload 7
    //   195: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   198: ifeq -105 -> 93
    //   201: new 83	java/lang/IllegalArgumentException
    //   204: dup
    //   205: ldc 136
    //   207: invokespecial 86	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   210: athrow
    //   211: astore_0
    //   212: new 83	java/lang/IllegalArgumentException
    //   215: dup
    //   216: ldc 88
    //   218: aload_0
    //   219: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: athrow
    //   223: ldc 138
    //   225: aload_3
    //   226: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifeq +11 -> 240
    //   232: aload_0
    //   233: invokevirtual 141	android/content/Context:getFilesDir	()Ljava/io/File;
    //   236: astore_3
    //   237: goto -62 -> 175
    //   240: ldc 143
    //   242: aload_3
    //   243: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   246: ifeq +11 -> 257
    //   249: aload_0
    //   250: invokevirtual 146	android/content/Context:getCacheDir	()Ljava/io/File;
    //   253: astore_3
    //   254: goto -79 -> 175
    //   257: ldc 148
    //   259: aload_3
    //   260: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +10 -> 273
    //   266: invokestatic 153	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   269: astore_3
    //   270: goto -95 -> 175
    //   273: ldc 155
    //   275: aload_3
    //   276: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   279: ifeq +20 -> 299
    //   282: aload_0
    //   283: invokestatic 161	android/support/v4/content/b:O	(Landroid/content/Context;)[Ljava/io/File;
    //   286: astore_3
    //   287: aload_3
    //   288: arraylength
    //   289: ifle +114 -> 403
    //   292: aload_3
    //   293: iconst_0
    //   294: aaload
    //   295: astore_3
    //   296: goto -121 -> 175
    //   299: ldc 163
    //   301: aload_3
    //   302: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   305: ifeq +20 -> 325
    //   308: aload_0
    //   309: invokestatic 166	android/support/v4/content/b:P	(Landroid/content/Context;)[Ljava/io/File;
    //   312: astore_3
    //   313: aload_3
    //   314: arraylength
    //   315: ifle +88 -> 403
    //   318: aload_3
    //   319: iconst_0
    //   320: aaload
    //   321: astore_3
    //   322: goto -147 -> 175
    //   325: getstatic 172	android/os/Build$VERSION:SDK_INT	I
    //   328: bipush 21
    //   330: if_icmplt +73 -> 403
    //   333: ldc 174
    //   335: aload_3
    //   336: invokevirtual 126	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifeq +64 -> 403
    //   342: aload_0
    //   343: invokevirtual 178	android/content/Context:getExternalMediaDirs	()[Ljava/io/File;
    //   346: astore_3
    //   347: aload_3
    //   348: arraylength
    //   349: ifle +54 -> 403
    //   352: aload_3
    //   353: iconst_0
    //   354: aaload
    //   355: astore_3
    //   356: goto -181 -> 175
    //   359: astore_0
    //   360: new 83	java/lang/IllegalArgumentException
    //   363: dup
    //   364: new 180	java/lang/StringBuilder
    //   367: dup
    //   368: ldc 182
    //   370: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   373: aload_3
    //   374: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: aload_0
    //   381: invokespecial 91	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: athrow
    //   385: getstatic 44	android/support/v4/content/FileProvider:za	Ljava/util/HashMap;
    //   388: aload_1
    //   389: aload 4
    //   391: invokevirtual 102	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   394: pop
    //   395: aload 4
    //   397: astore_3
    //   398: aload 5
    //   400: monitorexit
    //   401: aload_3
    //   402: areturn
    //   403: aconst_null
    //   404: astore_3
    //   405: goto -230 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	408	0	paramContext	Context
    //   0	408	1	paramString	String
    //   119	9	2	i	int
    //   22	383	3	localObject1	Object
    //   18	378	4	localObject2	Object
    //   3	396	5	localHashMap	HashMap
    //   58	93	6	localXmlResourceParser	android.content.res.XmlResourceParser
    //   104	90	7	localObject3	Object
    //   97	90	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   28	60	75	java/io/IOException
    //   65	75	75	java/io/IOException
    //   99	112	75	java/io/IOException
    //   112	120	75	java/io/IOException
    //   130	175	75	java/io/IOException
    //   179	211	75	java/io/IOException
    //   223	237	75	java/io/IOException
    //   240	254	75	java/io/IOException
    //   257	270	75	java/io/IOException
    //   273	292	75	java/io/IOException
    //   299	318	75	java/io/IOException
    //   325	352	75	java/io/IOException
    //   360	385	75	java/io/IOException
    //   8	20	87	finally
    //   28	60	87	finally
    //   65	75	87	finally
    //   76	87	87	finally
    //   88	91	87	finally
    //   93	99	87	finally
    //   99	112	87	finally
    //   112	120	87	finally
    //   130	175	87	finally
    //   179	211	87	finally
    //   212	223	87	finally
    //   223	237	87	finally
    //   240	254	87	finally
    //   257	270	87	finally
    //   273	292	87	finally
    //   299	318	87	finally
    //   325	352	87	finally
    //   360	385	87	finally
    //   385	395	87	finally
    //   398	401	87	finally
    //   28	60	211	org/xmlpull/v1/XmlPullParserException
    //   65	75	211	org/xmlpull/v1/XmlPullParserException
    //   93	99	211	org/xmlpull/v1/XmlPullParserException
    //   99	112	211	org/xmlpull/v1/XmlPullParserException
    //   112	120	211	org/xmlpull/v1/XmlPullParserException
    //   130	175	211	org/xmlpull/v1/XmlPullParserException
    //   179	211	211	org/xmlpull/v1/XmlPullParserException
    //   223	237	211	org/xmlpull/v1/XmlPullParserException
    //   240	254	211	org/xmlpull/v1/XmlPullParserException
    //   257	270	211	org/xmlpull/v1/XmlPullParserException
    //   273	292	211	org/xmlpull/v1/XmlPullParserException
    //   299	318	211	org/xmlpull/v1/XmlPullParserException
    //   325	352	211	org/xmlpull/v1/XmlPullParserException
    //   360	385	211	org/xmlpull/v1/XmlPullParserException
    //   93	99	359	java/io/IOException
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
    this.zb = f(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.zb.c(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = this.zb.c(paramUri);
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
    paramUri = this.zb.c(paramUri);
    int i;
    if ("r".equals(paramString)) {
      i = 268435456;
    }
    for (;;)
    {
      return ParcelFileDescriptor.open(paramUri, i);
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
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = this.zb.c(paramUri);
    paramUri = paramArrayOfString1;
    if (paramArrayOfString1 == null) {
      paramUri = yY;
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
        paramUri = new String[i];
        System.arraycopy(paramArrayOfString2, 0, paramUri, 0, i);
        paramString1 = new Object[i];
        System.arraycopy(paramArrayOfString1, 0, paramString1, 0, i);
        paramUri = new MatrixCursor(paramUri, 1);
        paramUri.addRow(paramString1);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */