package com.tencent.mm.plugin.appbrand.ui.collection;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.e.b;
import com.tencent.mm.plugin.appbrand.appusage.z.b;
import com.tencent.mm.plugin.appbrand.report.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionVerticalSortList$onActivityCreated$1$1", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandCollectionStorageExport$ReorderCallback;", "onInsert", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "onRemoved", "onReorderEnd", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCollectionVerticalSortList$b
  extends e.b
{
  AppBrandCollectionVerticalSortList$b(AppBrandCollectionVerticalSortList paramAppBrandCollectionVerticalSortList) {}
  
  public final void b(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(51206);
    s.u(paramLocalUsageInfo, "info");
    Object localObject = this.uik.getArguments();
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = this.uik.getArguments();
      if (localObject != null) {
        break label63;
      }
    }
    label63:
    for (localObject = null;; localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID"))
    {
      m.a(paramLocalUsageInfo, 6, i, (String)localObject);
      AppMethodBeat.o(51206);
      return;
      i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
      break;
    }
  }
  
  public final void ciC()
  {
    AppMethodBeat.i(51208);
    Log.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
    ((c)h.ax(c.class)).a(z.b.qPR);
    FragmentActivity localFragmentActivity = this.uik.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
    AppMethodBeat.o(51208);
  }
  
  public final void d(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(51207);
    s.u(paramLocalUsageInfo, "info");
    Object localObject = this.uik.getArguments();
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = this.uik.getArguments();
      if (localObject != null) {
        break label63;
      }
    }
    label63:
    for (localObject = null;; localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID"))
    {
      m.a(paramLocalUsageInfo, 7, i, (String)localObject);
      AppMethodBeat.o(51207);
      return;
      i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionVerticalSortList.b
 * JD-Core Version:    0.7.0.1
 */