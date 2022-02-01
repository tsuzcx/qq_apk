package com.tencent.mm.plugin.finder.feed.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.accessibility.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.g;
import com.tencent.mm.plugin.finder.viewmodel.component.h;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtFeedManageUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "containerView", "Landroid/widget/LinearLayout;", "getLayoutId", "", "hideActionBar", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAtFeedManageUI
  extends MMFinderUI
{
  public static final a BlE;
  private LinearLayout BlF;
  
  static
  {
    AppMethodBeat.i(365293);
    BlE = new a((byte)0);
    AppMethodBeat.o(365293);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_at_feed_manage_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365308);
    Set localSet = ar.setOf(new Class[] { g.class, h.class, c.class });
    AppMethodBeat.o(365308);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365301);
    super.onCreate(paramBundle);
    this.BlF = ((LinearLayout)findViewById(e.e.at_feed_container));
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    AppMethodBeat.o(365301);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderAtFeedManageUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderAtFeedManageUI
 * JD-Core Version:    0.7.0.1
 */