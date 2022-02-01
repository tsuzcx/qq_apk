package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator$AnchorData;", "", "sdkUserId", "", "audioMode", "", "(Ljava/lang/String;Z)V", "getAudioMode", "()Z", "setAudioMode", "(Z)V", "getSdkUserId", "()Ljava/lang/String;", "setSdkUserId", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa$a
{
  boolean AWE;
  String mXL;
  
  private aa$a(String paramString)
  {
    AppMethodBeat.i(362444);
    this.mXL = paramString;
    this.AWE = false;
    AppMethodBeat.o(362444);
  }
  
  public final void avP(String paramString)
  {
    AppMethodBeat.i(362457);
    s.u(paramString, "<set-?>");
    this.mXL = paramString;
    AppMethodBeat.o(362457);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(362472);
    if (this == paramObject)
    {
      AppMethodBeat.o(362472);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(362472);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.mXL, paramObject.mXL))
    {
      AppMethodBeat.o(362472);
      return false;
    }
    if (this.AWE != paramObject.AWE)
    {
      AppMethodBeat.o(362472);
      return false;
    }
    AppMethodBeat.o(362472);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(362462);
    String str = "AnchorData(sdkUserId=" + this.mXL + ", audioMode=" + this.AWE + ')';
    AppMethodBeat.o(362462);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.a
 * JD-Core Version:    0.7.0.1
 */