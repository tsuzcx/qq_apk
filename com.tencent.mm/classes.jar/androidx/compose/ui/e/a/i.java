package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Oklab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXyz", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends c
{
  private static final float[] SK;
  private static final float[] SL;
  public static final i.a azM;
  private static final float[] azN;
  private static final float[] azO;
  
  static
  {
    AppMethodBeat.i(206195);
    azM = new i.a((byte)0);
    Object localObject1 = a.ayF;
    localObject1 = a.tY().transform;
    Object localObject2 = g.azA;
    localObject2 = g.uy().uF();
    g localg = g.azA;
    localObject1 = d.a((float[])localObject1, (float[])localObject2, g.uA().uF());
    SK = d.b(new float[] { 0.818933F, 0.03298454F, 0.0482003F, 0.3618667F, 0.9293119F, 0.2643663F, -0.1288597F, 0.03614564F, 0.6338517F }, (float[])localObject1);
    azN = new float[] { 0.2104543F, 1.977999F, 0.02590404F, 0.7936178F, -2.428592F, 0.7827718F, -0.004072047F, 0.4505937F, -0.8086758F };
    SL = d.h(SK);
    azO = d.h(azN);
    AppMethodBeat.o(206195);
  }
  
  public i(String paramString)
  {
    super(paramString, b.ub(), 17, (byte)0);
    AppMethodBeat.i(206187);
    AppMethodBeat.o(206187);
  }
  
  public final float cM(int paramInt)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return -2.0F;
  }
  
  public final float cN(int paramInt)
  {
    if (paramInt == 0) {
      return 1.0F;
    }
    return 2.0F;
  }
  
  public final float[] f(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206217);
    s.u(paramArrayOfFloat, "v");
    paramArrayOfFloat[0] = k.C(paramArrayOfFloat[0], 0.0F, 1.0F);
    paramArrayOfFloat[1] = k.C(paramArrayOfFloat[1], -2.0F, 2.0F);
    paramArrayOfFloat[2] = k.C(paramArrayOfFloat[2], -2.0F, 2.0F);
    d.c(azO, paramArrayOfFloat);
    paramArrayOfFloat[0] = ((float)Math.pow(paramArrayOfFloat[0], 3.0D));
    paramArrayOfFloat[1] = ((float)Math.pow(paramArrayOfFloat[1], 3.0D));
    paramArrayOfFloat[2] = ((float)Math.pow(paramArrayOfFloat[2], 3.0D));
    d.c(SL, paramArrayOfFloat);
    AppMethodBeat.o(206217);
    return paramArrayOfFloat;
  }
  
  public final float[] g(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206224);
    s.u(paramArrayOfFloat, "v");
    d.c(SK, paramArrayOfFloat);
    paramArrayOfFloat[0] = ((float)Math.pow(paramArrayOfFloat[0], 0.333333343267441D));
    paramArrayOfFloat[1] = ((float)Math.pow(paramArrayOfFloat[1], 0.333333343267441D));
    paramArrayOfFloat[2] = ((float)Math.pow(paramArrayOfFloat[2], 0.333333343267441D));
    d.c(azN, paramArrayOfFloat);
    AppMethodBeat.o(206224);
    return paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.i
 * JD-Core Version:    0.7.0.1
 */