package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/DebugClickPref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "title", "", "operation", "Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/ui/IClickEvent;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/IClickEvent;", "getTitle", "()Ljava/lang/String;", "doSomething", "", "refresh", "plugin-finder_release"})
public final class g
  extends Preference
  implements l
{
  private final MMPreference KXJ;
  private final k KXO;
  private final String title;
  
  public g(MMPreference paramMMPreference, String paramString, k paramk)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(199114);
    this.KXJ = paramMMPreference;
    this.title = paramString;
    this.KXO = paramk;
    setTitle((CharSequence)this.title);
    setKey(this.title);
    this.KXJ.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(199114);
  }
  
  public final void fVl()
  {
    AppMethodBeat.i(199113);
    String str = "doSomething " + this.title + " onClick";
    ad.i(m.getTAG(), str);
    t.makeText((Context)this.KXJ, (CharSequence)str, 1).show();
    this.KXO.onClick();
    AppMethodBeat.o(199113);
  }
  
  public final void refresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.g
 * JD-Core Version:    0.7.0.1
 */