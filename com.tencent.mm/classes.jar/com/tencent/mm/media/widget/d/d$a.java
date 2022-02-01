package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/util/CameraReportHelper$CameraInfo;", "", "id", "", "lens", "", "supportLevel", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getLens", "()Ljava/lang/String;", "setLens", "(Ljava/lang/String;)V", "getSupportLevel", "setSupportLevel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-mediaeditor_release"})
public final class d$a
{
  private int id;
  private String liu;
  private String liv;
  
  public d$a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(259335);
    this.id = paramInt;
    this.liu = paramString1;
    this.liv = paramString2;
    AppMethodBeat.o(259335);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(259338);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.id != paramObject.id) || (!p.h(this.liu, paramObject.liu)) || (!p.h(this.liv, paramObject.liv))) {}
      }
    }
    else
    {
      AppMethodBeat.o(259338);
      return true;
    }
    AppMethodBeat.o(259338);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(259337);
    int k = this.id;
    String str = this.liu;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.liv;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(259337);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(259336);
    String str = "CameraInfo(id=" + this.id + ", lens=" + this.liu + ", supportLevel=" + this.liv + ")";
    AppMethodBeat.o(259336);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.d.a
 * JD-Core Version:    0.7.0.1
 */