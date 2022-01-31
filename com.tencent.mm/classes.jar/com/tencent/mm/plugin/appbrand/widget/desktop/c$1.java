package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements RecyclerView.f.a
{
  c$1(c paramc) {}
  
  public final void jx()
  {
    AppMethodBeat.i(133774);
    if (this.jed.jeb != null)
    {
      ConversationAppBrandRecentView localConversationAppBrandRecentView = this.jed.jeb;
      this.jed.jeb.getCurrentPage();
      Object localObject = (LinearLayoutManager)localConversationAppBrandRecentView.getLayoutManager();
      int i = ((LinearLayoutManager)localObject).it();
      int j = ((LinearLayoutManager)localObject).iv();
      ab.i("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i <= j)
      {
        localObject = localConversationAppBrandRecentView.bQ(i);
        if ((localObject != null) && (((RecyclerView.v)localObject).aku != null))
        {
          ((RecyclerView.v)localObject).aku.setScaleX(1.0F);
          ((RecyclerView.v)localObject).aku.setScaleY(1.0F);
          if (i != j) {
            break label145;
          }
          ((RecyclerView.v)localObject).aku.setAlpha(0.3F);
        }
        for (;;)
        {
          i += 1;
          break;
          label145:
          ((RecyclerView.v)localObject).aku.setAlpha(1.0F);
        }
      }
    }
    AppMethodBeat.o(133774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c.1
 * JD-Core Version:    0.7.0.1
 */