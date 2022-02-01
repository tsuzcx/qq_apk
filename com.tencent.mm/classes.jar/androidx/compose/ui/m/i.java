package androidx.compose.ui.m;

import androidx.compose.ui.d.f;
import androidx.compose.ui.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/ParagraphInfo;", "", "paragraph", "Landroidx/compose/ui/text/Paragraph;", "startIndex", "", "endIndex", "startLineIndex", "endLineIndex", "top", "", "bottom", "(Landroidx/compose/ui/text/Paragraph;IIIIFF)V", "getBottom", "()F", "setBottom", "(F)V", "getEndIndex", "()I", "getEndLineIndex", "setEndLineIndex", "(I)V", "length", "getLength", "getParagraph", "()Landroidx/compose/ui/text/Paragraph;", "getStartIndex", "getStartLineIndex", "setStartLineIndex", "getTop", "setTop", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "toGlobal", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/graphics/Path;", "Landroidx/compose/ui/text/TextRange;", "toGlobal-GEjPoXI", "(J)J", "toGlobalIndex", "toGlobalLineIndex", "toGlobalYPosition", "toLocal", "Landroidx/compose/ui/geometry/Offset;", "toLocal-MK-Hz9U", "toLocalIndex", "toLocalLineIndex", "toLocalYPosition", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public final h aYY;
  int aYZ;
  int aZa;
  float bottom;
  public final int endIndex;
  public final int startIndex;
  public float top;
  
  public i(h paramh, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(204919);
    this.aYY = paramh;
    this.startIndex = paramInt1;
    this.endIndex = paramInt2;
    this.aYZ = paramInt3;
    this.aZa = paramInt4;
    this.top = paramFloat1;
    this.bottom = paramFloat2;
    AppMethodBeat.o(204919);
  }
  
  public final int jdMethod_do(int paramInt)
  {
    AppMethodBeat.i(204927);
    paramInt = k.bQ(paramInt, this.startIndex, this.endIndex);
    int i = this.startIndex;
    AppMethodBeat.o(204927);
    return paramInt - i;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204942);
    if (this == paramObject)
    {
      AppMethodBeat.o(204942);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(204942);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.aYY, paramObject.aYY))
    {
      AppMethodBeat.o(204942);
      return false;
    }
    if (this.startIndex != paramObject.startIndex)
    {
      AppMethodBeat.o(204942);
      return false;
    }
    if (this.endIndex != paramObject.endIndex)
    {
      AppMethodBeat.o(204942);
      return false;
    }
    if (this.aYZ != paramObject.aYZ)
    {
      AppMethodBeat.o(204942);
      return false;
    }
    if (this.aZa != paramObject.aZa)
    {
      AppMethodBeat.o(204942);
      return false;
    }
    if (!s.p(Float.valueOf(this.top), Float.valueOf(paramObject.top)))
    {
      AppMethodBeat.o(204942);
      return false;
    }
    if (!s.p(Float.valueOf(this.bottom), Float.valueOf(paramObject.bottom)))
    {
      AppMethodBeat.o(204942);
      return false;
    }
    AppMethodBeat.o(204942);
    return true;
  }
  
  public final int getLength()
  {
    return this.endIndex - this.startIndex;
  }
  
  public final g h(g paramg)
  {
    AppMethodBeat.i(204932);
    s.u(paramg, "<this>");
    paramg = paramg.P(f.x(0.0F, this.top));
    AppMethodBeat.o(204932);
    return paramg;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204939);
    int i = this.aYY.hashCode();
    int j = this.startIndex;
    int k = this.endIndex;
    int m = this.aYZ;
    int n = this.aZa;
    int i1 = Float.floatToIntBits(this.top);
    int i2 = Float.floatToIntBits(this.bottom);
    AppMethodBeat.o(204939);
    return (((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204935);
    String str = "ParagraphInfo(paragraph=" + this.aYY + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", startLineIndex=" + this.aYZ + ", endLineIndex=" + this.aZa + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    AppMethodBeat.o(204935);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.i
 * JD-Core Version:    0.7.0.1
 */