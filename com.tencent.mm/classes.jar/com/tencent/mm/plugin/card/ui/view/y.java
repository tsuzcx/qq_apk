package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private b nTp;
  private MMActivity nTt;
  private View olP;
  
  public final void bTM()
  {
    AppMethodBeat.i(113718);
    if (this.olP != null) {
      this.olP.setVisibility(8);
    }
    AppMethodBeat.o(113718);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113716);
    this.nTt = this.olg.bRJ();
    AppMethodBeat.o(113716);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113717);
    this.nTp = this.olg.bRG();
    if (this.olP == null) {
      this.olP = ((ViewStub)findViewById(2131297900)).inflate();
    }
    if (this.nTp.bOR()) {
      this.olP.setBackgroundDrawable(l.O(this.nTt, this.nTt.getResources().getColor(2131100086)));
    }
    TextView localTextView = (TextView)this.olP.findViewById(2131297901);
    if (this.nTp.bPj() == null)
    {
      ac.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(113717);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.nTt.getResources().getColor(2131100469));
    if (!TextUtils.isEmpty(this.nTp.bPi().EkN))
    {
      localTextView.setText(this.nTp.bPi().EkN);
      AppMethodBeat.o(113717);
      return;
    }
    com.tencent.mm.plugin.card.d.n.h(localTextView, this.nTp.bPj().status);
    AppMethodBeat.o(113717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */