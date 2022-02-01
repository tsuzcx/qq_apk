package com.tencent.mm.plugin.finder.nearby.person;

import android.content.Context;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder-nearby_release"})
public final class NearbyPersonFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  
  public NearbyPersonFragment()
  {
    super(b.j.nearby_tab_person, 1003);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(200945);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(200945);
  }
  
  public final String akA()
  {
    return "77-1003";
  }
  
  public final void dLs()
  {
    AppMethodBeat.i(200940);
    super.dLs();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onMenuClick()");
      AppMethodBeat.o(200940);
      return;
    }
    Object localObject = (b)component(b.class);
    ((b)localObject).zHL = new com.tencent.mm.ui.widget.a.e((Context)((b)localObject).getActivity(), 1, false);
    com.tencent.mm.ui.widget.a.e locale = ((b)localObject).zHL;
    if (locale != null) {
      locale.a((q.f)b.s.zIj);
    }
    locale = ((b)localObject).zHL;
    if (locale != null) {
      locale.a((q.g)new b.t((b)localObject));
    }
    locale = ((b)localObject).zHL;
    if (locale != null) {
      locale.a((e.a)b.u.zIk);
    }
    locale = ((b)localObject).zHL;
    if (locale != null) {
      locale.b((e.b)b.v.zIl);
    }
    localObject = ((b)localObject).zHL;
    if (localObject != null) {
      ((com.tencent.mm.ui.widget.a.e)localObject).eik();
    }
    localObject = c.zJb;
    c.a("", 0L, "", "", "", 0L, 3L, 3L);
    AppMethodBeat.o(200940);
  }
  
  public final void dLt()
  {
    AppMethodBeat.i(200935);
    super.dLt();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarClick()");
      AppMethodBeat.o(200935);
      return;
    }
    component(b.class);
    AppMethodBeat.o(200935);
  }
  
  public final void dLu()
  {
    AppMethodBeat.i(200937);
    super.dLu();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarDoubleClick()");
      AppMethodBeat.o(200937);
      return;
    }
    Object localObject1 = ((b)component(b.class)).mYU;
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    AppMethodBeat.o(200937);
  }
  
  public final String dLv()
  {
    return "1003";
  }
  
  public final int duR()
  {
    return 0;
  }
  
  public final int getCommentScene()
  {
    return 77;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(200934);
    Set localSet = ak.setOf(b.class);
    AppMethodBeat.o(200934);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(200941);
    super.onUserVisibleFocused();
    com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.d((AbsNearByFragment)this);
    AppMethodBeat.o(200941);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(200942);
    super.onUserVisibleUnFocused();
    com.tencent.mm.plugin.finder.nearby.report.e locale = com.tencent.mm.plugin.finder.nearby.report.e.zJs;
    com.tencent.mm.plugin.finder.nearby.report.e.e((AbsNearByFragment)this);
    AppMethodBeat.o(200942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonFragment
 * JD-Core Version:    0.7.0.1
 */