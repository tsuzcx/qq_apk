package androidx.compose.ui.e.a;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Adaptation;", "", "transform", "", "([F)V", "getTransform$ui_graphics_release", "()[F", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a ayF = new a.a((byte)0);
  private static final a ayG = (a)new b(new float[] { 0.8951F, -0.7502F, 0.0389F, 0.2664F, 1.7135F, -0.0685F, -0.1614F, 0.0367F, 1.0296F });
  private static final a ayH = (a)new d(new float[] { 0.40024F, -0.2263F, 0.0F, 0.7076F, 1.16532F, 0.0F, -0.08081F, 0.0457F, 0.91822F });
  private static final a ayI = (a)new c(new float[] { 0.7328F, -0.7036F, 0.003F, 0.4296F, 1.6975F, 0.0136F, -0.1624F, 0.0061F, 0.9834F });
  final float[] transform;
  
  private a(float[] paramArrayOfFloat)
  {
    this.transform = paramArrayOfFloat;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/colorspace/Adaptation$Companion$Bradford$1", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a
  {
    b(float[] paramArrayOfFloat)
    {
      super((byte)0);
    }
    
    public final String toString()
    {
      return "Bradford";
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/colorspace/Adaptation$Companion$Ciecat02$1", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends a
  {
    c(float[] paramArrayOfFloat)
    {
      super((byte)0);
    }
    
    public final String toString()
    {
      return "Ciecat02";
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/graphics/colorspace/Adaptation$Companion$VonKries$1", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends a
  {
    d(float[] paramArrayOfFloat)
    {
      super((byte)0);
    }
    
    public final String toString()
    {
      return "VonKries";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.a
 * JD-Core Version:    0.7.0.1
 */