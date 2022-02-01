package com.tencent.mm.av;

import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.ImageOptimLib;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LongBitmapHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class i
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
  public static int iXV = 0;
  public static int iYg = 150;
  public static long iYh = 0L;
  private MMHandler hAk;
  public com.tencent.mm.storagebase.h iFy;
  com.tencent.mm.b.f<String, Bitmap> iXW;
  private com.tencent.mm.b.f<String, String> iXX;
  private List<b> iXY;
  private Map<Integer, WeakReference<ImageView>> iXZ;
  private Map<Integer, WeakReference<ImageView>> iYa;
  private Map<Integer, WeakReference<View>> iYb;
  private Set<Integer> iYc;
  private Map<String, String> iYd;
  private FrameLayout.LayoutParams iYe;
  private SoftReference<ColorDrawable> iYf;
  
  public i(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150566);
    this.iXW = new com.tencent.mm.memory.a.b(40, new i.1(this), getClass());
    this.iXX = new com.tencent.mm.memory.a.c(40);
    this.iXY = new ArrayList();
    this.iXZ = new HashMap();
    this.iYa = new HashMap();
    this.iYb = new HashMap();
    this.iYc = new HashSet();
    this.hAk = new MMHandler(Looper.getMainLooper());
    this.iYd = new HashMap();
    this.iFy = null;
    this.iYe = new FrameLayout.LayoutParams(-2, -2);
    Iterator localIterator = d.iYu.iterator();
    while (localIterator.hasNext()) {
      a(paramh, ((c)localIterator.next()).table);
    }
    this.iFy = paramh;
    bcy();
    AppMethodBeat.o(150566);
  }
  
  private g Ax(long paramLong)
  {
    AppMethodBeat.i(150604);
    g localg = new g();
    Cursor localCursor = b("ImgInfo2", null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToFirst()) {
      localg.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(150604);
    return localg;
  }
  
  public static String EX(String paramString)
  {
    AppMethodBeat.i(150573);
    paramString = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString));
    AppMethodBeat.o(150573);
    return paramString;
  }
  
  /* Error */
  private static String OE(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 239
    //   5: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   11: lstore_3
    //   12: getstatic 84	com/tencent/mm/av/i:iYh	J
    //   15: lstore 5
    //   17: lload_3
    //   18: lstore_1
    //   19: lload 5
    //   21: lload_3
    //   22: lcmp
    //   23: ifne +11 -> 34
    //   26: lconst_1
    //   27: invokestatic 251	java/lang/Thread:sleep	(J)V
    //   30: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   33: lstore_1
    //   34: lload_1
    //   35: putstatic 84	com/tencent/mm/av/i:iYh	J
    //   38: new 253	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_1
    //   50: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokevirtual 269	java/lang/String:getBytes	()[B
    //   59: invokestatic 275	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   62: astore_0
    //   63: ldc_w 277
    //   66: ldc_w 279
    //   69: iconst_2
    //   70: anewarray 105	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: lload_1
    //   80: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   83: aastore
    //   84: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: ldc 239
    //   89: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: ldc 2
    //   94: monitorexit
    //   95: aload_0
    //   96: areturn
    //   97: astore 7
    //   99: goto -69 -> 30
    //   102: astore_0
    //   103: ldc 2
    //   105: monitorexit
    //   106: aload_0
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramString	String
    //   18	62	1	l1	long
    //   11	11	3	l2	long
    //   15	5	5	l3	long
    //   97	1	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   26	30	97	java/lang/InterruptedException
    //   3	17	102	finally
    //   26	30	102	finally
    //   30	34	102	finally
    //   34	92	102	finally
  }
  
  public static String[] Ox(String paramString)
  {
    AppMethodBeat.i(223581);
    String str1 = "CREATE TABLE IF NOT EXISTS " + paramString + " ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen" + " INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid" + " INT, status INT, nettimes INT, reserved1 int  , reserved2" + " int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete" + " INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType" + " INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )";
    String str2 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoIndex ON " + paramString + " ( msgSvrId ) ";
    String str3 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoHdIndex ON " + paramString + " ( reserved1 ) ";
    String str4 = "CREATE INDEX IF NOT EXISTS " + paramString + "msgLocalIdIndex ON " + paramString + " ( msglocalid ) ";
    String str5 = "CREATE INDEX IF NOT EXISTS " + paramString + "iscomplete_index ON " + paramString + " ( iscomplete ) ";
    paramString = "CREATE INDEX IF NOT EXISTS " + paramString + "origImgMD5_index ON " + paramString + " ( origImgMD5 ) ";
    AppMethodBeat.o(223581);
    return new String[] { str1, str2, str3, str4, str5, paramString };
  }
  
  public static long Oy(String paramString)
  {
    AppMethodBeat.i(223582);
    long l = d.OG(paramString).incrementAndGet();
    AppMethodBeat.o(223582);
    return l;
  }
  
  public static String W(ca paramca)
  {
    AppMethodBeat.i(150635);
    if (paramca == null)
    {
      Log.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      AppMethodBeat.o(150635);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject1;
    if (paramca.field_isSend == 1)
    {
      localObject2 = q.bcR().H(paramca.field_talker, paramca.field_msgId);
      localObject1 = localObject2;
      if (((g)localObject2).localId != 0L) {}
    }
    else
    {
      localObject1 = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
    }
    if (com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
      if (paramca.field_isSend == 1)
      {
        paramca = h.c((g)localObject1);
        localObject2 = q.bcR().o(paramca, "", "");
        if ((paramca != null) && (paramca.length() > 0) && (s.YS((String)localObject2)))
        {
          AppMethodBeat.o(150635);
          return localObject2;
        }
        paramca = ((g)localObject1).iXm;
        localObject1 = q.bcR().o(paramca, "", "");
        if ((paramca != null) && (paramca.length() > 0) && (s.YS((String)localObject1)))
        {
          AppMethodBeat.o(150635);
          return localObject1;
        }
      }
      else if (((g)localObject1).bcu())
      {
        paramca = ((g)localObject1).iXm;
        if (!((g)localObject1).bcv()) {
          break label314;
        }
        localObject1 = h.a((g)localObject1);
        if ((localObject1 == null) || (((g)localObject1).localId <= 0L) || (!((g)localObject1).bcu()) || (!s.YS(q.bcR().o(((g)localObject1).iXm, "", "")))) {
          break label314;
        }
        paramca = ((g)localObject1).iXm;
      }
    }
    label314:
    for (;;)
    {
      AppMethodBeat.o(150635);
      return paramca;
      Log.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      AppMethodBeat.o(150635);
      return null;
    }
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString4, String paramString5, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(223596);
    if (paramInt1 == 0)
    {
      paramString2 = a(paramString1, paramString2, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString2 == null)
      {
        AppMethodBeat.o(223596);
        return -1L;
      }
      paramPString.value = paramString2.iXo;
      if (s.YS(paramString3))
      {
        paramPString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).alX(paramString2.iXm);
        s.nw(paramString3, o(paramPString, "", ""));
        paramString2.Ou(paramPString);
      }
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(223596);
        return paramLong;
      }
    }
    if (paramInt1 == 1)
    {
      paramString3 = a(paramString1, paramString2, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString3 == null)
      {
        AppMethodBeat.o(223596);
        return -1L;
      }
      paramPString.value = paramString3.iXo;
      paramString3.Aw(0L);
      paramString3.yF(0L);
      paramString3.tf((int)s.boW(o(paramString3.iXm, "", "")));
      paramString2 = a(paramString1, paramString2, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString2 == null)
      {
        AppMethodBeat.o(223596);
        return 0L;
      }
      paramString2.Oq(paramString3.iXm);
      paramString2.Os(paramString3.iXo);
      paramString2.Or(paramString3.iXn);
      paramString2.tf(0);
      long l = this.iFy.beginTransaction(Thread.currentThread().getId());
      paramString2.tg((int)a(paramString1, "id", paramString3));
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        Log.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramString2.localId), Long.valueOf(paramString2.iXv), paramString2.iXm, paramString2.iXn, Integer.valueOf(paramString2.iKP) });
        if (l > 0L) {
          com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l);
        }
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(223596);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(223596);
    return 0L;
  }
  
  private Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString3, com.tencent.mm.b.b paramb, int paramInt3)
  {
    AppMethodBeat.i(223600);
    Log.i("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap talker[%s] origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Util.getStack(), paramString3 });
    Bitmap localBitmap2 = (Bitmap)this.iXW.aT(h.Ow(paramString2));
    String str1 = null;
    String str2;
    int i;
    int j;
    if (localBitmap2 != null)
    {
      localBitmap1 = localBitmap2;
      if (!localBitmap2.isRecycled()) {}
    }
    else
    {
      str1 = m(paramString1, paramString2, paramInt1);
      if (Util.isNullOrNil(str1)) {
        break label500;
      }
      if (!str1.endsWith("hd")) {
        break label358;
      }
      str2 = str1;
      localBitmap1 = localBitmap2;
      if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
        break label497;
      }
      i = LongBitmapHandler.isLongPicture(str2);
      j = BackwardSupportUtil.ExifHelper.getExifOrientation(str2);
      if (i <= 0) {
        break label371;
      }
    }
    label184:
    label349:
    label358:
    label371:
    for (Bitmap localBitmap1 = BitmapUtil.drawBackgroundInNeed(LongBitmapHandler.createLongPictureBitmap(str2, i, j + paramInt2 * 90), str2, paramInt3);; localBitmap1 = BitmapUtil.createThumbBitmap(str2, 120, 120, true, false, paramInt3))
    {
      if (localBitmap1 != null)
      {
        this.iXW.x(h.Ow(paramString2), localBitmap1);
        paramPInt1.value = localBitmap1.getWidth();
        paramPInt2.value = localBitmap1.getHeight();
        if (paramBoolean)
        {
          paramPInt1 = str1;
          if (str1 == null) {
            paramPInt1 = m(paramString1, paramString2, paramInt1);
          }
          paramString1 = paramPInt1;
          if (!Util.isNullOrNil(paramPInt1))
          {
            paramString1 = paramPInt1;
            if (paramPInt1.endsWith("hd")) {
              paramString1 = paramPInt1.substring(0, paramPInt1.length() - 2);
            }
          }
          if (paramb != null) {
            paramb.Ur();
          }
          if ((Util.isNullOrNil(paramString1)) || (!s.YS(paramString1)) || (s.boW(paramString1) <= 0L)) {
            break label389;
          }
          s.nw(paramString1, paramString3);
          Log.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s %s", new Object[] { paramString1, paramString3 });
        }
      }
      AppMethodBeat.o(223600);
      return localBitmap1;
      localBitmap1 = BitmapUtil.getBitmapNative(str1);
      str2 = paramString2;
      break;
    }
    label389:
    if ((!Util.isNullOrNil(paramString1)) && (s.YS(paramString1))) {
      Log.i("MicroMsg.ImgInfoStorage", "oldThumbFile Length %s", new Object[] { Long.valueOf(s.boW(paramString1)) });
    }
    for (;;)
    {
      label448:
      try
      {
        if ((Util.isNullOrNil(paramString1)) || (!paramString1.endsWith("hd"))) {
          break label486;
        }
        paramInt1 = 1;
      }
      catch (IOException paramString1) {}
      BitmapUtil.saveBitmapToImage(localBitmap1, paramInt1, Bitmap.CompressFormat.JPEG, paramString3, false);
      Log.i("MicroMsg.ImgInfoStorage", "saveBitmapToImage thumbPath %s", new Object[] { paramString3 });
      break label349;
      break label349;
      label486:
      paramInt1 = 0;
      label497:
      label500:
      while (paramInt1 == 0)
      {
        paramInt1 = 90;
        break label448;
        break label184;
        str2 = paramString2;
        localBitmap1 = localBitmap2;
        break;
      }
      paramInt1 = 80;
    }
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    AppMethodBeat.i(150590);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, paramBoolean5, null);
    AppMethodBeat.o(150590);
    return paramString;
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150591);
    String str2 = paramString;
    if (!paramBoolean1) {
      str2 = d(paramString, false, true);
    }
    if (str2 == null)
    {
      AppMethodBeat.o(150591);
      return null;
    }
    String str1 = null;
    int k;
    label87:
    String str3;
    label146:
    long l;
    int m;
    int n;
    int i;
    int j;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      k = 1;
      if (paramBoolean5)
      {
        paramString = (Bitmap)this.iXW.aT(str2);
        str1 = paramString;
        if (paramString == null)
        {
          if (paramString != null) {
            break label698;
          }
          paramBoolean1 = true;
          Log.printDebugStack("MicroMsg.ImgInfoStorage", "bm is null:%b,  url:%s", new Object[] { Boolean.valueOf(paramBoolean1), str2 });
          str1 = paramString;
        }
      }
      if ((str1 != null) && (!str1.isRecycled()))
      {
        str3 = str1;
        if (k == 0) {}
      }
      else
      {
        Util.nowMilliSecond();
        if (k == 0) {
          break label703;
        }
        paramString = paramBitmap;
        if (paramBitmap == null) {
          paramString = u.Sq(str2);
        }
        if (paramString == null) {
          break label929;
        }
        l = System.currentTimeMillis();
        m = paramString.getWidth();
        n = paramString.getHeight();
        i = n;
        j = m;
        if (paramBoolean3)
        {
          if (iXV == 0) {
            iXV = com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), 2131166307);
          }
          if (m <= iXV)
          {
            i = n;
            j = m;
            if (n <= iXV) {}
          }
          else
          {
            if (m <= n) {
              break label714;
            }
            i = n * iXV / m;
            j = iXV;
          }
        }
        label259:
        n = i;
        m = j;
        if (paramBoolean4)
        {
          if (str2.endsWith("hd")) {
            break label968;
          }
          j = (int)(paramString.getWidth() * paramFloat * 1.25F);
          i = (int)(paramString.getHeight() * paramFloat * 1.25F);
        }
      }
    }
    label512:
    label698:
    label703:
    label968:
    for (;;)
    {
      float f;
      if ((j >= 160.0F * paramFloat) || (i >= 160.0F * paramFloat)) {
        if (i > j)
        {
          f = 160.0F * paramFloat / i;
          label353:
          j = (int)(j * f);
          i = (int)(f * i);
        }
      }
      for (;;)
      {
        m = j;
        if (j < 60.0F * paramFloat)
        {
          Log.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(j) });
          m = (int)(60.0F * paramFloat);
        }
        j = i;
        if (i < 60.0F * paramFloat)
        {
          Log.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(i) });
          j = (int)(60.0F * paramFloat);
        }
        MMApplicationContext.getContext();
        paramBitmap = new int[2];
        if (j >= m)
        {
          f = j / m;
          if (f <= 2.0F)
          {
            i = Math.round(150.0F * paramFloat);
            j = (int)(i / f);
            paramBitmap[0] = j;
            paramBitmap[1] = i;
            m = paramBitmap[0];
            n = paramBitmap[1];
          }
        }
        for (;;)
        {
          try
          {
            paramBitmap = Bitmap.createScaledBitmap(paramString, m, n, true);
            if ((paramString != paramBitmap) && (k == 0))
            {
              Log.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramString.toString() });
              paramString.recycle();
            }
            if (paramBoolean4)
            {
              paramString = BitmapUtil.createChattingImage(paramBitmap, paramInt);
              str1 = System.currentTimeMillis() - l;
              if (paramString != null) {
                continue;
              }
              paramBitmap = "";
              Log.i("MicroMsg.ImgInfoStorage", "cached file :%s bitmap time:%s bitmap:%s", new Object[] { str2, str1, paramBitmap });
              str3 = paramString;
              if (paramString != null)
              {
                str3 = paramString;
                if (k == 0)
                {
                  this.iXW.x(str2, paramString);
                  str3 = paramString;
                }
              }
              AppMethodBeat.o(150591);
              return str3;
              k = 0;
              break;
              paramBoolean1 = false;
              break label87;
              paramBitmap = BitmapUtil.getBitmapNative(str2, paramFloat);
              break label146;
              label714:
              if (m == n)
              {
                i = iXV;
                j = iXV;
                break label259;
              }
              j = m * iXV / n;
              i = iXV;
              break label259;
              f = 160.0F * paramFloat / j;
              break label353;
              j = Math.round(75.0F * paramFloat);
              i = (int)(j * f);
              break label512;
              f = m / j;
              if (f <= 2.0F)
              {
                j = Math.round(150.0F * paramFloat);
                i = (int)(j / f);
                break label512;
              }
              i = Math.round(75.0F * paramFloat);
              j = (int)(i * f);
            }
          }
          catch (OutOfMemoryError paramBitmap)
          {
            paramBitmap = paramString;
            continue;
          }
          catch (IllegalArgumentException paramBitmap)
          {
            paramBitmap = paramString;
            continue;
            if (paramBoolean2)
            {
              paramString = BitmapUtil.getRoundedCornerBitmap(paramBitmap, true, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 3));
              Log.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
              continue;
            }
            paramString = paramBitmap;
            continue;
            paramBitmap = paramString.toString();
            continue;
          }
          Log.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", new Object[] { str2, Boolean.valueOf(s.YS(str2)) });
          str3 = str1;
        }
      }
    }
  }
  
  private g a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString3, long paramLong, String paramString4, String paramString5, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama, int paramInt4)
  {
    AppMethodBeat.i(223604);
    if (!s.YS(paramString2))
    {
      AppMethodBeat.o(223604);
      return null;
    }
    String str = h.Ow(paramString2);
    paramb1 = a(paramString1, paramString2, paramInt1, paramBoolean, paramInt3, paramPInt1, paramPInt2, paramString3, paramString4, paramb1, paramInt4);
    if ((parama != null) && (parama.iXp == paramInt1))
    {
      paramString5 = parama.bcI();
      paramPInt2 = paramString5.iZP;
      paramString3 = paramString5.iZQ;
      paramPInt1 = paramString5.iXy;
      paramString4 = paramString5.iZR;
      paramString5 = paramString5.iZS;
      Log.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramString5.value });
      paramString5 = new g();
      paramString5.cSx = -1;
      paramString5.setLocalId(d.OG(paramString1).incrementAndGet());
      paramString5.Aw(paramLong);
      if (!Util.isNullOrNil(paramPInt1)) {
        paramString5.Ot(paramPInt1);
      }
      paramString5.tj(0);
      paramString5.setSource(paramInt2);
      if (paramInt2 != 4) {
        break label580;
      }
      if (paramString2.startsWith(ap.aTc()))
      {
        paramString5.th(3);
        label240:
        if (paramBoolean)
        {
          paramString5.Oq(paramPInt2.value + ".jpg");
          if (!Util.isNullOrNil(paramString4.value)) {
            paramString5.Or(paramString4.value + ".jpg");
          }
          if (Util.isNullOrNil(paramString5.iXo)) {
            paramString5.Os(paramb1);
          }
          paramString5.tf((int)s.boW(paramString3.value));
          if (paramString5.iKP == 0) {
            Log.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString3.value });
          }
          paramString5.Op(str);
        }
        paramString5.setCreateTime((int)Util.nowSecond());
        paramString5.tk(paramInt1);
        Log.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramString5.iKP);
        AppMethodBeat.o(223604);
        return paramString5;
      }
    }
    else
    {
      if ((parama == null) || (parama.iXp == paramInt1)) {
        break label589;
      }
      paramPInt2 = null;
    }
    for (paramPInt1 = null;; paramPInt1 = paramString5)
    {
      paramString5 = new PString();
      paramString3 = new PString();
      paramString4 = new PString();
      paramb2 = new PString();
      paramPInt1 = a(paramString1, paramString2, str, paramInt1, paramBoolean, paramString5, paramString3, paramString4, paramb2, paramPInt1, paramPInt2, paramInt4);
      Log.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramb2.value });
      paramPInt2 = paramString5;
      break;
      paramString5.th(2);
      break label240;
      label580:
      paramString5.th(1);
      break label240;
      label589:
      paramPInt2 = paramb2;
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, com.tencent.mm.b.b paramb, int paramInt3)
  {
    AppMethodBeat.i(223602);
    Log.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString2 });
    if (!s.YS(paramString2))
    {
      Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(223602);
      return null;
    }
    String str = paramString4;
    if (Util.isNullOrNil(paramString4)) {
      str = bcA();
    }
    str = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
    paramString4 = a(str, "th_", "", false);
    if (paramb == null) {
      paramString4 = o(str, "th_", "");
    }
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(paramString3)) && (s.YS(paramString3))) {
        break label264;
      }
      long l = Util.currentTicks();
      a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, true, paramString4, paramb, paramInt3);
      if (!s.YS(paramString4)) {
        break label252;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(10921, new Object[] { Long.valueOf(s.boW(paramString4)), Long.valueOf(s.boW(paramString2)), Integer.valueOf(90), Long.valueOf(Util.ticksToNow(l)) });
    }
    for (;;)
    {
      Log.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
      AppMethodBeat.o(223602);
      return str;
      label252:
      Log.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
      continue;
      label264:
      s.nw(paramString3, paramString4);
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(223586);
    int j = paramString.hashCode();
    int k = paramImageView1.hashCode();
    Iterator localIterator = this.iXY.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (k == localb.iYn)
      {
        Log.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.iYn), localb.url });
        localb.url = paramString;
        if (!this.iYc.contains(Integer.valueOf(j)))
        {
          this.iYc.add(Integer.valueOf(j));
          a(paramString, paramFloat, true, 2131231628);
        }
        AppMethodBeat.o(223586);
        return;
      }
    }
    this.iXZ.put(Integer.valueOf(k), new WeakReference(paramImageView1));
    paramInt = 0;
    if (paramImageView2 != null)
    {
      paramInt = paramImageView2.hashCode();
      this.iYa.put(Integer.valueOf(paramInt), new WeakReference(paramImageView2));
    }
    int i = 0;
    if (paramView != null)
    {
      i = paramView.hashCode();
      this.iYb.put(Integer.valueOf(i), new WeakReference(paramView));
    }
    paramImageView1 = new b(k, paramString, paramInt, i);
    this.iXY.add(paramImageView1);
    if (!this.iYc.contains(Integer.valueOf(j)))
    {
      this.iYc.add(Integer.valueOf(j));
      a(paramString, paramFloat, true, 2131231628);
    }
    AppMethodBeat.o(223586);
  }
  
  private static void a(com.tencent.mm.storagebase.h paramh, String paramString)
  {
    AppMethodBeat.i(223583);
    Cursor localCursor = paramh.rawQuery("PRAGMA table_info(" + paramString + ")", null, 2);
    int i4 = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    int n = 0;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    int m = 0;
    int k = 0;
    while (localCursor.moveToNext()) {
      if (i4 >= 0)
      {
        String str = localCursor.getString(i4);
        if ("hashdthumb".equals(str)) {
          k = 1;
        }
        if ("iscomplete".equals(str)) {
          m = 1;
        }
        if ("origImgMD5".equals(str)) {
          i1 = 1;
        }
        if ("compressType".equals(str)) {
          i3 = 1;
        }
        if ("midImgPath".equals(str)) {
          i2 = 1;
        }
        if ("forwardType".equals(str)) {
          n = 1;
        }
        if (!"hevcPath".equals(str)) {
          break label531;
        }
        i = 1;
      }
    }
    label531:
    for (;;)
    {
      if ("sendImgType".endsWith("colName")) {
        j = 1;
      }
      break;
      localCursor.close();
      long l = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
      if (k == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add hashdthumb INT DEFAULT 0");
      }
      if (m == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add iscomplete INT DEFAULT 1");
      }
      if (i1 == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add origImgMD5 TEXT");
      }
      if (i3 == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add compressType INT DEFAULT 0");
      }
      if (i2 == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add midImgPath TEXT");
      }
      if (n == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add forwardType INT DEFAULT 0");
      }
      if (i == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add hevcPath TEXT");
      }
      if (j == 0) {
        paramh.execSQL(paramString, "Alter table " + paramString + " add sendImgType INT DEFAULT 0");
      }
      if (l > 0L) {
        com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l);
      }
      AppMethodBeat.o(223583);
      return;
    }
  }
  
  private void a(final String paramString, final float paramFloat, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(223587);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150562);
        i.this.a(paramString, true, paramFloat, true, false, paramBoolean, paramInt);
        i.a(i.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150561);
            i.a(i.this, i.2.this.iYj);
            AppMethodBeat.o(150561);
          }
        });
        AppMethodBeat.o(150562);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(150563);
        String str = super.toString() + "|loadImginBackground";
        AppMethodBeat.o(150563);
        return str;
      }
    });
    AppMethodBeat.o(223587);
  }
  
  private long b(String paramString, g paramg)
  {
    AppMethodBeat.i(223598);
    paramString = d.OH(paramString);
    long l = this.iFy.gFH().insertOrThrow(paramString, "id", paramg.convertTo());
    if (l != -1L) {
      paramg.bcx();
    }
    Log.i("MicroMsg.ImgInfoStorage", "insert img, table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString, Long.valueOf(l), Long.valueOf(paramg.localId), Long.valueOf(paramg.iXv), Long.valueOf(paramg.dTS), Integer.valueOf(paramg.iXx) });
    AppMethodBeat.o(223598);
    return l;
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150608);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
    AppMethodBeat.o(150608);
    return paramString1;
  }
  
  public static String bcA()
  {
    try
    {
      AppMethodBeat.i(150620);
      String str = OE("");
      AppMethodBeat.o(150620);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private g l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(223589);
    g localg = new g();
    paramString1 = a(d.OH(paramString1), null, "origImgMD5=? AND compressType=?", new String[] { String.valueOf(paramString2), String.valueOf(paramInt) });
    if (paramString1.moveToFirst()) {
      localg.convertFrom(paramString1);
    }
    paramString1.close();
    AppMethodBeat.o(223589);
    return localg;
  }
  
  private String m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(223599);
    paramString1 = l(paramString1, h.Ow(paramString2), paramInt);
    if (!Util.isNullOrNil(paramString1.iXo))
    {
      paramString1 = R(paramString1.iXo, true);
      if (s.YS(paramString1))
      {
        AppMethodBeat.o(223599);
        return paramString1;
      }
    }
    AppMethodBeat.o(223599);
    return null;
  }
  
  public final g G(String paramString, long paramLong)
  {
    AppMethodBeat.i(223591);
    g localg = new g();
    paramString = b(d.OH(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToFirst()) {
      localg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(223591);
    return localg;
  }
  
  public final g H(String paramString, long paramLong)
  {
    AppMethodBeat.i(223592);
    g localg = new g();
    paramString = b(d.OH(paramString), null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToLast()) {
      localg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(223592);
    return localg;
  }
  
  public final String OA(String paramString)
  {
    AppMethodBeat.i(223584);
    paramString = R(paramString, true);
    AppMethodBeat.o(223584);
    return paramString;
  }
  
  public final Bitmap OB(String paramString)
  {
    AppMethodBeat.i(150592);
    float f = com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext());
    paramString = BitmapUtil.getBitmapNative(d(paramString, false, true), f);
    AppMethodBeat.o(150592);
    return paramString;
  }
  
  public final String OC(String paramString)
  {
    AppMethodBeat.i(150615);
    paramString = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString)), "th_", "", false);
    AppMethodBeat.o(150615);
    return paramString;
  }
  
  public final String OD(String paramString)
  {
    AppMethodBeat.i(150616);
    paramString = a(paramString, "", ".jpg", false);
    AppMethodBeat.o(150616);
    return paramString;
  }
  
  public final String OF(String paramString)
  {
    AppMethodBeat.i(258495);
    paramString = d(paramString, false, true);
    AppMethodBeat.o(258495);
    return paramString;
  }
  
  public final String Oz(String paramString)
  {
    AppMethodBeat.i(150574);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(150574);
      return null;
    }
    String str1 = "";
    String str2 = paramString.trim();
    if (str2.startsWith("THUMBNAIL://")) {
      paramString = str2.substring(12);
    }
    for (;;)
    {
      try
      {
        paramString = tl(Integer.valueOf(paramString).intValue()).iXo;
        paramString = o(paramString, str1, "");
        AppMethodBeat.o(150574);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150574);
        return null;
      }
      paramString = str2;
      if (str2.startsWith("THUMBNAIL_DIRPATH://"))
      {
        paramString = str2.substring(23);
        str1 = "th_";
      }
    }
  }
  
  public final String R(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(150581);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(150581);
      return null;
    }
    String str = paramString.trim();
    if (str.startsWith("THUMBNAIL://")) {
      paramString = str.substring(12);
    }
    do
    {
      try
      {
        paramString = tl(Integer.valueOf(paramString).intValue()).iXo;
        paramString = a(paramString, "", "", paramBoolean);
        AppMethodBeat.o(150581);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150581);
        return null;
      }
      paramString = str;
    } while (!str.startsWith("THUMBNAIL_DIRPATH://"));
    paramString = a(str.substring(20).substring(3), "th_", "", paramBoolean);
    AppMethodBeat.o(150581);
    return paramString;
  }
  
  public final g U(ca paramca)
  {
    AppMethodBeat.i(150595);
    g localg = H(paramca.field_talker, paramca.field_msgId);
    Object localObject = localg;
    if (localg.localId == 0L)
    {
      paramca = G(paramca.field_talker, paramca.field_msgSvrId);
      localObject = paramca;
      if (paramca.localId == 0L)
      {
        Log.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        AppMethodBeat.o(150595);
        return null;
      }
    }
    AppMethodBeat.o(150595);
    return localObject;
  }
  
  public final void V(ca paramca)
  {
    AppMethodBeat.i(150599);
    g localg = U(paramca);
    if ((localg == null) || (localg.localId == 0L))
    {
      Log.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      AppMethodBeat.o(150599);
      return;
    }
    s.deleteFile(o(localg.iXm, "", ""));
    s.deleteFile(o(localg.iXr, "", ""));
    s.deleteFile(o(localg.iXo, "", ""));
    s.deleteFile(o(localg.iXo, "", "") + "hd");
    this.iFy.delete(d.OH(paramca.field_talker), "id=?", new String[] { localg.localId });
    if (localg.bcv())
    {
      localg = tl(localg.iXx);
      if (localg == null)
      {
        AppMethodBeat.o(150599);
        return;
      }
      s.deleteFile(o(localg.iXm, "", ""));
      s.deleteFile(o(localg.iXr, "", ""));
      s.deleteFile(o(localg.iXo, "", ""));
      s.deleteFile(o(localg.iXo, "", "") + "hd");
      this.iFy.delete(d.OH(paramca.field_talker), "id=?", new String[] { localg.localId });
    }
    AppMethodBeat.o(150599);
  }
  
  public final int a(int paramInt, g paramg)
  {
    AppMethodBeat.i(150627);
    paramInt = a(Long.valueOf(paramInt), paramg);
    AppMethodBeat.o(150627);
    return paramInt;
  }
  
  public final int a(Long paramLong, g paramg)
  {
    AppMethodBeat.i(150628);
    long l = System.currentTimeMillis();
    ContentValues localContentValues = paramg.convertTo();
    if (localContentValues.size() == 0) {}
    for (int i = 1;; i = this.iFy.update(d.Ay(paramLong.longValue()), localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      Log.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString(), Integer.valueOf(i) });
      if (i != -1)
      {
        paramg.bcx();
        doNotify();
      }
      AppMethodBeat.o(150628);
      return i;
    }
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama, int paramInt4)
  {
    AppMethodBeat.i(223595);
    paramLong = a(paramString1, paramString2, null, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, paramString3, paramString4, paramLong, paramb1, paramb2, parama, false, paramInt4);
    AppMethodBeat.o(223595);
    return paramLong;
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(223594);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, 0, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, 0);
    AppMethodBeat.o(223594);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(223597);
    paramString1 = d.OH(paramString1);
    long l = this.iFy.insert(paramString1, paramString2, paramg.convertTo());
    if (l != -1L) {
      paramg.bcx();
    }
    Log.i("MicroMsg.ImgInfoStorage", "insert img,table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString1, Long.valueOf(l), Long.valueOf(paramg.localId), Long.valueOf(paramg.iXv), Long.valueOf(paramg.dTS), Integer.valueOf(paramg.iXx) });
    AppMethodBeat.o(223597);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(223593);
    long l = a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, true, 0);
    AppMethodBeat.o(223593);
    return l;
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, int paramInt, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(223606);
    String str1 = "SERVERID://".concat(String.valueOf(paramLong));
    String str2 = com.tencent.mm.b.g.getMessageDigest(str1.getBytes());
    String str3 = o(str2, "th_", "");
    Bitmap localBitmap;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 0))
    {
      localBitmap = BitmapUtil.decodeByteArray(paramArrayOfByte);
      if (localBitmap == null) {
        Log.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(paramArrayOfByte));
      }
      if ((paramBoolean) || (localBitmap == null)) {}
    }
    try
    {
      localBitmap = BitmapUtil.extractThumeNail(localBitmap, 120, 120, false);
      paramPInt1.value = localBitmap.getWidth();
      paramPInt2.value = localBitmap.getHeight();
      BitmapUtil.saveBitmapToImage(localBitmap, 90, Bitmap.CompressFormat.JPEG, str3, true);
      paramArrayOfByte = new g();
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.setOffset(paramInt);
        paramArrayOfByte.tf(paramInt);
        paramArrayOfByte.cSx = -1;
        paramArrayOfByte.setLocalId(d.OG(paramString1).incrementAndGet());
        paramArrayOfByte.Oq(paramString2);
        paramArrayOfByte.Os("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2)));
        paramPString.value = paramArrayOfByte.iXo;
        if (paramBoolean)
        {
          paramArrayOfByte.yF(0L);
          paramArrayOfByte.tk(1);
          paramArrayOfByte.Ot(paramString3);
          paramArrayOfByte.setCreateTime((int)Util.nowSecond());
          paramLong = a(paramString1, "id", paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          AppMethodBeat.o(223606);
          return paramLong;
        }
      }
    }
    catch (IOException paramPInt1)
    {
      for (;;)
      {
        Log.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + str2 + " " + new String(paramArrayOfByte));
        continue;
        paramArrayOfByte.yF(paramLong);
        paramArrayOfByte.tk(0);
        continue;
        paramString2 = str1;
      }
    }
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(223605);
    paramLong = a(paramString1, paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString2, paramPString, paramPInt1, paramPInt2);
    AppMethodBeat.o(223605);
    return paramLong;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150607);
    paramString1 = this.iFy.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    AppMethodBeat.o(150607);
    return paramString1;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150630);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from".concat(String.valueOf(paramLong));; str = "location_backgroup_key_tor".concat(String.valueOf(paramLong)))
    {
      Bitmap localBitmap2 = (Bitmap)this.iXW.aT(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BitmapUtil.createLocation(paramString, paramInt1, paramInt2, paramInt3);
        this.iXW.x(str, localBitmap1);
      }
      AppMethodBeat.o(150630);
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(223588);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(223588);
      return null;
    }
    String str = paramString.trim();
    paramString = (Bitmap)this.iXW.aT(str);
    Object localObject;
    Bitmap localBitmap;
    int k;
    int m;
    int j;
    int i;
    if (paramString != null)
    {
      localObject = paramString;
      if (!paramString.isRecycled()) {}
    }
    else
    {
      localBitmap = BackwardSupportUtil.BitmapFactory.decodeFile(str, paramFloat);
      if (localBitmap == null) {
        break label359;
      }
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (k < m) {
        break label277;
      }
      j = Math.round(iYg * paramFloat);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label305;
      }
      Log.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 188L, 1L, false);
      paramString = null;
      label190:
      localObject = paramString;
      if (paramInt != -1) {
        localObject = BitmapUtil.createChattingImage(paramString, paramInt);
      }
      if (localBitmap != localObject)
      {
        Log.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      Log.d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(str)));
      this.iXW.x(str, localObject);
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(223588);
        return localObject;
        label277:
        i = Math.round(iYg * paramFloat);
        j = (int)(k / m * i);
        break;
        try
        {
          label305:
          paramString = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        }
        catch (Exception paramString)
        {
          Log.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[] { paramString.getMessage() });
          paramString = null;
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 188L, 1L, false);
        }
      }
      break label190;
      label359:
      localObject = localBitmap;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(150583);
    paramString = a(paramString, false, paramFloat, paramBoolean, false, false, -1);
    AppMethodBeat.o(150583);
    return paramString;
  }
  
  public final Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    AppMethodBeat.i(150589);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, true);
    AppMethodBeat.o(150589);
    return paramString;
  }
  
  public final String a(String paramString, g paramg)
  {
    Object localObject = null;
    AppMethodBeat.i(223590);
    if (paramg == null)
    {
      AppMethodBeat.o(223590);
      return null;
    }
    if (paramg.bcv())
    {
      paramString = d.OH(paramString);
      paramg = paramg.iXx;
      paramg = b(paramString, new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { paramg });
      paramString = localObject;
      if (paramg.moveToFirst()) {
        paramString = paramg.getString(0);
      }
      paramg.close();
      AppMethodBeat.o(223590);
      return paramString;
    }
    AppMethodBeat.o(223590);
    return null;
  }
  
  public final String a(String paramString1, String paramString2, int paramInt1, PString paramPString, PInt paramPInt1, PInt paramPInt2, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(223601);
    if (!s.YS(paramString2))
    {
      Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(223601);
      return null;
    }
    String str1 = paramString3;
    if (Util.isNullOrNil(paramString3)) {
      str1 = bcA();
    }
    String str2 = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
    paramString3 = a(str2, "th_", "", false);
    paramPString.value = str2;
    long l = Util.currentTicks();
    paramPInt1 = a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, false, null, null, -1);
    paramString1 = (String)this.iXX.get(paramString2);
    if (paramString1 != null) {}
    for (paramString1 = (Bitmap)this.iXW.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramPString = paramString1;
        if (!paramString1.isRecycled()) {}
      }
      else
      {
        paramPString = a(paramString2, true, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()), false, false, true, 2131231628, true, paramPInt1);
        this.iXX.put(paramString2, paramString3);
      }
      if (paramPString != null) {
        this.iXW.x(paramString3, paramPString);
      }
      Log.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(223601);
      return str1;
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString4, com.tencent.mm.b.b paramb, int paramInt2)
  {
    AppMethodBeat.i(223603);
    String str = paramString4;
    if (Util.isNullOrNil(paramString4))
    {
      str = OE(paramString2);
      Log.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", new Object[] { str, paramString2 });
    }
    paramString4 = a(str, "", ".jpg", false);
    if (paramb == null) {
      paramString4 = a(str, "", ".jpg", true);
    }
    Log.i("MicroMsg.ImgInfoStorage", "fullPath is %s", new Object[] { paramString4 });
    if (s.boW(paramString4) > 0L)
    {
      Log.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
      com.tencent.mm.plugin.report.service.h.CyF.dN(944, 8);
    }
    paramPString1.value = str;
    paramPString2.value = paramString4;
    if ((paramBoolean) && (!Util.isNullOrNil(paramString3)) && (paramInt1 == 0))
    {
      paramString1 = l(paramString1, paramString3, paramInt1);
      if (!Util.isNullOrNil(paramString1.iXm))
      {
        paramString3 = o(paramString1.iXm, "", "");
        if (paramb != null) {
          paramb.Ur();
        }
        s.nw(paramString3, paramString4);
        if (s.boW(paramString3) > 0L)
        {
          if (!Util.isNullOrNil(paramString1.iXy))
          {
            paramString1 = paramString1.iXy;
            AppMethodBeat.o(223603);
            return paramString1;
          }
          AppMethodBeat.o(223603);
          return null;
        }
        Log.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString2, paramString4 });
      }
    }
    label1164:
    label1223:
    label1229:
    label3405:
    label3534:
    label3537:
    try
    {
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        Log.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3551;
        }
        n = 70;
        j = 0;
        m = 0;
        k = 1080;
        i = j;
        try
        {
          if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            break;
          }
          i = j;
          paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionForWifi");
          i = j;
          i1 = paramString1.indexOf("*");
          if (-1 == i1) {
            break label3543;
          }
          i = j;
          m = Integer.valueOf(paramString1.substring(0, i1)).intValue();
          i = m;
          j = Integer.valueOf(paramString1.substring(i1 + 1)).intValue();
          i = j;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            int i1;
            m = i;
            continue;
            continue;
            continue;
            i = m;
            continue;
            paramString1 = paramString2;
            continue;
            paramInt2 = i1;
            k = i;
            continue;
            paramBoolean = bool1;
            continue;
            j = i;
            continue;
            continue;
            continue;
            boolean bool1 = false;
            continue;
            i = 1080;
          }
        }
        k = i;
        try
        {
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.g.aAf();
          paramString1 = new p(com.tencent.mm.kernel.a.getUin());
          if ((int)(paramString1.longValue() / 100L) % 100 + 1 > i) {
            break label3537;
          }
          bool1 = true;
          Log.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Long.valueOf(paramString1.longValue()), Long.valueOf(paramString1.longValue() / 100L), Boolean.valueOf(CrashReportFactory.hasDebuger()), Integer.valueOf(Build.VERSION.SDK_INT) });
        }
        catch (Exception paramString1)
        {
          int i7;
          int i4;
          for (;;)
          {
            Log.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { Util.stackTraceToString(paramString1) });
            bool1 = false;
            continue;
            if (k >= 2160)
            {
              j = 0;
              i = 1080;
            }
            else
            {
              i = k;
              j = m;
              if (k <= 0)
              {
                i = k;
                j = m;
                if (m > 3240)
                {
                  j = 1620;
                  i = 0;
                  continue;
                  paramBoolean = false;
                }
              }
            }
          }
          int i5 = paramString3.outWidth;
          int i6 = paramString3.outHeight;
          if (paramString3.outWidth <= paramString3.outHeight) {
            break label1831;
          }
          k = paramString3.outWidth;
          if (paramString3.outWidth >= paramString3.outHeight) {
            break label1840;
          }
          int i2 = paramString3.outWidth;
          if (i <= 0) {
            break label1867;
          }
          int i3 = i2 / i;
          if (paramString3.outHeight <= i) {
            break label1849;
          }
          j = paramString3.outHeight * i / i2;
          if (paramString3.outWidth <= i) {
            break label1858;
          }
          i = i * paramString3.outWidth / i2;
          k = i;
          i = j;
          if (i * k <= 10240000) {
            break label3524;
          }
          double d = Math.sqrt(i * k / 10240000.0D);
          j = (int)(i / d);
          k = (int)(k / d);
          Log.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[] { Integer.valueOf(paramString3.outHeight), Integer.valueOf(paramString3.outWidth), Integer.valueOf(j), Integer.valueOf(k) });
          if (paramString3 == null) {
            break label1941;
          }
          paramString1 = paramString3.outMimeType;
          long l2 = s.boW(paramString2);
          boolean bool3 = MMNativeJpeg.IsJpegFile(paramString2);
          if ((paramString1 == null) || ((!paramString1.endsWith("jpeg")) && (!paramString1.endsWith("jpg")) && (!paramString1.endsWith("bmp")) && (!paramString1.endsWith("png")) && (!paramString1.endsWith("gif")))) {
            break label1948;
          }
          i2 = 1;
          if ((paramInt1 != 0) || ((i1 == 0) && (l2 <= 204800L) && ((paramString3 == null) || (i3 <= 0))) || (l2 <= i7)) {
            break label1961;
          }
          if ((i4 >= 55) && (bool3)) {
            break label3517;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            break label1954;
          }
          long l1;
          long l3;
          for (i = 18;; i = 8)
          {
            l1 = Util.nowMilliSecond();
            i1 = BitmapUtil.createThumbNailMayUseOpt(paramBoolean, paramString2, j, k, Bitmap.CompressFormat.JPEG, n, paramString4, paramb, paramInt2);
            if ((i1 == 1) || (!paramBoolean)) {
              break label3506;
            }
            i = 28;
            paramInt2 = BitmapUtil.createThumbNailMayUseOpt(false, paramString2, j, k, Bitmap.CompressFormat.JPEG, n, paramString4, paramb, paramInt2);
            paramBoolean = false;
            k = i;
            l3 = s.boW(paramString4);
            Log.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(100L * l3 / l2), Integer.valueOf(m), paramString4 });
            j = paramInt2;
            bool1 = paramBoolean;
            i = k;
            if (i2 != 0)
            {
              j = paramInt2;
              bool1 = paramBoolean;
              i = k;
              if ((l2 - l3) * 100L < m * l2)
              {
                s.nw(paramString2, paramString4);
                bool1 = false;
                i = 48;
                j = 1;
              }
            }
            l1 = Util.nowMilliSecond() - l1;
            paramInt2 = j;
            paramBoolean = bool1;
            if (j == 1) {
              break label2399;
            }
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 187L, 1L, false);
            Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString2 });
            AppMethodBeat.o(223603);
            return null;
            k = paramString3.outHeight;
            break;
            i2 = paramString3.outHeight;
            break label1275;
            j = paramString3.outHeight;
            break label1308;
            i = paramString3.outWidth;
            break label1329;
            i3 = k / j;
            if (paramString3.outHeight > j)
            {
              i = paramString3.outHeight * j / k;
              if (paramString3.outWidth <= j) {
                break label1932;
              }
            }
            for (j = j * paramString3.outWidth / k;; j = paramString3.outWidth)
            {
              k = j;
              break;
              i = paramString3.outHeight;
              break label1895;
            }
            paramString1 = "";
            break label1439;
            i2 = 0;
            break label1508;
          }
          Log.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6) });
          if (i2 == 0) {
            break label3228;
          }
          if (Build.VERSION.SDK_INT < 30) {
            break label3501;
          }
          paramString1 = p.b.O(MMApplicationContext.getContext(), paramString2);
          if (paramString1 == null) {
            break label3501;
          }
          paramString1 = paramString1.toString();
          s.nw(paramString1, paramString4);
          com.tencent.mm.an.f.baQ();
          if (!com.tencent.mm.an.b.sS(256)) {
            break label3405;
          }
          if (paramInt1 != 1) {
            break label3414;
          }
          i = 0;
          for (;;)
          {
            for (;;)
            {
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressMidPicLevel")).intValue();
                i = m;
              }
              catch (Exception paramString1)
              {
                continue;
              }
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressMidPicSize")).intValue();
                Log.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
                if (i > 10)
                {
                  i1 = i;
                  if (i <= 100) {}
                }
                else
                {
                  i1 = 52;
                }
                if ((m > 0) && (m <= 800)) {
                  break label3494;
                }
                i = 800;
                if (k <= i) {
                  break label3491;
                }
                k = i;
                if (j <= i) {
                  break label3488;
                }
                j = i;
                bool1 = true;
                paramBoolean = bool1;
                if (i4 != 0)
                {
                  paramBoolean = bool1;
                  if (i4 <= i1) {
                    paramBoolean = false;
                  }
                }
                if ((paramBoolean) || (l2 > 800L) || ((paramString3 != null) && ((i6 > i) || (i5 > i))))
                {
                  paramPString3.value = OE(paramString2);
                  paramPString4.value = a(paramPString3.value, "", ".jpg", false);
                  paramInt2 = BitmapUtil.createThumbNailMayUseOpt(false, paramString2, j, k, Bitmap.CompressFormat.JPEG, i1, paramPString4.value, paramb, paramInt2);
                  Log.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.FALSE, Integer.valueOf(paramInt2), Integer.valueOf(j), Integer.valueOf(k) });
                  l1 = 0L;
                  i = 38;
                  paramBoolean = false;
                  paramString1 = BitmapUtil.getImageOptions(paramString4);
                  if (paramString1 == null) {
                    continue;
                  }
                  j = paramString1.outWidth;
                  if (paramString1 == null) {
                    continue;
                  }
                  k = paramString1.outHeight;
                  l3 = s.boW(paramString4);
                  i1 = MMNativeJpeg.queryQuality(paramString4);
                  boolean bool4 = MMNativeJpeg.IsJpegFile(paramString4);
                  paramString1 = com.tencent.mm.plugin.report.service.h.CyF;
                  if (!bool3) {
                    continue;
                  }
                  m = 1;
                  paramString1.a(11713, new Object[] { Integer.valueOf(paramInt2), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(m), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt1), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i4), Integer.valueOf(i1) });
                  Log.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Long.valueOf(l3), Boolean.valueOf(bool4), paramString2, paramString4 });
                  if ((paramInt1 == 0) && (l3 >= 40960L) && (bool4) && (!MMNativeJpeg.isProgressive(paramString4)))
                  {
                    paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("EnableCDNUploadImg");
                    if ((!Util.isNullOrNil(paramString1)) && (paramString1.equals("1")))
                    {
                      l1 = Util.nowMilliSecond();
                      if (!paramBoolean) {
                        continue;
                      }
                      i = 19;
                      paramString1 = paramString4 + ".prog";
                      s.nw(paramString4, paramString1);
                      boolean bool2 = ImageOptimLib.convertToProgressive(paramString1, paramString4, n);
                      s.deleteFile(paramString1);
                      bool1 = bool2;
                      if (!bool2)
                      {
                        i = 29;
                        bool1 = MMNativeJpeg.convertToProgressive(paramString4, n);
                      }
                      long l4 = Util.nowMilliSecond();
                      long l5 = s.boW(paramString4);
                      paramString1 = com.tencent.mm.plugin.report.service.h.CyF;
                      if (!bool1) {
                        continue;
                      }
                      m = 1;
                      if (!bool3) {
                        continue;
                      }
                      n = 1;
                      paramString1.a(11713, new Object[] { Integer.valueOf(m), Long.valueOf(l4 - l1), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt1), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i4), Integer.valueOf(i1), Long.valueOf(l5) });
                      Log.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Long.valueOf(l3), Boolean.valueOf(bool4), paramString2, paramString4 });
                      if (!bool1)
                      {
                        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 186L, 1L, false);
                        Log.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString4 });
                      }
                    }
                  }
                  AppMethodBeat.o(223603);
                  return null;
                  if (BitmapUtil.createThumbNailMayUseOpt(false, paramString2, i5, i6, Bitmap.CompressFormat.JPEG, 100, paramString4, paramb, paramInt2) == 1) {
                    break;
                  }
                  com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(111L, 187L, 1L, false);
                  Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString2 });
                  AppMethodBeat.o(223603);
                  return null;
                }
              }
              catch (Exception paramString1)
              {
                m = 0;
                continue;
                paramPString3.value = paramPString1.value;
                paramPString4.value = paramPString2.value;
                Log.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(j), Integer.valueOf(k), paramPString3.value, paramPString4.value });
                l1 = 0L;
                paramInt2 = 1;
                i = 38;
                paramBoolean = false;
              }
            }
            Log.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
            l1 = 0L;
            paramInt2 = 1;
            i = 38;
            paramBoolean = false;
            continue;
            j = -1;
            continue;
            k = -1;
            continue;
            m = 2;
            continue;
            i = 9;
            bool1 = MMNativeJpeg.convertToProgressive(paramString4, n);
            continue;
            m = -1;
            continue;
            n = 2;
          }
        }
        if (CrashReportFactory.hasDebuger()) {
          bool1 = true;
        }
        if (!com.tencent.mm.compatible.util.d.oE(16)) {
          break label3534;
        }
        bool1 = false;
        Log.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        if ((m > 0) || (k > 0)) {
          break label1164;
        }
        j = 0;
        i = 1080;
        m = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        k = m;
        if (m <= 0) {
          k = 100;
        }
        i7 = k * 1024;
        m = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((m > 0) && (m < 100)) {
          break label3531;
        }
        m = 10;
        i4 = MMNativeJpeg.queryQuality(paramString2);
        k = 1;
        i1 = k;
        if (i4 != 0)
        {
          i1 = k;
          if (i4 <= n) {
            i1 = 0;
          }
        }
        Log.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[] { paramString2, paramString4, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(i7), Integer.valueOf(m) });
        if (!paramBoolean) {
          break label3220;
        }
        paramString3 = BitmapUtil.getImageOptions(paramString2);
        if ((paramString3 != null) && (paramString3.outWidth != 0) && (paramString3.outHeight != 0)) {
          break label1229;
        }
        if (paramString3 != null) {
          break label1223;
        }
        paramBoolean = true;
        Log.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString2, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(223603);
        return null;
        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelFor2G"), 40);
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception paramString1)
    {
      label3414:
      label3543:
      label3551:
      for (;;)
      {
        int n;
        int j;
        int m;
        int k;
        int i = 0;
        continue;
        i = j;
        label2399:
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          i = j;
          paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          label1508:
          label1895:
          if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
          {
            i = j;
            paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionFor3G");
          }
          else
          {
            i = j;
            paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("CompressResolutionFor4G");
            continue;
            label1275:
            n = i;
          }
        }
      }
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(150570);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(150570);
      return null;
    }
    if (paramString1.startsWith("SERVERID://")) {}
    for (String str1 = paramString1.substring(11);; str1 = "") {
      for (;;)
      {
        try
        {
          str1 = Ax(Long.valueOf(str1).longValue()).iXm;
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = com.tencent.mm.plugin.image.d.aSY();
            String str4 = com.tencent.mm.plugin.image.d.aSZ();
            String str2 = str1;
            if (Util.isNullOrNil(str1)) {
              str2 = paramString1;
            }
            paramString1 = FilePathGenerator.defGenPathWithOld(str3, str4, paramString2, str2, paramString3, 1, paramBoolean);
            AppMethodBeat.o(150570);
            return paramString1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString1.getMessage());
          AppMethodBeat.o(150570);
          return null;
        }
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(150576);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(150576);
      return null;
    }
    String str1 = bcA();
    String str2 = o(str1, "th_", "");
    Log.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[] { str2 });
    try
    {
      BitmapUtil.saveBitmapToImage(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length), 100, paramCompressFormat, str2, true);
      paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
      AppMethodBeat.o(150576);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      Log.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localIOException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(150576);
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(150576);
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1561
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1545	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 277
    //   16: ldc_w 1547
    //   19: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1561
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 832	com/tencent/mm/av/i:bcA	()Ljava/lang/String;
    //   38: astore 16
    //   40: aload_0
    //   41: aload 16
    //   43: ldc_w 834
    //   46: ldc_w 400
    //   49: invokevirtual 403	com/tencent/mm/av/i:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 17
    //   54: new 253	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   61: aload 17
    //   63: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1563
    //   69: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 15
    //   77: ldc_w 277
    //   80: ldc_w 1565
    //   83: aload 17
    //   85: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1381	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1566	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1570	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1573	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aconst_null
    //   124: astore 13
    //   126: aload 15
    //   128: iconst_0
    //   129: invokestatic 1577	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   132: astore 12
    //   134: aload 12
    //   136: astore 13
    //   138: aload 12
    //   140: aload_1
    //   141: invokevirtual 1582	java/io/OutputStream:write	([B)V
    //   144: aload 12
    //   146: astore 13
    //   148: aload 12
    //   150: invokevirtual 1585	java/io/OutputStream:flush	()V
    //   153: aload 12
    //   155: astore 13
    //   157: aload_1
    //   158: iload_3
    //   159: iload 4
    //   161: invokestatic 1586	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   164: astore 19
    //   166: aload 12
    //   168: astore 13
    //   170: aload_1
    //   171: arraylength
    //   172: istore 8
    //   174: aload 19
    //   176: ifnull +321 -> 497
    //   179: bipush 100
    //   181: istore 7
    //   183: aload 12
    //   185: astore 13
    //   187: aload_1
    //   188: arraylength
    //   189: istore_3
    //   190: iload_3
    //   191: ldc_w 1587
    //   194: if_icmple +534 -> 728
    //   197: new 1589	java/io/ByteArrayOutputStream
    //   200: dup
    //   201: invokespecial 1590	java/io/ByteArrayOutputStream:<init>	()V
    //   204: astore 14
    //   206: aload 14
    //   208: astore 13
    //   210: aload 19
    //   212: aload_2
    //   213: bipush 100
    //   215: aload 14
    //   217: invokevirtual 1594	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   220: pop
    //   221: aload 14
    //   223: astore 13
    //   225: aload 14
    //   227: invokevirtual 1597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   230: arraylength
    //   231: istore 4
    //   233: bipush 100
    //   235: istore_3
    //   236: aload 14
    //   238: astore 13
    //   240: iload_3
    //   241: istore 7
    //   243: aload 14
    //   245: invokevirtual 1597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   248: arraylength
    //   249: ldc_w 1587
    //   252: if_icmple +64 -> 316
    //   255: iload_3
    //   256: bipush 15
    //   258: if_icmplt +58 -> 316
    //   261: aload 14
    //   263: astore 13
    //   265: iload_3
    //   266: istore 7
    //   268: aload 14
    //   270: invokevirtual 1600	java/io/ByteArrayOutputStream:reset	()V
    //   273: iload_3
    //   274: iconst_5
    //   275: isub
    //   276: istore_3
    //   277: aload 14
    //   279: astore 13
    //   281: iload_3
    //   282: istore 7
    //   284: aload 19
    //   286: aload_2
    //   287: iload_3
    //   288: aload 14
    //   290: invokevirtual 1594	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   293: pop
    //   294: aload 14
    //   296: astore 13
    //   298: iload_3
    //   299: istore 7
    //   301: aload 14
    //   303: invokevirtual 1597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   306: arraylength
    //   307: istore 8
    //   309: iload 8
    //   311: istore 4
    //   313: goto -77 -> 236
    //   316: aload 12
    //   318: astore 13
    //   320: aload 14
    //   322: invokevirtual 1601	java/io/ByteArrayOutputStream:close	()V
    //   325: aload 12
    //   327: astore 13
    //   329: aload 19
    //   331: iload_3
    //   332: aload_2
    //   333: aload 17
    //   335: iconst_1
    //   336: invokestatic 648	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   339: pop
    //   340: aload 12
    //   342: astore 13
    //   344: ldc_w 277
    //   347: ldc_w 1603
    //   350: iconst_3
    //   351: anewarray 105	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: aload 15
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload 17
    //   363: aastore
    //   364: dup
    //   365: iconst_2
    //   366: iload_3
    //   367: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   370: aastore
    //   371: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload 12
    //   376: astore 13
    //   378: getstatic 848	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   381: sipush 16498
    //   384: bipush 10
    //   386: anewarray 105	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: aload 5
    //   393: invokestatic 1606	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   396: ldc_w 1608
    //   399: invokestatic 1614	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   402: aastore
    //   403: dup
    //   404: iconst_1
    //   405: iload 6
    //   407: invokestatic 551	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   410: aastore
    //   411: dup
    //   412: iconst_2
    //   413: iload 9
    //   415: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: aastore
    //   419: dup
    //   420: iconst_3
    //   421: aload 18
    //   423: getfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   426: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   429: aastore
    //   430: dup
    //   431: iconst_4
    //   432: aload 18
    //   434: getfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   437: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: dup
    //   442: iconst_5
    //   443: iload 4
    //   445: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aastore
    //   449: dup
    //   450: bipush 6
    //   452: aload 19
    //   454: invokevirtual 616	android/graphics/Bitmap:getHeight	()I
    //   457: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: aastore
    //   461: dup
    //   462: bipush 7
    //   464: aload 19
    //   466: invokevirtual 611	android/graphics/Bitmap:getWidth	()I
    //   469: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   472: aastore
    //   473: dup
    //   474: bipush 8
    //   476: iconst_0
    //   477: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: aastore
    //   481: dup
    //   482: bipush 9
    //   484: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   487: lload 10
    //   489: lsub
    //   490: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   493: aastore
    //   494: invokevirtual 854	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   497: aload 15
    //   499: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   502: ifeq +18 -> 520
    //   505: ldc_w 277
    //   508: ldc_w 1616
    //   511: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload 15
    //   516: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   519: pop
    //   520: aload 12
    //   522: ifnull +8 -> 530
    //   525: aload 12
    //   527: invokevirtual 1617	java/io/OutputStream:close	()V
    //   530: ldc 229
    //   532: aload 16
    //   534: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   537: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   540: astore_1
    //   541: ldc_w 1561
    //   544: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   547: aload_1
    //   548: areturn
    //   549: astore 13
    //   551: goto -226 -> 325
    //   554: astore 13
    //   556: aconst_null
    //   557: astore 14
    //   559: aload 14
    //   561: astore 13
    //   563: ldc_w 277
    //   566: ldc_w 1619
    //   569: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: iload 7
    //   574: istore_3
    //   575: iload 8
    //   577: istore 4
    //   579: aload 14
    //   581: ifnull -256 -> 325
    //   584: aload 12
    //   586: astore 13
    //   588: aload 14
    //   590: invokevirtual 1601	java/io/ByteArrayOutputStream:close	()V
    //   593: iload 7
    //   595: istore_3
    //   596: iload 8
    //   598: istore 4
    //   600: goto -275 -> 325
    //   603: astore 13
    //   605: iload 7
    //   607: istore_3
    //   608: iload 8
    //   610: istore 4
    //   612: goto -287 -> 325
    //   615: astore 5
    //   617: aconst_null
    //   618: astore 14
    //   620: aload 14
    //   622: ifnull +12 -> 634
    //   625: aload 12
    //   627: astore 13
    //   629: aload 14
    //   631: invokevirtual 1601	java/io/ByteArrayOutputStream:close	()V
    //   634: aload 12
    //   636: astore 13
    //   638: ldc_w 1561
    //   641: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   644: aload 12
    //   646: astore 13
    //   648: aload 5
    //   650: athrow
    //   651: astore 13
    //   653: aload 12
    //   655: astore 5
    //   657: aload 13
    //   659: astore 12
    //   661: ldc_w 277
    //   664: ldc_w 1556
    //   667: iconst_1
    //   668: anewarray 105	java/lang/Object
    //   671: dup
    //   672: iconst_0
    //   673: aload 12
    //   675: aastore
    //   676: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: aload_0
    //   680: aload_1
    //   681: iconst_1
    //   682: aload_2
    //   683: invokevirtual 1559	com/tencent/mm/av/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   686: astore_1
    //   687: aload 15
    //   689: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   692: ifeq +18 -> 710
    //   695: ldc_w 277
    //   698: ldc_w 1616
    //   701: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 15
    //   706: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   709: pop
    //   710: aload 5
    //   712: ifnull +8 -> 720
    //   715: aload 5
    //   717: invokevirtual 1617	java/io/OutputStream:close	()V
    //   720: ldc_w 1561
    //   723: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_1
    //   727: areturn
    //   728: aload 12
    //   730: astore 13
    //   732: aload 15
    //   734: aload 17
    //   736: invokestatic 1622	com/tencent/mm/vfs/s:nx	(Ljava/lang/String;Ljava/lang/String;)Z
    //   739: pop
    //   740: iload 7
    //   742: istore_3
    //   743: iload 8
    //   745: istore 4
    //   747: goto -407 -> 340
    //   750: astore 5
    //   752: aload 12
    //   754: astore 13
    //   756: ldc_w 277
    //   759: ldc_w 1556
    //   762: iconst_1
    //   763: anewarray 105	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: aload 5
    //   770: aastore
    //   771: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   774: aload 12
    //   776: astore 13
    //   778: aload_0
    //   779: aload_1
    //   780: iconst_1
    //   781: aload_2
    //   782: invokevirtual 1559	com/tencent/mm/av/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   785: astore_1
    //   786: aload 15
    //   788: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   791: ifeq +18 -> 809
    //   794: ldc_w 277
    //   797: ldc_w 1616
    //   800: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: aload 15
    //   805: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   808: pop
    //   809: aload 12
    //   811: ifnull +8 -> 819
    //   814: aload 12
    //   816: invokevirtual 1617	java/io/OutputStream:close	()V
    //   819: ldc_w 1561
    //   822: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   825: aload_1
    //   826: areturn
    //   827: astore_1
    //   828: aconst_null
    //   829: astore 13
    //   831: aload 15
    //   833: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   836: ifeq +18 -> 854
    //   839: ldc_w 277
    //   842: ldc_w 1616
    //   845: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   848: aload 15
    //   850: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   853: pop
    //   854: aload 13
    //   856: ifnull +8 -> 864
    //   859: aload 13
    //   861: invokevirtual 1617	java/io/OutputStream:close	()V
    //   864: ldc_w 1561
    //   867: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   870: aload_1
    //   871: athrow
    //   872: astore 13
    //   874: goto -240 -> 634
    //   877: astore_1
    //   878: goto -348 -> 530
    //   881: astore_2
    //   882: goto -162 -> 720
    //   885: astore_2
    //   886: goto -67 -> 819
    //   889: astore_2
    //   890: goto -26 -> 864
    //   893: astore_1
    //   894: goto -63 -> 831
    //   897: astore_1
    //   898: aload 5
    //   900: astore 13
    //   902: goto -71 -> 831
    //   905: astore 5
    //   907: aconst_null
    //   908: astore 12
    //   910: goto -158 -> 752
    //   913: astore 12
    //   915: aload 13
    //   917: astore 5
    //   919: goto -258 -> 661
    //   922: astore 5
    //   924: aload 13
    //   926: astore 14
    //   928: goto -308 -> 620
    //   931: astore 13
    //   933: goto -374 -> 559
    //   936: astore 13
    //   938: iload 4
    //   940: istore 8
    //   942: goto -383 -> 559
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	945	0	this	i
    //   0	945	1	paramArrayOfByte	byte[]
    //   0	945	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	945	3	paramInt1	int
    //   0	945	4	paramInt2	int
    //   0	945	5	paramString	String
    //   0	945	6	paramBoolean	boolean
    //   181	560	7	i	int
    //   172	769	8	j	int
    //   96	318	9	k	int
    //   33	455	10	l	long
    //   132	777	12	localObject1	Object
    //   913	1	12	localIOException1	IOException
    //   124	253	13	localObject2	Object
    //   549	1	13	localException1	Exception
    //   554	1	13	localException2	Exception
    //   561	26	13	localObject3	Object
    //   603	1	13	localException3	Exception
    //   627	20	13	localObject4	Object
    //   651	7	13	localIOException2	IOException
    //   730	130	13	localObject5	Object
    //   872	1	13	localException4	Exception
    //   900	25	13	str1	String
    //   931	1	13	localException5	Exception
    //   936	1	13	localException6	Exception
    //   204	723	14	localObject6	Object
    //   75	774	15	str2	String
    //   38	495	16	str3	String
    //   52	683	17	str4	String
    //   105	328	18	localOptions	BitmapFactory.Options
    //   164	301	19	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   320	325	549	java/lang/Exception
    //   197	206	554	java/lang/Exception
    //   588	593	603	java/lang/Exception
    //   197	206	615	finally
    //   138	144	651	java/io/IOException
    //   148	153	651	java/io/IOException
    //   157	166	651	java/io/IOException
    //   170	174	651	java/io/IOException
    //   187	190	651	java/io/IOException
    //   320	325	651	java/io/IOException
    //   329	340	651	java/io/IOException
    //   344	374	651	java/io/IOException
    //   378	497	651	java/io/IOException
    //   588	593	651	java/io/IOException
    //   629	634	651	java/io/IOException
    //   638	644	651	java/io/IOException
    //   648	651	651	java/io/IOException
    //   732	740	651	java/io/IOException
    //   138	144	750	java/lang/Exception
    //   148	153	750	java/lang/Exception
    //   157	166	750	java/lang/Exception
    //   170	174	750	java/lang/Exception
    //   187	190	750	java/lang/Exception
    //   329	340	750	java/lang/Exception
    //   344	374	750	java/lang/Exception
    //   378	497	750	java/lang/Exception
    //   638	644	750	java/lang/Exception
    //   648	651	750	java/lang/Exception
    //   732	740	750	java/lang/Exception
    //   126	134	827	finally
    //   629	634	872	java/lang/Exception
    //   525	530	877	java/lang/Exception
    //   715	720	881	java/lang/Exception
    //   814	819	885	java/lang/Exception
    //   859	864	889	java/lang/Exception
    //   138	144	893	finally
    //   148	153	893	finally
    //   157	166	893	finally
    //   170	174	893	finally
    //   187	190	893	finally
    //   320	325	893	finally
    //   329	340	893	finally
    //   344	374	893	finally
    //   378	497	893	finally
    //   588	593	893	finally
    //   629	634	893	finally
    //   638	644	893	finally
    //   648	651	893	finally
    //   732	740	893	finally
    //   756	774	893	finally
    //   778	786	893	finally
    //   661	687	897	finally
    //   126	134	905	java/lang/Exception
    //   126	134	913	java/io/IOException
    //   210	221	922	finally
    //   225	233	922	finally
    //   243	255	922	finally
    //   268	273	922	finally
    //   284	294	922	finally
    //   301	309	922	finally
    //   563	572	922	finally
    //   210	221	931	java/lang/Exception
    //   225	233	931	java/lang/Exception
    //   243	255	936	java/lang/Exception
    //   268	273	936	java/lang/Exception
    //   284	294	936	java/lang/Exception
    //   301	309	936	java/lang/Exception
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1624
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1545	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 277
    //   16: ldc_w 1547
    //   19: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1624
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 832	com/tencent/mm/av/i:bcA	()Ljava/lang/String;
    //   38: astore 17
    //   40: aload_0
    //   41: aload 17
    //   43: ldc_w 834
    //   46: ldc_w 400
    //   49: invokevirtual 403	com/tencent/mm/av/i:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 19
    //   54: new 253	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   61: aload 19
    //   63: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1563
    //   69: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 16
    //   77: ldc_w 277
    //   80: ldc_w 1565
    //   83: aload 19
    //   85: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1381	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1566	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1570	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1573	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aload 18
    //   125: getfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   128: istore 7
    //   130: aload 18
    //   132: getfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   135: istore 6
    //   137: sipush 720
    //   140: iload 7
    //   142: if_icmpgt +13 -> 155
    //   145: ldc_w 1625
    //   148: iload 6
    //   150: i2f
    //   151: fcmpl
    //   152: ifle +283 -> 435
    //   155: iload 7
    //   157: istore 5
    //   159: aconst_null
    //   160: astore 13
    //   162: aload 16
    //   164: iconst_0
    //   165: invokestatic 1577	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   168: astore 12
    //   170: aload 12
    //   172: astore 13
    //   174: aload 12
    //   176: aload_1
    //   177: invokevirtual 1582	java/io/OutputStream:write	([B)V
    //   180: aload 12
    //   182: astore 13
    //   184: aload 12
    //   186: invokevirtual 1585	java/io/OutputStream:flush	()V
    //   189: aload 12
    //   191: astore 13
    //   193: aload_1
    //   194: iload 5
    //   196: iload 6
    //   198: invokestatic 1586	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   201: astore 14
    //   203: aload 12
    //   205: astore 13
    //   207: iload 5
    //   209: aload 14
    //   211: invokevirtual 611	android/graphics/Bitmap:getWidth	()I
    //   214: if_icmpeq +240 -> 454
    //   217: aload 12
    //   219: astore 13
    //   221: aload 14
    //   223: iload 5
    //   225: iload 6
    //   227: iconst_1
    //   228: invokestatic 707	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   231: astore 14
    //   233: aload 12
    //   235: astore 13
    //   237: aload 14
    //   239: invokevirtual 616	android/graphics/Bitmap:getHeight	()I
    //   242: i2f
    //   243: aload 14
    //   245: invokevirtual 611	android/graphics/Bitmap:getWidth	()I
    //   248: i2f
    //   249: ldc_w 1626
    //   252: fmul
    //   253: fcmpl
    //   254: ifle +203 -> 457
    //   257: aload 12
    //   259: astore 13
    //   261: aload 14
    //   263: iconst_0
    //   264: iconst_0
    //   265: aload 14
    //   267: invokevirtual 611	android/graphics/Bitmap:getWidth	()I
    //   270: aload 14
    //   272: invokevirtual 611	android/graphics/Bitmap:getWidth	()I
    //   275: i2f
    //   276: ldc_w 1626
    //   279: fmul
    //   280: f2i
    //   281: invokestatic 1630	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   284: astore 15
    //   286: aload 12
    //   288: astore 13
    //   290: aload_1
    //   291: arraylength
    //   292: istore 6
    //   294: aload 15
    //   296: ifnull +405 -> 701
    //   299: bipush 70
    //   301: istore 5
    //   303: new 1589	java/io/ByteArrayOutputStream
    //   306: dup
    //   307: invokespecial 1590	java/io/ByteArrayOutputStream:<init>	()V
    //   310: astore 14
    //   312: aload 14
    //   314: astore 13
    //   316: aload 15
    //   318: aload_2
    //   319: bipush 70
    //   321: aload 14
    //   323: invokevirtual 1594	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   326: pop
    //   327: aload 14
    //   329: astore 13
    //   331: aload 14
    //   333: invokevirtual 1597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   336: arraylength
    //   337: istore 7
    //   339: bipush 70
    //   341: istore 5
    //   343: iload 7
    //   345: istore 6
    //   347: aload 14
    //   349: astore 13
    //   351: iload 5
    //   353: istore 7
    //   355: aload 14
    //   357: invokevirtual 1597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   360: arraylength
    //   361: ldc_w 1587
    //   364: if_icmple +125 -> 489
    //   367: iload 5
    //   369: bipush 15
    //   371: if_icmplt +118 -> 489
    //   374: aload 14
    //   376: astore 13
    //   378: iload 5
    //   380: istore 7
    //   382: aload 14
    //   384: invokevirtual 1600	java/io/ByteArrayOutputStream:reset	()V
    //   387: iload 5
    //   389: iconst_5
    //   390: isub
    //   391: istore 5
    //   393: aload 14
    //   395: astore 13
    //   397: iload 5
    //   399: istore 7
    //   401: aload 15
    //   403: aload_2
    //   404: iload 5
    //   406: aload 14
    //   408: invokevirtual 1594	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   411: pop
    //   412: aload 14
    //   414: astore 13
    //   416: iload 5
    //   418: istore 7
    //   420: aload 14
    //   422: invokevirtual 1597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   425: arraylength
    //   426: istore 8
    //   428: iload 8
    //   430: istore 6
    //   432: goto -85 -> 347
    //   435: sipush 720
    //   438: istore 5
    //   440: iload 6
    //   442: sipush 720
    //   445: imul
    //   446: iload 7
    //   448: idiv
    //   449: istore 6
    //   451: goto -292 -> 159
    //   454: goto -221 -> 233
    //   457: aload 12
    //   459: astore 13
    //   461: aload 14
    //   463: iconst_0
    //   464: iconst_0
    //   465: aload 14
    //   467: invokevirtual 616	android/graphics/Bitmap:getHeight	()I
    //   470: i2f
    //   471: ldc_w 1626
    //   474: fdiv
    //   475: f2i
    //   476: aload 14
    //   478: invokevirtual 616	android/graphics/Bitmap:getHeight	()I
    //   481: invokestatic 1630	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   484: astore 15
    //   486: goto -200 -> 286
    //   489: aload 12
    //   491: astore 13
    //   493: aload 14
    //   495: invokevirtual 1601	java/io/ByteArrayOutputStream:close	()V
    //   498: iload 6
    //   500: istore 8
    //   502: iload 5
    //   504: istore 7
    //   506: aload 12
    //   508: astore 13
    //   510: aload 15
    //   512: iload 7
    //   514: aload_2
    //   515: aload 19
    //   517: iconst_1
    //   518: invokestatic 648	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   521: pop
    //   522: aload 12
    //   524: astore 13
    //   526: ldc_w 277
    //   529: ldc_w 1603
    //   532: iconst_3
    //   533: anewarray 105	java/lang/Object
    //   536: dup
    //   537: iconst_0
    //   538: aload 16
    //   540: aastore
    //   541: dup
    //   542: iconst_1
    //   543: aload 19
    //   545: aastore
    //   546: dup
    //   547: iconst_2
    //   548: iload 7
    //   550: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   553: aastore
    //   554: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: aload 12
    //   559: astore 13
    //   561: getstatic 848	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   564: astore 14
    //   566: aload 12
    //   568: astore 13
    //   570: aload_3
    //   571: invokestatic 1606	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   574: ldc_w 1608
    //   577: invokestatic 1614	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   580: astore_3
    //   581: iload 4
    //   583: ifeq +355 -> 938
    //   586: iconst_1
    //   587: istore 5
    //   589: aload 12
    //   591: astore 13
    //   593: aload 14
    //   595: sipush 16498
    //   598: bipush 10
    //   600: anewarray 105	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: aload_3
    //   606: aastore
    //   607: dup
    //   608: iconst_1
    //   609: iload 5
    //   611: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_2
    //   617: iload 9
    //   619: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: aastore
    //   623: dup
    //   624: iconst_3
    //   625: aload 18
    //   627: getfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   630: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   633: aastore
    //   634: dup
    //   635: iconst_4
    //   636: aload 18
    //   638: getfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   641: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: aastore
    //   645: dup
    //   646: iconst_5
    //   647: iload 8
    //   649: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: aastore
    //   653: dup
    //   654: bipush 6
    //   656: aload 15
    //   658: invokevirtual 616	android/graphics/Bitmap:getHeight	()I
    //   661: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: aastore
    //   665: dup
    //   666: bipush 7
    //   668: aload 15
    //   670: invokevirtual 611	android/graphics/Bitmap:getWidth	()I
    //   673: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   676: aastore
    //   677: dup
    //   678: bipush 8
    //   680: iconst_1
    //   681: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   684: aastore
    //   685: dup
    //   686: bipush 9
    //   688: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   691: lload 10
    //   693: lsub
    //   694: invokestatic 284	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   697: aastore
    //   698: invokevirtual 854	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   701: aload 16
    //   703: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   706: ifeq +18 -> 724
    //   709: ldc_w 277
    //   712: ldc_w 1616
    //   715: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload 16
    //   720: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   723: pop
    //   724: aload 12
    //   726: ifnull +8 -> 734
    //   729: aload 12
    //   731: invokevirtual 1617	java/io/OutputStream:close	()V
    //   734: ldc 229
    //   736: aload 17
    //   738: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   741: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   744: astore_1
    //   745: ldc_w 1624
    //   748: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   751: aload_1
    //   752: areturn
    //   753: astore 13
    //   755: iload 5
    //   757: istore 7
    //   759: iload 6
    //   761: istore 8
    //   763: goto -257 -> 506
    //   766: astore 13
    //   768: aconst_null
    //   769: astore 14
    //   771: aload 14
    //   773: astore 13
    //   775: ldc_w 277
    //   778: ldc_w 1619
    //   781: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: iload 5
    //   786: istore 7
    //   788: iload 6
    //   790: istore 8
    //   792: aload 14
    //   794: ifnull -288 -> 506
    //   797: aload 12
    //   799: astore 13
    //   801: aload 14
    //   803: invokevirtual 1601	java/io/ByteArrayOutputStream:close	()V
    //   806: iload 5
    //   808: istore 7
    //   810: iload 6
    //   812: istore 8
    //   814: goto -308 -> 506
    //   817: astore 13
    //   819: iload 5
    //   821: istore 7
    //   823: iload 6
    //   825: istore 8
    //   827: goto -321 -> 506
    //   830: astore_3
    //   831: aconst_null
    //   832: astore 14
    //   834: aload 14
    //   836: ifnull +12 -> 848
    //   839: aload 12
    //   841: astore 13
    //   843: aload 14
    //   845: invokevirtual 1601	java/io/ByteArrayOutputStream:close	()V
    //   848: aload 12
    //   850: astore 13
    //   852: ldc_w 1624
    //   855: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: aload 12
    //   860: astore 13
    //   862: aload_3
    //   863: athrow
    //   864: astore 13
    //   866: aload 12
    //   868: astore_3
    //   869: aload 13
    //   871: astore 12
    //   873: ldc_w 277
    //   876: ldc_w 1556
    //   879: iconst_1
    //   880: anewarray 105	java/lang/Object
    //   883: dup
    //   884: iconst_0
    //   885: aload 12
    //   887: aastore
    //   888: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   891: aload_0
    //   892: aload_1
    //   893: iconst_1
    //   894: aload_2
    //   895: invokevirtual 1559	com/tencent/mm/av/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   898: astore_1
    //   899: aload 16
    //   901: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   904: ifeq +18 -> 922
    //   907: ldc_w 277
    //   910: ldc_w 1616
    //   913: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   916: aload 16
    //   918: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   921: pop
    //   922: aload_3
    //   923: ifnull +7 -> 930
    //   926: aload_3
    //   927: invokevirtual 1617	java/io/OutputStream:close	()V
    //   930: ldc_w 1624
    //   933: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   936: aload_1
    //   937: areturn
    //   938: iconst_0
    //   939: istore 5
    //   941: goto -352 -> 589
    //   944: astore_3
    //   945: aconst_null
    //   946: astore 12
    //   948: aload 12
    //   950: astore 13
    //   952: ldc_w 277
    //   955: ldc_w 1556
    //   958: iconst_1
    //   959: anewarray 105	java/lang/Object
    //   962: dup
    //   963: iconst_0
    //   964: aload_3
    //   965: aastore
    //   966: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   969: aload 12
    //   971: astore 13
    //   973: aload_0
    //   974: aload_1
    //   975: iconst_1
    //   976: aload_2
    //   977: invokevirtual 1559	com/tencent/mm/av/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   980: astore_1
    //   981: aload 16
    //   983: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   986: ifeq +18 -> 1004
    //   989: ldc_w 277
    //   992: ldc_w 1616
    //   995: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   998: aload 16
    //   1000: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   1003: pop
    //   1004: aload 12
    //   1006: ifnull +8 -> 1014
    //   1009: aload 12
    //   1011: invokevirtual 1617	java/io/OutputStream:close	()V
    //   1014: ldc_w 1624
    //   1017: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1020: aload_1
    //   1021: areturn
    //   1022: astore_1
    //   1023: aconst_null
    //   1024: astore 13
    //   1026: aload 16
    //   1028: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   1031: ifeq +18 -> 1049
    //   1034: ldc_w 277
    //   1037: ldc_w 1616
    //   1040: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1043: aload 16
    //   1045: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   1048: pop
    //   1049: aload 13
    //   1051: ifnull +8 -> 1059
    //   1054: aload 13
    //   1056: invokevirtual 1617	java/io/OutputStream:close	()V
    //   1059: ldc_w 1624
    //   1062: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1065: aload_1
    //   1066: athrow
    //   1067: astore 13
    //   1069: goto -221 -> 848
    //   1072: astore_1
    //   1073: goto -339 -> 734
    //   1076: astore_2
    //   1077: goto -147 -> 930
    //   1080: astore_2
    //   1081: goto -67 -> 1014
    //   1084: astore_2
    //   1085: goto -26 -> 1059
    //   1088: astore_1
    //   1089: goto -63 -> 1026
    //   1092: astore_1
    //   1093: aload_3
    //   1094: astore 13
    //   1096: goto -70 -> 1026
    //   1099: astore_3
    //   1100: goto -152 -> 948
    //   1103: astore 12
    //   1105: aload 13
    //   1107: astore_3
    //   1108: goto -235 -> 873
    //   1111: astore_3
    //   1112: aload 13
    //   1114: astore 14
    //   1116: goto -282 -> 834
    //   1119: astore 13
    //   1121: goto -350 -> 771
    //   1124: astore 13
    //   1126: iload 7
    //   1128: istore 5
    //   1130: goto -359 -> 771
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1133	0	this	i
    //   0	1133	1	paramArrayOfByte	byte[]
    //   0	1133	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	1133	3	paramString	String
    //   0	1133	4	paramBoolean	boolean
    //   157	972	5	i	int
    //   135	689	6	j	int
    //   128	999	7	k	int
    //   426	400	8	m	int
    //   96	522	9	n	int
    //   33	659	10	l	long
    //   168	842	12	localObject1	Object
    //   1103	1	12	localIOException1	IOException
    //   160	432	13	localObject2	Object
    //   753	1	13	localException1	Exception
    //   766	1	13	localException2	Exception
    //   773	27	13	localObject3	Object
    //   817	1	13	localException3	Exception
    //   841	20	13	localObject4	Object
    //   864	6	13	localIOException2	IOException
    //   950	105	13	localObject5	Object
    //   1067	1	13	localException4	Exception
    //   1094	19	13	str1	String
    //   1119	1	13	localException5	Exception
    //   1124	1	13	localException6	Exception
    //   201	914	14	localObject6	Object
    //   284	385	15	localBitmap	Bitmap
    //   75	969	16	str2	String
    //   38	699	17	str3	String
    //   105	532	18	localOptions	BitmapFactory.Options
    //   52	492	19	str4	String
    // Exception table:
    //   from	to	target	type
    //   493	498	753	java/lang/Exception
    //   303	312	766	java/lang/Exception
    //   801	806	817	java/lang/Exception
    //   303	312	830	finally
    //   174	180	864	java/io/IOException
    //   184	189	864	java/io/IOException
    //   193	203	864	java/io/IOException
    //   207	217	864	java/io/IOException
    //   221	233	864	java/io/IOException
    //   237	257	864	java/io/IOException
    //   261	286	864	java/io/IOException
    //   290	294	864	java/io/IOException
    //   461	486	864	java/io/IOException
    //   493	498	864	java/io/IOException
    //   510	522	864	java/io/IOException
    //   526	557	864	java/io/IOException
    //   561	566	864	java/io/IOException
    //   570	581	864	java/io/IOException
    //   593	701	864	java/io/IOException
    //   801	806	864	java/io/IOException
    //   843	848	864	java/io/IOException
    //   852	858	864	java/io/IOException
    //   862	864	864	java/io/IOException
    //   162	170	944	java/lang/Exception
    //   162	170	1022	finally
    //   843	848	1067	java/lang/Exception
    //   729	734	1072	java/lang/Exception
    //   926	930	1076	java/lang/Exception
    //   1009	1014	1080	java/lang/Exception
    //   1054	1059	1084	java/lang/Exception
    //   174	180	1088	finally
    //   184	189	1088	finally
    //   193	203	1088	finally
    //   207	217	1088	finally
    //   221	233	1088	finally
    //   237	257	1088	finally
    //   261	286	1088	finally
    //   290	294	1088	finally
    //   461	486	1088	finally
    //   493	498	1088	finally
    //   510	522	1088	finally
    //   526	557	1088	finally
    //   561	566	1088	finally
    //   570	581	1088	finally
    //   593	701	1088	finally
    //   801	806	1088	finally
    //   843	848	1088	finally
    //   852	858	1088	finally
    //   862	864	1088	finally
    //   952	969	1088	finally
    //   973	981	1088	finally
    //   873	899	1092	finally
    //   174	180	1099	java/lang/Exception
    //   184	189	1099	java/lang/Exception
    //   193	203	1099	java/lang/Exception
    //   207	217	1099	java/lang/Exception
    //   221	233	1099	java/lang/Exception
    //   237	257	1099	java/lang/Exception
    //   261	286	1099	java/lang/Exception
    //   290	294	1099	java/lang/Exception
    //   461	486	1099	java/lang/Exception
    //   510	522	1099	java/lang/Exception
    //   526	557	1099	java/lang/Exception
    //   561	566	1099	java/lang/Exception
    //   570	581	1099	java/lang/Exception
    //   593	701	1099	java/lang/Exception
    //   852	858	1099	java/lang/Exception
    //   862	864	1099	java/lang/Exception
    //   162	170	1103	java/io/IOException
    //   316	327	1111	finally
    //   331	339	1111	finally
    //   355	367	1111	finally
    //   382	387	1111	finally
    //   401	412	1111	finally
    //   420	428	1111	finally
    //   775	784	1111	finally
    //   316	327	1119	java/lang/Exception
    //   331	339	1119	java/lang/Exception
    //   355	367	1124	java/lang/Exception
    //   382	387	1124	java/lang/Exception
    //   401	412	1124	java/lang/Exception
    //   420	428	1124	java/lang/Exception
  }
  
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(150575);
    paramArrayOfByte = a(paramArrayOfByte, paramBoolean, paramCompressFormat, false);
    AppMethodBeat.o(150575);
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean1, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 1635
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1545	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 277
    //   16: ldc_w 1547
    //   19: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1635
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 832	com/tencent/mm/av/i:bcA	()Ljava/lang/String;
    //   33: astore 9
    //   35: aload_0
    //   36: aload 9
    //   38: ldc_w 834
    //   41: ldc_w 400
    //   44: invokevirtual 403	com/tencent/mm/av/i:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 10
    //   49: new 253	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   56: aload 10
    //   58: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1563
    //   64: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 8
    //   72: ldc_w 277
    //   75: ldc_w 1565
    //   78: aload 10
    //   80: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 8
    //   91: iconst_0
    //   92: invokestatic 1577	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   95: astore 7
    //   97: aload 7
    //   99: aload_1
    //   100: invokevirtual 1582	java/io/OutputStream:write	([B)V
    //   103: aload 7
    //   105: invokevirtual 1585	java/io/OutputStream:flush	()V
    //   108: iload_2
    //   109: ifeq +113 -> 222
    //   112: sipush 128
    //   115: istore 5
    //   117: goto +298 -> 415
    //   120: iload 4
    //   122: ifeq +114 -> 236
    //   125: aload 8
    //   127: aconst_null
    //   128: invokestatic 1638	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +37 -> 170
    //   136: aload_1
    //   137: bipush 90
    //   139: aload_3
    //   140: aload 10
    //   142: iconst_1
    //   143: invokestatic 648	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   146: pop
    //   147: ldc_w 277
    //   150: ldc_w 1640
    //   153: iconst_2
    //   154: anewarray 105	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload 8
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload 10
    //   166: aastore
    //   167: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload 8
    //   172: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   175: ifeq +18 -> 193
    //   178: ldc_w 277
    //   181: ldc_w 1616
    //   184: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 8
    //   189: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   192: pop
    //   193: aload 7
    //   195: ifnull +8 -> 203
    //   198: aload 7
    //   200: invokevirtual 1617	java/io/OutputStream:close	()V
    //   203: ldc 229
    //   205: aload 9
    //   207: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   213: astore_1
    //   214: ldc_w 1635
    //   217: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_1
    //   221: areturn
    //   222: bipush 120
    //   224: istore 5
    //   226: goto +189 -> 415
    //   229: bipush 120
    //   231: istore 6
    //   233: goto -113 -> 120
    //   236: aload 8
    //   238: iload 5
    //   240: iload 6
    //   242: iconst_0
    //   243: invokestatic 1644	com/tencent/mm/sdk/platformtools/BitmapUtil:extractThumbNail	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   246: astore_1
    //   247: goto -115 -> 132
    //   250: astore_3
    //   251: aconst_null
    //   252: astore_1
    //   253: getstatic 848	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   256: ldc2_w 1246
    //   259: ldc2_w 1645
    //   262: lconst_1
    //   263: iconst_0
    //   264: invokevirtual 1253	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   267: ldc_w 277
    //   270: new 253	java/lang/StringBuilder
    //   273: dup
    //   274: ldc_w 1648
    //   277: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: aload 9
    //   282: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 1650
    //   288: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_3
    //   292: invokevirtual 1260	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 8
    //   306: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   309: ifeq +18 -> 327
    //   312: ldc_w 277
    //   315: ldc_w 1616
    //   318: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 8
    //   323: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   326: pop
    //   327: aload_1
    //   328: ifnull +7 -> 335
    //   331: aload_1
    //   332: invokevirtual 1617	java/io/OutputStream:close	()V
    //   335: ldc_w 1635
    //   338: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aconst_null
    //   342: areturn
    //   343: astore_3
    //   344: aconst_null
    //   345: astore_1
    //   346: aload 8
    //   348: invokestatic 413	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   351: ifeq +18 -> 369
    //   354: ldc_w 277
    //   357: ldc_w 1616
    //   360: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 8
    //   365: invokestatic 1143	com/tencent/mm/vfs/s:deleteFile	(Ljava/lang/String;)Z
    //   368: pop
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 1617	java/io/OutputStream:close	()V
    //   377: ldc_w 1635
    //   380: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload_3
    //   384: athrow
    //   385: astore_1
    //   386: goto -183 -> 203
    //   389: astore_1
    //   390: goto -55 -> 335
    //   393: astore_1
    //   394: goto -17 -> 377
    //   397: astore_3
    //   398: aload 7
    //   400: astore_1
    //   401: goto -55 -> 346
    //   404: astore_3
    //   405: goto -59 -> 346
    //   408: astore_3
    //   409: aload 7
    //   411: astore_1
    //   412: goto -159 -> 253
    //   415: iload_2
    //   416: ifeq -187 -> 229
    //   419: sipush 128
    //   422: istore 6
    //   424: goto -304 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	i
    //   0	427	1	paramArrayOfByte	byte[]
    //   0	427	2	paramBoolean1	boolean
    //   0	427	3	paramCompressFormat	Bitmap.CompressFormat
    //   0	427	4	paramBoolean2	boolean
    //   115	124	5	i	int
    //   231	192	6	j	int
    //   95	315	7	localOutputStream	java.io.OutputStream
    //   70	294	8	str1	String
    //   33	248	9	str2	String
    //   47	118	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	97	250	java/lang/Exception
    //   89	97	343	finally
    //   198	203	385	java/lang/Exception
    //   331	335	389	java/lang/Exception
    //   373	377	393	java/lang/Exception
    //   97	108	397	finally
    //   125	132	397	finally
    //   136	170	397	finally
    //   236	247	397	finally
    //   253	304	404	finally
    //   97	108	408	java/lang/Exception
    //   125	132	408	java/lang/Exception
    //   136	170	408	java/lang/Exception
    //   236	247	408	java/lang/Exception
  }
  
  public final HashMap<Long, g> a(Long... paramVarArgs)
  {
    AppMethodBeat.i(150601);
    Object localObject1 = "(";
    int k = paramVarArgs.length;
    int i = 0;
    int j = 1;
    Object localObject2;
    if (i < k)
    {
      long l = paramVarArgs[i].longValue();
      localObject2 = new StringBuilder().append((String)localObject1);
      if (j != 0) {}
      for (localObject1 = Long.valueOf(l);; localObject1 = ",".concat(String.valueOf(l)))
      {
        localObject1 = localObject1;
        i += 1;
        j = 0;
        break;
      }
    }
    paramVarArgs = b("ImgInfo2", null, "msgSvrId in ".concat(String.valueOf((String)localObject1 + ")")), null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new g();
      ((g)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((g)localObject2).dTS), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150601);
    return localObject1;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, float paramFloat, int paramInt1, int paramInt2, ImageView paramImageView2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(150584);
    boolean bool = a(paramImageView1, paramString, false, paramFloat, paramInt1, paramInt2, paramImageView2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(150584);
    return bool;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, ImageView paramImageView2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(150585);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      AppMethodBeat.o(150585);
      return false;
    }
    label594:
    label606:
    label621:
    label750:
    label1137:
    for (;;)
    {
      synchronized (this.iYd)
      {
        boolean bool = this.iYd.containsKey(paramString);
        String str = d(paramString, paramBoolean, false);
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { Util.nullAsNil(paramString) });
          AppMethodBeat.o(150585);
          return false;
        }
        localObject = str;
        if (!bool)
        {
          localObject = str;
          if (!str.endsWith("hd"))
          {
            localObject = str;
            if (s.YS(str + "hd"))
            {
              this.iYd.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1140;
        }
        paramString = (Bitmap)this.iXW.aT(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, true, 2131231628);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1137;
          }
          paramString = (Bitmap)this.iXW.aT(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label661;
          }
          Log.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          i.a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label594;
          }
          localObject = this.iYe;
          if (paramInt4 != 0) {
            break label606;
          }
          ((FrameLayout.LayoutParams)localObject).gravity = 5;
          paramImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramString.getWidth() < paramString.getHeight() * 2.5D) {
            break label621;
          }
          paramInt1 = 1;
          if (paramString.getHeight() < paramString.getWidth() * 2.5D) {
            break label627;
          }
          paramInt2 = 1;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            paramImageView1.setScaleType(ImageView.ScaleType.CENTER);
          }
          if (paramImageView2 != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label633;
            }
            paramImageView1.gravity = 5;
            paramImageView2.setLayoutParams(paramImageView1);
          }
          if (paramView != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label647;
            }
            paramImageView1.gravity = 5;
            paramView.setLayoutParams(paramImageView1);
          }
          AppMethodBeat.o(150585);
          return true;
        }
      }
      if (this.iXW.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
        Log.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(String.valueOf(localObject)));
      }
      int i = 0;
      continue;
      Object localObject = (FrameLayout.LayoutParams)paramImageView1.getLayoutParams();
      continue;
      label627:
      label1140:
      if (paramInt4 == 1)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
        continue;
        paramInt1 = 0;
        continue;
        paramInt2 = 0;
        continue;
        label633:
        if (paramInt4 == 1)
        {
          paramImageView1.gravity = 3;
          continue;
          if (paramInt4 == 1)
          {
            paramImageView1.gravity = 3;
            continue;
            float f;
            if (paramInt3 > 0)
            {
              paramImageView1.setBackgroundResource(paramInt3);
              paramImageView1.setImageDrawable(null);
              if ((paramInt1 >= 160) || (paramInt2 >= 160)) {
                if (paramInt2 > paramInt1)
                {
                  f = 160.0F / paramInt2;
                  paramInt1 = (int)(paramInt1 * f);
                  paramInt2 = (int)(f * paramInt2);
                  if (paramInt1 <= 0) {
                    break label933;
                  }
                  paramInt3 = (int)(paramInt1 * paramFloat);
                  if (paramInt2 <= 0) {
                    break label940;
                  }
                  paramInt1 = paramInt2;
                  paramInt1 = (int)(paramInt1 * paramFloat);
                  paramInt2 = paramInt3;
                  if (paramInt2 >= 60.0F * paramFloat) {
                    break label1134;
                  }
                  Log.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(paramInt2) });
                  paramInt2 = (int)(60.0F * paramFloat);
                }
              }
            }
            for (;;)
            {
              paramInt3 = paramInt1;
              if (paramInt1 < 60.0F * paramFloat)
              {
                Log.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(paramInt1) });
                paramInt3 = (int)(60.0F * paramFloat);
              }
              paramString = new FrameLayout.LayoutParams(paramInt2, paramInt3);
              if (paramInt4 == 0)
              {
                paramString.gravity = 5;
                if (paramView == null) {
                  break label1131;
                }
                paramView.setLayoutParams(paramString);
              }
              for (;;)
              {
                paramImageView1.setLayoutParams(paramString);
                if (i == 0) {
                  a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, true, 2131231628);
                }
                AppMethodBeat.o(150585);
                return false;
                f = 160.0F / paramInt1;
                break;
                paramInt1 = 120;
                break label732;
                paramInt1 = 75;
                break label750;
                if (paramInt1 > 0)
                {
                  paramInt3 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label997;
                  }
                }
                for (;;)
                {
                  paramInt1 = (int)(paramInt2 * paramFloat * 1.25F);
                  paramInt2 = paramInt3;
                  break;
                  paramInt1 = 120;
                  break label952;
                  paramInt2 = 75;
                }
                if (paramInt4 != 1) {
                  break label875;
                }
                paramString.gravity = 3;
                break label875;
                if ((this.iYf == null) || (this.iYf.get() == null)) {
                  this.iYf = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.iYf.get());
                if (paramInt1 > 0)
                {
                  paramInt1 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label1124;
                  }
                }
                for (;;)
                {
                  paramString = new FrameLayout.LayoutParams(paramInt1, (int)(paramInt2 * paramFloat * 1.25F));
                  break;
                  paramInt1 = 120;
                  break label1075;
                  paramInt2 = 75;
                }
              }
            }
            continue;
            i = 0;
            paramString = null;
          }
        }
      }
    }
  }
  
  public final boolean a(ca paramca, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(223607);
    String str = W(paramca);
    if (!Util.isNullOrNil(str))
    {
      boolean bool = a(str, paramca.field_imgPath, paramInt1, paramInt2, 0, 0);
      AppMethodBeat.o(223607);
      return bool;
    }
    AppMethodBeat.o(223607);
    return false;
  }
  
  /* Error */
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 1730
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 277
    //   9: ldc_w 1732
    //   12: iconst_5
    //   13: anewarray 105	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_1
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_2
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: iload_3
    //   27: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: iload 4
    //   35: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_4
    //   41: invokestatic 557	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   44: aastore
    //   45: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   51: lstore 10
    //   53: invokestatic 682	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   56: invokestatic 1095	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   59: fstore 7
    //   61: aload_1
    //   62: invokestatic 578	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +10 -> 75
    //   68: aload_2
    //   69: invokestatic 578	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifeq +11 -> 83
    //   75: ldc_w 1730
    //   78: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_2
    //   85: iconst_0
    //   86: iconst_1
    //   87: invokevirtual 663	com/tencent/mm/av/i:d	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   90: astore 13
    //   92: aload 13
    //   94: invokestatic 578	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   97: ifeq +11 -> 108
    //   100: ldc_w 1730
    //   103: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 13
    //   110: ldc_w 580
    //   113: invokevirtual 583	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +98 -> 214
    //   119: new 253	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   126: aload 13
    //   128: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 580
    //   134: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 15
    //   142: aload 13
    //   144: astore 14
    //   146: aload 15
    //   148: astore 13
    //   150: aload 14
    //   152: invokestatic 1379	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   155: astore 16
    //   157: aload 16
    //   159: ifnull +23 -> 182
    //   162: aload 16
    //   164: getfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   167: ifle +15 -> 182
    //   170: aload 16
    //   172: astore 15
    //   174: aload 16
    //   176: getfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   179: ifgt +121 -> 300
    //   182: getstatic 848	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   185: ldc2_w 1246
    //   188: ldc2_w 1733
    //   191: lconst_1
    //   192: iconst_0
    //   193: invokevirtual 1253	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   196: aload 14
    //   198: invokestatic 480	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   201: lconst_0
    //   202: lcmp
    //   203: ifle +29 -> 232
    //   206: ldc_w 1730
    //   209: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: iconst_0
    //   213: ireturn
    //   214: aload 13
    //   216: iconst_0
    //   217: aload 13
    //   219: invokevirtual 407	java/lang/String:length	()I
    //   222: iconst_2
    //   223: isub
    //   224: invokevirtual 620	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore 14
    //   229: goto -79 -> 150
    //   232: new 1381	android/graphics/BitmapFactory$Options
    //   235: dup
    //   236: invokespecial 1566	android/graphics/BitmapFactory$Options:<init>	()V
    //   239: astore 15
    //   241: aload 15
    //   243: invokestatic 1738	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   246: ldc_w 277
    //   249: ldc_w 1740
    //   252: iconst_3
    //   253: anewarray 105	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload 15
    //   260: aastore
    //   261: dup
    //   262: iconst_1
    //   263: aload 15
    //   265: getfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   268: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: aload 15
    //   276: getfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   279: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: invokestatic 289	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: getstatic 848	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   289: ldc2_w 1246
    //   292: ldc2_w 1741
    //   295: lconst_1
    //   296: iconst_0
    //   297: invokevirtual 1253	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   300: aload 15
    //   302: getfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   305: ifne +10 -> 315
    //   308: aload 15
    //   310: iload 5
    //   312: putfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   315: aload 15
    //   317: getfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   320: ifne +10 -> 330
    //   323: aload 15
    //   325: iload 6
    //   327: putfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   330: aload 15
    //   332: getfield 1384	android/graphics/BitmapFactory$Options:outWidth	I
    //   335: i2f
    //   336: fload 7
    //   338: fmul
    //   339: ldc_w 690
    //   342: fmul
    //   343: f2i
    //   344: istore 9
    //   346: aload 15
    //   348: getfield 1387	android/graphics/BitmapFactory$Options:outHeight	I
    //   351: i2f
    //   352: fload 7
    //   354: fmul
    //   355: ldc_w 690
    //   358: fmul
    //   359: f2i
    //   360: istore 8
    //   362: iload 9
    //   364: i2f
    //   365: ldc_w 691
    //   368: fload 7
    //   370: fmul
    //   371: fcmpl
    //   372: ifge +24 -> 396
    //   375: iload 8
    //   377: istore 6
    //   379: iload 9
    //   381: istore 5
    //   383: iload 8
    //   385: i2f
    //   386: ldc_w 691
    //   389: fload 7
    //   391: fmul
    //   392: fcmpl
    //   393: iflt +40 -> 433
    //   396: iload 8
    //   398: iload 9
    //   400: if_icmple +221 -> 621
    //   403: ldc_w 691
    //   406: fload 7
    //   408: fmul
    //   409: iload 8
    //   411: i2f
    //   412: fdiv
    //   413: fstore 7
    //   415: iload 9
    //   417: i2f
    //   418: fload 7
    //   420: fmul
    //   421: f2i
    //   422: istore 5
    //   424: fload 7
    //   426: iload 8
    //   428: i2f
    //   429: fmul
    //   430: f2i
    //   431: istore 6
    //   433: iload 4
    //   435: ifne +201 -> 636
    //   438: aload_1
    //   439: iload 6
    //   441: iload 5
    //   443: getstatic 644	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   446: bipush 80
    //   448: aload 13
    //   450: iconst_1
    //   451: new 485	com/tencent/mm/pointers/PInt
    //   454: dup
    //   455: invokespecial 486	com/tencent/mm/pointers/PInt:<init>	()V
    //   458: new 485	com/tencent/mm/pointers/PInt
    //   461: dup
    //   462: invokespecial 486	com/tencent/mm/pointers/PInt:<init>	()V
    //   465: iconst_1
    //   466: iconst_m1
    //   467: invokestatic 1746	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;ZLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;ZI)Z
    //   470: istore 12
    //   472: ldc_w 277
    //   475: ldc_w 1748
    //   478: iconst_4
    //   479: anewarray 105	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: new 253	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 254	java/lang/StringBuilder:<init>	()V
    //   491: invokestatic 245	java/lang/System:currentTimeMillis	()J
    //   494: lload 10
    //   496: lsub
    //   497: invokevirtual 261	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: aastore
    //   504: dup
    //   505: iconst_1
    //   506: iload 6
    //   508: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: aastore
    //   512: dup
    //   513: iconst_2
    //   514: iload 5
    //   516: invokestatic 527	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: aastore
    //   520: dup
    //   521: iconst_3
    //   522: iload 12
    //   524: invokestatic 551	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   527: aastore
    //   528: invokestatic 429	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload_0
    //   532: aload 14
    //   534: iconst_1
    //   535: invokestatic 682	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   538: invokestatic 1095	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   541: iconst_1
    //   542: iconst_0
    //   543: iconst_1
    //   544: iload_3
    //   545: iconst_0
    //   546: invokespecial 1268	com/tencent/mm/av/i:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   549: pop
    //   550: iload 12
    //   552: ifeq +176 -> 728
    //   555: aload_0
    //   556: getfield 154	com/tencent/mm/av/i:iYd	Ljava/util/Map;
    //   559: astore_1
    //   560: aload_1
    //   561: monitorenter
    //   562: aload_0
    //   563: getfield 154	com/tencent/mm/av/i:iYd	Ljava/util/Map;
    //   566: aload_2
    //   567: invokeinterface 1675 2 0
    //   572: ifeq +38 -> 610
    //   575: aload_0
    //   576: getfield 154	com/tencent/mm/av/i:iYd	Ljava/util/Map;
    //   579: aload_2
    //   580: invokeinterface 918 2 0
    //   585: checkcast 58	java/lang/String
    //   588: ldc_w 580
    //   591: invokevirtual 583	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   594: ifne +16 -> 610
    //   597: aload_0
    //   598: getfield 154	com/tencent/mm/av/i:iYd	Ljava/util/Map;
    //   601: aload_2
    //   602: aload 13
    //   604: invokeinterface 901 3 0
    //   609: pop
    //   610: aload_1
    //   611: monitorexit
    //   612: ldc_w 1730
    //   615: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: iload 12
    //   620: ireturn
    //   621: ldc_w 691
    //   624: fload 7
    //   626: fmul
    //   627: iload 9
    //   629: i2f
    //   630: fdiv
    //   631: fstore 7
    //   633: goto -218 -> 415
    //   636: aload_1
    //   637: iload 6
    //   639: iload 5
    //   641: getstatic 644	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   644: bipush 80
    //   646: aload 13
    //   648: iconst_1
    //   649: new 485	com/tencent/mm/pointers/PInt
    //   652: dup
    //   653: invokespecial 486	com/tencent/mm/pointers/PInt:<init>	()V
    //   656: new 485	com/tencent/mm/pointers/PInt
    //   659: dup
    //   660: invokespecial 486	com/tencent/mm/pointers/PInt:<init>	()V
    //   663: iconst_1
    //   664: iconst_1
    //   665: iconst_m1
    //   666: invokestatic 1751	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;ZLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;ZZI)Z
    //   669: istore 12
    //   671: goto -199 -> 472
    //   674: astore_1
    //   675: getstatic 848	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   678: ldc2_w 1246
    //   681: ldc2_w 1752
    //   684: lconst_1
    //   685: iconst_0
    //   686: invokevirtual 1253	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   689: ldc_w 277
    //   692: ldc_w 1755
    //   695: iconst_1
    //   696: anewarray 105	java/lang/Object
    //   699: dup
    //   700: iconst_0
    //   701: aload_1
    //   702: invokevirtual 1756	java/lang/Exception:toString	()Ljava/lang/String;
    //   705: aastore
    //   706: invokestatic 735	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   709: ldc_w 1730
    //   712: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   715: iconst_0
    //   716: ireturn
    //   717: astore_2
    //   718: aload_1
    //   719: monitorexit
    //   720: ldc_w 1730
    //   723: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_2
    //   727: athrow
    //   728: getstatic 848	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
    //   731: ldc2_w 1246
    //   734: ldc2_w 1752
    //   737: lconst_1
    //   738: iconst_0
    //   739: invokevirtual 1253	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   742: goto -130 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	this	i
    //   0	745	2	paramString2	String
    //   0	745	3	paramInt1	int
    //   0	745	4	paramInt2	int
    //   0	745	5	paramInt3	int
    //   0	745	6	paramInt4	int
    //   59	573	7	f	float
    //   360	67	8	i	int
    //   344	284	9	j	int
    //   51	444	10	l	long
    //   470	200	12	bool	boolean
    //   90	557	13	localObject1	Object
    //   144	389	14	localObject2	Object
    //   140	207	15	localObject3	Object
    //   155	20	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   438	472	674	java/lang/Exception
    //   636	671	674	java/lang/Exception
    //   562	610	717	finally
    //   610	612	717	finally
    //   718	720	717	finally
  }
  
  public final String ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150580);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(150580);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth < 0) || (((BitmapFactory.Options)localObject).outHeight < 0))
    {
      Log.e("MicroMsg.ImgInfoStorage", "Bad thumbBuf, perhaps it's not complete or damaged ??");
      AppMethodBeat.o(150580);
      return null;
    }
    localObject = bcA();
    String str = o((String)localObject, "th_", "");
    Log.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(str)));
    s.deleteFile(str);
    s.f(str, paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(localObject));
    AppMethodBeat.o(150580);
    return paramArrayOfByte;
  }
  
  public final Bitmap b(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(150588);
    paramString = a(paramString, true, paramFloat, paramBoolean, true, false, 0);
    AppMethodBeat.o(150588);
    return paramString;
  }
  
  public final HashMap<Long, g> b(Long... paramVarArgs)
  {
    AppMethodBeat.i(150602);
    Object localObject1 = "(";
    int k = paramVarArgs.length;
    int i = 0;
    int j = 1;
    Object localObject2;
    if (i < k)
    {
      long l = paramVarArgs[i].longValue();
      localObject2 = new StringBuilder().append((String)localObject1);
      if (j != 0) {}
      for (localObject1 = Long.valueOf(l);; localObject1 = ",".concat(String.valueOf(l)))
      {
        localObject1 = localObject1;
        i += 1;
        j = 0;
        break;
      }
    }
    paramVarArgs = b("ImgInfo2", null, "msglocalid in ".concat(String.valueOf((String)localObject1 + ")")), null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new g();
      ((g)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((g)localObject2).dTS), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150602);
    return localObject1;
  }
  
  public final void bcy()
  {
    AppMethodBeat.i(150567);
    Iterator localIterator = d.iYu.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      Cursor localCursor = this.iFy.rawQuery("SELECT max(id) FROM " + localc.table, null, 2);
      AtomicLong localAtomicLong = localc.iYt;
      long l;
      if (localCursor.moveToFirst()) {
        l = localCursor.getLong(0);
      }
      try
      {
        if (l > localAtomicLong.get()) {
          localAtomicLong.set(l);
        }
        localCursor.close();
        Log.i("MicroMsg.ImgInfoStorage", "[updateLatestImgID] table=%s, loading new img id=%s", new Object[] { localc.table, Long.valueOf(localAtomicLong.get()) });
      }
      finally
      {
        AppMethodBeat.o(150567);
      }
    }
    AppMethodBeat.o(150567);
  }
  
  public final List<g> bcz()
  {
    AppMethodBeat.i(150598);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = d.iYu.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (c)localIterator.next();
      localObject = "select * " + " FROM " + ((c)localObject).table;
      localObject = (String)localObject + " WHERE iscomplete= 0 AND totalLen != 0 ";
      localObject = this.iFy.rawQuery((String)localObject, null);
      if (!((Cursor)localObject).moveToFirst()) {
        ((Cursor)localObject).close();
      } else {
        label228:
        for (;;)
        {
          g localg1 = new g();
          localg1.convertFrom((Cursor)localObject);
          g localg2 = tm((int)localg1.localId);
          if (localg2 != null) {
            if ((localg2.dTS != 0L) || (localg2.iXv != 0L)) {
              localArrayList.add(localg1);
            }
          }
          for (;;)
          {
            if (((Cursor)localObject).moveToNext()) {
              break label228;
            }
            ((Cursor)localObject).close();
            break;
            if ((localg1.dTS != 0L) || (localg1.iXv != 0L)) {
              localArrayList.add(localg1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(150598);
    return localArrayList;
  }
  
  public final Bitmap c(String paramString, float paramFloat)
  {
    AppMethodBeat.i(223585);
    paramString = a(paramString, paramFloat, true);
    AppMethodBeat.o(223585);
    return paramString;
  }
  
  public final g c(Long paramLong)
  {
    AppMethodBeat.i(150596);
    g localg = new g();
    paramLong = a(d.Ay(paramLong.longValue()), null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      localg.convertFrom(paramLong);
    }
    paramLong.close();
    AppMethodBeat.o(150596);
    return localg;
  }
  
  public final Bitmap d(String paramString, float paramFloat)
  {
    AppMethodBeat.i(150582);
    paramString = a(paramString, paramFloat, false);
    AppMethodBeat.o(150582);
    return paramString;
  }
  
  public final String d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150633);
    Object localObject;
    if ((paramString != null) && (this.iYd.containsKey(paramString)))
    {
      localObject = (String)this.iYd.get(paramString);
      AppMethodBeat.o(150633);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = R(paramString, paramBoolean2))
    {
      localObject = str;
      if (Util.isNullOrNil(str)) {
        break;
      }
      this.iYd.put(paramString, str);
      localObject = str;
      break;
    }
  }
  
  public final String getFullPath(String paramString)
  {
    AppMethodBeat.i(150572);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150572);
      return null;
    }
    if (paramString.startsWith("SERVERID://")) {}
    for (String str1 = paramString.substring(11);; str1 = "") {
      try
      {
        str1 = Ax(Long.valueOf(str1).longValue()).iXm;
        String str3 = com.tencent.mm.plugin.image.d.aSY();
        String str4 = com.tencent.mm.plugin.image.d.aSZ();
        String str2 = str1;
        if (Util.isNullOrNil(str1)) {
          str2 = paramString;
        }
        paramString = FilePathGenerator.defGenPathWithOld(str3, str4, "th_", str2, "", 1);
        AppMethodBeat.o(150572);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150572);
        return null;
      }
    }
  }
  
  public final Bitmap m(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(150629);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from";; str = "location_backgroup_key_tor")
    {
      Bitmap localBitmap2 = (Bitmap)this.iXW.aT(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BitmapUtil.createLocation(2131233533, 2131233886, paramInt1, paramInt2);
        this.iXW.x(str, localBitmap1);
      }
      AppMethodBeat.o(150629);
      return localBitmap1;
    }
  }
  
  public final String o(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150571);
    paramString1 = a(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(150571);
    return paramString1;
  }
  
  public final g tl(int paramInt)
  {
    AppMethodBeat.i(150603);
    g localg = c(Long.valueOf(paramInt));
    AppMethodBeat.o(150603);
    return localg;
  }
  
  /* Error */
  public final g tm(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1829
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: i2l
    //   8: lstore_2
    //   9: aload_0
    //   10: lload_2
    //   11: invokestatic 1172	com/tencent/mm/av/i$d:Ay	(J)Ljava/lang/String;
    //   14: aconst_null
    //   15: ldc_w 1831
    //   18: iconst_1
    //   19: anewarray 58	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 1073	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: aastore
    //   29: invokespecial 212	com/tencent/mm/av/i:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +170 -> 206
    //   39: aload 5
    //   41: astore 6
    //   43: aload 5
    //   45: invokeinterface 217 1 0
    //   50: ifeq +156 -> 206
    //   53: aload 5
    //   55: astore 6
    //   57: new 200	com/tencent/mm/av/g
    //   60: dup
    //   61: invokespecial 201	com/tencent/mm/av/g:<init>	()V
    //   64: astore 4
    //   66: aload 5
    //   68: astore 6
    //   70: aload 4
    //   72: aload 5
    //   74: invokevirtual 221	com/tencent/mm/av/g:convertFrom	(Landroid/database/Cursor;)V
    //   77: aload 4
    //   79: astore 6
    //   81: aload 5
    //   83: ifnull +14 -> 97
    //   86: aload 5
    //   88: invokeinterface 224 1 0
    //   93: aload 4
    //   95: astore 6
    //   97: ldc_w 1829
    //   100: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload 6
    //   105: areturn
    //   106: astore 7
    //   108: aconst_null
    //   109: astore 4
    //   111: aconst_null
    //   112: astore 5
    //   114: aload 5
    //   116: astore 6
    //   118: ldc_w 277
    //   121: ldc_w 1833
    //   124: iconst_1
    //   125: anewarray 105	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload 7
    //   132: invokevirtual 1756	java/lang/Exception:toString	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 1295	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload 4
    //   141: astore 6
    //   143: aload 5
    //   145: ifnull -48 -> 97
    //   148: aload 5
    //   150: invokeinterface 224 1 0
    //   155: aload 4
    //   157: astore 6
    //   159: goto -62 -> 97
    //   162: astore 4
    //   164: aconst_null
    //   165: astore 6
    //   167: aload 6
    //   169: ifnull +10 -> 179
    //   172: aload 6
    //   174: invokeinterface 224 1 0
    //   179: ldc_w 1829
    //   182: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload 4
    //   187: athrow
    //   188: astore 4
    //   190: goto -23 -> 167
    //   193: astore 7
    //   195: aconst_null
    //   196: astore 4
    //   198: goto -84 -> 114
    //   201: astore 7
    //   203: goto -89 -> 114
    //   206: aconst_null
    //   207: astore 4
    //   209: goto -132 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	i
    //   0	212	1	paramInt	int
    //   8	3	2	l	long
    //   64	92	4	localg	g
    //   162	24	4	localObject1	Object
    //   188	1	4	localObject2	Object
    //   196	12	4	localObject3	Object
    //   32	117	5	localCursor	Cursor
    //   41	132	6	localObject4	Object
    //   106	25	7	localException1	Exception
    //   193	1	7	localException2	Exception
    //   201	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   9	34	106	java/lang/Exception
    //   9	34	162	finally
    //   43	53	188	finally
    //   57	66	188	finally
    //   70	77	188	finally
    //   118	139	188	finally
    //   43	53	193	java/lang/Exception
    //   57	66	193	java/lang/Exception
    //   70	77	201	java/lang/Exception
  }
  
  static final class b
  {
    int iYn;
    int iYo;
    int iYp;
    String url;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      this.iYn = paramInt1;
      this.url = paramString;
      this.iYo = paramInt2;
      this.iYp = paramInt3;
    }
  }
  
  public static final class c
  {
    String iYq;
    String[] iYr;
    long[] iYs;
    AtomicLong iYt;
    String table;
    
    public c(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(223575);
      this.iYs = new long[2];
      this.iYt = new AtomicLong(0L);
      this.table = paramString2;
      this.iYq = paramString1;
      this.iYr = paramArrayOfString;
      this.iYs[0] = paramLong1;
      this.iYs[1] = paramLong2;
      this.iYt.set(paramLong1);
      AppMethodBeat.o(223575);
    }
  }
  
  public static final class d
  {
    public static final ArrayList<i.c> iYu;
    
    static
    {
      AppMethodBeat.i(223580);
      iYu = new ArrayList(3);
      a("", "ImgInfo2", i.SQL_CREATE, 1L, 1000000000L);
      a("@findermsg", "finder_img_info_table", i.Ox("finder_img_info_table"), 1000000001L, 1001000001L);
      a("@gamelifesess", "gamelife_img_info_table", i.Ox("gamelife_img_info_table"), 1001000002L, 1002000002L);
      AppMethodBeat.o(223580);
    }
    
    public static String Ay(long paramLong)
    {
      AppMethodBeat.i(223579);
      Object localObject = iYu.iterator();
      while (((Iterator)localObject).hasNext())
      {
        i.c localc = (i.c)((Iterator)localObject).next();
        if ((localc.iYs[0] <= paramLong) && (paramLong <= localc.iYs[1]))
        {
          localObject = localc.table;
          AppMethodBeat.o(223579);
          return localObject;
        }
      }
      Log.i("MicroMsg.ImgInfoStorage", "[getTableById] table=%s id=%s", new Object[] { ((i.c)iYu.get(0)).table, Long.valueOf(paramLong) });
      localObject = ((i.c)iYu.get(0)).table;
      AppMethodBeat.o(223579);
      return localObject;
    }
    
    public static AtomicLong OG(String paramString)
    {
      AppMethodBeat.i(223577);
      if (paramString == null)
      {
        Log.e("MicroMsg.ImgInfoStorage", "[getIdCreator] talker is null %s", new Object[] { Util.getStack() });
        paramString = ((i.c)iYu.get(0)).iYt;
        AppMethodBeat.o(223577);
        return paramString;
      }
      Iterator localIterator = iYu.iterator();
      while (localIterator.hasNext())
      {
        i.c localc = (i.c)localIterator.next();
        if ((!localc.iYq.isEmpty()) && (paramString.toLowerCase().endsWith(localc.iYq)))
        {
          Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { localc.table, paramString });
          paramString = localc.iYt;
          AppMethodBeat.o(223577);
          return paramString;
        }
      }
      Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { ((i.c)iYu.get(0)).table, paramString });
      paramString = ((i.c)iYu.get(0)).iYt;
      AppMethodBeat.o(223577);
      return paramString;
    }
    
    public static String OH(String paramString)
    {
      AppMethodBeat.i(223578);
      if (paramString == null)
      {
        Log.e("MicroMsg.ImgInfoStorage", "[getTableByTalker] talker is null %s", new Object[] { Util.getStack() });
        paramString = ((i.c)iYu.get(0)).table;
        AppMethodBeat.o(223578);
        return paramString;
      }
      Iterator localIterator = iYu.iterator();
      while (localIterator.hasNext())
      {
        i.c localc = (i.c)localIterator.next();
        if ((!localc.iYq.isEmpty()) && (paramString.toLowerCase().endsWith(localc.iYq)))
        {
          paramString = localc.table;
          AppMethodBeat.o(223578);
          return paramString;
        }
      }
      Log.i("MicroMsg.ImgInfoStorage", "[getTableByTalker] table=%s talker=%s", new Object[] { ((i.c)iYu.get(0)).table, paramString });
      paramString = ((i.c)iYu.get(0)).table;
      AppMethodBeat.o(223578);
      return paramString;
    }
    
    private static void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(223576);
      iYu.add(new i.c(paramString1.toLowerCase(), paramString2, paramArrayOfString, paramLong1, paramLong2));
      AppMethodBeat.o(223576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.i
 * JD-Core Version:    0.7.0.1
 */