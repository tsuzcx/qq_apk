package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeFeedGridFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeMegaVideoFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeListTabUIC;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLikeFeedGridUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderLikeFeedGridUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderLikeFeedGridUI";
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245320);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245320);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245319);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(245319);
    return localView1;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 35;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245316);
    Set localSet = ak.setOf(FinderLikeListTabUIC.class);
    AppMethodBeat.o(245316);
    return localSet;
  }
  
  public final void onBackPressed()
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(245318);
    Intent localIntent = new Intent();
    Object localObject1 = a.PRN;
    localObject1 = ((FinderLikeListTabUIC)a.b((AppCompatActivity)this).get(FinderLikeListTabUIC.class)).getActiveFragment();
    switch (((FinderHomeTabFragment)localObject1).dLS)
    {
    }
    for (;;)
    {
      setResult(-1, localIntent);
      super.onBackPressed();
      AppMethodBeat.o(245318);
      return;
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof FinderLikeFeedGridFragment)) {
        localObject2 = null;
      }
      localObject2 = (FinderLikeFeedGridFragment)localObject2;
      localObject1 = localObject3;
      if (localObject2 != null) {
        localObject1 = ((FinderLikeFeedGridFragment)localObject2).dAv();
      }
      if (localObject1 != null)
      {
        localObject2 = FinderSelfUI.vOh;
        localIntent.putExtra(FinderSelfUI.dAc(), ((FinderLikedFeedLoader)localObject1).gAZ);
        continue;
        localObject2 = localObject1;
        if (!(localObject1 instanceof FinderLikeMegaVideoFragment)) {
          localObject2 = null;
        }
        localObject2 = (FinderLikeMegaVideoFragment)localObject2;
        localObject1 = localObject4;
        if (localObject2 != null) {
          localObject1 = ((FinderLikeMegaVideoFragment)localObject2).dAw();
        }
        if (localObject1 != null)
        {
          localObject2 = FinderSelfUI.vOh;
          localIntent.putExtra(FinderSelfUI.dAc(), ((FinderLikeMegaVideoLoader)localObject1).gAZ);
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245317);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    AppMethodBeat.o(245317);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderLikeFeedGridUI paramFinderLikeFeedGridUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245315);
      this.ubk.onBackPressed();
      AppMethodBeat.o(245315);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLikeFeedGridUI
 * JD-Core Version:    0.7.0.1
 */