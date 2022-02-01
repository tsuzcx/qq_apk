package com.tencent.mm.aj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static int hPn;
  private static int hPo;
  static final Map<String, Integer> hPp;
  private static a hPt;
  private l<a, String> hPq;
  private final List<WeakReference<a>> hPr;
  private final a hPs;
  
  static
  {
    AppMethodBeat.i(150268);
    hPn = 100;
    hPo = 100;
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    hPp = localConcurrentHashMap;
    localConcurrentHashMap.put("voipapp", Integer.valueOf(2131690041));
    hPp.put("qqmail", Integer.valueOf(2131690034));
    hPp.put("fmessage", Integer.valueOf(2131690021));
    hPp.put("floatbottle", Integer.valueOf(2131690014));
    hPp.put("lbsapp", Integer.valueOf(2131690028));
    hPp.put("shakeapp", Integer.valueOf(2131690038));
    hPp.put("medianote", Integer.valueOf(2131690026));
    hPp.put("qqfriend", Integer.valueOf(2131690033));
    hPp.put("masssendapp", Integer.valueOf(2131690025));
    hPp.put("feedsapp", Integer.valueOf(2131690020));
    hPp.put("facebookapp", Integer.valueOf(2131690019));
    hPp.put("newsapp", Integer.valueOf(2131690036));
    hPp.put("helper_entry", Integer.valueOf(2131690030));
    hPp.put("voicevoipapp", Integer.valueOf(2131690040));
    hPp.put("voiceinputapp", Integer.valueOf(2131690039));
    hPp.put("findersayhisessionholder", Integer.valueOf(2131235059));
    hPp.put("officialaccounts", Integer.valueOf(2131690015));
    hPp.put("service_officialaccounts", Integer.valueOf(2131690037));
    hPp.put("linkedinplugin", Integer.valueOf(2131690024));
    hPp.put("notifymessage", Integer.valueOf(2131690029));
    hPp.put("appbrandcustomerservicemsg", Integer.valueOf(2131690012));
    hPp.put("appbrand_notify_message", Integer.valueOf(2131690011));
    hPp.put("downloaderapp", Integer.valueOf(2131690018));
    hPt = new a(hPo);
    AppMethodBeat.o(150268);
  }
  
  public e()
  {
    AppMethodBeat.i(150243);
    this.hPq = new l() {};
    this.hPr = new ArrayList();
    this.hPs = new a()
    {
      public final void DG(String paramAnonymousString)
      {
        AppMethodBeat.i(150238);
        ae.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramAnonymousString, Integer.valueOf(e.a(e.this).size()), Integer.valueOf(e.a(e.this).size()) });
        ArrayList localArrayList = new ArrayList();
        for (;;)
        {
          Iterator localIterator;
          synchronized (e.a(e.this))
          {
            localIterator = e.a(e.this).iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            Object localObject2 = (WeakReference)localIterator.next();
            if (localObject2 == null) {
              continue;
            }
            localObject2 = (e.a)((WeakReference)localObject2).get();
            if (localObject2 != null) {
              localArrayList.add(localObject2);
            }
          }
          localIterator.remove();
        }
        ??? = localArrayList.iterator();
        while (((Iterator)???).hasNext()) {
          ((e.a)((Iterator)???).next()).DG(paramAnonymousString);
        }
        AppMethodBeat.o(150238);
      }
    };
    reset();
    this.hPq.a(this.hPs, null);
    AppMethodBeat.o(150243);
  }
  
  public static Bitmap DA(String paramString)
  {
    AppMethodBeat.i(150250);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    Object localObject = hPt;
    if (((a)localObject).hOQ != null) {}
    for (localObject = (Bitmap)((a)localObject).hOQ.aL(paramString); localObject == null; localObject = (Bitmap)g.a.U("avatar_cache", paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = hPt;
      if (((a)localObject).hOQ != null) {
        ((a)localObject).hOQ.remove(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(150250);
        return null;
        g.a.V("avatar_cache", paramString);
      }
    }
    AppMethodBeat.o(150250);
    return localObject;
  }
  
  public static boolean DB(String paramString)
  {
    AppMethodBeat.i(150256);
    paramString = J(paramString, false);
    if ((o.fB(paramString)) || (o.fB(paramString + ".bm")))
    {
      AppMethodBeat.o(150256);
      return true;
    }
    AppMethodBeat.o(150256);
    return false;
  }
  
  public static Bitmap DC(String paramString)
  {
    AppMethodBeat.i(150258);
    paramString = DF(J(paramString, false));
    AppMethodBeat.o(150258);
    return paramString;
  }
  
  public static Bitmap DD(String paramString)
  {
    AppMethodBeat.i(150264);
    ae.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150264);
      return null;
    }
    paramString = h.aO(J(paramString, true), 1080, 1080);
    AppMethodBeat.o(150264);
    return paramString;
  }
  
  public static Bitmap DE(String paramString)
  {
    AppMethodBeat.i(150265);
    int i = 0;
    if (hPp.containsKey(paramString)) {
      i = ((Integer)hPp.get(paramString)).intValue();
    }
    if (i != 0) {
      p.aEM();
    }
    for (paramString = com.tencent.mm.compatible.e.a.decodeResource(p.getContext().getResources(), i);; paramString = null)
    {
      paramString = h.a(paramString, true, 1.0F, true);
      AppMethodBeat.o(150265);
      return paramString;
    }
  }
  
  public static Bitmap DF(String paramString)
  {
    AppMethodBeat.i(150267);
    if (o.fB(paramString)) {}
    for (Bitmap localBitmap2 = h.decodeFile(paramString, null);; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = b.DI(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (J(localBitmap1))
      {
        i = localBitmap1.getWidth();
        j = localBitmap1.getHeight();
        paramString = localBitmap1;
        if (i != j) {
          if (i <= j) {
            break label92;
          }
        }
      }
      label92:
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); J(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        AppMethodBeat.o(150267);
        return paramString;
      }
      AppMethodBeat.o(150267);
      return null;
    }
  }
  
  public static String J(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150254);
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    o.aZI(o.aZU(paramString));
    AppMethodBeat.o(150254);
    return paramString;
  }
  
  private static boolean J(Bitmap paramBitmap)
  {
    AppMethodBeat.i(150266);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(150266);
      return true;
    }
    AppMethodBeat.o(150266);
    return false;
  }
  
  public static String K(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150255);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150255);
      return null;
    }
    paramString = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.ajR().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    if (o.aZI(o.aZU(paramString)))
    {
      AppMethodBeat.o(150255);
      return paramString;
    }
    AppMethodBeat.o(150255);
    return null;
  }
  
  public static boolean L(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150257);
    String str = J(paramString, paramBoolean);
    ae.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = o.deleteFile(str);
    boolean bool1 = bool2;
    if (!paramBoolean) {
      bool1 = bool2 | b.remove(str);
    }
    AppMethodBeat.o(150257);
    return bool1;
  }
  
  private static StringBuilder a(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150253);
    paramString = com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
    paramStringBuilder.append(paramString.substring(0, 2)).append('/').append(paramString.substring(2, 4)).append('/').append("user_");
    if (paramBoolean) {
      paramStringBuilder.append("hd_");
    }
    paramStringBuilder = paramStringBuilder.append(paramString).append(".png");
    AppMethodBeat.o(150253);
    return paramStringBuilder;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(150242);
    try
    {
      paramImageView.setImageBitmap(h.a(com.tencent.mm.compatible.e.a.decodeResource(paramContext.getResources(), paramInt), true, 1.0F));
      AppMethodBeat.o(150242);
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bu.o(paramContext) });
      AppMethodBeat.o(150242);
    }
  }
  
  private WeakReference<a> c(a parama)
  {
    AppMethodBeat.i(150246);
    List localList = this.hPr;
    int i = 0;
    try
    {
      while (i < this.hPr.size())
      {
        WeakReference localWeakReference = (WeakReference)this.hPr.get(i);
        if (localWeakReference != null)
        {
          a locala = (a)localWeakReference.get();
          if ((locala != null) && (locala.equals(parama))) {
            return localWeakReference;
          }
        }
        i += 1;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(150246);
    }
  }
  
  /* Error */
  public static Bitmap g(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 432
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: sipush 156
    //   10: sipush 156
    //   13: invokestatic 436	com/tencent/mm/sdk/platformtools/h:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   16: astore 5
    //   18: aload 5
    //   20: invokestatic 300	com/tencent/mm/aj/e:J	(Landroid/graphics/Bitmap;)Z
    //   23: ifne +27 -> 50
    //   26: ldc 237
    //   28: ldc_w 438
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokestatic 406	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: ldc_w 432
    //   45: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload 5
    //   52: invokevirtual 303	android/graphics/Bitmap:getWidth	()I
    //   55: istore_2
    //   56: aload 5
    //   58: invokevirtual 306	android/graphics/Bitmap:getHeight	()I
    //   61: istore_3
    //   62: aload 5
    //   64: astore 4
    //   66: iload_2
    //   67: iload_3
    //   68: if_icmpeq +23 -> 91
    //   71: iload_2
    //   72: iload_3
    //   73: if_icmple +81 -> 154
    //   76: aload 5
    //   78: iload_2
    //   79: iload_3
    //   80: isub
    //   81: iconst_2
    //   82: idiv
    //   83: iconst_0
    //   84: iload_3
    //   85: iload_3
    //   86: invokestatic 310	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   89: astore 4
    //   91: aload_0
    //   92: iconst_0
    //   93: invokestatic 210	com/tencent/mm/aj/e:J	(Ljava/lang/String;Z)Ljava/lang/String;
    //   96: astore 5
    //   98: aload 5
    //   100: iconst_0
    //   101: invokestatic 442	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   104: astore 6
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: aload_1
    //   113: iconst_0
    //   114: aload_1
    //   115: arraylength
    //   116: invokevirtual 448	java/io/OutputStream:write	([BII)V
    //   119: aload 6
    //   121: ifnull +8 -> 129
    //   124: aload 6
    //   126: invokevirtual 451	java/io/OutputStream:close	()V
    //   129: ldc 237
    //   131: ldc_w 453
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: aastore
    //   142: invokestatic 353	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: ldc_w 432
    //   148: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload 4
    //   153: areturn
    //   154: aload 5
    //   156: iconst_0
    //   157: iload_3
    //   158: iload_2
    //   159: isub
    //   160: iconst_2
    //   161: idiv
    //   162: iload_2
    //   163: iload_2
    //   164: invokestatic 310	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   167: astore 4
    //   169: goto -78 -> 91
    //   172: astore_1
    //   173: aconst_null
    //   174: astore 6
    //   176: aload 6
    //   178: astore 5
    //   180: ldc 237
    //   182: aload_1
    //   183: ldc_w 455
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_0
    //   193: aastore
    //   194: invokestatic 459	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload 6
    //   199: ifnull +8 -> 207
    //   202: aload 6
    //   204: invokevirtual 451	java/io/OutputStream:close	()V
    //   207: ldc_w 432
    //   210: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore 5
    //   219: aload 5
    //   221: ifnull +8 -> 229
    //   224: aload 5
    //   226: invokevirtual 451	java/io/OutputStream:close	()V
    //   229: ldc_w 432
    //   232: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: aload_0
    //   236: athrow
    //   237: astore_1
    //   238: goto -109 -> 129
    //   241: astore_0
    //   242: goto -35 -> 207
    //   245: astore_1
    //   246: goto -17 -> 229
    //   249: astore_0
    //   250: goto -31 -> 219
    //   253: astore_1
    //   254: goto -78 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString	String
    //   0	257	1	paramArrayOfByte	byte[]
    //   55	109	2	i	int
    //   61	99	3	j	int
    //   64	104	4	localObject1	Object
    //   16	209	5	localObject2	Object
    //   104	99	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   98	106	172	java/io/IOException
    //   98	106	215	finally
    //   124	129	237	java/io/IOException
    //   202	207	241	java/io/IOException
    //   224	229	245	java/io/IOException
    //   110	119	249	finally
    //   180	197	249	finally
    //   110	119	253	java/io/IOException
  }
  
  public static Bitmap o(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150263);
    ae.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150263);
      return null;
    }
    paramString = h.aO(J(paramString, true), paramInt1, paramInt2);
    AppMethodBeat.o(150263);
    return paramString;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(150249);
    if (hPt == null) {
      hPt = new a(hPo);
    }
    AppMethodBeat.o(150249);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150244);
    synchronized (this.hPr)
    {
      this.hPr.add(new WeakReference(parama));
      AppMethodBeat.o(150244);
      return;
    }
  }
  
  public final boolean aX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150261);
    try
    {
      BitmapFactory.Options localOptions = h.aRz(paramString1);
      int k = localOptions.outWidth;
      int m = localOptions.outHeight;
      int i;
      int j;
      if (m < k)
      {
        i = k * 156 / m;
        j = 156;
      }
      for (;;)
      {
        ae.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(1) });
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inSampleSize = 1;
        boolean bool = e(paramString2, h.decodeFile(paramString1, localOptions));
        AppMethodBeat.o(150261);
        return bool;
        j = m * 156 / k;
        i = 156;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bu.o(paramString1) });
      AppMethodBeat.o(150261);
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(150245);
    synchronized (this.hPr)
    {
      parama = c(parama);
      if (parama != null) {
        this.hPr.remove(parama);
      }
      AppMethodBeat.o(150245);
      return;
    }
  }
  
  public final Bitmap cA(Context paramContext)
  {
    AppMethodBeat.i(150252);
    paramContext.getResources();
    Bitmap localBitmap = DA("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!J(localBitmap))
    {
      paramContext = localBitmap;
      if (localBitmap != null)
      {
        ae.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", new Object[] { Boolean.valueOf(localBitmap.isRecycled()), "I_AM_NO_SDCARD_USER_NAME" });
        paramContext = h.a(localBitmap, true, 1.0F);
        d("I_AM_NO_SDCARD_USER_NAME", paramContext);
      }
    }
    AppMethodBeat.o(150252);
    return paramContext;
  }
  
  @Deprecated
  public final void d(a parama)
  {
    AppMethodBeat.i(150247);
    this.hPq.a(parama, Looper.getMainLooper());
    AppMethodBeat.o(150247);
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150251);
    hPt.c(paramString, paramBitmap);
    paramBitmap = a.a.InF;
    if (paramBitmap != null) {
      paramBitmap.UD(paramString);
    }
    this.hPq.dW(paramString);
    this.hPq.doNotify();
    ae.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
    AppMethodBeat.o(150251);
  }
  
  @Deprecated
  public final void e(a parama)
  {
    AppMethodBeat.i(150248);
    this.hPq.remove(parama);
    AppMethodBeat.o(150248);
  }
  
  /* Error */
  final boolean e(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc_w 559
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 300	com/tencent/mm/aj/e:J	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 559
    //   16: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 303	android/graphics/Bitmap:getWidth	()I
    //   25: sipush 156
    //   28: if_icmpne +107 -> 135
    //   31: aload_2
    //   32: invokevirtual 306	android/graphics/Bitmap:getHeight	()I
    //   35: sipush 156
    //   38: if_icmpne +97 -> 135
    //   41: aload_2
    //   42: astore 5
    //   44: aload_2
    //   45: astore 6
    //   47: aload 5
    //   49: ifnull +39 -> 88
    //   52: aload_2
    //   53: astore 6
    //   55: aload 5
    //   57: aload_2
    //   58: if_acmpeq +30 -> 88
    //   61: ldc 237
    //   63: ldc_w 561
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_2
    //   73: invokevirtual 562	java/lang/Object:toString	()Ljava/lang/String;
    //   76: aastore
    //   77: invokestatic 353	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_2
    //   81: invokevirtual 565	android/graphics/Bitmap:recycle	()V
    //   84: aload 5
    //   86: astore 6
    //   88: aload_1
    //   89: iconst_0
    //   90: invokestatic 210	com/tencent/mm/aj/e:J	(Ljava/lang/String;Z)Ljava/lang/String;
    //   93: astore_2
    //   94: aload_2
    //   95: iconst_0
    //   96: invokestatic 442	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   99: astore_2
    //   100: aload 6
    //   102: getstatic 571	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   105: bipush 100
    //   107: aload_2
    //   108: invokevirtual 575	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 451	java/io/OutputStream:close	()V
    //   120: aload_0
    //   121: aload_1
    //   122: aload 6
    //   124: invokevirtual 521	com/tencent/mm/aj/e:d	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   127: ldc_w 559
    //   130: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_1
    //   134: ireturn
    //   135: aload_2
    //   136: invokevirtual 303	android/graphics/Bitmap:getWidth	()I
    //   139: istore_3
    //   140: aload_2
    //   141: invokevirtual 306	android/graphics/Bitmap:getHeight	()I
    //   144: istore 4
    //   146: iload_3
    //   147: iload 4
    //   149: if_icmpeq +61 -> 210
    //   152: iload_3
    //   153: iload 4
    //   155: if_icmple +37 -> 192
    //   158: aload_2
    //   159: iload_3
    //   160: iload 4
    //   162: isub
    //   163: iconst_2
    //   164: idiv
    //   165: iconst_0
    //   166: iload 4
    //   168: iload 4
    //   170: invokestatic 310	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   173: astore 5
    //   175: aload 5
    //   177: sipush 156
    //   180: sipush 156
    //   183: iconst_1
    //   184: invokestatic 579	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   187: astore 5
    //   189: goto -145 -> 44
    //   192: aload_2
    //   193: iconst_0
    //   194: iload 4
    //   196: iload_3
    //   197: isub
    //   198: iconst_2
    //   199: idiv
    //   200: iload_3
    //   201: iload_3
    //   202: invokestatic 310	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   205: astore 5
    //   207: goto -32 -> 175
    //   210: aload_2
    //   211: sipush 156
    //   214: sipush 156
    //   217: iconst_1
    //   218: invokestatic 579	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   221: astore 5
    //   223: goto -179 -> 44
    //   226: astore 5
    //   228: ldc 237
    //   230: ldc_w 581
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_1
    //   240: aastore
    //   241: invokestatic 406	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_2
    //   245: invokestatic 300	com/tencent/mm/aj/e:J	(Landroid/graphics/Bitmap;)Z
    //   248: ifeq +26 -> 274
    //   251: ldc 237
    //   253: ldc_w 561
    //   256: iconst_1
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_2
    //   263: invokevirtual 562	java/lang/Object:toString	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 353	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_2
    //   271: invokevirtual 565	android/graphics/Bitmap:recycle	()V
    //   274: ldc_w 559
    //   277: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iconst_0
    //   281: ireturn
    //   282: astore 5
    //   284: aconst_null
    //   285: astore_2
    //   286: ldc 237
    //   288: aload 5
    //   290: ldc_w 455
    //   293: iconst_1
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_1
    //   300: aastore
    //   301: invokestatic 459	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: aload_2
    //   305: ifnull +7 -> 312
    //   308: aload_2
    //   309: invokevirtual 451	java/io/OutputStream:close	()V
    //   312: ldc_w 559
    //   315: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: iconst_0
    //   319: ireturn
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_2
    //   323: aload_2
    //   324: ifnull +7 -> 331
    //   327: aload_2
    //   328: invokevirtual 451	java/io/OutputStream:close	()V
    //   331: ldc_w 559
    //   334: invokestatic 140	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   337: aload_1
    //   338: athrow
    //   339: astore_2
    //   340: goto -220 -> 120
    //   343: astore_1
    //   344: goto -32 -> 312
    //   347: astore_2
    //   348: goto -17 -> 331
    //   351: astore_1
    //   352: goto -29 -> 323
    //   355: astore_1
    //   356: goto -33 -> 323
    //   359: astore 5
    //   361: goto -75 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	e
    //   0	364	1	paramString	String
    //   0	364	2	paramBitmap	Bitmap
    //   139	63	3	i	int
    //   144	54	4	j	int
    //   42	180	5	localBitmap1	Bitmap
    //   226	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   282	7	5	localIOException1	java.io.IOException
    //   359	1	5	localIOException2	java.io.IOException
    //   45	78	6	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   135	146	226	java/lang/OutOfMemoryError
    //   158	175	226	java/lang/OutOfMemoryError
    //   175	189	226	java/lang/OutOfMemoryError
    //   192	207	226	java/lang/OutOfMemoryError
    //   210	223	226	java/lang/OutOfMemoryError
    //   94	100	282	java/io/IOException
    //   94	100	320	finally
    //   116	120	339	java/io/IOException
    //   308	312	343	java/io/IOException
    //   327	331	347	java/io/IOException
    //   100	112	351	finally
    //   286	304	355	finally
    //   100	112	359	java/io/IOException
  }
  
  public final boolean h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150260);
    paramArrayOfByte = g(paramString, paramArrayOfByte);
    if (!J(paramArrayOfByte))
    {
      AppMethodBeat.o(150260);
      return false;
    }
    d(paramString, paramArrayOfByte);
    AppMethodBeat.o(150260);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void DG(String paramString);
  }
  
  public static final class b
  {
    /* Error */
    public static boolean DH(String paramString)
    {
      // Byte code:
      //   0: ldc 12
      //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 22	com/tencent/mm/aj/e$b:DI	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   9: astore 4
      //   11: aload 4
      //   13: ifnull +11 -> 24
      //   16: aload 4
      //   18: invokevirtual 28	android/graphics/Bitmap:isRecycled	()Z
      //   21: ifeq +10 -> 31
      //   24: ldc 12
      //   26: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   29: iconst_0
      //   30: ireturn
      //   31: aconst_null
      //   32: astore_2
      //   33: aconst_null
      //   34: astore_1
      //   35: aload_0
      //   36: iconst_0
      //   37: invokestatic 37	com/tencent/mm/vfs/o:db	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   40: astore_3
      //   41: aload_3
      //   42: astore_1
      //   43: aload_3
      //   44: astore_2
      //   45: aload 4
      //   47: getstatic 43	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
      //   50: bipush 100
      //   52: aload_3
      //   53: invokevirtual 47	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   56: pop
      //   57: aload_3
      //   58: astore_1
      //   59: aload_3
      //   60: astore_2
      //   61: new 49	java/lang/StringBuilder
      //   64: dup
      //   65: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   68: aload_0
      //   69: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: ldc 59
      //   74: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokestatic 66	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
      //   83: pop
      //   84: aload_3
      //   85: ifnull +7 -> 92
      //   88: aload_3
      //   89: invokevirtual 71	java/io/OutputStream:close	()V
      //   92: ldc 12
      //   94: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: iconst_1
      //   98: ireturn
      //   99: astore_3
      //   100: aload_1
      //   101: astore_2
      //   102: ldc 73
      //   104: aload_3
      //   105: ldc 75
      //   107: iconst_1
      //   108: anewarray 4	java/lang/Object
      //   111: dup
      //   112: iconst_0
      //   113: aload_0
      //   114: aastore
      //   115: invokestatic 81	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   118: aload_1
      //   119: ifnull +7 -> 126
      //   122: aload_1
      //   123: invokevirtual 71	java/io/OutputStream:close	()V
      //   126: ldc 12
      //   128: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   131: iconst_0
      //   132: ireturn
      //   133: astore_0
      //   134: aload_2
      //   135: ifnull +7 -> 142
      //   138: aload_2
      //   139: invokevirtual 71	java/io/OutputStream:close	()V
      //   142: ldc 12
      //   144: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   147: aload_0
      //   148: athrow
      //   149: astore_0
      //   150: goto -58 -> 92
      //   153: astore_0
      //   154: goto -28 -> 126
      //   157: astore_1
      //   158: goto -16 -> 142
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	161	0	paramString	String
      //   34	89	1	localObject1	Object
      //   157	1	1	localIOException1	java.io.IOException
      //   32	107	2	localObject2	Object
      //   40	49	3	localOutputStream	java.io.OutputStream
      //   99	6	3	localIOException2	java.io.IOException
      //   9	37	4	localBitmap	Bitmap
      // Exception table:
      //   from	to	target	type
      //   35	41	99	java/io/IOException
      //   45	57	99	java/io/IOException
      //   61	84	99	java/io/IOException
      //   35	41	133	finally
      //   45	57	133	finally
      //   61	84	133	finally
      //   102	118	133	finally
      //   88	92	149	java/io/IOException
      //   122	126	153	java/io/IOException
      //   138	142	157	java/io/IOException
    }
    
    /* Error */
    public static Bitmap DI(String paramString)
    {
      // Byte code:
      //   0: ldc 87
      //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 49	java/lang/StringBuilder
      //   8: dup
      //   9: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   12: aload_0
      //   13: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: ldc 59
      //   18: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   21: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   24: astore 10
      //   26: iconst_1
      //   27: istore_2
      //   28: aconst_null
      //   29: astore 7
      //   31: aconst_null
      //   32: astore 9
      //   34: aconst_null
      //   35: astore 8
      //   37: aconst_null
      //   38: astore 6
      //   40: aload 10
      //   42: invokestatic 90	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
      //   45: ifne +26 -> 71
      //   48: ldc 73
      //   50: ldc 92
      //   52: iconst_1
      //   53: anewarray 4	java/lang/Object
      //   56: dup
      //   57: iconst_0
      //   58: aload 10
      //   60: aastore
      //   61: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   64: ldc 87
      //   66: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   69: aconst_null
      //   70: areturn
      //   71: aload 10
      //   73: invokestatic 100	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
      //   76: l2i
      //   77: istore_1
      //   78: iload_1
      //   79: ifle +15 -> 94
      //   82: iload_1
      //   83: ldc 101
      //   85: if_icmpeq +44 -> 129
      //   88: iload_1
      //   89: ldc 102
      //   91: if_icmpeq +38 -> 129
      //   94: aload_0
      //   95: invokestatic 105	com/tencent/mm/aj/e$b:remove	(Ljava/lang/String;)Z
      //   98: pop
      //   99: ldc 73
      //   101: ldc 107
      //   103: iconst_2
      //   104: anewarray 4	java/lang/Object
      //   107: dup
      //   108: iconst_0
      //   109: iload_1
      //   110: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   113: aastore
      //   114: dup
      //   115: iconst_1
      //   116: aload 10
      //   118: aastore
      //   119: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   122: ldc 87
      //   124: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   127: aconst_null
      //   128: areturn
      //   129: aload 10
      //   131: invokestatic 120	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   134: astore 5
      //   136: aload 9
      //   138: astore 6
      //   140: aload 8
      //   142: astore 7
      //   144: aload 5
      //   146: invokestatic 126	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
      //   149: astore 8
      //   151: aload 8
      //   153: astore 6
      //   155: aload 8
      //   157: astore 7
      //   159: ldc 101
      //   161: invokestatic 132	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   164: astore 9
      //   166: aload 8
      //   168: astore 6
      //   170: aload 8
      //   172: astore 7
      //   174: aload 8
      //   176: aload 9
      //   178: invokeinterface 138 2 0
      //   183: pop
      //   184: aload 8
      //   186: astore 6
      //   188: aload 8
      //   190: astore 7
      //   192: aload 9
      //   194: iconst_0
      //   195: invokevirtual 142	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   198: pop
      //   199: iload_1
      //   200: ldc 102
      //   202: if_icmpne +145 -> 347
      //   205: aload 8
      //   207: astore 6
      //   209: aload 8
      //   211: astore 7
      //   213: bipush 16
      //   215: invokestatic 132	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   218: astore 11
      //   220: aload 8
      //   222: astore 6
      //   224: aload 8
      //   226: astore 7
      //   228: aload 8
      //   230: aload 11
      //   232: invokeinterface 138 2 0
      //   237: pop
      //   238: aload 8
      //   240: astore 6
      //   242: aload 8
      //   244: astore 7
      //   246: aload 11
      //   248: iconst_0
      //   249: invokevirtual 146	java/nio/ByteBuffer:getLong	(I)J
      //   252: lstore_3
      //   253: lload_3
      //   254: lconst_1
      //   255: lcmp
      //   256: ifeq +89 -> 345
      //   259: aload 8
      //   261: astore 6
      //   263: aload 8
      //   265: astore 7
      //   267: ldc 73
      //   269: ldc 148
      //   271: iconst_3
      //   272: anewarray 4	java/lang/Object
      //   275: dup
      //   276: iconst_0
      //   277: lload_3
      //   278: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   281: aastore
      //   282: dup
      //   283: iconst_1
      //   284: iload_1
      //   285: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   288: aastore
      //   289: dup
      //   290: iconst_2
      //   291: aload 10
      //   293: aastore
      //   294: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   297: aload 8
      //   299: astore 6
      //   301: aload 8
      //   303: astore 7
      //   305: aload 8
      //   307: invokeinterface 154 1 0
      //   312: aload 8
      //   314: astore 6
      //   316: aload 8
      //   318: astore 7
      //   320: aload 5
      //   322: invokevirtual 157	java/io/InputStream:close	()V
      //   325: aload 8
      //   327: astore 6
      //   329: aload 8
      //   331: astore 7
      //   333: aload_0
      //   334: invokestatic 105	com/tencent/mm/aj/e$b:remove	(Ljava/lang/String;)Z
      //   337: pop
      //   338: ldc 87
      //   340: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   343: aconst_null
      //   344: areturn
      //   345: iconst_0
      //   346: istore_2
      //   347: aload 8
      //   349: astore 6
      //   351: aload 8
      //   353: astore 7
      //   355: ldc 73
      //   357: ldc 159
      //   359: iconst_3
      //   360: anewarray 4	java/lang/Object
      //   363: dup
      //   364: iconst_0
      //   365: iload_1
      //   366: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   369: aastore
      //   370: dup
      //   371: iconst_1
      //   372: iload_2
      //   373: invokestatic 164	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   376: aastore
      //   377: dup
      //   378: iconst_2
      //   379: aload 10
      //   381: aastore
      //   382: invokestatic 96	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   385: aload 8
      //   387: astore 6
      //   389: aload 8
      //   391: astore 7
      //   393: aload 8
      //   395: invokeinterface 154 1 0
      //   400: aload 5
      //   402: astore 6
      //   404: aload 5
      //   406: astore 7
      //   408: aload 5
      //   410: invokevirtual 157	java/io/InputStream:close	()V
      //   413: aconst_null
      //   414: astore 5
      //   416: aconst_null
      //   417: astore_0
      //   418: aload_0
      //   419: astore 6
      //   421: aload 5
      //   423: astore 7
      //   425: bipush 96
      //   427: bipush 96
      //   429: getstatic 170	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   432: invokestatic 174	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
      //   435: astore 8
      //   437: aload_0
      //   438: astore 6
      //   440: aload 5
      //   442: astore 7
      //   444: aload 8
      //   446: aload 9
      //   448: invokevirtual 178	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
      //   451: iload_2
      //   452: ifeq +71 -> 523
      //   455: aload_0
      //   456: astore 6
      //   458: aload 5
      //   460: astore 7
      //   462: aload 8
      //   464: bipush 9
      //   466: bipush 9
      //   468: bipush 78
      //   470: bipush 78
      //   472: invokestatic 181	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
      //   475: astore 9
      //   477: aload_0
      //   478: astore 6
      //   480: aload 5
      //   482: astore 7
      //   484: ldc 73
      //   486: ldc 183
      //   488: iconst_1
      //   489: anewarray 4	java/lang/Object
      //   492: dup
      //   493: iconst_0
      //   494: aload 8
      //   496: invokevirtual 184	java/lang/Object:toString	()Ljava/lang/String;
      //   499: aastore
      //   500: invokestatic 186	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   503: aload_0
      //   504: astore 6
      //   506: aload 5
      //   508: astore 7
      //   510: aload 8
      //   512: invokevirtual 189	android/graphics/Bitmap:recycle	()V
      //   515: ldc 87
      //   517: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   520: aload 9
      //   522: areturn
      //   523: ldc 87
      //   525: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   528: aload 8
      //   530: areturn
      //   531: astore 7
      //   533: aconst_null
      //   534: astore 5
      //   536: aload 6
      //   538: astore_0
      //   539: aload 7
      //   541: astore 6
      //   543: ldc 73
      //   545: ldc 191
      //   547: iconst_2
      //   548: anewarray 4	java/lang/Object
      //   551: dup
      //   552: iconst_0
      //   553: aload 6
      //   555: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   558: aastore
      //   559: dup
      //   560: iconst_1
      //   561: aload 10
      //   563: aastore
      //   564: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   567: aload_0
      //   568: ifnull +9 -> 577
      //   571: aload_0
      //   572: invokeinterface 154 1 0
      //   577: aload 5
      //   579: ifnull +8 -> 587
      //   582: aload 5
      //   584: invokevirtual 157	java/io/InputStream:close	()V
      //   587: ldc 87
      //   589: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   592: aconst_null
      //   593: areturn
      //   594: astore 6
      //   596: aconst_null
      //   597: astore 5
      //   599: aload 7
      //   601: astore_0
      //   602: aload 6
      //   604: astore 7
      //   606: ldc 73
      //   608: ldc 196
      //   610: iconst_2
      //   611: anewarray 4	java/lang/Object
      //   614: dup
      //   615: iconst_0
      //   616: aload 7
      //   618: invokevirtual 197	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   621: aastore
      //   622: dup
      //   623: iconst_1
      //   624: aload 10
      //   626: aastore
      //   627: invokestatic 116	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   630: goto -63 -> 567
      //   633: astore_0
      //   634: goto -47 -> 587
      //   637: astore 7
      //   639: aload 6
      //   641: astore_0
      //   642: goto -36 -> 606
      //   645: astore 7
      //   647: aconst_null
      //   648: astore_0
      //   649: aload 6
      //   651: astore 5
      //   653: goto -47 -> 606
      //   656: astore 6
      //   658: aload 7
      //   660: astore_0
      //   661: goto -118 -> 543
      //   664: astore 6
      //   666: aconst_null
      //   667: astore_0
      //   668: aload 7
      //   670: astore 5
      //   672: goto -129 -> 543
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	675	0	paramString	String
      //   77	289	1	i	int
      //   27	425	2	bool	boolean
      //   252	26	3	l	long
      //   134	537	5	localObject1	Object
      //   38	516	6	localObject2	Object
      //   594	56	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
      //   656	1	6	localException1	Exception
      //   664	1	6	localException2	Exception
      //   29	480	7	localObject3	Object
      //   531	69	7	localException3	Exception
      //   604	13	7	localObject4	Object
      //   637	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
      //   645	24	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
      //   35	494	8	localObject5	Object
      //   32	489	9	localObject6	Object
      //   24	601	10	str	String
      //   218	29	11	localByteBuffer	java.nio.ByteBuffer
      // Exception table:
      //   from	to	target	type
      //   40	64	531	java/lang/Exception
      //   71	78	531	java/lang/Exception
      //   94	122	531	java/lang/Exception
      //   129	136	531	java/lang/Exception
      //   40	64	594	java/lang/OutOfMemoryError
      //   71	78	594	java/lang/OutOfMemoryError
      //   94	122	594	java/lang/OutOfMemoryError
      //   129	136	594	java/lang/OutOfMemoryError
      //   571	577	633	java/lang/Exception
      //   582	587	633	java/lang/Exception
      //   144	151	637	java/lang/OutOfMemoryError
      //   159	166	637	java/lang/OutOfMemoryError
      //   174	184	637	java/lang/OutOfMemoryError
      //   192	199	637	java/lang/OutOfMemoryError
      //   213	220	637	java/lang/OutOfMemoryError
      //   228	238	637	java/lang/OutOfMemoryError
      //   246	253	637	java/lang/OutOfMemoryError
      //   267	297	637	java/lang/OutOfMemoryError
      //   305	312	637	java/lang/OutOfMemoryError
      //   320	325	637	java/lang/OutOfMemoryError
      //   333	338	637	java/lang/OutOfMemoryError
      //   355	385	637	java/lang/OutOfMemoryError
      //   393	400	637	java/lang/OutOfMemoryError
      //   408	413	645	java/lang/OutOfMemoryError
      //   425	437	645	java/lang/OutOfMemoryError
      //   444	451	645	java/lang/OutOfMemoryError
      //   462	477	645	java/lang/OutOfMemoryError
      //   484	503	645	java/lang/OutOfMemoryError
      //   510	515	645	java/lang/OutOfMemoryError
      //   144	151	656	java/lang/Exception
      //   159	166	656	java/lang/Exception
      //   174	184	656	java/lang/Exception
      //   192	199	656	java/lang/Exception
      //   213	220	656	java/lang/Exception
      //   228	238	656	java/lang/Exception
      //   246	253	656	java/lang/Exception
      //   267	297	656	java/lang/Exception
      //   305	312	656	java/lang/Exception
      //   320	325	656	java/lang/Exception
      //   333	338	656	java/lang/Exception
      //   355	385	656	java/lang/Exception
      //   393	400	656	java/lang/Exception
      //   408	413	664	java/lang/Exception
      //   425	437	664	java/lang/Exception
      //   444	451	664	java/lang/Exception
      //   462	477	664	java/lang/Exception
      //   484	503	664	java/lang/Exception
      //   510	515	664	java/lang/Exception
    }
    
    static boolean remove(String paramString)
    {
      AppMethodBeat.i(150241);
      o.deleteFile(paramString + ".bm");
      o.deleteFile(paramString);
      AppMethodBeat.o(150241);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.e
 * JD-Core Version:    0.7.0.1
 */