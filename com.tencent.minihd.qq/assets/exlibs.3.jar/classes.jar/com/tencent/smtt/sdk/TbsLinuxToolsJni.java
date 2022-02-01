package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;

class TbsLinuxToolsJni
{
  private static boolean a = false;
  private static boolean b = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    a(paramContext);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  /* Error */
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 26
    //   5: new 28	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   12: ldc 31
    //   14: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: getstatic 13	com/tencent/smtt/sdk/TbsLinuxToolsJni:b	Z
    //   20: invokevirtual 38	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: getstatic 13	com/tencent/smtt/sdk/TbsLinuxToolsJni:b	Z
    //   32: ifeq +7 -> 39
    //   35: ldc 2
    //   37: monitorexit
    //   38: return
    //   39: iconst_1
    //   40: putstatic 13	com/tencent/smtt/sdk/TbsLinuxToolsJni:b	Z
    //   43: aload_1
    //   44: invokestatic 54	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   47: ifeq +172 -> 219
    //   50: new 56	java/io/File
    //   53: dup
    //   54: invokestatic 58	com/tencent/smtt/sdk/TbsShareManager:a	()Ljava/lang/String;
    //   57: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_2
    //   61: aload_2
    //   62: ifnull +138 -> 200
    //   65: new 56	java/io/File
    //   68: dup
    //   69: new 28	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   76: aload_2
    //   77: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: getstatic 68	java/io/File:separator	Ljava/lang/String;
    //   86: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 70
    //   91: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 4
    //   102: aload 4
    //   104: ifnull +13 -> 117
    //   107: aload_2
    //   108: astore_3
    //   109: aload 4
    //   111: invokevirtual 74	java/io/File:exists	()Z
    //   114: ifne +20 -> 134
    //   117: aload_2
    //   118: astore_3
    //   119: aload_1
    //   120: invokestatic 54	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   123: ifne +11 -> 134
    //   126: invokestatic 79	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   129: aload_1
    //   130: invokevirtual 83	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   133: astore_3
    //   134: aload_3
    //   135: ifnull +65 -> 200
    //   138: ldc 26
    //   140: new 28	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   147: ldc 85
    //   149: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: new 28	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   172: aload_3
    //   173: invokevirtual 64	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   176: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 68	java/io/File:separator	Ljava/lang/String;
    //   182: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 70
    //   187: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 90	java/lang/System:load	(Ljava/lang/String;)V
    //   196: iconst_1
    //   197: putstatic 11	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	Z
    //   200: aload_0
    //   201: ldc 92
    //   203: ldc 94
    //   205: invokespecial 96	com/tencent/smtt/sdk/TbsLinuxToolsJni:ChmodInner	(Ljava/lang/String;Ljava/lang/String;)I
    //   208: pop
    //   209: ldc 2
    //   211: monitorexit
    //   212: return
    //   213: astore_1
    //   214: ldc 2
    //   216: monitorexit
    //   217: aload_1
    //   218: athrow
    //   219: invokestatic 79	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   222: aload_1
    //   223: invokevirtual 99	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   226: astore_2
    //   227: goto -166 -> 61
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 102	java/lang/Throwable:printStackTrace	()V
    //   235: iconst_0
    //   236: putstatic 11	com/tencent/smtt/sdk/TbsLinuxToolsJni:a	Z
    //   239: ldc 26
    //   241: new 28	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   248: ldc 104
    //   250: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: aload_1
    //   254: invokevirtual 107	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   257: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 109
    //   262: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_1
    //   266: invokevirtual 113	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   269: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 48	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: goto -69 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	TbsLinuxToolsJni
    //   0	281	1	paramContext	Context
    //   60	167	2	localFile1	java.io.File
    //   108	65	3	localFile2	java.io.File
    //   100	10	4	localFile3	java.io.File
    // Exception table:
    //   from	to	target	type
    //   3	38	213	finally
    //   39	43	213	finally
    //   43	61	213	finally
    //   65	102	213	finally
    //   109	117	213	finally
    //   119	134	213	finally
    //   138	200	213	finally
    //   200	209	213	finally
    //   209	212	213	finally
    //   214	217	213	finally
    //   219	227	213	finally
    //   231	278	213	finally
    //   43	61	230	java/lang/Throwable
    //   65	102	230	java/lang/Throwable
    //   109	117	230	java/lang/Throwable
    //   119	134	230	java/lang/Throwable
    //   138	200	230	java/lang/Throwable
    //   200	209	230	java/lang/Throwable
    //   219	227	230	java/lang/Throwable
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLinuxToolsJni
 * JD-Core Version:    0.7.0.1
 */