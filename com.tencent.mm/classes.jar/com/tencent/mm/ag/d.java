package com.tencent.mm.ag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.e.a;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public final class d
{
  private static int ebr = 150;
  private static int ebs = 150;
  static final Map<String, Integer> ebt;
  private static a ebx = new a(ebs);
  private k<a, String> ebu = new k() {};
  private Vector<WeakReference<a>> ebv = new Vector();
  private final a ebw = new a()
  {
    public final void kk(String paramAnonymousString)
    {
      Vector localVector2 = new Vector();
      y.d("MicroMsg.AvatarStorage", "notifyChanged user:%s clonesize:%d watchers:%d", new Object[] { paramAnonymousString, Integer.valueOf(d.a(d.this).size()), Integer.valueOf(d.a(d.this).size()) });
      Vector localVector3 = new Vector();
      Vector localVector1 = d.a(d.this);
      int i = 0;
      for (;;)
      {
        try
        {
          if (i < d.a(d.this).size())
          {
            WeakReference localWeakReference = (WeakReference)d.a(d.this).get(i);
            if (localWeakReference == null) {
              break label203;
            }
            d.a locala = (d.a)localWeakReference.get();
            if (locala != null) {
              localVector3.add(locala);
            } else {
              localVector2.add(localWeakReference);
            }
          }
        }
        finally {}
        d.a(d.this).removeAll(localVector2);
        i = 0;
        while (i < localVector3.size())
        {
          ((d.a)localVector3.get(i)).kk(paramAnonymousString);
          i += 1;
        }
        return;
        label203:
        i += 1;
      }
    }
  };
  
  static
  {
    HashMap localHashMap = new HashMap();
    ebt = localHashMap;
    localHashMap.put("voipapp", Integer.valueOf(a.g.default_voip));
    ebt.put("qqmail", Integer.valueOf(a.g.default_qqmail));
    ebt.put("fmessage", Integer.valueOf(a.g.default_fmessage));
    ebt.put("floatbottle", Integer.valueOf(a.g.default_bottle));
    ebt.put("lbsapp", Integer.valueOf(a.g.default_nearby));
    ebt.put("shakeapp", Integer.valueOf(a.g.default_shake));
    ebt.put("medianote", Integer.valueOf(a.g.default_medianote));
    ebt.put("qqfriend", Integer.valueOf(a.g.default_qqfriend));
    ebt.put("masssendapp", Integer.valueOf(a.g.default_masssend));
    ebt.put("feedsapp", Integer.valueOf(a.g.default_feedsapp));
    ebt.put("facebookapp", Integer.valueOf(a.g.default_facebookapp));
    ebt.put("newsapp", Integer.valueOf(a.g.default_readerapp));
    ebt.put("helper_entry", Integer.valueOf(a.g.default_plugin_icon_contract));
    ebt.put("voicevoipapp", Integer.valueOf(a.g.default_voicevoip));
    ebt.put("voiceinputapp", Integer.valueOf(a.g.default_voiceinput));
    ebt.put("officialaccounts", Integer.valueOf(a.g.default_brand_contact));
    ebt.put("service_officialaccounts", Integer.valueOf(a.g.default_servicebrand_contact));
    ebt.put("linkedinplugin", Integer.valueOf(a.g.default_linkedin));
    ebt.put("notifymessage", Integer.valueOf(a.g.default_notify_message_contact));
    ebt.put("appbrandcustomerservicemsg", Integer.valueOf(a.g.default_app_brand_service_msg));
    ebt.put("downloaderapp", Integer.valueOf(a.g.default_downloaderapp));
  }
  
  public d()
  {
    reset();
    this.ebu.a(this.ebw, null);
  }
  
  public static String A(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {}
    do
    {
      return null;
      paramString = a(new StringBuilder(128).append(com.tencent.mm.kernel.g.DP().cachePath).append("avatar/"), paramString, paramBoolean).toString();
    } while (!com.tencent.mm.vfs.e.nb(com.tencent.mm.vfs.e.aeS(paramString)));
    return paramString;
  }
  
  public static boolean B(String paramString, boolean paramBoolean)
  {
    String str = z(paramString, paramBoolean);
    y.i("MicroMsg.AvatarStorage", "Removed avatar: %s, hd: %b, path: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), str });
    boolean bool2 = com.tencent.mm.vfs.e.deleteFile(str);
    boolean bool1 = bool2;
    if (!paramBoolean) {
      bool1 = bool2 | b.ey(str);
    }
    return bool1;
  }
  
  private static StringBuilder a(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    paramString = com.tencent.mm.a.g.o(paramString.getBytes());
    paramStringBuilder.append(paramString.substring(0, 2)).append('/').append(paramString.substring(2, 4)).append('/').append("user_");
    if (paramBoolean) {
      paramStringBuilder.append("hd_");
    }
    return paramStringBuilder.append(paramString).append(".png");
  }
  
  public static void a(Context paramContext, ImageView paramImageView, int paramInt)
  {
    try
    {
      paramImageView.setImageBitmap(c.a(com.tencent.mm.compatible.g.a.decodeResource(paramContext.getResources(), paramInt), true, 1.0F));
      return;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bk.j(paramContext) });
    }
  }
  
  private WeakReference<a> c(a parama)
  {
    Vector localVector = this.ebv;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.ebv.size())
        {
          WeakReference localWeakReference = (WeakReference)this.ebv.get(i);
          if (localWeakReference != null)
          {
            a locala = (a)localWeakReference.get();
            if ((locala != null) && (locala.equals(parama))) {
              return localWeakReference;
            }
          }
        }
        else
        {
          return null;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  /* Error */
  public static Bitmap g(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: bipush 96
    //   3: bipush 96
    //   5: iconst_2
    //   6: newarray int
    //   8: dup
    //   9: iconst_0
    //   10: iconst_0
    //   11: iastore
    //   12: dup
    //   13: iconst_1
    //   14: iconst_1
    //   15: iastore
    //   16: invokestatic 352	com/tencent/mm/sdk/platformtools/c:a	([BII[I)Landroid/graphics/Bitmap;
    //   19: astore 5
    //   21: aload 5
    //   23: invokestatic 356	com/tencent/mm/ag/d:s	(Landroid/graphics/Bitmap;)Z
    //   26: ifne +21 -> 47
    //   29: ldc 244
    //   31: ldc_w 358
    //   34: iconst_1
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: aastore
    //   42: invokestatic 324	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: aconst_null
    //   46: areturn
    //   47: aload 5
    //   49: invokevirtual 363	android/graphics/Bitmap:getWidth	()I
    //   52: istore_2
    //   53: aload 5
    //   55: invokevirtual 366	android/graphics/Bitmap:getHeight	()I
    //   58: istore_3
    //   59: aload 5
    //   61: astore 4
    //   63: iload_2
    //   64: iload_3
    //   65: if_icmpeq +23 -> 88
    //   68: iload_2
    //   69: iload_3
    //   70: if_icmple +75 -> 145
    //   73: aload 5
    //   75: iload_2
    //   76: iload_3
    //   77: isub
    //   78: iconst_2
    //   79: idiv
    //   80: iconst_0
    //   81: iload_3
    //   82: iload_3
    //   83: invokestatic 370	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   86: astore 4
    //   88: aload_0
    //   89: iconst_0
    //   90: invokestatic 242	com/tencent/mm/ag/d:z	(Ljava/lang/String;Z)Ljava/lang/String;
    //   93: astore 5
    //   95: aload 5
    //   97: iconst_0
    //   98: invokestatic 373	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   101: astore 6
    //   103: aload 6
    //   105: astore 5
    //   107: aload 6
    //   109: aload_1
    //   110: iconst_0
    //   111: aload_1
    //   112: arraylength
    //   113: invokevirtual 379	java/io/OutputStream:write	([BII)V
    //   116: aload 6
    //   118: ifnull +8 -> 126
    //   121: aload 6
    //   123: invokevirtual 382	java/io/OutputStream:close	()V
    //   126: ldc 244
    //   128: ldc_w 384
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: aastore
    //   139: invokestatic 257	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload 4
    //   144: areturn
    //   145: aload 5
    //   147: iconst_0
    //   148: iload_3
    //   149: iload_2
    //   150: isub
    //   151: iconst_2
    //   152: idiv
    //   153: iload_2
    //   154: iload_2
    //   155: invokestatic 370	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   158: astore 4
    //   160: goto -72 -> 88
    //   163: astore_1
    //   164: aconst_null
    //   165: astore 6
    //   167: aload 6
    //   169: astore 5
    //   171: ldc 244
    //   173: aload_1
    //   174: ldc_w 386
    //   177: iconst_1
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_0
    //   184: aastore
    //   185: invokestatic 390	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 6
    //   190: ifnull +8 -> 198
    //   193: aload 6
    //   195: invokevirtual 382	java/io/OutputStream:close	()V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_0
    //   201: aconst_null
    //   202: astore 5
    //   204: aload 5
    //   206: ifnull +8 -> 214
    //   209: aload 5
    //   211: invokevirtual 382	java/io/OutputStream:close	()V
    //   214: aload_0
    //   215: athrow
    //   216: astore_1
    //   217: goto -91 -> 126
    //   220: astore_0
    //   221: goto -23 -> 198
    //   224: astore_1
    //   225: goto -11 -> 214
    //   228: astore_0
    //   229: goto -25 -> 204
    //   232: astore_1
    //   233: goto -66 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramString	String
    //   0	236	1	paramArrayOfByte	byte[]
    //   52	103	2	i	int
    //   58	93	3	j	int
    //   61	98	4	localObject1	Object
    //   19	191	5	localObject2	Object
    //   101	93	6	localOutputStream	java.io.OutputStream
    // Exception table:
    //   from	to	target	type
    //   95	103	163	java/io/IOException
    //   95	103	200	finally
    //   121	126	216	java/io/IOException
    //   193	198	220	java/io/IOException
    //   209	214	224	java/io/IOException
    //   107	116	228	finally
    //   171	188	228	finally
    //   107	116	232	java/io/IOException
  }
  
  public static Bitmap kf(String paramString)
  {
    Object localObject2;
    if (bk.bl(paramString)) {
      localObject2 = null;
    }
    do
    {
      return localObject2;
      localObject1 = ebx;
      if (((a)localObject1).eaZ != null) {}
      for (localObject1 = (Bitmap)((a)localObject1).eaZ.get(paramString); localObject1 == null; localObject1 = (Bitmap)e.a.A("avatar_cache", paramString)) {
        return null;
      }
      localObject2 = localObject1;
    } while (!((Bitmap)localObject1).isRecycled());
    Object localObject1 = ebx;
    if (((a)localObject1).eaZ != null) {
      ((a)localObject1).eaZ.remove(paramString);
    }
    for (;;)
    {
      return null;
      e.a.B("avatar_cache", paramString);
    }
  }
  
  public static Bitmap kg(String paramString)
  {
    return kj(z(paramString, false));
  }
  
  public static Bitmap kh(String paramString)
  {
    y.d("MicroMsg.AvatarStorage", "getHDBitmap user:%s", new Object[] { paramString });
    if (bk.bl(paramString)) {
      return null;
    }
    return c.a(z(paramString, true), 480, 480, null, 0, new int[] { 0, 1 });
  }
  
  public static Bitmap ki(String paramString)
  {
    int i = 0;
    if (ebt.containsKey(paramString)) {
      i = ((Integer)ebt.get(paramString)).intValue();
    }
    if (i != 0) {
      o.Kg();
    }
    for (paramString = com.tencent.mm.compatible.g.a.decodeResource(o.getContext().getResources(), i);; paramString = null) {
      return c.a(paramString, true, 1.0F, true);
    }
  }
  
  public static Bitmap kj(String paramString)
  {
    if (com.tencent.mm.vfs.e.bK(paramString)) {}
    for (Bitmap localBitmap2 = c.a(paramString, null, 0, new int[] { 0, 1 });; localBitmap2 = null)
    {
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = b.km(paramString);
      }
      paramString = localBitmap1;
      int i;
      int j;
      if (s(localBitmap1))
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
      for (paramString = Bitmap.createBitmap(localBitmap1, (i - j) / 2, 0, j, j); s(paramString); paramString = Bitmap.createBitmap(localBitmap1, 0, (j - i) / 2, i, i)) {
        return paramString;
      }
      return null;
    }
  }
  
  public static void reset()
  {
    if (ebx == null) {
      ebx = new a(ebs);
    }
  }
  
  private static boolean s(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  public static String z(String paramString, boolean paramBoolean)
  {
    paramString = a(new StringBuilder(64).append("wcf://avatar/"), paramString, paramBoolean).toString();
    com.tencent.mm.vfs.e.nb(com.tencent.mm.vfs.e.aeS(paramString));
    return paramString;
  }
  
  public final void a(a parama)
  {
    synchronized (this.ebv)
    {
      this.ebv.add(new WeakReference(parama));
      return;
    }
  }
  
  public final boolean ai(String paramString1, String paramString2)
  {
    try
    {
      BitmapFactory.Options localOptions = c.YU(paramString1);
      int k = localOptions.outWidth;
      int m = localOptions.outHeight;
      int j;
      int i;
      if (m < k)
      {
        j = k * 96 / m;
        i = 96;
      }
      for (;;)
      {
        y.d("MicroMsg.AvatarStorage", "inJustDecodeBounds old [w:%d h:%d]  new [w:%d h:%d] corner:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(1) });
        localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        localOptions.inSampleSize = Math.min(k / j, m / i);
        return e(paramString2, c.a(paramString1, localOptions, 0, new int[] { 0, 1 }));
        i = m * 96 / k;
        j = 96;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      y.e("MicroMsg.AvatarStorage", "exception:%s", new Object[] { bk.j(paramString1) });
    }
  }
  
  public final void b(a parama)
  {
    synchronized (this.ebv)
    {
      this.ebv.remove(c(parama));
      return;
    }
  }
  
  public final Bitmap bv(Context paramContext)
  {
    paramContext.getResources();
    Bitmap localBitmap = kf("I_AM_NO_SDCARD_USER_NAME");
    paramContext = localBitmap;
    if (!s(localBitmap))
    {
      paramContext = localBitmap;
      if (localBitmap != null)
      {
        y.i("MicroMsg.AvatarStorage", "not cached, recycled=%b, reload=%s", new Object[] { Boolean.valueOf(localBitmap.isRecycled()), "I_AM_NO_SDCARD_USER_NAME" });
        paramContext = c.a(localBitmap, true, 1.0F);
        d("I_AM_NO_SDCARD_USER_NAME", paramContext);
      }
    }
    return paramContext;
  }
  
  @Deprecated
  public final void d(a parama)
  {
    this.ebu.a(parama, Looper.getMainLooper());
  }
  
  public final void d(String paramString, Bitmap paramBitmap)
  {
    a locala = ebx;
    if (locala.eaZ != null) {
      locala.eaZ.f(paramString, paramBitmap);
    }
    for (;;)
    {
      this.ebu.bV(paramString);
      this.ebu.doNotify();
      y.d("MicroMsg.AvatarStorage", "setToCache %s", new Object[] { paramString });
      return;
      e.a.a("avatar_cache", paramString, paramBitmap);
    }
  }
  
  @Deprecated
  public final void e(a parama)
  {
    this.ebu.remove(parama);
  }
  
  /* Error */
  final boolean e(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 356	com/tencent/mm/ag/d:s	(Landroid/graphics/Bitmap;)Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_2
    //   10: invokevirtual 363	android/graphics/Bitmap:getWidth	()I
    //   13: bipush 96
    //   15: if_icmpne +100 -> 115
    //   18: aload_2
    //   19: invokevirtual 366	android/graphics/Bitmap:getHeight	()I
    //   22: bipush 96
    //   24: if_icmpne +91 -> 115
    //   27: aload_2
    //   28: astore 5
    //   30: aload_2
    //   31: astore 6
    //   33: aload 5
    //   35: ifnull +39 -> 74
    //   38: aload_2
    //   39: astore 6
    //   41: aload 5
    //   43: aload_2
    //   44: if_acmpeq +30 -> 74
    //   47: ldc 244
    //   49: ldc_w 552
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_2
    //   59: invokevirtual 553	java/lang/Object:toString	()Ljava/lang/String;
    //   62: aastore
    //   63: invokestatic 257	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: aload_2
    //   67: invokevirtual 556	android/graphics/Bitmap:recycle	()V
    //   70: aload 5
    //   72: astore 6
    //   74: aload_1
    //   75: iconst_0
    //   76: invokestatic 242	com/tencent/mm/ag/d:z	(Ljava/lang/String;Z)Ljava/lang/String;
    //   79: astore_2
    //   80: aload_2
    //   81: iconst_0
    //   82: invokestatic 373	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   85: astore_2
    //   86: aload 6
    //   88: getstatic 562	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   91: bipush 100
    //   93: aload_2
    //   94: invokevirtual 566	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   97: pop
    //   98: aload_2
    //   99: ifnull +7 -> 106
    //   102: aload_2
    //   103: invokevirtual 382	java/io/OutputStream:close	()V
    //   106: aload_0
    //   107: aload_1
    //   108: aload 6
    //   110: invokevirtual 523	com/tencent/mm/ag/d:d	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   113: iconst_1
    //   114: ireturn
    //   115: aload_2
    //   116: invokevirtual 363	android/graphics/Bitmap:getWidth	()I
    //   119: istore_3
    //   120: aload_2
    //   121: invokevirtual 366	android/graphics/Bitmap:getHeight	()I
    //   124: istore 4
    //   126: iload_3
    //   127: iload 4
    //   129: if_icmpeq +59 -> 188
    //   132: iload_3
    //   133: iload 4
    //   135: if_icmple +35 -> 170
    //   138: aload_2
    //   139: iload_3
    //   140: iload 4
    //   142: isub
    //   143: iconst_2
    //   144: idiv
    //   145: iconst_0
    //   146: iload 4
    //   148: iload 4
    //   150: invokestatic 370	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   153: astore 5
    //   155: aload 5
    //   157: bipush 96
    //   159: bipush 96
    //   161: iconst_1
    //   162: invokestatic 570	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   165: astore 5
    //   167: goto -137 -> 30
    //   170: aload_2
    //   171: iconst_0
    //   172: iload 4
    //   174: iload_3
    //   175: isub
    //   176: iconst_2
    //   177: idiv
    //   178: iload_3
    //   179: iload_3
    //   180: invokestatic 370	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   183: astore 5
    //   185: goto -30 -> 155
    //   188: aload_2
    //   189: bipush 96
    //   191: bipush 96
    //   193: iconst_1
    //   194: invokestatic 570	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   197: astore 5
    //   199: goto -169 -> 30
    //   202: astore 5
    //   204: ldc 244
    //   206: ldc_w 572
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_1
    //   216: aastore
    //   217: invokestatic 324	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload_2
    //   221: invokestatic 356	com/tencent/mm/ag/d:s	(Landroid/graphics/Bitmap;)Z
    //   224: ifeq +26 -> 250
    //   227: ldc 244
    //   229: ldc_w 552
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload_2
    //   239: invokevirtual 553	java/lang/Object:toString	()Ljava/lang/String;
    //   242: aastore
    //   243: invokestatic 257	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: aload_2
    //   247: invokevirtual 556	android/graphics/Bitmap:recycle	()V
    //   250: iconst_0
    //   251: ireturn
    //   252: astore 5
    //   254: aconst_null
    //   255: astore_2
    //   256: ldc 244
    //   258: aload 5
    //   260: ldc_w 386
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: aload_1
    //   270: aastore
    //   271: invokestatic 390	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload_2
    //   275: ifnull +7 -> 282
    //   278: aload_2
    //   279: invokevirtual 382	java/io/OutputStream:close	()V
    //   282: iconst_0
    //   283: ireturn
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_2
    //   287: aload_2
    //   288: ifnull +7 -> 295
    //   291: aload_2
    //   292: invokevirtual 382	java/io/OutputStream:close	()V
    //   295: aload_1
    //   296: athrow
    //   297: astore_2
    //   298: goto -192 -> 106
    //   301: astore_1
    //   302: goto -20 -> 282
    //   305: astore_2
    //   306: goto -11 -> 295
    //   309: astore_1
    //   310: goto -23 -> 287
    //   313: astore_1
    //   314: goto -27 -> 287
    //   317: astore 5
    //   319: goto -63 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	d
    //   0	322	1	paramString	String
    //   0	322	2	paramBitmap	Bitmap
    //   119	61	3	i	int
    //   124	52	4	j	int
    //   28	170	5	localBitmap1	Bitmap
    //   202	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   252	7	5	localIOException1	java.io.IOException
    //   317	1	5	localIOException2	java.io.IOException
    //   31	78	6	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   115	126	202	java/lang/OutOfMemoryError
    //   138	155	202	java/lang/OutOfMemoryError
    //   155	167	202	java/lang/OutOfMemoryError
    //   170	185	202	java/lang/OutOfMemoryError
    //   188	199	202	java/lang/OutOfMemoryError
    //   80	86	252	java/io/IOException
    //   80	86	284	finally
    //   102	106	297	java/io/IOException
    //   278	282	301	java/io/IOException
    //   291	295	305	java/io/IOException
    //   86	98	309	finally
    //   256	274	313	finally
    //   86	98	317	java/io/IOException
  }
  
  public final boolean h(String paramString, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = g(paramString, paramArrayOfByte);
    if (!s(paramArrayOfByte)) {
      return false;
    }
    d(paramString, paramArrayOfByte);
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void kk(String paramString);
  }
  
  public static final class b
  {
    static boolean ey(String paramString)
    {
      com.tencent.mm.vfs.e.deleteFile(paramString + ".bm");
      com.tencent.mm.vfs.e.deleteFile(paramString);
      return true;
    }
    
    /* Error */
    public static boolean kl(String paramString)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: invokestatic 38	com/tencent/mm/ag/d$b:km	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   6: astore 5
      //   8: aload 5
      //   10: ifnull +11 -> 21
      //   13: aload 5
      //   15: invokevirtual 44	android/graphics/Bitmap:isRecycled	()Z
      //   18: ifeq +7 -> 25
      //   21: iconst_0
      //   22: istore_1
      //   23: iload_1
      //   24: ireturn
      //   25: aconst_null
      //   26: astore_3
      //   27: aconst_null
      //   28: astore_2
      //   29: aload_0
      //   30: iconst_0
      //   31: invokestatic 48	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
      //   34: astore 4
      //   36: aload 4
      //   38: astore_2
      //   39: aload 4
      //   41: astore_3
      //   42: aload 5
      //   44: getstatic 54	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
      //   47: bipush 100
      //   49: aload 4
      //   51: invokevirtual 58	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
      //   54: pop
      //   55: aload 4
      //   57: astore_2
      //   58: aload 4
      //   60: astore_3
      //   61: new 11	java/lang/StringBuilder
      //   64: dup
      //   65: invokespecial 15	java/lang/StringBuilder:<init>	()V
      //   68: aload_0
      //   69: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: ldc 21
      //   74: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 25	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokestatic 30	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
      //   83: pop
      //   84: aload 4
      //   86: ifnull -63 -> 23
      //   89: aload 4
      //   91: invokevirtual 63	java/io/OutputStream:close	()V
      //   94: iconst_1
      //   95: ireturn
      //   96: astore_0
      //   97: iconst_1
      //   98: ireturn
      //   99: astore 4
      //   101: aload_2
      //   102: astore_3
      //   103: ldc 65
      //   105: aload 4
      //   107: ldc 67
      //   109: iconst_1
      //   110: anewarray 4	java/lang/Object
      //   113: dup
      //   114: iconst_0
      //   115: aload_0
      //   116: aastore
      //   117: invokestatic 73	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   120: aload_2
      //   121: ifnull +7 -> 128
      //   124: aload_2
      //   125: invokevirtual 63	java/io/OutputStream:close	()V
      //   128: iconst_0
      //   129: ireturn
      //   130: astore_0
      //   131: aload_3
      //   132: ifnull +7 -> 139
      //   135: aload_3
      //   136: invokevirtual 63	java/io/OutputStream:close	()V
      //   139: aload_0
      //   140: athrow
      //   141: astore_0
      //   142: goto -14 -> 128
      //   145: astore_2
      //   146: goto -7 -> 139
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	149	0	paramString	String
      //   1	23	1	bool	boolean
      //   28	97	2	localObject1	Object
      //   145	1	2	localIOException1	java.io.IOException
      //   26	110	3	localObject2	Object
      //   34	56	4	localOutputStream	java.io.OutputStream
      //   99	7	4	localIOException2	java.io.IOException
      //   6	37	5	localBitmap	Bitmap
      // Exception table:
      //   from	to	target	type
      //   89	94	96	java/io/IOException
      //   29	36	99	java/io/IOException
      //   42	55	99	java/io/IOException
      //   61	84	99	java/io/IOException
      //   29	36	130	finally
      //   42	55	130	finally
      //   61	84	130	finally
      //   103	120	130	finally
      //   124	128	141	java/io/IOException
      //   135	139	145	java/io/IOException
    }
    
    /* Error */
    public static Bitmap km(String paramString)
    {
      // Byte code:
      //   0: new 11	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 15	java/lang/StringBuilder:<init>	()V
      //   7: aload_0
      //   8: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   11: ldc 21
      //   13: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   16: invokevirtual 25	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   19: astore 8
      //   21: aload 8
      //   23: invokestatic 80	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
      //   26: ifne +21 -> 47
      //   29: ldc 65
      //   31: ldc 82
      //   33: iconst_1
      //   34: anewarray 4	java/lang/Object
      //   37: dup
      //   38: iconst_0
      //   39: aload 8
      //   41: aastore
      //   42: invokestatic 86	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   45: aconst_null
      //   46: areturn
      //   47: aload 8
      //   49: invokestatic 90	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
      //   52: l2i
      //   53: istore_1
      //   54: iload_1
      //   55: ifle +15 -> 70
      //   58: iload_1
      //   59: ldc 91
      //   61: if_icmpeq +95 -> 156
      //   64: iload_1
      //   65: ldc 92
      //   67: if_icmpeq +89 -> 156
      //   70: aload_0
      //   71: invokestatic 94	com/tencent/mm/ag/d$b:ey	(Ljava/lang/String;)Z
      //   74: pop
      //   75: ldc 65
      //   77: ldc 96
      //   79: iconst_2
      //   80: anewarray 4	java/lang/Object
      //   83: dup
      //   84: iconst_0
      //   85: iload_1
      //   86: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   89: aastore
      //   90: dup
      //   91: iconst_1
      //   92: aload 8
      //   94: aastore
      //   95: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   98: aconst_null
      //   99: areturn
      //   100: astore 7
      //   102: aconst_null
      //   103: astore_0
      //   104: aconst_null
      //   105: astore 5
      //   107: ldc 65
      //   109: ldc 107
      //   111: iconst_2
      //   112: anewarray 4	java/lang/Object
      //   115: dup
      //   116: iconst_0
      //   117: aload 7
      //   119: invokevirtual 110	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   122: aastore
      //   123: dup
      //   124: iconst_1
      //   125: aload 8
      //   127: aastore
      //   128: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: aload_0
      //   132: ifnull +9 -> 141
      //   135: aload_0
      //   136: invokeinterface 113 1 0
      //   141: aload 5
      //   143: ifnull +304 -> 447
      //   146: aload 5
      //   148: invokevirtual 116	java/io/InputStream:close	()V
      //   151: aconst_null
      //   152: areturn
      //   153: astore_0
      //   154: aconst_null
      //   155: areturn
      //   156: aload 8
      //   158: invokestatic 120	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   161: astore 5
      //   163: aload 5
      //   165: invokestatic 126	java/nio/channels/Channels:newChannel	(Ljava/io/InputStream;)Ljava/nio/channels/ReadableByteChannel;
      //   168: astore 6
      //   170: ldc 91
      //   172: invokestatic 132	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   175: astore 7
      //   177: aload 6
      //   179: aload 7
      //   181: invokeinterface 136 2 0
      //   186: pop
      //   187: aload 7
      //   189: iconst_0
      //   190: invokevirtual 140	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
      //   193: pop
      //   194: iload_1
      //   195: ldc 92
      //   197: if_icmpne +244 -> 441
      //   200: bipush 16
      //   202: invokestatic 132	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   205: astore 9
      //   207: aload 6
      //   209: aload 9
      //   211: invokeinterface 136 2 0
      //   216: pop
      //   217: aload 9
      //   219: iconst_0
      //   220: invokevirtual 144	java/nio/ByteBuffer:getLong	(I)J
      //   223: lstore_2
      //   224: lload_2
      //   225: lconst_1
      //   226: lcmp
      //   227: ifeq +230 -> 457
      //   230: ldc 65
      //   232: ldc 146
      //   234: iconst_3
      //   235: anewarray 4	java/lang/Object
      //   238: dup
      //   239: iconst_0
      //   240: lload_2
      //   241: invokestatic 151	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   244: aastore
      //   245: dup
      //   246: iconst_1
      //   247: iload_1
      //   248: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   251: aastore
      //   252: dup
      //   253: iconst_2
      //   254: aload 8
      //   256: aastore
      //   257: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   260: aload 6
      //   262: invokeinterface 113 1 0
      //   267: aload 5
      //   269: invokevirtual 116	java/io/InputStream:close	()V
      //   272: aload_0
      //   273: invokestatic 94	com/tencent/mm/ag/d$b:ey	(Ljava/lang/String;)Z
      //   276: pop
      //   277: aconst_null
      //   278: areturn
      //   279: ldc 65
      //   281: ldc 153
      //   283: iconst_3
      //   284: anewarray 4	java/lang/Object
      //   287: dup
      //   288: iconst_0
      //   289: iload_1
      //   290: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   293: aastore
      //   294: dup
      //   295: iconst_1
      //   296: iload 4
      //   298: invokestatic 158	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   301: aastore
      //   302: dup
      //   303: iconst_2
      //   304: aload 8
      //   306: aastore
      //   307: invokestatic 86	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   310: aload 6
      //   312: invokeinterface 113 1 0
      //   317: aload 5
      //   319: invokevirtual 116	java/io/InputStream:close	()V
      //   322: bipush 96
      //   324: bipush 96
      //   326: getstatic 164	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   329: invokestatic 168	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
      //   332: astore_0
      //   333: aload_0
      //   334: aload 7
      //   336: invokevirtual 172	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
      //   339: iload 4
      //   341: ifeq +42 -> 383
      //   344: aload_0
      //   345: bipush 9
      //   347: bipush 9
      //   349: bipush 78
      //   351: bipush 78
      //   353: invokestatic 175	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
      //   356: astore 5
      //   358: ldc 65
      //   360: ldc 177
      //   362: iconst_1
      //   363: anewarray 4	java/lang/Object
      //   366: dup
      //   367: iconst_0
      //   368: aload_0
      //   369: invokevirtual 178	java/lang/Object:toString	()Ljava/lang/String;
      //   372: aastore
      //   373: invokestatic 181	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   376: aload_0
      //   377: invokevirtual 184	android/graphics/Bitmap:recycle	()V
      //   380: aload 5
      //   382: areturn
      //   383: aload_0
      //   384: areturn
      //   385: astore 7
      //   387: aconst_null
      //   388: astore_0
      //   389: aconst_null
      //   390: astore 5
      //   392: ldc 65
      //   394: ldc 186
      //   396: iconst_2
      //   397: anewarray 4	java/lang/Object
      //   400: dup
      //   401: iconst_0
      //   402: aload 7
      //   404: invokevirtual 187	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
      //   407: aastore
      //   408: dup
      //   409: iconst_1
      //   410: aload 8
      //   412: aastore
      //   413: invokestatic 105	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   416: goto -285 -> 131
      //   419: astore 7
      //   421: aconst_null
      //   422: astore_0
      //   423: goto -31 -> 392
      //   426: astore 7
      //   428: aload 6
      //   430: astore_0
      //   431: goto -39 -> 392
      //   434: astore 7
      //   436: aconst_null
      //   437: astore_0
      //   438: goto -331 -> 107
      //   441: iconst_1
      //   442: istore 4
      //   444: goto -165 -> 279
      //   447: aconst_null
      //   448: areturn
      //   449: astore 7
      //   451: aload 6
      //   453: astore_0
      //   454: goto -347 -> 107
      //   457: iconst_0
      //   458: istore 4
      //   460: goto -181 -> 279
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	463	0	paramString	String
      //   53	237	1	i	int
      //   223	18	2	l	long
      //   296	163	4	bool	boolean
      //   105	286	5	localObject	Object
      //   168	284	6	localReadableByteChannel	java.nio.channels.ReadableByteChannel
      //   100	18	7	localException1	Exception
      //   175	160	7	localByteBuffer1	java.nio.ByteBuffer
      //   385	18	7	localOutOfMemoryError1	java.lang.OutOfMemoryError
      //   419	1	7	localOutOfMemoryError2	java.lang.OutOfMemoryError
      //   426	1	7	localOutOfMemoryError3	java.lang.OutOfMemoryError
      //   434	1	7	localException2	Exception
      //   449	1	7	localException3	Exception
      //   19	392	8	str	String
      //   205	13	9	localByteBuffer2	java.nio.ByteBuffer
      // Exception table:
      //   from	to	target	type
      //   21	45	100	java/lang/Exception
      //   47	54	100	java/lang/Exception
      //   70	98	100	java/lang/Exception
      //   156	163	100	java/lang/Exception
      //   322	339	100	java/lang/Exception
      //   344	380	100	java/lang/Exception
      //   135	141	153	java/lang/Exception
      //   146	151	153	java/lang/Exception
      //   21	45	385	java/lang/OutOfMemoryError
      //   47	54	385	java/lang/OutOfMemoryError
      //   70	98	385	java/lang/OutOfMemoryError
      //   156	163	385	java/lang/OutOfMemoryError
      //   322	339	385	java/lang/OutOfMemoryError
      //   344	380	385	java/lang/OutOfMemoryError
      //   163	170	419	java/lang/OutOfMemoryError
      //   317	322	419	java/lang/OutOfMemoryError
      //   170	194	426	java/lang/OutOfMemoryError
      //   200	224	426	java/lang/OutOfMemoryError
      //   230	277	426	java/lang/OutOfMemoryError
      //   279	317	426	java/lang/OutOfMemoryError
      //   163	170	434	java/lang/Exception
      //   317	322	434	java/lang/Exception
      //   170	194	449	java/lang/Exception
      //   200	224	449	java/lang/Exception
      //   230	277	449	java/lang/Exception
      //   279	317	449	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.d
 * JD-Core Version:    0.7.0.1
 */