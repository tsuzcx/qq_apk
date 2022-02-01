package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
  extends i
{
  private View oOt;
  
  public final void bYr()
  {
    AppMethodBeat.i(113670);
    if (this.oOt != null) {
      this.oOt.setVisibility(8);
    }
    AppMethodBeat.o(113670);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113669);
    b localb = this.oOB.bWl();
    th localth = localb.bTN().FRM;
    if (localth != null)
    {
      ad.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localth.yMB);
      ad.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localth.text);
      ad.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localth.FNA);
    }
    if ((localth != null) && (!TextUtils.isEmpty(localth.text)) && (localb.bTL()))
    {
      if (this.oOt == null) {
        this.oOt = ((ViewStub)findViewById(2131297731)).inflate();
      }
      ((TextView)this.oOt.findViewById(2131303541)).setText(localth.text);
      this.oOt.setOnClickListener(this.oOB.bWp());
      AppMethodBeat.o(113669);
      return;
    }
    if (this.oOt != null) {
      this.oOt.setVisibility(8);
    }
    AppMethodBeat.o(113669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */