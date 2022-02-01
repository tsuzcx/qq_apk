package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$e
  extends Preference
  implements i.f
{
  private final d FVO;
  private final MMPreference FVQ;
  
  public i$e(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(347071);
    this.FVQ = paramMMPreference;
    this.FVO = paramd;
    paramMMPreference = this.FVO.fsk();
    if (paramMMPreference == null)
    {
      paramMMPreference = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(347071);
      throw paramMMPreference;
    }
    paramMMPreference = paramMMPreference.toUpperCase();
    s.s(paramMMPreference, "(this as java.lang.String).toUpperCase()");
    if (s.p(paramMMPreference, "2021-NOV-P1")) {}
    for (paramMMPreference = (CharSequence)s.X("🌟", this.FVO.title);; paramMMPreference = (CharSequence)this.FVO.title)
    {
      setTitle(paramMMPreference);
      setKey(this.FVO.title);
      this.FVQ.getPreferenceScreen().c((Preference)this);
      AppMethodBeat.o(347071);
      return;
    }
  }
  
  public final void bDL() {}
  
  public final void fcl()
  {
    AppMethodBeat.i(347078);
    String str = "doSomething " + getTitle() + " onClick";
    Log.i("SettingHelper", str);
    aa.makeText((Context)this.FVQ, (CharSequence)str, 1).show();
    this.FVO.VB(0);
    AppMethodBeat.o(347078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.i.e
 * JD-Core Version:    0.7.0.1
 */