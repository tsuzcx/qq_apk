package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.s;

final class FavVoiceBaseView$2
  implements View.OnClickListener
{
  FavVoiceBaseView$2(FavVoiceBaseView paramFavVoiceBaseView) {}
  
  public final void onClick(View paramView)
  {
    if ((a.bk(paramView.getContext())) || (a.bi(paramView.getContext()))) {}
    do
    {
      return;
      if ((!f.zF()) && (!bk.bl(FavVoiceBaseView.g(this.kdF))))
      {
        s.gM(paramView.getContext());
        return;
      }
      if (!bk.aM(FavVoiceBaseView.g(this.kdF), "").equals(FavVoiceBaseView.h(this.kdF).path))
      {
        FavVoiceBaseView.i(this.kdF);
        return;
      }
      if (FavVoiceBaseView.h(this.kdF).aQk())
      {
        this.kdF.aQm();
        return;
      }
    } while (FavVoiceBaseView.j(this.kdF));
    FavVoiceBaseView.i(this.kdF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavVoiceBaseView.2
 * JD-Core Version:    0.7.0.1
 */