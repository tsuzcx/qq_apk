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
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.e.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View wIZ;
  
  public final void doE()
  {
    AppMethodBeat.i(113657);
    this.wIZ.setVisibility(8);
    AppMethodBeat.o(113657);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113655);
    this.wIZ = findViewById(a.d.wfi);
    AppMethodBeat.o(113655);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113656);
    Object localObject = this.wJs.dmp();
    b localb = this.wJs.dmk();
    MMActivity localMMActivity = this.wJs.dmn();
    e.b localb1 = this.wJs.dmr();
    e locale = this.wJs.dms();
    if (((g)localObject).dnA())
    {
      this.wIZ.setVisibility(0);
      findViewById(a.d.weI).setVisibility(0);
      localObject = (ImageView)findViewById(a.d.weH);
      TextView localTextView1 = (TextView)findViewById(a.d.weJ);
      TextView localTextView2 = (TextView)findViewById(a.d.weK);
      if (localb1.wzv != null) {
        localTextView1.setText(p.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(localb1.wzv).aSU(), localTextView1.getTextSize()));
      }
      if (localb1.lCR == 23) {
        if (!TextUtils.isEmpty(localb.djK().Zej)) {
          localTextView2.setText(localb.djK().Zej);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, localb1.wzv, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.wJs.dmo());
        AppMethodBeat.o(113656);
        return;
        if (!TextUtils.isEmpty(localb.djK().wtN))
        {
          localTextView2.setText(localMMActivity.getString(a.g.wpJ, new Object[] { localb.djK().wtN }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(a.g.wpJ, new Object[] { locale.getTitle() }));
          continue;
          if ((localb.djM() != null) && (!TextUtils.isEmpty(localb.djM().abBp))) {
            localTextView2.setText(localb.djM().abBp);
          } else if (!TextUtils.isEmpty(localb.djK().wtN))
          {
            if (localb.dju()) {
              localTextView2.setText(localMMActivity.getString(a.g.wpf, new Object[] { localb.djK().wtN }));
            } else {
              localTextView2.setText(localMMActivity.getString(a.g.woK, new Object[] { localb.djK().wtN }));
            }
          }
          else if (localb.dju()) {
            localTextView2.setText(localMMActivity.getString(a.g.wpf, new Object[] { locale.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(a.g.woK, new Object[] { locale.getTitle() }));
          }
        }
      }
    }
    if (((g)localObject).dnB())
    {
      if (!TextUtils.isEmpty(localb.djK().Zej))
      {
        this.wIZ.setVisibility(0);
        findViewById(a.d.weI).setVisibility(8);
        ((TextView)findViewById(a.d.weK)).setText(localb.djK().Zej);
        AppMethodBeat.o(113656);
        return;
      }
      this.wIZ.setVisibility(8);
      AppMethodBeat.o(113656);
      return;
    }
    doE();
    AppMethodBeat.o(113656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */