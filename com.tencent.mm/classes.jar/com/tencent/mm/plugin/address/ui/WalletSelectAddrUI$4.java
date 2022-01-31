package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class WalletSelectAddrUI$4
  implements AdapterView.OnItemClickListener
{
  WalletSelectAddrUI$4(WalletSelectAddrUI paramWalletSelectAddrUI) {}
  
  public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
  {
    y.d("MicroMsg.WalletSelectAddrUI", "select pos " + paramInt);
    synchronized (WalletSelectAddrUI.c(this.fvI))
    {
      if (paramInt < WalletSelectAddrUI.d(this.fvI).size())
      {
        WalletSelectAddrUI.a(this.fvI, (com.tencent.mm.plugin.address.d.b)WalletSelectAddrUI.d(this.fvI).get(paramInt));
        if ((WalletSelectAddrUI.e(this.fvI)) || (WalletSelectAddrUI.f(this.fvI) == null)) {
          break label121;
        }
        WalletSelectAddrUI.a(this.fvI, WalletSelectAddrUI.f(this.fvI).id);
      }
      label121:
      while ((WalletSelectAddrUI.f(this.fvI) == null) || (WalletSelectAddrUI.f(this.fvI).id == 0))
      {
        WalletSelectAddrUI.h(this.fvI).notifyDataSetChanged();
        return;
      }
      paramView = new g(WalletSelectAddrUI.f(this.fvI).id);
      WalletSelectAddrUI.g(this.fvI).g(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.4
 * JD-Core Version:    0.7.0.1
 */