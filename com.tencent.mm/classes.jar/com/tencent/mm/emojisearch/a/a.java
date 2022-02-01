package com.tencent.mm.emojisearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/emojisearch/data/IEmojiSearchManager;", "()V", "callback", "timeStart", "", "getEmojiSearchList", "", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "onCrate", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-emojisdk_release"})
public final class a
  implements i, b
{
  public static final a jPZ;
  private i callback;
  private long jPY;
  
  static
  {
    AppMethodBeat.i(224227);
    jPZ = new a((byte)0);
    AppMethodBeat.o(224227);
  }
  
  public final void a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, i parami)
  {
    AppMethodBeat.i(224222);
    p.k(paramSimilarEmojiQueryModel, "model");
    p.k(parami, "callback");
    Log.i("MicroMsg.EmojiSearch", "do net request:[" + paramSimilarEmojiQueryModel + ']');
    this.callback = parami;
    paramSimilarEmojiQueryModel = new com.tencent.mm.emojisearch.c.a(paramSimilarEmojiQueryModel);
    this.jPY = System.currentTimeMillis();
    parami = h.aHF();
    p.j(parami, "MMKernel.network()");
    parami.aGY().b((q)paramSimilarEmojiQueryModel);
    AppMethodBeat.o(224222);
  }
  
  public final void aDP()
  {
    AppMethodBeat.i(224212);
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().a(3793, (i)this);
    AppMethodBeat.o(224212);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(224215);
    this.callback = null;
    c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b(3793, (i)this);
    localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().cancel(3793);
    AppMethodBeat.o(224215);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(224225);
    i locali = this.callback;
    if (locali != null)
    {
      locali.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(224225);
      return;
    }
    AppMethodBeat.o(224225);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emojisearch.a.a
 * JD-Core Version:    0.7.0.1
 */