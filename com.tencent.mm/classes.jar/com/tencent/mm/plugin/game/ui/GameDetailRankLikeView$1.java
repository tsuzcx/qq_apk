package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.sdk.platformtools.y;

final class GameDetailRankLikeView$1
  implements w.a
{
  GameDetailRankLikeView$1(GameDetailRankLikeView paramGameDetailRankLikeView) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView.1
 * JD-Core Version:    0.7.0.1
 */