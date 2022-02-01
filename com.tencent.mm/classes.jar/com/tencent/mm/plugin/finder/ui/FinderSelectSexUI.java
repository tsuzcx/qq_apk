package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.b.m;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.w.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderSelectSexUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "TAG", "", "selectFeMale", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "selectMale", "complete", "", "getFooterResourceId", "", "getResourceId", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreferenceTreeClick", "", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateComplete", "plugin-finder_release"})
public final class FinderSelectSexUI
  extends MMPreference
{
  private SelectPreference AuI;
  private SelectPreference AuJ;
  private final String TAG = "Finder.FinderSelectSexUI";
  private HashMap _$_findViewCache;
  
  private final void eaQ()
  {
    AppMethodBeat.i(167566);
    SelectPreference localSelectPreference = this.AuJ;
    if (localSelectPreference == null) {
      p.bGy("selectFeMale");
    }
    if (!localSelectPreference.getSelected())
    {
      localSelectPreference = this.AuI;
      if (localSelectPreference == null) {
        p.bGy("selectMale");
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
    AppMethodBeat.i(289186);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(289186);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(289185);
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
    AppMethodBeat.o(289185);
    return localView1;
  }
  
  public final int getFooterResourceId()
  {
    return b.g.finder_select_sex_footer;
  }
  
  public final int getResourceId()
  {
    return b.m.finder_select_sex;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167565);
    super.onCreate(paramBundle);
    paramBundle = getPreferenceScreen().byG("select_male");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.AuI = ((SelectPreference)paramBundle);
    paramBundle = getPreferenceScreen().byG("select_female");
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.preference.SelectPreference");
      AppMethodBeat.o(167565);
      throw paramBundle;
    }
    this.AuJ = ((SelectPreference)paramBundle);
    Object localObject = getIntent().getStringExtra("key_input_sex");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    "inputSex = ".concat(String.valueOf(paramBundle));
    h.ioq();
    localObject = this.AuI;
    if (localObject == null) {
      p.bGy("selectMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    localObject = this.AuJ;
    if (localObject == null) {
      p.bGy("selectFeMale");
    }
    ((SelectPreference)localObject).setEnabled(true);
    if (p.h(paramBundle, "male"))
    {
      paramBundle = this.AuI;
      if (paramBundle == null) {
        p.bGy("selectMale");
      }
      paramBundle.setSelected(true);
      paramBundle = this.AuJ;
      if (paramBundle == null) {
        p.bGy("selectFeMale");
      }
      paramBundle.setSelected(false);
    }
    for (;;)
    {
      addTextOptionMenu(0, getString(b.j.app_finish), (MenuItem.OnMenuItemClickListener)new a(this), null, w.b.Wao);
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      eaQ();
      AppMethodBeat.o(167565);
      return;
      if (p.h(paramBundle, "female"))
      {
        paramBundle = this.AuI;
        if (paramBundle == null) {
          p.bGy("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.AuJ;
        if (paramBundle == null) {
          p.bGy("selectFeMale");
        }
        paramBundle.setSelected(true);
      }
      else
      {
        paramBundle = this.AuI;
        if (paramBundle == null) {
          p.bGy("selectMale");
        }
        paramBundle.setSelected(false);
        paramBundle = this.AuJ;
        if (paramBundle == null) {
          p.bGy("selectFeMale");
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
    if (p.h(paramPreference, "select_male"))
    {
      paramPreference = this.AuI;
      if (paramPreference == null) {
        p.bGy("selectMale");
      }
      paramPreference.setSelected(true);
      paramPreference = this.AuJ;
      if (paramPreference == null) {
        p.bGy("selectFeMale");
      }
      paramPreference.setSelected(false);
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
    }
    for (;;)
    {
      eaQ();
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
      AppMethodBeat.o(167567);
      return false;
      if (p.h(paramPreference, "select_female"))
      {
        paramPreference = this.AuI;
        if (paramPreference == null) {
          p.bGy("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.AuJ;
        if (paramPreference == null) {
          p.bGy("selectFeMale");
        }
        paramPreference.setSelected(true);
      }
      else
      {
        paramPreference = this.AuI;
        if (paramPreference == null) {
          p.bGy("selectMale");
        }
        paramPreference.setSelected(false);
        paramPreference = this.AuJ;
        if (paramPreference == null) {
          p.bGy("selectFeMale");
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167563);
      FinderSelectSexUI.a(this.AuK);
      AppMethodBeat.o(167563);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelectSexUI paramFinderSelectSexUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167564);
      this.AuK.finish();
      AppMethodBeat.o(167564);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSelectSexUI
 * JD-Core Version:    0.7.0.1
 */