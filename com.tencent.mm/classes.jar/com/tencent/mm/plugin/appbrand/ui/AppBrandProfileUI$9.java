package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.protocal.protobuf.ejl;
import com.tencent.mm.protocal.protobuf.ejm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$9
  implements View.OnClickListener
{
  AppBrandProfileUI$9(AppBrandProfileUI paramAppBrandProfileUI, ejm paramejm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48715);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    if (!this.mJl.Imt.isEmpty())
    {
      paramView = new ArrayList();
      localObject = this.mJl.Imt.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ejl localejl = (ejl)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localejl.username;
        localWxaEntryInfo.title = localejl.title;
        localWxaEntryInfo.kdj = localejl.desc;
        localWxaEntryInfo.iconUrl = localejl.pqW;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.mJd.getContext(), WxaBindBizInfoUI.class);
      ((Intent)localObject).putExtra("register", this.mJl.Ims);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(paramView));
      paramView = this.mJd.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandProfileUI.a(this.mJd, 3, 1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48715);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.9
 * JD-Core Version:    0.7.0.1
 */