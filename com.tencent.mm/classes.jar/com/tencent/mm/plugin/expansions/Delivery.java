package com.tencent.mm.plugin.expansions;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.soloader.e;
import com.facebook.soloader.n;
import com.facebook.soloader.o;
import com.google.android.a.a.a.d;
import com.google.android.a.a.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.toolkit.frontia.a.c.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

final class Delivery
{
  private static final int ERR_CODE_TIMEOUT = 10001;
  private static final int ERR_CODE_USER_CONFIRM = 10002;
  private static final String MODULE_NAME = "delivery";
  private static final int REQ_CODE_USER_CONFIRM = 10002;
  private static final String TAG = "MicroMsg.exp.Delivery";
  static boolean postDumping;
  static boolean preDumping;
  private static final List<File> sAllNativeLibDirs;
  private static WeakReference<Context> sAttachedContext;
  private static c.a sBehavior;
  private static com.google.android.a.a.a.b sDeliveryManager;
  private static final List<String> sLoadedLibs;
  private byte _hellAccFlag_;
  
  static
  {
    AppMethodBeat.i(273959);
    sAllNativeLibDirs = new LinkedList();
    sLoadedLibs = new LinkedList();
    AppMethodBeat.o(273959);
  }
  
  private static void checkInit()
  {
    AppMethodBeat.i(273696);
    if (sDeliveryManager == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("#init is not yet done!");
      AppMethodBeat.o(273696);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(273696);
  }
  
  private static void doRequest(final a parama)
  {
    AppMethodBeat.i(273727);
    checkInit();
    Log.i("MicroMsg.exp.Delivery", "#doRequest, isInstalled = " + isInstalled());
    if (isInstalled())
    {
      if (parama != null) {
        parama.dHt();
      }
      AppMethodBeat.o(273727);
      return;
    }
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    d.XI();
    d.a.XJ();
    d.a.XK();
    new com.google.android.a.a.a.f() {};
    new com.google.android.a.a.b.a() {};
    parama = new RuntimeException("stub!");
    AppMethodBeat.o(273727);
    throw parama;
  }
  
  /* Error */
  static void dumpApkLibEntry(File paramFile)
  {
    // Byte code:
    //   0: ldc 166
    //   2: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 39
    //   7: new 107	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 168
    //   13: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 173	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 179	java/io/File:isFile	()Z
    //   33: ifne +16 -> 49
    //   36: ldc 39
    //   38: ldc 181
    //   40: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: ldc 166
    //   45: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: return
    //   49: new 183	java/util/zip/ZipFile
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 185	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 189	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   62: astore_1
    //   63: aload_1
    //   64: invokeinterface 194 1 0
    //   69: ifeq +73 -> 142
    //   72: aload_1
    //   73: invokeinterface 198 1 0
    //   78: checkcast 200	java/util/zip/ZipEntry
    //   81: invokevirtual 203	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_2
    //   85: aload_2
    //   86: ldc 205
    //   88: invokevirtual 211	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   91: ifeq -28 -> 63
    //   94: ldc 39
    //   96: ldc 213
    //   98: aload_2
    //   99: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokevirtual 221	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   105: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -45 -> 63
    //   111: astore_1
    //   112: aload_0
    //   113: invokevirtual 224	java/util/zip/ZipFile:close	()V
    //   116: ldc 166
    //   118: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_1
    //   122: athrow
    //   123: astore_0
    //   124: ldc 39
    //   126: aload_0
    //   127: ldc 226
    //   129: iconst_0
    //   130: anewarray 4	java/lang/Object
    //   133: invokestatic 230	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: ldc 166
    //   138: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: aload_0
    //   143: invokevirtual 224	java/util/zip/ZipFile:close	()V
    //   146: ldc 166
    //   148: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: astore_0
    //   153: aload_1
    //   154: aload_0
    //   155: invokevirtual 236	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   158: goto -42 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramFile	File
    //   62	11	1	localEnumeration	java.util.Enumeration
    //   111	43	1	localObject	Object
    //   84	15	2	str	String
    // Exception table:
    //   from	to	target	type
    //   58	63	111	finally
    //   63	108	111	finally
    //   49	58	123	finally
    //   116	123	123	finally
    //   142	151	123	finally
    //   153	158	123	finally
    //   112	116	152	finally
  }
  
  static void dumpAppClassLoader()
  {
    AppMethodBeat.i(273881);
    Log.i("MicroMsg.exp.Delivery", "dumping classloader");
    Iterator localIterator = getNativeLibraryDirectoriesCompat(Delivery.class.getClassLoader()).iterator();
    while (localIterator.hasNext()) {
      dumpFiles((File)localIterator.next());
    }
    AppMethodBeat.o(273881);
  }
  
  static void dumpFiles(File paramFile)
  {
    int i = 0;
    AppMethodBeat.i(273906);
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        while (i < j)
        {
          dumpFiles(paramFile[i]);
          i += 1;
        }
      }
      AppMethodBeat.o(273906);
      return;
    }
    if (paramFile.getAbsolutePath().contains(".apk!/lib"))
    {
      dumpApkLibEntry(new File(paramFile.getAbsolutePath().substring(0, paramFile.getAbsolutePath().indexOf(".apk!/lib")) + ".apk"));
      AppMethodBeat.o(273906);
      return;
    }
    Log.i("MicroMsg.exp.Delivery", " > " + paramFile.getAbsolutePath());
    AppMethodBeat.o(273906);
  }
  
  private static void dumping()
  {
    AppMethodBeat.i(273875);
    Log.i("MicroMsg.exp.Delivery", "dumping SoLoader");
    if ((!WeChatEnvironment.isCoolassistEnv()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.i("MicroMsg.exp.Delivery", "skip, no debug env");
      AppMethodBeat.o(273875);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        o[] arrayOfo = n.Qa();
        int j = arrayOfo.length;
        i = 0;
        if (i < j)
        {
          o localo = arrayOfo[i];
          if ((localo instanceof com.facebook.soloader.i)) {
            Log.i("MicroMsg.exp.Delivery", " - ApkSoSource: ".concat(String.valueOf(((com.facebook.soloader.i)localo).PU())));
          } else {
            Log.i("MicroMsg.exp.Delivery", " - ".concat(String.valueOf(localo)));
          }
        }
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.exp.Delivery", localThrowable, "dumping SoLoader fail", new Object[0]);
        dumpAppClassLoader();
        AppMethodBeat.o(273875);
        return;
      }
      i += 1;
    }
  }
  
  static String findLibraryPathByName(String paramString)
  {
    AppMethodBeat.i(273888);
    if (sAllNativeLibDirs.isEmpty()) {}
    synchronized (sAllNativeLibDirs)
    {
      Object localObject2;
      if (sAllNativeLibDirs.isEmpty())
      {
        localObject2 = getNativeLibraryDirectoriesCompat(Delivery.class.getClassLoader());
        sAllNativeLibDirs.addAll((Collection)localObject2);
      }
      if (!sAllNativeLibDirs.isEmpty())
      {
        ??? = sAllNativeLibDirs.iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = recursiveFindLibraryPathByName(paramString, (File)((Iterator)???).next());
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            AppMethodBeat.o(273888);
            return localObject2;
          }
        }
      }
    }
    AppMethodBeat.o(273888);
    return null;
  }
  
  static String getAAbInfo()
  {
    AppMethodBeat.i(273706);
    if (!isEnabled())
    {
      AppMethodBeat.o(273706);
      return "aab-disabled";
    }
    String str = org.apache.commons.c.i.b(sDeliveryManager.XG(), "|");
    AppMethodBeat.o(273706);
    return str;
  }
  
  static Future<?> getAssets(final e.a parama)
  {
    AppMethodBeat.i(273791);
    Log.i("MicroMsg.exp.Delivery", "#getAssets, isInstalled = " + isInstalled());
    b localb = new b();
    doRequest(new a()
    {
      public final void dHt()
      {
        AppMethodBeat.i(273635);
        Delivery.this.setResult(e.e.dHG());
        if (parama != null) {
          parama.a(Delivery.sBehavior.getAssets());
        }
        AppMethodBeat.o(273635);
      }
    });
    AppMethodBeat.o(273791);
    return localb;
  }
  
  static String getLastObbErrorInfo()
  {
    AppMethodBeat.i(273713);
    if (!isEnabled())
    {
      AppMethodBeat.o(273713);
      return "aab-disabled";
    }
    String str = MultiProcessMMKV.getDefault().getString("delivery_request_status", "initial");
    AppMethodBeat.o(273713);
    return str;
  }
  
  /* Error */
  static List<File> getNativeLibraryDirectoriesCompat(java.lang.ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: ldc_w 396
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 39
    //   8: ldc_w 398
    //   11: aload_0
    //   12: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 221	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   24: bipush 25
    //   26: if_icmpne +9 -> 35
    //   29: getstatic 406	android/os/Build$VERSION:PREVIEW_SDK_INT	I
    //   32: ifne +13 -> 45
    //   35: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   38: istore_1
    //   39: iload_1
    //   40: bipush 25
    //   42: if_icmple +117 -> 159
    //   45: new 408	java/util/ArrayList
    //   48: dup
    //   49: invokespecial 409	java/util/ArrayList:<init>	()V
    //   52: astore_2
    //   53: aload_0
    //   54: ldc_w 411
    //   57: invokestatic 417	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   60: aload_0
    //   61: invokevirtual 423	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull +38 -> 104
    //   69: aload_3
    //   70: ldc_w 425
    //   73: invokestatic 417	com/tencent/tinker/loader/shareutil/ShareReflectUtil:findField	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   76: aload_3
    //   77: invokevirtual 423	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   80: checkcast 252	java/util/List
    //   83: astore_3
    //   84: ldc 39
    //   86: ldc_w 427
    //   89: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_3
    //   93: ifnull +11 -> 104
    //   96: aload_2
    //   97: aload_3
    //   98: invokeinterface 338 2 0
    //   103: pop
    //   104: aload_2
    //   105: astore_0
    //   106: aload_0
    //   107: ifnonnull +152 -> 259
    //   110: invokestatic 432	java/util/Collections:emptyList	()Ljava/util/List;
    //   113: astore_0
    //   114: ldc_w 396
    //   117: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_0
    //   121: areturn
    //   122: astore_2
    //   123: ldc 39
    //   125: ldc_w 434
    //   128: iconst_2
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   137: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: aload_2
    //   144: invokevirtual 442	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: invokestatic 448	com/tencent/mm/plugin/expansions/Delivery$d:b	(Ljava/lang/ClassLoader;)Ljava/util/List;
    //   155: astore_0
    //   156: goto -50 -> 106
    //   159: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   162: istore_1
    //   163: iload_1
    //   164: bipush 23
    //   166: if_icmplt +50 -> 216
    //   169: aload_0
    //   170: invokestatic 448	com/tencent/mm/plugin/expansions/Delivery$d:b	(Ljava/lang/ClassLoader;)Ljava/util/List;
    //   173: astore_2
    //   174: aload_2
    //   175: astore_0
    //   176: goto -70 -> 106
    //   179: astore_2
    //   180: ldc 39
    //   182: ldc_w 450
    //   185: iconst_2
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   194: invokestatic 439	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: dup
    //   199: iconst_1
    //   200: aload_2
    //   201: invokevirtual 442	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   204: aastore
    //   205: invokestatic 446	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: aload_0
    //   209: invokestatic 451	com/tencent/mm/plugin/expansions/Delivery$c:b	(Ljava/lang/ClassLoader;)Ljava/util/List;
    //   212: astore_0
    //   213: goto -107 -> 106
    //   216: getstatic 403	android/os/Build$VERSION:SDK_INT	I
    //   219: bipush 14
    //   221: if_icmplt +11 -> 232
    //   224: aload_0
    //   225: invokestatic 451	com/tencent/mm/plugin/expansions/Delivery$c:b	(Ljava/lang/ClassLoader;)Ljava/util/List;
    //   228: astore_0
    //   229: goto -123 -> 106
    //   232: aload_0
    //   233: invokestatic 452	com/tencent/mm/plugin/expansions/Delivery$e:b	(Ljava/lang/ClassLoader;)Ljava/util/List;
    //   236: astore_0
    //   237: goto -131 -> 106
    //   240: astore_0
    //   241: ldc 39
    //   243: aload_0
    //   244: ldc_w 454
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 230	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: aconst_null
    //   255: astore_0
    //   256: goto -150 -> 106
    //   259: ldc_w 396
    //   262: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_0
    //   266: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramClassLoader	java.lang.ClassLoader
    //   38	129	1	i	int
    //   52	53	2	localArrayList	ArrayList
    //   122	22	2	localObject1	Object
    //   173	2	2	localList	List
    //   179	22	2	localObject2	Object
    //   64	34	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   45	65	122	finally
    //   69	92	122	finally
    //   96	104	122	finally
    //   169	174	179	finally
    //   6	35	240	finally
    //   35	39	240	finally
    //   123	156	240	finally
    //   159	163	240	finally
    //   180	213	240	finally
    //   216	229	240	finally
    //   232	237	240	finally
  }
  
  public static Future<?> getSoLibDir(e.b paramb)
  {
    AppMethodBeat.i(273848);
    paramb = new RuntimeException("Stub!");
    AppMethodBeat.o(273848);
    throw paramb;
  }
  
  static void init(Context paramContext)
  {
    AppMethodBeat.i(273694);
    if (isEnabled())
    {
      Log.i("MicroMsg.exp.Delivery", "init SplitCompat for Expansions Delivery");
      Log.i("MicroMsg.exp.Delivery", "init SoLoader");
      n.aJ(paramContext);
      injectClassLoaderContext(paramContext);
      f.ayW();
      sDeliveryManager = com.google.android.a.a.a.c.XH();
      sBehavior = new Delivery.1(paramContext);
    }
    AppMethodBeat.o(273694);
  }
  
  private static void injectClassLoaderContext(Context paramContext)
  {
    AppMethodBeat.i(273868);
    Log.i("MicroMsg.exp.Delivery", "#injectClassLoaderContext");
    Object localObject2 = getNativeLibraryDirectoriesCompat(Delivery.class.getClassLoader());
    if (!((List)localObject2).isEmpty()) {}
    for (;;)
    {
      ArrayList localArrayList;
      o[] arrayOfo;
      int j;
      int i;
      Object localObject3;
      Object localObject1;
      try
      {
        Log.i("MicroMsg.exp.Delivery", "collect SoLoader list");
        localArrayList = new ArrayList();
        arrayOfo = n.Qa();
        j = arrayOfo.length;
        i = 0;
        if (i < j)
        {
          localObject3 = arrayOfo[i];
          if ((localObject3 instanceof com.facebook.soloader.i))
          {
            localArrayList.add(((com.facebook.soloader.i)localObject3).PU());
          }
          else if (((localObject3 instanceof e)) || ((localObject3 instanceof com.facebook.soloader.c)))
          {
            localObject1 = null;
            if ((localObject3 instanceof e)) {
              localObject1 = (e)localObject3;
            }
            if ((localObject3 instanceof com.facebook.soloader.c))
            {
              localObject1 = ((com.facebook.soloader.c)localObject3).cCt;
              if (localObject1 == null) {
                break label539;
              }
              localArrayList.add(((e)localObject1).PS());
            }
          }
        }
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.exp.Delivery", paramContext, "injectClassLoaderContext fail", new Object[0]);
      }
      for (;;)
      {
        dumping();
        AppMethodBeat.o(273868);
        return;
        Log.i("MicroMsg.exp.Delivery", "inject SoLoader list");
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (File)((Iterator)localObject2).next();
          if (!localArrayList.contains(localObject3)) {
            if (((File)localObject3).getAbsolutePath().contains(".apk!/lib"))
            {
              Log.i("MicroMsg.exp.Delivery", "inject ApkSoSource: ".concat(String.valueOf(localObject3)));
              localObject3 = ((File)localObject3).getAbsolutePath().substring(0, ((File)localObject3).getAbsolutePath().indexOf(".apk!/lib")) + ".apk";
              File localFile = new File((String)localObject3);
              if (!localArrayList.contains(localFile))
              {
                i = ((String)localObject3).lastIndexOf("/");
                j = ((String)localObject3).lastIndexOf(".apk");
                if ((i >= 0) && (i + 1 < j)) {
                  ((List)localObject1).add(new com.facebook.soloader.b(paramContext, localFile, ((String)localObject3).substring(i + 1, j)));
                } else {
                  Log.w("MicroMsg.exp.Delivery", "invalid apkPath: ".concat(String.valueOf(localObject3)));
                }
              }
            }
            else if (((File)localObject3).isDirectory())
            {
              Log.i("MicroMsg.exp.Delivery", "inject DirectorySoSource: ".concat(String.valueOf(localObject3)));
              ((List)localObject1).add(new e((File)localObject3, 0));
            }
            else
            {
              Log.w("MicroMsg.exp.Delivery", "inject fail, unknown so lib type: ".concat(String.valueOf(localObject3)));
            }
          }
        }
        if (!((List)localObject1).isEmpty())
        {
          ((List)localObject1).addAll(Arrays.asList(arrayOfo));
          n.a((o[])((List)localObject1).toArray(new o[0]));
        }
        else
        {
          Log.i("MicroMsg.exp.Delivery", "soSourceList is empty, skip inject");
        }
      }
      continue;
      label539:
      i += 1;
    }
  }
  
  static Future<?> install(final e.b paramb)
  {
    AppMethodBeat.i(273779);
    Log.i("MicroMsg.exp.Delivery", "#install delivery, isInstalled = " + isInstalled());
    b localb = new b();
    doRequest(new a()
    {
      public final void dHt()
      {
        AppMethodBeat.i(273632);
        Delivery.this.setResult(e.e.dHG());
        if (paramb != null) {
          paramb.a(Delivery.sBehavior);
        }
        AppMethodBeat.o(273632);
      }
    });
    AppMethodBeat.o(273779);
    return localb;
  }
  
  static boolean isEnabled()
  {
    return false;
  }
  
  static boolean isInstalled()
  {
    AppMethodBeat.i(273759);
    if (!isEnabled())
    {
      AppMethodBeat.o(273759);
      return true;
    }
    boolean bool = sDeliveryManager.XG().contains("delivery");
    Log.i("MicroMsg.exp.Delivery", "#isInstalled = ".concat(String.valueOf(bool)));
    if (bool) {
      if (!postDumping)
      {
        Log.i("MicroMsg.exp.Delivery", "post dumping classloader all nativeLibs");
        dumping();
        postDumping = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273759);
      return bool;
      if (!preDumping)
      {
        Log.i("MicroMsg.exp.Delivery", "pre dumping classloader all nativeLibs");
        dumping();
        preDumping = true;
      }
    }
  }
  
  static boolean isInstalled(String paramString)
  {
    AppMethodBeat.i(273770);
    boolean bool = isInstalled();
    AppMethodBeat.o(273770);
    return bool;
  }
  
  static Future<?> loadLibrary(String paramString, e.b paramb)
  {
    AppMethodBeat.i(273835);
    paramString = new RuntimeException("Stub!");
    AppMethodBeat.o(273835);
    throw paramString;
  }
  
  private static void loadLibraryFlattWithinDelivery(String paramString)
  {
    AppMethodBeat.i(273827);
    Log.i("MicroMsg.exp.Delivery", "loadLibrary flatt, libName  = ".concat(String.valueOf(paramString)));
    synchronized (sLoadedLibs)
    {
      if (sLoadedLibs.contains(paramString))
      {
        AppMethodBeat.o(273827);
        return;
      }
      ??? = findLibraryPathByName(paramString);
      if (TextUtils.isEmpty((CharSequence)???)) {
        break label140;
      }
      Log.i("MicroMsg.exp.Delivery", "loadLibraryFlatt with System#load, libName  = ".concat(String.valueOf(paramString)));
      System.load((String)???);
    }
    synchronized (sLoadedLibs)
    {
      if (!sLoadedLibs.contains(paramString)) {
        sLoadedLibs.add(paramString);
      }
      AppMethodBeat.o(273827);
      return;
      paramString = finally;
      AppMethodBeat.o(273827);
      throw paramString;
    }
    label140:
    Log.i("MicroMsg.exp.Delivery", "loadLibraryFlatt with System#loadLibrary, libName  = ".concat(String.valueOf(paramString)));
    ??? = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)???).aYi(), "com/tencent/mm/plugin/expansions/Delivery", "loadLibraryFlattWithinDelivery", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)((com.tencent.mm.hellhoundlib.b.a)???).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/expansions/Delivery", "loadLibraryFlattWithinDelivery", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    synchronized (sLoadedLibs)
    {
      if (!sLoadedLibs.contains(paramString)) {
        sLoadedLibs.add(paramString);
      }
      AppMethodBeat.o(273827);
      return;
    }
  }
  
  /* Error */
  private static void loadLibraryImpl(String paramString)
  {
    // Byte code:
    //   0: ldc_w 634
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 39
    //   8: ldc_w 636
    //   11: aload_0
    //   12: invokestatic 217	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokevirtual 221	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 642	com/tencent/mm/plugin/expansions/a:yFe	Ljava/util/Map;
    //   24: aload_0
    //   25: invokeinterface 645 2 0
    //   30: checkcast 252	java/util/List
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +78 -> 113
    //   38: aload_1
    //   39: invokeinterface 256 1 0
    //   44: astore_1
    //   45: aload_1
    //   46: invokeinterface 261 1 0
    //   51: ifeq +62 -> 113
    //   54: aload_1
    //   55: invokeinterface 264 1 0
    //   60: checkcast 207	java/lang/String
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual 648	java/lang/String:trim	()Ljava/lang/String;
    //   68: invokestatic 346	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   71: ifne -26 -> 45
    //   74: aload_2
    //   75: invokevirtual 648	java/lang/String:trim	()Ljava/lang/String;
    //   78: invokestatic 650	com/tencent/mm/plugin/expansions/Delivery:loadLibraryFlattWithinDelivery	(Ljava/lang/String;)V
    //   81: goto -36 -> 45
    //   84: astore_2
    //   85: ldc 39
    //   87: new 107	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 652
    //   94: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: invokevirtual 442	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 654	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -65 -> 45
    //   113: aload_0
    //   114: invokestatic 650	com/tencent/mm/plugin/expansions/Delivery:loadLibraryFlattWithinDelivery	(Ljava/lang/String;)V
    //   117: ldc_w 634
    //   120: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   33	22	1	localObject1	Object
    //   63	12	2	str	String
    //   84	14	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   74	81	84	finally
  }
  
  static void onAttachBaseContext(Context paramContext)
  {
    AppMethodBeat.i(273701);
    checkInit();
    sAttachedContext = new WeakReference(paramContext);
    AppMethodBeat.o(273701);
  }
  
  private static String recursiveFindLibraryPathByName(String paramString, File paramFile)
  {
    AppMethodBeat.i(273897);
    if ((paramFile.isFile()) && (paramFile.getAbsolutePath().endsWith("lib" + paramString + ".so")))
    {
      paramString = paramFile.getAbsolutePath();
      AppMethodBeat.o(273897);
      return paramString;
    }
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          String str = recursiveFindLibraryPathByName(paramString, paramFile[i]);
          if (!TextUtils.isEmpty(str))
          {
            AppMethodBeat.o(273897);
            return str;
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(273897);
    return null;
  }
  
  static Future<?> request()
  {
    AppMethodBeat.i(273746);
    Log.i("MicroMsg.exp.Delivery", "#request delivery, isInstalled = " + isInstalled());
    b localb = new b();
    doRequest(new a()
    {
      public final void dHt()
      {
        AppMethodBeat.i(273643);
        Delivery.this.setResult(e.e.dHG());
        AppMethodBeat.o(273643);
      }
    });
    AppMethodBeat.o(273746);
    return localb;
  }
  
  /* Error */
  static boolean requestSync(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 680
    //   3: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 39
    //   8: new 107	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 682
    //   15: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_0
    //   19: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   22: ldc_w 684
    //   25: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokestatic 114	com/tencent/mm/plugin/expansions/Delivery:isInstalled	()Z
    //   31: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: invokestatic 114	com/tencent/mm/plugin/expansions/Delivery:isInstalled	()Z
    //   43: ifeq +11 -> 54
    //   46: ldc_w 680
    //   49: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: iconst_1
    //   53: ireturn
    //   54: invokestatic 105	com/tencent/mm/plugin/expansions/Delivery:checkInit	()V
    //   57: new 686	com/tencent/mm/plugin/expansions/g$a
    //   60: dup
    //   61: ldc_w 688
    //   64: invokespecial 689	com/tencent/mm/plugin/expansions/g$a:<init>	(Ljava/lang/String;)V
    //   67: astore 7
    //   69: sipush 2000
    //   72: istore_2
    //   73: iconst_0
    //   74: istore_3
    //   75: ldc 39
    //   77: ldc_w 691
    //   80: iload_3
    //   81: invokestatic 694	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 221	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   87: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: invokestatic 696	com/tencent/mm/plugin/expansions/Delivery:request	()Ljava/util/concurrent/Future;
    //   93: invokeinterface 700 1 0
    //   98: pop
    //   99: invokestatic 114	com/tencent/mm/plugin/expansions/Delivery:isInstalled	()Z
    //   102: ifne +149 -> 251
    //   105: iload_0
    //   106: ifeq +145 -> 251
    //   109: iload_3
    //   110: iconst_1
    //   111: iadd
    //   112: istore_3
    //   113: iload_2
    //   114: i2l
    //   115: lstore 4
    //   117: lload 4
    //   119: invokestatic 706	java/lang/Thread:sleep	(J)V
    //   122: iload_2
    //   123: i2f
    //   124: ldc_w 707
    //   127: fmul
    //   128: f2i
    //   129: istore_2
    //   130: iconst_1
    //   131: istore_1
    //   132: iload_1
    //   133: ifne -58 -> 75
    //   136: aload 7
    //   138: invokestatic 711	java/lang/System:currentTimeMillis	()J
    //   141: putfield 715	com/tencent/mm/plugin/expansions/g$a:axI	J
    //   144: ldc_w 717
    //   147: new 107	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 282	java/lang/StringBuilder:<init>	()V
    //   154: aload 7
    //   156: getfield 720	com/tencent/mm/plugin/expansions/g$a:hQR	Ljava/lang/String;
    //   159: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 722
    //   165: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 7
    //   170: getfield 715	com/tencent/mm/plugin/expansions/g$a:axI	J
    //   173: aload 7
    //   175: getfield 725	com/tencent/mm/plugin/expansions/g$a:yFO	J
    //   178: lsub
    //   179: invokevirtual 728	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: invokestatic 114	com/tencent/mm/plugin/expansions/Delivery:isInstalled	()Z
    //   191: istore_0
    //   192: ldc_w 680
    //   195: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: iload_0
    //   199: ireturn
    //   200: astore 6
    //   202: ldc 39
    //   204: ldc_w 730
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload 6
    //   215: invokevirtual 733	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: goto -123 -> 99
    //   225: astore 6
    //   227: iload_2
    //   228: i2f
    //   229: ldc_w 707
    //   232: fmul
    //   233: f2i
    //   234: istore_2
    //   235: iconst_1
    //   236: istore_1
    //   237: goto -105 -> 132
    //   240: astore 6
    //   242: ldc_w 680
    //   245: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload 6
    //   250: athrow
    //   251: iconst_0
    //   252: istore_1
    //   253: goto -121 -> 132
    //   256: astore 6
    //   258: goto -56 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramBoolean	boolean
    //   131	122	1	i	int
    //   72	163	2	j	int
    //   74	39	3	k	int
    //   115	3	4	l	long
    //   200	14	6	localInterruptedException1	java.lang.InterruptedException
    //   225	1	6	localInterruptedException2	java.lang.InterruptedException
    //   240	9	6	localObject	Object
    //   256	1	6	localExecutionException	java.util.concurrent.ExecutionException
    //   67	107	7	locala	g.a
    // Exception table:
    //   from	to	target	type
    //   75	99	200	java/lang/InterruptedException
    //   117	122	225	java/lang/InterruptedException
    //   117	122	240	finally
    //   75	99	256	java/util/concurrent/ExecutionException
  }
  
  static void saveDeliveryStatus(String paramString)
  {
    AppMethodBeat.i(273719);
    MultiProcessMMKV.getDefault().putString("delivery_request_status", paramString).commit();
    AppMethodBeat.o(273719);
  }
  
  static AssetManager tryGetAssets()
  {
    AppMethodBeat.i(273786);
    if (isInstalled())
    {
      AssetManager localAssetManager = sBehavior.getAssets();
      AppMethodBeat.o(273786);
      return localAssetManager;
    }
    AppMethodBeat.o(273786);
    return null;
  }
  
  static String tryGetSoLibDir()
  {
    AppMethodBeat.i(273842);
    if (isInstalled())
    {
      String str = sBehavior.dHs().getAbsolutePath() + File.separator;
      AppMethodBeat.o(273842);
      return str;
    }
    AppMethodBeat.o(273842);
    return null;
  }
  
  public static boolean tryLoadLibrary(String paramString)
  {
    AppMethodBeat.i(273798);
    boolean bool = tryLoadLibrary(paramString, true);
    AppMethodBeat.o(273798);
    return bool;
  }
  
  static boolean tryLoadLibrary(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(273806);
    Log.i("MicroMsg.exp.Delivery", "#tryLoadLibrary, isInstalled = " + isInstalled());
    if (isInstalled()) {
      try
      {
        loadLibraryImpl(paramString);
        AppMethodBeat.o(273806);
        return true;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.exp.Delivery", localThrowable, "tryLoadLibrary fail", new Object[0]);
        if (paramBoolean) {
          try
          {
            Log.i("MicroMsg.exp.Delivery", "try SoLoader at last, libName = ".concat(String.valueOf(paramString)));
            n.loadLibrary(paramString);
            AppMethodBeat.o(273806);
            return true;
          }
          finally
          {
            Log.printErrStackTrace("MicroMsg.exp.Delivery", paramString, "SoLoader.loadLibrary fail", new Object[0]);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273806);
      return false;
      Log.w("MicroMsg.exp.Delivery", "Delivery is not installed, libName = ".concat(String.valueOf(paramString)));
    }
  }
  
  static void tryRetrieveDelivery(int paramInt)
  {
    AppMethodBeat.i(273925);
    try
    {
      Object localObject = "content://com.google.android.finsky.FileProvider/dynamicsplits/" + paramInt + "/delivery";
      Log.i("MicroMsg.exp.Delivery", "#tryRetrieveDelivery, uri = ".concat(String.valueOf(localObject)));
      localObject = Uri.parse((String)localObject);
      localObject = new ZipInputStream(ApplicationGlobal.context().getContentResolver().openInputStream((Uri)localObject));
      for (;;)
      {
        ZipEntry localZipEntry = ((ZipInputStream)localObject).getNextEntry();
        if (localZipEntry == null) {
          break;
        }
        Log.i("MicroMsg.exp.Delivery", " > zipEntry: " + localZipEntry.getName());
      }
      localThrowable.close();
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.exp.Delivery", localThrowable, "tryRetrieveDelivery fail", new Object[0]);
      AppMethodBeat.o(273925);
      return;
    }
    AppMethodBeat.o(273925);
  }
  
  static void updateLang(String paramString)
  {
    AppMethodBeat.i(273852);
    checkInit();
    if (!TextUtils.isEmpty(paramString))
    {
      d.XI();
      Locale.forLanguageTag(paramString);
      paramString = new RuntimeException("stub!");
      AppMethodBeat.o(273852);
      throw paramString;
    }
    AppMethodBeat.o(273852);
  }
  
  static abstract interface a
  {
    public abstract void dHt();
  }
  
  static final class b<T>
    implements Future<T>
  {
    private final CountDownLatch fco;
    private T value;
    
    b()
    {
      AppMethodBeat.i(273646);
      this.fco = new CountDownLatch(1);
      AppMethodBeat.o(273646);
    }
    
    public final boolean cancel(boolean paramBoolean)
    {
      return false;
    }
    
    public final T get()
    {
      AppMethodBeat.i(273661);
      this.fco.await();
      Object localObject = this.value;
      AppMethodBeat.o(273661);
      return localObject;
    }
    
    public final T get(long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(273665);
      if (this.fco.await(paramLong, paramTimeUnit))
      {
        paramTimeUnit = this.value;
        AppMethodBeat.o(273665);
        return paramTimeUnit;
      }
      paramTimeUnit = new TimeoutException();
      AppMethodBeat.o(273665);
      throw paramTimeUnit;
    }
    
    public final boolean isCancelled()
    {
      return false;
    }
    
    public final boolean isDone()
    {
      AppMethodBeat.i(273658);
      if (this.fco.getCount() == 0L)
      {
        AppMethodBeat.o(273658);
        return true;
      }
      AppMethodBeat.o(273658);
      return false;
    }
    
    final void setResult(T paramT)
    {
      AppMethodBeat.i(273667);
      this.value = paramT;
      this.fco.countDown();
      AppMethodBeat.o(273667);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expansions.Delivery
 * JD-Core Version:    0.7.0.1
 */