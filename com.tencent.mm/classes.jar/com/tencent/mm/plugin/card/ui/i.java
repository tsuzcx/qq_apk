package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  View iCk;
  MMActivity jpX;
  boolean krU = false;
  View kxa;
  TextView kxb;
  ImageView kxc;
  View kxd;
  TextView kxe;
  ImageView kxf;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.jpX = paramMMActivity;
    this.iCk = paramView;
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(88590);
    bel();
    AppMethodBeat.o(88590);
  }
  
  final void bel()
  {
    AppMethodBeat.i(88591);
    int i = am.bch().kme;
    if ((i > 0) && (this.krU))
    {
      String str1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyX, "");
      String str2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yyY, "");
      int j = this.jpX.getResources().getDimensionPixelOffset(2131428170);
      if (!TextUtils.isEmpty(str2))
      {
        m.a(this.kxc, str2, j, 2130838155, true);
        if (TextUtils.isEmpty(str1)) {
          break label186;
        }
        this.kxb.setText(str1);
        label109:
        this.kxa.setVisibility(0);
        if (this.kxd != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label216;
          }
          m.a(this.kxf, str2, j, 2130838155, true);
          label145:
          if (TextUtils.isEmpty(str1)) {
            break label228;
          }
          this.kxe.setText(str1);
        }
      }
      for (;;)
      {
        this.kxd.setVisibility(0);
        AppMethodBeat.o(88591);
        return;
        this.kxc.setImageResource(2130838155);
        break;
        label186:
        this.kxb.setText(this.jpX.getString(2131297953, new Object[] { Integer.valueOf(i) }));
        break label109;
        label216:
        this.kxf.setImageResource(2130838155);
        break label145;
        label228:
        this.kxe.setText(this.jpX.getString(2131297953, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.kxa.setVisibility(8);
    if (this.kxd != null) {
      this.kxd.setVisibility(8);
    }
    AppMethodBeat.o(88591);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */