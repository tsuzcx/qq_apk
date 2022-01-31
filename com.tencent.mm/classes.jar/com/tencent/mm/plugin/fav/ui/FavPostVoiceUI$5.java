package com.tencent.mm.plugin.fav.ui;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;

final class FavPostVoiceUI$5
  implements View.OnTouchListener
{
  FavPostVoiceUI$5(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramView != FavPostVoiceUI.g(this.kcp)) {}
    do
    {
      do
      {
        int i;
        int j;
        do
        {
          return false;
          i = (int)paramMotionEvent.getRawY();
          paramView = new int[2];
          FavPostVoiceUI.a(this.kcp, this.kcp.getResources().getDisplayMetrics().heightPixels);
          FavPostVoiceUI.g(this.kcp).getLocationOnScreen(paramView);
          j = paramView[1];
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          }
        } while (FavPostVoiceUI.h(this.kcp));
        FavPostVoiceUI.i(this.kcp);
        FavPostVoiceUI.j(this.kcp);
        return false;
        int k = BackwardSupportUtil.b.b(this.kcp, 60.0F);
        if ((i <= FavPostVoiceUI.k(this.kcp) - k) && (i < j))
        {
          FavPostVoiceUI.l(this.kcp).setVisibility(8);
          FavPostVoiceUI.m(this.kcp).setVisibility(0);
          return false;
        }
        FavPostVoiceUI.l(this.kcp).setVisibility(0);
        FavPostVoiceUI.m(this.kcp).setVisibility(8);
        return false;
      } while (!FavPostVoiceUI.h(this.kcp));
      if (FavPostVoiceUI.m(this.kcp).getVisibility() == 0)
      {
        y.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
        FavPostVoiceUI.n(this.kcp);
        return false;
      }
    } while (FavPostVoiceUI.o(this.kcp));
    FavPostVoiceUI.p(this.kcp);
    return false;
    y.w("MicroMsg.FavPostVoiceUI", "action cancel");
    FavPostVoiceUI.n(this.kcp);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.5
 * JD-Core Version:    0.7.0.1
 */