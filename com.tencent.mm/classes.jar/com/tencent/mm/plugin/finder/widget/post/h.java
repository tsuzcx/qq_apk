package com.tencent.mm.plugin.finder.widget.post;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqr;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "", "ok", "", "type", "", "localFinderContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "videoPathBeforeCut", "", "(ZILcom/tencent/mm/protocal/protobuf/LocalFinderContent;Ljava/lang/String;)V", "getLocalFinderContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getOk", "()Z", "getType", "()I", "getVideoPathBeforeCut", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class h
{
  public final boolean dzK;
  public final String siQ;
  public final bqr sjc;
  public final int type;
  
  public h(boolean paramBoolean, int paramInt, bqr parambqr, String paramString)
  {
    AppMethodBeat.i(204895);
    this.dzK = paramBoolean;
    this.type = paramInt;
    this.sjc = parambqr;
    this.siQ = paramString;
    AppMethodBeat.o(204895);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204899);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((this.dzK != paramObject.dzK) || (this.type != paramObject.type) || (!k.g(this.sjc, paramObject.sjc)) || (!k.g(this.siQ, paramObject.siQ))) {}
      }
    }
    else
    {
      AppMethodBeat.o(204899);
      return true;
    }
    AppMethodBeat.o(204899);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204897);
    String str = "UploadData(ok=" + this.dzK + ", type=" + this.type + ", localFinderContent=" + this.sjc + ", videoPathBeforeCut=" + this.siQ + ")";
    AppMethodBeat.o(204897);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.h
 * JD-Core Version:    0.7.0.1
 */