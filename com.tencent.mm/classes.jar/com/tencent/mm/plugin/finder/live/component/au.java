package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/LotteryUpdateStatus;", "", "statusChange", "", "newLottery", "localStatus", "", "lotteryStatus", "resumeState", "(ZZIIZ)V", "getLocalStatus", "()I", "setLocalStatus", "(I)V", "getLotteryStatus", "setLotteryStatus", "getNewLottery", "()Z", "setNewLottery", "(Z)V", "getResumeState", "setResumeState", "getStatusChange", "setStatusChange", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
{
  boolean CBa = false;
  boolean CBb = false;
  int CBc = 0;
  int CBd = 0;
  boolean CBe = false;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof au)) {
        return false;
      }
      paramObject = (au)paramObject;
      if (this.CBa != paramObject.CBa) {
        return false;
      }
      if (this.CBb != paramObject.CBb) {
        return false;
      }
      if (this.CBc != paramObject.CBc) {
        return false;
      }
      if (this.CBd != paramObject.CBd) {
        return false;
      }
    } while (this.CBe == paramObject.CBe);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(352720);
    String str = "LotteryUpdateStatus localStatus:" + this.CBc + ",lotteryStatus:" + this.CBd + ",statusChange:" + this.CBa + ",newLottery:" + this.CBb + ",resumeState:" + this.CBe;
    AppMethodBeat.o(352720);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.au
 * JD-Core Version:    0.7.0.1
 */