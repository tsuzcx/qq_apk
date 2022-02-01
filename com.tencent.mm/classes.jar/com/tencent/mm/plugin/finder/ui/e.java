package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "title", "", "operation", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/ui/IClickEvent;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "getTitle", "()Ljava/lang/String;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class e
  extends Preference
  implements k
{
  private final MMPreference rFu;
  private final j rFz;
  private final String title;
  
  public e(MMPreference paramMMPreference, String paramString, j paramj)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(203084);
    this.rFu = paramMMPreference;
    this.title = paramString;
    this.rFz = paramj;
    setTitle((CharSequence)this.title);
    setKey(this.title);
    this.rFu.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(203084);
  }
  
  public final void cBs()
  {
    AppMethodBeat.i(203083);
    String str = "doSomething " + this.title + " onClick";
    ac.i(m.getTAG(), str);
    t.makeText((Context)this.rFu, (CharSequence)str, 1).show();
    this.rFz.onClick();
    AppMethodBeat.o(203083);
  }
  
  public final void refresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e
 * JD-Core Version:    0.7.0.1
 */