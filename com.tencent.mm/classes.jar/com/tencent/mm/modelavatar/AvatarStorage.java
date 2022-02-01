package com.tencent.mm.modelavatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.oc;
import com.tencent.mm.b.g;
import com.tencent.mm.by.a.a.a;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.comm.c.d;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AvatarStorage
{
  private static int osa;
  private static int osb;
  static final Map<String, Integer> osc;
  private static MMTrimMemoryEventListener osd;
  private static a osh;
  private MStorageEvent<AvatarStorage.a, String> ose;
  private final List<WeakReference<AvatarStorage.a>> osf;
  private final AvatarStorage.a osg;
  
  static
  {
    AppMethodBeat.i(150268);
    osa = 100;
    osb = 100;
    Object localObject = new ConcurrentHashMap();
    osc = (Map)localObject;
    ((Map)localObject).put("voipapp", Integer.valueOf(c.g.default_voip));
    osc.put("qqmail", Integer.valueOf(c.g.default_qqmail));
    osc.put("fmessage", Integer.valueOf(c.g.default_fmessage));
    osc.put("floatbottle", Integer.valueOf(c.g.default_bottle));
    osc.put("lbsapp", Integer.valueOf(c.g.default_nearby));
    osc.put("shakeapp", Integer.valueOf(c.g.default_shake));
    osc.put("medianote", Integer.valueOf(c.g.default_medianote));
    osc.put("qqfriend", Integer.valueOf(c.g.default_qqfriend));
    osc.put("masssendapp", Integer.valueOf(c.g.default_masssend));
    osc.put("feedsapp", Integer.valueOf(c.g.default_feedsapp));
    osc.put("facebookapp", Integer.valueOf(c.g.default_facebookapp));
    osc.put("newsapp", Integer.valueOf(c.g.default_readerapp));
    osc.put("helper_entry", Integer.valueOf(c.g.default_plugin_icon_contract));
    osc.put("voicevoipapp", Integer.valueOf(c.g.default_voicevoip));
    osc.put("voiceinputapp", Integer.valueOf(c.g.default_voiceinput));
    osc.put("findersayhisessionholder", Integer.valueOf(c.d.icon_filled_nearby_finder));
    osc.put("textstatussayhisessionholder", Integer.valueOf(c.d.icon_filled_nearby_text_status));
    osc.put("officialaccounts", Integer.valueOf(c.g.default_brand_contact));
    osc.put("service_officialaccounts", Integer.valueOf(c.g.default_servicebrand_contact));
    osc.put("linkedinplugin", Integer.valueOf(c.g.default_linkedin));
    osc.put("notifymessage", Integer.valueOf(c.g.default_notify_message_contact));
    osc.put("appbrandcustomerservicemsg", Integer.valueOf(c.g.default_app_brand_service_msg));
    osc.put("appbrand_notify_message", Integer.valueOf(c.g.default_app_brand_notify_msg));
    osc.put("downloaderapp", Integer.valueOf(c.g.default_downloaderapp));
    osc.put("finderaliassessionholder", Integer.valueOf(c.g.icons_finder_msg_alias_holder));
    osc.put("opencustomerservicemsg", Integer.valueOf(c.g.default_open_im_kefu_service));
    osc.put("conversationboxservice", Integer.valueOf(c.g.default_chatroom_box));
    osd = null;
    localObject = new MMTrimMemoryEventListener();
    osd = (MMTrimMemoryEventListener)localObject;
    ((MMTrimMemoryEventListener)localObject).alive();
    osh = new a(osb);
    AppMethodBeat.o(150268);
  }
  
  public AvatarStorage()
  {
    AppMethodBeat.i(150243);
    this.ose = new MStorageEvent() {};
    this.osf = new ArrayList();
    this.osg = new AvatarStorage.2(this);
    reset();
    this.ose.add(this.osg, null);
    AppMethodBeat.o(150243);
  }
  
  public static Bitmap LH(String paramString)
  {
    AppMethodBeat.i(150250);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    Object localObject = osh;
    if (((a)localObject).orD != null) {}
    for (localObject = (Bitmap)((a)localObject).orD.ct(paramString); localObject == null; localObject = (Bitmap)g.a.ag("avatar_cache", paramString))
    {
      AppMethodBeat.o(150250);
      return null;
    }
    if (((Bitmap)localObject).isRecycled())
    {
      localObject = osh;
      if (((a)localObject).orD != null) {
        ((a)localObject).orD.remove(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(150250);
        return null;
        g.a.ah("avatar_cache", paramString);
      }
    }
    AppMethodBeat.o(150250);
    return localObject;
  }
  
  public static Bitmap LI(String paramString)
  {
    AppMethodBeat.i(150258);
    paramString = LL(Q(paramString, false));
    AppMethodBeat.o(150258);
    return paramString;
  }
  
  public static Bitmap LJ(String paramString)
  {
    AppMethodBeat.i(150264);
    Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150264);
      return null;
    }
    paramString = BitmapUtil.getBitmapNative(Q(paramString, true), 1080, 1080);
    AppMethodBeat.o(150264);
    return paramString;
  }
  
  public static Bitmap LK(String paramString)
  {
    AppMethodBeat.i(150265);
    int i = 0;
    if (osc.containsKey(paramString)) {
      i = ((Integer)osc.get(paramString)).intValue();
    }
    if (i != 0) {
      q.bFD();
    }
    for (paramString = com.tencent.mm.compatible.f.a.decodeResource(q.getContext().getResources(), i);; paramString = null)
    {
      paramString = BitmapUtil.getRoundedCornerBitmap(paramString, true, 1.0F, true);
      AppMethodBeat.o(150265);
      return paramString;
    }
  }
  
  public static Bitmap LL(String paramString)
  {
    AppMethodBeat.i(150267);
    if (y.ZC(paramString)) {}
    for (Bitmap localBitmap2 = BitmapUtil.decodeFile(paramString, null);; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = b.LO(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (S(localBitmap1))
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
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); S(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i))
      {
        AppMethodBeat.o(150267);
        return paramString;
      }
      AppMethodBeat.o(150267);
      return null;
    }
  }
  
  public static String Q(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150254);
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    y.bDX(y.bEo(paramString));
    AppMethodBeat.o(150254);
    return paramString;
  }
  
  public static String R(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150255);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150255);
      return null;
    }
    paramString = a(new StringBuilder(128).append(h.baE().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    if (y.bDX(y.bEo(paramString)))
    {
      AppMethodBeat.o(150255);
      return paramString;
    }
    AppMethodBeat.o(150255);
    return null;
  }
  
  private static boolean S(Bitmap paramBitmap)
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
  
  public static boolean S(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(231341);
    paramString = Q(paramString, paramBoolean);
    if ((y.ZC(paramString)) || ((!paramBoolean) && (y.ZC(paramString + ".bm"))))
    {
      AppMethodBeat.o(231341);
      return true;
    }
    AppMethodBeat.o(231341);
    return false;
  }
  
  public static boolean T(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150257);
    String str = Q(paramString, paramBoolean);
    Log.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = y.deleteFile(str);
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
  
  private WeakReference<AvatarStorage.a> c(AvatarStorage.a parama)
  {
    AppMethodBeat.i(150246);
    List localList = this.osf;
    int i = 0;
    try
    {
      while (i < this.osf.size())
      {
        WeakReference localWeakReference = (WeakReference)this.osf.get(i);
        if (localWeakReference != null)
        {
          AvatarStorage.a locala = (AvatarStorage.a)localWeakReference.get();
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
  public static Bitmap i(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 517
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: sipush 156
    //   10: sipush 156
    //   13: invokestatic 521	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   16: astore 5
    //   18: aload 5
    //   20: invokestatic 368	com/tencent/mm/modelavatar/AvatarStorage:S	(Landroid/graphics/Bitmap;)Z
    //   23: ifne +28 -> 51
    //   26: ldc_w 298
    //   29: ldc_w 523
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: ldc_w 517
    //   46: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload 5
    //   53: invokevirtual 371	android/graphics/Bitmap:getWidth	()I
    //   56: istore_2
    //   57: aload 5
    //   59: invokevirtual 374	android/graphics/Bitmap:getHeight	()I
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
    //   87: invokestatic 378	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   90: astore 4
    //   92: aload_0
    //   93: iconst_0
    //   94: invokestatic 291	com/tencent/mm/modelavatar/AvatarStorage:Q	(Ljava/lang/String;Z)Ljava/lang/String;
    //   97: astore 5
    //   99: aload 5
    //   101: iconst_0
    //   102: invokestatic 527	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   105: astore 6
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: invokevirtual 533	java/io/OutputStream:write	([BII)V
    //   120: aload 6
    //   122: ifnull +8 -> 130
    //   125: aload 6
    //   127: invokevirtual 536	java/io/OutputStream:close	()V
    //   130: ldc_w 298
    //   133: ldc_w 538
    //   136: iconst_1
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_0
    //   143: aastore
    //   144: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   147: ldc_w 517
    //   150: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   166: invokestatic 378	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   169: astore 4
    //   171: goto -79 -> 92
    //   174: astore_1
    //   175: aconst_null
    //   176: astore 6
    //   178: aload 6
    //   180: astore 5
    //   182: ldc_w 298
    //   185: aload_1
    //   186: ldc_w 540
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_0
    //   196: aastore
    //   197: invokestatic 544	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 6
    //   202: ifnull +8 -> 210
    //   205: aload 6
    //   207: invokevirtual 536	java/io/OutputStream:close	()V
    //   210: ldc_w 517
    //   213: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aconst_null
    //   217: areturn
    //   218: astore_0
    //   219: aconst_null
    //   220: astore 5
    //   222: aload 5
    //   224: ifnull +8 -> 232
    //   227: aload 5
    //   229: invokevirtual 536	java/io/OutputStream:close	()V
    //   232: ldc_w 517
    //   235: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void reset()
  {
    AppMethodBeat.i(150249);
    if (osh == null) {
      osh = new a(osb);
    }
    AppMethodBeat.o(150249);
  }
  
  public static Bitmap s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150263);
    Log.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s, width:%d, height:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150263);
      return null;
    }
    paramString = BitmapUtil.getBitmapNative(Q(paramString, true), paramInt1, paramInt2);
    AppMethodBeat.o(150263);
    return paramString;
  }
  
  public final void a(AvatarStorage.a parama)
  {
    AppMethodBeat.i(150244);
    synchronized (this.osf)
    {
      this.osf.add(new WeakReference(parama));
      AppMethodBeat.o(150244);
      return;
    }
  }
  
  public final void b(AvatarStorage.a parama)
  {
    AppMethodBeat.i(150245);
    synchronized (this.osf)
    {
      parama = c(parama);
      if (parama != null) {
        this.osf.remove(parama);
      }
      AppMethodBeat.o(150245);
      return;
    }
  }
  
  public final boolean bq(String paramString1, String paramString2)
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
  
  @Deprecated
  public final void d(AvatarStorage.a parama)
  {
    AppMethodBeat.i(150247);
    this.ose.add(parama, Looper.getMainLooper());
    AppMethodBeat.o(150247);
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150251);
    osh.c(paramString, paramBitmap);
    paramBitmap = a.a.acjy;
    if (paramBitmap != null) {
      paramBitmap.aft(paramString);
    }
    this.ose.event(paramString);
    this.ose.doNotify();
    Log.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
    AppMethodBeat.o(150251);
  }
  
  public final Bitmap dO(Context paramContext)
  {
    AppMethodBeat.i(150252);
    paramContext.getResources();
    Bitmap localBitmap = LH("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!S(localBitmap))
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
  public final void e(AvatarStorage.a parama)
  {
    AppMethodBeat.i(150248);
    this.ose.remove(parama);
    AppMethodBeat.o(150248);
  }
  
  /* Error */
  final boolean e(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: ldc_w 644
    //   3: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: invokestatic 368	com/tencent/mm/modelavatar/AvatarStorage:S	(Landroid/graphics/Bitmap;)Z
    //   10: ifne +11 -> 21
    //   13: ldc_w 644
    //   16: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_2
    //   22: invokevirtual 371	android/graphics/Bitmap:getWidth	()I
    //   25: sipush 156
    //   28: if_icmpne +108 -> 136
    //   31: aload_2
    //   32: invokevirtual 374	android/graphics/Bitmap:getHeight	()I
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
    //   61: ldc_w 298
    //   64: ldc_w 646
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_2
    //   74: invokevirtual 647	java/lang/Object:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_2
    //   82: invokevirtual 650	android/graphics/Bitmap:recycle	()V
    //   85: aload 5
    //   87: astore 6
    //   89: aload_1
    //   90: iconst_0
    //   91: invokestatic 291	com/tencent/mm/modelavatar/AvatarStorage:Q	(Ljava/lang/String;Z)Ljava/lang/String;
    //   94: astore_2
    //   95: aload_2
    //   96: iconst_0
    //   97: invokestatic 527	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   100: astore_2
    //   101: aload 6
    //   103: getstatic 656	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   106: bipush 100
    //   108: aload_2
    //   109: invokevirtual 660	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   112: pop
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 536	java/io/OutputStream:close	()V
    //   121: aload_0
    //   122: aload_1
    //   123: aload 6
    //   125: invokevirtual 638	com/tencent/mm/modelavatar/AvatarStorage:d	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   128: ldc_w 644
    //   131: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: iconst_1
    //   135: ireturn
    //   136: aload_2
    //   137: invokevirtual 371	android/graphics/Bitmap:getWidth	()I
    //   140: istore_3
    //   141: aload_2
    //   142: invokevirtual 374	android/graphics/Bitmap:getHeight	()I
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
    //   171: invokestatic 378	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   174: astore 5
    //   176: aload 5
    //   178: sipush 156
    //   181: sipush 156
    //   184: iconst_1
    //   185: invokestatic 664	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
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
    //   203: invokestatic 378	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   206: astore 5
    //   208: goto -32 -> 176
    //   211: aload_2
    //   212: sipush 156
    //   215: sipush 156
    //   218: iconst_1
    //   219: invokestatic 664	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   222: astore 5
    //   224: goto -180 -> 44
    //   227: astore 5
    //   229: ldc_w 298
    //   232: ldc_w 666
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_1
    //   242: aastore
    //   243: invokestatic 490	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload_2
    //   247: invokestatic 368	com/tencent/mm/modelavatar/AvatarStorage:S	(Landroid/graphics/Bitmap;)Z
    //   250: ifeq +27 -> 277
    //   253: ldc_w 298
    //   256: ldc_w 646
    //   259: iconst_1
    //   260: anewarray 4	java/lang/Object
    //   263: dup
    //   264: iconst_0
    //   265: aload_2
    //   266: invokevirtual 647	java/lang/Object:toString	()Ljava/lang/String;
    //   269: aastore
    //   270: invokestatic 436	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload_2
    //   274: invokevirtual 650	android/graphics/Bitmap:recycle	()V
    //   277: ldc_w 644
    //   280: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: iconst_0
    //   284: ireturn
    //   285: astore 5
    //   287: aconst_null
    //   288: astore_2
    //   289: ldc_w 298
    //   292: aload 5
    //   294: ldc_w 540
    //   297: iconst_1
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload_1
    //   304: aastore
    //   305: invokestatic 544	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: aload_2
    //   309: ifnull +7 -> 316
    //   312: aload_2
    //   313: invokevirtual 536	java/io/OutputStream:close	()V
    //   316: ldc_w 644
    //   319: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iconst_0
    //   323: ireturn
    //   324: astore_1
    //   325: aconst_null
    //   326: astore_2
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 536	java/io/OutputStream:close	()V
    //   335: ldc_w 644
    //   338: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	368	0	this	AvatarStorage
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
  
  public final boolean j(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150260);
    paramArrayOfByte = i(paramString, paramArrayOfByte);
    if (!S(paramArrayOfByte))
    {
      AppMethodBeat.o(150260);
      return false;
    }
    d(paramString, paramArrayOfByte);
    AppMethodBeat.o(150260);
    return true;
  }
  
  static class MMTrimMemoryEventListener
    extends IListener<oc>
  {
    public MMTrimMemoryEventListener()
    {
      super();
      AppMethodBeat.i(231322);
      this.__eventId = oc.class.getName().hashCode();
      AppMethodBeat.o(231322);
    }
  }
  
  public static final class b
  {
    /* Error */
    public static boolean LN(String paramString)
    {
      // Byte code:
      //   0: ldc 12
      //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 22	com/tencent/mm/modelavatar/AvatarStorage$b:LO	(Ljava/lang/String;)Landroid/graphics/Bitmap;
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
      //   37: invokestatic 37	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
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
      //   80: invokestatic 66	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
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
      //   115: invokestatic 81	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
    public static Bitmap LO(String paramString)
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
      //   42: invokestatic 90	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
      //   45: ifne +26 -> 71
      //   48: ldc 73
      //   50: ldc 92
      //   52: iconst_1
      //   53: anewarray 4	java/lang/Object
      //   56: dup
      //   57: iconst_0
      //   58: aload 10
      //   60: aastore
      //   61: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   64: ldc 87
      //   66: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   69: aconst_null
      //   70: areturn
      //   71: aload 10
      //   73: invokestatic 100	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
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
      //   95: invokestatic 105	com/tencent/mm/modelavatar/AvatarStorage$b:remove	(Ljava/lang/String;)Z
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
      //   119: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   122: ldc 87
      //   124: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   127: aconst_null
      //   128: areturn
      //   129: aload 10
      //   131: invokestatic 120	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
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
      //   294: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   334: invokestatic 105	com/tencent/mm/modelavatar/AvatarStorage$b:remove	(Ljava/lang/String;)Z
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
      //   382: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   500: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   564: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   627: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      y.deleteFile(paramString + ".bm");
      y.deleteFile(paramString);
      AppMethodBeat.o(150241);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.AvatarStorage
 * JD-Core Version:    0.7.0.1
 */