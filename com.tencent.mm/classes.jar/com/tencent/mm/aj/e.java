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
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  private static a iKA;
  private static int iKu;
  private static int iKv;
  static final Map<String, Integer> iKw;
  private MStorageEvent<e.a, String> iKx;
  private final List<WeakReference<e.a>> iKy;
  private final e.a iKz;
  
  static
  {
    AppMethodBeat.i(150268);
    iKu = 100;
    iKv = 100;
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    iKw = localConcurrentHashMap;
    localConcurrentHashMap.put("voipapp", Integer.valueOf(2131690071));
    iKw.put("qqmail", Integer.valueOf(2131690064));
    iKw.put("fmessage", Integer.valueOf(2131690051));
    iKw.put("floatbottle", Integer.valueOf(2131690044));
    iKw.put("lbsapp", Integer.valueOf(2131690058));
    iKw.put("shakeapp", Integer.valueOf(2131690068));
    iKw.put("medianote", Integer.valueOf(2131690056));
    iKw.put("qqfriend", Integer.valueOf(2131690063));
    iKw.put("masssendapp", Integer.valueOf(2131690055));
    iKw.put("feedsapp", Integer.valueOf(2131690050));
    iKw.put("facebookapp", Integer.valueOf(2131690049));
    iKw.put("newsapp", Integer.valueOf(2131690066));
    iKw.put("helper_entry", Integer.valueOf(2131690060));
    iKw.put("voicevoipapp", Integer.valueOf(2131690070));
    iKw.put("voiceinputapp", Integer.valueOf(2131690069));
    iKw.put("findersayhisessionholder", Integer.valueOf(2131233108));
    iKw.put("officialaccounts", Integer.valueOf(2131690045));
    iKw.put("service_officialaccounts", Integer.valueOf(2131690067));
    iKw.put("linkedinplugin", Integer.valueOf(2131690054));
    iKw.put("notifymessage", Integer.valueOf(2131690059));
    iKw.put("appbrandcustomerservicemsg", Integer.valueOf(2131690041));
    iKw.put("appbrand_notify_message", Integer.valueOf(2131690040));
    iKw.put("downloaderapp", Integer.valueOf(2131690048));
    iKA = new a(iKv);
    AppMethodBeat.o(150268);
  }
  
  public e()
  {
    AppMethodBeat.i(150243);
    this.iKx = new MStorageEvent() {};
    this.iKy = new ArrayList();
    this.iKz = new e.2(this);
    reset();
    this.iKx.add(this.iKz, null);
    AppMethodBeat.o(150243);
  }
  
  public static String L(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150254);
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    s.boN(s.boZ(paramString));
    AppMethodBeat.o(150254);
    return paramString;
  }
  
  public static String M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150255);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150255);
      return null;
    }
    paramString = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.aAh().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    if (s.boN(s.boZ(paramString)))
    {
      AppMethodBeat.o(150255);
      return paramString;
    }
    AppMethodBeat.o(150255);
    return null;
  }
  
  private static boolean M(Bitmap paramBitmap)
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
  
  public static Bitmap Mk(String paramString)
  {
    AppMethodBeat.i(150250);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    Object localObject = iKA;
    if (((a)localObject).iJX != null) {}
    for (localObject = (Bitmap)((a)localObject).iJX.aT(paramString); localObject == null; localObject = (Bitmap)g.a.X("avatar_cache", paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = iKA;
      if (((a)localObject).iJX != null) {
        ((a)localObject).iJX.remove(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(150250);
        return null;
        g.a.Y("avatar_cache", paramString);
      }
    }
    AppMethodBeat.o(150250);
    return localObject;
  }
  
  public static String Ml(String paramString)
  {
    AppMethodBeat.i(223533);
    paramString = M(paramString, false);
    AppMethodBeat.o(223533);
    return paramString;
  }
  
  public static boolean Mm(String paramString)
  {
    AppMethodBeat.i(150256);
    paramString = L(paramString, false);
    if ((s.YS(paramString)) || (s.YS(paramString + ".bm")))
    {
      AppMethodBeat.o(150256);
      return true;
    }
    AppMethodBeat.o(150256);
    return false;
  }
  
  public static Bitmap Mn(String paramString)
  {
    AppMethodBeat.i(150258);
    paramString = Mq(L(paramString, false));
    AppMethodBeat.o(150258);
    return paramString;
  }
  
  public static Bitmap Mo(String paramString)
  {
    AppMethodBeat.i(150264);
    Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150264);
      return null;
    }
    paramString = BitmapUtil.getBitmapNative(L(paramString, true), 1080, 1080);
    AppMethodBeat.o(150264);
    return paramString;
  }
  
  public static Bitmap Mp(String paramString)
  {
    AppMethodBeat.i(150265);
    int i = 0;
    if (iKw.containsKey(paramString)) {
      i = ((Integer)iKw.get(paramString)).intValue();
    }
    if (i != 0) {
      p.aYA();
    }
    for (paramString = com.tencent.mm.compatible.f.a.decodeResource(p.getContext().getResources(), i);; paramString = null)
    {
      paramString = BitmapUtil.getRoundedCornerBitmap(paramString, true, 1.0F, true);
      AppMethodBeat.o(150265);
      return paramString;
    }
  }
  
  public static Bitmap Mq(String paramString)
  {
    AppMethodBeat.i(150267);
    if (s.YS(paramString)) {}
    for (Bitmap localBitmap2 = BitmapUtil.decodeFile(paramString, null);; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = e.b.Mt(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (M(localBitmap1))
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
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); M(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        AppMethodBeat.o(150267);
        return paramString;
      }
      AppMethodBeat.o(150267);
      return null;
    }
  }
  
  public static boolean N(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150257);
    String str = L(paramString, paramBoolean);
    Log.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = s.deleteFile(str);
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
      paramImageView.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(com.tencent.mm.compatible.f.a.decodeResource(paramContext.getResources(), paramInt), true, 1.0F));
      AppMethodBeat.o(150242);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramContext) });
      AppMethodBeat.o(150242);
    }
  }
  
  private WeakReference<e.a> c(e.a parama)
  {
    AppMethodBeat.i(150246);
    List localList = this.iKy;
    int i = 0;
    try
    {
      while (i < this.iKy.size())
      {
        WeakReference localWeakReference = (WeakReference)this.iKy.get(i);
        if (localWeakReference != null)
        {
          e.a locala = (e.a)localWeakReference.get();
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
    //   0: ldc_w 438
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: sipush 156
    //   10: sipush 156
    //   13: invokestatic 442	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   16: astore 5
    //   18: aload 5
    //   20: invokestatic 336	com/tencent/mm/aj/e:M	(Landroid/graphics/Bitmap;)Z
    //   23: ifne +28 -> 51
    //   26: ldc_w 273
    //   29: ldc_w 444
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc_w 438
    //   46: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload 5
    //   53: invokevirtual 339	android/graphics/Bitmap:getWidth	()I
    //   56: istore_2
    //   57: aload 5
    //   59: invokevirtual 342	android/graphics/Bitmap:getHeight	()I
    //   62: istore_3
    //   63: aload 5
    //   65: astore 4
    //   67: iload_2
    //   68: iload_3
    //   69: if_icmpeq +23 -> 92
    //   72: iload_2
    //   73: iload_3
    //   74: if_icmple +82 -> 156
    //   77: aload 5
    //   79: iload_2
    //   80: iload_3
    //   81: isub
    //   82: iconst_2
    //   83: idiv
    //   84: iconst_0
    //   85: iload_3
    //   86: iload_3
    //   87: invokestatic 346	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   90: astore 4
    //   92: aload_0
    //   93: iconst_0
    //   94: invokestatic 258	com/tencent/mm/aj/e:L	(Ljava/lang/String;Z)Ljava/lang/String;
    //   97: astore 5
    //   99: aload 5
    //   101: iconst_0
    //   102: invokestatic 448	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   105: astore 6
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: invokevirtual 454	java/io/OutputStream:write	([BII)V
    //   120: aload 6
    //   122: ifnull +8 -> 130
    //   125: aload 6
    //   127: invokevirtual 457	java/io/OutputStream:close	()V
    //   130: ldc_w 273
    //   133: ldc_w 459
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_0
    //   143: aastore
    //   144: invokestatic 358	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: ldc_w 438
    //   150: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: aload 4
    //   155: areturn
    //   156: aload 5
    //   158: iconst_0
    //   159: iload_3
    //   160: iload_2
    //   161: isub
    //   162: iconst_2
    //   163: idiv
    //   164: iload_2
    //   165: iload_2
    //   166: invokestatic 346	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   169: astore 4
    //   171: goto -79 -> 92
    //   174: astore_1
    //   175: aconst_null
    //   176: astore 6
    //   178: aload 6
    //   180: astore 5
    //   182: ldc_w 273
    //   185: aload_1
    //   186: ldc_w 461
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_0
    //   196: aastore
    //   197: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 6
    //   202: ifnull +8 -> 210
    //   205: aload 6
    //   207: invokevirtual 457	java/io/OutputStream:close	()V
    //   210: ldc_w 438
    //   213: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_0
    //   219: aconst_null
    //   220: astore 5
    //   222: aload 5
    //   224: ifnull +8 -> 232
    //   227: aload 5
    //   229: invokevirtual 457	java/io/OutputStream:close	()V
    //   232: ldc_w 438
    //   235: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_0
    //   239: athrow
    //   240: astore_1
    //   241: goto -111 -> 130
    //   244: astore_0
    //   245: goto -35 -> 210
    //   248: astore_1
    //   249: goto -17 -> 232
    //   252: astore_0
    //   253: goto -31 -> 222
    //   256: astore_1
    //   257: goto -79 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramString	String
    //   0	260	1	paramArrayOfByte	byte[]
    //   56	110	2	i	int
    //   62	100	3	j	int
    //   65	105	4	localObject1	Object
    //   16	212	5	localObject2	Object
    //   105	101	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   99	107	174	java/io/IOException
    //   99	107	218	finally
    //   125	130	240	java/io/IOException
    //   205	210	244	java/io/IOException
    //   227	232	248	java/io/IOException
    //   111	120	252	finally
    //   182	200	252	finally
    //   111	120	256	java/io/IOException
  }
  
  public static Bitmap o(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150263);
    Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150263);
      return null;
    }
    paramString = BitmapUtil.getBitmapNative(L(paramString, true), paramInt1, paramInt2);
    AppMethodBeat.o(150263);
    return paramString;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(150249);
    if (iKA == null) {
      iKA = new a(iKv);
    }
    AppMethodBeat.o(150249);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(150244);
    synchronized (this.iKy)
    {
      this.iKy.add(new WeakReference(parama));
      AppMethodBeat.o(150244);
      return;
    }
  }
  
  public final void b(e.a parama)
  {
    AppMethodBeat.i(150245);
    synchronized (this.iKy)
    {
      parama = c(parama);
      if (parama != null) {
        this.iKy.remove(parama);
      }
      AppMethodBeat.o(150245);
      return;
    }
  }
  
  public final boolean bb(String paramString1, String paramString2)
  {
    AppMethodBeat.i(150261);
    try
    {
      BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(paramString1);
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
        Log.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(1) });
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inSampleSize = 1;
        boolean bool = e(paramString2, BitmapUtil.decodeFile(paramString1, localOptions));
        AppMethodBeat.o(150261);
        return bool;
        j = m * 156 / k;
        i = 156;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(150261);
    }
  }
  
  public final Bitmap cW(Context paramContext)
  {
    AppMethodBeat.i(150252);
    paramContext.getResources();
    Bitmap localBitmap = Mk("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!M(localBitmap))
    {
      paramContext = localBitmap;
      if (localBitmap != null)
      {
        Log.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", new Object[] { Boolean.valueOf(localBitmap.isRecycled()), "I_AM_NO_SDCARD_USER_NAME" });
        paramContext = BitmapUtil.getRoundedCornerBitmap(localBitmap, true, 1.0F);
        d("I_AM_NO_SDCARD_USER_NAME", paramContext);
      }
    }
    AppMethodBeat.o(150252);
    return paramContext;
  }
  
  @Deprecated
  public final void d(e.a parama)
  {
    AppMethodBeat.i(150247);
    this.iKx.add(parama, Looper.getMainLooper());
    AppMethodBeat.o(150247);
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150251);
    iKA.c(paramString, paramBitmap);
    paramBitmap = a.a.NAL;
    if (paramBitmap != null) {
      paramBitmap.aer(paramString);
    }
    this.iKx.event(paramString);
    this.iKx.doNotify();
    Log.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
    AppMethodBeat.o(150251);
  }
  
  @Deprecated
  public final void e(e.a parama)
  {
    AppMethodBeat.i(150248);
    this.iKx.remove(parama);
    AppMethodBeat.o(150248);
  }
  
  /* Error */
  final boolean e(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc_w 565
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 336	com/tencent/mm/aj/e:M	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 565
    //   16: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 339	android/graphics/Bitmap:getWidth	()I
    //   25: sipush 156
    //   28: if_icmpne +108 -> 136
    //   31: aload_2
    //   32: invokevirtual 342	android/graphics/Bitmap:getHeight	()I
    //   35: sipush 156
    //   38: if_icmpne +98 -> 136
    //   41: aload_2
    //   42: astore 5
    //   44: aload_2
    //   45: astore 6
    //   47: aload 5
    //   49: ifnull +40 -> 89
    //   52: aload_2
    //   53: astore 6
    //   55: aload 5
    //   57: aload_2
    //   58: if_acmpeq +31 -> 89
    //   61: ldc_w 273
    //   64: ldc_w 567
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_2
    //   74: invokevirtual 568	java/lang/Object:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 358	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_2
    //   82: invokevirtual 571	android/graphics/Bitmap:recycle	()V
    //   85: aload 5
    //   87: astore 6
    //   89: aload_1
    //   90: iconst_0
    //   91: invokestatic 258	com/tencent/mm/aj/e:L	(Ljava/lang/String;Z)Ljava/lang/String;
    //   94: astore_2
    //   95: aload_2
    //   96: iconst_0
    //   97: invokestatic 448	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   100: astore_2
    //   101: aload 6
    //   103: getstatic 577	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   106: bipush 100
    //   108: aload_2
    //   109: invokevirtual 581	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   112: pop
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 457	java/io/OutputStream:close	()V
    //   121: aload_0
    //   122: aload_1
    //   123: aload 6
    //   125: invokevirtual 527	com/tencent/mm/aj/e:d	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   128: ldc_w 565
    //   131: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: iconst_1
    //   135: ireturn
    //   136: aload_2
    //   137: invokevirtual 339	android/graphics/Bitmap:getWidth	()I
    //   140: istore_3
    //   141: aload_2
    //   142: invokevirtual 342	android/graphics/Bitmap:getHeight	()I
    //   145: istore 4
    //   147: iload_3
    //   148: iload 4
    //   150: if_icmpeq +61 -> 211
    //   153: iload_3
    //   154: iload 4
    //   156: if_icmple +37 -> 193
    //   159: aload_2
    //   160: iload_3
    //   161: iload 4
    //   163: isub
    //   164: iconst_2
    //   165: idiv
    //   166: iconst_0
    //   167: iload 4
    //   169: iload 4
    //   171: invokestatic 346	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   174: astore 5
    //   176: aload 5
    //   178: sipush 156
    //   181: sipush 156
    //   184: iconst_1
    //   185: invokestatic 585	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   188: astore 5
    //   190: goto -146 -> 44
    //   193: aload_2
    //   194: iconst_0
    //   195: iload 4
    //   197: iload_3
    //   198: isub
    //   199: iconst_2
    //   200: idiv
    //   201: iload_3
    //   202: iload_3
    //   203: invokestatic 346	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   206: astore 5
    //   208: goto -32 -> 176
    //   211: aload_2
    //   212: sipush 156
    //   215: sipush 156
    //   218: iconst_1
    //   219: invokestatic 585	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   222: astore 5
    //   224: goto -180 -> 44
    //   227: astore 5
    //   229: ldc_w 273
    //   232: ldc_w 587
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_1
    //   242: aastore
    //   243: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload_2
    //   247: invokestatic 336	com/tencent/mm/aj/e:M	(Landroid/graphics/Bitmap;)Z
    //   250: ifeq +27 -> 277
    //   253: ldc_w 273
    //   256: ldc_w 567
    //   259: iconst_1
    //   260: anewarray 4	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload_2
    //   266: invokevirtual 568	java/lang/Object:toString	()Ljava/lang/String;
    //   269: aastore
    //   270: invokestatic 358	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload_2
    //   274: invokevirtual 571	android/graphics/Bitmap:recycle	()V
    //   277: ldc_w 565
    //   280: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_0
    //   284: ireturn
    //   285: astore 5
    //   287: aconst_null
    //   288: astore_2
    //   289: ldc_w 273
    //   292: aload 5
    //   294: ldc_w 461
    //   297: iconst_1
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload_1
    //   304: aastore
    //   305: invokestatic 465	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 457	java/io/OutputStream:close	()V
    //   316: ldc_w 565
    //   319: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iconst_0
    //   323: ireturn
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 457	java/io/OutputStream:close	()V
    //   335: ldc_w 565
    //   338: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_1
    //   342: athrow
    //   343: astore_2
    //   344: goto -223 -> 121
    //   347: astore_1
    //   348: goto -32 -> 316
    //   351: astore_2
    //   352: goto -17 -> 335
    //   355: astore_1
    //   356: goto -29 -> 327
    //   359: astore_1
    //   360: goto -33 -> 327
    //   363: astore 5
    //   365: goto -76 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	this	e
    //   0	368	1	paramString	String
    //   0	368	2	paramBitmap	Bitmap
    //   140	63	3	i	int
    //   145	54	4	j	int
    //   42	181	5	localBitmap1	Bitmap
    //   227	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   285	8	5	localIOException1	java.io.IOException
    //   363	1	5	localIOException2	java.io.IOException
    //   45	79	6	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   136	147	227	java/lang/OutOfMemoryError
    //   159	176	227	java/lang/OutOfMemoryError
    //   176	190	227	java/lang/OutOfMemoryError
    //   193	208	227	java/lang/OutOfMemoryError
    //   211	224	227	java/lang/OutOfMemoryError
    //   95	101	285	java/io/IOException
    //   95	101	324	finally
    //   117	121	343	java/io/IOException
    //   312	316	347	java/io/IOException
    //   331	335	351	java/io/IOException
    //   101	113	355	finally
    //   289	308	359	finally
    //   101	113	363	java/io/IOException
  }
  
  public final boolean h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150260);
    paramArrayOfByte = g(paramString, paramArrayOfByte);
    if (!M(paramArrayOfByte))
    {
      AppMethodBeat.o(150260);
      return false;
    }
    d(paramString, paramArrayOfByte);
    AppMethodBeat.o(150260);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.e
 * JD-Core Version:    0.7.0.1
 */