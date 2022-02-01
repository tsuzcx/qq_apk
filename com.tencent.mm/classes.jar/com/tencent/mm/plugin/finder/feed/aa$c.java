package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator$MicUserInfo;", "", "liveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "selfRoom", "", "micType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;ZI)V", "getLiveContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "setLiveContact", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;)V", "getMicType", "()I", "setMicType", "(I)V", "getSelfRoom", "()Z", "setSelfRoom", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa$c
{
  bgh AWF;
  boolean AWG;
  int mXM;
  
  public aa$c(bgh parambgh, boolean paramBoolean, int paramInt)
  {
    this.AWF = parambgh;
    this.AWG = paramBoolean;
    this.mXM = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(362458);
    if (this == paramObject)
    {
      AppMethodBeat.o(362458);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(362458);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.AWF, paramObject.AWF))
    {
      AppMethodBeat.o(362458);
      return false;
    }
    if (this.AWG != paramObject.AWG)
    {
      AppMethodBeat.o(362458);
      return false;
    }
    if (this.mXM != paramObject.mXM)
    {
      AppMethodBeat.o(362458);
      return false;
    }
    AppMethodBeat.o(362458);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(362445);
    String str = "MicUserInfo(liveContact=" + this.AWF + ", selfRoom=" + this.AWG + ", micType=" + this.mXM + ')';
    AppMethodBeat.o(362445);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.c
 * JD-Core Version:    0.7.0.1
 */