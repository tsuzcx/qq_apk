package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;

public class AppBrandRecommendCategoryListUI
  extends DrawStatusBarActivity
{
  private c hkb;
  mm hko = new mm();
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    Intent localIntent = new Intent(paramContext, AppBrandRecommendCategoryListUI.class);
    localIntent.putExtra("category_id", paramInt);
    localIntent.putExtra("category_name", paramString);
    localIntent.putExtra("KEY_FROM_SCENE", 0);
    paramContext.startActivity(localIntent);
  }
  
  protected final int getLayoutId()
  {
    return y.h.app_brand_recommend_category_list_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.hko.sJi = getIntent().getIntExtra("category_id", -1);
    this.hko.sJp = getIntent().getStringExtra("category_name");
    y.i("MicroMsg.AppBrandRecommendCategoryListUI", "onCreate cate_id:%s, cate_name:%s", new Object[] { Integer.valueOf(this.hko.sJi), this.hko.sJp });
    if ((this.hko.sJi == -1) || (TextUtils.isEmpty(this.hko.sJp)))
    {
      y.e("MicroMsg.AppBrandRecommendCategoryListUI", "cate_id or cate_name is illegal");
      finish();
      return;
    }
    this.mController.contentView.setBackgroundColor(-855310);
    ta(-855310);
    setTitleBarDoubleClickListener(new Runnable()
    {
      public final void run()
      {
        if ((!AppBrandRecommendCategoryListUI.this.uMr) && (AppBrandRecommendCategoryListUI.this.isFinishing())) {}
      }
    });
    setMMTitle(getResources().getString(y.j.app_brand_recommend_list_header_text_all_use));
    oX(-16777216);
    setBackBtn(new AppBrandRecommendCategoryListUI.3(this), y.i.actionbar_icon_dark_back);
    if (this.hkb == null) {
      this.hkb = new AppBrandRecommendCategoryListUI.1(this, this);
    }
    y.i("MicroMsg.AppBrandRecommendUILogic", "onCreate");
    this.hkb.initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.hkb.onDestroyView();
    y.i("MicroMsg.AppBrandRecommendUILogic", "onDestroy");
    y.i("MicroMsg.AppBrandRecommendCategoryListUI", "onDestroy");
  }
  
  protected void onResume()
  {
    super.onResume();
    y.i("MicroMsg.AppBrandRecommendCategoryListUI", "onResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.AppBrandRecommendCategoryListUI
 * JD-Core Version:    0.7.0.1
 */