package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends i
{
  private View qjP;
  
  public final void cxw()
  {
    AppMethodBeat.i(113670);
    if (this.qjP != null) {
      this.qjP.setVisibility(8);
    }
    AppMethodBeat.o(113670);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113669);
    b localb = this.qjX.cvq();
    uo localuo = localb.csQ().LeO;
    if (localuo != null)
    {
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localuo.DhD);
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localuo.text);
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localuo.gTB);
    }
    if ((localuo != null) && (!TextUtils.isEmpty(localuo.text)) && (localb.csO()))
    {
      if (this.qjP == null) {
        this.qjP = ((ViewStub)findViewById(2131298035)).inflate();
      }
      ((TextView)this.qjP.findViewById(2131306312)).setText(localuo.text);
      this.qjP.setOnClickListener(this.qjX.cvu());
      AppMethodBeat.o(113669);
      return;
    }
    if (this.qjP != null) {
      this.qjP.setVisibility(8);
    }
    AppMethodBeat.o(113669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */