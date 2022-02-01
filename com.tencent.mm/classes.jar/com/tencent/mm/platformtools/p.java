package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.f.a;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.c;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.e;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class p
{
  private static Executor mDV;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(243744);
    mDV = null;
    try
    {
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class);
      if (localb == null) {
        break label104;
      }
      i = localb.a(b.a.vSY, 1);
    }
    catch (Throwable localThrowable)
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
      mDV = new p.1();
    }
    Log.i("MicroMsg.ExportFileUtil", "res update cliCfg = " + i + ", exportingAsync = " + bool);
    AppMethodBeat.o(243744);
  }
  
  public static void J(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(243708);
    paramContext = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187493);
        Toast.makeText(this.val$context, paramString, 1).show();
        AppMethodBeat.o(187493);
      }
    };
    if (Looper.myLooper() != null)
    {
      paramContext.run();
      AppMethodBeat.o(243708);
      return;
    }
    com.tencent.e.h.ZvG.bd(paramContext);
    AppMethodBeat.o(243708);
  }
  
  public static String K(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243720);
    paramContext = l(paramContext, paramString, null);
    AppMethodBeat.o(243720);
    return paramContext;
  }
  
  private static void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(243709);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(243709);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(243709);
      return;
    }
    com.tencent.e.h.ZvG.bc(paramRunnable);
    AppMethodBeat.o(243709);
  }
  
  public static String L(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243732);
    paramContext = n(paramContext, paramString, null);
    AppMethodBeat.o(243732);
    return paramContext;
  }
  
  public static String M(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243738);
    paramContext = N(paramContext, paramString);
    AppMethodBeat.o(243738);
    return paramContext;
  }
  
  private static String N(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243740);
    String str1 = ZO(paramString);
    String str2 = new q(paramString).getName();
    q localq1 = new q(str1);
    Object localObject = localq1;
    int i = 2;
    boolean bool2;
    if (!((q)localObject).ifE())
    {
      if (i > 2) {
        Log.w("MicroMsg.ExportFileUtil", "[!] dest file [%s] exists, rename to [%s]", new Object[] { ((q)localObject).bOF(), ((q)localObject).bOF() });
      }
      ((q)localObject).ifB().ifL();
      Log.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDir, src: %s, dest: %s", new Object[] { paramString, str1 });
      if (Build.VERSION.SDK_INT < 29) {
        break label340;
      }
      localObject = ScopedStorageUtil.MediaStoreOps.saveDownloads(paramContext, paramString, str1);
      if (localObject == null) {
        break label340;
      }
      paramContext = ScopedStorageUtil.MediaStoreOps.uriToPath(paramContext, (Uri)localObject);
      if (TextUtils.isEmpty(paramContext)) {
        break label340;
      }
      bool2 = true;
    }
    for (;;)
    {
      for (;;)
      {
        boolean bool1 = bool2;
        if (!bool2) {}
        try
        {
          if (u.on(paramString, paramContext) >= 0L) {}
          for (bool1 = u.agG(paramContext);; bool1 = false)
          {
            if (!bool1) {
              break label333;
            }
            AppMethodBeat.o(243740);
            return paramContext;
            q localq2 = localq1.ifB();
            StringBuilder localStringBuilder = new StringBuilder();
            int j = str2.lastIndexOf('.');
            if (j < 0)
            {
              localObject = str2;
              label218:
              localStringBuilder = localStringBuilder.append((String)localObject).append("(").append(i).append(")");
              j = str2.lastIndexOf('.');
              if (j >= 0) {
                break label297;
              }
            }
            label297:
            for (localObject = "";; localObject = str2.substring(j))
            {
              localObject = new q(localq2, (String)localObject);
              i += 1;
              break;
              localObject = str2.substring(0, j);
              break label218;
            }
          }
        }
        catch (Throwable paramString)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.ExportFileUtil", paramString, "[-] Exception ocurred.", new Object[0]);
            bool1 = false;
          }
          label333:
          AppMethodBeat.o(243740);
          return null;
        }
      }
      label340:
      bool2 = false;
      paramContext = str1;
    }
  }
  
  private static String ZN(String paramString)
  {
    AppMethodBeat.i(243713);
    String str = u.asq(paramString);
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
    AppMethodBeat.o(243713);
    return paramString;
  }
  
  private static String ZO(String paramString)
  {
    AppMethodBeat.i(243735);
    paramString = new q(paramString).getName();
    paramString = new q(com.tencent.mm.loader.j.b.aTM(), paramString).bOF();
    AppMethodBeat.o(243735);
    return paramString;
  }
  
  public static void a(Context paramContext, final a<Boolean> parama)
  {
    AppMethodBeat.i(243705);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called checkStoragePermission, ctx: %s", new Object[] { paramContext });
    if (PermissionHelper.bqn("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      Log.i("MicroMsg.ExportFileUtil", "[+] hasPermission = true");
      parama.accept(Boolean.TRUE);
      AppMethodBeat.o(243705);
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      parama.accept(Boolean.FALSE);
      AppMethodBeat.o(243705);
      return;
    }
    Log.i("MicroMsg.ExportFileUtil", "requestPermission");
    PermissionHelper.bc((Activity)paramContext).a(paramContext.getString(c.h.permission_tips_title), paramContext.getString(c.h.exportfile_permission_msg), "android.permission.WRITE_EXTERNAL_STORAGE", new b(paramContext)
    {
      protected final void bvk()
      {
        AppMethodBeat.i(199587);
        Log.i("MicroMsg.ExportFileUtil", "[+] onPermissionGranted");
        parama.accept(Boolean.TRUE);
        AppMethodBeat.o(199587);
      }
      
      protected final void bvl()
      {
        AppMethodBeat.i(199591);
        Log.i("MicroMsg.ExportFileUtil", "[-] onPermissionGranted");
        parama.accept(Boolean.FALSE);
        AppMethodBeat.o(199591);
      }
    });
    AppMethodBeat.o(243705);
  }
  
  public static void a(Context paramContext, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(243706);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called requestStoragePermission, ctx: %s", new Object[] { paramContext });
    if (!(paramContext instanceof Activity))
    {
      Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      K(paramRunnable2);
      AppMethodBeat.o(243706);
      return;
    }
    PermissionHelper.bc((Activity)paramContext).a(paramContext.getString(c.h.permission_tips_title), paramContext.getString(c.h.exportfile_permission_msg), "android.permission.WRITE_EXTERNAL_STORAGE", new b(paramContext)
    {
      protected final void bvk()
      {
        AppMethodBeat.i(220152);
        p.L(paramRunnable1);
        AppMethodBeat.o(220152);
      }
      
      protected final void bvl()
      {
        AppMethodBeat.i(220153);
        p.L(paramRunnable2);
        AppMethodBeat.o(220153);
      }
    });
    AppMethodBeat.o(243706);
  }
  
  public static void a(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(243716);
    final String str = ZN(paramString);
    u.bBD(u.bBT(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImageWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new a {}, new a() {});
    AppMethodBeat.o(243716);
  }
  
  public static void a(Context paramContext, Callable<String> paramCallable, a<String> parama)
  {
    AppMethodBeat.i(243711);
    a(paramContext, new p.7(paramCallable, parama));
    AppMethodBeat.o(243711);
  }
  
  public static void b(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(243729);
    final String str = AndroidMediaUtil.getExportImagePath("mp4");
    u.bBD(u.bBT(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportVideoWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new a {}, new a() {});
    AppMethodBeat.o(243729);
  }
  
  public static void c(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(243736);
    final String str = ZO(paramString);
    u.bBD(u.bBT(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDirWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new a {}, new a() {});
    AppMethodBeat.o(243736);
  }
  
  public static String l(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(243722);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImage, src: %s", new Object[] { paramString1 });
    paramContext = m(paramContext, paramString1, paramString2);
    AppMethodBeat.o(243722);
    return paramContext;
  }
  
  /* Error */
  private static String m(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 9
    //   6: ldc_w 410
    //   9: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_1
    //   13: invokestatic 415	com/tencent/mm/sdk/platformtools/ImgUtil:isWXGF	(Ljava/lang/String;)Z
    //   16: ifeq +396 -> 412
    //   19: new 73	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   26: aload_1
    //   27: invokestatic 360	com/tencent/mm/vfs/u:bBT	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 417
    //   36: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokestatic 420	com/tencent/mm/vfs/u:bBW	(Ljava/lang/String;)Ljava/lang/String;
    //   43: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 422
    //   49: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_1
    //   53: invokestatic 260	com/tencent/mm/vfs/u:asq	(Ljava/lang/String;)Ljava/lang/String;
    //   56: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 6
    //   64: ldc_w 424
    //   67: invokestatic 55	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   70: checkcast 424	com/tencent/mm/plugin/emoji/b/c
    //   73: aload_1
    //   74: aload 6
    //   76: invokeinterface 428 3 0
    //   81: istore 4
    //   83: ldc 71
    //   85: ldc_w 430
    //   88: iconst_1
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: iload 4
    //   96: invokestatic 436	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: iload 4
    //   105: ifne +210 -> 315
    //   108: aload 6
    //   110: astore 8
    //   112: aload 6
    //   114: astore 7
    //   116: aload_2
    //   117: astore 6
    //   119: aload_2
    //   120: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifeq +10 -> 133
    //   126: aload 8
    //   128: invokestatic 357	com/tencent/mm/platformtools/p:ZN	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 6
    //   133: aload 6
    //   135: invokestatic 360	com/tencent/mm/vfs/u:bBT	(Ljava/lang/String;)Ljava/lang/String;
    //   138: invokestatic 363	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
    //   141: pop
    //   142: getstatic 206	android/os/Build$VERSION:SDK_INT	I
    //   145: bipush 29
    //   147: if_icmplt +259 -> 406
    //   150: aload_0
    //   151: aload_1
    //   152: aload 6
    //   154: invokestatic 439	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:saveImage	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +247 -> 406
    //   162: aload_0
    //   163: aload_1
    //   164: invokestatic 216	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:uriToPath	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   167: astore_1
    //   168: aload_1
    //   169: invokestatic 222	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   172: ifne +234 -> 406
    //   175: iconst_1
    //   176: istore 4
    //   178: aload_1
    //   179: astore 6
    //   181: iload 4
    //   183: ifne +220 -> 403
    //   186: aload 8
    //   188: aload 6
    //   190: invokestatic 228	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   193: lconst_0
    //   194: lcmp
    //   195: iflt +208 -> 403
    //   198: iload 5
    //   200: istore 4
    //   202: iload 4
    //   204: ifeq +196 -> 400
    //   207: aload 6
    //   209: invokestatic 444	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   212: ifeq +188 -> 400
    //   215: aload 6
    //   217: invokestatic 450	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:getExifOrientation	(Ljava/lang/String;)I
    //   220: istore 5
    //   222: aload 6
    //   224: invokestatic 454	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   227: astore 8
    //   229: aload 8
    //   231: ifnull +164 -> 395
    //   234: iload 5
    //   236: i2f
    //   237: fstore_3
    //   238: aload 8
    //   240: fload_3
    //   241: invokestatic 460	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   244: astore_1
    //   245: aload_1
    //   246: astore 8
    //   248: getstatic 466	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   251: astore 10
    //   253: aload 6
    //   255: invokestatic 470	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   258: astore_1
    //   259: aload_1
    //   260: astore_2
    //   261: aload 8
    //   263: aload 10
    //   265: bipush 80
    //   267: aload_1
    //   268: invokevirtual 476	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   271: pop
    //   272: aload_1
    //   273: invokestatic 480	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   276: iload 4
    //   278: ifeq +9 -> 287
    //   281: aload 6
    //   283: aload_0
    //   284: invokestatic 484	com/tencent/mm/sdk/system/AndroidMediaUtil:refreshMediaScannerAsync	(Ljava/lang/String;Landroid/content/Context;)V
    //   287: aload 7
    //   289: invokestatic 265	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   292: ifne +9 -> 301
    //   295: aload 7
    //   297: invokestatic 487	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   300: pop
    //   301: iload 4
    //   303: ifeq +74 -> 377
    //   306: ldc_w 410
    //   309: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: aload 6
    //   314: areturn
    //   315: ldc_w 410
    //   318: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aconst_null
    //   322: areturn
    //   323: astore_1
    //   324: ldc 71
    //   326: aload_1
    //   327: ldc_w 489
    //   330: iconst_0
    //   331: anewarray 4	java/lang/Object
    //   334: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: goto -89 -> 248
    //   340: astore_1
    //   341: aconst_null
    //   342: astore_1
    //   343: aload_1
    //   344: astore_2
    //   345: aload 6
    //   347: invokestatic 487	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   350: pop
    //   351: aload_1
    //   352: invokestatic 480	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   355: iconst_0
    //   356: istore 4
    //   358: goto -82 -> 276
    //   361: astore_0
    //   362: aload 9
    //   364: astore_1
    //   365: aload_1
    //   366: invokestatic 480	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   369: ldc_w 410
    //   372: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload_0
    //   376: athrow
    //   377: ldc_w 410
    //   380: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aconst_null
    //   384: areturn
    //   385: astore_0
    //   386: aload_2
    //   387: astore_1
    //   388: goto -23 -> 365
    //   391: astore_2
    //   392: goto -49 -> 343
    //   395: aconst_null
    //   396: astore_1
    //   397: goto -125 -> 272
    //   400: goto -124 -> 276
    //   403: goto -201 -> 202
    //   406: iconst_0
    //   407: istore 4
    //   409: goto -228 -> 181
    //   412: aload_1
    //   413: astore 8
    //   415: aconst_null
    //   416: astore 7
    //   418: goto -302 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramContext	Context
    //   0	421	1	paramString1	String
    //   0	421	2	paramString2	String
    //   237	4	3	f	float
    //   81	327	4	i	int
    //   1	234	5	j	int
    //   62	284	6	str1	String
    //   114	303	7	str2	String
    //   110	304	8	localObject1	Object
    //   4	359	9	localObject2	Object
    //   251	13	10	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   238	245	323	java/lang/Exception
    //   215	229	340	java/lang/Exception
    //   248	259	340	java/lang/Exception
    //   324	337	340	java/lang/Exception
    //   215	229	361	finally
    //   238	245	361	finally
    //   248	259	361	finally
    //   324	337	361	finally
    //   261	272	385	finally
    //   345	351	385	finally
    //   261	272	391	java/lang/Exception
  }
  
  public static String n(Context paramContext, String paramString1, String paramString2)
  {
    int j = 1;
    AppMethodBeat.i(243734);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportVideo, src: %s", new Object[] { paramString1 });
    label146:
    label153:
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label153;
        }
        paramString2 = AndroidMediaUtil.getExportImagePath("mp4");
        u.bBD(u.bBT(paramString2));
        if (Build.VERSION.SDK_INT < 29) {
          break label146;
        }
        Uri localUri = ScopedStorageUtil.MediaStoreOps.saveVideo(paramContext, paramString1, paramString2);
        if (localUri == null) {
          break label146;
        }
        paramContext = ScopedStorageUtil.MediaStoreOps.uriToPath(paramContext, localUri);
        if (TextUtils.isEmpty(paramContext)) {
          break label146;
        }
        i = 1;
        if ((i == 0) && (u.on(paramString1, paramContext) >= 0L))
        {
          i = j;
          if (i != 0)
          {
            AppMethodBeat.o(243734);
            return paramContext;
          }
          AppMethodBeat.o(243734);
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ExportFileUtil", paramContext, "exportVideoImpl fail", new Object[0]);
        AppMethodBeat.o(243734);
        return null;
      }
      continue;
      int i = 0;
      paramContext = paramString2;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bT(String paramString1, String paramString2);
    
    public abstract void bU(String paramString1, String paramString2);
  }
  
  static abstract class b
    implements PermissionHelper.e, PermissionHelper.f
  {
    private final WeakReference<Context> mContextRef;
    String mEg = null;
    
    b(Context paramContext)
    {
      this.mContextRef = new WeakReference(paramContext);
    }
    
    public final void ZP(String paramString)
    {
      this.mEg = paramString;
      bvk();
    }
    
    public final void a(final PermissionHelper.c paramc, String paramString)
    {
      this.mEg = paramString;
      paramString = (Context)this.mContextRef.get();
      if (paramString == null)
      {
        Log.e("MicroMsg.ExportFileUtil", "[-] context is recycled, skip rest steps.");
        return;
      }
      String str = paramString.getString(c.h.permission_tips_title);
      com.tencent.mm.ui.base.h.a(paramString, paramString.getString(c.h.exportfile_permission_msg), str, paramString.getString(c.h.jump_to_settings), paramString.getString(c.h.permission_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(198124);
          paramAnonymousDialogInterface.dismiss();
          paramc.a(p.b.this);
          AppMethodBeat.o(198124);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(205207);
          paramAnonymousDialogInterface.dismiss();
          p.b.this.bvl();
          AppMethodBeat.o(205207);
        }
      });
    }
    
    protected abstract void bvk();
    
    protected abstract void bvl();
    
    public final void bvm()
    {
      if (PermissionHelper.bqn(this.mEg))
      {
        bvk();
        return;
      }
      bvl();
    }
    
    public final void bvn()
    {
      bvl();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.p
 * JD-Core Version:    0.7.0.1
 */