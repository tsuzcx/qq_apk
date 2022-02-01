package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.plugin.hld.model.b;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldKeyboardSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "oriKeyVoiceChecked", "", "Ljava/lang/Boolean;", "oriTNineChecked", "prefKeySound", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "getPrefKeySound", "()Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "prefKeySound$delegate", "Lkotlin/Lazy;", "prefS1ChineseT9", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "getPrefS1ChineseT9", "()Lcom/tencent/mm/ui/base/preference/SelectPreference;", "prefS1ChineseT9$delegate", "prefS2ChineseQwerty", "getPrefS2ChineseQwerty", "prefS2ChineseQwerty$delegate", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onPreferenceTreeClick", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateStatus", "Companion", "plugin-hld_release"})
public final class HldKeyboardSettingUI
  extends MMPreference
{
  public static final a DGj;
  private final kotlin.f DGg;
  private final kotlin.f DGh;
  private final kotlin.f DGi;
  private Boolean DyE;
  private Boolean DyF;
  
  static
  {
    AppMethodBeat.i(216594);
    DGj = new a((byte)0);
    AppMethodBeat.o(216594);
  }
  
  public HldKeyboardSettingUI()
  {
    AppMethodBeat.i(216593);
    this.DGg = g.ar((a)new e(this));
    this.DGh = g.ar((a)new f(this));
    this.DGi = g.ar((a)new d(this));
    AppMethodBeat.o(216593);
  }
  
  private final SelectPreference eFD()
  {
    AppMethodBeat.i(216579);
    SelectPreference localSelectPreference = (SelectPreference)this.DGg.getValue();
    AppMethodBeat.o(216579);
    return localSelectPreference;
  }
  
  private final SelectPreference eFE()
  {
    AppMethodBeat.i(216581);
    SelectPreference localSelectPreference = (SelectPreference)this.DGh.getValue();
    AppMethodBeat.o(216581);
    return localSelectPreference;
  }
  
  private final CheckBoxPreference eFF()
  {
    AppMethodBeat.i(216583);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.DGi.getValue();
    AppMethodBeat.o(216583);
    return localCheckBoxPreference;
  }
  
  public final int getResourceId()
  {
    return a.m.wxime_keyboard_setting;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216586);
    Object localObject = k.DDb;
    k.NW(System.currentTimeMillis());
    super.onCreate(paramBundle);
    setMMTitle(a.j.contact_info_wxime_keyboard);
    paramBundle = new StringBuilder("imeSetting:");
    localObject = i.DHq;
    Log.i("WxIme.HldSettingUI", i.eGG());
    paramBundle = i.DHq;
    if (i.eEm() == c.Dyl.ordinal())
    {
      eFD().setSelected(true);
      eFE().setSelected(false);
    }
    for (;;)
    {
      paramBundle = i.DHq;
      this.DyE = Boolean.valueOf(i.eGD());
      paramBundle = eFF();
      localObject = i.DHq;
      paramBundle.setChecked(i.eGD());
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      addTextOptionMenu(0, getString(a.j.app_finish), (MenuItem.OnMenuItemClickListener)new c(this), null, w.b.Wao);
      paramBundle = k.DDb;
      k.ap(0, 3, 0);
      AppMethodBeat.o(216586);
      return;
      c.Dym.ordinal();
      eFD().setSelected(false);
      eFE().setSelected(true);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(216588);
    super.onPause();
    AppMethodBeat.o(216588);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(216591);
    p.k(paramf, "screen");
    p.k(paramPreference, "pref");
    paramPreference = paramPreference.getKey();
    paramf = paramPreference;
    if (paramPreference == null) {
      paramf = "";
    }
    switch (paramf.hashCode())
    {
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(216591);
      return true;
      if (paramf.equals("settings_wxime_s1_chinese_t9"))
      {
        eFD().setSelected(true);
        eFE().setSelected(false);
        continue;
        if (paramf.equals("settings_wxime_s2_chinese_qwerty"))
        {
          eFD().setSelected(false);
          eFE().setSelected(true);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldKeyboardSettingUI$Companion;", "", "()V", "KEY_ENABLE_KEY_SOUND", "", "KEY_S1_CHINESE_T9", "KEY_S2_CHINESE_QWERTY", "TAG", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(HldKeyboardSettingUI paramHldKeyboardSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(209414);
      this.DGk.finish();
      AppMethodBeat.o(209414);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(HldKeyboardSettingUI paramHldKeyboardSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(211037);
      boolean bool1 = HldKeyboardSettingUI.a(this.DGk).getSelected();
      ArrayList localArrayList = new ArrayList();
      label86:
      boolean bool2;
      if ((p.h(HldKeyboardSettingUI.b(this.DGk), Boolean.valueOf(bool1)) ^ true))
      {
        if (bool1)
        {
          paramMenuItem = b.DBm;
          localArrayList.add(paramMenuItem);
          if (!bool1) {
            break label249;
          }
          paramMenuItem = k.DDb;
          k.ap(1, 3, 0);
          paramMenuItem = i.DHq;
          i.UJ(c.Dyl.ordinal());
        }
      }
      else
      {
        bool2 = HldKeyboardSettingUI.c(this.DGk).isChecked();
        if ((p.h(HldKeyboardSettingUI.d(this.DGk), Boolean.valueOf(bool2)) ^ true))
        {
          if (!bool2) {
            break label275;
          }
          paramMenuItem = b.DBo;
          label124:
          localArrayList.add(paramMenuItem);
          paramMenuItem = i.DHq;
          i.te(bool2);
          if (!bool2) {
            break label282;
          }
          paramMenuItem = k.DDb;
          k.ap(4, 3, 0);
        }
        label153:
        if (!localArrayList.isEmpty()) {
          break label295;
        }
        Log.i("WxIme.HldSettingUI", "operation is null");
      }
      for (;;)
      {
        Log.i("WxIme.HldSettingUI", "oriTNineChecked:" + HldKeyboardSettingUI.b(this.DGk) + " newTNineChecked:" + bool1 + ", oriKeyVoiceChecked:" + HldKeyboardSettingUI.d(this.DGk) + " newKeyVoiceChecked:" + bool2);
        this.DGk.finish();
        AppMethodBeat.o(211037);
        return true;
        paramMenuItem = b.DBn;
        break;
        label249:
        paramMenuItem = k.DDb;
        k.ap(2, 3, 0);
        paramMenuItem = i.DHq;
        i.UJ(c.Dym.ordinal());
        break label86;
        label275:
        paramMenuItem = b.DBp;
        break label124;
        label282:
        paramMenuItem = k.DDb;
        k.ap(5, 3, 0);
        break label153;
        label295:
        paramMenuItem = e.Dvq;
        e.a.fB((List)localArrayList);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "invoke"})
  static final class d
    extends q
    implements a<CheckBoxPreference>
  {
    d(HldKeyboardSettingUI paramHldKeyboardSettingUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "invoke"})
  static final class e
    extends q
    implements a<SelectPreference>
  {
    e(HldKeyboardSettingUI paramHldKeyboardSettingUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "invoke"})
  static final class f
    extends q
    implements a<SelectPreference>
  {
    f(HldKeyboardSettingUI paramHldKeyboardSettingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldKeyboardSettingUI
 * JD-Core Version:    0.7.0.1
 */