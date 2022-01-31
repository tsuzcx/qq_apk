package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;

final class FavChatVoiceView$1
  implements View.OnClickListener
{
  FavChatVoiceView$1(FavChatVoiceView paramFavChatVoiceView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(73937);
    String str2 = FavChatVoiceView.a(this.mvQ);
    if (FavChatVoiceView.b(this.mvQ).bwz()) {}
    for (String str1 = "true";; str1 = "false")
    {
      ab.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, FavChatVoiceView.b(this.mvQ).path });
      if ((!a.bO(FavChatVoiceView.c(this.mvQ))) && (!a.bM(FavChatVoiceView.c(this.mvQ)))) {
        break;
      }
      AppMethodBeat.o(73937);
      return;
    }
    if ((!f.Mi()) && (!bo.isNullOrNil(FavChatVoiceView.a(this.mvQ))))
    {
      t.ii(paramView.getContext());
      AppMethodBeat.o(73937);
      return;
    }
    if ((bo.bf(FavChatVoiceView.a(this.mvQ), "").equals(FavChatVoiceView.b(this.mvQ).path)) && (FavChatVoiceView.b(this.mvQ).bwz()))
    {
      this.mvQ.stopPlay();
      AppMethodBeat.o(73937);
      return;
    }
    FavChatVoiceView.d(this.mvQ);
    AppMethodBeat.o(73937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView.1
 * JD-Core Version:    0.7.0.1
 */