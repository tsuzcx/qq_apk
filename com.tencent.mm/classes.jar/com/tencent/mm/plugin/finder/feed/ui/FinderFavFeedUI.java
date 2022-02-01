package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
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
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.q;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderFavFeedUI
  extends MMFinderUI
{
  public static final a xMb;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(289161);
    xMb = new a((byte)0);
    AppMethodBeat.o(289161);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(289163);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(289163);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(289162);
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
    AppMethodBeat.o(289162);
    return localView1;
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 24;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(289157);
    Set localSet = ak.setOf(q.class);
    AppMethodBeat.o(289157);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(289160);
    if ((paramInt1 == 10001) && (paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject1 = g.Xox;
      localObject1 = ((q)g.b((AppCompatActivity)this).i(q.class)).fragments;
      if (localObject1 == null) {
        p.bGy("fragments");
      }
      Object localObject2 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (FinderHomeTabFragment)((Iterator)localObject2).next();
      } while ((((FinderHomeTabFragment)localObject1).fEH != 100) || (!((FinderHomeTabFragment)localObject1).isVisible()));
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
        localObject1 = ((FinderFavFeedFragment)localObject1).ebK();
        if (localObject1 == null) {
          break label218;
        }
        p.k(paramIntent, "data");
        localObject2 = ((c.a)localObject1).xvU;
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((c.b)localObject2).xvJ.getRecyclerView();
        if (localObject2 == null) {
          break;
        }
        aj localaj = aj.AGc;
        aj.a(paramIntent, (RecyclerView)localObject2, (BaseFeedLoader)((c.a)localObject1).xnX);
        AppMethodBeat.o(289160);
        return;
        localObject1 = null;
      }
      AppMethodBeat.o(289160);
      return;
      label218:
      AppMethodBeat.o(289160);
      return;
    }
    AppMethodBeat.o(289160);
  }
  
  public final void onBackPressed()
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(289158);
    Intent localIntent = new Intent();
    Object localObject1 = g.Xox;
    localObject1 = ((q)g.b((AppCompatActivity)this).i(q.class)).getActiveFragment();
    switch (((FinderHomeTabFragment)localObject1).fEH)
    {
    }
    for (;;)
    {
      setResult(-1, localIntent);
      super.onBackPressed();
      AppMethodBeat.o(289158);
      return;
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof FinderFavFeedFragment)) {
        localObject2 = null;
      }
      localObject2 = (FinderFavFeedFragment)localObject2;
      localObject1 = localObject3;
      if (localObject2 != null) {
        localObject1 = ((FinderFavFeedFragment)localObject2).ebJ();
      }
      if (localObject1 != null)
      {
        localObject2 = FinderSelfUI.Avb;
        localIntent.putExtra(FinderSelfUI.eaT(), ((FinderFavFeedLoader)localObject1).jlf);
        continue;
        localObject2 = localObject1;
        if (!(localObject1 instanceof FinderFavMegaVideoFragment)) {
          localObject2 = null;
        }
        localObject2 = (FinderFavMegaVideoFragment)localObject2;
        localObject1 = localObject4;
        if (localObject2 != null) {
          localObject1 = ((FinderFavMegaVideoFragment)localObject2).ebL();
        }
        if (localObject1 != null)
        {
          localObject2 = FinderSelfUI.Avb;
          localIntent.putExtra(FinderSelfUI.eaT(), ((FinderFavMegaVideoLoader)localObject1).jlf);
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(289156);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    AppMethodBeat.o(289156);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFavFeedUI paramFinderFavFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(285246);
      this.xMc.onBackPressed();
      AppMethodBeat.o(285246);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI
 * JD-Core Version:    0.7.0.1
 */