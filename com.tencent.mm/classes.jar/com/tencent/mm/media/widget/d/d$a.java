package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/util/CameraReportHelper$CameraInfo;", "", "id", "", "lens", "", "supportLevel", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getLens", "()Ljava/lang/String;", "setLens", "(Ljava/lang/String;)V", "getSupportLevel", "setSupportLevel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  private int id;
  private String nNc;
  private String nNd;
  
  public d$a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(237492);
    this.id = paramInt;
    this.nNc = paramString1;
    this.nNd = paramString2;
    AppMethodBeat.o(237492);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(237506);
    if (this == paramObject)
    {
      AppMethodBeat.o(237506);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(237506);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.id != paramObject.id)
    {
      AppMethodBeat.o(237506);
      return false;
    }
    if (!s.p(this.nNc, paramObject.nNc))
    {
      AppMethodBeat.o(237506);
      return false;
    }
    if (!s.p(this.nNd, paramObject.nNd))
    {
      AppMethodBeat.o(237506);
      return false;
    }
    AppMethodBeat.o(237506);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(237501);
    int i = this.id;
    int j = this.nNc.hashCode();
    int k = this.nNd.hashCode();
    AppMethodBeat.o(237501);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237497);
    String str = "CameraInfo(id=" + this.id + ", lens=" + this.nNc + ", supportLevel=" + this.nNd + ')';
    AppMethodBeat.o(237497);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.d.a
 * JD-Core Version:    0.7.0.1
 */