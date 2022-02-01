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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.lang.ref.WeakReference;

public final class p
{
  public static String FA(String paramString)
  {
    AppMethodBeat.i(192633);
    String str = new e(paramString).getName();
    e locale1 = new e(com.tencent.mm.loader.j.b.aqd(), str);
    Object localObject = locale1;
    int i = 2;
    for (;;)
    {
      if (!((e)localObject).exists())
      {
        if (i > 2) {
          ac.w("MicroMsg.ExportFileUtil", "[!] dest file [%s] exists, rename to [%s]", new Object[] { q.B(((e)localObject).fxV()), q.B(((e)localObject).fxV()) });
        }
        ((e)localObject).fxU().mkdirs();
        localObject = q.B(((e)localObject).fxV());
        ac.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDir, src: %s, dest: %s", new Object[] { paramString, localObject });
      }
      try
      {
        if (com.tencent.mm.vfs.i.lZ(paramString, (String)localObject) >= 0L) {}
        for (bool = com.tencent.mm.vfs.i.eA((String)localObject);; bool = false)
        {
          if (!bool) {
            break label297;
          }
          AppMethodBeat.o(192633);
          return localObject;
          e locale2 = locale1.fxU();
          StringBuilder localStringBuilder = new StringBuilder();
          int j = str.lastIndexOf('.');
          if (j < 0)
          {
            localObject = str;
            label184:
            localStringBuilder = localStringBuilder.append((String)localObject).append("(").append(i).append(")");
            j = str.lastIndexOf('.');
            if (j >= 0) {
              break label263;
            }
          }
          label263:
          for (localObject = "";; localObject = str.substring(j))
          {
            localObject = new e(locale2, (String)localObject);
            i += 1;
            break;
            localObject = str.substring(0, j);
            break label184;
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.ExportFileUtil", paramString, "[-] Exception ocurred.", new Object[0]);
          boolean bool = false;
        }
        label297:
        AppMethodBeat.o(192633);
      }
    }
    return null;
  }
  
  private static String Fz(String paramString)
  {
    AppMethodBeat.i(192629);
    String str = com.tencent.mm.vfs.i.VW(paramString);
    paramString = str;
    if (bs.isNullOrNil(str)) {
      paramString = "jpg";
    }
    paramString = com.tencent.mm.sdk.f.b.alY(paramString);
    AppMethodBeat.o(192629);
    return paramString;
  }
  
  /* Error */
  public static String I(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 175
    //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 177	com/tencent/mm/platformtools/p:Fz	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore 6
    //   11: ldc 67
    //   13: ldc 179
    //   15: iconst_2
    //   16: anewarray 4	java/lang/Object
    //   19: dup
    //   20: iconst_0
    //   21: aload_1
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: aload 6
    //   27: aastore
    //   28: invokestatic 96	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload 6
    //   33: invokestatic 182	com/tencent/mm/vfs/i:aSs	(Ljava/lang/String;)Ljava/lang/String;
    //   36: invokestatic 185	com/tencent/mm/vfs/i:aSh	(Ljava/lang/String;)Z
    //   39: pop
    //   40: aload_1
    //   41: aload 6
    //   43: invokestatic 102	com/tencent/mm/vfs/i:lZ	(Ljava/lang/String;Ljava/lang/String;)J
    //   46: lconst_0
    //   47: lcmp
    //   48: iflt +147 -> 195
    //   51: aload 6
    //   53: invokestatic 190	com/tencent/mm/sdk/platformtools/MMNativeJpeg:isProgressive	(Ljava/lang/String;)Z
    //   56: ifeq +168 -> 224
    //   59: aload 6
    //   61: invokestatic 196	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:ce	(Ljava/lang/String;)I
    //   64: istore_3
    //   65: aload 6
    //   67: invokestatic 200	com/tencent/mm/sdk/platformtools/MMNativeJpeg:decodeAsBitmap	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   70: astore 5
    //   72: aload 5
    //   74: ifnull +145 -> 219
    //   77: iload_3
    //   78: i2f
    //   79: fstore_2
    //   80: aload 5
    //   82: fload_2
    //   83: invokestatic 205	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   86: astore_1
    //   87: aload_1
    //   88: astore 5
    //   90: getstatic 211	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   93: astore 7
    //   95: aload 6
    //   97: iconst_0
    //   98: invokestatic 215	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   101: astore_1
    //   102: aload_1
    //   103: astore 4
    //   105: aload 5
    //   107: aload 7
    //   109: bipush 80
    //   111: aload_1
    //   112: invokevirtual 221	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   115: pop
    //   116: aload_1
    //   117: invokestatic 225	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   120: iconst_1
    //   121: istore_3
    //   122: iload_3
    //   123: ifeq +9 -> 132
    //   126: aload 6
    //   128: aload_0
    //   129: invokestatic 229	com/tencent/mm/sdk/f/b:k	(Ljava/lang/String;Landroid/content/Context;)V
    //   132: iload_3
    //   133: ifeq +67 -> 200
    //   136: ldc 175
    //   138: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload 6
    //   143: areturn
    //   144: astore_1
    //   145: ldc 67
    //   147: aload_1
    //   148: ldc 231
    //   150: iconst_0
    //   151: anewarray 4	java/lang/Object
    //   154: invokestatic 152	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: goto -67 -> 90
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_1
    //   164: astore 4
    //   166: aload 6
    //   168: invokestatic 234	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   171: pop
    //   172: aload_1
    //   173: invokestatic 225	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   176: iconst_0
    //   177: istore_3
    //   178: goto -56 -> 122
    //   181: astore_0
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_1
    //   185: invokestatic 225	com/tencent/mm/sdk/platformtools/bs:d	(Ljava/io/Closeable;)V
    //   188: ldc 175
    //   190: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_0
    //   194: athrow
    //   195: iconst_0
    //   196: istore_3
    //   197: goto -75 -> 122
    //   200: ldc 175
    //   202: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aconst_null
    //   206: areturn
    //   207: astore_0
    //   208: aload 4
    //   210: astore_1
    //   211: goto -27 -> 184
    //   214: astore 4
    //   216: goto -53 -> 163
    //   219: aconst_null
    //   220: astore_1
    //   221: goto -105 -> 116
    //   224: iconst_1
    //   225: istore_3
    //   226: goto -104 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramContext	Context
    //   0	229	1	paramString	String
    //   79	4	2	f	float
    //   64	162	3	i	int
    //   103	106	4	str1	String
    //   214	1	4	localException	java.lang.Exception
    //   70	36	5	localObject	Object
    //   9	158	6	str2	String
    //   93	15	7	localCompressFormat	android.graphics.Bitmap.CompressFormat
    // Exception table:
    //   from	to	target	type
    //   80	87	144	java/lang/Exception
    //   59	72	160	java/lang/Exception
    //   90	102	160	java/lang/Exception
    //   145	157	160	java/lang/Exception
    //   59	72	181	finally
    //   80	87	181	finally
    //   90	102	181	finally
    //   145	157	181	finally
    //   105	116	207	finally
    //   166	172	207	finally
    //   105	116	214	java/lang/Exception
  }
  
  static void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(192627);
    if (paramRunnable == null)
    {
      AppMethodBeat.o(192627);
      return;
    }
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramRunnable.run();
      AppMethodBeat.o(192627);
      return;
    }
    com.tencent.e.h.JZN.aQ(paramRunnable);
    AppMethodBeat.o(192627);
  }
  
  public static void a(Context paramContext, final Runnable paramRunnable1, final Runnable paramRunnable2)
  {
    AppMethodBeat.i(192628);
    ac.i("MicroMsg.ExportFileUtil", "[+] Called requestStoragePermission, ctx: %s", new Object[] { paramContext });
    if (!(paramContext instanceof Activity))
    {
      ac.e("MicroMsg.ExportFileUtil", "[-] Context [%s] is not an ui context, regard as user denied since we can't ask him.");
      J(paramRunnable2);
      AppMethodBeat.o(192628);
      return;
    }
    PermissionHelper.aQ((Activity)paramContext).a(paramContext.getString(2131761885), paramContext.getString(2131761738), "android.permission.WRITE_EXTERNAL_STORAGE", new b(paramContext)
    {
      protected final void aNf()
      {
        AppMethodBeat.i(192617);
        p.J(paramRunnable1);
        AppMethodBeat.o(192617);
      }
      
      protected final void aNg()
      {
        AppMethodBeat.i(192618);
        p.J(paramRunnable2);
        AppMethodBeat.o(192618);
      }
    });
    AppMethodBeat.o(192628);
  }
  
  public static void a(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(192631);
    final String str = Fz(paramString);
    ac.i("MicroMsg.ExportFileUtil", "[+] Called exportImageWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(str));
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192619);
        if (!bs.isNullOrNil(p.I(this.val$context, paramString)))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(192619);
          return;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(192619);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192620);
        p.b(this.itZ, paramString, str);
        AppMethodBeat.o(192620);
      }
    };
    if (new e(str).fxU().canWrite())
    {
      local4.run();
      AppMethodBeat.o(192631);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local4, paramString);
      AppMethodBeat.o(192631);
      return;
    }
    paramString.run();
    AppMethodBeat.o(192631);
  }
  
  public static void b(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(192632);
    final String str = Fz(paramString);
    ac.i("MicroMsg.ExportFileUtil", "[+] Called exportVideoWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(str));
    Runnable local6 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192621);
        String str2 = paramString;
        String str1 = com.tencent.mm.sdk.f.b.alY("mp4");
        ac.i("MicroMsg.ExportFileUtil", "[+] Called exportVideo, src: %s, dest: %s", new Object[] { str2, str1 });
        com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(str1));
        if (com.tencent.mm.vfs.i.lZ(str2, str1) >= 0L) {}
        while (!bs.isNullOrNil(str1))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(192621);
          return;
          str1 = null;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(192621);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192622);
        p.b(this.itZ, paramString, str);
        AppMethodBeat.o(192622);
      }
    };
    if (new e(str).fxU().canWrite())
    {
      local6.run();
      AppMethodBeat.o(192632);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local6, paramString);
      AppMethodBeat.o(192632);
      return;
    }
    paramString.run();
    AppMethodBeat.o(192632);
  }
  
  public static void c(Context paramContext, final String paramString, final a parama)
  {
    AppMethodBeat.i(192634);
    Object localObject = new e(paramString).getName();
    localObject = new e(com.tencent.mm.loader.j.b.aqd(), (String)localObject);
    ((e)localObject).fxU().mkdirs();
    final String str = q.B(((e)localObject).fxV());
    ac.i("MicroMsg.ExportFileUtil", "[+] Called exportToPublicDownloadDirWithPermissionRequest, src: %s, dest: %s", new Object[] { paramString, str });
    Runnable local8 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192623);
        if (!bs.isNullOrNil(p.FA(paramString)))
        {
          p.a(parama, paramString, str);
          AppMethodBeat.o(192623);
          return;
        }
        p.b(parama, paramString, str);
        AppMethodBeat.o(192623);
      }
    };
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192624);
        p.b(this.itZ, paramString, str);
        AppMethodBeat.o(192624);
      }
    };
    if (((e)localObject).fxU().canWrite())
    {
      local8.run();
      AppMethodBeat.o(192634);
      return;
    }
    if ((paramContext instanceof Activity))
    {
      a(paramContext, local8, paramString);
      AppMethodBeat.o(192634);
      return;
    }
    paramString.run();
    AppMethodBeat.o(192634);
  }
  
  public static abstract interface a
  {
    public abstract void bD(String paramString1, String paramString2);
    
    public abstract void bE(String paramString1, String paramString2);
  }
  
  static abstract class b
    implements PermissionHelper.e, PermissionHelper.f
  {
    private String iuf = null;
    private final WeakReference<Context> mContextRef;
    
    b(Context paramContext)
    {
      this.mContextRef = new WeakReference(paramContext);
    }
    
    public final void FB(String paramString)
    {
      this.iuf = paramString;
      aNf();
    }
    
    public final void a(final PermissionHelper.c paramc, String paramString)
    {
      this.iuf = paramString;
      paramString = (Context)this.mContextRef.get();
      if (paramString == null)
      {
        ac.e("MicroMsg.ExportFileUtil", "[-] context is recycled, skip rest steps.");
        return;
      }
      String str = paramString.getString(2131761885);
      com.tencent.mm.ui.base.h.a(paramString, paramString.getString(2131761738), str, paramString.getString(2131760598), paramString.getString(2131761861), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(192625);
          paramAnonymousDialogInterface.dismiss();
          paramc.a(p.b.this);
          AppMethodBeat.o(192625);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(192626);
          paramAnonymousDialogInterface.dismiss();
          p.b.this.aNg();
          AppMethodBeat.o(192626);
        }
      });
    }
    
    protected abstract void aNf();
    
    protected abstract void aNg();
    
    public final void aNh()
    {
      if (PermissionHelper.aGv(this.iuf))
      {
        aNf();
        return;
      }
      aNg();
    }
    
    public final void aNi()
    {
      aNg();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.p
 * JD-Core Version:    0.7.0.1
 */