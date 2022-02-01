package androidx.compose.ui.m.e;

import android.text.TextPaint;
import androidx.compose.ui.d.e;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.ax;
import androidx.compose.ui.e.z;
import androidx.compose.ui.e.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setColor", "", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setShadow", "setTextDecoration", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends TextPaint
{
  private androidx.compose.ui.m.f.d bat;
  private ax bau;
  
  public d(float paramFloat)
  {
    super(1);
    AppMethodBeat.i(205338);
    this.density = paramFloat;
    Object localObject = androidx.compose.ui.m.f.d.bek;
    this.bat = androidx.compose.ui.m.f.d.BT();
    localObject = ax.aym;
    this.bau = ax.tN();
    AppMethodBeat.o(205338);
  }
  
  public final void W(long paramLong)
  {
    AppMethodBeat.i(205359);
    z.a locala = z.awK;
    if (paramLong != z.sw()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = ab.ai(paramLong);
        if (getColor() != i) {
          setColor(i);
        }
      }
      AppMethodBeat.o(205359);
      return;
    }
  }
  
  public final void a(ax paramax)
  {
    AppMethodBeat.i(205353);
    Object localObject = paramax;
    if (paramax == null)
    {
      paramax = ax.aym;
      localObject = ax.tN();
    }
    if (!s.p(this.bau, localObject))
    {
      this.bau = ((ax)localObject);
      paramax = this.bau;
      localObject = ax.aym;
      if (s.p(paramax, ax.tN()))
      {
        clearShadowLayer();
        AppMethodBeat.o(205353);
        return;
      }
      setShadowLayer(this.bau.ayo, e.F(this.bau.offset), e.G(this.bau.offset), ab.ai(this.bau.ayn));
    }
    AppMethodBeat.o(205353);
  }
  
  public final void a(androidx.compose.ui.m.f.d paramd)
  {
    AppMethodBeat.i(205343);
    Object localObject = paramd;
    if (paramd == null)
    {
      paramd = androidx.compose.ui.m.f.d.bek;
      localObject = androidx.compose.ui.m.f.d.BT();
    }
    if (!s.p(this.bat, localObject))
    {
      this.bat = ((androidx.compose.ui.m.f.d)localObject);
      paramd = this.bat;
      localObject = androidx.compose.ui.m.f.d.bek;
      setUnderlineText(paramd.b(androidx.compose.ui.m.f.d.BU()));
      paramd = this.bat;
      localObject = androidx.compose.ui.m.f.d.bek;
      setStrikeThruText(paramd.b(androidx.compose.ui.m.f.d.BV()));
    }
    AppMethodBeat.o(205343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.d
 * JD-Core Version:    0.7.0.1
 */