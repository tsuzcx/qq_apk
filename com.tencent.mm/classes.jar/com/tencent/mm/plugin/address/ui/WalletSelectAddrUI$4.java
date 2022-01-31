package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class WalletSelectAddrUI$4
  implements AdapterView.OnItemClickListener
{
  WalletSelectAddrUI$4(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(16980);
    ab.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(paramInt)));
    synchronized (WalletSelectAddrUI.c(this.gNo))
    {
      if (paramInt < WalletSelectAddrUI.d(this.gNo).size())
      {
        WalletSelectAddrUI.a(this.gNo, (com.tencent.mm.plugin.address.d.b)WalletSelectAddrUI.d(this.gNo).get(paramInt));
        if ((WalletSelectAddrUI.e(this.gNo)) || (WalletSelectAddrUI.f(this.gNo)) || (WalletSelectAddrUI.g(this.gNo) == null)) {
          break label136;
        }
        WalletSelectAddrUI.a(this.gNo, WalletSelectAddrUI.g(this.gNo).id);
      }
      label136:
      while ((WalletSelectAddrUI.g(this.gNo) == null) || (WalletSelectAddrUI.g(this.gNo).id == 0))
      {
        WalletSelectAddrUI.i(this.gNo).notifyDataSetChanged();
        AppMethodBeat.o(16980);
        return;
      }
      paramView = new g(WalletSelectAddrUI.g(this.gNo).id);
      WalletSelectAddrUI.h(this.gNo).e(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.4
 * JD-Core Version:    0.7.0.1
 */