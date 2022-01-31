package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.game.d.bq;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class GameDetailRankLikedUI$2
  implements w.a
{
  GameDetailRankLikedUI$2(GameDetailRankLikedUI paramGameDetailRankLikedUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(111824);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e(GameDetailRankLikedUI.access$000(), "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.nxg.finish();
      AppMethodBeat.o(111824);
      return 0;
    }
    paramb = (bq)paramb.fsW.fta;
    paramString = GameDetailRankLikedUI.a(this.nxg);
    paramb = paramb.ntg;
    if (paramb != null)
    {
      paramString.nxh.clear();
      paramString.nxh.addAll(paramb);
      paramString.notifyDataSetChanged();
    }
    GameDetailRankLikedUI.b(this.nxg).dismiss();
    AppMethodBeat.o(111824);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.2
 * JD-Core Version:    0.7.0.1
 */