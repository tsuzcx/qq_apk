package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
  extends i
{
  private View okY;
  
  public final void bTM()
  {
    AppMethodBeat.i(113670);
    if (this.okY != null) {
      this.okY.setVisibility(8);
    }
    AppMethodBeat.o(113670);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113669);
    b localb = this.olg.bRG();
    rn localrn = localb.bPi().EkD;
    if (localrn != null)
    {
      ac.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localrn.xxQ);
      ac.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localrn.text);
      ac.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localrn.EjH);
    }
    if ((localrn != null) && (!TextUtils.isEmpty(localrn.text)) && (localb.bPg()))
    {
      if (this.okY == null) {
        this.okY = ((ViewStub)findViewById(2131297731)).inflate();
      }
      ((TextView)this.okY.findViewById(2131303541)).setText(localrn.text);
      this.okY.setOnClickListener(this.olg.bRK());
      AppMethodBeat.o(113669);
      return;
    }
    if (this.okY != null) {
      this.okY.setVisibility(8);
    }
    AppMethodBeat.o(113669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */