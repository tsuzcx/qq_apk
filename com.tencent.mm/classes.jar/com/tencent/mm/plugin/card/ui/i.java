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
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements k.a
{
  View ijA;
  MMActivity nTt;
  boolean oan = false;
  View ofu;
  TextView ofv;
  ImageView ofw;
  View ofx;
  TextView ofy;
  ImageView ofz;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.nTt = paramMMActivity;
    this.ijA = paramView;
  }
  
  public final void a(com.tencent.mm.plugin.card.model.g paramg)
  {
    AppMethodBeat.i(113517);
    bSv();
    AppMethodBeat.o(113517);
  }
  
  final void bSv()
  {
    AppMethodBeat.i(113518);
    int i = am.bQm().nUk;
    if ((i > 0) && (this.oan))
    {
      String str1 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFh, "");
      String str2 = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GFi, "");
      int j = this.nTt.getResources().getDimensionPixelOffset(2131165969);
      if (!TextUtils.isEmpty(str2))
      {
        n.a(this.ofw, str2, j, 2131231486, true);
        if (TextUtils.isEmpty(str1)) {
          break label186;
        }
        this.ofv.setText(str1);
        label109:
        this.ofu.setVisibility(0);
        if (this.ofx != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label216;
          }
          n.a(this.ofz, str2, j, 2131231486, true);
          label145:
          if (TextUtils.isEmpty(str1)) {
            break label228;
          }
          this.ofy.setText(str1);
        }
      }
      for (;;)
      {
        this.ofx.setVisibility(0);
        AppMethodBeat.o(113518);
        return;
        this.ofw.setImageResource(2131231486);
        break;
        label186:
        this.ofv.setText(this.nTt.getString(2131756895, new Object[] { Integer.valueOf(i) }));
        break label109;
        label216:
        this.ofz.setImageResource(2131231486);
        break label145;
        label228:
        this.ofy.setText(this.nTt.getString(2131756895, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.ofu.setVisibility(8);
    if (this.ofx != null) {
      this.ofx.setVisibility(8);
    }
    AppMethodBeat.o(113518);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */