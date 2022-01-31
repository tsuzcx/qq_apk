package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class a
{
  private static int lRV;
  private static int lRW;
  private static int lRX;
  private static int lRY;
  private static int lRZ;
  private static int lSa;
  public c lSb;
  
  public a(ViewGroup paramViewGroup)
  {
    if (lRV == 0)
    {
      paramViewGroup = paramViewGroup.getResources();
      lRV = paramViewGroup.getDimensionPixelSize(a.d.default_confetti_size);
      lRW = paramViewGroup.getDimensionPixelOffset(a.d.default_velocity_slow);
      lRX = paramViewGroup.getDimensionPixelOffset(a.d.default_velocity_normal);
      lRY = paramViewGroup.getDimensionPixelOffset(a.d.default_velocity_fast);
      lRZ = paramViewGroup.getDimensionPixelOffset(a.d.default_velocity_very_fast);
      lSa = paramViewGroup.getDimensionPixelOffset(a.d.default_explosion_radius);
    }
  }
  
  public static a a(ViewGroup paramViewGroup, b paramb)
  {
    a locala = new a(paramViewGroup);
    paramViewGroup = new c(paramViewGroup.getContext(), paramb, new d(paramViewGroup.getWidth() / 2, paramViewGroup.getHeight() + 400), paramViewGroup).R(0.0F, 800.0F).S(-2000.0F, 1250.0F).au(2000.0F);
    paramViewGroup.lSK = 3000.0F;
    paramViewGroup.lSL = 500.0F;
    paramViewGroup = paramViewGroup.bfP();
    paramViewGroup.lSn = e.bfT();
    locala.lSb = paramViewGroup.bfQ().bfR();
    return locala;
  }
  
  public final c D(int paramInt, long paramLong)
  {
    c localc = this.lSb;
    localc.lSj = 0;
    localc.lSk = paramLong;
    localc.lSl = (paramInt / 1000.0F);
    localc.lSm = (1.0F / localc.lSl);
    if (localc.hsF != null) {
      localc.hsF.cancel();
    }
    localc.lSi = 0L;
    Object localObject = localc.lSh.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localc.lSg.add(((Iterator)localObject).next());
      ((Iterator)localObject).remove();
    }
    localObject = localc.lSf.getParent();
    if (localObject != null)
    {
      if (localObject != localc.lSe) {
        ((ViewGroup)localObject).removeView(localc.lSf);
      }
    }
    else {
      localc.lSe.addView(localc.lSf);
    }
    localc.lSf.terminated = false;
    localc.E(localc.lSj, 0L);
    localc.hsF = ValueAnimator.ofInt(new int[] { 0 }).setDuration(9223372036854775807L);
    localc.hsF.addUpdateListener(new c.2(localc));
    localc.hsF.start();
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.particles.a
 * JD-Core Version:    0.7.0.1
 */