package com.tencent.mm.plugin.finder.live.plugin;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.w;
import com.tencent.mm.plugin.finder.live.widget.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorExceptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "exceptionWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveExceptionWidget;", "initWidget", "", "anchorUserName", "showJoinOverloadTip", "showKickedMemberTip", "showPrivateCount", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ck
  extends b
{
  public w CUG;
  public final String TAG;
  private final com.tencent.mm.live.b.b nfT;
  
  public ck(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354348);
    this.nfT = paramb;
    this.TAG = "Finder.LiveVisitorExceptionPlugin";
    AppMethodBeat.o(354348);
  }
  
  public final void awP(String paramString)
  {
    AppMethodBeat.i(354369);
    if (this.CUG == null) {
      this.CUG = new w((View)this.mJe, paramString, ((e)getBuContext().business(e.class)).eyo());
    }
    AppMethodBeat.o(354369);
  }
  
  public final void bkp(String paramString)
  {
    AppMethodBeat.i(371421);
    s.u(paramString, "anchorUserName");
    Log.i(this.TAG, s.X("showPrivateCount anchorUserName:", paramString));
    awP(paramString);
    paramString = this.CUG;
    if (paramString != null)
    {
      w.a locala = w.EoA;
      w.a(paramString, w.eAD(), null, (kotlin.g.a.b)new b(this), 6);
    }
    AppMethodBeat.o(371421);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ok", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    public a(ck paramck)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "ok", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(ck paramck)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ck
 * JD-Core Version:    0.7.0.1
 */