package com.tencent.mm.plugin.finder.nearby.person;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.plugin.finder.nearby.report.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isNeedSwitchTabOnResume", "", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyPersonFragment
  extends AbsNearByFragment
{
  public NearbyPersonFragment()
  {
    super(e.h.nearby_tab_person, 1003);
  }
  
  public final void eEp()
  {
    AppMethodBeat.i(339906);
    super.eEp();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onMenuClick()");
      AppMethodBeat.o(339906);
      return;
    }
    ((b)component(b.class)).eGe();
    d locald = d.EQT;
    d.report(5L);
    AppMethodBeat.o(339906);
  }
  
  public final void eEq()
  {
    AppMethodBeat.i(339897);
    super.eEq();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarClick()");
      AppMethodBeat.o(339897);
      return;
    }
    component(b.class);
    AppMethodBeat.o(339897);
  }
  
  public final void eEr()
  {
    AppMethodBeat.i(339901);
    super.eEr();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarDoubleClick()");
      AppMethodBeat.o(339901);
      return;
    }
    Object localObject1 = ((b)component(b.class)).pVC;
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    AppMethodBeat.o(339901);
  }
  
  public final boolean eEs()
  {
    return false;
  }
  
  public final String eEt()
  {
    return "1003";
  }
  
  public final String eEw()
  {
    AppMethodBeat.i(339941);
    String str = s.X("77-", "1003");
    AppMethodBeat.o(339941);
    return str;
  }
  
  public final int edC()
  {
    return 0;
  }
  
  public final int getCommentScene()
  {
    return 77;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(339888);
    Set localSet = ar.setOf(b.class);
    AppMethodBeat.o(339888);
    return localSet;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(339951);
    s.u(paramArrayOfString, "permissions");
    s.u(paramArrayOfInt, "grantResults");
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    ((b)component(b.class)).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(339951);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(339910);
    super.onUserVisibleFocused();
    g localg = g.ERj;
    g.d((AbsNearByFragment)this);
    AppMethodBeat.o(339910);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(339917);
    super.onUserVisibleUnFocused();
    g localg = g.ERj;
    g.e((AbsNearByFragment)this);
    AppMethodBeat.o(339917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonFragment
 * JD-Core Version:    0.7.0.1
 */