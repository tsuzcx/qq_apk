package com.tencent.mm.ah;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.bx.a.a.a;
import com.tencent.mm.cache.f.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static int frH;
  private static int frI;
  static final Map<String, Integer> frJ;
  private static a frN;
  private l<d.a, String> frK;
  private final List<WeakReference<d.a>> frL;
  private final d.a frM;
  
  static
  {
    AppMethodBeat.i(77904);
    frH = 150;
    frI = 150;
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    frJ = localConcurrentHashMap;
    localConcurrentHashMap.put("voipapp", Integer.valueOf(2131231235));
    frJ.put("qqmail", Integer.valueOf(2131231228));
    frJ.put("fmessage", Integer.valueOf(2131231215));
    frJ.put("floatbottle", Integer.valueOf(2131231208));
    frJ.put("lbsapp", Integer.valueOf(2131231222));
    frJ.put("shakeapp", Integer.valueOf(2131231232));
    frJ.put("medianote", Integer.valueOf(2131231220));
    frJ.put("qqfriend", Integer.valueOf(2131231227));
    frJ.put("masssendapp", Integer.valueOf(2131231219));
    frJ.put("feedsapp", Integer.valueOf(2131231214));
    frJ.put("facebookapp", Integer.valueOf(2131231213));
    frJ.put("newsapp", Integer.valueOf(2131231230));
    frJ.put("helper_entry", Integer.valueOf(2131231224));
    frJ.put("voicevoipapp", Integer.valueOf(2131231234));
    frJ.put("voiceinputapp", Integer.valueOf(2131231233));
    frJ.put("officialaccounts", Integer.valueOf(2131231209));
    frJ.put("service_officialaccounts", Integer.valueOf(2131231231));
    frJ.put("linkedinplugin", Integer.valueOf(2131231218));
    frJ.put("notifymessage", Integer.valueOf(2131231223));
    frJ.put("appbrandcustomerservicemsg", Integer.valueOf(2131231206));
    frJ.put("downloaderapp", Integer.valueOf(2131231212));
    frN = new a(frI);
    AppMethodBeat.o(77904);
  }
  
  public d()
  {
    AppMethodBeat.i(77879);
    this.frK = new d.1(this);
    this.frL = new ArrayList();
    this.frM = new d.2(this);
    reset();
    this.frK.a(this.frM, null);
    AppMethodBeat.o(77879);
  }
  
  private static boolean A(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77902);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(77902);
      return true;
    }
    AppMethodBeat.o(77902);
    return false;
  }
  
  public static String D(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(77890);
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(paramString));
    AppMethodBeat.o(77890);
    return paramString;
  }
  
  public static String E(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(77891);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77891);
      return null;
    }
    paramString = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.RL().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    if (com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(paramString)))
    {
      AppMethodBeat.o(77891);
      return paramString;
    }
    AppMethodBeat.o(77891);
    return null;
  }
  
  public static boolean F(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(77893);
    String str = D(paramString, paramBoolean);
    ab.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = com.tencent.mm.vfs.e.deleteFile(str);
    boolean bool1 = bool2;
    if (!paramBoolean) {
      bool1 = bool2 | d.b.remove(str);
    }
    AppMethodBeat.o(77893);
    return bool1;
  }
  
  private static StringBuilder a(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(77889);
    paramString = com.tencent.mm.a.g.w(paramString.getBytes());
    paramStringBuilder.append(paramString.substring(0, 2)).append('/').append(paramString.substring(2, 4)).append('/').append("user_");
    if (paramBoolean) {
      paramStringBuilder.append("hd_");
    }
    paramStringBuilder = paramStringBuilder.append(paramString).append(".png");
    AppMethodBeat.o(77889);
    return paramStringBuilder;
  }
  
  public static void a(Context paramContext, ImageView paramImageView, int paramInt)
  {
    AppMethodBeat.i(77878);
    try
    {
      paramImageView.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.compatible.g.a.decodeResource(paramContext.getResources(), paramInt), true, 1.0F));
      AppMethodBeat.o(77878);
      return;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bo.l(paramContext) });
      AppMethodBeat.o(77878);
    }
  }
  
  private WeakReference<d.a> c(d.a parama)
  {
    AppMethodBeat.i(77882);
    List localList = this.frL;
    int i = 0;
    try
    {
      while (i < this.frL.size())
      {
        WeakReference localWeakReference = (WeakReference)this.frL.get(i);
        if (localWeakReference != null)
        {
          d.a locala = (d.a)localWeakReference.get();
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
      AppMethodBeat.o(77882);
    }
  }
  
  /* Error */
  public static Bitmap m(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 333
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: bipush 96
    //   9: bipush 96
    //   11: invokestatic 337	com/tencent/mm/sdk/platformtools/d:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   14: astore 5
    //   16: aload 5
    //   18: invokestatic 339	com/tencent/mm/ah/d:A	(Landroid/graphics/Bitmap;)Z
    //   21: ifne +27 -> 48
    //   24: ldc 223
    //   26: ldc_w 341
    //   29: iconst_1
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: aastore
    //   37: invokestatic 304	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   40: ldc_w 333
    //   43: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aconst_null
    //   47: areturn
    //   48: aload 5
    //   50: invokevirtual 344	android/graphics/Bitmap:getWidth	()I
    //   53: istore_2
    //   54: aload 5
    //   56: invokevirtual 347	android/graphics/Bitmap:getHeight	()I
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
    //   84: invokestatic 351	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   87: astore 4
    //   89: aload_0
    //   90: iconst_0
    //   91: invokestatic 221	com/tencent/mm/ah/d:D	(Ljava/lang/String;Z)Ljava/lang/String;
    //   94: astore 5
    //   96: aload 5
    //   98: iconst_0
    //   99: invokestatic 355	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   102: astore 6
    //   104: aload 6
    //   106: astore 5
    //   108: aload 6
    //   110: aload_1
    //   111: iconst_0
    //   112: aload_1
    //   113: arraylength
    //   114: invokevirtual 361	java/io/OutputStream:write	([BII)V
    //   117: aload 6
    //   119: ifnull +8 -> 127
    //   122: aload 6
    //   124: invokevirtual 364	java/io/OutputStream:close	()V
    //   127: ldc 223
    //   129: ldc_w 366
    //   132: iconst_1
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_0
    //   139: aastore
    //   140: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: ldc_w 333
    //   146: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   162: invokestatic 351	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   165: astore 4
    //   167: goto -78 -> 89
    //   170: astore_1
    //   171: aconst_null
    //   172: astore 6
    //   174: aload 6
    //   176: astore 5
    //   178: ldc 223
    //   180: aload_1
    //   181: ldc_w 368
    //   184: iconst_1
    //   185: anewarray 4	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload_0
    //   191: aastore
    //   192: invokestatic 372	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: aload 6
    //   197: ifnull +8 -> 205
    //   200: aload 6
    //   202: invokevirtual 364	java/io/OutputStream:close	()V
    //   205: ldc_w 333
    //   208: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aconst_null
    //   212: areturn
    //   213: astore_0
    //   214: aconst_null
    //   215: astore 5
    //   217: aload 5
    //   219: ifnull +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 364	java/io/OutputStream:close	()V
    //   227: ldc_w 333
    //   230: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static Bitmap q(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(77899);
    ab.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77899);
      return null;
    }
    paramString = com.tencent.mm.sdk.platformtools.d.aA(D(paramString, true), paramInt1, paramInt2);
    AppMethodBeat.o(77899);
    return paramString;
  }
  
  public static Bitmap qY(String paramString)
  {
    AppMethodBeat.i(77886);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77886);
      return null;
    }
    Object localObject = frN;
    if (((a)localObject).frn != null) {}
    for (localObject = (Bitmap)((a)localObject).frn.Y(paramString); localObject == null; localObject = (Bitmap)f.a.M("avatar_cache", paramString))
    {
      AppMethodBeat.o(77886);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = frN;
      if (((a)localObject).frn != null) {
        ((a)localObject).frn.remove(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(77886);
        return null;
        f.a.N("avatar_cache", paramString);
      }
    }
    AppMethodBeat.o(77886);
    return localObject;
  }
  
  public static boolean qZ(String paramString)
  {
    AppMethodBeat.i(77892);
    paramString = D(paramString, false);
    if ((com.tencent.mm.vfs.e.cN(paramString)) || (com.tencent.mm.vfs.e.cN(paramString + ".bm")))
    {
      AppMethodBeat.o(77892);
      return true;
    }
    AppMethodBeat.o(77892);
    return false;
  }
  
  public static Bitmap ra(String paramString)
  {
    AppMethodBeat.i(77894);
    paramString = rd(D(paramString, false));
    AppMethodBeat.o(77894);
    return paramString;
  }
  
  public static Bitmap rb(String paramString)
  {
    AppMethodBeat.i(77900);
    ab.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(77900);
      return null;
    }
    paramString = com.tencent.mm.sdk.platformtools.d.aA(D(paramString, true), 480, 480);
    AppMethodBeat.o(77900);
    return paramString;
  }
  
  public static Bitmap rc(String paramString)
  {
    AppMethodBeat.i(77901);
    int i = 0;
    if (frJ.containsKey(paramString)) {
      i = ((Integer)frJ.get(paramString)).intValue();
    }
    if (i != 0) {
      o.adf();
    }
    for (paramString = com.tencent.mm.compatible.g.a.decodeResource(o.getContext().getResources(), i);; paramString = null)
    {
      paramString = com.tencent.mm.sdk.platformtools.d.a(paramString, true, 1.0F, true);
      AppMethodBeat.o(77901);
      return paramString;
    }
  }
  
  public static Bitmap rd(String paramString)
  {
    AppMethodBeat.i(77903);
    if (com.tencent.mm.vfs.e.cN(paramString)) {}
    for (Bitmap localBitmap2 = com.tencent.mm.sdk.platformtools.d.decodeFile(paramString, null);; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = d.b.rg(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (A(localBitmap1))
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
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); A(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        AppMethodBeat.o(77903);
        return paramString;
      }
      AppMethodBeat.o(77903);
      return null;
    }
  }
  
  public static void reset()
  {
    AppMethodBeat.i(77885);
    if (frN == null) {
      frN = new a(frI);
    }
    AppMethodBeat.o(77885);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(77880);
    synchronized (this.frL)
    {
      this.frL.add(new WeakReference(parama));
      AppMethodBeat.o(77880);
      return;
    }
  }
  
  public final boolean ay(String paramString1, String paramString2)
  {
    AppMethodBeat.i(77897);
    try
    {
      BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.d.aoT(paramString1);
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
        ab.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(1) });
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inSampleSize = Math.min(k / i, m / j);
        boolean bool = f(paramString2, com.tencent.mm.sdk.platformtools.d.decodeFile(paramString1, localOptions));
        AppMethodBeat.o(77897);
        return bool;
        j = m * 96 / k;
        i = 96;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ab.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bo.l(paramString1) });
      AppMethodBeat.o(77897);
    }
  }
  
  public final void b(d.a parama)
  {
    AppMethodBeat.i(77881);
    synchronized (this.frL)
    {
      parama = c(parama);
      if (parama != null) {
        this.frL.remove(parama);
      }
      AppMethodBeat.o(77881);
      return;
    }
  }
  
  public final Bitmap bZ(Context paramContext)
  {
    AppMethodBeat.i(77888);
    paramContext.getResources();
    Bitmap localBitmap = qY("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!A(localBitmap))
    {
      paramContext = localBitmap;
      if (localBitmap != null)
      {
        ab.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", new Object[] { Boolean.valueOf(localBitmap.isRecycled()), "I_AM_NO_SDCARD_USER_NAME" });
        paramContext = com.tencent.mm.sdk.platformtools.d.a(localBitmap, true, 1.0F);
        e("I_AM_NO_SDCARD_USER_NAME", paramContext);
      }
    }
    AppMethodBeat.o(77888);
    return paramContext;
  }
  
  @Deprecated
  public final void d(d.a parama)
  {
    AppMethodBeat.i(77883);
    this.frK.a(parama, Looper.getMainLooper());
    AppMethodBeat.o(77883);
  }
  
  @Deprecated
  public final void e(d.a parama)
  {
    AppMethodBeat.i(77884);
    this.frK.remove(parama);
    AppMethodBeat.o(77884);
  }
  
  public final void e(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(77887);
    frN.d(paramString, paramBitmap);
    paramBitmap = a.a.yio;
    if (paramBitmap != null) {
      paramBitmap.Ey(paramString);
    }
    this.frK.cy(paramString);
    this.frK.doNotify();
    ab.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
    AppMethodBeat.o(77887);
  }
  
  /* Error */
  final boolean f(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc_w 562
    //   3: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 339	com/tencent/mm/ah/d:A	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 562
    //   16: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 344	android/graphics/Bitmap:getWidth	()I
    //   25: bipush 96
    //   27: if_icmpne +106 -> 133
    //   30: aload_2
    //   31: invokevirtual 347	android/graphics/Bitmap:getHeight	()I
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
    //   59: ldc 223
    //   61: ldc_w 564
    //   64: iconst_1
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_2
    //   71: invokevirtual 565	java/lang/Object:toString	()Ljava/lang/String;
    //   74: aastore
    //   75: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_2
    //   79: invokevirtual 568	android/graphics/Bitmap:recycle	()V
    //   82: aload 5
    //   84: astore 6
    //   86: aload_1
    //   87: iconst_0
    //   88: invokestatic 221	com/tencent/mm/ah/d:D	(Ljava/lang/String;Z)Ljava/lang/String;
    //   91: astore_2
    //   92: aload_2
    //   93: iconst_0
    //   94: invokestatic 355	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   97: astore_2
    //   98: aload 6
    //   100: getstatic 574	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   103: bipush 100
    //   105: aload_2
    //   106: invokevirtual 578	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   109: pop
    //   110: aload_2
    //   111: ifnull +7 -> 118
    //   114: aload_2
    //   115: invokevirtual 364	java/io/OutputStream:close	()V
    //   118: aload_0
    //   119: aload_1
    //   120: aload 6
    //   122: invokevirtual 524	com/tencent/mm/ah/d:e	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   125: ldc_w 562
    //   128: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: iconst_1
    //   132: ireturn
    //   133: aload_2
    //   134: invokevirtual 344	android/graphics/Bitmap:getWidth	()I
    //   137: istore_3
    //   138: aload_2
    //   139: invokevirtual 347	android/graphics/Bitmap:getHeight	()I
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
    //   168: invokestatic 351	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   171: astore 5
    //   173: aload 5
    //   175: bipush 96
    //   177: bipush 96
    //   179: iconst_1
    //   180: invokestatic 582	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
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
    //   198: invokestatic 351	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   201: astore 5
    //   203: goto -30 -> 173
    //   206: aload_2
    //   207: bipush 96
    //   209: bipush 96
    //   211: iconst_1
    //   212: invokestatic 582	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   215: astore 5
    //   217: goto -175 -> 42
    //   220: astore 5
    //   222: ldc 223
    //   224: ldc_w 584
    //   227: iconst_1
    //   228: anewarray 4	java/lang/Object
    //   231: dup
    //   232: iconst_0
    //   233: aload_1
    //   234: aastore
    //   235: invokestatic 304	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: aload_2
    //   239: invokestatic 339	com/tencent/mm/ah/d:A	(Landroid/graphics/Bitmap;)Z
    //   242: ifeq +26 -> 268
    //   245: ldc 223
    //   247: ldc_w 564
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_2
    //   257: invokevirtual 565	java/lang/Object:toString	()Ljava/lang/String;
    //   260: aastore
    //   261: invokestatic 235	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_2
    //   265: invokevirtual 568	android/graphics/Bitmap:recycle	()V
    //   268: ldc_w 562
    //   271: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore 5
    //   278: aconst_null
    //   279: astore_2
    //   280: ldc 223
    //   282: aload 5
    //   284: ldc_w 368
    //   287: iconst_1
    //   288: anewarray 4	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload_1
    //   294: aastore
    //   295: invokestatic 372	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   298: aload_2
    //   299: ifnull +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 364	java/io/OutputStream:close	()V
    //   306: ldc_w 562
    //   309: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   312: iconst_0
    //   313: ireturn
    //   314: astore_1
    //   315: aconst_null
    //   316: astore_2
    //   317: aload_2
    //   318: ifnull +7 -> 325
    //   321: aload_2
    //   322: invokevirtual 364	java/io/OutputStream:close	()V
    //   325: ldc_w 562
    //   328: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	358	0	this	d
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
  
  public final boolean n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77896);
    paramArrayOfByte = m(paramString, paramArrayOfByte);
    if (!A(paramArrayOfByte))
    {
      AppMethodBeat.o(77896);
      return false;
    }
    e(paramString, paramArrayOfByte);
    AppMethodBeat.o(77896);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ah.d
 * JD-Core Version:    0.7.0.1
 */