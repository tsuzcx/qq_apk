package com.tencent.mm.plugin.finder.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bp;
import com.tencent.mm.plugin.finder.profile.uic.n;
import com.tencent.mm.plugin.finder.report.am;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/FinderProfileShopFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "initFeedData", "", "Lcom/tencent/mm/plugin/finder/model/FinderShopFeed;", "getInitFeedData", "()Ljava/util/List;", "setInitFeedData", "(Ljava/util/List;)V", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setInitLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onUserVisibleFocused", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderProfileShopFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  public List<bp> xJf;
  public b xJg;
  
  public FinderProfileShopFragment()
  {
    super(110);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(279499);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(279499);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(279493);
    Set localSet = ak.setOf(n.class);
    AppMethodBeat.o(279493);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(279497);
    super.onUserVisibleFocused();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      Object localObject = am.zZN;
      localObject = g.Xox;
      p.j(localFragmentActivity, "it");
      localObject = ((aj)g.lm((Context)localFragmentActivity).i(aj.class)).ekY();
      i locali = new i();
      locali.g("finderusername", localFragmentActivity.getIntent().getStringExtra("finder_username"));
      am.a((bid)localObject, "prodtab", true, (JSONObject)locali);
      AppMethodBeat.o(279497);
      return;
    }
    AppMethodBeat.o(279497);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(279495);
    p.k(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = this.xJf;
    paramBundle = this.xJg;
    if ((paramView != null) && (paramBundle != null))
    {
      Object localObject = g.Xox;
      localObject = (n)g.h((Fragment)this).i(n.class);
      p.k(paramView, "feedList");
      p.k(paramBundle, "lastBuffer");
      ((n)localObject).dOJ().xJf = paramView;
      ((n)localObject).dOJ().xJg = paramBundle;
      BaseFeedLoader.requestInit$default(((n)localObject).dOJ(), false, 1, null);
    }
    AppMethodBeat.o(279495);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.FinderProfileShopFragment
 * JD-Core Version:    0.7.0.1
 */