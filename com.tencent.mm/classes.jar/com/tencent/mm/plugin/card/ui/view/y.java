package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private b oDm;
  private MMActivity oDq;
  private View oVM;
  
  public final void bZG()
  {
    AppMethodBeat.i(113718);
    if (this.oVM != null) {
      this.oVM.setVisibility(8);
    }
    AppMethodBeat.o(113718);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113716);
    this.oDq = this.oVd.bXD();
    AppMethodBeat.o(113716);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113717);
    this.oDm = this.oVd.bXA();
    if (this.oVM == null) {
      this.oVM = ((ViewStub)findViewById(2131297900)).inflate();
    }
    if (this.oDm.bUL()) {
      this.oVM.setBackgroundDrawable(l.P(this.oDq, this.oDq.getResources().getColor(2131100086)));
    }
    TextView localTextView = (TextView)this.oVM.findViewById(2131297901);
    if (this.oDm.bVd() == null)
    {
      ae.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(113717);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.oDq.getResources().getColor(2131100469));
    if (!TextUtils.isEmpty(this.oDm.bVc().Gkv))
    {
      localTextView.setText(this.oDm.bVc().Gkv);
      AppMethodBeat.o(113717);
      return;
    }
    com.tencent.mm.plugin.card.d.n.h(localTextView, this.oDm.bVd().status);
    AppMethodBeat.o(113717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */