package com.tencent.mm.plugin.game.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

final class GameDetailRankLikeView$1
  implements aa.a
{
  GameDetailRankLikeView$1(GameDetailRankLikeView paramGameDetailRankLikeView) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(41986);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(41986);
      return 0;
    }
    AppMethodBeat.o(41986);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameDetailRankLikeView.1
 * JD-Core Version:    0.7.0.1
 */