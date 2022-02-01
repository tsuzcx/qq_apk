package com.tencent.mm.aw;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
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
import com.tencent.mm.g.c.ei;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.storage.bu;
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
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
  public static int iaf = 0;
  public static int iaq = 150;
  public static long iar = 0L;
  private ap gIf;
  public com.tencent.mm.storagebase.h hHS;
  com.tencent.mm.b.f<String, Bitmap> iag;
  private com.tencent.mm.b.f<String, String> iah;
  private List<b> iai;
  private Map<Integer, WeakReference<ImageView>> iaj;
  private Map<Integer, WeakReference<ImageView>> iak;
  private Map<Integer, WeakReference<View>> ial;
  private Set<Integer> iam;
  private Map<String, String> ian;
  private FrameLayout.LayoutParams iao;
  private SoftReference<ColorDrawable> iap;
  
  public i(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150566);
    this.iag = new com.tencent.mm.memory.a.b(40, new f.b() {}, getClass());
    this.iah = new com.tencent.mm.memory.a.c(40);
    this.iai = new ArrayList();
    this.iaj = new HashMap();
    this.iak = new HashMap();
    this.ial = new HashMap();
    this.iam = new HashSet();
    this.gIf = new ap(Looper.getMainLooper());
    this.ian = new HashMap();
    this.hHS = null;
    this.iao = new FrameLayout.LayoutParams(-2, -2);
    Iterator localIterator = d.iaE.iterator();
    while (localIterator.hasNext()) {
      a(paramh, ((c)localIterator.next()).table);
    }
    this.hHS = paramh;
    aIm();
    AppMethodBeat.o(150566);
  }
  
  public static String[] Fk(String paramString)
  {
    AppMethodBeat.i(195245);
    String str1 = "CREATE TABLE IF NOT EXISTS " + paramString + " ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete" + " INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )";
    String str2 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoIndex ON " + paramString + " ( msgSvrId ) ";
    String str3 = "CREATE INDEX IF NOT EXISTS " + paramString + "serverImgInfoHdIndex ON " + paramString + " ( reserved1 ) ";
    String str4 = "CREATE INDEX IF NOT EXISTS " + paramString + "msgLocalIdIndex ON " + paramString + " ( msglocalid ) ";
    String str5 = "CREATE INDEX IF NOT EXISTS " + paramString + "iscomplete_index ON " + paramString + " ( iscomplete ) ";
    paramString = "CREATE INDEX IF NOT EXISTS " + paramString + "origImgMD5_index ON " + paramString + " ( origImgMD5 ) ";
    AppMethodBeat.o(195245);
    return new String[] { str1, str2, str3, str4, str5, paramString };
  }
  
  public static long Fl(String paramString)
  {
    AppMethodBeat.i(195246);
    long l = d.Ft(paramString).incrementAndGet();
    AppMethodBeat.o(195246);
    return l;
  }
  
  /* Error */
  private static String Fr(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 257
    //   6: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: getstatic 87	com/tencent/mm/aw/i:iar	J
    //   16: lstore 5
    //   18: lload_3
    //   19: lstore_1
    //   20: lload 5
    //   22: lload_3
    //   23: lcmp
    //   24: ifne +11 -> 35
    //   27: lconst_1
    //   28: invokestatic 268	java/lang/Thread:sleep	(J)V
    //   31: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   34: lstore_1
    //   35: lload_1
    //   36: putstatic 87	com/tencent/mm/aw/i:iar	J
    //   39: new 200	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: lload_1
    //   51: invokevirtual 272	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokevirtual 276	java/lang/String:getBytes	()[B
    //   60: invokestatic 282	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   63: astore_0
    //   64: ldc_w 284
    //   67: ldc_w 286
    //   70: iconst_2
    //   71: anewarray 106	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: lload_1
    //   81: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   84: aastore
    //   85: invokestatic 297	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: ldc_w 257
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
  
  public static String N(bu parambu)
  {
    AppMethodBeat.i(150635);
    if (parambu == null)
    {
      ad.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      AppMethodBeat.o(150635);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject1;
    if (parambu.field_isSend == 1)
    {
      localObject2 = q.aIF().G(parambu.field_talker, parambu.field_msgId);
      localObject1 = localObject2;
      if (((g)localObject2).dnz != 0L) {}
    }
    else
    {
      localObject1 = q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
    }
    if (com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {
      if (parambu.field_isSend == 1)
      {
        parambu = h.c((g)localObject1);
        localObject2 = q.aIF().o(parambu, "", "");
        if ((parambu != null) && (parambu.length() > 0) && (com.tencent.mm.vfs.i.fv((String)localObject2)))
        {
          AppMethodBeat.o(150635);
          return localObject2;
        }
        parambu = ((g)localObject1).hZw;
        localObject1 = q.aIF().o(parambu, "", "");
        if ((parambu != null) && (parambu.length() > 0) && (com.tencent.mm.vfs.i.fv((String)localObject1)))
        {
          AppMethodBeat.o(150635);
          return localObject1;
        }
      }
      else if (((g)localObject1).aIi())
      {
        parambu = ((g)localObject1).hZw;
        if (!((g)localObject1).aIj()) {
          break label314;
        }
        localObject1 = h.a((g)localObject1);
        if ((localObject1 == null) || (((g)localObject1).dnz <= 0L) || (!((g)localObject1).aIi()) || (!com.tencent.mm.vfs.i.fv(q.aIF().o(((g)localObject1).hZw, "", "")))) {
          break label314;
        }
        parambu = ((g)localObject1).hZw;
      }
    }
    label314:
    for (;;)
    {
      AppMethodBeat.o(150635);
      return parambu;
      ad.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      AppMethodBeat.o(150635);
      return null;
    }
  }
  
  private long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString4, String paramString5, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(195256);
    if (paramInt1 == 0)
    {
      paramString2 = a(paramString1, paramString2, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama);
      if (paramString2 == null)
      {
        AppMethodBeat.o(195256);
        return -1L;
      }
      paramPString.value = paramString2.hZy;
      if (com.tencent.mm.vfs.i.fv(paramString3))
      {
        paramPString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).abe(paramString2.hZw);
        com.tencent.mm.vfs.i.mz(paramString3, o(paramPString, "", ""));
        paramString2.Fh(paramPString);
      }
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(195256);
        return paramLong;
      }
    }
    if (paramInt1 == 1)
    {
      paramString3 = a(paramString1, paramString2, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString4, paramString5, paramb2, paramb1, parama);
      if (paramString3 == null)
      {
        AppMethodBeat.o(195256);
        return -1L;
      }
      paramPString.value = paramString3.hZy;
      paramString3.sd(0L);
      paramString3.qz(0L);
      paramString3.pn((int)com.tencent.mm.vfs.i.aYo(o(paramString3.hZw, "", "")));
      paramString2 = a(paramString1, paramString2, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString4, paramString5, paramb2, paramb1, parama);
      if (paramString2 == null)
      {
        AppMethodBeat.o(195256);
        return 0L;
      }
      paramString2.Fd(paramString3.hZw);
      paramString2.Ff(paramString3.hZy);
      paramString2.Fe(paramString3.hZx);
      paramString2.pn(0);
      long l = this.hHS.xO(Thread.currentThread().getId());
      paramString2.po((int)a(paramString1, "id", paramString3));
      if (paramBoolean) {}
      for (paramLong = b(paramString1, paramString2);; paramLong = a(paramString1, "id", paramString2))
      {
        ad.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramString2.dnz), Long.valueOf(paramString2.hZF), paramString2.hZw, paramString2.hZx, Integer.valueOf(paramString2.hMP) });
        if (l > 0L) {
          com.tencent.mm.kernel.g.ajC().gBq.sJ(l);
        }
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(195256);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(195256);
    return 0L;
  }
  
  private Bitmap a(String paramString1, String paramString2, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString3, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(195260);
    ad.i("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap talker[%s] origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), bt.flS(), paramString3 });
    Object localObject2 = (Bitmap)this.iag.aL(h.Fj(paramString2));
    Object localObject4 = null;
    Object localObject3;
    Object localObject1;
    Object localObject5;
    if (localObject2 != null)
    {
      localObject3 = localObject2;
      if (!((Bitmap)localObject2).isRecycled()) {}
    }
    else
    {
      localObject1 = n(paramString1, paramString2, paramInt1);
      if (bt.isNullOrNil((String)localObject1)) {
        break label496;
      }
      int i;
      int j;
      if (((String)localObject1).endsWith("hd"))
      {
        localObject5 = localObject1;
        if (localObject2 != null)
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (!((Bitmap)localObject2).isRecycled()) {
            break label485;
          }
        }
        i = af.aQs((String)localObject5);
        j = BackwardSupportUtil.ExifHelper.cY((String)localObject5);
        if (i <= 0) {
          break label357;
        }
      }
      label181:
      label335:
      label357:
      for (localObject2 = af.aO((String)localObject5, i, j + paramInt2 * 90);; localObject2 = com.tencent.mm.sdk.platformtools.g.aK((String)localObject5, 120, 120))
      {
        if (localObject2 != null)
        {
          this.iag.q(h.Fj(paramString2), localObject2);
          paramPInt1.value = ((Bitmap)localObject2).getWidth();
          paramPInt2.value = ((Bitmap)localObject2).getHeight();
          if (paramBoolean)
          {
            if (localObject1 != null) {
              break label479;
            }
            paramString1 = n(paramString1, paramString2, paramInt1);
            label239:
            paramString2 = paramString1;
            if (!bt.isNullOrNil(paramString1))
            {
              paramString2 = paramString1;
              if (paramString1.endsWith("hd")) {
                paramString2 = paramString1.substring(0, paramString1.length() - 2);
              }
            }
            if (paramb != null) {
              paramb.Ka();
            }
            if ((bt.isNullOrNil(paramString2)) || (!com.tencent.mm.vfs.i.fv(paramString2)) || (com.tencent.mm.vfs.i.aYo(paramString2) <= 0L)) {
              break label371;
            }
            com.tencent.mm.vfs.i.mz(paramString2, paramString3);
            ad.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s %s", new Object[] { paramString2, paramString3 });
          }
        }
        AppMethodBeat.o(195260);
        return localObject2;
        localObject2 = com.tencent.mm.sdk.platformtools.g.aQf((String)localObject1);
        localObject5 = paramString2;
        break;
      }
      label371:
      if ((!bt.isNullOrNil(paramString2)) && (com.tencent.mm.vfs.i.fv(paramString2))) {
        ad.i("MicroMsg.ImgInfoStorage", "oldThumbFile Length %s", new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(paramString2)) });
      }
    }
    for (;;)
    {
      label430:
      try
      {
        if ((bt.isNullOrNil(paramString2)) || (!paramString2.endsWith("hd"))) {
          break label468;
        }
        paramInt1 = 1;
      }
      catch (IOException paramString1) {}
      com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, paramInt1, Bitmap.CompressFormat.JPEG, paramString3, false);
      ad.i("MicroMsg.ImgInfoStorage", "saveBitmapToImage thumbPath %s", new Object[] { paramString3 });
      break label335;
      break label335;
      label468:
      paramInt1 = 0;
      label479:
      label485:
      label496:
      while (paramInt1 == 0)
      {
        paramInt1 = 90;
        break label430;
        paramString1 = (String)localObject1;
        break label239;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break label181;
        localObject5 = paramString2;
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
    String str = paramString;
    if (!paramBoolean1) {
      str = c(paramString, false, true);
    }
    if (str == null)
    {
      AppMethodBeat.o(150591);
      return null;
    }
    Object localObject1 = null;
    int k;
    label87:
    Object localObject2;
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
        paramString = (Bitmap)this.iag.aL(str);
        localObject1 = paramString;
        if (paramString == null)
        {
          if (paramString != null) {
            break label696;
          }
          paramBoolean1 = true;
          ad.l("MicroMsg.ImgInfoStorage", "bm is null:%b,  url:%s", new Object[] { Boolean.valueOf(paramBoolean1), str });
          localObject1 = paramString;
        }
      }
      if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
      {
        localObject2 = localObject1;
        if (k == 0) {}
      }
      else
      {
        bt.flT();
        if (k == 0) {
          break label701;
        }
        paramString = paramBitmap;
        if (paramBitmap == null) {
          paramString = u.IT(str);
        }
        if (paramString == null) {
          break label922;
        }
        l = System.currentTimeMillis();
        m = paramString.getWidth();
        n = paramString.getHeight();
        i = n;
        j = m;
        if (paramBoolean3)
        {
          if (iaf == 0) {
            iaf = com.tencent.mm.cc.a.ay(com.tencent.mm.sdk.platformtools.aj.getContext(), 2131166264);
          }
          if (m <= iaf)
          {
            i = n;
            j = m;
            if (n <= iaf) {}
          }
          else
          {
            if (m <= n) {
              break label712;
            }
            i = n * iaf / m;
            j = iaf;
          }
        }
        label259:
        n = i;
        m = j;
        if (paramBoolean4)
        {
          if (str.endsWith("hd")) {
            break label961;
          }
          j = (int)(paramString.getWidth() * paramFloat * 1.25F);
          i = (int)(paramString.getHeight() * paramFloat * 1.25F);
        }
      }
    }
    label696:
    label701:
    label961:
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
          ad.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(j) });
          m = (int)(60.0F * paramFloat);
        }
        j = i;
        if (i < 60.0F * paramFloat)
        {
          ad.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(i) });
          j = (int)(60.0F * paramFloat);
        }
        paramBitmap = com.tencent.mm.sdk.platformtools.aj.getContext();
        localObject1 = new int[2];
        if (j >= m)
        {
          paramFloat = j / m;
          if (paramFloat <= 2.0F)
          {
            i = com.tencent.mm.cc.a.ay(paramBitmap, 2131165213);
            j = (int)(i / paramFloat);
            label510:
            localObject1[0] = j;
            localObject1[1] = i;
            m = localObject1[0];
            n = localObject1[1];
          }
        }
        for (;;)
        {
          try
          {
            paramBitmap = Bitmap.createScaledBitmap(paramString, m, n, true);
            if ((paramString != paramBitmap) && (k == 0))
            {
              ad.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramString.toString() });
              paramString.recycle();
            }
            if (paramBoolean4)
            {
              paramString = com.tencent.mm.sdk.platformtools.g.k(paramBitmap, paramInt);
              localObject1 = System.currentTimeMillis() - l;
              if (paramString != null) {
                continue;
              }
              paramBitmap = "";
              ad.i("MicroMsg.ImgInfoStorage", "cached file :%s bitmap time:%s bitmap:%s", new Object[] { str, localObject1, paramBitmap });
              localObject2 = paramString;
              if (paramString != null)
              {
                localObject2 = paramString;
                if (k == 0)
                {
                  this.iag.q(str, paramString);
                  localObject2 = paramString;
                }
              }
              AppMethodBeat.o(150591);
              return localObject2;
              k = 0;
              break;
              paramBoolean1 = false;
              break label87;
              paramBitmap = com.tencent.mm.sdk.platformtools.g.p(str, paramFloat);
              break label146;
              label712:
              if (m == n)
              {
                i = iaf;
                j = iaf;
                break label259;
              }
              j = m * iaf / n;
              i = iaf;
              break label259;
              f = 160.0F * paramFloat / j;
              break label353;
              j = com.tencent.mm.cc.a.ay(paramBitmap, 2131165215);
              i = (int)(j * paramFloat);
              break label510;
              paramFloat = m / j;
              if (paramFloat <= 2.0F)
              {
                j = com.tencent.mm.cc.a.ay(paramBitmap, 2131165213);
                i = (int)(j / paramFloat);
                break label510;
              }
              i = com.tencent.mm.cc.a.ay(paramBitmap, 2131165215);
              j = (int)(i * paramFloat);
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
              paramString = com.tencent.mm.sdk.platformtools.g.a(paramBitmap, true, com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.aj.getContext(), 3));
              ad.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
              continue;
            }
            paramString = paramBitmap;
            continue;
            paramBitmap = paramString.toString();
            continue;
          }
          ad.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", new Object[] { str, Boolean.valueOf(com.tencent.mm.vfs.i.fv(str)) });
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private g a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString3, long paramLong, String paramString4, String paramString5, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama)
  {
    AppMethodBeat.i(195264);
    if (!com.tencent.mm.vfs.i.fv(paramString2))
    {
      AppMethodBeat.o(195264);
      return null;
    }
    String str = h.Fj(paramString2);
    paramb1 = a(paramString1, paramString2, paramInt1, paramBoolean, paramInt3, paramPInt1, paramPInt2, paramString3, paramString4, paramb1);
    if ((parama != null) && (parama.hZz == paramInt1))
    {
      paramString5 = parama.aIw();
      paramPInt2 = paramString5.icb;
      paramString3 = paramString5.icc;
      paramPInt1 = paramString5.hZI;
      paramString4 = paramString5.icd;
      paramString5 = paramString5.ice;
      ad.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramString5.value });
      paramString5 = new g();
      paramString5.dDp = -1;
      paramString5.setLocalId(d.Ft(paramString1).incrementAndGet());
      paramString5.sd(paramLong);
      if (!bt.isNullOrNil(paramPInt1)) {
        paramString5.Fg(paramPInt1);
      }
      paramString5.pr(0);
      paramString5.setSource(paramInt2);
      if (paramInt2 != 4) {
        break label576;
      }
      if (paramString2.startsWith(com.tencent.mm.storage.aj.azE()))
      {
        paramString5.pp(3);
        label238:
        if (paramBoolean)
        {
          paramString5.Fd(paramPInt2.value + ".jpg");
          if (!bt.isNullOrNil(paramString4.value)) {
            paramString5.Fe(paramString4.value + ".jpg");
          }
          if (bt.isNullOrNil(paramString5.hZy)) {
            paramString5.Ff(paramb1);
          }
          paramString5.pn((int)com.tencent.mm.vfs.i.aYo(paramString3.value));
          if (paramString5.hMP == 0) {
            ad.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString3.value });
          }
          paramString5.Fc(str);
        }
        paramString5.setCreateTime((int)bt.aQJ());
        paramString5.ps(paramInt1);
        ad.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramString5.hMP);
        AppMethodBeat.o(195264);
        return paramString5;
      }
    }
    else
    {
      if ((parama == null) || (parama.hZz == paramInt1)) {
        break label585;
      }
      paramPInt2 = null;
    }
    for (paramPInt1 = null;; paramPInt1 = paramString5)
    {
      paramString5 = new PString();
      paramString3 = new PString();
      paramString4 = new PString();
      paramb2 = new PString();
      paramPInt1 = a(paramString1, paramString2, str, paramInt1, paramBoolean, paramString5, paramString3, paramString4, paramb2, paramPInt1, paramPInt2);
      ad.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramb2.value });
      paramPInt2 = paramString5;
      break;
      paramString5.pp(2);
      break label238;
      label576:
      paramString5.pp(1);
      break label238;
      label585:
      paramPInt2 = paramb2;
    }
  }
  
  private String a(String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(195262);
    ad.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString2 });
    if (!com.tencent.mm.vfs.i.fv(paramString2))
    {
      ad.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(195262);
      return null;
    }
    String str = paramString4;
    if (bt.isNullOrNil(paramString4)) {
      str = aIo();
    }
    str = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
    paramString4 = a(str, "th_", "", false);
    if (paramb == null) {
      paramString4 = o(str, "th_", "");
    }
    if (paramBoolean)
    {
      if ((!bt.isNullOrNil(paramString3)) && (com.tencent.mm.vfs.i.fv(paramString3))) {
        break label263;
      }
      long l = bt.HI();
      a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, true, paramString4, paramb);
      if (!com.tencent.mm.vfs.i.fv(paramString4)) {
        break label251;
      }
      com.tencent.mm.plugin.report.service.g.yhR.f(10921, new Object[] { Long.valueOf(com.tencent.mm.vfs.i.aYo(paramString4)), Long.valueOf(com.tencent.mm.vfs.i.aYo(paramString2)), Integer.valueOf(90), Long.valueOf(bt.aO(l)) });
    }
    for (;;)
    {
      ad.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
      AppMethodBeat.o(195262);
      return str;
      label251:
      ad.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
      continue;
      label263:
      com.tencent.mm.vfs.i.mz(paramString3, paramString4);
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat)
  {
    AppMethodBeat.i(150586);
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.iai.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (m == localb.iax)
      {
        ad.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.iax), localb.url });
        localb.url = paramString;
        if (!this.iam.contains(Integer.valueOf(k)))
        {
          this.iam.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(150586);
        return;
      }
    }
    this.iaj.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.iak.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    for (;;)
    {
      int j;
      if (paramView != null)
      {
        j = paramView.hashCode();
        this.ial.put(Integer.valueOf(j), new WeakReference(paramView));
      }
      for (;;)
      {
        paramImageView1 = new b(m, paramString, i, j);
        this.iai.add(paramImageView1);
        if (!this.iam.contains(Integer.valueOf(k)))
        {
          this.iam.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(150586);
        return;
        j = 0;
      }
      i = 0;
    }
  }
  
  private static void a(com.tencent.mm.storagebase.h paramh, String paramString)
  {
    AppMethodBeat.i(195247);
    Cursor localCursor = paramh.a("PRAGMA table_info(" + paramString + ")", null, 2);
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
      long l = com.tencent.mm.kernel.g.ajC().gBq.xO(Thread.currentThread().getId());
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
        com.tencent.mm.kernel.g.ajC().gBq.sJ(l);
      }
      AppMethodBeat.o(195247);
      return;
    }
  }
  
  public static String aIo()
  {
    try
    {
      AppMethodBeat.i(150620);
      String str = Fr("");
      AppMethodBeat.o(150620);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private long b(String paramString, g paramg)
  {
    AppMethodBeat.i(195258);
    paramString = d.Fu(paramString);
    long l = this.hHS.ftT().insertOrThrow(paramString, "id", paramg.convertTo());
    if (l != -1L) {
      paramg.aIl();
    }
    ad.i("MicroMsg.ImgInfoStorage", "insert img, table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString, Long.valueOf(l), Long.valueOf(paramg.dnz), Long.valueOf(paramg.hZF), Long.valueOf(paramg.dAY), Integer.valueOf(paramg.hZH) });
    AppMethodBeat.o(195258);
    return l;
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150608);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
    AppMethodBeat.o(150608);
    return paramString1;
  }
  
  private void f(final String paramString, final float paramFloat)
  {
    AppMethodBeat.i(150587);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150562);
        i.this.a(paramString, true, paramFloat, true, false, this.iau, this.iav);
        i.a(i.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150561);
            i.a(i.this, i.2.this.iat);
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
    AppMethodBeat.o(150587);
  }
  
  private g m(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195249);
    g localg = new g();
    paramString1 = a(d.Fu(paramString1), null, "origImgMD5=? AND compressType=?", new String[] { String.valueOf(paramString2), String.valueOf(paramInt) });
    if (paramString1.moveToFirst()) {
      localg.convertFrom(paramString1);
    }
    paramString1.close();
    AppMethodBeat.o(195249);
    return localg;
  }
  
  private String n(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(195259);
    paramString1 = m(paramString1, h.Fj(paramString2), paramInt);
    if (!bt.isNullOrNil(paramString1.hZy))
    {
      paramString1 = R(paramString1.hZy, true);
      if (com.tencent.mm.vfs.i.fv(paramString1))
      {
        AppMethodBeat.o(195259);
        return paramString1;
      }
    }
    AppMethodBeat.o(195259);
    return null;
  }
  
  private g se(long paramLong)
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
  
  public static String wb(String paramString)
  {
    AppMethodBeat.i(150573);
    paramString = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString));
    AppMethodBeat.o(150573);
    return paramString;
  }
  
  public final g F(String paramString, long paramLong)
  {
    AppMethodBeat.i(195251);
    g localg = new g();
    paramString = b(d.Fu(paramString), null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToFirst()) {
      localg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(195251);
    return localg;
  }
  
  public final String Fm(String paramString)
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
        paramString = pt(Integer.valueOf(paramString).intValue()).hZy;
        paramString = o(paramString, str1, "");
        AppMethodBeat.o(150574);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        ad.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
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
  
  public final String Fn(String paramString)
  {
    AppMethodBeat.i(195248);
    paramString = R(paramString, true);
    AppMethodBeat.o(195248);
    return paramString;
  }
  
  public final Bitmap Fo(String paramString)
  {
    AppMethodBeat.i(150592);
    float f = com.tencent.mm.cc.a.getDensity(com.tencent.mm.sdk.platformtools.aj.getContext());
    paramString = com.tencent.mm.sdk.platformtools.g.p(c(paramString, false, true), f);
    AppMethodBeat.o(150592);
    return paramString;
  }
  
  public final String Fp(String paramString)
  {
    AppMethodBeat.i(150615);
    paramString = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString)), "th_", "", false);
    AppMethodBeat.o(150615);
    return paramString;
  }
  
  public final String Fq(String paramString)
  {
    AppMethodBeat.i(150616);
    paramString = a(paramString, "", ".jpg", false);
    AppMethodBeat.o(150616);
    return paramString;
  }
  
  public final String Fs(String paramString)
  {
    AppMethodBeat.i(221219);
    paramString = c(paramString, false, true);
    AppMethodBeat.o(221219);
    return paramString;
  }
  
  public final g G(String paramString, long paramLong)
  {
    AppMethodBeat.i(195252);
    g localg = new g();
    paramString = b(d.Fu(paramString), null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (paramString.moveToLast()) {
      localg.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(195252);
    return localg;
  }
  
  public final g L(bu parambu)
  {
    AppMethodBeat.i(150595);
    g localg = G(parambu.field_talker, parambu.field_msgId);
    Object localObject = localg;
    if (localg.dnz == 0L)
    {
      parambu = F(parambu.field_talker, parambu.field_msgSvrId);
      localObject = parambu;
      if (parambu.dnz == 0L)
      {
        ad.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        AppMethodBeat.o(150595);
        return null;
      }
    }
    AppMethodBeat.o(150595);
    return localObject;
  }
  
  public final void M(bu parambu)
  {
    AppMethodBeat.i(150599);
    g localg = L(parambu);
    if ((localg == null) || (localg.dnz == 0L))
    {
      ad.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      AppMethodBeat.o(150599);
      return;
    }
    com.tencent.mm.vfs.i.deleteFile(o(localg.hZw, "", ""));
    com.tencent.mm.vfs.i.deleteFile(o(localg.hZB, "", ""));
    com.tencent.mm.vfs.i.deleteFile(o(localg.hZy, "", ""));
    com.tencent.mm.vfs.i.deleteFile(o(localg.hZy, "", "") + "hd");
    this.hHS.delete(d.Fu(parambu.field_talker), "id=?", new String[] { localg.dnz });
    if (localg.aIj())
    {
      localg = pt(localg.hZH);
      if (localg == null)
      {
        AppMethodBeat.o(150599);
        return;
      }
      com.tencent.mm.vfs.i.deleteFile(o(localg.hZw, "", ""));
      com.tencent.mm.vfs.i.deleteFile(o(localg.hZB, "", ""));
      com.tencent.mm.vfs.i.deleteFile(o(localg.hZy, "", ""));
      com.tencent.mm.vfs.i.deleteFile(o(localg.hZy, "", "") + "hd");
      this.hHS.delete(d.Fu(parambu.field_talker), "id=?", new String[] { localg.dnz });
    }
    AppMethodBeat.o(150599);
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
        paramString = pt(Integer.valueOf(paramString).intValue()).hZy;
        paramString = a(paramString, "", "", paramBoolean);
        AppMethodBeat.o(150581);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        ad.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150581);
        return null;
      }
      paramString = str;
    } while (!str.startsWith("THUMBNAIL_DIRPATH://"));
    paramString = a(str.substring(20).substring(3), "th_", "", paramBoolean);
    AppMethodBeat.o(150581);
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
    for (int i = 1;; i = this.hHS.update(d.sf(paramLong.longValue()), localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      ad.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString(), Integer.valueOf(i) });
      if (i != -1)
      {
        paramg.aIl();
        doNotify();
      }
      AppMethodBeat.o(150628);
      return i;
    }
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, p.a parama)
  {
    AppMethodBeat.i(195255);
    paramLong = a(paramString1, paramString2, null, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, paramString3, paramString4, paramLong, paramb1, paramb2, parama, false);
    AppMethodBeat.o(195255);
    return paramLong;
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(195254);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, 0, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null);
    AppMethodBeat.o(195254);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(195257);
    paramString1 = d.Fu(paramString1);
    long l = this.hHS.a(paramString1, paramString2, paramg.convertTo());
    if (l != -1L) {
      paramg.aIl();
    }
    ad.i("MicroMsg.ImgInfoStorage", "insert img,table:%s result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { paramString1, Long.valueOf(l), Long.valueOf(paramg.dnz), Long.valueOf(paramg.hZF), Long.valueOf(paramg.dAY), Integer.valueOf(paramg.hZH) });
    AppMethodBeat.o(195257);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(195253);
    long l = a(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, true);
    AppMethodBeat.o(195253);
    return l;
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, int paramInt, String paramString3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(195266);
    String str1 = "SERVERID://".concat(String.valueOf(paramLong));
    String str2 = com.tencent.mm.b.g.getMessageDigest(str1.getBytes());
    String str3 = o(str2, "th_", "");
    Bitmap localBitmap;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 0))
    {
      localBitmap = com.tencent.mm.sdk.platformtools.g.cr(paramArrayOfByte);
      if (localBitmap == null) {
        ad.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(paramArrayOfByte));
      }
      if ((paramBoolean) || (localBitmap == null)) {}
    }
    try
    {
      localBitmap = com.tencent.mm.sdk.platformtools.g.az(localBitmap);
      paramPInt1.value = localBitmap.getWidth();
      paramPInt2.value = localBitmap.getHeight();
      com.tencent.mm.sdk.platformtools.g.a(localBitmap, 90, Bitmap.CompressFormat.JPEG, str3, true);
      paramArrayOfByte = new g();
      if (!bt.isNullOrNil(paramString2))
      {
        paramArrayOfByte.setOffset(paramInt);
        paramArrayOfByte.pn(paramInt);
        paramArrayOfByte.dDp = -1;
        paramArrayOfByte.setLocalId(d.Ft(paramString1).incrementAndGet());
        paramArrayOfByte.Fd(paramString2);
        paramArrayOfByte.Ff("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2)));
        paramPString.value = paramArrayOfByte.hZy;
        if (paramBoolean)
        {
          paramArrayOfByte.qz(0L);
          paramArrayOfByte.ps(1);
          paramArrayOfByte.Fg(paramString3);
          paramArrayOfByte.setCreateTime((int)bt.aQJ());
          paramLong = a(paramString1, "id", paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          AppMethodBeat.o(195266);
          return paramLong;
        }
      }
    }
    catch (IOException paramPInt1)
    {
      for (;;)
      {
        ad.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + str2 + " " + new String(paramArrayOfByte));
        continue;
        paramArrayOfByte.qz(paramLong);
        paramArrayOfByte.ps(0);
        continue;
        paramString2 = str1;
      }
    }
  }
  
  public final long a(String paramString1, byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(195265);
    paramLong = a(paramString1, paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString2, paramPString, paramPInt1, paramPInt2);
    AppMethodBeat.o(195265);
    return paramLong;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150607);
    paramString1 = this.hHS.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    AppMethodBeat.o(150607);
    return paramString1;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150630);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from".concat(String.valueOf(paramLong));; str = "location_backgroup_key_tor".concat(String.valueOf(paramLong)))
    {
      Bitmap localBitmap2 = (Bitmap)this.iag.aL(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.g.s(paramString, paramInt1, paramInt2, paramInt3);
        this.iag.q(str, localBitmap1);
      }
      AppMethodBeat.o(150630);
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext)
  {
    AppMethodBeat.i(150593);
    paramString = a(paramString, paramFloat, paramContext, -1);
    AppMethodBeat.o(150593);
    return paramString;
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(150594);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(150594);
      return null;
    }
    String str = paramString.trim();
    Bitmap localBitmap = (Bitmap)this.iag.aL(str);
    int k;
    int m;
    int j;
    int i;
    if (localBitmap != null)
    {
      paramString = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      localBitmap = BackwardSupportUtil.b.o(str, paramFloat);
      if (localBitmap == null) {
        break label359;
      }
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (k < m) {
        break label278;
      }
      j = BackwardSupportUtil.b.g(paramContext, iaq);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label305;
      }
      ad.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 188L, 1L, false);
      paramString = null;
      label192:
      paramContext = paramString;
      if (paramInt != -1) {
        paramContext = com.tencent.mm.sdk.platformtools.g.k(paramString, paramInt);
      }
      if (localBitmap != paramContext)
      {
        ad.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      ad.d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(str)));
      this.iag.q(str, paramContext);
    }
    label278:
    label305:
    label359:
    for (paramString = paramContext;; paramString = localBitmap)
    {
      for (;;)
      {
        AppMethodBeat.o(150594);
        return paramString;
        i = BackwardSupportUtil.b.g(paramContext, iaq);
        j = (int)(k / m * i);
        break;
        try
        {
          paramString = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        }
        catch (Exception paramString)
        {
          ad.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[] { paramString.getMessage() });
          paramString = null;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 188L, 1L, false);
        }
      }
      break label192;
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
    AppMethodBeat.i(195250);
    if (paramg == null)
    {
      AppMethodBeat.o(195250);
      return null;
    }
    if (paramg.aIj())
    {
      paramString = d.Fu(paramString);
      paramg = paramg.hZH;
      paramg = b(paramString, new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { paramg });
      paramString = localObject;
      if (paramg.moveToFirst()) {
        paramString = paramg.getString(0);
      }
      paramg.close();
      AppMethodBeat.o(195250);
      return paramString;
    }
    AppMethodBeat.o(195250);
    return null;
  }
  
  public final String a(String paramString1, String paramString2, int paramInt1, PString paramPString, PInt paramPInt1, PInt paramPInt2, int paramInt2, String paramString3)
  {
    AppMethodBeat.i(195261);
    if (!com.tencent.mm.vfs.i.fv(paramString2))
    {
      ad.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString2 });
      AppMethodBeat.o(195261);
      return null;
    }
    String str1 = paramString3;
    if (bt.isNullOrNil(paramString3)) {
      str1 = aIo();
    }
    String str2 = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
    paramString3 = a(str2, "th_", "", false);
    paramPString.value = str2;
    long l = bt.HI();
    paramPInt1 = a(paramString1, paramString2, paramInt1, paramInt2, paramPInt1, paramPInt2, false, null, null);
    paramString1 = (String)this.iah.get(paramString2);
    if (paramString1 != null) {}
    for (paramString1 = (Bitmap)this.iag.get(paramString1);; paramString1 = null)
    {
      if (paramString1 != null)
      {
        paramPString = paramString1;
        if (!paramString1.isRecycled()) {}
      }
      else
      {
        paramPString = a(paramString2, true, com.tencent.mm.cc.a.getDensity(com.tencent.mm.sdk.platformtools.aj.getContext()), false, false, true, 2131231564, true, paramPInt1);
        this.iah.put(paramString2, paramString3);
      }
      if (paramPString != null) {
        this.iag.q(paramString3, paramPString);
      }
      ad.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(bt.aO(l)) });
      AppMethodBeat.o(195261);
      return str1;
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString4, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(195263);
    String str = paramString4;
    if (bt.isNullOrNil(paramString4))
    {
      str = Fr(paramString2);
      ad.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", new Object[] { str, paramString2 });
    }
    paramString4 = a(str, "", ".jpg", false);
    if (paramb == null) {
      paramString4 = a(str, "", ".jpg", true);
    }
    ad.i("MicroMsg.ImgInfoStorage", "fullPath is %s", new Object[] { paramString4 });
    if (com.tencent.mm.vfs.i.aYo(paramString4) > 0L)
    {
      ad.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
      com.tencent.mm.plugin.report.service.g.yhR.dD(944, 8);
    }
    paramPString1.value = str;
    paramPString2.value = paramString4;
    if ((paramBoolean) && (!bt.isNullOrNil(paramString3)) && (paramInt == 0))
    {
      paramString1 = m(paramString1, paramString3, paramInt);
      if (!bt.isNullOrNil(paramString1.hZw))
      {
        paramString3 = o(paramString1.hZw, "", "");
        if (paramb != null) {
          paramb.Ka();
        }
        com.tencent.mm.vfs.i.mz(paramString3, paramString4);
        if (com.tencent.mm.vfs.i.aYo(paramString3) > 0L)
        {
          if (!bt.isNullOrNil(paramString1.hZI))
          {
            paramString1 = paramString1.hZI;
            AppMethodBeat.o(195263);
            return paramString1;
          }
          AppMethodBeat.o(195263);
          return null;
        }
        ad.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString2, paramString4 });
      }
    }
    label1164:
    label1223:
    label3529:
    label3532:
    try
    {
      if (ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext())) {
        i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        ad.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3546;
        }
        n = 70;
        j = 0;
        m = 0;
        k = 1080;
        i = j;
        try
        {
          if (!ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext())) {
            break;
          }
          i = j;
          paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressResolutionForWifi");
          i = j;
          i1 = paramString1.indexOf("*");
          if (-1 == i1) {
            break label3538;
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
            continue;
            i = m;
            continue;
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
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.g.ajA();
          paramString1 = new p(com.tencent.mm.kernel.a.getUin());
          if ((int)(paramString1.longValue() / 100L) % 100 + 1 > i) {
            break label3532;
          }
          bool1 = true;
          ad.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Long.valueOf(paramString1.longValue()), Long.valueOf(paramString1.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.fjN()), Integer.valueOf(Build.VERSION.SDK_INT) });
        }
        catch (Exception paramString1)
        {
          int i7;
          int i4;
          for (;;)
          {
            ad.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { bt.n(paramString1) });
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
            break label1823;
          }
          k = paramString3.outWidth;
          if (paramString3.outWidth >= paramString3.outHeight) {
            break label1832;
          }
          int i2 = paramString3.outWidth;
          if (i <= 0) {
            break label1859;
          }
          int i3 = i2 / i;
          if (paramString3.outHeight <= i) {
            break label1841;
          }
          j = paramString3.outHeight * i / i2;
          if (paramString3.outWidth <= i) {
            break label1850;
          }
          i = i * paramString3.outWidth / i2;
          k = i;
          i = j;
          if (i * k <= 10240000) {
            break label3519;
          }
          double d = Math.sqrt(i * k / 10240000.0D);
          j = (int)(i / d);
          k = (int)(k / d);
          ad.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[] { Integer.valueOf(paramString3.outHeight), Integer.valueOf(paramString3.outWidth), Integer.valueOf(j), Integer.valueOf(k) });
          if (paramString3 == null) {
            break label1933;
          }
          paramString1 = paramString3.outMimeType;
          long l2 = com.tencent.mm.vfs.i.aYo(paramString2);
          boolean bool2 = MMNativeJpeg.IsJpegFile(paramString2);
          if ((paramString1 == null) || ((!paramString1.endsWith("jpeg")) && (!paramString1.endsWith("jpg")) && (!paramString1.endsWith("bmp")) && (!paramString1.endsWith("png")) && (!paramString1.endsWith("gif")))) {
            break label1940;
          }
          i2 = 1;
          if ((paramInt != 0) || ((m == 0) && (l2 <= 204800L) && ((paramString3 == null) || (i3 <= 0))) || (l2 <= i7)) {
            break label1953;
          }
          if ((i4 >= 55) && (bool2)) {
            break label3512;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            break label1946;
          }
          long l1;
          long l3;
          for (i = 18;; i = 8)
          {
            l1 = bt.flT();
            m = com.tencent.mm.sdk.platformtools.g.a(paramBoolean, paramString2, j, k, Bitmap.CompressFormat.JPEG, n, paramString4, paramb);
            if ((m == 1) || (!paramBoolean)) {
              break label3509;
            }
            i = 28;
            m = com.tencent.mm.sdk.platformtools.g.a(false, paramString2, j, k, Bitmap.CompressFormat.JPEG, n, paramString4, paramb);
            paramBoolean = false;
            l3 = com.tencent.mm.vfs.i.aYo(paramString4);
            ad.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(100L * l3 / l2), Integer.valueOf(i1), paramString4 });
            k = m;
            bool1 = paramBoolean;
            j = i;
            if (i2 != 0)
            {
              k = m;
              bool1 = paramBoolean;
              j = i;
              if ((l2 - l3) * 100L < i1 * l2)
              {
                com.tencent.mm.vfs.i.mz(paramString2, paramString4);
                bool1 = false;
                j = 48;
                k = 1;
              }
            }
            l1 = bt.flT() - l1;
            i = k;
            paramBoolean = bool1;
            if (k == 1) {
              break label2364;
            }
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 187L, 1L, false);
            ad.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString2 });
            AppMethodBeat.o(195263);
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
                break label1924;
              }
            }
            for (j = j * paramString3.outWidth / k;; j = paramString3.outWidth)
            {
              k = j;
              break;
              i = paramString3.outHeight;
              break label1887;
            }
            paramString1 = "";
            break label1439;
            i2 = 0;
            break label1508;
          }
          ad.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6) });
          if (i2 == 0) {
            break label3204;
          }
          com.tencent.mm.vfs.i.mz(paramString2, paramString4);
          com.tencent.mm.ao.f.aGI();
          if (!com.tencent.mm.ao.b.pa(256)) {
            break label3379;
          }
          if (paramInt != 1) {
            break label3388;
          }
          i = 0;
          for (;;)
          {
            for (;;)
            {
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressMidPicLevel")).intValue();
                i = m;
              }
              catch (Exception paramString1)
              {
                continue;
              }
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressMidPicSize")).intValue();
                ad.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
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
                  break label3502;
                }
                i = 800;
                if (k <= i) {
                  break label3499;
                }
                k = i;
                if (j <= i) {
                  break label3496;
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
                  paramPString3.value = Fr(paramString2);
                  paramPString4.value = a(paramPString3.value, "", ".jpg", false);
                  i = com.tencent.mm.sdk.platformtools.g.a(false, paramString2, j, k, Bitmap.CompressFormat.JPEG, i1, paramPString4.value, paramb);
                  ad.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  l1 = 0L;
                  j = 38;
                  paramBoolean = false;
                  paramString1 = com.tencent.mm.sdk.platformtools.g.aQc(paramString4);
                  if (paramString1 == null) {
                    continue;
                  }
                  k = paramString1.outWidth;
                  if (paramString1 == null) {
                    continue;
                  }
                  m = paramString1.outHeight;
                  l3 = com.tencent.mm.vfs.i.aYo(paramString4);
                  i2 = MMNativeJpeg.queryQuality(paramString4);
                  boolean bool3 = MMNativeJpeg.IsJpegFile(paramString4);
                  paramString1 = com.tencent.mm.plugin.report.service.g.yhR;
                  if (!bool2) {
                    continue;
                  }
                  i1 = 1;
                  paramString1.f(11713, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2) });
                  ad.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString2, paramString4 });
                  if ((paramInt == 0) && (l3 >= 40960L) && (bool3) && (!MMNativeJpeg.isProgressive(paramString4)))
                  {
                    paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("EnableCDNUploadImg");
                    if ((!bt.isNullOrNil(paramString1)) && (paramString1.equals("1")))
                    {
                      l1 = bt.flT();
                      if (!paramBoolean) {
                        continue;
                      }
                      j = 19;
                      paramString1 = paramString4 + ".prog";
                      com.tencent.mm.vfs.i.mz(paramString4, paramString1);
                      if ((!bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(paramString4)) && (com.tencent.mm.vfs.i.fv(paramString1))) {
                        continue;
                      }
                      bool1 = false;
                      com.tencent.mm.vfs.i.deleteFile(paramString1);
                      if (bool1) {
                        break label3493;
                      }
                      bool1 = MMNativeJpeg.convertToProgressive(paramString4, n);
                      j = 29;
                      long l4 = bt.flT();
                      long l5 = com.tencent.mm.vfs.i.aYo(paramString4);
                      paramString1 = com.tencent.mm.plugin.report.service.g.yhR;
                      if (!bool1) {
                        continue;
                      }
                      n = 1;
                      if (!bool2) {
                        continue;
                      }
                      i1 = 1;
                      paramString1.f(11713, new Object[] { Integer.valueOf(n), Long.valueOf(l4 - l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2), Long.valueOf(l5) });
                      ad.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString2, paramString4 });
                      if (!bool1)
                      {
                        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 186L, 1L, false);
                        ad.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString4 });
                      }
                    }
                  }
                  AppMethodBeat.o(195263);
                  return null;
                  if (com.tencent.mm.sdk.platformtools.g.a(false, paramString2, i5, i6, Bitmap.CompressFormat.JPEG, 100, paramString4, paramb) == 1) {
                    break;
                  }
                  com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(111L, 187L, 1L, false);
                  ad.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString2 });
                  AppMethodBeat.o(195263);
                  return null;
                }
              }
              catch (Exception paramString1)
              {
                m = 0;
                continue;
                paramPString3.value = paramPString1.value;
                paramPString4.value = paramPString2.value;
                ad.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(j), Integer.valueOf(k), paramPString3.value, paramPString4.value });
                l1 = 0L;
                i = 1;
                j = 38;
                paramBoolean = false;
              }
            }
            ad.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
            l1 = 0L;
            i = 1;
            j = 38;
            paramBoolean = false;
            continue;
            k = -1;
            continue;
            m = -1;
            continue;
            i1 = 2;
            continue;
            if (MMJpegOptim.convertToProgressive(com.tencent.mm.b.q.k(paramString1, false), com.tencent.mm.b.q.k(paramString4, false), n) == 0)
            {
              bool1 = true;
            }
            else
            {
              bool1 = false;
              continue;
              j = 9;
              bool1 = MMNativeJpeg.convertToProgressive(paramString4, n);
              continue;
              n = -1;
              continue;
              i1 = 2;
            }
          }
        }
        if (com.tencent.mm.sdk.a.b.fjN()) {
          bool1 = true;
        }
        if (!com.tencent.mm.compatible.util.d.lz(16)) {
          break label3529;
        }
        bool1 = false;
        ad.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        if ((m > 0) || (k > 0)) {
          break label1164;
        }
        j = 0;
        i = 1080;
        m = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        k = m;
        if (m <= 0) {
          k = 100;
        }
        i7 = k * 1024;
        i1 = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((i1 > 0) && (i1 < 100)) {
          break label3526;
        }
        i1 = 10;
        i4 = MMNativeJpeg.queryQuality(paramString2);
        k = 1;
        m = k;
        if (i4 != 0)
        {
          m = k;
          if (i4 <= n) {
            m = 0;
          }
        }
        ad.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[] { paramString2, paramString4, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i7), Integer.valueOf(i1) });
        if (!paramBoolean) {
          break label3196;
        }
        paramString3 = com.tencent.mm.sdk.platformtools.g.aQc(paramString2);
        if ((paramString3 != null) && (paramString3.outWidth != 0) && (paramString3.outHeight != 0)) {
          break label1229;
        }
        if (paramString3 != null) {
          break label1223;
        }
        paramBoolean = true;
        ad.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString2, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(195263);
        return null;
        if (ay.is2G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressPicLevelFor2G"), 40);
        } else if (ay.is3G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception paramString1)
    {
      label1229:
      label3538:
      label3546:
      for (;;)
      {
        int n;
        int j;
        int m;
        int k;
        int i = 0;
        continue;
        i = j;
        label1887:
        if (ay.is2G(com.tencent.mm.sdk.platformtools.aj.getContext()))
        {
          i = j;
          paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          label1508:
          if (ay.is3G(com.tencent.mm.sdk.platformtools.aj.getContext()))
          {
            i = j;
            paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressResolutionFor3G");
          }
          else
          {
            i = j;
            paramString1 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA().getValue("CompressResolutionFor4G");
            continue;
            label1275:
            label3196:
            n = i;
          }
        }
      }
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(150570);
    if (bt.isNullOrNil(paramString1))
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
          str1 = se(Long.valueOf(str1).longValue()).hZw;
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = com.tencent.mm.plugin.image.d.azA();
            String str4 = com.tencent.mm.plugin.image.d.azB();
            String str2 = str1;
            if (bt.isNullOrNil(str1)) {
              str2 = paramString1;
            }
            paramString1 = m.b(str3, str4, paramString2, str2, paramString3, paramBoolean);
            AppMethodBeat.o(150570);
            return paramString1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          ad.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString1.getMessage());
          AppMethodBeat.o(150570);
          return null;
        }
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(150576);
    if (bt.cC(paramArrayOfByte))
    {
      ad.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(150576);
      return null;
    }
    String str1 = aIo();
    String str2 = o(str1, "th_", "");
    ad.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[] { str2 });
    try
    {
      com.tencent.mm.sdk.platformtools.g.a(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length), 100, paramCompressFormat, str2, true);
      paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
      AppMethodBeat.o(150576);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      ad.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localIOException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(150576);
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(150576);
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1542
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1525	com/tencent/mm/sdk/platformtools/bt:cC	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 284
    //   16: ldc_w 1527
    //   19: invokestatic 813	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1542
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 777	com/tencent/mm/aw/i:aIo	()Ljava/lang/String;
    //   38: astore 16
    //   40: aload_0
    //   41: aload 16
    //   43: ldc_w 787
    //   46: ldc_w 356
    //   49: invokevirtual 359	com/tencent/mm/aw/i:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 17
    //   54: new 200	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   61: aload 17
    //   63: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1544
    //   69: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 15
    //   77: ldc_w 284
    //   80: ldc_w 1546
    //   83: aload 17
    //   85: invokestatic 782	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 785	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1366	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1547	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1551	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1554	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aconst_null
    //   124: astore 13
    //   126: aload 15
    //   128: iconst_0
    //   129: invokestatic 1558	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   132: astore 12
    //   134: aload 12
    //   136: astore 13
    //   138: aload 12
    //   140: aload_1
    //   141: invokevirtual 1563	java/io/OutputStream:write	([B)V
    //   144: aload 12
    //   146: astore 13
    //   148: aload 12
    //   150: invokevirtual 1566	java/io/OutputStream:flush	()V
    //   153: aload 12
    //   155: astore 13
    //   157: aload_1
    //   158: iload_3
    //   159: iload 4
    //   161: invokestatic 1567	com/tencent/mm/sdk/platformtools/g:decodeByteArray	([BII)Landroid/graphics/Bitmap;
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
    //   191: ldc_w 1568
    //   194: if_icmple +535 -> 729
    //   197: new 1570	java/io/ByteArrayOutputStream
    //   200: dup
    //   201: invokespecial 1571	java/io/ByteArrayOutputStream:<init>	()V
    //   204: astore 14
    //   206: aload 14
    //   208: astore 13
    //   210: aload 19
    //   212: aload_2
    //   213: bipush 100
    //   215: aload 14
    //   217: invokevirtual 1575	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   220: pop
    //   221: aload 14
    //   223: astore 13
    //   225: aload 14
    //   227: invokevirtual 1578	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   230: arraylength
    //   231: istore 4
    //   233: bipush 100
    //   235: istore_3
    //   236: aload 14
    //   238: astore 13
    //   240: iload_3
    //   241: istore 7
    //   243: aload 14
    //   245: invokevirtual 1578	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   248: arraylength
    //   249: ldc_w 1568
    //   252: if_icmple +64 -> 316
    //   255: iload_3
    //   256: bipush 15
    //   258: if_icmplt +58 -> 316
    //   261: aload 14
    //   263: astore 13
    //   265: iload_3
    //   266: istore 7
    //   268: aload 14
    //   270: invokevirtual 1581	java/io/ByteArrayOutputStream:reset	()V
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
    //   290: invokevirtual 1575	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   293: pop
    //   294: aload 14
    //   296: astore 13
    //   298: iload_3
    //   299: istore 7
    //   301: aload 14
    //   303: invokevirtual 1578	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   306: arraylength
    //   307: istore 8
    //   309: iload 8
    //   311: istore 4
    //   313: goto -77 -> 236
    //   316: aload 12
    //   318: astore 13
    //   320: aload 14
    //   322: invokevirtual 1582	java/io/ByteArrayOutputStream:close	()V
    //   325: aload 12
    //   327: astore 13
    //   329: aload 19
    //   331: iload_3
    //   332: aload_2
    //   333: aload 17
    //   335: iconst_1
    //   336: invokestatic 598	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   339: pop
    //   340: aload 12
    //   342: astore 13
    //   344: ldc_w 284
    //   347: ldc_w 1584
    //   350: iconst_3
    //   351: anewarray 106	java/lang/Object
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
    //   367: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   370: aastore
    //   371: invokestatic 385	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: aload 12
    //   376: astore 13
    //   378: getstatic 801	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   381: sipush 16498
    //   384: bipush 10
    //   386: anewarray 106	java/lang/Object
    //   389: dup
    //   390: iconst_0
    //   391: aload 5
    //   393: invokestatic 1587	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   396: ldc_w 1589
    //   399: invokestatic 1595	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   402: aastore
    //   403: dup
    //   404: iconst_1
    //   405: iload 6
    //   407: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   410: aastore
    //   411: dup
    //   412: iconst_2
    //   413: iload 9
    //   415: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   418: aastore
    //   419: dup
    //   420: iconst_3
    //   421: aload 18
    //   423: getfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   426: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   429: aastore
    //   430: dup
    //   431: iconst_4
    //   432: aload 18
    //   434: getfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   437: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   440: aastore
    //   441: dup
    //   442: iconst_5
    //   443: iload 4
    //   445: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   448: aastore
    //   449: dup
    //   450: bipush 6
    //   452: aload 19
    //   454: invokevirtual 566	android/graphics/Bitmap:getHeight	()I
    //   457: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: aastore
    //   461: dup
    //   462: bipush 7
    //   464: aload 19
    //   466: invokevirtual 561	android/graphics/Bitmap:getWidth	()I
    //   469: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   472: aastore
    //   473: dup
    //   474: bipush 8
    //   476: iconst_0
    //   477: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: aastore
    //   481: dup
    //   482: bipush 9
    //   484: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   487: lload 10
    //   489: lsub
    //   490: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   493: aastore
    //   494: invokevirtual 807	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   497: aload 15
    //   499: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   502: ifeq +18 -> 520
    //   505: ldc_w 284
    //   508: ldc_w 1597
    //   511: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload 15
    //   516: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   519: pop
    //   520: aload 12
    //   522: ifnull +8 -> 530
    //   525: aload 12
    //   527: invokevirtual 1598	java/io/OutputStream:close	()V
    //   530: ldc_w 779
    //   533: aload 16
    //   535: invokestatic 782	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   538: invokevirtual 785	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   541: astore_1
    //   542: ldc_w 1542
    //   545: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: aload_1
    //   549: areturn
    //   550: astore 13
    //   552: goto -227 -> 325
    //   555: astore 13
    //   557: aconst_null
    //   558: astore 14
    //   560: aload 14
    //   562: astore 13
    //   564: ldc_w 284
    //   567: ldc_w 1600
    //   570: invokestatic 813	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: iload 7
    //   575: istore_3
    //   576: iload 8
    //   578: istore 4
    //   580: aload 14
    //   582: ifnull -257 -> 325
    //   585: aload 12
    //   587: astore 13
    //   589: aload 14
    //   591: invokevirtual 1582	java/io/ByteArrayOutputStream:close	()V
    //   594: iload 7
    //   596: istore_3
    //   597: iload 8
    //   599: istore 4
    //   601: goto -276 -> 325
    //   604: astore 13
    //   606: iload 7
    //   608: istore_3
    //   609: iload 8
    //   611: istore 4
    //   613: goto -288 -> 325
    //   616: astore 5
    //   618: aconst_null
    //   619: astore 14
    //   621: aload 14
    //   623: ifnull +12 -> 635
    //   626: aload 12
    //   628: astore 13
    //   630: aload 14
    //   632: invokevirtual 1582	java/io/ByteArrayOutputStream:close	()V
    //   635: aload 12
    //   637: astore 13
    //   639: ldc_w 1542
    //   642: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   645: aload 12
    //   647: astore 13
    //   649: aload 5
    //   651: athrow
    //   652: astore 13
    //   654: aload 12
    //   656: astore 5
    //   658: aload 13
    //   660: astore 12
    //   662: ldc_w 284
    //   665: ldc_w 1537
    //   668: iconst_1
    //   669: anewarray 106	java/lang/Object
    //   672: dup
    //   673: iconst_0
    //   674: aload 12
    //   676: aastore
    //   677: invokestatic 679	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   680: aload_0
    //   681: aload_1
    //   682: iconst_1
    //   683: aload_2
    //   684: invokevirtual 1540	com/tencent/mm/aw/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   687: astore_1
    //   688: aload 15
    //   690: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   693: ifeq +18 -> 711
    //   696: ldc_w 284
    //   699: ldc_w 1597
    //   702: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   705: aload 15
    //   707: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   710: pop
    //   711: aload 5
    //   713: ifnull +8 -> 721
    //   716: aload 5
    //   718: invokevirtual 1598	java/io/OutputStream:close	()V
    //   721: ldc_w 1542
    //   724: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   727: aload_1
    //   728: areturn
    //   729: aload 12
    //   731: astore 13
    //   733: aload 15
    //   735: aload 17
    //   737: invokestatic 1603	com/tencent/mm/vfs/i:mA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   740: pop
    //   741: iload 7
    //   743: istore_3
    //   744: iload 8
    //   746: istore 4
    //   748: goto -408 -> 340
    //   751: astore 5
    //   753: aload 12
    //   755: astore 13
    //   757: ldc_w 284
    //   760: ldc_w 1537
    //   763: iconst_1
    //   764: anewarray 106	java/lang/Object
    //   767: dup
    //   768: iconst_0
    //   769: aload 5
    //   771: aastore
    //   772: invokestatic 679	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   775: aload 12
    //   777: astore 13
    //   779: aload_0
    //   780: aload_1
    //   781: iconst_1
    //   782: aload_2
    //   783: invokevirtual 1540	com/tencent/mm/aw/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   786: astore_1
    //   787: aload 15
    //   789: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   792: ifeq +18 -> 810
    //   795: ldc_w 284
    //   798: ldc_w 1597
    //   801: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   804: aload 15
    //   806: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   809: pop
    //   810: aload 12
    //   812: ifnull +8 -> 820
    //   815: aload 12
    //   817: invokevirtual 1598	java/io/OutputStream:close	()V
    //   820: ldc_w 1542
    //   823: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   826: aload_1
    //   827: areturn
    //   828: astore_1
    //   829: aconst_null
    //   830: astore 13
    //   832: aload 15
    //   834: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   837: ifeq +18 -> 855
    //   840: ldc_w 284
    //   843: ldc_w 1597
    //   846: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   849: aload 15
    //   851: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   854: pop
    //   855: aload 13
    //   857: ifnull +8 -> 865
    //   860: aload 13
    //   862: invokevirtual 1598	java/io/OutputStream:close	()V
    //   865: ldc_w 1542
    //   868: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   871: aload_1
    //   872: athrow
    //   873: astore 13
    //   875: goto -240 -> 635
    //   878: astore_1
    //   879: goto -349 -> 530
    //   882: astore_2
    //   883: goto -162 -> 721
    //   886: astore_2
    //   887: goto -67 -> 820
    //   890: astore_2
    //   891: goto -26 -> 865
    //   894: astore_1
    //   895: goto -63 -> 832
    //   898: astore_1
    //   899: aload 5
    //   901: astore 13
    //   903: goto -71 -> 832
    //   906: astore 5
    //   908: aconst_null
    //   909: astore 12
    //   911: goto -158 -> 753
    //   914: astore 12
    //   916: aload 13
    //   918: astore 5
    //   920: goto -258 -> 662
    //   923: astore 5
    //   925: aload 13
    //   927: astore 14
    //   929: goto -308 -> 621
    //   932: astore 13
    //   934: goto -374 -> 560
    //   937: astore 13
    //   939: iload 4
    //   941: istore 8
    //   943: goto -383 -> 560
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	946	0	this	i
    //   0	946	1	paramArrayOfByte	byte[]
    //   0	946	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	946	3	paramInt1	int
    //   0	946	4	paramInt2	int
    //   0	946	5	paramString	String
    //   0	946	6	paramBoolean	boolean
    //   181	561	7	i	int
    //   172	770	8	j	int
    //   96	318	9	k	int
    //   33	455	10	l	long
    //   132	778	12	localObject1	Object
    //   914	1	12	localIOException1	IOException
    //   124	253	13	localObject2	Object
    //   550	1	13	localException1	Exception
    //   555	1	13	localException2	Exception
    //   562	26	13	localObject3	Object
    //   604	1	13	localException3	Exception
    //   628	20	13	localObject4	Object
    //   652	7	13	localIOException2	IOException
    //   731	130	13	localObject5	Object
    //   873	1	13	localException4	Exception
    //   901	25	13	str1	String
    //   932	1	13	localException5	Exception
    //   937	1	13	localException6	Exception
    //   204	724	14	localObject6	Object
    //   75	775	15	str2	String
    //   38	496	16	str3	String
    //   52	684	17	str4	String
    //   105	328	18	localOptions	BitmapFactory.Options
    //   164	301	19	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   320	325	550	java/lang/Exception
    //   197	206	555	java/lang/Exception
    //   589	594	604	java/lang/Exception
    //   197	206	616	finally
    //   138	144	652	java/io/IOException
    //   148	153	652	java/io/IOException
    //   157	166	652	java/io/IOException
    //   170	174	652	java/io/IOException
    //   187	190	652	java/io/IOException
    //   320	325	652	java/io/IOException
    //   329	340	652	java/io/IOException
    //   344	374	652	java/io/IOException
    //   378	497	652	java/io/IOException
    //   589	594	652	java/io/IOException
    //   630	635	652	java/io/IOException
    //   639	645	652	java/io/IOException
    //   649	652	652	java/io/IOException
    //   733	741	652	java/io/IOException
    //   138	144	751	java/lang/Exception
    //   148	153	751	java/lang/Exception
    //   157	166	751	java/lang/Exception
    //   170	174	751	java/lang/Exception
    //   187	190	751	java/lang/Exception
    //   329	340	751	java/lang/Exception
    //   344	374	751	java/lang/Exception
    //   378	497	751	java/lang/Exception
    //   639	645	751	java/lang/Exception
    //   649	652	751	java/lang/Exception
    //   733	741	751	java/lang/Exception
    //   126	134	828	finally
    //   630	635	873	java/lang/Exception
    //   525	530	878	java/lang/Exception
    //   716	721	882	java/lang/Exception
    //   815	820	886	java/lang/Exception
    //   860	865	890	java/lang/Exception
    //   138	144	894	finally
    //   148	153	894	finally
    //   157	166	894	finally
    //   170	174	894	finally
    //   187	190	894	finally
    //   320	325	894	finally
    //   329	340	894	finally
    //   344	374	894	finally
    //   378	497	894	finally
    //   589	594	894	finally
    //   630	635	894	finally
    //   639	645	894	finally
    //   649	652	894	finally
    //   733	741	894	finally
    //   757	775	894	finally
    //   779	787	894	finally
    //   662	688	898	finally
    //   126	134	906	java/lang/Exception
    //   126	134	914	java/io/IOException
    //   210	221	923	finally
    //   225	233	923	finally
    //   243	255	923	finally
    //   268	273	923	finally
    //   284	294	923	finally
    //   301	309	923	finally
    //   564	573	923	finally
    //   210	221	932	java/lang/Exception
    //   225	233	932	java/lang/Exception
    //   243	255	937	java/lang/Exception
    //   268	273	937	java/lang/Exception
    //   284	294	937	java/lang/Exception
    //   301	309	937	java/lang/Exception
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1605
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1525	com/tencent/mm/sdk/platformtools/bt:cC	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 284
    //   16: ldc_w 1527
    //   19: invokestatic 813	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1605
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   33: lstore 10
    //   35: invokestatic 777	com/tencent/mm/aw/i:aIo	()Ljava/lang/String;
    //   38: astore 17
    //   40: aload_0
    //   41: aload 17
    //   43: ldc_w 787
    //   46: ldc_w 356
    //   49: invokevirtual 359	com/tencent/mm/aw/i:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore 19
    //   54: new 200	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   61: aload 19
    //   63: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 1544
    //   69: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: astore 16
    //   77: ldc_w 284
    //   80: ldc_w 1546
    //   83: aload 19
    //   85: invokestatic 782	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 785	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: arraylength
    //   96: istore 9
    //   98: new 1366	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 1547	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 18
    //   107: aload 18
    //   109: iconst_1
    //   110: putfield 1551	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   113: aload_1
    //   114: iconst_0
    //   115: aload_1
    //   116: arraylength
    //   117: aload 18
    //   119: invokestatic 1554	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   122: pop
    //   123: aload 18
    //   125: getfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   128: istore 7
    //   130: aload 18
    //   132: getfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   135: istore 6
    //   137: sipush 720
    //   140: iload 7
    //   142: if_icmpgt +13 -> 155
    //   145: ldc_w 1606
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
    //   165: invokestatic 1558	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   168: astore 12
    //   170: aload 12
    //   172: astore 13
    //   174: aload 12
    //   176: aload_1
    //   177: invokevirtual 1563	java/io/OutputStream:write	([B)V
    //   180: aload 12
    //   182: astore 13
    //   184: aload 12
    //   186: invokevirtual 1566	java/io/OutputStream:flush	()V
    //   189: aload 12
    //   191: astore 13
    //   193: aload_1
    //   194: iload 5
    //   196: iload 6
    //   198: invokestatic 1567	com/tencent/mm/sdk/platformtools/g:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   201: astore 14
    //   203: aload 12
    //   205: astore 13
    //   207: iload 5
    //   209: aload 14
    //   211: invokevirtual 561	android/graphics/Bitmap:getWidth	()I
    //   214: if_icmpeq +240 -> 454
    //   217: aload 12
    //   219: astore 13
    //   221: aload 14
    //   223: iload 5
    //   225: iload 6
    //   227: iconst_1
    //   228: invokestatic 651	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   231: astore 14
    //   233: aload 12
    //   235: astore 13
    //   237: aload 14
    //   239: invokevirtual 566	android/graphics/Bitmap:getHeight	()I
    //   242: i2f
    //   243: aload 14
    //   245: invokevirtual 561	android/graphics/Bitmap:getWidth	()I
    //   248: i2f
    //   249: ldc_w 1607
    //   252: fmul
    //   253: fcmpl
    //   254: ifle +203 -> 457
    //   257: aload 12
    //   259: astore 13
    //   261: aload 14
    //   263: iconst_0
    //   264: iconst_0
    //   265: aload 14
    //   267: invokevirtual 561	android/graphics/Bitmap:getWidth	()I
    //   270: aload 14
    //   272: invokevirtual 561	android/graphics/Bitmap:getWidth	()I
    //   275: i2f
    //   276: ldc_w 1607
    //   279: fmul
    //   280: f2i
    //   281: invokestatic 1611	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
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
    //   303: new 1570	java/io/ByteArrayOutputStream
    //   306: dup
    //   307: invokespecial 1571	java/io/ByteArrayOutputStream:<init>	()V
    //   310: astore 14
    //   312: aload 14
    //   314: astore 13
    //   316: aload 15
    //   318: aload_2
    //   319: bipush 70
    //   321: aload 14
    //   323: invokevirtual 1575	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   326: pop
    //   327: aload 14
    //   329: astore 13
    //   331: aload 14
    //   333: invokevirtual 1578	java/io/ByteArrayOutputStream:toByteArray	()[B
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
    //   357: invokevirtual 1578	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   360: arraylength
    //   361: ldc_w 1568
    //   364: if_icmple +125 -> 489
    //   367: iload 5
    //   369: bipush 15
    //   371: if_icmplt +118 -> 489
    //   374: aload 14
    //   376: astore 13
    //   378: iload 5
    //   380: istore 7
    //   382: aload 14
    //   384: invokevirtual 1581	java/io/ByteArrayOutputStream:reset	()V
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
    //   408: invokevirtual 1575	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   411: pop
    //   412: aload 14
    //   414: astore 13
    //   416: iload 5
    //   418: istore 7
    //   420: aload 14
    //   422: invokevirtual 1578	java/io/ByteArrayOutputStream:toByteArray	()[B
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
    //   467: invokevirtual 566	android/graphics/Bitmap:getHeight	()I
    //   470: i2f
    //   471: ldc_w 1607
    //   474: fdiv
    //   475: f2i
    //   476: aload 14
    //   478: invokevirtual 566	android/graphics/Bitmap:getHeight	()I
    //   481: invokestatic 1611	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   484: astore 15
    //   486: goto -200 -> 286
    //   489: aload 12
    //   491: astore 13
    //   493: aload 14
    //   495: invokevirtual 1582	java/io/ByteArrayOutputStream:close	()V
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
    //   518: invokestatic 598	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   521: pop
    //   522: aload 12
    //   524: astore 13
    //   526: ldc_w 284
    //   529: ldc_w 1584
    //   532: iconst_3
    //   533: anewarray 106	java/lang/Object
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
    //   550: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   553: aastore
    //   554: invokestatic 385	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: aload 12
    //   559: astore 13
    //   561: getstatic 801	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   564: astore 14
    //   566: aload 12
    //   568: astore 13
    //   570: aload_3
    //   571: invokestatic 1587	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   574: ldc_w 1589
    //   577: invokestatic 1595	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   580: astore_3
    //   581: iload 4
    //   583: ifeq +356 -> 939
    //   586: iconst_1
    //   587: istore 5
    //   589: aload 12
    //   591: astore 13
    //   593: aload 14
    //   595: sipush 16498
    //   598: bipush 10
    //   600: anewarray 106	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: aload_3
    //   606: aastore
    //   607: dup
    //   608: iconst_1
    //   609: iload 5
    //   611: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   614: aastore
    //   615: dup
    //   616: iconst_2
    //   617: iload 9
    //   619: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: aastore
    //   623: dup
    //   624: iconst_3
    //   625: aload 18
    //   627: getfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   630: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   633: aastore
    //   634: dup
    //   635: iconst_4
    //   636: aload 18
    //   638: getfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   641: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   644: aastore
    //   645: dup
    //   646: iconst_5
    //   647: iload 8
    //   649: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   652: aastore
    //   653: dup
    //   654: bipush 6
    //   656: aload 15
    //   658: invokevirtual 566	android/graphics/Bitmap:getHeight	()I
    //   661: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   664: aastore
    //   665: dup
    //   666: bipush 7
    //   668: aload 15
    //   670: invokevirtual 561	android/graphics/Bitmap:getWidth	()I
    //   673: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   676: aastore
    //   677: dup
    //   678: bipush 8
    //   680: iconst_1
    //   681: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   684: aastore
    //   685: dup
    //   686: bipush 9
    //   688: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   691: lload 10
    //   693: lsub
    //   694: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   697: aastore
    //   698: invokevirtual 807	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   701: aload 16
    //   703: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   706: ifeq +18 -> 724
    //   709: ldc_w 284
    //   712: ldc_w 1597
    //   715: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload 16
    //   720: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   723: pop
    //   724: aload 12
    //   726: ifnull +8 -> 734
    //   729: aload 12
    //   731: invokevirtual 1598	java/io/OutputStream:close	()V
    //   734: ldc_w 779
    //   737: aload 17
    //   739: invokestatic 782	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   742: invokevirtual 785	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   745: astore_1
    //   746: ldc_w 1605
    //   749: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   752: aload_1
    //   753: areturn
    //   754: astore 13
    //   756: iload 5
    //   758: istore 7
    //   760: iload 6
    //   762: istore 8
    //   764: goto -258 -> 506
    //   767: astore 13
    //   769: aconst_null
    //   770: astore 14
    //   772: aload 14
    //   774: astore 13
    //   776: ldc_w 284
    //   779: ldc_w 1600
    //   782: invokestatic 813	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   785: iload 5
    //   787: istore 7
    //   789: iload 6
    //   791: istore 8
    //   793: aload 14
    //   795: ifnull -289 -> 506
    //   798: aload 12
    //   800: astore 13
    //   802: aload 14
    //   804: invokevirtual 1582	java/io/ByteArrayOutputStream:close	()V
    //   807: iload 5
    //   809: istore 7
    //   811: iload 6
    //   813: istore 8
    //   815: goto -309 -> 506
    //   818: astore 13
    //   820: iload 5
    //   822: istore 7
    //   824: iload 6
    //   826: istore 8
    //   828: goto -322 -> 506
    //   831: astore_3
    //   832: aconst_null
    //   833: astore 14
    //   835: aload 14
    //   837: ifnull +12 -> 849
    //   840: aload 12
    //   842: astore 13
    //   844: aload 14
    //   846: invokevirtual 1582	java/io/ByteArrayOutputStream:close	()V
    //   849: aload 12
    //   851: astore 13
    //   853: ldc_w 1605
    //   856: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   859: aload 12
    //   861: astore 13
    //   863: aload_3
    //   864: athrow
    //   865: astore 13
    //   867: aload 12
    //   869: astore_3
    //   870: aload 13
    //   872: astore 12
    //   874: ldc_w 284
    //   877: ldc_w 1537
    //   880: iconst_1
    //   881: anewarray 106	java/lang/Object
    //   884: dup
    //   885: iconst_0
    //   886: aload 12
    //   888: aastore
    //   889: invokestatic 679	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   892: aload_0
    //   893: aload_1
    //   894: iconst_1
    //   895: aload_2
    //   896: invokevirtual 1540	com/tencent/mm/aw/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   899: astore_1
    //   900: aload 16
    //   902: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   905: ifeq +18 -> 923
    //   908: ldc_w 284
    //   911: ldc_w 1597
    //   914: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   917: aload 16
    //   919: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   922: pop
    //   923: aload_3
    //   924: ifnull +7 -> 931
    //   927: aload_3
    //   928: invokevirtual 1598	java/io/OutputStream:close	()V
    //   931: ldc_w 1605
    //   934: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   937: aload_1
    //   938: areturn
    //   939: iconst_0
    //   940: istore 5
    //   942: goto -353 -> 589
    //   945: astore_3
    //   946: aconst_null
    //   947: astore 12
    //   949: aload 12
    //   951: astore 13
    //   953: ldc_w 284
    //   956: ldc_w 1537
    //   959: iconst_1
    //   960: anewarray 106	java/lang/Object
    //   963: dup
    //   964: iconst_0
    //   965: aload_3
    //   966: aastore
    //   967: invokestatic 679	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   970: aload 12
    //   972: astore 13
    //   974: aload_0
    //   975: aload_1
    //   976: iconst_1
    //   977: aload_2
    //   978: invokevirtual 1540	com/tencent/mm/aw/i:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   981: astore_1
    //   982: aload 16
    //   984: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   987: ifeq +18 -> 1005
    //   990: ldc_w 284
    //   993: ldc_w 1597
    //   996: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   999: aload 16
    //   1001: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   1004: pop
    //   1005: aload 12
    //   1007: ifnull +8 -> 1015
    //   1010: aload 12
    //   1012: invokevirtual 1598	java/io/OutputStream:close	()V
    //   1015: ldc_w 1605
    //   1018: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1021: aload_1
    //   1022: areturn
    //   1023: astore_1
    //   1024: aconst_null
    //   1025: astore 13
    //   1027: aload 16
    //   1029: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   1032: ifeq +18 -> 1050
    //   1035: ldc_w 284
    //   1038: ldc_w 1597
    //   1041: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1044: aload 16
    //   1046: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   1049: pop
    //   1050: aload 13
    //   1052: ifnull +8 -> 1060
    //   1055: aload 13
    //   1057: invokevirtual 1598	java/io/OutputStream:close	()V
    //   1060: ldc_w 1605
    //   1063: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1066: aload_1
    //   1067: athrow
    //   1068: astore 13
    //   1070: goto -221 -> 849
    //   1073: astore_1
    //   1074: goto -340 -> 734
    //   1077: astore_2
    //   1078: goto -147 -> 931
    //   1081: astore_2
    //   1082: goto -67 -> 1015
    //   1085: astore_2
    //   1086: goto -26 -> 1060
    //   1089: astore_1
    //   1090: goto -63 -> 1027
    //   1093: astore_1
    //   1094: aload_3
    //   1095: astore 13
    //   1097: goto -70 -> 1027
    //   1100: astore_3
    //   1101: goto -152 -> 949
    //   1104: astore 12
    //   1106: aload 13
    //   1108: astore_3
    //   1109: goto -235 -> 874
    //   1112: astore_3
    //   1113: aload 13
    //   1115: astore 14
    //   1117: goto -282 -> 835
    //   1120: astore 13
    //   1122: goto -350 -> 772
    //   1125: astore 13
    //   1127: iload 7
    //   1129: istore 5
    //   1131: goto -359 -> 772
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1134	0	this	i
    //   0	1134	1	paramArrayOfByte	byte[]
    //   0	1134	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	1134	3	paramString	String
    //   0	1134	4	paramBoolean	boolean
    //   157	973	5	i	int
    //   135	690	6	j	int
    //   128	1000	7	k	int
    //   426	401	8	m	int
    //   96	522	9	n	int
    //   33	659	10	l	long
    //   168	843	12	localObject1	Object
    //   1104	1	12	localIOException1	IOException
    //   160	432	13	localObject2	Object
    //   754	1	13	localException1	Exception
    //   767	1	13	localException2	Exception
    //   774	27	13	localObject3	Object
    //   818	1	13	localException3	Exception
    //   842	20	13	localObject4	Object
    //   865	6	13	localIOException2	IOException
    //   951	105	13	localObject5	Object
    //   1068	1	13	localException4	Exception
    //   1095	19	13	str1	String
    //   1120	1	13	localException5	Exception
    //   1125	1	13	localException6	Exception
    //   201	915	14	localObject6	Object
    //   284	385	15	localBitmap	Bitmap
    //   75	970	16	str2	String
    //   38	700	17	str3	String
    //   105	532	18	localOptions	BitmapFactory.Options
    //   52	492	19	str4	String
    // Exception table:
    //   from	to	target	type
    //   493	498	754	java/lang/Exception
    //   303	312	767	java/lang/Exception
    //   802	807	818	java/lang/Exception
    //   303	312	831	finally
    //   174	180	865	java/io/IOException
    //   184	189	865	java/io/IOException
    //   193	203	865	java/io/IOException
    //   207	217	865	java/io/IOException
    //   221	233	865	java/io/IOException
    //   237	257	865	java/io/IOException
    //   261	286	865	java/io/IOException
    //   290	294	865	java/io/IOException
    //   461	486	865	java/io/IOException
    //   493	498	865	java/io/IOException
    //   510	522	865	java/io/IOException
    //   526	557	865	java/io/IOException
    //   561	566	865	java/io/IOException
    //   570	581	865	java/io/IOException
    //   593	701	865	java/io/IOException
    //   802	807	865	java/io/IOException
    //   844	849	865	java/io/IOException
    //   853	859	865	java/io/IOException
    //   863	865	865	java/io/IOException
    //   162	170	945	java/lang/Exception
    //   162	170	1023	finally
    //   844	849	1068	java/lang/Exception
    //   729	734	1073	java/lang/Exception
    //   927	931	1077	java/lang/Exception
    //   1010	1015	1081	java/lang/Exception
    //   1055	1060	1085	java/lang/Exception
    //   174	180	1089	finally
    //   184	189	1089	finally
    //   193	203	1089	finally
    //   207	217	1089	finally
    //   221	233	1089	finally
    //   237	257	1089	finally
    //   261	286	1089	finally
    //   290	294	1089	finally
    //   461	486	1089	finally
    //   493	498	1089	finally
    //   510	522	1089	finally
    //   526	557	1089	finally
    //   561	566	1089	finally
    //   570	581	1089	finally
    //   593	701	1089	finally
    //   802	807	1089	finally
    //   844	849	1089	finally
    //   853	859	1089	finally
    //   863	865	1089	finally
    //   953	970	1089	finally
    //   974	982	1089	finally
    //   874	900	1093	finally
    //   174	180	1100	java/lang/Exception
    //   184	189	1100	java/lang/Exception
    //   193	203	1100	java/lang/Exception
    //   207	217	1100	java/lang/Exception
    //   221	233	1100	java/lang/Exception
    //   237	257	1100	java/lang/Exception
    //   261	286	1100	java/lang/Exception
    //   290	294	1100	java/lang/Exception
    //   461	486	1100	java/lang/Exception
    //   510	522	1100	java/lang/Exception
    //   526	557	1100	java/lang/Exception
    //   561	566	1100	java/lang/Exception
    //   570	581	1100	java/lang/Exception
    //   593	701	1100	java/lang/Exception
    //   853	859	1100	java/lang/Exception
    //   863	865	1100	java/lang/Exception
    //   162	170	1104	java/io/IOException
    //   316	327	1112	finally
    //   331	339	1112	finally
    //   355	367	1112	finally
    //   382	387	1112	finally
    //   401	412	1112	finally
    //   420	428	1112	finally
    //   776	785	1112	finally
    //   316	327	1120	java/lang/Exception
    //   331	339	1120	java/lang/Exception
    //   355	367	1125	java/lang/Exception
    //   382	387	1125	java/lang/Exception
    //   401	412	1125	java/lang/Exception
    //   420	428	1125	java/lang/Exception
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
    //   0: ldc_w 1616
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1525	com/tencent/mm/sdk/platformtools/bt:cC	([B)Z
    //   10: ifeq +20 -> 30
    //   13: ldc_w 284
    //   16: ldc_w 1527
    //   19: invokestatic 813	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 1616
    //   25: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: invokestatic 777	com/tencent/mm/aw/i:aIo	()Ljava/lang/String;
    //   33: astore 9
    //   35: aload_0
    //   36: aload 9
    //   38: ldc_w 787
    //   41: ldc_w 356
    //   44: invokevirtual 359	com/tencent/mm/aw/i:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   47: astore 10
    //   49: new 200	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   56: aload 10
    //   58: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1544
    //   64: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 8
    //   72: ldc_w 284
    //   75: ldc_w 1546
    //   78: aload 10
    //   80: invokestatic 782	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 785	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 8
    //   91: iconst_0
    //   92: invokestatic 1558	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   95: astore 7
    //   97: aload 7
    //   99: aload_1
    //   100: invokevirtual 1563	java/io/OutputStream:write	([B)V
    //   103: aload 7
    //   105: invokevirtual 1566	java/io/OutputStream:flush	()V
    //   108: iload_2
    //   109: ifeq +114 -> 223
    //   112: sipush 128
    //   115: istore 5
    //   117: goto +299 -> 416
    //   120: iload 4
    //   122: ifeq +115 -> 237
    //   125: aload 8
    //   127: aconst_null
    //   128: invokestatic 1620	com/tencent/mm/sdk/platformtools/g:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +37 -> 170
    //   136: aload_1
    //   137: bipush 90
    //   139: aload_3
    //   140: aload 10
    //   142: iconst_1
    //   143: invokestatic 598	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   146: pop
    //   147: ldc_w 284
    //   150: ldc_w 1622
    //   153: iconst_2
    //   154: anewarray 106	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload 8
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: aload 10
    //   166: aastore
    //   167: invokestatic 385	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload 8
    //   172: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   175: ifeq +18 -> 193
    //   178: ldc_w 284
    //   181: ldc_w 1597
    //   184: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 8
    //   189: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   192: pop
    //   193: aload 7
    //   195: ifnull +8 -> 203
    //   198: aload 7
    //   200: invokevirtual 1598	java/io/OutputStream:close	()V
    //   203: ldc_w 779
    //   206: aload 9
    //   208: invokestatic 782	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   211: invokevirtual 785	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   214: astore_1
    //   215: ldc_w 1616
    //   218: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_1
    //   222: areturn
    //   223: bipush 120
    //   225: istore 5
    //   227: goto +189 -> 416
    //   230: bipush 120
    //   232: istore 6
    //   234: goto -114 -> 120
    //   237: aload 8
    //   239: iload 5
    //   241: iload 6
    //   243: iconst_0
    //   244: invokestatic 1625	com/tencent/mm/sdk/platformtools/g:d	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   247: astore_1
    //   248: goto -116 -> 132
    //   251: astore_3
    //   252: aconst_null
    //   253: astore_1
    //   254: getstatic 801	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   257: ldc2_w 1231
    //   260: ldc2_w 1626
    //   263: lconst_1
    //   264: iconst_0
    //   265: invokevirtual 1238	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   268: ldc_w 284
    //   271: new 200	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 1629
    //   278: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: aload 9
    //   283: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 1631
    //   289: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_3
    //   293: invokevirtual 1245	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   296: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 813	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload 8
    //   307: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   310: ifeq +18 -> 328
    //   313: ldc_w 284
    //   316: ldc_w 1597
    //   319: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload 8
    //   324: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   327: pop
    //   328: aload_1
    //   329: ifnull +7 -> 336
    //   332: aload_1
    //   333: invokevirtual 1598	java/io/OutputStream:close	()V
    //   336: ldc_w 1616
    //   339: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: aconst_null
    //   343: areturn
    //   344: astore_3
    //   345: aconst_null
    //   346: astore_1
    //   347: aload 8
    //   349: invokestatic 369	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   352: ifeq +18 -> 370
    //   355: ldc_w 284
    //   358: ldc_w 1597
    //   361: invokestatic 762	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: aload 8
    //   366: invokestatic 1120	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   369: pop
    //   370: aload_1
    //   371: ifnull +7 -> 378
    //   374: aload_1
    //   375: invokevirtual 1598	java/io/OutputStream:close	()V
    //   378: ldc_w 1616
    //   381: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload_3
    //   385: athrow
    //   386: astore_1
    //   387: goto -184 -> 203
    //   390: astore_1
    //   391: goto -55 -> 336
    //   394: astore_1
    //   395: goto -17 -> 378
    //   398: astore_3
    //   399: aload 7
    //   401: astore_1
    //   402: goto -55 -> 347
    //   405: astore_3
    //   406: goto -59 -> 347
    //   409: astore_3
    //   410: aload 7
    //   412: astore_1
    //   413: goto -159 -> 254
    //   416: iload_2
    //   417: ifeq -187 -> 230
    //   420: sipush 128
    //   423: istore 6
    //   425: goto -305 -> 120
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	this	i
    //   0	428	1	paramArrayOfByte	byte[]
    //   0	428	2	paramBoolean1	boolean
    //   0	428	3	paramCompressFormat	Bitmap.CompressFormat
    //   0	428	4	paramBoolean2	boolean
    //   115	125	5	i	int
    //   232	192	6	j	int
    //   95	316	7	localOutputStream	java.io.OutputStream
    //   70	295	8	str1	String
    //   33	249	9	str2	String
    //   47	118	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   89	97	251	java/lang/Exception
    //   89	97	344	finally
    //   198	203	386	java/lang/Exception
    //   332	336	390	java/lang/Exception
    //   374	378	394	java/lang/Exception
    //   97	108	398	finally
    //   125	132	398	finally
    //   136	170	398	finally
    //   237	248	398	finally
    //   254	305	405	finally
    //   97	108	409	java/lang/Exception
    //   125	132	409	java/lang/Exception
    //   136	170	409	java/lang/Exception
    //   237	248	409	java/lang/Exception
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
      ((HashMap)localObject1).put(Long.valueOf(((g)localObject2).dAY), localObject2);
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
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      AppMethodBeat.o(150585);
      return false;
    }
    label590:
    label602:
    label617:
    label1129:
    for (;;)
    {
      synchronized (this.ian)
      {
        boolean bool = this.ian.containsKey(paramString);
        String str = c(paramString, paramBoolean, false);
        if (bt.isNullOrNil(str))
        {
          ad.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { bt.nullAsNil(paramString) });
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
            if (com.tencent.mm.vfs.i.fv(str + "hd"))
            {
              this.ian.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1132;
        }
        paramString = (Bitmap)this.iag.aL(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1129;
          }
          paramString = (Bitmap)this.iag.aL(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label657;
          }
          ad.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label590;
          }
          localObject = this.iao;
          if (paramInt4 != 0) {
            break label602;
          }
          ((FrameLayout.LayoutParams)localObject).gravity = 5;
          paramImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramString.getWidth() < paramString.getHeight() * 2.5D) {
            break label617;
          }
          paramInt1 = 1;
          if (paramString.getHeight() < paramString.getWidth() * 2.5D) {
            break label623;
          }
          paramInt2 = 1;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            paramImageView1.setScaleType(ImageView.ScaleType.CENTER);
          }
          if (paramImageView2 != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label629;
            }
            paramImageView1.gravity = 5;
            paramImageView2.setLayoutParams(paramImageView1);
          }
          if (paramView != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label643;
            }
            paramImageView1.gravity = 5;
            paramView.setLayoutParams(paramImageView1);
          }
          AppMethodBeat.o(150585);
          return true;
        }
      }
      if (this.iag.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
        ad.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(String.valueOf(localObject)));
      }
      int i = 0;
      continue;
      Object localObject = (FrameLayout.LayoutParams)paramImageView1.getLayoutParams();
      continue;
      label746:
      label1132:
      if (paramInt4 == 1)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
        continue;
        paramInt1 = 0;
        continue;
        label623:
        paramInt2 = 0;
        continue;
        label629:
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
                    break label925;
                  }
                  paramInt3 = (int)(paramInt1 * paramFloat);
                  if (paramInt2 <= 0) {
                    break label932;
                  }
                  paramInt1 = paramInt2;
                  paramInt1 = (int)(paramInt1 * paramFloat);
                  paramInt2 = paramInt3;
                  if (paramInt2 >= 60.0F * paramFloat) {
                    break label1126;
                  }
                  ad.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(paramInt2) });
                  paramInt2 = (int)(60.0F * paramFloat);
                }
              }
            }
            for (;;)
            {
              paramInt3 = paramInt1;
              if (paramInt1 < 60.0F * paramFloat)
              {
                ad.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(paramInt1) });
                paramInt3 = (int)(60.0F * paramFloat);
              }
              paramString = new FrameLayout.LayoutParams(paramInt2, paramInt3);
              if (paramInt4 == 0)
              {
                paramString.gravity = 5;
                if (paramView == null) {
                  break label1123;
                }
                paramView.setLayoutParams(paramString);
              }
              for (;;)
              {
                paramImageView1.setLayoutParams(paramString);
                if (i == 0) {
                  a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat);
                }
                AppMethodBeat.o(150585);
                return false;
                f = 160.0F / paramInt1;
                break;
                paramInt1 = 120;
                break label728;
                paramInt1 = 75;
                break label746;
                if (paramInt1 > 0)
                {
                  paramInt3 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label989;
                  }
                }
                for (;;)
                {
                  paramInt1 = (int)(paramInt2 * paramFloat * 1.25F);
                  paramInt2 = paramInt3;
                  break;
                  paramInt1 = 120;
                  break label944;
                  paramInt2 = 75;
                }
                if (paramInt4 != 1) {
                  break label871;
                }
                paramString.gravity = 3;
                break label871;
                if ((this.iap == null) || (this.iap.get() == null)) {
                  this.iap = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.iap.get());
                if (paramInt1 > 0)
                {
                  paramInt1 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label1116;
                  }
                }
                for (;;)
                {
                  paramString = new FrameLayout.LayoutParams(paramInt1, (int)(paramInt2 * paramFloat * 1.25F));
                  break;
                  paramInt1 = 120;
                  break label1067;
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
  
  public final boolean a(bu parambu, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150631);
    String str = N(parambu);
    if (!bt.isNullOrNil(str))
    {
      boolean bool = a(str, parambu.field_imgPath, paramInt1, paramInt2, 0, 0);
      AppMethodBeat.o(150631);
      return bool;
    }
    AppMethodBeat.o(150631);
    return false;
  }
  
  /* Error */
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 1711
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 284
    //   9: ldc_w 1713
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
    //   27: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_3
    //   33: iload 4
    //   35: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_4
    //   41: invokestatic 513	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   44: aastore
    //   45: invokestatic 385	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   51: lstore 10
    //   53: invokestatic 632	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   56: invokestatic 1095	com/tencent/mm/cc/a:getDensity	(Landroid/content/Context;)F
    //   59: fstore 7
    //   61: aload_1
    //   62: invokestatic 534	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   65: ifne +10 -> 75
    //   68: aload_2
    //   69: invokestatic 534	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifeq +11 -> 83
    //   75: ldc_w 1711
    //   78: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_0
    //   82: ireturn
    //   83: aload_0
    //   84: aload_2
    //   85: iconst_0
    //   86: iconst_1
    //   87: invokevirtual 613	com/tencent/mm/aw/i:c	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   90: astore 13
    //   92: aload 13
    //   94: invokestatic 534	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   97: ifeq +11 -> 108
    //   100: ldc_w 1711
    //   103: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: iconst_0
    //   107: ireturn
    //   108: aload 13
    //   110: ldc_w 536
    //   113: invokevirtual 539	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   116: ifne +98 -> 214
    //   119: new 200	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   126: aload 13
    //   128: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 536
    //   134: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore 15
    //   142: aload 13
    //   144: astore 14
    //   146: aload 15
    //   148: astore 13
    //   150: aload 14
    //   152: invokestatic 1364	com/tencent/mm/sdk/platformtools/g:aQc	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   155: astore 16
    //   157: aload 16
    //   159: ifnull +23 -> 182
    //   162: aload 16
    //   164: getfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   167: ifle +15 -> 182
    //   170: aload 16
    //   172: astore 15
    //   174: aload 16
    //   176: getfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   179: ifgt +119 -> 298
    //   182: getstatic 801	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   185: ldc2_w 1231
    //   188: ldc2_w 1714
    //   191: lconst_1
    //   192: iconst_0
    //   193: invokevirtual 1238	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   196: aload 14
    //   198: invokestatic 436	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   201: lconst_0
    //   202: lcmp
    //   203: ifle +29 -> 232
    //   206: ldc_w 1711
    //   209: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: iconst_0
    //   213: ireturn
    //   214: aload 13
    //   216: iconst_0
    //   217: aload 13
    //   219: invokevirtual 363	java/lang/String:length	()I
    //   222: iconst_2
    //   223: isub
    //   224: invokevirtual 570	java/lang/String:substring	(II)Ljava/lang/String;
    //   227: astore 14
    //   229: goto -79 -> 150
    //   232: new 1366	android/graphics/BitmapFactory$Options
    //   235: dup
    //   236: invokespecial 1547	android/graphics/BitmapFactory$Options:<init>	()V
    //   239: astore 15
    //   241: invokestatic 1718	com/tencent/mm/sdk/platformtools/g:fjY	()V
    //   244: ldc_w 284
    //   247: ldc_w 1720
    //   250: iconst_3
    //   251: anewarray 106	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload 15
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: aload 15
    //   263: getfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   266: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: dup
    //   271: iconst_2
    //   272: aload 15
    //   274: getfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   277: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: invokestatic 297	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: getstatic 801	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   287: ldc2_w 1231
    //   290: ldc2_w 1721
    //   293: lconst_1
    //   294: iconst_0
    //   295: invokevirtual 1238	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   298: aload 15
    //   300: getfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   303: ifne +10 -> 313
    //   306: aload 15
    //   308: iload 5
    //   310: putfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   313: aload 15
    //   315: getfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   318: ifne +10 -> 328
    //   321: aload 15
    //   323: iload 6
    //   325: putfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   328: aload 15
    //   330: getfield 1369	android/graphics/BitmapFactory$Options:outWidth	I
    //   333: i2f
    //   334: fload 7
    //   336: fmul
    //   337: ldc_w 640
    //   340: fmul
    //   341: f2i
    //   342: istore 9
    //   344: aload 15
    //   346: getfield 1372	android/graphics/BitmapFactory$Options:outHeight	I
    //   349: i2f
    //   350: fload 7
    //   352: fmul
    //   353: ldc_w 640
    //   356: fmul
    //   357: f2i
    //   358: istore 8
    //   360: iload 9
    //   362: i2f
    //   363: ldc_w 641
    //   366: fload 7
    //   368: fmul
    //   369: fcmpl
    //   370: ifge +24 -> 394
    //   373: iload 8
    //   375: istore 6
    //   377: iload 9
    //   379: istore 5
    //   381: iload 8
    //   383: i2f
    //   384: ldc_w 641
    //   387: fload 7
    //   389: fmul
    //   390: fcmpl
    //   391: iflt +40 -> 431
    //   394: iload 8
    //   396: iload 9
    //   398: if_icmple +216 -> 614
    //   401: ldc_w 641
    //   404: fload 7
    //   406: fmul
    //   407: iload 8
    //   409: i2f
    //   410: fdiv
    //   411: fstore 7
    //   413: iload 9
    //   415: i2f
    //   416: fload 7
    //   418: fmul
    //   419: f2i
    //   420: istore 5
    //   422: fload 7
    //   424: iload 8
    //   426: i2f
    //   427: fmul
    //   428: f2i
    //   429: istore 6
    //   431: iload 4
    //   433: ifne +196 -> 629
    //   436: aload_1
    //   437: iload 6
    //   439: iload 5
    //   441: getstatic 595	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   444: aload 13
    //   446: new 441	com/tencent/mm/pointers/PInt
    //   449: dup
    //   450: invokespecial 442	com/tencent/mm/pointers/PInt:<init>	()V
    //   453: new 441	com/tencent/mm/pointers/PInt
    //   456: dup
    //   457: invokespecial 442	com/tencent/mm/pointers/PInt:<init>	()V
    //   460: invokestatic 1725	com/tencent/mm/sdk/platformtools/g:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   463: istore 12
    //   465: ldc_w 284
    //   468: ldc_w 1727
    //   471: iconst_4
    //   472: anewarray 106	java/lang/Object
    //   475: dup
    //   476: iconst_0
    //   477: new 200	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 269	java/lang/StringBuilder:<init>	()V
    //   484: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   487: lload 10
    //   489: lsub
    //   490: invokevirtual 272	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   493: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: aastore
    //   497: dup
    //   498: iconst_1
    //   499: iload 6
    //   501: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   504: aastore
    //   505: dup
    //   506: iconst_2
    //   507: iload 5
    //   509: invokestatic 483	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   512: aastore
    //   513: dup
    //   514: iconst_3
    //   515: iload 12
    //   517: invokestatic 507	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   520: aastore
    //   521: invokestatic 385	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   524: aload_0
    //   525: aload 14
    //   527: iconst_1
    //   528: invokestatic 632	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   531: invokestatic 1095	com/tencent/mm/cc/a:getDensity	(Landroid/content/Context;)F
    //   534: iconst_1
    //   535: iconst_0
    //   536: iconst_1
    //   537: iload_3
    //   538: iconst_0
    //   539: invokespecial 1253	com/tencent/mm/aw/i:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   542: pop
    //   543: iload 12
    //   545: ifeq +170 -> 715
    //   548: aload_0
    //   549: getfield 155	com/tencent/mm/aw/i:ian	Ljava/util/Map;
    //   552: astore_1
    //   553: aload_1
    //   554: monitorenter
    //   555: aload_0
    //   556: getfield 155	com/tencent/mm/aw/i:ian	Ljava/util/Map;
    //   559: aload_2
    //   560: invokeinterface 1656 2 0
    //   565: ifeq +38 -> 603
    //   568: aload_0
    //   569: getfield 155	com/tencent/mm/aw/i:ian	Ljava/util/Map;
    //   572: aload_2
    //   573: invokeinterface 870 2 0
    //   578: checkcast 61	java/lang/String
    //   581: ldc_w 536
    //   584: invokevirtual 539	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   587: ifne +16 -> 603
    //   590: aload_0
    //   591: getfield 155	com/tencent/mm/aw/i:ian	Ljava/util/Map;
    //   594: aload_2
    //   595: aload 13
    //   597: invokeinterface 853 3 0
    //   602: pop
    //   603: aload_1
    //   604: monitorexit
    //   605: ldc_w 1711
    //   608: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   611: iload 12
    //   613: ireturn
    //   614: ldc_w 641
    //   617: fload 7
    //   619: fmul
    //   620: iload 9
    //   622: i2f
    //   623: fdiv
    //   624: fstore 7
    //   626: goto -213 -> 413
    //   629: aload_1
    //   630: iload 6
    //   632: iload 5
    //   634: getstatic 595	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   637: aload 13
    //   639: new 441	com/tencent/mm/pointers/PInt
    //   642: dup
    //   643: invokespecial 442	com/tencent/mm/pointers/PInt:<init>	()V
    //   646: new 441	com/tencent/mm/pointers/PInt
    //   649: dup
    //   650: invokespecial 442	com/tencent/mm/pointers/PInt:<init>	()V
    //   653: invokestatic 1729	com/tencent/mm/sdk/platformtools/g:b	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   656: istore 12
    //   658: goto -193 -> 465
    //   661: astore_1
    //   662: getstatic 801	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   665: ldc2_w 1231
    //   668: ldc2_w 1730
    //   671: lconst_1
    //   672: iconst_0
    //   673: invokevirtual 1238	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   676: ldc_w 284
    //   679: ldc_w 1733
    //   682: iconst_1
    //   683: anewarray 106	java/lang/Object
    //   686: dup
    //   687: iconst_0
    //   688: aload_1
    //   689: invokevirtual 1734	java/lang/Exception:toString	()Ljava/lang/String;
    //   692: aastore
    //   693: invokestatic 679	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   696: ldc_w 1711
    //   699: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   702: iconst_0
    //   703: ireturn
    //   704: astore_2
    //   705: aload_1
    //   706: monitorexit
    //   707: ldc_w 1711
    //   710: invokestatic 195	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   713: aload_2
    //   714: athrow
    //   715: getstatic 801	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   718: ldc2_w 1231
    //   721: ldc2_w 1730
    //   724: lconst_1
    //   725: iconst_0
    //   726: invokevirtual 1238	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   729: goto -124 -> 605
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	732	0	this	i
    //   0	732	2	paramString2	String
    //   0	732	3	paramInt1	int
    //   0	732	4	paramInt2	int
    //   0	732	5	paramInt3	int
    //   0	732	6	paramInt4	int
    //   59	566	7	f	float
    //   358	67	8	i	int
    //   342	279	9	j	int
    //   51	437	10	l	long
    //   463	194	12	bool	boolean
    //   90	548	13	localObject1	Object
    //   144	382	14	localObject2	Object
    //   140	205	15	localObject3	Object
    //   155	20	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   436	465	661	java/lang/Exception
    //   629	658	661	java/lang/Exception
    //   555	603	704	finally
    //   603	605	704	finally
    //   705	707	704	finally
  }
  
  public final void aIm()
  {
    AppMethodBeat.i(150567);
    Iterator localIterator = d.iaE.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      Cursor localCursor = this.hHS.a("SELECT max(id) FROM " + localc.table, null, 2);
      AtomicLong localAtomicLong = localc.iaD;
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
        ad.i("MicroMsg.ImgInfoStorage", "[updateLatestImgID] table=%s, loading new img id=%s", new Object[] { localc.table, Long.valueOf(localAtomicLong.get()) });
      }
      finally
      {
        AppMethodBeat.o(150567);
      }
    }
    AppMethodBeat.o(150567);
  }
  
  public final List<g> aIn()
  {
    AppMethodBeat.i(150598);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = d.iaE.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (c)localIterator.next();
      localObject = "select * " + " FROM " + ((c)localObject).table;
      localObject = (String)localObject + " WHERE iscomplete= 0 AND totalLen != 0 ";
      localObject = this.hHS.a((String)localObject, null, 0);
      if (!((Cursor)localObject).moveToFirst()) {
        ((Cursor)localObject).close();
      } else {
        label229:
        for (;;)
        {
          g localg1 = new g();
          localg1.convertFrom((Cursor)localObject);
          g localg2 = pu((int)localg1.dnz);
          if (localg2 != null) {
            if ((localg2.dAY != 0L) || (localg2.hZF != 0L)) {
              localArrayList.add(localg1);
            }
          }
          for (;;)
          {
            if (((Cursor)localObject).moveToNext()) {
              break label229;
            }
            ((Cursor)localObject).close();
            break;
            if ((localg1.dAY != 0L) || (localg1.hZF != 0L)) {
              localArrayList.add(localg1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(150598);
    return localArrayList;
  }
  
  public final String aa(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150580);
    if (bt.cC(paramArrayOfByte))
    {
      ad.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(150580);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth < 0) || (((BitmapFactory.Options)localObject).outHeight < 0))
    {
      ad.e("MicroMsg.ImgInfoStorage", "Bad thumbBuf, perhaps it's not complete or damaged ??");
      AppMethodBeat.o(150580);
      return null;
    }
    localObject = aIo();
    String str = o((String)localObject, "th_", "");
    ad.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(str)));
    com.tencent.mm.vfs.i.deleteFile(str);
    com.tencent.mm.vfs.i.f(str, paramArrayOfByte, paramArrayOfByte.length);
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
      ((HashMap)localObject1).put(Long.valueOf(((g)localObject2).dAY), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150602);
    return localObject1;
  }
  
  public final g c(Long paramLong)
  {
    AppMethodBeat.i(150596);
    g localg = new g();
    paramLong = a(d.sf(paramLong.longValue()), null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      localg.convertFrom(paramLong);
    }
    paramLong.close();
    AppMethodBeat.o(150596);
    return localg;
  }
  
  public final String c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150633);
    Object localObject;
    if ((paramString != null) && (this.ian.containsKey(paramString)))
    {
      localObject = (String)this.ian.get(paramString);
      AppMethodBeat.o(150633);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = R(paramString, paramBoolean2))
    {
      localObject = str;
      if (bt.isNullOrNil(str)) {
        break;
      }
      this.ian.put(paramString, str);
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
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(150572);
      return null;
    }
    String str1 = "";
    if (paramString.startsWith("SERVERID://")) {
      str1 = paramString.substring(11);
    }
    for (;;)
    {
      try
      {
        str1 = se(Long.valueOf(str1).longValue()).hZw;
        String str2 = com.tencent.mm.plugin.image.d.azA();
        String str3 = com.tencent.mm.plugin.image.d.azB();
        if (bt.isNullOrNil(str1))
        {
          paramString = m.j(str2, str3, "th_", paramString, "");
          AppMethodBeat.o(150572);
          return paramString;
        }
      }
      catch (NumberFormatException paramString)
      {
        ad.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(150572);
        return null;
      }
      paramString = str1;
    }
  }
  
  public final Bitmap l(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(150629);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from";; str = "location_backgroup_key_tor")
    {
      Bitmap localBitmap2 = (Bitmap)this.iag.aL(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.g.ju(paramInt1, paramInt2);
        this.iag.q(str, localBitmap1);
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
  
  public final g pt(int paramInt)
  {
    AppMethodBeat.i(150603);
    g localg = c(Long.valueOf(paramInt));
    AppMethodBeat.o(150603);
    return localg;
  }
  
  /* Error */
  public final g pu(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1802
    //   3: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: i2l
    //   8: lstore_2
    //   9: aload_0
    //   10: lload_2
    //   11: invokestatic 1150	com/tencent/mm/aw/i$d:sf	(J)Ljava/lang/String;
    //   14: aconst_null
    //   15: ldc_w 1804
    //   18: iconst_1
    //   19: anewarray 61	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: iload_1
    //   25: invokestatic 1030	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   28: aastore
    //   29: invokespecial 1056	com/tencent/mm/aw/i:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +170 -> 206
    //   39: aload 5
    //   41: astore 6
    //   43: aload 5
    //   45: invokeinterface 1033 1 0
    //   50: ifeq +156 -> 206
    //   53: aload 5
    //   55: astore 6
    //   57: new 329	com/tencent/mm/aw/g
    //   60: dup
    //   61: invokespecial 713	com/tencent/mm/aw/g:<init>	()V
    //   64: astore 4
    //   66: aload 5
    //   68: astore 6
    //   70: aload 4
    //   72: aload 5
    //   74: invokevirtual 1037	com/tencent/mm/aw/g:convertFrom	(Landroid/database/Cursor;)V
    //   77: aload 4
    //   79: astore 6
    //   81: aload 5
    //   83: ifnull +14 -> 97
    //   86: aload 5
    //   88: invokeinterface 947 1 0
    //   93: aload 4
    //   95: astore 6
    //   97: ldc_w 1802
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
    //   118: ldc_w 284
    //   121: ldc_w 1806
    //   124: iconst_1
    //   125: anewarray 106	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload 7
    //   132: invokevirtual 1734	java/lang/Exception:toString	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 1280	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload 4
    //   141: astore 6
    //   143: aload 5
    //   145: ifnull -48 -> 97
    //   148: aload 5
    //   150: invokeinterface 947 1 0
    //   155: aload 4
    //   157: astore 6
    //   159: goto -62 -> 97
    //   162: astore 4
    //   164: aconst_null
    //   165: astore 6
    //   167: aload 6
    //   169: ifnull +10 -> 179
    //   172: aload 6
    //   174: invokeinterface 947 1 0
    //   179: ldc_w 1802
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
        ad.e("MicroMsg.ImgInfoStorage", "Cannot draw recycled bitmaps:%s", new Object[] { getBitmap().toString() });
      }
      AppMethodBeat.o(150565);
    }
  }
  
  static final class b
  {
    int iax;
    int iay;
    int iaz;
    String url;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      this.iax = paramInt1;
      this.url = paramString;
      this.iay = paramInt2;
      this.iaz = paramInt3;
    }
  }
  
  public static final class c
  {
    String iaA;
    String[] iaB;
    long[] iaC;
    AtomicLong iaD;
    String table;
    
    public c(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(195239);
      this.iaC = new long[2];
      this.iaD = new AtomicLong(0L);
      this.table = paramString2;
      this.iaA = paramString1;
      this.iaB = paramArrayOfString;
      this.iaC[0] = paramLong1;
      this.iaC[1] = paramLong2;
      this.iaD.set(paramLong1);
      AppMethodBeat.o(195239);
    }
  }
  
  public static final class d
  {
    public static final ArrayList<i.c> iaE;
    
    static
    {
      AppMethodBeat.i(195244);
      iaE = new ArrayList(3);
      a("", "ImgInfo2", i.SQL_CREATE, 1L, 1000000000L);
      a("@findermsg", "finder_img_info_table", i.Fk("finder_img_info_table"), 1000000001L, 1001000001L);
      AppMethodBeat.o(195244);
    }
    
    public static AtomicLong Ft(String paramString)
    {
      AppMethodBeat.i(195241);
      if (paramString == null)
      {
        ad.e("MicroMsg.ImgInfoStorage", "[getIdCreator] talker is null %s", new Object[] { bt.flS() });
        paramString = ((i.c)iaE.get(0)).iaD;
        AppMethodBeat.o(195241);
        return paramString;
      }
      Iterator localIterator = iaE.iterator();
      while (localIterator.hasNext())
      {
        i.c localc = (i.c)localIterator.next();
        if ((!localc.iaA.isEmpty()) && (paramString.toLowerCase().endsWith(localc.iaA)))
        {
          ad.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { localc.table, paramString });
          paramString = localc.iaD;
          AppMethodBeat.o(195241);
          return paramString;
        }
      }
      ad.i("MicroMsg.ImgInfoStorage", "[getIdCreator] table=%s talker=%s", new Object[] { ((i.c)iaE.get(0)).table, paramString });
      paramString = ((i.c)iaE.get(0)).iaD;
      AppMethodBeat.o(195241);
      return paramString;
    }
    
    public static String Fu(String paramString)
    {
      AppMethodBeat.i(195242);
      if (paramString == null)
      {
        ad.e("MicroMsg.ImgInfoStorage", "[getTableByTalker] talker is null %s", new Object[] { bt.flS() });
        paramString = ((i.c)iaE.get(0)).table;
        AppMethodBeat.o(195242);
        return paramString;
      }
      Iterator localIterator = iaE.iterator();
      while (localIterator.hasNext())
      {
        i.c localc = (i.c)localIterator.next();
        if ((!localc.iaA.isEmpty()) && (paramString.toLowerCase().endsWith(localc.iaA)))
        {
          paramString = localc.table;
          AppMethodBeat.o(195242);
          return paramString;
        }
      }
      ad.i("MicroMsg.ImgInfoStorage", "[getTableByTalker] table=%s talker=%s", new Object[] { ((i.c)iaE.get(0)).table, paramString });
      paramString = ((i.c)iaE.get(0)).table;
      AppMethodBeat.o(195242);
      return paramString;
    }
    
    private static void a(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(195240);
      iaE.add(new i.c(paramString1.toLowerCase(), paramString2, paramArrayOfString, paramLong1, paramLong2));
      AppMethodBeat.o(195240);
    }
    
    public static String sf(long paramLong)
    {
      AppMethodBeat.i(195243);
      Object localObject = iaE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        i.c localc = (i.c)((Iterator)localObject).next();
        if ((localc.iaC[0] <= paramLong) && (paramLong <= localc.iaC[1]))
        {
          localObject = localc.table;
          AppMethodBeat.o(195243);
          return localObject;
        }
      }
      ad.i("MicroMsg.ImgInfoStorage", "[getTableById] table=%s id=%s", new Object[] { ((i.c)iaE.get(0)).table, Long.valueOf(paramLong) });
      localObject = ((i.c)iaE.get(0)).table;
      AppMethodBeat.o(195243);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.i
 * JD-Core Version:    0.7.0.1
 */