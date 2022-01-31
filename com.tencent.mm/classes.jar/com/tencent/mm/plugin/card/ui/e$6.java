package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.protobuf.pg;

final class e$6
  implements q.a
{
  e$6(e parame, int paramInt, String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(88343);
    if (paramBoolean)
    {
      this.ktX.ktP = paramString;
      if (this.val$requestCode == 0)
      {
        if (this.ktX.ktT != null) {
          this.ktX.ktT.Ie(this.efI);
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(11582, new Object[] { "OperGift", Integer.valueOf(1), Integer.valueOf(this.ktX.klk.bbd().iFL), this.ktX.klk.bbi(), this.ktX.klk.bbh(), this.ktX.ktO });
        com.tencent.mm.ui.base.h.bO(this.ktX.kts, this.ktX.kts.getResources().getString(2131297941));
        AppMethodBeat.o(88343);
        return;
      }
      if (this.val$requestCode == 1)
      {
        paramString = this.ktX;
        paramString.klk.bbf().xMB = (paramString.getString(2131298052) + paramString.ktN.getTitle());
        l.a(paramString.klk, paramString.ktO, paramString.ktU.kte, 2);
        l.dz(paramString.ktP, paramString.ktO);
        com.tencent.mm.ui.base.h.bO(this.ktX.kts, this.ktX.kts.getResources().getString(2131297941));
        AppMethodBeat.o(88343);
        return;
      }
      if (this.val$requestCode == 4)
      {
        paramString = this.ktX;
        if (TextUtils.isEmpty(paramString.klk.bbj())) {
          paramString.klk.Hx(r.Zn());
        }
        paramString.klk.bbf().xMB = (paramString.getString(2131298013) + paramString.ktN.getTitle());
        l.a(paramString.klk, paramString.ktO, paramString.ktU.kte, 23);
        l.dz(paramString.ktP, paramString.ktO);
        com.tencent.mm.plugin.report.service.h.qsU.e(11582, new Object[] { "OpeRecommendCard", Integer.valueOf(this.ktX.ktU.ejF), Integer.valueOf(this.ktX.klk.bbd().iFL), this.ktX.klk.bbi(), this.ktX.klk.bbh(), this.ktX.ktO });
        com.tencent.mm.ui.base.h.bO(this.ktX.kts, this.ktX.kts.getResources().getString(2131297941));
      }
    }
    AppMethodBeat.o(88343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.e.6
 * JD-Core Version:    0.7.0.1
 */