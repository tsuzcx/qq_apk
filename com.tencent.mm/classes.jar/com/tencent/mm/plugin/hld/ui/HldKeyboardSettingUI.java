package com.tencent.mm.plugin.hld.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.plugin.hld.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.y.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldKeyboardSettingUI;", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "()V", "oriKeyVoiceChecked", "", "Ljava/lang/Boolean;", "oriTNineChecked", "prefKeySound", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "getPrefKeySound", "()Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "prefKeySound$delegate", "Lkotlin/Lazy;", "prefS1ChineseT9", "Lcom/tencent/mm/ui/base/preference/SelectPreference;", "getPrefS1ChineseT9", "()Lcom/tencent/mm/ui/base/preference/SelectPreference;", "prefS1ChineseT9$delegate", "prefS2ChineseQwerty", "getPrefS2ChineseQwerty", "prefS2ChineseQwerty$delegate", "getResourceId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onPreferenceTreeClick", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "updateStatus", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldKeyboardSettingUI
  extends MMPreference
{
  public static final HldKeyboardSettingUI.a JxH;
  private Boolean JrJ;
  private Boolean JrK;
  private final j JxI;
  private final j JxJ;
  private final j JxK;
  
  static
  {
    AppMethodBeat.i(312310);
    JxH = new HldKeyboardSettingUI.a((byte)0);
    AppMethodBeat.o(312310);
  }
  
  public HldKeyboardSettingUI()
  {
    AppMethodBeat.i(312259);
    this.JxI = kotlin.k.cm((a)new c(this));
    this.JxJ = kotlin.k.cm((a)new d(this));
    this.JxK = kotlin.k.cm((a)new b(this));
    AppMethodBeat.o(312259);
  }
  
  private static final boolean a(HldKeyboardSettingUI paramHldKeyboardSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312287);
    s.u(paramHldKeyboardSettingUI, "this$0");
    paramHldKeyboardSettingUI.finish();
    AppMethodBeat.o(312287);
    return true;
  }
  
  private static final boolean b(HldKeyboardSettingUI paramHldKeyboardSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312302);
    s.u(paramHldKeyboardSettingUI, "this$0");
    boolean bool1 = paramHldKeyboardSettingUI.fNx().isSelected;
    ArrayList localArrayList = new ArrayList();
    label84:
    boolean bool2;
    if (!s.p(paramHldKeyboardSettingUI.JrK, Boolean.valueOf(bool1)))
    {
      if (bool1)
      {
        paramMenuItem = b.Jul;
        localArrayList.add(paramMenuItem);
        if (!bool1) {
          break label230;
        }
        paramMenuItem = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.aL(1, 3, 0);
        paramMenuItem = i.JyA;
        i.YH(c.Jrp.ordinal());
      }
    }
    else
    {
      bool2 = paramHldKeyboardSettingUI.fNz().isChecked();
      if (!s.p(paramHldKeyboardSettingUI.JrJ, Boolean.valueOf(bool2)))
      {
        if (!bool2) {
          break label256;
        }
        paramMenuItem = b.Jun;
        label114:
        localArrayList.add(paramMenuItem);
        paramMenuItem = i.JyA;
        i.xp(bool2);
        if (!bool2) {
          break label263;
        }
        paramMenuItem = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.aL(4, 3, 0);
      }
      label143:
      if (!localArrayList.isEmpty()) {
        break label276;
      }
      Log.i("WxIme.HldSettingUI", "operation is null");
    }
    for (;;)
    {
      Log.i("WxIme.HldSettingUI", "oriTNineChecked:" + paramHldKeyboardSettingUI.JrK + " newTNineChecked:" + bool1 + ", oriKeyVoiceChecked:" + paramHldKeyboardSettingUI.JrJ + " newKeyVoiceChecked:" + bool2);
      paramHldKeyboardSettingUI.finish();
      AppMethodBeat.o(312302);
      return true;
      paramMenuItem = b.Jum;
      break;
      label230:
      paramMenuItem = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.aL(2, 3, 0);
      paramMenuItem = i.JyA;
      i.YH(c.Jrq.ordinal());
      break label84;
      label256:
      paramMenuItem = b.Juo;
      break label114;
      label263:
      paramMenuItem = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.aL(5, 3, 0);
      break label143;
      label276:
      paramMenuItem = e.JoK;
      e.a.iy((List)localArrayList);
    }
  }
  
  private final SelectPreference fNx()
  {
    AppMethodBeat.i(312266);
    SelectPreference localSelectPreference = (SelectPreference)this.JxI.getValue();
    AppMethodBeat.o(312266);
    return localSelectPreference;
  }
  
  private final SelectPreference fNy()
  {
    AppMethodBeat.i(312273);
    SelectPreference localSelectPreference = (SelectPreference)this.JxJ.getValue();
    AppMethodBeat.o(312273);
    return localSelectPreference;
  }
  
  private final CheckBoxPreference fNz()
  {
    AppMethodBeat.i(312281);
    CheckBoxPreference localCheckBoxPreference = (CheckBoxPreference)this.JxK.getValue();
    AppMethodBeat.o(312281);
    return localCheckBoxPreference;
  }
  
  public final int getResourceId()
  {
    return a.m.wxime_keyboard_setting;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312341);
    Object localObject = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.rO(System.currentTimeMillis());
    super.onCreate(paramBundle);
    setMMTitle(a.j.contact_info_wxime_keyboard);
    paramBundle = i.JyA;
    Log.i("WxIme.HldSettingUI", s.X("imeSetting:", Integer.valueOf(i.fOs())));
    paramBundle = i.JyA;
    if (i.fMo() == c.Jrp.ordinal()) {
      fNx().isSelected = true;
    }
    for (fNy().isSelected = false;; fNy().isSelected = true)
    {
      paramBundle = i.JyA;
      this.JrJ = Boolean.valueOf(i.fOp());
      paramBundle = fNz();
      localObject = i.JyA;
      paramBundle.setChecked(i.fOp());
      setBackBtn(new HldKeyboardSettingUI..ExternalSyntheticLambda0(this));
      addTextOptionMenu(0, getString(a.j.app_finish), new HldKeyboardSettingUI..ExternalSyntheticLambda1(this), null, y.b.adEJ);
      paramBundle = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.aL(0, 3, 0);
      AppMethodBeat.o(312341);
      return;
      c.Jrq.ordinal();
      fNx().isSelected = false;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(312347);
    super.onPause();
    AppMethodBeat.o(312347);
  }
  
  public final boolean onPreferenceTreeClick(f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(312354);
    s.u(paramf, "screen");
    s.u(paramPreference, "pref");
    paramPreference = paramPreference.mKey;
    paramf = paramPreference;
    if (paramPreference == null) {
      paramf = "";
    }
    if (s.p(paramf, "settings_wxime_s1_chinese_t9"))
    {
      fNx().isSelected = true;
      fNy().isSelected = false;
    }
    for (;;)
    {
      getPreferenceScreen().notifyDataSetChanged();
      AppMethodBeat.o(312354);
      return true;
      if (s.p(paramf, "settings_wxime_s2_chinese_qwerty"))
      {
        fNx().isSelected = false;
        fNy().isSelected = true;
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<CheckBoxPreference>
  {
    b(HldKeyboardSettingUI paramHldKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/preference/SelectPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<SelectPreference>
  {
    c(HldKeyboardSettingUI paramHldKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/base/preference/SelectPreference;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<SelectPreference>
  {
    d(HldKeyboardSettingUI paramHldKeyboardSettingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldKeyboardSettingUI
 * JD-Core Version:    0.7.0.1
 */