package com.tencent.mm.plugin.finder.widget.post;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvy;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "", "ok", "", "type", "", "localFinderContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "videoPathBeforeCut", "", "(ZILcom/tencent/mm/protocal/protobuf/LocalFinderContent;Ljava/lang/String;)V", "getLocalFinderContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getOk", "()Z", "getType", "()I", "getVideoPathBeforeCut", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class h
{
  public final boolean dNl;
  final String tqj;
  final bvy tqx;
  final int type;
  
  public h(boolean paramBoolean, int paramInt, bvy parambvy, String paramString)
  {
    AppMethodBeat.i(206444);
    this.dNl = paramBoolean;
    this.type = paramInt;
    this.tqx = parambvy;
    this.tqj = paramString;
    AppMethodBeat.o(206444);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206448);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((this.dNl != paramObject.dNl) || (this.type != paramObject.type) || (!p.i(this.tqx, paramObject.tqx)) || (!p.i(this.tqj, paramObject.tqj))) {}
      }
    }
    else
    {
      AppMethodBeat.o(206448);
      return true;
    }
    AppMethodBeat.o(206448);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206446);
    String str = "UploadData(ok=" + this.dNl + ", type=" + this.type + ", localFinderContent=" + this.tqx + ", videoPathBeforeCut=" + this.tqj + ")";
    AppMethodBeat.o(206446);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.h
 * JD-Core Version:    0.7.0.1
 */