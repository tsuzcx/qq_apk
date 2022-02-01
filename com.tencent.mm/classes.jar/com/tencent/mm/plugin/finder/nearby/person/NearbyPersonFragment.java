package com.tencent.mm.plugin.finder.nearby.person;

import android.content.Context;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.report.b;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/person/NearbyPersonFragment;", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getPageName", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActionbarClick", "", "onActionbarDoubleClick", "onMenuClick", "onUserVisibleFocused", "onUserVisibleUnFocused", "plugin-finder_release"})
public final class NearbyPersonFragment
  extends AbsNearByFragment
{
  private HashMap _$_findViewCache;
  
  public NearbyPersonFragment()
  {
    super(2131763492, 1003);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(249258);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(249258);
  }
  
  public final String ack()
  {
    return "1003";
  }
  
  public final String afB()
  {
    return "77-1003";
  }
  
  public final int ddN()
  {
    return 0;
  }
  
  public final void dlk()
  {
    AppMethodBeat.i(249255);
    super.dlk();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onMenuClick()");
      AppMethodBeat.o(249255);
      return;
    }
    Object localObject = (NearbyPersonV1UIC)component(NearbyPersonV1UIC.class);
    ((NearbyPersonV1UIC)localObject).uSx = new e((Context)((NearbyPersonV1UIC)localObject).getActivity(), 1, false);
    e locale = ((NearbyPersonV1UIC)localObject).uSx;
    if (locale != null) {
      locale.a((o.f)NearbyPersonV1UIC.s.uSV);
    }
    locale = ((NearbyPersonV1UIC)localObject).uSx;
    if (locale != null) {
      locale.a((o.g)new NearbyPersonV1UIC.t((NearbyPersonV1UIC)localObject));
    }
    locale = ((NearbyPersonV1UIC)localObject).uSx;
    if (locale != null) {
      locale.a((e.a)NearbyPersonV1UIC.u.uSW);
    }
    locale = ((NearbyPersonV1UIC)localObject).uSx;
    if (locale != null) {
      locale.b((e.b)NearbyPersonV1UIC.v.uSX);
    }
    localObject = ((NearbyPersonV1UIC)localObject).uSx;
    if (localObject != null) {
      ((e)localObject).dGm();
    }
    localObject = b.uSZ;
    b.a("", 0L, "", "", "", 0L, 3L, 3L);
    AppMethodBeat.o(249255);
  }
  
  public final void dll()
  {
    AppMethodBeat.i(249253);
    super.dll();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarClick()");
      AppMethodBeat.o(249253);
      return;
    }
    component(NearbyPersonV1UIC.class);
    AppMethodBeat.o(249253);
  }
  
  public final void dlm()
  {
    AppMethodBeat.i(249254);
    super.dlm();
    if (getActivity() == null)
    {
      Log.w("MicroMsg.UIComponentFragment", "onActionbarDoubleClick()");
      AppMethodBeat.o(249254);
      return;
    }
    Object localObject1 = ((NearbyPersonV1UIC)component(NearbyPersonV1UIC.class)).khv;
    localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
    Object localObject2 = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/finder/nearby/person/NearbyPersonV1UIC", "onActionbarDoubleClick", "()V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    AppMethodBeat.o(249254);
  }
  
  public final int getCommentScene()
  {
    return 77;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(249252);
    Set localSet = ak.setOf(NearbyPersonV1UIC.class);
    AppMethodBeat.o(249252);
    return localSet;
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(249256);
    super.onUserVisibleFocused();
    d locald = d.uTq;
    d.b((AbsNearByFragment)this);
    AppMethodBeat.o(249256);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(249257);
    super.onUserVisibleUnFocused();
    d locald = d.uTq;
    d.c((AbsNearByFragment)this);
    AppMethodBeat.o(249257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.person.NearbyPersonFragment
 * JD-Core Version:    0.7.0.1
 */