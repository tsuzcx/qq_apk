package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.protocal.protobuf.gmf;
import com.tencent.mm.protocal.protobuf.gmg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$13
  implements View.OnClickListener
{
  AppBrandProfileUI$13(AppBrandProfileUI paramAppBrandProfileUI, gmg paramgmg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(322572);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (!this.udI.achu.isEmpty())
    {
      paramView = new ArrayList();
      localObject = this.udI.achu.iterator();
      while (((Iterator)localObject).hasNext())
      {
        gmf localgmf = (gmf)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localgmf.username;
        localWxaEntryInfo.title = localgmf.title;
        localWxaEntryInfo.rcg = localgmf.desc;
        localWxaEntryInfo.iconUrl = localgmf.icon_url;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.udA.getContext(), WxaBindBizInfoUI.class);
      ((Intent)localObject).putExtra("register", this.udI.acht);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(paramView));
      paramView = this.udA.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandProfileUI.a(this.udA, 3, 1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.13
 * JD-Core Version:    0.7.0.1
 */