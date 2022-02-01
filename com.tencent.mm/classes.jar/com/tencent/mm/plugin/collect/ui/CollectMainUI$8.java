package com.tencent.mm.plugin.collect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

final class CollectMainUI$8
  implements View.OnClickListener
{
  CollectMainUI$8(CollectMainUI paramCollectMainUI, cxf paramcxf) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(276140);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/collect/ui/CollectMainUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.uaT.type == 1) {
      if (this.uaT.url.equals("wxpay://f2f/f2fdetail"))
      {
        paramView = new Intent(this.uaM.getContext(), CollectBillUI.class);
        paramView.putExtra("key_from_scene", 0);
        this.uaM.startActivityForResult(paramView, 4097);
        h.IzE.a(13944, new Object[] { Integer.valueOf(1) });
        h.IzE.a(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(1), this.uaT.wording, "", "", "", Integer.valueOf(2) });
        if (this.uaT.TFO == 1) {
          h.IzE.a(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(1), this.uaT.wording, "", "", "", Integer.valueOf(2) });
        }
      }
    }
    for (;;)
    {
      this.uaM.uaq.setVisibility(4);
      this.uaM.uar.setVisibility(8);
      a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(276140);
      return;
      if (this.uaT.type == 2)
      {
        if (Util.isNullOrNil(this.uaT.url))
        {
          Log.w("MicroMsg.CollectMainUI", "empty bottom h5 url");
          a.a(this, "com/tencent/mm/plugin/collect/ui/CollectMainUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(276140);
          return;
        }
        g.p(this.uaM.getContext(), this.uaT.url, false);
        h.IzE.a(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(2), this.uaT.wording, "", "", this.uaT.url, Integer.valueOf(2) });
        if (this.uaT.TFO == 1) {
          h.IzE.a(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(2), this.uaT.wording, "", "", this.uaT.url, Integer.valueOf(2) });
        }
      }
      else if (this.uaT.type == 3)
      {
        paramView = new xw();
        paramView.fWN.userName = this.uaT.TFL;
        paramView.fWN.fWP = Util.nullAs(this.uaT.TFM, "");
        paramView.fWN.scene = 1072;
        paramView.fWN.fWQ = 0;
        EventCenter.instance.publish(paramView);
        h.IzE.a(14526, new Object[] { Integer.valueOf(1), Integer.valueOf(3), this.uaT.wording, this.uaT.TFL, this.uaT.TFM, "", Integer.valueOf(2) });
        if (this.uaT.TFO == 1) {
          h.IzE.a(14526, new Object[] { Integer.valueOf(3), Integer.valueOf(3), this.uaT.wording, this.uaT.TFL, this.uaT.TFM, "", Integer.valueOf(2) });
        }
      }
      else
      {
        paramView = new Intent(this.uaM.getContext(), CollectBillUI.class);
        paramView.putExtra("key_from_scene", 0);
        this.uaM.startActivityForResult(paramView, 4097);
        h.IzE.a(13944, new Object[] { Integer.valueOf(1) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.8
 * JD-Core Version:    0.7.0.1
 */