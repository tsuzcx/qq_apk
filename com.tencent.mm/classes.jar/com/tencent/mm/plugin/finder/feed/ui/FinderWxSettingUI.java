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
import com.tencent.mm.plugin.finder.storage.data.h;
import com.tencent.mm.plugin.finder.storage.data.h.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.a;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderWxSettingUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderWxSettingUI
  extends MMFinderUI
{
  private HashMap _$_findViewCache;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198602);
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
    AppMethodBeat.o(198602);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496270;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198600);
    super.onCreate(paramBundle);
    paramBundle = h.KXp;
    h.a.fVe().onAlive();
    paramBundle = h.KXp;
    h.a.fVe();
    h.fVc();
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    setMMTitle("");
    findViewById(2131307409).setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(2131307407);
    b localb = b.qJA;
    if (b.fUr())
    {
      k.g(paramBundle, "blackList");
      paramBundle.setVisibility(0);
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(198600);
      return;
    }
    k.g(paramBundle, "blackList");
    paramBundle.setVisibility(8);
    AppMethodBeat.o(198600);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198601);
    super.onDestroy();
    h.a locala = h.KXp;
    h.a.fVe().onAlive();
    AppMethodBeat.o(198601);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198597);
      this.KTe.finish();
      AppMethodBeat.o(198597);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198598);
      paramView = a.qSb;
      a.eI((Context)this.KTe);
      AppMethodBeat.o(198598);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderWxSettingUI paramFinderWxSettingUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198599);
      paramView = a.qSb;
      a.ah((Context)this.KTe, null);
      AppMethodBeat.o(198599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderWxSettingUI
 * JD-Core Version:    0.7.0.1
 */