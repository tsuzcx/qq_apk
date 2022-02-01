package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "title", "", "operation", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/ui/IAutoValue;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "getTitle", "()Ljava/lang/String;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class c
  extends CheckBoxPreference
  implements k
{
  private final MMPreference rFu;
  private final i rFv;
  private final String title;
  
  public c(MMPreference paramMMPreference, String paramString, i parami)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(203077);
    this.rFu = paramMMPreference;
    this.title = paramString;
    this.rFv = parami;
    setTitle((CharSequence)this.title);
    setKey(this.title);
    setChecked(this.rFv.cCl());
    this.rFu.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(203077);
  }
  
  public final void cBs()
  {
    AppMethodBeat.i(203076);
    String str = "doSomething " + this.title + " isChecked: " + isChecked();
    ac.i(m.getTAG(), str);
    t.makeText((Context)this.rFu, (CharSequence)str, 1).show();
    this.rFv.lM(isChecked());
    refresh();
    AppMethodBeat.o(203076);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(203075);
    setChecked(this.rFv.cCl());
    AppMethodBeat.o(203075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.c
 * JD-Core Version:    0.7.0.1
 */