package com.tencent.mm.plugin.expansions;

import android.content.res.AssetManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.toolkit.frontia.a.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public final class e
{
  private static volatile boolean hjd;
  private static volatile com.tencent.mm.toolkit.frontia.a.c.a sBehavior;
  private static final byte[] yFB;
  private static final byte[] yFC;
  private static final byte[] yFD;
  private static final Object yFE;
  private static volatile boolean yFF;
  private static volatile a.a yFG;
  private static final List<String> yFH;
  
  static
  {
    AppMethodBeat.i(273797);
    yFB = new byte[] { 7, 2, -1, -1, -4, 8, -10, -3, 4, 2, -8, -4, 9, 5, -6, -17, 3, 4, 3, 1 };
    yFC = new byte[0];
    yFD = new byte[0];
    yFE = k.class;
    hjd = true;
    yFF = true;
    yFH = new ArrayList();
    sBehavior = new e.1();
    e locale = e.dHG();
    yFG = new a.a(locale, new e.c(locale));
    AppMethodBeat.o(273797);
  }
  
  public static boolean aQh()
  {
    return true;
  }
  
  static void dHA() {}
  
  public static String dHB()
  {
    return null;
  }
  
  public static boolean dHC()
  {
    AppMethodBeat.i(273700);
    boolean bool = requestSync(false);
    AppMethodBeat.o(273700);
    return bool;
  }
  
  public static Future<?> dHD()
  {
    AppMethodBeat.i(273711);
    if (Delivery.isEnabled())
    {
      localFuture = Delivery.request();
      AppMethodBeat.o(273711);
      return localFuture;
    }
    Log.i("MicroMsg.exp.Expansions", "request expansions, isInstalling = true, isForce = false");
    Future localFuture = yFG.PL;
    AppMethodBeat.o(273711);
    return localFuture;
  }
  
  public static boolean dHE()
  {
    return false;
  }
  
  public static boolean dHF()
  {
    return false;
  }
  
  static boolean dHx()
  {
    synchronized (yFD)
    {
      if (yFG != null)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
  }
  
  static boolean dHy()
  {
    AppMethodBeat.i(273684);
    if (Delivery.isEnabled())
    {
      boolean bool = Delivery.isInstalled();
      AppMethodBeat.o(273684);
      return bool;
    }
    AppMethodBeat.o(273684);
    return true;
  }
  
  static void dHz()
  {
    AppMethodBeat.i(273687);
    if (Delivery.isEnabled())
    {
      AppMethodBeat.o(273687);
      return;
    }
    AppMethodBeat.o(273687);
  }
  
  public static void dumpAppClassLoader()
  {
    AppMethodBeat.i(273674);
    Delivery.dumpAppClassLoader();
    AppMethodBeat.o(273674);
  }
  
  public static Future<?> getAssets(a parama)
  {
    AppMethodBeat.i(273762);
    if (Delivery.isEnabled())
    {
      parama = Delivery.getAssets(parama);
      AppMethodBeat.o(273762);
      return parama;
    }
    parama.a(sBehavior.getAssets());
    parama = yFG.PL;
    AppMethodBeat.o(273762);
    return parama;
  }
  
  public static String getLastObbErrorInfo()
  {
    AppMethodBeat.i(273695);
    if (Delivery.isEnabled())
    {
      str = Delivery.getLastObbErrorInfo();
      AppMethodBeat.o(273695);
      return str;
    }
    String str = d.getLastObbErrorInfo();
    AppMethodBeat.o(273695);
    return str;
  }
  
  public static Future<?> install(b paramb)
  {
    AppMethodBeat.i(273742);
    if (Delivery.isEnabled())
    {
      paramb = Delivery.install(paramb);
      AppMethodBeat.o(273742);
      return paramb;
    }
    paramb.a(sBehavior);
    paramb = yFG.PL;
    AppMethodBeat.o(273742);
    return paramb;
  }
  
  public static boolean isInstalled()
  {
    return true;
  }
  
  static boolean isMainProcess()
  {
    AppMethodBeat.i(273789);
    boolean bool = MMApplicationContext.isMainProcess();
    AppMethodBeat.o(273789);
    return bool;
  }
  
  static void prepare()
  {
    AppMethodBeat.i(273692);
    com.tencent.mm.xwebutil.c.a(new com.tencent.mm.xwebutil.c.a() {});
    AppMethodBeat.o(273692);
  }
  
  public static boolean requestSync(boolean paramBoolean)
  {
    AppMethodBeat.i(273704);
    if (Delivery.isEnabled())
    {
      paramBoolean = Delivery.requestSync(paramBoolean);
      AppMethodBeat.o(273704);
      return paramBoolean;
    }
    AppMethodBeat.o(273704);
    return true;
  }
  
  public static AssetManager tryGetAssets()
  {
    AppMethodBeat.i(273751);
    if (Delivery.isEnabled())
    {
      localAssetManager = Delivery.tryGetAssets();
      AppMethodBeat.o(273751);
      return localAssetManager;
    }
    AssetManager localAssetManager = sBehavior.getAssets();
    AppMethodBeat.o(273751);
    return localAssetManager;
  }
  
  public static boolean tryLoadLibrary(String paramString)
  {
    AppMethodBeat.i(273775);
    if (Delivery.isEnabled())
    {
      if (Delivery.tryLoadLibrary(paramString))
      {
        AppMethodBeat.o(273775);
        return true;
      }
      Log.w("MicroMsg.exp.Expansions", "tryLoadLibrary with delivery fail, fallback to legacy!");
    }
    if (yFH.contains(paramString))
    {
      AppMethodBeat.o(273775);
      return true;
    }
    try
    {
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/expansions/JExpansions", "tryLoadLibrary", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/expansions/JExpansions", "tryLoadLibrary", "(Ljava/lang/String;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      yFH.add(paramString);
      AppMethodBeat.o(273775);
      return true;
    }
    finally
    {
      Log.w("MicroMsg.exp.Expansions", "tryLoadLibrary fail, error = " + paramString.getMessage());
      AppMethodBeat.o(273775);
    }
    return false;
  }
  
  public static void updateLang(String paramString)
  {
    AppMethodBeat.i(273783);
    if (Delivery.isEnabled()) {
      Delivery.updateLang(paramString);
    }
    AppMethodBeat.o(273783);
  }
  
  public static abstract interface a
  {
    public abstract void a(AssetManager paramAssetManager);
  }
  
  public static abstract interface b
  {
    public abstract void a(com.tencent.mm.toolkit.frontia.a.c.a parama);
  }
  
  public static final class d
  {
    private static long a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(273654);
      int i;
      for (long l = 0L;; l += i)
      {
        i = paramInputStream.read(paramArrayOfByte);
        if (-1 == i) {
          break;
        }
        paramOutputStream.write(paramArrayOfByte, 0, i);
      }
      AppMethodBeat.o(273654);
      return l;
    }
    
    /* Error */
    public static String a(AssetManager paramAssetManager, String paramString)
    {
      // Byte code:
      //   0: ldc 38
      //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   9: ifeq +10 -> 19
      //   12: ldc 38
      //   14: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   17: aconst_null
      //   18: areturn
      //   19: aload_0
      //   20: aload_1
      //   21: invokevirtual 50	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   24: astore_1
      //   25: aload_1
      //   26: astore_0
      //   27: ldc 52
      //   29: invokestatic 58	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
      //   32: astore 4
      //   34: aload_1
      //   35: astore_0
      //   36: sipush 2048
      //   39: newarray byte
      //   41: astore 5
      //   43: aload_1
      //   44: astore_0
      //   45: aload_1
      //   46: aload 5
      //   48: invokevirtual 22	java/io/InputStream:read	([B)I
      //   51: istore_2
      //   52: iload_2
      //   53: iflt +46 -> 99
      //   56: aload_1
      //   57: astore_0
      //   58: aload 4
      //   60: aload 5
      //   62: iconst_0
      //   63: iload_2
      //   64: invokevirtual 61	java/security/MessageDigest:update	([BII)V
      //   67: goto -24 -> 43
      //   70: astore 4
      //   72: aload_1
      //   73: astore_0
      //   74: ldc 63
      //   76: aload 4
      //   78: invokestatic 69	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   81: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   84: aload_1
      //   85: ifnull +7 -> 92
      //   88: aload_1
      //   89: invokevirtual 79	java/io/InputStream:close	()V
      //   92: ldc 38
      //   94: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: aconst_null
      //   98: areturn
      //   99: aload_1
      //   100: astore_0
      //   101: aload 4
      //   103: invokevirtual 83	java/security/MessageDigest:digest	()[B
      //   106: astore 4
      //   108: aload_1
      //   109: astore_0
      //   110: new 85	java/lang/StringBuilder
      //   113: dup
      //   114: bipush 32
      //   116: invokespecial 88	java/lang/StringBuilder:<init>	(I)V
      //   119: astore 5
      //   121: aload_1
      //   122: astore_0
      //   123: aload 4
      //   125: arraylength
      //   126: istore_3
      //   127: iconst_0
      //   128: istore_2
      //   129: iload_2
      //   130: iload_3
      //   131: if_icmpge +39 -> 170
      //   134: aload_1
      //   135: astore_0
      //   136: aload 5
      //   138: aload 4
      //   140: iload_2
      //   141: baload
      //   142: sipush 255
      //   145: iand
      //   146: sipush 256
      //   149: iadd
      //   150: bipush 16
      //   152: invokestatic 94	java/lang/Integer:toString	(II)Ljava/lang/String;
      //   155: iconst_1
      //   156: invokevirtual 100	java/lang/String:substring	(I)Ljava/lang/String;
      //   159: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   162: pop
      //   163: iload_2
      //   164: iconst_1
      //   165: iadd
      //   166: istore_2
      //   167: goto -38 -> 129
      //   170: aload_1
      //   171: astore_0
      //   172: aload 5
      //   174: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   177: astore 4
      //   179: aload_1
      //   180: ifnull +7 -> 187
      //   183: aload_1
      //   184: invokevirtual 79	java/io/InputStream:close	()V
      //   187: ldc 38
      //   189: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   192: aload 4
      //   194: areturn
      //   195: astore_0
      //   196: ldc 63
      //   198: aload_0
      //   199: ldc 109
      //   201: iconst_0
      //   202: anewarray 4	java/lang/Object
      //   205: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   208: goto -21 -> 187
      //   211: astore_0
      //   212: ldc 63
      //   214: aload_0
      //   215: ldc 109
      //   217: iconst_0
      //   218: anewarray 4	java/lang/Object
      //   221: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   224: goto -132 -> 92
      //   227: astore_1
      //   228: aconst_null
      //   229: astore_0
      //   230: aload_0
      //   231: ifnull +7 -> 238
      //   234: aload_0
      //   235: invokevirtual 79	java/io/InputStream:close	()V
      //   238: ldc 38
      //   240: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   243: aload_1
      //   244: athrow
      //   245: astore_0
      //   246: ldc 63
      //   248: aload_0
      //   249: ldc 109
      //   251: iconst_0
      //   252: anewarray 4	java/lang/Object
      //   255: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   258: goto -20 -> 238
      //   261: astore_1
      //   262: goto -32 -> 230
      //   265: astore 4
      //   267: aconst_null
      //   268: astore_1
      //   269: goto -197 -> 72
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	272	0	paramAssetManager	AssetManager
      //   0	272	1	paramString	String
      //   51	116	2	i	int
      //   126	6	3	j	int
      //   32	27	4	localMessageDigest	java.security.MessageDigest
      //   70	32	4	localException1	java.lang.Exception
      //   106	87	4	localObject1	Object
      //   265	1	4	localException2	java.lang.Exception
      //   41	132	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   27	34	70	java/lang/Exception
      //   36	43	70	java/lang/Exception
      //   45	52	70	java/lang/Exception
      //   58	67	70	java/lang/Exception
      //   101	108	70	java/lang/Exception
      //   110	121	70	java/lang/Exception
      //   123	127	70	java/lang/Exception
      //   136	163	70	java/lang/Exception
      //   172	179	70	java/lang/Exception
      //   183	187	195	java/io/IOException
      //   88	92	211	java/io/IOException
      //   19	25	227	finally
      //   234	238	245	java/io/IOException
      //   27	34	261	finally
      //   36	43	261	finally
      //   45	52	261	finally
      //   58	67	261	finally
      //   74	84	261	finally
      //   101	108	261	finally
      //   110	121	261	finally
      //   123	127	261	finally
      //   136	163	261	finally
      //   172	179	261	finally
      //   19	25	265	java/lang/Exception
    }
    
    /* Error */
    public static void a(AssetManager paramAssetManager, String paramString, java.io.File paramFile)
    {
      // Byte code:
      //   0: ldc 115
      //   2: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: invokestatic 44	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   9: ifeq +20 -> 29
      //   12: new 37	java/io/IOException
      //   15: dup
      //   16: ldc 117
      //   18: invokespecial 120	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   21: astore_0
      //   22: ldc 115
      //   24: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   27: aload_0
      //   28: athrow
      //   29: aload_2
      //   30: invokevirtual 126	java/io/File:exists	()Z
      //   33: ifeq +15 -> 48
      //   36: aload_2
      //   37: invokevirtual 129	java/io/File:isDirectory	()Z
      //   40: ifeq +49 -> 89
      //   43: aload_2
      //   44: invokestatic 135	com/tencent/mm/toolkit/frontia/b$a:J	(Ljava/io/File;)Z
      //   47: pop
      //   48: aload_2
      //   49: invokevirtual 139	java/io/File:getParentFile	()Ljava/io/File;
      //   52: astore_3
      //   53: aload_3
      //   54: invokevirtual 126	java/io/File:exists	()Z
      //   57: ifne +8 -> 65
      //   60: aload_3
      //   61: invokevirtual 142	java/io/File:mkdirs	()Z
      //   64: pop
      //   65: aload_2
      //   66: invokevirtual 145	java/io/File:createNewFile	()Z
      //   69: ifne +28 -> 97
      //   72: new 37	java/io/IOException
      //   75: dup
      //   76: ldc 147
      //   78: invokespecial 120	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   81: astore_0
      //   82: ldc 115
      //   84: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   87: aload_0
      //   88: athrow
      //   89: aload_2
      //   90: invokestatic 150	com/tencent/mm/toolkit/frontia/b$a:safeDeleteFile	(Ljava/io/File;)Z
      //   93: pop
      //   94: goto -46 -> 48
      //   97: aload_0
      //   98: aload_1
      //   99: invokevirtual 50	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
      //   102: astore_1
      //   103: new 152	java/io/FileOutputStream
      //   106: dup
      //   107: aload_2
      //   108: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   111: astore 5
      //   113: aload 5
      //   115: astore 4
      //   117: aload_1
      //   118: astore_3
      //   119: aload 5
      //   121: checkcast 152	java/io/FileOutputStream
      //   124: invokevirtual 159	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
      //   127: astore_2
      //   128: aload 5
      //   130: astore 4
      //   132: aload_1
      //   133: astore_3
      //   134: new 161	java/io/BufferedOutputStream
      //   137: dup
      //   138: aload 5
      //   140: invokespecial 164	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   143: astore_0
      //   144: aload_1
      //   145: aload_0
      //   146: sipush 16384
      //   149: newarray byte
      //   151: invokestatic 166	com/tencent/mm/plugin/expansions/e$d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;[B)J
      //   154: pop2
      //   155: aload_0
      //   156: invokevirtual 169	java/io/OutputStream:flush	()V
      //   159: aload_2
      //   160: invokevirtual 174	java/io/FileDescriptor:sync	()V
      //   163: aload_1
      //   164: ifnull +7 -> 171
      //   167: aload_1
      //   168: invokevirtual 79	java/io/InputStream:close	()V
      //   171: aload_0
      //   172: invokevirtual 175	java/io/OutputStream:close	()V
      //   175: ldc 115
      //   177: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   180: return
      //   181: astore_1
      //   182: ldc 63
      //   184: aload_1
      //   185: ldc 109
      //   187: iconst_0
      //   188: anewarray 4	java/lang/Object
      //   191: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   194: goto -23 -> 171
      //   197: astore_0
      //   198: ldc 63
      //   200: aload_0
      //   201: ldc 109
      //   203: iconst_0
      //   204: anewarray 4	java/lang/Object
      //   207: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   210: ldc 115
      //   212: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   215: return
      //   216: astore_2
      //   217: aconst_null
      //   218: astore_0
      //   219: aconst_null
      //   220: astore_1
      //   221: aload_0
      //   222: astore 4
      //   224: aload_1
      //   225: astore_3
      //   226: ldc 63
      //   228: aload_2
      //   229: invokestatic 69	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   232: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   235: aload_1
      //   236: ifnull +7 -> 243
      //   239: aload_1
      //   240: invokevirtual 79	java/io/InputStream:close	()V
      //   243: aload_0
      //   244: ifnull +108 -> 352
      //   247: aload_0
      //   248: invokevirtual 175	java/io/OutputStream:close	()V
      //   251: ldc 115
      //   253: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   256: return
      //   257: astore_1
      //   258: ldc 63
      //   260: aload_1
      //   261: ldc 109
      //   263: iconst_0
      //   264: anewarray 4	java/lang/Object
      //   267: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   270: goto -27 -> 243
      //   273: astore_0
      //   274: ldc 63
      //   276: aload_0
      //   277: ldc 109
      //   279: iconst_0
      //   280: anewarray 4	java/lang/Object
      //   283: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   286: ldc 115
      //   288: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   291: return
      //   292: astore_0
      //   293: aconst_null
      //   294: astore_2
      //   295: aconst_null
      //   296: astore_1
      //   297: aload_1
      //   298: ifnull +7 -> 305
      //   301: aload_1
      //   302: invokevirtual 79	java/io/InputStream:close	()V
      //   305: aload_2
      //   306: ifnull +7 -> 313
      //   309: aload_2
      //   310: invokevirtual 175	java/io/OutputStream:close	()V
      //   313: ldc 115
      //   315: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   318: aload_0
      //   319: athrow
      //   320: astore_1
      //   321: ldc 63
      //   323: aload_1
      //   324: ldc 109
      //   326: iconst_0
      //   327: anewarray 4	java/lang/Object
      //   330: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   333: goto -28 -> 305
      //   336: astore_1
      //   337: ldc 63
      //   339: aload_1
      //   340: ldc 109
      //   342: iconst_0
      //   343: anewarray 4	java/lang/Object
      //   346: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   349: goto -36 -> 313
      //   352: ldc 115
      //   354: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   357: return
      //   358: astore_0
      //   359: aconst_null
      //   360: astore_2
      //   361: goto -64 -> 297
      //   364: astore_0
      //   365: aload 4
      //   367: astore_2
      //   368: aload_3
      //   369: astore_1
      //   370: goto -73 -> 297
      //   373: astore_3
      //   374: aload_0
      //   375: astore_2
      //   376: aload_3
      //   377: astore_0
      //   378: goto -81 -> 297
      //   381: astore_2
      //   382: aconst_null
      //   383: astore_0
      //   384: goto -163 -> 221
      //   387: astore_2
      //   388: aload 5
      //   390: astore_0
      //   391: goto -170 -> 221
      //   394: astore_2
      //   395: goto -174 -> 221
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	398	0	paramAssetManager	AssetManager
      //   0	398	1	paramString	String
      //   0	398	2	paramFile	java.io.File
      //   52	317	3	localObject1	Object
      //   373	4	3	localObject2	Object
      //   115	251	4	localObject3	Object
      //   111	278	5	localFileOutputStream	java.io.FileOutputStream
      // Exception table:
      //   from	to	target	type
      //   167	171	181	java/io/IOException
      //   171	175	197	java/io/IOException
      //   97	103	216	java/io/IOException
      //   239	243	257	java/io/IOException
      //   247	251	273	java/io/IOException
      //   97	103	292	finally
      //   301	305	320	java/io/IOException
      //   309	313	336	java/io/IOException
      //   103	113	358	finally
      //   119	128	364	finally
      //   134	144	364	finally
      //   226	235	364	finally
      //   144	163	373	finally
      //   103	113	381	java/io/IOException
      //   119	128	387	java/io/IOException
      //   134	144	387	java/io/IOException
      //   144	163	394	java/io/IOException
    }
  }
  
  static final class e
    extends com.tencent.mm.toolkit.frontia.a.a<Object>
  {
    public static final String yFI;
    public boolean yFJ;
    
    static
    {
      AppMethodBeat.i(273653);
      StringBuilder localStringBuilder = new StringBuilder("expansions-");
      String str = Build.CPU_ABI;
      "Capable cpu abi = ".concat(String.valueOf(str));
      com.tencent.mm.toolkit.frontia.c.jhg();
      yFI = str + ".obb";
      AppMethodBeat.o(273653);
    }
    
    private e()
    {
      AppMethodBeat.i(273639);
      this.yFJ = true;
      jhh();
      AppMethodBeat.o(273639);
    }
    
    public static e dHG()
    {
      AppMethodBeat.i(273647);
      e locale = new e();
      locale.azQ(0);
      locale.bzz("use builtin impl");
      AppMethodBeat.o(273647);
      return locale;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.e
 * JD-Core Version:    0.7.0.1
 */