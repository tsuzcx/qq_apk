package com.tencent.mm.plugin.finder.view;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bgh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper$PopupMenuConfig;", "", "anchorView", "Landroid/view/View;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "isAssistant", "", "enableCustomMenuColor", "isBox", "boxId", "", "likeComment", "(Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;ZZZLjava/lang/String;Ljava/lang/String;)V", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "getBoxId", "()Ljava/lang/String;", "setBoxId", "(Ljava/lang/String;)V", "getContact", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getEnableCustomMenuColor", "()Z", "setEnableCustomMenuColor", "(Z)V", "setBox", "getLikeComment", "setLikeComment", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$a
{
  final boolean DUe;
  final bgh Ddj;
  String adma;
  View aeMz;
  boolean akil;
  boolean akim;
  String akin;
  
  public i$a(View paramView, bgh parambgh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(370608);
    this.aeMz = paramView;
    this.Ddj = parambgh;
    this.DUe = paramBoolean1;
    this.akil = paramBoolean2;
    this.akim = paramBoolean3;
    this.adma = paramString1;
    this.akin = paramString2;
    AppMethodBeat.o(370608);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(370615);
    if (this == paramObject)
    {
      AppMethodBeat.o(370615);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(370615);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.aeMz, paramObject.aeMz))
    {
      AppMethodBeat.o(370615);
      return false;
    }
    if (!s.p(this.Ddj, paramObject.Ddj))
    {
      AppMethodBeat.o(370615);
      return false;
    }
    if (this.DUe != paramObject.DUe)
    {
      AppMethodBeat.o(370615);
      return false;
    }
    if (this.akil != paramObject.akil)
    {
      AppMethodBeat.o(370615);
      return false;
    }
    if (this.akim != paramObject.akim)
    {
      AppMethodBeat.o(370615);
      return false;
    }
    if (!s.p(this.adma, paramObject.adma))
    {
      AppMethodBeat.o(370615);
      return false;
    }
    if (!s.p(this.akin, paramObject.akin))
    {
      AppMethodBeat.o(370615);
      return false;
    }
    AppMethodBeat.o(370615);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(370612);
    String str = "PopupMenuConfig(anchorView=" + this.aeMz + ", contact=" + this.Ddj + ", isAssistant=" + this.DUe + ", enableCustomMenuColor=" + this.akil + ", isBox=" + this.akim + ", boxId=" + this.adma + ", likeComment=" + this.akin + ')';
    AppMethodBeat.o(370612);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.i.a
 * JD-Core Version:    0.7.0.1
 */