package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveOlympicsSlice$OlympicBaseData;", "", "isStart", "", "certId", "", "torcherCount", "isTorcher", "hasLightTorch", "joinRunCount", "certName", "", "(ZJJZZJLjava/lang/String;)V", "getCertId", "()J", "setCertId", "(J)V", "getCertName", "()Ljava/lang/String;", "setCertName", "(Ljava/lang/String;)V", "getHasLightTorch", "()Z", "setHasLightTorch", "(Z)V", "setStart", "setTorcher", "getJoinRunCount", "setJoinRunCount", "getTorcherCount", "setTorcherCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n$e
{
  public long CPl;
  public long EhH;
  public boolean EhI;
  public boolean EhJ;
  private long EhK;
  public String akhd;
  public boolean isStart;
  
  public n$e(boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, boolean paramBoolean3, long paramLong3, String paramString)
  {
    this.isStart = paramBoolean1;
    this.CPl = paramLong1;
    this.EhH = paramLong2;
    this.EhI = paramBoolean2;
    this.EhJ = paramBoolean3;
    this.EhK = paramLong3;
    this.akhd = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(371758);
    if (this == paramObject)
    {
      AppMethodBeat.o(371758);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(371758);
      return false;
    }
    paramObject = (e)paramObject;
    if (this.isStart != paramObject.isStart)
    {
      AppMethodBeat.o(371758);
      return false;
    }
    if (this.CPl != paramObject.CPl)
    {
      AppMethodBeat.o(371758);
      return false;
    }
    if (this.EhH != paramObject.EhH)
    {
      AppMethodBeat.o(371758);
      return false;
    }
    if (this.EhI != paramObject.EhI)
    {
      AppMethodBeat.o(371758);
      return false;
    }
    if (this.EhJ != paramObject.EhJ)
    {
      AppMethodBeat.o(371758);
      return false;
    }
    if (this.EhK != paramObject.EhK)
    {
      AppMethodBeat.o(371758);
      return false;
    }
    if (!s.p(this.akhd, paramObject.akhd))
    {
      AppMethodBeat.o(371758);
      return false;
    }
    AppMethodBeat.o(371758);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356800);
    String str = "OlympicBaseData(isStart=" + this.isStart + ", certId=" + this.CPl + ", torcherCount=" + this.EhH + ", isTorcher=" + this.EhI + ", hasLightTorch=" + this.EhJ + ", joinRunCount=" + this.EhK + ", certName=" + this.akhd + ')';
    AppMethodBeat.o(356800);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.n.e
 * JD-Core Version:    0.7.0.1
 */