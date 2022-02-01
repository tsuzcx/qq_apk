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
import com.tencent.mm.b.q;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
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

public final class g
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT, sendImgType INT DEFAULT 0 )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
  public static int hgS = 0;
  public static int hhe = 150;
  public static long hhf = 0L;
  private ap gAC;
  public com.tencent.mm.storagebase.h gPa;
  com.tencent.mm.b.f<String, Bitmap> hgT;
  private com.tencent.mm.b.f<String, String> hgU;
  private List<b> hgV;
  private Map<Integer, WeakReference<ImageView>> hgW;
  private Map<Integer, WeakReference<ImageView>> hgX;
  private Map<Integer, WeakReference<View>> hgY;
  private Set<Integer> hgZ;
  private Map<String, String> hha;
  private final AtomicLong hhb;
  private FrameLayout.LayoutParams hhc;
  private SoftReference<ColorDrawable> hhd;
  
  public g(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150566);
    this.hgT = new com.tencent.mm.memory.a.b(40, new f.b() {}, getClass());
    this.hgU = new com.tencent.mm.memory.a.c(40);
    this.hgV = new ArrayList();
    this.hgW = new HashMap();
    this.hgX = new HashMap();
    this.hgY = new HashMap();
    this.hgZ = new HashSet();
    this.gAC = new ap(Looper.getMainLooper());
    this.hha = new HashMap();
    this.hhb = new AtomicLong(1L);
    this.gPa = null;
    this.hhc = new FrameLayout.LayoutParams(-2, -2);
    a(paramh);
    this.gPa = paramh;
    ayl();
    AppMethodBeat.o(150566);
  }
  
  public static String K(bl parambl)
  {
    AppMethodBeat.i(150635);
    if (parambl == null)
    {
      ad.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      AppMethodBeat.o(150635);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject1;
    if (parambl.field_isSend == 1)
    {
      localObject2 = o.ayF().ms(parambl.field_msgId);
      localObject1 = localObject2;
      if (((e)localObject2).deI != 0L) {}
    }
    else
    {
      localObject1 = o.ayF().mr(parambl.field_msgSvrId);
    }
    if (com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
      if (parambl.field_isSend == 1)
      {
        parambl = f.c((e)localObject1);
        localObject2 = o.ayF().p(parambl, "", "");
        if ((parambl != null) && (parambl.length() > 0) && (i.eK((String)localObject2)))
        {
          AppMethodBeat.o(150635);
          return localObject2;
        }
        parambl = ((e)localObject1).hgj;
        localObject1 = o.ayF().p(parambl, "", "");
        if ((parambl != null) && (parambl.length() > 0) && (i.eK((String)localObject1)))
        {
          AppMethodBeat.o(150635);
          return localObject1;
        }
      }
      else if (((e)localObject1).ayh())
      {
        parambl = ((e)localObject1).hgj;
        if (!((e)localObject1).ayi()) {
          break label291;
        }
        localObject1 = f.a((e)localObject1);
        if ((localObject1 == null) || (((e)localObject1).deI <= 0L) || (!((e)localObject1).ayh()) || (!i.eK(o.ayF().p(((e)localObject1).hgj, "", "")))) {
          break label291;
        }
        parambl = ((e)localObject1).hgj;
      }
    }
    label291:
    for (;;)
    {
      AppMethodBeat.o(150635);
      return parambl;
      ad.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      AppMethodBeat.o(150635);
      return null;
    }
  }
  
  private long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, n.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(150612);
    if (paramInt1 == 0)
    {
      paramString1 = a(paramString1, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString1 == null)
      {
        AppMethodBeat.o(150612);
        return -1L;
      }
      paramPString.value = paramString1.hgl;
      if (i.eK(paramString2))
      {
        paramPString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.c.class)).Tl(paramString1.hgj);
        i.lC(paramString2, p(paramPString, "", ""));
        paramString1.yd(paramPString);
      }
      if (paramBoolean) {}
      for (paramLong = f(paramString1);; paramLong = e(paramString1))
      {
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(150612);
        return paramLong;
      }
    }
    if (paramInt1 == 1)
    {
      paramString2 = a(paramString1, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString2 == null)
      {
        AppMethodBeat.o(150612);
        return -1L;
      }
      paramPString.value = paramString2.hgl;
      paramString2.mq(0L);
      paramString2.kX(0L);
      paramString2.nX((int)i.aMN(p(paramString2.hgj, "", "")));
      paramString1 = a(paramString1, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString1 == null)
      {
        AppMethodBeat.o(150612);
        return 0L;
      }
      paramString1.xZ(paramString2.hgj);
      paramString1.yb(paramString2.hgl);
      paramString1.ya(paramString2.hgk);
      paramString1.nX(0);
      long l = this.gPa.rb(Thread.currentThread().getId());
      paramString1.nY((int)e(paramString2));
      if (paramBoolean) {}
      for (paramLong = f(paramString1);; paramLong = e(paramString1))
      {
        ad.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(paramLong), Long.valueOf(paramString1.deI), Long.valueOf(paramString1.hgs), paramString1.hgj, paramString1.hgk, Integer.valueOf(paramString1.gTY) });
        if (l > 0L) {
          com.tencent.mm.kernel.g.afB().gda.mX(l);
        }
        if (paramLong != -1L) {
          doNotify();
        }
        AppMethodBeat.o(150612);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(150612);
    return 0L;
  }
  
  private Bitmap a(String paramString1, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString2, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(150618);
    ad.i("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), bt.eGN(), paramString2 });
    Object localObject2 = (Bitmap)this.hgT.aM(f.yf(paramString1));
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
      localObject1 = ag(paramString1, paramInt1);
      if (bt.isNullOrNil((String)localObject1)) {
        break label497;
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
            break label486;
          }
        }
        i = af.aFv((String)localObject5);
        j = BackwardSupportUtil.ExifHelper.co((String)localObject5);
        if (i <= 0) {
          break label355;
        }
      }
      label173:
      label333:
      label355:
      for (localObject2 = af.aH((String)localObject5, i, j + paramInt2 * 90);; localObject2 = com.tencent.mm.sdk.platformtools.f.aD((String)localObject5, 120, 120))
      {
        if (localObject2 != null)
        {
          this.hgT.o(f.yf(paramString1), localObject2);
          paramPInt1.value = ((Bitmap)localObject2).getWidth();
          paramPInt2.value = ((Bitmap)localObject2).getHeight();
          if (paramBoolean)
          {
            if (localObject1 != null) {
              break label480;
            }
            paramString1 = ag(paramString1, paramInt1);
            label230:
            paramPInt1 = paramString1;
            if (!bt.isNullOrNil(paramString1))
            {
              paramPInt1 = paramString1;
              if (paramString1.endsWith("hd")) {
                paramPInt1 = paramString1.substring(0, paramString1.length() - 2);
              }
            }
            if (paramb != null) {
              paramb.IR();
            }
            if ((bt.isNullOrNil(paramPInt1)) || (!i.eK(paramPInt1)) || (i.aMN(paramPInt1) <= 0L)) {
              break label369;
            }
            i.lC(paramPInt1, paramString2);
            ad.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s %s", new Object[] { paramPInt1, paramString2 });
          }
        }
        AppMethodBeat.o(150618);
        return localObject2;
        localObject2 = com.tencent.mm.sdk.platformtools.f.aFi((String)localObject1);
        localObject5 = paramString1;
        break;
      }
      label369:
      if ((!bt.isNullOrNil(paramPInt1)) && (i.eK(paramPInt1))) {
        ad.i("MicroMsg.ImgInfoStorage", "oldThumbFile Length %s", new Object[] { Long.valueOf(i.aMN(paramPInt1)) });
      }
    }
    for (;;)
    {
      label432:
      try
      {
        if ((bt.isNullOrNil(paramPInt1)) || (!paramPInt1.endsWith("hd"))) {
          break label469;
        }
        paramInt1 = 1;
      }
      catch (IOException paramString1) {}
      com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject2, paramInt1, Bitmap.CompressFormat.JPEG, paramString2, false);
      ad.i("MicroMsg.ImgInfoStorage", "saveBitmapToImage thumbPath %s", new Object[] { paramString2 });
      break label333;
      break label333;
      label469:
      paramInt1 = 0;
      label480:
      label486:
      label497:
      while (paramInt1 == 0)
      {
        paramInt1 = 90;
        break label432;
        paramString1 = (String)localObject1;
        break label230;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break label173;
        localObject5 = paramString1;
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
      str = b(paramString, false, true);
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
    label145:
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
        paramString = (Bitmap)this.hgT.aM(str);
        localObject1 = paramString;
        if (paramString == null)
        {
          if (paramString != null) {
            break label690;
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
        bt.eGO();
        if (k == 0) {
          break label695;
        }
        paramString = paramBitmap;
        if (paramBitmap == null) {
          paramString = u.BA(str);
        }
        if (paramString == null) {
          break label915;
        }
        l = System.currentTimeMillis();
        m = paramString.getWidth();
        n = paramString.getHeight();
        i = n;
        j = m;
        if (paramBoolean3)
        {
          if (hgS == 0) {
            hgS = com.tencent.mm.cd.a.ap(aj.getContext(), 2131166264);
          }
          if (m <= hgS)
          {
            i = n;
            j = m;
            if (n <= hgS) {}
          }
          else
          {
            if (m <= n) {
              break label706;
            }
            i = n * hgS / m;
            j = hgS;
          }
        }
        label258:
        n = i;
        m = j;
        if (paramBoolean4)
        {
          if (str.endsWith("hd")) {
            break label953;
          }
          j = (int)(paramString.getWidth() * paramFloat * 1.25F);
          i = (int)(paramString.getHeight() * paramFloat * 1.25F);
        }
      }
    }
    label690:
    label695:
    label953:
    for (;;)
    {
      float f;
      if ((j >= 160.0F * paramFloat) || (i >= 160.0F * paramFloat)) {
        if (i > j)
        {
          f = 160.0F * paramFloat / i;
          label352:
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
        paramBitmap = aj.getContext();
        localObject1 = new int[2];
        if (j >= m)
        {
          paramFloat = j / m;
          if (paramFloat <= 2.0F)
          {
            i = com.tencent.mm.cd.a.ap(paramBitmap, 2131165213);
            j = (int)(i / paramFloat);
            label507:
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
              paramString = com.tencent.mm.sdk.platformtools.f.k(paramBitmap, paramInt);
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
                  this.hgT.o(str, paramString);
                  localObject2 = paramString;
                }
              }
              AppMethodBeat.o(150591);
              return localObject2;
              k = 0;
              break;
              paramBoolean1 = false;
              break label87;
              paramBitmap = com.tencent.mm.sdk.platformtools.f.o(str, paramFloat);
              break label145;
              label706:
              if (m == n)
              {
                i = hgS;
                j = hgS;
                break label258;
              }
              j = m * hgS / n;
              i = hgS;
              break label258;
              f = 160.0F * paramFloat / j;
              break label352;
              j = com.tencent.mm.cd.a.ap(paramBitmap, 2131165215);
              i = (int)(j * paramFloat);
              break label507;
              paramFloat = m / j;
              if (paramFloat <= 2.0F)
              {
                j = com.tencent.mm.cd.a.ap(paramBitmap, 2131165213);
                i = (int)(j / paramFloat);
                break label507;
              }
              i = com.tencent.mm.cd.a.ap(paramBitmap, 2131165215);
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
              paramString = com.tencent.mm.sdk.platformtools.f.a(paramBitmap, true, com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 3));
              ad.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
              continue;
            }
            paramString = paramBitmap;
            continue;
            paramBitmap = paramString.toString();
            continue;
          }
          ad.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", new Object[] { str, Boolean.valueOf(i.eK(str)) });
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private e a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString2, long paramLong, String paramString3, String paramString4, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, n.a parama)
  {
    AppMethodBeat.i(150624);
    if (!i.eK(paramString1))
    {
      AppMethodBeat.o(150624);
      return null;
    }
    String str = f.yf(paramString1);
    paramb1 = a(paramString1, paramInt1, paramBoolean, paramInt3, paramPInt1, paramPInt2, paramString2, paramString3, paramb1);
    if ((parama != null) && (parama.hgm == paramInt1))
    {
      paramString4 = parama.ayw();
      paramPInt2 = paramString4.hiI;
      paramString2 = paramString4.hiJ;
      paramPInt1 = paramString4.hgv;
      paramString3 = paramString4.hiK;
      paramString4 = paramString4.hiL;
      ad.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString3.value, paramString4.value });
      paramString4 = new e();
      paramString4.dtM = -1;
      paramString4.setLocalId(aym());
      paramString4.mq(paramLong);
      if (!bt.isNullOrNil(paramPInt1)) {
        paramString4.yc(paramPInt1);
      }
      paramString4.ob(0);
      paramString4.setSource(paramInt2);
      if (paramInt2 != 4) {
        break label564;
      }
      if (paramString1.startsWith(ac.aqa()))
      {
        paramString4.nZ(3);
        label232:
        if (paramBoolean)
        {
          paramString4.xZ(paramPInt2.value + ".jpg");
          if (!bt.isNullOrNil(paramString3.value)) {
            paramString4.ya(paramString3.value + ".jpg");
          }
          if (bt.isNullOrNil(paramString4.hgl)) {
            paramString4.yb(paramb1);
          }
          paramString4.nX((int)i.aMN(paramString2.value));
          if (paramString4.gTY == 0) {
            ad.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString2.value });
          }
          paramString4.xY(str);
        }
        paramString4.setCreateTime((int)bt.aGK());
        paramString4.oc(paramInt1);
        ad.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramString4.gTY);
        AppMethodBeat.o(150624);
        return paramString4;
      }
    }
    else
    {
      if ((parama == null) || (parama.hgm == paramInt1)) {
        break label573;
      }
      paramPInt2 = null;
    }
    for (paramPInt1 = null;; paramPInt1 = paramString4)
    {
      paramString4 = new PString();
      paramString2 = new PString();
      paramString3 = new PString();
      paramb2 = new PString();
      paramPInt1 = a(paramString1, str, paramInt1, paramBoolean, paramString4, paramString2, paramString3, paramb2, paramPInt1, paramPInt2);
      ad.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString3.value, paramb2.value });
      paramPInt2 = paramString4;
      break;
      paramString4.nZ(2);
      break label232;
      label564:
      paramString4.nZ(1);
      break label232;
      label573:
      paramPInt2 = paramb2;
    }
  }
  
  private String a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(150622);
    ad.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString1 });
    if (!i.eK(paramString1))
    {
      ad.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      AppMethodBeat.o(150622);
      return null;
    }
    String str = paramString3;
    if (bt.isNullOrNil(paramString3)) {
      str = ayo();
    }
    str = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
    paramString3 = a(str, "th_", "", false);
    if (paramb == null) {
      paramString3 = p(str, "th_", "");
    }
    if (paramBoolean)
    {
      if ((!bt.isNullOrNil(paramString2)) && (i.eK(paramString2))) {
        break label255;
      }
      long l = bt.GC();
      a(paramString1, paramInt1, paramInt2, paramPInt1, paramPInt2, true, paramString3, paramb);
      if (!i.eK(paramString3)) {
        break label244;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(10921, new Object[] { Long.valueOf(i.aMN(paramString3)), Long.valueOf(i.aMN(paramString1)), Integer.valueOf(90), Long.valueOf(bt.aS(l)) });
    }
    for (;;)
    {
      ad.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
      AppMethodBeat.o(150622);
      return str;
      label244:
      ad.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
      continue;
      label255:
      i.lC(paramString2, paramString3);
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat)
  {
    AppMethodBeat.i(150586);
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.hgV.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (m == localb.hhl)
      {
        ad.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.hhl), localb.url });
        localb.url = paramString;
        if (!this.hgZ.contains(Integer.valueOf(k)))
        {
          this.hgZ.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(150586);
        return;
      }
    }
    this.hgW.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.hgX.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    for (;;)
    {
      int j;
      if (paramView != null)
      {
        j = paramView.hashCode();
        this.hgY.put(Integer.valueOf(j), new WeakReference(paramView));
      }
      for (;;)
      {
        paramImageView1 = new b(m, paramString, i, j);
        this.hgV.add(paramImageView1);
        if (!this.hgZ.contains(Integer.valueOf(k)))
        {
          this.hgZ.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(150586);
        return;
        j = 0;
      }
      i = 0;
    }
  }
  
  private static void a(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(150569);
    Cursor localCursor = paramh.a("PRAGMA table_info(ImgInfo2)", null, 2);
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
          break label364;
        }
        i = 1;
      }
    }
    label364:
    for (;;)
    {
      if ("sendImgType".endsWith("colName")) {
        j = 1;
      }
      break;
      localCursor.close();
      long l = com.tencent.mm.kernel.g.afB().gda.rb(Thread.currentThread().getId());
      if (k == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
      }
      if (m == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
      }
      if (i1 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
      }
      if (i3 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
      }
      if (i2 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
      }
      if (n == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
      }
      if (i == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add hevcPath TEXT");
      }
      if (j == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add sendImgType INT DEFAULT 0");
      }
      if (l > 0L) {
        com.tencent.mm.kernel.g.afB().gda.mX(l);
      }
      AppMethodBeat.o(150569);
      return;
    }
  }
  
  private e af(String paramString, int paramInt)
  {
    AppMethodBeat.i(150597);
    e locale = new e();
    paramString = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[] { String.valueOf(paramString), String.valueOf(paramInt) });
    if (paramString.moveToFirst()) {
      locale.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(150597);
    return locale;
  }
  
  private String ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(150617);
    paramString = af(f.yf(paramString), paramInt);
    if (!bt.isNullOrNil(paramString.hgl))
    {
      paramString = Q(paramString.hgl, true);
      if (i.eK(paramString))
      {
        AppMethodBeat.o(150617);
        return paramString;
      }
    }
    AppMethodBeat.o(150617);
    return null;
  }
  
  public static String ayo()
  {
    try
    {
      AppMethodBeat.i(150620);
      String str = yk("");
      AppMethodBeat.o(150620);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private Cursor b(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150608);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
    AppMethodBeat.o(150608);
    return paramString1;
  }
  
  private long f(e parame)
  {
    AppMethodBeat.i(150614);
    long l = this.gPa.eOh().insertOrThrow("ImgInfo2", "id", parame.convertTo());
    if (l != -1L) {
      parame.ayk();
    }
    ad.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { Long.valueOf(l), Long.valueOf(parame.deI), Long.valueOf(parame.hgs), Long.valueOf(parame.drA), Integer.valueOf(parame.hgu) });
    AppMethodBeat.o(150614);
    return l;
  }
  
  private void f(final String paramString, final float paramFloat)
  {
    AppMethodBeat.i(150587);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(150562);
        g.this.a(paramString, true, paramFloat, true, false, this.hhi, this.hhj);
        g.a(g.this).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(150561);
            g.a(g.this, g.2.this.hhh);
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
  
  public static String pY(String paramString)
  {
    AppMethodBeat.i(150573);
    paramString = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString));
    AppMethodBeat.o(150573);
    return paramString;
  }
  
  /* Error */
  private static String yk(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 979
    //   6: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: getstatic 83	com/tencent/mm/aw/g:hhf	J
    //   16: lstore 5
    //   18: lload_3
    //   19: lstore_1
    //   20: lload 5
    //   22: lload_3
    //   23: lcmp
    //   24: ifne +11 -> 35
    //   27: lconst_1
    //   28: invokestatic 982	java/lang/Thread:sleep	(J)V
    //   31: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   34: lstore_1
    //   35: lload_1
    //   36: putstatic 83	com/tencent/mm/aw/g:hhf	J
    //   39: new 274	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: lload_1
    //   51: invokevirtual 279	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokevirtual 986	java/lang/String:getBytes	()[B
    //   60: invokestatic 992	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
    //   63: astore_0
    //   64: ldc 180
    //   66: ldc_w 994
    //   69: iconst_2
    //   70: anewarray 102	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: lload_1
    //   80: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   83: aastore
    //   84: invokestatic 427	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: ldc_w 979
    //   90: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: ldc 2
    //   95: monitorexit
    //   96: aload_0
    //   97: areturn
    //   98: astore 7
    //   100: goto -69 -> 31
    //   103: astore_0
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramString	String
    //   19	61	1	l1	long
    //   12	11	3	l2	long
    //   16	5	5	l3	long
    //   98	1	7	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   27	31	98	java/lang/InterruptedException
    //   3	18	103	finally
    //   27	31	103	finally
    //   31	35	103	finally
    //   35	93	103	finally
  }
  
  public final e I(bl parambl)
  {
    AppMethodBeat.i(150595);
    e locale = ms(parambl.field_msgId);
    Object localObject = locale;
    if (locale.deI == 0L)
    {
      parambl = mr(parambl.field_msgSvrId);
      localObject = parambl;
      if (parambl.deI == 0L)
      {
        ad.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        AppMethodBeat.o(150595);
        return null;
      }
    }
    AppMethodBeat.o(150595);
    return localObject;
  }
  
  public final void J(bl parambl)
  {
    AppMethodBeat.i(150599);
    parambl = I(parambl);
    if ((parambl == null) || (parambl.deI == 0L))
    {
      ad.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      AppMethodBeat.o(150599);
      return;
    }
    i.deleteFile(p(parambl.hgj, "", ""));
    i.deleteFile(p(parambl.hgo, "", ""));
    i.deleteFile(p(parambl.hgl, "", ""));
    i.deleteFile(p(parambl.hgl, "", "") + "hd");
    this.gPa.delete("ImgInfo2", "id=?", new String[] { parambl.deI });
    if (parambl.ayi())
    {
      parambl = od(parambl.hgu);
      if (parambl == null)
      {
        AppMethodBeat.o(150599);
        return;
      }
      i.deleteFile(p(parambl.hgj, "", ""));
      i.deleteFile(p(parambl.hgo, "", ""));
      i.deleteFile(p(parambl.hgl, "", ""));
      i.deleteFile(p(parambl.hgl, "", "") + "hd");
      this.gPa.delete("ImgInfo2", "id=?", new String[] { parambl.deI });
    }
    AppMethodBeat.o(150599);
  }
  
  public final String Q(String paramString, boolean paramBoolean)
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
        paramString = od(Integer.valueOf(paramString).intValue()).hgl;
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
  
  public final int a(int paramInt, e parame)
  {
    AppMethodBeat.i(150627);
    paramInt = a(Long.valueOf(paramInt), parame);
    AppMethodBeat.o(150627);
    return paramInt;
  }
  
  public final int a(Long paramLong, e parame)
  {
    AppMethodBeat.i(150628);
    long l = System.currentTimeMillis();
    ContentValues localContentValues = parame.convertTo();
    if (localContentValues.size() == 0) {}
    for (int i = 1;; i = this.gPa.update("ImgInfo2", localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      ad.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString(), Integer.valueOf(i) });
      if (i != -1)
      {
        parame.ayk();
        doNotify();
      }
      AppMethodBeat.o(150628);
      return i;
    }
  }
  
  public final long a(String paramString1, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, long paramLong, com.tencent.mm.b.b paramb1, com.tencent.mm.b.b paramb2, n.a parama)
  {
    AppMethodBeat.i(150611);
    paramLong = a(paramString1, null, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, paramString2, paramString3, paramLong, paramb1, paramb2, parama, false);
    AppMethodBeat.o(150611);
    return paramLong;
  }
  
  public final long a(String paramString, int paramInt1, int paramInt2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150610);
    long l = a(paramString, paramInt1, paramInt2, 0, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null);
    AppMethodBeat.o(150610);
    return l;
  }
  
  public final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150609);
    long l = a(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null, true);
    AppMethodBeat.o(150609);
    return l;
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150626);
    String str1 = "SERVERID://".concat(String.valueOf(paramLong));
    String str2 = com.tencent.mm.b.g.getMessageDigest(str1.getBytes());
    String str3 = p(str2, "th_", "");
    Bitmap localBitmap;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 0))
    {
      localBitmap = com.tencent.mm.sdk.platformtools.f.cl(paramArrayOfByte);
      if (localBitmap == null) {
        ad.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(paramArrayOfByte));
      }
      if ((paramBoolean) || (localBitmap == null)) {}
    }
    try
    {
      localBitmap = com.tencent.mm.sdk.platformtools.f.av(localBitmap);
      paramPInt1.value = localBitmap.getWidth();
      paramPInt2.value = localBitmap.getHeight();
      com.tencent.mm.sdk.platformtools.f.a(localBitmap, 90, Bitmap.CompressFormat.JPEG, str3, true);
      paramArrayOfByte = new e();
      if (!bt.isNullOrNil(paramString1))
      {
        paramArrayOfByte.setOffset(paramInt);
        paramArrayOfByte.nX(paramInt);
        paramArrayOfByte.dtM = -1;
        paramArrayOfByte.setLocalId(aym());
        paramArrayOfByte.xZ(paramString1);
        paramArrayOfByte.yb("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2)));
        paramPString.value = paramArrayOfByte.hgl;
        if (paramBoolean)
        {
          paramArrayOfByte.kX(0L);
          paramArrayOfByte.oc(1);
          paramArrayOfByte.yc(paramString2);
          paramArrayOfByte.setCreateTime((int)bt.aGK());
          paramLong = e(paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          AppMethodBeat.o(150626);
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
        paramArrayOfByte.kX(paramLong);
        paramArrayOfByte.oc(0);
        continue;
        paramString1 = str1;
      }
    }
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(150625);
    paramLong = a(paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString, paramPString, paramPInt1, paramPInt2);
    AppMethodBeat.o(150625);
    return paramLong;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(150607);
    paramString1 = this.gPa.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    AppMethodBeat.o(150607);
    return paramString1;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150630);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from".concat(String.valueOf(paramLong));; str = "location_backgroup_key_tor".concat(String.valueOf(paramLong)))
    {
      Bitmap localBitmap2 = (Bitmap)this.hgT.aM(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.f.s(paramString, paramInt1, paramInt2, paramInt3);
        this.hgT.o(str, localBitmap1);
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
    Bitmap localBitmap = (Bitmap)this.hgT.aM(str);
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
      localBitmap = BackwardSupportUtil.b.n(str, paramFloat);
      if (localBitmap == null) {
        break label355;
      }
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (k < m) {
        break label275;
      }
      j = BackwardSupportUtil.b.g(paramContext, hhe);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label302;
      }
      ad.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 188L, 1L, false);
      paramString = null;
      label191:
      paramContext = paramString;
      if (paramInt != -1) {
        paramContext = com.tencent.mm.sdk.platformtools.f.k(paramString, paramInt);
      }
      if (localBitmap != paramContext)
      {
        ad.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      ad.d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(str)));
      this.hgT.o(str, paramContext);
    }
    label275:
    label302:
    label355:
    for (paramString = paramContext;; paramString = localBitmap)
    {
      for (;;)
      {
        AppMethodBeat.o(150594);
        return paramString;
        i = BackwardSupportUtil.b.g(paramContext, hhe);
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
          com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 188L, 1L, false);
        }
      }
      break label191;
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
  
  public final String a(String paramString1, int paramInt1, PString paramPString, PInt paramPInt1, PInt paramPInt2, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(150619);
    if (!i.eK(paramString1))
    {
      ad.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      AppMethodBeat.o(150619);
      return null;
    }
    String str1 = paramString2;
    if (bt.isNullOrNil(paramString2)) {
      str1 = ayo();
    }
    String str2 = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
    paramString2 = a(str2, "th_", "", false);
    paramPString.value = str2;
    long l = bt.GC();
    paramPInt2 = a(paramString1, paramInt1, paramInt2, paramPInt1, paramPInt2, false, null, null);
    paramPString = (String)this.hgU.get(paramString1);
    if (paramPString != null) {}
    for (paramPString = (Bitmap)this.hgT.get(paramPString);; paramPString = null)
    {
      if (paramPString != null)
      {
        paramPInt1 = paramPString;
        if (!paramPString.isRecycled()) {}
      }
      else
      {
        paramPInt1 = a(paramString1, true, com.tencent.mm.cd.a.getDensity(aj.getContext()), false, false, true, 2131231564, true, paramPInt2);
        this.hgU.put(paramString1, paramString2);
      }
      if (paramPInt1 != null) {
        this.hgT.o(paramString2, paramPInt1);
      }
      ad.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(bt.aS(l)) });
      AppMethodBeat.o(150619);
      return str1;
    }
  }
  
  public final String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString3, com.tencent.mm.b.b paramb)
  {
    AppMethodBeat.i(150623);
    Object localObject = paramString3;
    if (bt.isNullOrNil(paramString3))
    {
      localObject = yk(paramString1);
      ad.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", new Object[] { localObject, paramString1 });
    }
    paramString3 = a((String)localObject, "", ".jpg", false);
    if (paramb == null) {
      paramString3 = a((String)localObject, "", ".jpg", true);
    }
    ad.i("MicroMsg.ImgInfoStorage", "fullPath is %s", new Object[] { paramString3 });
    if (i.aMN(paramString3) > 0L)
    {
      ad.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
      com.tencent.mm.plugin.report.service.h.vKh.dB(944, 8);
    }
    paramPString1.value = ((String)localObject);
    paramPString2.value = paramString3;
    if ((paramBoolean) && (!bt.isNullOrNil(paramString2)) && (paramInt == 0))
    {
      paramString2 = af(paramString2, paramInt);
      if (!bt.isNullOrNil(paramString2.hgj))
      {
        localObject = p(paramString2.hgj, "", "");
        if (paramb != null) {
          paramb.IR();
        }
        i.lC((String)localObject, paramString3);
        if (i.aMN((String)localObject) > 0L)
        {
          if (!bt.isNullOrNil(paramString2.hgv))
          {
            paramString1 = paramString2.hgv;
            AppMethodBeat.o(150623);
            return paramString1;
          }
          AppMethodBeat.o(150623);
          return null;
        }
        ad.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString1, paramString3 });
      }
    }
    label1154:
    label1213:
    label1219:
    label2372:
    label3525:
    label3528:
    try
    {
      if (ay.isWifi(aj.getContext())) {
        i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        ad.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3545;
        }
        n = 70;
        j = 0;
        m = 0;
        k = 1080;
        i = j;
        try
        {
          if (!ay.isWifi(aj.getContext())) {
            break;
          }
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressResolutionForWifi");
          i = j;
          i1 = paramString2.indexOf("*");
          if (-1 == i1) {
            break label3537;
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
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.g.afz();
          paramString2 = new p(com.tencent.mm.kernel.a.getUin());
          if ((int)(paramString2.longValue() / 100L) % 100 + 1 > i) {
            break label3531;
          }
          bool1 = true;
          ad.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Long.valueOf(paramString2.longValue()), Long.valueOf(paramString2.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.eEQ()), Integer.valueOf(Build.VERSION.SDK_INT) });
        }
        catch (Exception paramString2)
        {
          int i7;
          int i4;
          for (;;)
          {
            ad.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { bt.m(paramString2) });
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
            break label1826;
          }
          k = ((BitmapFactory.Options)localObject).outWidth;
          if (((BitmapFactory.Options)localObject).outWidth >= ((BitmapFactory.Options)localObject).outHeight) {
            break label1836;
          }
          int i2 = ((BitmapFactory.Options)localObject).outWidth;
          if (i <= 0) {
            break label1866;
          }
          int i3 = i2 / i;
          if (((BitmapFactory.Options)localObject).outHeight <= i) {
            break label1846;
          }
          j = ((BitmapFactory.Options)localObject).outHeight * i / i2;
          if (((BitmapFactory.Options)localObject).outWidth <= i) {
            break label1856;
          }
          i = i * ((BitmapFactory.Options)localObject).outWidth / i2;
          k = i;
          i = j;
          if (i * k <= 10240000) {
            break label3518;
          }
          double d = Math.sqrt(i * k / 10240000.0D);
          j = (int)(i / d);
          k = (int)(k / d);
          ad.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(j), Integer.valueOf(k) });
          if (localObject == null) {
            break label1946;
          }
          paramString2 = ((BitmapFactory.Options)localObject).outMimeType;
          long l2 = i.aMN(paramString1);
          boolean bool2 = MMNativeJpeg.IsJpegFile(paramString1);
          if ((paramString2 == null) || ((!paramString2.endsWith("jpeg")) && (!paramString2.endsWith("jpg")) && (!paramString2.endsWith("bmp")) && (!paramString2.endsWith("png")) && (!paramString2.endsWith("gif")))) {
            break label1952;
          }
          i2 = 1;
          if ((paramInt != 0) || ((m == 0) && (l2 <= 204800L) && ((localObject == null) || (i3 <= 0))) || (l2 <= i7)) {
            break label1965;
          }
          if ((i4 >= 55) && (bool2)) {
            break label3511;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            break label1958;
          }
          long l1;
          long l3;
          for (i = 18;; i = 8)
          {
            l1 = bt.eGO();
            m = com.tencent.mm.sdk.platformtools.f.a(paramBoolean, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            if ((m == 1) || (!paramBoolean)) {
              break label3508;
            }
            i = 28;
            m = com.tencent.mm.sdk.platformtools.f.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            paramBoolean = false;
            l3 = i.aMN(paramString3);
            ad.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(100L * l3 / l2), Integer.valueOf(i1), paramString3 });
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
                i.lC(paramString1, paramString3);
                bool1 = false;
                j = 48;
                k = 1;
              }
            }
            l1 = bt.eGO() - l1;
            i = k;
            paramBoolean = bool1;
            if (k == 1) {
              break label2372;
            }
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 187L, 1L, false);
            ad.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString1 });
            AppMethodBeat.o(150623);
            return null;
            k = ((BitmapFactory.Options)localObject).outHeight;
            break;
            i2 = ((BitmapFactory.Options)localObject).outHeight;
            break label1273;
            j = ((BitmapFactory.Options)localObject).outHeight;
            break label1308;
            i = ((BitmapFactory.Options)localObject).outWidth;
            break label1331;
            i3 = k / j;
            if (((BitmapFactory.Options)localObject).outHeight > j)
            {
              i = ((BitmapFactory.Options)localObject).outHeight * j / k;
              if (((BitmapFactory.Options)localObject).outWidth <= j) {
                break label1936;
              }
            }
            for (j = j * ((BitmapFactory.Options)localObject).outWidth / k;; j = ((BitmapFactory.Options)localObject).outWidth)
            {
              k = j;
              break;
              i = ((BitmapFactory.Options)localObject).outHeight;
              break label1896;
            }
            paramString2 = "";
            break label1444;
            i2 = 0;
            break label1513;
          }
          ad.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6) });
          if (i2 == 0) {
            break label3206;
          }
          i.lC(paramString1, paramString3);
          com.tencent.mm.ao.f.awL();
          if (!com.tencent.mm.ao.b.nL(256)) {
            break label3379;
          }
          if (paramInt != 1) {
            break label3387;
          }
          i = 0;
          for (;;)
          {
            for (;;)
            {
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressMidPicLevel")).intValue();
                i = m;
              }
              catch (Exception paramString2)
              {
                continue;
              }
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressMidPicSize")).intValue();
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
                  break label3501;
                }
                i = 800;
                if (k <= i) {
                  break label3498;
                }
                k = i;
                if (j <= i) {
                  break label3495;
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
                  paramPString3.value = yk(paramString1);
                  paramPString4.value = a(paramPString3.value, "", ".jpg", false);
                  i = com.tencent.mm.sdk.platformtools.f.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, i1, paramPString4.value, paramb);
                  ad.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  l1 = 0L;
                  j = 38;
                  paramBoolean = false;
                  paramString2 = com.tencent.mm.sdk.platformtools.f.aFf(paramString3);
                  if (paramString2 == null) {
                    continue;
                  }
                  k = paramString2.outWidth;
                  if (paramString2 == null) {
                    continue;
                  }
                  m = paramString2.outHeight;
                  l3 = i.aMN(paramString3);
                  i2 = MMNativeJpeg.queryQuality(paramString3);
                  boolean bool3 = MMNativeJpeg.IsJpegFile(paramString3);
                  paramString2 = com.tencent.mm.plugin.report.service.h.vKh;
                  if (!bool2) {
                    continue;
                  }
                  i1 = 1;
                  paramString2.f(11713, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2) });
                  ad.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                  if ((paramInt == 0) && (l3 >= 40960L) && (bool3) && (!MMNativeJpeg.isProgressive(paramString3)))
                  {
                    paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("EnableCDNUploadImg");
                    if ((!bt.isNullOrNil(paramString2)) && (paramString2.equals("1")))
                    {
                      l1 = bt.eGO();
                      if (!paramBoolean) {
                        continue;
                      }
                      j = 19;
                      paramString2 = paramString3 + ".prog";
                      i.lC(paramString3, paramString2);
                      if ((!bt.isNullOrNil(paramString2)) && (!bt.isNullOrNil(paramString3)) && (i.eK(paramString2))) {
                        continue;
                      }
                      bool1 = false;
                      i.deleteFile(paramString2);
                      if (bool1) {
                        break label3492;
                      }
                      bool1 = MMNativeJpeg.convertToProgressive(paramString3, n);
                      j = 29;
                      long l4 = bt.eGO();
                      long l5 = i.aMN(paramString3);
                      paramString2 = com.tencent.mm.plugin.report.service.h.vKh;
                      if (!bool1) {
                        continue;
                      }
                      n = 1;
                      if (!bool2) {
                        continue;
                      }
                      i1 = 1;
                      paramString2.f(11713, new Object[] { Integer.valueOf(n), Long.valueOf(l4 - l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2), Long.valueOf(l5) });
                      ad.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                      if (!bool1)
                      {
                        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 186L, 1L, false);
                        ad.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString3 });
                      }
                    }
                  }
                  AppMethodBeat.o(150623);
                  return null;
                  if (com.tencent.mm.sdk.platformtools.f.a(false, paramString1, i5, i6, Bitmap.CompressFormat.JPEG, 100, paramString3, paramb) == 1) {
                    break;
                  }
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(111L, 187L, 1L, false);
                  ad.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString1 });
                  AppMethodBeat.o(150623);
                  return null;
                }
              }
              catch (Exception paramString2)
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
            if (MMJpegOptim.convertToProgressive(q.k(paramString2, false), q.k(paramString3, false), n) == 0)
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
        if (com.tencent.mm.sdk.a.b.eEQ()) {
          bool1 = true;
        }
        if (!com.tencent.mm.compatible.util.d.lg(16)) {
          break label3528;
        }
        bool1 = false;
        ad.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        if ((m > 0) || (k > 0)) {
          break label1154;
        }
        j = 0;
        i = 1080;
        m = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        k = m;
        if (m <= 0) {
          k = 100;
        }
        i7 = k * 1024;
        i1 = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((i1 > 0) && (i1 < 100)) {
          break label3525;
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
        ad.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[] { paramString1, paramString3, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i7), Integer.valueOf(i1) });
        if (!paramBoolean) {
          break label3198;
        }
        localObject = com.tencent.mm.sdk.platformtools.f.aFf(paramString1);
        if ((localObject != null) && (((BitmapFactory.Options)localObject).outWidth != 0) && (((BitmapFactory.Options)localObject).outHeight != 0)) {
          break label1219;
        }
        if (localObject != null) {
          break label1213;
        }
        paramBoolean = true;
        ad.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString1, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(150623);
        return null;
        if (ay.is2G(aj.getContext())) {
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressPicLevelFor2G"), 40);
        } else if (ay.is3G(aj.getContext())) {
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bt.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception paramString2)
    {
      label1866:
      label3531:
      label3537:
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
        label1896:
        if (ay.is2G(aj.getContext()))
        {
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          label1513:
          if (ay.is3G(aj.getContext()))
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressResolutionFor3G");
          }
          else
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue("CompressResolutionFor4G");
            continue;
            label1273:
            label3198:
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
          str1 = mr(Long.valueOf(str1).longValue()).hgj;
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = com.tencent.mm.plugin.image.d.apW();
            String str4 = com.tencent.mm.plugin.image.d.apX();
            String str2 = str1;
            if (bt.isNullOrNil(str1)) {
              str2 = paramString1;
            }
            paramString1 = l.b(str3, str4, paramString2, str2, paramString3, paramBoolean);
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
    if (bt.cw(paramArrayOfByte))
    {
      ad.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(150576);
      return null;
    }
    String str1 = ayo();
    String str2 = p(str1, "th_", "");
    ad.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[] { str2 });
    try
    {
      com.tencent.mm.sdk.platformtools.f.a(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length), 100, paramCompressFormat, str2, true);
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
    //   0: ldc_w 1446
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1429	com/tencent/mm/sdk/platformtools/bt:cw	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 180
    //   15: ldc_w 1431
    //   18: invokestatic 732	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1446
    //   24: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   32: lstore 10
    //   34: invokestatic 696	com/tencent/mm/aw/g:ayo	()Ljava/lang/String;
    //   37: astore 16
    //   39: aload_0
    //   40: aload 16
    //   42: ldc_w 706
    //   45: ldc 243
    //   47: invokevirtual 247	com/tencent/mm/aw/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 17
    //   52: new 274	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   59: aload 17
    //   61: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 1448
    //   67: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 15
    //   75: ldc 180
    //   77: ldc_w 1450
    //   80: aload 17
    //   82: invokestatic 701	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   85: invokevirtual 704	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: arraylength
    //   93: istore 9
    //   95: new 1271	android/graphics/BitmapFactory$Options
    //   98: dup
    //   99: invokespecial 1451	android/graphics/BitmapFactory$Options:<init>	()V
    //   102: astore 18
    //   104: aload 18
    //   106: iconst_1
    //   107: putfield 1455	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   110: aload_1
    //   111: iconst_0
    //   112: aload_1
    //   113: arraylength
    //   114: aload 18
    //   116: invokestatic 1458	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   119: pop
    //   120: aconst_null
    //   121: astore 13
    //   123: aload 15
    //   125: iconst_0
    //   126: invokestatic 1462	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   129: astore 12
    //   131: aload 12
    //   133: astore 13
    //   135: aload 12
    //   137: aload_1
    //   138: invokevirtual 1467	java/io/OutputStream:write	([B)V
    //   141: aload 12
    //   143: astore 13
    //   145: aload 12
    //   147: invokevirtual 1470	java/io/OutputStream:flush	()V
    //   150: aload 12
    //   152: astore 13
    //   154: aload_1
    //   155: iload_3
    //   156: iload 4
    //   158: invokestatic 1471	com/tencent/mm/sdk/platformtools/f:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   161: astore 19
    //   163: aload 12
    //   165: astore 13
    //   167: aload_1
    //   168: arraylength
    //   169: istore 8
    //   171: aload 19
    //   173: ifnull +320 -> 493
    //   176: bipush 100
    //   178: istore 7
    //   180: aload 12
    //   182: astore 13
    //   184: aload_1
    //   185: arraylength
    //   186: istore_3
    //   187: iload_3
    //   188: ldc_w 1472
    //   191: if_icmple +530 -> 721
    //   194: new 1474	java/io/ByteArrayOutputStream
    //   197: dup
    //   198: invokespecial 1475	java/io/ByteArrayOutputStream:<init>	()V
    //   201: astore 14
    //   203: aload 14
    //   205: astore 13
    //   207: aload 19
    //   209: aload_2
    //   210: bipush 100
    //   212: aload 14
    //   214: invokevirtual 1479	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   217: pop
    //   218: aload 14
    //   220: astore 13
    //   222: aload 14
    //   224: invokevirtual 1482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   227: arraylength
    //   228: istore 4
    //   230: bipush 100
    //   232: istore_3
    //   233: aload 14
    //   235: astore 13
    //   237: iload_3
    //   238: istore 7
    //   240: aload 14
    //   242: invokevirtual 1482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   245: arraylength
    //   246: ldc_w 1472
    //   249: if_icmple +64 -> 313
    //   252: iload_3
    //   253: bipush 15
    //   255: if_icmplt +58 -> 313
    //   258: aload 14
    //   260: astore 13
    //   262: iload_3
    //   263: istore 7
    //   265: aload 14
    //   267: invokevirtual 1485	java/io/ByteArrayOutputStream:reset	()V
    //   270: iload_3
    //   271: iconst_5
    //   272: isub
    //   273: istore_3
    //   274: aload 14
    //   276: astore 13
    //   278: iload_3
    //   279: istore 7
    //   281: aload 19
    //   283: aload_2
    //   284: iload_3
    //   285: aload 14
    //   287: invokevirtual 1479	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   290: pop
    //   291: aload 14
    //   293: astore 13
    //   295: iload_3
    //   296: istore 7
    //   298: aload 14
    //   300: invokevirtual 1482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   303: arraylength
    //   304: istore 8
    //   306: iload 8
    //   308: istore 4
    //   310: goto -77 -> 233
    //   313: aload 12
    //   315: astore 13
    //   317: aload 14
    //   319: invokevirtual 1486	java/io/ByteArrayOutputStream:close	()V
    //   322: aload 12
    //   324: astore 13
    //   326: aload 19
    //   328: iload_3
    //   329: aload_2
    //   330: aload 17
    //   332: iconst_1
    //   333: invokestatic 511	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   336: pop
    //   337: aload 12
    //   339: astore 13
    //   341: ldc 180
    //   343: ldc_w 1488
    //   346: iconst_3
    //   347: anewarray 102	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: aload 15
    //   354: aastore
    //   355: dup
    //   356: iconst_1
    //   357: aload 17
    //   359: aastore
    //   360: dup
    //   361: iconst_2
    //   362: iload_3
    //   363: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: aload 12
    //   372: astore 13
    //   374: getstatic 720	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   377: sipush 16498
    //   380: bipush 10
    //   382: anewarray 102	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload 5
    //   389: invokestatic 1491	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   392: ldc_w 1493
    //   395: invokestatic 1499	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   398: aastore
    //   399: dup
    //   400: iconst_1
    //   401: iload 6
    //   403: invokestatic 419	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   406: aastore
    //   407: dup
    //   408: iconst_2
    //   409: iload 9
    //   411: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: dup
    //   416: iconst_3
    //   417: aload 18
    //   419: getfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   422: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: aastore
    //   426: dup
    //   427: iconst_4
    //   428: aload 18
    //   430: getfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   433: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aastore
    //   437: dup
    //   438: iconst_5
    //   439: iload 4
    //   441: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   444: aastore
    //   445: dup
    //   446: bipush 6
    //   448: aload 19
    //   450: invokevirtual 479	android/graphics/Bitmap:getHeight	()I
    //   453: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   456: aastore
    //   457: dup
    //   458: bipush 7
    //   460: aload 19
    //   462: invokevirtual 474	android/graphics/Bitmap:getWidth	()I
    //   465: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: dup
    //   470: bipush 8
    //   472: iconst_0
    //   473: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: dup
    //   478: bipush 9
    //   480: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   483: lload 10
    //   485: lsub
    //   486: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   489: aastore
    //   490: invokevirtual 726	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   493: aload 15
    //   495: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   498: ifeq +17 -> 515
    //   501: ldc 180
    //   503: ldc_w 1501
    //   506: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload 15
    //   511: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   514: pop
    //   515: aload 12
    //   517: ifnull +8 -> 525
    //   520: aload 12
    //   522: invokevirtual 1502	java/io/OutputStream:close	()V
    //   525: ldc_w 698
    //   528: aload 16
    //   530: invokestatic 701	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   533: invokevirtual 704	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   536: astore_1
    //   537: ldc_w 1446
    //   540: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: aload_1
    //   544: areturn
    //   545: astore 13
    //   547: goto -225 -> 322
    //   550: astore 13
    //   552: aconst_null
    //   553: astore 14
    //   555: aload 14
    //   557: astore 13
    //   559: ldc 180
    //   561: ldc_w 1504
    //   564: invokestatic 732	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: iload 7
    //   569: istore_3
    //   570: iload 8
    //   572: istore 4
    //   574: aload 14
    //   576: ifnull -254 -> 322
    //   579: aload 12
    //   581: astore 13
    //   583: aload 14
    //   585: invokevirtual 1486	java/io/ByteArrayOutputStream:close	()V
    //   588: iload 7
    //   590: istore_3
    //   591: iload 8
    //   593: istore 4
    //   595: goto -273 -> 322
    //   598: astore 13
    //   600: iload 7
    //   602: istore_3
    //   603: iload 8
    //   605: istore 4
    //   607: goto -285 -> 322
    //   610: astore 5
    //   612: aconst_null
    //   613: astore 14
    //   615: aload 14
    //   617: ifnull +12 -> 629
    //   620: aload 12
    //   622: astore 13
    //   624: aload 14
    //   626: invokevirtual 1486	java/io/ByteArrayOutputStream:close	()V
    //   629: aload 12
    //   631: astore 13
    //   633: ldc_w 1446
    //   636: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   639: aload 12
    //   641: astore 13
    //   643: aload 5
    //   645: athrow
    //   646: astore 13
    //   648: aload 12
    //   650: astore 5
    //   652: aload 13
    //   654: astore 12
    //   656: ldc 180
    //   658: ldc_w 1441
    //   661: iconst_1
    //   662: anewarray 102	java/lang/Object
    //   665: dup
    //   666: iconst_0
    //   667: aload 12
    //   669: aastore
    //   670: invokestatic 590	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: aload_0
    //   674: aload_1
    //   675: iconst_1
    //   676: aload_2
    //   677: invokevirtual 1444	com/tencent/mm/aw/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   680: astore_1
    //   681: aload 15
    //   683: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   686: ifeq +17 -> 703
    //   689: ldc 180
    //   691: ldc_w 1501
    //   694: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 15
    //   699: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   702: pop
    //   703: aload 5
    //   705: ifnull +8 -> 713
    //   708: aload 5
    //   710: invokevirtual 1502	java/io/OutputStream:close	()V
    //   713: ldc_w 1446
    //   716: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   719: aload_1
    //   720: areturn
    //   721: aload 12
    //   723: astore 13
    //   725: aload 15
    //   727: aload 17
    //   729: invokestatic 1507	com/tencent/mm/vfs/i:lD	(Ljava/lang/String;Ljava/lang/String;)Z
    //   732: pop
    //   733: iload 7
    //   735: istore_3
    //   736: iload 8
    //   738: istore 4
    //   740: goto -403 -> 337
    //   743: astore 5
    //   745: aload 12
    //   747: astore 13
    //   749: ldc 180
    //   751: ldc_w 1441
    //   754: iconst_1
    //   755: anewarray 102	java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: aload 5
    //   762: aastore
    //   763: invokestatic 590	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: aload 12
    //   768: astore 13
    //   770: aload_0
    //   771: aload_1
    //   772: iconst_1
    //   773: aload_2
    //   774: invokevirtual 1444	com/tencent/mm/aw/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   777: astore_1
    //   778: aload 15
    //   780: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   783: ifeq +17 -> 800
    //   786: ldc 180
    //   788: ldc_w 1501
    //   791: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload 15
    //   796: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   799: pop
    //   800: aload 12
    //   802: ifnull +8 -> 810
    //   805: aload 12
    //   807: invokevirtual 1502	java/io/OutputStream:close	()V
    //   810: ldc_w 1446
    //   813: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   816: aload_1
    //   817: areturn
    //   818: astore_1
    //   819: aconst_null
    //   820: astore 13
    //   822: aload 15
    //   824: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   827: ifeq +17 -> 844
    //   830: ldc 180
    //   832: ldc_w 1501
    //   835: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   838: aload 15
    //   840: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   843: pop
    //   844: aload 13
    //   846: ifnull +8 -> 854
    //   849: aload 13
    //   851: invokevirtual 1502	java/io/OutputStream:close	()V
    //   854: ldc_w 1446
    //   857: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   860: aload_1
    //   861: athrow
    //   862: astore 13
    //   864: goto -235 -> 629
    //   867: astore_1
    //   868: goto -343 -> 525
    //   871: astore_2
    //   872: goto -159 -> 713
    //   875: astore_2
    //   876: goto -66 -> 810
    //   879: astore_2
    //   880: goto -26 -> 854
    //   883: astore_1
    //   884: goto -62 -> 822
    //   887: astore_1
    //   888: aload 5
    //   890: astore 13
    //   892: goto -70 -> 822
    //   895: astore 5
    //   897: aconst_null
    //   898: astore 12
    //   900: goto -155 -> 745
    //   903: astore 12
    //   905: aload 13
    //   907: astore 5
    //   909: goto -253 -> 656
    //   912: astore 5
    //   914: aload 13
    //   916: astore 14
    //   918: goto -303 -> 615
    //   921: astore 13
    //   923: goto -368 -> 555
    //   926: astore 13
    //   928: iload 4
    //   930: istore 8
    //   932: goto -377 -> 555
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	935	0	this	g
    //   0	935	1	paramArrayOfByte	byte[]
    //   0	935	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	935	3	paramInt1	int
    //   0	935	4	paramInt2	int
    //   0	935	5	paramString	String
    //   0	935	6	paramBoolean	boolean
    //   178	556	7	i	int
    //   169	762	8	j	int
    //   93	317	9	k	int
    //   32	452	10	l	long
    //   129	770	12	localObject1	Object
    //   903	1	12	localIOException1	IOException
    //   121	252	13	localObject2	Object
    //   545	1	13	localException1	Exception
    //   550	1	13	localException2	Exception
    //   557	25	13	localObject3	Object
    //   598	1	13	localException3	Exception
    //   622	20	13	localObject4	Object
    //   646	7	13	localIOException2	IOException
    //   723	127	13	localObject5	Object
    //   862	1	13	localException4	Exception
    //   890	25	13	str1	String
    //   921	1	13	localException5	Exception
    //   926	1	13	localException6	Exception
    //   201	716	14	localObject6	Object
    //   73	766	15	str2	String
    //   37	492	16	str3	String
    //   50	678	17	str4	String
    //   102	327	18	localOptions	BitmapFactory.Options
    //   161	300	19	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   317	322	545	java/lang/Exception
    //   194	203	550	java/lang/Exception
    //   583	588	598	java/lang/Exception
    //   194	203	610	finally
    //   135	141	646	java/io/IOException
    //   145	150	646	java/io/IOException
    //   154	163	646	java/io/IOException
    //   167	171	646	java/io/IOException
    //   184	187	646	java/io/IOException
    //   317	322	646	java/io/IOException
    //   326	337	646	java/io/IOException
    //   341	370	646	java/io/IOException
    //   374	493	646	java/io/IOException
    //   583	588	646	java/io/IOException
    //   624	629	646	java/io/IOException
    //   633	639	646	java/io/IOException
    //   643	646	646	java/io/IOException
    //   725	733	646	java/io/IOException
    //   135	141	743	java/lang/Exception
    //   145	150	743	java/lang/Exception
    //   154	163	743	java/lang/Exception
    //   167	171	743	java/lang/Exception
    //   184	187	743	java/lang/Exception
    //   326	337	743	java/lang/Exception
    //   341	370	743	java/lang/Exception
    //   374	493	743	java/lang/Exception
    //   633	639	743	java/lang/Exception
    //   643	646	743	java/lang/Exception
    //   725	733	743	java/lang/Exception
    //   123	131	818	finally
    //   624	629	862	java/lang/Exception
    //   520	525	867	java/lang/Exception
    //   708	713	871	java/lang/Exception
    //   805	810	875	java/lang/Exception
    //   849	854	879	java/lang/Exception
    //   135	141	883	finally
    //   145	150	883	finally
    //   154	163	883	finally
    //   167	171	883	finally
    //   184	187	883	finally
    //   317	322	883	finally
    //   326	337	883	finally
    //   341	370	883	finally
    //   374	493	883	finally
    //   583	588	883	finally
    //   624	629	883	finally
    //   633	639	883	finally
    //   643	646	883	finally
    //   725	733	883	finally
    //   749	766	883	finally
    //   770	778	883	finally
    //   656	681	887	finally
    //   123	131	895	java/lang/Exception
    //   123	131	903	java/io/IOException
    //   207	218	912	finally
    //   222	230	912	finally
    //   240	252	912	finally
    //   265	270	912	finally
    //   281	291	912	finally
    //   298	306	912	finally
    //   559	567	912	finally
    //   207	218	921	java/lang/Exception
    //   222	230	921	java/lang/Exception
    //   240	252	926	java/lang/Exception
    //   265	270	926	java/lang/Exception
    //   281	291	926	java/lang/Exception
    //   298	306	926	java/lang/Exception
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1509
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1429	com/tencent/mm/sdk/platformtools/bt:cw	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 180
    //   15: ldc_w 1431
    //   18: invokestatic 732	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1509
    //   24: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   32: lstore 10
    //   34: invokestatic 696	com/tencent/mm/aw/g:ayo	()Ljava/lang/String;
    //   37: astore 17
    //   39: aload_0
    //   40: aload 17
    //   42: ldc_w 706
    //   45: ldc 243
    //   47: invokevirtual 247	com/tencent/mm/aw/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: astore 19
    //   52: new 274	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   59: aload 19
    //   61: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 1448
    //   67: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 16
    //   75: ldc 180
    //   77: ldc_w 1450
    //   80: aload 19
    //   82: invokestatic 701	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   85: invokevirtual 704	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_1
    //   92: arraylength
    //   93: istore 9
    //   95: new 1271	android/graphics/BitmapFactory$Options
    //   98: dup
    //   99: invokespecial 1451	android/graphics/BitmapFactory$Options:<init>	()V
    //   102: astore 18
    //   104: aload 18
    //   106: iconst_1
    //   107: putfield 1455	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   110: aload_1
    //   111: iconst_0
    //   112: aload_1
    //   113: arraylength
    //   114: aload 18
    //   116: invokestatic 1458	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   119: pop
    //   120: aload 18
    //   122: getfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   125: istore 7
    //   127: aload 18
    //   129: getfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   132: istore 6
    //   134: sipush 720
    //   137: iload 7
    //   139: if_icmpgt +13 -> 152
    //   142: ldc_w 1510
    //   145: iload 6
    //   147: i2f
    //   148: fcmpl
    //   149: ifle +283 -> 432
    //   152: iload 7
    //   154: istore 5
    //   156: aconst_null
    //   157: astore 13
    //   159: aload 16
    //   161: iconst_0
    //   162: invokestatic 1462	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   165: astore 12
    //   167: aload 12
    //   169: astore 13
    //   171: aload 12
    //   173: aload_1
    //   174: invokevirtual 1467	java/io/OutputStream:write	([B)V
    //   177: aload 12
    //   179: astore 13
    //   181: aload 12
    //   183: invokevirtual 1470	java/io/OutputStream:flush	()V
    //   186: aload 12
    //   188: astore 13
    //   190: aload_1
    //   191: iload 5
    //   193: iload 6
    //   195: invokestatic 1471	com/tencent/mm/sdk/platformtools/f:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   198: astore 14
    //   200: aload 12
    //   202: astore 13
    //   204: iload 5
    //   206: aload 14
    //   208: invokevirtual 474	android/graphics/Bitmap:getWidth	()I
    //   211: if_icmpeq +240 -> 451
    //   214: aload 12
    //   216: astore 13
    //   218: aload 14
    //   220: iload 5
    //   222: iload 6
    //   224: iconst_1
    //   225: invokestatic 564	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   228: astore 14
    //   230: aload 12
    //   232: astore 13
    //   234: aload 14
    //   236: invokevirtual 479	android/graphics/Bitmap:getHeight	()I
    //   239: i2f
    //   240: aload 14
    //   242: invokevirtual 474	android/graphics/Bitmap:getWidth	()I
    //   245: i2f
    //   246: ldc_w 1511
    //   249: fmul
    //   250: fcmpl
    //   251: ifle +203 -> 454
    //   254: aload 12
    //   256: astore 13
    //   258: aload 14
    //   260: iconst_0
    //   261: iconst_0
    //   262: aload 14
    //   264: invokevirtual 474	android/graphics/Bitmap:getWidth	()I
    //   267: aload 14
    //   269: invokevirtual 474	android/graphics/Bitmap:getWidth	()I
    //   272: i2f
    //   273: ldc_w 1511
    //   276: fmul
    //   277: f2i
    //   278: invokestatic 1515	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   281: astore 15
    //   283: aload 12
    //   285: astore 13
    //   287: aload_1
    //   288: arraylength
    //   289: istore 6
    //   291: aload 15
    //   293: ifnull +404 -> 697
    //   296: bipush 70
    //   298: istore 5
    //   300: new 1474	java/io/ByteArrayOutputStream
    //   303: dup
    //   304: invokespecial 1475	java/io/ByteArrayOutputStream:<init>	()V
    //   307: astore 14
    //   309: aload 14
    //   311: astore 13
    //   313: aload 15
    //   315: aload_2
    //   316: bipush 70
    //   318: aload 14
    //   320: invokevirtual 1479	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   323: pop
    //   324: aload 14
    //   326: astore 13
    //   328: aload 14
    //   330: invokevirtual 1482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   333: arraylength
    //   334: istore 7
    //   336: bipush 70
    //   338: istore 5
    //   340: iload 7
    //   342: istore 6
    //   344: aload 14
    //   346: astore 13
    //   348: iload 5
    //   350: istore 7
    //   352: aload 14
    //   354: invokevirtual 1482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   357: arraylength
    //   358: ldc_w 1472
    //   361: if_icmple +125 -> 486
    //   364: iload 5
    //   366: bipush 15
    //   368: if_icmplt +118 -> 486
    //   371: aload 14
    //   373: astore 13
    //   375: iload 5
    //   377: istore 7
    //   379: aload 14
    //   381: invokevirtual 1485	java/io/ByteArrayOutputStream:reset	()V
    //   384: iload 5
    //   386: iconst_5
    //   387: isub
    //   388: istore 5
    //   390: aload 14
    //   392: astore 13
    //   394: iload 5
    //   396: istore 7
    //   398: aload 15
    //   400: aload_2
    //   401: iload 5
    //   403: aload 14
    //   405: invokevirtual 1479	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   408: pop
    //   409: aload 14
    //   411: astore 13
    //   413: iload 5
    //   415: istore 7
    //   417: aload 14
    //   419: invokevirtual 1482	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   422: arraylength
    //   423: istore 8
    //   425: iload 8
    //   427: istore 6
    //   429: goto -85 -> 344
    //   432: sipush 720
    //   435: istore 5
    //   437: iload 6
    //   439: sipush 720
    //   442: imul
    //   443: iload 7
    //   445: idiv
    //   446: istore 6
    //   448: goto -292 -> 156
    //   451: goto -221 -> 230
    //   454: aload 12
    //   456: astore 13
    //   458: aload 14
    //   460: iconst_0
    //   461: iconst_0
    //   462: aload 14
    //   464: invokevirtual 479	android/graphics/Bitmap:getHeight	()I
    //   467: i2f
    //   468: ldc_w 1511
    //   471: fdiv
    //   472: f2i
    //   473: aload 14
    //   475: invokevirtual 479	android/graphics/Bitmap:getHeight	()I
    //   478: invokestatic 1515	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   481: astore 15
    //   483: goto -200 -> 283
    //   486: aload 12
    //   488: astore 13
    //   490: aload 14
    //   492: invokevirtual 1486	java/io/ByteArrayOutputStream:close	()V
    //   495: iload 6
    //   497: istore 8
    //   499: iload 5
    //   501: istore 7
    //   503: aload 12
    //   505: astore 13
    //   507: aload 15
    //   509: iload 7
    //   511: aload_2
    //   512: aload 19
    //   514: iconst_1
    //   515: invokestatic 511	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   518: pop
    //   519: aload 12
    //   521: astore 13
    //   523: ldc 180
    //   525: ldc_w 1488
    //   528: iconst_3
    //   529: anewarray 102	java/lang/Object
    //   532: dup
    //   533: iconst_0
    //   534: aload 16
    //   536: aastore
    //   537: dup
    //   538: iconst_1
    //   539: aload 19
    //   541: aastore
    //   542: dup
    //   543: iconst_2
    //   544: iload 7
    //   546: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   549: aastore
    //   550: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   553: aload 12
    //   555: astore 13
    //   557: getstatic 720	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   560: astore 14
    //   562: aload 12
    //   564: astore 13
    //   566: aload_3
    //   567: invokestatic 1491	com/tencent/mm/sdk/platformtools/bt:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   570: ldc_w 1493
    //   573: invokestatic 1499	com/tencent/mm/compatible/util/p:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   576: astore_3
    //   577: iload 4
    //   579: ifeq +352 -> 931
    //   582: iconst_1
    //   583: istore 5
    //   585: aload 12
    //   587: astore 13
    //   589: aload 14
    //   591: sipush 16498
    //   594: bipush 10
    //   596: anewarray 102	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload_3
    //   602: aastore
    //   603: dup
    //   604: iconst_1
    //   605: iload 5
    //   607: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aastore
    //   611: dup
    //   612: iconst_2
    //   613: iload 9
    //   615: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: aastore
    //   619: dup
    //   620: iconst_3
    //   621: aload 18
    //   623: getfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   626: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   629: aastore
    //   630: dup
    //   631: iconst_4
    //   632: aload 18
    //   634: getfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   637: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: aastore
    //   641: dup
    //   642: iconst_5
    //   643: iload 8
    //   645: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   648: aastore
    //   649: dup
    //   650: bipush 6
    //   652: aload 15
    //   654: invokevirtual 479	android/graphics/Bitmap:getHeight	()I
    //   657: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: aastore
    //   661: dup
    //   662: bipush 7
    //   664: aload 15
    //   666: invokevirtual 474	android/graphics/Bitmap:getWidth	()I
    //   669: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   672: aastore
    //   673: dup
    //   674: bipush 8
    //   676: iconst_1
    //   677: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: dup
    //   682: bipush 9
    //   684: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   687: lload 10
    //   689: lsub
    //   690: invokestatic 384	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   693: aastore
    //   694: invokevirtual 726	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   697: aload 16
    //   699: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   702: ifeq +17 -> 719
    //   705: ldc 180
    //   707: ldc_w 1501
    //   710: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: aload 16
    //   715: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   718: pop
    //   719: aload 12
    //   721: ifnull +8 -> 729
    //   724: aload 12
    //   726: invokevirtual 1502	java/io/OutputStream:close	()V
    //   729: ldc_w 698
    //   732: aload 17
    //   734: invokestatic 701	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   737: invokevirtual 704	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   740: astore_1
    //   741: ldc_w 1509
    //   744: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   747: aload_1
    //   748: areturn
    //   749: astore 13
    //   751: iload 5
    //   753: istore 7
    //   755: iload 6
    //   757: istore 8
    //   759: goto -256 -> 503
    //   762: astore 13
    //   764: aconst_null
    //   765: astore 14
    //   767: aload 14
    //   769: astore 13
    //   771: ldc 180
    //   773: ldc_w 1504
    //   776: invokestatic 732	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: iload 5
    //   781: istore 7
    //   783: iload 6
    //   785: istore 8
    //   787: aload 14
    //   789: ifnull -286 -> 503
    //   792: aload 12
    //   794: astore 13
    //   796: aload 14
    //   798: invokevirtual 1486	java/io/ByteArrayOutputStream:close	()V
    //   801: iload 5
    //   803: istore 7
    //   805: iload 6
    //   807: istore 8
    //   809: goto -306 -> 503
    //   812: astore 13
    //   814: iload 5
    //   816: istore 7
    //   818: iload 6
    //   820: istore 8
    //   822: goto -319 -> 503
    //   825: astore_3
    //   826: aconst_null
    //   827: astore 14
    //   829: aload 14
    //   831: ifnull +12 -> 843
    //   834: aload 12
    //   836: astore 13
    //   838: aload 14
    //   840: invokevirtual 1486	java/io/ByteArrayOutputStream:close	()V
    //   843: aload 12
    //   845: astore 13
    //   847: ldc_w 1509
    //   850: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   853: aload 12
    //   855: astore 13
    //   857: aload_3
    //   858: athrow
    //   859: astore 13
    //   861: aload 12
    //   863: astore_3
    //   864: aload 13
    //   866: astore 12
    //   868: ldc 180
    //   870: ldc_w 1441
    //   873: iconst_1
    //   874: anewarray 102	java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: aload 12
    //   881: aastore
    //   882: invokestatic 590	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   885: aload_0
    //   886: aload_1
    //   887: iconst_1
    //   888: aload_2
    //   889: invokevirtual 1444	com/tencent/mm/aw/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   892: astore_1
    //   893: aload 16
    //   895: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   898: ifeq +17 -> 915
    //   901: ldc 180
    //   903: ldc_w 1501
    //   906: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   909: aload 16
    //   911: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   914: pop
    //   915: aload_3
    //   916: ifnull +7 -> 923
    //   919: aload_3
    //   920: invokevirtual 1502	java/io/OutputStream:close	()V
    //   923: ldc_w 1509
    //   926: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   929: aload_1
    //   930: areturn
    //   931: iconst_0
    //   932: istore 5
    //   934: goto -349 -> 585
    //   937: astore_3
    //   938: aconst_null
    //   939: astore 12
    //   941: aload 12
    //   943: astore 13
    //   945: ldc 180
    //   947: ldc_w 1441
    //   950: iconst_1
    //   951: anewarray 102	java/lang/Object
    //   954: dup
    //   955: iconst_0
    //   956: aload_3
    //   957: aastore
    //   958: invokestatic 590	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   961: aload 12
    //   963: astore 13
    //   965: aload_0
    //   966: aload_1
    //   967: iconst_1
    //   968: aload_2
    //   969: invokevirtual 1444	com/tencent/mm/aw/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   972: astore_1
    //   973: aload 16
    //   975: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   978: ifeq +17 -> 995
    //   981: ldc 180
    //   983: ldc_w 1501
    //   986: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   989: aload 16
    //   991: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   994: pop
    //   995: aload 12
    //   997: ifnull +8 -> 1005
    //   1000: aload 12
    //   1002: invokevirtual 1502	java/io/OutputStream:close	()V
    //   1005: ldc_w 1509
    //   1008: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1011: aload_1
    //   1012: areturn
    //   1013: astore_1
    //   1014: aconst_null
    //   1015: astore 13
    //   1017: aload 16
    //   1019: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   1022: ifeq +17 -> 1039
    //   1025: ldc 180
    //   1027: ldc_w 1501
    //   1030: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload 16
    //   1035: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   1038: pop
    //   1039: aload 13
    //   1041: ifnull +8 -> 1049
    //   1044: aload 13
    //   1046: invokevirtual 1502	java/io/OutputStream:close	()V
    //   1049: ldc_w 1509
    //   1052: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1055: aload_1
    //   1056: athrow
    //   1057: astore 13
    //   1059: goto -216 -> 843
    //   1062: astore_1
    //   1063: goto -334 -> 729
    //   1066: astore_2
    //   1067: goto -144 -> 923
    //   1070: astore_2
    //   1071: goto -66 -> 1005
    //   1074: astore_2
    //   1075: goto -26 -> 1049
    //   1078: astore_1
    //   1079: goto -62 -> 1017
    //   1082: astore_1
    //   1083: aload_3
    //   1084: astore 13
    //   1086: goto -69 -> 1017
    //   1089: astore_3
    //   1090: goto -149 -> 941
    //   1093: astore 12
    //   1095: aload 13
    //   1097: astore_3
    //   1098: goto -230 -> 868
    //   1101: astore_3
    //   1102: aload 13
    //   1104: astore 14
    //   1106: goto -277 -> 829
    //   1109: astore 13
    //   1111: goto -344 -> 767
    //   1114: astore 13
    //   1116: iload 7
    //   1118: istore 5
    //   1120: goto -353 -> 767
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1123	0	this	g
    //   0	1123	1	paramArrayOfByte	byte[]
    //   0	1123	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	1123	3	paramString	String
    //   0	1123	4	paramBoolean	boolean
    //   154	965	5	i	int
    //   132	687	6	j	int
    //   125	992	7	k	int
    //   423	398	8	m	int
    //   93	521	9	n	int
    //   32	656	10	l	long
    //   165	836	12	localObject1	Object
    //   1093	1	12	localIOException1	IOException
    //   157	431	13	localObject2	Object
    //   749	1	13	localException1	Exception
    //   762	1	13	localException2	Exception
    //   769	26	13	localObject3	Object
    //   812	1	13	localException3	Exception
    //   836	20	13	localObject4	Object
    //   859	6	13	localIOException2	IOException
    //   943	102	13	localObject5	Object
    //   1057	1	13	localException4	Exception
    //   1084	19	13	str1	String
    //   1109	1	13	localException5	Exception
    //   1114	1	13	localException6	Exception
    //   198	907	14	localObject6	Object
    //   281	384	15	localBitmap	Bitmap
    //   73	961	16	str2	String
    //   37	696	17	str3	String
    //   102	531	18	localOptions	BitmapFactory.Options
    //   50	490	19	str4	String
    // Exception table:
    //   from	to	target	type
    //   490	495	749	java/lang/Exception
    //   300	309	762	java/lang/Exception
    //   796	801	812	java/lang/Exception
    //   300	309	825	finally
    //   171	177	859	java/io/IOException
    //   181	186	859	java/io/IOException
    //   190	200	859	java/io/IOException
    //   204	214	859	java/io/IOException
    //   218	230	859	java/io/IOException
    //   234	254	859	java/io/IOException
    //   258	283	859	java/io/IOException
    //   287	291	859	java/io/IOException
    //   458	483	859	java/io/IOException
    //   490	495	859	java/io/IOException
    //   507	519	859	java/io/IOException
    //   523	553	859	java/io/IOException
    //   557	562	859	java/io/IOException
    //   566	577	859	java/io/IOException
    //   589	697	859	java/io/IOException
    //   796	801	859	java/io/IOException
    //   838	843	859	java/io/IOException
    //   847	853	859	java/io/IOException
    //   857	859	859	java/io/IOException
    //   159	167	937	java/lang/Exception
    //   159	167	1013	finally
    //   838	843	1057	java/lang/Exception
    //   724	729	1062	java/lang/Exception
    //   919	923	1066	java/lang/Exception
    //   1000	1005	1070	java/lang/Exception
    //   1044	1049	1074	java/lang/Exception
    //   171	177	1078	finally
    //   181	186	1078	finally
    //   190	200	1078	finally
    //   204	214	1078	finally
    //   218	230	1078	finally
    //   234	254	1078	finally
    //   258	283	1078	finally
    //   287	291	1078	finally
    //   458	483	1078	finally
    //   490	495	1078	finally
    //   507	519	1078	finally
    //   523	553	1078	finally
    //   557	562	1078	finally
    //   566	577	1078	finally
    //   589	697	1078	finally
    //   796	801	1078	finally
    //   838	843	1078	finally
    //   847	853	1078	finally
    //   857	859	1078	finally
    //   945	961	1078	finally
    //   965	973	1078	finally
    //   868	893	1082	finally
    //   171	177	1089	java/lang/Exception
    //   181	186	1089	java/lang/Exception
    //   190	200	1089	java/lang/Exception
    //   204	214	1089	java/lang/Exception
    //   218	230	1089	java/lang/Exception
    //   234	254	1089	java/lang/Exception
    //   258	283	1089	java/lang/Exception
    //   287	291	1089	java/lang/Exception
    //   458	483	1089	java/lang/Exception
    //   507	519	1089	java/lang/Exception
    //   523	553	1089	java/lang/Exception
    //   557	562	1089	java/lang/Exception
    //   566	577	1089	java/lang/Exception
    //   589	697	1089	java/lang/Exception
    //   847	853	1089	java/lang/Exception
    //   857	859	1089	java/lang/Exception
    //   159	167	1093	java/io/IOException
    //   313	324	1101	finally
    //   328	336	1101	finally
    //   352	364	1101	finally
    //   379	384	1101	finally
    //   398	409	1101	finally
    //   417	425	1101	finally
    //   771	779	1101	finally
    //   313	324	1109	java/lang/Exception
    //   328	336	1109	java/lang/Exception
    //   352	364	1114	java/lang/Exception
    //   379	384	1114	java/lang/Exception
    //   398	409	1114	java/lang/Exception
    //   417	425	1114	java/lang/Exception
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
    //   0: ldc_w 1520
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 1429	com/tencent/mm/sdk/platformtools/bt:cw	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 180
    //   15: ldc_w 1431
    //   18: invokestatic 732	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1520
    //   24: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 696	com/tencent/mm/aw/g:ayo	()Ljava/lang/String;
    //   32: astore 9
    //   34: aload_0
    //   35: aload 9
    //   37: ldc_w 706
    //   40: ldc 243
    //   42: invokevirtual 247	com/tencent/mm/aw/g:p	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   45: astore 10
    //   47: new 274	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   54: aload 10
    //   56: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 1448
    //   62: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 8
    //   70: ldc 180
    //   72: ldc_w 1450
    //   75: aload 10
    //   77: invokestatic 701	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   80: invokevirtual 704	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   83: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 8
    //   88: iconst_0
    //   89: invokestatic 1462	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   92: astore 7
    //   94: aload 7
    //   96: aload_1
    //   97: invokevirtual 1467	java/io/OutputStream:write	([B)V
    //   100: aload 7
    //   102: invokevirtual 1470	java/io/OutputStream:flush	()V
    //   105: iload_2
    //   106: ifeq +112 -> 218
    //   109: sipush 128
    //   112: istore 5
    //   114: goto +294 -> 408
    //   117: iload 4
    //   119: ifeq +113 -> 232
    //   122: aload 8
    //   124: aconst_null
    //   125: invokestatic 1524	com/tencent/mm/sdk/platformtools/f:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   128: astore_1
    //   129: aload_1
    //   130: ifnull +36 -> 166
    //   133: aload_1
    //   134: bipush 90
    //   136: aload_3
    //   137: aload 10
    //   139: iconst_1
    //   140: invokestatic 511	com/tencent/mm/sdk/platformtools/f:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   143: pop
    //   144: ldc 180
    //   146: ldc_w 1526
    //   149: iconst_2
    //   150: anewarray 102	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload 8
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload 10
    //   162: aastore
    //   163: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload 8
    //   168: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   171: ifeq +17 -> 188
    //   174: ldc 180
    //   176: ldc_w 1501
    //   179: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 8
    //   184: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   187: pop
    //   188: aload 7
    //   190: ifnull +8 -> 198
    //   193: aload 7
    //   195: invokevirtual 1502	java/io/OutputStream:close	()V
    //   198: ldc_w 698
    //   201: aload 9
    //   203: invokestatic 701	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokevirtual 704	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore_1
    //   210: ldc_w 1520
    //   213: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload_1
    //   217: areturn
    //   218: bipush 120
    //   220: istore 5
    //   222: goto +186 -> 408
    //   225: bipush 120
    //   227: istore 6
    //   229: goto -112 -> 117
    //   232: aload 8
    //   234: iload 5
    //   236: iload 6
    //   238: iconst_0
    //   239: invokestatic 1529	com/tencent/mm/sdk/platformtools/f:e	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   242: astore_1
    //   243: goto -114 -> 129
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_1
    //   249: getstatic 720	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   252: ldc2_w 1138
    //   255: ldc2_w 1530
    //   258: lconst_1
    //   259: iconst_0
    //   260: invokevirtual 1145	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   263: ldc 180
    //   265: new 274	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 1533
    //   272: invokespecial 676	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload 9
    //   277: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 1535
    //   283: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_3
    //   287: invokevirtual 1152	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 732	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload 8
    //   301: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   304: ifeq +17 -> 321
    //   307: ldc 180
    //   309: ldc_w 1501
    //   312: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload 8
    //   317: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   320: pop
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 1502	java/io/OutputStream:close	()V
    //   329: ldc_w 1520
    //   332: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aconst_null
    //   336: areturn
    //   337: astore_3
    //   338: aconst_null
    //   339: astore_1
    //   340: aload 8
    //   342: invokestatic 257	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   345: ifeq +17 -> 362
    //   348: ldc 180
    //   350: ldc_w 1501
    //   353: invokestatic 681	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 8
    //   358: invokestatic 1005	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   361: pop
    //   362: aload_1
    //   363: ifnull +7 -> 370
    //   366: aload_1
    //   367: invokevirtual 1502	java/io/OutputStream:close	()V
    //   370: ldc_w 1520
    //   373: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   376: aload_3
    //   377: athrow
    //   378: astore_1
    //   379: goto -181 -> 198
    //   382: astore_1
    //   383: goto -54 -> 329
    //   386: astore_1
    //   387: goto -17 -> 370
    //   390: astore_3
    //   391: aload 7
    //   393: astore_1
    //   394: goto -54 -> 340
    //   397: astore_3
    //   398: goto -58 -> 340
    //   401: astore_3
    //   402: aload 7
    //   404: astore_1
    //   405: goto -156 -> 249
    //   408: iload_2
    //   409: ifeq -184 -> 225
    //   412: sipush 128
    //   415: istore 6
    //   417: goto -300 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	g
    //   0	420	1	paramArrayOfByte	byte[]
    //   0	420	2	paramBoolean1	boolean
    //   0	420	3	paramCompressFormat	Bitmap.CompressFormat
    //   0	420	4	paramBoolean2	boolean
    //   112	123	5	i	int
    //   227	189	6	j	int
    //   92	311	7	localOutputStream	java.io.OutputStream
    //   68	289	8	str1	String
    //   32	244	9	str2	String
    //   45	116	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   86	94	246	java/lang/Exception
    //   86	94	337	finally
    //   193	198	378	java/lang/Exception
    //   325	329	382	java/lang/Exception
    //   366	370	386	java/lang/Exception
    //   94	105	390	finally
    //   122	129	390	finally
    //   133	166	390	finally
    //   232	243	390	finally
    //   249	299	397	finally
    //   94	105	401	java/lang/Exception
    //   122	129	401	java/lang/Exception
    //   133	166	401	java/lang/Exception
    //   232	243	401	java/lang/Exception
  }
  
  public final HashMap<Long, e> a(Long... paramVarArgs)
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
      localObject2 = new e();
      ((e)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).drA), localObject2);
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
    label586:
    label598:
    label613:
    label1126:
    for (;;)
    {
      synchronized (this.hha)
      {
        boolean bool = this.hha.containsKey(paramString);
        String str = b(paramString, paramBoolean, false);
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
            if (i.eK(str + "hd"))
            {
              this.hha.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1126;
        }
        paramString = (Bitmap)this.hgT.aM(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1123;
          }
          paramString = (Bitmap)this.hgT.aM(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label653;
          }
          ad.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label586;
          }
          localObject = this.hhc;
          if (paramInt4 != 0) {
            break label598;
          }
          ((FrameLayout.LayoutParams)localObject).gravity = 5;
          paramImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (paramString.getWidth() < paramString.getHeight() * 2.5D) {
            break label613;
          }
          paramInt1 = 1;
          if (paramString.getHeight() < paramString.getWidth() * 2.5D) {
            break label619;
          }
          paramInt2 = 1;
          if ((paramInt1 != 0) || (paramInt2 != 0)) {
            paramImageView1.setScaleType(ImageView.ScaleType.CENTER);
          }
          if (paramImageView2 != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label625;
            }
            paramImageView1.gravity = 5;
            paramImageView2.setLayoutParams(paramImageView1);
          }
          if (paramView != null)
          {
            paramImageView1 = new FrameLayout.LayoutParams(paramString.getWidth(), paramString.getHeight());
            if (paramInt4 != 0) {
              break label639;
            }
            paramImageView1.gravity = 5;
            paramView.setLayoutParams(paramImageView1);
          }
          AppMethodBeat.o(150585);
          return true;
        }
      }
      if (this.hgT.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
        ad.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(String.valueOf(localObject)));
      }
      int i = 0;
      continue;
      Object localObject = (FrameLayout.LayoutParams)paramImageView1.getLayoutParams();
      continue;
      label742:
      if (paramInt4 == 1)
      {
        ((FrameLayout.LayoutParams)localObject).gravity = 3;
        continue;
        paramInt1 = 0;
        continue;
        label619:
        paramInt2 = 0;
        continue;
        label625:
        if (paramInt4 == 1)
        {
          paramImageView1.gravity = 3;
          continue;
          label639:
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
                    break label919;
                  }
                  paramInt3 = (int)(paramInt1 * paramFloat);
                  if (paramInt2 <= 0) {
                    break label926;
                  }
                  paramInt1 = paramInt2;
                  paramInt1 = (int)(paramInt1 * paramFloat);
                  paramInt2 = paramInt3;
                  if (paramInt2 >= 60.0F * paramFloat) {
                    break label1120;
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
                  break label1117;
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
                break label724;
                paramInt1 = 75;
                break label742;
                if (paramInt1 > 0)
                {
                  paramInt3 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label983;
                  }
                }
                for (;;)
                {
                  paramInt1 = (int)(paramInt2 * paramFloat * 1.25F);
                  paramInt2 = paramInt3;
                  break;
                  paramInt1 = 120;
                  break label938;
                  paramInt2 = 75;
                }
                if (paramInt4 != 1) {
                  break label865;
                }
                paramString.gravity = 3;
                break label865;
                if ((this.hhd == null) || (this.hhd.get() == null)) {
                  this.hhd = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.hhd.get());
                if (paramInt1 > 0)
                {
                  paramInt1 = (int)(paramInt1 * paramFloat * 1.25F);
                  if (paramInt2 <= 0) {
                    break label1110;
                  }
                }
                for (;;)
                {
                  paramString = new FrameLayout.LayoutParams(paramInt1, (int)(paramInt2 * paramFloat * 1.25F));
                  break;
                  paramInt1 = 120;
                  break label1061;
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
  
  public final boolean a(bl parambl, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150631);
    String str = K(parambl);
    if (!bt.isNullOrNil(str))
    {
      boolean bool = a(str, parambl.field_imgPath, paramInt1, paramInt2, 0, 0);
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
    //   0: ldc_w 1619
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 180
    //   8: ldc_w 1621
    //   11: iconst_5
    //   12: anewarray 102	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_2
    //   22: aastore
    //   23: dup
    //   24: iconst_2
    //   25: iload_3
    //   26: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: iload 4
    //   34: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_4
    //   40: invokestatic 425	com/tencent/mm/sdk/platformtools/bt:eGN	()Lcom/tencent/mm/sdk/platformtools/at;
    //   43: aastore
    //   44: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   50: lstore 10
    //   52: invokestatic 545	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   55: invokestatic 1167	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
    //   58: fstore 7
    //   60: aload_1
    //   61: invokestatic 448	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   64: ifne +10 -> 74
    //   67: aload_2
    //   68: invokestatic 448	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   71: ifeq +11 -> 82
    //   74: ldc_w 1619
    //   77: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: aload_2
    //   84: iconst_0
    //   85: iconst_1
    //   86: invokevirtual 526	com/tencent/mm/aw/g:b	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   89: astore 13
    //   91: aload 13
    //   93: invokestatic 448	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   96: ifeq +11 -> 107
    //   99: ldc_w 1619
    //   102: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 13
    //   109: ldc_w 450
    //   112: invokevirtual 453	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   115: ifne +98 -> 213
    //   118: new 274	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   125: aload 13
    //   127: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 450
    //   133: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 15
    //   141: aload 13
    //   143: astore 14
    //   145: aload 15
    //   147: astore 13
    //   149: aload 14
    //   151: invokestatic 1269	com/tencent/mm/sdk/platformtools/f:aFf	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   154: astore 16
    //   156: aload 16
    //   158: ifnull +23 -> 181
    //   161: aload 16
    //   163: getfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   166: ifle +15 -> 181
    //   169: aload 16
    //   171: astore 15
    //   173: aload 16
    //   175: getfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   178: ifgt +118 -> 296
    //   181: getstatic 720	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   184: ldc2_w 1138
    //   187: ldc2_w 1622
    //   190: lconst_1
    //   191: iconst_0
    //   192: invokevirtual 1145	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   195: aload 14
    //   197: invokestatic 340	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   200: lconst_0
    //   201: lcmp
    //   202: ifle +29 -> 231
    //   205: ldc_w 1619
    //   208: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: aload 13
    //   215: iconst_0
    //   216: aload 13
    //   218: invokevirtual 251	java/lang/String:length	()I
    //   221: iconst_2
    //   222: isub
    //   223: invokevirtual 483	java/lang/String:substring	(II)Ljava/lang/String;
    //   226: astore 14
    //   228: goto -79 -> 149
    //   231: new 1271	android/graphics/BitmapFactory$Options
    //   234: dup
    //   235: invokespecial 1451	android/graphics/BitmapFactory$Options:<init>	()V
    //   238: astore 15
    //   240: invokestatic 1626	com/tencent/mm/sdk/platformtools/f:eFa	()V
    //   243: ldc 180
    //   245: ldc_w 1628
    //   248: iconst_3
    //   249: anewarray 102	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 15
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload 15
    //   261: getfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   264: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: dup
    //   269: iconst_2
    //   270: aload 15
    //   272: getfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   275: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: invokestatic 427	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: getstatic 720	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   285: ldc2_w 1138
    //   288: ldc2_w 1629
    //   291: lconst_1
    //   292: iconst_0
    //   293: invokevirtual 1145	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   296: aload 15
    //   298: getfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   301: ifne +10 -> 311
    //   304: aload 15
    //   306: iload 5
    //   308: putfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   311: aload 15
    //   313: getfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   316: ifne +10 -> 326
    //   319: aload 15
    //   321: iload 6
    //   323: putfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   326: aload 15
    //   328: getfield 1274	android/graphics/BitmapFactory$Options:outWidth	I
    //   331: i2f
    //   332: fload 7
    //   334: fmul
    //   335: ldc_w 553
    //   338: fmul
    //   339: f2i
    //   340: istore 9
    //   342: aload 15
    //   344: getfield 1277	android/graphics/BitmapFactory$Options:outHeight	I
    //   347: i2f
    //   348: fload 7
    //   350: fmul
    //   351: ldc_w 553
    //   354: fmul
    //   355: f2i
    //   356: istore 8
    //   358: iload 9
    //   360: i2f
    //   361: ldc_w 554
    //   364: fload 7
    //   366: fmul
    //   367: fcmpl
    //   368: ifge +24 -> 392
    //   371: iload 8
    //   373: istore 6
    //   375: iload 9
    //   377: istore 5
    //   379: iload 8
    //   381: i2f
    //   382: ldc_w 554
    //   385: fload 7
    //   387: fmul
    //   388: fcmpl
    //   389: iflt +40 -> 429
    //   392: iload 8
    //   394: iload 9
    //   396: if_icmple +215 -> 611
    //   399: ldc_w 554
    //   402: fload 7
    //   404: fmul
    //   405: iload 8
    //   407: i2f
    //   408: fdiv
    //   409: fstore 7
    //   411: iload 9
    //   413: i2f
    //   414: fload 7
    //   416: fmul
    //   417: f2i
    //   418: istore 5
    //   420: fload 7
    //   422: iload 8
    //   424: i2f
    //   425: fmul
    //   426: f2i
    //   427: istore 6
    //   429: iload 4
    //   431: ifne +195 -> 626
    //   434: aload_1
    //   435: iload 6
    //   437: iload 5
    //   439: getstatic 508	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   442: aload 13
    //   444: new 345	com/tencent/mm/pointers/PInt
    //   447: dup
    //   448: invokespecial 346	com/tencent/mm/pointers/PInt:<init>	()V
    //   451: new 345	com/tencent/mm/pointers/PInt
    //   454: dup
    //   455: invokespecial 346	com/tencent/mm/pointers/PInt:<init>	()V
    //   458: invokestatic 1633	com/tencent/mm/sdk/platformtools/f:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   461: istore 12
    //   463: ldc 180
    //   465: ldc_w 1635
    //   468: iconst_4
    //   469: anewarray 102	java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: new 274	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 275	java/lang/StringBuilder:<init>	()V
    //   481: invokestatic 194	java/lang/System:currentTimeMillis	()J
    //   484: lload 10
    //   486: lsub
    //   487: invokevirtual 279	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   490: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: iload 6
    //   498: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aastore
    //   502: dup
    //   503: iconst_2
    //   504: iload 5
    //   506: invokestatic 395	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: dup
    //   511: iconst_3
    //   512: iload 12
    //   514: invokestatic 419	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   517: aastore
    //   518: invokestatic 287	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: aload_0
    //   522: aload 14
    //   524: iconst_1
    //   525: invokestatic 545	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   528: invokestatic 1167	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
    //   531: iconst_1
    //   532: iconst_0
    //   533: iconst_1
    //   534: iload_3
    //   535: iconst_0
    //   536: invokespecial 1160	com/tencent/mm/aw/g:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   539: pop
    //   540: iload 12
    //   542: ifeq +169 -> 711
    //   545: aload_0
    //   546: getfield 151	com/tencent/mm/aw/g:hha	Ljava/util/Map;
    //   549: astore_1
    //   550: aload_1
    //   551: monitorenter
    //   552: aload_0
    //   553: getfield 151	com/tencent/mm/aw/g:hha	Ljava/util/Map;
    //   556: aload_2
    //   557: invokeinterface 1564 2 0
    //   562: ifeq +38 -> 600
    //   565: aload_0
    //   566: getfield 151	com/tencent/mm/aw/g:hha	Ljava/util/Map;
    //   569: aload_2
    //   570: invokeinterface 801 2 0
    //   575: checkcast 57	java/lang/String
    //   578: ldc_w 450
    //   581: invokevirtual 453	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   584: ifne +16 -> 600
    //   587: aload_0
    //   588: getfield 151	com/tencent/mm/aw/g:hha	Ljava/util/Map;
    //   591: aload_2
    //   592: aload 13
    //   594: invokeinterface 784 3 0
    //   599: pop
    //   600: aload_1
    //   601: monitorexit
    //   602: ldc_w 1619
    //   605: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iload 12
    //   610: ireturn
    //   611: ldc_w 554
    //   614: fload 7
    //   616: fmul
    //   617: iload 9
    //   619: i2f
    //   620: fdiv
    //   621: fstore 7
    //   623: goto -212 -> 411
    //   626: aload_1
    //   627: iload 6
    //   629: iload 5
    //   631: getstatic 508	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   634: aload 13
    //   636: new 345	com/tencent/mm/pointers/PInt
    //   639: dup
    //   640: invokespecial 346	com/tencent/mm/pointers/PInt:<init>	()V
    //   643: new 345	com/tencent/mm/pointers/PInt
    //   646: dup
    //   647: invokespecial 346	com/tencent/mm/pointers/PInt:<init>	()V
    //   650: invokestatic 1637	com/tencent/mm/sdk/platformtools/f:b	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   653: istore 12
    //   655: goto -192 -> 463
    //   658: astore_1
    //   659: getstatic 720	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   662: ldc2_w 1138
    //   665: ldc2_w 1638
    //   668: lconst_1
    //   669: iconst_0
    //   670: invokevirtual 1145	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   673: ldc 180
    //   675: ldc_w 1641
    //   678: iconst_1
    //   679: anewarray 102	java/lang/Object
    //   682: dup
    //   683: iconst_0
    //   684: aload_1
    //   685: invokevirtual 1642	java/lang/Exception:toString	()Ljava/lang/String;
    //   688: aastore
    //   689: invokestatic 590	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   692: ldc_w 1619
    //   695: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   698: iconst_0
    //   699: ireturn
    //   700: astore_2
    //   701: aload_1
    //   702: monitorexit
    //   703: ldc_w 1619
    //   706: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   709: aload_2
    //   710: athrow
    //   711: getstatic 720	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   714: ldc2_w 1138
    //   717: ldc2_w 1638
    //   720: lconst_1
    //   721: iconst_0
    //   722: invokevirtual 1145	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   725: goto -123 -> 602
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	728	0	this	g
    //   0	728	2	paramString2	String
    //   0	728	3	paramInt1	int
    //   0	728	4	paramInt2	int
    //   0	728	5	paramInt3	int
    //   0	728	6	paramInt4	int
    //   58	564	7	f	float
    //   356	67	8	i	int
    //   340	278	9	j	int
    //   50	435	10	l	long
    //   461	193	12	bool	boolean
    //   89	546	13	localObject1	Object
    //   143	380	14	localObject2	Object
    //   139	204	15	localObject3	Object
    //   154	20	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   434	463	658	java/lang/Exception
    //   626	655	658	java/lang/Exception
    //   552	600	700	finally
    //   600	602	700	finally
    //   701	703	700	finally
  }
  
  public final String ab(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150580);
    if (bt.cw(paramArrayOfByte))
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
    localObject = ayo();
    String str = p((String)localObject, "th_", "");
    ad.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(str)));
    i.deleteFile(str);
    i.f(str, paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(localObject));
    AppMethodBeat.o(150580);
    return paramArrayOfByte;
  }
  
  public final void ayl()
  {
    AppMethodBeat.i(150567);
    Cursor localCursor = this.gPa.a("SELECT max(id) FROM ImgInfo2", null, 2);
    long l;
    if (localCursor.moveToFirst()) {
      l = localCursor.getLong(0) + 1L;
    }
    synchronized (this.hhb)
    {
      if (l > this.hhb.get()) {
        this.hhb.set(l);
      }
      localCursor.close();
      ad.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.hhb.get());
      AppMethodBeat.o(150567);
      return;
    }
  }
  
  public final long aym()
  {
    AppMethodBeat.i(150568);
    synchronized (this.hhb)
    {
      long l = this.hhb.getAndIncrement();
      AppMethodBeat.o(150568);
      return l;
    }
  }
  
  public final List<e> ayn()
  {
    AppMethodBeat.i(150598);
    Object localObject = "select * " + " FROM ImgInfo2";
    localObject = (String)localObject + " WHERE iscomplete= 0 AND totalLen != 0 ";
    localObject = this.gPa.a((String)localObject, null, 0);
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(150598);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      e locale1 = new e();
      locale1.convertFrom((Cursor)localObject);
      e locale2 = oe((int)locale1.deI);
      if (locale2 != null) {
        if ((locale2.drA != 0L) || (locale2.hgs != 0L)) {
          localArrayList.add(locale1);
        }
      }
      while (!((Cursor)localObject).moveToNext())
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(150598);
        return localArrayList;
        if ((locale1.drA != 0L) || (locale1.hgs != 0L)) {
          localArrayList.add(locale1);
        }
      }
    }
  }
  
  public final Bitmap b(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(150588);
    paramString = a(paramString, true, paramFloat, paramBoolean, true, false, 0);
    AppMethodBeat.o(150588);
    return paramString;
  }
  
  public final e b(Long paramLong)
  {
    AppMethodBeat.i(150596);
    e locale = new e();
    paramLong = a("ImgInfo2", null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      locale.convertFrom(paramLong);
    }
    paramLong.close();
    AppMethodBeat.o(150596);
    return locale;
  }
  
  public final String b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(150633);
    Object localObject;
    if ((paramString != null) && (this.hha.containsKey(paramString)))
    {
      localObject = (String)this.hha.get(paramString);
      AppMethodBeat.o(150633);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = Q(paramString, paramBoolean2))
    {
      localObject = str;
      if (bt.isNullOrNil(str)) {
        break;
      }
      this.hha.put(paramString, str);
      localObject = str;
      break;
    }
  }
  
  public final HashMap<Long, e> b(Long... paramVarArgs)
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
      localObject2 = new e();
      ((e)localObject2).convertFrom(paramVarArgs);
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).drA), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(150602);
    return localObject1;
  }
  
  public final String d(e parame)
  {
    Object localObject = null;
    AppMethodBeat.i(150600);
    if (parame == null)
    {
      AppMethodBeat.o(150600);
      return null;
    }
    if (parame.ayi())
    {
      parame = parame.hgu;
      Cursor localCursor = b("ImgInfo2", new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { parame });
      parame = localObject;
      if (localCursor.moveToFirst()) {
        parame = localCursor.getString(0);
      }
      localCursor.close();
      AppMethodBeat.o(150600);
      return parame;
    }
    AppMethodBeat.o(150600);
    return null;
  }
  
  public final long e(e parame)
  {
    AppMethodBeat.i(150613);
    long l = this.gPa.a("ImgInfo2", "id", parame.convertTo());
    if (l != -1L) {
      parame.ayk();
    }
    ad.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { Long.valueOf(l), Long.valueOf(parame.deI), Long.valueOf(parame.hgs), Long.valueOf(parame.drA), Integer.valueOf(parame.hgu) });
    AppMethodBeat.o(150613);
    return l;
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
        str1 = mr(Long.valueOf(str1).longValue()).hgj;
        String str2 = com.tencent.mm.plugin.image.d.apW();
        String str3 = com.tencent.mm.plugin.image.d.apX();
        if (bt.isNullOrNil(str1))
        {
          paramString = l.j(str2, str3, "th_", paramString, "");
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
      Bitmap localBitmap2 = (Bitmap)this.hgT.aM(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.f.iV(paramInt1, paramInt2);
        this.hgT.o(str, localBitmap1);
      }
      AppMethodBeat.o(150629);
      return localBitmap1;
    }
  }
  
  public final e mr(long paramLong)
  {
    AppMethodBeat.i(150604);
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToFirst()) {
      locale.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(150604);
    return locale;
  }
  
  public final e ms(long paramLong)
  {
    AppMethodBeat.i(150605);
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToLast()) {
      locale.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(150605);
    return locale;
  }
  
  public final e od(int paramInt)
  {
    AppMethodBeat.i(150603);
    e locale = b(Long.valueOf(paramInt));
    AppMethodBeat.o(150603);
    return locale;
  }
  
  /* Error */
  public final e oe(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1725
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc_w 878
    //   10: aconst_null
    //   11: ldc_w 1727
    //   14: iconst_1
    //   15: anewarray 57	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: iload_1
    //   21: invokestatic 905	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   24: aastore
    //   25: invokespecial 1550	com/tencent/mm/aw/g:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +147 -> 177
    //   33: aload_3
    //   34: astore 4
    //   36: aload_3
    //   37: invokeinterface 911 1 0
    //   42: ifeq +135 -> 177
    //   45: aload_3
    //   46: astore 4
    //   48: new 214	com/tencent/mm/aw/e
    //   51: dup
    //   52: invokespecial 624	com/tencent/mm/aw/e:<init>	()V
    //   55: astore_2
    //   56: aload_3
    //   57: astore 4
    //   59: aload_2
    //   60: aload_3
    //   61: invokevirtual 915	com/tencent/mm/aw/e:convertFrom	(Landroid/database/Cursor;)V
    //   64: aload_2
    //   65: astore 4
    //   67: aload_3
    //   68: ifnull +12 -> 80
    //   71: aload_3
    //   72: invokeinterface 876 1 0
    //   77: aload_2
    //   78: astore 4
    //   80: ldc_w 1725
    //   83: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aload 4
    //   88: areturn
    //   89: astore 5
    //   91: aconst_null
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_3
    //   96: astore 4
    //   98: ldc 180
    //   100: ldc_w 1729
    //   103: iconst_1
    //   104: anewarray 102	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload 5
    //   111: invokevirtual 1642	java/lang/Exception:toString	()Ljava/lang/String;
    //   114: aastore
    //   115: invokestatic 1185	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aload_2
    //   119: astore 4
    //   121: aload_3
    //   122: ifnull -42 -> 80
    //   125: aload_3
    //   126: invokeinterface 876 1 0
    //   131: aload_2
    //   132: astore 4
    //   134: goto -54 -> 80
    //   137: astore_2
    //   138: aconst_null
    //   139: astore 4
    //   141: aload 4
    //   143: ifnull +10 -> 153
    //   146: aload 4
    //   148: invokeinterface 876 1 0
    //   153: ldc_w 1725
    //   156: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_2
    //   160: athrow
    //   161: astore_2
    //   162: goto -21 -> 141
    //   165: astore 5
    //   167: aconst_null
    //   168: astore_2
    //   169: goto -74 -> 95
    //   172: astore 5
    //   174: goto -79 -> 95
    //   177: aconst_null
    //   178: astore_2
    //   179: goto -115 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	g
    //   0	182	1	paramInt	int
    //   55	77	2	locale	e
    //   137	23	2	localObject1	Object
    //   161	1	2	localObject2	Object
    //   168	11	2	localObject3	Object
    //   28	98	3	localCursor	Cursor
    //   34	113	4	localObject4	Object
    //   89	21	5	localException1	Exception
    //   165	1	5	localException2	Exception
    //   172	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   6	29	89	java/lang/Exception
    //   6	29	137	finally
    //   36	45	161	finally
    //   48	56	161	finally
    //   59	64	161	finally
    //   98	118	161	finally
    //   36	45	165	java/lang/Exception
    //   48	56	165	java/lang/Exception
    //   59	64	172	java/lang/Exception
  }
  
  public final String p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(150571);
    paramString1 = a(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(150571);
    return paramString1;
  }
  
  public final String yg(String paramString)
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
        paramString = od(Integer.valueOf(paramString).intValue()).hgl;
        paramString = p(paramString, str1, "");
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
  
  public final Bitmap yh(String paramString)
  {
    AppMethodBeat.i(150592);
    float f = com.tencent.mm.cd.a.getDensity(aj.getContext());
    paramString = com.tencent.mm.sdk.platformtools.f.o(b(paramString, false, true), f);
    AppMethodBeat.o(150592);
    return paramString;
  }
  
  public final String yi(String paramString)
  {
    AppMethodBeat.i(150615);
    paramString = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString)), "th_", "", false);
    AppMethodBeat.o(150615);
    return paramString;
  }
  
  public final String yj(String paramString)
  {
    AppMethodBeat.i(150616);
    paramString = a(paramString, "", ".jpg", false);
    AppMethodBeat.o(150616);
    return paramString;
  }
  
  public final String yl(String paramString)
  {
    AppMethodBeat.i(203569);
    paramString = b(paramString, false, true);
    AppMethodBeat.o(203569);
    return paramString;
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
    int hhl;
    int hhm;
    int hhn;
    String url;
    
    b(int paramInt1, String paramString, int paramInt2, int paramInt3)
    {
      this.hhl = paramInt1;
      this.url = paramString;
      this.hhm = paramInt2;
      this.hhn = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.g
 * JD-Core Version:    0.7.0.1
 */