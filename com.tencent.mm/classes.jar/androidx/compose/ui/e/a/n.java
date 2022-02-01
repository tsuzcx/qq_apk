package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Xyz;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "clamp", "", "x", "fromXyz", "", "v", "getMaxValue", "component", "getMinValue", "toXyz", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends c
{
  public n(String paramString)
  {
    super(paramString, b.ua(), 14, (byte)0);
    AppMethodBeat.i(206156);
    AppMethodBeat.o(206156);
  }
  
  public final float cM(int paramInt)
  {
    return -2.0F;
  }
  
  public final float cN(int paramInt)
  {
    return 2.0F;
  }
  
  public final float[] f(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206167);
    s.u(paramArrayOfFloat, "v");
    paramArrayOfFloat[0] = k.C(paramArrayOfFloat[0], -2.0F, 2.0F);
    paramArrayOfFloat[1] = k.C(paramArrayOfFloat[1], -2.0F, 2.0F);
    paramArrayOfFloat[2] = k.C(paramArrayOfFloat[2], -2.0F, 2.0F);
    AppMethodBeat.o(206167);
    return paramArrayOfFloat;
  }
  
  public final float[] g(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206171);
    s.u(paramArrayOfFloat, "v");
    paramArrayOfFloat[0] = k.C(paramArrayOfFloat[0], -2.0F, 2.0F);
    paramArrayOfFloat[1] = k.C(paramArrayOfFloat[1], -2.0F, 2.0F);
    paramArrayOfFloat[2] = k.C(paramArrayOfFloat[2], -2.0F, 2.0F);
    AppMethodBeat.o(206171);
    return paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.n
 * JD-Core Version:    0.7.0.1
 */