package com.tencent.mm.plugin.fav.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.r.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.s;

final class FavChatVoiceView$1
  implements View.OnClickListener
{
  FavChatVoiceView$1(FavChatVoiceView paramFavChatVoiceView) {}
  
  public final void onClick(View paramView)
  {
    String str2 = FavChatVoiceView.a(this.kbu);
    if (FavChatVoiceView.b(this.kbu).aQk()) {}
    for (String str1 = "true";; str1 = "false")
    {
      y.i("MicroMsg.FavChatVoiceView", "clicked path:%s, player isPlay:%s, path:%s", new Object[] { str2, str1, FavChatVoiceView.b(this.kbu).path });
      if ((!a.bk(FavChatVoiceView.c(this.kbu))) && (!a.bi(FavChatVoiceView.c(this.kbu)))) {
        break;
      }
      return;
    }
    if ((!f.zF()) && (!bk.bl(FavChatVoiceView.a(this.kbu))))
    {
      s.gM(paramView.getContext());
      return;
    }
    if ((bk.aM(FavChatVoiceView.a(this.kbu), "").equals(FavChatVoiceView.b(this.kbu).path)) && (FavChatVoiceView.b(this.kbu).aQk()))
    {
      this.kbu.stopPlay();
      return;
    }
    FavChatVoiceView.d(this.kbu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavChatVoiceView.1
 * JD-Core Version:    0.7.0.1
 */