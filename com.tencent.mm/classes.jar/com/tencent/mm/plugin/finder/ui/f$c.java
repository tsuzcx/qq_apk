package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class f$c
  extends CheckBoxPreference
  implements f.f
{
  private final d sIo;
  private final MMPreference sIs;
  
  public f$c(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(204266);
    this.sIs = paramMMPreference;
    this.sIo = paramd;
    setTitle((CharSequence)this.sIo.title);
    setKey(this.sIo.title);
    if (this.sIo.szz == 1) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      this.sIs.getPreferenceScreen().b((Preference)this);
      AppMethodBeat.o(204266);
      return;
    }
  }
  
  public final void cKx()
  {
    AppMethodBeat.i(204265);
    Object localObject = "doSomething " + getTitle() + " isChecked: " + isChecked();
    ad.i("SettingHelper", (String)localObject);
    t.makeText((Context)this.sIs, (CharSequence)localObject, 1).show();
    localObject = this.sIo;
    if (isChecked()) {}
    for (int i = 1;; i = 0)
    {
      ((d)localObject).Fq(i);
      refresh();
      AppMethodBeat.o(204265);
      return;
    }
  }
  
  public final void refresh()
  {
    boolean bool = true;
    AppMethodBeat.i(204264);
    if (this.sIo.szz == 1) {}
    for (;;)
    {
      setChecked(bool);
      AppMethodBeat.o(204264);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f.c
 * JD-Core Version:    0.7.0.1
 */