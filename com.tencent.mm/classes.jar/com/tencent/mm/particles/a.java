package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static int ipd;
  private static int ipe;
  private static int ipf;
  private static int ipg;
  private static int iph;
  private static int ipi;
  public c gBR;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151345);
    if (ipd == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      ipd = paramViewGroup.getDimensionPixelSize(2131166084);
      ipe = paramViewGroup.getDimensionPixelOffset(2131166089);
      ipf = paramViewGroup.getDimensionPixelOffset(2131166088);
      ipg = paramViewGroup.getDimensionPixelOffset(2131166087);
      iph = paramViewGroup.getDimensionPixelOffset(2131166090);
      ipi = paramViewGroup.getDimensionPixelOffset(2131166085);
    }
    AppMethodBeat.o(151345);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151346);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).B(0.0F, 800.0F).C(-2000.0F, 1250.0F).an(2000.0F);
    paramViewGroup.ipR = 3000.0F;
    paramViewGroup.ipS = 500.0F;
    paramViewGroup = paramViewGroup.aMr();
    paramViewGroup.ipu = e.aMz();
    locala.gBR = paramViewGroup.aMs().aMt();
    AppMethodBeat.o(151346);
    return locala;
  }
  
  public final c C(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151347);
    c localc = this.gBR;
    localc.ipq = 0;
    localc.ipr = paramLong;
    localc = localc.al(paramInt).aMu();
    AppMethodBeat.o(151347);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */