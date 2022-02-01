package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.profile.model.WxaRegisterInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.protocal.protobuf.fpi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AppBrandProfileUI$13
  implements View.OnClickListener
{
  AppBrandProfileUI$13(AppBrandProfileUI paramAppBrandProfileUI, AppBrandProfileUI.c paramc, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(267055);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = new ArrayList();
    localObject = this.qXJ.qXP.iterator();
    while (((Iterator)localObject).hasNext())
    {
      fpi localfpi = (fpi)((Iterator)localObject).next();
      if ((localfpi != null) && (localfpi.UNa != null) && (!localfpi.UNa.isEmpty())) {
        paramView.add(new WxaRegisterInfo(localfpi));
      }
    }
    localObject = new Intent(this.qXA.getContext(), WxaBindWxaInfoUI.class);
    ((Intent)localObject).putExtra("register", this.qXK);
    ((Intent)localObject).putParcelableArrayListExtra("wxa_register_info_list", paramView);
    paramView = this.qXA.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppBrandProfileUI.a(this.qXA, 23, 1);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(267055);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.13
 * JD-Core Version:    0.7.0.1
 */