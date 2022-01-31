package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.ae;
import com.tencent.mm.plugin.appbrand.appusage.ae.a;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionFolderActivityContext;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "onActivityDidCreate", "", "intent", "Landroid/content/Intent;", "onActivityDidResume", "onActivityWillDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showListPage", "showList", "", "plugin-appbrand-integration_release"})
public final class CollectionFolderActivityContext
  extends FolderActivityContextWithLifecycle
  implements k.a
{
  private final String TAG;
  
  public CollectionFolderActivityContext(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(135099);
    this.TAG = "CollectionFolderActivityContext";
    AppMethodBeat.o(135099);
  }
  
  public final void N(Intent paramIntent)
  {
    AppMethodBeat.i(135096);
    View localView = aNc().findViewById(16908290);
    if (localView != null) {
      localView.setBackgroundColor(-855310);
    }
    eP(true);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("extra_get_usage_reason", 7);
      int j = paramIntent.getIntExtra("extra_get_usage_prescene", 0);
      paramIntent = ae.hcG;
      ae.a.cU(i, j);
      AppMethodBeat.o(135096);
      return;
    }
    AppMethodBeat.o(135096);
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(135094);
    paramString = com.tencent.mm.kernel.g.E(af.class);
    j.p(paramString, "MMKernel.service(IAppBra…ctionStorage::class.java)");
    if (((af)paramString).getCount() > 0) {
      aNc().runOnUiThread((Runnable)new CollectionFolderActivityContext.a(this));
    }
    AppMethodBeat.o(135094);
  }
  
  public final void eP(boolean paramBoolean)
  {
    AppMethodBeat.i(135095);
    Object localObject1 = aNc();
    j.p(localObject1, "activity");
    if (((MMActivity)localObject1).isFinishing())
    {
      AppMethodBeat.o(135095);
      return;
    }
    if (paramBoolean) {}
    Object localObject2;
    for (localObject1 = AppBrandCollectionDisplayVerticalList.class;; localObject1 = AppBrandLauncherBlankPage.class)
    {
      localObject2 = aNc();
      j.p(localObject2, "activity");
      if (!((Class)localObject1).isInstance(((MMActivity)localObject2).getSupportFragmentManager().findFragmentById(16908290))) {
        break;
      }
      AppMethodBeat.o(135095);
      return;
    }
    aNc().removeAllOptionMenu();
    label131:
    int i;
    if (paramBoolean)
    {
      aNc().showActionbarLine();
      localObject1 = aNc();
      j.p(localObject1, "activity");
      localObject2 = ((MMActivity)localObject1).getSupportFragmentManager().beginTransaction();
      if (!paramBoolean) {
        break label303;
      }
      localObject1 = (AppBrandLauncherUI.Fragment)new AppBrandCollectionDisplayVerticalList();
      ((k)localObject2).b(16908290, (Fragment)localObject1).commitAllowingStateLoss();
      localObject1 = (af)com.tencent.mm.kernel.g.E(af.class);
      localObject2 = aNc();
      if (localObject2 != null)
      {
        localObject2 = ((MMActivity)localObject2).getIntent();
        if (localObject2 != null)
        {
          i = ((Intent)localObject2).getIntExtra("extra_enter_scene", -1);
          ab.i(this.TAG, "EnterScene = ".concat(String.valueOf(i)));
        }
      }
      switch (i)
      {
      case 2: 
      default: 
        label236:
        if (!paramBoolean)
        {
          localObject2 = (k.a)this;
          al localal = com.tencent.mm.plugin.appbrand.s.m.aNS();
          j.p(localal, "ThreadUtil.getWorkerThread()");
          ((af)localObject1).add((k.a)localObject2, localal.getLooper());
        }
        break;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        h.b(com.tencent.mm.plugin.appbrand.task.g.iKS);
        h.b(com.tencent.mm.plugin.appbrand.task.g.iKT);
      }
      AppMethodBeat.o(135095);
      return;
      aNc().hideActionbarLine();
      break;
      label303:
      localObject1 = (AppBrandLauncherUI.Fragment)AppBrandLauncherBlankPage.cT(aNc().getString(2131296817), aNc().getString(2131296597));
      break label131;
      e.ps(i);
      break label236;
      ((af)localObject1).remove((k.a)this);
    }
  }
  
  public final void onActivityDidResume()
  {
    AppMethodBeat.i(135097);
    aNc().setMMTitle(2131296817);
    AppMethodBeat.o(135097);
  }
  
  public final void onActivityWillDestroy()
  {
    AppMethodBeat.i(135098);
    super.onActivityWillDestroy();
    ((af)com.tencent.mm.kernel.g.E(af.class)).remove((k.a)this);
    AppMethodBeat.o(135098);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */