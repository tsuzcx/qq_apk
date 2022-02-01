package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;)V", "doSomething", "", "refresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$d
  extends Preference
  implements i.f
{
  private final d FVO;
  private final MMPreference FVQ;
  private i.a FVR;
  
  public i$d(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(347070);
    this.FVQ = paramMMPreference;
    this.FVO = paramd;
    this.FVR = new i.a((Activity)this.FVQ, this.FVO);
    paramMMPreference = this.FVO.fsk();
    if (paramMMPreference == null)
    {
      paramMMPreference = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(347070);
      throw paramMMPreference;
    }
    paramMMPreference = paramMMPreference.toUpperCase();
    s.s(paramMMPreference, "(this as java.lang.String).toUpperCase()");
    if (s.p(paramMMPreference, "2021-NOV-P1")) {}
    for (paramMMPreference = (CharSequence)s.X("🌟", this.FVO.title);; paramMMPreference = (CharSequence)this.FVO.title)
    {
      setTitle(paramMMPreference);
      setKey(this.FVO.title);
      aS((CharSequence)String.valueOf(this.FVR.getValue()));
      this.FVQ.getPreferenceScreen().c((Preference)this);
      AppMethodBeat.o(347070);
      return;
    }
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(347080);
    aS((CharSequence)String.valueOf(this.FVR.getValue()));
    AppMethodBeat.o(347080);
  }
  
  public final void fcl()
  {
    AppMethodBeat.i(347088);
    this.FVR.a(this.FVQ, (i.f)this);
    AppMethodBeat.o(347088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.i.d
 * JD-Core Version:    0.7.0.1
 */