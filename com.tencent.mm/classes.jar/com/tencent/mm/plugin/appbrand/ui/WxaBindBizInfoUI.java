package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaBindBizInfoUI
  extends DrawStatusBarActivity
{
  private ThreeDotsLoadingView haZ;
  private String heF;
  WxaBindBizInfoUI.a heG;
  private LoadMoreRecyclerView heH;
  private View heI;
  private String mAppId;
  
  protected final int getLayoutId()
  {
    return y.h.wxa_bind_biz_info_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setBackBtn(new WxaBindBizInfoUI.1(this), y.i.actionbar_icon_dark_back);
    setMMTitle(y.j.app_brand_profile_biz_brand_belong_title);
    oX(-16777216);
    ta(-855310);
    paramBundle = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
    this.mAppId = getIntent().getStringExtra("app_id");
    this.heH = ((LoadMoreRecyclerView)findViewById(y.g.dataLv));
    this.heG = new WxaBindBizInfoUI.a(getLayoutInflater());
    this.heH.setOnItemClickListener(new MRecyclerView.a()
    {
      public final void B(View paramAnonymousView, int paramAnonymousInt)
      {
        paramAnonymousView = WxaBindBizInfoUI.this.heG.mp(paramAnonymousInt);
        if (paramAnonymousView == null) {
          return;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("Contact_User", paramAnonymousView.username);
        localIntent.putExtra("key_start_biz_profile_from_app_brand_profile", true);
        localIntent.putExtra("force_get_contact", true);
        d.b(WxaBindBizInfoUI.this, "profile", ".ui.ContactInfoUI", localIntent);
      }
    });
    this.heG.aA(paramBundle);
    this.heH.setItemAnimator(null);
    this.heH.setOnLoadingStateChangedListener(new WxaBindBizInfoUI.3(this));
    this.heH.setAdapter(this.heG);
    paramBundle = getLayoutInflater().inflate(y.h.wxa_bind_biz_ui_loading_footer, this.heH, false);
    this.haZ = ((ThreeDotsLoadingView)paramBundle.findViewById(y.g.loading_view));
    this.haZ.cKb();
    this.heH.setLoadingView(paramBundle);
    this.heI = getLayoutInflater().inflate(y.h.wxa_bind_biz_ui_no_more_footer, this.heH, false);
    this.heH.addFooterView(this.heI);
    this.heI.setVisibility(8);
    if (this.heG.getItemCount() > 20)
    {
      this.heH.dZ(true);
      this.heG.heM = false;
    }
    this.mController.contentView.setBackgroundColor(-855310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI
 * JD-Core Version:    0.7.0.1
 */