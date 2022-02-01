package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.s.b;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"})
public final class FinderSelectSexUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectSexUI";
  private SelectPreference sFY;
  private SelectPreference sFZ;
  
  private final void cKi()
  {
    AppMethodBeat.i(167566);
    SelectPreference localSelectPreference = this.sFZ;
    if (localSelectPreference == null) {
      p.bcb("selectFeMale");
    }
    if (!localSelectPreference.getSelected())
    {
      localSelectPreference = this.sFY;
      if (localSelectPreference == null) {
        p.bcb("selectMale");
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
  
  public final int getFooterResourceId()
  {
    return 2131496252;
  }
  
  public final int getResourceId()
  {
    return 2131951678;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167565);
    super.onCreate(paramBundle);
    paramBundle = getPreferenceScreen().aVD("select_male");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.sFY = ((SelectPreference)paramBundle);
    paramBundle = getPreferenceScreen().aVD("select_female");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.sFZ = ((SelectPreference)paramBundle);
    Object localObject = getIntent().getStringExtra("key_input_sex");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    "inputSex = ".concat(String.valueOf(paramBundle));
    h.fUh();
    localObject = this.sFY;
    if (localObject == null) {
      p.bcb("selectMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    localObject = this.sFZ;
    if (localObject == null) {
      p.bcb("selectFeMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    if (p.i(paramBundle, "male"))
    {
      paramBundle = this.sFY;
      if (paramBundle == null) {
        p.bcb("selectMale");
      }
      paramBundle.setSelected(true);
      paramBundle = this.sFZ;
      if (paramBundle == null) {
        p.bcb("selectFeMale");
      }
      paramBundle.setSelected(false);
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, s.b.JbS);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      cKi();
      AppMethodBeat.o(167565);
      return;
      if (p.i(paramBundle, "female"))
      {
        paramBundle = this.sFY;
        if (paramBundle == null) {
          p.bcb("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.sFZ;
        if (paramBundle == null) {
          p.bcb("selectFeMale");
        }
        paramBundle.setSelected(true);
      }
      else
      {
        paramBundle = this.sFY;
        if (paramBundle == null) {
          p.bcb("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.sFZ;
        if (paramBundle == null) {
          p.bcb("selectFeMale");
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
    if (p.i(paramPreference, "select_male"))
    {
      paramPreference = this.sFY;
      if (paramPreference == null) {
        p.bcb("selectMale");
      }
      paramPreference.setSelected(true);
      paramPreference = this.sFZ;
      if (paramPreference == null) {
        p.bcb("selectFeMale");
      }
      paramPreference.setSelected(false);
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      cKi();
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(167567);
      return false;
      if (p.i(paramPreference, "select_female"))
      {
        paramPreference = this.sFY;
        if (paramPreference == null) {
          p.bcb("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.sFZ;
        if (paramPreference == null) {
          p.bcb("selectFeMale");
        }
        paramPreference.setSelected(true);
      }
      else
      {
        paramPreference = this.sFY;
        if (paramPreference == null) {
          p.bcb("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.sFZ;
        if (paramPreference == null) {
          p.bcb("selectFeMale");
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167563);
      FinderSelectSexUI.a(this.sGa);
      AppMethodBeat.o(167563);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167564);
      this.sGa.finish();
      AppMethodBeat.o(167564);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectSexUI
 * JD-Core Version:    0.7.0.1
 */