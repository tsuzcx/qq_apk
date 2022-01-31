package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

final class c$6
  implements Runnable
{
  c$6(c paramc, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.abJ.iterator();
    while (localIterator.hasNext())
    {
      RecyclerView.v localv = (RecyclerView.v)localIterator.next();
      c localc = this.hpW;
      y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.c)localv).eXr.getText() });
      View localView = localv.aie;
      ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      localc.abC.add(localv);
      int i = ConversationAppBrandRecentView.bg(localView);
      if ((localc.hpT) && (i == 1))
      {
        y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateFirstItemInserted holder %s", new Object[] { ((BaseAppBrandRecentView.c)localv).eXr.getText() });
        localView = localv.aie;
        localViewPropertyAnimator = localView.animate();
        if (ConversationAppBrandRecentView.bg(localv.aie) < localc.hpU.getDataCount()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label184;
          }
          localView.setVisibility(4);
          break;
        }
        label184:
        localView.setVisibility(0);
        localView.setAlpha(1.0F);
        localView.setScaleX(1.0F);
        localView.setScaleY(1.0F);
        ((BaseAppBrandRecentView.c)localv).eXr.setAlpha(0.0F);
        ((BaseAppBrandRecentView.c)localv).hCT.setAlpha(0.0F);
        ((BaseAppBrandRecentView.c)localv).hCT.setScaleX(1.0F);
        ((BaseAppBrandRecentView.c)localv).hCT.setScaleY(1.0F);
        ((BaseAppBrandRecentView.c)localv).eXr.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
        ((BaseAppBrandRecentView.c)localv).hCT.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.8(localc, localv, localView, localViewPropertyAnimator)).start();
      }
      else if ((localc.hpS) && (i == localc.hpU.getDataCount() - 1))
      {
        y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo lastItemAnimateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.c)localv).eXr.getText() });
        localView = localv.aie;
        localViewPropertyAnimator = localView.animate();
        localView.setVisibility(0);
        localView.setAlpha(1.0F);
        localView.setScaleX(1.0F);
        localView.setScaleY(1.0F);
        ((BaseAppBrandRecentView.c)localv).eXr.setAlpha(0.0F);
        ((BaseAppBrandRecentView.c)localv).hCT.setAlpha(0.0F);
        ((BaseAppBrandRecentView.c)localv).hCT.setScaleX(1.0F);
        ((BaseAppBrandRecentView.c)localv).hCT.setScaleY(1.0F);
        ((BaseAppBrandRecentView.c)localv).eXr.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
        ((BaseAppBrandRecentView.c)localv).hCT.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.10(localc, localv, localView, localViewPropertyAnimator)).start();
      }
      else
      {
        boolean bool;
        label569:
        float f;
        if (i < localc.hpU.getDataCount())
        {
          bool = true;
          if (bool) {
            break label690;
          }
          localv.aie.setVisibility(4);
          f = 0.0F;
        }
        for (;;)
        {
          y.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl pos: %d, targetAlpha: %f, customItemCount: %d, dataCount: %d", new Object[] { Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(localc.hpU.getCustomItemCount()), Integer.valueOf(localc.hpU.getDataCount()) });
          localViewPropertyAnimator.alpha(f).scaleX(1.0F).scaleY(1.0F).setDuration(localc.agP).setListener(new c.9(localc, localv, localView, i, bool, localViewPropertyAnimator)).start();
          break;
          bool = false;
          break label569;
          label690:
          if (localc.hpU.nj(i))
          {
            localv.aie.setVisibility(0);
            f = 0.3F;
          }
          else
          {
            localv.aie.setVisibility(0);
            f = 1.0F;
          }
        }
      }
    }
    this.abJ.clear();
    this.hpW.abz.remove(this.abJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.6
 * JD-Core Version:    0.7.0.1
 */