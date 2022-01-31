package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements RecyclerView.f.a
{
  c$1(c paramc) {}
  
  public final void hQ()
  {
    if (this.hpW.hpU != null)
    {
      ConversationAppBrandRecentView localConversationAppBrandRecentView = this.hpW.hpU;
      this.hpW.hpU.getCurrentPage();
      Object localObject = (LinearLayoutManager)localConversationAppBrandRecentView.getLayoutManager();
      int i = ((LinearLayoutManager)localObject).gY();
      int j = ((LinearLayoutManager)localObject).ha();
      y.i("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i <= j)
      {
        localObject = localConversationAppBrandRecentView.bK(i);
        if ((localObject != null) && (((RecyclerView.v)localObject).aie != null))
        {
          ((RecyclerView.v)localObject).aie.setScaleX(1.0F);
          ((RecyclerView.v)localObject).aie.setScaleY(1.0F);
          if (i != j) {
            break label140;
          }
          ((RecyclerView.v)localObject).aie.setAlpha(0.3F);
        }
        for (;;)
        {
          i += 1;
          break;
          label140:
          ((RecyclerView.v)localObject).aie.setAlpha(1.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.1
 * JD-Core Version:    0.7.0.1
 */