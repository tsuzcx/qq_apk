package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.viewmodel.component.bb;
import com.tencent.mm.plugin.finder.viewmodel.component.e;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLbsTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLbsTabFragment
  extends FinderHomeTabFragment
{
  public FinderLbsTabFragment()
  {
    super(e.h.finder_tab_lbs, 2);
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(347689);
    super.eEr();
    ((e)component(e.class)).fnc();
    ((bb)component(bb.class)).eEr();
    AppMethodBeat.o(347689);
  }
  
  public final int getCommentScene()
  {
    return 16;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347684);
    Set localSet = ar.setOf(new Class[] { bb.class, e.class });
    AppMethodBeat.o(347684);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderLbsTabFragment
 * JD-Core Version:    0.7.0.1
 */