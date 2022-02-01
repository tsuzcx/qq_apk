package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class f$c
  extends CheckBoxPreference
  implements f.f
{
  private final d sTA;
  private final MMPreference sTE;
  
  public f$c(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(204884);
    this.sTE = paramMMPreference;
    this.sTA = paramd;
    setTitle((CharSequence)this.sTA.title);
    setKey(this.sTA.title);
    if (this.sTA.sKs == 1) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      this.sTE.getPreferenceScreen().b((Preference)this);
      AppMethodBeat.o(204884);
      return;
    }
  }
  
  public final void cNb()
  {
    AppMethodBeat.i(204883);
    Object localObject = "doSomething " + getTitle() + " isChecked: " + isChecked();
    ae.i("SettingHelper", (String)localObject);
    t.makeText((Context)this.sTE, (CharSequence)localObject, 1).show();
    localObject = this.sTA;
    if (isChecked()) {}
    for (int i = 1;; i = 0)
    {
      ((d)localObject).FN(i);
      refresh();
      AppMethodBeat.o(204883);
      return;
    }
  }
  
  public final void refresh()
  {
    boolean bool = true;
    AppMethodBeat.i(204882);
    if (this.sTA.sKs == 1) {}
    for (;;)
    {
      setChecked(bool);
      AppMethodBeat.o(204882);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f.c
 * JD-Core Version:    0.7.0.1
 */