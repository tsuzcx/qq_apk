package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderWxSettingUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203391);
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
    AppMethodBeat.o(203391);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496271;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203389);
    super.onCreate(paramBundle);
    paramBundle = c.sKz;
    c.a.cLE().onAlive();
    paramBundle = c.sKz;
    c.a.cLE();
    c.cLC();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    setMMTitle("");
    findViewById(2131307485).setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(2131307483);
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIJ().value()).intValue() == 1)
    {
      p.g(paramBundle, "blackList");
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(203389);
      return;
    }
    p.g(paramBundle, "blackList");
    paramBundle.setVisibility(8);
    AppMethodBeat.o(203389);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203390);
    super.onDestroy();
    c.a locala = c.sKz;
    c.a.cLE().onAlive();
    AppMethodBeat.o(203390);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203386);
      this.sqY.finish();
      AppMethodBeat.o(203386);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203387);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.eU((Context)this.sqY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203387);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203388);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      com.tencent.mm.plugin.finder.utils.a.Q((Context)this.sqY, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203388);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderWxSettingUI
 * JD-Core Version:    0.7.0.1
 */