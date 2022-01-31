package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class IPCallPackageUI$a$1
  implements View.OnClickListener
{
  IPCallPackageUI$a$1(IPCallPackageUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(22226);
    paramView = (cva)this.nUu.getItem(((Integer)paramView.getTag()).intValue());
    if ((paramView == null) || (bo.isNullOrNil(paramView.ProductID)))
    {
      ab.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
      AppMethodBeat.o(22226);
      return;
    }
    IPCallPackageUI.b(IPCallPackageUI.a.a(this.nUu)).start();
    f localf = IPCallPackageUI.b(IPCallPackageUI.a.a(this.nUu));
    localf.nPx += 1;
    IPCallPackageUI.b(IPCallPackageUI.a.a(this.nUu)).nPB = paramView.ProductID;
    h.a(IPCallPackageUI.a.a(this.nUu), IPCallPackageUI.a.a(this.nUu).getString(2131300934, new Object[] { paramView.xBK, paramView.Title }), IPCallPackageUI.a.a(this.nUu).getString(2131300935), IPCallPackageUI.a.a(this.nUu).getString(2131300932), IPCallPackageUI.a.a(this.nUu).getString(2131300933), false, new IPCallPackageUI.a.1.1(this, paramView), new IPCallPackageUI.a.1.2(this));
    AppMethodBeat.o(22226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a.1
 * JD-Core Version:    0.7.0.1
 */