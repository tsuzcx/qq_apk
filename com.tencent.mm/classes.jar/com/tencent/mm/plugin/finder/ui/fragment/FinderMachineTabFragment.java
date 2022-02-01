package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.datareport.a.a.a;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.viewmodel.component.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.au;
import com.tencent.mm.plugin.finder.viewmodel.component.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.bd;
import com.tencent.mm.plugin.finder.viewmodel.component.c;
import com.tencent.mm.plugin.finder.viewmodel.component.e;
import com.tencent.mm.plugin.finder.viewmodel.component.f;
import com.tencent.mm.plugin.finder.viewmodel.component.n;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.ar;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderMachineTabFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", "getCommentScene", "", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMachineTabFragment
  extends FinderHomeTabFragment
{
  public FinderMachineTabFragment()
  {
    super(e.h.finder_tab_machine, 4);
  }
  
  private static final Map aBg(String paramString)
  {
    AppMethodBeat.i(347745);
    String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    r localr1 = v.Y("session_id", paramString);
    str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    r localr2 = v.Y("finder_context_id", paramString);
    str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    paramString = ak.e(new r[] { localr1, localr2, v.Y("finder_tab_context_id", paramString), v.Y("extra_info", ""), v.Y("enter_source_info", "") });
    AppMethodBeat.o(347745);
    return paramString;
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(347764);
    super.eEr();
    ((e)component(e.class)).fnc();
    ((bd)component(bd.class)).fnc();
    AppMethodBeat.o(347764);
  }
  
  public final int getCommentScene()
  {
    return 20;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347759);
    Object localObject = ar.an(new Class[] { bd.class, e.class, aw.class, ag.class, f.class, c.class, au.class });
    ((HashSet)localObject).add(ac.class);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXm().bmg()).intValue() == 1) {
      ((HashSet)localObject).add(n.class);
    }
    localObject = (Set)localObject;
    AppMethodBeat.o(347759);
    return localObject;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(347772);
    super.onCreate(paramBundle);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, a.xgt);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
    ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, FinderMachineTabFragment..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(347772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.FinderMachineTabFragment
 * JD-Core Version:    0.7.0.1
 */