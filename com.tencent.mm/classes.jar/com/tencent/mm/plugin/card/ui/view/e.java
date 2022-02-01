package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends i
{
  private View nHY;
  
  public final void bMB()
  {
    AppMethodBeat.i(113670);
    if (this.nHY != null) {
      this.nHY.setVisibility(8);
    }
    AppMethodBeat.o(113670);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113669);
    b localb = this.nIg.bKt();
    rd localrd = localb.bHV().CRS;
    if (localrd != null)
    {
      ad.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localrd.wmA);
      ad.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localrd.text);
      ad.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localrd.CQW);
    }
    if ((localrd != null) && (!TextUtils.isEmpty(localrd.text)) && (localb.bHT()))
    {
      if (this.nHY == null) {
        this.nHY = ((ViewStub)findViewById(2131297731)).inflate();
      }
      ((TextView)this.nHY.findViewById(2131303541)).setText(localrd.text);
      this.nHY.setOnClickListener(this.nIg.bKx());
      AppMethodBeat.o(113669);
      return;
    }
    if (this.nHY != null) {
      this.nHY.setVisibility(8);
    }
    AppMethodBeat.o(113669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */