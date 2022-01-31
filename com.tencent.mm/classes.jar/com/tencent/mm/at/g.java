package com.tencent.mm.at;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.MMJpegOptim;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.storage.aa;
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
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class g
  extends k
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS ImgInfo ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT )", "CREATE TABLE IF NOT EXISTS ImgInfo2 ( id INTEGER PRIMARY KEY, msgSvrId LONG, offset INT, totalLen INT, bigImgPath TEXT, thumbImgPath TEXT, createtime INT, msglocalid INT, status INT, nettimes INT, reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text, hashdthumb int DEFAULT 0, iscomplete INT DEFAULT 1, origImgMD5 TEXT, compressType INT DEFAULT 0, midImgPath TEXT, forwardType INT DEFAULT 0, hevcPath TEXT )", "CREATE INDEX IF NOT EXISTS  serverImgInfoIndex ON ImgInfo2 ( msgSvrId ) ", "CREATE INDEX IF NOT EXISTS  serverImgInfoHdIndex ON ImgInfo2 ( reserved1 ) ", "CREATE INDEX IF NOT EXISTS  msgLocalIdIndex ON ImgInfo2 ( msglocalid ) ", "insert into imginfo2 (id,msgSvrId , offset , totalLen , bigImgPath , thumbImgPath) select id, msgSvrId, offset ,totallen , bigimgpath , thumbimgpath from imginfo; ", "delete from ImgInfo ; ", "CREATE INDEX IF NOT EXISTS iscomplete_index ON ImgInfo2 ( iscomplete ) ", "CREATE INDEX IF NOT EXISTS origImgMD5_index ON ImgInfo2 ( origImgMD5 ) " };
  public static long fEG = 0L;
  public static int fEt = 0;
  private Set<Integer> fEA;
  private Map<String, String> fEB;
  private final AtomicLong fEC;
  private FrameLayout.LayoutParams fED;
  private SoftReference<ColorDrawable> fEE;
  public int fEF;
  com.tencent.mm.a.f<String, Bitmap> fEu;
  private com.tencent.mm.a.f<String, String> fEv;
  private List<g.b> fEw;
  private Map<Integer, WeakReference<ImageView>> fEx;
  private Map<Integer, WeakReference<ImageView>> fEy;
  private Map<Integer, WeakReference<View>> fEz;
  private ak faV;
  public com.tencent.mm.cg.h fnw;
  
  public g(com.tencent.mm.cg.h paramh)
  {
    AppMethodBeat.i(78208);
    this.fEu = new com.tencent.mm.memory.a.b(40, new g.1(this), getClass());
    this.fEv = new com.tencent.mm.memory.a.c(40);
    this.fEw = new ArrayList();
    this.fEx = new HashMap();
    this.fEy = new HashMap();
    this.fEz = new HashMap();
    this.fEA = new HashSet();
    this.faV = new ak(Looper.getMainLooper());
    this.fEB = new HashMap();
    this.fEC = new AtomicLong(1L);
    this.fnw = null;
    this.fED = new FrameLayout.LayoutParams(-2, -2);
    this.fEF = 150;
    a(paramh);
    this.fnw = paramh;
    ahk();
    AppMethodBeat.o(78208);
  }
  
  private e X(String paramString, int paramInt)
  {
    AppMethodBeat.i(78239);
    e locale = new e();
    paramString = a("ImgInfo2", null, "origImgMD5=? AND compressType=?", new String[] { String.valueOf(paramString), String.valueOf(paramInt) });
    if (paramString.moveToFirst()) {
      locale.convertFrom(paramString);
    }
    paramString.close();
    AppMethodBeat.o(78239);
    return locale;
  }
  
  private String Y(String paramString, int paramInt)
  {
    AppMethodBeat.i(78257);
    paramString = X(f.tc(paramString), paramInt);
    if (!bo.isNullOrNil(paramString.fDO))
    {
      paramString = J(paramString.fDO, true);
      if (com.tencent.mm.vfs.e.cN(paramString))
      {
        AppMethodBeat.o(78257);
        return paramString;
      }
    }
    AppMethodBeat.o(78257);
    return null;
  }
  
  private Bitmap a(String paramString1, int paramInt1, int paramInt2, PInt paramPInt1, PInt paramPInt2, boolean paramBoolean, String paramString2, com.tencent.mm.a.b paramb)
  {
    AppMethodBeat.i(78258);
    ab.d("MicroMsg.ImgInfoStorage", "summersafecdn getPreSendBitmap origPath[%s], compressType[%d],needSave[%b], stack[%s], thumbPath: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), bo.dtY(), paramString2 });
    Object localObject2 = (Bitmap)this.fEu.Y(f.tc(paramString1));
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
      localObject1 = Y(paramString1, paramInt1);
      if (bo.isNullOrNil((String)localObject1)) {
        break label422;
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
            break label411;
          }
        }
        i = ad.api((String)localObject5);
        j = BackwardSupportUtil.ExifHelper.bY((String)localObject5);
        if (i <= 0) {
          break label337;
        }
      }
      label171:
      label316:
      label337:
      for (localObject2 = ad.aC((String)localObject5, i, j + paramInt2 * 90);; localObject2 = com.tencent.mm.sdk.platformtools.d.az((String)localObject5, 120, 120))
      {
        if (localObject2 != null)
        {
          this.fEu.f(f.tc(paramString1), localObject2);
          paramPInt1.value = ((Bitmap)localObject2).getWidth();
          paramPInt2.value = ((Bitmap)localObject2).getHeight();
          if (paramBoolean)
          {
            if (localObject1 != null) {
              break label405;
            }
            paramString1 = Y(paramString1, paramInt1);
            label228:
            paramPInt1 = paramString1;
            if (!bo.isNullOrNil(paramString1))
            {
              paramPInt1 = paramString1;
              if (paramString1.endsWith("hd")) {
                paramPInt1 = paramString1.substring(0, paramString1.length() - 2);
              }
            }
            if (paramb != null) {
              paramb.getFile();
            }
            if ((bo.isNullOrNil(paramPInt1)) || (!com.tencent.mm.vfs.e.cN(paramPInt1))) {
              break label351;
            }
            com.tencent.mm.vfs.e.C(paramPInt1, paramString2);
            ab.i("MicroMsg.ImgInfoStorage", "copy from old thumbPath %s", new Object[] { paramPInt1 });
          }
        }
        AppMethodBeat.o(78258);
        return localObject2;
        localObject2 = com.tencent.mm.sdk.platformtools.d.aoV((String)localObject1);
        localObject5 = paramString1;
        break;
      }
    }
    for (;;)
    {
      label351:
      label375:
      try
      {
        if ((bo.isNullOrNil(paramPInt1)) || (!paramPInt1.endsWith("hd"))) {
          break label394;
        }
        paramInt1 = 1;
      }
      catch (IOException paramString1) {}
      com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject2, paramInt1, Bitmap.CompressFormat.JPEG, paramString2, false);
      break label316;
      break label316;
      label394:
      paramInt1 = 0;
      label405:
      label411:
      label422:
      while (paramInt1 == 0)
      {
        paramInt1 = 90;
        break label375;
        paramString1 = (String)localObject1;
        break label228;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break label171;
        localObject5 = paramString1;
        break;
      }
      paramInt1 = 80;
    }
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5)
  {
    AppMethodBeat.i(78232);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, paramBoolean5, null);
    AppMethodBeat.o(78232);
    return paramString;
  }
  
  private Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt, boolean paramBoolean5, Bitmap paramBitmap)
  {
    AppMethodBeat.i(78233);
    String str = paramString;
    if (!paramBoolean1) {
      str = c(paramString, false, true);
    }
    if (str == null)
    {
      AppMethodBeat.o(78233);
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
        paramString = (Bitmap)this.fEu.Y(str);
        localObject1 = paramString;
        if (paramString == null)
        {
          if (paramString != null) {
            break label691;
          }
          paramBoolean1 = true;
          ab.a("MicroMsg.ImgInfoStorage", "bm is null:%b,  url:%s", new Object[] { Boolean.valueOf(paramBoolean1), str });
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
        bo.aoy();
        if (k == 0) {
          break label696;
        }
        paramString = paramBitmap;
        if (paramBitmap == null) {
          paramString = x.wx(str);
        }
        if (paramString == null) {
          break label908;
        }
        l = System.currentTimeMillis();
        m = paramString.getWidth();
        n = paramString.getHeight();
        i = n;
        j = m;
        if (paramBoolean3)
        {
          if (fEt == 0) {
            fEt = com.tencent.mm.cb.a.ap(ah.getContext(), 2131428398);
          }
          if (m <= fEt)
          {
            i = n;
            j = m;
            if (n <= fEt) {}
          }
          else
          {
            if (m <= n) {
              break label707;
            }
            i = n * fEt / m;
            j = fEt;
          }
        }
        label258:
        n = i;
        m = j;
        if (paramBoolean4)
        {
          if (str.endsWith("hd")) {
            break label946;
          }
          j = (int)(paramString.getWidth() * paramFloat * 1.25F);
          i = (int)(paramString.getHeight() * paramFloat * 1.25F);
        }
      }
    }
    label908:
    label946:
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
          ab.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(j) });
          m = (int)(60.0F * paramFloat);
        }
        j = i;
        if (i < 60.0F * paramFloat)
        {
          ab.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(i) });
          j = (int)(60.0F * paramFloat);
        }
        paramBitmap = ah.getContext();
        localObject1 = new int[2];
        if (j >= m)
        {
          paramFloat = j / m;
          if (paramFloat <= 2.0F)
          {
            i = com.tencent.mm.cb.a.ap(paramBitmap, 2131427520);
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
              ab.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramString.toString() });
              paramString.recycle();
            }
            if (paramBoolean4)
            {
              paramString = com.tencent.mm.sdk.platformtools.d.f(paramBitmap, paramInt);
              localObject1 = System.currentTimeMillis() - l;
              if (paramString != null) {
                continue;
              }
              paramBitmap = "";
              ab.i("MicroMsg.ImgInfoStorage", "cached file :%s bitmap time:%s bitmap:%s", new Object[] { str, localObject1, paramBitmap });
              localObject2 = paramString;
              if (paramString != null)
              {
                localObject2 = paramString;
                if (k == 0)
                {
                  this.fEu.f(str, paramString);
                  localObject2 = paramString;
                }
              }
              AppMethodBeat.o(78233);
              return localObject2;
              k = 0;
              break;
              label691:
              paramBoolean1 = false;
              break label87;
              label696:
              paramBitmap = com.tencent.mm.sdk.platformtools.d.l(str, paramFloat);
              break label145;
              label707:
              if (m == n)
              {
                i = fEt;
                j = fEt;
                break label258;
              }
              j = m * fEt / n;
              i = fEt;
              break label258;
              f = 160.0F * paramFloat / j;
              break label352;
              j = com.tencent.mm.cb.a.ap(paramBitmap, 2131427522);
              i = (int)(j * paramFloat);
              break label507;
              paramFloat = m / j;
              if (paramFloat <= 2.0F)
              {
                j = com.tencent.mm.cb.a.ap(paramBitmap, 2131427520);
                i = (int)(j / paramFloat);
                break label507;
              }
              i = com.tencent.mm.cb.a.ap(paramBitmap, 2131427522);
              j = (int)(i * paramFloat);
            }
          }
          catch (OutOfMemoryError paramBitmap)
          {
            paramBitmap = paramString;
            continue;
            if (paramBoolean2)
            {
              paramString = com.tencent.mm.sdk.platformtools.d.a(paramBitmap, true, com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 3));
              ab.i("MicroMsg.ImgInfoStorage", "[bitmapFromUriPath]:bitmap recycle %s", new Object[] { paramBitmap.toString() });
              paramBitmap.recycle();
              continue;
            }
            paramString = paramBitmap;
            continue;
            paramBitmap = paramString.toString();
            continue;
          }
          ab.e("MicroMsg.ImgInfoStorage", "img maybe delete, %s, %s", new Object[] { str, Boolean.valueOf(FileOp.cN(str)) });
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private e a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, PInt paramPInt1, PInt paramPInt2, String paramString2, long paramLong, String paramString3, String paramString4, com.tencent.mm.a.b paramb1, com.tencent.mm.a.b paramb2, n.a parama)
  {
    AppMethodBeat.i(78264);
    if (!com.tencent.mm.vfs.e.cN(paramString1))
    {
      AppMethodBeat.o(78264);
      return null;
    }
    String str = f.tc(paramString1);
    paramb1 = a(paramString1, paramInt1, paramBoolean, paramInt3, paramPInt1, paramPInt2, paramString2, paramString3, paramb1);
    if ((parama != null) && (parama.fDP == paramInt1))
    {
      paramString4 = parama.ahv();
      paramPInt2 = paramString4.fGi;
      paramString2 = paramString4.fGj;
      paramPInt1 = paramString4.fDX;
      paramString3 = paramString4.fGk;
      paramString4 = paramString4.fGl;
      ab.i("MicroMsg.ImgInfoStorage", "summersafecdn found CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString3.value, paramString4.value });
      paramString4 = new e();
      paramString4.bsY = -1;
      paramString4.gR(ahl());
      paramString4.gQ(paramLong);
      if (!bo.isNullOrNil(paramPInt1)) {
        paramString4.sZ(paramPInt1);
      }
      paramString4.lt(0);
      paramString4.setSource(paramInt2);
      if (paramInt2 != 4) {
        break label564;
      }
      if (paramString1.startsWith(aa.YO()))
      {
        paramString4.ls(3);
        label232:
        if (paramBoolean)
        {
          paramString4.sW(paramPInt2.value + ".jpg");
          if (!bo.isNullOrNil(paramString3.value)) {
            paramString4.sX(paramString3.value + ".jpg");
          }
          if (bo.isNullOrNil(paramString4.fDO)) {
            paramString4.sY(paramb1);
          }
          paramString4.lq((int)com.tencent.mm.vfs.e.avI(paramString2.value));
          if (paramString4.fsd == 0) {
            ab.i("MicroMsg.ImgInfoStorage", "thumb file totlen is 0 %s", new Object[] { paramString2.value });
          }
          paramString4.sV(str);
        }
        paramString4.lp((int)bo.aox());
        paramString4.lu(paramInt1);
        ab.d("MicroMsg.ImgInfoStorage", "fromPathToImgInfo insert: compress img size = " + paramString4.fsd);
        AppMethodBeat.o(78264);
        return paramString4;
      }
    }
    else
    {
      if ((parama == null) || (parama.fDP == paramInt1)) {
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
      ab.i("MicroMsg.ImgInfoStorage", "summersafecdn user change CompressType path %s, source:%d, compressType:%d, pMidImgName[%s], pMidImgPath[%s]", new Object[] { paramString1, Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString3.value, paramb2.value });
      paramPInt2 = paramString4;
      break;
      paramString4.ls(2);
      break label232;
      label564:
      paramString4.ls(1);
      break label232;
      label573:
      paramPInt2 = paramb2;
    }
  }
  
  private String a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, com.tencent.mm.a.b paramb)
  {
    AppMethodBeat.i(78262);
    ab.i("MicroMsg.ImgInfoStorage", "genThumbImg, orig:%s", new Object[] { paramString1 });
    if (!com.tencent.mm.vfs.e.cN(paramString1))
    {
      ab.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      AppMethodBeat.o(78262);
      return null;
    }
    String str = paramString3;
    if (bo.isNullOrNil(paramString3)) {
      str = ahn();
    }
    str = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str));
    paramString3 = a(str, "th_", "", false);
    if (paramb == null) {
      paramString3 = q(str, "th_", "");
    }
    if (paramBoolean)
    {
      if ((!bo.isNullOrNil(paramString2)) && (com.tencent.mm.vfs.e.cN(paramString2))) {
        break label257;
      }
      long l = bo.yB();
      a(paramString1, paramInt1, paramInt2, paramPInt1, paramPInt2, true, paramString3, paramb);
      if (!com.tencent.mm.vfs.e.cN(paramString3)) {
        break label246;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(10921, new Object[] { Long.valueOf(com.tencent.mm.vfs.e.avI(paramString3)), Long.valueOf(com.tencent.mm.vfs.e.avI(paramString1)), Integer.valueOf(90), Long.valueOf(bo.av(l)) });
    }
    for (;;)
    {
      ab.d("MicroMsg.ImgInfoStorage", "insert: thumbName = ".concat(String.valueOf(str)));
      AppMethodBeat.o(78262);
      return str;
      label246:
      ab.e("MicroMsg.ImgInfoStorage", " thumbImg not exits");
      continue;
      label257:
      com.tencent.mm.vfs.e.C(paramString2, paramString3);
    }
  }
  
  private void a(ImageView paramImageView1, ImageView paramImageView2, View paramView, String paramString, float paramFloat)
  {
    AppMethodBeat.i(78228);
    int k = paramString.hashCode();
    int m = paramImageView1.hashCode();
    Iterator localIterator = this.fEw.iterator();
    while (localIterator.hasNext())
    {
      g.b localb = (g.b)localIterator.next();
      if (m == localb.fEM)
      {
        ab.i("MicroMsg.ImgInfoStorage", "setbitmapFromUri  [%d, %s] ", new Object[] { Integer.valueOf(localb.fEM), localb.url });
        localb.url = paramString;
        if (!this.fEA.contains(Integer.valueOf(k)))
        {
          this.fEA.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(78228);
        return;
      }
    }
    this.fEx.put(Integer.valueOf(m), new WeakReference(paramImageView1));
    int i;
    if (paramImageView2 != null)
    {
      i = paramImageView2.hashCode();
      this.fEy.put(Integer.valueOf(i), new WeakReference(paramImageView2));
    }
    for (;;)
    {
      int j;
      if (paramView != null)
      {
        j = paramView.hashCode();
        this.fEz.put(Integer.valueOf(j), new WeakReference(paramView));
      }
      for (;;)
      {
        paramImageView1 = new g.b(m, paramString, i, j);
        this.fEw.add(paramImageView1);
        if (!this.fEA.contains(Integer.valueOf(k)))
        {
          this.fEA.add(Integer.valueOf(k));
          f(paramString, paramFloat);
        }
        AppMethodBeat.o(78228);
        return;
        j = 0;
      }
      i = 0;
    }
  }
  
  private static void a(com.tencent.mm.cg.h paramh)
  {
    AppMethodBeat.i(78211);
    Cursor localCursor = paramh.a("PRAGMA table_info(ImgInfo2)", null, 2);
    int i3 = localCursor.getColumnIndex("name");
    int j = 0;
    int i = 0;
    int n = 0;
    int i2 = 0;
    int i1 = 0;
    int m = 0;
    int k = 0;
    String str;
    while (localCursor.moveToNext()) {
      if (i3 >= 0)
      {
        str = localCursor.getString(i3);
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
          i2 = 1;
        }
        if ("midImgPath".equals(str)) {
          n = 1;
        }
        if (!"forwardType".equals(str)) {
          break label323;
        }
        i = 1;
      }
    }
    label323:
    for (;;)
    {
      if ("hevcPath".equals(str)) {
        j = 1;
      }
      break;
      localCursor.close();
      long l = com.tencent.mm.kernel.g.RL().eHS.kr(Thread.currentThread().getId());
      if (k == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add hashdthumb INT DEFAULT 0");
      }
      if (m == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add iscomplete INT DEFAULT 1");
      }
      if (i1 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add origImgMD5 TEXT");
      }
      if (i2 == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add compressType INT DEFAULT 0");
      }
      if (n == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add midImgPath TEXT");
      }
      if (i == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add forwardType INT DEFAULT 0");
      }
      if (j == 0) {
        paramh.execSQL("ImgInfo2", "Alter table ImgInfo2 add hevcPath TEXT");
      }
      if (l > 0L) {
        com.tencent.mm.kernel.g.RL().eHS.nY(l);
      }
      AppMethodBeat.o(78211);
      return;
    }
  }
  
  public static String ahn()
  {
    try
    {
      AppMethodBeat.i(78260);
      String str = ti("");
      AppMethodBeat.o(78260);
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
    AppMethodBeat.i(78250);
    paramString1 = a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2);
    AppMethodBeat.o(78250);
    return paramString1;
  }
  
  private void f(String paramString, float paramFloat)
  {
    AppMethodBeat.i(78229);
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new g.2(this, paramString, paramFloat, true, 2130838228));
    AppMethodBeat.o(78229);
  }
  
  public static String td(String paramString)
  {
    AppMethodBeat.i(78215);
    paramString = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString));
    AppMethodBeat.o(78215);
    return paramString;
  }
  
  /* Error */
  private static String ti(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 835
    //   6: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   12: lstore_3
    //   13: getstatic 73	com/tencent/mm/at/g:fEG	J
    //   16: lstore 5
    //   18: lload_3
    //   19: lstore_1
    //   20: lload 5
    //   22: lload_3
    //   23: lcmp
    //   24: ifne +11 -> 35
    //   27: lconst_1
    //   28: invokestatic 838	java/lang/Thread:sleep	(J)V
    //   31: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   34: lstore_1
    //   35: lload_1
    //   36: putstatic 73	com/tencent/mm/at/g:fEG	J
    //   39: new 416	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: lload_1
    //   51: invokevirtual 421	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokevirtual 842	java/lang/String:getBytes	()[B
    //   60: invokestatic 848	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   63: astore_0
    //   64: ldc 238
    //   66: ldc_w 850
    //   69: iconst_2
    //   70: anewarray 94	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_0
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: lload_1
    //   80: invokestatic 609	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   83: aastore
    //   84: invokestatic 329	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: ldc_w 835
    //   90: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static String y(bi parambi)
  {
    AppMethodBeat.i(78275);
    if (parambi == null)
    {
      ab.w("MicroMsg.ImgInfoStorage", "[getBigPicPath] msg is null.");
      AppMethodBeat.o(78275);
      return null;
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject1;
    if (parambi.field_isSend == 1)
    {
      localObject2 = o.ahC().gT(parambi.field_msgId);
      localObject1 = localObject2;
      if (((e)localObject2).fDL != 0L) {}
    }
    else
    {
      localObject1 = o.ahC().gS(parambi.field_msgSvrId);
    }
    if (com.tencent.mm.kernel.g.RL().isSDCardAvailable()) {
      if (parambi.field_isSend == 1)
      {
        parambi = f.c((e)localObject1);
        localObject2 = o.ahC().q(parambi, "", "");
        if ((parambi != null) && (parambi.length() > 0) && (com.tencent.mm.vfs.e.cN((String)localObject2)))
        {
          AppMethodBeat.o(78275);
          return localObject2;
        }
        parambi = ((e)localObject1).fDM;
        localObject1 = o.ahC().q(parambi, "", "");
        if ((parambi != null) && (parambi.length() > 0) && (com.tencent.mm.vfs.e.cN((String)localObject1)))
        {
          AppMethodBeat.o(78275);
          return localObject1;
        }
      }
      else if (((e)localObject1).ahg())
      {
        parambi = ((e)localObject1).fDM;
        if (!((e)localObject1).ahh()) {
          break label304;
        }
        localObject1 = f.a((e)localObject1);
        if ((localObject1 == null) || (((e)localObject1).fDL <= 0L) || (!((e)localObject1).ahg()) || (!com.tencent.mm.vfs.e.cN(o.ahC().q(((e)localObject1).fDM, "", "")))) {
          break label304;
        }
        parambi = ((e)localObject1).fDM;
      }
    }
    label304:
    for (;;)
    {
      AppMethodBeat.o(78275);
      return parambi;
      ab.d("MicroMsg.ImgInfoStorage", "getBigPicPath use time:%s", new Object[] { System.currentTimeMillis() - l });
      AppMethodBeat.o(78275);
      return null;
    }
  }
  
  public final String J(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(78223);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(78223);
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
        paramString = lv(Integer.valueOf(paramString).intValue()).fDO;
        paramString = a(paramString, "", "", paramBoolean);
        AppMethodBeat.o(78223);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(78223);
        return null;
      }
      paramString = str;
    } while (!str.startsWith("THUMBNAIL_DIRPATH://"));
    paramString = a(str.substring(20).substring(3), "th_", "", paramBoolean);
    AppMethodBeat.o(78223);
    return paramString;
  }
  
  public final String T(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78222);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(78222);
      return null;
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, (BitmapFactory.Options)localObject);
    if ((((BitmapFactory.Options)localObject).outWidth < 0) || (((BitmapFactory.Options)localObject).outHeight < 0))
    {
      ab.e("MicroMsg.ImgInfoStorage", "Bad thumbBuf, perhaps it's not complete or damaged ??");
      AppMethodBeat.o(78222);
      return null;
    }
    localObject = ahn();
    String str = q((String)localObject, "th_", "");
    ab.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = ".concat(String.valueOf(str)));
    com.tencent.mm.vfs.e.deleteFile(str);
    com.tencent.mm.vfs.e.b(str, paramArrayOfByte, paramArrayOfByte.length);
    paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(localObject));
    AppMethodBeat.o(78222);
    return paramArrayOfByte;
  }
  
  public final int a(int paramInt, e parame)
  {
    AppMethodBeat.i(78267);
    paramInt = a(Long.valueOf(paramInt), parame);
    AppMethodBeat.o(78267);
    return paramInt;
  }
  
  public final int a(Long paramLong, e parame)
  {
    AppMethodBeat.i(78268);
    long l = System.currentTimeMillis();
    ContentValues localContentValues = parame.convertTo();
    if (localContentValues.size() == 0) {}
    for (int i = 1;; i = this.fnw.update("ImgInfo2", localContentValues, "id=?", new String[] { String.valueOf(paramLong) }))
    {
      ab.i("MicroMsg.ImgInfoStorage", "update last :%d values : %s %s", new Object[] { Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()), localContentValues.toString(), Integer.valueOf(i) });
      if (i != -1)
      {
        parame.ahj();
        doNotify();
      }
      AppMethodBeat.o(78268);
      return i;
    }
  }
  
  public final long a(String paramString1, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString2, String paramString3, long paramLong, com.tencent.mm.a.b paramb1, com.tencent.mm.a.b paramb2, n.a parama)
  {
    AppMethodBeat.i(78252);
    paramLong = a(paramString1, null, paramInt1, paramInt2, paramInt3, paramPString, paramPInt1, paramPInt2, paramString2, paramString3, paramLong, paramb1, paramb2, parama);
    AppMethodBeat.o(78252);
    return paramLong;
  }
  
  public final long a(String paramString, int paramInt1, int paramInt2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(78251);
    long l = a(paramString, paramInt1, paramInt2, 0, paramPString, paramPInt1, paramPInt2, "", "", -1L, null, null, null);
    AppMethodBeat.o(78251);
    return l;
  }
  
  final long a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, PString paramPString, PInt paramPInt1, PInt paramPInt2, String paramString3, String paramString4, long paramLong, com.tencent.mm.a.b paramb1, com.tencent.mm.a.b paramb2, n.a parama)
  {
    AppMethodBeat.i(78253);
    if (paramInt1 == 0)
    {
      paramString1 = a(paramString1, 0, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString1 == null)
      {
        AppMethodBeat.o(78253);
        return -1L;
      }
      paramPString.value = paramString1.fDO;
      if (com.tencent.mm.vfs.e.cN(paramString2))
      {
        paramPString = ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.emoji.b.c.class)).Kf(paramString1.fDM);
        com.tencent.mm.vfs.e.C(paramString2, q(paramPString, "", ""));
        paramString1.ta(paramPString);
      }
      paramLong = e(paramString1);
      if (paramLong != -1L) {
        doNotify();
      }
      AppMethodBeat.o(78253);
      return paramLong;
    }
    if (paramInt1 == 1)
    {
      paramString2 = a(paramString1, 1, true, paramInt2, paramInt3, paramPInt1, paramPInt2, paramPString.value, paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString2 == null)
      {
        AppMethodBeat.o(78253);
        return -1L;
      }
      paramPString.value = paramString2.fDO;
      paramString2.gQ(0L);
      paramString2.fP(0L);
      paramString2.lq((int)com.tencent.mm.vfs.e.avI(q(paramString2.fDM, "", "")));
      paramString1 = a(paramString1, 0, false, paramInt2, paramInt3, new PInt(), new PInt(), "", paramLong, paramString3, paramString4, paramb2, paramb1, parama);
      if (paramString1 == null)
      {
        AppMethodBeat.o(78253);
        return 0L;
      }
      paramString1.sW(paramString2.fDM);
      paramString1.sY(paramString2.fDO);
      paramString1.sX(paramString2.fDN);
      paramString1.lq(0);
      paramLong = this.fnw.kr(Thread.currentThread().getId());
      paramString1.lr((int)e(paramString2));
      long l = e(paramString1);
      ab.d("MicroMsg.ImgInfoStorage", "summersafecdn insert ret[%d],  getLocalId[%d], getMsgLocalId[%d], getBigImgPath[%s], getMidImgPath[%s], getTotalLen[%d]", new Object[] { Long.valueOf(l), Long.valueOf(paramString1.fDL), Long.valueOf(paramString1.fDU), paramString1.fDM, paramString1.fDN, Integer.valueOf(paramString1.fsd) });
      if (paramLong > 0L) {
        com.tencent.mm.kernel.g.RL().eHS.nY(paramLong);
      }
      if (l != -1L) {
        doNotify();
      }
      AppMethodBeat.o(78253);
      return l;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(78253);
    return 0L;
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString1, int paramInt, String paramString2, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(78266);
    String str1 = "SERVERID://".concat(String.valueOf(paramLong));
    String str2 = com.tencent.mm.a.g.w(str1.getBytes());
    String str3 = q(str2, "th_", "");
    Bitmap localBitmap;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 0))
    {
      localBitmap = com.tencent.mm.sdk.platformtools.d.bT(paramArrayOfByte);
      if (localBitmap == null) {
        ab.e("MicroMsg.ImgInfoStorage", "create decodeByteArray failed: " + new String(paramArrayOfByte));
      }
      if ((paramBoolean) || (localBitmap == null)) {}
    }
    try
    {
      localBitmap = com.tencent.mm.sdk.platformtools.d.ah(localBitmap);
      paramPInt1.value = localBitmap.getWidth();
      paramPInt2.value = localBitmap.getHeight();
      com.tencent.mm.sdk.platformtools.d.a(localBitmap, 90, Bitmap.CompressFormat.JPEG, str3, true);
      paramArrayOfByte = new e();
      if (!bo.isNullOrNil(paramString1))
      {
        paramArrayOfByte.setOffset(paramInt);
        paramArrayOfByte.lq(paramInt);
        paramArrayOfByte.bsY = -1;
        paramArrayOfByte.gR(ahl());
        paramArrayOfByte.sW(paramString1);
        paramArrayOfByte.sY("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str2)));
        paramPString.value = paramArrayOfByte.fDO;
        if (paramBoolean)
        {
          paramArrayOfByte.fP(0L);
          paramArrayOfByte.lu(1);
          paramArrayOfByte.sZ(paramString2);
          paramArrayOfByte.lp((int)bo.aox());
          paramLong = e(paramArrayOfByte);
          if (paramLong != -1L) {
            doNotify();
          }
          AppMethodBeat.o(78266);
          return paramLong;
        }
      }
    }
    catch (IOException paramPInt1)
    {
      for (;;)
      {
        ab.e("MicroMsg.ImgInfoStorage", "create thumbnail from byte failed: " + str2 + " " + new String(paramArrayOfByte));
        continue;
        paramArrayOfByte.fP(paramLong);
        paramArrayOfByte.lu(0);
        continue;
        paramString1 = str1;
      }
    }
  }
  
  public final long a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean, String paramString, PString paramPString, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(78265);
    paramLong = a(paramArrayOfByte, paramLong, paramBoolean, "", 0, paramString, paramPString, paramPInt1, paramPInt2);
    AppMethodBeat.o(78265);
    return paramLong;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(78249);
    paramString1 = this.fnw.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, null);
    AppMethodBeat.o(78249);
    return paramString1;
  }
  
  public final Bitmap a(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(78270);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from".concat(String.valueOf(paramLong));; str = "location_backgroup_key_tor".concat(String.valueOf(paramLong)))
    {
      Bitmap localBitmap2 = (Bitmap)this.fEu.Y(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.d.p(paramString, paramInt1, paramInt2, paramInt3);
        this.fEu.f(str, localBitmap1);
      }
      AppMethodBeat.o(78270);
      return localBitmap1;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext)
  {
    AppMethodBeat.i(78235);
    paramString = a(paramString, paramFloat, paramContext, -1);
    AppMethodBeat.o(78235);
    return paramString;
  }
  
  public final Bitmap a(String paramString, float paramFloat, Context paramContext, int paramInt)
  {
    AppMethodBeat.i(78236);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(78236);
      return null;
    }
    String str = paramString.trim();
    Bitmap localBitmap = (Bitmap)this.fEu.Y(str);
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
      localBitmap = BackwardSupportUtil.b.k(str, paramFloat);
      if (localBitmap == null) {
        break label357;
      }
      k = localBitmap.getWidth();
      m = localBitmap.getHeight();
      if (k < m) {
        break label276;
      }
      j = BackwardSupportUtil.b.b(paramContext, this.fEF);
      i = (int)(m / k * j);
      if ((j > 0) && (i > 0) && (j <= 2048) && (i <= 2048)) {
        break label304;
      }
      ab.e("MicroMsg.ImgInfoStorage", "getVideoThumb, error Scale Size %d*%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 188L, 1L, false);
      paramString = null;
      label192:
      paramContext = paramString;
      if (paramInt != -1) {
        paramContext = com.tencent.mm.sdk.platformtools.d.f(paramString, paramInt);
      }
      if (localBitmap != paramContext)
      {
        ab.i("MicroMsg.ImgInfoStorage", "[getVideoThumb] bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
      ab.d("MicroMsg.ImgInfoStorage", "cached file ".concat(String.valueOf(str)));
      this.fEu.f(str, paramContext);
    }
    label276:
    label304:
    label357:
    for (paramString = paramContext;; paramString = localBitmap)
    {
      for (;;)
      {
        AppMethodBeat.o(78236);
        return paramString;
        i = BackwardSupportUtil.b.b(paramContext, this.fEF);
        j = (int)(k / m * i);
        break;
        try
        {
          paramString = Bitmap.createScaledBitmap(localBitmap, j, i, true);
        }
        catch (Exception paramString)
        {
          ab.e("MicroMsg.ImgInfoStorage", "getVideoThumb, Bitmap.createScaledBitmap Exception:%s", new Object[] { paramString.getMessage() });
          paramString = null;
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 188L, 1L, false);
        }
      }
      break label192;
    }
  }
  
  public final Bitmap a(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(78225);
    paramString = a(paramString, false, paramFloat, paramBoolean, false, false, -1);
    AppMethodBeat.o(78225);
    return paramString;
  }
  
  public final Bitmap a(String paramString, boolean paramBoolean1, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    AppMethodBeat.i(78231);
    paramString = a(paramString, paramBoolean1, paramFloat, paramBoolean2, paramBoolean3, paramBoolean4, paramInt, true);
    AppMethodBeat.o(78231);
    return paramString;
  }
  
  public final String a(String paramString1, int paramInt1, PString paramPString, PInt paramPInt1, PInt paramPInt2, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(78259);
    if (!com.tencent.mm.vfs.e.cN(paramString1))
    {
      ab.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
      AppMethodBeat.o(78259);
      return null;
    }
    String str1 = paramString2;
    if (bo.isNullOrNil(paramString2)) {
      str1 = ahn();
    }
    String str2 = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
    paramString2 = a(str2, "th_", "", false);
    paramPString.value = str2;
    long l = bo.yB();
    paramPInt2 = a(paramString1, paramInt1, paramInt2, paramPInt1, paramPInt2, false, null, null);
    paramPString = (String)this.fEv.get(paramString1);
    if (paramPString != null) {}
    for (paramPString = (Bitmap)this.fEu.get(paramPString);; paramPString = null)
    {
      if (paramPString != null)
      {
        paramPInt1 = paramPString;
        if (!paramPString.isRecycled()) {}
      }
      else
      {
        paramPInt1 = a(paramString1, true, com.tencent.mm.cb.a.getDensity(ah.getContext()), false, false, true, 2130838228, true, paramPInt2);
        this.fEv.put(paramString1, paramString2);
      }
      if (paramPInt1 != null) {
        this.fEu.f(paramString2, paramPInt1);
      }
      ab.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(78259);
      return str1;
    }
  }
  
  public final String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, PString paramPString1, PString paramPString2, PString paramPString3, PString paramPString4, String paramString3, com.tencent.mm.a.b paramb)
  {
    AppMethodBeat.i(78263);
    Object localObject = paramString3;
    if (bo.isNullOrNil(paramString3))
    {
      localObject = ti(paramString1);
      ab.i("MicroMsg.ImgInfoStorage", "generateMd5: %s, %s", new Object[] { localObject, paramString1 });
    }
    paramString3 = a((String)localObject, "", ".jpg", false);
    if (paramb == null) {
      paramString3 = a((String)localObject, "", ".jpg", true);
    }
    ab.i("MicroMsg.ImgInfoStorage", "fullPath is %s", new Object[] { paramString3 });
    if (com.tencent.mm.vfs.e.avI(paramString3) > 0L)
    {
      ab.i("MicroMsg.ImgInfoStorage", "genBigImg file already exist!");
      com.tencent.mm.plugin.report.service.h.qsU.cT(944, 8);
    }
    paramPString1.value = ((String)localObject);
    paramPString2.value = paramString3;
    if ((paramBoolean) && (!bo.isNullOrNil(paramString2)) && (paramInt == 0))
    {
      paramString2 = X(paramString2, paramInt);
      if (!bo.isNullOrNil(paramString2.fDM))
      {
        localObject = q(paramString2.fDM, "", "");
        if (paramb != null) {
          paramb.getFile();
        }
        com.tencent.mm.vfs.e.C((String)localObject, paramString3);
        if (com.tencent.mm.vfs.e.avI((String)localObject) > 0L)
        {
          if (!bo.isNullOrNil(paramString2.fDX))
          {
            paramString1 = paramString2.fDX;
            AppMethodBeat.o(78263);
            return paramString1;
          }
          AppMethodBeat.o(78263);
          return null;
        }
        ab.w("MicroMsg.ImgInfoStorage", "ERR: copy old match file failed ,:%s ,%s ", new Object[] { paramString1, paramString3 });
      }
    }
    label1158:
    label1217:
    label1223:
    label2378:
    label3533:
    try
    {
      if (at.isWifi(ah.getContext())) {
        i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelForWifi"), 60);
      }
      for (;;)
      {
        ab.i("MicroMsg.ImgInfoStorage", "genBigImg CompressPicLevel-level:%d", new Object[] { Integer.valueOf(i) });
        if ((i > 10) && (i <= 100)) {
          break label3550;
        }
        n = 70;
        j = 0;
        m = 0;
        k = 1080;
        i = j;
        try
        {
          if (!at.isWifi(ah.getContext())) {
            break;
          }
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressResolutionForWifi");
          i = j;
          i1 = paramString2.indexOf("*");
          if (-1 == i1) {
            break label3542;
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
          i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("UseOptImage"), 0);
          com.tencent.mm.kernel.g.RJ();
          paramString2 = new p(com.tencent.mm.kernel.a.getUin());
          if ((int)(paramString2.longValue() / 100L) % 100 + 1 > i) {
            break label3536;
          }
          bool1 = true;
          ab.i("MicroMsg.ImgInfoStorage", "fromPathToImgInfo useOpt:%b opt:%d uin:(%d,%d) debug:%b sdk:%d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Long.valueOf(paramString2.longValue()), Long.valueOf(paramString2.longValue() / 100L), Boolean.valueOf(com.tencent.mm.sdk.a.b.dsf()), Integer.valueOf(Build.VERSION.SDK_INT) });
        }
        catch (Exception paramString2)
        {
          int i7;
          int i4;
          for (;;)
          {
            ab.e("MicroMsg.ImgInfoStorage", "get useopt :%s", new Object[] { bo.l(paramString2) });
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
            break label1830;
          }
          k = ((BitmapFactory.Options)localObject).outWidth;
          if (((BitmapFactory.Options)localObject).outWidth >= ((BitmapFactory.Options)localObject).outHeight) {
            break label1840;
          }
          int i2 = ((BitmapFactory.Options)localObject).outWidth;
          if (i <= 0) {
            break label1870;
          }
          int i3 = i2 / i;
          if (((BitmapFactory.Options)localObject).outHeight <= i) {
            break label1850;
          }
          j = ((BitmapFactory.Options)localObject).outHeight * i / i2;
          if (((BitmapFactory.Options)localObject).outWidth <= i) {
            break label1860;
          }
          i = i * ((BitmapFactory.Options)localObject).outWidth / i2;
          k = i;
          i = j;
          if (i * k <= 10240000) {
            break label3523;
          }
          double d = Math.sqrt(i * k / 10240000.0D);
          j = (int)(i / d);
          k = (int)(k / d);
          ab.i("MicroMsg.ImgInfoStorage", "genBigImg [%d, %d] -> target:[h,w]:[%d,%d]", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject).outHeight), Integer.valueOf(((BitmapFactory.Options)localObject).outWidth), Integer.valueOf(j), Integer.valueOf(k) });
          if (localObject == null) {
            break label1950;
          }
          paramString2 = ((BitmapFactory.Options)localObject).outMimeType;
          long l2 = com.tencent.mm.vfs.e.avI(paramString1);
          boolean bool2 = MMNativeJpeg.IsJpegFile(paramString1);
          if ((paramString2 == null) || ((!paramString2.endsWith("jpeg")) && (!paramString2.endsWith("jpg")) && (!paramString2.endsWith("bmp")) && (!paramString2.endsWith("png")) && (!paramString2.endsWith("gif")))) {
            break label1957;
          }
          i2 = 1;
          if ((paramInt != 0) || ((m == 0) && (l2 <= 204800L) && ((localObject == null) || (i3 <= 0))) || (l2 <= i7)) {
            break label1970;
          }
          if ((i4 >= 55) && (bool2)) {
            break label3516;
          }
          paramBoolean = false;
          if (!paramBoolean) {
            break label1963;
          }
          long l1;
          long l3;
          for (i = 18;; i = 8)
          {
            l1 = bo.aoy();
            m = com.tencent.mm.sdk.platformtools.d.a(paramBoolean, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            if ((m == 1) || (!paramBoolean)) {
              break label3513;
            }
            i = 28;
            m = com.tencent.mm.sdk.platformtools.d.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, n, paramString3, paramb);
            paramBoolean = false;
            l3 = com.tencent.mm.vfs.e.avI(paramString3);
            ab.i("MicroMsg.ImgInfoStorage", "genBigImg check use orig , orig:%d aftercomp:%d diff percent:[%d] picCompressAvoidanceRemainderPerc:%d  %s ", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(100L * l3 / l2), Integer.valueOf(i1), paramString3 });
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
                com.tencent.mm.vfs.e.C(paramString1, paramString3);
                bool1 = false;
                j = 48;
                k = 1;
              }
            }
            l1 = bo.aoy() - l1;
            i = k;
            paramBoolean = bool1;
            if (k == 1) {
              break label2378;
            }
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 187L, 1L, false);
            ab.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail: %s", new Object[] { paramString1 });
            AppMethodBeat.o(78263);
            return null;
            k = ((BitmapFactory.Options)localObject).outHeight;
            break;
            i2 = ((BitmapFactory.Options)localObject).outHeight;
            break label1277;
            j = ((BitmapFactory.Options)localObject).outHeight;
            break label1312;
            i = ((BitmapFactory.Options)localObject).outWidth;
            break label1335;
            i3 = k / j;
            if (((BitmapFactory.Options)localObject).outHeight > j)
            {
              i = ((BitmapFactory.Options)localObject).outHeight * j / k;
              if (((BitmapFactory.Options)localObject).outWidth <= j) {
                break label1940;
              }
            }
            for (j = j * ((BitmapFactory.Options)localObject).outWidth / k;; j = ((BitmapFactory.Options)localObject).outWidth)
            {
              k = j;
              break;
              i = ((BitmapFactory.Options)localObject).outHeight;
              break label1900;
            }
            paramString2 = "";
            break label1448;
            i2 = 0;
            break label1517;
          }
          ab.i("MicroMsg.ImgInfoStorage", "summersafecdn createThumbNail big pic no compress, calculatedQuality:%d, origLen:%d oriWidth:%d oriHeight:%d", new Object[] { Integer.valueOf(i4), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6) });
          if (i2 == 0) {
            break label3219;
          }
          com.tencent.mm.vfs.e.C(paramString1, paramString3);
          com.tencent.mm.al.f.afO();
          if (!com.tencent.mm.al.b.lc(256)) {
            break label3392;
          }
          if (paramInt != 1) {
            break label3400;
          }
          i = 0;
          for (;;)
          {
            for (;;)
            {
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressMidPicLevel")).intValue();
                i = m;
              }
              catch (Exception paramString2)
              {
                continue;
              }
              try
              {
                m = Integer.valueOf(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressMidPicSize")).intValue();
                ab.i("MicroMsg.ImgInfoStorage", "summersafecdn CompressMidPicLevel-level:%d size:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(m) });
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
                  break label3506;
                }
                i = 800;
                if (k <= i) {
                  break label3503;
                }
                k = i;
                if (j <= i) {
                  break label3500;
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
                  paramPString3.value = ti(paramString1);
                  paramPString4.value = a(paramPString3.value, "", ".jpg", false);
                  i = com.tencent.mm.sdk.platformtools.d.a(false, paramString1, j, k, Bitmap.CompressFormat.JPEG, i1, paramPString4.value, paramb);
                  ab.d("MicroMsg.ImgInfoStorage", "summersafecdn pMidImgName[%s], pMidImgPath[%s], useOpt[%b], ret[%b] [%d, %d]", new Object[] { paramPString3.value, paramPString4.value, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
                  l1 = 0L;
                  j = 38;
                  paramBoolean = false;
                  paramString2 = com.tencent.mm.sdk.platformtools.d.aoT(paramString3);
                  if (paramString2 == null) {
                    continue;
                  }
                  k = paramString2.outWidth;
                  if (paramString2 == null) {
                    continue;
                  }
                  m = paramString2.outHeight;
                  l3 = com.tencent.mm.vfs.e.avI(paramString3);
                  i2 = MMNativeJpeg.queryQuality(paramString3);
                  boolean bool3 = MMNativeJpeg.IsJpegFile(paramString3);
                  paramString2 = com.tencent.mm.plugin.report.service.h.qsU;
                  if (!bool2) {
                    continue;
                  }
                  i1 = 1;
                  paramString2.e(11713, new Object[] { Integer.valueOf(i), Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2) });
                  ab.i("MicroMsg.ImgInfoStorage", "genBigImg ret:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                  if ((paramInt == 0) && (l3 >= 40960L) && (bool3) && (!MMNativeJpeg.isProgressive(paramString3)))
                  {
                    paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("EnableCDNUploadImg");
                    if ((!bo.isNullOrNil(paramString2)) && (paramString2.equals("1")))
                    {
                      l1 = bo.aoy();
                      if (!paramBoolean) {
                        continue;
                      }
                      j = 19;
                      paramString2 = paramString3 + ".prog";
                      com.tencent.mm.vfs.e.C(paramString3, paramString2);
                      if ((!bo.isNullOrNil(paramString2)) && (!bo.isNullOrNil(paramString3)) && (new File(paramString2).exists())) {
                        continue;
                      }
                      bool1 = false;
                      com.tencent.mm.vfs.e.deleteFile(paramString2);
                      if (bool1) {
                        break label3497;
                      }
                      bool1 = MMNativeJpeg.convertToProgressive(paramString3, n);
                      j = 29;
                      long l4 = bo.aoy();
                      long l5 = com.tencent.mm.vfs.e.avI(paramString3);
                      paramString2 = com.tencent.mm.plugin.report.service.h.qsU;
                      if (!bool1) {
                        continue;
                      }
                      n = 1;
                      if (!bool2) {
                        continue;
                      }
                      i1 = 1;
                      paramString2.e(11713, new Object[] { Integer.valueOf(n), Long.valueOf(l4 - l1), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l2), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(paramInt), Long.valueOf(l3), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i4), Integer.valueOf(i2), Long.valueOf(l5) });
                      ab.i("MicroMsg.ImgInfoStorage", "genBigImg PROGRESS ret:%d progret:%b size:%d useOpt:%b scene:%d [%d,%d,%d,%d,%b]->[%d,%d,%d,%d,%b] [%s]->[%s]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Long.valueOf(l5), Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i4), Long.valueOf(l2), Boolean.valueOf(bool2), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Long.valueOf(l3), Boolean.valueOf(bool3), paramString1, paramString3 });
                      if (!bool1)
                      {
                        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 186L, 1L, false);
                        ab.e("MicroMsg.ImgInfoStorage", "genBigImg convert to progressive failed %s", new Object[] { paramString3 });
                      }
                    }
                  }
                  AppMethodBeat.o(78263);
                  return null;
                  if (com.tencent.mm.sdk.platformtools.d.a(false, paramString1, i5, i6, Bitmap.CompressFormat.JPEG, 100, paramString3, paramb) == 1) {
                    break;
                  }
                  com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(111L, 187L, 1L, false);
                  ab.e("MicroMsg.ImgInfoStorage", "createThumbNail big pic fail (for cvrt to jpg): %s", new Object[] { paramString1 });
                  AppMethodBeat.o(78263);
                  return null;
                }
              }
              catch (Exception paramString2)
              {
                m = 0;
                continue;
                paramPString3.value = paramPString1.value;
                paramPString4.value = paramPString2.value;
                ab.d("MicroMsg.ImgInfoStorage", "summersafecdn not need to compress mid pic needCompressByQuality[%b], [%d, %d; %d, %d] use big pMidImgName[%s], pMidImgPath[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(j), Integer.valueOf(k), paramPString3.value, paramPString4.value });
                l1 = 0L;
                i = 1;
                j = 38;
                paramBoolean = false;
              }
            }
            ab.d("MicroMsg.ImgInfoStorage", "summersafecdn not use CDNNEWPROTO");
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
        if (com.tencent.mm.sdk.a.b.dsf()) {
          bool1 = true;
        }
        if (!com.tencent.mm.compatible.util.d.fw(16)) {
          break label3533;
        }
        bool1 = false;
        ab.i("MicroMsg.ImgInfoStorage", "genBigImg configLong:%d configShort:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        if ((m > 0) || (k > 0)) {
          break label1158;
        }
        j = 0;
        i = 1080;
        m = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("PicCompressAvoidanceActiveSizeNormal"), 100);
        k = m;
        if (m <= 0) {
          k = 100;
        }
        i7 = k * 1024;
        i1 = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("PicCompressAvoidanceRemainderPerc"), 10);
        if ((i1 > 0) && (i1 < 100)) {
          break label3530;
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
        ab.d("MicroMsg.ImgInfoStorage", "genBigImg insert : original img path: %s, fullpath:%s, needimg:%b,comresstype:%d Avoidance[%d,%d] ", new Object[] { paramString1, paramString3, Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Integer.valueOf(i7), Integer.valueOf(i1) });
        if (!paramBoolean) {
          break label3211;
        }
        localObject = com.tencent.mm.sdk.platformtools.d.aoT(paramString1);
        if ((localObject != null) && (((BitmapFactory.Options)localObject).outWidth != 0) && (((BitmapFactory.Options)localObject).outHeight != 0)) {
          break label1223;
        }
        if (localObject != null) {
          break label1217;
        }
        paramBoolean = true;
        ab.w("MicroMsg.ImgInfoStorage", "genBigImg getImageOptions error:%s, origOptions_null:%b", new Object[] { paramString1, Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(78263);
        return null;
        if (at.is2G(ah.getContext())) {
          i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelFor2G"), 40);
        } else if (at.is3G(ah.getContext())) {
          i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelFor3G"), 40);
        } else {
          i = bo.getInt(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressPicLevelFor4G"), 60);
        }
      }
    }
    catch (Exception paramString2)
    {
      label1870:
      label3536:
      label3542:
      label3550:
      for (;;)
      {
        int n;
        int j;
        int m;
        int k;
        int i = 0;
        continue;
        i = j;
        label1900:
        if (at.is2G(ah.getContext()))
        {
          i = j;
          paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressResolutionFor2G");
        }
        else
        {
          i = j;
          label1517:
          if (at.is3G(ah.getContext()))
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressResolutionFor3G");
          }
          else
          {
            i = j;
            paramString2 = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue("CompressResolutionFor4G");
            continue;
            label1277:
            n = i;
          }
        }
      }
    }
  }
  
  public final String a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(78212);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(78212);
      return null;
    }
    if (paramString1.startsWith("SERVERID://")) {}
    for (String str1 = paramString1.substring(11);; str1 = "") {
      for (;;)
      {
        try
        {
          str1 = gS(Long.valueOf(str1).longValue()).fDM;
          if (paramString1.startsWith("THUMBNAIL_DIRPATH://"))
          {
            paramString1 = paramString1.substring(23);
            paramString2 = "th_";
            String str3 = com.tencent.mm.plugin.i.c.YK();
            String str4 = com.tencent.mm.plugin.i.c.YL();
            String str2 = str1;
            if (bo.isNullOrNil(str1)) {
              str2 = paramString1;
            }
            paramString1 = j.b(str3, str4, paramString2, str2, paramString3, paramBoolean);
            AppMethodBeat.o(78212);
            return paramString1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString1.getMessage());
          AppMethodBeat.o(78212);
          return null;
        }
      }
    }
  }
  
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(78218);
    if (bo.ce(paramArrayOfByte))
    {
      ab.e("MicroMsg.ImgInfoStorage", "save dir thumb error, thumbBuf is null");
      AppMethodBeat.o(78218);
      return null;
    }
    String str1 = ahn();
    String str2 = q(str1, "th_", "");
    ab.d("MicroMsg.ImgInfoStorage", "saveDirThumb, fullPath = %s", new Object[] { str2 });
    try
    {
      com.tencent.mm.sdk.platformtools.d.a(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length), 100, paramCompressFormat, str2, true);
      paramArrayOfByte = "THUMBNAIL_DIRPATH://th_".concat(String.valueOf(str1));
      AppMethodBeat.o(78218);
      return paramArrayOfByte;
    }
    catch (IOException localIOException)
    {
      ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localIOException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(78218);
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ImgInfoStorage", "save bitmap to image error, %s", new Object[] { localException });
      paramArrayOfByte = a(paramArrayOfByte, true, paramCompressFormat);
      AppMethodBeat.o(78218);
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1410
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 937	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 238
    //   15: ldc_w 939
    //   18: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1410
    //   24: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   32: lstore 10
    //   34: invokestatic 579	com/tencent/mm/at/g:ahn	()Ljava/lang/String;
    //   37: astore 16
    //   39: aload_0
    //   40: aload 16
    //   42: ldc_w 586
    //   45: ldc_w 424
    //   48: invokevirtual 593	com/tencent/mm/at/g:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 17
    //   53: new 416	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   60: aload 17
    //   62: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 1412
    //   68: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 15
    //   76: ldc 238
    //   78: ldc_w 962
    //   81: aload 17
    //   83: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 584	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: arraylength
    //   94: istore 9
    //   96: new 941	android/graphics/BitmapFactory$Options
    //   99: dup
    //   100: invokespecial 942	android/graphics/BitmapFactory$Options:<init>	()V
    //   103: astore 18
    //   105: aload 18
    //   107: iconst_1
    //   108: putfield 946	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: aload_1
    //   112: iconst_0
    //   113: aload_1
    //   114: arraylength
    //   115: aload 18
    //   117: invokestatic 1413	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   120: pop
    //   121: aconst_null
    //   122: astore 13
    //   124: aload 15
    //   126: iconst_0
    //   127: invokestatic 1417	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   130: astore 12
    //   132: aload 12
    //   134: astore 13
    //   136: aload 12
    //   138: aload_1
    //   139: invokevirtual 1422	java/io/OutputStream:write	([B)V
    //   142: aload 12
    //   144: astore 13
    //   146: aload 12
    //   148: invokevirtual 1425	java/io/OutputStream:flush	()V
    //   151: aload 12
    //   153: astore 13
    //   155: aload_1
    //   156: iload_3
    //   157: iload 4
    //   159: invokestatic 1426	com/tencent/mm/sdk/platformtools/d:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   162: astore 19
    //   164: aload 12
    //   166: astore 13
    //   168: aload_1
    //   169: arraylength
    //   170: istore 8
    //   172: aload 19
    //   174: ifnull +319 -> 493
    //   177: bipush 100
    //   179: istore 7
    //   181: aload 12
    //   183: astore 13
    //   185: aload_1
    //   186: arraylength
    //   187: istore_3
    //   188: iload_3
    //   189: ldc_w 1427
    //   192: if_icmple +529 -> 721
    //   195: new 1429	java/io/ByteArrayOutputStream
    //   198: dup
    //   199: invokespecial 1430	java/io/ByteArrayOutputStream:<init>	()V
    //   202: astore 14
    //   204: aload 14
    //   206: astore 13
    //   208: aload 19
    //   210: aload_2
    //   211: bipush 100
    //   213: aload 14
    //   215: invokevirtual 1434	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   218: pop
    //   219: aload 14
    //   221: astore 13
    //   223: aload 14
    //   225: invokevirtual 1437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   228: arraylength
    //   229: istore 4
    //   231: bipush 100
    //   233: istore_3
    //   234: aload 14
    //   236: astore 13
    //   238: iload_3
    //   239: istore 7
    //   241: aload 14
    //   243: invokevirtual 1437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   246: arraylength
    //   247: ldc_w 1427
    //   250: if_icmple +64 -> 314
    //   253: iload_3
    //   254: bipush 15
    //   256: if_icmplt +58 -> 314
    //   259: aload 14
    //   261: astore 13
    //   263: iload_3
    //   264: istore 7
    //   266: aload 14
    //   268: invokevirtual 1440	java/io/ByteArrayOutputStream:reset	()V
    //   271: iload_3
    //   272: iconst_5
    //   273: isub
    //   274: istore_3
    //   275: aload 14
    //   277: astore 13
    //   279: iload_3
    //   280: istore 7
    //   282: aload 19
    //   284: aload_2
    //   285: iload_3
    //   286: aload 14
    //   288: invokevirtual 1434	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   291: pop
    //   292: aload 14
    //   294: astore 13
    //   296: iload_3
    //   297: istore 7
    //   299: aload 14
    //   301: invokevirtual 1437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   304: arraylength
    //   305: istore 8
    //   307: iload 8
    //   309: istore 4
    //   311: goto -77 -> 234
    //   314: aload 12
    //   316: astore 13
    //   318: aload 14
    //   320: invokevirtual 1441	java/io/ByteArrayOutputStream:close	()V
    //   323: aload 12
    //   325: astore 13
    //   327: aload 19
    //   329: iload_3
    //   330: aload_2
    //   331: aload 17
    //   333: iconst_1
    //   334: invokestatic 347	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   337: aload 12
    //   339: astore 13
    //   341: ldc 238
    //   343: ldc_w 1443
    //   346: iconst_3
    //   347: anewarray 94	java/lang/Object
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
    //   363: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: aastore
    //   367: invokestatic 260	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: aload 12
    //   372: astore 13
    //   374: getstatic 604	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   377: sipush 16498
    //   380: bipush 10
    //   382: anewarray 94	java/lang/Object
    //   385: dup
    //   386: iconst_0
    //   387: aload 5
    //   389: invokestatic 1446	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   392: ldc_w 1448
    //   395: invokestatic 1454	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   398: aastore
    //   399: dup
    //   400: iconst_1
    //   401: iload 6
    //   403: invokestatic 250	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   406: aastore
    //   407: dup
    //   408: iconst_2
    //   409: iload 9
    //   411: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: dup
    //   416: iconst_3
    //   417: aload 18
    //   419: getfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   422: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: aastore
    //   426: dup
    //   427: iconst_4
    //   428: aload 18
    //   430: getfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   433: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   436: aastore
    //   437: dup
    //   438: iconst_5
    //   439: iload 4
    //   441: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   444: aastore
    //   445: dup
    //   446: bipush 6
    //   448: aload 19
    //   450: invokevirtual 308	android/graphics/Bitmap:getHeight	()I
    //   453: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   456: aastore
    //   457: dup
    //   458: bipush 7
    //   460: aload 19
    //   462: invokevirtual 300	android/graphics/Bitmap:getWidth	()I
    //   465: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: dup
    //   470: bipush 8
    //   472: iconst_0
    //   473: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: dup
    //   478: bipush 9
    //   480: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   483: lload 10
    //   485: lsub
    //   486: invokestatic 609	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   489: aastore
    //   490: invokevirtual 616	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   493: aload 15
    //   495: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   498: ifeq +17 -> 515
    //   501: ldc 238
    //   503: ldc_w 1456
    //   506: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload 15
    //   511: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   514: pop
    //   515: aload 12
    //   517: ifnull +8 -> 525
    //   520: aload 12
    //   522: invokevirtual 1457	java/io/OutputStream:close	()V
    //   525: ldc_w 581
    //   528: aload 16
    //   530: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   533: invokevirtual 584	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   536: astore_1
    //   537: ldc_w 1410
    //   540: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: aload_1
    //   544: areturn
    //   545: astore 13
    //   547: goto -224 -> 323
    //   550: astore 13
    //   552: aconst_null
    //   553: astore 14
    //   555: aload 14
    //   557: astore 13
    //   559: ldc 238
    //   561: ldc_w 1459
    //   564: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   567: iload 7
    //   569: istore_3
    //   570: iload 8
    //   572: istore 4
    //   574: aload 14
    //   576: ifnull -253 -> 323
    //   579: aload 12
    //   581: astore 13
    //   583: aload 14
    //   585: invokevirtual 1441	java/io/ByteArrayOutputStream:close	()V
    //   588: iload 7
    //   590: istore_3
    //   591: iload 8
    //   593: istore 4
    //   595: goto -272 -> 323
    //   598: astore 13
    //   600: iload 7
    //   602: istore_3
    //   603: iload 8
    //   605: istore 4
    //   607: goto -284 -> 323
    //   610: astore 5
    //   612: aconst_null
    //   613: astore 14
    //   615: aload 14
    //   617: ifnull +12 -> 629
    //   620: aload 12
    //   622: astore 13
    //   624: aload 14
    //   626: invokevirtual 1441	java/io/ByteArrayOutputStream:close	()V
    //   629: aload 12
    //   631: astore 13
    //   633: ldc_w 1410
    //   636: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   639: aload 12
    //   641: astore 13
    //   643: aload 5
    //   645: athrow
    //   646: astore 13
    //   648: aload 12
    //   650: astore 5
    //   652: aload 13
    //   654: astore 12
    //   656: ldc 238
    //   658: ldc_w 1405
    //   661: iconst_1
    //   662: anewarray 94	java/lang/Object
    //   665: dup
    //   666: iconst_0
    //   667: aload 12
    //   669: aastore
    //   670: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: aload_0
    //   674: aload_1
    //   675: iconst_1
    //   676: aload_2
    //   677: invokevirtual 1408	com/tencent/mm/at/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   680: astore_1
    //   681: aload 15
    //   683: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   686: ifeq +17 -> 703
    //   689: ldc 238
    //   691: ldc_w 1456
    //   694: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 15
    //   699: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   702: pop
    //   703: aload 5
    //   705: ifnull +8 -> 713
    //   708: aload 5
    //   710: invokevirtual 1457	java/io/OutputStream:close	()V
    //   713: ldc_w 1410
    //   716: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   719: aload_1
    //   720: areturn
    //   721: aload 12
    //   723: astore 13
    //   725: aload 15
    //   727: aload 17
    //   729: invokestatic 1462	com/tencent/mm/vfs/e:aT	(Ljava/lang/String;Ljava/lang/String;)Z
    //   732: pop
    //   733: iload 7
    //   735: istore_3
    //   736: iload 8
    //   738: istore 4
    //   740: goto -403 -> 337
    //   743: astore 5
    //   745: aload 12
    //   747: astore 13
    //   749: ldc 238
    //   751: ldc_w 1405
    //   754: iconst_1
    //   755: anewarray 94	java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: aload 5
    //   762: aastore
    //   763: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   766: aload 12
    //   768: astore 13
    //   770: aload_0
    //   771: aload_1
    //   772: iconst_1
    //   773: aload_2
    //   774: invokevirtual 1408	com/tencent/mm/at/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   777: astore_1
    //   778: aload 15
    //   780: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   783: ifeq +17 -> 800
    //   786: ldc 238
    //   788: ldc_w 1456
    //   791: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   794: aload 15
    //   796: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   799: pop
    //   800: aload 12
    //   802: ifnull +8 -> 810
    //   805: aload 12
    //   807: invokevirtual 1457	java/io/OutputStream:close	()V
    //   810: ldc_w 1410
    //   813: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   816: aload_1
    //   817: areturn
    //   818: astore_1
    //   819: aconst_null
    //   820: astore 13
    //   822: aload 15
    //   824: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   827: ifeq +17 -> 844
    //   830: ldc 238
    //   832: ldc_w 1456
    //   835: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   838: aload 15
    //   840: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   843: pop
    //   844: aload 13
    //   846: ifnull +8 -> 854
    //   849: aload 13
    //   851: invokevirtual 1457	java/io/OutputStream:close	()V
    //   854: ldc_w 1410
    //   857: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   179	555	7	i	int
    //   170	761	8	j	int
    //   94	316	9	k	int
    //   32	452	10	l	long
    //   130	769	12	localObject1	Object
    //   903	1	12	localIOException1	IOException
    //   122	251	13	localObject2	Object
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
    //   202	715	14	localObject6	Object
    //   74	765	15	str2	String
    //   37	492	16	str3	String
    //   51	677	17	str4	String
    //   103	326	18	localOptions	BitmapFactory.Options
    //   162	299	19	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   318	323	545	java/lang/Exception
    //   195	204	550	java/lang/Exception
    //   583	588	598	java/lang/Exception
    //   195	204	610	finally
    //   136	142	646	java/io/IOException
    //   146	151	646	java/io/IOException
    //   155	164	646	java/io/IOException
    //   168	172	646	java/io/IOException
    //   185	188	646	java/io/IOException
    //   318	323	646	java/io/IOException
    //   327	337	646	java/io/IOException
    //   341	370	646	java/io/IOException
    //   374	493	646	java/io/IOException
    //   583	588	646	java/io/IOException
    //   624	629	646	java/io/IOException
    //   633	639	646	java/io/IOException
    //   643	646	646	java/io/IOException
    //   725	733	646	java/io/IOException
    //   136	142	743	java/lang/Exception
    //   146	151	743	java/lang/Exception
    //   155	164	743	java/lang/Exception
    //   168	172	743	java/lang/Exception
    //   185	188	743	java/lang/Exception
    //   327	337	743	java/lang/Exception
    //   341	370	743	java/lang/Exception
    //   374	493	743	java/lang/Exception
    //   633	639	743	java/lang/Exception
    //   643	646	743	java/lang/Exception
    //   725	733	743	java/lang/Exception
    //   124	132	818	finally
    //   624	629	862	java/lang/Exception
    //   520	525	867	java/lang/Exception
    //   708	713	871	java/lang/Exception
    //   805	810	875	java/lang/Exception
    //   849	854	879	java/lang/Exception
    //   136	142	883	finally
    //   146	151	883	finally
    //   155	164	883	finally
    //   168	172	883	finally
    //   185	188	883	finally
    //   318	323	883	finally
    //   327	337	883	finally
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
    //   124	132	895	java/lang/Exception
    //   124	132	903	java/io/IOException
    //   208	219	912	finally
    //   223	231	912	finally
    //   241	253	912	finally
    //   266	271	912	finally
    //   282	292	912	finally
    //   299	307	912	finally
    //   559	567	912	finally
    //   208	219	921	java/lang/Exception
    //   223	231	921	java/lang/Exception
    //   241	253	926	java/lang/Exception
    //   266	271	926	java/lang/Exception
    //   282	292	926	java/lang/Exception
    //   299	307	926	java/lang/Exception
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, Bitmap.CompressFormat paramCompressFormat, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1464
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 937	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 238
    //   15: ldc_w 939
    //   18: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1464
    //   24: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   32: lstore 10
    //   34: invokestatic 579	com/tencent/mm/at/g:ahn	()Ljava/lang/String;
    //   37: astore 17
    //   39: aload_0
    //   40: aload 17
    //   42: ldc_w 586
    //   45: ldc_w 424
    //   48: invokevirtual 593	com/tencent/mm/at/g:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: astore 19
    //   53: new 416	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   60: aload 19
    //   62: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: ldc_w 1412
    //   68: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 16
    //   76: ldc 238
    //   78: ldc_w 962
    //   81: aload 19
    //   83: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 584	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload_1
    //   93: arraylength
    //   94: istore 9
    //   96: new 941	android/graphics/BitmapFactory$Options
    //   99: dup
    //   100: invokespecial 942	android/graphics/BitmapFactory$Options:<init>	()V
    //   103: astore 18
    //   105: aload 18
    //   107: iconst_1
    //   108: putfield 946	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   111: aload_1
    //   112: iconst_0
    //   113: aload_1
    //   114: arraylength
    //   115: aload 18
    //   117: invokestatic 1413	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   120: pop
    //   121: aload 18
    //   123: getfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   126: istore 7
    //   128: aload 18
    //   130: getfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   133: istore 6
    //   135: sipush 720
    //   138: iload 7
    //   140: if_icmpgt +13 -> 153
    //   143: ldc_w 1465
    //   146: iload 6
    //   148: i2f
    //   149: fcmpl
    //   150: ifle +283 -> 433
    //   153: iload 7
    //   155: istore 5
    //   157: aconst_null
    //   158: astore 13
    //   160: aload 16
    //   162: iconst_0
    //   163: invokestatic 1417	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   166: astore 12
    //   168: aload 12
    //   170: astore 13
    //   172: aload 12
    //   174: aload_1
    //   175: invokevirtual 1422	java/io/OutputStream:write	([B)V
    //   178: aload 12
    //   180: astore 13
    //   182: aload 12
    //   184: invokevirtual 1425	java/io/OutputStream:flush	()V
    //   187: aload 12
    //   189: astore 13
    //   191: aload_1
    //   192: iload 5
    //   194: iload 6
    //   196: invokestatic 1426	com/tencent/mm/sdk/platformtools/d:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   199: astore 14
    //   201: aload 12
    //   203: astore 13
    //   205: iload 5
    //   207: aload 14
    //   209: invokevirtual 300	android/graphics/Bitmap:getWidth	()I
    //   212: if_icmpeq +240 -> 452
    //   215: aload 12
    //   217: astore 13
    //   219: aload 14
    //   221: iload 5
    //   223: iload 6
    //   225: iconst_1
    //   226: invokestatic 402	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   229: astore 14
    //   231: aload 12
    //   233: astore 13
    //   235: aload 14
    //   237: invokevirtual 308	android/graphics/Bitmap:getHeight	()I
    //   240: i2f
    //   241: aload 14
    //   243: invokevirtual 300	android/graphics/Bitmap:getWidth	()I
    //   246: i2f
    //   247: ldc_w 1466
    //   250: fmul
    //   251: fcmpl
    //   252: ifle +203 -> 455
    //   255: aload 12
    //   257: astore 13
    //   259: aload 14
    //   261: iconst_0
    //   262: iconst_0
    //   263: aload 14
    //   265: invokevirtual 300	android/graphics/Bitmap:getWidth	()I
    //   268: aload 14
    //   270: invokevirtual 300	android/graphics/Bitmap:getWidth	()I
    //   273: i2f
    //   274: ldc_w 1466
    //   277: fmul
    //   278: f2i
    //   279: invokestatic 1470	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   282: astore 15
    //   284: aload 12
    //   286: astore 13
    //   288: aload_1
    //   289: arraylength
    //   290: istore 6
    //   292: aload 15
    //   294: ifnull +403 -> 697
    //   297: bipush 70
    //   299: istore 5
    //   301: new 1429	java/io/ByteArrayOutputStream
    //   304: dup
    //   305: invokespecial 1430	java/io/ByteArrayOutputStream:<init>	()V
    //   308: astore 14
    //   310: aload 14
    //   312: astore 13
    //   314: aload 15
    //   316: aload_2
    //   317: bipush 70
    //   319: aload 14
    //   321: invokevirtual 1434	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   324: pop
    //   325: aload 14
    //   327: astore 13
    //   329: aload 14
    //   331: invokevirtual 1437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   334: arraylength
    //   335: istore 7
    //   337: bipush 70
    //   339: istore 5
    //   341: iload 7
    //   343: istore 6
    //   345: aload 14
    //   347: astore 13
    //   349: iload 5
    //   351: istore 7
    //   353: aload 14
    //   355: invokevirtual 1437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   358: arraylength
    //   359: ldc_w 1427
    //   362: if_icmple +125 -> 487
    //   365: iload 5
    //   367: bipush 15
    //   369: if_icmplt +118 -> 487
    //   372: aload 14
    //   374: astore 13
    //   376: iload 5
    //   378: istore 7
    //   380: aload 14
    //   382: invokevirtual 1440	java/io/ByteArrayOutputStream:reset	()V
    //   385: iload 5
    //   387: iconst_5
    //   388: isub
    //   389: istore 5
    //   391: aload 14
    //   393: astore 13
    //   395: iload 5
    //   397: istore 7
    //   399: aload 15
    //   401: aload_2
    //   402: iload 5
    //   404: aload 14
    //   406: invokevirtual 1434	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   409: pop
    //   410: aload 14
    //   412: astore 13
    //   414: iload 5
    //   416: istore 7
    //   418: aload 14
    //   420: invokevirtual 1437	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   423: arraylength
    //   424: istore 8
    //   426: iload 8
    //   428: istore 6
    //   430: goto -85 -> 345
    //   433: sipush 720
    //   436: istore 5
    //   438: iload 6
    //   440: sipush 720
    //   443: imul
    //   444: iload 7
    //   446: idiv
    //   447: istore 6
    //   449: goto -292 -> 157
    //   452: goto -221 -> 231
    //   455: aload 12
    //   457: astore 13
    //   459: aload 14
    //   461: iconst_0
    //   462: iconst_0
    //   463: aload 14
    //   465: invokevirtual 308	android/graphics/Bitmap:getHeight	()I
    //   468: i2f
    //   469: ldc_w 1466
    //   472: fdiv
    //   473: f2i
    //   474: aload 14
    //   476: invokevirtual 308	android/graphics/Bitmap:getHeight	()I
    //   479: invokestatic 1470	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   482: astore 15
    //   484: goto -200 -> 284
    //   487: aload 12
    //   489: astore 13
    //   491: aload 14
    //   493: invokevirtual 1441	java/io/ByteArrayOutputStream:close	()V
    //   496: iload 6
    //   498: istore 8
    //   500: iload 5
    //   502: istore 7
    //   504: aload 12
    //   506: astore 13
    //   508: aload 15
    //   510: iload 7
    //   512: aload_2
    //   513: aload 19
    //   515: iconst_1
    //   516: invokestatic 347	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   519: aload 12
    //   521: astore 13
    //   523: ldc 238
    //   525: ldc_w 1443
    //   528: iconst_3
    //   529: anewarray 94	java/lang/Object
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
    //   546: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   549: aastore
    //   550: invokestatic 260	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   553: aload 12
    //   555: astore 13
    //   557: getstatic 604	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   560: astore 14
    //   562: aload 12
    //   564: astore 13
    //   566: aload_3
    //   567: invokestatic 1446	com/tencent/mm/sdk/platformtools/bo:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   570: ldc_w 1448
    //   573: invokestatic 1454	com/tencent/mm/compatible/util/q:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   596: anewarray 94	java/lang/Object
    //   599: dup
    //   600: iconst_0
    //   601: aload_3
    //   602: aastore
    //   603: dup
    //   604: iconst_1
    //   605: iload 5
    //   607: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aastore
    //   611: dup
    //   612: iconst_2
    //   613: iload 9
    //   615: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: aastore
    //   619: dup
    //   620: iconst_3
    //   621: aload 18
    //   623: getfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   626: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   629: aastore
    //   630: dup
    //   631: iconst_4
    //   632: aload 18
    //   634: getfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   637: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: aastore
    //   641: dup
    //   642: iconst_5
    //   643: iload 8
    //   645: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   648: aastore
    //   649: dup
    //   650: bipush 6
    //   652: aload 15
    //   654: invokevirtual 308	android/graphics/Bitmap:getHeight	()I
    //   657: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: aastore
    //   661: dup
    //   662: bipush 7
    //   664: aload 15
    //   666: invokevirtual 300	android/graphics/Bitmap:getWidth	()I
    //   669: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   672: aastore
    //   673: dup
    //   674: bipush 8
    //   676: iconst_1
    //   677: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   680: aastore
    //   681: dup
    //   682: bipush 9
    //   684: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   687: lload 10
    //   689: lsub
    //   690: invokestatic 609	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   693: aastore
    //   694: invokevirtual 616	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   697: aload 16
    //   699: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   702: ifeq +17 -> 719
    //   705: ldc 238
    //   707: ldc_w 1456
    //   710: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: aload 16
    //   715: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   718: pop
    //   719: aload 12
    //   721: ifnull +8 -> 729
    //   724: aload 12
    //   726: invokevirtual 1457	java/io/OutputStream:close	()V
    //   729: ldc_w 581
    //   732: aload 17
    //   734: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   737: invokevirtual 584	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   740: astore_1
    //   741: ldc_w 1464
    //   744: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   747: aload_1
    //   748: areturn
    //   749: astore 13
    //   751: iload 5
    //   753: istore 7
    //   755: iload 6
    //   757: istore 8
    //   759: goto -255 -> 504
    //   762: astore 13
    //   764: aconst_null
    //   765: astore 14
    //   767: aload 14
    //   769: astore 13
    //   771: ldc 238
    //   773: ldc_w 1459
    //   776: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   779: iload 5
    //   781: istore 7
    //   783: iload 6
    //   785: istore 8
    //   787: aload 14
    //   789: ifnull -285 -> 504
    //   792: aload 12
    //   794: astore 13
    //   796: aload 14
    //   798: invokevirtual 1441	java/io/ByteArrayOutputStream:close	()V
    //   801: iload 5
    //   803: istore 7
    //   805: iload 6
    //   807: istore 8
    //   809: goto -305 -> 504
    //   812: astore 13
    //   814: iload 5
    //   816: istore 7
    //   818: iload 6
    //   820: istore 8
    //   822: goto -318 -> 504
    //   825: astore_3
    //   826: aconst_null
    //   827: astore 14
    //   829: aload 14
    //   831: ifnull +12 -> 843
    //   834: aload 12
    //   836: astore 13
    //   838: aload 14
    //   840: invokevirtual 1441	java/io/ByteArrayOutputStream:close	()V
    //   843: aload 12
    //   845: astore 13
    //   847: ldc_w 1464
    //   850: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   853: aload 12
    //   855: astore 13
    //   857: aload_3
    //   858: athrow
    //   859: astore 13
    //   861: aload 12
    //   863: astore_3
    //   864: aload 13
    //   866: astore 12
    //   868: ldc 238
    //   870: ldc_w 1405
    //   873: iconst_1
    //   874: anewarray 94	java/lang/Object
    //   877: dup
    //   878: iconst_0
    //   879: aload 12
    //   881: aastore
    //   882: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   885: aload_0
    //   886: aload_1
    //   887: iconst_1
    //   888: aload_2
    //   889: invokevirtual 1408	com/tencent/mm/at/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   892: astore_1
    //   893: aload 16
    //   895: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   898: ifeq +17 -> 915
    //   901: ldc 238
    //   903: ldc_w 1456
    //   906: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   909: aload 16
    //   911: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   914: pop
    //   915: aload_3
    //   916: ifnull +7 -> 923
    //   919: aload_3
    //   920: invokevirtual 1457	java/io/OutputStream:close	()V
    //   923: ldc_w 1464
    //   926: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   945: ldc 238
    //   947: ldc_w 1405
    //   950: iconst_1
    //   951: anewarray 94	java/lang/Object
    //   954: dup
    //   955: iconst_0
    //   956: aload_3
    //   957: aastore
    //   958: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   961: aload 12
    //   963: astore 13
    //   965: aload_0
    //   966: aload_1
    //   967: iconst_1
    //   968: aload_2
    //   969: invokevirtual 1408	com/tencent/mm/at/g:a	([BZLandroid/graphics/Bitmap$CompressFormat;)Ljava/lang/String;
    //   972: astore_1
    //   973: aload 16
    //   975: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   978: ifeq +17 -> 995
    //   981: ldc 238
    //   983: ldc_w 1456
    //   986: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   989: aload 16
    //   991: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   994: pop
    //   995: aload 12
    //   997: ifnull +8 -> 1005
    //   1000: aload 12
    //   1002: invokevirtual 1457	java/io/OutputStream:close	()V
    //   1005: ldc_w 1464
    //   1008: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1011: aload_1
    //   1012: areturn
    //   1013: astore_1
    //   1014: aconst_null
    //   1015: astore 13
    //   1017: aload 16
    //   1019: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   1022: ifeq +17 -> 1039
    //   1025: ldc 238
    //   1027: ldc_w 1456
    //   1030: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aload 16
    //   1035: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   1038: pop
    //   1039: aload 13
    //   1041: ifnull +8 -> 1049
    //   1044: aload 13
    //   1046: invokevirtual 1457	java/io/OutputStream:close	()V
    //   1049: ldc_w 1464
    //   1052: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   155	964	5	i	int
    //   133	686	6	j	int
    //   126	991	7	k	int
    //   424	397	8	m	int
    //   94	520	9	n	int
    //   32	656	10	l	long
    //   166	835	12	localObject1	Object
    //   1093	1	12	localIOException1	IOException
    //   158	430	13	localObject2	Object
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
    //   199	906	14	localObject6	Object
    //   282	383	15	localBitmap	Bitmap
    //   74	960	16	str2	String
    //   37	696	17	str3	String
    //   103	530	18	localOptions	BitmapFactory.Options
    //   51	489	19	str4	String
    // Exception table:
    //   from	to	target	type
    //   491	496	749	java/lang/Exception
    //   301	310	762	java/lang/Exception
    //   796	801	812	java/lang/Exception
    //   301	310	825	finally
    //   172	178	859	java/io/IOException
    //   182	187	859	java/io/IOException
    //   191	201	859	java/io/IOException
    //   205	215	859	java/io/IOException
    //   219	231	859	java/io/IOException
    //   235	255	859	java/io/IOException
    //   259	284	859	java/io/IOException
    //   288	292	859	java/io/IOException
    //   459	484	859	java/io/IOException
    //   491	496	859	java/io/IOException
    //   508	519	859	java/io/IOException
    //   523	553	859	java/io/IOException
    //   557	562	859	java/io/IOException
    //   566	577	859	java/io/IOException
    //   589	697	859	java/io/IOException
    //   796	801	859	java/io/IOException
    //   838	843	859	java/io/IOException
    //   847	853	859	java/io/IOException
    //   857	859	859	java/io/IOException
    //   160	168	937	java/lang/Exception
    //   160	168	1013	finally
    //   838	843	1057	java/lang/Exception
    //   724	729	1062	java/lang/Exception
    //   919	923	1066	java/lang/Exception
    //   1000	1005	1070	java/lang/Exception
    //   1044	1049	1074	java/lang/Exception
    //   172	178	1078	finally
    //   182	187	1078	finally
    //   191	201	1078	finally
    //   205	215	1078	finally
    //   219	231	1078	finally
    //   235	255	1078	finally
    //   259	284	1078	finally
    //   288	292	1078	finally
    //   459	484	1078	finally
    //   491	496	1078	finally
    //   508	519	1078	finally
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
    //   172	178	1089	java/lang/Exception
    //   182	187	1089	java/lang/Exception
    //   191	201	1089	java/lang/Exception
    //   205	215	1089	java/lang/Exception
    //   219	231	1089	java/lang/Exception
    //   235	255	1089	java/lang/Exception
    //   259	284	1089	java/lang/Exception
    //   288	292	1089	java/lang/Exception
    //   459	484	1089	java/lang/Exception
    //   508	519	1089	java/lang/Exception
    //   523	553	1089	java/lang/Exception
    //   557	562	1089	java/lang/Exception
    //   566	577	1089	java/lang/Exception
    //   589	697	1089	java/lang/Exception
    //   847	853	1089	java/lang/Exception
    //   857	859	1089	java/lang/Exception
    //   160	168	1093	java/io/IOException
    //   314	325	1101	finally
    //   329	337	1101	finally
    //   353	365	1101	finally
    //   380	385	1101	finally
    //   399	410	1101	finally
    //   418	426	1101	finally
    //   771	779	1101	finally
    //   314	325	1109	java/lang/Exception
    //   329	337	1109	java/lang/Exception
    //   353	365	1114	java/lang/Exception
    //   380	385	1114	java/lang/Exception
    //   399	410	1114	java/lang/Exception
    //   418	426	1114	java/lang/Exception
  }
  
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean, Bitmap.CompressFormat paramCompressFormat)
  {
    AppMethodBeat.i(78217);
    paramArrayOfByte = a(paramArrayOfByte, paramBoolean, paramCompressFormat, false);
    AppMethodBeat.o(78217);
    return paramArrayOfByte;
  }
  
  /* Error */
  public final String a(byte[] paramArrayOfByte, boolean paramBoolean1, Bitmap.CompressFormat paramCompressFormat, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc_w 1475
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 937	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   10: ifeq +19 -> 29
    //   13: ldc 238
    //   15: ldc_w 939
    //   18: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 1475
    //   24: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aconst_null
    //   28: areturn
    //   29: invokestatic 579	com/tencent/mm/at/g:ahn	()Ljava/lang/String;
    //   32: astore 9
    //   34: aload_0
    //   35: aload 9
    //   37: ldc_w 586
    //   40: ldc_w 424
    //   43: invokevirtual 593	com/tencent/mm/at/g:q	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 10
    //   48: new 416	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   55: aload 10
    //   57: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 1412
    //   63: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore 8
    //   71: ldc 238
    //   73: ldc_w 962
    //   76: aload 10
    //   78: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 584	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 8
    //   89: iconst_0
    //   90: invokestatic 1417	com/tencent/mm/vfs/e:M	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   93: astore 7
    //   95: aload 7
    //   97: aload_1
    //   98: invokevirtual 1422	java/io/OutputStream:write	([B)V
    //   101: aload 7
    //   103: invokevirtual 1425	java/io/OutputStream:flush	()V
    //   106: iload_2
    //   107: ifeq +111 -> 218
    //   110: sipush 128
    //   113: istore 5
    //   115: goto +293 -> 408
    //   118: iload 4
    //   120: ifeq +112 -> 232
    //   123: aload 8
    //   125: aconst_null
    //   126: invokestatic 1479	com/tencent/mm/sdk/platformtools/d:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +35 -> 166
    //   134: aload_1
    //   135: bipush 90
    //   137: aload_3
    //   138: aload 10
    //   140: iconst_1
    //   141: invokestatic 347	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   144: ldc 238
    //   146: ldc_w 1481
    //   149: iconst_2
    //   150: anewarray 94	java/lang/Object
    //   153: dup
    //   154: iconst_0
    //   155: aload 8
    //   157: aastore
    //   158: dup
    //   159: iconst_1
    //   160: aload 10
    //   162: aastore
    //   163: invokestatic 260	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload 8
    //   168: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   171: ifeq +17 -> 188
    //   174: ldc 238
    //   176: ldc_w 1456
    //   179: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 8
    //   184: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   187: pop
    //   188: aload 7
    //   190: ifnull +8 -> 198
    //   193: aload 7
    //   195: invokevirtual 1457	java/io/OutputStream:close	()V
    //   198: ldc_w 581
    //   201: aload 9
    //   203: invokestatic 184	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   206: invokevirtual 584	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore_1
    //   210: ldc_w 1475
    //   213: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload_1
    //   217: areturn
    //   218: bipush 120
    //   220: istore 5
    //   222: goto +186 -> 408
    //   225: bipush 120
    //   227: istore 6
    //   229: goto -111 -> 118
    //   232: aload 8
    //   234: iload 5
    //   236: iload 6
    //   238: iconst_0
    //   239: invokestatic 1484	com/tencent/mm/sdk/platformtools/d:d	(Ljava/lang/String;IIZ)Landroid/graphics/Bitmap;
    //   242: astore_1
    //   243: goto -113 -> 130
    //   246: astore_3
    //   247: aconst_null
    //   248: astore_1
    //   249: getstatic 604	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   252: ldc2_w 1116
    //   255: ldc2_w 1485
    //   258: lconst_1
    //   259: iconst_0
    //   260: invokevirtual 1123	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   263: ldc 238
    //   265: new 416	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 1488
    //   272: invokespecial 558	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload 9
    //   277: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: ldc_w 1490
    //   283: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload_3
    //   287: invokevirtual 1130	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 622	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload 8
    //   301: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   304: ifeq +17 -> 321
    //   307: ldc 238
    //   309: ldc_w 1456
    //   312: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload 8
    //   317: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   320: pop
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 1457	java/io/OutputStream:close	()V
    //   329: ldc_w 1475
    //   332: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aconst_null
    //   336: areturn
    //   337: astore_3
    //   338: aconst_null
    //   339: astore_1
    //   340: aload 8
    //   342: invokestatic 232	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   345: ifeq +17 -> 362
    //   348: ldc 238
    //   350: ldc_w 1456
    //   353: invokestatic 564	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 8
    //   358: invokestatic 965	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   361: pop
    //   362: aload_1
    //   363: ifnull +7 -> 370
    //   366: aload_1
    //   367: invokevirtual 1457	java/io/OutputStream:close	()V
    //   370: ldc_w 1475
    //   373: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   417: goto -299 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	g
    //   0	420	1	paramArrayOfByte	byte[]
    //   0	420	2	paramBoolean1	boolean
    //   0	420	3	paramCompressFormat	Bitmap.CompressFormat
    //   0	420	4	paramBoolean2	boolean
    //   113	122	5	i	int
    //   227	189	6	j	int
    //   93	310	7	localOutputStream	java.io.OutputStream
    //   69	288	8	str1	String
    //   32	244	9	str2	String
    //   46	115	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   87	95	246	java/lang/Exception
    //   87	95	337	finally
    //   193	198	378	java/lang/Exception
    //   325	329	382	java/lang/Exception
    //   366	370	386	java/lang/Exception
    //   95	106	390	finally
    //   123	130	390	finally
    //   134	166	390	finally
    //   232	243	390	finally
    //   249	299	397	finally
    //   95	106	401	java/lang/Exception
    //   123	130	401	java/lang/Exception
    //   134	166	401	java/lang/Exception
    //   232	243	401	java/lang/Exception
  }
  
  public final HashMap<Long, e> a(Long... paramVarArgs)
  {
    AppMethodBeat.i(78243);
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
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).cFn), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(78243);
    return localObject1;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, float paramFloat, int paramInt1, int paramInt2, ImageView paramImageView2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(78226);
    boolean bool = a(paramImageView1, paramString, false, paramFloat, paramInt1, paramInt2, paramImageView2, paramInt3, paramInt4, paramView);
    AppMethodBeat.o(78226);
    return bool;
  }
  
  public final boolean a(ImageView paramImageView1, String paramString, boolean paramBoolean, float paramFloat, int paramInt1, int paramInt2, ImageView paramImageView2, int paramInt3, int paramInt4, View paramView)
  {
    AppMethodBeat.i(78227);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ImgInfoStorage", "invalid uri is %s", new Object[] { paramString });
      AppMethodBeat.o(78227);
      return false;
    }
    label586:
    label598:
    label613:
    label1126:
    for (;;)
    {
      synchronized (this.fEB)
      {
        boolean bool = this.fEB.containsKey(paramString);
        String str = c(paramString, paramBoolean, false);
        if (bo.isNullOrNil(str))
        {
          ab.e("MicroMsg.ImgInfoStorage", "getFullThumbPathByCache uri is null, uri:%s", new Object[] { bo.nullAsNil(paramString) });
          AppMethodBeat.o(78227);
          return false;
        }
        localObject = str;
        if (!bool)
        {
          localObject = str;
          if (!str.endsWith("hd"))
          {
            localObject = str;
            if (com.tencent.mm.vfs.e.cN(str + "hd"))
            {
              this.fEB.put(paramString, str + "hd");
              localObject = str + "hd";
            }
          }
        }
        if (!((String)localObject).endsWith("hd")) {
          break label1126;
        }
        paramString = (Bitmap)this.fEu.Y(localObject);
        if (paramString == null)
        {
          a(paramImageView1, paramImageView2, paramView, (String)localObject, paramFloat);
          localObject = ((String)localObject).substring(0, ((String)localObject).length() - 2);
          i = 1;
          if (paramString != null) {
            break label1123;
          }
          paramString = (Bitmap)this.fEu.Y(localObject);
          if ((paramString == null) || (paramString.isRecycled())) {
            break label653;
          }
          ab.i("MicroMsg.ImgInfoStorage", "[setbitmapFromUri] bitmap width %d,height %d", new Object[] { Integer.valueOf(paramString.getWidth()), Integer.valueOf(paramString.getHeight()) });
          paramImageView1.setBackgroundDrawable(null);
          g.a.a(paramString, paramImageView1);
          if (paramImageView1.getLayoutParams().width == -2) {
            break label586;
          }
          localObject = this.fED;
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
          AppMethodBeat.o(78227);
          return true;
        }
      }
      if (this.fEu.remove(((String)localObject).substring(0, ((String)localObject).length() - 2)) != null) {
        ab.d("MicroMsg.ImgInfoStorage", "remove low quality thumb from cacheMap, path: ".concat(String.valueOf(localObject)));
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
                  ab.d("MicroMsg.ImgInfoStorage", "pic to small width is %d ", new Object[] { Integer.valueOf(paramInt2) });
                  paramInt2 = (int)(60.0F * paramFloat);
                }
              }
            }
            for (;;)
            {
              paramInt3 = paramInt1;
              if (paramInt1 < 60.0F * paramFloat)
              {
                ab.d("MicroMsg.ImgInfoStorage", "pic to small height is %d ", new Object[] { Integer.valueOf(paramInt1) });
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
                AppMethodBeat.o(78227);
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
                if ((this.fEE == null) || (this.fEE.get() == null)) {
                  this.fEE = new SoftReference(new ColorDrawable(-1118482));
                }
                paramImageView1.setImageDrawable((ColorDrawable)this.fEE.get());
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
  
  public final boolean a(bi parambi, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78271);
    String str = y(parambi);
    if (!bo.isNullOrNil(str))
    {
      boolean bool = a(str, parambi.field_imgPath, paramInt1, paramInt2, 0, 0);
      AppMethodBeat.o(78271);
      return bool;
    }
    AppMethodBeat.o(78271);
    return false;
  }
  
  /* Error */
  public final boolean a(String arg1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: ldc_w 1577
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 238
    //   8: ldc_w 1579
    //   11: iconst_5
    //   12: anewarray 94	java/lang/Object
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
    //   26: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: iload 4
    //   34: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: aastore
    //   38: dup
    //   39: iconst_4
    //   40: invokestatic 254	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
    //   43: aastore
    //   44: invokestatic 260	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   50: lstore 10
    //   52: invokestatic 383	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   55: invokestatic 1145	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   58: fstore 7
    //   60: aload_1
    //   61: invokestatic 224	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   64: ifne +10 -> 74
    //   67: aload_2
    //   68: invokestatic 224	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   71: ifeq +11 -> 82
    //   74: ldc_w 1577
    //   77: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_0
    //   83: aload_2
    //   84: iconst_0
    //   85: iconst_1
    //   86: invokevirtual 359	com/tencent/mm/at/g:c	(Ljava/lang/String;ZZ)Ljava/lang/String;
    //   89: astore 13
    //   91: aload 13
    //   93: invokestatic 224	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   96: ifeq +11 -> 107
    //   99: ldc_w 1577
    //   102: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 13
    //   109: ldc_w 274
    //   112: invokevirtual 277	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   115: ifne +98 -> 213
    //   118: new 416	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   125: aload 13
    //   127: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 274
    //   133: invokevirtual 519	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 15
    //   141: aload 13
    //   143: astore 14
    //   145: aload 15
    //   147: astore 13
    //   149: aload 14
    //   151: invokestatic 1247	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   154: astore 16
    //   156: aload 16
    //   158: ifnull +23 -> 181
    //   161: aload 16
    //   163: getfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   166: ifle +15 -> 181
    //   169: aload 16
    //   171: astore 15
    //   173: aload 16
    //   175: getfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   178: ifgt +118 -> 296
    //   181: getstatic 604	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   184: ldc2_w 1116
    //   187: ldc2_w 1580
    //   190: lconst_1
    //   191: iconst_0
    //   192: invokevirtual 1123	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   195: aload 14
    //   197: invokestatic 534	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   200: lconst_0
    //   201: lcmp
    //   202: ifle +29 -> 231
    //   205: ldc_w 1577
    //   208: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: aload 13
    //   215: iconst_0
    //   216: aload 13
    //   218: invokevirtual 311	java/lang/String:length	()I
    //   221: iconst_2
    //   222: isub
    //   223: invokevirtual 315	java/lang/String:substring	(II)Ljava/lang/String;
    //   226: astore 14
    //   228: goto -79 -> 149
    //   231: new 941	android/graphics/BitmapFactory$Options
    //   234: dup
    //   235: invokespecial 942	android/graphics/BitmapFactory$Options:<init>	()V
    //   238: astore 15
    //   240: invokestatic 1584	com/tencent/mm/sdk/platformtools/d:dsm	()V
    //   243: ldc 238
    //   245: ldc_w 1586
    //   248: iconst_3
    //   249: anewarray 94	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload 15
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload 15
    //   261: getfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   264: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: dup
    //   269: iconst_2
    //   270: aload 15
    //   272: getfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   275: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   278: aastore
    //   279: invokestatic 329	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: getstatic 604	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   285: ldc2_w 1116
    //   288: ldc2_w 1587
    //   291: lconst_1
    //   292: iconst_0
    //   293: invokevirtual 1123	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   296: aload 15
    //   298: getfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   301: ifne +10 -> 311
    //   304: aload 15
    //   306: iload 5
    //   308: putfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   311: aload 15
    //   313: getfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   316: ifne +10 -> 326
    //   319: aload 15
    //   321: iload 6
    //   323: putfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   326: aload 15
    //   328: getfield 955	android/graphics/BitmapFactory$Options:outWidth	I
    //   331: i2f
    //   332: fload 7
    //   334: fmul
    //   335: ldc_w 391
    //   338: fmul
    //   339: f2i
    //   340: istore 9
    //   342: aload 15
    //   344: getfield 958	android/graphics/BitmapFactory$Options:outHeight	I
    //   347: i2f
    //   348: fload 7
    //   350: fmul
    //   351: ldc_w 391
    //   354: fmul
    //   355: f2i
    //   356: istore 8
    //   358: iload 9
    //   360: i2f
    //   361: ldc_w 392
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
    //   382: ldc_w 392
    //   385: fload 7
    //   387: fmul
    //   388: fcmpl
    //   389: iflt +40 -> 429
    //   392: iload 8
    //   394: iload 9
    //   396: if_icmple +215 -> 611
    //   399: ldc_w 392
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
    //   439: getstatic 344	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   442: aload 13
    //   444: new 302	com/tencent/mm/pointers/PInt
    //   447: dup
    //   448: invokespecial 1034	com/tencent/mm/pointers/PInt:<init>	()V
    //   451: new 302	com/tencent/mm/pointers/PInt
    //   454: dup
    //   455: invokespecial 1034	com/tencent/mm/pointers/PInt:<init>	()V
    //   458: invokestatic 1591	com/tencent/mm/sdk/platformtools/d:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   461: istore 12
    //   463: ldc 238
    //   465: ldc_w 1593
    //   468: iconst_4
    //   469: anewarray 94	java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: new 416	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 417	java/lang/StringBuilder:<init>	()V
    //   481: invokestatic 377	java/lang/System:currentTimeMillis	()J
    //   484: lload 10
    //   486: lsub
    //   487: invokevirtual 421	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   490: invokevirtual 422	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: iload 6
    //   498: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   501: aastore
    //   502: dup
    //   503: iconst_2
    //   504: iload 5
    //   506: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: dup
    //   511: iconst_3
    //   512: iload 12
    //   514: invokestatic 250	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   517: aastore
    //   518: invokestatic 260	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: aload_0
    //   522: aload 14
    //   524: iconst_1
    //   525: invokestatic 383	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   528: invokestatic 1145	com/tencent/mm/cb/a:getDensity	(Landroid/content/Context;)F
    //   531: iconst_1
    //   532: iconst_0
    //   533: iconst_1
    //   534: iload_3
    //   535: iconst_0
    //   536: invokespecial 1138	com/tencent/mm/at/g:a	(Ljava/lang/String;ZFZZZIZ)Landroid/graphics/Bitmap;
    //   539: pop
    //   540: iload 12
    //   542: ifeq +169 -> 711
    //   545: aload_0
    //   546: getfield 143	com/tencent/mm/at/g:fEB	Ljava/util/Map;
    //   549: astore_1
    //   550: aload_1
    //   551: monitorenter
    //   552: aload_0
    //   553: getfield 143	com/tencent/mm/at/g:fEB	Ljava/util/Map;
    //   556: aload_2
    //   557: invokeinterface 1522 2 0
    //   562: ifeq +38 -> 600
    //   565: aload_0
    //   566: getfield 143	com/tencent/mm/at/g:fEB	Ljava/util/Map;
    //   569: aload_2
    //   570: invokeinterface 691 2 0
    //   575: checkcast 49	java/lang/String
    //   578: ldc_w 274
    //   581: invokevirtual 277	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   584: ifne +16 -> 600
    //   587: aload_0
    //   588: getfield 143	com/tencent/mm/at/g:fEB	Ljava/util/Map;
    //   591: aload_2
    //   592: aload 13
    //   594: invokeinterface 674 3 0
    //   599: pop
    //   600: aload_1
    //   601: monitorexit
    //   602: ldc_w 1577
    //   605: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   608: iload 12
    //   610: ireturn
    //   611: ldc_w 392
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
    //   631: getstatic 344	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   634: aload 13
    //   636: new 302	com/tencent/mm/pointers/PInt
    //   639: dup
    //   640: invokespecial 1034	com/tencent/mm/pointers/PInt:<init>	()V
    //   643: new 302	com/tencent/mm/pointers/PInt
    //   646: dup
    //   647: invokespecial 1034	com/tencent/mm/pointers/PInt:<init>	()V
    //   650: invokestatic 1595	com/tencent/mm/sdk/platformtools/d:b	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Lcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   653: istore 12
    //   655: goto -192 -> 463
    //   658: astore_1
    //   659: getstatic 604	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   662: ldc2_w 1116
    //   665: ldc2_w 1596
    //   668: lconst_1
    //   669: iconst_0
    //   670: invokevirtual 1123	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   673: ldc 238
    //   675: ldc_w 1599
    //   678: iconst_1
    //   679: anewarray 94	java/lang/Object
    //   682: dup
    //   683: iconst_0
    //   684: aload_1
    //   685: invokevirtual 1600	java/lang/Exception:toString	()Ljava/lang/String;
    //   688: aastore
    //   689: invokestatic 445	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   692: ldc_w 1577
    //   695: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   698: iconst_0
    //   699: ireturn
    //   700: astore_2
    //   701: aload_1
    //   702: monitorexit
    //   703: ldc_w 1577
    //   706: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   709: aload_2
    //   710: athrow
    //   711: getstatic 604	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   714: ldc2_w 1116
    //   717: ldc2_w 1596
    //   720: lconst_1
    //   721: iconst_0
    //   722: invokevirtual 1123	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
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
  
  public final void ahk()
  {
    AppMethodBeat.i(78209);
    Cursor localCursor = this.fnw.a("SELECT max(id) FROM ImgInfo2", null, 2);
    long l;
    if (localCursor.moveToFirst()) {
      l = localCursor.getLong(0) + 1L;
    }
    synchronized (this.fEC)
    {
      if (l > this.fEC.get()) {
        this.fEC.set(l);
      }
      localCursor.close();
      ab.i("MicroMsg.ImgInfoStorage", "loading new img id: " + this.fEC.get());
      AppMethodBeat.o(78209);
      return;
    }
  }
  
  public final long ahl()
  {
    AppMethodBeat.i(78210);
    synchronized (this.fEC)
    {
      long l = this.fEC.getAndIncrement();
      AppMethodBeat.o(78210);
      return l;
    }
  }
  
  public final List<e> ahm()
  {
    AppMethodBeat.i(78240);
    Object localObject = "select * " + " FROM ImgInfo2";
    localObject = (String)localObject + " WHERE iscomplete= 0 AND totalLen != 0 ";
    localObject = this.fnw.a((String)localObject, null, 0);
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(78240);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      e locale1 = new e();
      locale1.convertFrom((Cursor)localObject);
      e locale2 = lw((int)locale1.fDL);
      if (locale2 != null) {
        if ((locale2.cFn != 0L) || (locale2.fDU != 0L)) {
          localArrayList.add(locale1);
        }
      }
      while (!((Cursor)localObject).moveToNext())
      {
        ((Cursor)localObject).close();
        AppMethodBeat.o(78240);
        return localArrayList;
        if ((locale1.cFn != 0L) || (locale1.fDU != 0L)) {
          localArrayList.add(locale1);
        }
      }
    }
  }
  
  public final Bitmap b(String paramString, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(78230);
    paramString = a(paramString, true, paramFloat, paramBoolean, true, false, 0);
    AppMethodBeat.o(78230);
    return paramString;
  }
  
  public final e b(Long paramLong)
  {
    AppMethodBeat.i(78238);
    e locale = new e();
    paramLong = a("ImgInfo2", null, "id=?", new String[] { String.valueOf(paramLong) });
    if ((paramLong != null) && (paramLong.moveToFirst())) {
      locale.convertFrom(paramLong);
    }
    paramLong.close();
    AppMethodBeat.o(78238);
    return locale;
  }
  
  public final HashMap<Long, e> b(Long... paramVarArgs)
  {
    AppMethodBeat.i(78244);
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
      ((HashMap)localObject1).put(Long.valueOf(((e)localObject2).cFn), localObject2);
    }
    paramVarArgs.close();
    AppMethodBeat.o(78244);
    return localObject1;
  }
  
  public final String c(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(78273);
    Object localObject;
    if ((paramString != null) && (this.fEB.containsKey(paramString)))
    {
      localObject = (String)this.fEB.get(paramString);
      AppMethodBeat.o(78273);
      return localObject;
    }
    if (paramBoolean1) {}
    for (String str = paramString;; str = J(paramString, paramBoolean2))
    {
      localObject = str;
      if (bo.isNullOrNil(str)) {
        break;
      }
      this.fEB.put(paramString, str);
      localObject = str;
      break;
    }
  }
  
  public final String d(e parame)
  {
    Object localObject = null;
    AppMethodBeat.i(78242);
    if (parame == null)
    {
      AppMethodBeat.o(78242);
      return null;
    }
    if (parame.ahh())
    {
      parame = parame.fDW;
      Cursor localCursor = b("ImgInfo2", new String[] { "bigImgPath" }, "id=? and totalLen = offset", new String[] { parame });
      parame = localObject;
      if (localCursor.moveToFirst()) {
        parame = localCursor.getString(0);
      }
      localCursor.close();
      AppMethodBeat.o(78242);
      return parame;
    }
    AppMethodBeat.o(78242);
    return null;
  }
  
  public final long e(e parame)
  {
    AppMethodBeat.i(78254);
    long l = this.fnw.a("ImgInfo2", "id", parame.convertTo());
    if (l != -1L) {
      parame.ahj();
    }
    ab.i("MicroMsg.ImgInfoStorage", "insert img, result:%d, localId:%d, msgLocalId:%d, msgSvrId:%d, hdID:%d", new Object[] { Long.valueOf(l), Long.valueOf(parame.fDL), Long.valueOf(parame.fDU), Long.valueOf(parame.cFn), Integer.valueOf(parame.fDW) });
    AppMethodBeat.o(78254);
    return l;
  }
  
  public final Bitmap e(String paramString, float paramFloat)
  {
    AppMethodBeat.i(78224);
    paramString = a(paramString, paramFloat, false);
    AppMethodBeat.o(78224);
    return paramString;
  }
  
  public final Bitmap g(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(78269);
    if (paramBoolean) {}
    for (String str = "location_backgroup_key_from";; str = "location_backgroup_key_tor")
    {
      Bitmap localBitmap2 = (Bitmap)this.fEu.Y(str);
      Bitmap localBitmap1;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (!localBitmap2.isRecycled()) {}
      }
      else
      {
        localBitmap1 = com.tencent.mm.sdk.platformtools.d.hj(paramInt1, paramInt2);
        this.fEu.f(str, localBitmap1);
      }
      AppMethodBeat.o(78269);
      return localBitmap1;
    }
  }
  
  public final e gS(long paramLong)
  {
    AppMethodBeat.i(78246);
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msgSvrId=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToFirst()) {
      locale.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(78246);
    return locale;
  }
  
  public final e gT(long paramLong)
  {
    AppMethodBeat.i(78247);
    e locale = new e();
    Cursor localCursor = b("ImgInfo2", null, "msglocalid=?", new String[] { String.valueOf(paramLong) });
    if (localCursor.moveToLast()) {
      locale.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(78247);
    return locale;
  }
  
  public final String getFullPath(String paramString)
  {
    AppMethodBeat.i(78214);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78214);
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
        str1 = gS(Long.valueOf(str1).longValue()).fDM;
        String str2 = com.tencent.mm.plugin.i.c.YK();
        String str3 = com.tencent.mm.plugin.i.c.YL();
        if (bo.isNullOrNil(str1))
        {
          paramString = j.h(str2, str3, "th_", paramString, "");
          AppMethodBeat.o(78214);
          return paramString;
        }
      }
      catch (NumberFormatException paramString)
      {
        ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(78214);
        return null;
      }
      paramString = str1;
    }
  }
  
  public final e lv(int paramInt)
  {
    AppMethodBeat.i(78245);
    e locale = b(Long.valueOf(paramInt));
    AppMethodBeat.o(78245);
    return locale;
  }
  
  /* Error */
  public final e lw(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 1683
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ldc 178
    //   9: aconst_null
    //   10: ldc_w 1685
    //   13: iconst_1
    //   14: anewarray 49	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: iload_1
    //   20: invokestatic 187	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   23: aastore
    //   24: invokespecial 1505	com/tencent/mm/at/g:b	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnull +147 -> 176
    //   32: aload_3
    //   33: astore 4
    //   35: aload_3
    //   36: invokeinterface 196 1 0
    //   41: ifeq +135 -> 176
    //   44: aload_3
    //   45: astore 4
    //   47: new 175	com/tencent/mm/at/e
    //   50: dup
    //   51: invokespecial 176	com/tencent/mm/at/e:<init>	()V
    //   54: astore_2
    //   55: aload_3
    //   56: astore 4
    //   58: aload_2
    //   59: aload_3
    //   60: invokevirtual 200	com/tencent/mm/at/e:convertFrom	(Landroid/database/Cursor;)V
    //   63: aload_2
    //   64: astore 4
    //   66: aload_3
    //   67: ifnull +12 -> 79
    //   70: aload_3
    //   71: invokeinterface 203 1 0
    //   76: aload_2
    //   77: astore 4
    //   79: ldc_w 1683
    //   82: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload 4
    //   87: areturn
    //   88: astore 5
    //   90: aconst_null
    //   91: astore_2
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_3
    //   95: astore 4
    //   97: ldc 238
    //   99: ldc_w 1687
    //   102: iconst_1
    //   103: anewarray 94	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload 5
    //   110: invokevirtual 1600	java/lang/Exception:toString	()Ljava/lang/String;
    //   113: aastore
    //   114: invokestatic 1163	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_2
    //   118: astore 4
    //   120: aload_3
    //   121: ifnull -42 -> 79
    //   124: aload_3
    //   125: invokeinterface 203 1 0
    //   130: aload_2
    //   131: astore 4
    //   133: goto -54 -> 79
    //   136: astore_2
    //   137: aconst_null
    //   138: astore 4
    //   140: aload 4
    //   142: ifnull +10 -> 152
    //   145: aload 4
    //   147: invokeinterface 203 1 0
    //   152: ldc_w 1683
    //   155: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_2
    //   159: athrow
    //   160: astore_2
    //   161: goto -21 -> 140
    //   164: astore 5
    //   166: aconst_null
    //   167: astore_2
    //   168: goto -74 -> 94
    //   171: astore 5
    //   173: goto -79 -> 94
    //   176: aconst_null
    //   177: astore_2
    //   178: goto -115 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	g
    //   0	181	1	paramInt	int
    //   54	77	2	locale	e
    //   136	23	2	localObject1	Object
    //   160	1	2	localObject2	Object
    //   167	11	2	localObject3	Object
    //   27	98	3	localCursor	Cursor
    //   33	113	4	localObject4	Object
    //   88	21	5	localException1	Exception
    //   164	1	5	localException2	Exception
    //   171	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   6	28	88	java/lang/Exception
    //   6	28	136	finally
    //   35	44	160	finally
    //   47	55	160	finally
    //   58	63	160	finally
    //   97	117	160	finally
    //   35	44	164	java/lang/Exception
    //   47	55	164	java/lang/Exception
    //   58	63	171	java/lang/Exception
  }
  
  public final String q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78213);
    paramString1 = a(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(78213);
    return paramString1;
  }
  
  public final String te(String paramString)
  {
    AppMethodBeat.i(78216);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(78216);
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
        paramString = lv(Integer.valueOf(paramString).intValue()).fDO;
        paramString = q(paramString, str1, "");
        AppMethodBeat.o(78216);
        return paramString;
      }
      catch (NumberFormatException paramString)
      {
        ab.e("MicroMsg.ImgInfoStorage", "read img buf failed: " + paramString.getMessage());
        AppMethodBeat.o(78216);
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
  
  public final Bitmap tf(String paramString)
  {
    AppMethodBeat.i(78234);
    float f = com.tencent.mm.cb.a.getDensity(ah.getContext());
    paramString = com.tencent.mm.sdk.platformtools.d.l(c(paramString, false, true), f);
    AppMethodBeat.o(78234);
    return paramString;
  }
  
  public final String tg(String paramString)
  {
    AppMethodBeat.i(78255);
    paramString = a("THUMBNAIL_DIRPATH://th_".concat(String.valueOf(paramString)), "th_", "", false);
    AppMethodBeat.o(78255);
    return paramString;
  }
  
  public final String th(String paramString)
  {
    AppMethodBeat.i(78256);
    paramString = a(paramString, "", ".jpg", false);
    AppMethodBeat.o(78256);
    return paramString;
  }
  
  public final String tj(String paramString)
  {
    AppMethodBeat.i(156857);
    paramString = c(paramString, false, true);
    AppMethodBeat.o(156857);
    return paramString;
  }
  
  public final e w(bi parambi)
  {
    AppMethodBeat.i(78237);
    e locale = gT(parambi.field_msgId);
    Object localObject = locale;
    if (locale.fDL == 0L)
    {
      parambi = gS(parambi.field_msgSvrId);
      localObject = parambi;
      if (parambi.fDL == 0L)
      {
        ab.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
        AppMethodBeat.o(78237);
        return null;
      }
    }
    AppMethodBeat.o(78237);
    return localObject;
  }
  
  public final void x(bi parambi)
  {
    AppMethodBeat.i(78241);
    parambi = w(parambi);
    if ((parambi == null) || (parambi.fDL == 0L))
    {
      ab.e("MicroMsg.ImgInfoStorage", "deleteByMsg can't find correspond imgInfo");
      AppMethodBeat.o(78241);
      return;
    }
    com.tencent.mm.vfs.e.deleteFile(q(parambi.fDM, "", ""));
    com.tencent.mm.vfs.e.deleteFile(q(parambi.fDR, "", ""));
    com.tencent.mm.vfs.e.deleteFile(q(parambi.fDO, "", ""));
    com.tencent.mm.vfs.e.deleteFile(q(parambi.fDO, "", "") + "hd");
    this.fnw.delete("ImgInfo2", "id=?", new String[] { parambi.fDL });
    if (parambi.ahh())
    {
      parambi = lv(parambi.fDW);
      if (parambi == null)
      {
        AppMethodBeat.o(78241);
        return;
      }
      com.tencent.mm.vfs.e.deleteFile(q(parambi.fDM, "", ""));
      com.tencent.mm.vfs.e.deleteFile(q(parambi.fDR, "", ""));
      com.tencent.mm.vfs.e.deleteFile(q(parambi.fDO, "", ""));
      com.tencent.mm.vfs.e.deleteFile(q(parambi.fDO, "", "") + "hd");
      this.fnw.delete("ImgInfo2", "id=?", new String[] { parambi.fDL });
    }
    AppMethodBeat.o(78241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.at.g
 * JD-Core Version:    0.7.0.1
 */