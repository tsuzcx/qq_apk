package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.card.model.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$initView$4$1$2$1"})
final class CardHomePageNewUI$m$b$1
  implements DialogInterface.OnClickListener
{
  CardHomePageNewUI$m$b$1(CardHomePageNewUI.m.b paramb) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(89224);
    Object localObject1 = this.kAa.kzY.kzs;
    Object localObject2 = this.kAa.kzZ.kzm;
    if (localObject2 == null) {
      j.ebi();
    }
    localObject2 = ((on)localObject2).wEJ;
    j.p(localObject2, "element!!.card_pack_merchant_id");
    j.q(localObject2, "merchantId");
    ab.i("MicroMsg.CardHomePageNewUI", "do delete merchant: %s", new Object[] { localObject2 });
    new e((String)localObject2).adl().b((a)new CardHomePageNewUI.g((CardHomePageNewUI)localObject1, (String)localObject2));
    paramDialogInterface.dismiss();
    paramDialogInterface = h.qsU;
    localObject1 = this.kAa.kzZ.kzm;
    if (localObject1 == null) {
      j.ebi();
    }
    paramDialogInterface.e(16324, new Object[] { Integer.valueOf(2), ((on)localObject1).wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(this.kAa.iWi), Integer.valueOf(CardHomePageNewUI.l(this.kAa.kzY.kzs)) });
    AppMethodBeat.o(89224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.m.b.1
 * JD-Core Version:    0.7.0.1
 */