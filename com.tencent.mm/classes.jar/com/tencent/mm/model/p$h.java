package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$GetRecommendFeedsStyleFlag;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "GET_RECOMMEND_FEEDS_STYLE_FLAG_BIG", "GET_RECOMMEND_FEEDS_STYLE_FLAG_SMALL", "GET_RECOMMEND_FEEDS_STYLE_FLAG_THREE", "GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_BIG", "GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_SMALL", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum p$h
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(242035);
    ojC = new h("GET_RECOMMEND_FEEDS_STYLE_FLAG_BIG", 0, 0);
    ojD = new h("GET_RECOMMEND_FEEDS_STYLE_FLAG_SMALL", 1, 1);
    ojE = new h("GET_RECOMMEND_FEEDS_STYLE_FLAG_THREE", 2, 2);
    ojF = new h("GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_BIG", 3, 3);
    ojG = new h("GET_RECOMMEND_FEEDS_STYLE_FLAG_CONTENT_SMALL", 4, 4);
    ojH = new h[] { ojC, ojD, ojE, ojF, ojG };
    AppMethodBeat.o(242035);
  }
  
  private p$h(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.p.h
 * JD-Core Version:    0.7.0.1
 */