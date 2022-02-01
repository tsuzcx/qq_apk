package androidx.compose.ui.g.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/util/Vector;", "", "length", "", "(I)V", "elements", "", "", "getElements", "()[Ljava/lang/Float;", "[Ljava/lang/Float;", "getLength", "()I", "get", "i", "norm", "set", "", "value", "times", "a", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
{
  private final Float[] aMr;
  private final int length;
  
  public d(int paramInt)
  {
    AppMethodBeat.i(205868);
    this.length = paramInt;
    paramInt = 0;
    int i = this.length;
    Float[] arrayOfFloat = new Float[i];
    while (paramInt < i)
    {
      arrayOfFloat[paramInt] = Float.valueOf(0.0F);
      paramInt += 1;
    }
    this.aMr = arrayOfFloat;
    AppMethodBeat.o(205868);
  }
  
  public final float a(d paramd)
  {
    AppMethodBeat.i(205898);
    s.u(paramd, "a");
    int i = 0;
    int k = this.length;
    float f1;
    int j;
    if (k > 0)
    {
      f1 = 0.0F;
      j = i + 1;
      float f2 = get(i);
      f1 += paramd.get(i) * f2;
      if (j < k) {}
    }
    for (;;)
    {
      AppMethodBeat.o(205898);
      return f1;
      i = j;
      break;
      f1 = 0.0F;
    }
  }
  
  public final void f(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(205888);
    this.aMr[paramInt] = Float.valueOf(paramFloat);
    AppMethodBeat.o(205888);
  }
  
  public final float get(int paramInt)
  {
    AppMethodBeat.i(205877);
    float f = this.aMr[paramInt].floatValue();
    AppMethodBeat.o(205877);
    return f;
  }
  
  public final float wy()
  {
    AppMethodBeat.i(205906);
    float f = (float)Math.sqrt(a(this));
    AppMethodBeat.o(205906);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.a.d
 * JD-Core Version:    0.7.0.1
 */