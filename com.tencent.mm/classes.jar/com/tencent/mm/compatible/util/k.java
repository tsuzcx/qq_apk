package com.tencent.mm.compatible.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.loader.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class k
{
  private static HashMap<String, String> dAa = null;
  private static String dzY;
  private static boolean dzZ;
  private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();
  
  static
  {
    dzY = null;
    dzZ = false;
  }
  
  private static boolean a(String paramString, ClassLoader paramClassLoader)
  {
    if (!a.EQ()) {
      return false;
    }
    Object localObject2;
    if (!dzZ)
    {
      localObject2 = com.tencent.mm.app.b.applicationLike;
      if (localObject2 == null) {
        throw new RuntimeException("tinker application is null when try to load from patch libs");
      }
      dzZ = true;
      if ((localObject2 == null) || (((ApplicationLike)localObject2).getApplication() == null)) {
        throw new TinkerRuntimeException("tinkerApplication is null");
      }
      ??? = ((ApplicationLike)localObject2).getTinkerResultIntent();
      if ((??? != null) && (ShareIntentUtil.aA((Intent)???) == 0))
      {
        ??? = ShareIntentUtil.aF((Intent)???);
        dAa = (HashMap)???;
        ??? = com.tencent.tinker.lib.e.b.e((ApplicationLike)localObject2);
        if (!ShareTinkerInternals.bl((String)???)) {
          break label298;
        }
        dzY = null;
      }
    }
    else
    {
      label98:
      if (!paramString.startsWith("lib")) {
        break label381;
      }
      label107:
      if (!paramString.endsWith(".so")) {
        break label401;
      }
    }
    String str2;
    for (;;)
    {
      ??? = "lib/armeabi/" + paramString;
      localObject2 = com.tencent.mm.app.b.applicationLike;
      if ((!com.tencent.tinker.lib.e.b.c((ApplicationLike)localObject2)) || (!com.tencent.tinker.lib.e.b.d((ApplicationLike)localObject2)) || (dAa == null)) {
        break label544;
      }
      Iterator localIterator = dAa.keySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label544;
        }
        String str1 = (String)localIterator.next();
        if (str1.equals(???))
        {
          str2 = dzY + "/" + str1;
          File localFile = new File(str2);
          if (localFile.exists())
          {
            if ((!((ApplicationLike)localObject2).getTinkerLoadVerifyFlag()) || (SharePatchFileUtil.f(localFile, (String)dAa.get(str1)))) {
              break;
            }
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.LoadLibrary", "loadLibraryFromTinker md5mismatch fail: %s", new Object[] { str2 });
          }
        }
      }
      ??? = null;
      break;
      label298:
      localObject2 = SharePatchFileUtil.hX(((ApplicationLike)localObject2).getApplication());
      ??? = SharePatchFileUtil.agk((String)???);
      if ((localObject2 == null) || (??? == null)) {
        break label98;
      }
      ??? = new File(((File)localObject2).getAbsolutePath() + "/" + (String)???);
      dzY = ((File)???).getAbsolutePath() + "/lib";
      break label98;
      label381:
      paramString = "lib" + paramString;
      break label107;
      label401:
      paramString = paramString + ".so";
    }
    try
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.LoadLibrary", "succ load from patch path: %s", new Object[] { str2 });
      reflectSystemLoad(str2, paramClassLoader);
      synchronized (mLoadedLibs)
      {
        mLoadedLibs.put(paramString, new WeakReference(paramClassLoader));
        return true;
      }
      return false;
    }
    catch (InvocationTargetException paramClassLoader)
    {
      throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: " + paramString).initCause(paramClassLoader.getCause()));
    }
    catch (Exception paramClassLoader)
    {
      throw ((UnsatisfiedLinkError)new UnsatisfiedLinkError("Failed loading library: " + paramString).initCause(paramClassLoader));
    }
  }
  
  /* Error */
  public static void b(String paramString, ClassLoader paramClassLoader)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 320	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +867 -> 875
    //   11: iconst_1
    //   12: istore_2
    //   13: ldc_w 322
    //   16: iload_2
    //   17: invokestatic 328	junit/framework/Assert:assertFalse	(Ljava/lang/String;Z)V
    //   20: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   23: astore 4
    //   25: aload 4
    //   27: monitorenter
    //   28: ldc 173
    //   30: new 108	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 330
    //   37: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 334	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   53: aload_0
    //   54: invokevirtual 165	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   57: checkcast 204	java/lang/ref/WeakReference
    //   60: astore_3
    //   61: aload_3
    //   62: ifnull +807 -> 869
    //   65: aload_3
    //   66: invokevirtual 336	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   69: checkcast 338	java/lang/ClassLoader
    //   72: astore_3
    //   73: aload_3
    //   74: ifnull +57 -> 131
    //   77: aload_3
    //   78: aload_1
    //   79: if_acmpne +15 -> 94
    //   82: ldc 173
    //   84: ldc_w 340
    //   87: invokestatic 334	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload 4
    //   92: monitorexit
    //   93: return
    //   94: new 213	java/lang/UnsatisfiedLinkError
    //   97: dup
    //   98: new 108	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 342
    //   105: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc_w 344
    //   115: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   124: athrow
    //   125: astore_0
    //   126: aload 4
    //   128: monitorexit
    //   129: aload_0
    //   130: athrow
    //   131: aload 4
    //   133: monitorexit
    //   134: ldc 173
    //   136: new 108	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 346
    //   143: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 334	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: aload_0
    //   157: aload_1
    //   158: invokestatic 348	com/tencent/mm/compatible/util/k:a	(Ljava/lang/String;Ljava/lang/ClassLoader;)Z
    //   161: ifne +713 -> 874
    //   164: invokestatic 235	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   167: astore 5
    //   169: aload 5
    //   171: ifnull +15 -> 186
    //   174: invokestatic 353	com/tencent/mm/sdk/platformtools/bl:csf	()Z
    //   177: ifne +9 -> 186
    //   180: getstatic 358	com/tencent/mm/sdk/platformtools/d:DEBUG	Z
    //   183: ifeq +105 -> 288
    //   186: aload_0
    //   187: aload_1
    //   188: invokestatic 361	com/tencent/mm/compatible/util/k:reflectSystemLoadlibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   191: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   194: astore_3
    //   195: aload_3
    //   196: monitorenter
    //   197: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   200: aload_0
    //   201: new 204	java/lang/ref/WeakReference
    //   204: dup
    //   205: aload_1
    //   206: invokespecial 207	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   209: invokevirtual 211	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload_3
    //   214: monitorexit
    //   215: return
    //   216: astore_1
    //   217: aload_3
    //   218: monitorexit
    //   219: aload_1
    //   220: athrow
    //   221: astore_1
    //   222: new 213	java/lang/UnsatisfiedLinkError
    //   225: dup
    //   226: new 108	java/lang/StringBuilder
    //   229: dup
    //   230: ldc 215
    //   232: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_0
    //   236: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   245: aload_1
    //   246: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   249: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   252: checkcast 213	java/lang/UnsatisfiedLinkError
    //   255: athrow
    //   256: astore_1
    //   257: new 213	java/lang/UnsatisfiedLinkError
    //   260: dup
    //   261: new 108	java/lang/StringBuilder
    //   264: dup
    //   265: ldc 215
    //   267: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   270: aload_0
    //   271: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   280: aload_1
    //   281: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   284: checkcast 213	java/lang/UnsatisfiedLinkError
    //   287: athrow
    //   288: new 154	java/io/File
    //   291: dup
    //   292: aload 5
    //   294: ldc 237
    //   296: iconst_0
    //   297: invokevirtual 243	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   300: new 108	java/lang/StringBuilder
    //   303: dup
    //   304: ldc 96
    //   306: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   309: aload_0
    //   310: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: ldc 103
    //   315: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokespecial 302	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   324: astore 6
    //   326: aload 6
    //   328: invokevirtual 364	java/io/File:isFile	()Z
    //   331: ifeq +533 -> 864
    //   334: aload 6
    //   336: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   339: aload_1
    //   340: invokestatic 202	com/tencent/mm/compatible/util/k:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   343: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   346: astore_3
    //   347: aload_3
    //   348: monitorenter
    //   349: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   352: aload_0
    //   353: new 204	java/lang/ref/WeakReference
    //   356: dup
    //   357: aload_1
    //   358: invokespecial 207	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   361: invokevirtual 211	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   364: pop
    //   365: aload_3
    //   366: monitorexit
    //   367: return
    //   368: astore 4
    //   370: aload_3
    //   371: monitorexit
    //   372: aload 4
    //   374: athrow
    //   375: astore_3
    //   376: aload 6
    //   378: invokevirtual 367	java/io/File:delete	()Z
    //   381: pop
    //   382: aload_0
    //   383: aload_1
    //   384: invokestatic 361	com/tencent/mm/compatible/util/k:reflectSystemLoadlibrary	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   387: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   390: astore 4
    //   392: aload 4
    //   394: monitorenter
    //   395: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   398: aload_0
    //   399: new 204	java/lang/ref/WeakReference
    //   402: dup
    //   403: aload_1
    //   404: invokespecial 207	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   407: invokevirtual 211	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   410: pop
    //   411: aload 4
    //   413: monitorexit
    //   414: return
    //   415: astore 7
    //   417: aload 4
    //   419: monitorexit
    //   420: aload 7
    //   422: athrow
    //   423: astore 4
    //   425: aload_3
    //   426: ifnonnull +435 -> 861
    //   429: aload 4
    //   431: astore_3
    //   432: new 245	java/util/zip/ZipFile
    //   435: dup
    //   436: aload 5
    //   438: invokevirtual 249	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   441: getfield 254	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   444: invokespecial 255	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   447: astore 5
    //   449: aload 5
    //   451: astore 4
    //   453: aload 5
    //   455: aload_0
    //   456: invokestatic 229	com/tencent/mm/compatible/util/k:generateAbiList	()Ljava/util/List;
    //   459: aload 6
    //   461: invokestatic 306	com/tencent/mm/compatible/util/k:extractLibrary	(Ljava/util/zip/ZipFile;Ljava/lang/String;Ljava/util/List;Ljava/io/File;)Z
    //   464: ifne +259 -> 723
    //   467: aload 5
    //   469: astore 4
    //   471: new 52	java/lang/RuntimeException
    //   474: dup
    //   475: new 108	java/lang/StringBuilder
    //   478: dup
    //   479: ldc_w 369
    //   482: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: aload_0
    //   486: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokespecial 57	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   495: athrow
    //   496: astore_0
    //   497: aload 5
    //   499: astore 4
    //   501: new 213	java/lang/UnsatisfiedLinkError
    //   504: dup
    //   505: ldc_w 371
    //   508: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   511: aload_0
    //   512: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   515: checkcast 213	java/lang/UnsatisfiedLinkError
    //   518: athrow
    //   519: astore_0
    //   520: aload 4
    //   522: ifnull +8 -> 530
    //   525: aload 4
    //   527: invokevirtual 312	java/util/zip/ZipFile:close	()V
    //   530: aload_0
    //   531: athrow
    //   532: astore_3
    //   533: aload_3
    //   534: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   537: instanceof 213
    //   540: ifeq +14 -> 554
    //   543: aload_3
    //   544: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   547: checkcast 213	java/lang/UnsatisfiedLinkError
    //   550: astore_3
    //   551: goto -175 -> 376
    //   554: new 213	java/lang/UnsatisfiedLinkError
    //   557: dup
    //   558: new 108	java/lang/StringBuilder
    //   561: dup
    //   562: ldc_w 373
    //   565: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   568: aload_0
    //   569: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   578: aload_3
    //   579: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   582: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   585: checkcast 213	java/lang/UnsatisfiedLinkError
    //   588: athrow
    //   589: astore_1
    //   590: new 213	java/lang/UnsatisfiedLinkError
    //   593: dup
    //   594: new 108	java/lang/StringBuilder
    //   597: dup
    //   598: ldc_w 373
    //   601: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   604: aload_0
    //   605: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   614: aload_1
    //   615: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   618: checkcast 213	java/lang/UnsatisfiedLinkError
    //   621: athrow
    //   622: astore 4
    //   624: aload 4
    //   626: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   629: instanceof 213
    //   632: ifeq +19 -> 651
    //   635: aload_3
    //   636: ifnonnull +51 -> 687
    //   639: aload 4
    //   641: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   644: checkcast 213	java/lang/UnsatisfiedLinkError
    //   647: astore_3
    //   648: goto -216 -> 432
    //   651: new 213	java/lang/UnsatisfiedLinkError
    //   654: dup
    //   655: new 108	java/lang/StringBuilder
    //   658: dup
    //   659: ldc_w 373
    //   662: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   665: aload_0
    //   666: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   675: aload 4
    //   677: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   680: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   683: checkcast 213	java/lang/UnsatisfiedLinkError
    //   686: athrow
    //   687: goto -255 -> 432
    //   690: astore_1
    //   691: new 213	java/lang/UnsatisfiedLinkError
    //   694: dup
    //   695: new 108	java/lang/StringBuilder
    //   698: dup
    //   699: ldc_w 373
    //   702: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   705: aload_0
    //   706: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   715: aload_1
    //   716: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   719: checkcast 213	java/lang/UnsatisfiedLinkError
    //   722: athrow
    //   723: aload 5
    //   725: invokevirtual 312	java/util/zip/ZipFile:close	()V
    //   728: aload 6
    //   730: invokevirtual 191	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   733: aload_1
    //   734: invokestatic 202	com/tencent/mm/compatible/util/k:reflectSystemLoad	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   737: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   740: astore 4
    //   742: aload 4
    //   744: monitorenter
    //   745: getstatic 25	com/tencent/mm/compatible/util/k:mLoadedLibs	Ljava/util/HashMap;
    //   748: aload_0
    //   749: new 204	java/lang/ref/WeakReference
    //   752: dup
    //   753: aload_1
    //   754: invokespecial 207	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   757: invokevirtual 211	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   760: pop
    //   761: aload 4
    //   763: monitorexit
    //   764: return
    //   765: astore_1
    //   766: aload 4
    //   768: monitorexit
    //   769: aload_1
    //   770: athrow
    //   771: astore_1
    //   772: aload_3
    //   773: ifnonnull +38 -> 811
    //   776: new 213	java/lang/UnsatisfiedLinkError
    //   779: dup
    //   780: new 108	java/lang/StringBuilder
    //   783: dup
    //   784: ldc_w 373
    //   787: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   790: aload_0
    //   791: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   797: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   800: aload_1
    //   801: invokevirtual 220	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   804: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   807: checkcast 213	java/lang/UnsatisfiedLinkError
    //   810: athrow
    //   811: aload_3
    //   812: athrow
    //   813: astore_0
    //   814: aload_3
    //   815: ifnonnull +21 -> 836
    //   818: new 213	java/lang/UnsatisfiedLinkError
    //   821: dup
    //   822: ldc_w 371
    //   825: invokespecial 216	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   828: aload_0
    //   829: invokevirtual 224	java/lang/UnsatisfiedLinkError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   832: checkcast 213	java/lang/UnsatisfiedLinkError
    //   835: athrow
    //   836: aload_3
    //   837: athrow
    //   838: astore 4
    //   840: goto -112 -> 728
    //   843: astore_1
    //   844: goto -314 -> 530
    //   847: astore_0
    //   848: aconst_null
    //   849: astore 4
    //   851: goto -331 -> 520
    //   854: astore_0
    //   855: aconst_null
    //   856: astore 4
    //   858: goto -357 -> 501
    //   861: goto -429 -> 432
    //   864: aconst_null
    //   865: astore_3
    //   866: goto -484 -> 382
    //   869: aconst_null
    //   870: astore_3
    //   871: goto -798 -> 73
    //   874: return
    //   875: iconst_0
    //   876: istore_2
    //   877: goto -864 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	880	0	paramString	String
    //   0	880	1	paramClassLoader	ClassLoader
    //   12	865	2	bool	boolean
    //   60	311	3	localObject1	Object
    //   375	51	3	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   431	1	3	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   532	12	3	localInvocationTargetException1	InvocationTargetException
    //   550	321	3	localUnsatisfiedLinkError3	UnsatisfiedLinkError
    //   23	109	4	localHashMap1	HashMap
    //   368	5	4	localObject2	Object
    //   390	28	4	localHashMap2	HashMap
    //   423	7	4	localUnsatisfiedLinkError4	UnsatisfiedLinkError
    //   451	75	4	localObject3	Object
    //   622	54	4	localInvocationTargetException2	InvocationTargetException
    //   838	1	4	localIOException	java.io.IOException
    //   849	8	4	localObject4	Object
    //   167	557	5	localObject5	Object
    //   324	405	6	localFile	File
    //   415	6	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   28	61	125	finally
    //   65	73	125	finally
    //   82	93	125	finally
    //   94	125	125	finally
    //   126	129	125	finally
    //   131	134	125	finally
    //   197	215	216	finally
    //   217	219	216	finally
    //   186	197	221	java/lang/reflect/InvocationTargetException
    //   219	221	221	java/lang/reflect/InvocationTargetException
    //   186	197	256	java/lang/Exception
    //   219	221	256	java/lang/Exception
    //   349	367	368	finally
    //   370	372	368	finally
    //   334	349	375	java/lang/UnsatisfiedLinkError
    //   372	375	375	java/lang/UnsatisfiedLinkError
    //   395	414	415	finally
    //   417	420	415	finally
    //   382	395	423	java/lang/UnsatisfiedLinkError
    //   420	423	423	java/lang/UnsatisfiedLinkError
    //   453	467	496	java/lang/Exception
    //   471	496	496	java/lang/Exception
    //   453	467	519	finally
    //   471	496	519	finally
    //   501	519	519	finally
    //   334	349	532	java/lang/reflect/InvocationTargetException
    //   372	375	532	java/lang/reflect/InvocationTargetException
    //   334	349	589	java/lang/Throwable
    //   372	375	589	java/lang/Throwable
    //   382	395	622	java/lang/reflect/InvocationTargetException
    //   420	423	622	java/lang/reflect/InvocationTargetException
    //   382	395	690	java/lang/Throwable
    //   420	423	690	java/lang/Throwable
    //   745	764	765	finally
    //   766	769	765	finally
    //   728	745	771	java/lang/reflect/InvocationTargetException
    //   769	771	771	java/lang/reflect/InvocationTargetException
    //   728	745	813	java/lang/Exception
    //   769	771	813	java/lang/Exception
    //   723	728	838	java/io/IOException
    //   525	530	843	java/io/IOException
    //   432	449	847	finally
    //   432	449	854	java/lang/Exception
  }
  
  private static boolean extractLibrary(ZipFile paramZipFile, String paramString, List<String> paramList, File paramFile)
  {
    if (paramFile.isFile()) {
      return true;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      localObject = paramZipFile.getEntry("lib/" + (String)localObject + "/lib" + paramString + ".so");
      if (localObject != null)
      {
        paramZipFile = paramZipFile.getInputStream((ZipEntry)localObject);
        paramString = new FileOutputStream(paramFile);
        paramList = new byte[2048];
        try
        {
          for (;;)
          {
            int i = paramZipFile.read(paramList, 0, 2048);
            if (i == -1) {
              break;
            }
            paramString.write(paramList, 0, i);
          }
          paramZipFile.close();
        }
        finally
        {
          paramZipFile.close();
          paramString.close();
        }
        paramString.close();
        paramFile.setReadOnly();
        return true;
      }
    }
    return false;
  }
  
  public static boolean fd(String paramString)
  {
    synchronized (mLoadedLibs)
    {
      boolean bool = mLoadedLibs.containsKey(paramString);
      return bool;
    }
  }
  
  public static String fe(String paramString)
  {
    try
    {
      Object localObject1 = k.class.getClassLoader();
      Object localObject3 = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
      ((Method)localObject3).setAccessible(true);
      localObject1 = (String)((Method)localObject3).invoke(localObject1, new Object[] { paramString });
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        paramString = new File(ae.getContext().getDir("recover_lib", 0), "lib" + paramString + ".so");
        localObject3 = localObject1;
        if (paramString.canRead()) {
          localObject3 = paramString.getAbsolutePath();
        }
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private static List<String> generateAbiList()
  {
    ArrayList localArrayList = new ArrayList(3);
    String str = com.tencent.mm.compatible.e.y.get("ro.product.cpu.abi");
    if ((str != null) && (str.length() > 0)) {
      localArrayList.add(str);
    }
    str = com.tencent.mm.compatible.e.y.get("ro.product.cpu.abi2");
    if ((str != null) && (str.length() > 0)) {
      localArrayList.add(str);
    }
    localArrayList.add("armeabi");
    return localArrayList;
  }
  
  private static void reflectSystemLoad(String paramString, ClassLoader paramClassLoader)
  {
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("load", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
  }
  
  private static void reflectSystemLoadlibrary(String paramString, ClassLoader paramClassLoader)
  {
    Runtime localRuntime = Runtime.getRuntime();
    Method localMethod = localRuntime.getClass().getDeclaredMethod("loadLibrary", new Class[] { String.class, ClassLoader.class });
    localMethod.setAccessible(true);
    localMethod.invoke(localRuntime, new Object[] { paramString, paramClassLoader });
  }
  
  public static void setupBrokenLibraryHandler()
  {
    Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
  }
  
  private static final class a
    implements Thread.UncaughtExceptionHandler
  {
    private Thread.UncaughtExceptionHandler mParent;
    
    public a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
    {
      this.mParent = paramUncaughtExceptionHandler;
    }
    
    public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
    {
      int j = 1;
      int i;
      if (((paramThrowable instanceof UnsatisfiedLinkError)) || (((paramThrowable instanceof NoSuchMethodError)) && (paramThrowable.getMessage().matches(".*sig(nature)?[=:].*"))))
      {
        i = 1;
        if (i == 0) {
          break label83;
        }
      }
      for (;;)
      {
        try
        {
          k.access$000();
          i = j;
          Throwable localThrowable = paramThrowable;
          if (i != 0) {
            localThrowable = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(paramThrowable);
          }
          this.mParent.uncaughtException(paramThread, localThrowable);
          return;
        }
        catch (Exception localException) {}
        i = 0;
        break;
        label83:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.k
 * JD-Core Version:    0.7.0.1
 */