package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.WxaBindWxaInfoUI;
import com.tencent.mm.protocal.protobuf.ehw;
import com.tencent.mm.protocal.protobuf.ehx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandProfileUI$11
  implements View.OnClickListener
{
  AppBrandProfileUI$11(AppBrandProfileUI paramAppBrandProfileUI, ehx paramehx) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48717);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    if (!this.mEi.HSo.isEmpty())
    {
      paramView = new ArrayList();
      localObject = this.mEi.HSo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ehw localehw = (ehw)((Iterator)localObject).next();
        WxaAttributes.WxaEntryInfo localWxaEntryInfo = new WxaAttributes.WxaEntryInfo();
        localWxaEntryInfo.username = localehw.username;
        localWxaEntryInfo.title = localehw.title;
        localWxaEntryInfo.jZS = localehw.desc;
        localWxaEntryInfo.iconUrl = localehw.pkr;
        paramView.add(localWxaEntryInfo);
      }
      localObject = new Intent(this.mDY.getContext(), WxaBindWxaInfoUI.class);
      ((Intent)localObject).putExtra("register", this.mEi.HSn);
      ((Intent)localObject).putParcelableArrayListExtra("wxa_entry_info_list", paramView);
      paramView = this.mDY.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandProfileUI.a(this.mDY, 23, 1);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandProfileUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(48717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI.11
 * JD-Core Version:    0.7.0.1
 */