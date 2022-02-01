package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.e;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.e;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/SettingHelper$DebugChoicePref;", "Lcom/tencent/mm/ui/base/preference/Preference;", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$IPreferenceEvent;", "activity", "Lcom/tencent/mm/ui/base/preference/MMPreference;", "config", "Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "(Lcom/tencent/mm/ui/base/preference/MMPreference;Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;)V", "getActivity", "()Lcom/tencent/mm/ui/base/preference/MMPreference;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "operation", "Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "getOperation", "()Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;", "setOperation", "(Lcom/tencent/mm/plugin/finder/ui/SettingHelper$ChoiceItem;)V", "doSomething", "", "refresh", "plugin-finder_release"})
public final class j$d
  extends Preference
  implements j.f
{
  private final e vQf;
  private final MMPreference vQj;
  private j.a vQk;
  
  public j$d(MMPreference paramMMPreference, e parame)
  {
    super((Context)paramMMPreference);
    AppMethodBeat.i(252817);
    this.vQj = paramMMPreference;
    this.vQf = parame;
    this.vQk = new j.a((Activity)this.vQj, this.vQf);
    if (p.j(this.vQf.dyq(), "T5")) {}
    for (paramMMPreference = (CharSequence)("🌟" + this.vQf.title);; paramMMPreference = (CharSequence)this.vQf.title)
    {
      setTitle(paramMMPreference);
      setKey(this.vQf.title);
      setSummary((CharSequence)String.valueOf(this.vQk.getValue()));
      this.vQj.getPreferenceScreen().c((Preference)this);
      AppMethodBeat.o(252817);
      return;
    }
  }
  
  public final void dAo()
  {
    AppMethodBeat.i(252816);
    j.a locala = this.vQk;
    MMPreference localMMPreference = this.vQj;
    j.f localf = (j.f)this;
    p.h(localMMPreference, "activity");
    p.h(localf, "operation");
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    List localList = locala.vQe;
    if (localList == null) {
      p.hyc();
    }
    int j = ((Collection)localList).size();
    int i = 0;
    while (i < j)
    {
      localList = locala.vQe;
      if (localList == null) {
        p.hyc();
      }
      localLinkedList1.add(localList.get(i));
      localLinkedList2.add(Integer.valueOf(i));
      i += 1;
    }
    h.a((Context)localMMPreference, "", (List)localLinkedList1, (List)localLinkedList2, "", (h.e)new j.a.a(locala, localf, localMMPreference));
    AppMethodBeat.o(252816);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(252815);
    setSummary((CharSequence)String.valueOf(this.vQk.getValue()));
    AppMethodBeat.o(252815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.j.d
 * JD-Core Version:    0.7.0.1
 */