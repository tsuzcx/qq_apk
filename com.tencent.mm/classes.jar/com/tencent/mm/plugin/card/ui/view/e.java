package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends i
{
  private View ixS;
  
  public final void aCU()
  {
    if (this.ixS != null) {
      this.ixS.setVisibility(8);
    }
  }
  
  public final void initView() {}
  
  public final void update()
  {
    b localb = this.iya.aBE();
    ly locally = localb.azx().sIE;
    if (locally != null)
    {
      y.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + locally.nZA);
      y.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + locally.text);
      y.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + locally.sHO);
    }
    if ((locally != null) && (!TextUtils.isEmpty(locally.text)) && (localb.azv()))
    {
      if (this.ixS == null) {
        this.ixS = ((ViewStub)findViewById(a.d.card_annoucement_layout_stub)).inflate();
      }
      ((TextView)this.ixS.findViewById(a.d.public_notice)).setText(locally.text);
      this.ixS.setOnClickListener(this.iya.aBI());
    }
    while (this.ixS == null) {
      return;
    }
    this.ixS.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.e
 * JD-Core Version:    0.7.0.1
 */