package com.tencent.mm.plugin.fts.ui.hotsearch.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/SearchEducationItem;", "", "businessType", "", "hotword", "", "optType", "(ILjava/lang/String;I)V", "getBusinessType", "()I", "ftsNeedHideKeyBoard", "", "getFtsNeedHideKeyBoard", "()Z", "setFtsNeedHideKeyBoard", "(Z)V", "getHotword", "()Ljava/lang/String;", "getOptType", "showRedDot", "getShowRedDot", "setShowRedDot", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final int CvB;
  public final String Hzu;
  public boolean Hzv;
  public final int businessType;
  public boolean iaS;
  
  public c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(265737);
    this.businessType = paramInt1;
    this.Hzu = paramString;
    this.CvB = paramInt2;
    AppMethodBeat.o(265737);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(265749);
    if (this == paramObject)
    {
      AppMethodBeat.o(265749);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(265749);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.businessType != paramObject.businessType)
    {
      AppMethodBeat.o(265749);
      return false;
    }
    if (!s.p(this.Hzu, paramObject.Hzu))
    {
      AppMethodBeat.o(265749);
      return false;
    }
    if (this.CvB != paramObject.CvB)
    {
      AppMethodBeat.o(265749);
      return false;
    }
    AppMethodBeat.o(265749);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(265745);
    int i = this.businessType;
    int j = this.Hzu.hashCode();
    int k = this.CvB;
    AppMethodBeat.o(265745);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(265741);
    String str = "SearchEducationItem(businessType=" + this.businessType + ", hotword=" + this.Hzu + ", optType=" + this.CvB + ')';
    AppMethodBeat.o(265741);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.a.c
 * JD-Core Version:    0.7.0.1
 */