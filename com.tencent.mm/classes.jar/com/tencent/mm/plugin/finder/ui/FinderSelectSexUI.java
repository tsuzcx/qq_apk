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
import com.tencent.mm.ui.r.b;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"})
public final class FinderSelectSexUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectSexUI";
  private SelectPreference qPt;
  private SelectPreference qPu;
  
  private final void cru()
  {
    AppMethodBeat.i(167566);
    SelectPreference localSelectPreference = this.qPu;
    if (localSelectPreference == null) {
      k.aPZ("selectFeMale");
    }
    if (!localSelectPreference.getSelected())
    {
      localSelectPreference = this.qPt;
      if (localSelectPreference == null) {
        k.aPZ("selectMale");
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
    return 2131496251;
  }
  
  public final int getResourceId()
  {
    return 2131951678;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167565);
    super.onCreate(paramBundle);
    paramBundle = getPreferenceScreen().aKk("select_male");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.qPt = ((SelectPreference)paramBundle);
    paramBundle = getPreferenceScreen().aKk("select_female");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.qPu = ((SelectPreference)paramBundle);
    Object localObject = getIntent().getStringExtra("key_input_sex");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    "inputSex = ".concat(String.valueOf(paramBundle));
    h.fmz();
    localObject = this.qPt;
    if (localObject == null) {
      k.aPZ("selectMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    localObject = this.qPu;
    if (localObject == null) {
      k.aPZ("selectFeMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    if (k.g(paramBundle, "male"))
    {
      paramBundle = this.qPt;
      if (paramBundle == null) {
        k.aPZ("selectMale");
      }
      paramBundle.setSelected(true);
      paramBundle = this.qPu;
      if (paramBundle == null) {
        k.aPZ("selectFeMale");
      }
      paramBundle.setSelected(false);
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, r.b.FOB);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      cru();
      AppMethodBeat.o(167565);
      return;
      if (k.g(paramBundle, "female"))
      {
        paramBundle = this.qPt;
        if (paramBundle == null) {
          k.aPZ("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.qPu;
        if (paramBundle == null) {
          k.aPZ("selectFeMale");
        }
        paramBundle.setSelected(true);
      }
      else
      {
        paramBundle = this.qPt;
        if (paramBundle == null) {
          k.aPZ("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.qPu;
        if (paramBundle == null) {
          k.aPZ("selectFeMale");
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
      paramPreference = this.qPt;
      if (paramPreference == null) {
        k.aPZ("selectMale");
      }
      paramPreference.setSelected(true);
      paramPreference = this.qPu;
      if (paramPreference == null) {
        k.aPZ("selectFeMale");
      }
      paramPreference.setSelected(false);
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      cru();
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(167567);
      return false;
      if (k.g(paramPreference, "select_female"))
      {
        paramPreference = this.qPt;
        if (paramPreference == null) {
          k.aPZ("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.qPu;
        if (paramPreference == null) {
          k.aPZ("selectFeMale");
        }
        paramPreference.setSelected(true);
      }
      else
      {
        paramPreference = this.qPt;
        if (paramPreference == null) {
          k.aPZ("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.qPu;
        if (paramPreference == null) {
          k.aPZ("selectFeMale");
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167563);
      FinderSelectSexUI.a(this.qPw);
      AppMethodBeat.o(167563);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167564);
      this.qPw.finish();
      AppMethodBeat.o(167564);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectSexUI
 * JD-Core Version:    0.7.0.1
 */