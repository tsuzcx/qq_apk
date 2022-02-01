package androidx.compose.ui.m.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/style/TextGeometricTransform;", "", "scaleX", "", "skewX", "(FF)V", "getScaleX", "()F", "getSkewX", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a beu;
  private static final f bev;
  public final float bbL;
  public final float scaleX;
  
  static
  {
    AppMethodBeat.i(205072);
    beu = new f.a((byte)0);
    bev = new f(1.0F, 0.0F);
    AppMethodBeat.o(205072);
  }
  
  public f(float paramFloat1, float paramFloat2)
  {
    this.scaleX = paramFloat1;
    this.bbL = paramFloat2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof f)) {
      return false;
    }
    if (this.scaleX == ((f)paramObject).scaleX) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    if (this.bbL == ((f)paramObject).bbL) {}
    for (i = 1; i == 0; i = 0) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205082);
    int i = Float.floatToIntBits(this.scaleX);
    int j = Float.floatToIntBits(this.bbL);
    AppMethodBeat.o(205082);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205089);
    String str = "TextGeometricTransform(scaleX=" + this.scaleX + ", skewX=" + this.bbL + ')';
    AppMethodBeat.o(205089);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.f.f
 * JD-Core Version:    0.7.0.1
 */