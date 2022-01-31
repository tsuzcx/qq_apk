package com.tencent.mm.plugin.fav.ui;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

final class FavPostVoiceUI$5
  implements View.OnTouchListener
{
  FavPostVoiceUI$5(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(74045);
    if (paramView != FavPostVoiceUI.g(this.mxa))
    {
      AppMethodBeat.o(74045);
      return false;
    }
    int i = (int)paramMotionEvent.getRawY();
    paramView = new int[2];
    FavPostVoiceUI.a(this.mxa, this.mxa.getResources().getDisplayMetrics().heightPixels);
    FavPostVoiceUI.g(this.mxa).getLocationOnScreen(paramView);
    int j = paramView[1];
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(74045);
      return false;
      if (!FavPostVoiceUI.h(this.mxa))
      {
        FavPostVoiceUI.i(this.mxa);
        FavPostVoiceUI.j(this.mxa);
        continue;
        int k = BackwardSupportUtil.b.b(this.mxa, 60.0F);
        if ((i <= FavPostVoiceUI.k(this.mxa) - k) && (i < j))
        {
          FavPostVoiceUI.l(this.mxa).setVisibility(8);
          FavPostVoiceUI.m(this.mxa).setVisibility(0);
        }
        else
        {
          FavPostVoiceUI.l(this.mxa).setVisibility(0);
          FavPostVoiceUI.m(this.mxa).setVisibility(8);
          continue;
          if (!FavPostVoiceUI.h(this.mxa))
          {
            AppMethodBeat.o(74045);
            return false;
          }
          if (FavPostVoiceUI.m(this.mxa).getVisibility() == 0)
          {
            ab.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
            FavPostVoiceUI.n(this.mxa);
          }
          else if (!FavPostVoiceUI.o(this.mxa))
          {
            FavPostVoiceUI.p(this.mxa);
            continue;
            ab.w("MicroMsg.FavPostVoiceUI", "action cancel");
            FavPostVoiceUI.n(this.mxa);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.5
 * JD-Core Version:    0.7.0.1
 */