package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.util.Pair;
import android.view.View;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import java.util.Map;
import java.util.Queue;

final class LuckyMoneyF2FQRCodeUI$1$1
  implements Runnable
{
  LuckyMoneyF2FQRCodeUI$1$1(LuckyMoneyF2FQRCodeUI.1 param1, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    Object localObject;
    if (!LuckyMoneyF2FQRCodeUI.a(this.lOH.lOE).contains(this.lOF))
    {
      LuckyMoneyF2FQRCodeUI.a(this.lOH.lOE).add(0, this.lOF);
      if (!s.hk(this.dol))
      {
        localObject = new h();
        ((h)localObject).username = this.dol;
        o.Kh().a((h)localObject);
      }
      LuckyMoneyF2FQRCodeUI.b(this.lOH.lOE).put(this.lOF, this.dol);
      localObject = LuckyMoneyF2FQRCodeUI.c(this.lOH.lOE);
      if (((ShuffleView)localObject).lOX.size() > 0)
      {
        if (((ShuffleView)localObject).lPb.isStarted()) {
          ((ShuffleView)localObject).lPb.end();
        }
        if (((ShuffleView)localObject).jjN.isStarted()) {
          ((ShuffleView)localObject).jjN.end();
        }
        if (((ShuffleView)localObject).fnv == null) {
          break label341;
        }
        ((ShuffleView)localObject).lPf = ((ShuffleView)localObject).fnv;
        ((ShuffleView)localObject).lOX.remove(((ShuffleView)localObject).lPf);
        if (((ShuffleView)localObject).lOZ != null) {
          ((ShuffleView)localObject).lOZ.start();
        }
        ((ShuffleView)localObject).tm(((ShuffleView)localObject).lPh);
        if (((ShuffleView)localObject).lPk <= 0) {
          break label328;
        }
        ((ShuffleView)localObject).lPh = ((ShuffleView)localObject).bfC();
        ((ShuffleView)localObject).fnv = ((View)((ShuffleView)localObject).lOX.get(((ShuffleView)localObject).lPh));
      }
    }
    for (;;)
    {
      LuckyMoneyF2FQRCodeUI.d(this.lOH.lOE).remove(LuckyMoneyF2FQRCodeUI.c(this.lOH.lOE).getExitView());
      LuckyMoneyF2FQRCodeUI.e(this.lOH.lOE).S(0L, 60000L);
      LuckyMoneyF2FQRCodeUI.f(this.lOH.lOE).add(new Pair(this.dol, Integer.valueOf(bk.getInt(this.lOG, 0))));
      return;
      label328:
      ((ShuffleView)localObject).fnv = null;
      ((ShuffleView)localObject).lPh = 0;
      continue;
      label341:
      ((ShuffleView)localObject).tk(((ShuffleView)localObject).bfC());
      ((ShuffleView)localObject).lPf = ((ShuffleView)localObject).fnv;
      ((ShuffleView)localObject).lPb.addListener(new ShuffleView.5((ShuffleView)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.1.1
 * JD-Core Version:    0.7.0.1
 */