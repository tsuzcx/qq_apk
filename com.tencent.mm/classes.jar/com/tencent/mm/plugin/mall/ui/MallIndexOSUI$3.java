package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fhr;
import com.tencent.mm.ui.f.r;
import com.tencent.mm.wallet_core.ui.g;

final class MallIndexOSUI$3
  implements View.OnClickListener
{
  MallIndexOSUI$3(MallIndexOSUI paramMallIndexOSUI, fhr paramfhr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(66078);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    h.IzE.a(13867, new Object[] { com.tencent.mm.platformtools.z.a(this.ERi.UHE), Integer.valueOf(this.ERg.EOJ) });
    paramView = new Intent();
    paramView.putExtra("rawUrl", com.tencent.mm.platformtools.z.a(this.ERi.UHE));
    paramView.putExtra("geta8key_username", com.tencent.mm.model.z.bcZ());
    paramView.putExtra("pay_channel", 1);
    paramView.putExtra(f.r.VSX, true);
    g.aJ(this.ERg.getContext(), paramView);
    a.a(this, "com/tencent/mm/plugin/mall/ui/MallIndexOSUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(66078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.3
 * JD-Core Version:    0.7.0.1
 */