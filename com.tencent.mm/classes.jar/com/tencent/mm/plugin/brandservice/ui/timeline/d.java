package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.d.a;
import com.tencent.mm.av.e;
import com.tencent.mm.av.g;
import com.tencent.mm.av.o;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.t;
import com.tencent.mm.vfs.i;
import java.util.HashMap;

public final class d
  implements d.a
{
  int nzH;
  public HashMap<Long, Integer> nzI;
  private j nzJ;
  
  public d(j paramj)
  {
    AppMethodBeat.i(5892);
    this.nzI = new HashMap();
    this.nzJ = paramj;
    AppMethodBeat.o(5892);
  }
  
  private void a(e parame, t paramt, int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(5893);
    if (o.aFy().a(parame.dcd, paramt.field_msgId, 0, Integer.valueOf(paramInt), 2131231564, this, 0, false) == -2)
    {
      ac.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
      parame = c(paramt);
      if (parame == null)
      {
        ac.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
        AppMethodBeat.o(5893);
        return;
      }
      parame = i(parame);
      if (i.eA(parame)) {
        loadImage(parame, paramImageView);
      }
    }
    AppMethodBeat.o(5893);
  }
  
  private static e c(t paramt)
  {
    AppMethodBeat.i(5897);
    e locale1 = null;
    if (paramt.field_msgId > 0L) {
      locale1 = o.aFx().qg(paramt.field_msgId);
    }
    e locale2;
    if (locale1 != null)
    {
      locale2 = locale1;
      if (locale1.dcd > 0L) {}
    }
    else
    {
      locale2 = locale1;
      if (paramt.field_msgSvrId > 0L) {
        locale2 = o.aFx().qf(paramt.field_msgSvrId);
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
    String str = parame.hGM;
    Object localObject1 = localObject2;
    if (parame.aFa())
    {
      parame = o.aFx().d(parame);
      localObject1 = localObject2;
      if (parame != null)
      {
        parame = o.aFx().p(parame, "", "");
        localObject1 = localObject2;
        if (i.eA(parame))
        {
          ac.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
          localObject1 = parame;
        }
      }
    }
    parame = (e)localObject1;
    if (localObject1 == null) {
      parame = o.aFx().p(str, "", "");
    }
    AppMethodBeat.o(5896);
    return parame;
  }
  
  private void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(5895);
    if (this.nzH != 0) {}
    for (final int i = 2131231245;; i = 0)
    {
      com.tencent.mm.av.a.a locala = o.aFB();
      c.a locala1 = new c.a();
      locala1.hKN = "biz_nor_img".concat(String.valueOf(i));
      locala1.hKL = 2131100141;
      locala1.hKA = 1;
      locala.a(paramString, paramImageView, locala1.aFT(), new h()
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
            ac.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(5891);
            return null;
          }
          if (bs.isNullOrNil(paramAnonymousString))
          {
            ac.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap url is null");
            AppMethodBeat.o(5891);
            return null;
          }
          try
          {
            int j = com.tencent.mm.cc.a.ig(paramAnonymousView.getContext()) - (int)(com.tencent.mm.cc.a.getDensity(paramAnonymousView.getContext()) * 16.0F);
            if (d.this.nzH != 0) {}
            for (int i = d.this.nzH;; i = (int)(j / 2.35D))
            {
              paramAnonymousView = f.b(paramAnonymousb.bitmap, j, i, true);
              paramAnonymousString = Bitmap.createScaledBitmap(paramAnonymousView, j, i, true);
              if ((paramAnonymousString != paramAnonymousView) && (paramAnonymousView != null) && (!paramAnonymousView.isRecycled()))
              {
                ac.i("MicroMsg.BizTimeLineImgMsgHandler", "bitmap recycled %s", new Object[] { paramAnonymousView });
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
            ac.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramAnonymousString.getMessage() });
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
  
  private void o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5900);
    this.nzI.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(5900);
  }
  
  private int ro(long paramLong)
  {
    AppMethodBeat.i(5899);
    if (this.nzI.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((Integer)this.nzI.get(Long.valueOf(paramLong))).intValue();
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
      ac.i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      if (paramInt4 == -5103059)
      {
        o(paramLong2, 2);
        AppMethodBeat.o(5898);
        return;
      }
      o(paramLong2, 3);
      AppMethodBeat.o(5898);
      return;
    }
    o(paramLong2, 1);
    this.nzJ.bJU();
    AppMethodBeat.o(5898);
  }
  
  public final void a(t paramt, int paramInt1, ImageView paramImageView, int paramInt2)
  {
    AppMethodBeat.i(5894);
    this.nzH = paramInt2;
    if ((ro(paramt.field_msgId) == 2) || (ro(paramt.field_msgId) == 3))
    {
      AppMethodBeat.o(5894);
      return;
    }
    e locale = c(paramt);
    if (locale != null)
    {
      String str = i(locale);
      if (i.eA(str))
      {
        loadImage(str, paramImageView);
        o(paramt.field_msgId, 1);
        AppMethodBeat.o(5894);
        return;
      }
      a(locale, paramt, paramInt1, paramImageView);
      AppMethodBeat.o(5894);
      return;
    }
    ac.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", new Object[] { Long.valueOf(paramt.field_msgId), Long.valueOf(paramt.field_msgSvrId) });
    AppMethodBeat.o(5894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.d
 * JD-Core Version:    0.7.0.1
 */