package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.q.bv;
import com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.j;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentRealNamePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "realNamePanel", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "show", "realNameUrl", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends b
{
  private FinderLiveCommentPostRealNamePanel CYg;
  private final com.tencent.mm.live.b.b nfT;
  
  public ai(FinderLiveCommentPostRealNamePanel paramFinderLiveCommentPostRealNamePanel, com.tencent.mm.live.b.b paramb)
  {
    super((ViewGroup)paramFinderLiveCommentPostRealNamePanel, paramb);
    AppMethodBeat.i(355760);
    this.nfT = paramb;
    this.CYg = paramFinderLiveCommentPostRealNamePanel;
    AppMethodBeat.o(355760);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(355768);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    FinderLiveCommentPostRealNamePanel localFinderLiveCommentPostRealNamePanel = this.CYg;
    if (paramInt1 == 10000) {
      if (paramIntent == null)
      {
        paramIntent = null;
        if ((paramInt2 != -1) || (paramIntent == null)) {
          break label217;
        }
        String str = paramIntent.getString("go_next", "");
        paramIntent = paramIntent.getString("result_json");
        if (Util.isNullOrNil(paramIntent)) {
          break label217;
        }
        paramInt1 = new i(paramIntent).getInt("code");
        Log.i("Finder.FinderMaxSizeLayout", "onActivityResult, nextStep:" + str + ", code:" + paramInt1);
        if ((!s.p(str, "roomlive_verify")) || (paramInt1 != 0)) {
          break label217;
        }
        paramIntent = localFinderLiveCommentPostRealNamePanel.DMf;
        if (paramIntent != null) {
          paramIntent.invoke(Boolean.TRUE);
        }
        paramIntent = localFinderLiveCommentPostRealNamePanel.DMg;
        if (paramIntent != null) {
          break label199;
        }
        s.bIx("bottomDialog");
        paramIntent = localObject;
        label164:
        paramIntent.cyW();
      }
    }
    label199:
    label217:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0)
      {
        k.Doi.a(q.bv.DDv);
        AppMethodBeat.o(355768);
        return;
        paramIntent = paramIntent.getBundleExtra("result_data");
        break;
        break label164;
      }
      k.Doi.a(q.bv.DDw);
      AppMethodBeat.o(355768);
      return;
    }
  }
  
  public final void q(String paramString, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(355779);
    s.u(paramString, "realNameUrl");
    s.u(paramb, "callback");
    this.CYg.setDialogHeight(bf.bf(MMApplicationContext.getContext()).y * 0.55D);
    this.CYg.setWebviewForwardCallback((q)new a(this));
    FinderLiveCommentPostRealNamePanel localFinderLiveCommentPostRealNamePanel = this.CYg;
    paramb = (kotlin.g.a.b)new ai.b(paramb);
    s.u(paramString, "verifyUrl");
    s.u(paramb, "callback");
    localFinderLiveCommentPostRealNamePanel.nag = paramString;
    localFinderLiveCommentPostRealNamePanel.DMf = paramb;
    paramb = localFinderLiveCommentPostRealNamePanel.DMg;
    paramString = paramb;
    if (paramb == null)
    {
      s.bIx("bottomDialog");
      paramString = null;
    }
    paramString.dDn();
    k.Doi.a(q.bv.DDt);
    AppMethodBeat.o(355779);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "requestCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<Context, Intent, Integer, ah>
  {
    a(ai paramai)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ai
 * JD-Core Version:    0.7.0.1
 */