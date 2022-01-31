package com.tencent.mm.plugin.aa.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.mm.vending.g.d.a;

final class PaylistAAUI$15
  implements d.a
{
  PaylistAAUI$15(PaylistAAUI paramPaylistAAUI) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(40884);
    ab.i("MicroMsg.PaylistAAUI", "aapay failed: %s", new Object[] { paramObject });
    this.grF.hideLoading();
    if (paramObject != null)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        String str1 = paramObject.cyA;
        String str2 = paramObject.opC;
        String str3 = paramObject.opD;
        c.a locala = new c.a(this.grF);
        locala.avn(str1);
        locala.avs(str3).a(new PaylistAAUI.15.1(this, paramObject));
        locala.avt(str2);
        locala.aLZ().show();
        AppMethodBeat.o(40884);
        return;
      }
      if (((paramObject instanceof String)) && (!paramObject.toString().equalsIgnoreCase("ok")))
      {
        Toast.makeText(this.grF, paramObject.toString(), 1).show();
        AppMethodBeat.o(40884);
      }
    }
    else
    {
      Toast.makeText(this.grF, this.grF.getString(2131296376), 1).show();
    }
    AppMethodBeat.o(40884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.PaylistAAUI.15
 * JD-Core Version:    0.7.0.1
 */