package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class j$e
  extends Preference
  implements j.f
{
  private final e vQf;
  private final MMPreference vQj;
  
  public j$e(MMPreference paramMMPreference, e parame)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(252819);
    this.vQj = paramMMPreference;
    this.vQf = parame;
    if (p.j(this.vQf.dyq(), "T5")) {}
    for (paramMMPreference = (CharSequence)("🌟" + this.vQf.title);; paramMMPreference = (CharSequence)this.vQf.title)
    {
      setTitle(paramMMPreference);
      setKey(this.vQf.title);
      this.vQj.getPreferenceScreen().c((Preference)this);
      AppMethodBeat.o(252819);
      return;
    }
  }
  
  public final void dAo()
  {
    AppMethodBeat.i(252818);
    String str = "doSomething " + getTitle() + " onClick";
    Log.i("SettingHelper", str);
    u.makeText((Context)this.vQj, (CharSequence)str, 1).show();
    this.vQf.Lc(0);
    AppMethodBeat.o(252818);
  }
  
  public final void refresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.j.e
 * JD-Core Version:    0.7.0.1
 */