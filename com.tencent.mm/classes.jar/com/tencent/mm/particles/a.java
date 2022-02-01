package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.c;

public final class a
{
  private static int mzm;
  private static int mzn;
  private static int mzo;
  private static int mzp;
  private static int mzq;
  private static int mzr;
  public c kFD;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151345);
    if (mzm == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      mzm = paramViewGroup.getDimensionPixelSize(c.c.default_confetti_size);
      mzn = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_slow);
      mzo = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_normal);
      mzp = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_fast);
      mzq = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_very_fast);
      mzr = paramViewGroup.getDimensionPixelOffset(c.c.default_explosion_radius);
    }
    AppMethodBeat.o(151345);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151346);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).H(0.0F, 800.0F).I(-2000.0F, 1250.0F).az(2000.0F);
    paramViewGroup.mAa = 3000.0F;
    paramViewGroup.mAb = 500.0F;
    paramViewGroup = paramViewGroup.buu();
    paramViewGroup.mzD = e.buC();
    locala.kFD = paramViewGroup.buv().buw();
    AppMethodBeat.o(151346);
    return locala;
  }
  
  public final c G(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151347);
    c localc = this.kFD;
    localc.mzz = 0;
    localc.mzA = paramLong;
    localc = localc.ax(paramInt).bux();
    AppMethodBeat.o(151347);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */