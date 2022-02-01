package androidx.compose.ui.m.a.b;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/ShadowSpan;", "Landroid/text/style/CharacterStyle;", "color", "", "offsetX", "", "offsetY", "radius", "(IFFF)V", "getColor", "()I", "getOffsetX", "()F", "getOffsetY", "getRadius", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends CharacterStyle
{
  private final float bbJ;
  private final float bbK;
  private final int color;
  private final float radius;
  
  public g(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.color = paramInt;
    this.bbJ = paramFloat1;
    this.bbK = paramFloat2;
    this.radius = paramFloat3;
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205211);
    s.u(paramTextPaint, "tp");
    paramTextPaint.setShadowLayer(this.radius, this.bbJ, this.bbK, this.color);
    AppMethodBeat.o(205211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.g
 * JD-Core Version:    0.7.0.1
 */