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
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.plugin.finder.storage.data.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.a;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderWxSettingUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202526);
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
    AppMethodBeat.o(202526);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496271;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202524);
    super.onCreate(paramBundle);
    paramBundle = c.rEC;
    c.a.cBc().onAlive();
    paramBundle = c.rEC;
    c.a.cBc();
    c.cBa();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    setMMTitle("");
    findViewById(2131307485).setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(2131307483);
    b localb = b.rCU;
    if (b.czO())
    {
      k.g(paramBundle, "blackList");
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(202524);
      return;
    }
    k.g(paramBundle, "blackList");
    paramBundle.setVisibility(8);
    AppMethodBeat.o(202524);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202525);
    super.onDestroy();
    c.a locala = c.rEC;
    c.a.cBc().onAlive();
    AppMethodBeat.o(202525);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202521);
      this.rsQ.finish();
      AppMethodBeat.o(202521);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202522);
      paramView = a.rOv;
      a.eQ((Context)this.rsQ);
      AppMethodBeat.o(202522);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202523);
      paramView = a.rOv;
      a.Q((Context)this.rsQ, null);
      AppMethodBeat.o(202523);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderWxSettingUI
 * JD-Core Version:    0.7.0.1
 */