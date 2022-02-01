package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeFeedGridFragment;
import com.tencent.mm.plugin.finder.ui.fragment.FinderLikeMegaVideoFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.ai;
import com.tencent.mm.plugin.finder.viewmodel.teenmode.b;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLikeFeedGridUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLikeFeedGridUI
  extends MMFinderUI
{
  private final String TAG = "Finder.FinderLikeFeedGridUI";
  
  private static final boolean a(FinderLikeFeedGridUI paramFinderLikeFeedGridUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364430);
    s.u(paramFinderLikeFeedGridUI, "this$0");
    paramFinderLikeFeedGridUI.onBackPressed();
    AppMethodBeat.o(364430);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 3;
  }
  
  public final int getCommentScene()
  {
    return 35;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(364448);
    Set localSet = ar.setOf(new Class[] { ai.class, b.class });
    AppMethodBeat.o(364448);
    return localSet;
  }
  
  public final void onBackPressed()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364467);
    Intent localIntent = new Intent();
    Object localObject1 = k.aeZF;
    localObject1 = ((ai)k.d((AppCompatActivity)this).q(ai.class)).getActiveFragment();
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
      AppMethodBeat.o(364467);
      return;
      if ((localObject1 instanceof FinderLikeFeedGridFragment))
      {
        localObject1 = (FinderLikeFeedGridFragment)localObject1;
        label92:
        if (localObject1 != null) {
          break label121;
        }
      }
      label121:
      for (localObject1 = localObject2; localObject1 != null; localObject1 = ((FinderLikeFeedGridFragment)localObject1).fcT())
      {
        localIntent.putExtra("INNER_ITEM_COUNT", ((FinderLikedFeedLoader)localObject1).lNX);
        break;
        localObject1 = null;
        break label92;
      }
      if ((localObject1 instanceof FinderLikeMegaVideoFragment))
      {
        localObject1 = (FinderLikeMegaVideoFragment)localObject1;
        if (localObject1 != null) {
          break label170;
        }
      }
      for (localObject1 = null;; localObject1 = ((FinderLikeMegaVideoFragment)localObject1).fcU())
      {
        if (localObject1 == null) {
          break label176;
        }
        localIntent.putExtra("INNER_ITEM_COUNT", ((FinderLikeMegaVideoLoader)localObject1).lNX);
        break;
        localObject1 = null;
        break label141;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364455);
    super.onCreate(paramBundle);
    setBackBtn(new FinderLikeFeedGridUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(364455);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLikeFeedGridUI
 * JD-Core Version:    0.7.0.1
 */