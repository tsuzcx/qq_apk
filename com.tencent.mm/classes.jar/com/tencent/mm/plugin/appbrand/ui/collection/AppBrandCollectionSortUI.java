package com.tencent.mm.plugin.appbrand.ui.collection;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@i
@a(3)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getLayoutId", "", "initActivityCloseAnimation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionSortUI
  extends MMActivity
{
  public static final a mIA;
  
  static
  {
    AppMethodBeat.i(51203);
    mIA = new a((byte)0);
    AppMethodBeat.o(51203);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(51202);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130771982);
    }
    localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
    }
    super.finish();
    overridePendingTransition(2130771986, 2130771982);
    AppMethodBeat.o(51202);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void initActivityCloseAnimation() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    String str = null;
    AppMethodBeat.i(51200);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getParcelableArrayListExtra("KEY_SORT_DATA_LIST"); (paramBundle == null) || (paramBundle.isEmpty()); paramBundle = null)
    {
      super.finish();
      AppMethodBeat.o(51200);
      return;
    }
    overridePendingTransition(2130771981, 2130771986);
    setActionbarColor(getContext().getResources().getColor(2131100705));
    getContentView().setBackgroundColor(getActionbarColor());
    k localk = getSupportFragmentManager().beginTransaction();
    Object localObject = AppBrandCollectionVerticalSortList.mIE;
    localObject = getIntent();
    if (localObject != null) {}
    for (int i = ((Intent)localObject).getIntExtra("KEY_OPERATE_REPORT_SCENE", 0);; i = 0)
    {
      localObject = getIntent();
      if (localObject != null) {
        str = ((Intent)localObject).getStringExtra("KEY_OPERATE_REPORT_SCENE_ID");
      }
      p.h(paramBundle, "list");
      localObject = new AppBrandCollectionVerticalSortList();
      Bundle localBundle = new Bundle(1);
      localBundle.putParcelableArrayList("KEY_SORT_DATA_LIST", paramBundle);
      localBundle.putInt("KEY_OPERATE_REPORT_SCENE", i);
      localBundle.putString("KEY_OPERATE_REPORT_SCENE_ID", str);
      ((AppBrandCollectionVerticalSortList)localObject).setArguments(localBundle);
      localk.b(16908290, (Fragment)localObject).commit();
      AppMethodBeat.o(51200);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51201);
    super.onResume();
    setMMTitle(2131755614);
    hideActionbarLine();
    AppMethodBeat.o(51201);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI$Companion;", "", "()V", "KEY_OPERATE_REPORT_SCENE", "", "KEY_OPERATE_REPORT_SCENE_ID", "KEY_SORT_DATA_LIST", "startSortList", "", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "operateReportScene", "", "operateReportSceneId", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI
 * JD-Core Version:    0.7.0.1
 */