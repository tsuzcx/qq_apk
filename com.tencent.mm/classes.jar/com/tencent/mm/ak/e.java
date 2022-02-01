package com.tencent.mm.ak;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static int gTD;
  private static int gTE;
  static final Map<String, Integer> gTF;
  private static a gTJ;
  private l<a, String> gTG;
  private final List<WeakReference<a>> gTH;
  private final a gTI;
  
  static
  {
    AppMethodBeat.i(150268);
    gTD = 150;
    gTE = 150;
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    gTF = localConcurrentHashMap;
    localConcurrentHashMap.put("voipapp", Integer.valueOf(2131690041));
    gTF.put("qqmail", Integer.valueOf(2131690034));
    gTF.put("fmessage", Integer.valueOf(2131690021));
    gTF.put("floatbottle", Integer.valueOf(2131690014));
    gTF.put("lbsapp", Integer.valueOf(2131690028));
    gTF.put("shakeapp", Integer.valueOf(2131690038));
    gTF.put("medianote", Integer.valueOf(2131690026));
    gTF.put("qqfriend", Integer.valueOf(2131690033));
    gTF.put("masssendapp", Integer.valueOf(2131690025));
    gTF.put("feedsapp", Integer.valueOf(2131690020));
    gTF.put("facebookapp", Integer.valueOf(2131690019));
    gTF.put("newsapp", Integer.valueOf(2131690036));
    gTF.put("helper_entry", Integer.valueOf(2131690030));
    gTF.put("voicevoipapp", Integer.valueOf(2131690040));
    gTF.put("voiceinputapp", Integer.valueOf(2131690039));
    gTF.put("officialaccounts", Integer.valueOf(2131690015));
    gTF.put("service_officialaccounts", Integer.valueOf(2131690037));
    gTF.put("linkedinplugin", Integer.valueOf(2131690024));
    gTF.put("notifymessage", Integer.valueOf(2131690029));
    gTF.put("appbrandcustomerservicemsg", Integer.valueOf(2131690012));
    gTF.put("appbrand_notify_message", Integer.valueOf(2131690011));
    gTF.put("downloaderapp", Integer.valueOf(2131690018));
    gTJ = new a(gTE);
    AppMethodBeat.o(150268);
  }
  
  public e()
  {
    AppMethodBeat.i(150243);
    this.gTG = new l() {};
    this.gTH = new ArrayList();
    this.gTI = new a()
    {
      public final void vZ(String paramAnonymousString)
      {
        AppMethodBeat.i(150238);
        ad.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramAnonymousString, Integer.valueOf(e.a(e.this).size()), Integer.valueOf(e.a(e.this).size()) });
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
          ((e.a)((Iterator)???).next()).vZ(paramAnonymousString);
        }
        AppMethodBeat.o(150238);
      }
    };
    reset();
    this.gTG.a(this.gTI, null);
    AppMethodBeat.o(150243);
  }
  
  public static String I(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150254);
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    i.aMF(i.aMQ(paramString));
    AppMethodBeat.o(150254);
    return paramString;
  }
  
  private static boolean I(Bitmap paramBitmap)
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
  
  public static String J(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150255);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150255);
      return null;
    }
    paramString = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.afB().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    if (i.aMF(i.aMQ(paramString)))
    {
      AppMethodBeat.o(150255);
      return paramString;
    }
    AppMethodBeat.o(150255);
    return null;
  }
  
  public static boolean K(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150257);
    String str = I(paramString, paramBoolean);
    ad.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = i.deleteFile(str);
    boolean bool1 = bool2;
    if (!paramBoolean) {
      bool1 = bool2 | e.b.remove(str);
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
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.f.a(com.tencent.mm.compatible.e.a.decodeResource(paramContext.getResources(), paramInt), true, 1.0F));
      AppMethodBeat.o(150242);
      return;
    }
    catch (Exception paramContext)
    {
      ad.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bt.m(paramContext) });
      AppMethodBeat.o(150242);
    }
  }
  
  private WeakReference<a> c(a parama)
  {
    AppMethodBeat.i(150246);
    List localList = this.gTH;
    int i = 0;
    try
    {
      while (i < this.gTH.size())
      {
        WeakReference localWeakReference = (WeakReference)this.gTH.get(i);
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
    //   0: ldc_w 334
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: bipush 96
    //   9: bipush 96
    //   11: invokestatic 338	com/tencent/mm/sdk/platformtools/f:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   14: astore 5
    //   16: aload 5
    //   18: invokestatic 340	com/tencent/mm/ak/e:I	(Landroid/graphics/Bitmap;)Z
    //   21: ifne +27 -> 48
    //   24: ldc 224
    //   26: ldc_w 342
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: aastore
    //   37: invokestatic 305	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: ldc_w 334
    //   43: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aconst_null
    //   47: areturn
    //   48: aload 5
    //   50: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   53: istore_2
    //   54: aload 5
    //   56: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   59: istore_3
    //   60: aload 5
    //   62: astore 4
    //   64: iload_2
    //   65: iload_3
    //   66: if_icmpeq +23 -> 89
    //   69: iload_2
    //   70: iload_3
    //   71: if_icmple +81 -> 152
    //   74: aload 5
    //   76: iload_2
    //   77: iload_3
    //   78: isub
    //   79: iconst_2
    //   80: idiv
    //   81: iconst_0
    //   82: iload_3
    //   83: iload_3
    //   84: invokestatic 352	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   87: astore 4
    //   89: aload_0
    //   90: iconst_0
    //   91: invokestatic 222	com/tencent/mm/ak/e:I	(Ljava/lang/String;Z)Ljava/lang/String;
    //   94: astore 5
    //   96: aload 5
    //   98: iconst_0
    //   99: invokestatic 356	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   102: astore 6
    //   104: aload 6
    //   106: astore 5
    //   108: aload 6
    //   110: aload_1
    //   111: iconst_0
    //   112: aload_1
    //   113: arraylength
    //   114: invokevirtual 362	java/io/OutputStream:write	([BII)V
    //   117: aload 6
    //   119: ifnull +8 -> 127
    //   122: aload 6
    //   124: invokevirtual 365	java/io/OutputStream:close	()V
    //   127: ldc 224
    //   129: ldc_w 367
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_0
    //   139: aastore
    //   140: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: ldc_w 334
    //   146: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 4
    //   151: areturn
    //   152: aload 5
    //   154: iconst_0
    //   155: iload_3
    //   156: iload_2
    //   157: isub
    //   158: iconst_2
    //   159: idiv
    //   160: iload_2
    //   161: iload_2
    //   162: invokestatic 352	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   165: astore 4
    //   167: goto -78 -> 89
    //   170: astore_1
    //   171: aconst_null
    //   172: astore 6
    //   174: aload 6
    //   176: astore 5
    //   178: ldc 224
    //   180: aload_1
    //   181: ldc_w 369
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload_0
    //   191: aastore
    //   192: invokestatic 373	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 6
    //   197: ifnull +8 -> 205
    //   200: aload 6
    //   202: invokevirtual 365	java/io/OutputStream:close	()V
    //   205: ldc_w 334
    //   208: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aconst_null
    //   215: astore 5
    //   217: aload 5
    //   219: ifnull +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 365	java/io/OutputStream:close	()V
    //   227: ldc_w 334
    //   230: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_0
    //   234: athrow
    //   235: astore_1
    //   236: goto -109 -> 127
    //   239: astore_0
    //   240: goto -35 -> 205
    //   243: astore_1
    //   244: goto -17 -> 227
    //   247: astore_0
    //   248: goto -31 -> 217
    //   251: astore_1
    //   252: goto -78 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramString	String
    //   0	255	1	paramArrayOfByte	byte[]
    //   53	109	2	i	int
    //   59	99	3	j	int
    //   62	104	4	localObject1	Object
    //   14	209	5	localObject2	Object
    //   102	99	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   96	104	170	java/io/IOException
    //   96	104	213	finally
    //   122	127	235	java/io/IOException
    //   200	205	239	java/io/IOException
    //   222	227	243	java/io/IOException
    //   108	117	247	finally
    //   178	195	247	finally
    //   108	117	251	java/io/IOException
  }
  
  public static Bitmap m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150263);
    ad.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150263);
      return null;
    }
    paramString = com.tencent.mm.sdk.platformtools.f.aF(I(paramString, true), paramInt1, paramInt2);
    AppMethodBeat.o(150263);
    return paramString;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(150249);
    if (gTJ == null) {
      gTJ = new a(gTE);
    }
    AppMethodBeat.o(150249);
  }
  
  public static Bitmap vT(String paramString)
  {
    AppMethodBeat.i(150250);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    Object localObject = gTJ;
    if (((a)localObject).gTg != null) {}
    for (localObject = (Bitmap)((a)localObject).gTg.aM(paramString); localObject == null; localObject = (Bitmap)g.a.S("avatar_cache", paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = gTJ;
      if (((a)localObject).gTg != null) {
        ((a)localObject).gTg.remove(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(150250);
        return null;
        g.a.T("avatar_cache", paramString);
      }
    }
    AppMethodBeat.o(150250);
    return localObject;
  }
  
  public static boolean vU(String paramString)
  {
    AppMethodBeat.i(150256);
    paramString = I(paramString, false);
    if ((i.eK(paramString)) || (i.eK(paramString + ".bm")))
    {
      AppMethodBeat.o(150256);
      return true;
    }
    AppMethodBeat.o(150256);
    return false;
  }
  
  public static Bitmap vV(String paramString)
  {
    AppMethodBeat.i(150258);
    paramString = vY(I(paramString, false));
    AppMethodBeat.o(150258);
    return paramString;
  }
  
  public static Bitmap vW(String paramString)
  {
    AppMethodBeat.i(150264);
    ad.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150264);
      return null;
    }
    paramString = com.tencent.mm.sdk.platformtools.f.aF(I(paramString, true), 1080, 1080);
    AppMethodBeat.o(150264);
    return paramString;
  }
  
  public static Bitmap vX(String paramString)
  {
    AppMethodBeat.i(150265);
    int i = 0;
    if (gTF.containsKey(paramString)) {
      i = ((Integer)gTF.get(paramString)).intValue();
    }
    if (i != 0) {
      p.auE();
    }
    for (paramString = com.tencent.mm.compatible.e.a.decodeResource(p.getContext().getResources(), i);; paramString = null)
    {
      paramString = com.tencent.mm.sdk.platformtools.f.a(paramString, true, 1.0F, true);
      AppMethodBeat.o(150265);
      return paramString;
    }
  }
  
  public static Bitmap vY(String paramString)
  {
    AppMethodBeat.i(150267);
    if (i.eK(paramString)) {}
    for (Bitmap localBitmap2 = com.tencent.mm.sdk.platformtools.f.decodeFile(paramString, null);; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = e.b.wb(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (I(localBitmap1))
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
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); I(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        AppMethodBeat.o(150267);
        return paramString;
      }
      AppMethodBeat.o(150267);
      return null;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150244);
    synchronized (this.gTH)
    {
      this.gTH.add(new WeakReference(parama));
      AppMethodBeat.o(150244);
      return;
    }
  }
  
  public final boolean aO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150261);
    try
    {
      BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.f.aFf(paramString1);
      int k = localOptions.outWidth;
      int m = localOptions.outHeight;
      int i;
      int j;
      if (m < k)
      {
        i = k * 96 / m;
        j = 96;
      }
      for (;;)
      {
        ad.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(1) });
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inSampleSize = Math.min(k / i, m / j);
        boolean bool = f(paramString2, com.tencent.mm.sdk.platformtools.f.decodeFile(paramString1, localOptions));
        AppMethodBeat.o(150261);
        return bool;
        j = m * 96 / k;
        i = 96;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bt.m(paramString1) });
      AppMethodBeat.o(150261);
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(150245);
    synchronized (this.gTH)
    {
      parama = c(parama);
      if (parama != null) {
        this.gTH.remove(parama);
      }
      AppMethodBeat.o(150245);
      return;
    }
  }
  
  public final Bitmap cs(Context paramContext)
  {
    AppMethodBeat.i(150252);
    paramContext.getResources();
    Bitmap localBitmap = vT("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!I(localBitmap))
    {
      paramContext = localBitmap;
      if (localBitmap != null)
      {
        ad.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", new Object[] { Boolean.valueOf(localBitmap.isRecycled()), "I_AM_NO_SDCARD_USER_NAME" });
        paramContext = com.tencent.mm.sdk.platformtools.f.a(localBitmap, true, 1.0F);
        e("I_AM_NO_SDCARD_USER_NAME", paramContext);
      }
    }
    AppMethodBeat.o(150252);
    return paramContext;
  }
  
  @Deprecated
  public final void d(a parama)
  {
    AppMethodBeat.i(150247);
    this.gTG.a(parama, Looper.getMainLooper());
    AppMethodBeat.o(150247);
  }
  
  @Deprecated
  public final void e(a parama)
  {
    AppMethodBeat.i(150248);
    this.gTG.remove(parama);
    AppMethodBeat.o(150248);
  }
  
  public final void e(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150251);
    gTJ.d(paramString, paramBitmap);
    paramBitmap = a.a.EKY;
    if (paramBitmap != null) {
      paramBitmap.Mf(paramString);
    }
    this.gTG.dR(paramString);
    this.gTG.doNotify();
    ad.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
    AppMethodBeat.o(150251);
  }
  
  /* Error */
  final boolean f(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc_w 563
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 340	com/tencent/mm/ak/e:I	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 563
    //   16: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   25: bipush 96
    //   27: if_icmpne +106 -> 133
    //   30: aload_2
    //   31: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   34: bipush 96
    //   36: if_icmpne +97 -> 133
    //   39: aload_2
    //   40: astore 5
    //   42: aload_2
    //   43: astore 6
    //   45: aload 5
    //   47: ifnull +39 -> 86
    //   50: aload_2
    //   51: astore 6
    //   53: aload 5
    //   55: aload_2
    //   56: if_acmpeq +30 -> 86
    //   59: ldc 224
    //   61: ldc_w 565
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_2
    //   71: invokevirtual 566	java/lang/Object:toString	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_2
    //   79: invokevirtual 569	android/graphics/Bitmap:recycle	()V
    //   82: aload 5
    //   84: astore 6
    //   86: aload_1
    //   87: iconst_0
    //   88: invokestatic 222	com/tencent/mm/ak/e:I	(Ljava/lang/String;Z)Ljava/lang/String;
    //   91: astore_2
    //   92: aload_2
    //   93: iconst_0
    //   94: invokestatic 356	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   97: astore_2
    //   98: aload 6
    //   100: getstatic 575	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   103: bipush 100
    //   105: aload_2
    //   106: invokevirtual 579	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   109: pop
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 365	java/io/OutputStream:close	()V
    //   118: aload_0
    //   119: aload_1
    //   120: aload 6
    //   122: invokevirtual 525	com/tencent/mm/ak/e:e	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   125: ldc_w 563
    //   128: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_1
    //   132: ireturn
    //   133: aload_2
    //   134: invokevirtual 345	android/graphics/Bitmap:getWidth	()I
    //   137: istore_3
    //   138: aload_2
    //   139: invokevirtual 348	android/graphics/Bitmap:getHeight	()I
    //   142: istore 4
    //   144: iload_3
    //   145: iload 4
    //   147: if_icmpeq +59 -> 206
    //   150: iload_3
    //   151: iload 4
    //   153: if_icmple +35 -> 188
    //   156: aload_2
    //   157: iload_3
    //   158: iload 4
    //   160: isub
    //   161: iconst_2
    //   162: idiv
    //   163: iconst_0
    //   164: iload 4
    //   166: iload 4
    //   168: invokestatic 352	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   171: astore 5
    //   173: aload 5
    //   175: bipush 96
    //   177: bipush 96
    //   179: iconst_1
    //   180: invokestatic 583	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   183: astore 5
    //   185: goto -143 -> 42
    //   188: aload_2
    //   189: iconst_0
    //   190: iload 4
    //   192: iload_3
    //   193: isub
    //   194: iconst_2
    //   195: idiv
    //   196: iload_3
    //   197: iload_3
    //   198: invokestatic 352	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   201: astore 5
    //   203: goto -30 -> 173
    //   206: aload_2
    //   207: bipush 96
    //   209: bipush 96
    //   211: iconst_1
    //   212: invokestatic 583	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   215: astore 5
    //   217: goto -175 -> 42
    //   220: astore 5
    //   222: ldc 224
    //   224: ldc_w 585
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload_1
    //   234: aastore
    //   235: invokestatic 305	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: aload_2
    //   239: invokestatic 340	com/tencent/mm/ak/e:I	(Landroid/graphics/Bitmap;)Z
    //   242: ifeq +26 -> 268
    //   245: ldc 224
    //   247: ldc_w 565
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_2
    //   257: invokevirtual 566	java/lang/Object:toString	()Ljava/lang/String;
    //   260: aastore
    //   261: invokestatic 236	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_2
    //   265: invokevirtual 569	android/graphics/Bitmap:recycle	()V
    //   268: ldc_w 563
    //   271: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore 5
    //   278: aconst_null
    //   279: astore_2
    //   280: ldc 224
    //   282: aload 5
    //   284: ldc_w 369
    //   287: iconst_1
    //   288: anewarray 4	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload_1
    //   294: aastore
    //   295: invokestatic 373	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: aload_2
    //   299: ifnull +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 365	java/io/OutputStream:close	()V
    //   306: ldc_w 563
    //   309: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: iconst_0
    //   313: ireturn
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_2
    //   317: aload_2
    //   318: ifnull +7 -> 325
    //   321: aload_2
    //   322: invokevirtual 365	java/io/OutputStream:close	()V
    //   325: ldc_w 563
    //   328: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aload_1
    //   332: athrow
    //   333: astore_2
    //   334: goto -216 -> 118
    //   337: astore_1
    //   338: goto -32 -> 306
    //   341: astore_2
    //   342: goto -17 -> 325
    //   345: astore_1
    //   346: goto -29 -> 317
    //   349: astore_1
    //   350: goto -33 -> 317
    //   353: astore 5
    //   355: goto -75 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	e
    //   0	358	1	paramString	String
    //   0	358	2	paramBitmap	Bitmap
    //   137	61	3	i	int
    //   142	52	4	j	int
    //   40	176	5	localBitmap1	Bitmap
    //   220	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   276	7	5	localIOException1	java.io.IOException
    //   353	1	5	localIOException2	java.io.IOException
    //   43	78	6	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   133	144	220	java/lang/OutOfMemoryError
    //   156	173	220	java/lang/OutOfMemoryError
    //   173	185	220	java/lang/OutOfMemoryError
    //   188	203	220	java/lang/OutOfMemoryError
    //   206	217	220	java/lang/OutOfMemoryError
    //   92	98	276	java/io/IOException
    //   92	98	314	finally
    //   114	118	333	java/io/IOException
    //   302	306	337	java/io/IOException
    //   321	325	341	java/io/IOException
    //   98	110	345	finally
    //   280	298	349	finally
    //   98	110	353	java/io/IOException
  }
  
  public final boolean h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150260);
    paramArrayOfByte = g(paramString, paramArrayOfByte);
    if (!I(paramArrayOfByte))
    {
      AppMethodBeat.o(150260);
      return false;
    }
    e(paramString, paramArrayOfByte);
    AppMethodBeat.o(150260);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void vZ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.e
 * JD-Core Version:    0.7.0.1
 */