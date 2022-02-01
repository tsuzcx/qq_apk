package com.tencent.mm.plugin.finder.widget.post;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.djh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/post/UploadData;", "", "ok", "", "type", "", "localFinderContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "videoPathBeforeCut", "", "(ZILcom/tencent/mm/protocal/protobuf/LocalFinderContent;Ljava/lang/String;)V", "getLocalFinderContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getOk", "()Z", "getType", "()I", "getVideoPathBeforeCut", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public final String Gcs;
  public final djh HaW;
  public final boolean ifx;
  public final int type;
  
  public h(boolean paramBoolean, int paramInt, djh paramdjh, String paramString)
  {
    AppMethodBeat.i(330714);
    this.ifx = paramBoolean;
    this.type = paramInt;
    this.HaW = paramdjh;
    this.Gcs = paramString;
    AppMethodBeat.o(330714);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(330735);
    if (this == paramObject)
    {
      AppMethodBeat.o(330735);
      return true;
    }
    if (!(paramObject instanceof h))
    {
      AppMethodBeat.o(330735);
      return false;
    }
    paramObject = (h)paramObject;
    if (this.ifx != paramObject.ifx)
    {
      AppMethodBeat.o(330735);
      return false;
    }
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(330735);
      return false;
    }
    if (!s.p(this.HaW, paramObject.HaW))
    {
      AppMethodBeat.o(330735);
      return false;
    }
    if (!s.p(this.Gcs, paramObject.Gcs))
    {
      AppMethodBeat.o(330735);
      return false;
    }
    AppMethodBeat.o(330735);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(330725);
    String str = "UploadData(ok=" + this.ifx + ", type=" + this.type + ", localFinderContent=" + this.HaW + ", videoPathBeforeCut=" + this.Gcs + ')';
    AppMethodBeat.o(330725);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.h
 * JD-Core Version:    0.7.0.1
 */