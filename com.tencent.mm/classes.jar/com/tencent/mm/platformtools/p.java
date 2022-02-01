package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.provider.MediaStore.Downloads;
import android.provider.MediaStore.Video.Media;
import android.support.v4.e.c;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.c;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.e;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class p
{
  private static Executor jMN;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(223691);
    jMN = null;
    try
    {
      com.tencent.mm.plugin.expt.b.b localb = (com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class);
      if (localb == null) {
        break label104;
      }
      i = localb.a(b.a.siR, 1);
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
      jMN = new p.1();
    }
    Log.i("MicroMsg.ExportFileUtil", "res update cliCfg = " + i + ", exportingAsync = " + bool);
    AppMethodBeat.o(223691);
  }
  
  public static void I(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223677);
    paramContext = new p.6(paramContext, paramString);
    if (Looper.myLooper() != null)
    {
      paramContext.run();
      AppMethodBeat.o(223677);
      return;
    }
    com.tencent.f.h.RTc.aW(paramContext);
    AppMethodBeat.o(223677);
  }
  
  public static String J(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223682);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImage, src: %s", new Object[] { paramString });
    paramContext = K(paramContext, paramString);
    AppMethodBeat.o(223682);
    return paramContext;
  }
  
  /* Error */
  private static String K(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 9
    //   6: ldc 153
    //   8: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_1
    //   12: invokestatic 159	com/tencent/mm/sdk/platformtools/ImgUtil:isWXGF	(Ljava/lang/String;)Z
    //   15: ifeq +371 -> 386
    //   18: new 73	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   25: aload_1
    //   26: invokestatic 166	com/tencent/mm/vfs/s:boZ	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 168
    //   34: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokestatic 171	com/tencent/mm/vfs/s:bpb	(Ljava/lang/String;)Ljava/lang/String;
    //   41: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 173
    //   46: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_1
    //   50: invokestatic 176	com/tencent/mm/vfs/s:akC	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 6
    //   61: ldc 178
    //   63: invokestatic 55	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   66: checkcast 178	com/tencent/mm/plugin/emoji/b/c
    //   69: aload_1
    //   70: aload 6
    //   72: invokeinterface 182 3 0
    //   77: istore_3
    //   78: ldc 71
    //   80: ldc 184
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: iload_3
    //   89: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   92: aastore
    //   93: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: iload_3
    //   97: ifne +194 -> 291
    //   100: aload 6
    //   102: astore 5
    //   104: aload 5
    //   106: invokestatic 193	com/tencent/mm/platformtools/p:Sl	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 7
    //   111: aload 7
    //   113: invokestatic 166	com/tencent/mm/vfs/s:boZ	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokestatic 196	com/tencent/mm/vfs/s:boN	(Ljava/lang/String;)Z
    //   119: pop
    //   120: getstatic 201	android/os/Build$VERSION:SDK_INT	I
    //   123: bipush 29
    //   125: if_icmplt +256 -> 381
    //   128: aload_0
    //   129: aload_1
    //   130: aload 7
    //   132: getstatic 207	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   135: invokestatic 210	com/tencent/mm/platformtools/p$b:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Landroid/net/Uri;
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +241 -> 381
    //   143: aload_0
    //   144: aload_1
    //   145: invokestatic 214	com/tencent/mm/platformtools/p$b:h	(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;
    //   148: astore_1
    //   149: aload_1
    //   150: invokestatic 220	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   153: ifne +228 -> 381
    //   156: iconst_1
    //   157: istore_3
    //   158: aload_1
    //   159: astore 7
    //   161: iload_3
    //   162: ifne +216 -> 378
    //   165: aload 5
    //   167: aload 7
    //   169: invokestatic 224	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   172: lconst_0
    //   173: lcmp
    //   174: iflt +204 -> 378
    //   177: iload 4
    //   179: istore_3
    //   180: iload_3
    //   181: ifeq +194 -> 375
    //   184: aload 7
    //   186: invokestatic 229	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   189: ifeq +186 -> 375
    //   192: aload 7
    //   194: invokestatic 235	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:getExifOrientation	(Ljava/lang/String;)I
    //   197: istore 4
    //   199: aload 7
    //   201: invokestatic 239	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   204: astore 8
    //   206: aload 8
    //   208: ifnull +162 -> 370
    //   211: iload 4
    //   213: i2f
    //   214: fstore_2
    //   215: aload 8
    //   217: fload_2
    //   218: invokestatic 245	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   221: astore_1
    //   222: aload_1
    //   223: astore 8
    //   225: getstatic 251	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   228: astore 10
    //   230: aload 7
    //   232: iconst_0
    //   233: invokestatic 255	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   236: astore_1
    //   237: aload_1
    //   238: astore 5
    //   240: aload 8
    //   242: aload 10
    //   244: bipush 80
    //   246: aload_1
    //   247: invokevirtual 261	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   250: pop
    //   251: aload_1
    //   252: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   255: iload_3
    //   256: ifeq +9 -> 265
    //   259: aload 7
    //   261: aload_0
    //   262: invokestatic 273	com/tencent/mm/sdk/system/AndroidMediaUtil:refreshMediaScannerAsync	(Ljava/lang/String;Landroid/content/Context;)V
    //   265: aload 6
    //   267: invokestatic 276	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   270: ifne +9 -> 279
    //   273: aload 6
    //   275: invokestatic 279	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   278: pop
    //   279: iload_3
    //   280: ifeq +71 -> 351
    //   283: ldc 153
    //   285: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: aload 7
    //   290: areturn
    //   291: ldc 153
    //   293: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: aconst_null
    //   297: areturn
    //   298: astore_1
    //   299: ldc 71
    //   301: aload_1
    //   302: ldc_w 281
    //   305: iconst_0
    //   306: anewarray 4	java/lang/Object
    //   309: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   312: goto -87 -> 225
    //   315: astore_1
    //   316: aconst_null
    //   317: astore_1
    //   318: aload_1
    //   319: astore 5
    //   321: aload 7
    //   323: invokestatic 279	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   326: pop
    //   327: aload_1
    //   328: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   331: iconst_0
    //   332: istore_3
    //   333: goto -78 -> 255
    //   336: astore_0
    //   337: aload 9
    //   339: astore_1
    //   340: aload_1
    //   341: invokestatic 267	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   344: ldc 153
    //   346: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload_0
    //   350: athrow
    //   351: ldc 153
    //   353: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aconst_null
    //   357: areturn
    //   358: astore_0
    //   359: aload 5
    //   361: astore_1
    //   362: goto -22 -> 340
    //   365: astore 5
    //   367: goto -49 -> 318
    //   370: aconst_null
    //   371: astore_1
    //   372: goto -121 -> 251
    //   375: goto -120 -> 255
    //   378: goto -198 -> 180
    //   381: iconst_0
    //   382: istore_3
    //   383: goto -222 -> 161
    //   386: aload_1
    //   387: astore 5
    //   389: aconst_null
    //   390: astore 6
    //   392: goto -288 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	paramContext	Context
    //   0	395	1	paramString	String
    //   214	4	2	f	float
    //   77	306	3	i	int
    //   1	211	4	j	int
    //   102	258	5	str1	String
    //   365	1	5	localException	java.lang.Exception
    //   387	1	5	str2	String
    //   59	332	6	str3	String
    //   109	213	7	str4	String
    //   204	37	8	localObject1	Object
    //   4	334	9	localObject2	Object
    //   228	15	10	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   215	222	298	java/lang/Exception
    //   192	206	315	java/lang/Exception
    //   225	237	315	java/lang/Exception
    //   299	312	315	java/lang/Exception
    //   192	206	336	finally
    //   215	222	336	finally
    //   225	237	336	finally
    //   299	312	336	finally
    //   240	251	358	finally
    //   321	327	358	finally
    //   240	251	365	java/lang/Exception
  }
  
  private static void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(223678);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(223678);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(223678);
      return;
    }
    com.tencent.f.h.RTc.aV(paramRunnable);
    AppMethodBeat.o(223678);
  }
  
  public static String L(Context paramContext, String paramString)
  {
    int j = 1;
    AppMethodBeat.i(223685);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportVideo, src: %s", new Object[] { paramString });
    for (;;)
    {
      String str;
      try
      {
        str = AndroidMediaUtil.getExportImagePath("mp4");
        s.boN(s.boZ(str));
        if (Build.VERSION.SDK_INT < 29) {
          break label143;
        }
        Uri localUri = p.b.a(paramContext, paramString, str, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        if (localUri == null) {
          break label143;
        }
        paramContext = p.b.h(paramContext, localUri);
        if (TextUtils.isEmpty(paramContext)) {
          break label143;
        }
        i = 1;
        if ((i == 0) && (s.nw(paramString, paramContext) >= 0L))
        {
          i = j;
          if (i != 0)
          {
            AppMethodBeat.o(223685);
            return paramContext;
          }
          AppMethodBeat.o(223685);
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ExportFileUtil", paramContext, "exportVideoImpl fail", new Object[0]);
        AppMethodBeat.o(223685);
        return null;
      }
      continue;
      label143:
      int i = 0;
      paramContext = str;
    }
  }
  
  public static String M(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223688);
    paramContext = N(paramContext, paramString);
    AppMethodBeat.o(223688);
    return paramContext;
  }
  
  private static String N(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223689);
    String str1 = Sm(paramString);
    String str2 = new o(paramString).getName();
    o localo1 = new o(str1);
    Object localObject = localo1;
    int i = 2;
    boolean bool2;
    if (!((o)localObject).exists())
    {
      if (i > 2) {
        Log.w("MicroMsg.ExportFileUtil", "[!] dest file [%s] exists, rename to [%s]", new Object[] { aa.z(((o)localObject).her()), aa.z(((o)localObject).her()) });
      }
      ((o)localObject).heq().mkdirs();
      Log.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDir, src: %s, dest: %s", new Object[] { paramString, str1 });
      if (Build.VERSION.SDK_INT < 29) {
        break label357;
      }
      localObject = p.b.a(paramContext, paramString, str1, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
      if (localObject == null) {
        break label357;
      }
      paramContext = p.b.h(paramContext, (Uri)localObject);
      if (TextUtils.isEmpty(paramContext)) {
        break label357;
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
          if (s.nw(paramString, paramContext) >= 0L) {}
          for (bool1 = s.YS(paramContext);; bool1 = false)
          {
            if (!bool1) {
              break label349;
            }
            AppMethodBeat.o(223689);
            return paramContext;
            o localo2 = localo1.heq();
            StringBuilder localStringBuilder = new StringBuilder();
            int j = str2.lastIndexOf('.');
            if (j < 0)
            {
              localObject = str2;
              label231:
              localStringBuilder = localStringBuilder.append((String)localObject).append("(").append(i).append(")");
              j = str2.lastIndexOf('.');
              if (j >= 0) {
                break label312;
              }
            }
            label312:
            for (localObject = "";; localObject = str2.substring(j))
            {
              localObject = new o(localo2, (String)localObject);
              i += 1;
              break;
              localObject = str2.substring(0, j);
              break label231;
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
          label349:
          AppMethodBeat.o(223689);
          return null;
        }
      }
      label357:
      bool2 = false;
      paramContext = str1;
    }
  }
  
  private static String Sl(String paramString)
  {
    AppMethodBeat.i(223680);
    String str = s.akC(paramString);
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
    AppMethodBeat.o(223680);
    return paramString;
  }
  
  private static String Sm(String paramString)
  {
    AppMethodBeat.i(223686);
    paramString = new o(paramString).getName();
    paramString = aa.z(new o(com.tencent.mm.loader.j.b.aLH(), paramString).her());
    AppMethodBeat.o(223686);
    return paramString;
  }
  
  public static void a(Context paramContext, final c<Boolean> paramc)
  {
    AppMethodBeat.i(223675);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called checkStoragePermission, ctx: %s", new Object[] { paramContext });
    if (PermissionHelper.bdR("android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      Log.i("MicroMsg.ExportFileUtil", "[+] hasPermission = true");
      paramc.accept(Boolean.TRUE);
      AppMethodBeat.o(223675);
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      paramc.accept(Boolean.FALSE);
      AppMethodBeat.o(223675);
      return;
    }
    Log.i("MicroMsg.ExportFileUtil", "requestPermission");
    PermissionHelper.aX((Activity)paramContext).a(paramContext.getString(2131763890), paramContext.getString(2131758938), "android.permission.WRITE_EXTERNAL_STORAGE", new c(paramContext)
    {
      protected final void blu()
      {
        AppMethodBeat.i(223656);
        Log.i("MicroMsg.ExportFileUtil", "[+] onPermissionGranted");
        paramc.accept(Boolean.TRUE);
        AppMethodBeat.o(223656);
      }
      
      protected final void blv()
      {
        AppMethodBeat.i(223657);
        Log.i("MicroMsg.ExportFileUtil", "[-] onPermissionGranted");
        paramc.accept(Boolean.FALSE);
        AppMethodBeat.o(223657);
      }
    });
    AppMethodBeat.o(223675);
  }
  
  public static void a(Context paramContext, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(223676);
    Log.i("MicroMsg.ExportFileUtil", "[+] Called requestStoragePermission, ctx: %s", new Object[] { paramContext });
    if (!(paramContext instanceof Activity))
    {
      Log.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      K(paramRunnable2);
      AppMethodBeat.o(223676);
      return;
    }
    PermissionHelper.aX((Activity)paramContext).a(paramContext.getString(2131763890), paramContext.getString(2131758938), "android.permission.WRITE_EXTERNAL_STORAGE", new c(paramContext)
    {
      protected final void blu()
      {
        AppMethodBeat.i(223658);
        p.L(paramRunnable1);
        AppMethodBeat.o(223658);
      }
      
      protected final void blv()
      {
        AppMethodBeat.i(223659);
        p.L(paramRunnable2);
        AppMethodBeat.o(223659);
      }
    });
    AppMethodBeat.o(223676);
  }
  
  public static void a(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(223681);
    final String str = Sl(paramString);
    s.boN(s.boZ(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportImageWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new c {}, new c() {});
    AppMethodBeat.o(223681);
  }
  
  public static void a(Context paramContext, Callable<String> paramCallable, c<String> paramc)
  {
    AppMethodBeat.i(223679);
    a(paramContext, new p.7(paramCallable, paramc));
    AppMethodBeat.o(223679);
  }
  
  public static void b(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(223684);
    final String str = AndroidMediaUtil.getExportImagePath("mp4");
    s.boN(s.boZ(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportVideoWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new c {}, new c() {});
    AppMethodBeat.o(223684);
  }
  
  public static void c(Context paramContext, final String paramString, a parama)
  {
    AppMethodBeat.i(223687);
    final String str = Sm(paramString);
    s.boN(s.boZ(str));
    Log.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDirWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    a(paramContext, new Callable()new c {}, new c() {});
    AppMethodBeat.o(223687);
  }
  
  public static abstract interface a
  {
    public abstract void bP(String paramString1, String paramString2);
    
    public abstract void bQ(String paramString1, String paramString2);
  }
  
  static abstract class c
    implements PermissionHelper.e, PermissionHelper.f
  {
    private String jMY = null;
    private final WeakReference<Context> mContextRef;
    
    c(Context paramContext)
    {
      this.mContextRef = new WeakReference(paramContext);
    }
    
    public final void Sn(String paramString)
    {
      this.jMY = paramString;
      blu();
    }
    
    public final void a(final PermissionHelper.c paramc, String paramString)
    {
      this.jMY = paramString;
      paramString = (Context)this.mContextRef.get();
      if (paramString == null)
      {
        Log.e("MicroMsg.ExportFileUtil", "[-] context is recycled, skip rest steps.");
        return;
      }
      String str = paramString.getString(2131763890);
      com.tencent.mm.ui.base.h.a(paramString, paramString.getString(2131758938), str, paramString.getString(2131762043), paramString.getString(2131763865), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(223673);
          paramAnonymousDialogInterface.dismiss();
          paramc.a(p.c.this);
          AppMethodBeat.o(223673);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(223674);
          paramAnonymousDialogInterface.dismiss();
          p.c.this.blv();
          AppMethodBeat.o(223674);
        }
      });
    }
    
    protected abstract void blu();
    
    protected abstract void blv();
    
    public final void blw()
    {
      if (PermissionHelper.bdR(this.jMY))
      {
        blu();
        return;
      }
      blv();
    }
    
    public final void blx()
    {
      blv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.p
 * JD-Core Version:    0.7.0.1
 */