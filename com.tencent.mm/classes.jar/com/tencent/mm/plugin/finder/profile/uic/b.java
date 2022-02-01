package com.tencent.mm.plugin.finder.profile.uic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.ak.a;
import com.tencent.mm.plugin.finder.feed.ak.b;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "selectPresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectPresenter;", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderSelectContract$SelectViewCallback;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class b
  extends UIComponent
{
  public static final a zQx;
  private ak.b xBc;
  private ak.a zQw;
  
  static
  {
    AppMethodBeat.i(291349);
    zQx = new a((byte)0);
    AppMethodBeat.o(291349);
  }
  
  public b(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(291348);
    AppMethodBeat.o(291348);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_select_activity_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291344);
    super.onCreate(paramBundle);
    paramBundle = getActivity().getIntent().getStringExtra("finder_username");
    this.zQw = new ak.a(true, paramBundle);
    Object localObject1 = getActivity();
    if (localObject1 == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(291344);
      throw paramBundle;
    }
    localObject1 = (MMActivity)localObject1;
    Object localObject2 = getRootView();
    ak.a locala = this.zQw;
    if (locala == null) {
      p.bGy("selectPresenter");
    }
    this.xBc = new ak.b((MMActivity)localObject1, (View)localObject2, locala);
    localObject1 = this.zQw;
    if (localObject1 == null) {
      p.bGy("selectPresenter");
    }
    localObject2 = this.xBc;
    if (localObject2 == null) {
      p.bGy("viewCallback");
    }
    ((ak.a)localObject1).a((ak.b)localObject2);
    localObject1 = this.xBc;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    ((ak.b)localObject1).initView();
    localObject1 = n.zWF;
    long l;
    if (p.h(paramBundle, z.bdh()))
    {
      l = 1L;
      paramBundle = aj.Bnu;
      paramBundle = aj.a.fZ((Context)getContext());
      if (paramBundle == null) {
        break label234;
      }
    }
    label234:
    for (paramBundle = paramBundle.ekY();; paramBundle = null)
    {
      n.a(l, "1", 3L, "", paramBundle);
      AppMethodBeat.o(291344);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291347);
    super.onDestroy();
    ak.a locala = this.zQw;
    if (locala == null) {
      p.bGy("selectPresenter");
    }
    locala.onDetach();
    AppMethodBeat.o(291347);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291345);
    super.onResume();
    h.ioq();
    AppMethodBeat.o(291345);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(291346);
    super.onUserVisibleFocused();
    h.ioq();
    ak.b localb = this.xBc;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    Log.i(ak.b.TAG, "onUserVisibleFocused : " + localb.xBw);
    LinkedList localLinkedList = localb.xBw;
    if (localLinkedList != null)
    {
      localb.ad(localLinkedList);
      AppMethodBeat.o(291346);
      return;
    }
    AppMethodBeat.o(291346);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileActivityUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.b
 * JD-Core Version:    0.7.0.1
 */