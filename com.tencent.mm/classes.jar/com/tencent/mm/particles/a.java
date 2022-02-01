package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static int iIA;
  private static int iIB;
  private static int iIC;
  private static int iID;
  private static int iIE;
  private static int iIF;
  public c gVB;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151345);
    if (iIA == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      iIA = paramViewGroup.getDimensionPixelSize(2131166084);
      iIB = paramViewGroup.getDimensionPixelOffset(2131166089);
      iIC = paramViewGroup.getDimensionPixelOffset(2131166088);
      iID = paramViewGroup.getDimensionPixelOffset(2131166087);
      iIE = paramViewGroup.getDimensionPixelOffset(2131166090);
      iIF = paramViewGroup.getDimensionPixelOffset(2131166085);
    }
    AppMethodBeat.o(151345);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151346);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).C(0.0F, 800.0F).D(-2000.0F, 1250.0F).aq(2000.0F);
    paramViewGroup.iJo = 3000.0F;
    paramViewGroup.iJp = 500.0F;
    paramViewGroup = paramViewGroup.aPE();
    paramViewGroup.iIR = e.aPM();
    locala.gVB = paramViewGroup.aPF().aPG();
    AppMethodBeat.o(151346);
    return locala;
  }
  
  public final c E(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151347);
    c localc = this.gVB;
    localc.iIN = 0;
    localc.iIO = paramLong;
    localc = localc.ao(paramInt).aPH();
    AppMethodBeat.o(151347);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */