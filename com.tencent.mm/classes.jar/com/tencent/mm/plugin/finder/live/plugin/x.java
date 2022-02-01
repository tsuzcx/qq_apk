package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentRealNamePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "realNamePanel", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "show", "realNameUrl", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-finder_release"})
public final class x
  extends d
{
  private final com.tencent.mm.live.c.b hOp;
  private FinderLiveCommentPostRealNamePanel uoQ;
  
  public x(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, com.tencent.mm.live.c.b paramb)
  {
    super((ViewGroup)paramFinderLiveCommentPostRealNamePanel, paramb);
    AppMethodBeat.i(246608);
    this.hOp = paramb;
    this.uoQ = paramFinderLiveCommentPostRealNamePanel;
    AppMethodBeat.o(246608);
  }
  
  public final void l(String paramString, kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
  {
    AppMethodBeat.i(246607);
    p.h(paramString, "realNameUrl");
    p.h(paramb, "callback");
    this.uoQ.setDialogHeight(au.az(MMApplicationContext.getContext()).y * 0.55D);
    this.uoQ.setWebviewForwardCallback((kotlin.g.a.q)new a(this));
    FinderLiveCommentPostRealNamePanel localFinderLiveCommentPostRealNamePanel = this.uoQ;
    paramb = (kotlin.g.a.b)new b(paramb);
    p.h(paramString, "verifyUrl");
    p.h(paramb, "callback");
    localFinderLiveCommentPostRealNamePanel.hJl = paramString;
    localFinderLiveCommentPostRealNamePanel.uym = paramb;
    paramString = localFinderLiveCommentPostRealNamePanel.uyo;
    if (paramString == null) {
      p.btv("bottomDialog");
    }
    paramString.dGm();
    paramString = m.vli;
    m.a(s.as.vrE);
    AppMethodBeat.o(246607);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(246606);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FinderLiveCommentPostRealNamePanel localFinderLiveCommentPostRealNamePanel = this.uoQ;
    int j = 0;
    int i = j;
    if (paramInt1 == 10000) {
      if (paramIntent == null) {
        break label218;
      }
    }
    label218:
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
            if (p.j(str, "roomlive_verify"))
            {
              i = j;
              if (paramInt1 == 0)
              {
                paramIntent = localFinderLiveCommentPostRealNamePanel.uym;
                if (paramIntent != null) {
                  paramIntent.invoke(Boolean.TRUE);
                }
                paramIntent = localFinderLiveCommentPostRealNamePanel.uyo;
                if (paramIntent == null) {
                  p.btv("bottomDialog");
                }
                paramIntent.bMo();
                i = 1;
              }
            }
          }
        }
      }
      if (i == 0) {
        break;
      }
      paramIntent = m.vli;
      m.a(s.as.vrG);
      AppMethodBeat.o(246606);
      return;
    }
    paramIntent = m.vli;
    m.a(s.as.vrH);
    AppMethodBeat.o(246606);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "requestCode", "", "invoke", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Context, Intent, Integer, kotlin.x>
  {
    a(x paramx)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    b(kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.x
 * JD-Core Version:    0.7.0.1
 */