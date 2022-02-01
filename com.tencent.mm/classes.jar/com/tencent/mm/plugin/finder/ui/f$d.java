package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;)V", "title", "", "getTitle", "()Ljava/lang/String;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class f$d
  extends Preference
  implements f.f
{
  private final d sTA;
  private final MMPreference sTE;
  private f.a sTF;
  private final String title;
  
  public f$d(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(204887);
    this.sTE = paramMMPreference;
    this.sTA = paramd;
    this.sTF = new f.a((Activity)this.sTE, this.sTA);
    this.title = this.sTA.title;
    setTitle((CharSequence)this.title);
    setKey(this.title);
    setSummary((CharSequence)("=>:" + this.sTF.getValue()));
    this.sTE.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(204887);
  }
  
  public final void cNb()
  {
    AppMethodBeat.i(204886);
    ae.i("SettingHelper", "doSomething " + this.title);
    this.sTF.a(this.sTE, (f.f)this);
    AppMethodBeat.o(204886);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(204885);
    setSummary((CharSequence)("=>" + this.sTF.getValue()));
    AppMethodBeat.o(204885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f.d
 * JD-Core Version:    0.7.0.1
 */