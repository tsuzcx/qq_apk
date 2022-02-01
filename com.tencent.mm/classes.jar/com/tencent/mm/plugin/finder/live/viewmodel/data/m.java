package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.protocal.protobuf.bjc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/LotteryInfoWrapper;", "", "localStatus", "", "localRemainTime", "haveLottering", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "lastDoneLottery", "cardShowing", "bubbleFinsh", "(IIZLcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;ZZZ)V", "getBubbleFinsh", "()Z", "setBubbleFinsh", "(Z)V", "getCardShowing", "setCardShowing", "getHaveLottering", "setHaveLottering", "getLastDoneLottery", "setLastDoneLottery", "getLocalRemainTime", "()I", "setLocalRemainTime", "(I)V", "getLocalStatus", "setLocalStatus", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public bjc Bhm;
  public int CBc;
  public int EbT;
  public boolean EbU;
  public boolean EbV;
  public boolean EbW;
  public boolean EbX;
  
  public m()
  {
    this(0, 0, null, false, 127);
  }
  
  private m(int paramInt1, int paramInt2, bjc parambjc, boolean paramBoolean)
  {
    this.CBc = paramInt1;
    this.EbT = paramInt2;
    this.EbU = false;
    this.Bhm = parambjc;
    this.EbV = paramBoolean;
    this.EbW = false;
    this.EbX = false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356871);
    if (this == paramObject)
    {
      AppMethodBeat.o(356871);
      return true;
    }
    if (!(paramObject instanceof m))
    {
      AppMethodBeat.o(356871);
      return false;
    }
    paramObject = (m)paramObject;
    if (this.CBc != paramObject.CBc)
    {
      AppMethodBeat.o(356871);
      return false;
    }
    if (this.EbT != paramObject.EbT)
    {
      AppMethodBeat.o(356871);
      return false;
    }
    if (this.EbU != paramObject.EbU)
    {
      AppMethodBeat.o(356871);
      return false;
    }
    if (!s.p(this.Bhm, paramObject.Bhm))
    {
      AppMethodBeat.o(356871);
      return false;
    }
    if (this.EbV != paramObject.EbV)
    {
      AppMethodBeat.o(356871);
      return false;
    }
    if (this.EbW != paramObject.EbW)
    {
      AppMethodBeat.o(356871);
      return false;
    }
    if (this.EbX != paramObject.EbX)
    {
      AppMethodBeat.o(356871);
      return false;
    }
    AppMethodBeat.o(356871);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356856);
    StringBuilder localStringBuilder = new StringBuilder("localStatus:").append(this.CBc).append(",localRemainTime:").append(this.EbT).append(",haveLottering:").append(this.EbU).append(", lotteryInfo:");
    bjc localbjc = this.Bhm;
    Object localObject = localbjc;
    if (localbjc == null) {
      localObject = "";
    }
    localObject = f.dg(localObject) + ",lastDoneLottery:" + this.EbV + ",cardShowing:" + this.EbW + ",bubbleFinsh:" + this.EbX;
    AppMethodBeat.o(356856);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.m
 * JD-Core Version:    0.7.0.1
 */