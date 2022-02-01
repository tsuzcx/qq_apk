package com.tencent.mm.plugin.finder.replay.shopping;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.replay.e;
import com.tencent.mm.plugin.finder.replay.widget.c;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "shoppingReplayBaseUIC", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayBaseUIC;", "getShoppingReplayBaseUIC", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayBaseUIC;", "setShoppingReplayBaseUIC", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayBaseUIC;)V", "shoppingReplayDecorateUIC", "Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayDecorateUIC;", "getShoppingReplayDecorateUIC", "()Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayDecorateUIC;", "setShoppingReplayDecorateUIC", "(Lcom/tencent/mm/plugin/finder/replay/shopping/FinderLiveShoppingReplayDecorateUIC;)V", "prepareToStart", "", "byMiniWin", "", "startToEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  extends com.tencent.mm.plugin.finder.live.view.a
{
  private e Fms;
  private a Fmt;
  private final String TAG = "FinderLiveShoppingReplayRouter";
  
  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null, paramAttributeSet);
    this.Fms = new e((AppCompatActivity)paramContext, (m)a.Fmu);
    this.Fmt = new a((AppCompatActivity)paramContext);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final e getShoppingReplayBaseUIC()
  {
    return this.Fms;
  }
  
  public final a getShoppingReplayDecorateUIC()
  {
    return this.Fmt;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void setShoppingReplayBaseUIC(e parame)
  {
    s.u(parame, "<set-?>");
    this.Fms = parame;
  }
  
  public final void setShoppingReplayDecorateUIC(a parama)
  {
    s.u(parama, "<set-?>");
    this.Fmt = parama;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "", "id", "", "sourcePlayer"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Long, c, r<? extends c, ? extends Boolean>>
  {
    public static final a Fmu;
    
    static
    {
      AppMethodBeat.i(332562);
      Fmu = new a();
      AppMethodBeat.o(332562);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.shopping.b
 * JD-Core Version:    0.7.0.1
 */