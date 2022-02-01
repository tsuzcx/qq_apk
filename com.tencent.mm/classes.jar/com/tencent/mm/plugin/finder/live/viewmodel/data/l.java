package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.protocal.protobuf.bal;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "", "localStatus", "", "localRemainTime", "haveLottering", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "lastDoneLottery", "cardShowing", "bubbleFinsh", "(IIZLcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;ZZZ)V", "getBubbleFinsh", "()Z", "setBubbleFinsh", "(Z)V", "getCardShowing", "setCardShowing", "getHaveLottering", "setHaveLottering", "getLastDoneLottery", "setLastDoneLottery", "getLocalRemainTime", "()I", "setLocalRemainTime", "(I)V", "getLocalStatus", "setLocalStatus", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-base_release"})
public final class l
{
  public bal xHW;
  public int ycO;
  public int zeO;
  public boolean zeP;
  public boolean zeQ;
  public boolean zeR;
  public boolean zeS;
  
  public l()
  {
    this(0, 0, null, false, 127);
  }
  
  private l(int paramInt1, int paramInt2, bal parambal, boolean paramBoolean)
  {
    this.ycO = paramInt1;
    this.zeO = paramInt2;
    this.zeP = false;
    this.xHW = parambal;
    this.zeQ = paramBoolean;
    this.zeR = false;
    this.zeS = false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(258945);
    if (this != paramObject)
    {
      if ((paramObject instanceof l))
      {
        paramObject = (l)paramObject;
        if ((this.ycO != paramObject.ycO) || (this.zeO != paramObject.zeO) || (this.zeP != paramObject.zeP) || (!p.h(this.xHW, paramObject.xHW)) || (this.zeQ != paramObject.zeQ) || (this.zeR != paramObject.zeR) || (this.zeS != paramObject.zeS)) {}
      }
    }
    else
    {
      AppMethodBeat.o(258945);
      return true;
    }
    AppMethodBeat.o(258945);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258939);
    StringBuilder localStringBuilder = new StringBuilder("localStatus:").append(this.ycO).append(",localRemainTime:").append(this.zeO).append(",haveLottering:").append(this.zeP).append(", lotteryInfo:");
    bal localbal = this.xHW;
    Object localObject = localbal;
    if (localbal == null) {
      localObject = "";
    }
    localObject = g.bN(localObject) + ",lastDoneLottery:" + this.zeQ + ",cardShowing:" + this.zeR + ",bubbleFinsh:" + this.zeS;
    AppMethodBeat.o(258939);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.l
 * JD-Core Version:    0.7.0.1
 */