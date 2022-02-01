package com.tencent.mm.ay;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
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
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.et;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.comm.c.c;
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
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.v;
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
  public static int lOA = 150;
  public static long lOB = 0L;
  public static int lOp = 0;
  private MMHandler knk;
  com.tencent.mm.b.f<String, Bitmap> lOq;
  private com.tencent.mm.b.f<String, String> lOr;
  private List<b> lOs;
  private Map<Integer, WeakReference<ImageView>> lOt;
  private Map<Integer, WeakReference<ImageView>> lOu;
  private Map<Integer, WeakReference<View>> lOv;
  private Set<Integer> lOw;
  private Map<String, String> lOx;
  private FrameLayout.LayoutParams lOy;
  private SoftReference<ColorDrawable> lOz;
  public com.tencent.mm.storagebase.h lvy;
  
  public i(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150566);
    this.lOq = new com.tencent.mm.memory.a.b(40, new f.b() {}, getClass());
    this.lOr = new com.tencent.mm.memory.a.c(40);
    this.lOs = new ArrayList();
    this.lOt = new HashMap();
    this.lOu = new HashMap();
    this.lOv = new HashMap();
    this.lOw = new HashSet();
    this.knk = new MMHandler(Looper.getMainLooper());
    this.lOx = new HashMap();
    this.lvy = null;
    this.lOy = new FrameLayout.LayoutParams(-2, -2);
    Iterator localIterator = d.lOO.iterator();
    while (localIterator.hasNext()) {
      a(paramh, ((c)localIterator.next()).table);
    }
    this.lvy = paramh;
    blO();
    AppMethodBeat.o(150566);
  }
  
  private g GF(long paramLong)
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
  
  public static String LQ(String paramString)
  {
    AppMethodBeat.i(150573);
    paramString = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString));
    AppMethodBeat.o(150573);
    return paramString;
  }
  
  public static String[] VU(String paramString)
  {
    AppMethodBeat.i(212911);
    String str1 = "CREATE TABLE IF NOT EXISTS " + paramString + " ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen" + " INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid" + " INT, status INT, nettimes INT, reserved1 int  , reserved2" + " int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete" + " INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType" + " INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )";
    String str2 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoIndex ON " + paramString + " ( msgSvrId ) ";
    String str3 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoHdIndex ON " + paramString + " ( reserved1 ) ";
    String str4 = "CREATE INDEX IF NOT EXISTS " + paramString + "msgLocalIdIndex ON " + paramString + " ( msglocalid ) ";
    String str5 = "CREATE INDEX IF NOT EXISTS " + paramString + "iscomplete_index ON " + paramString + " ( iscomplete ) ";
    paramString = "CREATE INDEX IF NOT EXISTS " + paramString + "origImgMD5_index ON " + paramString + " ( origImgMD5 ) ";
    AppMethodBeat.o(212911);
    return new String[] { str1, str2, str3, str4, str5, paramString };
  }
  
  public static long VV(String paramString)
  {
    AppMethodBeat.i(212922);
    long l = d.We(paramString).incrementAndGet();
    AppMethodBeat.o(212922);
    return l;
  }
  
  private static String VX(String paramString)
  {
    AppMethodBeat.i(212951);
    paramString = "THUMBNAIL_APPMSG_DIR://msgth_".concat(String.valueOf(paramString));
    AppMethodBeat.o(212951);
    return paramString;
  }
  
  /* Error */
  private static String Wc(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 308
    //   6: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: getstatic 87	com/tencent/mm/ay/i:lOB	J
    //   16: lstore 5
    //   18: lload_3
    //   19: lstore_1
    //   20: lload 5
    //   22: lload_3
    //   23: lcmp
    //   24: ifne +11 -> 35
    //   27: lconst_1
    //   28: invokestatic 319	java/lang/Thread:sleep	(J)V
    //   31: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   34: lstore_1
    //   35: lload_1
    //   36: putstatic 87	com/tencent/mm/ay/i:lOB	J
    //   39: new 240	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: lload_1
    //   51: invokevirtual 323	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokevirtual 327	java/lang/String:getBytes	()[B
    //   60: invokestatic 333	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   63: astore_0
    //   64: ldc_w 335
    //   67: ldc_w 337
    //   70: iconst_2
    //   71: anewarray 106	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: lload_1
    //   81: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: aastore
    //   85: invokestatic 347	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: ldc_w 308
    //   91: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: ldc 2
    //   96: monitorexit
    //   97: aload_0
    //   98: areturn
    //   99: astore 7
    //   101: goto -70 -> 31
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramString	String
    //   19	62	1	l1	long
    //   12	11	3	l2	long
    //   16	5	5	l3	long
    //   99	1	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   27	31	99	java/lang/InterruptedException
    //   3	18	104	finally
    //   27	31	104	finally
    //   31	35	104	finally
    //   35	94	104	finally
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString4, String paramString5, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(213025);
    if (paramInt1 == 0)
    {
      paramString2 = a(paramString1, paramString2, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString2 == null)
      {
        AppMethodBeat.o(213025);
        return -1L;
      }
      paramPString.value = paramString2.lNJ;
      if (com.tencent.mm.vfs.u.agG(paramString3))
      {
        paramPString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).atR(paramString2.lNH);
        com.tencent.mm.vfs.u.on(paramString3, r(paramPString, "", ""));
        paramString2.VR(paramPString);
      }
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(213025);
        return paramLong;
      }
    }
    if (paramInt1 == 1)
    {
      paramString3 = a(paramString1, paramString2, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString3 == null)
      {
        AppMethodBeat.o(213025);
        return -1L;
      }
      paramPString.value = paramString3.lNJ;
      paramString3.GE(0L);
      paramString3.EG(0L);
      paramString3.wf((int)com.tencent.mm.vfs.u.bBQ(r(paramString3.lNH, "", "")));
      paramString2 = a(paramString1, paramString2, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString2 == null)
      {
        AppMethodBeat.o(213025);
        return 0L;
      }
      paramString2.VN(paramString3.lNH);
      paramString2.VP(paramString3.lNJ);
      paramString2.VO(paramString3.lNI);
      paramString2.wf(0);
      long l = this.lvy.beginTransaction(Thread.currentThread().getId());
      paramString2.wg((int)a(paramString1, "id", paramString3));
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        Log.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramString2.localId), Long.valueOf(paramString2.lNP), paramString2.lNH, paramString2.lNI, Integer.valueOf(paramString2.lAW) });
        if (l > 0L) {
          com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
        }
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(213025);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(213025);
    return 0L;
  }
  
  private Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString3, com.tencent.mm.b.b paramb, int paramInt3)
  {
    AppMethodBeat.i(213034);
    Log.i("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap talker[%s] origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Util.getStack(), paramString3 });
    Bitmap localBitmap2 = (Bitmap)this.lOq.aX(h.VT(paramString2));
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
      str1 = n(paramString1, paramString2, paramInt1);
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
        this.lOq.q(h.VT(paramString2), localBitmap1);
        paramPInt1.value = localBitmap1.getWidth();
        paramPInt2.value = localBitmap1.getHeight();
        if (paramBoolean)
        {
          paramPInt1 = str1;
          if (str1 == null) {
            paramPInt1 = n(paramString1, paramString2, paramInt1);
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
            paramb.YJ();
          }
          if ((Util.isNullOrNil(paramString1)) || (!com.tencent.mm.vfs.u.agG(paramString1)) || (com.tencent.mm.vfs.u.bBQ(paramString1) <= 0L)) {
            break label389;
          }
          com.tencent.mm.vfs.u.on(paramString1, paramString3);
          Log.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s %s", new Object[] { paramString1, paramString3 });
        }
      }
      AppMethodBeat.o(213034);
      return localBitmap1;
      localBitmap1 = BitmapUtil.getBitmapNative(str1);
      str2 = paramString2;
      break;
    }
    label389:
    if ((!Util.isNullOrNil(paramString1)) && (com.tencent.mm.vfs.u.agG(paramString1))) {
      Log.i("MicroMsg.ImgInfoStorage", "oldThumbFile Length %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.u.bBQ(paramString1)) });
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
        paramString = (Bitmap)this.lOq.aX(str2);
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
          paramString = com.tencent.mm.platformtools.u.ZS(str2);
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
          if (lOp == 0) {
            lOp = com.tencent.mm.ci.a.aZ(MMApplicationContext.getContext(), c.c.emoji_view_image_size);
          }
          if (m <= lOp)
          {
            i = n;
            j = m;
            if (n <= lOp) {}
          }
          else
          {
            if (m <= n) {
              break label714;
            }
            i = n * lOp / m;
            j = lOp;
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
                  this.lOq.q(str2, paramString);
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
                i = lOp;
                j = lOp;
                break label259;
              }
              j = m * lOp / n;
              i = lOp;
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
              paramString = BitmapUtil.getRoundedCornerBitmap(paramBitmap, true, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 3));
              Log.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
              continue;
            }
            paramString = paramBitmap;
            continue;
            paramBitmap = paramString.toString();
            continue;
          }
          Log.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", new Object[] { str2, Boolean.valueOf(com.tencent.mm.vfs.u.agG(str2)) });
          str3 = str1;
        }
      }
    }
  }
  
  private g a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString3, long paramLong, String paramString4, String paramString5, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama, int paramInt4)
  {
    AppMethodBeat.i(213062);
    if (!com.tencent.mm.vfs.u.agG(paramString2))
    {
      AppMethodBeat.o(213062);
      return null;
    }
    String str = h.VT(paramString2);
    paramb1 = a(paramString1, paramString2, paramInt1, paramBoolean, paramInt3, paramPInt1, paramPInt2, paramString3, paramString4, paramb1, paramInt4);
    if ((parama != null) && (parama.lNK == paramInt1))
    {
      paramString5 = parama.blY();
      paramPInt2 = paramString5.lQk;
      paramString3 = paramString5.lQl;
      paramPInt1 = paramString5.lNS;
      paramString4 = paramString5.lQm;
      paramString5 = paramString5.lQn;
      Log.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramString5.value });
      paramString5 = new g();
      paramString5.cUP = -1;
      paramString5.setLocalId(d.We(paramString1).incrementAndGet());
      paramString5.GE(paramLong);
      if (!Util.isNullOrNil(paramPInt1)) {
        paramString5.VQ(paramPInt1);
      }
      paramString5.wj(0);
      paramString5.setSource(paramInt2);
      if (paramInt2 != 4) {
        break label580;
      }
      if (paramString2.startsWith(ap.bca()))
      {
        paramString5.wh(3);
        label240:
        if (paramBoolean)
        {
          paramString5.VN(paramPInt2.value + ".jpg");
          if (!Util.isNullOrNil(paramString4.value)) {
            paramString5.VO(paramString4.value + ".jpg");
          }
          if (Util.isNullOrNil(paramString5.lNJ)) {
            paramString5.VP(paramb1);
          }
          paramString5.wf((int)com.tencent.mm.vfs.u.bBQ(paramString3.value));
          if (paramString5.lAW == 0) {
            Log.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString3.value });
          }
          paramString5.VM(str);
        }
        paramString5.setCreateTime((int)Util.nowSecond());
        paramString5.wk(paramInt1);
        Log.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramString5.lAW);
        AppMethodBeat.o(213062);
        return paramString5;
      }
    }
    else
    {
      if ((parama == null) || (parama.lNK == paramInt1)) {
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
      paramString5.wh(2);
      break label240;
      label580:
      paramString5.wh(1);
      break label240;
      label589:
      paramPInt2 = paramb2;
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, com.tencent.mm.b.b paramb, int paramInt3)
  {
    AppMethodBeat.i(213044);
    Log.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString2 });
    if (!com.tencent.mm.vfs.u.agG(paramString2))
    {
      Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(213044);
      return null;
    }
    String str = paramString4;
    if (Util.isNullOrNil(paramString4)) {
      str = blQ();
    }
    str = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
    paramString4 = a(str, "th_", "", false);
    if (paramb == null) {
      paramString4 = r(str, "th_", "");
    }
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(paramString3)) && (com.tencent.mm.vfs.u.agG(paramString3))) {
        break label264;
      }
      long l = Util.currentTicks();
      a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, true, paramString4, paramb, paramInt3);
      if (!com.tencent.mm.vfs.u.agG(paramString4)) {
        break label252;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(10921, new Object[] { Long.valueOf(com.tencent.mm.vfs.u.bBQ(paramString4)), Long.valueOf(com.tencent.mm.vfs.u.bBQ(paramString2)), Integer.valueOf(90), Long.valueOf(Util.ticksToNow(l)) });
    }
    for (;;)
    {
      Log.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
      AppMethodBeat.o(213044);
      return str;
      label252:
      Log.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
      continue;
      label264:
      com.tencent.mm.vfs.u.on(paramString3, paramString4);
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(212975);
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.lOs.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (m == localb.lOH)
      {
        Log.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.lOH), localb.url });
        localb.url = paramString;
        if (!this.lOw.contains(Integer.valueOf(k)))
        {
          this.lOw.add(Integer.valueOf(k));
          a(paramString, paramFloat, true, paramInt);
        }
        AppMethodBeat.o(212975);
        return;
      }
    }
    this.lOt.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i = 0;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.lOu.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    int j = 0;
    if (paramView != null)
    {
      j = paramView.hashCode();
      this.lOv.put(Integer.valueOf(j), new WeakReference(paramView));
    }
    paramImageView1 = new b(m, paramString, i, j);
    this.lOs.add(paramImageView1);
    if (!this.lOw.contains(Integer.valueOf(k)))
    {
      this.lOw.add(Integer.valueOf(k));
      a(paramString, paramFloat, true, paramInt);
    }
    AppMethodBeat.o(212975);
  }
  
  private static void a(com.tencent.mm.storagebase.h paramh, String paramString)
  {
    AppMethodBeat.i(212927);
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
      long l = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
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
        com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
      }
      AppMethodBeat.o(212927);
      return;
    }
  }
  
  private void a(final String paramString, final float paramFloat, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(212979);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
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
            i.a(i.this, i.2.this.lOD);
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
    AppMethodBeat.o(212979);
  }
  
  public static String ac(ca paramca)
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
      localObject2 = q.bmh().D(paramca.field_talker, paramca.field_msgId);
      localObject1 = localObject2;
      if (((g)localObject2).localId != 0L) {}
    }
    else
    {
      localObject1 = q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
    }
    if (com.tencent.mm.kernel.h.aHG().isSDCardAvailable()) {
      if (paramca.field_isSend == 1)
      {
        paramca = h.c((g)localObject1);
        localObject2 = q.bmh().r(paramca, "", "");
        if ((paramca != null) && (paramca.length() > 0) && (com.tencent.mm.vfs.u.agG((String)localObject2)))
        {
          AppMethodBeat.o(150635);
          return localObject2;
        }
        paramca = ((g)localObject1).lNH;
        localObject1 = q.bmh().r(paramca, "", "");
        if ((paramca != null) && (paramca.length() > 0) && (com.tencent.mm.vfs.u.agG((String)localObject1)))
        {
          AppMethodBeat.o(150635);
          return localObject1;
        }
      }
      else if (((g)localObject1).blJ())
      {
        paramca = ((g)localObject1).lNH;
        if (!((g)localObject1).blK()) {
          break label314;
        }
        localObject1 = h.a((g)localObject1);
        if ((localObject1 == null) || (((g)localObject1).localId <= 0L) || (!((g)localObject1).blJ()) || (!com.tencent.mm.vfs.u.agG(q.bmh().r(((g)localObject1).lNH, "", "")))) {
          break label314;
        }
        paramca = ((g)localObject1).lNH;
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
  
  private long b(String paramString, g paramg)
  {
    AppMethodBeat.i(213029);
    paramString = d.Wf(paramString);
    long l = this.lvy.hBZ().insertOrThrow(paramString, "id", paramg.convertTo());
    if (l != -1L) {
      paramg.blN();
    }
    Log.i("MicroMsg.ImgInfoStorage", "insert img, table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString, Long.valueOf(l), Long.valueOf(paramg.localId), Long.valueOf(paramg.lNP), Long.valueOf(paramg.fNu), Integer.valueOf(paramg.lNR) });
    AppMethodBeat.o(213029);
    return l;
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150608);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
    AppMethodBeat.o(150608);
    return paramString1;
  }
  
  public static String blQ()
  {
    try
    {
      AppMethodBeat.i(150620);
      String str = Wc("");
      AppMethodBeat.o(150620);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private g m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(212998);
    g localg = new g();
    paramString1 = a(d.Wf(paramString1), null, "origImgMD5=? AND compressType=?", new String[] { String.valueOf(paramString2), String.valueOf(paramInt) });
    if (paramString1.moveToFirst()) {
      localg.convertFrom(paramString1);
    }
    paramString1.close();
    AppMethodBeat.o(212998);
    return localg;
  }
  
  private String n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(213031);
    paramString1 = m(paramString1, h.VT(paramString2), paramInt);
    if (!Util.isNullOrNil(paramString1.lNJ))
    {
      paramString1 = T(paramString1.lNJ, true);
      if (com.tencent.mm.vfs.u.agG(paramString1))
      {
        AppMethodBeat.o(213031);
        return paramString1;
      }
    }
    AppMethodBeat.o(213031);
    return null;
  }
  
  public final g C(String paramString, long paramLong)
  {
    AppMethodBeat.i(213010);
    g localg = new g();
    paramString = b(d.Wf(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToFirst()) {
      localg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(213010);
    return localg;
  }
  
  public final g D(String paramString, long paramLong)
  {
    AppMethodBeat.i(213012);
    g localg = new g();
    paramString = b(d.Wf(paramString), null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToLast()) {
      localg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(213012);
    return localg;
  }
  
  public final String T(String paramString, boolean paramBoolean)
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
        paramString = wl(Integer.valueOf(paramString).intValue()).lNJ;
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
  
  public final String VW(String paramString)
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
        paramString = wl(Integer.valueOf(paramString).intValue()).lNJ;
        paramString = r(paramString, str1, "");
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
  
  public final String VY(String paramString)
  {
    AppMethodBeat.i(212956);
    paramString = T(paramString, true);
    AppMethodBeat.o(212956);
    return paramString;
  }
  
  public final Bitmap VZ(String paramString)
  {
    AppMethodBeat.i(150592);
    float f = com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext());
    paramString = BitmapUtil.getBitmapNative(d(paramString, false, true), f);
    AppMethodBeat.o(150592);
    return paramString;
  }
  
  public final String Wa(String paramString)
  {
    AppMethodBeat.i(150615);
    paramString = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString)), "th_", "", false);
    AppMethodBeat.o(150615);
    return paramString;
  }
  
  public final String Wb(String paramString)
  {
    AppMethodBeat.i(150616);
    paramString = a(paramString, "", ".jpg", false);
    AppMethodBeat.o(150616);
    return paramString;
  }
  
  public final String Wd(String paramString)
  {
    AppMethodBeat.i(292892);
    paramString = d(paramString, false, true);
    AppMethodBeat.o(292892);
    return paramString;
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
    for (int i = 1;; i = this.lvy.update(d.GG(paramLong.longValue()), localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      Log.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString(), Integer.valueOf(i) });
      if (i != -1)
      {
        paramg.blN();
        doNotify();
      }
      AppMethodBeat.o(150628);
      return i;
    }
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama, int paramInt4)
  {
    AppMethodBeat.i(213021);
    paramLong = a(paramString1, paramString2, null, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, paramString3, paramString4, paramLong, paramb1, paramb2, parama, false, paramInt4);
    AppMethodBeat.o(213021);
    return paramLong;
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(213020);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, 0, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, 0);
    AppMethodBeat.o(213020);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(213027);
    paramString1 = d.Wf(paramString1);
    long l = this.lvy.insert(paramString1, paramString2, paramg.convertTo());
    if (l != -1L) {
      paramg.blN();
    }
    Log.i("MicroMsg.ImgInfoStorage", "insert img,table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString1, Long.valueOf(l), Long.valueOf(paramg.localId), Long.valueOf(paramg.lNP), Long.valueOf(paramg.fNu), Integer.valueOf(paramg.lNR) });
    AppMethodBeat.o(213027);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(213019);
    long l = a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, true, 0);
    AppMethodBeat.o(213019);
    return l;
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, int paramInt, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(213068);
    String str1 = "SERVERID://".concat(String.valueOf(paramLong));
    String str2 = com.tencent.mm.b.g.getMessageDigest(str1.getBytes());
    String str3 = r(str2, "th_", "");
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
        paramArrayOfByte.we(paramInt);
        paramArrayOfByte.wf(paramInt);
        paramArrayOfByte.cUP = -1;
        paramArrayOfByte.setLocalId(d.We(paramString1).incrementAndGet());
        paramArrayOfByte.VN(paramString2);
        paramArrayOfByte.VP("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2)));
        paramPString.value = paramArrayOfByte.lNJ;
        if (paramBoolean)
        {
          paramArrayOfByte.EG(0L);
          paramArrayOfByte.wk(1);
          paramArrayOfByte.VQ(paramString3);
          paramArrayOfByte.setCreateTime((int)Util.nowSecond());
          paramLong = a(paramString1, "id", paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          AppMethodBeat.o(213068);
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
        paramArrayOfByte.EG(paramLong);
        paramArrayOfByte.wk(0);
        continue;
        paramString2 = str1;
      }
    }
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(213063);
    paramLong = a(paramString1, paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString2, paramPString, paramPInt1, paramPInt2);
    AppMethodBeat.o(213063);
    return paramLong;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150607);
    paramString1 = this.lvy.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    AppMethodBeat.o(150607);
    return paramString1;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150630);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from".concat(String.valueOf(paramLong));; str = "location_backgroup_key_tor".concat(String.valueOf(paramLong)))
    {
      Bitmap localBitmap2 = (Bitmap)this.lOq.aX(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BitmapUtil.createLocation(paramString, paramInt1, paramInt2, paramInt3);
        this.lOq.q(str, localBitmap1);
      }
      AppMethodBeat.o(150630);
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(212990);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(212990);
      return null;
    }
    String str = paramString.trim();
    paramString = (Bitmap)this.lOq.aX(str);
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
      j = Math.round(lOA * paramFloat);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label305;
      }
      Log.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 188L, 1L, false);
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
      this.lOq.q(str, localObject);
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(212990);
        return localObject;
        label277:
        i = Math.round(lOA * paramFloat);
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
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 188L, 1L, false);
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
    AppMethodBeat.i(213005);
    if (paramg == null)
    {
      AppMethodBeat.o(213005);
      return null;
    }
    if (paramg.blK())
    {
      paramString = d.Wf(paramString);
      paramg = paramg.lNR;
      paramg = b(paramString, new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { paramg });
      paramString = localObject;
      if (paramg.moveToFirst()) {
        paramString = paramg.getString(0);
      }
      paramg.close();
      AppMethodBeat.o(213005);
      return paramString;
    }
    AppMethodBeat.o(213005);
    return null;
  }
  
  public final String a(String paramString1, String paramString2, int paramInt1, PString paramPString, PInt paramPInt1, PInt paramPInt2, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(213038);
    if (!com.tencent.mm.vfs.u.agG(paramString2))
    {
      Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(213038);
      return null;
    }
    String str1 = paramString3;
    if (Util.isNullOrNil(paramString3)) {
      str1 = blQ();
    }
    String str2 = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
    paramString3 = a(str2, "th_", "", false);
    paramPString.value = str2;
    long l = Util.currentTicks();
    paramPInt1 = a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, false, null, null, -1);
    paramString1 = (String)this.lOr.get(paramString2);
    if (paramString1 != null) {}
    for (paramString1 = (Bitmap)this.lOq.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramPString = paramString1;
        if (!paramString1.isRecycled()) {}
      }
      else
      {
        paramPString = a(paramString2, true, com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext()), false, false, true, paramInt3, true, paramPInt1);
        this.lOr.put(paramString2, paramString3);
      }
      if (paramPString != null) {
        this.lOq.q(paramString3, paramPString);
      }
      Log.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(213038);
      return str1;
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString4, com.tencent.mm.b.b paramb, int paramInt2)
  {
    AppMethodBeat.i(213058);
    String str = paramString4;
    if (Util.isNullOrNil(paramString4))
    {
      str = Wc(paramString2);
      Log.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", new Object[] { str, paramString2 });
    }
    paramString4 = a(str, "", ".jpg", false);
    if (paramb == null) {
      paramString4 = a(str, "", ".jpg", true);
    }
    Log.i("MicroMsg.ImgInfoStorage", "fullPath is %s", new Object[] { paramString4 });
    if (com.tencent.mm.vfs.u.bBQ(paramString4) > 0L)
    {
      Log.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
      com.tencent.mm.plugin.report.service.h.IzE.el(944, 8);
    }
    paramPString1.value = str;
    paramPString2.value = paramString4;
    if ((paramBoolean) && (!Util.isNullOrNil(paramString3)) && (paramInt1 == 0))
    {
      paramString1 = m(paramString1, paramString3, paramInt1);
      if (!Util.isNullOrNil(paramString1.lNH))
      {
        paramString3 = r(paramString1.lNH, "", "");
        if (paramb != null) {
          paramb.YJ();
        }
        com.tencent.mm.vfs.u.on(paramString3, paramString4);
        if (com.tencent.mm.vfs.u.bBQ(paramString3) > 0L)
        {
          if (!Util.isNullOrNil(paramString1.lNS))
          {
            paramString1 = paramString1.lNS;
            AppMethodBeat.o(213058);
            return paramString1;
          }
          AppMethodBeat.o(213058);
          return null;
        }
        Log.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString2, paramString4 });
      }
    }
    label1164:
    label1223:
    label1229:
    label3407:
    label3536:
    label3539:
    try
    {
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        Log.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3553;
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
          paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressResolutionForWifi");
          i = j;
          i1 = paramString1.indexOf("*");
          if (-1 == i1) {
            break label3545;
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
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.h.aHE();
          paramString1 = new p(com.tencent.mm.kernel.b.getUin());
          if ((int)(paramString1.longValue() / 100L) % 100 + 1 > i) {
            break label3539;
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
            break label3526;
          }
          double d = Math.sqrt(i * k / 10240000.0D);
          j = (int)(i / d);
          k = (int)(k / d);
          Log.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[] { Integer.valueOf(paramString3.outHeight), Integer.valueOf(paramString3.outWidth), Integer.valueOf(j), Integer.valueOf(k) });
          if (paramString3 == null) {
            break label1941;
          }
          paramString1 = paramString3.outMimeType;
          long l2 = com.tencent.mm.vfs.u.bBQ(paramString2);
          boolean bool3 = MMNativeJpeg.IsJpegFile(paramString2);
          if ((paramString1 == null) || ((!paramString1.endsWith("jpeg")) && (!paramString1.endsWith("jpg")) && (!paramString1.endsWith("bmp")) && (!paramString1.endsWith("png")) && (!paramString1.endsWith("gif")))) {
            break label1948;
          }
          i2 = 1;
          if ((paramInt1 != 0) || ((i1 == 0) && (l2 <= 204800L) && ((paramString3 == null) || (i3 <= 0))) || (l2 <= i7)) {
            break label1961;
          }
          if ((i4 >= 55) && (bool3)) {
            break label3519;
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
              break label3508;
            }
            i = 28;
            paramInt2 = BitmapUtil.createThumbNailMayUseOpt(false, paramString2, j, k, Bitmap.CompressFormat.JPEG, n, paramString4, paramb, paramInt2);
            paramBoolean = false;
            k = i;
            l3 = com.tencent.mm.vfs.u.bBQ(paramString4);
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
                v.ot(paramString2, paramString4);
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
            com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 187L, 1L, false);
            Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString2 });
            AppMethodBeat.o(213058);
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
            break label3503;
          }
          paramString1 = ScopedStorageUtil.MediaStoreOps.imagePathToUri(MMApplicationContext.getContext(), paramString2);
          if (paramString1 == null) {
            break label3503;
          }
          paramString1 = paramString1.toString();
          v.ot(paramString1, paramString4);
          com.tencent.mm.aq.f.bkg();
          if (!com.tencent.mm.aq.b.vQ(256)) {
            break label3407;
          }
          if (paramInt1 != 1) {
            break label3416;
          }
          i = 0;
          for (;;)
          {
            for (;;)
            {
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressMidPicLevel")).intValue();
                i = m;
              }
              catch (Exception paramString1)
              {
                continue;
              }
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressMidPicSize")).intValue();
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
                  break label3496;
                }
                i = 800;
                if (k <= i) {
                  break label3493;
                }
                k = i;
                if (j <= i) {
                  break label3490;
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
                  paramPString3.value = Wc(paramString2);
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
                  l3 = com.tencent.mm.vfs.u.bBQ(paramString4);
                  i1 = MMNativeJpeg.queryQuality(paramString4);
                  boolean bool4 = MMNativeJpeg.IsJpegFile(paramString4);
                  paramString1 = com.tencent.mm.plugin.report.service.h.IzE;
                  if (!bool3) {
                    continue;
                  }
                  m = 1;
                  paramString1.a(11713, new Object[] { Integer.valueOf(paramInt2), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(m), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt1), Long.valueOf(l3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i4), Integer.valueOf(i1) });
                  Log.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Long.valueOf(l3), Boolean.valueOf(bool4), paramString2, paramString4 });
                  if ((paramInt1 == 0) && (l3 >= 40960L) && (bool4) && (!MMNativeJpeg.isProgressive(paramString4)))
                  {
                    paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("EnableCDNUploadImg");
                    if ((!Util.isNullOrNil(paramString1)) && (paramString1.equals("1")))
                    {
                      l1 = Util.nowMilliSecond();
                      if (!paramBoolean) {
                        continue;
                      }
                      i = 19;
                      paramString1 = paramString4 + ".prog";
                      com.tencent.mm.vfs.u.on(paramString4, paramString1);
                      boolean bool2 = ImageOptimLib.convertToProgressive(paramString1, paramString4, n);
                      com.tencent.mm.vfs.u.deleteFile(paramString1);
                      bool1 = bool2;
                      if (!bool2)
                      {
                        i = 29;
                        bool1 = MMNativeJpeg.convertToProgressive(paramString4, n);
                      }
                      long l4 = Util.nowMilliSecond();
                      long l5 = com.tencent.mm.vfs.u.bBQ(paramString4);
                      paramString1 = com.tencent.mm.plugin.report.service.h.IzE;
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
                        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 186L, 1L, false);
                        Log.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString4 });
                      }
                    }
                  }
                  AppMethodBeat.o(213058);
                  return null;
                  if (BitmapUtil.convertImageFile(new com.tencent.mm.vfs.q(paramString2), new com.tencent.mm.vfs.q(paramString4), Bitmap.CompressFormat.JPEG)) {
                    break;
                  }
                  com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(111L, 187L, 1L, false);
                  Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString2 });
                  AppMethodBeat.o(213058);
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
        if (!com.tencent.mm.compatible.util.d.qW(16)) {
          break label3536;
        }
        bool1 = false;
        Log.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        if ((m > 0) || (k > 0)) {
          break label1164;
        }
        j = 0;
        i = 1080;
        m = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        k = m;
        if (m <= 0) {
          k = 100;
        }
        i7 = k * 1024;
        m = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((m > 0) && (m < 100)) {
          break label3533;
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
        AppMethodBeat.o(213058);
        return null;
        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressPicLevelFor2G"), 40);
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception paramString1)
    {
      label3416:
      label3545:
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
        label3553:
        if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
        {
          i = j;
          paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          label1508:
          label1895:
          if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
          {
            i = j;
            paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressResolutionFor3G");
          }
          else
          {
            i = j;
            paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue("CompressResolutionFor4G");
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
        String str2;
        try
        {
          str1 = GF(Long.valueOf(str1).longValue()).lNH;
          str2 = com.tencent.mm.plugin.image.d.bbX();
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = str2;
            if (paramString2 != null)
            {
              str3 = str2;
              if (paramString2.equals("msgth_")) {
                str3 = com.tencent.mm.plugin.ab.a.fmu();
              }
            }
            String str4 = com.tencent.mm.plugin.image.d.bbW();
            str2 = str1;
            if (Util.isNullOrNil(str1)) {
              str2 = paramString1;
            }
            paramString1 = FilePathGenerator.defGenPathWithOld(str4, str3, paramString2, str2, paramString3, 1, paramBoolean);
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
        if (paramString1.startsWith("THUMBNAIL_APPMSG_DIR://"))
        {
          paramString1 = paramString1.substring(29);
          paramString2 = "msgth_";
          str2 = com.tencent.mm.plugin.ab.a.fmu();
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
    String str1 = blQ();
    String str2 = r(str1, "th_", "");
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
    //   0: ldc_w 1573
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1557	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 335
    //   16: ldc_w 1559
    //   19: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1573
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 789	com/tencent/mm/ay/i:blQ	()Ljava/lang/String;
    //   38: astore 16
    //   40: aload_0
    //   41: aload 16
    //   43: ldc_w 791
    //   46: ldc_w 384
    //   49: invokevirtual 388	com/tencent/mm/ay/i:r	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 17
    //   54: new 240	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   61: aload 17
    //   63: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1575
    //   69: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 15
    //   77: ldc_w 335
    //   80: ldc_w 1577
    //   83: aload 17
    //   85: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1369	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1578	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1582	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1585	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aconst_null
    //   124: astore 13
    //   126: aload 15
    //   128: invokestatic 1589	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   131: astore 12
    //   133: aload 12
    //   135: astore 13
    //   137: aload 12
    //   139: aload_1
    //   140: invokevirtual 1594	java/io/OutputStream:write	([B)V
    //   143: aload 12
    //   145: astore 13
    //   147: aload 12
    //   149: invokevirtual 1597	java/io/OutputStream:flush	()V
    //   152: aload 12
    //   154: astore 13
    //   156: aload_1
    //   157: iload_3
    //   158: iload 4
    //   160: invokestatic 1598	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   163: astore 19
    //   165: aload 12
    //   167: astore 13
    //   169: aload_1
    //   170: arraylength
    //   171: istore 8
    //   173: aload 19
    //   175: ifnull +321 -> 496
    //   178: bipush 100
    //   180: istore 7
    //   182: aload 12
    //   184: astore 13
    //   186: aload_1
    //   187: arraylength
    //   188: istore_3
    //   189: iload_3
    //   190: ldc_w 1599
    //   193: if_icmple +534 -> 727
    //   196: new 1601	java/io/ByteArrayOutputStream
    //   199: dup
    //   200: invokespecial 1602	java/io/ByteArrayOutputStream:<init>	()V
    //   203: astore 14
    //   205: aload 14
    //   207: astore 13
    //   209: aload 19
    //   211: aload_2
    //   212: bipush 100
    //   214: aload 14
    //   216: invokevirtual 1606	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   219: pop
    //   220: aload 14
    //   222: astore 13
    //   224: aload 14
    //   226: invokevirtual 1609	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   229: arraylength
    //   230: istore 4
    //   232: bipush 100
    //   234: istore_3
    //   235: aload 14
    //   237: astore 13
    //   239: iload_3
    //   240: istore 7
    //   242: aload 14
    //   244: invokevirtual 1609	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   247: arraylength
    //   248: ldc_w 1599
    //   251: if_icmple +64 -> 315
    //   254: iload_3
    //   255: bipush 15
    //   257: if_icmplt +58 -> 315
    //   260: aload 14
    //   262: astore 13
    //   264: iload_3
    //   265: istore 7
    //   267: aload 14
    //   269: invokevirtual 1612	java/io/ByteArrayOutputStream:reset	()V
    //   272: iload_3
    //   273: iconst_5
    //   274: isub
    //   275: istore_3
    //   276: aload 14
    //   278: astore 13
    //   280: iload_3
    //   281: istore 7
    //   283: aload 19
    //   285: aload_2
    //   286: iload_3
    //   287: aload 14
    //   289: invokevirtual 1606	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   292: pop
    //   293: aload 14
    //   295: astore 13
    //   297: iload_3
    //   298: istore 7
    //   300: aload 14
    //   302: invokevirtual 1609	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   305: arraylength
    //   306: istore 8
    //   308: iload 8
    //   310: istore 4
    //   312: goto -77 -> 235
    //   315: aload 12
    //   317: astore 13
    //   319: aload 14
    //   321: invokevirtual 1613	java/io/ByteArrayOutputStream:close	()V
    //   324: aload 12
    //   326: astore 13
    //   328: aload 19
    //   330: iload_3
    //   331: aload_2
    //   332: aload 17
    //   334: iconst_1
    //   335: invokestatic 600	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   338: pop
    //   339: aload 12
    //   341: astore 13
    //   343: ldc_w 335
    //   346: ldc_w 1615
    //   349: iconst_3
    //   350: anewarray 106	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload 15
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: aload 17
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: iload_3
    //   366: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   373: aload 12
    //   375: astore 13
    //   377: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   380: sipush 16498
    //   383: bipush 10
    //   385: anewarray 106	java/lang/Object
    //   388: dup
    //   389: iconst_0
    //   390: aload 5
    //   392: invokestatic 1618	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   395: ldc_w 1620
    //   398: invokestatic 1626	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   401: aastore
    //   402: dup
    //   403: iconst_1
    //   404: iload 6
    //   406: invokestatic 497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   409: aastore
    //   410: dup
    //   411: iconst_2
    //   412: iload 9
    //   414: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   417: aastore
    //   418: dup
    //   419: iconst_3
    //   420: aload 18
    //   422: getfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   425: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: dup
    //   430: iconst_4
    //   431: aload 18
    //   433: getfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   436: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   439: aastore
    //   440: dup
    //   441: iconst_5
    //   442: iload 4
    //   444: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   447: aastore
    //   448: dup
    //   449: bipush 6
    //   451: aload 19
    //   453: invokevirtual 565	android/graphics/Bitmap:getHeight	()I
    //   456: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: dup
    //   461: bipush 7
    //   463: aload 19
    //   465: invokevirtual 560	android/graphics/Bitmap:getWidth	()I
    //   468: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   471: aastore
    //   472: dup
    //   473: bipush 8
    //   475: iconst_0
    //   476: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   479: aastore
    //   480: dup
    //   481: bipush 9
    //   483: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   486: lload 10
    //   488: lsub
    //   489: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   492: aastore
    //   493: invokevirtual 811	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   496: aload 15
    //   498: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   501: ifeq +18 -> 519
    //   504: ldc_w 335
    //   507: ldc_w 1628
    //   510: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: aload 15
    //   515: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   518: pop
    //   519: aload 12
    //   521: ifnull +8 -> 529
    //   524: aload 12
    //   526: invokevirtual 1629	java/io/OutputStream:close	()V
    //   529: ldc 229
    //   531: aload 16
    //   533: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   536: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   539: astore_1
    //   540: ldc_w 1573
    //   543: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   546: aload_1
    //   547: areturn
    //   548: astore 13
    //   550: goto -226 -> 324
    //   553: astore 13
    //   555: aconst_null
    //   556: astore 14
    //   558: aload 14
    //   560: astore 13
    //   562: ldc_w 335
    //   565: ldc_w 1631
    //   568: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: iload 7
    //   573: istore_3
    //   574: iload 8
    //   576: istore 4
    //   578: aload 14
    //   580: ifnull -256 -> 324
    //   583: aload 12
    //   585: astore 13
    //   587: aload 14
    //   589: invokevirtual 1613	java/io/ByteArrayOutputStream:close	()V
    //   592: iload 7
    //   594: istore_3
    //   595: iload 8
    //   597: istore 4
    //   599: goto -275 -> 324
    //   602: astore 13
    //   604: iload 7
    //   606: istore_3
    //   607: iload 8
    //   609: istore 4
    //   611: goto -287 -> 324
    //   614: astore 5
    //   616: aconst_null
    //   617: astore 14
    //   619: aload 14
    //   621: ifnull +12 -> 633
    //   624: aload 12
    //   626: astore 13
    //   628: aload 14
    //   630: invokevirtual 1613	java/io/ByteArrayOutputStream:close	()V
    //   633: aload 12
    //   635: astore 13
    //   637: ldc_w 1573
    //   640: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   643: aload 12
    //   645: astore 13
    //   647: aload 5
    //   649: athrow
    //   650: astore 13
    //   652: aload 12
    //   654: astore 5
    //   656: aload 13
    //   658: astore 12
    //   660: ldc_w 335
    //   663: ldc_w 1568
    //   666: iconst_1
    //   667: anewarray 106	java/lang/Object
    //   670: dup
    //   671: iconst_0
    //   672: aload 12
    //   674: aastore
    //   675: invokestatic 691	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   678: aload_0
    //   679: aload_1
    //   680: iconst_1
    //   681: aload_2
    //   682: invokevirtual 1571	com/tencent/mm/ay/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   685: astore_1
    //   686: aload 15
    //   688: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   691: ifeq +18 -> 709
    //   694: ldc_w 335
    //   697: ldc_w 1628
    //   700: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   703: aload 15
    //   705: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   708: pop
    //   709: aload 5
    //   711: ifnull +8 -> 719
    //   714: aload 5
    //   716: invokevirtual 1629	java/io/OutputStream:close	()V
    //   719: ldc_w 1573
    //   722: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   725: aload_1
    //   726: areturn
    //   727: aload 12
    //   729: astore 13
    //   731: aload 15
    //   733: aload 17
    //   735: invokestatic 1634	com/tencent/mm/vfs/u:oo	(Ljava/lang/String;Ljava/lang/String;)Z
    //   738: pop
    //   739: iload 7
    //   741: istore_3
    //   742: iload 8
    //   744: istore 4
    //   746: goto -407 -> 339
    //   749: astore 5
    //   751: aload 12
    //   753: astore 13
    //   755: ldc_w 335
    //   758: ldc_w 1568
    //   761: iconst_1
    //   762: anewarray 106	java/lang/Object
    //   765: dup
    //   766: iconst_0
    //   767: aload 5
    //   769: aastore
    //   770: invokestatic 691	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   773: aload 12
    //   775: astore 13
    //   777: aload_0
    //   778: aload_1
    //   779: iconst_1
    //   780: aload_2
    //   781: invokevirtual 1571	com/tencent/mm/ay/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   784: astore_1
    //   785: aload 15
    //   787: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   790: ifeq +18 -> 808
    //   793: ldc_w 335
    //   796: ldc_w 1628
    //   799: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: aload 15
    //   804: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   807: pop
    //   808: aload 12
    //   810: ifnull +8 -> 818
    //   813: aload 12
    //   815: invokevirtual 1629	java/io/OutputStream:close	()V
    //   818: ldc_w 1573
    //   821: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   824: aload_1
    //   825: areturn
    //   826: astore_1
    //   827: aconst_null
    //   828: astore 13
    //   830: aload 15
    //   832: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   835: ifeq +18 -> 853
    //   838: ldc_w 335
    //   841: ldc_w 1628
    //   844: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: aload 15
    //   849: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   852: pop
    //   853: aload 13
    //   855: ifnull +8 -> 863
    //   858: aload 13
    //   860: invokevirtual 1629	java/io/OutputStream:close	()V
    //   863: ldc_w 1573
    //   866: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   869: aload_1
    //   870: athrow
    //   871: astore 13
    //   873: goto -240 -> 633
    //   876: astore_1
    //   877: goto -348 -> 529
    //   880: astore_2
    //   881: goto -162 -> 719
    //   884: astore_2
    //   885: goto -67 -> 818
    //   888: astore_2
    //   889: goto -26 -> 863
    //   892: astore_1
    //   893: goto -63 -> 830
    //   896: astore_1
    //   897: aload 5
    //   899: astore 13
    //   901: goto -71 -> 830
    //   904: astore 5
    //   906: aconst_null
    //   907: astore 12
    //   909: goto -158 -> 751
    //   912: astore 12
    //   914: aload 13
    //   916: astore 5
    //   918: goto -258 -> 660
    //   921: astore 5
    //   923: aload 13
    //   925: astore 14
    //   927: goto -308 -> 619
    //   930: astore 13
    //   932: goto -374 -> 558
    //   935: astore 13
    //   937: iload 4
    //   939: istore 8
    //   941: goto -383 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	944	0	this	i
    //   0	944	1	paramArrayOfByte	byte[]
    //   0	944	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	944	3	paramInt1	int
    //   0	944	4	paramInt2	int
    //   0	944	5	paramString	String
    //   0	944	6	paramBoolean	boolean
    //   180	560	7	i	int
    //   171	769	8	j	int
    //   96	317	9	k	int
    //   33	454	10	l	long
    //   131	777	12	localObject1	Object
    //   912	1	12	localIOException1	IOException
    //   124	252	13	localObject2	Object
    //   548	1	13	localException1	Exception
    //   553	1	13	localException2	Exception
    //   560	26	13	localObject3	Object
    //   602	1	13	localException3	Exception
    //   626	20	13	localObject4	Object
    //   650	7	13	localIOException2	IOException
    //   729	130	13	localObject5	Object
    //   871	1	13	localException4	Exception
    //   899	25	13	str1	String
    //   930	1	13	localException5	Exception
    //   935	1	13	localException6	Exception
    //   203	723	14	localObject6	Object
    //   75	773	15	str2	String
    //   38	494	16	str3	String
    //   52	682	17	str4	String
    //   105	327	18	localOptions	BitmapFactory.Options
    //   163	301	19	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   319	324	548	java/lang/Exception
    //   196	205	553	java/lang/Exception
    //   587	592	602	java/lang/Exception
    //   196	205	614	finally
    //   137	143	650	java/io/IOException
    //   147	152	650	java/io/IOException
    //   156	165	650	java/io/IOException
    //   169	173	650	java/io/IOException
    //   186	189	650	java/io/IOException
    //   319	324	650	java/io/IOException
    //   328	339	650	java/io/IOException
    //   343	373	650	java/io/IOException
    //   377	496	650	java/io/IOException
    //   587	592	650	java/io/IOException
    //   628	633	650	java/io/IOException
    //   637	643	650	java/io/IOException
    //   647	650	650	java/io/IOException
    //   731	739	650	java/io/IOException
    //   137	143	749	java/lang/Exception
    //   147	152	749	java/lang/Exception
    //   156	165	749	java/lang/Exception
    //   169	173	749	java/lang/Exception
    //   186	189	749	java/lang/Exception
    //   328	339	749	java/lang/Exception
    //   343	373	749	java/lang/Exception
    //   377	496	749	java/lang/Exception
    //   637	643	749	java/lang/Exception
    //   647	650	749	java/lang/Exception
    //   731	739	749	java/lang/Exception
    //   126	133	826	finally
    //   628	633	871	java/lang/Exception
    //   524	529	876	java/lang/Exception
    //   714	719	880	java/lang/Exception
    //   813	818	884	java/lang/Exception
    //   858	863	888	java/lang/Exception
    //   137	143	892	finally
    //   147	152	892	finally
    //   156	165	892	finally
    //   169	173	892	finally
    //   186	189	892	finally
    //   319	324	892	finally
    //   328	339	892	finally
    //   343	373	892	finally
    //   377	496	892	finally
    //   587	592	892	finally
    //   628	633	892	finally
    //   637	643	892	finally
    //   647	650	892	finally
    //   731	739	892	finally
    //   755	773	892	finally
    //   777	785	892	finally
    //   660	686	896	finally
    //   126	133	904	java/lang/Exception
    //   126	133	912	java/io/IOException
    //   209	220	921	finally
    //   224	232	921	finally
    //   242	254	921	finally
    //   267	272	921	finally
    //   283	293	921	finally
    //   300	308	921	finally
    //   562	571	921	finally
    //   209	220	930	java/lang/Exception
    //   224	232	930	java/lang/Exception
    //   242	254	935	java/lang/Exception
    //   267	272	935	java/lang/Exception
    //   283	293	935	java/lang/Exception
    //   300	308	935	java/lang/Exception
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1636
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1557	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 335
    //   16: ldc_w 1559
    //   19: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1636
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 789	com/tencent/mm/ay/i:blQ	()Ljava/lang/String;
    //   38: astore 17
    //   40: aload_0
    //   41: aload 17
    //   43: ldc_w 791
    //   46: ldc_w 384
    //   49: invokevirtual 388	com/tencent/mm/ay/i:r	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 19
    //   54: new 240	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   61: aload 19
    //   63: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1575
    //   69: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 16
    //   77: ldc_w 335
    //   80: ldc_w 1577
    //   83: aload 19
    //   85: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1369	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1578	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1582	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1585	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aload 18
    //   125: getfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   128: istore 7
    //   130: aload 18
    //   132: getfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   135: istore 6
    //   137: sipush 720
    //   140: iload 7
    //   142: if_icmpgt +13 -> 155
    //   145: ldc_w 1637
    //   148: iload 6
    //   150: i2f
    //   151: fcmpl
    //   152: ifle +282 -> 434
    //   155: iload 7
    //   157: istore 5
    //   159: aconst_null
    //   160: astore 13
    //   162: aload 16
    //   164: invokestatic 1589	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   167: astore 12
    //   169: aload 12
    //   171: astore 13
    //   173: aload 12
    //   175: aload_1
    //   176: invokevirtual 1594	java/io/OutputStream:write	([B)V
    //   179: aload 12
    //   181: astore 13
    //   183: aload 12
    //   185: invokevirtual 1597	java/io/OutputStream:flush	()V
    //   188: aload 12
    //   190: astore 13
    //   192: aload_1
    //   193: iload 5
    //   195: iload 6
    //   197: invokestatic 1598	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   200: astore 14
    //   202: aload 12
    //   204: astore 13
    //   206: iload 5
    //   208: aload 14
    //   210: invokevirtual 560	android/graphics/Bitmap:getWidth	()I
    //   213: if_icmpeq +240 -> 453
    //   216: aload 12
    //   218: astore 13
    //   220: aload 14
    //   222: iload 5
    //   224: iload 6
    //   226: iconst_1
    //   227: invokestatic 663	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   230: astore 14
    //   232: aload 12
    //   234: astore 13
    //   236: aload 14
    //   238: invokevirtual 565	android/graphics/Bitmap:getHeight	()I
    //   241: i2f
    //   242: aload 14
    //   244: invokevirtual 560	android/graphics/Bitmap:getWidth	()I
    //   247: i2f
    //   248: ldc_w 1638
    //   251: fmul
    //   252: fcmpl
    //   253: ifle +203 -> 456
    //   256: aload 12
    //   258: astore 13
    //   260: aload 14
    //   262: iconst_0
    //   263: iconst_0
    //   264: aload 14
    //   266: invokevirtual 560	android/graphics/Bitmap:getWidth	()I
    //   269: aload 14
    //   271: invokevirtual 560	android/graphics/Bitmap:getWidth	()I
    //   274: i2f
    //   275: ldc_w 1638
    //   278: fmul
    //   279: f2i
    //   280: invokestatic 1642	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   283: astore 15
    //   285: aload 12
    //   287: astore 13
    //   289: aload_1
    //   290: arraylength
    //   291: istore 6
    //   293: aload 15
    //   295: ifnull +405 -> 700
    //   298: bipush 70
    //   300: istore 5
    //   302: new 1601	java/io/ByteArrayOutputStream
    //   305: dup
    //   306: invokespecial 1602	java/io/ByteArrayOutputStream:<init>	()V
    //   309: astore 14
    //   311: aload 14
    //   313: astore 13
    //   315: aload 15
    //   317: aload_2
    //   318: bipush 70
    //   320: aload 14
    //   322: invokevirtual 1606	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   325: pop
    //   326: aload 14
    //   328: astore 13
    //   330: aload 14
    //   332: invokevirtual 1609	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   335: arraylength
    //   336: istore 7
    //   338: bipush 70
    //   340: istore 5
    //   342: iload 7
    //   344: istore 6
    //   346: aload 14
    //   348: astore 13
    //   350: iload 5
    //   352: istore 7
    //   354: aload 14
    //   356: invokevirtual 1609	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   359: arraylength
    //   360: ldc_w 1599
    //   363: if_icmple +125 -> 488
    //   366: iload 5
    //   368: bipush 15
    //   370: if_icmplt +118 -> 488
    //   373: aload 14
    //   375: astore 13
    //   377: iload 5
    //   379: istore 7
    //   381: aload 14
    //   383: invokevirtual 1612	java/io/ByteArrayOutputStream:reset	()V
    //   386: iload 5
    //   388: iconst_5
    //   389: isub
    //   390: istore 5
    //   392: aload 14
    //   394: astore 13
    //   396: iload 5
    //   398: istore 7
    //   400: aload 15
    //   402: aload_2
    //   403: iload 5
    //   405: aload 14
    //   407: invokevirtual 1606	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   410: pop
    //   411: aload 14
    //   413: astore 13
    //   415: iload 5
    //   417: istore 7
    //   419: aload 14
    //   421: invokevirtual 1609	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   424: arraylength
    //   425: istore 8
    //   427: iload 8
    //   429: istore 6
    //   431: goto -85 -> 346
    //   434: sipush 720
    //   437: istore 5
    //   439: iload 6
    //   441: sipush 720
    //   444: imul
    //   445: iload 7
    //   447: idiv
    //   448: istore 6
    //   450: goto -291 -> 159
    //   453: goto -221 -> 232
    //   456: aload 12
    //   458: astore 13
    //   460: aload 14
    //   462: iconst_0
    //   463: iconst_0
    //   464: aload 14
    //   466: invokevirtual 565	android/graphics/Bitmap:getHeight	()I
    //   469: i2f
    //   470: ldc_w 1638
    //   473: fdiv
    //   474: f2i
    //   475: aload 14
    //   477: invokevirtual 565	android/graphics/Bitmap:getHeight	()I
    //   480: invokestatic 1642	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   483: astore 15
    //   485: goto -200 -> 285
    //   488: aload 12
    //   490: astore 13
    //   492: aload 14
    //   494: invokevirtual 1613	java/io/ByteArrayOutputStream:close	()V
    //   497: iload 6
    //   499: istore 8
    //   501: iload 5
    //   503: istore 7
    //   505: aload 12
    //   507: astore 13
    //   509: aload 15
    //   511: iload 7
    //   513: aload_2
    //   514: aload 19
    //   516: iconst_1
    //   517: invokestatic 600	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   520: pop
    //   521: aload 12
    //   523: astore 13
    //   525: ldc_w 335
    //   528: ldc_w 1615
    //   531: iconst_3
    //   532: anewarray 106	java/lang/Object
    //   535: dup
    //   536: iconst_0
    //   537: aload 16
    //   539: aastore
    //   540: dup
    //   541: iconst_1
    //   542: aload 19
    //   544: aastore
    //   545: dup
    //   546: iconst_2
    //   547: iload 7
    //   549: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   552: aastore
    //   553: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: aload 12
    //   558: astore 13
    //   560: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   563: astore 14
    //   565: aload 12
    //   567: astore 13
    //   569: aload_3
    //   570: invokestatic 1618	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   573: ldc_w 1620
    //   576: invokestatic 1626	com/tencent/mm/compatible/util/q:an	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   579: astore_3
    //   580: iload 4
    //   582: ifeq +355 -> 937
    //   585: iconst_1
    //   586: istore 5
    //   588: aload 12
    //   590: astore 13
    //   592: aload 14
    //   594: sipush 16498
    //   597: bipush 10
    //   599: anewarray 106	java/lang/Object
    //   602: dup
    //   603: iconst_0
    //   604: aload_3
    //   605: aastore
    //   606: dup
    //   607: iconst_1
    //   608: iload 5
    //   610: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   613: aastore
    //   614: dup
    //   615: iconst_2
    //   616: iload 9
    //   618: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   621: aastore
    //   622: dup
    //   623: iconst_3
    //   624: aload 18
    //   626: getfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   629: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   632: aastore
    //   633: dup
    //   634: iconst_4
    //   635: aload 18
    //   637: getfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   640: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   643: aastore
    //   644: dup
    //   645: iconst_5
    //   646: iload 8
    //   648: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   651: aastore
    //   652: dup
    //   653: bipush 6
    //   655: aload 15
    //   657: invokevirtual 565	android/graphics/Bitmap:getHeight	()I
    //   660: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   663: aastore
    //   664: dup
    //   665: bipush 7
    //   667: aload 15
    //   669: invokevirtual 560	android/graphics/Bitmap:getWidth	()I
    //   672: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   675: aastore
    //   676: dup
    //   677: bipush 8
    //   679: iconst_1
    //   680: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   683: aastore
    //   684: dup
    //   685: bipush 9
    //   687: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   690: lload 10
    //   692: lsub
    //   693: invokestatic 342	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   696: aastore
    //   697: invokevirtual 811	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   700: aload 16
    //   702: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   705: ifeq +18 -> 723
    //   708: ldc_w 335
    //   711: ldc_w 1628
    //   714: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   717: aload 16
    //   719: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   722: pop
    //   723: aload 12
    //   725: ifnull +8 -> 733
    //   728: aload 12
    //   730: invokevirtual 1629	java/io/OutputStream:close	()V
    //   733: ldc 229
    //   735: aload 17
    //   737: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   740: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   743: astore_1
    //   744: ldc_w 1636
    //   747: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: aload_1
    //   751: areturn
    //   752: astore 13
    //   754: iload 5
    //   756: istore 7
    //   758: iload 6
    //   760: istore 8
    //   762: goto -257 -> 505
    //   765: astore 13
    //   767: aconst_null
    //   768: astore 14
    //   770: aload 14
    //   772: astore 13
    //   774: ldc_w 335
    //   777: ldc_w 1631
    //   780: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   783: iload 5
    //   785: istore 7
    //   787: iload 6
    //   789: istore 8
    //   791: aload 14
    //   793: ifnull -288 -> 505
    //   796: aload 12
    //   798: astore 13
    //   800: aload 14
    //   802: invokevirtual 1613	java/io/ByteArrayOutputStream:close	()V
    //   805: iload 5
    //   807: istore 7
    //   809: iload 6
    //   811: istore 8
    //   813: goto -308 -> 505
    //   816: astore 13
    //   818: iload 5
    //   820: istore 7
    //   822: iload 6
    //   824: istore 8
    //   826: goto -321 -> 505
    //   829: astore_3
    //   830: aconst_null
    //   831: astore 14
    //   833: aload 14
    //   835: ifnull +12 -> 847
    //   838: aload 12
    //   840: astore 13
    //   842: aload 14
    //   844: invokevirtual 1613	java/io/ByteArrayOutputStream:close	()V
    //   847: aload 12
    //   849: astore 13
    //   851: ldc_w 1636
    //   854: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   857: aload 12
    //   859: astore 13
    //   861: aload_3
    //   862: athrow
    //   863: astore 13
    //   865: aload 12
    //   867: astore_3
    //   868: aload 13
    //   870: astore 12
    //   872: ldc_w 335
    //   875: ldc_w 1568
    //   878: iconst_1
    //   879: anewarray 106	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: aload 12
    //   886: aastore
    //   887: invokestatic 691	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   890: aload_0
    //   891: aload_1
    //   892: iconst_1
    //   893: aload_2
    //   894: invokevirtual 1571	com/tencent/mm/ay/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   897: astore_1
    //   898: aload 16
    //   900: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   903: ifeq +18 -> 921
    //   906: ldc_w 335
    //   909: ldc_w 1628
    //   912: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   915: aload 16
    //   917: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   920: pop
    //   921: aload_3
    //   922: ifnull +7 -> 929
    //   925: aload_3
    //   926: invokevirtual 1629	java/io/OutputStream:close	()V
    //   929: ldc_w 1636
    //   932: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   935: aload_1
    //   936: areturn
    //   937: iconst_0
    //   938: istore 5
    //   940: goto -352 -> 588
    //   943: astore_3
    //   944: aconst_null
    //   945: astore 12
    //   947: aload 12
    //   949: astore 13
    //   951: ldc_w 335
    //   954: ldc_w 1568
    //   957: iconst_1
    //   958: anewarray 106	java/lang/Object
    //   961: dup
    //   962: iconst_0
    //   963: aload_3
    //   964: aastore
    //   965: invokestatic 691	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   968: aload 12
    //   970: astore 13
    //   972: aload_0
    //   973: aload_1
    //   974: iconst_1
    //   975: aload_2
    //   976: invokevirtual 1571	com/tencent/mm/ay/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   979: astore_1
    //   980: aload 16
    //   982: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   985: ifeq +18 -> 1003
    //   988: ldc_w 335
    //   991: ldc_w 1628
    //   994: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   997: aload 16
    //   999: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   1002: pop
    //   1003: aload 12
    //   1005: ifnull +8 -> 1013
    //   1008: aload 12
    //   1010: invokevirtual 1629	java/io/OutputStream:close	()V
    //   1013: ldc_w 1636
    //   1016: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1019: aload_1
    //   1020: areturn
    //   1021: astore_1
    //   1022: aconst_null
    //   1023: astore 13
    //   1025: aload 16
    //   1027: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   1030: ifeq +18 -> 1048
    //   1033: ldc_w 335
    //   1036: ldc_w 1628
    //   1039: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1042: aload 16
    //   1044: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   1047: pop
    //   1048: aload 13
    //   1050: ifnull +8 -> 1058
    //   1053: aload 13
    //   1055: invokevirtual 1629	java/io/OutputStream:close	()V
    //   1058: ldc_w 1636
    //   1061: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1064: aload_1
    //   1065: athrow
    //   1066: astore 13
    //   1068: goto -221 -> 847
    //   1071: astore_1
    //   1072: goto -339 -> 733
    //   1075: astore_2
    //   1076: goto -147 -> 929
    //   1079: astore_2
    //   1080: goto -67 -> 1013
    //   1083: astore_2
    //   1084: goto -26 -> 1058
    //   1087: astore_1
    //   1088: goto -63 -> 1025
    //   1091: astore_1
    //   1092: aload_3
    //   1093: astore 13
    //   1095: goto -70 -> 1025
    //   1098: astore_3
    //   1099: goto -152 -> 947
    //   1102: astore 12
    //   1104: aload 13
    //   1106: astore_3
    //   1107: goto -235 -> 872
    //   1110: astore_3
    //   1111: aload 13
    //   1113: astore 14
    //   1115: goto -282 -> 833
    //   1118: astore 13
    //   1120: goto -350 -> 770
    //   1123: astore 13
    //   1125: iload 7
    //   1127: istore 5
    //   1129: goto -359 -> 770
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1132	0	this	i
    //   0	1132	1	paramArrayOfByte	byte[]
    //   0	1132	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	1132	3	paramString	String
    //   0	1132	4	paramBoolean	boolean
    //   157	971	5	i	int
    //   135	688	6	j	int
    //   128	998	7	k	int
    //   425	400	8	m	int
    //   96	521	9	n	int
    //   33	658	10	l	long
    //   167	842	12	localObject1	Object
    //   1102	1	12	localIOException1	IOException
    //   160	431	13	localObject2	Object
    //   752	1	13	localException1	Exception
    //   765	1	13	localException2	Exception
    //   772	27	13	localObject3	Object
    //   816	1	13	localException3	Exception
    //   840	20	13	localObject4	Object
    //   863	6	13	localIOException2	IOException
    //   949	105	13	localObject5	Object
    //   1066	1	13	localException4	Exception
    //   1093	19	13	str1	String
    //   1118	1	13	localException5	Exception
    //   1123	1	13	localException6	Exception
    //   200	914	14	localObject6	Object
    //   283	385	15	localBitmap	Bitmap
    //   75	968	16	str2	String
    //   38	698	17	str3	String
    //   105	531	18	localOptions	BitmapFactory.Options
    //   52	491	19	str4	String
    // Exception table:
    //   from	to	target	type
    //   492	497	752	java/lang/Exception
    //   302	311	765	java/lang/Exception
    //   800	805	816	java/lang/Exception
    //   302	311	829	finally
    //   173	179	863	java/io/IOException
    //   183	188	863	java/io/IOException
    //   192	202	863	java/io/IOException
    //   206	216	863	java/io/IOException
    //   220	232	863	java/io/IOException
    //   236	256	863	java/io/IOException
    //   260	285	863	java/io/IOException
    //   289	293	863	java/io/IOException
    //   460	485	863	java/io/IOException
    //   492	497	863	java/io/IOException
    //   509	521	863	java/io/IOException
    //   525	556	863	java/io/IOException
    //   560	565	863	java/io/IOException
    //   569	580	863	java/io/IOException
    //   592	700	863	java/io/IOException
    //   800	805	863	java/io/IOException
    //   842	847	863	java/io/IOException
    //   851	857	863	java/io/IOException
    //   861	863	863	java/io/IOException
    //   162	169	943	java/lang/Exception
    //   162	169	1021	finally
    //   842	847	1066	java/lang/Exception
    //   728	733	1071	java/lang/Exception
    //   925	929	1075	java/lang/Exception
    //   1008	1013	1079	java/lang/Exception
    //   1053	1058	1083	java/lang/Exception
    //   173	179	1087	finally
    //   183	188	1087	finally
    //   192	202	1087	finally
    //   206	216	1087	finally
    //   220	232	1087	finally
    //   236	256	1087	finally
    //   260	285	1087	finally
    //   289	293	1087	finally
    //   460	485	1087	finally
    //   492	497	1087	finally
    //   509	521	1087	finally
    //   525	556	1087	finally
    //   560	565	1087	finally
    //   569	580	1087	finally
    //   592	700	1087	finally
    //   800	805	1087	finally
    //   842	847	1087	finally
    //   851	857	1087	finally
    //   861	863	1087	finally
    //   951	968	1087	finally
    //   972	980	1087	finally
    //   872	898	1091	finally
    //   173	179	1098	java/lang/Exception
    //   183	188	1098	java/lang/Exception
    //   192	202	1098	java/lang/Exception
    //   206	216	1098	java/lang/Exception
    //   220	232	1098	java/lang/Exception
    //   236	256	1098	java/lang/Exception
    //   260	285	1098	java/lang/Exception
    //   289	293	1098	java/lang/Exception
    //   460	485	1098	java/lang/Exception
    //   509	521	1098	java/lang/Exception
    //   525	556	1098	java/lang/Exception
    //   560	565	1098	java/lang/Exception
    //   569	580	1098	java/lang/Exception
    //   592	700	1098	java/lang/Exception
    //   851	857	1098	java/lang/Exception
    //   861	863	1098	java/lang/Exception
    //   162	169	1102	java/io/IOException
    //   315	326	1110	finally
    //   330	338	1110	finally
    //   354	366	1110	finally
    //   381	386	1110	finally
    //   400	411	1110	finally
    //   419	427	1110	finally
    //   774	783	1110	finally
    //   315	326	1118	java/lang/Exception
    //   330	338	1118	java/lang/Exception
    //   354	366	1123	java/lang/Exception
    //   381	386	1123	java/lang/Exception
    //   400	411	1123	java/lang/Exception
    //   419	427	1123	java/lang/Exception
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
    //   0: ldc_w 1647
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1557	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 335
    //   16: ldc_w 1559
    //   19: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1647
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 789	com/tencent/mm/ay/i:blQ	()Ljava/lang/String;
    //   33: astore 9
    //   35: aload_0
    //   36: aload 9
    //   38: ldc_w 791
    //   41: ldc_w 384
    //   44: invokevirtual 388	com/tencent/mm/ay/i:r	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 10
    //   49: new 240	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   56: aload 10
    //   58: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1575
    //   64: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 8
    //   72: ldc_w 335
    //   75: ldc_w 1577
    //   78: aload 10
    //   80: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 8
    //   91: invokestatic 1589	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   94: astore 7
    //   96: aload 7
    //   98: aload_1
    //   99: invokevirtual 1594	java/io/OutputStream:write	([B)V
    //   102: aload 7
    //   104: invokevirtual 1597	java/io/OutputStream:flush	()V
    //   107: iload_2
    //   108: ifeq +113 -> 221
    //   111: sipush 128
    //   114: istore 5
    //   116: goto +298 -> 414
    //   119: iload 4
    //   121: ifeq +114 -> 235
    //   124: aload 8
    //   126: aconst_null
    //   127: invokestatic 1650	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull +37 -> 169
    //   135: aload_1
    //   136: bipush 90
    //   138: aload_3
    //   139: aload 10
    //   141: iconst_1
    //   142: invokestatic 600	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   145: pop
    //   146: ldc_w 335
    //   149: ldc_w 1652
    //   152: iconst_2
    //   153: anewarray 106	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload 8
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload 10
    //   165: aastore
    //   166: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload 8
    //   171: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   174: ifeq +18 -> 192
    //   177: ldc_w 335
    //   180: ldc_w 1628
    //   183: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 8
    //   188: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   191: pop
    //   192: aload 7
    //   194: ifnull +8 -> 202
    //   197: aload 7
    //   199: invokevirtual 1629	java/io/OutputStream:close	()V
    //   202: ldc 229
    //   204: aload 9
    //   206: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   209: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore_1
    //   213: ldc_w 1647
    //   216: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: aload_1
    //   220: areturn
    //   221: bipush 120
    //   223: istore 5
    //   225: goto +189 -> 414
    //   228: bipush 120
    //   230: istore 6
    //   232: goto -113 -> 119
    //   235: aload 8
    //   237: iload 5
    //   239: iload 6
    //   241: iconst_0
    //   242: invokestatic 1656	com/tencent/mm/sdk/platformtools/BitmapUtil:extractThumbNail	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   245: astore_1
    //   246: goto -115 -> 131
    //   249: astore_3
    //   250: aconst_null
    //   251: astore_1
    //   252: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   255: ldc2_w 1234
    //   258: ldc2_w 1657
    //   261: lconst_1
    //   262: iconst_0
    //   263: invokevirtual 1241	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   266: ldc_w 335
    //   269: new 240	java/lang/StringBuilder
    //   272: dup
    //   273: ldc_w 1660
    //   276: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   279: aload 9
    //   281: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc_w 1662
    //   287: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload_3
    //   291: invokevirtual 1248	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload 8
    //   305: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   308: ifeq +18 -> 326
    //   311: ldc_w 335
    //   314: ldc_w 1628
    //   317: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload 8
    //   322: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   325: pop
    //   326: aload_1
    //   327: ifnull +7 -> 334
    //   330: aload_1
    //   331: invokevirtual 1629	java/io/OutputStream:close	()V
    //   334: ldc_w 1647
    //   337: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aconst_null
    //   341: areturn
    //   342: astore_3
    //   343: aconst_null
    //   344: astore_1
    //   345: aload 8
    //   347: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   350: ifeq +18 -> 368
    //   353: ldc_w 335
    //   356: ldc_w 1628
    //   359: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload 8
    //   364: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   367: pop
    //   368: aload_1
    //   369: ifnull +7 -> 376
    //   372: aload_1
    //   373: invokevirtual 1629	java/io/OutputStream:close	()V
    //   376: ldc_w 1647
    //   379: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: aload_3
    //   383: athrow
    //   384: astore_1
    //   385: goto -183 -> 202
    //   388: astore_1
    //   389: goto -55 -> 334
    //   392: astore_1
    //   393: goto -17 -> 376
    //   396: astore_3
    //   397: aload 7
    //   399: astore_1
    //   400: goto -55 -> 345
    //   403: astore_3
    //   404: goto -59 -> 345
    //   407: astore_3
    //   408: aload 7
    //   410: astore_1
    //   411: goto -159 -> 252
    //   414: iload_2
    //   415: ifeq -187 -> 228
    //   418: sipush 128
    //   421: istore 6
    //   423: goto -304 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	i
    //   0	426	1	paramArrayOfByte	byte[]
    //   0	426	2	paramBoolean1	boolean
    //   0	426	3	paramCompressFormat	Bitmap.CompressFormat
    //   0	426	4	paramBoolean2	boolean
    //   114	124	5	i	int
    //   230	192	6	j	int
    //   94	315	7	localOutputStream	java.io.OutputStream
    //   70	293	8	str1	String
    //   33	247	9	str2	String
    //   47	117	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	96	249	java/lang/Exception
    //   89	96	342	finally
    //   197	202	384	java/lang/Exception
    //   330	334	388	java/lang/Exception
    //   372	376	392	java/lang/Exception
    //   96	107	396	finally
    //   124	131	396	finally
    //   135	169	396	finally
    //   235	246	396	finally
    //   252	303	403	finally
    //   96	107	407	java/lang/Exception
    //   124	131	407	java/lang/Exception
    //   135	169	407	java/lang/Exception
    //   235	246	407	java/lang/Exception
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
      ((HashMap)localObject1).put(Long.valueOf(((g)localObject2).fNu), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150601);
    return localObject1;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, View paramView)
  {
    AppMethodBeat.i(212965);
    boolean bool = a(paramImageView1, paramString, false, paramFloat, paramInt1, paramInt2, paramInt3, paramImageView2, paramInt4, paramInt5, paramView);
    AppMethodBeat.o(212965);
    return bool;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, View paramView)
  {
    AppMethodBeat.i(212973);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      AppMethodBeat.o(212973);
      return false;
    }
    label593:
    label605:
    label874:
    label1132:
    for (;;)
    {
      synchronized (this.lOx)
      {
        boolean bool = this.lOx.containsKey(paramString);
        String str = d(paramString, paramBoolean, false);
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { Util.nullAsNil(paramString) });
          AppMethodBeat.o(212973);
          return false;
        }
        localObject = str;
        if (!bool)
        {
          localObject = str;
          if (!str.endsWith("hd"))
          {
            localObject = str;
            if (com.tencent.mm.vfs.u.agG(str + "hd"))
            {
              this.lOx.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1138;
        }
        paramString = (Bitmap)this.lOq.aX(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, true, paramInt3);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1135;
          }
          paramString = (Bitmap)this.lOq.aX(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label660;
          }
          Log.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label593;
          }
          localObject = this.lOy;
          if (paramInt5 != 0) {
            break label605;
          }
          ((FrameLayout.LayoutParams)localObject).gravity = 5;
          paramImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramString.getWidth() < paramString.getHeight() * 2.5D) {
            break label620;
          }
          paramInt1 = 1;
          if (paramString.getHeight() < paramString.getWidth() * 2.5D) {
            break label626;
          }
          paramInt2 = 1;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            paramImageView1.setScaleType(ImageView.ScaleType.CENTER);
          }
          if (paramImageView2 != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt5 != 0) {
              break label632;
            }
            paramImageView1.gravity = 5;
            paramImageView2.setLayoutParams(paramImageView1);
          }
          if (paramView != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt5 != 0) {
              break label646;
            }
            paramImageView1.gravity = 5;
            paramView.setLayoutParams(paramImageView1);
          }
          AppMethodBeat.o(212973);
          return true;
        }
      }
      if (this.lOq.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
        Log.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(String.valueOf(localObject)));
      }
      int i = 0;
      continue;
      Object localObject = (FrameLayout.LayoutParams)paramImageView1.getLayoutParams();
      continue;
      label620:
      label749:
      label1135:
      label1138:
      if (paramInt5 == 1)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
        continue;
        paramInt1 = 0;
        continue;
        label626:
        paramInt2 = 0;
        continue;
        label632:
        if (paramInt5 == 1)
        {
          paramImageView1.gravity = 3;
          continue;
          if (paramInt5 == 1)
          {
            paramImageView1.gravity = 3;
            continue;
            float f;
            if (paramInt4 > 0)
            {
              paramImageView1.setBackgroundResource(paramInt4);
              paramImageView1.setImageDrawable(null);
              if ((paramInt1 >= 160) || (paramInt2 >= 160)) {
                if (paramInt2 > paramInt1)
                {
                  f = 160.0F / paramInt2;
                  paramInt1 = (int)(paramInt1 * f);
                  paramInt2 = (int)(f * paramInt2);
                  if (paramInt1 <= 0) {
                    break label931;
                  }
                  paramInt4 = (int)(paramInt1 * paramFloat);
                  if (paramInt2 <= 0) {
                    break label938;
                  }
                  paramInt1 = paramInt2;
                  paramInt1 = (int)(paramInt1 * paramFloat);
                  paramInt2 = paramInt4;
                  if (paramInt2 >= 60.0F * paramFloat) {
                    break label1132;
                  }
                  Log.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(paramInt2) });
                  paramInt2 = (int)(60.0F * paramFloat);
                }
              }
            }
            for (;;)
            {
              paramInt4 = paramInt1;
              if (paramInt1 < 60.0F * paramFloat)
              {
                Log.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(paramInt1) });
                paramInt4 = (int)(60.0F * paramFloat);
              }
              paramString = new FrameLayout.LayoutParams(paramInt2, paramInt4);
              if (paramInt5 == 0)
              {
                paramString.gravity = 5;
                if (paramView == null) {
                  break label1129;
                }
                paramView.setLayoutParams(paramString);
              }
              for (;;)
              {
                paramImageView1.setLayoutParams(paramString);
                if (i == 0) {
                  a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, true, paramInt3);
                }
                AppMethodBeat.o(212973);
                return false;
                f = 160.0F / paramInt1;
                break;
                paramInt1 = 120;
                break label731;
                paramInt1 = 75;
                break label749;
                if (paramInt1 > 0)
                {
                  paramInt4 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label995;
                  }
                }
                for (;;)
                {
                  paramInt1 = (int)(paramInt2 * paramFloat * 1.25F);
                  paramInt2 = paramInt4;
                  break;
                  paramInt1 = 120;
                  break label950;
                  paramInt2 = 75;
                }
                if (paramInt5 != 1) {
                  break label874;
                }
                paramString.gravity = 3;
                break label874;
                if ((this.lOz == null) || (this.lOz.get() == null)) {
                  this.lOz = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.lOz.get());
                if (paramInt1 > 0)
                {
                  paramInt1 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label1122;
                  }
                }
                for (;;)
                {
                  paramString = new FrameLayout.LayoutParams(paramInt1, (int)(paramInt2 * paramFloat * 1.25F));
                  break;
                  paramInt1 = 120;
                  break label1073;
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
    AppMethodBeat.i(213083);
    String str = ac(paramca);
    if (!Util.isNullOrNil(str))
    {
      boolean bool = a(str, paramca.field_imgPath, paramInt1, paramInt2, 0, 0);
      AppMethodBeat.o(213083);
      return bool;
    }
    AppMethodBeat.o(213083);
    return false;
  }
  
  /* Error */
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 1742
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 335
    //   9: ldc_w 1744
    //   12: iconst_5
    //   13: anewarray 106	java/lang/Object
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
    //   27: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: iload 4
    //   35: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_4
    //   41: invokestatic 503	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   44: aastore
    //   45: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   51: lstore 10
    //   53: invokestatic 634	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   56: invokestatic 1132	com/tencent/mm/ci/a:getDensity	(Landroid/content/Context;)F
    //   59: fstore 7
    //   61: aload_1
    //   62: invokestatic 526	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +10 -> 75
    //   68: aload_2
    //   69: invokestatic 526	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifeq +11 -> 83
    //   75: ldc_w 1742
    //   78: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_2
    //   85: iconst_0
    //   86: iconst_1
    //   87: invokevirtual 615	com/tencent/mm/ay/i:d	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   90: astore 13
    //   92: aload 13
    //   94: invokestatic 526	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   97: ifeq +11 -> 108
    //   100: ldc_w 1742
    //   103: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 13
    //   110: ldc_w 528
    //   113: invokevirtual 531	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +98 -> 214
    //   119: new 240	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   126: aload 13
    //   128: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 528
    //   134: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 15
    //   142: aload 13
    //   144: astore 14
    //   146: aload 15
    //   148: astore 13
    //   150: aload 14
    //   152: invokestatic 1367	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   155: astore 16
    //   157: aload 16
    //   159: ifnull +23 -> 182
    //   162: aload 16
    //   164: getfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   167: ifle +15 -> 182
    //   170: aload 16
    //   172: astore 15
    //   174: aload 16
    //   176: getfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   179: ifgt +121 -> 300
    //   182: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   185: ldc2_w 1234
    //   188: ldc2_w 1745
    //   191: lconst_1
    //   192: iconst_0
    //   193: invokevirtual 1241	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   196: aload 14
    //   198: invokestatic 415	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   201: lconst_0
    //   202: lcmp
    //   203: ifle +29 -> 232
    //   206: ldc_w 1742
    //   209: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: iconst_0
    //   213: ireturn
    //   214: aload 13
    //   216: iconst_0
    //   217: aload 13
    //   219: invokevirtual 568	java/lang/String:length	()I
    //   222: iconst_2
    //   223: isub
    //   224: invokevirtual 572	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore 14
    //   229: goto -79 -> 150
    //   232: new 1369	android/graphics/BitmapFactory$Options
    //   235: dup
    //   236: invokespecial 1578	android/graphics/BitmapFactory$Options:<init>	()V
    //   239: astore 15
    //   241: aload 15
    //   243: invokestatic 1750	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   246: ldc_w 335
    //   249: ldc_w 1752
    //   252: iconst_3
    //   253: anewarray 106	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload 15
    //   260: aastore
    //   261: dup
    //   262: iconst_1
    //   263: aload 15
    //   265: getfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   268: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: aload 15
    //   276: getfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   279: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: invokestatic 347	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   289: ldc2_w 1234
    //   292: ldc2_w 1753
    //   295: lconst_1
    //   296: iconst_0
    //   297: invokevirtual 1241	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   300: aload 15
    //   302: getfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   305: ifne +10 -> 315
    //   308: aload 15
    //   310: iload 5
    //   312: putfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   315: aload 15
    //   317: getfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   320: ifne +10 -> 330
    //   323: aload 15
    //   325: iload 6
    //   327: putfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   330: aload 15
    //   332: getfield 1372	android/graphics/BitmapFactory$Options:outWidth	I
    //   335: i2f
    //   336: fload 7
    //   338: fmul
    //   339: ldc_w 646
    //   342: fmul
    //   343: f2i
    //   344: istore 9
    //   346: aload 15
    //   348: getfield 1375	android/graphics/BitmapFactory$Options:outHeight	I
    //   351: i2f
    //   352: fload 7
    //   354: fmul
    //   355: ldc_w 646
    //   358: fmul
    //   359: f2i
    //   360: istore 8
    //   362: iload 9
    //   364: i2f
    //   365: ldc_w 647
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
    //   386: ldc_w 647
    //   389: fload 7
    //   391: fmul
    //   392: fcmpl
    //   393: iflt +40 -> 433
    //   396: iload 8
    //   398: iload 9
    //   400: if_icmple +221 -> 621
    //   403: ldc_w 647
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
    //   443: getstatic 596	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   446: bipush 80
    //   448: aload 13
    //   450: iconst_1
    //   451: new 420	com/tencent/mm/pointers/PInt
    //   454: dup
    //   455: invokespecial 421	com/tencent/mm/pointers/PInt:<init>	()V
    //   458: new 420	com/tencent/mm/pointers/PInt
    //   461: dup
    //   462: invokespecial 421	com/tencent/mm/pointers/PInt:<init>	()V
    //   465: iconst_1
    //   466: iconst_m1
    //   467: invokestatic 1758	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;ZLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;ZI)Z
    //   470: istore 12
    //   472: ldc_w 335
    //   475: ldc_w 1760
    //   478: iconst_4
    //   479: anewarray 106	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: new 240	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   491: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   494: lload 10
    //   496: lsub
    //   497: invokevirtual 323	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: aastore
    //   504: dup
    //   505: iconst_1
    //   506: iload 6
    //   508: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: aastore
    //   512: dup
    //   513: iconst_2
    //   514: iload 5
    //   516: invokestatic 465	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: aastore
    //   520: dup
    //   521: iconst_3
    //   522: iload 12
    //   524: invokestatic 497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   527: aastore
    //   528: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload_0
    //   532: aload 14
    //   534: iconst_1
    //   535: invokestatic 634	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   538: invokestatic 1132	com/tencent/mm/ci/a:getDensity	(Landroid/content/Context;)F
    //   541: iconst_1
    //   542: iconst_0
    //   543: iconst_1
    //   544: iload_3
    //   545: iconst_0
    //   546: invokespecial 1256	com/tencent/mm/ay/i:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   549: pop
    //   550: iload 12
    //   552: ifeq +176 -> 728
    //   555: aload_0
    //   556: getfield 155	com/tencent/mm/ay/i:lOx	Ljava/util/Map;
    //   559: astore_1
    //   560: aload_1
    //   561: monitorenter
    //   562: aload_0
    //   563: getfield 155	com/tencent/mm/ay/i:lOx	Ljava/util/Map;
    //   566: aload_2
    //   567: invokeinterface 1687 2 0
    //   572: ifeq +38 -> 610
    //   575: aload_0
    //   576: getfield 155	com/tencent/mm/ay/i:lOx	Ljava/util/Map;
    //   579: aload_2
    //   580: invokeinterface 874 2 0
    //   585: checkcast 61	java/lang/String
    //   588: ldc_w 528
    //   591: invokevirtual 531	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   594: ifne +16 -> 610
    //   597: aload_0
    //   598: getfield 155	com/tencent/mm/ay/i:lOx	Ljava/util/Map;
    //   601: aload_2
    //   602: aload 13
    //   604: invokeinterface 857 3 0
    //   609: pop
    //   610: aload_1
    //   611: monitorexit
    //   612: ldc_w 1742
    //   615: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: iload 12
    //   620: ireturn
    //   621: ldc_w 647
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
    //   641: getstatic 596	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   644: bipush 80
    //   646: aload 13
    //   648: iconst_1
    //   649: new 420	com/tencent/mm/pointers/PInt
    //   652: dup
    //   653: invokespecial 421	com/tencent/mm/pointers/PInt:<init>	()V
    //   656: new 420	com/tencent/mm/pointers/PInt
    //   659: dup
    //   660: invokespecial 421	com/tencent/mm/pointers/PInt:<init>	()V
    //   663: iconst_1
    //   664: iconst_1
    //   665: iconst_m1
    //   666: invokestatic 1763	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;ZLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;ZZI)Z
    //   669: istore 12
    //   671: goto -199 -> 472
    //   674: astore_1
    //   675: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   678: ldc2_w 1234
    //   681: ldc2_w 1764
    //   684: lconst_1
    //   685: iconst_0
    //   686: invokevirtual 1241	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   689: ldc_w 335
    //   692: ldc_w 1767
    //   695: iconst_1
    //   696: anewarray 106	java/lang/Object
    //   699: dup
    //   700: iconst_0
    //   701: aload_1
    //   702: invokevirtual 1768	java/lang/Exception:toString	()Ljava/lang/String;
    //   705: aastore
    //   706: invokestatic 691	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   709: ldc_w 1742
    //   712: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   715: iconst_0
    //   716: ireturn
    //   717: astore_2
    //   718: aload_1
    //   719: monitorexit
    //   720: ldc_w 1742
    //   723: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_2
    //   727: athrow
    //   728: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   731: ldc2_w 1234
    //   734: ldc2_w 1764
    //   737: lconst_1
    //   738: iconst_0
    //   739: invokevirtual 1241	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
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
  }
  
  public final String aA(byte[] paramArrayOfByte)
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
    localObject = blQ();
    String str = r((String)localObject, "th_", "");
    Log.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(str)));
    com.tencent.mm.vfs.u.deleteFile(str);
    com.tencent.mm.vfs.u.H(str, paramArrayOfByte);
    paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(localObject));
    AppMethodBeat.o(150580);
    return paramArrayOfByte;
  }
  
  public final g aa(ca paramca)
  {
    AppMethodBeat.i(150595);
    g localg = D(paramca.field_talker, paramca.field_msgId);
    Object localObject = localg;
    if (localg.localId == 0L)
    {
      paramca = C(paramca.field_talker, paramca.field_msgSvrId);
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
  
  public final void ab(ca paramca)
  {
    AppMethodBeat.i(150599);
    g localg = aa(paramca);
    if ((localg == null) || (localg.localId == 0L))
    {
      Log.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      AppMethodBeat.o(150599);
      return;
    }
    com.tencent.mm.vfs.u.deleteFile(r(localg.lNH, "", ""));
    com.tencent.mm.vfs.u.deleteFile(r(localg.lNM, "", ""));
    com.tencent.mm.vfs.u.deleteFile(r(localg.lNJ, "", ""));
    com.tencent.mm.vfs.u.deleteFile(r(localg.lNJ, "", "") + "hd");
    this.lvy.delete(d.Wf(paramca.field_talker), "id=?", new String[] { localg.localId });
    if (localg.blK())
    {
      localg = wl(localg.lNR);
      if (localg == null)
      {
        AppMethodBeat.o(150599);
        return;
      }
      com.tencent.mm.vfs.u.deleteFile(r(localg.lNH, "", ""));
      com.tencent.mm.vfs.u.deleteFile(r(localg.lNM, "", ""));
      com.tencent.mm.vfs.u.deleteFile(r(localg.lNJ, "", ""));
      com.tencent.mm.vfs.u.deleteFile(r(localg.lNJ, "", "") + "hd");
      this.lvy.delete(d.Wf(paramca.field_talker), "id=?", new String[] { localg.localId });
    }
    AppMethodBeat.o(150599);
  }
  
  public final String az(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(212943);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.ImgInfoStorage", "directSaveThumbBufForAppMsg save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(212943);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth < 0) || (((BitmapFactory.Options)localObject).outHeight < 0))
    {
      Log.e("MicroMsg.ImgInfoStorage", "directSaveThumbBufForAppMsg Bad thumbBuf, perhaps it's not complete or damaged ??");
      AppMethodBeat.o(212943);
      return null;
    }
    localObject = blQ();
    String str = a((String)localObject, "msgth_", "", true);
    Log.d("MicroMsg.ImgInfoStorage", "directSaveThumbBufForAppMsg, fullPath = ".concat(String.valueOf(str)));
    com.tencent.mm.vfs.u.deleteFile(str);
    com.tencent.mm.vfs.u.H(str, paramArrayOfByte);
    paramArrayOfByte = VX((String)localObject);
    AppMethodBeat.o(212943);
    return paramArrayOfByte;
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(213075);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from";; str = "location_backgroup_key_tor")
    {
      Bitmap localBitmap2 = (Bitmap)this.lOq.aX(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BitmapUtil.createLocation(paramInt1, paramInt2, paramInt3, paramInt4);
        this.lOq.q(str, localBitmap1);
      }
      AppMethodBeat.o(213075);
      return localBitmap1;
    }
  }
  
  public final Bitmap b(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(150588);
    paramString = a(paramString, true, paramFloat, paramBoolean, true, false, 0);
    AppMethodBeat.o(150588);
    return paramString;
  }
  
  public final g b(Long paramLong)
  {
    AppMethodBeat.i(150596);
    g localg = new g();
    paramLong = a(d.GG(paramLong.longValue()), null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      localg.convertFrom(paramLong);
    }
    paramLong.close();
    AppMethodBeat.o(150596);
    return localg;
  }
  
  /* Error */
  public final String b(byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: ldc_w 1815
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1557	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 335
    //   16: ldc_w 1817
    //   19: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1815
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 789	com/tencent/mm/ay/i:blQ	()Ljava/lang/String;
    //   33: astore 8
    //   35: aload_0
    //   36: aload 8
    //   38: ldc_w 1536
    //   41: ldc_w 384
    //   44: invokevirtual 388	com/tencent/mm/ay/i:r	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 9
    //   49: new 240	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 320	java/lang/StringBuilder:<init>	()V
    //   56: aload 9
    //   58: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1575
    //   64: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 7
    //   72: ldc_w 335
    //   75: ldc_w 1819
    //   78: aload 9
    //   80: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 235	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 7
    //   91: invokestatic 1589	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   94: astore 6
    //   96: aload 6
    //   98: aload_1
    //   99: invokevirtual 1594	java/io/OutputStream:write	([B)V
    //   102: aload 6
    //   104: invokevirtual 1597	java/io/OutputStream:flush	()V
    //   107: iload_2
    //   108: ifeq +107 -> 215
    //   111: sipush 128
    //   114: istore 4
    //   116: goto +278 -> 394
    //   119: aload 7
    //   121: iload 4
    //   123: iload 5
    //   125: iconst_0
    //   126: invokestatic 1656	com/tencent/mm/sdk/platformtools/BitmapUtil:extractThumbNail	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +37 -> 168
    //   134: aload_1
    //   135: bipush 90
    //   137: aload_3
    //   138: aload 9
    //   140: iconst_1
    //   141: invokestatic 600	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   144: pop
    //   145: ldc_w 335
    //   148: ldc_w 1652
    //   151: iconst_2
    //   152: anewarray 106	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 7
    //   159: aastore
    //   160: dup
    //   161: iconst_1
    //   162: aload 9
    //   164: aastore
    //   165: invokestatic 467	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 7
    //   170: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   173: ifeq +18 -> 191
    //   176: ldc_w 335
    //   179: ldc_w 1628
    //   182: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload 7
    //   187: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   190: pop
    //   191: aload 6
    //   193: ifnull +8 -> 201
    //   196: aload 6
    //   198: invokevirtual 1629	java/io/OutputStream:close	()V
    //   201: aload 8
    //   203: invokestatic 1806	com/tencent/mm/ay/i:VX	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore_1
    //   207: ldc_w 1815
    //   210: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: aload_1
    //   214: areturn
    //   215: bipush 120
    //   217: istore 4
    //   219: goto +175 -> 394
    //   222: bipush 120
    //   224: istore 5
    //   226: goto -107 -> 119
    //   229: astore_3
    //   230: aconst_null
    //   231: astore_1
    //   232: getstatic 805	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   235: ldc2_w 1234
    //   238: ldc2_w 1657
    //   241: lconst_1
    //   242: iconst_0
    //   243: invokevirtual 1241	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   246: ldc_w 335
    //   249: new 240	java/lang/StringBuilder
    //   252: dup
    //   253: ldc_w 1821
    //   256: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   259: aload 8
    //   261: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc_w 1662
    //   267: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: aload_3
    //   271: invokevirtual 1248	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   274: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 817	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 7
    //   285: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   288: ifeq +18 -> 306
    //   291: ldc_w 335
    //   294: ldc_w 1628
    //   297: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload 7
    //   302: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   305: pop
    //   306: aload_1
    //   307: ifnull +7 -> 314
    //   310: aload_1
    //   311: invokevirtual 1629	java/io/OutputStream:close	()V
    //   314: ldc_w 1815
    //   317: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: aconst_null
    //   321: areturn
    //   322: astore_3
    //   323: aconst_null
    //   324: astore_1
    //   325: aload 7
    //   327: invokestatic 368	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   330: ifeq +18 -> 348
    //   333: ldc_w 335
    //   336: ldc_w 1628
    //   339: invokestatic 774	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: aload 7
    //   344: invokestatic 1501	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   347: pop
    //   348: aload_1
    //   349: ifnull +7 -> 356
    //   352: aload_1
    //   353: invokevirtual 1629	java/io/OutputStream:close	()V
    //   356: ldc_w 1815
    //   359: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aload_3
    //   363: athrow
    //   364: astore_1
    //   365: goto -164 -> 201
    //   368: astore_1
    //   369: goto -55 -> 314
    //   372: astore_1
    //   373: goto -17 -> 356
    //   376: astore_3
    //   377: aload 6
    //   379: astore_1
    //   380: goto -55 -> 325
    //   383: astore_3
    //   384: goto -59 -> 325
    //   387: astore_3
    //   388: aload 6
    //   390: astore_1
    //   391: goto -159 -> 232
    //   394: iload_2
    //   395: ifeq -173 -> 222
    //   398: sipush 128
    //   401: istore 5
    //   403: goto -284 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	this	i
    //   0	406	1	paramArrayOfByte	byte[]
    //   0	406	2	paramBoolean	boolean
    //   0	406	3	paramCompressFormat	Bitmap.CompressFormat
    //   114	104	4	i	int
    //   123	279	5	j	int
    //   94	295	6	localOutputStream	java.io.OutputStream
    //   70	273	7	str1	String
    //   33	227	8	str2	String
    //   47	116	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	96	229	java/lang/Exception
    //   89	96	322	finally
    //   196	201	364	java/lang/Exception
    //   310	314	368	java/lang/Exception
    //   352	356	372	java/lang/Exception
    //   96	107	376	finally
    //   119	130	376	finally
    //   134	168	376	finally
    //   232	283	383	finally
    //   96	107	387	java/lang/Exception
    //   119	130	387	java/lang/Exception
    //   134	168	387	java/lang/Exception
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
      ((HashMap)localObject1).put(Long.valueOf(((g)localObject2).fNu), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150602);
    return localObject1;
  }
  
  public final void blO()
  {
    AppMethodBeat.i(150567);
    Iterator localIterator = d.lOO.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      Cursor localCursor = this.lvy.rawQuery("SELECT max(id) FROM " + localc.table, null, 2);
      AtomicLong localAtomicLong = localc.lON;
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
  
  public final List<g> blP()
  {
    AppMethodBeat.i(150598);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = d.lOO.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (c)localIterator.next();
      localObject = "select * " + " FROM " + ((c)localObject).table;
      localObject = (String)localObject + " WHERE iscomplete= 0 AND totalLen != 0 ";
      localObject = this.lvy.rawQuery((String)localObject, null);
      if (!((Cursor)localObject).moveToFirst()) {
        ((Cursor)localObject).close();
      } else {
        label228:
        for (;;)
        {
          g localg1 = new g();
          localg1.convertFrom((Cursor)localObject);
          g localg2 = wm((int)localg1.localId);
          if (localg2 != null) {
            if ((localg2.fNu != 0L) || (localg2.lNP != 0L)) {
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
            if ((localg1.fNu != 0L) || (localg1.lNP != 0L)) {
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
    AppMethodBeat.i(212961);
    paramString = a(paramString, paramFloat, true);
    AppMethodBeat.o(212961);
    return paramString;
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
    if ((paramString != null) && (this.lOx.containsKey(paramString)))
    {
      localObject = (String)this.lOx.get(paramString);
      AppMethodBeat.o(150633);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = T(paramString, paramBoolean2))
    {
      localObject = str;
      if (Util.isNullOrNil(str)) {
        break;
      }
      this.lOx.put(paramString, str);
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
    String str2 = com.tencent.mm.plugin.image.d.bbX();
    String str3 = "th_";
    String str1;
    if (paramString.startsWith("SERVERID://")) {
      str1 = paramString.substring(11);
    }
    for (;;)
    {
      try
      {
        str1 = GF(Long.valueOf(str1).longValue()).lNH;
        String str5 = com.tencent.mm.plugin.image.d.bbW();
        String str4 = str1;
        if (Util.isNullOrNil(str1)) {
          str4 = paramString;
        }
        paramString = FilePathGenerator.defGenPathWithOld(str5, str2, str3, str4, "", 1);
        AppMethodBeat.o(150572);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        Log.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150572);
        return null;
      }
      if (paramString.startsWith("THUMBNAIL_APPMSG_DIR://"))
      {
        str1 = paramString.substring(29);
        str3 = "msgth_";
        str2 = com.tencent.mm.plugin.ab.a.fmu();
      }
      else
      {
        str1 = "";
      }
    }
  }
  
  public final String r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150571);
    paramString1 = a(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(150571);
    return paramString1;
  }
  
  public final g wl(int paramInt)
  {
    AppMethodBeat.i(150603);
    g localg = b(Long.valueOf(paramInt));
    AppMethodBeat.o(150603);
    return localg;
  }
  
  /* Error */
  public final g wm(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1873
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: i2l
    //   8: lstore_2
    //   9: aload_0
    //   10: lload_2
    //   11: invokestatic 1158	com/tencent/mm/ay/i$d:GG	(J)Ljava/lang/String;
    //   14: aconst_null
    //   15: ldc_w 1875
    //   18: iconst_1
    //   19: anewarray 61	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 1081	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: aastore
    //   29: invokespecial 212	com/tencent/mm/ay/i:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
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
    //   57: new 200	com/tencent/mm/ay/g
    //   60: dup
    //   61: invokespecial 201	com/tencent/mm/ay/g:<init>	()V
    //   64: astore 4
    //   66: aload 5
    //   68: astore 6
    //   70: aload 4
    //   72: aload 5
    //   74: invokevirtual 221	com/tencent/mm/ay/g:convertFrom	(Landroid/database/Cursor;)V
    //   77: aload 4
    //   79: astore 6
    //   81: aload 5
    //   83: ifnull +14 -> 97
    //   86: aload 5
    //   88: invokeinterface 224 1 0
    //   93: aload 4
    //   95: astore 6
    //   97: ldc_w 1873
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
    //   118: ldc_w 335
    //   121: ldc_w 1877
    //   124: iconst_1
    //   125: anewarray 106	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload 7
    //   132: invokevirtual 1768	java/lang/Exception:toString	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 1283	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   179: ldc_w 1873
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
  
  public static final class a
    extends BitmapDrawable
  {
    private a(Resources paramResources, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    public static void a(Bitmap paramBitmap, ImageView paramImageView)
    {
      AppMethodBeat.i(150564);
      if ((paramImageView == null) || (paramImageView.getResources() == null))
      {
        AppMethodBeat.o(150564);
        return;
      }
      paramBitmap = new a(paramImageView.getResources(), paramBitmap);
      if (paramImageView.getLayerType() == 1)
      {
        paramImageView.destroyDrawingCache();
        paramImageView.setLayerType(0, null);
      }
      paramImageView.setImageDrawable(paramBitmap);
      AppMethodBeat.o(150564);
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(150565);
      if ((getBitmap() != null) && (!getBitmap().isRecycled()))
      {
        super.draw(paramCanvas);
        AppMethodBeat.o(150565);
        return;
      }
      if (getBitmap() != null) {
        Log.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", new Object[] { getBitmap().toString() });
      }
      AppMethodBeat.o(150565);
    }
  }
  
  static final class b
  {
    int lOH;
    int lOI;
    int lOJ;
    String url;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      this.lOH = paramInt1;
      this.url = paramString;
      this.lOI = paramInt2;
      this.lOJ = paramInt3;
    }
  }
  
  public static final class c
  {
    String lOK;
    String[] lOL;
    long[] lOM;
    AtomicLong lON;
    String table;
    
    public c(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(210456);
      this.lOM = new long[2];
      this.lON = new AtomicLong(0L);
      this.table = paramString2;
      this.lOK = paramString1;
      this.lOL = paramArrayOfString;
      this.lOM[0] = paramLong1;
      this.lOM[1] = paramLong2;
      this.lON.set(paramLong1);
      AppMethodBeat.o(210456);
    }
  }
  
  public static final class d
  {
    public static final ArrayList<i.c> lOO;
    
    static
    {
      AppMethodBeat.i(223593);
      lOO = new ArrayList(3);
      a("", "ImgInfo2", i.SQL_CREATE, 1L, 1000000000L);
      a("@findermsg", "finder_img_info_table", i.VU("finder_img_info_table"), 1000000001L, 1001000001L);
      a("@gamelifesess", "gamelife_img_info_table", i.VU("gamelife_img_info_table"), 1001000002L, 1002000002L);
      AppMethodBeat.o(223593);
    }
    
    public static String GG(long paramLong)
    {
      AppMethodBeat.i(223590);
      Object localObject = lOO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        i.c localc = (i.c)((Iterator)localObject).next();
        if ((localc.lOM[0] <= paramLong) && (paramLong <= localc.lOM[1]))
        {
          localObject = localc.table;
          AppMethodBeat.o(223590);
          return localObject;
        }
      }
      Log.i("MicroMsg.ImgInfoStorage", "[getTableById] table=%s id=%s", new Object[] { ((i.c)lOO.get(0)).table, Long.valueOf(paramLong) });
      localObject = ((i.c)lOO.get(0)).table;
      AppMethodBeat.o(223590);
      return localObject;
    }
    
    public static AtomicLong We(String paramString)
    {
      AppMethodBeat.i(223578);
      if (paramString == null)
      {
        Log.e("MicroMsg.ImgInfoStorage", "[getIdCreator] talker is null %s", new Object[] { Util.getStack() });
        paramString = ((i.c)lOO.get(0)).lON;
        AppMethodBeat.o(223578);
        return paramString;
      }
      Iterator localIterator = lOO.iterator();
      while (localIterator.hasNext())
      {
        i.c localc = (i.c)localIterator.next();
        if ((!localc.lOK.isEmpty()) && (paramString.toLowerCase().endsWith(localc.lOK)))
        {
          Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { localc.table, paramString });
          paramString = localc.lON;
          AppMethodBeat.o(223578);
          return paramString;
        }
      }
      Log.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { ((i.c)lOO.get(0)).table, paramString });
      paramString = ((i.c)lOO.get(0)).lON;
      AppMethodBeat.o(223578);
      return paramString;
    }
    
    public static String Wf(String paramString)
    {
      AppMethodBeat.i(223584);
      if (paramString == null)
      {
        Log.e("MicroMsg.ImgInfoStorage", "[getTableByTalker] talker is null %s", new Object[] { Util.getStack() });
        paramString = ((i.c)lOO.get(0)).table;
        AppMethodBeat.o(223584);
        return paramString;
      }
      Iterator localIterator = lOO.iterator();
      while (localIterator.hasNext())
      {
        i.c localc = (i.c)localIterator.next();
        if ((!localc.lOK.isEmpty()) && (paramString.toLowerCase().endsWith(localc.lOK)))
        {
          paramString = localc.table;
          AppMethodBeat.o(223584);
          return paramString;
        }
      }
      Log.i("MicroMsg.ImgInfoStorage", "[getTableByTalker] table=%s talker=%s", new Object[] { ((i.c)lOO.get(0)).table, paramString });
      paramString = ((i.c)lOO.get(0)).table;
      AppMethodBeat.o(223584);
      return paramString;
    }
    
    private static void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(223568);
      lOO.add(new i.c(paramString1.toLowerCase(), paramString2, paramArrayOfString, paramLong1, paramLong2));
      AppMethodBeat.o(223568);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.i
 * JD-Core Version:    0.7.0.1
 */