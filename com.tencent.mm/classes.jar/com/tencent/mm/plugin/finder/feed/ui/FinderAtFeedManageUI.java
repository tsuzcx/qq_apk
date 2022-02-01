package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.f;
import com.tencent.mm.plugin.finder.viewmodel.component.h;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtFeedManageUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "containerView", "Landroid/widget/LinearLayout;", "getLayoutId", "", "hideActionBar", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class FinderAtFeedManageUI
  extends MMFinderUI
{
  public static final a xLv;
  private HashMap _$_findViewCache;
  private LinearLayout containerView;
  
  static
  {
    AppMethodBeat.i(241645);
    xLv = new a((byte)0);
    AppMethodBeat.o(241645);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(241647);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(241647);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(241646);
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
    AppMethodBeat.o(241646);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_at_feed_manage_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(241643);
    Set localSet = ak.setOf(new Class[] { f.class, h.class });
    AppMethodBeat.o(241643);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241642);
    super.onCreate(paramBundle);
    this.containerView = ((LinearLayout)findViewById(b.f.at_feed_container));
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.hide();
      AppMethodBeat.o(241642);
      return;
    }
    AppMethodBeat.o(241642);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtFeedManageUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtFeedManageUI
 * JD-Core Version:    0.7.0.1
 */