package com.tencent.mm.plugin.finder.profile.uic;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.loader.FinderProfileLiveUserPageLoader;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileReplayFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "initFeedData", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getInitFeedData", "()Ljava/util/List;", "setInitFeedData", "(Ljava/util/List;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onUserVisibleFocused", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileReplayFragment
  extends FinderHomeTabFragment
{
  List<? extends FinderObject> BiP;
  b BiQ;
  
  public FinderProfileReplayFragment()
  {
    super(113);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(348634);
    Set localSet = ar.setOf(k.class);
    AppMethodBeat.o(348634);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(348645);
    super.onUserVisibleFocused();
    getActivity();
    AppMethodBeat.o(348645);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(348640);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    Object localObject1 = this.BiP;
    paramView = this.BiQ;
    if ((localObject1 != null) && (paramView != null))
    {
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      paramBundle = (k)com.tencent.mm.ui.component.k.y((Fragment)this).q(k.class);
      s.u(localObject1, "feedList");
      s.u(paramView, "lastBuffer");
      FinderProfileLiveUserPageLoader localFinderProfileLiveUserPageLoader = paramBundle.eKd();
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(new ap((FinderObject)((Iterator)localObject2).next()));
      }
      localFinderProfileLiveUserPageLoader.BiP = ((List)localObject1);
      paramBundle.eKd().BiQ = paramView;
      BaseFeedLoader.requestInit$default((BaseFeedLoader)paramBundle.eKd(), false, 1, null);
    }
    AppMethodBeat.o(348640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.FinderProfileReplayFragment
 * JD-Core Version:    0.7.0.1
 */