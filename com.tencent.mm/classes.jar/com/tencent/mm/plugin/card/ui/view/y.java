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
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class y
  extends i
{
  private View wKb;
  private b wru;
  private MMActivity wry;
  
  public final void doE()
  {
    AppMethodBeat.i(113718);
    if (this.wKb != null) {
      this.wKb.setVisibility(8);
    }
    AppMethodBeat.o(113718);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(113716);
    this.wry = this.wJs.dmn();
    AppMethodBeat.o(113716);
  }
  
  public final void update()
  {
    AppMethodBeat.i(113717);
    this.wru = this.wJs.dmk();
    if (this.wKb == null) {
      this.wKb = ((ViewStub)findViewById(a.d.whM)).inflate();
    }
    if (this.wru.djs()) {
      this.wKb.setBackgroundDrawable(l.ag(this.wry, this.wry.getResources().getColor(a.a.wdD)));
    }
    TextView localTextView = (TextView)this.wKb.findViewById(a.d.whN);
    if (this.wru.djL() == null)
    {
      Log.e("MicroMsg.CardStatusView", "updateState() mCardInfo.getDataInfo() == null");
      localTextView.setVisibility(8);
      AppMethodBeat.o(113717);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setTextColor(this.wry.getResources().getColor(a.a.grey_background_text_color));
    if (!TextUtils.isEmpty(this.wru.djK().Zeh))
    {
      localTextView.setText(this.wru.djK().Zeh);
      AppMethodBeat.o(113717);
      return;
    }
    com.tencent.mm.plugin.card.c.n.i(localTextView, this.wru.djL().status);
    AppMethodBeat.o(113717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.y
 * JD-Core Version:    0.7.0.1
 */