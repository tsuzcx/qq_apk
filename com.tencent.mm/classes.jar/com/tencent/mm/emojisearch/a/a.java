package com.tencent.mm.emojisearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.enq;
import com.tencent.mm.protocal.protobuf.enr;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.Metadata;
import kotlin.d.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager;", "Lcom/tencent/mm/emojisearch/data/IEmojiSearchManager;", "()V", "getEmojiSearchList", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public static final a moO;
  
  static
  {
    AppMethodBeat.i(231444);
    moO = new a((byte)0);
    AppMethodBeat.o(231444);
  }
  
  public final Object a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel, d<? super enr> paramd)
  {
    AppMethodBeat.i(231446);
    enq localenq = new enq();
    localenq.YWK = paramSimilarEmojiQueryModel.query;
    localenq.absf = paramSimilarEmojiQueryModel.acrY;
    localenq.SessionId = String.valueOf(paramSimilarEmojiQueryModel.timestamp);
    localenq.aauj = paramSimilarEmojiQueryModel.acrZ;
    localenq.IJG = paramSimilarEmojiQueryModel.scene;
    paramSimilarEmojiQueryModel = com.tencent.mm.af.b.a((com.tencent.mm.am.b)new com.tencent.mm.emoji.c.b(localenq), paramd);
    AppMethodBeat.o(231446);
    return paramSimilarEmojiQueryModel;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emojisearch/data/EmojiSearchManager$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emojisearch.a.a
 * JD-Core Version:    0.7.0.1
 */