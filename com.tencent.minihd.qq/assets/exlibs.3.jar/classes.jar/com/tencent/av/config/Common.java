package com.tencent.av.config;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public class Common
{
  public static final String AV_SHARP_VERSION = "6.0.0";
  public static final int EM_Device_Android = 201;
  public static final String SHARP_CONFIG_PAYLOAD_FILE_NAME = "SharpConfigPayload";
  public static final String SHARP_CONFIG_TYPE_CLEAR = "0";
  public static final String SHARP_CONFIG_TYPE_PAYLOAD = "1";
  public static final String SHARP_CONFIG_TYPE_URL = "2";
  private static final String TAG = "Common";
  public static final String VIDEO_CONFIG_INFO_FILE_NAME = "VideoConfigInfo";
  private static final ConcurrentHashMap<String, byte[]> sBuffer = new ConcurrentHashMap();
  
  public static void deleteFile(Context paramContext, String paramString)
  {
    try
    {
      sBuffer.remove(paramString);
      paramContext.deleteFile(paramString);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static String getVersion(Context paramContext)
  {
    String str = "6.0.0";
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      paramContext = str;
      if (localPackageInfo != null)
      {
        paramContext = str;
        if (!TextUtils.isEmpty(localPackageInfo.versionName.trim())) {
          paramContext = localPackageInfo.versionName.trim();
        }
      }
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "6.0.0";
  }
  
  /* Error */
  public static byte[] readFile(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 41	com/tencent/av/config/Common:sBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 93	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 95	[B
    //   10: astore 6
    //   12: aload 6
    //   14: astore 4
    //   16: aload 6
    //   18: ifnonnull +124 -> 142
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore 5
    //   27: aload 6
    //   29: astore_3
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 99	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   35: astore_0
    //   36: aload 6
    //   38: astore_3
    //   39: aload_0
    //   40: astore 5
    //   42: aload_0
    //   43: astore 4
    //   45: aload_0
    //   46: invokevirtual 105	java/io/FileInputStream:available	()I
    //   49: istore_2
    //   50: iload_2
    //   51: ifgt +26 -> 77
    //   54: aload 6
    //   56: astore_3
    //   57: aload_0
    //   58: astore 5
    //   60: aload_0
    //   61: astore 4
    //   63: aload_0
    //   64: invokevirtual 108	java/io/FileInputStream:close	()V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 108	java/io/FileInputStream:close	()V
    //   75: aconst_null
    //   76: areturn
    //   77: aload 6
    //   79: astore_3
    //   80: aload_0
    //   81: astore 5
    //   83: aload_0
    //   84: astore 4
    //   86: iload_2
    //   87: newarray byte
    //   89: astore 6
    //   91: aload 6
    //   93: astore_3
    //   94: aload_0
    //   95: astore 5
    //   97: aload_0
    //   98: astore 4
    //   100: aload_0
    //   101: aload 6
    //   103: invokevirtual 112	java/io/FileInputStream:read	([B)I
    //   106: pop
    //   107: aload 6
    //   109: astore_3
    //   110: aload_0
    //   111: astore 5
    //   113: aload_0
    //   114: astore 4
    //   116: getstatic 41	com/tencent/av/config/Common:sBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   119: aload_1
    //   120: aload 6
    //   122: invokevirtual 116	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload 6
    //   128: astore 4
    //   130: aload_0
    //   131: ifnull +11 -> 142
    //   134: aload_0
    //   135: invokevirtual 108	java/io/FileInputStream:close	()V
    //   138: aload 6
    //   140: astore 4
    //   142: aload 4
    //   144: areturn
    //   145: astore_0
    //   146: aload_3
    //   147: astore 4
    //   149: aload 5
    //   151: ifnull -9 -> 142
    //   154: aload 5
    //   156: invokevirtual 108	java/io/FileInputStream:close	()V
    //   159: aload_3
    //   160: astore 4
    //   162: goto -20 -> 142
    //   165: astore_0
    //   166: aload_3
    //   167: astore 4
    //   169: goto -27 -> 142
    //   172: astore_0
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 108	java/io/FileInputStream:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: astore_0
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: aload 6
    //   191: astore 4
    //   193: goto -51 -> 142
    //   196: astore_1
    //   197: goto -14 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramContext	Context
    //   0	200	1	paramString	String
    //   49	38	2	i	int
    //   29	138	3	arrayOfByte1	byte[]
    //   14	178	4	localObject	Object
    //   25	130	5	localContext	Context
    //   10	180	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	36	145	java/lang/Exception
    //   45	50	145	java/lang/Exception
    //   63	67	145	java/lang/Exception
    //   86	91	145	java/lang/Exception
    //   100	107	145	java/lang/Exception
    //   116	126	145	java/lang/Exception
    //   154	159	165	java/lang/Exception
    //   30	36	172	finally
    //   45	50	172	finally
    //   63	67	172	finally
    //   86	91	172	finally
    //   100	107	172	finally
    //   116	126	172	finally
    //   71	75	185	java/lang/Exception
    //   134	138	188	java/lang/Exception
    //   178	183	196	java/lang/Exception
  }
  
  /* Error */
  public static void writeFile(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore_3
    //   9: aload 6
    //   11: astore 4
    //   13: getstatic 41	com/tencent/av/config/Common:sBuffer	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: aload_1
    //   17: aload_2
    //   18: invokevirtual 116	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: aload 5
    //   24: astore_3
    //   25: aload 6
    //   27: astore 4
    //   29: aload_0
    //   30: aload_1
    //   31: iconst_0
    //   32: invokevirtual 122	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   35: astore_0
    //   36: aload_0
    //   37: astore_3
    //   38: aload_0
    //   39: astore 4
    //   41: aload_0
    //   42: aload_2
    //   43: invokevirtual 128	java/io/FileOutputStream:write	([B)V
    //   46: aload_0
    //   47: ifnull +7 -> 54
    //   50: aload_0
    //   51: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   54: return
    //   55: astore_0
    //   56: aload_3
    //   57: ifnull -3 -> 54
    //   60: aload_3
    //   61: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   64: return
    //   65: astore_0
    //   66: return
    //   67: astore_0
    //   68: aload 4
    //   70: ifnull +8 -> 78
    //   73: aload 4
    //   75: invokevirtual 129	java/io/FileOutputStream:close	()V
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: return
    //   82: astore_1
    //   83: goto -5 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	paramContext	Context
    //   0	86	1	paramString	String
    //   0	86	2	paramArrayOfByte	byte[]
    //   8	53	3	localObject1	Object
    //   11	63	4	localObject2	Object
    //   4	19	5	localObject3	Object
    //   1	25	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   13	22	55	java/lang/Exception
    //   29	36	55	java/lang/Exception
    //   41	46	55	java/lang/Exception
    //   60	64	65	java/lang/Exception
    //   13	22	67	finally
    //   29	36	67	finally
    //   41	46	67	finally
    //   50	54	80	java/lang/Exception
    //   73	78	82	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.config.Common
 * JD-Core Version:    0.7.0.1
 */