package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends i
{
  private View kAZ;
  
  public final void bfq()
  {
    AppMethodBeat.i(88743);
    if (this.kAZ != null) {
      this.kAZ.setVisibility(8);
    }
    AppMethodBeat.o(88743);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(88742);
    b localb = this.kBh.bdv();
    ov localov = localb.bbd().wGn;
    if (localov != null)
    {
      ab.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localov.qNK);
      ab.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localov.text);
      ab.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localov.wFr);
    }
    if ((localov != null) && (!TextUtils.isEmpty(localov.text)) && (localb.bbb()))
    {
      if (this.kAZ == null) {
        this.kAZ = ((ViewStub)findViewById(2131822081)).inflate();
      }
      ((TextView)this.kAZ.findViewById(2131821997)).setText(localov.text);
      this.kAZ.setOnClickListener(this.kBh.bdz());
      AppMethodBeat.o(88742);
      return;
    }
    if (this.kAZ != null) {
      this.kAZ.setVisibility(8);
    }
    AppMethodBeat.o(88742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */