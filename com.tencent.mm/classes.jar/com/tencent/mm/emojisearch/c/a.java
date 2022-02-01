package com.tencent.mm.emojisearch.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.dut;
import com.tencent.mm.search.data.SimilarEmojiQueryModel;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emojisearch/model/NetSceneSearchEmoji;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "model", "Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;", "(Lcom/tencent/mm/search/data/SimilarEmojiQueryModel;)V", "mCallback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "callback", "getEmojiSearchList", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "getSessionId", "", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-emojisdk_release"})
public final class a
  extends q
  implements m
{
  public static final a jQh;
  private i jQg;
  public final d rr;
  
  static
  {
    AppMethodBeat.i(228121);
    jQh = new a((byte)0);
    AppMethodBeat.o(228121);
  }
  
  public a(SimilarEmojiQueryModel paramSimilarEmojiQueryModel)
  {
    AppMethodBeat.i(228119);
    Object localObject = new d.a();
    ((d.a)localObject).c((com.tencent.mm.cd.a)new dus());
    ((d.a)localObject).d((com.tencent.mm.cd.a)new dut());
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/mmrecommendpanelemoji");
    ((d.a)localObject).vD(3793);
    ((d.a)localObject).vF(0);
    ((d.a)localObject).vG(0);
    localObject = ((d.a)localObject).bgN();
    p.j(localObject, "builder.buildInstance()");
    this.rr = ((d)localObject);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(228119);
      throw paramSimilarEmojiQueryModel;
    }
    ((dus)localObject).RYJ = paramSimilarEmojiQueryModel.query;
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(228119);
      throw paramSimilarEmojiQueryModel;
    }
    ((dus)localObject).UaY = paramSimilarEmojiQueryModel.UWL;
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(228119);
      throw paramSimilarEmojiQueryModel;
    }
    ((dus)localObject).SessionId = String.valueOf(paramSimilarEmojiQueryModel.timestamp);
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(228119);
      throw paramSimilarEmojiQueryModel;
    }
    ((dus)localObject).TgT = paramSimilarEmojiQueryModel.UWM;
    localObject = this.rr.bhX();
    if (localObject == null)
    {
      paramSimilarEmojiQueryModel = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.RecommendPanelEmojiRequest");
      AppMethodBeat.o(228119);
      throw paramSimilarEmojiQueryModel;
    }
    ((dus)localObject).CPw = paramSimilarEmojiQueryModel.scene;
    AppMethodBeat.o(228119);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(228107);
    this.jQg = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(228107);
    return i;
  }
  
  public final int getType()
  {
    return 3793;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(228111);
    params = this.jQg;
    if (params != null)
    {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
      AppMethodBeat.o(228111);
      return;
    }
    AppMethodBeat.o(228111);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emojisearch/model/NetSceneSearchEmoji$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emojisearch.c.a
 * JD-Core Version:    0.7.0.1
 */