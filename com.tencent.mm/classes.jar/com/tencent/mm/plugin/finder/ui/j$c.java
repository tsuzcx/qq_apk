package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class j$c
  extends CheckBoxPreference
  implements j.f
{
  private final e vQf;
  private final MMPreference vQj;
  
  public j$c(MMPreference paramMMPreference, e parame)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(252814);
    this.vQj = paramMMPreference;
    this.vQf = parame;
    if (p.j(this.vQf.dyq(), "T5"))
    {
      paramMMPreference = (CharSequence)("🌟" + this.vQf.title);
      setTitle(paramMMPreference);
      setKey(this.vQf.title);
      if (this.vQf.vFI != 1) {
        break label146;
      }
    }
    label146:
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      this.vQj.getPreferenceScreen().c((Preference)this);
      AppMethodBeat.o(252814);
      return;
      paramMMPreference = (CharSequence)this.vQf.title;
      break;
    }
  }
  
  public final void dAo()
  {
    AppMethodBeat.i(252813);
    Object localObject = "doSomething " + getTitle() + " isChecked: " + isChecked();
    Log.i("SettingHelper", (String)localObject);
    u.makeText((Context)this.vQj, (CharSequence)localObject, 1).show();
    localObject = this.vQf;
    if (isChecked()) {}
    for (int i = 1;; i = 0)
    {
      ((e)localObject).Lc(i);
      refresh();
      AppMethodBeat.o(252813);
      return;
    }
  }
  
  public final void refresh()
  {
    boolean bool = true;
    AppMethodBeat.i(252812);
    if (this.vQf.vFI == 1) {}
    for (;;)
    {
      setChecked(bool);
      AppMethodBeat.o(252812);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.j.c
 * JD-Core Version:    0.7.0.1
 */