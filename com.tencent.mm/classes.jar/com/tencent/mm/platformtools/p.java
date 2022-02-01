package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.PermissionHelper;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.c;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.e;
import com.tencent.mm.pluginsdk.permission.PermissionHelper.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.lang.ref.WeakReference;

public final class p
{
  private static String Bv(String paramString)
  {
    AppMethodBeat.i(190732);
    String str = com.tencent.mm.vfs.i.RK(paramString);
    paramString = str;
    if (bt.isNullOrNil(str)) {
      paramString = "jpg";
    }
    paramString = com.tencent.mm.sdk.f.b.ahd(paramString);
    AppMethodBeat.o(190732);
    return paramString;
  }
  
  public static String Bw(String paramString)
  {
    AppMethodBeat.i(190736);
    String str = new e(paramString).getName();
    e locale1 = new e(com.tencent.mm.loader.j.b.ajd(), str);
    Object localObject = locale1;
    int i = 2;
    for (;;)
    {
      if (!((e)localObject).exists())
      {
        if (i > 2) {
          ad.w("MicroMsg.ExportFileUtil", "[!] dest file [%s] exists, rename to [%s]", new Object[] { q.B(((e)localObject).fhU()), q.B(((e)localObject).fhU()) });
        }
        ((e)localObject).fhT().mkdirs();
        localObject = q.B(((e)localObject).fhU());
      }
      try
      {
        if (com.tencent.mm.vfs.i.lC(paramString, (String)localObject) >= 0L) {}
        for (bool = com.tencent.mm.vfs.i.eK((String)localObject);; bool = false)
        {
          if (!bool) {
            break label277;
          }
          AppMethodBeat.o(190736);
          return localObject;
          e locale2 = locale1.fhT();
          StringBuilder localStringBuilder = new StringBuilder();
          int j = str.lastIndexOf('.');
          if (j < 0)
          {
            localObject = str;
            label164:
            localStringBuilder = localStringBuilder.append((String)localObject).append("(").append(i).append(")");
            j = str.lastIndexOf('.');
            if (j >= 0) {
              break label243;
            }
          }
          label243:
          for (localObject = "";; localObject = str.substring(j))
          {
            localObject = new e(locale2, (String)localObject);
            i += 1;
            break;
            localObject = str.substring(0, j);
            break label164;
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.ExportFileUtil", paramString, "[-] Exception ocurred.", new Object[0]);
          boolean bool = false;
        }
        label277:
        AppMethodBeat.o(190736);
      }
    }
    return null;
  }
  
  /* Error */
  public static String H(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 171
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 173	com/tencent/mm/platformtools/p:Bv	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 6
    //   11: aload 6
    //   13: invokestatic 176	com/tencent/mm/vfs/i:aMQ	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 179	com/tencent/mm/vfs/i:aMF	(Ljava/lang/String;)Z
    //   19: pop
    //   20: aload_1
    //   21: aload 6
    //   23: invokestatic 120	com/tencent/mm/vfs/i:lC	(Ljava/lang/String;Ljava/lang/String;)J
    //   26: lconst_0
    //   27: lcmp
    //   28: iflt +147 -> 175
    //   31: aload 6
    //   33: invokestatic 184	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   36: ifeq +168 -> 204
    //   39: aload 6
    //   41: invokestatic 190	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:co	(Ljava/lang/String;)I
    //   44: istore_3
    //   45: aload 6
    //   47: invokestatic 194	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +145 -> 199
    //   57: iload_3
    //   58: i2f
    //   59: fstore_2
    //   60: aload 5
    //   62: fload_2
    //   63: invokestatic 199	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   66: astore_1
    //   67: aload_1
    //   68: astore 5
    //   70: getstatic 205	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: astore 7
    //   75: aload 6
    //   77: iconst_0
    //   78: invokestatic 209	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   81: astore_1
    //   82: aload_1
    //   83: astore 4
    //   85: aload 5
    //   87: aload 7
    //   89: bipush 80
    //   91: aload_1
    //   92: invokevirtual 215	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   95: pop
    //   96: aload_1
    //   97: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   100: iconst_1
    //   101: istore_3
    //   102: iload_3
    //   103: ifeq +9 -> 112
    //   106: aload 6
    //   108: aload_0
    //   109: invokestatic 223	com/tencent/mm/sdk/f/b:k	(Ljava/lang/String;Landroid/content/Context;)V
    //   112: iload_3
    //   113: ifeq +67 -> 180
    //   116: ldc 171
    //   118: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload 6
    //   123: areturn
    //   124: astore_1
    //   125: ldc 91
    //   127: aload_1
    //   128: ldc 225
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: goto -67 -> 70
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: astore 4
    //   146: aload 6
    //   148: invokestatic 228	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   151: pop
    //   152: aload_1
    //   153: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   156: iconst_0
    //   157: istore_3
    //   158: goto -56 -> 102
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: invokestatic 219	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   168: ldc 171
    //   170: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload_0
    //   174: athrow
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -75 -> 102
    //   180: ldc 171
    //   182: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aconst_null
    //   186: areturn
    //   187: astore_0
    //   188: aload 4
    //   190: astore_1
    //   191: goto -27 -> 164
    //   194: astore 4
    //   196: goto -53 -> 143
    //   199: aconst_null
    //   200: astore_1
    //   201: goto -105 -> 96
    //   204: iconst_1
    //   205: istore_3
    //   206: goto -104 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramContext	Context
    //   0	209	1	paramString	String
    //   59	4	2	f	float
    //   44	162	3	i	int
    //   83	106	4	str1	String
    //   194	1	4	localException	java.lang.Exception
    //   50	36	5	localObject	Object
    //   9	138	6	str2	String
    //   73	15	7	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   60	67	124	java/lang/Exception
    //   39	52	140	java/lang/Exception
    //   70	82	140	java/lang/Exception
    //   125	137	140	java/lang/Exception
    //   39	52	161	finally
    //   60	67	161	finally
    //   70	82	161	finally
    //   125	137	161	finally
    //   85	96	187	finally
    //   146	152	187	finally
    //   85	96	194	java/lang/Exception
  }
  
  static void H(Runnable paramRunnable)
  {
    AppMethodBeat.i(190730);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(190730);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(190730);
      return;
    }
    com.tencent.e.h.Iye.aN(paramRunnable);
    AppMethodBeat.o(190730);
  }
  
  public static void a(Context paramContext, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(190731);
    if (!(paramContext instanceof Activity))
    {
      ad.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      H(paramRunnable2);
      AppMethodBeat.o(190731);
      return;
    }
    PermissionHelper.aM((Activity)paramContext).a(paramContext.getString(2131761885), paramContext.getString(2131761738), "android.permission.WRITE_EXTERNAL_STORAGE", new b(paramContext)
    {
      protected final void aGs()
      {
        AppMethodBeat.i(190720);
        p.H(paramRunnable1);
        AppMethodBeat.o(190720);
      }
      
      protected final void aGt()
      {
        AppMethodBeat.i(190721);
        p.H(paramRunnable2);
        AppMethodBeat.o(190721);
      }
    });
    AppMethodBeat.o(190731);
  }
  
  public static void a(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(190734);
    final String str = Bv(paramString);
    com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(str));
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190722);
        if (!bt.isNullOrNil(p.H(this.val$context, paramString)))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(190722);
          return;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(190722);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190723);
        p.b(this.hTV, paramString, str);
        AppMethodBeat.o(190723);
      }
    };
    if (new e(str).fhT().canWrite())
    {
      local4.run();
      AppMethodBeat.o(190734);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local4, paramString);
      AppMethodBeat.o(190734);
      return;
    }
    paramString.run();
    AppMethodBeat.o(190734);
  }
  
  public static void b(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(190735);
    final String str = Bv(paramString);
    com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(str));
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190724);
        String str2 = paramString;
        String str1 = com.tencent.mm.sdk.f.b.ahd("mp4");
        com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(str1));
        if (com.tencent.mm.vfs.i.lC(str2, str1) >= 0L) {}
        while (!bt.isNullOrNil(str1))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(190724);
          return;
          str1 = null;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(190724);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190725);
        p.b(this.hTV, paramString, str);
        AppMethodBeat.o(190725);
      }
    };
    if (new e(str).fhT().canWrite())
    {
      local6.run();
      AppMethodBeat.o(190735);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local6, paramString);
      AppMethodBeat.o(190735);
      return;
    }
    paramString.run();
    AppMethodBeat.o(190735);
  }
  
  public static void c(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(190737);
    Object localObject = new e(paramString).getName();
    localObject = new e(com.tencent.mm.loader.j.b.ajd(), (String)localObject);
    ((e)localObject).fhT().mkdirs();
    final String str = q.B(((e)localObject).fhU());
    Runnable local8 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190726);
        if (!bt.isNullOrNil(p.Bw(paramString)))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(190726);
          return;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(190726);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190727);
        p.b(this.hTV, paramString, str);
        AppMethodBeat.o(190727);
      }
    };
    if (((e)localObject).fhT().canWrite())
    {
      local8.run();
      AppMethodBeat.o(190737);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local8, paramString);
      AppMethodBeat.o(190737);
      return;
    }
    paramString.run();
    AppMethodBeat.o(190737);
  }
  
  public static abstract interface a
  {
    public abstract void bv(String paramString1, String paramString2);
    
    public abstract void bw(String paramString1, String paramString2);
  }
  
  static abstract class b
    implements PermissionHelper.e, PermissionHelper.f
  {
    private final WeakReference<Context> avO;
    private String hUb = null;
    
    b(Context paramContext)
    {
      this.avO = new WeakReference(paramContext);
    }
    
    public final void Bx(String paramString)
    {
      this.hUb = paramString;
      aGs();
    }
    
    public final void a(final PermissionHelper.c paramc, String paramString)
    {
      this.hUb = paramString;
      paramString = (Context)this.avO.get();
      if (paramString == null)
      {
        ad.e("MicroMsg.ExportFileUtil", "[-] context is recycled, skip rest steps.");
        return;
      }
      String str = paramString.getString(2131761885);
      com.tencent.mm.ui.base.h.a(paramString, paramString.getString(2131761738), str, paramString.getString(2131760598), paramString.getString(2131761861), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190728);
          paramAnonymousDialogInterface.dismiss();
          paramc.a(p.b.this);
          AppMethodBeat.o(190728);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(190729);
          paramAnonymousDialogInterface.dismiss();
          p.b.this.aGt();
          AppMethodBeat.o(190729);
        }
      });
    }
    
    protected abstract void aGs();
    
    protected abstract void aGt();
    
    public final void aGu()
    {
      if (PermissionHelper.aBd(this.hUb))
      {
        aGs();
        return;
      }
      aGt();
    }
    
    public final void aGv()
    {
      aGt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.p
 * JD-Core Version:    0.7.0.1
 */