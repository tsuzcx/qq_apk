package com.tencent.mm.msgsubscription.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "alwaysKeep", "getAlwaysKeep", "()Z", "setAlwaysKeep", "(Z)V", "getCheck", "setCheck", "getSampleWordings", "()Ljava/util/ArrayList;", "getTemplateId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "wxbiz-msgsubscription-sdk_release"})
public final class b$b
{
  public final String hDH;
  boolean iGu;
  public boolean iGv;
  final ArrayList<o<String, String>> iGw;
  final String title;
  
  public b$b(boolean paramBoolean, String paramString1, ArrayList<o<String, String>> paramArrayList, String paramString2)
  {
    AppMethodBeat.i(149742);
    this.iGv = paramBoolean;
    this.title = paramString1;
    this.iGw = paramArrayList;
    this.hDH = paramString2;
    AppMethodBeat.o(149742);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(149745);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.iGv != paramObject.iGv) || (!p.i(this.title, paramObject.title)) || (!p.i(this.iGw, paramObject.iGw)) || (!p.i(this.hDH, paramObject.hDH))) {}
      }
    }
    else
    {
      AppMethodBeat.o(149745);
      return true;
    }
    AppMethodBeat.o(149745);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149743);
    String str = "Item(check=" + this.iGv + ", title=" + this.title + ", sampleWordings=" + this.iGw + ", templateId=" + this.hDH + ")";
    AppMethodBeat.o(149743);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b.b
 * JD-Core Version:    0.7.0.1
 */