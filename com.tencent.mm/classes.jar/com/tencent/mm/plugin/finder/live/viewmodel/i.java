package com.tencent.mm.plugin.finder.live.viewmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.g;
import com.tencent.mm.protocal.protobuf.awi;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "", "localStatus", "", "localRemainTime", "haveLottering", "", "lotteryInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "lastDoneLottery", "cardShowing", "bubbleFinsh", "(IIZLcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;ZZZ)V", "getBubbleFinsh", "()Z", "setBubbleFinsh", "(Z)V", "getCardShowing", "setCardShowing", "getHaveLottering", "setHaveLottering", "getLastDoneLottery", "setLastDoneLottery", "getLocalRemainTime", "()I", "setLocalRemainTime", "(I)V", "getLocalStatus", "setLocalStatus", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
public final class i
{
  public awi tWe;
  public int uFr;
  public boolean uFs;
  public boolean uFt;
  public boolean uFu;
  public boolean uFv;
  public int uhD;
  
  public i()
  {
    this(0, 0, null, false, 127);
  }
  
  private i(int paramInt1, int paramInt2, awi paramawi, boolean paramBoolean)
  {
    this.uhD = paramInt1;
    this.uFr = paramInt2;
    this.uFs = false;
    this.tWe = paramawi;
    this.uFt = paramBoolean;
    this.uFu = false;
    this.uFv = false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(248014);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((this.uhD != paramObject.uhD) || (this.uFr != paramObject.uFr) || (this.uFs != paramObject.uFs) || (!p.j(this.tWe, paramObject.tWe)) || (this.uFt != paramObject.uFt) || (this.uFu != paramObject.uFu) || (this.uFv != paramObject.uFv)) {}
      }
    }
    else
    {
      AppMethodBeat.o(248014);
      return true;
    }
    AppMethodBeat.o(248014);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248011);
    StringBuilder localStringBuilder = new StringBuilder("localStatus:").append(this.uhD).append(",localRemainTime:").append(this.uFr).append(",haveLottering:").append(this.uFs).append(", lotteryInfo:");
    awi localawi = this.tWe;
    Object localObject = localawi;
    if (localawi == null) {
      localObject = "";
    }
    localObject = g.bN(localObject) + ",lastDoneLottery:" + this.uFt + ",cardShowing:" + this.uFu + ",bubbleFinsh:" + this.uFv;
    AppMethodBeat.o(248011);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.i
 * JD-Core Version:    0.7.0.1
 */