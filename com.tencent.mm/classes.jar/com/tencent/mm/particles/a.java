package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static int iLt;
  private static int iLu;
  private static int iLv;
  private static int iLw;
  private static int iLx;
  private static int iLy;
  public c gYk;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151345);
    if (iLt == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      iLt = paramViewGroup.getDimensionPixelSize(2131166084);
      iLu = paramViewGroup.getDimensionPixelOffset(2131166089);
      iLv = paramViewGroup.getDimensionPixelOffset(2131166088);
      iLw = paramViewGroup.getDimensionPixelOffset(2131166087);
      iLx = paramViewGroup.getDimensionPixelOffset(2131166090);
      iLy = paramViewGroup.getDimensionPixelOffset(2131166085);
    }
    AppMethodBeat.o(151345);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151346);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).C(0.0F, 800.0F).D(-2000.0F, 1250.0F).aq(2000.0F);
    paramViewGroup.iMh = 3000.0F;
    paramViewGroup.iMi = 500.0F;
    paramViewGroup = paramViewGroup.aQd();
    paramViewGroup.iLK = e.aQl();
    locala.gYk = paramViewGroup.aQe().aQf();
    AppMethodBeat.o(151346);
    return locala;
  }
  
  public final c D(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151347);
    c localc = this.gYk;
    localc.iLG = 0;
    localc.iLH = paramLong;
    localc = localc.ao(paramInt).aQg();
    AppMethodBeat.o(151347);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */