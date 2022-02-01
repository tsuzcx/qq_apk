package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import d.g.a.a;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "title", "", "_key", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "_items", "", "_vals", "", "onEvent", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Ljava/lang/String;Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;[Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "get_items", "()[Ljava/lang/String;", "set_items", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "get_key", "()Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "set_key", "(Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;)V", "get_vals", "()Ljava/lang/Object;", "set_vals", "(Ljava/lang/Object;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getOnEvent", "()Lkotlin/jvm/functions/Function0;", "operation", "Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/ChoiceItem;)V", "getTitle", "()Ljava/lang/String;", "doSomething", "refresh", "plugin-finder_release"})
public final class f
  extends Preference
  implements l
{
  private final MMPreference KXJ;
  private d KXL;
  private final a<y> KXM;
  private ae.a qPX;
  private String[] qPY;
  private Object qPZ;
  private final String title;
  
  public f(MMPreference paramMMPreference, String paramString, ae.a parama, String[] paramArrayOfString, Object paramObject, a<y> parama1)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(199111);
    this.KXJ = paramMMPreference;
    this.title = paramString;
    this.qPX = parama;
    this.qPY = paramArrayOfString;
    this.qPZ = paramObject;
    this.KXM = parama1;
    this.KXL = new d((Activity)this.KXJ, this.qPX, this.qPY, this.qPZ);
    setTitle((CharSequence)this.title);
    setKey(this.title);
    setSummary((CharSequence)("=>:" + this.KXL.getValue()));
    this.KXJ.getPreferenceScreen().b((Preference)this);
    AppMethodBeat.o(199111);
  }
  
  public final void fVl()
  {
    AppMethodBeat.i(199110);
    ad.i(m.getTAG(), "doSomething " + this.title);
    this.KXL.a(this.KXJ, (l)this);
    AppMethodBeat.o(199110);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(199109);
    setSummary((CharSequence)("=>" + this.KXL.getValue()));
    this.KXM.invoke();
    AppMethodBeat.o(199109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.f
 * JD-Core Version:    0.7.0.1
 */