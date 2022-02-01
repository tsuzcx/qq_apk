package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static int hOH;
  private static int hOI;
  private static int hOJ;
  private static int hOK;
  private static int hOL;
  private static int hOM;
  public c hON;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151345);
    if (hOH == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      hOH = paramViewGroup.getDimensionPixelSize(2131166084);
      hOI = paramViewGroup.getDimensionPixelOffset(2131166089);
      hOJ = paramViewGroup.getDimensionPixelOffset(2131166088);
      hOK = paramViewGroup.getDimensionPixelOffset(2131166087);
      hOL = paramViewGroup.getDimensionPixelOffset(2131166090);
      hOM = paramViewGroup.getDimensionPixelOffset(2131166085);
    }
    AppMethodBeat.o(151345);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151346);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).y(0.0F, 800.0F).z(-2000.0F, 1250.0F).aj(2000.0F);
    paramViewGroup.hPw = 3000.0F;
    paramViewGroup.hPx = 500.0F;
    paramViewGroup = paramViewGroup.aFz();
    paramViewGroup.hOZ = e.aFI();
    locala.hON = paramViewGroup.aFA().aFB();
    AppMethodBeat.o(151346);
    return locala;
  }
  
  public final c D(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151347);
    c localc = this.hON;
    localc.hOV = 0;
    localc.hOW = paramLong;
    localc = localc.ah(paramInt).aFD();
    AppMethodBeat.o(151347);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */