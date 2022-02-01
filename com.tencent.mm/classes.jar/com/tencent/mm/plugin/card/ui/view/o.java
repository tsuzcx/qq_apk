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
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;

public final class o
  extends i
{
  private View qko;
  private ImageView qkp;
  private TextView qkq;
  private TextView qkr;
  
  public final void cxw()
  {
    AppMethodBeat.i(113701);
    this.qko.setVisibility(8);
    AppMethodBeat.o(113701);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113699);
    this.qko = findViewById(2131301800);
    this.qkp = ((ImageView)findViewById(2131301798));
    this.qkq = ((TextView)findViewById(2131301802));
    this.qkr = ((TextView)findViewById(2131301801));
    this.qko.setVisibility(8);
    AppMethodBeat.o(113699);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113700);
    b localb = this.qjX.cvq();
    MMActivity localMMActivity = this.qjX.cvt();
    e.a locala = this.qjX.cvx();
    this.qko.setVisibility(0);
    this.qkq.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(locala.pZc).arI(), this.qkq.getTextSize()));
    if ((localb.csS() != null) && (!TextUtils.isEmpty(localb.csS().MXq))) {
      this.qkr.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localMMActivity, localb.csS().MXq, this.qkr.getTextSize()));
    }
    for (;;)
    {
      a.b.c(this.qkp, locala.pZc);
      this.qkp.setOnClickListener(this.qjX.cvu());
      AppMethodBeat.o(113700);
      return;
      if (!TextUtils.isEmpty(localb.csQ().pTn))
      {
        if (localb.csB()) {
          this.qkr.setText(localMMActivity.getString(2131757077, new Object[] { localb.csQ().pTn }));
        } else {
          this.qkr.setText(localMMActivity.getString(2131757035, new Object[] { localb.csQ().pTn }));
        }
      }
      else if (localb.csB()) {
        this.qkr.setText(localMMActivity.getString(2131757077, new Object[] { this.qjX.cvy().getTitle() }));
      } else {
        this.qkr.setText(localMMActivity.getString(2131757035, new Object[] { this.qjX.cvy().getTitle() }));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.o
 * JD-Core Version:    0.7.0.1
 */