package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private View nIP;
  private b nqp;
  private MMActivity nqt;
  
  public final void bMB()
  {
    AppMethodBeat.i(113718);
    if (this.nIP != null) {
      this.nIP.setVisibility(8);
    }
    AppMethodBeat.o(113718);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113716);
    this.nqt = this.nIg.bKw();
    AppMethodBeat.o(113716);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113717);
    this.nqp = this.nIg.bKt();
    if (this.nIP == null) {
      this.nIP = ((ViewStub)findViewById(2131297900)).inflate();
    }
    if (this.nqp.bHE()) {
      this.nIP.setBackgroundDrawable(l.K(this.nqt, this.nqt.getResources().getColor(2131100086)));
    }
    TextView localTextView = (TextView)this.nIP.findViewById(2131297901);
    if (this.nqp.bHW() == null)
    {
      ad.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(113717);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.nqt.getResources().getColor(2131100469));
    if (!TextUtils.isEmpty(this.nqp.bHV().CSc))
    {
      localTextView.setText(this.nqp.bHV().CSc);
      AppMethodBeat.o(113717);
      return;
    }
    com.tencent.mm.plugin.card.d.n.h(localTextView, this.nqp.bHW().status);
    AppMethodBeat.o(113717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */