package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class f$e
  extends Preference
  implements f.f
{
  private final d sIo;
  private final MMPreference sIs;
  
  public f$e(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(204271);
    this.sIs = paramMMPreference;
    this.sIo = paramd;
    setTitle((CharSequence)this.sIo.title);
    setKey(this.sIo.title);
    this.sIs.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(204271);
  }
  
  public final void cKx()
  {
    AppMethodBeat.i(204270);
    String str = "doSomething " + getTitle() + " onClick";
    ad.i("SettingHelper", str);
    t.makeText((Context)this.sIs, (CharSequence)str, 1).show();
    this.sIo.Fq(0);
    AppMethodBeat.o(204270);
  }
  
  public final void refresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f.e
 * JD-Core Version:    0.7.0.1
 */