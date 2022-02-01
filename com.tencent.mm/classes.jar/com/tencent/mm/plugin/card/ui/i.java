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
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.mgr.j;
import com.tencent.mm.plugin.card.mgr.j.a;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;

public final class i
  implements j.a
{
  View plc;
  View wDA;
  TextView wDB;
  ImageView wDC;
  View wDx;
  TextView wDy;
  ImageView wDz;
  MMActivity wry;
  boolean wyq = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.wry = paramMMActivity;
    this.plc = paramView;
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(113517);
    dmX();
    AppMethodBeat.o(113517);
  }
  
  final void dmX()
  {
    AppMethodBeat.i(113518);
    int i = am.dkN().wsr;
    if ((i > 0) && (this.wyq))
    {
      String str1 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJr, "");
      String str2 = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acJs, "");
      int j = this.wry.getResources().getDimensionPixelOffset(a.b.wdP);
      if (!TextUtils.isEmpty(str2))
      {
        n.a(this.wDz, str2, j, a.c.wes, true);
        if (TextUtils.isEmpty(str1)) {
          break label190;
        }
        this.wDy.setText(str1);
        label111:
        this.wDx.setVisibility(0);
        if (this.wDA != null)
        {
          if (TextUtils.isEmpty(str2)) {
            break label221;
          }
          n.a(this.wDC, str2, j, a.c.wes, true);
          label148:
          if (TextUtils.isEmpty(str1)) {
            break label234;
          }
          this.wDB.setText(str1);
        }
      }
      for (;;)
      {
        this.wDA.setVisibility(0);
        AppMethodBeat.o(113518);
        return;
        this.wDz.setImageResource(a.c.wes);
        break;
        label190:
        this.wDy.setText(this.wry.getString(a.g.wpa, new Object[] { Integer.valueOf(i) }));
        break label111;
        label221:
        this.wDC.setImageResource(a.c.wes);
        break label148;
        label234:
        this.wDB.setText(this.wry.getString(a.g.wpa, new Object[] { Integer.valueOf(i) }));
      }
    }
    this.wDx.setVisibility(8);
    if (this.wDA != null) {
      this.wDA.setVisibility(8);
    }
    AppMethodBeat.o(113518);
  }
  
  public final void onChange() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.i
 * JD-Core Version:    0.7.0.1
 */