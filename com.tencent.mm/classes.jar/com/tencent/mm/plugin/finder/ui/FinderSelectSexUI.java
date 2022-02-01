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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"})
public final class FinderSelectSexUI
  extends MMPreference
{
  private final String TAG = "Finder.FinderSelectSexUI";
  private SelectPreference sQX;
  private SelectPreference sQY;
  
  private final void cML()
  {
    AppMethodBeat.i(167566);
    SelectPreference localSelectPreference = this.sQY;
    if (localSelectPreference == null) {
      p.bdF("selectFeMale");
    }
    if (!localSelectPreference.getSelected())
    {
      localSelectPreference = this.sQX;
      if (localSelectPreference == null) {
        p.bdF("selectMale");
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
    paramBundle = getPreferenceScreen().aXe("select_male");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.sQX = ((SelectPreference)paramBundle);
    paramBundle = getPreferenceScreen().aXe("select_female");
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.sQY = ((SelectPreference)paramBundle);
    Object localObject = getIntent().getStringExtra("key_input_sex");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    "inputSex = ".concat(String.valueOf(paramBundle));
    h.fYG();
    localObject = this.sQX;
    if (localObject == null) {
      p.bdF("selectMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    localObject = this.sQY;
    if (localObject == null) {
      p.bdF("selectFeMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    if (p.i(paramBundle, "male"))
    {
      paramBundle = this.sQX;
      if (paramBundle == null) {
        p.bdF("selectMale");
      }
      paramBundle.setSelected(true);
      paramBundle = this.sQY;
      if (paramBundle == null) {
        p.bdF("selectFeMale");
      }
      paramBundle.setSelected(false);
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(2131755779), (MenuItem.OnMenuItemClickListener)new a(this), null, s.b.JwA);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      cML();
      AppMethodBeat.o(167565);
      return;
      if (p.i(paramBundle, "female"))
      {
        paramBundle = this.sQX;
        if (paramBundle == null) {
          p.bdF("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.sQY;
        if (paramBundle == null) {
          p.bdF("selectFeMale");
        }
        paramBundle.setSelected(true);
      }
      else
      {
        paramBundle = this.sQX;
        if (paramBundle == null) {
          p.bdF("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.sQY;
        if (paramBundle == null) {
          p.bdF("selectFeMale");
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
      paramPreference = this.sQX;
      if (paramPreference == null) {
        p.bdF("selectMale");
      }
      paramPreference.setSelected(true);
      paramPreference = this.sQY;
      if (paramPreference == null) {
        p.bdF("selectFeMale");
      }
      paramPreference.setSelected(false);
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      cML();
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(167567);
      return false;
      if (p.i(paramPreference, "select_female"))
      {
        paramPreference = this.sQX;
        if (paramPreference == null) {
          p.bdF("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.sQY;
        if (paramPreference == null) {
          p.bdF("selectFeMale");
        }
        paramPreference.setSelected(true);
      }
      else
      {
        paramPreference = this.sQX;
        if (paramPreference == null) {
          p.bdF("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.sQY;
        if (paramPreference == null) {
          p.bdF("selectFeMale");
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167563);
      FinderSelectSexUI.a(this.sQZ);
      AppMethodBeat.o(167563);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167564);
      this.sQZ.finish();
      AppMethodBeat.o(167564);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectSexUI
 * JD-Core Version:    0.7.0.1
 */