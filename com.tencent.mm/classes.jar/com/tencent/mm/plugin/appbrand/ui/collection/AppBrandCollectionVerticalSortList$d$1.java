package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import com.tencent.mm.plugin.appbrand.appusage.z.b;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$onActivityCreated$1$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionVerticalSortList$d$1
  extends f.b
{
  public final void awT()
  {
    AppMethodBeat.i(135044);
    ab.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
    ((c)g.E(c.class)).a(z.b.hcB);
    FragmentActivity localFragmentActivity = this.iRJ.iRI.getActivity();
    if (localFragmentActivity != null)
    {
      localFragmentActivity.finish();
      AppMethodBeat.o(135044);
      return;
    }
    AppMethodBeat.o(135044);
  }
  
  public final void b(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(135042);
    j.q(paramLocalUsageInfo, "info");
    Object localObject = this.iRJ.iRI.getArguments();
    int i;
    if (localObject != null)
    {
      i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
      localObject = this.iRJ.iRI.getArguments();
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
    {
      h.a(paramLocalUsageInfo, 6, i, (String)localObject);
      AppMethodBeat.o(135042);
      return;
      i = 0;
      break;
    }
  }
  
  public final void d(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(135043);
    j.q(paramLocalUsageInfo, "info");
    Object localObject = this.iRJ.iRI.getArguments();
    int i;
    if (localObject != null)
    {
      i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
      localObject = this.iRJ.iRI.getArguments();
      if (localObject == null) {
        break label74;
      }
    }
    label74:
    for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
    {
      h.a(paramLocalUsageInfo, 7, i, (String)localObject);
      AppMethodBeat.o(135043);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList.d.1
 * JD-Core Version:    0.7.0.1
 */