package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/DebugBoxPref;", "Lcom/tencent/mm/ui/base/preference/CheckBoxPreference;", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "title", "", "operation", "Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/ui/IAutoValue;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/IAutoValue;", "getTitle", "()Ljava/lang/String;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class e
  extends CheckBoxPreference
  implements l
{
  private final MMPreference KXJ;
  private final j KXK;
  private final String title;
  
  public e(MMPreference paramMMPreference, String paramString, j paramj)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(199107);
    this.KXJ = paramMMPreference;
    this.title = paramString;
    this.KXK = paramj;
    setTitle((CharSequence)this.title);
    setKey(this.title);
    setChecked(this.KXK.fVE());
    this.KXJ.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(199107);
  }
  
  public final void fVl()
  {
    AppMethodBeat.i(199106);
    String str = "doSomething " + this.title + " isChecked: " + isChecked();
    ad.i(m.getTAG(), str);
    t.makeText((Context)this.KXJ, (CharSequence)str, 1).show();
    this.KXK.yJ(isChecked());
    refresh();
    AppMethodBeat.o(199106);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(199105);
    setChecked(this.KXK.fVE());
    AppMethodBeat.o(199105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.e
 * JD-Core Version:    0.7.0.1
 */