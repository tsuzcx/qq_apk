package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class f$e
  extends Preference
  implements f.f
{
  private final d sTA;
  private final MMPreference sTE;
  
  public f$e(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(204889);
    this.sTE = paramMMPreference;
    this.sTA = paramd;
    setTitle((CharSequence)this.sTA.title);
    setKey(this.sTA.title);
    this.sTE.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(204889);
  }
  
  public final void cNb()
  {
    AppMethodBeat.i(204888);
    String str = "doSomething " + getTitle() + " onClick";
    ae.i("SettingHelper", str);
    t.makeText((Context)this.sTE, (CharSequence)str, 1).show();
    this.sTA.FN(0);
    AppMethodBeat.o(204888);
  }
  
  public final void refresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f.e
 * JD-Core Version:    0.7.0.1
 */