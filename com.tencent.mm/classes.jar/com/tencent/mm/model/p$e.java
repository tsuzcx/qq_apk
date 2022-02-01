package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/model/BizTLRecFeedsDataUtil$EnRecommendFeedsInfoSwitchOption;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "RECOMMEND_FEEDS_UNDEFINED", "RECOMMEND_FEEDS_CLOSE", "RECOMMEND_FEEDS_OPEN", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum p$e
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(242069);
    ojp = new e("RECOMMEND_FEEDS_UNDEFINED", 0, 0);
    ojq = new e("RECOMMEND_FEEDS_CLOSE", 1, 1);
    ojr = new e("RECOMMEND_FEEDS_OPEN", 2, 2);
    ojs = new e[] { ojp, ojq, ojr };
    AppMethodBeat.o(242069);
  }
  
  private p$e(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.p.e
 * JD-Core Version:    0.7.0.1
 */