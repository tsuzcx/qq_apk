package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.mgr.e;
import com.tencent.mm.plugin.card.ui.e.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;

public final class o
  extends i
{
  private View wJJ;
  private ImageView wJK;
  private TextView wJL;
  private TextView wJM;
  
  public final void doE()
  {
    AppMethodBeat.i(113701);
    this.wJJ.setVisibility(8);
    AppMethodBeat.o(113701);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113699);
    this.wJJ = findViewById(a.d.wkd);
    this.wJK = ((ImageView)findViewById(a.d.wkb));
    this.wJL = ((TextView)findViewById(a.d.wkf));
    this.wJM = ((TextView)findViewById(a.d.wke));
    this.wJJ.setVisibility(8);
    AppMethodBeat.o(113699);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113700);
    b localb = this.wJs.dmk();
    MMActivity localMMActivity = this.wJs.dmn();
    e.b localb1 = this.wJs.dmr();
    this.wJJ.setVisibility(0);
    this.wJL.setText(p.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localb1.wzv).aSU(), this.wJL.getTextSize()));
    if ((localb.djM() != null) && (!TextUtils.isEmpty(localb.djM().abBp))) {
      this.wJM.setText(p.b(localMMActivity, localb.djM().abBp, this.wJM.getTextSize()));
    }
    for (;;)
    {
      a.b.g(this.wJK, localb1.wzv);
      this.wJK.setOnClickListener(this.wJs.dmo());
      AppMethodBeat.o(113700);
      return;
      if (!TextUtils.isEmpty(localb.djK().wtN))
      {
        if (localb.dju()) {
          this.wJM.setText(localMMActivity.getString(a.g.wpf, new Object[] { localb.djK().wtN }));
        } else {
          this.wJM.setText(localMMActivity.getString(a.g.woK, new Object[] { localb.djK().wtN }));
        }
      }
      else if (localb.dju()) {
        this.wJM.setText(localMMActivity.getString(a.g.wpf, new Object[] { this.wJs.dms().getTitle() }));
      } else {
        this.wJM.setText(localMMActivity.getString(a.g.woK, new Object[] { this.wJs.dms().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */