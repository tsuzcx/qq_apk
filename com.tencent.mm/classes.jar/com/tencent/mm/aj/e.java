package com.tencent.mm.aj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static int huc;
  private static int hud;
  static final Map<String, Integer> hue;
  private static a hui;
  private l<a, String> huf;
  private final List<WeakReference<a>> hug;
  private final a huh;
  
  static
  {
    AppMethodBeat.i(150268);
    huc = 100;
    hud = 100;
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    hue = localConcurrentHashMap;
    localConcurrentHashMap.put("voipapp", Integer.valueOf(2131690041));
    hue.put("qqmail", Integer.valueOf(2131690034));
    hue.put("fmessage", Integer.valueOf(2131690021));
    hue.put("floatbottle", Integer.valueOf(2131690014));
    hue.put("lbsapp", Integer.valueOf(2131690028));
    hue.put("shakeapp", Integer.valueOf(2131690038));
    hue.put("medianote", Integer.valueOf(2131690026));
    hue.put("qqfriend", Integer.valueOf(2131690033));
    hue.put("masssendapp", Integer.valueOf(2131690025));
    hue.put("feedsapp", Integer.valueOf(2131690020));
    hue.put("facebookapp", Integer.valueOf(2131690019));
    hue.put("newsapp", Integer.valueOf(2131690036));
    hue.put("helper_entry", Integer.valueOf(2131690030));
    hue.put("voicevoipapp", Integer.valueOf(2131690040));
    hue.put("voiceinputapp", Integer.valueOf(2131690039));
    hue.put("officialaccounts", Integer.valueOf(2131690015));
    hue.put("service_officialaccounts", Integer.valueOf(2131690037));
    hue.put("linkedinplugin", Integer.valueOf(2131690024));
    hue.put("notifymessage", Integer.valueOf(2131690029));
    hue.put("appbrandcustomerservicemsg", Integer.valueOf(2131690012));
    hue.put("appbrand_notify_message", Integer.valueOf(2131690011));
    hue.put("downloaderapp", Integer.valueOf(2131690018));
    hui = new a(hud);
    AppMethodBeat.o(150268);
  }
  
  public e()
  {
    AppMethodBeat.i(150243);
    this.huf = new l() {};
    this.hug = new ArrayList();
    this.huh = new a()
    {
      public final void Af(String paramAnonymousString)
      {
        AppMethodBeat.i(150238);
        ac.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramAnonymousString, Integer.valueOf(e.a(e.this).size()), Integer.valueOf(e.a(e.this).size()) });
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
          ((e.a)((Iterator)???).next()).Af(paramAnonymousString);
        }
        AppMethodBeat.o(150238);
      }
    };
    reset();
    this.huf.a(this.huh, null);
    AppMethodBeat.o(150243);
  }
  
  public static boolean Aa(String paramString)
  {
    AppMethodBeat.i(150256);
    paramString = J(paramString, false);
    if ((i.eA(paramString)) || (i.eA(paramString + ".bm")))
    {
      AppMethodBeat.o(150256);
      return true;
    }
    AppMethodBeat.o(150256);
    return false;
  }
  
  public static Bitmap Ab(String paramString)
  {
    AppMethodBeat.i(150258);
    paramString = Ae(J(paramString, false));
    AppMethodBeat.o(150258);
    return paramString;
  }
  
  public static Bitmap Ac(String paramString)
  {
    AppMethodBeat.i(150264);
    ac.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150264);
      return null;
    }
    paramString = com.tencent.mm.sdk.platformtools.f.aI(J(paramString, true), 1080, 1080);
    AppMethodBeat.o(150264);
    return paramString;
  }
  
  public static Bitmap Ad(String paramString)
  {
    AppMethodBeat.i(150265);
    int i = 0;
    if (hue.containsKey(paramString)) {
      i = ((Integer)hue.get(paramString)).intValue();
    }
    if (i != 0) {
      p.aBv();
    }
    for (paramString = com.tencent.mm.compatible.e.a.decodeResource(p.getContext().getResources(), i);; paramString = null)
    {
      paramString = com.tencent.mm.sdk.platformtools.f.a(paramString, true, 1.0F, true);
      AppMethodBeat.o(150265);
      return paramString;
    }
  }
  
  public static Bitmap Ae(String paramString)
  {
    AppMethodBeat.i(150267);
    if (i.eA(paramString)) {}
    for (Bitmap localBitmap2 = com.tencent.mm.sdk.platformtools.f.decodeFile(paramString, null);; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = e.b.Ah(paramString);
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
            break label90;
          }
        }
      }
      label90:
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); I(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        AppMethodBeat.o(150267);
        return paramString;
      }
      AppMethodBeat.o(150267);
      return null;
    }
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
    AppMethodBeat.i(150254);
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    i.aSh(i.aSs(paramString));
    AppMethodBeat.o(150254);
    return paramString;
  }
  
  public static String K(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150255);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150255);
      return null;
    }
    paramString = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.agR().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    if (i.aSh(i.aSs(paramString)))
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
    ac.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
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
      ac.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bs.m(paramContext) });
      AppMethodBeat.o(150242);
    }
  }
  
  private WeakReference<a> c(a parama)
  {
    AppMethodBeat.i(150246);
    List localList = this.hug;
    int i = 0;
    try
    {
      while (i < this.hug.size())
      {
        WeakReference localWeakReference = (WeakReference)this.hug.get(i);
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
    //   0: ldc_w 404
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: sipush 156
    //   10: sipush 156
    //   13: invokestatic 408	com/tencent/mm/sdk/platformtools/f:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   16: astore 5
    //   18: aload 5
    //   20: invokestatic 264	com/tencent/mm/aj/e:I	(Landroid/graphics/Bitmap;)Z
    //   23: ifne +27 -> 50
    //   26: ldc 195
    //   28: ldc_w 410
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokestatic 378	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: ldc_w 404
    //   45: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload 5
    //   52: invokevirtual 269	android/graphics/Bitmap:getWidth	()I
    //   55: istore_2
    //   56: aload 5
    //   58: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
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
    //   86: invokestatic 276	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   89: astore 4
    //   91: aload_0
    //   92: iconst_0
    //   93: invokestatic 167	com/tencent/mm/aj/e:J	(Ljava/lang/String;Z)Ljava/lang/String;
    //   96: astore 5
    //   98: aload 5
    //   100: iconst_0
    //   101: invokestatic 414	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   104: astore 6
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: aload_1
    //   113: iconst_0
    //   114: aload_1
    //   115: arraylength
    //   116: invokevirtual 420	java/io/OutputStream:write	([BII)V
    //   119: aload 6
    //   121: ifnull +8 -> 129
    //   124: aload 6
    //   126: invokevirtual 423	java/io/OutputStream:close	()V
    //   129: ldc 195
    //   131: ldc_w 425
    //   134: iconst_1
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: aload_0
    //   141: aastore
    //   142: invokestatic 323	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: ldc_w 404
    //   148: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   164: invokestatic 276	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   167: astore 4
    //   169: goto -78 -> 91
    //   172: astore_1
    //   173: aconst_null
    //   174: astore 6
    //   176: aload 6
    //   178: astore 5
    //   180: ldc 195
    //   182: aload_1
    //   183: ldc_w 427
    //   186: iconst_1
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_0
    //   193: aastore
    //   194: invokestatic 431	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload 6
    //   199: ifnull +8 -> 207
    //   202: aload 6
    //   204: invokevirtual 423	java/io/OutputStream:close	()V
    //   207: ldc_w 404
    //   210: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_0
    //   216: aconst_null
    //   217: astore 5
    //   219: aload 5
    //   221: ifnull +8 -> 229
    //   224: aload 5
    //   226: invokevirtual 423	java/io/OutputStream:close	()V
    //   229: ldc_w 404
    //   232: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static Bitmap m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150263);
    ac.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150263);
      return null;
    }
    paramString = com.tencent.mm.sdk.platformtools.f.aI(J(paramString, true), paramInt1, paramInt2);
    AppMethodBeat.o(150263);
    return paramString;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(150249);
    if (hui == null) {
      hui = new a(hud);
    }
    AppMethodBeat.o(150249);
  }
  
  public static Bitmap zZ(String paramString)
  {
    AppMethodBeat.i(150250);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    Object localObject = hui;
    if (((a)localObject).htF != null) {}
    for (localObject = (Bitmap)((a)localObject).htF.aJ(paramString); localObject == null; localObject = (Bitmap)g.a.T("avatar_cache", paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = hui;
      if (((a)localObject).htF != null) {
        ((a)localObject).htF.remove(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(150250);
        return null;
        g.a.U("avatar_cache", paramString);
      }
    }
    AppMethodBeat.o(150250);
    return localObject;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150244);
    synchronized (this.hug)
    {
      this.hug.add(new WeakReference(parama));
      AppMethodBeat.o(150244);
      return;
    }
  }
  
  public final boolean aW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150261);
    try
    {
      BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.f.aKw(paramString1);
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
        ac.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(1) });
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inSampleSize = 1;
        boolean bool = e(paramString2, com.tencent.mm.sdk.platformtools.f.decodeFile(paramString1, localOptions));
        AppMethodBeat.o(150261);
        return bool;
        j = m * 156 / k;
        i = 156;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bs.m(paramString1) });
      AppMethodBeat.o(150261);
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(150245);
    synchronized (this.hug)
    {
      parama = c(parama);
      if (parama != null) {
        this.hug.remove(parama);
      }
      AppMethodBeat.o(150245);
      return;
    }
  }
  
  public final Bitmap cB(Context paramContext)
  {
    AppMethodBeat.i(150252);
    paramContext.getResources();
    Bitmap localBitmap = zZ("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!I(localBitmap))
    {
      paramContext = localBitmap;
      if (localBitmap != null)
      {
        ac.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", new Object[] { Boolean.valueOf(localBitmap.isRecycled()), "I_AM_NO_SDCARD_USER_NAME" });
        paramContext = com.tencent.mm.sdk.platformtools.f.a(localBitmap, true, 1.0F);
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
    this.huf.a(parama, Looper.getMainLooper());
    AppMethodBeat.o(150247);
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150251);
    hui.c(paramString, paramBitmap);
    paramBitmap = a.a.Gik;
    if (paramBitmap != null) {
      paramBitmap.Ql(paramString);
    }
    this.huf.dS(paramString);
    this.huf.doNotify();
    ac.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
    AppMethodBeat.o(150251);
  }
  
  @Deprecated
  public final void e(a parama)
  {
    AppMethodBeat.i(150248);
    this.huf.remove(parama);
    AppMethodBeat.o(150248);
  }
  
  /* Error */
  final boolean e(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc_w 557
    //   3: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 264	com/tencent/mm/aj/e:I	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 557
    //   16: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 269	android/graphics/Bitmap:getWidth	()I
    //   25: sipush 156
    //   28: if_icmpne +107 -> 135
    //   31: aload_2
    //   32: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
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
    //   61: ldc 195
    //   63: ldc_w 559
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_2
    //   73: invokevirtual 560	java/lang/Object:toString	()Ljava/lang/String;
    //   76: aastore
    //   77: invokestatic 323	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_2
    //   81: invokevirtual 563	android/graphics/Bitmap:recycle	()V
    //   84: aload 5
    //   86: astore 6
    //   88: aload_1
    //   89: iconst_0
    //   90: invokestatic 167	com/tencent/mm/aj/e:J	(Ljava/lang/String;Z)Ljava/lang/String;
    //   93: astore_2
    //   94: aload_2
    //   95: iconst_0
    //   96: invokestatic 414	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   99: astore_2
    //   100: aload 6
    //   102: getstatic 569	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   105: bipush 100
    //   107: aload_2
    //   108: invokevirtual 573	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 423	java/io/OutputStream:close	()V
    //   120: aload_0
    //   121: aload_1
    //   122: aload 6
    //   124: invokevirtual 519	com/tencent/mm/aj/e:d	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   127: ldc_w 557
    //   130: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_1
    //   134: ireturn
    //   135: aload_2
    //   136: invokevirtual 269	android/graphics/Bitmap:getWidth	()I
    //   139: istore_3
    //   140: aload_2
    //   141: invokevirtual 272	android/graphics/Bitmap:getHeight	()I
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
    //   170: invokestatic 276	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   173: astore 5
    //   175: aload 5
    //   177: sipush 156
    //   180: sipush 156
    //   183: iconst_1
    //   184: invokestatic 577	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
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
    //   202: invokestatic 276	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   205: astore 5
    //   207: goto -32 -> 175
    //   210: aload_2
    //   211: sipush 156
    //   214: sipush 156
    //   217: iconst_1
    //   218: invokestatic 577	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   221: astore 5
    //   223: goto -179 -> 44
    //   226: astore 5
    //   228: ldc 195
    //   230: ldc_w 579
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: dup
    //   238: iconst_0
    //   239: aload_1
    //   240: aastore
    //   241: invokestatic 378	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_2
    //   245: invokestatic 264	com/tencent/mm/aj/e:I	(Landroid/graphics/Bitmap;)Z
    //   248: ifeq +26 -> 274
    //   251: ldc 195
    //   253: ldc_w 559
    //   256: iconst_1
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_2
    //   263: invokevirtual 560	java/lang/Object:toString	()Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 323	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_2
    //   271: invokevirtual 563	android/graphics/Bitmap:recycle	()V
    //   274: ldc_w 557
    //   277: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: iconst_0
    //   281: ireturn
    //   282: astore 5
    //   284: aconst_null
    //   285: astore_2
    //   286: ldc 195
    //   288: aload 5
    //   290: ldc_w 427
    //   293: iconst_1
    //   294: anewarray 4	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_1
    //   300: aastore
    //   301: invokestatic 431	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: aload_2
    //   305: ifnull +7 -> 312
    //   308: aload_2
    //   309: invokevirtual 423	java/io/OutputStream:close	()V
    //   312: ldc_w 557
    //   315: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: iconst_0
    //   319: ireturn
    //   320: astore_1
    //   321: aconst_null
    //   322: astore_2
    //   323: aload_2
    //   324: ifnull +7 -> 331
    //   327: aload_2
    //   328: invokevirtual 423	java/io/OutputStream:close	()V
    //   331: ldc_w 557
    //   334: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    if (!I(paramArrayOfByte))
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
    public abstract void Af(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.e
 * JD-Core Version:    0.7.0.1
 */