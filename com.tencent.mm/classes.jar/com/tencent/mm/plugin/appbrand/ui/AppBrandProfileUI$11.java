package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.protocal.protobuf.dwb;
import com.tencent.mm.protocal.protobuf.dwc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$11
  implements View.OnClickListener
{
  AppBrandProfileUI$11(AppBrandProfileUI paramAppBrandProfileUI, dwc paramdwc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48717);
    if (!this.lBT.EJP.isEmpty())
    {
      paramView = new ArrayList();
      Object localObject = this.lBT.EJP.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dwb localdwb = (dwb)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localdwb.username;
        localWxaEntryInfo.title = localdwb.title;
        localWxaEntryInfo.jfu = localdwb.desc;
        localWxaEntryInfo.iconUrl = localdwb.odo;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.lBL.getContext(), WxaBindWxaInfoUI.class);
      ((Intent)localObject).putExtra("register", this.lBT.EJO);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", paramView);
      paramView = this.lBL.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandProfileUI.a(this.lBL, 23, 1);
    }
    AppMethodBeat.o(48717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.11
 * JD-Core Version:    0.7.0.1
 */