package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.ae;
import com.tencent.mm.plugin.appbrand.appusage.ae.a;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherBlankPage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionFolderActivityContext;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "TAG", "", "onActivityDidCreate", "", "intent", "Landroid/content/Intent;", "onActivityDidResume", "onActivityWillDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "showListPage", "showList", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  private static final void a(CollectionFolderActivityContext paramCollectionFolderActivityContext)
  {
    AppMethodBeat.i(322673);
    s.u(paramCollectionFolderActivityContext, "this$0");
    paramCollectionFolderActivityContext.kT(true);
    AppMethodBeat.o(322673);
  }
  
  public final void T(Intent paramIntent)
  {
    AppMethodBeat.i(51260);
    View localView = ((MMActivity)getBaseContext()).findViewById(16908290);
    if (localView != null) {
      localView.setBackgroundColor(-855310);
    }
    kT(true);
    if (paramIntent != null)
    {
      int i = paramIntent.getIntExtra("extra_get_usage_reason", 7);
      int j = paramIntent.getIntExtra("extra_get_usage_prescene", 0);
      paramIntent = ae.qPW;
      ae.a.a(i, j, null, 4);
    }
    AppMethodBeat.o(51260);
  }
  
  public final void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(51259);
    if (((MMActivity)getBaseContext()).isFinishing())
    {
      AppMethodBeat.o(51259);
      return;
    }
    if (paramBoolean) {}
    for (Object localObject1 = AppBrandCollectionDisplayVerticalList.class; ((Class)localObject1).isInstance(((MMActivity)getBaseContext()).getSupportFragmentManager().findFragmentById(16908290)); localObject1 = AppBrandLauncherBlankPage.class)
    {
      AppMethodBeat.o(51259);
      return;
    }
    ((MMActivity)getBaseContext()).removeAllOptionMenu();
    Object localObject2;
    label119:
    int i;
    if (paramBoolean)
    {
      ((MMActivity)getBaseContext()).showActionbarLine();
      localObject2 = ((MMActivity)getBaseContext()).getSupportFragmentManager().beginTransaction();
      if (!paramBoolean) {
        break label319;
      }
      localObject1 = (AppBrandLauncherUI.Fragment)new AppBrandCollectionDisplayVerticalList();
      ((r)localObject2).b(16908290, (Fragment)localObject1).FX();
      localObject2 = (af)h.ax(af.class);
      localObject1 = (MMActivity)getBaseContext();
      if (localObject1 != null) {
        break label355;
      }
      localObject1 = "";
      label159:
      Object localObject3 = (MMActivity)getBaseContext();
      if (localObject3 != null)
      {
        localObject3 = ((MMActivity)localObject3).getIntent();
        if (localObject3 != null)
        {
          i = ((Intent)localObject3).getIntExtra("extra_enter_scene", -1);
          Log.i(this.TAG, s.X("EnterScene = ", Integer.valueOf(i)));
        }
      }
      switch (i)
      {
      case 2: 
      default: 
        label240:
        if (!paramBoolean) {
          ((af)localObject2).add(s.X(this.TAG, ".WORKER"), (MStorage.IOnStorageChange)this);
        }
        break;
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        localObject1 = i.tWq;
        i.a.cJV().a(LuggageServiceType.euv, ab.tTL);
        localObject1 = i.tWq;
        i.a.cJV().a(LuggageServiceType.euw, ab.tTL);
      }
      AppMethodBeat.o(51259);
      return;
      ((MMActivity)getBaseContext()).hideActionbarLine();
      break;
      label319:
      localObject1 = (AppBrandLauncherUI.Fragment)AppBrandLauncherBlankPage.fo(((MMActivity)getBaseContext()).getString(ba.i.app_brand_recents_list_collection_entrance), ((MMActivity)getBaseContext()).getString(ba.i.app_brand_collection_list_blank_page_tip));
      break label119;
      label355:
      localObject1 = ((MMActivity)localObject1).getIntent();
      if (localObject1 == null)
      {
        localObject1 = "";
        break label159;
      }
      localObject1 = ((Intent)localObject1).getStringExtra("extra_enter_scene_note");
      if (localObject1 == null)
      {
        localObject1 = "";
        break label159;
      }
      break label159;
      j.aG(i, (String)localObject1);
      break label240;
      ((af)localObject2).remove((MStorage.IOnStorageChange)this);
    }
  }
  
  public final void onActivityDidResume()
  {
    AppMethodBeat.i(51261);
    ((MMActivity)getBaseContext()).setMMTitle(ba.i.app_brand_recents_list_collection_entrance);
    AppMethodBeat.o(51261);
  }
  
  public final void onActivityWillDestroy()
  {
    AppMethodBeat.i(51262);
    super.onActivityWillDestroy();
    ((af)h.ax(af.class)).remove((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(51262);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(51258);
    if (((af)h.ax(af.class)).getCount() > 0) {
      ((MMActivity)getBaseContext()).runOnUiThread(new CollectionFolderActivityContext..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(51258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext
 * JD-Core Version:    0.7.0.1
 */