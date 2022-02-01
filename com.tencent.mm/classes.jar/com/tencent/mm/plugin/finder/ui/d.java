package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "title", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "onEvent", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getOnEvent", "()Lkotlin/jvm/functions/Function0;", "operation", "Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;)V", "getTitle", "()Ljava/lang/String;", "doSomething", "refresh", "plugin-finder_release"})
public final class d
  extends Preference
  implements k
{
  private ah.a gFx;
  private String[] gFy;
  private Object gFz;
  private final MMPreference rFu;
  private a rFw;
  private final d.g.a.a<y> rFx;
  private final String title;
  
  public d(MMPreference paramMMPreference, String paramString, ah.a parama, String[] paramArrayOfString, Object paramObject, d.g.a.a<y> parama1)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(203081);
    this.rFu = paramMMPreference;
    this.title = paramString;
    this.gFx = parama;
    this.gFy = paramArrayOfString;
    this.gFz = paramObject;
    this.rFx = parama1;
    this.rFw = new a((Activity)this.rFu, this.gFx, this.gFy, this.gFz);
    setTitle((CharSequence)this.title);
    setKey(this.title);
    setSummary((CharSequence)("=>:" + this.rFw.getValue()));
    this.rFu.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(203081);
  }
  
  public final void cBs()
  {
    AppMethodBeat.i(203080);
    ac.i(m.getTAG(), "doSomething " + this.title);
    this.rFw.a(this.rFu, (k)this);
    AppMethodBeat.o(203080);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(203079);
    setSummary((CharSequence)("=>" + this.rFw.getValue()));
    this.rFx.invoke();
    AppMethodBeat.o(203079);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.d
 * JD-Core Version:    0.7.0.1
 */