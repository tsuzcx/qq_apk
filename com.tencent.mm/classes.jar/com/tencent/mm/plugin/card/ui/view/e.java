package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.platformtools.ae;

public final class e
  extends i
{
  private View oUV;
  
  public final void bZG()
  {
    AppMethodBeat.i(113670);
    if (this.oUV != null) {
      this.oUV.setVisibility(8);
    }
    AppMethodBeat.o(113670);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113669);
    b localb = this.oVd.bXA();
    tj localtj = localb.bVc().Gkl;
    if (localtj != null)
    {
      ae.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + localtj.zcL);
      ae.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + localtj.text);
      ae.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + localtj.GfZ);
    }
    if ((localtj != null) && (!TextUtils.isEmpty(localtj.text)) && (localb.bVa()))
    {
      if (this.oUV == null) {
        this.oUV = ((ViewStub)findViewById(2131297731)).inflate();
      }
      ((TextView)this.oUV.findViewById(2131303541)).setText(localtj.text);
      this.oUV.setOnClickListener(this.oVd.bXE());
      AppMethodBeat.o(113669);
      return;
    }
    if (this.oUV != null) {
      this.oUV.setVisibility(8);
    }
    AppMethodBeat.o(113669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */