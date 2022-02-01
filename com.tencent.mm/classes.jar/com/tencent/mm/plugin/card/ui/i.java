package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  View iFK;
  MMActivity oDq;
  boolean oKj = false;
  View oPp;
  TextView oPq;
  ImageView oPr;
  View oPs;
  TextView oPt;
  ImageView oPu;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.oDq = paramMMActivity;
    this.iFK = paramView;
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(113517);
    bYp();
    AppMethodBeat.o(113517);
  }
  
  final void bYp()
  {
    AppMethodBeat.i(113518);
    int i = am.bWg().oEh;
    if ((i > 0) && (this.oKj))
    {
      String str1 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILV, "");
      String str2 = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.ILW, "");
      int j = this.oDq.getResources().getDimensionPixelOffset(2131165969);
      if (!TextUtils.isEmpty(str2))
      {
        n.a(this.oPr, str2, j, 2131231486, true);
        if (TextUtils.isEmpty(str1)) {
          break label186;
        }
        this.oPq.setText(str1);
        label109:
        this.oPp.setVisibility(0);
        if (this.oPs != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label216;
          }
          n.a(this.oPu, str2, j, 2131231486, true);
          label145:
          if (TextUtils.isEmpty(str1)) {
            break label228;
          }
          this.oPt.setText(str1);
        }
      }
      for (;;)
      {
        this.oPs.setVisibility(0);
        AppMethodBeat.o(113518);
        return;
        this.oPr.setImageResource(2131231486);
        break;
        label186:
        this.oPq.setText(this.oDq.getString(2131756895, new Object[] { Integer.valueOf(i) }));
        break label109;
        label216:
        this.oPu.setImageResource(2131231486);
        break label145;
        label228:
        this.oPt.setText(this.oDq.getString(2131756895, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.oPp.setVisibility(8);
    if (this.oPs != null) {
      this.oPs.setVisibility(8);
    }
    AppMethodBeat.o(113518);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */