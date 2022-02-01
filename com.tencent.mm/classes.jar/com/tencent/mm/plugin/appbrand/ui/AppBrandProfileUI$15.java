package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.profile.model.WxaRegisterInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.protocal.protobuf.gmi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class AppBrandProfileUI$15
  implements View.OnClickListener
{
  AppBrandProfileUI$15(AppBrandProfileUI paramAppBrandProfileUI, AppBrandProfileUI.c paramc, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48720);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = new ArrayList();
    localObject = this.udK.udQ.iterator();
    while (((Iterator)localObject).hasNext())
    {
      gmi localgmi = (gmi)((Iterator)localObject).next();
      if ((localgmi != null) && (localgmi.achw != null) && (!localgmi.achw.isEmpty())) {
        paramView.add(new WxaRegisterInfo(localgmi));
      }
    }
    localObject = new Intent(this.udA.getContext(), WxaBindWxaInfoUI.class);
    ((Intent)localObject).putExtra("register", this.udL);
    ((Intent)localObject).putParcelableArrayListExtra("wxa_register_info_list", paramView);
    paramView = this.udA.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppBrandProfileUI.a(this.udA, 23, 1);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.15
 * JD-Core Version:    0.7.0.1
 */