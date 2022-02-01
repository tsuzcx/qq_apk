package com.tencent.mm.am;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.ce.a.a.a;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  private static int lAA;
  static final Map<String, Integer> lAB;
  private static b lAC;
  private static a lAG;
  private static int lAz;
  private MStorageEvent<f.a, String> lAD;
  private final List<WeakReference<f.a>> lAE;
  private final f.a lAF;
  
  static
  {
    AppMethodBeat.i(150268);
    lAz = 100;
    lAA = 100;
    Object localObject = new ConcurrentHashMap();
    lAB = (Map)localObject;
    ((Map)localObject).put("voipapp", Integer.valueOf(c.g.default_voip));
    lAB.put("qqmail", Integer.valueOf(c.g.default_qqmail));
    lAB.put("fmessage", Integer.valueOf(c.g.default_fmessage));
    lAB.put("floatbottle", Integer.valueOf(c.g.default_bottle));
    lAB.put("lbsapp", Integer.valueOf(c.g.default_nearby));
    lAB.put("shakeapp", Integer.valueOf(c.g.default_shake));
    lAB.put("medianote", Integer.valueOf(c.g.default_medianote));
    lAB.put("qqfriend", Integer.valueOf(c.g.default_qqfriend));
    lAB.put("masssendapp", Integer.valueOf(c.g.default_masssend));
    lAB.put("feedsapp", Integer.valueOf(c.g.default_feedsapp));
    lAB.put("facebookapp", Integer.valueOf(c.g.default_facebookapp));
    lAB.put("newsapp", Integer.valueOf(c.g.default_readerapp));
    lAB.put("helper_entry", Integer.valueOf(c.g.default_plugin_icon_contract));
    lAB.put("voicevoipapp", Integer.valueOf(c.g.default_voicevoip));
    lAB.put("voiceinputapp", Integer.valueOf(c.g.default_voiceinput));
    lAB.put("findersayhisessionholder", Integer.valueOf(c.d.icon_filled_nearby_finder));
    lAB.put("officialaccounts", Integer.valueOf(c.g.default_brand_contact));
    lAB.put("service_officialaccounts", Integer.valueOf(c.g.default_servicebrand_contact));
    lAB.put("linkedinplugin", Integer.valueOf(c.g.default_linkedin));
    lAB.put("notifymessage", Integer.valueOf(c.g.default_notify_message_contact));
    lAB.put("appbrandcustomerservicemsg", Integer.valueOf(c.g.default_app_brand_service_msg));
    lAB.put("appbrand_notify_message", Integer.valueOf(c.g.default_app_brand_notify_msg));
    lAB.put("downloaderapp", Integer.valueOf(c.g.default_downloaderapp));
    lAB.put("finderaliassessionholder", Integer.valueOf(c.g.icons_finder_msg_alias_holder));
    lAC = null;
    localObject = new b();
    lAC = (b)localObject;
    ((b)localObject).alive();
    lAG = new a(lAA);
    AppMethodBeat.o(150268);
  }
  
  public f()
  {
    AppMethodBeat.i(150243);
    this.lAD = new MStorageEvent() {};
    this.lAE = new ArrayList();
    this.lAF = new f.2(this);
    reset();
    this.lAD.add(this.lAF, null);
    AppMethodBeat.o(150243);
  }
  
  private static boolean K(Bitmap paramBitmap)
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
  
  public static String N(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150254);
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    u.bBD(u.bBT(paramString));
    AppMethodBeat.o(150254);
    return paramString;
  }
  
  public static String O(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150255);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150255);
      return null;
    }
    paramString = a(new StringBuilder(128).append(h.aHG().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    if (u.bBD(u.bBT(paramString)))
    {
      AppMethodBeat.o(150255);
      return paramString;
    }
    AppMethodBeat.o(150255);
    return null;
  }
  
  public static boolean P(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150257);
    String str = N(paramString, paramBoolean);
    Log.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = u.deleteFile(str);
    boolean bool1 = bool2;
    if (!paramBoolean) {
      bool1 = bool2 | f.c.remove(str);
    }
    AppMethodBeat.o(150257);
    return bool1;
  }
  
  public static Bitmap TF(String paramString)
  {
    AppMethodBeat.i(150250);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    Object localObject = lAG;
    if (((a)localObject).lAc != null) {}
    for (localObject = (Bitmap)((a)localObject).lAc.aX(paramString); localObject == null; localObject = (Bitmap)g.a.ab("avatar_cache", paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = lAG;
      if (((a)localObject).lAc != null) {
        ((a)localObject).lAc.remove(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(150250);
        return null;
        g.a.ac("avatar_cache", paramString);
      }
    }
    AppMethodBeat.o(150250);
    return localObject;
  }
  
  public static String TG(String paramString)
  {
    AppMethodBeat.i(229796);
    paramString = O(paramString, false);
    AppMethodBeat.o(229796);
    return paramString;
  }
  
  public static boolean TH(String paramString)
  {
    AppMethodBeat.i(150256);
    paramString = N(paramString, false);
    if ((u.agG(paramString)) || (u.agG(paramString + ".bm")))
    {
      AppMethodBeat.o(150256);
      return true;
    }
    AppMethodBeat.o(150256);
    return false;
  }
  
  public static Bitmap TI(String paramString)
  {
    AppMethodBeat.i(150258);
    paramString = TL(N(paramString, false));
    AppMethodBeat.o(150258);
    return paramString;
  }
  
  public static Bitmap TJ(String paramString)
  {
    AppMethodBeat.i(150264);
    Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150264);
      return null;
    }
    paramString = BitmapUtil.getBitmapNative(N(paramString, true), 1080, 1080);
    AppMethodBeat.o(150264);
    return paramString;
  }
  
  public static Bitmap TK(String paramString)
  {
    AppMethodBeat.i(150265);
    int i = 0;
    if (lAB.containsKey(paramString)) {
      i = ((Integer)lAB.get(paramString)).intValue();
    }
    if (i != 0) {
      q.bhO();
    }
    for (paramString = com.tencent.mm.compatible.f.a.decodeResource(q.getContext().getResources(), i);; paramString = null)
    {
      paramString = BitmapUtil.getRoundedCornerBitmap(paramString, true, 1.0F, true);
      AppMethodBeat.o(150265);
      return paramString;
    }
  }
  
  public static Bitmap TL(String paramString)
  {
    AppMethodBeat.i(150267);
    if (u.agG(paramString)) {}
    for (Bitmap localBitmap2 = BitmapUtil.decodeFile(paramString, null);; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = f.c.TO(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (K(localBitmap1))
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
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); K(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        AppMethodBeat.o(150267);
        return paramString;
      }
      AppMethodBeat.o(150267);
      return null;
    }
  }
  
  private static StringBuilder a(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150253);
    paramString = g.getMessageDigest(paramString.getBytes());
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
  
  private WeakReference<f.a> c(f.a parama)
  {
    AppMethodBeat.i(150246);
    List localList = this.lAE;
    int i = 0;
    try
    {
      while (i < this.lAE.size())
      {
        WeakReference localWeakReference = (WeakReference)this.lAE.get(i);
        if (localWeakReference != null)
        {
          f.a locala = (f.a)localWeakReference.get();
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
    //   0: ldc_w 508
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: sipush 156
    //   10: sipush 156
    //   13: invokestatic 512	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   16: astore 5
    //   18: aload 5
    //   20: invokestatic 421	com/tencent/mm/am/f:K	(Landroid/graphics/Bitmap;)Z
    //   23: ifne +28 -> 51
    //   26: ldc_w 297
    //   29: ldc_w 514
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc_w 508
    //   46: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload 5
    //   53: invokevirtual 424	android/graphics/Bitmap:getWidth	()I
    //   56: istore_2
    //   57: aload 5
    //   59: invokevirtual 427	android/graphics/Bitmap:getHeight	()I
    //   62: istore_3
    //   63: aload 5
    //   65: astore 4
    //   67: iload_2
    //   68: iload_3
    //   69: if_icmpeq +23 -> 92
    //   72: iload_2
    //   73: iload_3
    //   74: if_icmple +81 -> 155
    //   77: aload 5
    //   79: iload_2
    //   80: iload_3
    //   81: isub
    //   82: iconst_2
    //   83: idiv
    //   84: iconst_0
    //   85: iload_3
    //   86: iload_3
    //   87: invokestatic 431	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   90: astore 4
    //   92: aload_0
    //   93: iconst_0
    //   94: invokestatic 295	com/tencent/mm/am/f:N	(Ljava/lang/String;Z)Ljava/lang/String;
    //   97: astore 5
    //   99: aload 5
    //   101: invokestatic 518	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   104: astore 6
    //   106: aload 6
    //   108: astore 5
    //   110: aload 6
    //   112: aload_1
    //   113: iconst_0
    //   114: aload_1
    //   115: arraylength
    //   116: invokevirtual 524	java/io/OutputStream:write	([BII)V
    //   119: aload 6
    //   121: ifnull +8 -> 129
    //   124: aload 6
    //   126: invokevirtual 527	java/io/OutputStream:close	()V
    //   129: ldc_w 297
    //   132: ldc_w 529
    //   135: iconst_1
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_0
    //   142: aastore
    //   143: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc_w 508
    //   149: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload 4
    //   154: areturn
    //   155: aload 5
    //   157: iconst_0
    //   158: iload_3
    //   159: iload_2
    //   160: isub
    //   161: iconst_2
    //   162: idiv
    //   163: iload_2
    //   164: iload_2
    //   165: invokestatic 431	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   168: astore 4
    //   170: goto -78 -> 92
    //   173: astore_1
    //   174: aconst_null
    //   175: astore 6
    //   177: aload 6
    //   179: astore 5
    //   181: ldc_w 297
    //   184: aload_1
    //   185: ldc_w 531
    //   188: iconst_1
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_0
    //   195: aastore
    //   196: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aload 6
    //   201: ifnull +8 -> 209
    //   204: aload 6
    //   206: invokevirtual 527	java/io/OutputStream:close	()V
    //   209: ldc_w 508
    //   212: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aconst_null
    //   219: astore 5
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 527	java/io/OutputStream:close	()V
    //   231: ldc_w 508
    //   234: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_0
    //   238: athrow
    //   239: astore_1
    //   240: goto -111 -> 129
    //   243: astore_0
    //   244: goto -35 -> 209
    //   247: astore_1
    //   248: goto -17 -> 231
    //   251: astore_0
    //   252: goto -31 -> 221
    //   255: astore_1
    //   256: goto -79 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	paramString	String
    //   0	259	1	paramArrayOfByte	byte[]
    //   56	109	2	i	int
    //   62	99	3	j	int
    //   65	104	4	localObject1	Object
    //   16	211	5	localObject2	Object
    //   104	101	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   99	106	173	java/io/IOException
    //   99	106	217	finally
    //   124	129	239	java/io/IOException
    //   204	209	243	java/io/IOException
    //   226	231	247	java/io/IOException
    //   110	119	251	finally
    //   181	199	251	finally
    //   110	119	255	java/io/IOException
  }
  
  public static Bitmap p(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150263);
    Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150263);
      return null;
    }
    paramString = BitmapUtil.getBitmapNative(N(paramString, true), paramInt1, paramInt2);
    AppMethodBeat.o(150263);
    return paramString;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(150249);
    if (lAG == null) {
      lAG = new a(lAA);
    }
    AppMethodBeat.o(150249);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(150244);
    synchronized (this.lAE)
    {
      this.lAE.add(new WeakReference(parama));
      AppMethodBeat.o(150244);
      return;
    }
  }
  
  public final void b(f.a parama)
  {
    AppMethodBeat.i(150245);
    synchronized (this.lAE)
    {
      parama = c(parama);
      if (parama != null) {
        this.lAE.remove(parama);
      }
      AppMethodBeat.o(150245);
      return;
    }
  }
  
  public final boolean bg(String paramString1, String paramString2)
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
  
  public final Bitmap cT(Context paramContext)
  {
    AppMethodBeat.i(150252);
    paramContext.getResources();
    Bitmap localBitmap = TF("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!K(localBitmap))
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
  public final void d(f.a parama)
  {
    AppMethodBeat.i(150247);
    this.lAD.add(parama, Looper.getMainLooper());
    AppMethodBeat.o(150247);
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150251);
    lAG.c(paramString, paramBitmap);
    paramBitmap = a.a.UOn;
    if (paramBitmap != null) {
      paramBitmap.aml(paramString);
    }
    this.lAD.event(paramString);
    this.lAD.doNotify();
    Log.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
    AppMethodBeat.o(150251);
  }
  
  @Deprecated
  public final void e(f.a parama)
  {
    AppMethodBeat.i(150248);
    this.lAD.remove(parama);
    AppMethodBeat.o(150248);
  }
  
  /* Error */
  final boolean e(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc_w 635
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 421	com/tencent/mm/am/f:K	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 635
    //   16: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 424	android/graphics/Bitmap:getWidth	()I
    //   25: sipush 156
    //   28: if_icmpne +107 -> 135
    //   31: aload_2
    //   32: invokevirtual 427	android/graphics/Bitmap:getHeight	()I
    //   35: sipush 156
    //   38: if_icmpne +97 -> 135
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
    //   61: ldc_w 297
    //   64: ldc_w 637
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_2
    //   74: invokevirtual 638	java/lang/Object:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_2
    //   82: invokevirtual 641	android/graphics/Bitmap:recycle	()V
    //   85: aload 5
    //   87: astore 6
    //   89: aload_1
    //   90: iconst_0
    //   91: invokestatic 295	com/tencent/mm/am/f:N	(Ljava/lang/String;Z)Ljava/lang/String;
    //   94: astore_2
    //   95: aload_2
    //   96: invokestatic 518	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   99: astore_2
    //   100: aload 6
    //   102: getstatic 647	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   105: bipush 100
    //   107: aload_2
    //   108: invokevirtual 651	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   111: pop
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 527	java/io/OutputStream:close	()V
    //   120: aload_0
    //   121: aload_1
    //   122: aload 6
    //   124: invokevirtual 597	com/tencent/mm/am/f:d	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   127: ldc_w 635
    //   130: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_1
    //   134: ireturn
    //   135: aload_2
    //   136: invokevirtual 424	android/graphics/Bitmap:getWidth	()I
    //   139: istore_3
    //   140: aload_2
    //   141: invokevirtual 427	android/graphics/Bitmap:getHeight	()I
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
    //   170: invokestatic 431	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   173: astore 5
    //   175: aload 5
    //   177: sipush 156
    //   180: sipush 156
    //   183: iconst_1
    //   184: invokestatic 655	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
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
    //   202: invokestatic 431	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   205: astore 5
    //   207: goto -32 -> 175
    //   210: aload_2
    //   211: sipush 156
    //   214: sipush 156
    //   217: iconst_1
    //   218: invokestatic 655	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   221: astore 5
    //   223: goto -179 -> 44
    //   226: astore 5
    //   228: ldc_w 297
    //   231: ldc_w 657
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_1
    //   241: aastore
    //   242: invokestatic 480	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: aload_2
    //   246: invokestatic 421	com/tencent/mm/am/f:K	(Landroid/graphics/Bitmap;)Z
    //   249: ifeq +27 -> 276
    //   252: ldc_w 297
    //   255: ldc_w 637
    //   258: iconst_1
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload_2
    //   265: invokevirtual 638	java/lang/Object:toString	()Ljava/lang/String;
    //   268: aastore
    //   269: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aload_2
    //   273: invokevirtual 641	android/graphics/Bitmap:recycle	()V
    //   276: ldc_w 635
    //   279: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: iconst_0
    //   283: ireturn
    //   284: astore 5
    //   286: aconst_null
    //   287: astore_2
    //   288: ldc_w 297
    //   291: aload 5
    //   293: ldc_w 531
    //   296: iconst_1
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload_1
    //   303: aastore
    //   304: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: aload_2
    //   308: ifnull +7 -> 315
    //   311: aload_2
    //   312: invokevirtual 527	java/io/OutputStream:close	()V
    //   315: ldc_w 635
    //   318: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: iconst_0
    //   322: ireturn
    //   323: astore_1
    //   324: aconst_null
    //   325: astore_2
    //   326: aload_2
    //   327: ifnull +7 -> 334
    //   330: aload_2
    //   331: invokevirtual 527	java/io/OutputStream:close	()V
    //   334: ldc_w 635
    //   337: invokestatic 203	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload_1
    //   341: athrow
    //   342: astore_2
    //   343: goto -223 -> 120
    //   346: astore_1
    //   347: goto -32 -> 315
    //   350: astore_2
    //   351: goto -17 -> 334
    //   354: astore_1
    //   355: goto -29 -> 326
    //   358: astore_1
    //   359: goto -33 -> 326
    //   362: astore 5
    //   364: goto -76 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	f
    //   0	367	1	paramString	String
    //   0	367	2	paramBitmap	Bitmap
    //   139	63	3	i	int
    //   144	54	4	j	int
    //   42	180	5	localBitmap1	Bitmap
    //   226	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   284	8	5	localIOException1	java.io.IOException
    //   362	1	5	localIOException2	java.io.IOException
    //   45	78	6	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   135	146	226	java/lang/OutOfMemoryError
    //   158	175	226	java/lang/OutOfMemoryError
    //   175	189	226	java/lang/OutOfMemoryError
    //   192	207	226	java/lang/OutOfMemoryError
    //   210	223	226	java/lang/OutOfMemoryError
    //   95	100	284	java/io/IOException
    //   95	100	323	finally
    //   116	120	342	java/io/IOException
    //   311	315	346	java/io/IOException
    //   330	334	350	java/io/IOException
    //   100	112	354	finally
    //   288	307	358	finally
    //   100	112	362	java/io/IOException
  }
  
  public final boolean h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150260);
    paramArrayOfByte = g(paramString, paramArrayOfByte);
    if (!K(paramArrayOfByte))
    {
      AppMethodBeat.o(150260);
      return false;
    }
    d(paramString, paramArrayOfByte);
    AppMethodBeat.o(150260);
    return true;
  }
  
  static final class b
    extends IListener<mv>
  {
    public b()
    {
      AppMethodBeat.i(196272);
      this.__eventId = mv.class.getName().hashCode();
      AppMethodBeat.o(196272);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.f
 * JD-Core Version:    0.7.0.1
 */