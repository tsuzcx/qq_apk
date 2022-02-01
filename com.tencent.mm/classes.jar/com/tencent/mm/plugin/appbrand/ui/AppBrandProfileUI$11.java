package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.protocal.protobuf.ejn;
import com.tencent.mm.protocal.protobuf.ejo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$11
  implements View.OnClickListener
{
  AppBrandProfileUI$11(AppBrandProfileUI paramAppBrandProfileUI, ejo paramejo) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48717);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if (!this.mJn.Imv.isEmpty())
    {
      paramView = new ArrayList();
      localObject = this.mJn.Imv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ejn localejn = (ejn)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localejn.username;
        localWxaEntryInfo.title = localejn.title;
        localWxaEntryInfo.kdj = localejn.desc;
        localWxaEntryInfo.iconUrl = localejn.pqW;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.mJd.getContext(), WxaBindWxaInfoUI.class);
      ((Intent)localObject).putExtra("register", this.mJn.Imu);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", paramView);
      paramView = this.mJd.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandProfileUI.a(this.mJd, 23, 1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.11
 * JD-Core Version:    0.7.0.1
 */