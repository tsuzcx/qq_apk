package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

final class c$5
  implements Runnable
{
  c$5(c paramc, ArrayList paramArrayList) {}
  
  public final void run()
  {
    Iterator localIterator = this.abI.iterator();
    while (localIterator.hasNext())
    {
      c.a locala = (c.a)localIterator.next();
      if (locala != null)
      {
        c localc = this.hpW;
        Object localObject3 = locala.abS;
        Object localObject1;
        label57:
        Object localObject2;
        label76:
        int i;
        float f;
        boolean bool;
        if (localObject3 == null)
        {
          localObject1 = null;
          localObject2 = locala.abT;
          if (localObject2 == null) {
            break label313;
          }
          localObject2 = ((RecyclerView.v)localObject2).aie;
          y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl %s", new Object[] { ((BaseAppBrandRecentView.c)localObject3).eXr.getText() });
          if (localObject1 != null)
          {
            localObject3 = ((View)localObject1).animate().setDuration(localc.agS);
            localc.abF.add(locala.abS);
            ((ViewPropertyAnimator)localObject3).translationX(locala.abW - locala.abU);
            ((ViewPropertyAnimator)localObject3).translationY(locala.abX - locala.abV);
            ((ViewPropertyAnimator)localObject3).alpha(0.0F).setListener(new c.2(localc, locala, (ViewPropertyAnimator)localObject3, (View)localObject1)).start();
          }
          if (localObject2 == null) {
            continue;
          }
          i = ConversationAppBrandRecentView.bg((View)localObject2);
          f = 1.0F;
          if (i >= localc.hpU.getDataCount()) {
            break label319;
          }
          bool = true;
          label226:
          if (bool) {
            break label325;
          }
          f = 0.0F;
        }
        for (;;)
        {
          localObject1 = ((View)localObject2).animate();
          localc.abF.add(locala.abT);
          ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).alpha(f).setDuration(localc.agS).setListener(new c.3(localc, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f, bool)).start();
          break;
          localObject1 = ((RecyclerView.v)localObject3).aie;
          break label57;
          label313:
          localObject2 = null;
          break label76;
          label319:
          bool = false;
          break label226;
          label325:
          int j = ((LinearLayoutManager)localc.hpU.getLayoutManager()).ha();
          y.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl lastVisiblePos: %d, position: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          if (j == i) {
            f = 0.3F;
          }
        }
      }
    }
    this.abI.clear();
    this.hpW.abB.remove(this.abI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.5
 * JD-Core Version:    0.7.0.1
 */