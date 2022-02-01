package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static int jIh;
  private static int jIi;
  private static int jIj;
  private static int jIk;
  private static int jIl;
  private static int jIm;
  public c hRg;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151345);
    if (jIh == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      jIh = paramViewGroup.getDimensionPixelSize(2131166125);
      jIi = paramViewGroup.getDimensionPixelOffset(2131166130);
      jIj = paramViewGroup.getDimensionPixelOffset(2131166129);
      jIk = paramViewGroup.getDimensionPixelOffset(2131166128);
      jIl = paramViewGroup.getDimensionPixelOffset(2131166131);
      jIm = paramViewGroup.getDimensionPixelOffset(2131166126);
    }
    AppMethodBeat.o(151345);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151346);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).G(0.0F, 800.0F).H(-2000.0F, 1250.0F).az(2000.0F);
    paramViewGroup.jIV = 3000.0F;
    paramViewGroup.jIW = 500.0F;
    paramViewGroup = paramViewGroup.bkG();
    paramViewGroup.jIy = e.bkO();
    locala.hRg = paramViewGroup.bkH().bkI();
    AppMethodBeat.o(151346);
    return locala;
  }
  
  public final c G(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151347);
    c localc = this.hRg;
    localc.jIu = 0;
    localc.jIv = paramLong;
    localc = localc.ax(paramInt).bkJ();
    AppMethodBeat.o(151347);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */