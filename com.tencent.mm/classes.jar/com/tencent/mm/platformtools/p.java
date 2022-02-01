package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.c;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.e;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.lang.ref.WeakReference;

public final class p
{
  static void G(Runnable paramRunnable)
  {
    AppMethodBeat.i(218764);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(218764);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(218764);
      return;
    }
    com.tencent.e.h.MqF.aM(paramRunnable);
    AppMethodBeat.o(218764);
  }
  
  public static String Jo(String paramString)
  {
    AppMethodBeat.i(218766);
    String str = o.aaw(paramString);
    if (!bu.isNullOrNil(str))
    {
      paramString = str;
      if (!str.equalsIgnoreCase("pic")) {}
    }
    else
    {
      paramString = "jpg";
    }
    paramString = com.tencent.mm.sdk.f.b.arS(paramString);
    AppMethodBeat.o(218766);
    return paramString;
  }
  
  public static void a(Context paramContext, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(218765);
    ae.i("MicroMsg.ExportFileUtil", "[+] Called requestStoragePermission, ctx: %s", new Object[] { paramContext });
    if (!(paramContext instanceof Activity))
    {
      ae.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      G(paramRunnable2);
      AppMethodBeat.o(218765);
      return;
    }
    PermissionHelper.aR((Activity)paramContext).a(paramContext.getString(2131761885), paramContext.getString(2131761738), "android.permission.WRITE_EXTERNAL_STORAGE", new b(paramContext)
    {
      protected final void aQP()
      {
        AppMethodBeat.i(218754);
        p.G(paramRunnable1);
        AppMethodBeat.o(218754);
      }
      
      protected final void aQQ()
      {
        AppMethodBeat.i(218755);
        p.G(paramRunnable2);
        AppMethodBeat.o(218755);
      }
    });
    AppMethodBeat.o(218765);
  }
  
  public static void a(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(218768);
    final String str = Jo(paramString);
    ae.i("MicroMsg.ExportFileUtil", "[+] Called exportImageWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    o.aZI(o.aZU(str));
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218756);
        if (!bu.isNullOrNil(p.l(this.val$context, paramString, str)))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(218756);
          return;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(218756);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218757);
        p.b(this.iPW, paramString, str);
        AppMethodBeat.o(218757);
      }
    };
    if (new k(str).fTg().canWrite())
    {
      local4.run();
      AppMethodBeat.o(218768);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local4, paramString);
      AppMethodBeat.o(218768);
      return;
    }
    paramString.run();
    AppMethodBeat.o(218768);
  }
  
  public static void b(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(218769);
    final String str = com.tencent.mm.sdk.f.b.arS("mp4");
    ae.i("MicroMsg.ExportFileUtil", "[+] Called exportVideoWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    o.aZI(o.aZU(str));
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218758);
        String str2 = paramString;
        String str1 = str;
        o.aZI(o.aZU(str1));
        if (o.mF(str2, str1) >= 0L) {}
        while (!bu.isNullOrNil(str1))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(218758);
          return;
          str1 = null;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(218758);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218759);
        p.b(this.iPW, paramString, str);
        AppMethodBeat.o(218759);
      }
    };
    if (new k(str).fTg().canWrite())
    {
      local6.run();
      AppMethodBeat.o(218769);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local6, paramString);
      AppMethodBeat.o(218769);
      return;
    }
    paramString.run();
    AppMethodBeat.o(218769);
  }
  
  static String bE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(218770);
    String str = new k(paramString1).getName();
    k localk1 = new k(paramString2);
    Object localObject = localk1;
    int i = 2;
    for (;;)
    {
      if (!((k)localObject).exists())
      {
        if (i > 2) {
          ae.w("MicroMsg.ExportFileUtil", "[!] dest file [%s] exists, rename to [%s]", new Object[] { w.B(((k)localObject).fTh()), w.B(((k)localObject).fTh()) });
        }
        ((k)localObject).fTg().mkdirs();
        ae.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDir, src: %s, dest: %s", new Object[] { paramString1, paramString2 });
      }
      try
      {
        if (o.mF(paramString1, paramString2) >= 0L) {}
        for (bool = o.fB(paramString2);; bool = false)
        {
          if (!bool) {
            break label286;
          }
          AppMethodBeat.o(218770);
          return paramString2;
          k localk2 = localk1.fTg();
          StringBuilder localStringBuilder = new StringBuilder();
          int j = str.lastIndexOf('.');
          if (j < 0)
          {
            localObject = str;
            label168:
            localStringBuilder = localStringBuilder.append((String)localObject).append("(").append(i).append(")");
            j = str.lastIndexOf('.');
            if (j >= 0) {
              break label249;
            }
          }
          label249:
          for (localObject = "";; localObject = str.substring(j))
          {
            localObject = new k(localk2, (String)localObject);
            i += 1;
            break;
            localObject = str.substring(0, j);
            break label168;
          }
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.ExportFileUtil", paramString1, "[-] Exception ocurred.", new Object[0]);
          boolean bool = false;
        }
        label286:
        AppMethodBeat.o(218770);
      }
    }
    return null;
  }
  
  public static void c(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(218771);
    Object localObject = new k(paramString).getName();
    localObject = new k(com.tencent.mm.loader.j.b.ath(), (String)localObject);
    ((k)localObject).fTg().mkdirs();
    final String str = w.B(((k)localObject).fTh());
    ae.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDirWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    Runnable local8 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218760);
        if (!bu.isNullOrNil(p.bE(paramString, str)))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(218760);
          return;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(218760);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218761);
        p.b(this.iPW, paramString, str);
        AppMethodBeat.o(218761);
      }
    };
    if (((k)localObject).fTg().canWrite())
    {
      local8.run();
      AppMethodBeat.o(218771);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local8, paramString);
      AppMethodBeat.o(218771);
      return;
    }
    paramString.run();
    AppMethodBeat.o(218771);
  }
  
  /* Error */
  public static String l(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 297
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 154	com/tencent/mm/vfs/o:aZU	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokestatic 157	com/tencent/mm/vfs/o:aZI	(Ljava/lang/String;)Z
    //   13: pop
    //   14: aload_1
    //   15: aload_2
    //   16: invokestatic 237	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   19: lconst_0
    //   20: lcmp
    //   21: iflt +149 -> 170
    //   24: aload_2
    //   25: invokestatic 302	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   28: ifeq +173 -> 201
    //   31: aload_2
    //   32: invokestatic 308	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:df	(Ljava/lang/String;)I
    //   35: istore 4
    //   37: aload_2
    //   38: invokestatic 312	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   41: astore 6
    //   43: aload 6
    //   45: ifnull +151 -> 196
    //   48: iload 4
    //   50: i2f
    //   51: fstore_3
    //   52: aload 6
    //   54: fload_3
    //   55: invokestatic 317	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   58: astore_1
    //   59: aload_1
    //   60: astore 6
    //   62: getstatic 323	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   65: astore 7
    //   67: aload_2
    //   68: iconst_0
    //   69: invokestatic 327	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   72: astore_1
    //   73: aload_1
    //   74: astore 5
    //   76: aload 6
    //   78: aload 7
    //   80: bipush 80
    //   82: aload_1
    //   83: invokevirtual 333	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   86: pop
    //   87: aload_1
    //   88: invokestatic 337	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   91: iconst_1
    //   92: istore 4
    //   94: iload 4
    //   96: ifeq +8 -> 104
    //   99: aload_2
    //   100: aload_0
    //   101: invokestatic 341	com/tencent/mm/sdk/f/b:m	(Ljava/lang/String;Landroid/content/Context;)V
    //   104: iload 4
    //   106: ifeq +70 -> 176
    //   109: ldc_w 297
    //   112: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_2
    //   116: areturn
    //   117: astore_1
    //   118: ldc 104
    //   120: aload_1
    //   121: ldc_w 343
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 279	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: goto -69 -> 62
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: astore 5
    //   140: aload_2
    //   141: invokestatic 346	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   144: pop
    //   145: aload_1
    //   146: invokestatic 337	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   149: iconst_0
    //   150: istore 4
    //   152: goto -58 -> 94
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: invokestatic 337	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   162: ldc_w 297
    //   165: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_0
    //   169: athrow
    //   170: iconst_0
    //   171: istore 4
    //   173: goto -79 -> 94
    //   176: ldc_w 297
    //   179: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: aload 5
    //   187: astore_1
    //   188: goto -30 -> 158
    //   191: astore 5
    //   193: goto -56 -> 137
    //   196: aconst_null
    //   197: astore_1
    //   198: goto -111 -> 87
    //   201: iconst_1
    //   202: istore 4
    //   204: goto -110 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	paramContext	Context
    //   0	207	1	paramString1	String
    //   0	207	2	paramString2	String
    //   51	4	3	f	float
    //   35	168	4	i	int
    //   74	112	5	str	String
    //   191	1	5	localException	java.lang.Exception
    //   41	36	6	localObject	Object
    //   65	14	7	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   52	59	117	java/lang/Exception
    //   31	43	134	java/lang/Exception
    //   62	73	134	java/lang/Exception
    //   118	131	134	java/lang/Exception
    //   31	43	155	finally
    //   52	59	155	finally
    //   62	73	155	finally
    //   118	131	155	finally
    //   76	87	184	finally
    //   140	145	184	finally
    //   76	87	191	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void bF(String paramString1, String paramString2);
    
    public abstract void bG(String paramString1, String paramString2);
  }
  
  static abstract class b
    implements PermissionHelper.e, PermissionHelper.f
  {
    private String iQc = null;
    private final WeakReference<Context> mContextRef;
    
    b(Context paramContext)
    {
      this.mContextRef = new WeakReference(paramContext);
    }
    
    public final void Jp(String paramString)
    {
      this.iQc = paramString;
      aQP();
    }
    
    public final void a(final PermissionHelper.c paramc, String paramString)
    {
      this.iQc = paramString;
      paramString = (Context)this.mContextRef.get();
      if (paramString == null)
      {
        ae.e("MicroMsg.ExportFileUtil", "[-] context is recycled, skip rest steps.");
        return;
      }
      String str = paramString.getString(2131761885);
      com.tencent.mm.ui.base.h.a(paramString, paramString.getString(2131761738), str, paramString.getString(2131760598), paramString.getString(2131761861), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(218762);
          paramAnonymousDialogInterface.dismiss();
          paramc.a(p.b.this);
          AppMethodBeat.o(218762);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(218763);
          paramAnonymousDialogInterface.dismiss();
          p.b.this.aQQ();
          AppMethodBeat.o(218763);
        }
      });
    }
    
    protected abstract void aQP();
    
    protected abstract void aQQ();
    
    public final void aQR()
    {
      if (PermissionHelper.aNr(this.iQc))
      {
        aQP();
        return;
      }
      aQQ();
    }
    
    public final void aQS()
    {
      aQQ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.p
 * JD-Core Version:    0.7.0.1
 */