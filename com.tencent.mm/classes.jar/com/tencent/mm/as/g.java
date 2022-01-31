package com.tencent.mm.as;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.File;
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
import junit.framework.Assert;

public final class g
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0)", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
  public static int enV = 0;
  public static long eoj = 0L;
  private ah dPi = new ah(Looper.getMainLooper());
  public com.tencent.mm.cf.h dXo = null;
  public com.tencent.mm.a.f<String, Bitmap> enW = new com.tencent.mm.a.f(40, new g.1(this));
  com.tencent.mm.a.f<String, String> enX = new com.tencent.mm.a.f(40, new g.2(this));
  private List<g.b> enY = new ArrayList();
  private Map<Integer, WeakReference<ImageView>> enZ = new HashMap();
  private Map<Integer, WeakReference<ImageView>> eoa = new HashMap();
  private Map<Integer, WeakReference<View>> eob = new HashMap();
  private Set<Integer> eoc = new HashSet();
  private Map<String, String> eod = new HashMap();
  public long eoe = 1L;
  private FrameLayout.LayoutParams eog = new FrameLayout.LayoutParams(-2, -2);
  private SoftReference<ColorDrawable> eoh;
  public int eoi = 150;
  
  public g(com.tencent.mm.cf.h paramh)
  {
    a(paramh);
    this.dXo = paramh;
    Ot();
  }
  
  /* Error */
  public static String Ou()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   6: lstore_2
    //   7: getstatic 72	com/tencent/mm/as/g:eoj	J
    //   10: lstore 4
    //   12: lload_2
    //   13: lstore_0
    //   14: lload 4
    //   16: lload_2
    //   17: lcmp
    //   18: ifne +11 -> 29
    //   21: lconst_1
    //   22: invokestatic 163	java/lang/Thread:sleep	(J)V
    //   25: invokestatic 157	java/lang/System:currentTimeMillis	()J
    //   28: lstore_0
    //   29: lload_0
    //   30: putstatic 72	com/tencent/mm/as/g:eoj	J
    //   33: lload_0
    //   34: invokestatic 167	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: invokevirtual 171	java/lang/String:getBytes	()[B
    //   40: invokestatic 177	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   43: astore 6
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload 6
    //   50: areturn
    //   51: astore 6
    //   53: goto -28 -> 25
    //   56: astore 6
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload 6
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	21	0	l1	long
    //   6	11	2	l2	long
    //   10	5	4	l3	long
    //   43	6	6	str	String
    //   51	1	6	localInterruptedException	java.lang.InterruptedException
    //   56	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	25	51	java/lang/InterruptedException
    //   3	12	56	finally
    //   21	25	56	finally
    //   25	29	56	finally
    //   29	45	56	finally
  }
  
  private e P(String paramString, int paramInt)
  {
    e locale = new e();
    paramString = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[] { paramString, String.valueOf(paramInt) });
    if (paramString.moveToFirst()) {
      locale.d(paramString);
    }
    paramString.close();
    return locale;
  }
  
  private String Q(String paramString, int paramInt)
  {
    paramString = P(f.mc(paramString), paramInt);
    if (!bk.bl(paramString.ens))
    {
      paramString = F(paramString.ens, true);
      if (com.tencent.mm.vfs.e.bK(paramString)) {
        return paramString;
      }
    }
    return null;
  }
  
  private Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    return this.dXo.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    return a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, paramBoolean5, null);
  }
  
  private e a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString2, long paramLong, String paramString3, String paramString4, com.tencent.mm.a.b paramb1, com.tencent.mm.a.b paramb2, n.a parama)
  {
    if (!com.tencent.mm.vfs.e.bK(paramString1)) {
      return null;
    }
    String str2 = f.mc(paramString1);
    y.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString1 });
    long l;
    if (!com.tencent.mm.vfs.e.bK(paramString1))
    {
      y.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      paramPInt1 = null;
      if ((parama != null) && (parama.ent == paramInt1))
      {
        paramb1 = parama.OC();
        paramString2 = paramb1.epI;
        paramString3 = paramb1.epJ;
        paramPInt2 = paramb1.enA;
        paramString4 = paramb1.epK;
        paramb1 = paramb1.epL;
        y.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramb1.value });
        paramb1 = new e();
        paramb1.bcw = -1;
        l = this.eoe;
        this.eoe = (1L + l);
        paramb1.bW(l);
        paramb1.bV(paramLong);
        if (!bk.bl(paramPInt2)) {
          paramb1.ma(paramPInt2);
        }
        paramb1.iF(0);
        paramb1.source = paramInt2;
        paramb1.enO = true;
        if (paramInt2 != 4) {
          break label811;
        }
        if (!paramString1.startsWith(com.tencent.mm.storage.aa.FK())) {
          break label802;
        }
        paramb1.iE(3);
        label258:
        if (paramBoolean)
        {
          paramb1.lX(paramString2.value + ".jpg");
          if (!bk.bl(paramString4.value)) {
            paramb1.lY(paramString4.value + ".jpg");
          }
          if (bk.bl(paramb1.ens)) {
            paramb1.lZ(paramPInt1);
          }
          paramb1.iC((int)com.tencent.mm.vfs.e.aeQ(paramString3.value));
          if (paramb1.ebK == 0) {
            y.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString3.value });
          }
          paramb1.lW(str2);
        }
        paramb1.iB((int)bk.UX());
        paramb1.iG(paramInt1);
        y.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramb1.ebK);
        return paramb1;
      }
    }
    else
    {
      String str1 = paramString3;
      if (bk.bl(paramString3)) {
        str1 = Ou();
      }
      str1 = "THUMBNAIL_DIRPATH://th_" + str1;
      paramString3 = b(str1, "th_", "", false);
      if (paramb1 == null) {
        paramString3 = o(str1, "th_", "");
      }
      if (paramBoolean)
      {
        if ((!bk.bl(paramString2)) && (com.tencent.mm.vfs.e.bK(paramString2))) {
          break label658;
        }
        l = bk.UZ();
        a(paramString1, paramInt1, paramInt3, paramPInt1, paramPInt2, true, paramString3, paramb1);
        if (!com.tencent.mm.vfs.e.bK(paramString3)) {
          break label647;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(10921, new Object[] { Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString3)), Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString1)), Integer.valueOf(90), Long.valueOf(bk.cp(l)) });
      }
      for (;;)
      {
        y.d("MicroMsg.ImgInfoStorage", "insert: thumbName = " + str1);
        paramPInt1 = str1;
        break;
        label647:
        y.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
        continue;
        label658:
        com.tencent.mm.vfs.e.r(paramString2, paramString3);
      }
    }
    if ((parama != null) && (parama.ent != paramInt1)) {
      paramString2 = null;
    }
    for (paramPInt2 = null;; paramPInt2 = paramString4)
    {
      paramb1 = new PString();
      paramString3 = new PString();
      paramString4 = new PString();
      paramb2 = new PString();
      paramPInt2 = a(paramString1, str2, paramInt1, paramBoolean, paramb1, paramString3, paramString4, paramb2, paramPInt2, paramString2);
      y.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString4.value, paramb2.value });
      paramString2 = paramb1;
      break;
      label802:
      paramb1.iE(2);
      break label258;
      label811:
      paramb1.iE(1);
      break label258;
      paramString2 = paramb2;
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat, int paramInt)
  {
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.enY.iterator();
    while (localIterator.hasNext())
    {
      g.b localb = (g.b)localIterator.next();
      if (m == localb.eop)
      {
        y.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.eop), localb.url });
        localb.url = paramString;
        if (!this.eoc.contains(Integer.valueOf(k)))
        {
          this.eoc.add(Integer.valueOf(k));
          a(paramString, paramFloat, paramInt);
        }
        return;
      }
    }
    this.enZ.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.eoa.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    for (;;)
    {
      int j;
      if (paramView != null)
      {
        j = paramView.hashCode();
        this.eob.put(Integer.valueOf(j), new WeakReference(paramView));
      }
      for (;;)
      {
        paramImageView1 = new g.b(m, paramString, i, j);
        this.enY.add(paramImageView1);
        if (this.eoc.contains(Integer.valueOf(k))) {
          break;
        }
        this.eoc.add(Integer.valueOf(k));
        a(paramString, paramFloat, paramInt);
        return;
        j = 0;
      }
      i = 0;
    }
  }
  
  private static void a(com.tencent.mm.cf.h paramh)
  {
    Cursor localCursor = paramh.a("PRAGMA table_info(ImgInfo2)", null, 2);
    int i2 = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    int n = 0;
    int i1 = 0;
    int m = 0;
    int k = 0;
    String str;
    while (localCursor.moveToNext()) {
      if (i2 >= 0)
      {
        str = localCursor.getString(i2);
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
          n = 1;
        }
        if (!"midImgPath".equals(str)) {
          break label279;
        }
        i = 1;
      }
    }
    label279:
    for (;;)
    {
      if ("forwardType".equals(str)) {
        j = 1;
      }
      break;
      localCursor.close();
      long l = com.tencent.mm.kernel.g.DP().dKu.eV(Thread.currentThread().getId());
      if (k == 0) {
        paramh.gk("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
      }
      if (m == 0) {
        paramh.gk("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
      }
      if (i1 == 0) {
        paramh.gk("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
      }
      if (n == 0) {
        paramh.gk("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
      }
      if (i == 0) {
        paramh.gk("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
      }
      if (j == 0) {
        paramh.gk("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
      }
      if (l > 0L) {
        com.tencent.mm.kernel.g.DP().dKu.hI(l);
      }
      return;
    }
  }
  
  private void a(String paramString, float paramFloat, int paramInt)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new g.3(this, paramString, paramFloat, true, paramInt));
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    return a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
  }
  
  public static String md(String paramString)
  {
    return "THUMBNAIL_DIRPATH://th_" + paramString;
  }
  
  public static String s(bi parambi)
  {
    if (parambi == null)
    {
      y.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      parambi = null;
    }
    long l;
    Object localObject1;
    do
    {
      return parambi;
      l = System.currentTimeMillis();
      if (parambi.field_isSend == 1)
      {
        localObject2 = o.OJ().bY(parambi.field_msgId);
        localObject1 = localObject2;
        if (((e)localObject2).enp != 0L) {}
      }
      else
      {
        localObject1 = o.OJ().bX(parambi.field_msgSvrId);
      }
      if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable()) {
        break;
      }
      if (parambi.field_isSend != 1) {
        break label197;
      }
      parambi = f.c((e)localObject1);
      Object localObject2 = o.OJ().o(parambi, "", "");
      if ((parambi != null) && (parambi.length() > 0) && (com.tencent.mm.vfs.e.bK((String)localObject2))) {
        return localObject2;
      }
      parambi = ((e)localObject1).enq;
      localObject1 = o.OJ().o(parambi, "", "");
      if ((parambi == null) || (parambi.length() <= 0)) {
        break;
      }
      parambi = (bi)localObject1;
    } while (com.tencent.mm.vfs.e.bK((String)localObject1));
    label197:
    while (!((e)localObject1).Oq())
    {
      y.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      return null;
    }
    parambi = ((e)localObject1).enq;
    if (((e)localObject1).Or())
    {
      localObject1 = f.a((e)localObject1);
      if ((localObject1 != null) && (((e)localObject1).enp > 0L) && (((e)localObject1).Oq()) && (com.tencent.mm.vfs.e.bK(o.OJ().o(((e)localObject1).enq, "", "")))) {
        return ((e)localObject1).enq;
      }
    }
    return parambi;
  }
  
  public final String F(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
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
        paramString = iH(Integer.valueOf(paramString).intValue()).ens;
        return b(paramString, "", "", paramBoolean);
      }
      catch (NumberFormatException paramString)
      {
        y.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        return null;
      }
      paramString = str;
    } while (!str.startsWith("THUMBNAIL_DIRPATH://"));
    return b(str.substring(20).substring(3), "th_", "", paramBoolean);
  }
  
  public final void Ot()
  {
    Cursor localCursor = this.dXo.a("SELECT max(id) FROM ImgInfo2", null, 2);
    if (localCursor.moveToFirst()) {
      this.eoe = (localCursor.getLong(0) + 1L);
    }
    localCursor.close();
    y.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.eoe);
  }
  
  public final int a(int paramInt, e parame)
  {
    return a(Long.valueOf(paramInt), parame);
  }
  
  public final int a(Long paramLong, e parame)
  {
    long l = System.currentTimeMillis();
    ContentValues localContentValues = parame.vf();
    if (localContentValues.size() == 0) {}
    for (int i = 1;; i = this.dXo.update("ImgInfo2", localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      y.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString() });
      if (i != -1)
      {
        parame.Os();
        doNotify();
      }
      return i;
    }
  }
  
  public final long a(String paramString, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    return a(paramString, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null);
  }
  
  public final long a(String paramString1, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, long paramLong, com.tencent.mm.a.b paramb1, com.tencent.mm.a.b paramb2, n.a parama)
  {
    int j = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
    int i = j;
    if (j <= 0) {
      i = 100;
    }
    if ((paramInt1 == 0) || (com.tencent.mm.vfs.e.aeQ(paramString1) <= i * 1024))
    {
      paramString1 = a(paramString1, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString2, paramString3, paramb2, paramb1, parama);
      if (paramString1 == null) {
        paramLong = -1L;
      }
    }
    long l;
    do
    {
      do
      {
        return paramLong;
        paramPString.value = paramString1.ens;
        l = e(paramString1);
        paramLong = l;
      } while (l == -1L);
      doNotify();
      return l;
      if (paramInt1 != 1) {
        break;
      }
      paramPInt1 = a(paramString1, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString2, paramString3, paramb2, paramb1, parama);
      if (paramPInt1 == null) {
        return -1L;
      }
      paramPString.value = paramPInt1.ens;
      paramPInt1.bV(0L);
      paramPInt1.bf(0L);
      paramPInt1.iC((int)com.tencent.mm.vfs.e.aeQ(o(paramPInt1.enq, "", "")));
      paramString1 = a(paramString1, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString2, paramString3, paramb2, paramb1, parama);
      if (paramString1 == null) {
        return 0L;
      }
      paramString1.lX(paramPInt1.enq);
      paramString1.lZ(paramPInt1.ens);
      paramString1.lY(paramPInt1.enr);
      paramString1.iC(0);
      paramLong = this.dXo.eV(Thread.currentThread().getId());
      paramString1.iD((int)e(paramPInt1));
      l = e(paramString1);
      y.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramString1.enp), Long.valueOf(paramString1.enx), paramString1.enq, paramString1.enr, Integer.valueOf(paramString1.ebK) });
      if (paramLong > 0L) {
        com.tencent.mm.kernel.g.DP().dKu.hI(paramLong);
      }
      paramLong = l;
    } while (l == -1L);
    doNotify();
    return l;
    Assert.assertTrue(false);
    return 0L;
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    String str1 = "SERVERID://" + paramLong;
    String str2 = com.tencent.mm.a.g.o(str1.getBytes());
    String str3 = o(str2, "th_", "");
    Bitmap localBitmap;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 0))
    {
      localBitmap = com.tencent.mm.sdk.platformtools.c.bv(paramArrayOfByte);
      if (localBitmap == null) {
        y.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(paramArrayOfByte));
      }
      if ((paramBoolean) || (localBitmap == null)) {}
    }
    try
    {
      localBitmap = com.tencent.mm.sdk.platformtools.c.S(localBitmap);
      paramPInt1.value = localBitmap.getWidth();
      paramPInt2.value = localBitmap.getHeight();
      com.tencent.mm.sdk.platformtools.c.a(localBitmap, 90, Bitmap.CompressFormat.JPEG, str3, true);
      paramArrayOfByte = new e();
      if (!bk.bl(paramString1))
      {
        paramArrayOfByte.setOffset(paramInt);
        paramArrayOfByte.iC(paramInt);
        paramArrayOfByte.bcw = -1;
        long l = this.eoe;
        this.eoe = (1L + l);
        paramArrayOfByte.bW(l);
        paramArrayOfByte.lX(paramString1);
        paramArrayOfByte.lZ("THUMBNAIL_DIRPATH://th_" + str2);
        paramPString.value = paramArrayOfByte.ens;
        if (paramBoolean)
        {
          paramArrayOfByte.bf(0L);
          paramArrayOfByte.iG(1);
          paramArrayOfByte.ma(paramString2);
          paramArrayOfByte.iB((int)bk.UX());
          paramLong = e(paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          return paramLong;
        }
      }
    }
    catch (IOException paramPInt1)
    {
      for (;;)
      {
        y.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + str2 + " " + new String(paramArrayOfByte));
        continue;
        paramArrayOfByte.bf(paramLong);
        paramArrayOfByte.iG(0);
        continue;
        paramString1 = str1;
      }
    }
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    return a(paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString, paramPString, paramPInt1, paramPInt2);
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from" + paramLong;; str = "location_backgroup_key_tor" + paramLong)
    {
      Bitmap localBitmap2 = (Bitmap)this.enW.get(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.c.l(paramString, paramInt1, paramInt2, paramInt3);
        this.enW.f(str, localBitmap1);
      }
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext)
  {
    return a(paramString, paramFloat, paramContext, -1);
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext, int paramInt)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = paramString.trim();
      localBitmap = (Bitmap)this.enW.get(str);
      if (localBitmap == null) {
        break;
      }
      paramString = localBitmap;
    } while (!localBitmap.isRecycled());
    Bitmap localBitmap = BackwardSupportUtil.b.e(str, paramFloat);
    if (localBitmap != null)
    {
      int k = localBitmap.getWidth();
      int m = localBitmap.getHeight();
      int j;
      int i;
      if (k >= m)
      {
        j = BackwardSupportUtil.b.b(paramContext, this.eoi);
        i = (int)(m / k * j);
        if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
          break label289;
        }
        y.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 188L, 1L, false);
        paramString = null;
      }
      for (;;)
      {
        paramContext = paramString;
        if (paramInt != -1) {
          paramContext = com.tencent.mm.sdk.platformtools.c.e(paramString, paramInt);
        }
        if (localBitmap != paramContext)
        {
          y.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[] { localBitmap.toString() });
          localBitmap.recycle();
        }
        y.d("MicroMsg.ImgInfoStorage", "cached file " + str);
        this.enW.f(str, paramContext);
        return paramContext;
        i = BackwardSupportUtil.b.b(paramContext, this.eoi);
        j = (int)(k / m * i);
        break;
        try
        {
          label289:
          paramString = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        }
        catch (Exception paramString)
        {
          y.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[] { paramString.getMessage() });
          paramString = null;
          com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 188L, 1L, false);
        }
      }
    }
    return localBitmap;
  }
  
  public final Bitmap a(String paramString, float paramFloat, boolean paramBoolean)
  {
    return a(paramString, false, paramFloat, paramBoolean, false, false, -1);
  }
  
  public final Bitmap a(String paramString1, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString2, com.tencent.mm.a.b paramb)
  {
    y.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), bk.csb(), paramString2 });
    Object localObject2 = (Bitmap)this.enW.get(paramString1);
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
      localObject1 = Q(paramString1, paramInt1);
      if (bk.bl((String)localObject1)) {
        break label406;
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
            break label395;
          }
        }
        i = com.tencent.mm.sdk.platformtools.aa.Zk((String)localObject5);
        j = BackwardSupportUtil.ExifHelper.YS((String)localObject5);
        if (i <= 0) {
          break label320;
        }
      }
      label163:
      label320:
      for (localObject2 = com.tencent.mm.sdk.platformtools.aa.m((String)localObject5, i, j + paramInt2 * 90, 0);; localObject2 = com.tencent.mm.sdk.platformtools.c.k((String)localObject5, 120, 120, 0))
      {
        if (localObject2 != null)
        {
          this.enW.f(paramString1, localObject2);
          paramPInt1.value = ((Bitmap)localObject2).getWidth();
          paramPInt2.value = ((Bitmap)localObject2).getHeight();
          if (paramBoolean)
          {
            if (localObject1 != null) {
              break label389;
            }
            paramString1 = Q(paramString1, paramInt1);
            label215:
            paramPInt1 = paramString1;
            if (!bk.bl(paramString1))
            {
              paramPInt1 = paramString1;
              if (paramString1.endsWith("hd")) {
                paramPInt1 = paramString1.substring(0, paramString1.length() - 2);
              }
            }
            if (paramb != null) {
              paramb.rL();
            }
            if ((bk.bl(paramPInt1)) || (!com.tencent.mm.vfs.e.bK(paramPInt1))) {
              break label335;
            }
            com.tencent.mm.vfs.e.r(paramPInt1, paramString2);
            y.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", new Object[] { paramPInt1 });
          }
        }
        return localObject2;
        localObject2 = com.tencent.mm.sdk.platformtools.c.dn((String)localObject1, 0);
        localObject5 = paramString1;
        break;
      }
    }
    for (;;)
    {
      try
      {
        label335:
        if ((bk.bl(paramPInt1)) || (!paramPInt1.endsWith("hd"))) {
          break label378;
        }
        paramInt1 = 1;
      }
      catch (IOException paramString1)
      {
        label359:
        return localObject2;
      }
      com.tencent.mm.sdk.platformtools.c.a((Bitmap)localObject2, paramInt1, Bitmap.CompressFormat.JPEG, paramString2, false);
      return localObject2;
      label378:
      paramInt1 = 0;
      label389:
      label395:
      label406:
      while (paramInt1 == 0)
      {
        paramInt1 = 90;
        break label359;
        paramString1 = (String)localObject1;
        break label215;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break label163;
        localObject5 = paramString1;
        break;
      }
      paramInt1 = 80;
    }
  }
  
  public final Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    return a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, true);
  }
  
  public final Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5, Bitmap paramBitmap)
  {
    String str = paramString;
    if (!paramBoolean1) {
      str = b(paramString, false, true);
    }
    Object localObject2;
    if (str == null) {
      localObject2 = null;
    }
    Object localObject1;
    int k;
    label38:
    label69:
    label127:
    do
    {
      do
      {
        return localObject2;
        localObject1 = null;
        if (paramBitmap == null) {
          break label659;
        }
        k = 1;
        if (paramBoolean5)
        {
          paramString = (Bitmap)this.enW.get(str);
          localObject1 = paramString;
          if (paramString == null)
          {
            if (paramString != null) {
              break label665;
            }
            paramBoolean1 = true;
            y.b("MicroMsg.ImgInfoStorage", "bm is null:%b,  url:%s", new Object[] { Boolean.valueOf(paramBoolean1), str });
            localObject1 = paramString;
          }
        }
        if ((localObject1 == null) || (((Bitmap)localObject1).isRecycled())) {
          break;
        }
        localObject2 = localObject1;
      } while (k == 0);
      bk.UY();
      if (k == 0) {
        break label670;
      }
      paramString = paramBitmap;
      if (paramBitmap == null) {
        paramString = x.pg(str);
      }
      localObject2 = localObject1;
    } while (paramString == null);
    long l = System.currentTimeMillis();
    int m = paramString.getWidth();
    int n = paramString.getHeight();
    int i = n;
    int j = m;
    if (paramBoolean3)
    {
      if (enV == 0) {
        enV = com.tencent.mm.cb.a.ab(ae.getContext(), a.c.emoji_view_image_size);
      }
      if (m <= enV)
      {
        i = n;
        j = m;
        if (n <= enV) {}
      }
      else
      {
        if (m <= n) {
          break label682;
        }
        i = n * enV / m;
        j = enV;
      }
    }
    label244:
    n = i;
    m = j;
    if (paramBoolean4)
    {
      if (str.endsWith("hd")) {
        break label886;
      }
      j = (int)(paramString.getWidth() * paramFloat * 1.25F);
      i = (int)(paramString.getHeight() * paramFloat * 1.25F);
    }
    label338:
    label493:
    label886:
    for (;;)
    {
      float f;
      if ((j >= 160.0F * paramFloat) || (i >= 160.0F * paramFloat)) {
        if (i > j)
        {
          f = 160.0F * paramFloat / i;
          j = (int)(j * f);
          i = (int)(f * i);
        }
      }
      for (;;)
      {
        for (;;)
        {
          m = j;
          if (j < 60.0F * paramFloat)
          {
            y.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(j) });
            m = (int)(60.0F * paramFloat);
          }
          j = i;
          if (i < 60.0F * paramFloat)
          {
            y.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(i) });
            j = (int)(60.0F * paramFloat);
          }
          paramBitmap = ae.getContext();
          localObject1 = new int[2];
          if (j >= m)
          {
            paramFloat = j / m;
            if (paramFloat <= 2.0F)
            {
              i = com.tencent.mm.cb.a.ab(paramBitmap, a.c.ChatImgLimitWidth);
              j = (int)(i / paramFloat);
              localObject1[0] = j;
              localObject1[1] = i;
              m = localObject1[0];
              n = localObject1[1];
            }
          }
          try
          {
            paramBitmap = Bitmap.createScaledBitmap(paramString, m, n, true);
            if ((paramString != paramBitmap) && (k == 0))
            {
              y.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramString.toString() });
              paramString.recycle();
            }
            if (paramBoolean4)
            {
              paramString = com.tencent.mm.sdk.platformtools.c.e(paramBitmap, paramInt);
              localObject1 = System.currentTimeMillis() - l;
              if (paramString != null) {
                break label874;
              }
              paramBitmap = "";
              y.i("MicroMsg.ImgInfoStorage", "cached file :%s bitmap time:%s bitmap:%s", new Object[] { str, localObject1, paramBitmap });
              localObject2 = paramString;
              if (paramString == null) {
                break;
              }
              localObject2 = paramString;
              if (k != 0) {
                break;
              }
              this.enW.f(str, paramString);
              return paramString;
              k = 0;
              break label38;
              paramBoolean1 = false;
              break label69;
              paramBitmap = com.tencent.mm.sdk.platformtools.c.b(str, paramFloat, 0);
              break label127;
              if (m == n)
              {
                i = enV;
                j = enV;
                break label244;
              }
              j = m * enV / n;
              i = enV;
              break label244;
              f = 160.0F * paramFloat / j;
              break label338;
              j = com.tencent.mm.cb.a.ab(paramBitmap, a.c.ChatImgMinWidth);
              i = (int)(j * paramFloat);
              break label493;
              paramFloat = m / j;
              if (paramFloat <= 2.0F)
              {
                j = com.tencent.mm.cb.a.ab(paramBitmap, a.c.ChatImgLimitWidth);
                i = (int)(j / paramFloat);
                break label493;
              }
              i = com.tencent.mm.cb.a.ab(paramBitmap, a.c.ChatImgMinWidth);
              j = (int)(i * paramFloat);
            }
          }
          catch (OutOfMemoryError paramBitmap)
          {
            for (;;)
            {
              paramBitmap = paramString;
              continue;
              if (paramBoolean2)
              {
                paramString = com.tencent.mm.sdk.platformtools.c.a(paramBitmap, true, com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 3));
                y.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
                paramBitmap.recycle();
              }
              else
              {
                paramString = paramBitmap;
                continue;
                paramBitmap = paramString.toString();
              }
            }
          }
        }
      }
    }
  }
  
  public final String a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    return a(paramInt, paramArrayOfByte, paramBoolean, paramCompressFormat, false);
  }
  
  /* Error */
  public final String a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 1059	com/tencent/mm/sdk/platformtools/bk:bE	([B)Z
    //   4: ifeq +13 -> 17
    //   7: ldc 247
    //   9: ldc_w 1061
    //   12: invokestatic 437	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: aconst_null
    //   16: areturn
    //   17: new 338	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 339	java/lang/StringBuilder:<init>	()V
    //   24: invokestatic 1002	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   27: invokevirtual 707	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokevirtual 171	java/lang/String:getBytes	()[B
    //   36: invokestatic 177	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   39: astore 10
    //   41: aload_0
    //   42: aload 10
    //   44: ldc_w 397
    //   47: ldc_w 399
    //   50: invokevirtual 406	com/tencent/mm/as/g:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 11
    //   55: new 338	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 339	java/lang/StringBuilder:<init>	()V
    //   62: aload 11
    //   64: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 1063
    //   70: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: astore 9
    //   78: ldc 247
    //   80: new 338	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 1065
    //   87: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload 11
    //   92: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 9
    //   103: iconst_0
    //   104: invokestatic 1068	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   107: astore 8
    //   109: aload 8
    //   111: aload_2
    //   112: invokevirtual 1073	java/io/OutputStream:write	([B)V
    //   115: aload 8
    //   117: invokevirtual 1076	java/io/OutputStream:flush	()V
    //   120: iload_3
    //   121: ifeq +120 -> 241
    //   124: sipush 128
    //   127: istore 6
    //   129: goto +359 -> 488
    //   132: new 1078	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   135: dup
    //   136: invokespecial 1079	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   139: astore 12
    //   141: iload 5
    //   143: ifeq +112 -> 255
    //   146: aload 9
    //   148: aconst_null
    //   149: invokestatic 1083	com/tencent/mm/sdk/platformtools/c:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +118 -> 272
    //   157: aload_2
    //   158: bipush 90
    //   160: aload 4
    //   162: aload 11
    //   164: iconst_1
    //   165: invokestatic 872	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   168: ldc 247
    //   170: ldc_w 1085
    //   173: iconst_2
    //   174: anewarray 251	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload 9
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload 11
    //   186: aastore
    //   187: invokestatic 509	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: aload 9
    //   192: invokestatic 234	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   195: ifeq +17 -> 212
    //   198: ldc 247
    //   200: ldc_w 1087
    //   203: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload 9
    //   208: invokestatic 1090	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   211: pop
    //   212: aload 8
    //   214: ifnull +8 -> 222
    //   217: aload 8
    //   219: invokevirtual 1091	java/io/OutputStream:close	()V
    //   222: new 338	java/lang/StringBuilder
    //   225: dup
    //   226: ldc_w 395
    //   229: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   232: aload 10
    //   234: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: areturn
    //   241: bipush 120
    //   243: istore 6
    //   245: goto +243 -> 488
    //   248: bipush 120
    //   250: istore 7
    //   252: goto -120 -> 132
    //   255: aload 9
    //   257: iload 6
    //   259: iload 7
    //   261: iconst_0
    //   262: aload 12
    //   264: iconst_0
    //   265: invokestatic 1094	com/tencent/mm/sdk/platformtools/c:a	(Ljava/lang/String;IIZLcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)Landroid/graphics/Bitmap;
    //   268: astore_2
    //   269: goto -116 -> 153
    //   272: aload 12
    //   274: invokevirtual 1097	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   277: sipush 2000
    //   280: if_icmplt -90 -> 190
    //   283: ldc 247
    //   285: ldc_w 1099
    //   288: iconst_2
    //   289: anewarray 251	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: aload 9
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: aload 11
    //   301: aastore
    //   302: invokestatic 1101	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: aload 9
    //   307: iload_1
    //   308: aload 12
    //   310: invokestatic 1107	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   313: astore_2
    //   314: getstatic 418	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   317: sipush 12712
    //   320: aload_2
    //   321: invokevirtual 1111	com/tencent/mm/plugin/report/service/h:aC	(ILjava/lang/String;)V
    //   324: goto -134 -> 190
    //   327: astore 4
    //   329: aload 8
    //   331: astore_2
    //   332: getstatic 418	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   335: ldc2_w 911
    //   338: ldc2_w 1112
    //   341: lconst_1
    //   342: iconst_0
    //   343: invokevirtual 917	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   346: ldc 247
    //   348: new 338	java/lang/StringBuilder
    //   351: dup
    //   352: ldc_w 1115
    //   355: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   358: aload 10
    //   360: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: ldc_w 1117
    //   366: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload 4
    //   371: invokevirtual 935	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   374: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 437	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 9
    //   385: invokestatic 234	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   388: ifeq +17 -> 405
    //   391: ldc 247
    //   393: ldc_w 1087
    //   396: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload 9
    //   401: invokestatic 1090	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   404: pop
    //   405: aload_2
    //   406: ifnull +7 -> 413
    //   409: aload_2
    //   410: invokevirtual 1091	java/io/OutputStream:close	()V
    //   413: aconst_null
    //   414: areturn
    //   415: astore_2
    //   416: aconst_null
    //   417: astore 8
    //   419: aload 9
    //   421: invokestatic 234	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   424: ifeq +17 -> 441
    //   427: ldc 247
    //   429: ldc_w 1087
    //   432: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   435: aload 9
    //   437: invokestatic 1090	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   440: pop
    //   441: aload 8
    //   443: ifnull +8 -> 451
    //   446: aload 8
    //   448: invokevirtual 1091	java/io/OutputStream:close	()V
    //   451: aload_2
    //   452: athrow
    //   453: astore_2
    //   454: goto -232 -> 222
    //   457: astore_2
    //   458: goto -45 -> 413
    //   461: astore 4
    //   463: goto -12 -> 451
    //   466: astore_2
    //   467: goto -48 -> 419
    //   470: astore 4
    //   472: aload_2
    //   473: astore 8
    //   475: aload 4
    //   477: astore_2
    //   478: goto -59 -> 419
    //   481: astore 4
    //   483: aconst_null
    //   484: astore_2
    //   485: goto -153 -> 332
    //   488: iload_3
    //   489: ifeq -241 -> 248
    //   492: sipush 128
    //   495: istore 7
    //   497: goto -365 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	g
    //   0	500	1	paramInt	int
    //   0	500	2	paramArrayOfByte	byte[]
    //   0	500	3	paramBoolean1	boolean
    //   0	500	4	paramCompressFormat	Bitmap.CompressFormat
    //   0	500	5	paramBoolean2	boolean
    //   127	131	6	i	int
    //   250	246	7	j	int
    //   107	367	8	localObject	Object
    //   76	360	9	str1	String
    //   39	320	10	str2	String
    //   53	247	11	str3	String
    //   139	170	12	localDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    // Exception table:
    //   from	to	target	type
    //   109	120	327	java/lang/Exception
    //   132	141	327	java/lang/Exception
    //   146	153	327	java/lang/Exception
    //   157	190	327	java/lang/Exception
    //   255	269	327	java/lang/Exception
    //   272	324	327	java/lang/Exception
    //   101	109	415	finally
    //   217	222	453	java/lang/Exception
    //   409	413	457	java/lang/Exception
    //   446	451	461	java/lang/Exception
    //   109	120	466	finally
    //   132	141	466	finally
    //   146	153	466	finally
    //   157	190	466	finally
    //   255	269	466	finally
    //   272	324	466	finally
    //   332	383	470	finally
    //   101	109	481	java/lang/Exception
  }
  
  public final String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString3, com.tencent.mm.a.b paramb)
  {
    Object localObject = paramString3;
    if (bk.bl(paramString3)) {
      localObject = com.tencent.mm.a.g.o((paramString1 + System.currentTimeMillis()).getBytes());
    }
    paramString3 = b((String)localObject, "", ".jpg", false);
    if (paramb == null) {
      paramString3 = b((String)localObject, "", ".jpg", true);
    }
    paramPString1.value = ((String)localObject);
    paramPString2.value = paramString3;
    if ((paramBoolean) && (!bk.bl(paramString2)) && (paramInt == 0))
    {
      paramString2 = P(paramString2, paramInt);
      if (!bk.bl(paramString2.enq))
      {
        localObject = o(paramString2.enq, "", "");
        if (paramb != null) {
          paramb.rL();
        }
        com.tencent.mm.vfs.e.r((String)localObject, paramString3);
        if (com.tencent.mm.vfs.e.aeQ((String)localObject) > 0L)
        {
          if (!bk.bl(paramString2.enA)) {
            return paramString2.enA;
          }
          return null;
        }
        y.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString1, paramString3 });
      }
    }
    label1087:
    label1241:
    label1377:
    label1763:
    label1773:
    label3437:
    try
    {
      if (aq.isWifi(ae.getContext())) {
        i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        y.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3484;
        }
        n = 70;
        j = 0;
        m = 0;
        k = 1080;
        i = j;
        try
        {
          if (!aq.isWifi(ae.getContext())) {
            break;
          }
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressResolutionForWifi");
          i = j;
          i1 = paramString2.indexOf("*");
          if (-1 == i1) {
            break label3476;
          }
          i = j;
          m = Integer.valueOf(paramString2.substring(0, i1)).intValue();
          i = m;
          j = Integer.valueOf(paramString2.substring(i1 + 1)).intValue();
          i = j;
        }
        catch (Exception paramString2)
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
          i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.g.DN();
          paramString2 = new com.tencent.mm.a.o(com.tencent.mm.kernel.a.CK());
          if ((int)(paramString2.longValue() / 100L) % 100 + 1 > i) {
            break label3470;
          }
          bool1 = true;
          y.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Long.valueOf(paramString2.longValue()), Long.valueOf(paramString2.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.cqk()), Integer.valueOf(Build.VERSION.SDK_INT) });
        }
        catch (Exception paramString2)
        {
          int i7;
          int i4;
          for (;;)
          {
            y.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { bk.j(paramString2) });
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
          int i5 = ((BitmapFactory.Options)localObject).outWidth;
          int i6 = ((BitmapFactory.Options)localObject).outHeight;
          if (((BitmapFactory.Options)localObject).outWidth <= ((BitmapFactory.Options)localObject).outHeight) {
            break label1753;
          }
          k = ((BitmapFactory.Options)localObject).outWidth;
          if (((BitmapFactory.Options)localObject).outWidth >= ((BitmapFactory.Options)localObject).outHeight) {
            break label1763;
          }
          int i2 = ((BitmapFactory.Options)localObject).outWidth;
          if (i <= 0) {
            break label1793;
          }
          int i3 = i2 / i;
          if (((BitmapFactory.Options)localObject).outHeight <= i) {
            break label1773;
          }
          j = ((BitmapFactory.Options)localObject).outHeight * i / i2;
          if (((BitmapFactory.Options)localObject).outWidth <= i) {
            break label1783;
          }
          i = i * ((BitmapFactory.Options)localObject).outWidth / i2;
          k = i;
          i = j;
          if (i * k <= 10240000) {
            break label3457;
          }
          double d = Math.sqrt(10240000.0D / (i * k));
          j = (int)(i / d);
          k = (int)(k / d);
          y.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(j), Integer.valueOf(k) });
          if (localObject == null) {
            break label1873;
          }
          paramString2 = ((BitmapFactory.Options)localObject).outMimeType;
          long l2 = com.tencent.mm.vfs.e.aeQ(paramString1);
          boolean bool2 = MMNativeJpeg.IsJpegFile(paramString1);
          if ((paramString2 == null) || ((!paramString2.endsWith("jpeg")) && (!paramString2.endsWith("jpg")) && (!paramString2.endsWith("bmp")) && (!paramString2.endsWith("png")) && (!paramString2.endsWith("gif")))) {
            break label1880;
          }
          i2 = 1;
          if ((paramInt != 0) || ((m == 0) && (l2 <= 204800L) && ((localObject == null) || (i3 <= 0))) || (l2 <= i7)) {
            break label1893;
          }
          if ((i4 >= 55) && (bool2)) {
            break label3450;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            break label1886;
          }
          long l1;
          long l3;
          for (i = 18;; i = 8)
          {
            l1 = bk.UY();
            m = com.tencent.mm.sdk.platformtools.c.a(paramBoolean, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            if ((m == 1) || (!paramBoolean)) {
              break label3447;
            }
            i = 28;
            m = com.tencent.mm.sdk.platformtools.c.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            paramBoolean = false;
            l3 = com.tencent.mm.vfs.e.aeQ(paramString3);
            y.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(100L * l3 / l2), Integer.valueOf(i1), paramString3 });
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
                com.tencent.mm.vfs.e.r(paramString1, paramString3);
                bool1 = false;
                j = 48;
                k = 1;
              }
            }
            l1 = bk.UY() - l1;
            i = k;
            paramBoolean = bool1;
            if (k == 1) {
              break label2324;
            }
            com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 187L, 1L, false);
            y.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString1 });
            return null;
            k = ((BitmapFactory.Options)localObject).outHeight;
            break;
            i2 = ((BitmapFactory.Options)localObject).outHeight;
            break label1206;
            j = ((BitmapFactory.Options)localObject).outHeight;
            break label1241;
            i = ((BitmapFactory.Options)localObject).outWidth;
            break label1264;
            i3 = k / j;
            if (((BitmapFactory.Options)localObject).outHeight > j)
            {
              i = ((BitmapFactory.Options)localObject).outHeight * j / k;
              if (((BitmapFactory.Options)localObject).outWidth <= j) {
                break label1863;
              }
            }
            for (j = j * ((BitmapFactory.Options)localObject).outWidth / k;; j = ((BitmapFactory.Options)localObject).outWidth)
            {
              k = j;
              break;
              i = ((BitmapFactory.Options)localObject).outHeight;
              break label1823;
            }
            paramString2 = "";
            break label1377;
            i2 = 0;
            break label1446;
          }
          y.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6) });
          if (i2 == 0) {
            break label3159;
          }
          com.tencent.mm.vfs.e.r(paramString1, paramString3);
          com.tencent.mm.ak.f.Nd();
          if (!com.tencent.mm.ak.b.iq(256)) {
            break label3326;
          }
          if (paramInt != 1) {
            break label3334;
          }
          i = 0;
          for (;;)
          {
            for (;;)
            {
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressMidPicLevel")).intValue();
                i = m;
              }
              catch (Exception paramString2)
              {
                continue;
              }
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressMidPicSize")).intValue();
                y.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
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
                  break label3440;
                }
                i = 800;
                if (k <= i) {
                  break label3437;
                }
                k = i;
                if (j <= i) {
                  break label3434;
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
                if ((paramBoolean) || (l2 > 800L) || ((localObject != null) && ((i6 > i) || (i5 > i))))
                {
                  paramPString3.value = com.tencent.mm.a.g.o((paramString1 + System.currentTimeMillis()).getBytes());
                  paramPString4.value = b(paramPString3.value, "", ".jpg", false);
                  i = com.tencent.mm.sdk.platformtools.c.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, i1, paramPString4.value, paramb);
                  y.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  l1 = 0L;
                  j = 38;
                  paramBoolean = false;
                  paramString2 = com.tencent.mm.sdk.platformtools.c.YU(paramString3);
                  if (paramString2 == null) {
                    continue;
                  }
                  k = paramString2.outWidth;
                  if (paramString2 == null) {
                    continue;
                  }
                  m = paramString2.outHeight;
                  l3 = com.tencent.mm.vfs.e.aeQ(paramString3);
                  i2 = MMNativeJpeg.queryQuality(paramString3);
                  boolean bool3 = MMNativeJpeg.IsJpegFile(paramString3);
                  paramString2 = com.tencent.mm.plugin.report.service.h.nFQ;
                  if (!bool2) {
                    continue;
                  }
                  i1 = 1;
                  paramString2.f(11713, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2) });
                  y.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                  if ((paramInt == 0) && (l3 >= 40960L) && (bool3) && (!MMNativeJpeg.isProgressive(paramString3)))
                  {
                    paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("EnableCDNUploadImg");
                    if ((!bk.bl(paramString2)) && (paramString2.equals("1")))
                    {
                      l1 = bk.UY();
                      if (!paramBoolean) {
                        continue;
                      }
                      j = 19;
                      paramString2 = paramString3 + ".prog";
                      com.tencent.mm.vfs.e.r(paramString3, paramString2);
                      if ((!bk.bl(paramString2)) && (!bk.bl(paramString3)) && (new File(paramString2).exists())) {
                        continue;
                      }
                      bool1 = false;
                      com.tencent.mm.vfs.e.deleteFile(paramString2);
                      if (bool1) {
                        break label3431;
                      }
                      bool1 = MMNativeJpeg.convertToProgressive(paramString3, n);
                      j = 29;
                      long l4 = bk.UY();
                      long l5 = com.tencent.mm.vfs.e.aeQ(paramString3);
                      paramString2 = com.tencent.mm.plugin.report.service.h.nFQ;
                      if (!bool1) {
                        continue;
                      }
                      n = 1;
                      if (!bool2) {
                        continue;
                      }
                      i1 = 1;
                      paramString2.f(11713, new Object[] { Integer.valueOf(n), Long.valueOf(l4 - l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2), Long.valueOf(l5) });
                      y.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                      if (!bool1)
                      {
                        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 186L, 1L, false);
                        y.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString3 });
                      }
                    }
                  }
                  return null;
                  if (com.tencent.mm.sdk.platformtools.c.a(false, paramString1, i5, i6, Bitmap.CompressFormat.JPEG, 100, paramString3, paramb) == 1) {
                    break;
                  }
                  com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 187L, 1L, false);
                  y.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString1 });
                  return null;
                }
              }
              catch (Exception paramString2)
              {
                m = 0;
                continue;
                paramPString3.value = paramPString1.value;
                paramPString4.value = paramPString2.value;
                y.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(j), Integer.valueOf(k), paramPString3.value, paramPString4.value });
                l1 = 0L;
                i = 1;
                j = 38;
                paramBoolean = false;
              }
            }
            y.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
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
            if (MMJpegOptim.convertToProgressive(paramString2, paramString3, n) == 0)
            {
              bool1 = true;
            }
            else
            {
              bool1 = false;
              continue;
              j = 9;
              bool1 = MMNativeJpeg.convertToProgressive(paramString3, n);
              continue;
              n = -1;
              continue;
              i1 = 2;
            }
          }
        }
        if (com.tencent.mm.sdk.a.b.cqk()) {
          bool1 = true;
        }
        if (!d.gG(16)) {
          break label3467;
        }
        bool1 = false;
        y.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        if ((m > 0) || (k > 0)) {
          break label1087;
        }
        j = 0;
        i = 1080;
        m = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        k = m;
        if (m <= 0) {
          k = 100;
        }
        i7 = k * 1024;
        i1 = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((i1 > 0) && (i1 < 100)) {
          break label3464;
        }
        i1 = 10;
        i4 = MMNativeJpeg.queryQuality(paramString1);
        k = 1;
        m = k;
        if (i4 != 0)
        {
          m = k;
          if (i4 <= n) {
            m = 0;
          }
        }
        y.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[] { paramString1, paramString3, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i7), Integer.valueOf(i1) });
        if (!paramBoolean) {
          break label3157;
        }
        localObject = com.tencent.mm.sdk.platformtools.c.YU(paramString1);
        if ((localObject != null) && (((BitmapFactory.Options)localObject).outWidth != 0) && (((BitmapFactory.Options)localObject).outHeight != 0)) {
          break label1152;
        }
        if (localObject != null) {
          break label1146;
        }
        paramBoolean = true;
        y.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString1, Boolean.valueOf(paramBoolean) });
        return null;
        if (aq.is2G(ae.getContext())) {
          i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelFor2G"), 40);
        } else if (aq.is3G(ae.getContext())) {
          i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bk.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception paramString2)
    {
      label1264:
      label3440:
      for (;;)
      {
        int n;
        int j;
        int m;
        int k;
        int i = 0;
        continue;
        i = j;
        label1783:
        label3447:
        if (aq.is2G(ae.getContext()))
        {
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          label1146:
          label3450:
          if (aq.is3G(ae.getContext()))
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressResolutionFor3G");
          }
          else
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.zero.b.a.class)).AA().getValue("CompressResolutionFor4G");
            continue;
            label3326:
            n = i;
          }
        }
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat)
  {
    if (bk.bE(paramArrayOfByte))
    {
      y.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      return null;
    }
    String str1 = com.tencent.mm.a.g.o(bk.UY().getBytes());
    String str2 = o(str1, "th_", "");
    y.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[] { str2 });
    try
    {
      com.tencent.mm.sdk.platformtools.c.a(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length), 100, paramCompressFormat, str2, true);
      return "THUMBNAIL_DIRPATH://th_" + str1;
    }
    catch (IOException localIOException)
    {
      y.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localIOException });
      return a(9, paramArrayOfByte, true, paramCompressFormat);
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localException });
    }
    return a(9, paramArrayOfByte, true, paramCompressFormat);
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: aload_1
    //   10: invokestatic 1059	com/tencent/mm/sdk/platformtools/bk:bE	([B)Z
    //   13: ifeq +13 -> 26
    //   16: ldc 247
    //   18: ldc_w 1061
    //   21: invokestatic 437	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aconst_null
    //   25: areturn
    //   26: new 338	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 339	java/lang/StringBuilder:<init>	()V
    //   33: invokestatic 1002	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   36: invokevirtual 707	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   39: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokevirtual 171	java/lang/String:getBytes	()[B
    //   45: invokestatic 177	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   48: astore 11
    //   50: aload_0
    //   51: aload 11
    //   53: ldc_w 397
    //   56: ldc_w 399
    //   59: invokevirtual 406	com/tencent/mm/as/g:o	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 12
    //   64: new 338	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 339	java/lang/StringBuilder:<init>	()V
    //   71: aload 12
    //   73: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc_w 1063
    //   79: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 10
    //   87: ldc 247
    //   89: new 338	java/lang/StringBuilder
    //   92: dup
    //   93: ldc_w 1065
    //   96: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload 12
    //   101: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 10
    //   112: iconst_0
    //   113: invokestatic 1068	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   116: astore 7
    //   118: aload 7
    //   120: astore 6
    //   122: aload 6
    //   124: astore 7
    //   126: aload 6
    //   128: aload_1
    //   129: invokevirtual 1073	java/io/OutputStream:write	([B)V
    //   132: aload 6
    //   134: astore 7
    //   136: aload 6
    //   138: invokevirtual 1076	java/io/OutputStream:flush	()V
    //   141: aload 6
    //   143: astore 7
    //   145: new 1078	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   148: dup
    //   149: invokespecial 1079	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   152: astore 14
    //   154: aload 6
    //   156: astore 7
    //   158: aload 10
    //   160: iload 4
    //   162: iload_3
    //   163: iconst_0
    //   164: aload 14
    //   166: iconst_0
    //   167: invokestatic 1094	com/tencent/mm/sdk/platformtools/c:a	(Ljava/lang/String;IIZLcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)Landroid/graphics/Bitmap;
    //   170: astore 13
    //   172: aload 13
    //   174: ifnull +351 -> 525
    //   177: bipush 100
    //   179: istore_3
    //   180: aload 6
    //   182: astore 7
    //   184: aload_1
    //   185: arraylength
    //   186: istore 5
    //   188: iload_3
    //   189: istore 4
    //   191: iload 5
    //   193: ldc_w 1338
    //   196: if_icmple +116 -> 312
    //   199: aload 8
    //   201: astore 7
    //   203: new 1340	java/io/ByteArrayOutputStream
    //   206: dup
    //   207: invokespecial 1341	java/io/ByteArrayOutputStream:<init>	()V
    //   210: astore 8
    //   212: iload_3
    //   213: istore 4
    //   215: aload 13
    //   217: aload_2
    //   218: bipush 100
    //   220: aload 8
    //   222: invokevirtual 1345	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   225: pop
    //   226: iload_3
    //   227: istore 4
    //   229: aload 8
    //   231: invokevirtual 1348	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   234: arraylength
    //   235: ldc_w 1338
    //   238: if_icmple +174 -> 412
    //   241: iload_3
    //   242: bipush 15
    //   244: if_icmplt +168 -> 412
    //   247: iload_3
    //   248: istore 4
    //   250: aload 8
    //   252: invokevirtual 1351	java/io/ByteArrayOutputStream:reset	()V
    //   255: iload_3
    //   256: iconst_5
    //   257: isub
    //   258: istore_3
    //   259: iload_3
    //   260: istore 4
    //   262: aload 13
    //   264: aload_2
    //   265: iload_3
    //   266: aload 8
    //   268: invokevirtual 1345	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   271: pop
    //   272: goto -46 -> 226
    //   275: astore 7
    //   277: iload 4
    //   279: istore_3
    //   280: aload 8
    //   282: astore 7
    //   284: ldc 247
    //   286: ldc_w 1353
    //   289: invokestatic 437	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: iload_3
    //   293: istore 4
    //   295: aload 8
    //   297: ifnull +15 -> 312
    //   300: aload 6
    //   302: astore 7
    //   304: aload 8
    //   306: invokevirtual 1354	java/io/ByteArrayOutputStream:close	()V
    //   309: iload_3
    //   310: istore 4
    //   312: aload 6
    //   314: astore 7
    //   316: aload 13
    //   318: iload 4
    //   320: aload_2
    //   321: aload 12
    //   323: iconst_1
    //   324: invokestatic 872	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   327: aload 6
    //   329: astore 7
    //   331: ldc 247
    //   333: ldc_w 1356
    //   336: iconst_3
    //   337: anewarray 251	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload 10
    //   344: aastore
    //   345: dup
    //   346: iconst_1
    //   347: aload 12
    //   349: aastore
    //   350: dup
    //   351: iconst_2
    //   352: iload 4
    //   354: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: aastore
    //   358: invokestatic 509	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   361: aload 10
    //   363: invokestatic 234	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   366: ifeq +17 -> 383
    //   369: ldc 247
    //   371: ldc_w 1087
    //   374: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload 10
    //   379: invokestatic 1090	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   382: pop
    //   383: aload 6
    //   385: ifnull +8 -> 393
    //   388: aload 6
    //   390: invokevirtual 1091	java/io/OutputStream:close	()V
    //   393: new 338	java/lang/StringBuilder
    //   396: dup
    //   397: ldc_w 395
    //   400: invokespecial 385	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: aload 11
    //   405: invokevirtual 343	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 348	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: areturn
    //   412: aload 6
    //   414: astore 7
    //   416: aload 8
    //   418: invokevirtual 1354	java/io/ByteArrayOutputStream:close	()V
    //   421: iload_3
    //   422: istore 4
    //   424: goto -112 -> 312
    //   427: astore 7
    //   429: iload_3
    //   430: istore 4
    //   432: goto -120 -> 312
    //   435: astore 8
    //   437: aload 7
    //   439: astore 9
    //   441: aload 9
    //   443: ifnull +12 -> 455
    //   446: aload 6
    //   448: astore 7
    //   450: aload 9
    //   452: invokevirtual 1354	java/io/ByteArrayOutputStream:close	()V
    //   455: aload 6
    //   457: astore 7
    //   459: aload 8
    //   461: athrow
    //   462: astore 7
    //   464: ldc 247
    //   466: ldc_w 1334
    //   469: iconst_1
    //   470: anewarray 251	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload 7
    //   477: aastore
    //   478: invokestatic 262	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   481: aload_0
    //   482: bipush 6
    //   484: aload_1
    //   485: iconst_1
    //   486: aload_2
    //   487: invokevirtual 1336	com/tencent/mm/as/g:a	(I[BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   490: astore_1
    //   491: aload 10
    //   493: invokestatic 234	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   496: ifeq +17 -> 513
    //   499: ldc 247
    //   501: ldc_w 1087
    //   504: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: aload 10
    //   509: invokestatic 1090	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   512: pop
    //   513: aload 6
    //   515: ifnull +8 -> 523
    //   518: aload 6
    //   520: invokevirtual 1091	java/io/OutputStream:close	()V
    //   523: aload_1
    //   524: areturn
    //   525: aload 6
    //   527: astore 7
    //   529: aload 14
    //   531: invokevirtual 1097	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   534: sipush 2000
    //   537: if_icmplt -176 -> 361
    //   540: aload 6
    //   542: astore 7
    //   544: ldc 247
    //   546: ldc_w 1099
    //   549: iconst_2
    //   550: anewarray 251	java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: aload 10
    //   557: aastore
    //   558: dup
    //   559: iconst_1
    //   560: aload 12
    //   562: aastore
    //   563: invokestatic 1101	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: aload 6
    //   568: astore 7
    //   570: aload 10
    //   572: bipush 6
    //   574: aload 14
    //   576: invokestatic 1107	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   579: astore 8
    //   581: aload 6
    //   583: astore 7
    //   585: getstatic 418	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   588: sipush 12712
    //   591: aload 8
    //   593: invokevirtual 1111	com/tencent/mm/plugin/report/service/h:aC	(ILjava/lang/String;)V
    //   596: goto -235 -> 361
    //   599: astore 8
    //   601: aload 6
    //   603: astore 7
    //   605: ldc 247
    //   607: ldc_w 1334
    //   610: iconst_1
    //   611: anewarray 251	java/lang/Object
    //   614: dup
    //   615: iconst_0
    //   616: aload 8
    //   618: aastore
    //   619: invokestatic 262	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   622: aload 6
    //   624: astore 7
    //   626: aload_0
    //   627: bipush 6
    //   629: aload_1
    //   630: iconst_1
    //   631: aload_2
    //   632: invokevirtual 1336	com/tencent/mm/as/g:a	(I[BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   635: astore_1
    //   636: aload 10
    //   638: invokestatic 234	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   641: ifeq +17 -> 658
    //   644: ldc 247
    //   646: ldc_w 1087
    //   649: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   652: aload 10
    //   654: invokestatic 1090	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   657: pop
    //   658: aload 6
    //   660: ifnull +8 -> 668
    //   663: aload 6
    //   665: invokevirtual 1091	java/io/OutputStream:close	()V
    //   668: aload_1
    //   669: areturn
    //   670: astore_1
    //   671: aconst_null
    //   672: astore 7
    //   674: aload 10
    //   676: invokestatic 234	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   679: ifeq +17 -> 696
    //   682: ldc 247
    //   684: ldc_w 1087
    //   687: invokestatic 391	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: aload 10
    //   692: invokestatic 1090	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   695: pop
    //   696: aload 7
    //   698: ifnull +8 -> 706
    //   701: aload 7
    //   703: invokevirtual 1091	java/io/OutputStream:close	()V
    //   706: aload_1
    //   707: athrow
    //   708: astore 7
    //   710: iload_3
    //   711: istore 4
    //   713: goto -401 -> 312
    //   716: astore 7
    //   718: goto -263 -> 455
    //   721: astore_1
    //   722: goto -329 -> 393
    //   725: astore_2
    //   726: goto -203 -> 523
    //   729: astore_2
    //   730: goto -62 -> 668
    //   733: astore_2
    //   734: goto -28 -> 706
    //   737: astore_1
    //   738: goto -64 -> 674
    //   741: astore_1
    //   742: aload 6
    //   744: astore 7
    //   746: goto -72 -> 674
    //   749: astore 8
    //   751: aconst_null
    //   752: astore 6
    //   754: goto -153 -> 601
    //   757: astore 7
    //   759: goto -295 -> 464
    //   762: astore 7
    //   764: aload 8
    //   766: astore 9
    //   768: aload 7
    //   770: astore 8
    //   772: goto -331 -> 441
    //   775: astore 7
    //   777: aload 9
    //   779: astore 8
    //   781: goto -501 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	this	g
    //   0	784	1	paramArrayOfByte	byte[]
    //   0	784	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	784	3	paramInt1	int
    //   0	784	4	paramInt2	int
    //   186	11	5	i	int
    //   4	749	6	localObject1	Object
    //   116	86	7	localObject2	Object
    //   275	1	7	localException1	Exception
    //   282	133	7	localObject3	Object
    //   427	11	7	localException2	Exception
    //   448	10	7	localObject4	Object
    //   462	14	7	localIOException1	IOException
    //   527	175	7	localObject5	Object
    //   708	1	7	localException3	Exception
    //   716	1	7	localException4	Exception
    //   744	1	7	localObject6	Object
    //   757	1	7	localIOException2	IOException
    //   762	7	7	localObject7	Object
    //   775	1	7	localException5	Exception
    //   1	416	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   435	25	8	localObject8	Object
    //   579	13	8	str1	String
    //   599	18	8	localException6	Exception
    //   749	16	8	localException7	Exception
    //   770	10	8	localObject9	Object
    //   7	771	9	localObject10	Object
    //   85	606	10	str2	String
    //   48	356	11	str3	String
    //   62	499	12	str4	String
    //   170	147	13	localBitmap	Bitmap
    //   152	423	14	localDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    // Exception table:
    //   from	to	target	type
    //   215	226	275	java/lang/Exception
    //   229	241	275	java/lang/Exception
    //   250	255	275	java/lang/Exception
    //   262	272	275	java/lang/Exception
    //   416	421	427	java/lang/Exception
    //   203	212	435	finally
    //   284	292	435	finally
    //   126	132	462	java/io/IOException
    //   136	141	462	java/io/IOException
    //   145	154	462	java/io/IOException
    //   158	172	462	java/io/IOException
    //   184	188	462	java/io/IOException
    //   304	309	462	java/io/IOException
    //   316	327	462	java/io/IOException
    //   331	361	462	java/io/IOException
    //   416	421	462	java/io/IOException
    //   450	455	462	java/io/IOException
    //   459	462	462	java/io/IOException
    //   529	540	462	java/io/IOException
    //   544	566	462	java/io/IOException
    //   570	581	462	java/io/IOException
    //   585	596	462	java/io/IOException
    //   126	132	599	java/lang/Exception
    //   136	141	599	java/lang/Exception
    //   145	154	599	java/lang/Exception
    //   158	172	599	java/lang/Exception
    //   184	188	599	java/lang/Exception
    //   316	327	599	java/lang/Exception
    //   331	361	599	java/lang/Exception
    //   459	462	599	java/lang/Exception
    //   529	540	599	java/lang/Exception
    //   544	566	599	java/lang/Exception
    //   570	581	599	java/lang/Exception
    //   585	596	599	java/lang/Exception
    //   110	118	670	finally
    //   304	309	708	java/lang/Exception
    //   450	455	716	java/lang/Exception
    //   388	393	721	java/lang/Exception
    //   518	523	725	java/lang/Exception
    //   663	668	729	java/lang/Exception
    //   701	706	733	java/lang/Exception
    //   126	132	737	finally
    //   136	141	737	finally
    //   145	154	737	finally
    //   158	172	737	finally
    //   184	188	737	finally
    //   304	309	737	finally
    //   316	327	737	finally
    //   331	361	737	finally
    //   416	421	737	finally
    //   450	455	737	finally
    //   459	462	737	finally
    //   529	540	737	finally
    //   544	566	737	finally
    //   570	581	737	finally
    //   585	596	737	finally
    //   605	622	737	finally
    //   626	636	737	finally
    //   464	491	741	finally
    //   110	118	749	java/lang/Exception
    //   110	118	757	java/io/IOException
    //   215	226	762	finally
    //   229	241	762	finally
    //   250	255	762	finally
    //   262	272	762	finally
    //   203	212	775	java/lang/Exception
  }
  
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    return a(8, paramArrayOfByte, paramBoolean, paramCompressFormat);
  }
  
  public final HashMap<Long, e> a(Long... paramVarArgs)
  {
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
      for (localObject1 = Long.valueOf(l);; localObject1 = "," + l)
      {
        localObject1 = localObject1;
        i += 1;
        j = 0;
        break;
      }
    }
    paramVarArgs = (String)localObject1 + ")";
    paramVarArgs = b("ImgInfo2", null, "msgSvrId in " + paramVarArgs, null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new e();
      ((e)localObject2).d(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).bXr), localObject2);
    }
    paramVarArgs.close();
    return localObject1;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, float paramFloat, int paramInt1, int paramInt2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, View paramView)
  {
    return a(paramImageView1, paramString, false, paramFloat, paramInt1, paramInt2, paramInt3, paramImageView2, paramInt4, paramInt5, paramView);
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, int paramInt3, ImageView paramImageView2, int paramInt4, int paramInt5, View paramView)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      return false;
    }
    boolean bool;
    String str;
    synchronized (this.eod)
    {
      bool = this.eod.containsKey(paramString);
      str = b(paramString, paramBoolean, false);
      if (bk.bl(str))
      {
        y.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { bk.pm(paramString) });
        return false;
      }
    }
    Object localObject = str;
    if (!bool)
    {
      localObject = str;
      if (!str.endsWith("hd"))
      {
        localObject = str;
        if (com.tencent.mm.vfs.e.bK(str + "hd"))
        {
          this.eod.put(paramString, str + "hd");
          localObject = str + "hd";
        }
      }
    }
    int i;
    if (((String)localObject).endsWith("hd"))
    {
      paramString = (Bitmap)this.enW.get(localObject);
      if (paramString == null)
      {
        a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, paramInt3);
        localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
        i = 1;
      }
    }
    for (;;)
    {
      if (paramString == null) {
        paramString = (Bitmap)this.enW.get(localObject);
      }
      label393:
      label414:
      label1079:
      for (;;)
      {
        if ((paramString != null) && (!paramString.isRecycled()))
        {
          y.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          g.a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width != -2)
          {
            localObject = this.eog;
            label355:
            if (paramInt5 != 0) {
              break label571;
            }
            ((FrameLayout.LayoutParams)localObject).gravity = 5;
            label366:
            paramImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
            if (paramString.getWidth() < paramString.getHeight() * 2.5D) {
              break label586;
            }
            paramInt1 = 1;
            if (paramString.getHeight() < paramString.getWidth() * 2.5D) {
              break label592;
            }
            paramInt2 = 1;
            if ((paramInt1 != 0) || (paramInt2 != 0)) {
              paramImageView1.setScaleType(ImageView.ScaleType.CENTER);
            }
            if (paramImageView2 != null)
            {
              paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
              if (paramInt5 != 0) {
                break label598;
              }
              paramImageView1.gravity = 5;
              label462:
              paramImageView2.setLayoutParams(paramImageView1);
            }
            if (paramView != null)
            {
              paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
              if (paramInt5 != 0) {
                break label612;
              }
              paramImageView1.gravity = 5;
            }
          }
          for (;;)
          {
            paramView.setLayoutParams(paramImageView1);
            return true;
            if (this.enW.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
              y.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: " + (String)localObject);
            }
            i = 0;
            break;
            localObject = (FrameLayout.LayoutParams)paramImageView1.getLayoutParams();
            break label355;
            label571:
            if (paramInt5 != 1) {
              break label366;
            }
            ((FrameLayout.LayoutParams)localObject).gravity = 3;
            break label366;
            label586:
            paramInt1 = 0;
            break label393;
            label592:
            paramInt2 = 0;
            break label414;
            label598:
            if (paramInt5 != 1) {
              break label462;
            }
            paramImageView1.gravity = 3;
            break label462;
            label612:
            if (paramInt5 == 1) {
              paramImageView1.gravity = 3;
            }
          }
        }
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
                break label888;
              }
              label697:
              paramInt4 = (int)(paramInt1 * paramFloat);
              if (paramInt2 <= 0) {
                break label895;
              }
              paramInt1 = paramInt2;
              label715:
              paramInt1 = (int)(paramInt1 * paramFloat);
              paramInt2 = paramInt4;
              if (paramInt2 >= 60.0F * paramFloat) {
                break label1089;
              }
              y.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(paramInt2) });
              paramInt2 = (int)(60.0F * paramFloat);
            }
          }
        }
        label952:
        label1086:
        label1089:
        for (;;)
        {
          paramInt4 = paramInt1;
          if (paramInt1 < 60.0F * paramFloat)
          {
            y.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(paramInt1) });
            paramInt4 = (int)(60.0F * paramFloat);
          }
          paramString = new FrameLayout.LayoutParams(paramInt2, paramInt4);
          if (paramInt5 == 0)
          {
            paramString.gravity = 5;
            label838:
            if (paramView == null) {
              break label1086;
            }
            paramView.setLayoutParams(paramString);
          }
          for (;;)
          {
            paramImageView1.setLayoutParams(paramString);
            if (i == 0) {
              a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat, paramInt3);
            }
            return false;
            f = 160.0F / paramInt1;
            break;
            label888:
            paramInt1 = 120;
            break label697;
            label895:
            paramInt1 = 75;
            break label715;
            if (paramInt1 > 0)
            {
              paramInt4 = (int)(paramInt1 * paramFloat * 1.25F);
              if (paramInt2 <= 0) {
                break label952;
              }
            }
            for (;;)
            {
              paramInt1 = (int)(paramInt2 * paramFloat * 1.25F);
              paramInt2 = paramInt4;
              break;
              paramInt1 = 120;
              break label907;
              paramInt2 = 75;
            }
            if (paramInt5 != 1) {
              break label838;
            }
            paramString.gravity = 3;
            break label838;
            if ((this.eoh == null) || (this.eoh.get() == null)) {
              this.eoh = new SoftReference(new ColorDrawable(-1118482));
            }
            paramImageView1.setImageDrawable((ColorDrawable)this.eoh.get());
            if (paramInt1 > 0)
            {
              paramInt1 = (int)(paramInt1 * paramFloat * 1.25F);
              if (paramInt2 <= 0) {
                break label1079;
              }
            }
            for (;;)
            {
              paramString = new FrameLayout.LayoutParams(paramInt1, (int)(paramInt2 * paramFloat * 1.25F));
              break;
              paramInt1 = 120;
              break label1030;
              paramInt2 = 75;
            }
          }
        }
      }
      label907:
      i = 0;
      label1030:
      paramString = null;
    }
  }
  
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    y.d("MicroMsg.ImgInfoStorage", "createHDThumbNail bigPicPath%s thumbPath%s maskResId:%d, compressType:%d, stack[%s]", new Object[] { ???, paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bk.csb() });
    long l = System.currentTimeMillis();
    float f = com.tencent.mm.cb.a.getDensity(ae.getContext());
    if ((bk.bl(???)) || (bk.bl(paramString2))) {
      return false;
    }
    Object localObject1 = b(paramString2, false, true);
    if (bk.bl((String)localObject1)) {
      return false;
    }
    Object localObject2;
    if (!((String)localObject1).endsWith("hd"))
    {
      localObject3 = (String)localObject1 + "hd";
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.c.YU((String)localObject2);
      if ((localOptions != null) && (localOptions.outWidth > 0))
      {
        localObject3 = localOptions;
        if (localOptions.outHeight > 0) {
          break label274;
        }
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 185L, 1L, false);
      if (com.tencent.mm.vfs.e.aeQ((String)localObject2) <= 0L) {
        break;
      }
      return false;
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
    }
    Object localObject3 = new BitmapFactory.Options();
    com.tencent.mm.sdk.platformtools.c.c((BitmapFactory.Options)localObject3);
    y.i("MicroMsg.ImgInfoStorage", "createHDThumbNail old op is invaild but len is 0 need recreate[%s, %d, %d]", new Object[] { localObject3, Integer.valueOf(((BitmapFactory.Options)localObject3).outWidth), Integer.valueOf(((BitmapFactory.Options)localObject3).outHeight) });
    com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 183L, 1L, false);
    label274:
    if (((BitmapFactory.Options)localObject3).outWidth == 0) {
      ((BitmapFactory.Options)localObject3).outWidth = paramInt3;
    }
    if (((BitmapFactory.Options)localObject3).outHeight == 0) {
      ((BitmapFactory.Options)localObject3).outHeight = paramInt4;
    }
    int j = (int)(((BitmapFactory.Options)localObject3).outWidth * f * 1.25F);
    int i = (int)(((BitmapFactory.Options)localObject3).outHeight * f * 1.25F);
    if (j < 160.0F * f)
    {
      paramInt4 = i;
      paramInt3 = j;
      if (i < 160.0F * f) {}
    }
    else
    {
      if (i <= j) {
        break label588;
      }
      f = 160.0F * f / i;
      paramInt3 = (int)(j * f);
      paramInt4 = (int)(f * i);
    }
    if (paramInt2 == 0) {}
    boolean bool;
    for (;;)
    {
      try
      {
        bool = com.tencent.mm.sdk.platformtools.c.a(???, paramInt4, paramInt3, Bitmap.CompressFormat.JPEG, (String)localObject1, new PInt(), new PInt());
        y.d("MicroMsg.ImgInfoStorage", "createHDThumbNail user time %s, height %d, width %d, hasHDThumb:%b", new Object[] { System.currentTimeMillis() - l, Integer.valueOf(paramInt4), Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        a((String)localObject2, true, com.tencent.mm.cb.a.getDensity(ae.getContext()), true, false, true, paramInt1, false);
        if (!bool) {
          break label671;
        }
        synchronized (this.eod)
        {
          if ((this.eod.containsKey(paramString2)) && (!((String)this.eod.get(paramString2)).endsWith("hd"))) {
            this.eod.put(paramString2, localObject1);
          }
          return bool;
        }
        label588:
        f = 160.0F * f / j;
      }
      catch (Exception ???)
      {
        com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 184L, 1L, false);
        y.e("MicroMsg.ImgInfoStorage", "create hd thumbnail failed. %s", new Object[] { ???.toString() });
        return false;
      }
      bool = com.tencent.mm.sdk.platformtools.c.b(???, paramInt4, paramInt3, Bitmap.CompressFormat.JPEG, (String)localObject1, new PInt(), new PInt());
    }
    label671:
    com.tencent.mm.plugin.report.service.h.nFQ.a(111L, 184L, 1L, false);
    return bool;
  }
  
  public final Bitmap b(String paramString, float paramFloat, boolean paramBoolean)
  {
    return a(paramString, true, paramFloat, paramBoolean, true, false, 0);
  }
  
  public final e b(Long paramLong)
  {
    e locale = new e();
    paramLong = a("ImgInfo2", null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      locale.d(paramLong);
    }
    paramLong.close();
    return locale;
  }
  
  public final String b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    if (bk.bl(paramString1)) {
      return null;
    }
    if (paramString1.startsWith("SERVERID://")) {}
    for (String str1 = paramString1.substring(11);; str1 = "") {
      for (;;)
      {
        try
        {
          str1 = bX(Long.valueOf(str1).longValue()).enq;
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = com.tencent.mm.plugin.n.c.FG();
            String str4 = com.tencent.mm.plugin.n.c.FH();
            String str2 = str1;
            if (bk.bl(str1)) {
              str2 = paramString1;
            }
            return com.tencent.mm.sdk.platformtools.h.b(str3, str4, paramString2, str2, paramString3, paramBoolean);
          }
        }
        catch (NumberFormatException paramString1)
        {
          y.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString1.getMessage());
          return null;
        }
      }
    }
  }
  
  public final String b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if ((paramString != null) && (this.eod.containsKey(paramString)))
    {
      localObject = (String)this.eod.get(paramString);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = F(paramString, paramBoolean2))
    {
      localObject = str;
      if (bk.bl(str)) {
        break;
      }
      this.eod.put(paramString, str);
      return str;
    }
  }
  
  public final HashMap<Long, e> b(Long... paramVarArgs)
  {
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
      for (localObject1 = Long.valueOf(l);; localObject1 = "," + l)
      {
        localObject1 = localObject1;
        i += 1;
        j = 0;
        break;
      }
    }
    paramVarArgs = (String)localObject1 + ")";
    paramVarArgs = b("ImgInfo2", null, "msglocalid in " + paramVarArgs, null);
    localObject1 = new HashMap();
    while (paramVarArgs.moveToNext())
    {
      localObject2 = new e();
      ((e)localObject2).d(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).bXr), localObject2);
    }
    paramVarArgs.close();
    return localObject1;
  }
  
  public final e bX(long paramLong)
  {
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToFirst()) {
      locale.d(localCursor);
    }
    localCursor.close();
    return locale;
  }
  
  public final e bY(long paramLong)
  {
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToLast()) {
      locale.d(localCursor);
    }
    localCursor.close();
    return locale;
  }
  
  public final String d(e parame)
  {
    Object localObject = null;
    if (parame == null) {}
    while (!parame.Or()) {
      return null;
    }
    parame = parame.enz;
    Cursor localCursor = b("ImgInfo2", new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { parame });
    parame = localObject;
    if (localCursor.moveToFirst()) {
      parame = localCursor.getString(0);
    }
    localCursor.close();
    return parame;
  }
  
  public final long e(e parame)
  {
    long l = this.dXo.insert("ImgInfo2", "id", parame.vf());
    if (l != -1L) {
      parame.Os();
    }
    y.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { Long.valueOf(l), Long.valueOf(parame.enp), Long.valueOf(parame.enx), Long.valueOf(parame.bXr), Integer.valueOf(parame.enz) });
    return l;
  }
  
  public final String g(int paramInt, byte[] paramArrayOfByte)
  {
    if (bk.bE(paramArrayOfByte)) {
      y.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
    }
    do
    {
      return null;
      localObject = new MMBitmapFactory.DecodeResultLogger();
      if (MMBitmapFactory.checkIsImageLegal(paramArrayOfByte, (MMBitmapFactory.DecodeResultLogger)localObject)) {
        break;
      }
    } while (((MMBitmapFactory.DecodeResultLogger)localObject).getDecodeResult() < 2000);
    y.e("MicroMsg.ImgInfoStorage", "img in thumbBuf hits hole.");
    paramArrayOfByte = MMBitmapFactory.KVStatHelper.getKVStatString(paramArrayOfByte, paramInt, (MMBitmapFactory.DecodeResultLogger)localObject);
    com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramArrayOfByte);
    return null;
    Object localObject = com.tencent.mm.a.g.o(bk.UY().getBytes());
    String str = o((String)localObject, "th_", "");
    y.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = " + str);
    com.tencent.mm.vfs.e.deleteFile(str);
    com.tencent.mm.vfs.e.b(str, paramArrayOfByte, paramArrayOfByte.length);
    return "THUMBNAIL_DIRPATH://th_" + (String)localObject;
  }
  
  public final String getFullPath(String paramString)
  {
    if (bk.bl(paramString)) {
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
        str1 = bX(Long.valueOf(str1).longValue()).enq;
        String str2 = com.tencent.mm.plugin.n.c.FG();
        String str3 = com.tencent.mm.plugin.n.c.FH();
        if (bk.bl(str1)) {
          return com.tencent.mm.sdk.platformtools.h.e(str2, str3, "th_", paramString, "");
        }
      }
      catch (NumberFormatException paramString)
      {
        y.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        return null;
      }
      paramString = str1;
    }
  }
  
  public final e iH(int paramInt)
  {
    return b(Long.valueOf(paramInt));
  }
  
  /* Error */
  public final e iI(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 184
    //   3: aconst_null
    //   4: ldc_w 1525
    //   7: iconst_1
    //   8: anewarray 48	java/lang/String
    //   11: dup
    //   12: iconst_0
    //   13: iload_1
    //   14: invokestatic 189	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   17: aastore
    //   18: invokespecial 1371	com/tencent/mm/as/g:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +131 -> 154
    //   26: aload_3
    //   27: astore 4
    //   29: aload_3
    //   30: invokeinterface 198 1 0
    //   35: ifeq +119 -> 154
    //   38: aload_3
    //   39: astore 4
    //   41: new 181	com/tencent/mm/as/e
    //   44: dup
    //   45: invokespecial 182	com/tencent/mm/as/e:<init>	()V
    //   48: astore_2
    //   49: aload_3
    //   50: astore 4
    //   52: aload_2
    //   53: aload_3
    //   54: invokevirtual 202	com/tencent/mm/as/e:d	(Landroid/database/Cursor;)V
    //   57: aload_2
    //   58: astore 4
    //   60: aload_3
    //   61: ifnull +12 -> 73
    //   64: aload_3
    //   65: invokeinterface 205 1 0
    //   70: aload_2
    //   71: astore 4
    //   73: aload 4
    //   75: areturn
    //   76: astore 5
    //   78: aconst_null
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_3
    //   83: astore 4
    //   85: ldc 247
    //   87: ldc_w 1527
    //   90: iconst_1
    //   91: anewarray 251	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload 5
    //   98: invokevirtual 1462	java/lang/Exception:toString	()Ljava/lang/String;
    //   101: aastore
    //   102: invokestatic 1101	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload_2
    //   106: astore 4
    //   108: aload_3
    //   109: ifnull -36 -> 73
    //   112: aload_3
    //   113: invokeinterface 205 1 0
    //   118: aload_2
    //   119: areturn
    //   120: astore_2
    //   121: aconst_null
    //   122: astore 4
    //   124: aload 4
    //   126: ifnull +10 -> 136
    //   129: aload 4
    //   131: invokeinterface 205 1 0
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: goto -15 -> 124
    //   142: astore 5
    //   144: aconst_null
    //   145: astore_2
    //   146: goto -64 -> 82
    //   149: astore 5
    //   151: goto -69 -> 82
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -99 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	g
    //   0	159	1	paramInt	int
    //   48	71	2	locale	e
    //   120	17	2	localObject1	Object
    //   138	1	2	localObject2	Object
    //   145	11	2	localObject3	Object
    //   21	92	3	localCursor	Cursor
    //   27	103	4	localObject4	Object
    //   76	21	5	localException1	Exception
    //   142	1	5	localException2	Exception
    //   149	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	76	java/lang/Exception
    //   0	22	120	finally
    //   29	38	138	finally
    //   41	49	138	finally
    //   52	57	138	finally
    //   85	105	138	finally
    //   29	38	142	java/lang/Exception
    //   41	49	142	java/lang/Exception
    //   52	57	149	java/lang/Exception
  }
  
  public final String me(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
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
        paramString = iH(Integer.valueOf(paramString).intValue()).ens;
        return o(paramString, str1, "");
      }
      catch (NumberFormatException paramString)
      {
        y.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
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
  
  public final String o(String paramString1, String paramString2, String paramString3)
  {
    return b(paramString1, paramString2, paramString3, true);
  }
  
  public final e q(bi parambi)
  {
    e locale = bY(parambi.field_msgId);
    Object localObject = locale;
    if (locale.enp == 0L)
    {
      parambi = bX(parambi.field_msgSvrId);
      localObject = parambi;
      if (parambi.enp == 0L)
      {
        y.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        localObject = null;
      }
    }
    return localObject;
  }
  
  public final void r(bi parambi)
  {
    parambi = q(parambi);
    if ((parambi == null) || (parambi.enp == 0L)) {
      y.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
    }
    do
    {
      do
      {
        return;
        com.tencent.mm.vfs.e.deleteFile(o(parambi.enq, "", ""));
        com.tencent.mm.vfs.e.deleteFile(o(parambi.ens, "", ""));
        com.tencent.mm.vfs.e.deleteFile(o(parambi.ens, "", "") + "hd");
        this.dXo.delete("ImgInfo2", "id=?", new String[] { parambi.enp });
      } while (!parambi.Or());
      parambi = iH(parambi.enz);
    } while (parambi == null);
    com.tencent.mm.vfs.e.deleteFile(o(parambi.enq, "", ""));
    com.tencent.mm.vfs.e.deleteFile(o(parambi.ens, "", ""));
    com.tencent.mm.vfs.e.deleteFile(o(parambi.ens, "", "") + "hd");
    this.dXo.delete("ImgInfo2", "id=?", new String[] { parambi.enp });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.as.g
 * JD-Core Version:    0.7.0.1
 */