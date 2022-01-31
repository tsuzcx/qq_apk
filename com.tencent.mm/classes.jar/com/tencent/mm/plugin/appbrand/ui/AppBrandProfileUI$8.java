package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.protocal.protobuf.dba;
import com.tencent.mm.protocal.protobuf.dbb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$8
  implements View.OnClickListener
{
  AppBrandProfileUI$8(AppBrandProfileUI paramAppBrandProfileUI, dbb paramdbb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(143597);
    if (!this.iOo.yhi.isEmpty())
    {
      paramView = new ArrayList();
      Object localObject = this.iOo.yhi.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dba localdba = (dba)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localdba.username;
        localWxaEntryInfo.title = localdba.title;
        localWxaEntryInfo.hkc = localdba.desc;
        localWxaEntryInfo.iconUrl = localdba.kWy;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.iOj.getContext(), WxaBindBizInfoUI.class);
      ((Intent)localObject).putExtra("register", this.iOo.yhh);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(paramView));
      this.iOj.getContext().startActivity((Intent)localObject);
      AppBrandProfileUI.a(this.iOj, 3, 1);
    }
    AppMethodBeat.o(143597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.8
 * JD-Core Version:    0.7.0.1
 */