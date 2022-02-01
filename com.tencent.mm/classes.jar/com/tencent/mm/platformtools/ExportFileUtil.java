package com.tencent.mm.platformtools;

import a.d;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.c;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.e;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class ExportFileUtil
{
  private static Executor pAy;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(234062);
    pAy = null;
    try
    {
      c localc = (c)com.tencent.mm.kernel.h.ax(c.class);
      if (localc == null) {
        break label104;
      }
      i = localc.a(c.a.zlC, 1);
    }
    finally
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ExportFileUtil", localThrowable, "", new Object[0]);
        int i = 0;
      }
    }
    if (i != 0) {
      bool = true;
    }
    if (bool) {
      pAy = new ExportFileUtil.1();
    }
    Log.i("MicroMsg.ExportFileUtil", "res update cliCfg = " + i + ", exportingAsync = " + bool);
    AppMethodBeat.o(234062);
  }
  
  private ExportFileUtil()
  {
    AppMethodBeat.i(234003);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
    AppMethodBeat.o(234003);
    throw localUnsupportedOperationException;
  }
  
  public static void N(Context paramContext, String paramString)
  {
    AppMethodBeat.i(234020);
    paramContext = new ExportFileUtil.6(paramContext, paramString);
    if (Looper.myLooper() != null)
    {
      paramContext.run();
      AppMethodBeat.o(234020);
      return;
    }
    com.tencent.threadpool.h.ahAA.bl(paramContext);
    AppMethodBeat.o(234020);
  }
  
  public static String O(Context paramContext, String paramString)
  {
    AppMethodBeat.i(234035);
    paramContext = p(paramContext, paramString, null);
    AppMethodBeat.o(234035);
    return paramContext;
  }
  
  public static String P(Context paramContext, String paramString)
  {
    AppMethodBeat.i(234045);
    paramContext = q(paramContext, paramString, null);
    AppMethodBeat.o(234045);
    return paramContext;
  }
  
  private static void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(234025);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(234025);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(234025);
      return;
    }
    com.tencent.threadpool.h.ahAA.bk(paramRunnable);
    AppMethodBeat.o(234025);
  }
  
  public static String Q(Context paramContext, String paramString)
  {
    AppMethodBeat.i(234058);
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramString).cG(paramContext);
    paramContext = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), paramContext.aYi(), "com/tencent/mm/platformtools/ExportFileUtil", "exportToPublicDownloadDir", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "com/tencent/mm/platformtools/ExportFileUtil", "exportToPublicDownloadDirImpl", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;");
    AppMethodBeat.o(234058);
    return paramContext;
  }
  
  private static String Sb(String paramString)
  {
    AppMethodBeat.i(234030);
    String str = y.alV(paramString);
    if (!Util.isNullOrNil(str))
    {
      paramString = str;
      if (!str.equalsIgnoreCase("pic")) {}
    }
    else
    {
      paramString = "jpg";
    }
    paramString = AndroidMediaUtil.getExportImagePath(paramString);
    AppMethodBeat.o(234030);
    return paramString;
  }
  
  private static String Sc(String paramString)
  {
    AppMethodBeat.i(234050);
    paramString = new u(paramString).getName();
    paramString = ah.v(new u(b.bnB(), paramString).jKT());
    AppMethodBeat.o(234050);
    return paramString;
  }
  
  public static void a(Context paramContext, final androidx.core.f.a<Boolean> parama)
  {
    AppMethodBeat.i(234006);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called checkStoragePermission, ctx: %s", new Object[] { paramContext });
    if (PermissionHelper.aUq("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      Log.i("MicroMsg.ExportFileUtil", "[+] hasPermission = true");
      parama.accept(Boolean.TRUE);
      AppMethodBeat.o(234006);
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      parama.accept(Boolean.FALSE);
      AppMethodBeat.o(234006);
      return;
    }
    Log.i("MicroMsg.ExportFileUtil", "requestPermission");
    PermissionHelper.bH((Activity)paramContext).a(paramContext.getString(c.h.permission_tips_title), paramContext.getString(c.h.exportfile_permission_msg), "android.permission.WRITE_EXTERNAL_STORAGE", new b(paramContext)
    {
      protected final void bTw()
      {
        AppMethodBeat.i(234012);
        Log.i("MicroMsg.ExportFileUtil", "[+] onPermissionGranted");
        parama.accept(Boolean.TRUE);
        AppMethodBeat.o(234012);
      }
      
      protected final void bTx()
      {
        AppMethodBeat.i(234018);
        Log.i("MicroMsg.ExportFileUtil", "[-] onPermissionGranted");
        parama.accept(Boolean.FALSE);
        AppMethodBeat.o(234018);
      }
    });
    AppMethodBeat.o(234006);
  }
  
  public static void a(Context paramContext, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(234013);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called requestStoragePermission, ctx: %s", new Object[] { paramContext });
    if (!(paramContext instanceof Activity))
    {
      Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      P(paramRunnable2);
      AppMethodBeat.o(234013);
      return;
    }
    PermissionHelper.bH((Activity)paramContext).a(paramContext.getString(c.h.permission_tips_title), paramContext.getString(c.h.exportfile_permission_msg), "android.permission.WRITE_EXTERNAL_STORAGE", new b(paramContext)
    {
      protected final void bTw()
      {
        AppMethodBeat.i(234011);
        ExportFileUtil.Q(paramRunnable1);
        AppMethodBeat.o(234011);
      }
      
      protected final void bTx()
      {
        AppMethodBeat.i(234015);
        ExportFileUtil.Q(paramRunnable2);
        AppMethodBeat.o(234015);
      }
    });
    AppMethodBeat.o(234013);
  }
  
  public static void a(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(234033);
    final String str = Sb(paramString);
    y.bDX(y.bEo(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImageWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(234033);
  }
  
  public static void a(Context paramContext, Callable<String> paramCallable, final androidx.core.f.a<String> parama)
  {
    AppMethodBeat.i(234028);
    a(paramContext, new androidx.core.f.a() {});
    AppMethodBeat.o(234028);
  }
  
  public static void b(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(234043);
    final String str = AndroidMediaUtil.getExportImagePath("mp4");
    y.bDX(y.bEo(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportVideoWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(234043);
  }
  
  public static void c(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(234054);
    final String str = Sc(paramString);
    y.bDX(y.bEo(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDirWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new androidx.core.f.a {}, new androidx.core.f.a() {});
    AppMethodBeat.o(234054);
  }
  
  /* Error */
  private static String exportImageImpl(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: ldc_w 374
    //   6: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 75
    //   11: ldc_w 376
    //   14: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_1
    //   18: invokestatic 381	com/tencent/mm/sdk/platformtools/ImgUtil:isWXGF	(Ljava/lang/String;)Z
    //   21: istore 5
    //   23: iload 5
    //   25: ifeq +472 -> 497
    //   28: new 77	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   35: aload_1
    //   36: invokestatic 329	com/tencent/mm/vfs/y:bEo	(Ljava/lang/String;)Ljava/lang/String;
    //   39: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 384
    //   45: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokestatic 387	com/tencent/mm/vfs/y:bEq	(Ljava/lang/String;)Ljava/lang/String;
    //   52: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc_w 389
    //   58: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokestatic 205	com/tencent/mm/vfs/y:alV	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore 7
    //   73: ldc_w 391
    //   76: invokestatic 59	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   79: checkcast 391	com/tencent/mm/plugin/emoji/c/c
    //   82: aload_1
    //   83: aload 7
    //   85: invokeinterface 395 3 0
    //   90: istore 4
    //   92: ldc 75
    //   94: ldc_w 397
    //   97: iconst_1
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: iload 4
    //   105: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: iload 4
    //   114: ifne +276 -> 390
    //   117: aload 7
    //   119: astore 9
    //   121: aload 7
    //   123: astore 8
    //   125: aload_2
    //   126: astore 7
    //   128: aload_2
    //   129: invokestatic 409	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   132: ifeq +10 -> 142
    //   135: aload 9
    //   137: invokestatic 326	com/tencent/mm/platformtools/ExportFileUtil:Sb	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore 7
    //   142: ldc 75
    //   144: ldc_w 411
    //   147: aload 7
    //   149: invokestatic 329	com/tencent/mm/vfs/y:bEo	(Ljava/lang/String;)Ljava/lang/String;
    //   152: invokestatic 332	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   155: invokestatic 414	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   158: invokevirtual 417	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: getstatic 422	android/os/Build$VERSION:SDK_INT	I
    //   167: bipush 29
    //   169: if_icmplt +322 -> 491
    //   172: aload_0
    //   173: aload_1
    //   174: aload 7
    //   176: invokestatic 428	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:saveImage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +310 -> 491
    //   184: aload_0
    //   185: aload_1
    //   186: invokestatic 432	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:uriToPath	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   189: astore_1
    //   190: aload_1
    //   191: invokestatic 409	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +297 -> 491
    //   197: iconst_1
    //   198: istore 6
    //   200: aload_1
    //   201: astore 7
    //   203: ldc 75
    //   205: ldc_w 434
    //   208: iload 6
    //   210: invokestatic 414	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   213: invokevirtual 417	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: iload 6
    //   221: istore 5
    //   223: iload 6
    //   225: ifne +23 -> 248
    //   228: iload 6
    //   230: istore 5
    //   232: aload 9
    //   234: aload 7
    //   236: iconst_0
    //   237: invokestatic 437	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   240: lconst_0
    //   241: lcmp
    //   242: iflt +6 -> 248
    //   245: iconst_1
    //   246: istore 5
    //   248: ldc 75
    //   250: ldc_w 439
    //   253: iload 5
    //   255: invokestatic 414	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   258: invokevirtual 417	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   261: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: iload 5
    //   266: istore 6
    //   268: iload 5
    //   270: ifeq +81 -> 351
    //   273: iload 5
    //   275: istore 6
    //   277: aload 7
    //   279: invokestatic 444	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   282: ifeq +69 -> 351
    //   285: aload 7
    //   287: invokestatic 450	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:getExifOrientation	(Ljava/lang/String;)I
    //   290: istore 4
    //   292: aload 7
    //   294: invokestatic 454	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   297: astore 9
    //   299: aload 9
    //   301: ifnull +185 -> 486
    //   304: iload 4
    //   306: i2f
    //   307: fstore_3
    //   308: aload 9
    //   310: fload_3
    //   311: invokestatic 460	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   314: astore_1
    //   315: aload_1
    //   316: astore 9
    //   318: getstatic 466	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   321: astore 11
    //   323: aload 7
    //   325: iconst_0
    //   326: invokestatic 470	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   329: astore_1
    //   330: aload_1
    //   331: astore_2
    //   332: aload 9
    //   334: aload 11
    //   336: bipush 80
    //   338: aload_1
    //   339: invokevirtual 476	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   342: pop
    //   343: aload_1
    //   344: invokestatic 480	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   347: iload 5
    //   349: istore 6
    //   351: iload 6
    //   353: ifeq +9 -> 362
    //   356: aload 7
    //   358: aload_0
    //   359: invokestatic 484	com/tencent/mm/sdk/system/AndroidMediaUtil:refreshMediaScannerAsync	(Ljava/lang/String;Landroid/content/Context;)V
    //   362: aload 8
    //   364: invokestatic 211	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   367: ifne +9 -> 376
    //   370: aload 8
    //   372: invokestatic 487	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   375: pop
    //   376: iload 6
    //   378: ifeq +90 -> 468
    //   381: ldc_w 374
    //   384: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   387: aload 7
    //   389: areturn
    //   390: ldc 75
    //   392: ldc_w 489
    //   395: iload 5
    //   397: invokestatic 414	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   400: invokevirtual 417	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   403: invokestatic 103	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: ldc_w 374
    //   409: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aconst_null
    //   413: areturn
    //   414: astore_1
    //   415: ldc 75
    //   417: aload_1
    //   418: ldc_w 491
    //   421: iconst_0
    //   422: anewarray 4	java/lang/Object
    //   425: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   428: goto -110 -> 318
    //   431: astore_1
    //   432: aconst_null
    //   433: astore_1
    //   434: aload_1
    //   435: astore_2
    //   436: aload 7
    //   438: invokestatic 487	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   441: pop
    //   442: aload_1
    //   443: invokestatic 480	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   446: iconst_0
    //   447: istore 6
    //   449: goto -98 -> 351
    //   452: astore_0
    //   453: aload 10
    //   455: astore_1
    //   456: aload_1
    //   457: invokestatic 480	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   460: ldc_w 374
    //   463: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   466: aload_0
    //   467: athrow
    //   468: ldc_w 374
    //   471: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: aconst_null
    //   475: areturn
    //   476: astore_0
    //   477: aload_2
    //   478: astore_1
    //   479: goto -23 -> 456
    //   482: astore_2
    //   483: goto -49 -> 434
    //   486: aconst_null
    //   487: astore_1
    //   488: goto -145 -> 343
    //   491: iconst_0
    //   492: istore 6
    //   494: goto -291 -> 203
    //   497: aload_1
    //   498: astore 9
    //   500: aconst_null
    //   501: astore 8
    //   503: goto -378 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramContext	Context
    //   0	506	1	paramString1	String
    //   0	506	2	paramString2	String
    //   307	4	3	f	float
    //   90	215	4	i	int
    //   21	375	5	bool1	boolean
    //   198	295	6	bool2	boolean
    //   71	366	7	str1	String
    //   123	379	8	str2	String
    //   119	380	9	localObject1	Object
    //   1	453	10	localObject2	Object
    //   321	14	11	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   308	315	414	java/lang/Exception
    //   285	299	431	java/lang/Exception
    //   318	330	431	java/lang/Exception
    //   415	428	431	java/lang/Exception
    //   285	299	452	finally
    //   308	315	452	finally
    //   318	330	452	finally
    //   415	428	452	finally
    //   332	343	476	finally
    //   436	442	476	finally
    //   332	343	482	java/lang/Exception
  }
  
  /* Error */
  private static String exportToPublicDownloadDirImpl(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc_w 492
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 366	com/tencent/mm/platformtools/ExportFileUtil:Sc	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 7
    //   12: new 227	com/tencent/mm/vfs/u
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 228	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 231	com/tencent/mm/vfs/u:getName	()Ljava/lang/String;
    //   23: astore 8
    //   25: new 227	com/tencent/mm/vfs/u
    //   28: dup
    //   29: aload 7
    //   31: invokespecial 228	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   34: astore 9
    //   36: aload 9
    //   38: astore 6
    //   40: iconst_2
    //   41: istore_2
    //   42: aload 6
    //   44: invokevirtual 496	com/tencent/mm/vfs/u:jKS	()Z
    //   47: ifne +150 -> 197
    //   50: iload_2
    //   51: iconst_2
    //   52: if_icmple +37 -> 89
    //   55: ldc 75
    //   57: ldc_w 498
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload 6
    //   68: invokevirtual 242	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   71: invokestatic 248	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   74: aastore
    //   75: dup
    //   76: iconst_1
    //   77: aload 6
    //   79: invokevirtual 242	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   82: invokestatic 248	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   85: aastore
    //   86: invokestatic 501	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload 6
    //   91: invokevirtual 505	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   94: invokevirtual 508	com/tencent/mm/vfs/u:jKY	()Z
    //   97: pop
    //   98: ldc 75
    //   100: ldc_w 510
    //   103: iconst_2
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload 7
    //   115: aastore
    //   116: invokestatic 255	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: getstatic 422	android/os/Build$VERSION:SDK_INT	I
    //   122: bipush 29
    //   124: if_icmplt +231 -> 355
    //   127: aload_0
    //   128: aload_1
    //   129: aload 7
    //   131: invokestatic 513	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:saveDownloads	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   134: astore 6
    //   136: aload 6
    //   138: ifnull +217 -> 355
    //   141: aload_0
    //   142: aload 6
    //   144: invokestatic 432	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:uriToPath	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   147: astore_0
    //   148: aload_0
    //   149: invokestatic 409	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   152: ifne +203 -> 355
    //   155: iconst_1
    //   156: istore 5
    //   158: iload 5
    //   160: istore 4
    //   162: iload 5
    //   164: ifne +20 -> 184
    //   167: aload_1
    //   168: aload_0
    //   169: iconst_0
    //   170: invokestatic 437	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   173: lconst_0
    //   174: lcmp
    //   175: iflt +146 -> 321
    //   178: aload_0
    //   179: invokestatic 516	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   182: istore 4
    //   184: iload 4
    //   186: ifeq +161 -> 347
    //   189: ldc_w 492
    //   192: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_0
    //   196: areturn
    //   197: aload 9
    //   199: invokevirtual 505	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   202: astore 10
    //   204: new 77	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 382	java/lang/StringBuilder:<init>	()V
    //   211: astore 11
    //   213: aload 8
    //   215: bipush 46
    //   217: invokevirtual 520	java/lang/String:lastIndexOf	(I)I
    //   220: istore_3
    //   221: iload_3
    //   222: ifge +76 -> 298
    //   225: aload 8
    //   227: astore 6
    //   229: aload 11
    //   231: aload 6
    //   233: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: ldc_w 522
    //   239: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: iload_2
    //   243: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: ldc_w 524
    //   249: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: astore 11
    //   254: aload 8
    //   256: bipush 46
    //   258: invokevirtual 520	java/lang/String:lastIndexOf	(I)I
    //   261: istore_3
    //   262: iload_3
    //   263: ifge +47 -> 310
    //   266: ldc 108
    //   268: astore 6
    //   270: new 227	com/tencent/mm/vfs/u
    //   273: dup
    //   274: aload 10
    //   276: aload 11
    //   278: aload 6
    //   280: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 527	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   289: astore 6
    //   291: iload_2
    //   292: iconst_1
    //   293: iadd
    //   294: istore_2
    //   295: goto -253 -> 42
    //   298: aload 8
    //   300: iconst_0
    //   301: iload_3
    //   302: invokevirtual 531	java/lang/String:substring	(II)Ljava/lang/String;
    //   305: astore 6
    //   307: goto -78 -> 229
    //   310: aload 8
    //   312: iload_3
    //   313: invokevirtual 533	java/lang/String:substring	(I)Ljava/lang/String;
    //   316: astore 6
    //   318: goto -48 -> 270
    //   321: iconst_0
    //   322: istore 4
    //   324: goto -140 -> 184
    //   327: astore_1
    //   328: ldc 75
    //   330: aload_1
    //   331: ldc_w 535
    //   334: iconst_0
    //   335: anewarray 4	java/lang/Object
    //   338: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   341: iconst_0
    //   342: istore 4
    //   344: goto -160 -> 184
    //   347: ldc_w 492
    //   350: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   353: aconst_null
    //   354: areturn
    //   355: iconst_0
    //   356: istore 5
    //   358: aload 7
    //   360: astore_0
    //   361: goto -203 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramContext	Context
    //   0	364	1	paramString	String
    //   41	254	2	i	int
    //   220	93	3	j	int
    //   160	183	4	bool1	boolean
    //   156	201	5	bool2	boolean
    //   38	279	6	localObject	Object
    //   10	349	7	str1	String
    //   23	288	8	str2	String
    //   34	164	9	localu1	u
    //   202	73	10	localu2	u
    //   211	66	11	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   167	184	327	finally
  }
  
  private static String exportVideoImpl(Context paramContext, String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(234048);
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = AndroidMediaUtil.getExportImagePath("mp4");
    }
    y.bDX(y.bEo(str));
    int i;
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramString2 = ScopedStorageUtil.MediaStoreOps.saveVideo(paramContext, paramString1, str);
      if (paramString2 != null)
      {
        paramContext = ScopedStorageUtil.MediaStoreOps.uriToPath(paramContext, paramString2);
        if (!TextUtils.isEmpty(paramContext)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (y.O(paramString1, paramContext, false) >= 0L)) {
        i = j;
      }
      for (;;)
      {
        if (i != 0)
        {
          AppMethodBeat.o(234048);
          return paramContext;
        }
        AppMethodBeat.o(234048);
        return null;
      }
      i = 0;
      paramContext = str;
    }
  }
  
  public static String p(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(234036);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImage, src: %s", new Object[] { paramString1 });
    paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramString2).cG(paramString1).cG(paramContext);
    paramContext = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), paramContext.aYi(), "com/tencent/mm/platformtools/ExportFileUtil", "exportImage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "com/tencent/mm/platformtools/ExportFileUtil", "exportImageImpl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
    AppMethodBeat.o(234036);
    return paramContext;
  }
  
  public static String q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(234046);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportVideo, src: %s", new Object[] { paramString1 });
    try
    {
      paramContext = new com.tencent.mm.hellhoundlib.b.a().cG(paramString2).cG(paramString1).cG(paramContext);
      paramContext = (String)com.tencent.mm.hellhoundlib.a.a.a(new Object(), paramContext.aYi(), "com/tencent/mm/platformtools/ExportFileUtil", "exportVideo", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "com/tencent/mm/platformtools/ExportFileUtil", "exportVideoImpl", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
      AppMethodBeat.o(234046);
      return paramContext;
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.ExportFileUtil", paramContext, "exportVideoImpl fail", new Object[0]);
      AppMethodBeat.o(234046);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void cg(String paramString1, String paramString2);
    
    public abstract void ch(String paramString1, String paramString2);
  }
  
  static abstract class b
    implements PermissionHelper.e, PermissionHelper.f
  {
    private final WeakReference<Context> mContextRef;
    String pAJ = null;
    
    b(Context paramContext)
    {
      this.mContextRef = new WeakReference(paramContext);
    }
    
    public final void Sd(String paramString)
    {
      this.pAJ = paramString;
      bTw();
    }
    
    public final void a(final PermissionHelper.c paramc, String paramString)
    {
      this.pAJ = paramString;
      paramString = (Context)this.mContextRef.get();
      if (paramString == null)
      {
        Log.e("MicroMsg.ExportFileUtil", "[-] context is recycled, skip rest steps.");
        return;
      }
      String str = paramString.getString(c.h.permission_tips_title);
      k.a(paramString, paramString.getString(c.h.exportfile_permission_msg), str, paramString.getString(c.h.jump_to_settings), paramString.getString(c.h.permission_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(234031);
          paramAnonymousDialogInterface.dismiss();
          paramc.a(ExportFileUtil.b.this);
          AppMethodBeat.o(234031);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(234027);
          paramAnonymousDialogInterface.dismiss();
          ExportFileUtil.b.this.bTx();
          AppMethodBeat.o(234027);
        }
      });
    }
    
    protected abstract void bTw();
    
    protected abstract void bTx();
    
    public final void bTy()
    {
      if (PermissionHelper.aUq(this.pAJ))
      {
        bTw();
        return;
      }
      bTx();
    }
    
    public final void bTz()
    {
      bTx();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.ExportFileUtil
 * JD-Core Version:    0.7.0.1
 */