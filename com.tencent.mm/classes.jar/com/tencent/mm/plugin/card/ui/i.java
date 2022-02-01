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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  View iCR;
  boolean oDH = false;
  View oIN;
  TextView oIO;
  ImageView oIP;
  View oIQ;
  TextView oIR;
  ImageView oIS;
  MMActivity owO;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.owO = paramMMActivity;
    this.iCR = paramView;
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(113517);
    bXa();
    AppMethodBeat.o(113517);
  }
  
  final void bXa()
  {
    AppMethodBeat.i(113518);
    int i = am.bUR().oxF;
    if ((i > 0) && (this.oDH))
    {
      String str1 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.Irz, "");
      String str2 = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IrA, "");
      int j = this.owO.getResources().getDimensionPixelOffset(2131165969);
      if (!TextUtils.isEmpty(str2))
      {
        n.a(this.oIP, str2, j, 2131231486, true);
        if (TextUtils.isEmpty(str1)) {
          break label186;
        }
        this.oIO.setText(str1);
        label109:
        this.oIN.setVisibility(0);
        if (this.oIQ != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label216;
          }
          n.a(this.oIS, str2, j, 2131231486, true);
          label145:
          if (TextUtils.isEmpty(str1)) {
            break label228;
          }
          this.oIR.setText(str1);
        }
      }
      for (;;)
      {
        this.oIQ.setVisibility(0);
        AppMethodBeat.o(113518);
        return;
        this.oIP.setImageResource(2131231486);
        break;
        label186:
        this.oIO.setText(this.owO.getString(2131756895, new Object[] { Integer.valueOf(i) }));
        break label109;
        label216:
        this.oIS.setImageResource(2131231486);
        break label145;
        label228:
        this.oIR.setText(this.owO.getString(2131756895, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.oIN.setVisibility(8);
    if (this.oIQ != null) {
      this.oIQ.setVisibility(8);
    }
    AppMethodBeat.o(113518);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */