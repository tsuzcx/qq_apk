package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/IFinderFakeConfig;", "doSomething", "", "refresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i$c
  extends CheckBoxPreference
  implements i.f
{
  private final d FVO;
  private final MMPreference FVQ;
  
  public i$c(MMPreference paramMMPreference, d paramd)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(347185);
    this.FVQ = paramMMPreference;
    this.FVO = paramd;
    paramMMPreference = this.FVO.fsk();
    if (paramMMPreference == null)
    {
      paramMMPreference = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(347185);
      throw paramMMPreference;
    }
    paramMMPreference = paramMMPreference.toUpperCase();
    s.s(paramMMPreference, "(this as java.lang.String).toUpperCase()");
    if (s.p(paramMMPreference, "2021-NOV-P1"))
    {
      paramMMPreference = (CharSequence)s.X("🌟", this.FVO.title);
      setTitle(paramMMPreference);
      setKey(this.FVO.title);
      if (this.FVO.HdL != 1) {
        break label170;
      }
    }
    label170:
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      this.FVQ.getPreferenceScreen().c((Preference)this);
      AppMethodBeat.o(347185);
      return;
      paramMMPreference = (CharSequence)this.FVO.title;
      break;
    }
  }
  
  public final void bDL()
  {
    boolean bool = true;
    AppMethodBeat.i(347192);
    if (this.FVO.HdL == 1) {}
    for (;;)
    {
      setChecked(bool);
      AppMethodBeat.o(347192);
      return;
      bool = false;
    }
  }
  
  public final void fcl()
  {
    AppMethodBeat.i(347197);
    Object localObject = "doSomething " + getTitle() + " isChecked: " + isChecked();
    Log.i("SettingHelper", (String)localObject);
    aa.makeText((Context)this.FVQ, (CharSequence)localObject, 1).show();
    localObject = this.FVO;
    if (isChecked()) {}
    for (int i = 1;; i = 0)
    {
      ((d)localObject).VB(i);
      bDL();
      AppMethodBeat.o(347197);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.i.c
 * JD-Core Version:    0.7.0.1
 */