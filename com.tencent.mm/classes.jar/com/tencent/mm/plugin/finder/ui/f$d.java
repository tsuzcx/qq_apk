package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;)V", "title", "", "getTitle", "()Ljava/lang/String;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class f$d
  extends Preference
  implements f.f
{
  private final d sIo;
  private final MMPreference sIs;
  private f.a sIt;
  private final String title;
  
  public f$d(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(204269);
    this.sIs = paramMMPreference;
    this.sIo = paramd;
    this.sIt = new f.a((Activity)this.sIs, this.sIo);
    this.title = this.sIo.title;
    setTitle((CharSequence)this.title);
    setKey(this.title);
    setSummary((CharSequence)("=>:" + this.sIt.getValue()));
    this.sIs.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(204269);
  }
  
  public final void cKx()
  {
    AppMethodBeat.i(204268);
    ad.i("SettingHelper", "doSomething " + this.title);
    this.sIt.a(this.sIs, (f.f)this);
    AppMethodBeat.o(204268);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(204267);
    setSummary((CharSequence)("=>" + this.sIt.getValue()));
    AppMethodBeat.o(204267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f.d
 * JD-Core Version:    0.7.0.1
 */