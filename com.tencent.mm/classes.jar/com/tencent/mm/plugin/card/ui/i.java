package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  View hIZ;
  View nCt;
  TextView nCu;
  ImageView nCv;
  View nCw;
  TextView nCx;
  ImageView nCy;
  MMActivity nqt;
  boolean nxn = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.nqt = paramMMActivity;
    this.hIZ = paramView;
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(113517);
    bLi();
    AppMethodBeat.o(113517);
  }
  
  final void bLi()
  {
    AppMethodBeat.i(113518);
    int i = am.bIZ().nrk;
    if ((i > 0) && (this.nxn))
    {
      String str1 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fhs, "");
      String str2 = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fht, "");
      int j = this.nqt.getResources().getDimensionPixelOffset(2131165969);
      if (!TextUtils.isEmpty(str2))
      {
        n.a(this.nCv, str2, j, 2131231486, true);
        if (TextUtils.isEmpty(str1)) {
          break label186;
        }
        this.nCu.setText(str1);
        label109:
        this.nCt.setVisibility(0);
        if (this.nCw != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label216;
          }
          n.a(this.nCy, str2, j, 2131231486, true);
          label145:
          if (TextUtils.isEmpty(str1)) {
            break label228;
          }
          this.nCx.setText(str1);
        }
      }
      for (;;)
      {
        this.nCw.setVisibility(0);
        AppMethodBeat.o(113518);
        return;
        this.nCv.setImageResource(2131231486);
        break;
        label186:
        this.nCu.setText(this.nqt.getString(2131756895, new Object[] { Integer.valueOf(i) }));
        break label109;
        label216:
        this.nCy.setImageResource(2131231486);
        break label145;
        label228:
        this.nCx.setText(this.nqt.getString(2131756895, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.nCt.setVisibility(8);
    if (this.nCw != null) {
      this.nCw.setVisibility(8);
    }
    AppMethodBeat.o(113518);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */