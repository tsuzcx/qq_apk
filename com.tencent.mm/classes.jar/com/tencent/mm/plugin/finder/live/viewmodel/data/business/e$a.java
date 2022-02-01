package com.tencent.mm.plugin.finder.live.viewmodel.data.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acl;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/business/LiveCommonSlice$CheerInfo;", "", "hasChanged", "", "cheerIconInfos", "", "Lcom/tencent/mm/protocal/protobuf/CheerIconInfo;", "cheerIconUrl", "", "enable", "", "cheerType", "(ZLjava/util/List;Ljava/lang/String;II)V", "getCheerIconInfos", "()Ljava/util/List;", "getCheerIconUrl", "()Ljava/lang/String;", "setCheerIconUrl", "(Ljava/lang/String;)V", "getCheerType", "()I", "setCheerType", "(I)V", "getEnable", "setEnable", "getHasChanged", "()Z", "setHasChanged", "(Z)V", "clean", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$a
{
  public final List<acl> EeP;
  public String EeQ;
  public int EeR;
  public int lTH;
  public boolean tXv;
  
  private e$a(List<acl> paramList)
  {
    AppMethodBeat.i(356657);
    this.tXv = false;
    this.EeP = paramList;
    this.EeQ = null;
    this.lTH = 0;
    this.EeR = 0;
    AppMethodBeat.o(356657);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(356691);
    if (this == paramObject)
    {
      AppMethodBeat.o(356691);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(356691);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.tXv != paramObject.tXv)
    {
      AppMethodBeat.o(356691);
      return false;
    }
    if (!s.p(this.EeP, paramObject.EeP))
    {
      AppMethodBeat.o(356691);
      return false;
    }
    if (!s.p(this.EeQ, paramObject.EeQ))
    {
      AppMethodBeat.o(356691);
      return false;
    }
    if (this.lTH != paramObject.lTH)
    {
      AppMethodBeat.o(356691);
      return false;
    }
    if (this.EeR != paramObject.EeR)
    {
      AppMethodBeat.o(356691);
      return false;
    }
    AppMethodBeat.o(356691);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(356675);
    String str = "CheerInfo(hasChanged=" + this.tXv + ", cheerIconInfos=" + this.EeP + ", cheerIconUrl=" + this.EeQ + ", enable=" + this.lTH + ", cheerType=" + this.EeR + ')';
    AppMethodBeat.o(356675);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.business.e.a
 * JD-Core Version:    0.7.0.1
 */