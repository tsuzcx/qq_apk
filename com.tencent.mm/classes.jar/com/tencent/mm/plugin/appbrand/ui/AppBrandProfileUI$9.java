package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.protocal.protobuf.dwa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$9
  implements View.OnClickListener
{
  AppBrandProfileUI$9(AppBrandProfileUI paramAppBrandProfileUI, dwa paramdwa) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48715);
    if (!this.lBR.EJN.isEmpty())
    {
      paramView = new ArrayList();
      Object localObject = this.lBR.EJN.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dvz localdvz = (dvz)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localdvz.username;
        localWxaEntryInfo.title = localdvz.title;
        localWxaEntryInfo.jfu = localdvz.desc;
        localWxaEntryInfo.iconUrl = localdvz.odo;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.lBL.getContext(), WxaBindBizInfoUI.class);
      ((Intent)localObject).putExtra("register", this.lBR.EJM);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(paramView));
      paramView = this.lBL.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandProfileUI.a(this.lBL, 3, 1);
    }
    AppMethodBeat.o(48715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.9
 * JD-Core Version:    0.7.0.1
 */