package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import java.util.Map;
import java.util.Queue;

final class LuckyMoneyF2FQRCodeUI$1$1
  implements Runnable
{
  LuckyMoneyF2FQRCodeUI$1$1(LuckyMoneyF2FQRCodeUI.1 param1, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(42169);
    Object localObject;
    if (!LuckyMoneyF2FQRCodeUI.a(this.omb.olY).contains(this.olZ))
    {
      LuckyMoneyF2FQRCodeUI.a(this.omb.olY).add(0, this.olZ);
      if (!t.nT(this.efI))
      {
        localObject = new h();
        ((h)localObject).username = this.efI;
        o.adg().b((h)localObject);
      }
      LuckyMoneyF2FQRCodeUI.b(this.omb.olY).put(this.olZ, this.efI);
      localObject = LuckyMoneyF2FQRCodeUI.c(this.omb.olY);
      if (((ShuffleView)localObject).omr.size() > 0)
      {
        if (((ShuffleView)localObject).omv.isStarted()) {
          ((ShuffleView)localObject).omv.end();
        }
        if (((ShuffleView)localObject).lsF.isStarted()) {
          ((ShuffleView)localObject).lsF.end();
        }
        if (((ShuffleView)localObject).gEO == null) {
          break label351;
        }
        ((ShuffleView)localObject).omz = ((ShuffleView)localObject).gEO;
        ((ShuffleView)localObject).omr.remove(((ShuffleView)localObject).omz);
        if (((ShuffleView)localObject).omt != null) {
          ((ShuffleView)localObject).omt.start();
        }
        ((ShuffleView)localObject).yo(((ShuffleView)localObject).omB);
        if (((ShuffleView)localObject).omE <= 0) {
          break label338;
        }
        ((ShuffleView)localObject).omB = ((ShuffleView)localObject).bNc();
        ((ShuffleView)localObject).gEO = ((View)((ShuffleView)localObject).omr.get(((ShuffleView)localObject).omB));
      }
    }
    for (;;)
    {
      LuckyMoneyF2FQRCodeUI.d(this.omb.olY).remove(LuckyMoneyF2FQRCodeUI.c(this.omb.olY).getExitView());
      LuckyMoneyF2FQRCodeUI.e(this.omb.olY).ag(0L, 60000L);
      LuckyMoneyF2FQRCodeUI.f(this.omb.olY).add(new Pair(this.efI, Integer.valueOf(bo.getInt(this.oma, 0))));
      AppMethodBeat.o(42169);
      return;
      label338:
      ((ShuffleView)localObject).gEO = null;
      ((ShuffleView)localObject).omB = 0;
      continue;
      label351:
      ((ShuffleView)localObject).ym(((ShuffleView)localObject).bNc());
      ((ShuffleView)localObject).omz = ((ShuffleView)localObject).gEO;
      ((ShuffleView)localObject).omv.addListener(new ShuffleView.5((ShuffleView)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.1.1
 * JD-Core Version:    0.7.0.1
 */