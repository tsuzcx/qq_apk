package com.tencent.mm.plugin.finder.widget.post;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjk;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "", "ok", "", "type", "", "localFinderContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "videoPathBeforeCut", "", "(ZILcom/tencent/mm/protocal/protobuf/LocalFinderContent;Ljava/lang/String;)V", "getLocalFinderContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getOk", "()Z", "getType", "()I", "getVideoPathBeforeCut", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class g
{
  public final boolean efd;
  final int type;
  final String vTB;
  public final cjk wDD;
  
  public g(boolean paramBoolean, int paramInt, cjk paramcjk, String paramString)
  {
    AppMethodBeat.i(256151);
    this.efd = paramBoolean;
    this.type = paramInt;
    this.wDD = paramcjk;
    this.vTB = paramString;
    AppMethodBeat.o(256151);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256155);
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((this.efd != paramObject.efd) || (this.type != paramObject.type) || (!p.j(this.wDD, paramObject.wDD)) || (!p.j(this.vTB, paramObject.vTB))) {}
      }
    }
    else
    {
      AppMethodBeat.o(256155);
      return true;
    }
    AppMethodBeat.o(256155);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256153);
    String str = "UploadData(ok=" + this.efd + ", type=" + this.type + ", localFinderContent=" + this.wDD + ", videoPathBeforeCut=" + this.vTB + ")";
    AppMethodBeat.o(256153);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g
 * JD-Core Version:    0.7.0.1
 */