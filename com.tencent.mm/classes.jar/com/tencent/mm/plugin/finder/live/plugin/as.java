package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.bg;
import com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentRealNamePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "realNamePanel", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "show", "realNameUrl", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-finder_release"})
public final class as
  extends d
{
  private final com.tencent.mm.live.c.b kCL;
  private FinderLiveCommentPostRealNamePanel yps;
  
  public as(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, com.tencent.mm.live.c.b paramb)
  {
    super((ViewGroup)paramFinderLiveCommentPostRealNamePanel, paramb);
    AppMethodBeat.i(284975);
    this.kCL = paramb;
    this.yps = paramFinderLiveCommentPostRealNamePanel;
    AppMethodBeat.o(284975);
  }
  
  public final void m(String paramString, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(284974);
    p.k(paramString, "realNameUrl");
    p.k(paramb, "callback");
    this.yps.setDialogHeight(ax.au(MMApplicationContext.getContext()).y * 0.55D);
    this.yps.setWebviewForwardCallback((kotlin.g.a.q)new a(this));
    FinderLiveCommentPostRealNamePanel localFinderLiveCommentPostRealNamePanel = this.yps;
    paramb = (kotlin.g.a.b)new as.b(paramb);
    p.k(paramString, "verifyUrl");
    p.k(paramb, "callback");
    localFinderLiveCommentPostRealNamePanel.kwF = paramString;
    localFinderLiveCommentPostRealNamePanel.yTE = paramb;
    paramString = localFinderLiveCommentPostRealNamePanel.yTG;
    if (paramString == null) {
      p.bGy("bottomDialog");
    }
    paramString.eik();
    m.yCt.a(s.bg.yLC);
    AppMethodBeat.o(284974);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(284973);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FinderLiveCommentPostRealNamePanel localFinderLiveCommentPostRealNamePanel = this.yps;
    int j = 0;
    int i = j;
    if (paramInt1 == 10000) {
      if (paramIntent == null) {
        break label217;
      }
    }
    label217:
    for (paramIntent = paramIntent.getBundleExtra("result_data");; paramIntent = null)
    {
      i = j;
      if (paramInt2 == -1)
      {
        i = j;
        if (paramIntent != null)
        {
          String str = paramIntent.getString("go_next", "");
          paramIntent = paramIntent.getString("result_json");
          i = j;
          if (!Util.isNullOrNil(paramIntent))
          {
            paramInt1 = new i(paramIntent).getInt("code");
            Log.i("Finder.FinderMaxSizeLayout", "onActivityResult, nextStep:" + str + ", code:" + paramInt1);
            i = j;
            if (p.h(str, "roomlive_verify"))
            {
              i = j;
              if (paramInt1 == 0)
              {
                paramIntent = localFinderLiveCommentPostRealNamePanel.yTE;
                if (paramIntent != null) {
                  paramIntent.invoke(Boolean.TRUE);
                }
                paramIntent = localFinderLiveCommentPostRealNamePanel.yTG;
                if (paramIntent == null) {
                  p.bGy("bottomDialog");
                }
                paramIntent.bYF();
                i = 1;
              }
            }
          }
        }
      }
      if (i == 0) {
        break;
      }
      m.yCt.a(s.bg.yLE);
      AppMethodBeat.o(284973);
      return;
    }
    m.yCt.a(s.bg.yLF);
    AppMethodBeat.o(284973);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "requestCode", "", "invoke", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Context, Intent, Integer, x>
  {
    a(as paramas)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.as
 * JD-Core Version:    0.7.0.1
 */