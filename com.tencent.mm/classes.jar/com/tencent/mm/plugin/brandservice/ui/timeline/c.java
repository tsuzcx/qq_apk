package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.d.b;
import com.tencent.mm.av.e;
import com.tencent.mm.av.e.a;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public final class c
  implements e.a
{
  int ogD;
  public HashMap<Long, Integer> ogE;
  private i ogF;
  
  public c(i parami)
  {
    AppMethodBeat.i(5892);
    this.ogE = new HashMap();
    this.ogF = parami;
    AppMethodBeat.o(5892);
  }
  
  private void a(g paramg, w paramw, int paramInt, ImageView paramImageView)
  {
    AppMethodBeat.i(5893);
    if (q.aIY().a(paramg.doE, paramw.field_msgId, 0, Integer.valueOf(paramInt), 2131231564, this, 0, false) == -2)
    {
      ae.w("MicroMsg.BizTimeLineImgMsgHandler", "it is already download image finish, but imgInfo is old, search db and repair.");
      paramg = c(paramw);
      if (paramg == null)
      {
        ae.w("MicroMsg.BizTimeLineImgMsgHandler", "get imgInfo by db but it is null.");
        AppMethodBeat.o(5893);
        return;
      }
      paramg = c(paramw.field_talker, paramg);
      if (o.fB(paramg)) {
        loadImage(paramg, paramImageView);
      }
    }
    AppMethodBeat.o(5893);
  }
  
  private static g c(w paramw)
  {
    AppMethodBeat.i(5897);
    g localg1 = null;
    if (paramw.field_msgId > 0L) {
      localg1 = q.aIX().G(paramw.field_talker, paramw.field_msgId);
    }
    g localg2;
    if (localg1 != null)
    {
      localg2 = localg1;
      if (localg1.doE > 0L) {}
    }
    else
    {
      localg2 = localg1;
      if (paramw.field_msgSvrId > 0L) {
        localg2 = q.aIX().F(paramw.field_talker, paramw.field_msgSvrId);
      }
    }
    AppMethodBeat.o(5897);
    return localg2;
  }
  
  private static String c(String paramString, g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(208452);
    if (paramg == null)
    {
      AppMethodBeat.o(208452);
      return null;
    }
    String str = paramg.ico;
    Object localObject1 = localObject2;
    if (paramg.aIB())
    {
      paramString = q.aIX().a(paramString, paramg);
      localObject1 = localObject2;
      if (paramString != null)
      {
        paramString = q.aIX().o(paramString, "", "");
        localObject1 = localObject2;
        if (o.fB(paramString))
        {
          ae.i("MicroMsg.BizTimeLineImgMsgHandler", "hasHdImg");
          localObject1 = paramString;
        }
      }
    }
    paramString = (String)localObject1;
    if (localObject1 == null) {
      paramString = q.aIX().o(str, "", "");
    }
    AppMethodBeat.o(208452);
    return paramString;
  }
  
  private void loadImage(String paramString, ImageView paramImageView)
  {
    AppMethodBeat.i(5895);
    if (this.ogD != 0) {}
    for (final int i = 2131231245;; i = 0)
    {
      com.tencent.mm.av.a.a locala = q.aJb();
      c.a locala1 = new c.a();
      locala1.igA = "biz_nor_img".concat(String.valueOf(i));
      locala1.igy = 2131100141;
      locala1.ign = 1;
      locala.a(paramString, paramImageView, locala1.aJu(), new com.tencent.mm.av.a.c.h()
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
            ae.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap bitmap is null");
            AppMethodBeat.o(5891);
            return null;
          }
          if (bu.isNullOrNil(paramAnonymousString))
          {
            ae.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap url is null");
            AppMethodBeat.o(5891);
            return null;
          }
          try
          {
            int j = com.tencent.mm.cb.a.iu(paramAnonymousView.getContext()) - (int)(com.tencent.mm.cb.a.getDensity(paramAnonymousView.getContext()) * 16.0F);
            if (c.this.ogD != 0) {}
            for (int i = c.this.ogD;; i = (int)(j / 2.35D))
            {
              paramAnonymousView = com.tencent.mm.sdk.platformtools.h.b(paramAnonymousb.bitmap, j, i, true);
              paramAnonymousString = Bitmap.createScaledBitmap(paramAnonymousView, j, i, true);
              if ((paramAnonymousString != paramAnonymousView) && (paramAnonymousView != null) && (!paramAnonymousView.isRecycled()))
              {
                ae.i("MicroMsg.BizTimeLineImgMsgHandler", "bitmap recycled %s", new Object[] { paramAnonymousView });
                paramAnonymousView.recycle();
              }
              paramAnonymousView = com.tencent.mm.sdk.platformtools.h.k(paramAnonymousString, i);
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
            ae.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramAnonymousString.getMessage() });
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
    this.ogE.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    AppMethodBeat.o(5900);
  }
  
  private int tA(long paramLong)
  {
    AppMethodBeat.i(5899);
    if (this.ogE.containsKey(Long.valueOf(paramLong)))
    {
      int i = ((Integer)this.ogE.get(Long.valueOf(paramLong))).intValue();
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
      ae.i("MicroMsg.BizTimeLineImgMsgHandler", "onImgTaskEnd errType %d, errCode %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
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
    this.ogF.bPl();
    AppMethodBeat.o(5898);
  }
  
  public final void a(w paramw, int paramInt1, ImageView paramImageView, int paramInt2)
  {
    AppMethodBeat.i(5894);
    this.ogD = paramInt2;
    if ((tA(paramw.field_msgId) == 2) || (tA(paramw.field_msgId) == 3))
    {
      AppMethodBeat.o(5894);
      return;
    }
    g localg = c(paramw);
    if (localg != null)
    {
      String str = c(paramw.field_talker, localg);
      if (o.fB(str))
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
    ae.w("MicroMsg.BizTimeLineImgMsgHandler", "showImg img info is null. %d/%d", new Object[] { Long.valueOf(paramw.field_msgId), Long.valueOf(paramw.field_msgSvrId) });
    AppMethodBeat.o(5894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c
 * JD-Core Version:    0.7.0.1
 */