package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.List;

final class AppBrandProfileUI$a
  extends RecyclerView.v
  implements View.OnClickListener
{
  WxaBindBizInfoView hdK;
  String mAppId;
  
  AppBrandProfileUI$a(AppBrandProfileUI paramAppBrandProfileUI, View paramView)
  {
    super(paramView);
    this.hdK = ((WxaBindBizInfoView)paramView.findViewById(y.g.profile_bind_biz_info_item));
    paramView.setOnClickListener(this);
  }
  
  public final void onClick(View paramView)
  {
    paramView = this.hdK.getWxaEntryInfoList();
    if ((paramView == null) || (paramView.isEmpty()))
    {
      y.i("MicroMsg.AppBrandProfileUI", "deal onBindBizInfo click failed, bindBizInfoList is null or nil.");
      return;
    }
    if (paramView.size() == 1)
    {
      paramView = (WxaAttributes.WxaEntryInfo)paramView.get(0);
      d.b(this.aie.getContext(), "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramView.username).putExtra("key_start_biz_profile_from_app_brand_profile", true).putExtra("force_get_contact", true));
      AppBrandProfileUI.a(this.hdE, 3, 1);
      return;
    }
    Intent localIntent = new Intent(this.hdE.mController.uMN, WxaBindBizInfoUI.class);
    localIntent.putExtra("app_id", this.mAppId);
    localIntent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(paramView));
    this.hdE.mController.uMN.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.a
 * JD-Core Version:    0.7.0.1
 */