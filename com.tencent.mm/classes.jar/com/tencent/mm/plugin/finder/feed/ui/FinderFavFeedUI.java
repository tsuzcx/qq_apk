package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavFeedFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderFavMegaVideoFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.p;
import com.tencent.mm.plugin.finder.viewmodel.teenmode.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFavFeedUI
  extends MMFinderUI
{
  public static final a Bmm;
  
  static
  {
    AppMethodBeat.i(365555);
    Bmm = new a((byte)0);
    AppMethodBeat.o(365555);
  }
  
  private static final boolean a(FinderFavFeedUI paramFinderFavFeedUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365548);
    s.u(paramFinderFavFeedUI, "this$0");
    paramFinderFavFeedUI.onBackPressed();
    AppMethodBeat.o(365548);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 24;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365568);
    Set localSet = ar.setOf(new Class[] { p.class, b.class });
    AppMethodBeat.o(365568);
    return localSet;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(365596);
    Object localObject2;
    if ((paramInt1 == 10001) && (paramInt2 == -1) && (paramIntent != null))
    {
      localObject1 = k.aeZF;
      localObject2 = ((Iterable)((p)k.d((AppCompatActivity)this).q(p.class)).getFragments()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (FinderHomeTabFragment)((Iterator)localObject2).next();
        if ((((FinderHomeTabFragment)localObject1).hJx == 100) && (((FinderHomeTabFragment)localObject1).isVisible())) {
          if (!(localObject1 instanceof FinderFavFeedFragment)) {
            break label191;
          }
        }
      }
    }
    label191:
    for (Object localObject1 = (FinderFavFeedFragment)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((FinderFavFeedFragment)localObject1).fcQ();
        if (localObject1 != null)
        {
          s.u(paramIntent, "data");
          localObject2 = ((c.a)localObject1).ATE;
          if (localObject2 != null)
          {
            localObject2 = ((c.b)localObject2).ATx.getRecyclerView();
            if (localObject2 != null)
            {
              av localav = av.GiL;
              av.a(paramIntent, (RecyclerView)localObject2, (BaseFeedLoader)((c.a)localObject1).ALH);
            }
          }
        }
      }
      AppMethodBeat.o(365596);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public final void onBackPressed()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365577);
    Intent localIntent = new Intent();
    Object localObject1 = k.aeZF;
    localObject1 = ((p)k.d((AppCompatActivity)this).q(p.class)).getActiveFragment();
    switch (((FinderHomeTabFragment)localObject1).hJx)
    {
    }
    label141:
    label170:
    label176:
    for (;;)
    {
      setResult(-1, localIntent);
      super.onBackPressed();
      AppMethodBeat.o(365577);
      return;
      if ((localObject1 instanceof FinderFavFeedFragment))
      {
        localObject1 = (FinderFavFeedFragment)localObject1;
        label92:
        if (localObject1 != null) {
          break label121;
        }
      }
      label121:
      for (localObject1 = localObject2; localObject1 != null; localObject1 = ((FinderFavFeedFragment)localObject1).fcP())
      {
        localIntent.putExtra("INNER_ITEM_COUNT", ((FinderFavFeedLoader)localObject1).lNX);
        break;
        localObject1 = null;
        break label92;
      }
      if ((localObject1 instanceof FinderFavMegaVideoFragment))
      {
        localObject1 = (FinderFavMegaVideoFragment)localObject1;
        if (localObject1 != null) {
          break label170;
        }
      }
      for (localObject1 = null;; localObject1 = ((FinderFavMegaVideoFragment)localObject1).fcR())
      {
        if (localObject1 == null) {
          break label176;
        }
        localIntent.putExtra("INNER_ITEM_COUNT", ((FinderFavMegaVideoLoader)localObject1).lNX);
        break;
        localObject1 = null;
        break label141;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365564);
    super.onCreate(paramBundle);
    setBackBtn(new FinderFavFeedUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(365564);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavFeedUI$Companion;", "", "()V", "REQUEST_STREAM_CODE", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavFeedUI
 * JD-Core Version:    0.7.0.1
 */