package com.tencent.mm.plugin.finder.live.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/LotteryCreateItem;", "", "title", "", "type", "", "stateEnable", "", "choose", "(Ljava/lang/String;IZZ)V", "getChoose", "()Z", "setChoose", "(Z)V", "getStateEnable", "setStateEnable", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
{
  boolean CAY;
  boolean CAZ;
  String title;
  int type;
  
  public at()
  {
    this(null, 0, false, 15);
  }
  
  private at(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(352703);
    this.title = paramString;
    this.type = paramInt;
    this.CAY = paramBoolean;
    this.CAZ = false;
    AppMethodBeat.o(352703);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(352746);
    if (this == paramObject)
    {
      AppMethodBeat.o(352746);
      return true;
    }
    if (!(paramObject instanceof at))
    {
      AppMethodBeat.o(352746);
      return false;
    }
    paramObject = (at)paramObject;
    if (!s.p(this.title, paramObject.title))
    {
      AppMethodBeat.o(352746);
      return false;
    }
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(352746);
      return false;
    }
    if (this.CAY != paramObject.CAY)
    {
      AppMethodBeat.o(352746);
      return false;
    }
    if (this.CAZ != paramObject.CAZ)
    {
      AppMethodBeat.o(352746);
      return false;
    }
    AppMethodBeat.o(352746);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(352722);
    s.u(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(352722);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(352732);
    String str = "title:" + this.title + "-type:" + this.type + "-state:" + this.CAY + "-choose:" + this.CAZ;
    AppMethodBeat.o(352732);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.at
 * JD-Core Version:    0.7.0.1
 */