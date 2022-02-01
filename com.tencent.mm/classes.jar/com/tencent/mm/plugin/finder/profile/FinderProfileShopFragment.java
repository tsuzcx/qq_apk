package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bw;
import com.tencent.mm.plugin.finder.profile.uic.m;
import com.tencent.mm.plugin.finder.report.bb;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileShopFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "initFeedData", "", "Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "getInitFeedData", "()Ljava/util/List;", "setInitFeedData", "(Ljava/util/List;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onUserVisibleFocused", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileShopFragment
  extends FinderHomeTabFragment
{
  public List<bw> BiP;
  public b BiQ;
  
  public FinderProfileShopFragment()
  {
    super(110);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(348467);
    Set localSet = ar.setOf(m.class);
    AppMethodBeat.o(348467);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(348478);
    super.onUserVisibleFocused();
    Object localObject1 = getActivity();
    if (localObject1 != null)
    {
      Object localObject2 = bb.FuK;
      localObject2 = k.aeZF;
      localObject2 = ((as)k.nq((Context)localObject1).q(as.class)).fou();
      i locali = new i();
      locali.m("finderusername", ((FragmentActivity)localObject1).getIntent().getStringExtra("finder_username"));
      localObject1 = ah.aiuX;
      bb.a((bui)localObject2, "prodtab", true, (JSONObject)locali);
    }
    AppMethodBeat.o(348478);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(348472);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = this.BiP;
    paramBundle = this.BiQ;
    if ((paramView != null) && (paramBundle != null))
    {
      Object localObject = k.aeZF;
      localObject = (m)k.y((Fragment)this).q(m.class);
      s.u(paramView, "feedList");
      s.u(paramBundle, "lastBuffer");
      ((m)localObject).eKi().BiP = paramView;
      ((m)localObject).eKi().BiQ = paramBundle;
      BaseFeedLoader.requestInit$default((BaseFeedLoader)((m)localObject).eKi(), false, 1, null);
    }
    AppMethodBeat.o(348472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderProfileShopFragment
 * JD-Core Version:    0.7.0.1
 */