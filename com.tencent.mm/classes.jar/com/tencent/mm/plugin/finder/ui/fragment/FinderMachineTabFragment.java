package com.tencent.mm.plugin.finder.ui.fragment;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.ab;
import com.tencent.mm.plugin.finder.viewmodel.component.am;
import com.tencent.mm.plugin.finder.viewmodel.component.ar;
import com.tencent.mm.plugin.finder.viewmodel.component.e;
import com.tencent.mm.plugin.finder.viewmodel.component.n;
import com.tencent.mm.plugin.finder.viewmodel.component.y;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderMachineTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "plugin-finder_release"})
public final class FinderMachineTabFragment
  extends FinderHomeTabFragment
{
  private HashMap _$_findViewCache;
  
  public FinderMachineTabFragment()
  {
    super(b.j.finder_tab_machine, 4);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(280634);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(280634);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(280633);
    super.dLu();
    ((e)component(e.class)).ekl();
    ((ar)component(ar.class)).ekl();
    AppMethodBeat.o(280633);
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(280632);
    Object localObject = ak.ai(new Class[] { ar.class, e.class, am.class, ab.class });
    if (aj.a(aj.AGc, 4, 0, 2)) {
      ((HashSet)localObject).add(y.class);
    }
    d locald = d.AjH;
    if (((Number)d.dYh().aSr()).intValue() == 1) {
      ((HashSet)localObject).add(n.class);
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(280632);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment
 * JD-Core Version:    0.7.0.1
 */