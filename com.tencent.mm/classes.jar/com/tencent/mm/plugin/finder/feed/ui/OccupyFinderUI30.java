package com.tencent.mm.plugin.finder.feed.ui;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.ui.y;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@com.tencent.mm.ui.base.a(32)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI30;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSwipeBack", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OccupyFinderUI30
  extends MMFinderUI
{
  public static final a Btg;
  public aq coroutineScope;
  
  static
  {
    AppMethodBeat.i(365687);
    Btg = new a((byte)0);
    AppMethodBeat.o(365687);
  }
  
  public OccupyFinderUI30()
  {
    AppMethodBeat.i(365680);
    this.coroutineScope = ar.kBZ();
    AppMethodBeat.o(365680);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(365711);
    Log.i("FinderLiveShoppingManagerUI", "onBackPressed");
    Object localObject = k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.shopping.viewmodel.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.shopping.viewmodel.a.class)).FAj;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.shopping.a)localObject).Tj(2);
    }
    super.onBackPressed();
    AppMethodBeat.o(365711);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365698);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.mController.setStatusBarColor(getResources().getColor(p.b.White));
    AppMethodBeat.o(365698);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365717);
    super.onDestroy();
    ar.a(this.coroutineScope, null);
    AppMethodBeat.o(365717);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(365704);
    Log.i("FinderLiveShoppingManagerUI", "onSwipeBack");
    Object localObject = k.aeZF;
    localObject = ((com.tencent.mm.plugin.finder.shopping.viewmodel.a)k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.shopping.viewmodel.a.class)).FAj;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.shopping.a)localObject).Tj(1);
    }
    super.onSwipeBack();
    AppMethodBeat.o(365704);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(365727);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.finder.shopping.viewmodel.a.class);
    AppMethodBeat.o(365727);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI30$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI30
 * JD-Core Version:    0.7.0.1
 */