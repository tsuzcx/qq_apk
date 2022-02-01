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
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;

public final class o
  extends i
{
  private View oVu;
  private ImageView oVv;
  private TextView oVw;
  private TextView oVx;
  
  public final void bZG()
  {
    AppMethodBeat.i(113701);
    this.oVu.setVisibility(8);
    AppMethodBeat.o(113701);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113699);
    this.oVu = findViewById(2131300308);
    this.oVv = ((ImageView)findViewById(2131300306));
    this.oVw = ((TextView)findViewById(2131300310));
    this.oVx = ((TextView)findViewById(2131300309));
    this.oVu.setVisibility(8);
    AppMethodBeat.o(113699);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113700);
    b localb = this.oVd.bXA();
    MMActivity localMMActivity = this.oVd.bXD();
    e.a locala = this.oVd.bXH();
    this.oVu.setVisibility(0);
    this.oVw.setText(k.b(localMMActivity, ((l)g.ab(l.class)).azF().BH(locala.oLo).adF(), this.oVw.getTextSize()));
    if ((localb.bVe() != null) && (!TextUtils.isEmpty(localb.bVe().HLH))) {
      this.oVx.setText(k.b(localMMActivity, localb.bVe().HLH, this.oVx.getTextSize()));
    }
    for (;;)
    {
      a.b.c(this.oVv, locala.oLo);
      this.oVv.setOnClickListener(this.oVd.bXE());
      AppMethodBeat.o(113700);
      return;
      if (!TextUtils.isEmpty(localb.bVc().oFF))
      {
        if (localb.bUN()) {
          this.oVx.setText(localMMActivity.getString(2131756907, new Object[] { localb.bVc().oFF }));
        } else {
          this.oVx.setText(localMMActivity.getString(2131756870, new Object[] { localb.bVc().oFF }));
        }
      }
      else if (localb.bUN()) {
        this.oVx.setText(localMMActivity.getString(2131756907, new Object[] { this.oVd.bXI().getTitle() }));
      } else {
        this.oVx.setText(localMMActivity.getString(2131756870, new Object[] { this.oVd.bXI().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */