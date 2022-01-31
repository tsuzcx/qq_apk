package com.tencent.mm.plugin.fav.ui;

import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FavPostVoiceUI$7
  implements am.a
{
  FavPostVoiceUI$7(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final boolean tC()
  {
    if (FavPostVoiceUI.q(this.kcp) == -1L) {
      FavPostVoiceUI.a(this.kcp, bk.UZ());
    }
    long l = bk.cp(FavPostVoiceUI.q(this.kcp));
    if ((l >= 3590000L) && (l <= 3600000L))
    {
      if (FavPostVoiceUI.r(this.kcp) != null) {
        break label150;
      }
      FavPostVoiceUI.a(this.kcp, Toast.makeText(this.kcp, this.kcp.getString(n.i.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
    }
    for (;;)
    {
      FavPostVoiceUI.r(this.kcp).show();
      if (l < 3600000L) {
        break;
      }
      y.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
      FavPostVoiceUI.s(this.kcp);
      FavPostVoiceUI.p(this.kcp);
      return false;
      label150:
      FavPostVoiceUI.r(this.kcp).setText(this.kcp.getString(n.i.fav_rcd_time_limit, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.7
 * JD-Core Version:    0.7.0.1
 */