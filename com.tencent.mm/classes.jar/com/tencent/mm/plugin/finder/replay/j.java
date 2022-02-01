package com.tencent.mm.plugin.finder.replay;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.f;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayRouter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "Lcom/tencent/mm/plugin/finder/live/view/router/IFinderLiveRouter;", "context", "Landroid/content/Context;", "uicFragment", "Landroidx/fragment/app/Fragment;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroidx/fragment/app/Fragment;Landroid/util/AttributeSet;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fromFloat", "", "getFromFloat", "()Z", "setFromFloat", "(Z)V", "replayBaseUIC", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayBaseUIC;", "getReplayBaseUIC", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayBaseUIC;", "setReplayBaseUIC", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayBaseUIC;)V", "replayDecorateUIC", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayDecorateUIC;", "getReplayDecorateUIC", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayDecorateUIC;", "setReplayDecorateUIC", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayDecorateUIC;)V", "bindData", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "initLogic", "prepareToStart", "byMiniWin", "startToEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class j
  extends a
{
  private e Fku;
  private g Fkv;
  boolean Fkw;
  private final String TAG = "FinderLiveReplayRouter";
  
  public j(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, null, paramAttributeSet);
    this.Fku = new e((AppCompatActivity)paramContext, (m)a.Fkx);
    this.Fkv = new g((AppCompatActivity)paramContext);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public void bindData(f paramf)
  {
    boolean bool = false;
    s.u(paramf, "data");
    super.bindData(paramf);
    paramf = k.Fky.eLF().Fkz;
    if (paramf == null) {}
    do
    {
      this.Fkw = bool;
      Log.i(this.TAG, s.X("initLogic fromFloat:", Boolean.valueOf(this.Fkw)));
      paramf = k.Fky.eLF().Fkz;
      if (paramf != null) {
        paramf.FlU = null;
      }
      return;
      paramf = paramf.FlU;
    } while (paramf == null);
    if (((Number)paramf.bsC).longValue() == ((com.tencent.mm.plugin.finder.replay.viewmodel.c)business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo().liveId) {}
    for (bool = ((Boolean)paramf.bsD).booleanValue();; bool = false) {
      break;
    }
  }
  
  public final boolean getFromFloat()
  {
    return this.Fkw;
  }
  
  public final e getReplayBaseUIC()
  {
    return this.Fku;
  }
  
  public final g getReplayDecorateUIC()
  {
    return this.Fkv;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void setFromFloat(boolean paramBoolean)
  {
    this.Fkw = paramBoolean;
  }
  
  public final void setReplayBaseUIC(e parame)
  {
    s.u(parame, "<set-?>");
    this.Fku = parame;
  }
  
  public final void setReplayDecorateUIC(g paramg)
  {
    s.u(paramg, "<set-?>");
    this.Fkv = paramg;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/replay/widget/FinderLiveReplayerWidget;", "", "id", "", "sourcePlayer"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Long, com.tencent.mm.plugin.finder.replay.widget.c, r<? extends com.tencent.mm.plugin.finder.replay.widget.c, ? extends Boolean>>
  {
    public static final a Fkx;
    
    static
    {
      AppMethodBeat.i(332606);
      Fkx = new a();
      AppMethodBeat.o(332606);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.j
 * JD-Core Version:    0.7.0.1
 */