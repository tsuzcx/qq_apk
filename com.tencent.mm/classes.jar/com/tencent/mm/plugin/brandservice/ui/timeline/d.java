package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.aw.d.a;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.g;
import com.tencent.mm.aw.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.s;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public final class d
  implements d.a
{
  int mXi;
  public HashMap<Long, Integer> mXj;
  private j mXk;
  
  public d(j paramj)
  {
    AppMethodBeat.i(5892);
    this.mXj = new HashMap();
    this.mXk = paramj;
    AppMethodBeat.o(5892);
  }
  
  private void a(e parame, s params, int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(5893);
    if (o.ayG().a(parame.deI, params.field_msgId, 0, Integer.valueOf(paramInt), 2131231564, this, 0, false) == -2)
    {
      ad.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
      parame = c(params);
      if (parame == null)
      {
        ad.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
        AppMethodBeat.o(5893);
        return;
      }
      parame = i(parame);
      if (i.eK(parame)) {
        loadImage(parame, paramImageView);
      }
    }
    AppMethodBeat.o(5893);
  }
  
  private static e c(s params)
  {
    AppMethodBeat.i(5897);
    e locale1 = null;
    if (params.field_msgId > 0L) {
      locale1 = o.ayF().ms(params.field_msgId);
    }
    e locale2;
    if (locale1 != null)
    {
      locale2 = locale1;
      if (locale1.deI > 0L) {}
    }
    else
    {
      locale2 = locale1;
      if (params.field_msgSvrId > 0L) {
        locale2 = o.ayF().mr(params.field_msgSvrId);
      }
    }
    AppMethodBeat.o(5897);
    return locale2;
  }
  
  private static String i(e parame)
  {
    Object localObject2 = null;
    AppMethodBeat.i(5896);
    if (parame == null)
    {
      AppMethodBeat.o(5896);
      return null;
    }
    String str = parame.hgj;
    Object localObject1 = localObject2;
    if (parame.ayi())
    {
      parame = o.ayF().d(parame);
      localObject1 = localObject2;
      if (parame != null)
      {
        parame = o.ayF().p(parame, "", "");
        localObject1 = localObject2;
        if (i.eK(parame))
        {
          ad.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
          localObject1 = parame;
        }
      }
    }
    parame = (e)localObject1;
    if (localObject1 == null) {
      parame = o.ayF().p(str, "", "");
    }
    AppMethodBeat.o(5896);
    return parame;
  }
  
  private void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(5895);
    if (this.mXi != 0) {}
    for (final int i = 2131231245;; i = 0)
    {
      com.tencent.mm.aw.a.a locala = o.ayJ();
      c.a locala1 = new c.a();
      locala1.hkk = "biz_nor_img".concat(String.valueOf(i));
      locala1.hki = 2131100141;
      locala1.hjX = 1;
      locala.a(paramString, paramImageView, locala1.azc(), new h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
        {
          AppMethodBeat.i(5891);
          if (i == 0)
          {
            AppMethodBeat.o(5891);
            return null;
          }
          if ((paramAnonymousb == null) || (paramAnonymousb.bitmap == null) || (paramAnonymousb.bitmap.isRecycled()))
          {
            ad.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(5891);
            return null;
          }
          if (bt.isNullOrNil(paramAnonymousString))
          {
            ad.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap url is null");
            AppMethodBeat.o(5891);
            return null;
          }
          try
          {
            int j = com.tencent.mm.cd.a.hV(paramAnonymousView.getContext()) - (int)(com.tencent.mm.cd.a.getDensity(paramAnonymousView.getContext()) * 16.0F);
            if (d.this.mXi != 0) {}
            for (int i = d.this.mXi;; i = (int)(j / 2.35D))
            {
              paramAnonymousView = f.b(paramAnonymousb.bitmap, j, i, true);
              paramAnonymousString = Bitmap.createScaledBitmap(paramAnonymousView, j, i, true);
              if ((paramAnonymousString != paramAnonymousView) && (paramAnonymousView != null) && (!paramAnonymousView.isRecycled()))
              {
                ad.i("MicroMsg.BizTimeLineImgMsgHandler", "bitmap recycled %s", new Object[] { paramAnonymousView });
                paramAnonymousView.recycle();
              }
              paramAnonymousView = f.k(paramAnonymousString, i);
              if ((paramAnonymousString != null) && (!paramAnonymousString.isRecycled())) {
                paramAnonymousString.recycle();
              }
              AppMethodBeat.o(5891);
              return paramAnonymousView;
            }
            return null;
          }
          catch (OutOfMemoryError paramAnonymousString)
          {
            ad.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramAnonymousString.getMessage() });
            AppMethodBeat.o(5891);
          }
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb) {}
      });
      AppMethodBeat.o(5895);
      return;
    }
  }
  
  private void n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5900);
    this.mXj.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(5900);
  }
  
  private int nC(long paramLong)
  {
    AppMethodBeat.i(5899);
    if (this.mXj.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((Integer)this.mXj.get(Long.valueOf(paramLong))).intValue();
      AppMethodBeat.o(5899);
      return i;
    }
    AppMethodBeat.o(5899);
    return 0;
  }
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn)
  {
    AppMethodBeat.i(5898);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      ad.i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      if (paramInt4 == -5103059)
      {
        n(paramLong2, 2);
        AppMethodBeat.o(5898);
        return;
      }
      n(paramLong2, 3);
      AppMethodBeat.o(5898);
      return;
    }
    n(paramLong2, 1);
    this.mXk.bCM();
    AppMethodBeat.o(5898);
  }
  
  public final void a(s params, int paramInt1, ImageView paramImageView, int paramInt2)
  {
    AppMethodBeat.i(5894);
    this.mXi = paramInt2;
    if ((nC(params.field_msgId) == 2) || (nC(params.field_msgId) == 3))
    {
      AppMethodBeat.o(5894);
      return;
    }
    e locale = c(params);
    if (locale != null)
    {
      String str = i(locale);
      if (i.eK(str))
      {
        loadImage(str, paramImageView);
        n(params.field_msgId, 1);
        AppMethodBeat.o(5894);
        return;
      }
      a(locale, params, paramInt1, paramImageView);
      AppMethodBeat.o(5894);
      return;
    }
    ad.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", new Object[] { Long.valueOf(params.field_msgId), Long.valueOf(params.field_msgSvrId) });
    AppMethodBeat.o(5894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.d
 * JD-Core Version:    0.7.0.1
 */