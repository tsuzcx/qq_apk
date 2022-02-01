package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.tools.r.b;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$onCreate$searchViewHelper$1$1", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "plugin-finder_release"})
public final class FinderSettingsUI$c
  implements r.b
{
  FinderSettingsUI$c(FinderSettingsUI paramFinderSettingsUI) {}
  
  public final boolean Jp(String paramString)
  {
    return false;
  }
  
  public final void Jq(String paramString)
  {
    AppMethodBeat.i(221548);
    p.h(paramString, "searchText");
    Object localObject1 = FinderSettingsUI.a(this.sHi);
    if (localObject1 != null) {
      ((h)localObject1).removeAll();
    }
    localObject1 = this.sHi;
    Object localObject2 = FinderSettingsUI.sHh;
    localObject2 = FinderSettingsUI.fnf();
    if (localObject2 != null)
    {
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (n.e((CharSequence)((d)localObject4).title, (CharSequence)paramString)) {
          ((Collection)localObject2).add(localObject4);
        }
      }
    }
    for (paramString = (List)localObject2;; paramString = null)
    {
      FinderSettingsUI.a((FinderSettingsUI)localObject1, paramString);
      AppMethodBeat.o(221548);
      return;
    }
  }
  
  public final void aSm()
  {
    AppMethodBeat.i(221549);
    Object localObject = FinderSettingsUI.a(this.sHi);
    if (localObject != null) {
      ((h)localObject).removeAll();
    }
    localObject = this.sHi;
    FinderSettingsUI.a locala = FinderSettingsUI.sHh;
    FinderSettingsUI.a((FinderSettingsUI)localObject, FinderSettingsUI.fnf());
    AppMethodBeat.o(221549);
  }
  
  public final void aSn() {}
  
  public final void aSo() {}
  
  public final void aSp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.c
 * JD-Core Version:    0.7.0.1
 */