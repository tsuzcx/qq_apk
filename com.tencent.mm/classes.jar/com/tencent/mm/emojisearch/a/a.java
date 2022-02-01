package com.tencent.mm.emojisearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/emojisearch/data/IEmojiSearchManager;", "()V", "callback", "timeStart", "", "getEmojiSearchList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class a
  implements i, b
{
  public static final a hej;
  private i callback;
  private long hei;
  
  static
  {
    AppMethodBeat.i(200019);
    hej = new a((byte)0);
    AppMethodBeat.o(200019);
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, i parami)
  {
    AppMethodBeat.i(200017);
    p.h(paramSimilarEmojiQueryModel, "model");
    p.h(parami, "callback");
    Log.i("MicroMsg.EmojiSearch", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = parami;
    paramSimilarEmojiQueryModel = new com.tencent.mm.emojisearch.c.a(paramSimilarEmojiQueryModel);
    this.hei = System.currentTimeMillis();
    parami = g.aAg();
    p.g(parami, "MMKernel.network()");
    parami.azz().b((q)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(200017);
  }
  
  public final void awy()
  {
    AppMethodBeat.i(200015);
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().a(3793, (i)this);
    AppMethodBeat.o(200015);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200016);
    this.callback = null;
    com.tencent.mm.kernel.b localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().b(3793, (i)this);
    localb = g.aAg();
    p.g(localb, "MMKernel.network()");
    localb.azz().cancel(3793);
    AppMethodBeat.o(200016);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(200018);
    i locali = this.callback;
    if (locali != null)
    {
      locali.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(200018);
      return;
    }
    AppMethodBeat.o(200018);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emojisearch.a.a
 * JD-Core Version:    0.7.0.1
 */