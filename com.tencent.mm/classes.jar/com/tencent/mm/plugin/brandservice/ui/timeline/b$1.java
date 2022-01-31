package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.c.g;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class b$1
  implements g
{
  b$1(b paramb, int paramInt) {}
  
  public final Bitmap a(String paramString, View paramView, com.tencent.mm.at.a.d.b paramb)
  {
    AppMethodBeat.i(14132);
    if (this.jWh == 0)
    {
      AppMethodBeat.o(14132);
      return null;
    }
    if ((paramb == null) || (paramb.bitmap == null) || (paramb.bitmap.isRecycled()))
    {
      ab.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap bitmap is null");
      AppMethodBeat.o(14132);
      return null;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap url is null");
      AppMethodBeat.o(14132);
      return null;
    }
    try
    {
      int j = a.gw(paramView.getContext()) - (int)(a.getDensity(paramView.getContext()) * 16.0F);
      if (this.jWi.jWe != 0) {}
      for (int i = this.jWi.jWe;; i = (int)(j / 2.35D))
      {
        paramView = d.b(paramb.bitmap, j, i, true);
        paramString = Bitmap.createScaledBitmap(paramView, j, i, true);
        if ((paramString != paramView) && (paramView != null) && (!paramView.isRecycled()))
        {
          ab.i("MicroMsg.BizTimeLineImgMsgHandler", "bitmap recycled %s", new Object[] { paramView });
          paramView.recycle();
        }
        paramView = d.f(paramString, this.jWh);
        if ((paramString != null) && (!paramString.isRecycled())) {
          paramString.recycle();
        }
        AppMethodBeat.o(14132);
        return paramView;
      }
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      ab.w("MicroMsg.BizTimeLineImgMsgHandler", "onProcessBitmap OutOfMemoryError %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(14132);
    }
  }
  
  public final void b(String paramString, View paramView, com.tencent.mm.at.a.d.b paramb) {}
  
  public final void tF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b.1
 * JD-Core Version:    0.7.0.1
 */