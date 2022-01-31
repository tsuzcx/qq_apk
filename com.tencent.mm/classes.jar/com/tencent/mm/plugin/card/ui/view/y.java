package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private MMActivity jpX;
  private View kBQ;
  private b klk;
  
  public final void bfq()
  {
    AppMethodBeat.i(88791);
    if (this.kBQ != null) {
      this.kBQ.setVisibility(8);
    }
    AppMethodBeat.o(88791);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(88789);
    this.jpX = this.kBh.bdy();
    AppMethodBeat.o(88789);
  }
  
  public final void update()
  {
    AppMethodBeat.i(88790);
    this.klk = this.kBh.bdv();
    if (this.kBQ == null) {
      this.kBQ = ((ViewStub)findViewById(2131822079)).inflate();
    }
    if (this.klk.baN()) {
      this.kBQ.setBackgroundDrawable(l.I(this.jpX, this.jpX.getResources().getColor(2131689826)));
    }
    TextView localTextView = (TextView)this.kBQ.findViewById(2131822381);
    if (this.klk.bbe() == null)
    {
      ab.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(88790);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.jpX.getResources().getColor(2131690143));
    if (!TextUtils.isEmpty(this.klk.bbd().wGx))
    {
      localTextView.setText(this.klk.bbd().wGx);
      AppMethodBeat.o(88790);
      return;
    }
    m.f(localTextView, this.klk.bbe().status);
    AppMethodBeat.o(88790);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */