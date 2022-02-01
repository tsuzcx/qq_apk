package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private View tGC;
  private b tmU;
  private MMActivity tmY;
  
  public final void cKY()
  {
    AppMethodBeat.i(113718);
    if (this.tGC != null) {
      this.tGC.setVisibility(8);
    }
    AppMethodBeat.o(113718);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113716);
    this.tmY = this.tFT.cIV();
    AppMethodBeat.o(113716);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113717);
    this.tmU = this.tFT.cIS();
    if (this.tGC == null) {
      this.tGC = ((ViewStub)findViewById(a.d.tdy)).inflate();
    }
    if (this.tmU.cGa()) {
      this.tGC.setBackgroundDrawable(l.Z(this.tmY, this.tmY.getResources().getColor(a.a.sZu)));
    }
    TextView localTextView = (TextView)this.tGC.findViewById(a.d.tdz);
    if (this.tmU.cGt() == null)
    {
      Log.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(113717);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.tmY.getResources().getColor(a.a.grey_background_text_color));
    if (!TextUtils.isEmpty(this.tmU.cGs().Sgm))
    {
      localTextView.setText(this.tmU.cGs().Sgm);
      AppMethodBeat.o(113717);
      return;
    }
    com.tencent.mm.plugin.card.d.n.h(localTextView, this.tmU.cGt().status);
    AppMethodBeat.o(113717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */