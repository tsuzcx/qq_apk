package com.tencent.mm.mj_template.maas.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byy;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/TemplateResult;", "", "result", "", "path", "", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getResult", "()I", "getTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "setTemplateInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final int Ue;
  public static final a obn;
  public byy obo;
  public String path;
  public final int result;
  
  static
  {
    AppMethodBeat.i(239989);
    obn = new a((byte)0);
    Ue = 8;
    AppMethodBeat.o(239989);
  }
  
  public f(int paramInt, String paramString, byy parambyy)
  {
    this.result = paramInt;
    this.path = paramString;
    this.obo = parambyy;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(240019);
    if (this == paramObject)
    {
      AppMethodBeat.o(240019);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(240019);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.result != paramObject.result)
    {
      AppMethodBeat.o(240019);
      return false;
    }
    if (!s.p(this.path, paramObject.path))
    {
      AppMethodBeat.o(240019);
      return false;
    }
    if (!s.p(this.obo, paramObject.obo))
    {
      AppMethodBeat.o(240019);
      return false;
    }
    AppMethodBeat.o(240019);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(240008);
    int k = this.result;
    int i;
    if (this.path == null)
    {
      i = 0;
      if (this.obo != null) {
        break label56;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(240008);
      return (i + k * 31) * 31 + j;
      i = this.path.hashCode();
      break;
      label56:
      j = this.obo.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239997);
    String str = "TemplateResult(result=" + this.result + ", path=" + this.path + ", templateInfo=" + this.obo + ')';
    AppMethodBeat.o(239997);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/maas/record/TemplateResult$Companion;", "", "()V", "getErrorResult", "Lcom/tencent/mm/mj_template/maas/record/TemplateResult;", "result", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static f Ee(int paramInt)
    {
      AppMethodBeat.i(369579);
      f localf = new f(paramInt, null, null);
      AppMethodBeat.o(369579);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.mj_template.maas.a.f
 * JD-Core Version:    0.7.0.1
 */