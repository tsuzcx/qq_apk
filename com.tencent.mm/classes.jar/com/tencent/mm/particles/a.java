package com.tencent.mm.particles;

import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.c;

public final class a
{
  private static int pvX;
  private static int pvY;
  private static int pvZ;
  private static int pwa;
  private static int pwb;
  private static int pwc;
  public c niE;
  
  public a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(151345);
    if (pvX == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      pvX = paramViewGroup.getDimensionPixelSize(c.c.default_confetti_size);
      pvY = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_slow);
      pvZ = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_normal);
      pwa = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_fast);
      pwb = paramViewGroup.getDimensionPixelOffset(c.c.default_velocity_very_fast);
      pwc = paramViewGroup.getDimensionPixelOffset(c.c.default_explosion_radius);
    }
    AppMethodBeat.o(151345);
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    AppMethodBeat.i(151346);
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).an(0.0F, 800.0F).ao(-2000.0F, 1250.0F).bx(2000.0F);
    paramViewGroup.pwK = 3000.0F;
    paramViewGroup.pwL = 500.0F;
    paramViewGroup = paramViewGroup.bSF();
    paramViewGroup.pwn = e.bSN();
    locala.niE = paramViewGroup.bSG().bSH();
    AppMethodBeat.o(151346);
    return locala;
  }
  
  public final c J(int paramInt, long paramLong)
  {
    AppMethodBeat.i(151347);
    c localc = this.niE;
    localc.pwj = 0;
    localc.pwk = paramLong;
    localc = localc.bv(paramInt).bSI();
    AppMethodBeat.o(151347);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.particles.a
 * JD-Core Version:    0.7.0.1
 */