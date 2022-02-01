package com.tencent.mm.plugin.fav.ui.detail;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidMediaUtil;

final class FavoriteFileDetailUI$10
  implements p.a
{
  FavoriteFileDetailUI$10(FavoriteFileDetailUI paramFavoriteFileDetailUI, String paramString) {}
  
  public final void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235325);
    Log.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", new Object[] { Integer.valueOf(hashCode()), this.cJK, paramString2 });
    Toast.makeText(this.tie.cWv(), this.tie.getString(2131767076, new Object[] { AndroidMediaUtil.getFriendlySdcardPath(paramString2) }), 1).show();
    s.refreshMediaScanner(paramString2, this.tie.cWv());
    AppMethodBeat.o(235325);
  }
  
  public final void bQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(235326);
    Log.i("MicroMsg.FavoriteFileDetailUI", "%d save video now video path %s out path %s", new Object[] { Integer.valueOf(hashCode()), this.cJK, paramString2 });
    Toast.makeText(this.tie.cWv(), this.tie.getString(2131767075), 1).show();
    AppMethodBeat.o(235326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteFileDetailUI.10
 * JD-Core Version:    0.7.0.1
 */