package com.tencent.mm.mj_template.album_template.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/widget/TextLayoutInfo;", "", "textWidth", "", "containerWidth", "(II)V", "getContainerWidth", "()I", "getTextWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
final class h
{
  final int nZc;
  final int nZd;
  
  public h(int paramInt1, int paramInt2)
  {
    this.nZc = paramInt1;
    this.nZd = paramInt2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof h)) {
        return false;
      }
      paramObject = (h)paramObject;
      if (this.nZc != paramObject.nZc) {
        return false;
      }
    } while (this.nZd == paramObject.nZd);
    return false;
  }
  
  public final int hashCode()
  {
    return this.nZc * 31 + this.nZd;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(240578);
    String str = "TextLayoutInfo(textWidth=" + this.nZc + ", containerWidth=" + this.nZd + ')';
    AppMethodBeat.o(240578);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a.h
 * JD-Core Version:    0.7.0.1
 */