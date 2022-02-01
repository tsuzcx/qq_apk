package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindBizInfoUI;
import com.tencent.mm.protocal.protobuf.fpf;
import com.tencent.mm.protocal.protobuf.fpg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$10
  implements View.OnClickListener
{
  AppBrandProfileUI$10(AppBrandProfileUI paramAppBrandProfileUI, fpg paramfpg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(273322);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    if (!this.qXH.UMY.isEmpty())
    {
      paramView = new ArrayList();
      localObject = this.qXH.UMY.iterator();
      while (((Iterator)localObject).hasNext())
      {
        fpf localfpf = (fpf)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localfpf.username;
        localWxaEntryInfo.title = localfpf.title;
        localWxaEntryInfo.obt = localfpf.desc;
        localWxaEntryInfo.iconUrl = localfpf.ufC;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.qXA.getContext(), WxaBindBizInfoUI.class);
      ((Intent)localObject).putExtra("register", this.qXH.UMX);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(paramView));
      paramView = this.qXA.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandProfileUI.a(this.qXA, 3, 1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(273322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.10
 * JD-Core Version:    0.7.0.1
 */