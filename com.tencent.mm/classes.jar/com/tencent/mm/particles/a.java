package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static int ggK;
  private static int ggL;
  private static int ggM;
  private static int ggN;
  private static int ggO;
  private static int ggP;
  public c ggQ;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151570);
    if (ggK == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      ggK = paramViewGroup.getDimensionPixelSize(2131428269);
      ggL = paramViewGroup.getDimensionPixelOffset(2131428274);
      ggM = paramViewGroup.getDimensionPixelOffset(2131428273);
      ggN = paramViewGroup.getDimensionPixelOffset(2131428272);
      ggO = paramViewGroup.getDimensionPixelOffset(2131428275);
      ggP = paramViewGroup.getDimensionPixelOffset(2131428270);
    }
    AppMethodBeat.o(151570);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151571);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).H(0.0F, 800.0F).I(-2000.0F, 1250.0F).aj(2000.0F);
    paramViewGroup.ghz = 3000.0F;
    paramViewGroup.ghA = 500.0F;
    paramViewGroup = paramViewGroup.anR();
    paramViewGroup.ghc = e.aoa();
    locala.ggQ = paramViewGroup.anS().anT();
    AppMethodBeat.o(151571);
    return locala;
  }
  
  public final c A(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151572);
    c localc = this.ggQ;
    localc.ggZ = 0;
    localc.gha = paramLong;
    localc = localc.ah(paramInt).anV();
    AppMethodBeat.o(151572);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */