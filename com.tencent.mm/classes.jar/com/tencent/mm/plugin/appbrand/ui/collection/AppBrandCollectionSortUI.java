package com.tencent.mm.plugin.appbrand.ui.collection;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.appbrand.au.a;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@k
@a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionSortUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "finish", "", "getLayoutId", "", "initActivityCloseAnimation", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionSortUI
  extends MMActivity
{
  public static final AppBrandCollectionSortUI.a rcv;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(51203);
    rcv = new AppBrandCollectionSortUI.a((byte)0);
    AppMethodBeat.o(51203);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(255247);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(255247);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(255245);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(255245);
    return localView1;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(51202);
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideExitAnimation", au.a.alpha_out);
    }
    localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", au.a.anim_not_change);
    }
    super.finish();
    overridePendingTransition(au.a.anim_not_change, au.a.alpha_out);
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
    overridePendingTransition(au.a.alpha_in, au.a.anim_not_change);
    setActionbarColor(getContext().getResources().getColor(au.c.normal_actionbar_color));
    getContentView().setBackgroundColor(getActionbarColor());
    i locali = getSupportFragmentManager().beginTransaction();
    Object localObject = AppBrandCollectionVerticalSortList.rcy;
    localObject = getIntent();
    if (localObject != null) {}
    for (int i = ((Intent)localObject).getIntExtra("KEY_OPERATE_REPORT_SCENE", 0);; i = 0)
    {
      localObject = getIntent();
      if (localObject != null) {
        str = ((Intent)localObject).getStringExtra("KEY_OPERATE_REPORT_SCENE_ID");
      }
      p.k(paramBundle, "list");
      localObject = new AppBrandCollectionVerticalSortList();
      Bundle localBundle = new Bundle(1);
      localBundle.putParcelableArrayList("KEY_SORT_DATA_LIST", paramBundle);
      localBundle.putInt("KEY_OPERATE_REPORT_SCENE", i);
      localBundle.putString("KEY_OPERATE_REPORT_SCENE_ID", str);
      ((AppBrandCollectionVerticalSortList)localObject).setArguments(localBundle);
      locali.b(16908290, (Fragment)localObject).in();
      AppMethodBeat.o(51200);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51201);
    super.onResume();
    setMMTitle(au.i.app_brand_recents_list_collection_entrance);
    hideActionbarLine();
    AppMethodBeat.o(51201);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI
 * JD-Core Version:    0.7.0.1
 */