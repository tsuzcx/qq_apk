package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "transformSource", "transformDestination", "renderIntent", "transform", "", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDestination", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getRenderIntent-uksYyKA", "()I", "I", "getSource", "r", "", "g", "b", "v", "Companion", "RgbConnector", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
{
  public static final f.a azq;
  private final c azr;
  private final c azs;
  private final c azt;
  private final c azu;
  private final int azv;
  private final float[] transform;
  
  static
  {
    AppMethodBeat.i(206208);
    azq = new f.a((byte)0);
    AppMethodBeat.o(206208);
  }
  
  private f(c paramc1, c paramc2, int paramInt) {}
  
  private f(c paramc1, c paramc2, c paramc3, c paramc4, int paramInt, float[] paramArrayOfFloat)
  {
    this.azr = paramc1;
    this.azs = paramc2;
    this.azt = paramc3;
    this.azu = paramc4;
    this.azv = paramInt;
    this.transform = paramArrayOfFloat;
  }
  
  public float[] i(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206216);
    s.u(paramArrayOfFloat, "v");
    paramArrayOfFloat = this.azt.f(paramArrayOfFloat);
    if (this.transform != null)
    {
      paramArrayOfFloat[0] *= this.transform[0];
      paramArrayOfFloat[1] *= this.transform[1];
      paramArrayOfFloat[2] *= this.transform[2];
    }
    paramArrayOfFloat = this.azu.g(paramArrayOfFloat);
    AppMethodBeat.o(206216);
    return paramArrayOfFloat;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/colorspace/Connector$Companion$identity$1", "Landroidx/compose/ui/graphics/colorspace/Connector;", "transform", "", "v", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$a
    extends f
  {
    a$a(c paramc, int paramInt)
    {
      super(paramc, paramInt, (byte)0);
      AppMethodBeat.i(206251);
      AppMethodBeat.o(206251);
    }
    
    public final float[] i(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(206256);
      s.u(paramArrayOfFloat, "v");
      AppMethodBeat.o(206256);
      return paramArrayOfFloat;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "mSource", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mDestination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "mTransform", "", "computeTransform", "source", "destination", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "transform", "v", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends f
  {
    private final k azx;
    private final k azy;
    private final float[] azz;
    
    private b(k paramk1, k paramk2, int paramInt)
    {
      super((c)paramk2, (c)paramk1, (c)paramk2, paramInt, null, (byte)0);
      AppMethodBeat.i(206259);
      this.azx = paramk1;
      this.azy = paramk2;
      Object localObject2 = this.azx;
      Object localObject1 = this.azy;
      if (d.a(((k)localObject2).azU, ((k)localObject1).azU)) {}
      for (paramk1 = d.b(((k)localObject1).inverseTransform, ((k)localObject2).transform);; paramk1 = d.b(paramk2, (float[])localObject1))
      {
        this.azz = paramk1;
        AppMethodBeat.o(206259);
        return;
        paramk1 = ((k)localObject2).transform;
        paramk2 = ((k)localObject1).inverseTransform;
        float[] arrayOfFloat1 = ((k)localObject2).azU.uF();
        float[] arrayOfFloat2 = ((k)localObject1).azU.uF();
        Object localObject3 = ((k)localObject2).azU;
        g localg = g.azA;
        if (!d.a((m)localObject3, g.uy()))
        {
          paramk1 = a.ayF;
          paramk1 = a.tX().transform;
          localObject3 = g.azA;
          localObject3 = g.uB();
          localObject3 = Arrays.copyOf((float[])localObject3, localObject3.length);
          s.s(localObject3, "java.util.Arrays.copyOf(this, size)");
          paramk1 = d.b(d.a(paramk1, arrayOfFloat1, (float[])localObject3), ((k)localObject2).transform);
        }
        localObject2 = ((k)localObject1).azU;
        localObject3 = g.azA;
        if (!d.a((m)localObject2, g.uy()))
        {
          paramk2 = a.ayF;
          paramk2 = a.tX().transform;
          localObject2 = g.azA;
          localObject2 = g.uB();
          localObject2 = Arrays.copyOf((float[])localObject2, localObject2.length);
          s.s(localObject2, "java.util.Arrays.copyOf(this, size)");
          paramk2 = d.h(d.b(d.a(paramk2, arrayOfFloat2, (float[])localObject2), ((k)localObject1).transform));
        }
        localObject1 = j.azP;
        localObject1 = paramk1;
        if (j.C(paramInt, j.uE())) {
          localObject1 = d.d(new float[] { arrayOfFloat1[0] / arrayOfFloat2[0], arrayOfFloat1[1] / arrayOfFloat2[1], arrayOfFloat1[2] / arrayOfFloat2[2] }, paramk1);
        }
      }
    }
    
    public final float[] i(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(206264);
      s.u(paramArrayOfFloat, "v");
      paramArrayOfFloat[0] = ((float)((Number)this.azx.aAa.invoke(Double.valueOf(paramArrayOfFloat[0]))).doubleValue());
      paramArrayOfFloat[1] = ((float)((Number)this.azx.aAa.invoke(Double.valueOf(paramArrayOfFloat[1]))).doubleValue());
      paramArrayOfFloat[2] = ((float)((Number)this.azx.aAa.invoke(Double.valueOf(paramArrayOfFloat[2]))).doubleValue());
      d.c(this.azz, paramArrayOfFloat);
      paramArrayOfFloat[0] = ((float)((Number)this.azy.azY.invoke(Double.valueOf(paramArrayOfFloat[0]))).doubleValue());
      paramArrayOfFloat[1] = ((float)((Number)this.azy.azY.invoke(Double.valueOf(paramArrayOfFloat[1]))).doubleValue());
      paramArrayOfFloat[2] = ((float)((Number)this.azy.azY.invoke(Double.valueOf(paramArrayOfFloat[2]))).doubleValue());
      AppMethodBeat.o(206264);
      return paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.f
 * JD-Core Version:    0.7.0.1
 */