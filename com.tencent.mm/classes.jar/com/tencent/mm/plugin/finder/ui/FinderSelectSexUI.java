package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"})
public final class FinderSelectSexUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectSexUI";
  private HashMap _$_findViewCache;
  private SelectPreference vNQ;
  private SelectPreference vNR;
  
  private final void dzZ()
  {
    AppMethodBeat.i(167566);
    SelectPreference localSelectPreference = this.vNR;
    if (localSelectPreference == null) {
      p.btv("selectFeMale");
    }
    if (!localSelectPreference.getSelected())
    {
      localSelectPreference = this.vNQ;
      if (localSelectPreference == null) {
        p.btv("selectMale");
      }
      if (!localSelectPreference.getSelected()) {}
    }
    else
    {
      enableOptionMenu(0, true);
      AppMethodBeat.o(167566);
      return;
    }
    enableOptionMenu(0, false);
    AppMethodBeat.o(167566);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252653);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252653);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252652);
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
    AppMethodBeat.o(252652);
    return localView1;
  }
  
  public final int getFooterResourceId()
  {
    return 2131494615;
  }
  
  public final int getResourceId()
  {
    return 2132017220;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167565);
    super.onCreate(paramBundle);
    paramBundle = getPreferenceScreen().bmg("select_male");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.vNQ = ((SelectPreference)paramBundle);
    paramBundle = getPreferenceScreen().bmg("select_female");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.vNR = ((SelectPreference)paramBundle);
    Object localObject = getIntent().getStringExtra("key_input_sex");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    "inputSex = ".concat(String.valueOf(paramBundle));
    h.hkS();
    localObject = this.vNQ;
    if (localObject == null) {
      p.btv("selectMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    localObject = this.vNR;
    if (localObject == null) {
      p.btv("selectFeMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    if (p.j(paramBundle, "male"))
    {
      paramBundle = this.vNQ;
      if (paramBundle == null) {
        p.btv("selectMale");
      }
      paramBundle.setSelected(true);
      paramBundle = this.vNR;
      if (paramBundle == null) {
        p.btv("selectFeMale");
      }
      paramBundle.setSelected(false);
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131755858), (MenuItem.OnMenuItemClickListener)new a(this), null, t.b.OGU);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      dzZ();
      AppMethodBeat.o(167565);
      return;
      if (p.j(paramBundle, "female"))
      {
        paramBundle = this.vNQ;
        if (paramBundle == null) {
          p.btv("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.vNR;
        if (paramBundle == null) {
          p.btv("selectFeMale");
        }
        paramBundle.setSelected(true);
      }
      else
      {
        paramBundle = this.vNQ;
        if (paramBundle == null) {
          p.btv("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.vNR;
        if (paramBundle == null) {
          p.btv("selectFeMale");
        }
        paramBundle.setSelected(false);
      }
    }
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(167567);
    if (paramPreference != null)
    {
      String str = paramPreference.getKey();
      paramPreference = str;
      if (str != null) {}
    }
    else
    {
      paramPreference = "";
    }
    if (p.j(paramPreference, "select_male"))
    {
      paramPreference = this.vNQ;
      if (paramPreference == null) {
        p.btv("selectMale");
      }
      paramPreference.setSelected(true);
      paramPreference = this.vNR;
      if (paramPreference == null) {
        p.btv("selectFeMale");
      }
      paramPreference.setSelected(false);
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      dzZ();
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(167567);
      return false;
      if (p.j(paramPreference, "select_female"))
      {
        paramPreference = this.vNQ;
        if (paramPreference == null) {
          p.btv("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.vNR;
        if (paramPreference == null) {
          p.btv("selectFeMale");
        }
        paramPreference.setSelected(true);
      }
      else
      {
        paramPreference = this.vNQ;
        if (paramPreference == null) {
          p.btv("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.vNR;
        if (paramPreference == null) {
          p.btv("selectFeMale");
        }
        paramPreference.setSelected(false);
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
    a(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167563);
      FinderSelectSexUI.a(this.vNS);
      AppMethodBeat.o(167563);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167564);
      this.vNS.finish();
      AppMethodBeat.o(167564);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectSexUI
 * JD-Core Version:    0.7.0.1
 */