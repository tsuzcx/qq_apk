package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.View;
import com.tencent.mm.plugin.appbrand.appusage.ae;
import com.tencent.mm.plugin.appbrand.appusage.ae.a;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.a;
import com.tencent.mm.plugin.appbrand.ui.c;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.MMActivity;

public final class e
  extends com.tencent.mm.plugin.appbrand.ui.a.a
  implements j.a
{
  public e(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void a(String paramString, l paraml)
  {
    paramString = com.tencent.mm.kernel.g.r(af.class);
    a.d.b.g.j(paramString, "MMKernel.service(IAppBra…ctionStorage::class.java)");
    if (((af)paramString).getCount() > 0) {
      apI().runOnUiThread((Runnable)new e.a(this));
    }
  }
  
  public final void dC(boolean paramBoolean)
  {
    Object localObject1 = apI();
    a.d.b.g.j(localObject1, "activity");
    if (((MMActivity)localObject1).isFinishing()) {}
    Object localObject2;
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      localObject1 = a.class;
      localObject2 = apI();
      a.d.b.g.j(localObject2, "activity");
    } while (((Class)localObject1).isInstance(((MMActivity)localObject2).getSupportFragmentManager().Z(16908290)));
    apI().removeAllOptionMenu();
    if (paramBoolean)
    {
      apI().czp();
      label71:
      localObject1 = apI();
      a.d.b.g.j(localObject1, "activity");
      localObject2 = ((MMActivity)localObject1).getSupportFragmentManager().bP();
      if (!paramBoolean) {
        break label178;
      }
    }
    label178:
    for (localObject1 = (AppBrandLauncherUI.a)new a();; localObject1 = (AppBrandLauncherUI.a)c.ce(apI().getString(y.j.app_brand_recents_list_collection_entrance), apI().getString(y.j.app_brand_collection_list_blank_page_tip)))
    {
      ((o)localObject2).b(16908290, (Fragment)localObject1).commitAllowingStateLoss();
      if (paramBoolean) {
        break label208;
      }
      localObject1 = (af)com.tencent.mm.kernel.g.r(af.class);
      localObject2 = (j.a)this;
      ai localai = n.DS();
      a.d.b.g.j(localai, "ThreadUtil.getWorkerThread()");
      ((af)localObject1).a((j.a)localObject2, localai.getLooper());
      return;
      localObject1 = c.class;
      break;
      apI().czo();
      break label71;
    }
    label208:
    ((af)com.tencent.mm.kernel.g.r(af.class)).d((j.a)this);
  }
  
  public final void onActivityDidResume()
  {
    apI().setMMTitle(y.j.app_brand_recents_list_collection_entrance);
  }
  
  public final void onActivityWillDestroy()
  {
    super.onActivityWillDestroy();
    ((af)com.tencent.mm.kernel.g.r(af.class)).d((j.a)this);
  }
  
  public final void v(Intent paramIntent)
  {
    View localView = apI().findViewById(16908290);
    if (localView != null) {
      localView.setBackgroundColor(-855310);
    }
    dC(true);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("extra_get_usage_reason", 7);
      int j = paramIntent.getIntExtra("extra_get_usage_prescene", 0);
      paramIntent = ae.fJQ;
      ae.a.bJ(i, j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.e
 * JD-Core Version:    0.7.0.1
 */