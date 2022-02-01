package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.aw.a.d.b;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.e.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.w;
import java.util.HashMap;

public final class c
  implements e.a
{
  int oaM;
  public HashMap<Long, Integer> oaN;
  private i oaO;
  
  public c(i parami)
  {
    AppMethodBeat.i(5892);
    this.oaN = new HashMap();
    this.oaO = parami;
    AppMethodBeat.o(5892);
  }
  
  private void a(com.tencent.mm.aw.g paramg, w paramw, int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(5893);
    if (q.aIG().a(paramg.dnz, paramw.field_msgId, 0, Integer.valueOf(paramInt), 2131231564, this, 0, false) == -2)
    {
      ad.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
      paramg = c(paramw);
      if (paramg == null)
      {
        ad.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
        AppMethodBeat.o(5893);
        return;
      }
      paramg = c(paramw.field_talker, paramg);
      if (com.tencent.mm.vfs.i.fv(paramg)) {
        loadImage(paramg, paramImageView);
      }
    }
    AppMethodBeat.o(5893);
  }
  
  private static com.tencent.mm.aw.g c(w paramw)
  {
    AppMethodBeat.i(5897);
    com.tencent.mm.aw.g localg1 = null;
    if (paramw.field_msgId > 0L) {
      localg1 = q.aIF().G(paramw.field_talker, paramw.field_msgId);
    }
    com.tencent.mm.aw.g localg2;
    if (localg1 != null)
    {
      localg2 = localg1;
      if (localg1.dnz > 0L) {}
    }
    else
    {
      localg2 = localg1;
      if (paramw.field_msgSvrId > 0L) {
        localg2 = q.aIF().F(paramw.field_talker, paramw.field_msgSvrId);
      }
    }
    AppMethodBeat.o(5897);
    return localg2;
  }
  
  private static String c(String paramString, com.tencent.mm.aw.g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(209498);
    if (paramg == null)
    {
      AppMethodBeat.o(209498);
      return null;
    }
    String str = paramg.hZw;
    Object localObject1 = localObject2;
    if (paramg.aIj())
    {
      paramString = q.aIF().a(paramString, paramg);
      localObject1 = localObject2;
      if (paramString != null)
      {
        paramString = q.aIF().o(paramString, "", "");
        localObject1 = localObject2;
        if (com.tencent.mm.vfs.i.fv(paramString))
        {
          ad.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
          localObject1 = paramString;
        }
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = q.aIF().o(str, "", "");
    }
    AppMethodBeat.o(209498);
    return paramString;
  }
  
  private void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(5895);
    if (this.oaM != 0) {}
    for (final int i = 2131231245;; i = 0)
    {
      com.tencent.mm.aw.a.a locala = q.aIJ();
      c.a locala1 = new c.a();
      locala1.idI = "biz_nor_img".concat(String.valueOf(i));
      locala1.idG = 2131100141;
      locala1.idu = 1;
      locala.a(paramString, paramImageView, locala1.aJc(), new h()
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
            int j = com.tencent.mm.cc.a.ip(paramAnonymousView.getContext()) - (int)(com.tencent.mm.cc.a.getDensity(paramAnonymousView.getContext()) * 16.0F);
            if (c.this.oaM != 0) {}
            for (int i = c.this.oaM;; i = (int)(j / 2.35D))
            {
              paramAnonymousView = com.tencent.mm.sdk.platformtools.g.b(paramAnonymousb.bitmap, j, i, true);
              paramAnonymousString = Bitmap.createScaledBitmap(paramAnonymousView, j, i, true);
              if ((paramAnonymousString != paramAnonymousView) && (paramAnonymousView != null) && (!paramAnonymousView.isRecycled()))
              {
                ad.i("MicroMsg.BizTimeLineImgMsgHandler", "bitmap recycled %s", new Object[] { paramAnonymousView });
                paramAnonymousView.recycle();
              }
              paramAnonymousView = com.tencent.mm.sdk.platformtools.g.k(paramAnonymousString, i);
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
  
  private void o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5900);
    this.oaN.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(5900);
  }
  
  private int tm(long paramLong)
  {
    AppMethodBeat.i(5899);
    if (this.oaN.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((Integer)this.oaN.get(Long.valueOf(paramLong))).intValue();
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
        o(paramLong2, 2);
        AppMethodBeat.o(5898);
        return;
      }
      o(paramLong2, 3);
      AppMethodBeat.o(5898);
      return;
    }
    o(paramLong2, 1);
    this.oaO.bOo();
    AppMethodBeat.o(5898);
  }
  
  public final void a(w paramw, int paramInt1, ImageView paramImageView, int paramInt2)
  {
    AppMethodBeat.i(5894);
    this.oaM = paramInt2;
    if ((tm(paramw.field_msgId) == 2) || (tm(paramw.field_msgId) == 3))
    {
      AppMethodBeat.o(5894);
      return;
    }
    com.tencent.mm.aw.g localg = c(paramw);
    if (localg != null)
    {
      String str = c(paramw.field_talker, localg);
      if (com.tencent.mm.vfs.i.fv(str))
      {
        loadImage(str, paramImageView);
        o(paramw.field_msgId, 1);
        AppMethodBeat.o(5894);
        return;
      }
      a(localg, paramw, paramInt1, paramImageView);
      AppMethodBeat.o(5894);
      return;
    }
    ad.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", new Object[] { Long.valueOf(paramw.field_msgId), Long.valueOf(paramw.field_msgSvrId) });
    AppMethodBeat.o(5894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c
 * JD-Core Version:    0.7.0.1
 */