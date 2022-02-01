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
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"})
public final class FinderSelectSexUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectSexUI";
  private SelectPreference rKX;
  private SelectPreference rKY;
  
  private final void cCj()
  {
    AppMethodBeat.i(167566);
    SelectPreference localSelectPreference = this.rKY;
    if (localSelectPreference == null) {
      k.aVY("selectFeMale");
    }
    if (!localSelectPreference.getSelected())
    {
      localSelectPreference = this.rKX;
      if (localSelectPreference == null) {
        k.aVY("selectMale");
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
    paramBundle = getPreferenceScreen().aPN("select_male");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.rKX = ((SelectPreference)paramBundle);
    paramBundle = getPreferenceScreen().aPN("select_female");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.rKY = ((SelectPreference)paramBundle);
    Object localObject = getIntent().getStringExtra("key_input_sex");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    "inputSex = ".concat(String.valueOf(paramBundle));
    h.fCP();
    localObject = this.rKX;
    if (localObject == null) {
      k.aVY("selectMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    localObject = this.rKY;
    if (localObject == null) {
      k.aVY("selectFeMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    if (k.g(paramBundle, "male"))
    {
      paramBundle = this.rKX;
      if (paramBundle == null) {
        k.aVY("selectMale");
      }
      paramBundle.setSelected(true);
      paramBundle = this.rKY;
      if (paramBundle == null) {
        k.aVY("selectFeMale");
      }
      paramBundle.setSelected(false);
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, s.b.Hom);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      cCj();
      AppMethodBeat.o(167565);
      return;
      if (k.g(paramBundle, "female"))
      {
        paramBundle = this.rKX;
        if (paramBundle == null) {
          k.aVY("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.rKY;
        if (paramBundle == null) {
          k.aVY("selectFeMale");
        }
        paramBundle.setSelected(true);
      }
      else
      {
        paramBundle = this.rKX;
        if (paramBundle == null) {
          k.aVY("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.rKY;
        if (paramBundle == null) {
          k.aVY("selectFeMale");
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
    if (k.g(paramPreference, "select_male"))
    {
      paramPreference = this.rKX;
      if (paramPreference == null) {
        k.aVY("selectMale");
      }
      paramPreference.setSelected(true);
      paramPreference = this.rKY;
      if (paramPreference == null) {
        k.aVY("selectFeMale");
      }
      paramPreference.setSelected(false);
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      cCj();
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(167567);
      return false;
      if (k.g(paramPreference, "select_female"))
      {
        paramPreference = this.rKX;
        if (paramPreference == null) {
          k.aVY("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.rKY;
        if (paramPreference == null) {
          k.aVY("selectFeMale");
        }
        paramPreference.setSelected(true);
      }
      else
      {
        paramPreference = this.rKX;
        if (paramPreference == null) {
          k.aVY("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.rKY;
        if (paramPreference == null) {
          k.aVY("selectFeMale");
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167563);
      FinderSelectSexUI.a(this.rKZ);
      AppMethodBeat.o(167563);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167564);
      this.rKZ.finish();
      AppMethodBeat.o(167564);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectSexUI
 * JD-Core Version:    0.7.0.1
 */