package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$EnRecommendFeedsInfoSwitchOption;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "RECOMMEND_FEEDS_UNDEFINED", "RECOMMEND_FEEDS_CLOSE", "RECOMMEND_FEEDS_OPEN", "plugin-biz_release"})
public enum p$d
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(206308);
    d locald1 = new d("RECOMMEND_FEEDS_UNDEFINED", 0, 0);
    lrP = locald1;
    d locald2 = new d("RECOMMEND_FEEDS_CLOSE", 1, 1);
    lrQ = locald2;
    d locald3 = new d("RECOMMEND_FEEDS_OPEN", 2, 2);
    lrR = locald3;
    lrS = new d[] { locald1, locald2, locald3 };
    AppMethodBeat.o(206308);
  }
  
  private p$d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.p.d
 * JD-Core Version:    0.7.0.1
 */