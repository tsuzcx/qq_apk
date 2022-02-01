package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$EnRecommendFeedsInfoSwitchOption;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "RECOMMEND_FEEDS_UNDEFINED", "RECOMMEND_FEEDS_CLOSE", "RECOMMEND_FEEDS_OPEN", "plugin-biz_release"})
public enum p$c
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(212392);
    c localc1 = new c("RECOMMEND_FEEDS_UNDEFINED", 0, 0);
    iCf = localc1;
    c localc2 = new c("RECOMMEND_FEEDS_CLOSE", 1, 1);
    iCg = localc2;
    c localc3 = new c("RECOMMEND_FEEDS_OPEN", 2, 2);
    iCh = localc3;
    iCi = new c[] { localc1, localc2, localc3 };
    AppMethodBeat.o(212392);
  }
  
  private p$c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.p.c
 * JD-Core Version:    0.7.0.1
 */