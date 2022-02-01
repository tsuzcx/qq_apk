package com.tencent.mm.modelimage;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Point;
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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.p;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.pointers.PBool;
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
import com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.mm.vfs.z;
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

public final class j
  extends MStorage
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
  public static int oGZ = 0;
  public static int oHk = 150;
  public static long oHl = 0L;
  private MMHandler mRi;
  com.tencent.mm.b.f<String, Bitmap> oHa;
  private com.tencent.mm.b.f<String, String> oHb;
  private List<b> oHc;
  private Map<Integer, WeakReference<ImageView>> oHd;
  private Map<Integer, WeakReference<ImageView>> oHe;
  private Map<Integer, WeakReference<View>> oHf;
  private Set<Integer> oHg;
  private Map<String, String> oHh;
  private FrameLayout.LayoutParams oHi;
  private SoftReference<ColorDrawable> oHj;
  public com.tencent.mm.storagebase.h omV;
  
  public j(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150566);
    this.oHa = new com.tencent.mm.memory.a.b(40, new f.b() {}, getClass());
    this.oHb = new com.tencent.mm.memory.a.c(40);
    this.oHc = new ArrayList();
    this.oHd = new HashMap();
    this.oHe = new HashMap();
    this.oHf = new HashMap();
    this.oHg = new HashSet();
    this.mRi = new MMHandler(Looper.getMainLooper());
    this.oHh = new HashMap();
    this.omV = null;
    this.oHi = new FrameLayout.LayoutParams(-2, -2);
    Iterator localIterator = j.d.oHy.iterator();
    while (localIterator.hasNext()) {
      a(paramh, ((j.c)localIterator.next()).table);
    }
    this.omV = paramh;
    bJH();
    AppMethodBeat.o(150566);
  }
  
  public static String Ew(String paramString)
  {
    AppMethodBeat.i(150573);
    paramString = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString));
    AppMethodBeat.o(150573);
    return paramString;
  }
  
  public static String[] NW(String paramString)
  {
    AppMethodBeat.i(238982);
    String str1 = "CREATE TABLE IF NOT EXISTS " + paramString + " ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen" + " INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid" + " INT, status INT, nettimes INT, reserved1 int  , reserved2" + " int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete" + " INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType" + " INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )";
    String str2 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoIndex ON " + paramString + " ( msgSvrId ) ";
    String str3 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoHdIndex ON " + paramString + " ( reserved1 ) ";
    String str4 = "CREATE INDEX IF NOT EXISTS " + paramString + "msgLocalIdIndex ON " + paramString + " ( msglocalid ) ";
    String str5 = "CREATE INDEX IF NOT EXISTS " + paramString + "iscomplete_index ON " + paramString + " ( iscomplete ) ";
    paramString = "CREATE INDEX IF NOT EXISTS " + paramString + "origImgMD5_index ON " + paramString + " ( origImgMD5 ) ";
    AppMethodBeat.o(238982);
    return new String[] { str1, str2, str3, str4, str5, paramString };
  }
  
  public static long NX(String paramString)
  {
    AppMethodBeat.i(238988);
    long l = j.d.Of(paramString).incrementAndGet();
    AppMethodBeat.o(238988);
    return l;
  }
  
  private static String NZ(String paramString)
  {
    AppMethodBeat.i(239005);
    paramString = "THUMBNAIL_APPMSG_DIR://msgth_".concat(String.valueOf(paramString));
    AppMethodBeat.o(239005);
    return paramString;
  }
  
  /* Error */
  private static String Od(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 278
    //   6: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: getstatic 85	com/tencent/mm/modelimage/j:oHl	J
    //   16: lstore 5
    //   18: lload_3
    //   19: lstore_1
    //   20: lload 5
    //   22: lload_3
    //   23: lcmp
    //   24: ifne +11 -> 35
    //   27: lconst_1
    //   28: invokestatic 289	java/lang/Thread:sleep	(J)V
    //   31: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   34: lstore_1
    //   35: lload_1
    //   36: putstatic 85	com/tencent/mm/modelimage/j:oHl	J
    //   39: new 210	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: lload_1
    //   51: invokevirtual 293	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokevirtual 297	java/lang/String:getBytes	()[B
    //   60: invokestatic 303	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   63: astore_0
    //   64: ldc_w 305
    //   67: ldc_w 307
    //   70: iconst_2
    //   71: anewarray 104	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: lload_1
    //   81: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: aastore
    //   85: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: ldc_w 278
    //   91: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString4, String paramString5, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, q.a parama, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(239025);
    if (paramInt1 == 0)
    {
      paramString2 = a(paramString1, paramString2, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString2 == null)
      {
        AppMethodBeat.o(239025);
        return -1L;
      }
      paramPString.value = paramString2.oGt;
      if (y.ZC(paramString3))
      {
        paramPString = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(paramString2.oGr);
        y.O(paramString3, v(paramPString, "", ""), false);
        paramString2.NU(paramPString);
      }
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(239025);
        return paramLong;
      }
    }
    if (paramInt1 == 1)
    {
      paramString3 = a(paramString1, paramString2, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString3 == null)
      {
        AppMethodBeat.o(239025);
        return -1L;
      }
      paramPString.value = paramString3.oGt;
      paramString3.iP(0L);
      paramString3.gX(0L);
      paramString3.wk((int)y.bEl(v(paramString3.oGr, "", "")));
      paramString2 = a(paramString1, paramString2, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString4, paramString5, paramb2, paramb1, parama, paramInt4);
      if (paramString2 == null)
      {
        AppMethodBeat.o(239025);
        return 0L;
      }
      paramString2.NQ(paramString3.oGr);
      paramString2.NS(paramString3.oGt);
      paramString2.NR(paramString3.oGs);
      paramString2.wk(0);
      long l = this.omV.beginTransaction(Thread.currentThread().getId());
      paramString2.wl((int)a(paramString1, "id", paramString3));
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        Log.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramString2.localId), Long.valueOf(paramString2.oGz), paramString2.oGr, paramString2.oGs, Integer.valueOf(paramString2.osy) });
        if (l > 0L) {
          com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
        }
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(239025);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(239025);
    return 0L;
  }
  
  private Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString3, com.tencent.mm.b.b paramb, int paramInt3)
  {
    AppMethodBeat.i(239044);
    Log.i("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap talker[%s] origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Util.getStack(), paramString3 });
    Bitmap localBitmap2 = (Bitmap)this.oHa.ct(i.NV(paramString2));
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
      str1 = q(paramString1, paramString2, paramInt1);
      if (Util.isNullOrNil(str1)) {
        break label501;
      }
      if (!str1.endsWith("hd")) {
        break label359;
      }
      str2 = str1;
      localBitmap1 = localBitmap2;
      if ((localBitmap1 != null) && (!localBitmap1.isRecycled())) {
        break label498;
      }
      i = LongBitmapHandler.isLongPicture(str2);
      j = BackwardSupportUtil.ExifHelper.getExifOrientation(str2);
      if (i <= 0) {
        break label372;
      }
    }
    label184:
    label350:
    label359:
    label372:
    for (Bitmap localBitmap1 = BitmapUtil.drawBackgroundInNeed(LongBitmapHandler.createLongPictureBitmap(str2, i, j + paramInt2 * 90), str2, paramInt3);; localBitmap1 = BitmapUtil.createThumbBitmap(str2, 120, 120, true, false, paramInt3))
    {
      if (localBitmap1 != null)
      {
        this.oHa.B(i.NV(paramString2), localBitmap1);
        paramPInt1.value = localBitmap1.getWidth();
        paramPInt2.value = localBitmap1.getHeight();
        if (paramBoolean)
        {
          paramPInt1 = str1;
          if (str1 == null) {
            paramPInt1 = q(paramString1, paramString2, paramInt1);
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
            paramb.aAD();
          }
          if ((Util.isNullOrNil(paramString1)) || (!y.ZC(paramString1)) || (y.bEl(paramString1) <= 0L)) {
            break label390;
          }
          y.O(paramString1, paramString3, false);
          Log.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s %s", new Object[] { paramString1, paramString3 });
        }
      }
      AppMethodBeat.o(239044);
      return localBitmap1;
      localBitmap1 = BitmapUtil.getBitmapNative(str1);
      str2 = paramString2;
      break;
    }
    label390:
    if ((!Util.isNullOrNil(paramString1)) && (y.ZC(paramString1))) {
      Log.i("MicroMsg.ImgInfoStorage", "oldThumbFile Length %s", new Object[] { Long.valueOf(y.bEl(paramString1)) });
    }
    for (;;)
    {
      label449:
      try
      {
        if ((Util.isNullOrNil(paramString1)) || (!paramString1.endsWith("hd"))) {
          break label487;
        }
        paramInt1 = 1;
      }
      catch (IOException paramString1) {}
      BitmapUtil.saveBitmapToImage(localBitmap1, paramInt1, Bitmap.CompressFormat.JPEG, paramString3, false);
      Log.i("MicroMsg.ImgInfoStorage", "saveBitmapToImage thumbPath %s", new Object[] { paramString3 });
      break label350;
      break label350;
      label487:
      paramInt1 = 0;
      label498:
      label501:
      while (paramInt1 == 0)
      {
        paramInt1 = 90;
        break label449;
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
        paramString = (Bitmap)this.oHa.ct(str2);
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
          paramString = com.tencent.mm.platformtools.r.Sg(str2);
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
          if (oGZ == 0) {
            oGZ = com.tencent.mm.cd.a.bs(MMApplicationContext.getContext(), c.c.emoji_view_image_size);
          }
          if (m <= oGZ)
          {
            i = n;
            j = m;
            if (n <= oGZ) {}
          }
          else
          {
            if (m <= n) {
              break label714;
            }
            i = n * oGZ / m;
            j = oGZ;
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
                  this.oHa.B(str2, paramString);
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
                i = oGZ;
                j = oGZ;
                break label259;
              }
              j = m * oGZ / n;
              i = oGZ;
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
              paramString = BitmapUtil.getRoundedCornerBitmap(paramBitmap, true, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 3));
              Log.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
              continue;
            }
            paramString = paramBitmap;
            continue;
            paramBitmap = paramString.toString();
            continue;
          }
          Log.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", new Object[] { str2, Boolean.valueOf(y.ZC(str2)) });
          str3 = str1;
        }
      }
    }
  }
  
  private h a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString3, long paramLong, String paramString4, String paramString5, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, q.a parama, int paramInt4)
  {
    AppMethodBeat.i(239082);
    if (!y.ZC(paramString2))
    {
      AppMethodBeat.o(239082);
      return null;
    }
    String str = i.NV(paramString2);
    paramb1 = a(paramString1, paramString2, paramInt1, paramBoolean, paramInt3, paramPInt1, paramPInt2, paramString3, paramString4, paramb1, paramInt4);
    if ((parama != null) && (parama.oGu == paramInt1))
    {
      paramString5 = parama.bJR();
      paramPInt2 = paramString5.oIU;
      paramString3 = paramString5.oIV;
      paramPInt1 = paramString5.oGC;
      paramString4 = paramString5.oIW;
      paramString5 = paramString5.oIX;
      Log.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramString5.value });
      paramString5 = new h();
      paramString5.eQp = -1;
      paramString5.setLocalId(j.d.Of(paramString1).incrementAndGet());
      paramString5.iP(paramLong);
      if (!Util.isNullOrNil(paramPInt1)) {
        paramString5.NT(paramPInt1);
      }
      paramString5.wo(0);
      paramString5.setSource(paramInt2);
      if (paramInt2 != 4) {
        break label580;
      }
      if (paramString2.startsWith(ar.bzP()))
      {
        paramString5.wm(3);
        label240:
        if (paramBoolean)
        {
          paramString5.NQ(paramPInt2.value + ".jpg");
          if (!Util.isNullOrNil(paramString4.value)) {
            paramString5.NR(paramString4.value + ".jpg");
          }
          if (Util.isNullOrNil(paramString5.oGt)) {
            paramString5.NS(paramb1);
          }
          paramString5.wk((int)y.bEl(paramString3.value));
          if (paramString5.osy == 0) {
            Log.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString3.value });
          }
          paramString5.NP(str);
        }
        paramString5.setCreateTime((int)Util.nowSecond());
        paramString5.wp(paramInt1);
        Log.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramString5.osy);
        AppMethodBeat.o(239082);
        return paramString5;
      }
    }
    else
    {
      if ((parama == null) || (parama.oGu == paramInt1)) {
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
      paramString5.wm(2);
      break label240;
      label580:
      paramString5.wm(1);
      break label240;
      label589:
      paramPInt2 = paramb2;
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, com.tencent.mm.b.b paramb, int paramInt3)
  {
    AppMethodBeat.i(239069);
    Log.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString2 });
    if (!y.ZC(paramString2))
    {
      Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(239069);
      return null;
    }
    String str = paramString4;
    if (Util.isNullOrNil(paramString4)) {
      str = bJJ();
    }
    str = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
    paramString4 = a(str, "th_", "", false);
    if (paramb == null) {
      paramString4 = v(str, "th_", "");
    }
    if (paramBoolean)
    {
      if ((!Util.isNullOrNil(paramString3)) && (y.ZC(paramString3))) {
        break label264;
      }
      long l = Util.currentTicks();
      a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, true, paramString4, paramb, paramInt3);
      if (!y.ZC(paramString4)) {
        break label252;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(10921, new Object[] { Long.valueOf(y.bEl(paramString4)), Long.valueOf(y.bEl(paramString2)), Integer.valueOf(90), Long.valueOf(Util.ticksToNow(l)) });
    }
    for (;;)
    {
      Log.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
      AppMethodBeat.o(239069);
      return str;
      label252:
      Log.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
      continue;
      label264:
      y.O(paramString3, paramString4, false);
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(239009);
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.oHc.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (m == localb.oHr)
      {
        Log.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.oHr), localb.url });
        localb.url = paramString;
        if (!this.oHg.contains(Integer.valueOf(k)))
        {
          this.oHg.add(Integer.valueOf(k));
          a(paramString, paramFloat, true, paramInt);
        }
        AppMethodBeat.o(239009);
        return;
      }
    }
    this.oHd.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i = 0;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.oHe.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    int j = 0;
    if (paramView != null)
    {
      j = paramView.hashCode();
      this.oHf.put(Integer.valueOf(j), new WeakReference(paramView));
    }
    paramImageView1 = new b(m, paramString, i, j);
    this.oHc.add(paramImageView1);
    if (!this.oHg.contains(Integer.valueOf(k)))
    {
      this.oHg.add(Integer.valueOf(k));
      a(paramString, paramFloat, true, paramInt);
    }
    AppMethodBeat.o(239009);
  }
  
  private static void a(com.tencent.mm.storagebase.h paramh, String paramString)
  {
    AppMethodBeat.i(238998);
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
      long l = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
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
        com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
      }
      AppMethodBeat.o(238998);
      return;
    }
  }
  
  private void a(final String paramString, final float paramFloat, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(239014);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150562);
        j.this.a(paramString, true, paramFloat, true, false, paramBoolean, paramInt);
        j.a(j.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150561);
            j.a(j.this, j.2.this.oHn);
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
    AppMethodBeat.o(239014);
  }
  
  public static String ah(cc paramcc)
  {
    AppMethodBeat.i(150635);
    if (paramcc == null)
    {
      Log.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      AppMethodBeat.o(150635);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject;
    if (paramcc.field_isSend == 1)
    {
      localObject = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);
      if ((localObject != null) && (((h)localObject).localId != 0L)) {
        break label351;
      }
      localObject = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
    }
    label351:
    for (;;)
    {
      if ((localObject != null) && (com.tencent.mm.kernel.h.baE().isSDCardAvailable()))
      {
        String str;
        if (paramcc.field_isSend == 1)
        {
          paramcc = i.c((h)localObject);
          str = r.bKa().v(paramcc, "", "");
          if ((paramcc != null) && (paramcc.length() > 0) && (y.ZC(str)))
          {
            AppMethodBeat.o(150635);
            return str;
            localObject = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
            continue;
          }
          paramcc = ((h)localObject).oGr;
          localObject = r.bKa().v(paramcc, "", "");
          if ((paramcc != null) && (paramcc.length() > 0) && (y.ZC((String)localObject)))
          {
            AppMethodBeat.o(150635);
            return localObject;
          }
        }
        else if (((h)localObject).bJD())
        {
          str = ((h)localObject).oGr;
          paramcc = str;
          if (((h)localObject).bJE())
          {
            localObject = i.a((h)localObject);
            paramcc = str;
            if (localObject != null)
            {
              paramcc = str;
              if (((h)localObject).localId > 0L)
              {
                paramcc = str;
                if (((h)localObject).bJD())
                {
                  paramcc = str;
                  if (y.ZC(r.bKa().v(((h)localObject).oGr, "", ""))) {
                    paramcc = ((h)localObject).oGr;
                  }
                }
              }
            }
          }
          AppMethodBeat.o(150635);
          return paramcc;
        }
      }
      Log.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      AppMethodBeat.o(150635);
      return null;
    }
  }
  
  private long b(String paramString, h paramh)
  {
    AppMethodBeat.i(239029);
    paramString = j.d.Og(paramString);
    long l = this.omV.jef().insertOrThrow(paramString, "id", paramh.convertTo());
    if (l != -1L) {
      paramh.bJG();
    }
    Log.i("MicroMsg.ImgInfoStorage", "insert img, table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString, Long.valueOf(l), Long.valueOf(paramh.localId), Long.valueOf(paramh.oGz), Long.valueOf(paramh.hTh), Integer.valueOf(paramh.oGB) });
    AppMethodBeat.o(239029);
    return l;
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150608);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
    AppMethodBeat.o(150608);
    return paramString1;
  }
  
  public static String bJJ()
  {
    try
    {
      AppMethodBeat.i(150620);
      String str = Od("");
      AppMethodBeat.o(150620);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h iQ(long paramLong)
  {
    AppMethodBeat.i(150604);
    h localh = new h();
    Cursor localCursor = b("ImgInfo2", null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToFirst()) {
      localh.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(150604);
    return localh;
  }
  
  private h p(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(239022);
    h localh = new h();
    paramString1 = a(j.d.Og(paramString1), null, "origImgMD5=? AND compressType=?", new String[] { String.valueOf(paramString2), String.valueOf(paramInt) });
    if (paramString1.moveToFirst()) {
      localh.convertFrom(paramString1);
    }
    paramString1.close();
    AppMethodBeat.o(239022);
    return localh;
  }
  
  private String q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(239033);
    paramString1 = p(paramString1, i.NV(paramString2), paramInt);
    if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.oGt)))
    {
      paramString1 = X(paramString1.oGt, true);
      if (y.ZC(paramString1))
      {
        AppMethodBeat.o(239033);
        return paramString1;
      }
    }
    AppMethodBeat.o(239033);
    return null;
  }
  
  public final h G(String paramString, long paramLong)
  {
    AppMethodBeat.i(239298);
    h localh = new h();
    paramString = b(j.d.Og(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToFirst()) {
      localh.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(239298);
    return localh;
  }
  
  public final h H(String paramString, long paramLong)
  {
    AppMethodBeat.i(239307);
    h localh = new h();
    paramString = b(j.d.Og(paramString), null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToLast()) {
      localh.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(239307);
    return localh;
  }
  
  public final String NY(String paramString)
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
        paramString = wq(Integer.valueOf(paramString).intValue()).oGt;
        paramString = v(paramString, str1, "");
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
  
  public final Bitmap Oa(String paramString)
  {
    AppMethodBeat.i(150592);
    float f = com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext());
    paramString = BitmapUtil.getBitmapNative(d(paramString, false, true), f);
    AppMethodBeat.o(150592);
    return paramString;
  }
  
  public final String Ob(String paramString)
  {
    AppMethodBeat.i(150615);
    paramString = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString)), "th_", "", false);
    AppMethodBeat.o(150615);
    return paramString;
  }
  
  public final String Oc(String paramString)
  {
    AppMethodBeat.i(150616);
    paramString = a(paramString, "", ".jpg", false);
    AppMethodBeat.o(150616);
    return paramString;
  }
  
  public final String Oe(String paramString)
  {
    AppMethodBeat.i(369575);
    paramString = d(paramString, false, true);
    AppMethodBeat.o(369575);
    return paramString;
  }
  
  public final String X(String paramString, boolean paramBoolean)
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
        paramString = wq(Integer.valueOf(paramString).intValue()).oGt;
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
  
  public final int a(int paramInt, h paramh)
  {
    AppMethodBeat.i(150627);
    paramInt = a(Long.valueOf(paramInt), paramh);
    AppMethodBeat.o(150627);
    return paramInt;
  }
  
  public final int a(Long paramLong, h paramh)
  {
    AppMethodBeat.i(150628);
    long l = System.currentTimeMillis();
    ContentValues localContentValues = paramh.convertTo();
    if (localContentValues.size() == 0) {}
    for (int i = 1;; i = this.omV.update(j.d.iR(paramLong.longValue()), localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      Log.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString(), Integer.valueOf(i) });
      if (i != -1)
      {
        paramh.bJG();
        doNotify();
      }
      AppMethodBeat.o(150628);
      return i;
    }
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, q.a parama, int paramInt4)
  {
    AppMethodBeat.i(239329);
    paramLong = a(paramString1, paramString2, null, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, paramString3, paramString4, paramLong, paramb1, paramb2, parama, false, paramInt4);
    AppMethodBeat.o(239329);
    return paramLong;
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(239328);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, 0, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, 0);
    AppMethodBeat.o(239328);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, h paramh)
  {
    AppMethodBeat.i(239333);
    paramString1 = j.d.Og(paramString1);
    long l = this.omV.insert(paramString1, paramString2, paramh.convertTo());
    if (l != -1L) {
      paramh.bJG();
    }
    Log.i("MicroMsg.ImgInfoStorage", "insert img,table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString1, Long.valueOf(l), Long.valueOf(paramh.localId), Long.valueOf(paramh.oGz), Long.valueOf(paramh.hTh), Integer.valueOf(paramh.oGB) });
    AppMethodBeat.o(239333);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(239324);
    long l = a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, true, 0);
    AppMethodBeat.o(239324);
    return l;
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, int paramInt, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(239381);
    String str1 = "SERVERID://".concat(String.valueOf(paramLong));
    String str2 = com.tencent.mm.b.g.getMessageDigest(str1.getBytes());
    String str3 = v(str2, "th_", "");
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
      paramArrayOfByte = new h();
      if (!Util.isNullOrNil(paramString2))
      {
        paramArrayOfByte.wj(paramInt);
        paramArrayOfByte.wk(paramInt);
        paramArrayOfByte.eQp = -1;
        paramArrayOfByte.setLocalId(j.d.Of(paramString1).incrementAndGet());
        paramArrayOfByte.NQ(paramString2);
        paramArrayOfByte.NS("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2)));
        paramPString.value = paramArrayOfByte.oGt;
        if (paramBoolean)
        {
          paramArrayOfByte.gX(0L);
          paramArrayOfByte.wp(1);
          paramArrayOfByte.NT(paramString3);
          paramArrayOfByte.setCreateTime((int)Util.nowSecond());
          paramLong = a(paramString1, "id", paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          AppMethodBeat.o(239381);
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
        paramArrayOfByte.gX(paramLong);
        paramArrayOfByte.wp(0);
        continue;
        paramString2 = str1;
      }
    }
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(239375);
    paramLong = a(paramString1, paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString2, paramPString, paramPInt1, paramPInt2);
    AppMethodBeat.o(239375);
    return paramLong;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150607);
    paramString1 = this.omV.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    AppMethodBeat.o(150607);
    return paramString1;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150630);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from".concat(String.valueOf(paramLong));; str = "location_backgroup_key_tor".concat(String.valueOf(paramLong)))
    {
      Bitmap localBitmap2 = (Bitmap)this.oHa.ct(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BitmapUtil.createLocation(paramString, paramInt1, paramInt2, paramInt3);
        this.oHa.B(str, localBitmap1);
      }
      AppMethodBeat.o(150630);
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, int paramInt)
  {
    AppMethodBeat.i(239263);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(239263);
      return null;
    }
    String str = paramString.trim();
    paramString = (Bitmap)this.oHa.ct(str);
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
      j = Math.round(oHk * paramFloat);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label305;
      }
      Log.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 188L, 1L, false);
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
      this.oHa.B(str, localObject);
    }
    for (;;)
    {
      for (;;)
      {
        AppMethodBeat.o(239263);
        return localObject;
        label277:
        i = Math.round(oHk * paramFloat);
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
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 188L, 1L, false);
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
  
  public final String a(String paramString, h paramh)
  {
    Object localObject = null;
    AppMethodBeat.i(239278);
    if (paramh == null)
    {
      AppMethodBeat.o(239278);
      return null;
    }
    if (paramh.bJE())
    {
      paramString = j.d.Og(paramString);
      paramh = paramh.oGB;
      paramh = b(paramString, new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { paramh });
      paramString = localObject;
      if (paramh.moveToFirst()) {
        paramString = paramh.getString(0);
      }
      paramh.close();
      AppMethodBeat.o(239278);
      return paramString;
    }
    AppMethodBeat.o(239278);
    return null;
  }
  
  public final String a(String paramString1, String paramString2, int paramInt1, PString paramPString, PInt paramPInt1, PInt paramPInt2, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(239351);
    if (!y.ZC(paramString2))
    {
      Log.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(239351);
      return null;
    }
    String str1 = paramString3;
    if (Util.isNullOrNil(paramString3)) {
      str1 = bJJ();
    }
    String str2 = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
    paramString3 = a(str2, "th_", "", false);
    paramPString.value = str2;
    long l = Util.currentTicks();
    paramPInt1 = a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, false, null, null, -1);
    paramString1 = (String)this.oHb.get(paramString2);
    if (paramString1 != null) {}
    for (paramString1 = (Bitmap)this.oHa.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramPString = paramString1;
        if (!paramString1.isRecycled()) {}
      }
      else
      {
        paramPString = a(paramString2, true, com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()), false, false, true, paramInt3, true, paramPInt1);
        this.oHb.put(paramString2, paramString3);
      }
      if (paramPString != null) {
        this.oHa.B(paramString3, paramPString);
      }
      Log.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      AppMethodBeat.o(239351);
      return str1;
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString4, com.tencent.mm.b.b paramb, int paramInt2)
  {
    AppMethodBeat.i(239372);
    localObject = paramString4;
    if (Util.isNullOrNil(paramString4))
    {
      localObject = Od(paramString2);
      Log.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", new Object[] { localObject, paramString2 });
    }
    paramString4 = a((String)localObject, "", ".jpg", false);
    if (paramb == null) {
      paramString4 = a((String)localObject, "", ".jpg", true);
    }
    if (paramInt1 == 1)
    {
      i = 1;
      if ((!((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).dxO()) || (i != 0)) {
        break label336;
      }
      k = 1;
      label115:
      str = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).anI(paramString4);
      Log.i("MicroMsg.ImgInfoStorage", "fullPath is %s", new Object[] { paramString4 });
      if (y.bEl(paramString4) > 0L)
      {
        Log.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
        com.tencent.mm.plugin.report.service.h.OAn.kJ(944, 8);
      }
      paramPString1.value = ((String)localObject);
      paramPString2.value = paramString4;
      if ((!paramBoolean) || (Util.isNullOrNil(paramString3)) || (paramInt1 != 0)) {
        break label401;
      }
      paramString1 = p(paramString1, paramString3, paramInt1);
      if ((paramString1 == null) || (Util.isNullOrNil(paramString1.oGr))) {
        break label401;
      }
      paramString3 = v(paramString1.oGr, "", "");
      if (paramb != null) {
        paramb.aAD();
      }
      y.O(paramString3, paramString4, false);
      if (y.bEl(paramString3) <= 0L) {
        break label379;
      }
      if (k != 0)
      {
        paramString3 = BitmapUtil.getImageOptions(paramString4);
        if ((paramString3 != null) && (paramString3.outWidth > 0) && (paramString3.outHeight > 0)) {
          break label342;
        }
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString1.oGC)) {
        break label371;
      }
      paramString1 = paramString1.oGC;
      AppMethodBeat.o(239372);
      return paramString1;
      i = 0;
      break;
      label336:
      k = 0;
      break label115;
      label342:
      ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).i(paramString2, str, paramString3.outWidth, paramString3.outHeight);
    }
    label371:
    AppMethodBeat.o(239372);
    return null;
    label379:
    Log.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString2, paramString4 });
    label401:
    i5 = c.bJy();
    paramString1 = c.bJz();
    i = paramString1.x;
    j = paramString1.y;
    try
    {
      m = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("UseOptImage"), 0);
      com.tencent.mm.kernel.h.baC();
      paramString1 = new p(com.tencent.mm.kernel.b.getUin());
      if ((int)(paramString1.longValue() / 100L) % 100 + 1 > m) {
        break label3437;
      }
      bool1 = true;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        int m;
        int i4;
        Log.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { Util.stackTraceToString(paramString1) });
        boolean bool1 = false;
        continue;
        paramBoolean = false;
        continue;
        paramString1 = new c.a();
        localObject = c.bJz();
        i = ((Point)localObject).x;
        j = ((Point)localObject).y;
        localObject = BitmapUtil.getImageOptions(paramString2);
        int i6;
        int i7;
        long l3;
        boolean bool3;
        long l4;
        long l1;
        long l2;
        long l5;
        boolean bool2;
        if ((localObject == null) || (((BitmapFactory.Options)localObject).outWidth == 0) || (((BitmapFactory.Options)localObject).outHeight == 0))
        {
          if (localObject == null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            Log.w("MicroMsg.C2CImageUtil", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString2, Boolean.valueOf(paramBoolean) });
            i6 = paramString1.oFY;
            i7 = paramString1.oFZ;
            i2 = paramString1.height;
            i3 = paramString1.width;
            paramString1 = paramString3.outMimeType;
            l3 = y.bEl(paramString2);
            bool3 = MMNativeJpeg.IsJpegFile(paramString2);
            if ((paramString1 == null) || ((!paramString1.endsWith("jpeg")) && (!paramString1.endsWith("jpg")) && (!paramString1.endsWith("bmp")) && (!paramString1.endsWith("png")) && (!paramString1.endsWith("gif")))) {
              break;
            }
            n = 1;
            Log.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d], fileSize:%s, mime:%s", new Object[] { Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(l3), paramString1 });
            if ((paramInt1 != 0) || (l3 <= c.bJx())) {
              break label1819;
            }
            if ((i4 >= 55) && (bool3)) {
              break label3413;
            }
            paramBoolean = false;
            if (!paramBoolean) {
              break label1792;
            }
            i = 18;
            l4 = Util.currentTicks();
            if (y.bEl(str) > 0L)
            {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(944, 9);
              y.deleteFile(str);
            }
            if (paramb != null) {
              paramb.aAD();
            }
            paramString1 = new PBool();
            paramString1.value = paramBoolean;
            if (k == 0) {
              break label1799;
            }
            l1 = 0L;
            l2 = Util.currentTicks();
            int i8 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).i(paramString2, str, i3, i2);
            l5 = Util.ticksToNow(l2);
            j = 0;
            if (i8 != 0) {
              break label3407;
            }
            l1 = Util.currentTicks();
            i1 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).nativeWxam2Pic(str, paramString4);
            l2 = Util.ticksToNow(l1);
            j = i1;
            l1 = l2;
            if (i1 != 0) {
              break label3407;
            }
            bool1 = true;
            l1 = l2;
            j = i1;
            Log.i("MicroMsg.C2CImageUtil", "origToWxamToJpg: result:%s hevc:%s, %s; jpg:%s, %s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i8), Long.valueOf(l5), Integer.valueOf(j), Long.valueOf(l1) });
            paramBoolean = bool1;
            if (!bool1)
            {
              paramBoolean = c.a(paramString2, paramString4, i3, i2, paramString1, i5, paramInt2);
              paramInt2 = 0;
              if (paramBoolean) {
                paramInt2 = ((com.tencent.mm.plugin.emoji.c.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.emoji.c.c.class)).gG(paramString4, str);
              }
              Log.i("MicroMsg.C2CImageUtil", "origToJpgToWxam: result:%s, hevc:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
            }
            bool2 = paramString1.value;
            Log.i("MicroMsg.ImgInfoStorage", "genBigImg: cost %s, compress:%s, opt:%s", new Object[] { Long.valueOf(Util.ticksToNow(l4)), Integer.valueOf(i5), Boolean.valueOf(bool2) });
            l1 = y.bEl(paramString4);
            Log.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l3), Long.valueOf(l1), Long.valueOf(100L * l1 / l3), Integer.valueOf(m), paramString4 });
            if ((n == 0) || ((l3 - l1) * 100L >= m * l3)) {
              break label3393;
            }
            z.qr(paramString2, paramString4);
            if (k != 0) {
              c.bF(paramString4, str);
            }
            bool1 = true;
            paramBoolean = false;
            i = 48;
            paramInt2 = 1;
            l1 = Util.ticksToNow(l4);
            if (bool1) {
              break label2269;
            }
            com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 187L, 1L, false);
            Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString2 });
            AppMethodBeat.o(239372);
            return null;
          }
        }
        paramString1.oFY = ((BitmapFactory.Options)localObject).outWidth;
        paramString1.oFZ = ((BitmapFactory.Options)localObject).outHeight;
        int i2 = ((BitmapFactory.Options)localObject).outWidth;
        int i3 = ((BitmapFactory.Options)localObject).outHeight;
        int n = Math.max(i2, i3);
        int i1 = Math.min(i2, i3);
        float f;
        if (j > 0)
        {
          f = j * 1.0F / i1;
          if (f >= 1.0F) {
            break label3420;
          }
          j = (int)(i3 * f);
          i = (int)(i2 * f);
        }
        for (;;)
        {
          i1 = i;
          n = j;
          if (i * j > 10240000)
          {
            f = (float)Math.sqrt(10240000.0D / (i2 * i3));
            n = (int)(i3 * f);
            i1 = (int)(i2 * f);
          }
          paramString1.width = i1;
          paramString1.height = n;
          paramString1.scale = f;
          break;
          f = i * 1.0F / n;
          break label1673;
          n = 0;
          break label987;
          i = 8;
          break label1084;
          paramBoolean = c.a(paramString2, paramString4, i3, i2, paramString1, i5, paramInt2);
          break label1384;
          Log.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i4), Long.valueOf(l3), Integer.valueOf(i6), Integer.valueOf(i7) });
          if (n != 0)
          {
            if (Build.VERSION.SDK_INT < 30) {
              break label3388;
            }
            paramString1 = ScopedStorageUtil.MediaStoreOps.imagePathToUri(MMApplicationContext.getContext(), paramString2);
            if (paramString1 == null) {
              break label3388;
            }
          }
          for (paramString1 = paramString1.toString();; paramString1 = paramString2)
          {
            z.qr(paramString1, paramString4);
            if (k != 0) {
              c.bF(paramString4, str);
            }
            k.bHW();
            if (com.tencent.mm.modelcdntran.g.vV(256))
            {
              if (paramInt1 != 1) {
                break label3298;
              }
              i = 0;
            }
            for (;;)
            {
              for (;;)
              {
                try
                {
                  j = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("CompressMidPicLevel")).intValue();
                  i = j;
                }
                catch (Exception paramString1)
                {
                  continue;
                  continue;
                  m = i2;
                  continue;
                  j = i3;
                  continue;
                  i = j;
                  continue;
                }
                try
                {
                  j = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("CompressMidPicSize")).intValue();
                  Log.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
                  if (i > 10)
                  {
                    k = i;
                    if (i <= 100) {}
                  }
                  else
                  {
                    k = 52;
                  }
                  if ((j > 0) && (j <= 800)) {
                    continue;
                  }
                  i = 800;
                  if (i3 <= i) {
                    continue;
                  }
                  j = i;
                  if (i2 <= i) {
                    continue;
                  }
                  m = i;
                  bool1 = true;
                  paramBoolean = bool1;
                  if (i4 != 0)
                  {
                    paramBoolean = bool1;
                    if (i4 <= k) {
                      paramBoolean = false;
                    }
                  }
                  if ((paramBoolean) || (l3 > 800L) || ((paramString3 != null) && ((i7 > i) || (i6 > i))))
                  {
                    paramPString3.value = Od(paramString2);
                    paramPString4.value = a(paramPString3.value, "", ".jpg", false);
                    paramInt2 = BitmapUtil.createThumbNailMayUseOpt(false, paramString2, m, j, Bitmap.CompressFormat.JPEG, k, paramPString4.value, paramb, paramInt2);
                    Log.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.FALSE, Integer.valueOf(paramInt2), Integer.valueOf(m), Integer.valueOf(j) });
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
                    l2 = y.bEl(paramString4);
                    i1 = MMNativeJpeg.queryQuality(paramString4);
                    bool2 = MMNativeJpeg.IsJpegFile(paramString4);
                    paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
                    if (!bool3) {
                      continue;
                    }
                    m = 1;
                    paramString1.b(11713, new Object[] { Integer.valueOf(paramInt2), Long.valueOf(l1), Integer.valueOf(i), Integer.valueOf(m), Long.valueOf(l3), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(paramInt1), Long.valueOf(l2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i4), Integer.valueOf(i1) });
                    Log.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i4), Long.valueOf(l3), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Long.valueOf(l2), Boolean.valueOf(bool2), paramString2, paramString4 });
                    if ((paramInt1 == 0) && (l2 >= 40960L) && (bool2) && (!MMNativeJpeg.isProgressive(paramString4)))
                    {
                      paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("EnableCDNUploadImg");
                      if ((!Util.isNullOrNil(paramString1)) && (paramString1.equals("1")))
                      {
                        l1 = Util.nowMilliSecond();
                        if (!paramBoolean) {
                          continue;
                        }
                        i = 19;
                        paramString1 = paramString4 + ".prog";
                        y.O(paramString4, paramString1, false);
                        bool1 = ImageOptimLib.convertToProgressive(paramString1, paramString4, i5);
                        y.deleteFile(paramString1);
                        if (bool1) {
                          continue;
                        }
                        i = 29;
                        bool1 = MMNativeJpeg.convertToProgressive(paramString4, i5);
                        l4 = Util.nowMilliSecond();
                        l5 = y.bEl(paramString4);
                        paramString1 = com.tencent.mm.plugin.report.service.h.OAn;
                        if (!bool1) {
                          continue;
                        }
                        m = 1;
                        if (!bool3) {
                          continue;
                        }
                        n = 1;
                        paramString1.b(11713, new Object[] { Integer.valueOf(m), Long.valueOf(l4 - l1), Integer.valueOf(i), Integer.valueOf(n), Long.valueOf(l3), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(paramInt1), Long.valueOf(l2), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i4), Integer.valueOf(i1), Long.valueOf(l5) });
                        Log.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i4), Long.valueOf(l3), Boolean.valueOf(bool3), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Long.valueOf(l2), Boolean.valueOf(bool2), paramString2, paramString4 });
                        if (!bool1)
                        {
                          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 186L, 1L, false);
                          Log.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString4 });
                        }
                      }
                    }
                    AppMethodBeat.o(239372);
                    return null;
                    if (!BitmapUtil.convertImageFile(new u(paramString2), new u(paramString4), Bitmap.CompressFormat.JPEG))
                    {
                      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(111L, 187L, 1L, false);
                      Log.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString2 });
                      AppMethodBeat.o(239372);
                      return null;
                    }
                    if (k == 0) {
                      break;
                    }
                    c.bF(paramString4, str);
                  }
                }
                catch (Exception paramString1)
                {
                  j = 0;
                  continue;
                  paramPString3.value = paramPString1.value;
                  paramPString4.value = paramPString2.value;
                  Log.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i7), Integer.valueOf(i6), Integer.valueOf(m), Integer.valueOf(j), paramPString3.value, paramPString4.value });
                  l1 = 0L;
                  i = 38;
                  paramInt2 = 1;
                  paramBoolean = false;
                }
              }
              Log.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
              l1 = 0L;
              i = 38;
              paramInt2 = 1;
              paramBoolean = false;
              continue;
              j = -1;
              continue;
              k = -1;
              continue;
              m = 2;
              continue;
              i = 9;
              bool1 = MMNativeJpeg.convertToProgressive(paramString4, i5);
              continue;
              m = -1;
              continue;
              n = 2;
            }
          }
          paramInt2 = 0;
          bool1 = paramBoolean;
          paramBoolean = bool2;
          break label1550;
          bool1 = false;
          break label1248;
          paramBoolean = bool1;
          break label1075;
          i = i2;
          j = i3;
        }
        continue;
        continue;
        bool1 = false;
      }
    }
    Log.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(m), Long.valueOf(paramString1.longValue()), Long.valueOf(paramString1.longValue() / 100L), Boolean.valueOf(CrashReportFactory.hasDebuger()), Integer.valueOf(Build.VERSION.SDK_INT) });
    if (CrashReportFactory.hasDebuger()) {
      bool1 = true;
    }
    if (com.tencent.mm.compatible.util.d.rc(16))
    {
      bool1 = false;
      Log.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      m = Util.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("PicCompressAvoidanceRemainderPerc"), 10);
      if ((m <= 0) || (m >= 100))
      {
        m = 10;
        i4 = MMNativeJpeg.queryQuality(paramString2);
        Log.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d] ", new Object[] { paramString2, paramString4, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(m) });
        if (paramBoolean)
        {
          paramString3 = BitmapUtil.getImageOptions(paramString2);
          if ((paramString3 == null) || (paramString3.outWidth == 0) || (paramString3.outHeight == 0)) {
            if (paramString3 == null)
            {
              paramBoolean = true;
              Log.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString2, Boolean.valueOf(paramBoolean) });
              AppMethodBeat.o(239372);
              return null;
            }
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
          str1 = iQ(Long.valueOf(str1).longValue()).oGr;
          str2 = com.tencent.mm.plugin.image.d.bzM();
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = str2;
            if (paramString2 != null)
            {
              str3 = str2;
              if (paramString2.equals("msgth_")) {
                str3 = com.tencent.mm.plugin.openapi.a.gxi();
              }
            }
            String str4 = com.tencent.mm.plugin.image.d.bzL();
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
          str2 = com.tencent.mm.plugin.openapi.a.gxi();
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
    String str1 = bJJ();
    String str2 = v(str1, "th_", "");
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
    //   0: ldc_w 1612
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1596	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 305
    //   16: ldc_w 1598
    //   19: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1612
    //   25: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 763	com/tencent/mm/modelimage/j:bJJ	()Ljava/lang/String;
    //   38: astore 16
    //   40: aload_0
    //   41: aload 16
    //   43: ldc_w 765
    //   46: ldc_w 356
    //   49: invokevirtual 360	com/tencent/mm/modelimage/j:v	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 17
    //   54: new 210	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   61: aload 17
    //   63: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1614
    //   69: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 15
    //   77: ldc_w 305
    //   80: ldc_w 1616
    //   83: aload 17
    //   85: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1285	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1617	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1620	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1623	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aconst_null
    //   124: astore 13
    //   126: aload 15
    //   128: iconst_0
    //   129: invokestatic 1627	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   132: astore 12
    //   134: aload 12
    //   136: astore 13
    //   138: aload 12
    //   140: aload_1
    //   141: invokevirtual 1632	java/io/OutputStream:write	([B)V
    //   144: aload 12
    //   146: astore 13
    //   148: aload 12
    //   150: invokevirtual 1635	java/io/OutputStream:flush	()V
    //   153: aload 12
    //   155: astore 13
    //   157: aload_1
    //   158: iload_3
    //   159: iload 4
    //   161: invokestatic 1636	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
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
    //   191: ldc_w 1637
    //   194: if_icmple +534 -> 728
    //   197: new 1639	java/io/ByteArrayOutputStream
    //   200: dup
    //   201: invokespecial 1640	java/io/ByteArrayOutputStream:<init>	()V
    //   204: astore 14
    //   206: aload 14
    //   208: astore 13
    //   210: aload 19
    //   212: aload_2
    //   213: bipush 100
    //   215: aload 14
    //   217: invokevirtual 1644	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   220: pop
    //   221: aload 14
    //   223: astore 13
    //   225: aload 14
    //   227: invokevirtual 1647	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   230: arraylength
    //   231: istore 4
    //   233: bipush 100
    //   235: istore_3
    //   236: aload 14
    //   238: astore 13
    //   240: iload_3
    //   241: istore 7
    //   243: aload 14
    //   245: invokevirtual 1647	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   248: arraylength
    //   249: ldc_w 1637
    //   252: if_icmple +64 -> 316
    //   255: iload_3
    //   256: bipush 15
    //   258: if_icmplt +58 -> 316
    //   261: aload 14
    //   263: astore 13
    //   265: iload_3
    //   266: istore 7
    //   268: aload 14
    //   270: invokevirtual 1650	java/io/ByteArrayOutputStream:reset	()V
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
    //   290: invokevirtual 1644	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   293: pop
    //   294: aload 14
    //   296: astore 13
    //   298: iload_3
    //   299: istore 7
    //   301: aload 14
    //   303: invokevirtual 1647	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   306: arraylength
    //   307: istore 8
    //   309: iload 8
    //   311: istore 4
    //   313: goto -77 -> 236
    //   316: aload 12
    //   318: astore 13
    //   320: aload 14
    //   322: invokevirtual 1651	java/io/ByteArrayOutputStream:close	()V
    //   325: aload 12
    //   327: astore 13
    //   329: aload 19
    //   331: iload_3
    //   332: aload_2
    //   333: aload 17
    //   335: iconst_1
    //   336: invokestatic 573	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   339: pop
    //   340: aload 12
    //   342: astore 13
    //   344: ldc_w 305
    //   347: ldc_w 1653
    //   350: iconst_3
    //   351: anewarray 104	java/lang/Object
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
    //   367: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   370: aastore
    //   371: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload 12
    //   376: astore 13
    //   378: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   381: sipush 16498
    //   384: bipush 10
    //   386: anewarray 104	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: aload 5
    //   393: invokestatic 1656	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   396: ldc_w 1658
    //   399: invokestatic 1664	com/tencent/mm/compatible/util/r:as	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   402: aastore
    //   403: dup
    //   404: iconst_1
    //   405: iload 6
    //   407: invokestatic 470	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   410: aastore
    //   411: dup
    //   412: iconst_2
    //   413: iload 9
    //   415: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: aastore
    //   419: dup
    //   420: iconst_3
    //   421: aload 18
    //   423: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   426: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   429: aastore
    //   430: dup
    //   431: iconst_4
    //   432: aload 18
    //   434: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   437: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: dup
    //   442: iconst_5
    //   443: iload 4
    //   445: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aastore
    //   449: dup
    //   450: bipush 6
    //   452: aload 19
    //   454: invokevirtual 538	android/graphics/Bitmap:getHeight	()I
    //   457: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: aastore
    //   461: dup
    //   462: bipush 7
    //   464: aload 19
    //   466: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   469: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   472: aastore
    //   473: dup
    //   474: bipush 8
    //   476: iconst_0
    //   477: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: aastore
    //   481: dup
    //   482: bipush 9
    //   484: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   487: lload 10
    //   489: lsub
    //   490: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   493: aastore
    //   494: invokevirtual 785	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   497: aload 15
    //   499: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   502: ifeq +18 -> 520
    //   505: ldc_w 305
    //   508: ldc_w 1666
    //   511: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload 15
    //   516: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   519: pop
    //   520: aload 12
    //   522: ifnull +8 -> 530
    //   525: aload 12
    //   527: invokevirtual 1667	java/io/OutputStream:close	()V
    //   530: ldc 198
    //   532: aload 16
    //   534: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   537: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   540: astore_1
    //   541: ldc_w 1612
    //   544: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   547: aload_1
    //   548: areturn
    //   549: astore 13
    //   551: goto -226 -> 325
    //   554: astore 13
    //   556: aconst_null
    //   557: astore 14
    //   559: aload 14
    //   561: astore 13
    //   563: ldc_w 305
    //   566: ldc_w 1669
    //   569: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: iload 7
    //   574: istore_3
    //   575: iload 8
    //   577: istore 4
    //   579: aload 14
    //   581: ifnull -256 -> 325
    //   584: aload 12
    //   586: astore 13
    //   588: aload 14
    //   590: invokevirtual 1651	java/io/ByteArrayOutputStream:close	()V
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
    //   631: invokevirtual 1651	java/io/ByteArrayOutputStream:close	()V
    //   634: aload 12
    //   636: astore 13
    //   638: ldc_w 1612
    //   641: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   644: aload 12
    //   646: astore 13
    //   648: aload 5
    //   650: athrow
    //   651: astore 13
    //   653: aload 12
    //   655: astore 5
    //   657: aload 13
    //   659: astore 12
    //   661: ldc_w 305
    //   664: ldc_w 1607
    //   667: iconst_1
    //   668: anewarray 104	java/lang/Object
    //   671: dup
    //   672: iconst_0
    //   673: aload 12
    //   675: aastore
    //   676: invokestatic 664	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: aload_0
    //   680: aload_1
    //   681: iconst_1
    //   682: aload_2
    //   683: invokevirtual 1610	com/tencent/mm/modelimage/j:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   686: astore_1
    //   687: aload 15
    //   689: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   692: ifeq +18 -> 710
    //   695: ldc_w 305
    //   698: ldc_w 1666
    //   701: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 15
    //   706: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   709: pop
    //   710: aload 5
    //   712: ifnull +8 -> 720
    //   715: aload 5
    //   717: invokevirtual 1667	java/io/OutputStream:close	()V
    //   720: ldc_w 1612
    //   723: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_1
    //   727: areturn
    //   728: aload 12
    //   730: astore 13
    //   732: aload 15
    //   734: aload 17
    //   736: invokestatic 1672	com/tencent/mm/vfs/y:qn	(Ljava/lang/String;Ljava/lang/String;)Z
    //   739: pop
    //   740: iload 7
    //   742: istore_3
    //   743: iload 8
    //   745: istore 4
    //   747: goto -407 -> 340
    //   750: astore 5
    //   752: aload 12
    //   754: astore 13
    //   756: ldc_w 305
    //   759: ldc_w 1607
    //   762: iconst_1
    //   763: anewarray 104	java/lang/Object
    //   766: dup
    //   767: iconst_0
    //   768: aload 5
    //   770: aastore
    //   771: invokestatic 664	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   774: aload 12
    //   776: astore 13
    //   778: aload_0
    //   779: aload_1
    //   780: iconst_1
    //   781: aload_2
    //   782: invokevirtual 1610	com/tencent/mm/modelimage/j:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   785: astore_1
    //   786: aload 15
    //   788: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   791: ifeq +18 -> 809
    //   794: ldc_w 305
    //   797: ldc_w 1666
    //   800: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: aload 15
    //   805: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   808: pop
    //   809: aload 12
    //   811: ifnull +8 -> 819
    //   814: aload 12
    //   816: invokevirtual 1667	java/io/OutputStream:close	()V
    //   819: ldc_w 1612
    //   822: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   825: aload_1
    //   826: areturn
    //   827: astore_1
    //   828: aconst_null
    //   829: astore 13
    //   831: aload 15
    //   833: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   836: ifeq +18 -> 854
    //   839: ldc_w 305
    //   842: ldc_w 1666
    //   845: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   848: aload 15
    //   850: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   853: pop
    //   854: aload 13
    //   856: ifnull +8 -> 864
    //   859: aload 13
    //   861: invokevirtual 1667	java/io/OutputStream:close	()V
    //   864: ldc_w 1612
    //   867: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	945	0	this	j
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
    //   0: ldc_w 1674
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1596	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 305
    //   16: ldc_w 1598
    //   19: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1674
    //   25: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 763	com/tencent/mm/modelimage/j:bJJ	()Ljava/lang/String;
    //   38: astore 17
    //   40: aload_0
    //   41: aload 17
    //   43: ldc_w 765
    //   46: ldc_w 356
    //   49: invokevirtual 360	com/tencent/mm/modelimage/j:v	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 19
    //   54: new 210	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   61: aload 19
    //   63: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1614
    //   69: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 16
    //   77: ldc_w 305
    //   80: ldc_w 1616
    //   83: aload 19
    //   85: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1285	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1617	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1620	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1623	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aload 18
    //   125: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   128: istore 7
    //   130: aload 18
    //   132: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   135: istore 6
    //   137: sipush 720
    //   140: iload 7
    //   142: if_icmpgt +13 -> 155
    //   145: ldc_w 1675
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
    //   165: invokestatic 1627	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   168: astore 12
    //   170: aload 12
    //   172: astore 13
    //   174: aload 12
    //   176: aload_1
    //   177: invokevirtual 1632	java/io/OutputStream:write	([B)V
    //   180: aload 12
    //   182: astore 13
    //   184: aload 12
    //   186: invokevirtual 1635	java/io/OutputStream:flush	()V
    //   189: aload 12
    //   191: astore 13
    //   193: aload_1
    //   194: iload 5
    //   196: iload 6
    //   198: invokestatic 1636	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   201: astore 14
    //   203: aload 12
    //   205: astore 13
    //   207: iload 5
    //   209: aload 14
    //   211: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   214: if_icmpeq +240 -> 454
    //   217: aload 12
    //   219: astore 13
    //   221: aload 14
    //   223: iload 5
    //   225: iload 6
    //   227: iconst_1
    //   228: invokestatic 636	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   231: astore 14
    //   233: aload 12
    //   235: astore 13
    //   237: aload 14
    //   239: invokevirtual 538	android/graphics/Bitmap:getHeight	()I
    //   242: i2f
    //   243: aload 14
    //   245: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   248: i2f
    //   249: ldc_w 1676
    //   252: fmul
    //   253: fcmpl
    //   254: ifle +203 -> 457
    //   257: aload 12
    //   259: astore 13
    //   261: aload 14
    //   263: iconst_0
    //   264: iconst_0
    //   265: aload 14
    //   267: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   270: aload 14
    //   272: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   275: i2f
    //   276: ldc_w 1676
    //   279: fmul
    //   280: f2i
    //   281: invokestatic 1680	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
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
    //   303: new 1639	java/io/ByteArrayOutputStream
    //   306: dup
    //   307: invokespecial 1640	java/io/ByteArrayOutputStream:<init>	()V
    //   310: astore 14
    //   312: aload 14
    //   314: astore 13
    //   316: aload 15
    //   318: aload_2
    //   319: bipush 70
    //   321: aload 14
    //   323: invokevirtual 1644	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   326: pop
    //   327: aload 14
    //   329: astore 13
    //   331: aload 14
    //   333: invokevirtual 1647	java/io/ByteArrayOutputStream:toByteArray	()[B
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
    //   357: invokevirtual 1647	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   360: arraylength
    //   361: ldc_w 1637
    //   364: if_icmple +125 -> 489
    //   367: iload 5
    //   369: bipush 15
    //   371: if_icmplt +118 -> 489
    //   374: aload 14
    //   376: astore 13
    //   378: iload 5
    //   380: istore 7
    //   382: aload 14
    //   384: invokevirtual 1650	java/io/ByteArrayOutputStream:reset	()V
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
    //   408: invokevirtual 1644	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   411: pop
    //   412: aload 14
    //   414: astore 13
    //   416: iload 5
    //   418: istore 7
    //   420: aload 14
    //   422: invokevirtual 1647	java/io/ByteArrayOutputStream:toByteArray	()[B
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
    //   467: invokevirtual 538	android/graphics/Bitmap:getHeight	()I
    //   470: i2f
    //   471: ldc_w 1676
    //   474: fdiv
    //   475: f2i
    //   476: aload 14
    //   478: invokevirtual 538	android/graphics/Bitmap:getHeight	()I
    //   481: invokestatic 1680	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   484: astore 15
    //   486: goto -200 -> 286
    //   489: aload 12
    //   491: astore 13
    //   493: aload 14
    //   495: invokevirtual 1651	java/io/ByteArrayOutputStream:close	()V
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
    //   518: invokestatic 573	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   521: pop
    //   522: aload 12
    //   524: astore 13
    //   526: ldc_w 305
    //   529: ldc_w 1653
    //   532: iconst_3
    //   533: anewarray 104	java/lang/Object
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
    //   550: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   553: aastore
    //   554: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: aload 12
    //   559: astore 13
    //   561: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   564: astore 14
    //   566: aload 12
    //   568: astore 13
    //   570: aload_3
    //   571: invokestatic 1656	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   574: ldc_w 1658
    //   577: invokestatic 1664	com/tencent/mm/compatible/util/r:as	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   600: anewarray 104	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: aload_3
    //   606: aastore
    //   607: dup
    //   608: iconst_1
    //   609: iload 5
    //   611: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_2
    //   617: iload 9
    //   619: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: aastore
    //   623: dup
    //   624: iconst_3
    //   625: aload 18
    //   627: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   630: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   633: aastore
    //   634: dup
    //   635: iconst_4
    //   636: aload 18
    //   638: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   641: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: aastore
    //   645: dup
    //   646: iconst_5
    //   647: iload 8
    //   649: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: aastore
    //   653: dup
    //   654: bipush 6
    //   656: aload 15
    //   658: invokevirtual 538	android/graphics/Bitmap:getHeight	()I
    //   661: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: aastore
    //   665: dup
    //   666: bipush 7
    //   668: aload 15
    //   670: invokevirtual 533	android/graphics/Bitmap:getWidth	()I
    //   673: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   676: aastore
    //   677: dup
    //   678: bipush 8
    //   680: iconst_1
    //   681: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   684: aastore
    //   685: dup
    //   686: bipush 9
    //   688: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   691: lload 10
    //   693: lsub
    //   694: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   697: aastore
    //   698: invokevirtual 785	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
    //   701: aload 16
    //   703: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   706: ifeq +18 -> 724
    //   709: ldc_w 305
    //   712: ldc_w 1666
    //   715: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload 16
    //   720: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   723: pop
    //   724: aload 12
    //   726: ifnull +8 -> 734
    //   729: aload 12
    //   731: invokevirtual 1667	java/io/OutputStream:close	()V
    //   734: ldc 198
    //   736: aload 17
    //   738: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   741: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   744: astore_1
    //   745: ldc_w 1674
    //   748: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   775: ldc_w 305
    //   778: ldc_w 1669
    //   781: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: iload 5
    //   786: istore 7
    //   788: iload 6
    //   790: istore 8
    //   792: aload 14
    //   794: ifnull -288 -> 506
    //   797: aload 12
    //   799: astore 13
    //   801: aload 14
    //   803: invokevirtual 1651	java/io/ByteArrayOutputStream:close	()V
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
    //   845: invokevirtual 1651	java/io/ByteArrayOutputStream:close	()V
    //   848: aload 12
    //   850: astore 13
    //   852: ldc_w 1674
    //   855: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   858: aload 12
    //   860: astore 13
    //   862: aload_3
    //   863: athrow
    //   864: astore 13
    //   866: aload 12
    //   868: astore_3
    //   869: aload 13
    //   871: astore 12
    //   873: ldc_w 305
    //   876: ldc_w 1607
    //   879: iconst_1
    //   880: anewarray 104	java/lang/Object
    //   883: dup
    //   884: iconst_0
    //   885: aload 12
    //   887: aastore
    //   888: invokestatic 664	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   891: aload_0
    //   892: aload_1
    //   893: iconst_1
    //   894: aload_2
    //   895: invokevirtual 1610	com/tencent/mm/modelimage/j:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   898: astore_1
    //   899: aload 16
    //   901: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   904: ifeq +18 -> 922
    //   907: ldc_w 305
    //   910: ldc_w 1666
    //   913: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   916: aload 16
    //   918: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   921: pop
    //   922: aload_3
    //   923: ifnull +7 -> 930
    //   926: aload_3
    //   927: invokevirtual 1667	java/io/OutputStream:close	()V
    //   930: ldc_w 1674
    //   933: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   952: ldc_w 305
    //   955: ldc_w 1607
    //   958: iconst_1
    //   959: anewarray 104	java/lang/Object
    //   962: dup
    //   963: iconst_0
    //   964: aload_3
    //   965: aastore
    //   966: invokestatic 664	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   969: aload 12
    //   971: astore 13
    //   973: aload_0
    //   974: aload_1
    //   975: iconst_1
    //   976: aload_2
    //   977: invokevirtual 1610	com/tencent/mm/modelimage/j:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   980: astore_1
    //   981: aload 16
    //   983: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   986: ifeq +18 -> 1004
    //   989: ldc_w 305
    //   992: ldc_w 1666
    //   995: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   998: aload 16
    //   1000: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1003: pop
    //   1004: aload 12
    //   1006: ifnull +8 -> 1014
    //   1009: aload 12
    //   1011: invokevirtual 1667	java/io/OutputStream:close	()V
    //   1014: ldc_w 1674
    //   1017: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1020: aload_1
    //   1021: areturn
    //   1022: astore_1
    //   1023: aconst_null
    //   1024: astore 13
    //   1026: aload 16
    //   1028: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   1031: ifeq +18 -> 1049
    //   1034: ldc_w 305
    //   1037: ldc_w 1666
    //   1040: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1043: aload 16
    //   1045: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1048: pop
    //   1049: aload 13
    //   1051: ifnull +8 -> 1059
    //   1054: aload 13
    //   1056: invokevirtual 1667	java/io/OutputStream:close	()V
    //   1059: ldc_w 1674
    //   1062: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	1133	0	this	j
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
    //   0: ldc_w 1685
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1596	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 305
    //   16: ldc_w 1598
    //   19: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1685
    //   25: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 763	com/tencent/mm/modelimage/j:bJJ	()Ljava/lang/String;
    //   33: astore 9
    //   35: aload_0
    //   36: aload 9
    //   38: ldc_w 765
    //   41: ldc_w 356
    //   44: invokevirtual 360	com/tencent/mm/modelimage/j:v	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 10
    //   49: new 210	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   56: aload 10
    //   58: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1614
    //   64: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 8
    //   72: ldc_w 305
    //   75: ldc_w 1616
    //   78: aload 10
    //   80: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 8
    //   91: iconst_0
    //   92: invokestatic 1627	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   95: astore 7
    //   97: aload 7
    //   99: aload_1
    //   100: invokevirtual 1632	java/io/OutputStream:write	([B)V
    //   103: aload 7
    //   105: invokevirtual 1635	java/io/OutputStream:flush	()V
    //   108: iload_2
    //   109: ifeq +113 -> 222
    //   112: sipush 128
    //   115: istore 5
    //   117: goto +298 -> 415
    //   120: iload 4
    //   122: ifeq +114 -> 236
    //   125: aload 8
    //   127: aconst_null
    //   128: invokestatic 1688	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +37 -> 170
    //   136: aload_1
    //   137: bipush 90
    //   139: aload_3
    //   140: aload 10
    //   142: iconst_1
    //   143: invokestatic 573	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   146: pop
    //   147: ldc_w 305
    //   150: ldc_w 1690
    //   153: iconst_2
    //   154: anewarray 104	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload 8
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload 10
    //   166: aastore
    //   167: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload 8
    //   172: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   175: ifeq +18 -> 193
    //   178: ldc_w 305
    //   181: ldc_w 1666
    //   184: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 8
    //   189: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   192: pop
    //   193: aload 7
    //   195: ifnull +8 -> 203
    //   198: aload 7
    //   200: invokevirtual 1667	java/io/OutputStream:close	()V
    //   203: ldc 198
    //   205: aload 9
    //   207: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   210: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   213: astore_1
    //   214: ldc_w 1685
    //   217: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   243: invokestatic 1694	com/tencent/mm/sdk/platformtools/BitmapUtil:extractThumbNail	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   246: astore_1
    //   247: goto -115 -> 132
    //   250: astore_3
    //   251: aconst_null
    //   252: astore_1
    //   253: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   256: ldc2_w 1232
    //   259: ldc2_w 1695
    //   262: lconst_1
    //   263: iconst_0
    //   264: invokevirtual 1239	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   267: ldc_w 305
    //   270: new 210	java/lang/StringBuilder
    //   273: dup
    //   274: ldc_w 1698
    //   277: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: aload 9
    //   282: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 1700
    //   288: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_3
    //   292: invokevirtual 1246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 8
    //   306: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   309: ifeq +18 -> 327
    //   312: ldc_w 305
    //   315: ldc_w 1666
    //   318: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: aload 8
    //   323: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   326: pop
    //   327: aload_1
    //   328: ifnull +7 -> 335
    //   331: aload_1
    //   332: invokevirtual 1667	java/io/OutputStream:close	()V
    //   335: ldc_w 1685
    //   338: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aconst_null
    //   342: areturn
    //   343: astore_3
    //   344: aconst_null
    //   345: astore_1
    //   346: aload 8
    //   348: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   351: ifeq +18 -> 369
    //   354: ldc_w 305
    //   357: ldc_w 1666
    //   360: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 8
    //   365: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   368: pop
    //   369: aload_1
    //   370: ifnull +7 -> 377
    //   373: aload_1
    //   374: invokevirtual 1667	java/io/OutputStream:close	()V
    //   377: ldc_w 1685
    //   380: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	427	0	this	j
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
  
  public final HashMap<Long, h> a(Long... paramVarArgs)
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
      localObject2 = new h();
      ((h)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((h)localObject2).hTh), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150601);
    return localObject1;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, View paramView)
  {
    AppMethodBeat.i(239240);
    boolean bool = a(paramImageView1, paramString, false, paramFloat, paramInt1, paramInt2, paramInt3, paramImageView2, paramInt4, paramInt5, paramView);
    AppMethodBeat.o(239240);
    return bool;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, View paramView)
  {
    AppMethodBeat.i(239254);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      AppMethodBeat.o(239254);
      return false;
    }
    label593:
    label605:
    label874:
    label1132:
    for (;;)
    {
      synchronized (this.oHh)
      {
        boolean bool = this.oHh.containsKey(paramString);
        String str = d(paramString, paramBoolean, false);
        if (Util.isNullOrNil(str))
        {
          Log.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { Util.nullAsNil(paramString) });
          AppMethodBeat.o(239254);
          return false;
        }
        localObject = str;
        if (!bool)
        {
          localObject = str;
          if (!str.endsWith("hd"))
          {
            localObject = str;
            if (y.ZC(str + "hd"))
            {
              this.oHh.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1138;
        }
        paramString = (Bitmap)this.oHa.ct(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, true, paramInt3);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1135;
          }
          paramString = (Bitmap)this.oHa.ct(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label660;
          }
          Log.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label593;
          }
          localObject = this.oHi;
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
          AppMethodBeat.o(239254);
          return true;
        }
      }
      if (this.oHa.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
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
                AppMethodBeat.o(239254);
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
                if ((this.oHj == null) || (this.oHj.get() == null)) {
                  this.oHj = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.oHj.get());
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
  
  public final boolean a(cc paramcc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239400);
    String str = ah(paramcc);
    if (!Util.isNullOrNil(str))
    {
      boolean bool = a(str, paramcc.field_imgPath, paramInt1, paramInt2, 0, 0);
      AppMethodBeat.o(239400);
      return bool;
    }
    AppMethodBeat.o(239400);
    return false;
  }
  
  /* Error */
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 1778
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 305
    //   9: ldc_w 1780
    //   12: iconst_5
    //   13: anewarray 104	java/lang/Object
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
    //   27: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: iload 4
    //   35: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_4
    //   41: invokestatic 476	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
    //   44: aastore
    //   45: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   51: lstore 10
    //   53: invokestatic 607	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   56: invokestatic 1129	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
    //   59: fstore 7
    //   61: aload_1
    //   62: invokestatic 499	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +10 -> 75
    //   68: aload_2
    //   69: invokestatic 499	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifeq +11 -> 83
    //   75: ldc_w 1778
    //   78: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_2
    //   85: iconst_0
    //   86: iconst_1
    //   87: invokevirtual 588	com/tencent/mm/modelimage/j:d	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   90: astore 13
    //   92: aload 13
    //   94: invokestatic 499	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   97: ifeq +11 -> 108
    //   100: ldc_w 1778
    //   103: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 13
    //   110: ldc_w 501
    //   113: invokevirtual 504	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +98 -> 214
    //   119: new 210	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   126: aload 13
    //   128: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 501
    //   134: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 15
    //   142: aload 13
    //   144: astore 14
    //   146: aload 15
    //   148: astore 13
    //   150: aload 14
    //   152: invokestatic 1283	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   155: astore 16
    //   157: aload 16
    //   159: ifnull +23 -> 182
    //   162: aload 16
    //   164: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   167: ifle +15 -> 182
    //   170: aload 16
    //   172: astore 15
    //   174: aload 16
    //   176: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   179: ifgt +121 -> 300
    //   182: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   185: ldc2_w 1232
    //   188: ldc2_w 1781
    //   191: lconst_1
    //   192: iconst_0
    //   193: invokevirtual 1239	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   196: aload 14
    //   198: invokestatic 387	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   201: lconst_0
    //   202: lcmp
    //   203: ifle +29 -> 232
    //   206: ldc_w 1778
    //   209: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: iconst_0
    //   213: ireturn
    //   214: aload 13
    //   216: iconst_0
    //   217: aload 13
    //   219: invokevirtual 541	java/lang/String:length	()I
    //   222: iconst_2
    //   223: isub
    //   224: invokevirtual 545	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore 14
    //   229: goto -79 -> 150
    //   232: new 1285	android/graphics/BitmapFactory$Options
    //   235: dup
    //   236: invokespecial 1617	android/graphics/BitmapFactory$Options:<init>	()V
    //   239: astore 15
    //   241: aload 15
    //   243: invokestatic 1786	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   246: ldc_w 305
    //   249: ldc_w 1788
    //   252: iconst_3
    //   253: anewarray 104	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload 15
    //   260: aastore
    //   261: dup
    //   262: iconst_1
    //   263: aload 15
    //   265: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   268: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: aload 15
    //   276: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   279: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   289: ldc2_w 1232
    //   292: ldc2_w 1789
    //   295: lconst_1
    //   296: iconst_0
    //   297: invokevirtual 1239	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   300: aload 15
    //   302: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   305: ifne +10 -> 315
    //   308: aload 15
    //   310: iload 5
    //   312: putfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   315: aload 15
    //   317: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   320: ifne +10 -> 330
    //   323: aload 15
    //   325: iload 6
    //   327: putfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   330: aload 15
    //   332: getfield 1288	android/graphics/BitmapFactory$Options:outWidth	I
    //   335: i2f
    //   336: fload 7
    //   338: fmul
    //   339: ldc_w 619
    //   342: fmul
    //   343: f2i
    //   344: istore 9
    //   346: aload 15
    //   348: getfield 1291	android/graphics/BitmapFactory$Options:outHeight	I
    //   351: i2f
    //   352: fload 7
    //   354: fmul
    //   355: ldc_w 619
    //   358: fmul
    //   359: f2i
    //   360: istore 8
    //   362: iload 9
    //   364: i2f
    //   365: ldc_w 620
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
    //   386: ldc_w 620
    //   389: fload 7
    //   391: fmul
    //   392: fcmpl
    //   393: iflt +40 -> 433
    //   396: iload 8
    //   398: iload 9
    //   400: if_icmple +221 -> 621
    //   403: ldc_w 620
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
    //   443: getstatic 569	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   446: bipush 80
    //   448: aload 13
    //   450: iconst_1
    //   451: new 392	com/tencent/mm/pointers/PInt
    //   454: dup
    //   455: invokespecial 393	com/tencent/mm/pointers/PInt:<init>	()V
    //   458: new 392	com/tencent/mm/pointers/PInt
    //   461: dup
    //   462: invokespecial 393	com/tencent/mm/pointers/PInt:<init>	()V
    //   465: iconst_1
    //   466: iconst_m1
    //   467: invokestatic 1794	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;ZLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;ZI)Z
    //   470: istore 12
    //   472: ldc_w 305
    //   475: ldc_w 1796
    //   478: iconst_4
    //   479: anewarray 104	java/lang/Object
    //   482: dup
    //   483: iconst_0
    //   484: new 210	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   491: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   494: lload 10
    //   496: lsub
    //   497: invokevirtual 293	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: aastore
    //   504: dup
    //   505: iconst_1
    //   506: iload 6
    //   508: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: aastore
    //   512: dup
    //   513: iconst_2
    //   514: iload 5
    //   516: invokestatic 437	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: aastore
    //   520: dup
    //   521: iconst_3
    //   522: iload 12
    //   524: invokestatic 470	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   527: aastore
    //   528: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   531: aload_0
    //   532: aload 14
    //   534: iconst_1
    //   535: invokestatic 607	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   538: invokestatic 1129	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
    //   541: iconst_1
    //   542: iconst_0
    //   543: iconst_1
    //   544: iload_3
    //   545: iconst_0
    //   546: invokespecial 1254	com/tencent/mm/modelimage/j:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   549: pop
    //   550: iload 12
    //   552: ifeq +176 -> 728
    //   555: aload_0
    //   556: getfield 153	com/tencent/mm/modelimage/j:oHh	Ljava/util/Map;
    //   559: astore_1
    //   560: aload_1
    //   561: monitorenter
    //   562: aload_0
    //   563: getfield 153	com/tencent/mm/modelimage/j:oHh	Ljava/util/Map;
    //   566: aload_2
    //   567: invokeinterface 1725 2 0
    //   572: ifeq +38 -> 610
    //   575: aload_0
    //   576: getfield 153	com/tencent/mm/modelimage/j:oHh	Ljava/util/Map;
    //   579: aload_2
    //   580: invokeinterface 848 2 0
    //   585: checkcast 59	java/lang/String
    //   588: ldc_w 501
    //   591: invokevirtual 504	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   594: ifne +16 -> 610
    //   597: aload_0
    //   598: getfield 153	com/tencent/mm/modelimage/j:oHh	Ljava/util/Map;
    //   601: aload_2
    //   602: aload 13
    //   604: invokeinterface 831 3 0
    //   609: pop
    //   610: aload_1
    //   611: monitorexit
    //   612: ldc_w 1778
    //   615: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: iload 12
    //   620: ireturn
    //   621: ldc_w 620
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
    //   641: getstatic 569	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   644: bipush 80
    //   646: aload 13
    //   648: iconst_1
    //   649: new 392	com/tencent/mm/pointers/PInt
    //   652: dup
    //   653: invokespecial 393	com/tencent/mm/pointers/PInt:<init>	()V
    //   656: new 392	com/tencent/mm/pointers/PInt
    //   659: dup
    //   660: invokespecial 393	com/tencent/mm/pointers/PInt:<init>	()V
    //   663: iconst_1
    //   664: iconst_1
    //   665: iconst_m1
    //   666: invokestatic 1799	com/tencent/mm/sdk/platformtools/BitmapUtil:createThumbNail	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;ZLcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;ZZI)Z
    //   669: istore 12
    //   671: goto -199 -> 472
    //   674: astore_1
    //   675: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   678: ldc2_w 1232
    //   681: ldc2_w 1800
    //   684: lconst_1
    //   685: iconst_0
    //   686: invokevirtual 1239	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   689: ldc_w 305
    //   692: ldc_w 1803
    //   695: iconst_1
    //   696: anewarray 104	java/lang/Object
    //   699: dup
    //   700: iconst_0
    //   701: aload_1
    //   702: invokevirtual 1804	java/lang/Exception:toString	()Ljava/lang/String;
    //   705: aastore
    //   706: invokestatic 664	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   709: ldc_w 1778
    //   712: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   715: iconst_0
    //   716: ireturn
    //   717: astore_2
    //   718: aload_1
    //   719: monitorexit
    //   720: ldc_w 1778
    //   723: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   726: aload_2
    //   727: athrow
    //   728: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   731: ldc2_w 1232
    //   734: ldc2_w 1800
    //   737: lconst_1
    //   738: iconst_0
    //   739: invokevirtual 1239	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   742: goto -130 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	this	j
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
    localObject = bJJ();
    String str = v((String)localObject, "th_", "");
    Log.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(str)));
    y.deleteFile(str);
    y.f(str, paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(localObject));
    AppMethodBeat.o(150580);
    return paramArrayOfByte;
  }
  
  public final h af(cc paramcc)
  {
    AppMethodBeat.i(150595);
    h localh = H(paramcc.field_talker, paramcc.field_msgId);
    Object localObject;
    if (localh != null)
    {
      localObject = localh;
      if (localh.localId != 0L) {}
    }
    else
    {
      paramcc = G(paramcc.field_talker, paramcc.field_msgSvrId);
      if (paramcc != null)
      {
        localObject = paramcc;
        if (paramcc.localId != 0L) {}
      }
      else
      {
        Log.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        AppMethodBeat.o(150595);
        return null;
      }
    }
    AppMethodBeat.o(150595);
    return localObject;
  }
  
  public final void ag(cc paramcc)
  {
    AppMethodBeat.i(150599);
    h localh = af(paramcc);
    if ((localh == null) || (localh.localId == 0L))
    {
      Log.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      AppMethodBeat.o(150599);
      return;
    }
    y.deleteFile(v(localh.oGr, "", ""));
    y.deleteFile(v(localh.oGw, "", ""));
    y.deleteFile(v(localh.oGt, "", ""));
    y.deleteFile(v(localh.oGt, "", "") + "hd");
    this.omV.delete(j.d.Og(paramcc.field_talker), "id=?", new String[] { localh.localId });
    if (localh.bJE())
    {
      localh = wq(localh.oGB);
      if (localh == null)
      {
        AppMethodBeat.o(150599);
        return;
      }
      y.deleteFile(v(localh.oGr, "", ""));
      y.deleteFile(v(localh.oGw, "", ""));
      y.deleteFile(v(localh.oGt, "", ""));
      y.deleteFile(v(localh.oGt, "", "") + "hd");
      this.omV.delete(j.d.Og(paramcc.field_talker), "id=?", new String[] { localh.localId });
    }
    AppMethodBeat.o(150599);
  }
  
  public final String az(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(239202);
    if (Util.isNullOrNil(paramArrayOfByte))
    {
      Log.e("MicroMsg.ImgInfoStorage", "directSaveThumbBufForAppMsg save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(239202);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth < 0) || (((BitmapFactory.Options)localObject).outHeight < 0))
    {
      Log.e("MicroMsg.ImgInfoStorage", "directSaveThumbBufForAppMsg Bad thumbBuf, perhaps it's not complete or damaged ??");
      AppMethodBeat.o(239202);
      return null;
    }
    localObject = bJJ();
    String str = a((String)localObject, "msgth_", "", true);
    Log.d("MicroMsg.ImgInfoStorage", "directSaveThumbBufForAppMsg, fullPath = ".concat(String.valueOf(str)));
    y.deleteFile(str);
    y.f(str, paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = NZ((String)localObject);
    AppMethodBeat.o(239202);
    return paramArrayOfByte;
  }
  
  public final Bitmap b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(239393);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from";; str = "location_backgroup_key_tor")
    {
      Bitmap localBitmap2 = (Bitmap)this.oHa.ct(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = BitmapUtil.createLocation(paramInt1, paramInt2, paramInt3, paramInt4);
        this.oHa.B(str, localBitmap1);
      }
      AppMethodBeat.o(239393);
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
  
  public final h b(Long paramLong)
  {
    AppMethodBeat.i(150596);
    h localh = new h();
    paramLong = a(j.d.iR(paramLong.longValue()), null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      localh.convertFrom(paramLong);
    }
    paramLong.close();
    AppMethodBeat.o(150596);
    return localh;
  }
  
  /* Error */
  public final String b(byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: ldc_w 1851
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1596	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 305
    //   16: ldc_w 1853
    //   19: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1851
    //   25: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 763	com/tencent/mm/modelimage/j:bJJ	()Ljava/lang/String;
    //   33: astore 8
    //   35: aload_0
    //   36: aload 8
    //   38: ldc_w 1575
    //   41: ldc_w 356
    //   44: invokevirtual 360	com/tencent/mm/modelimage/j:v	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 9
    //   49: new 210	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 290	java/lang/StringBuilder:<init>	()V
    //   56: aload 9
    //   58: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1614
    //   64: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 7
    //   72: ldc_w 305
    //   75: ldc_w 1855
    //   78: aload 9
    //   80: invokestatic 202	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 7
    //   91: iconst_0
    //   92: invokestatic 1627	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   95: astore 6
    //   97: aload 6
    //   99: aload_1
    //   100: invokevirtual 1632	java/io/OutputStream:write	([B)V
    //   103: aload 6
    //   105: invokevirtual 1635	java/io/OutputStream:flush	()V
    //   108: iload_2
    //   109: ifeq +107 -> 216
    //   112: sipush 128
    //   115: istore 4
    //   117: goto +278 -> 395
    //   120: aload 7
    //   122: iload 4
    //   124: iload 5
    //   126: iconst_0
    //   127: invokestatic 1694	com/tencent/mm/sdk/platformtools/BitmapUtil:extractThumbNail	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   130: astore_1
    //   131: aload_1
    //   132: ifnull +37 -> 169
    //   135: aload_1
    //   136: bipush 90
    //   138: aload_3
    //   139: aload 9
    //   141: iconst_1
    //   142: invokestatic 573	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   145: pop
    //   146: ldc_w 305
    //   149: ldc_w 1690
    //   152: iconst_2
    //   153: anewarray 104	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload 7
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload 9
    //   165: aastore
    //   166: invokestatic 440	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: aload 7
    //   171: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   174: ifeq +18 -> 192
    //   177: ldc_w 305
    //   180: ldc_w 1666
    //   183: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 7
    //   188: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   191: pop
    //   192: aload 6
    //   194: ifnull +8 -> 202
    //   197: aload 6
    //   199: invokevirtual 1667	java/io/OutputStream:close	()V
    //   202: aload 8
    //   204: invokestatic 1842	com/tencent/mm/modelimage/j:NZ	(Ljava/lang/String;)Ljava/lang/String;
    //   207: astore_1
    //   208: ldc_w 1851
    //   211: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: areturn
    //   216: bipush 120
    //   218: istore 4
    //   220: goto +175 -> 395
    //   223: bipush 120
    //   225: istore 5
    //   227: goto -107 -> 120
    //   230: astore_3
    //   231: aconst_null
    //   232: astore_1
    //   233: getstatic 779	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   236: ldc2_w 1232
    //   239: ldc2_w 1695
    //   242: lconst_1
    //   243: iconst_0
    //   244: invokevirtual 1239	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   247: ldc_w 305
    //   250: new 210	java/lang/StringBuilder
    //   253: dup
    //   254: ldc_w 1857
    //   257: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload 8
    //   262: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc_w 1700
    //   268: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_3
    //   272: invokevirtual 1246	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 7
    //   286: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   289: ifeq +18 -> 307
    //   292: ldc_w 305
    //   295: ldc_w 1666
    //   298: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 7
    //   303: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   306: pop
    //   307: aload_1
    //   308: ifnull +7 -> 315
    //   311: aload_1
    //   312: invokevirtual 1667	java/io/OutputStream:close	()V
    //   315: ldc_w 1851
    //   318: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aconst_null
    //   322: areturn
    //   323: astore_3
    //   324: aconst_null
    //   325: astore_1
    //   326: aload 7
    //   328: invokestatic 340	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   331: ifeq +18 -> 349
    //   334: ldc_w 305
    //   337: ldc_w 1666
    //   340: invokestatic 748	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: aload 7
    //   345: invokestatic 1426	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   348: pop
    //   349: aload_1
    //   350: ifnull +7 -> 357
    //   353: aload_1
    //   354: invokevirtual 1667	java/io/OutputStream:close	()V
    //   357: ldc_w 1851
    //   360: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aload_3
    //   364: athrow
    //   365: astore_1
    //   366: goto -164 -> 202
    //   369: astore_1
    //   370: goto -55 -> 315
    //   373: astore_1
    //   374: goto -17 -> 357
    //   377: astore_3
    //   378: aload 6
    //   380: astore_1
    //   381: goto -55 -> 326
    //   384: astore_3
    //   385: goto -59 -> 326
    //   388: astore_3
    //   389: aload 6
    //   391: astore_1
    //   392: goto -159 -> 233
    //   395: iload_2
    //   396: ifeq -173 -> 223
    //   399: sipush 128
    //   402: istore 5
    //   404: goto -284 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	j
    //   0	407	1	paramArrayOfByte	byte[]
    //   0	407	2	paramBoolean	boolean
    //   0	407	3	paramCompressFormat	Bitmap.CompressFormat
    //   115	104	4	i	int
    //   124	279	5	j	int
    //   95	295	6	localOutputStream	java.io.OutputStream
    //   70	274	7	str1	String
    //   33	228	8	str2	String
    //   47	117	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	97	230	java/lang/Exception
    //   89	97	323	finally
    //   197	202	365	java/lang/Exception
    //   311	315	369	java/lang/Exception
    //   353	357	373	java/lang/Exception
    //   97	108	377	finally
    //   120	131	377	finally
    //   135	169	377	finally
    //   233	284	384	finally
    //   97	108	388	java/lang/Exception
    //   120	131	388	java/lang/Exception
    //   135	169	388	java/lang/Exception
  }
  
  public final HashMap<Long, h> b(Long... paramVarArgs)
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
      localObject2 = new h();
      ((h)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((h)localObject2).hTh), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150602);
    return localObject1;
  }
  
  public final void bJH()
  {
    AppMethodBeat.i(150567);
    Iterator localIterator = j.d.oHy.iterator();
    while (localIterator.hasNext())
    {
      j.c localc = (j.c)localIterator.next();
      Cursor localCursor = this.omV.rawQuery("SELECT max(id) FROM " + localc.table, null, 2);
      AtomicLong localAtomicLong = localc.oHx;
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
  
  public final List<h> bJI()
  {
    AppMethodBeat.i(150598);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = j.d.oHy.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (j.c)localIterator.next();
      localObject = "select * " + " FROM " + ((j.c)localObject).table;
      localObject = (String)localObject + " WHERE iscomplete= 0 AND totalLen != 0 ";
      localObject = this.omV.rawQuery((String)localObject, null);
      if (!((Cursor)localObject).moveToFirst()) {
        ((Cursor)localObject).close();
      } else {
        label228:
        for (;;)
        {
          h localh1 = new h();
          localh1.convertFrom((Cursor)localObject);
          h localh2 = wr((int)localh1.localId);
          if (localh2 != null) {
            if ((localh2.hTh != 0L) || (localh2.oGz != 0L)) {
              localArrayList.add(localh1);
            }
          }
          for (;;)
          {
            if (((Cursor)localObject).moveToNext()) {
              break label228;
            }
            ((Cursor)localObject).close();
            break;
            if ((localh1.hTh != 0L) || (localh1.oGz != 0L)) {
              localArrayList.add(localh1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(150598);
    return localArrayList;
  }
  
  public final Bitmap d(String paramString, float paramFloat)
  {
    AppMethodBeat.i(239227);
    paramString = a(paramString, paramFloat, true);
    AppMethodBeat.o(239227);
    return paramString;
  }
  
  public final String d(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150633);
    Object localObject;
    if ((paramString != null) && (this.oHh.containsKey(paramString)))
    {
      localObject = (String)this.oHh.get(paramString);
      AppMethodBeat.o(150633);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = X(paramString, paramBoolean2))
    {
      localObject = str;
      if (Util.isNullOrNil(str)) {
        break;
      }
      this.oHh.put(paramString, str);
      localObject = str;
      break;
    }
  }
  
  public final Bitmap e(String paramString, float paramFloat)
  {
    AppMethodBeat.i(150582);
    paramString = a(paramString, paramFloat, false);
    AppMethodBeat.o(150582);
    return paramString;
  }
  
  public final String getFullPath(String paramString)
  {
    AppMethodBeat.i(150572);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150572);
      return null;
    }
    String str2 = com.tencent.mm.plugin.image.d.bzM();
    String str3 = "th_";
    String str1;
    if (paramString.startsWith("SERVERID://")) {
      str1 = paramString.substring(11);
    }
    for (;;)
    {
      try
      {
        str1 = iQ(Long.valueOf(str1).longValue()).oGr;
        String str5 = com.tencent.mm.plugin.image.d.bzL();
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
        str2 = com.tencent.mm.plugin.openapi.a.gxi();
      }
      else
      {
        str1 = "";
      }
    }
  }
  
  public final String v(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150571);
    paramString1 = a(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(150571);
    return paramString1;
  }
  
  public final h wq(int paramInt)
  {
    AppMethodBeat.i(150603);
    h localh = b(Long.valueOf(paramInt));
    AppMethodBeat.o(150603);
    return localh;
  }
  
  /* Error */
  public final h wr(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1909
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: i2l
    //   8: lstore_2
    //   9: aload_0
    //   10: lload_2
    //   11: invokestatic 1156	com/tencent/mm/modelimage/j$d:iR	(J)Ljava/lang/String;
    //   14: aconst_null
    //   15: ldc_w 1911
    //   18: iconst_1
    //   19: anewarray 59	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 1081	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: aastore
    //   29: invokespecial 1067	com/tencent/mm/modelimage/j:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +170 -> 206
    //   39: aload 5
    //   41: astore 6
    //   43: aload 5
    //   45: invokeinterface 1070 1 0
    //   50: ifeq +156 -> 206
    //   53: aload 5
    //   55: astore 6
    //   57: new 331	com/tencent/mm/modelimage/h
    //   60: dup
    //   61: invokespecial 698	com/tencent/mm/modelimage/h:<init>	()V
    //   64: astore 4
    //   66: aload 5
    //   68: astore 6
    //   70: aload 4
    //   72: aload 5
    //   74: invokevirtual 1074	com/tencent/mm/modelimage/h:convertFrom	(Landroid/database/Cursor;)V
    //   77: aload 4
    //   79: astore 6
    //   81: aload 5
    //   83: ifnull +14 -> 97
    //   86: aload 5
    //   88: invokeinterface 926 1 0
    //   93: aload 4
    //   95: astore 6
    //   97: ldc_w 1909
    //   100: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload 6
    //   105: areturn
    //   106: astore 7
    //   108: aconst_null
    //   109: astore 4
    //   111: aconst_null
    //   112: astore 5
    //   114: aload 5
    //   116: astore 6
    //   118: ldc_w 305
    //   121: ldc_w 1913
    //   124: iconst_1
    //   125: anewarray 104	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload 7
    //   132: invokevirtual 1804	java/lang/Exception:toString	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 1299	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload 4
    //   141: astore 6
    //   143: aload 5
    //   145: ifnull -48 -> 97
    //   148: aload 5
    //   150: invokeinterface 926 1 0
    //   155: aload 4
    //   157: astore 6
    //   159: goto -62 -> 97
    //   162: astore 4
    //   164: aconst_null
    //   165: astore 6
    //   167: aload 6
    //   169: ifnull +10 -> 179
    //   172: aload 6
    //   174: invokeinterface 926 1 0
    //   179: ldc_w 1909
    //   182: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0	212	0	this	j
    //   0	212	1	paramInt	int
    //   8	3	2	l	long
    //   64	92	4	localh	h
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
    int oHr;
    int oHs;
    int oHt;
    String url;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      this.oHr = paramInt1;
      this.url = paramString;
      this.oHs = paramInt2;
      this.oHt = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.j
 * JD-Core Version:    0.7.0.1
 */