package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.appbrand.ba.a;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@k
@a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getLayoutId", "", "initActivityCloseAnimation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandCollectionSortUI
  extends MMActivity
{
  public static final AppBrandCollectionSortUI.a uig;
  
  static
  {
    AppMethodBeat.i(51203);
    uig = new AppBrandCollectionSortUI.a((byte)0);
    AppMethodBeat.o(51203);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(51202);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideExitAnimation", ba.a.alpha_out);
    }
    localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", ba.a.anim_not_change);
    }
    super.finish();
    overridePendingTransition(ba.a.anim_not_change, ba.a.alpha_out);
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
    if (paramBundle == null) {}
    for (paramBundle = null; (paramBundle == null) || (paramBundle.isEmpty()); paramBundle = paramBundle.getParcelableArrayListExtra("KEY_SORT_DATA_LIST"))
    {
      super.finish();
      AppMethodBeat.o(51200);
      return;
    }
    overridePendingTransition(ba.a.alpha_in, ba.a.anim_not_change);
    setActionbarColor(getContext().getResources().getColor(ba.c.normal_actionbar_color));
    getContentView().setBackgroundColor(getActionbarColor());
    r localr = getSupportFragmentManager().beginTransaction();
    Object localObject = AppBrandCollectionVerticalSortList.uih;
    localObject = getIntent();
    int i;
    if (localObject == null)
    {
      i = 0;
      localObject = getIntent();
      if (localObject != null) {
        break label224;
      }
    }
    for (;;)
    {
      s.u(paramBundle, "list");
      localObject = new AppBrandCollectionVerticalSortList();
      Bundle localBundle = new Bundle(1);
      localBundle.putParcelableArrayList("KEY_SORT_DATA_LIST", paramBundle);
      localBundle.putInt("KEY_OPERATE_REPORT_SCENE", i);
      localBundle.putString("KEY_OPERATE_REPORT_SCENE_ID", str);
      paramBundle = ah.aiuX;
      ((AppBrandCollectionVerticalSortList)localObject).setArguments(localBundle);
      localr.b(16908290, (Fragment)localObject).FW();
      AppMethodBeat.o(51200);
      return;
      i = ((Intent)localObject).getIntExtra("KEY_OPERATE_REPORT_SCENE", 0);
      break;
      label224:
      str = ((Intent)localObject).getStringExtra("KEY_OPERATE_REPORT_SCENE_ID");
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51201);
    super.onResume();
    setMMTitle(ba.i.app_brand_recents_list_collection_entrance);
    hideActionbarLine();
    AppMethodBeat.o(51201);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI
 * JD-Core Version:    0.7.0.1
 */