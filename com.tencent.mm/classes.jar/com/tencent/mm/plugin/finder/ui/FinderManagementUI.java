package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderManagementUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "getResourceId", "", "goBack", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "plugin-finder_release"})
public final class FinderManagementUI
  extends MMPreference
{
  private HashMap _$_findViewCache;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252503);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252503);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252502);
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
    AppMethodBeat.o(252502);
    return localView1;
  }
  
  public final int getResourceId()
  {
    return 2132017219;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(252499);
    finish();
    AppMethodBeat.o(252499);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252498);
    super.onCreate(paramBundle);
    setMMTitle(2131759820);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    getPreferenceScreen().notifyDataSetChanged();
    AppMethodBeat.o(252498);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(252500);
    if (paramPreference == null) {
      p.hyc();
    }
    paramf = paramPreference.getKey();
    if (paramf == null) {}
    for (;;)
    {
      AppMethodBeat.o(252500);
      return true;
      switch (paramf.hashCode())
      {
      default: 
        break;
      case -823205717: 
        if (paramf.equals("not_see_mine"))
        {
          paramf = a.vUU;
          paramf = getContext();
          p.g(paramf, "context");
          a.ae((Context)paramf, 2);
        }
        break;
      case 1545714883: 
        if (paramf.equals("no_see_account"))
        {
          paramf = a.vUU;
          paramf = getContext();
          p.g(paramf, "context");
          a.ae((Context)paramf, 3);
        }
        break;
      case 389082164: 
        if (paramf.equals("not_see_him"))
        {
          paramf = a.vUU;
          paramf = getContext();
          p.g(paramf, "context");
          a.ae((Context)paramf, 1);
        }
        break;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderManagementUI paramFinderManagementUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(252497);
      FinderManagementUI.a(this.vLc);
      AppMethodBeat.o(252497);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderManagementUI
 * JD-Core Version:    0.7.0.1
 */