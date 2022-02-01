package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends i
{
  private View tFL;
  
  public final void cKY()
  {
    AppMethodBeat.i(113670);
    if (this.tFL != null) {
      this.tFL.setVisibility(8);
    }
    AppMethodBeat.o(113670);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113669);
    b localb = this.tFT.cIS();
    uq localuq = localb.cGs().Sgc;
    if (localuq != null)
    {
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localuq.Jnj);
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localuq.text);
      Log.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localuq.jEd);
    }
    if ((localuq != null) && (!TextUtils.isEmpty(localuq.text)) && (localb.cGq()))
    {
      if (this.tFL == null) {
        this.tFL = ((ViewStub)findViewById(a.d.tbf)).inflate();
      }
      ((TextView)this.tFL.findViewById(a.d.tgv)).setText(localuq.text);
      this.tFL.setOnClickListener(this.tFT.cIW());
      AppMethodBeat.o(113669);
      return;
    }
    if (this.tFL != null) {
      this.tFL.setVisibility(8);
    }
    AppMethodBeat.o(113669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */