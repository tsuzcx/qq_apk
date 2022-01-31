package com.tencent.mm.plugin.appbrand.ui.collection;

import a.d.b.g;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.view.View;
import com.tencent.mm.plugin.appbrand.y.a;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(3)
public final class AppBrandCollectionSortUI
  extends MMActivity
{
  public static final AppBrandCollectionSortUI.a hgp = new AppBrandCollectionSortUI.a((byte)0);
  
  public final void finish()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideExitAnimation", y.a.alpha_out);
    }
    localIntent = getIntent();
    if (localIntent != null) {
      localIntent.putExtra("MMActivity.OverrideEnterAnimation", y.a.anim_not_change);
    }
    super.finish();
    overridePendingTransition(y.a.anim_not_change, y.a.alpha_out);
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected final void initActivityCloseAnimation() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    String str = null;
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getParcelableArrayListExtra("KEY_SORT_DATA_LIST"); (paramBundle == null) || (paramBundle.isEmpty()); paramBundle = null)
    {
      super.finish();
      return;
    }
    overridePendingTransition(y.a.alpha_in, y.a.anim_not_change);
    ta(-855310);
    getContentView().setBackgroundColor(czq());
    o localo = getSupportFragmentManager().bP();
    Object localObject = b.hgs;
    localObject = getIntent();
    if (localObject != null) {}
    for (int i = ((Intent)localObject).getIntExtra("KEY_OPERATE_REPORT_SCENE", 0);; i = 0)
    {
      localObject = getIntent();
      if (localObject != null) {
        str = ((Intent)localObject).getStringExtra("KEY_OPERATE_REPORT_SCENE_ID");
      }
      g.k(paramBundle, "list");
      localObject = new b();
      Bundle localBundle = new Bundle(1);
      localBundle.putParcelableArrayList("KEY_SORT_DATA_LIST", paramBundle);
      localBundle.putInt("KEY_OPERATE_REPORT_SCENE", i);
      localBundle.putString("KEY_OPERATE_REPORT_SCENE_ID", str);
      ((b)localObject).setArguments(localBundle);
      localo.b(16908290, (Fragment)localObject).commit();
      return;
    }
  }
  
  protected final void onResume()
  {
    super.onResume();
    setMMTitle(y.j.app_brand_recents_list_collection_entrance);
    czo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandCollectionSortUI
 * JD-Core Version:    0.7.0.1
 */