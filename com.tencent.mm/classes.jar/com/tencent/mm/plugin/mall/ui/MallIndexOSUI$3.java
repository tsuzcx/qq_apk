package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.exe;
import com.tencent.mm.ui.e.p;
import com.tencent.mm.wallet_core.ui.f;

final class MallIndexOSUI$3
  implements View.OnClickListener
{
  MallIndexOSUI$3(MallIndexOSUI paramMallIndexOSUI, exe paramexe) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66078);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    h.CyF.a(13867, new Object[] { com.tencent.mm.platformtools.z.a(this.zlS.NuD), Integer.valueOf(this.zlQ.zjs) });
    paramView = new Intent();
    paramView.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(this.zlS.NuD));
    paramView.putExtra("geta8key_username", com.tencent.mm.model.z.aTY());
    paramView.putExtra("pay_channel", 1);
    paramView.putExtra(e.p.OzJ, true);
    f.aA(this.zlQ.getContext(), paramView);
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.3
 * JD-Core Version:    0.7.0.1
 */