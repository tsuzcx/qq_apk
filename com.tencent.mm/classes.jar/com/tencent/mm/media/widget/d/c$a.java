package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/util/CameraReportHelper$CameraInfo;", "", "id", "", "lens", "", "supportLevel", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "setId", "(I)V", "getLens", "()Ljava/lang/String;", "setLens", "(Ljava/lang/String;)V", "getSupportLevel", "setSupportLevel", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-mediaeditor_release"})
public final class c$a
{
  private int id;
  private String itm;
  private String itn;
  
  public c$a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(218941);
    this.id = paramInt;
    this.itm = paramString1;
    this.itn = paramString2;
    AppMethodBeat.o(218941);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(218944);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.id != paramObject.id) || (!p.j(this.itm, paramObject.itm)) || (!p.j(this.itn, paramObject.itn))) {}
      }
    }
    else
    {
      AppMethodBeat.o(218944);
      return true;
    }
    AppMethodBeat.o(218944);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(218943);
    int k = this.id;
    String str = this.itm;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      str = this.itn;
      if (str != null) {
        j = str.hashCode();
      }
      AppMethodBeat.o(218943);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(218942);
    String str = "CameraInfo(id=" + this.id + ", lens=" + this.itm + ", supportLevel=" + this.itn + ")";
    AppMethodBeat.o(218942);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.c.a
 * JD-Core Version:    0.7.0.1
 */