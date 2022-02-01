package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private View oPk;
  private b owK;
  private MMActivity owO;
  
  public final void bYr()
  {
    AppMethodBeat.i(113718);
    if (this.oPk != null) {
      this.oPk.setVisibility(8);
    }
    AppMethodBeat.o(113718);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113716);
    this.owO = this.oOB.bWo();
    AppMethodBeat.o(113716);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113717);
    this.owK = this.oOB.bWl();
    if (this.oPk == null) {
      this.oPk = ((ViewStub)findViewById(2131297900)).inflate();
    }
    if (this.owK.bTw()) {
      this.oPk.setBackgroundDrawable(l.P(this.owO, this.owO.getResources().getColor(2131100086)));
    }
    TextView localTextView = (TextView)this.oPk.findViewById(2131297901);
    if (this.owK.bTO() == null)
    {
      ad.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(113717);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.owO.getResources().getColor(2131100469));
    if (!TextUtils.isEmpty(this.owK.bTN().FRW))
    {
      localTextView.setText(this.owK.bTN().FRW);
      AppMethodBeat.o(113717);
      return;
    }
    com.tencent.mm.plugin.card.d.n.h(localTextView, this.owK.bTO().status);
    AppMethodBeat.o(113717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */