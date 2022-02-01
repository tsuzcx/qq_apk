package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.ui.FinderSelfUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFavListTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderFavFeedUI
  extends MMFinderUI
{
  public static final a tZM;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(245143);
    tZM = new a((byte)0);
    AppMethodBeat.o(245143);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245145);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245145);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245144);
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
    AppMethodBeat.o(245144);
    return localView1;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 24;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(245140);
    Set localSet = ak.setOf(FinderFavListTabUIC.class);
    AppMethodBeat.o(245140);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(245142);
    if ((paramInt1 == 10001) && (paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject1 = a.PRN;
      localObject1 = ((FinderFavListTabUIC)a.b((AppCompatActivity)this).get(FinderFavListTabUIC.class)).fragments;
      if (localObject1 == null) {
        p.btv("fragments");
      }
      Object localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (FinderHomeTabFragment)((Iterator)localObject2).next();
      } while ((((FinderHomeTabFragment)localObject1).dLS != 100) || (!((FinderHomeTabFragment)localObject1).isVisible()));
      for (;;)
      {
        localObject2 = localObject1;
        if (!(localObject1 instanceof FinderFavFeedFragment)) {
          localObject2 = null;
        }
        localObject1 = (FinderFavFeedFragment)localObject2;
        if (localObject1 == null) {
          break label218;
        }
        localObject1 = ((FinderFavFeedFragment)localObject1).dAs();
        if (localObject1 == null) {
          break label218;
        }
        p.h(paramIntent, "data");
        localObject2 = ((c.a)localObject1).tMd;
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((c.b)localObject2).tLS.getRecyclerView();
        if (localObject2 == null) {
          break;
        }
        y localy = y.vXH;
        y.a(paramIntent, (RecyclerView)localObject2, (BaseFeedLoader)((c.a)localObject1).tFM);
        AppMethodBeat.o(245142);
        return;
        localObject1 = null;
      }
      AppMethodBeat.o(245142);
      return;
      label218:
      AppMethodBeat.o(245142);
      return;
    }
    AppMethodBeat.o(245142);
  }
  
  public final void onBackPressed()
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(245141);
    Intent localIntent = new Intent();
    Object localObject1 = a.PRN;
    localObject1 = ((FinderFavListTabUIC)a.b((AppCompatActivity)this).get(FinderFavListTabUIC.class)).getActiveFragment();
    switch (((FinderHomeTabFragment)localObject1).dLS)
    {
    }
    for (;;)
    {
      setResult(-1, localIntent);
      super.onBackPressed();
      AppMethodBeat.o(245141);
      return;
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof FinderFavFeedFragment)) {
        localObject2 = null;
      }
      localObject2 = (FinderFavFeedFragment)localObject2;
      localObject1 = localObject3;
      if (localObject2 != null) {
        localObject1 = ((FinderFavFeedFragment)localObject2).dAr();
      }
      if (localObject1 != null)
      {
        localObject2 = FinderSelfUI.vOh;
        localIntent.putExtra(FinderSelfUI.dAc(), ((FinderFavFeedLoader)localObject1).gAZ);
        continue;
        localObject2 = localObject1;
        if (!(localObject1 instanceof FinderFavMegaVideoFragment)) {
          localObject2 = null;
        }
        localObject2 = (FinderFavMegaVideoFragment)localObject2;
        localObject1 = localObject4;
        if (localObject2 != null) {
          localObject1 = ((FinderFavMegaVideoFragment)localObject2).dAt();
        }
        if (localObject1 != null)
        {
          localObject2 = FinderSelfUI.vOh;
          localIntent.putExtra(FinderSelfUI.dAc(), ((FinderFavMegaVideoLoader)localObject1).gAZ);
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245139);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(245139);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFavFeedUI paramFinderFavFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245138);
      this.tZN.onBackPressed();
      AppMethodBeat.o(245138);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI
 * JD-Core Version:    0.7.0.1
 */