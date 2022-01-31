package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.game.d.bp;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class GameDetailRankLikedUI$2
  implements w.a
{
  GameDetailRankLikedUI$2(GameDetailRankLikedUI paramGameDetailRankLikedUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e(GameDetailRankLikedUI.access$000(), "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      this.kZj.finish();
      return 0;
    }
    paramb = (bp)paramb.ecF.ecN;
    paramString = GameDetailRankLikedUI.a(this.kZj);
    paramb = paramb.kVe;
    if (paramb != null)
    {
      paramString.kZk.clear();
      paramString.kZk.addAll(paramb);
      paramString.notifyDataSetChanged();
    }
    GameDetailRankLikedUI.b(this.kZj).dismiss();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikedUI.2
 * JD-Core Version:    0.7.0.1
 */