package com.tencent.mm.plugin.finder.replay.fragment;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveReplayUI;
import com.tencent.mm.plugin.finder.replay.m;
import com.tencent.mm.plugin.finder.replay.shopping.c;
import com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/fragment/FinderLiveReplayFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "sourceType", "", "getSourceType", "()I", "setSourceType", "(I)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onAttach", "", "context", "Landroid/content/Context;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveReplayFragment
  extends MMFinderFragment
{
  private final String TAG = "FinderLiveReplayFragment";
  private int sourceType;
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(332548);
    Log.i(this.TAG, s.X("importUIComponents sourceType:", Integer.valueOf(this.sourceType)));
    if (this.sourceType == 3) {}
    for (Object localObject = c.class;; localObject = m.class)
    {
      localObject = ar.setOf(localObject);
      AppMethodBeat.o(332548);
      return localObject;
    }
  }
  
  public final void onAttach(Context paramContext)
  {
    AppMethodBeat.i(332541);
    s.u(paramContext, "context");
    FinderLiveReplayUI localFinderLiveReplayUI;
    if ((paramContext instanceof FinderLiveReplayUI))
    {
      localFinderLiveReplayUI = (FinderLiveReplayUI)paramContext;
      if (localFinderLiveReplayUI != null) {
        break label69;
      }
    }
    label69:
    for (int i = 0;; i = localFinderLiveReplayUI.sourceType)
    {
      this.sourceType = i;
      Log.i(this.TAG, s.X("onAttach sourceType:", Integer.valueOf(this.sourceType)));
      super.onAttach(paramContext);
      AppMethodBeat.o(332541);
      return;
      localFinderLiveReplayUI = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.fragment.FinderLiveReplayFragment
 * JD-Core Version:    0.7.0.1
 */