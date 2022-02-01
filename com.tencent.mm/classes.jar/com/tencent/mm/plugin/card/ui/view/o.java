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
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;

public final class o
  extends i
{
  private View oOS;
  private ImageView oOT;
  private TextView oOU;
  private TextView oOV;
  
  public final void bYr()
  {
    AppMethodBeat.i(113701);
    this.oOS.setVisibility(8);
    AppMethodBeat.o(113701);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113699);
    this.oOS = findViewById(2131300308);
    this.oOT = ((ImageView)findViewById(2131300306));
    this.oOU = ((TextView)findViewById(2131300310));
    this.oOV = ((TextView)findViewById(2131300309));
    this.oOS.setVisibility(8);
    AppMethodBeat.o(113699);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113700);
    b localb = this.oOB.bWl();
    MMActivity localMMActivity = this.oOB.bWo();
    e.a locala = this.oOB.bWs();
    this.oOS.setVisibility(0);
    this.oOU.setText(k.b(localMMActivity, ((l)g.ab(l.class)).azp().Bf(locala.oEM).adu(), this.oOU.getTextSize()));
    if ((localb.bTP() != null) && (!TextUtils.isEmpty(localb.bTP().Hsf))) {
      this.oOV.setText(k.b(localMMActivity, localb.bTP().Hsf, this.oOV.getTextSize()));
    }
    for (;;)
    {
      a.b.c(this.oOT, locala.oEM);
      this.oOT.setOnClickListener(this.oOB.bWp());
      AppMethodBeat.o(113700);
      return;
      if (!TextUtils.isEmpty(localb.bTN().ozd))
      {
        if (localb.bTy()) {
          this.oOV.setText(localMMActivity.getString(2131756907, new Object[] { localb.bTN().ozd }));
        } else {
          this.oOV.setText(localMMActivity.getString(2131756870, new Object[] { localb.bTN().ozd }));
        }
      }
      else if (localb.bTy()) {
        this.oOV.setText(localMMActivity.getString(2131756907, new Object[] { this.oOB.bWt().getTitle() }));
      } else {
        this.oOV.setText(localMMActivity.getString(2131756870, new Object[] { this.oOB.bWt().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */