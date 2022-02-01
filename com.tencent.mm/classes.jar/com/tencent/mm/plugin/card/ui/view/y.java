package com.tencent.mm.plugin.card.ui.view;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private b pQV;
  private MMActivity pQZ;
  private View qkG;
  
  public final void cxw()
  {
    AppMethodBeat.i(113718);
    if (this.qkG != null) {
      this.qkG.setVisibility(8);
    }
    AppMethodBeat.o(113718);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113716);
    this.pQZ = this.qjX.cvt();
    AppMethodBeat.o(113716);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113717);
    this.pQV = this.qjX.cvq();
    if (this.qkG == null) {
      this.qkG = ((ViewStub)findViewById(2131298218)).inflate();
    }
    if (this.pQV.csz()) {
      this.qkG.setBackgroundDrawable(l.U(this.pQZ, this.pQZ.getResources().getColor(2131100117)));
    }
    TextView localTextView = (TextView)this.qkG.findViewById(2131298219);
    if (this.pQV.csR() == null)
    {
      Log.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(113717);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.pQZ.getResources().getColor(2131100571));
    if (!TextUtils.isEmpty(this.pQV.csQ().LeY))
    {
      localTextView.setText(this.pQV.csQ().LeY);
      AppMethodBeat.o(113717);
      return;
    }
    com.tencent.mm.plugin.card.d.n.h(localTextView, this.pQV.csR().status);
    AppMethodBeat.o(113717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */