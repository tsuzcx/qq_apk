package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends i
{
  private View wJk;
  
  public final void doE()
  {
    AppMethodBeat.i(113670);
    if (this.wJk != null) {
      this.wJk.setVisibility(8);
    }
    AppMethodBeat.o(113670);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113669);
    b localb = this.wJs.dmk();
    wh localwh = localb.djK().ZdX;
    if (localwh != null)
    {
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localwh.PzZ);
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localwh.text);
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localwh.mdZ);
    }
    if ((localwh != null) && (!TextUtils.isEmpty(localwh.text)) && (localb.djI()))
    {
      if (this.wJk == null) {
        this.wJk = ((ViewStub)findViewById(a.d.wfp)).inflate();
      }
      ((TextView)this.wJk.findViewById(a.d.wkR)).setText(localwh.text);
      this.wJk.setOnClickListener(this.wJs.dmo());
      AppMethodBeat.o(113669);
      return;
    }
    if (this.wJk != null) {
      this.wJk.setVisibility(8);
    }
    AppMethodBeat.o(113669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */