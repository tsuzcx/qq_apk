package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.d;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.tools.s.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderSettingsUI$onCreate$searchViewHelper$1$1", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSettingsUI$b
  implements s.c
{
  FinderSettingsUI$b(FinderSettingsUI paramFinderSettingsUI) {}
  
  public final boolean SN(String paramString)
  {
    return false;
  }
  
  public final void SO(String paramString)
  {
    AppMethodBeat.i(346776);
    s.u(paramString, "searchText");
    Object localObject1 = FinderSettingsUI.a(this.FUx);
    if (localObject1 != null) {
      ((h)localObject1).removeAll();
    }
    localObject1 = this.FUx;
    Object localObject2 = FinderSettingsUI.FUu;
    localObject2 = FinderSettingsUI.fbQ();
    if (localObject2 == null) {}
    for (paramString = null;; paramString = (List)localObject2)
    {
      FinderSettingsUI.a((FinderSettingsUI)localObject1, paramString);
      AppMethodBeat.o(346776);
      return;
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (n.i((CharSequence)((d)localObject4).title, (CharSequence)paramString)) {
          ((Collection)localObject2).add(localObject4);
        }
      }
    }
  }
  
  public final void bWw()
  {
    AppMethodBeat.i(346782);
    Object localObject = FinderSettingsUI.a(this.FUx);
    if (localObject != null) {
      ((h)localObject).removeAll();
    }
    localObject = this.FUx;
    FinderSettingsUI.a locala = FinderSettingsUI.FUu;
    FinderSettingsUI.a((FinderSettingsUI)localObject, (List)FinderSettingsUI.fbQ());
    AppMethodBeat.o(346782);
  }
  
  public final void bWx() {}
  
  public final void bWy() {}
  
  public final void bWz() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderSettingsUI.b
 * JD-Core Version:    0.7.0.1
 */