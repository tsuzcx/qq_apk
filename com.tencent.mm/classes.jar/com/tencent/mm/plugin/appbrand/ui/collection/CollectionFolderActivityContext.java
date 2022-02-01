package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.af.a;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionFolderActivityContext;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "onActivityDidCreate", "", "intent", "Landroid/content/Intent;", "onActivityDidResume", "onActivityWillDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showListPage", "showList", "", "plugin-appbrand-integration_release"})
public final class CollectionFolderActivityContext
  extends FolderActivityContextWithLifecycle
  implements MStorage.IOnStorageChange
{
  private final String TAG;
  
  public CollectionFolderActivityContext(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(51263);
    this.TAG = "CollectionFolderActivityContext";
    AppMethodBeat.o(51263);
  }
  
  public final void S(Intent paramIntent)
  {
    AppMethodBeat.i(51260);
    View localView = getActivity().findViewById(16908290);
    if (localView != null) {
      localView.setBackgroundColor(-855310);
    }
    iI(true);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("extra_get_usage_reason", 7);
      int j = paramIntent.getIntExtra("extra_get_usage_prescene", 0);
      paramIntent = af.kVR;
      af.a.a(i, j, null, 4);
      AppMethodBeat.o(51260);
      return;
    }
    AppMethodBeat.o(51260);
  }
  
  public final void iI(boolean paramBoolean)
  {
    AppMethodBeat.i(51259);
    Object localObject1 = getActivity();
    kotlin.g.b.p.g(localObject1, "activity");
    if (((MMActivity)localObject1).isFinishing())
    {
      AppMethodBeat.o(51259);
      return;
    }
    if (paramBoolean) {}
    Object localObject2;
    for (localObject1 = AppBrandCollectionDisplayVerticalList.class;; localObject1 = AppBrandLauncherBlankPage.class)
    {
      localObject2 = getActivity();
      kotlin.g.b.p.g(localObject2, "activity");
      if (!((Class)localObject1).isInstance(((MMActivity)localObject2).getSupportFragmentManager().findFragmentById(16908290))) {
        break;
      }
      AppMethodBeat.o(51259);
      return;
    }
    getActivity().removeAllOptionMenu();
    label131:
    ag localag;
    label193:
    int i;
    if (paramBoolean)
    {
      getActivity().showActionbarLine();
      localObject1 = getActivity();
      kotlin.g.b.p.g(localObject1, "activity");
      localObject2 = ((MMActivity)localObject1).getSupportFragmentManager().beginTransaction();
      if (!paramBoolean) {
        break label357;
      }
      localObject1 = (AppBrandLauncherUI.Fragment)new AppBrandCollectionDisplayVerticalList();
      ((k)localObject2).b(16908290, (Fragment)localObject1).commitAllowingStateLoss();
      localag = (ag)com.tencent.mm.kernel.g.af(ag.class);
      localObject1 = getActivity();
      if (localObject1 != null)
      {
        localObject1 = ((MMActivity)localObject1).getIntent();
        if (localObject1 != null)
        {
          localObject2 = ((Intent)localObject1).getStringExtra("extra_enter_scene_note");
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label193;
          }
        }
      }
      localObject1 = "";
      localObject2 = getActivity();
      if (localObject2 != null)
      {
        localObject2 = ((MMActivity)localObject2).getIntent();
        if (localObject2 != null)
        {
          i = ((Intent)localObject2).getIntExtra("extra_enter_scene", -1);
          Log.i(this.TAG, "EnterScene = ".concat(String.valueOf(i)));
        }
      }
      switch (i)
      {
      case 2: 
      default: 
        label272:
        if (!paramBoolean) {
          localag.add(this.TAG + ".WORKER", (MStorage.IOnStorageChange)this);
        }
        break;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPD, z.nMC);
        h.bWb().a(com.tencent.mm.plugin.appbrand.task.g.nPE, z.nMC);
      }
      AppMethodBeat.o(51259);
      return;
      getActivity().hideActionbarLine();
      break;
      label357:
      localObject1 = (AppBrandLauncherUI.Fragment)AppBrandLauncherBlankPage.eJ(getActivity().getString(2131755661), getActivity().getString(2131755399));
      break label131;
      i.as(i, (String)localObject1);
      break label272;
      localag.remove((MStorage.IOnStorageChange)this);
    }
  }
  
  public final void onActivityDidResume()
  {
    AppMethodBeat.i(51261);
    getActivity().setMMTitle(2131755661);
    AppMethodBeat.o(51261);
  }
  
  public final void onActivityWillDestroy()
  {
    AppMethodBeat.i(51262);
    super.onActivityWillDestroy();
    ((ag)com.tencent.mm.kernel.g.af(ag.class)).remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(51262);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(51258);
    paramString = com.tencent.mm.kernel.g.af(ag.class);
    kotlin.g.b.p.g(paramString, "MMKernel.service(IAppBra…ctionStorage::class.java)");
    if (((ag)paramString).getCount() > 0) {
      getActivity().runOnUiThread((Runnable)new a(this));
    }
    AppMethodBeat.o(51258);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(CollectionFolderActivityContext paramCollectionFolderActivityContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(51257);
      this.oaY.iI(true);
      AppMethodBeat.o(51257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */