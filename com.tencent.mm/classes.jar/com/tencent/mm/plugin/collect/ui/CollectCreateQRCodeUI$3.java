package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class CollectCreateQRCodeUI$3
  implements View.OnClickListener
{
  CollectCreateQRCodeUI$3(CollectCreateQRCodeUI paramCollectCreateQRCodeUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41232);
    double d = bo.getDouble(CollectCreateQRCodeUI.a(this.kRn).getText(), 0.0D);
    g.RM();
    int i = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
    ab.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
    if (!CollectCreateQRCodeUI.a(this.kRn).asv())
    {
      t.makeText(this.kRn.getContext(), 2131304847, 0).show();
      AppMethodBeat.o(41232);
      return;
    }
    if (d < 0.01D)
    {
      t.makeText(this.kRn.getContext(), 2131302516, 0).show();
      AppMethodBeat.o(41232);
      return;
    }
    if (i == 8)
    {
      this.kRn.doSceneForceProgress(new m(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(this.kRn), r.Zu()));
      AppMethodBeat.o(41232);
      return;
    }
    this.kRn.doSceneProgress(new s(d, "1", CollectCreateQRCodeUI.b(this.kRn)));
    AppMethodBeat.o(41232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.3
 * JD-Core Version:    0.7.0.1
 */