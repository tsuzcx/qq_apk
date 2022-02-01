package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.appusage.ag.a;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.plugin.appbrand.task.preload.d.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionFolderActivityContext;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "onActivityDidCreate", "", "intent", "Landroid/content/Intent;", "onActivityDidResume", "onActivityWillDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showListPage", "showList", "", "plugin-appbrand-integration_release"})
public final class CollectionFolderActivityContext
  extends FolderActivityContextWithLifecycle
  implements k.a
{
  private final String TAG;
  
  public CollectionFolderActivityContext(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(51263);
    this.TAG = "CollectionFolderActivityContext";
    AppMethodBeat.o(51263);
  }
  
  public final void R(Intent paramIntent)
  {
    AppMethodBeat.i(51260);
    View localView = getActivity().findViewById(16908290);
    if (localView != null) {
      localView.setBackgroundColor(-855310);
    }
    ha(true);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("extra_get_usage_reason", 7);
      int j = paramIntent.getIntExtra("extra_get_usage_prescene", 0);
      paramIntent = ag.iVH;
      ag.a.a(i, j, null, 4);
      AppMethodBeat.o(51260);
      return;
    }
    AppMethodBeat.o(51260);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(51258);
    paramString = com.tencent.mm.kernel.g.ab(ah.class);
    d.g.b.k.g(paramString, "MMKernel.service(IAppBra…ctionStorage::class.java)");
    if (((ah)paramString).getCount() > 0) {
      getActivity().runOnUiThread((Runnable)new a(this));
    }
    AppMethodBeat.o(51258);
  }
  
  public final void ha(boolean paramBoolean)
  {
    AppMethodBeat.i(51259);
    Object localObject1 = getActivity();
    d.g.b.k.g(localObject1, "activity");
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
      d.g.b.k.g(localObject2, "activity");
      if (!((Class)localObject1).isInstance(((MMActivity)localObject2).getSupportFragmentManager().findFragmentById(16908290))) {
        break;
      }
      AppMethodBeat.o(51259);
      return;
    }
    getActivity().removeAllOptionMenu();
    label131:
    ah localah;
    label193:
    int i;
    if (paramBoolean)
    {
      getActivity().showActionbarLine();
      localObject1 = getActivity();
      d.g.b.k.g(localObject1, "activity");
      localObject2 = ((MMActivity)localObject1).getSupportFragmentManager().beginTransaction();
      if (!paramBoolean) {
        break label347;
      }
      localObject1 = (AppBrandLauncherUI.Fragment)new AppBrandCollectionDisplayVerticalList();
      ((android.support.v4.app.k)localObject2).b(16908290, (Fragment)localObject1).commitAllowingStateLoss();
      localah = (ah)com.tencent.mm.kernel.g.ab(ah.class);
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
          ad.i(this.TAG, "EnterScene = ".concat(String.valueOf(i)));
        }
      }
      switch (i)
      {
      case 2: 
      default: 
        label272:
        if (!paramBoolean) {
          localah.add(this.TAG + ".WORKER", (k.a)this);
        }
        break;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        f.a(e.lwx, d.a.lxt);
        f.a(e.lwy, d.a.lxt);
      }
      AppMethodBeat.o(51259);
      return;
      getActivity().hideActionbarLine();
      break;
      label347:
      localObject1 = (AppBrandLauncherUI.Fragment)AppBrandLauncherBlankPage.dT(getActivity().getString(2131755614), getActivity().getString(2131755362));
      break label131;
      h.an(i, (String)localObject1);
      break label272;
      localah.remove((k.a)this);
    }
  }
  
  public final void onActivityDidResume()
  {
    AppMethodBeat.i(51261);
    getActivity().setMMTitle(2131755614);
    AppMethodBeat.o(51261);
  }
  
  public final void onActivityWillDestroy()
  {
    AppMethodBeat.i(51262);
    super.onActivityWillDestroy();
    ((ah)com.tencent.mm.kernel.g.ab(ah.class)).remove((k.a)this);
    AppMethodBeat.o(51262);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(CollectionFolderActivityContext paramCollectionFolderActivityContext) {}
    
    public final void run()
    {
      AppMethodBeat.i(51257);
      this.lGz.ha(true);
      AppMethodBeat.o(51257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */