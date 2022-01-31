package com.tencent.mm.plugin.fav.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;

final class FavPostVoiceUI$7
  implements ap.a
{
  FavPostVoiceUI$7(FavPostVoiceUI paramFavPostVoiceUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(74047);
    if (FavPostVoiceUI.q(this.mxa) == -1L) {
      FavPostVoiceUI.a(this.mxa, bo.yB());
    }
    long l = bo.av(FavPostVoiceUI.q(this.mxa));
    if ((l >= 3590000L) && (l <= 3600000L))
    {
      if (FavPostVoiceUI.r(this.mxa) != null) {
        break label159;
      }
      FavPostVoiceUI.a(this.mxa, Toast.makeText(this.mxa, this.mxa.getString(2131299677, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }), 0));
    }
    for (;;)
    {
      FavPostVoiceUI.r(this.mxa).show();
      if (l < 3600000L) {
        break;
      }
      ab.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
      FavPostVoiceUI.s(this.mxa);
      FavPostVoiceUI.p(this.mxa);
      AppMethodBeat.o(74047);
      return false;
      label159:
      FavPostVoiceUI.r(this.mxa).setText(this.mxa.getString(2131299677, new Object[] { Integer.valueOf((int)((3600000L - l) / 1000L)) }));
    }
    AppMethodBeat.o(74047);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.7
 * JD-Core Version:    0.7.0.1
 */