package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedsStyleFlag;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "GET_RECOMMEND_FEEDS_STYLE_FLAG_BIG", "GET_RECOMMEND_FEEDS_STYLE_FLAG_SMALL", "GET_RECOMMEND_FEEDS_STYLE_FLAG_THREE", "GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_BIG", "GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_SMALL", "plugin-biz_release"})
public enum p$g
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(207823);
    g localg1 = new g("GET_RECOMMEND_FEEDS_STYLE_FLAG_BIG", 0, 0);
    lsb = localg1;
    g localg2 = new g("GET_RECOMMEND_FEEDS_STYLE_FLAG_SMALL", 1, 1);
    lsc = localg2;
    g localg3 = new g("GET_RECOMMEND_FEEDS_STYLE_FLAG_THREE", 2, 2);
    lsd = localg3;
    g localg4 = new g("GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_BIG", 3, 3);
    lse = localg4;
    g localg5 = new g("GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_SMALL", 4, 4);
    lsg = localg5;
    lsh = new g[] { localg1, localg2, localg3, localg4, localg5 };
    AppMethodBeat.o(207823);
  }
  
  private p$g(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.p.g
 * JD-Core Version:    0.7.0.1
 */