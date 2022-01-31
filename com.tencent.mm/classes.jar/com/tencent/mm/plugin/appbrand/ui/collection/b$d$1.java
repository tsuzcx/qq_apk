package com.tencent.mm.plugin.appbrand.ui.collection;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.c;
import com.tencent.mm.plugin.appbrand.appusage.f.b;
import com.tencent.mm.plugin.appbrand.appusage.z.b;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.sdk.platformtools.y;

public final class b$d$1
  extends f.b
{
  public final void acN()
  {
    y.i("MicroMsg.AppBrandCollectionVerticalSortList", "[collection]reorder callback entered");
    ((c)com.tencent.mm.kernel.g.r(c.class)).a(z.b.fJI);
    FragmentActivity localFragmentActivity = this.hgu.hgt.getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.finish();
    }
  }
  
  public final void b(LocalUsageInfo paramLocalUsageInfo)
  {
    a.d.b.g.k(paramLocalUsageInfo, "info");
    Object localObject = this.hgu.hgt.getArguments();
    int i;
    if (localObject != null)
    {
      i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
      localObject = this.hgu.hgt.getArguments();
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
    {
      e.a(paramLocalUsageInfo, 6, i, (String)localObject);
      return;
      i = 0;
      break;
    }
  }
  
  public final void d(LocalUsageInfo paramLocalUsageInfo)
  {
    a.d.b.g.k(paramLocalUsageInfo, "info");
    Object localObject = this.hgu.hgt.getArguments();
    int i;
    if (localObject != null)
    {
      i = ((Bundle)localObject).getInt("KEY_OPERATE_REPORT_SCENE");
      localObject = this.hgu.hgt.getArguments();
      if (localObject == null) {
        break label64;
      }
    }
    label64:
    for (localObject = ((Bundle)localObject).getString("KEY_OPERATE_REPORT_SCENE_ID");; localObject = null)
    {
      e.a(paramLocalUsageInfo, 7, i, (String)localObject);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b.d.1
 * JD-Core Version:    0.7.0.1
 */