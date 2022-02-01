package com.tencent.mm.plugin.finder.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.accessibility.h;
import com.tencent.mm.plugin.finder.viewmodel.component.aa;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFollowListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "superImportUIComponents", "", "set", "Ljava/util/HashSet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFollowListUI
  extends MMFinderUI
{
  private final String TAG;
  
  public FinderFollowListUI()
  {
    AppMethodBeat.i(167282);
    this.TAG = "Finder.FinderFollowListUI";
    AppMethodBeat.o(167282);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getCommentScene()
  {
    return 12;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346701);
    Set localSet = ar.setOf(aa.class);
    AppMethodBeat.o(346701);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(346707);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(h.class);
    AppMethodBeat.o(346707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFollowListUI
 * JD-Core Version:    0.7.0.1
 */