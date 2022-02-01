package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;

public final class o
  extends i
{
  private TextView olA;
  private View olx;
  private ImageView oly;
  private TextView olz;
  
  public final void bTM()
  {
    AppMethodBeat.i(113701);
    this.olx.setVisibility(8);
    AppMethodBeat.o(113701);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113699);
    this.olx = findViewById(2131300308);
    this.oly = ((ImageView)findViewById(2131300306));
    this.olz = ((TextView)findViewById(2131300310));
    this.olA = ((TextView)findViewById(2131300309));
    this.olx.setVisibility(8);
    AppMethodBeat.o(113699);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113700);
    b localb = this.olg.bRG();
    MMActivity localMMActivity = this.olg.bRJ();
    e.a locala = this.olg.bRN();
    this.olx.setVisibility(0);
    this.olz.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(locala.obt).aaR(), this.olz.getTextSize()));
    if ((localb.bPk() != null) && (!TextUtils.isEmpty(localb.bPk().FHx))) {
      this.olA.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMActivity, localb.bPk().FHx, this.olA.getTextSize()));
    }
    for (;;)
    {
      a.b.c(this.oly, locala.obt);
      this.oly.setOnClickListener(this.olg.bRK());
      AppMethodBeat.o(113700);
      return;
      if (!TextUtils.isEmpty(localb.bPi().nVJ))
      {
        if (localb.bOT()) {
          this.olA.setText(localMMActivity.getString(2131756907, new Object[] { localb.bPi().nVJ }));
        } else {
          this.olA.setText(localMMActivity.getString(2131756870, new Object[] { localb.bPi().nVJ }));
        }
      }
      else if (localb.bOT()) {
        this.olA.setText(localMMActivity.getString(2131756907, new Object[] { this.olg.bRO().getTitle() }));
      } else {
        this.olA.setText(localMMActivity.getString(2131756870, new Object[] { this.olg.bRO().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */