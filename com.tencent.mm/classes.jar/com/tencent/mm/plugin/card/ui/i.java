package com.tencent.mm.plugin.card.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.k.a;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  View mrI;
  MMActivity tmY;
  boolean ttT = false;
  View tza;
  TextView tzb;
  ImageView tzc;
  View tzd;
  TextView tze;
  ImageView tzf;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.tmY = paramMMActivity;
    this.mrI = paramView;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(113517);
    cJH();
    AppMethodBeat.o(113517);
  }
  
  final void cJH()
  {
    AppMethodBeat.i(113518);
    int i = am.cHw().tnQ;
    if ((i > 0) && (this.ttT))
    {
      String str1 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhX, "");
      String str2 = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VhY, "");
      int j = this.tmY.getResources().getDimensionPixelOffset(a.b.sZI);
      if (!TextUtils.isEmpty(str2))
      {
        n.a(this.tzc, str2, j, a.c.tak, true);
        if (TextUtils.isEmpty(str1)) {
          break label190;
        }
        this.tzb.setText(str1);
        label111:
        this.tza.setVisibility(0);
        if (this.tzd != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label221;
          }
          n.a(this.tzf, str2, j, a.c.tak, true);
          label148:
          if (TextUtils.isEmpty(str1)) {
            break label234;
          }
          this.tze.setText(str1);
        }
      }
      for (;;)
      {
        this.tzd.setVisibility(0);
        AppMethodBeat.o(113518);
        return;
        this.tzc.setImageResource(a.c.tak);
        break;
        label190:
        this.tzb.setText(this.tmY.getString(a.g.tkC, new Object[] { Integer.valueOf(i) }));
        break label111;
        label221:
        this.tzf.setImageResource(a.c.tak);
        break label148;
        label234:
        this.tze.setText(this.tmY.getString(a.g.tkC, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.tza.setVisibility(8);
    if (this.tzd != null) {
      this.tzd.setVisibility(8);
    }
    AppMethodBeat.o(113518);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */