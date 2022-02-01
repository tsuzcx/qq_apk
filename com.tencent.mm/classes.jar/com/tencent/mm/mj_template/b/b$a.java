package com.tencent.mm.mj_template.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fxr;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/svr_model/TemplateInfoHolder$CachedTemplateListInfo;", "", "expireTime", "", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "(JLjava/util/List;)V", "getDataList", "()Ljava/util/List;", "getExpireTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b$a
{
  final List<fxr> dataList;
  final long ofU;
  
  public b$a(long paramLong, List<? extends fxr> paramList)
  {
    AppMethodBeat.i(239548);
    this.ofU = paramLong;
    this.dataList = paramList;
    AppMethodBeat.o(239548);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(239566);
    if (this == paramObject)
    {
      AppMethodBeat.o(239566);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(239566);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.ofU != paramObject.ofU)
    {
      AppMethodBeat.o(239566);
      return false;
    }
    if (!s.p(this.dataList, paramObject.dataList))
    {
      AppMethodBeat.o(239566);
      return false;
    }
    AppMethodBeat.o(239566);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(239558);
    int i = q.a..ExternalSyntheticBackport0.m(this.ofU);
    int j = this.dataList.hashCode();
    AppMethodBeat.o(239558);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239551);
    String str = "CachedTemplateListInfo(expireTime=" + this.ofU + ", dataList=" + this.dataList + ')';
    AppMethodBeat.o(239551);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.b.b.a
 * JD-Core Version:    0.7.0.1
 */