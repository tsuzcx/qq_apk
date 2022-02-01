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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  View jBN;
  MMActivity pQZ;
  boolean pXX = false;
  View qdd;
  TextView qde;
  ImageView qdf;
  View qdg;
  TextView qdh;
  ImageView qdi;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.pQZ = paramMMActivity;
    this.jBN = paramView;
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(113517);
    cwf();
    AppMethodBeat.o(113517);
  }
  
  final void cwf()
  {
    AppMethodBeat.i(113518);
    int i = am.ctU().pRQ;
    if ((i > 0) && (this.pXX))
    {
      String str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTX, "");
      String str2 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NTY, "");
      int j = this.pQZ.getResources().getDimensionPixelOffset(2131166001);
      if (!TextUtils.isEmpty(str2))
      {
        n.a(this.qdf, str2, j, 2131231550, true);
        if (TextUtils.isEmpty(str1)) {
          break label186;
        }
        this.qde.setText(str1);
        label109:
        this.qdd.setVisibility(0);
        if (this.qdg != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label216;
          }
          n.a(this.qdi, str2, j, 2131231550, true);
          label145:
          if (TextUtils.isEmpty(str1)) {
            break label228;
          }
          this.qdh.setText(str1);
        }
      }
      for (;;)
      {
        this.qdg.setVisibility(0);
        AppMethodBeat.o(113518);
        return;
        this.qdf.setImageResource(2131231550);
        break;
        label186:
        this.qde.setText(this.pQZ.getString(2131757065, new Object[] { Integer.valueOf(i) }));
        break label109;
        label216:
        this.qdi.setImageResource(2131231550);
        break label145;
        label228:
        this.qdh.setText(this.pQZ.getString(2131757065, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.qdd.setVisibility(8);
    if (this.qdg != null) {
      this.qdg.setVisibility(8);
    }
    AppMethodBeat.o(113518);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */