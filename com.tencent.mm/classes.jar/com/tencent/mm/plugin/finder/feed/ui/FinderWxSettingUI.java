package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderWxSettingUI
  extends MMFinderUI
{
  private static final void a(FinderWxSettingUI paramFinderWxSettingUI, View paramView)
  {
    AppMethodBeat.i(365019);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderWxSettingUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderWxSettingUI, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.ha((Context)paramFinderWxSettingUI);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365019);
  }
  
  private static final boolean a(FinderWxSettingUI paramFinderWxSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365013);
    s.u(paramFinderWxSettingUI, "this$0");
    paramFinderWxSettingUI.finish();
    AppMethodBeat.o(365013);
    return true;
  }
  
  private static final void b(FinderWxSettingUI paramFinderWxSettingUI, View paramView)
  {
    AppMethodBeat.i(365027);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderWxSettingUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderWxSettingUI, "this$0");
    paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
    com.tencent.mm.plugin.finder.utils.a.hd((Context)paramFinderWxSettingUI);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365027);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_wx_setting_ui_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365058);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX().onAlive();
    paramBundle = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX();
    com.tencent.mm.plugin.finder.storage.data.d.eZV();
    setBackBtn(new FinderWxSettingUI..ExternalSyntheticLambda0(this));
    setMMTitle("");
    findViewById(e.e.jump_finder_wxmsg).setOnClickListener(new FinderWxSettingUI..ExternalSyntheticLambda2(this));
    paramBundle = findViewById(e.e.jump_black_list);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eRV().bmg()).intValue() == 1)
    {
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener(new FinderWxSettingUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(365058);
      return;
    }
    paramBundle.setVisibility(8);
    AppMethodBeat.o(365058);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365066);
    super.onDestroy();
    d.a locala = com.tencent.mm.plugin.finder.storage.data.d.FML;
    d.a.eZX().onAlive();
    AppMethodBeat.o(365066);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderWxSettingUI
 * JD-Core Version:    0.7.0.1
 */