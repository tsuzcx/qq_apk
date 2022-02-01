package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i
{
  private View mrI;
  MMActivity tmY;
  View ttQ;
  TextView ttR;
  TextView ttS;
  private boolean ttT = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.tmY = paramMMActivity;
    this.mrI = paramView;
  }
  
  public final void cIz()
  {
    AppMethodBeat.i(113139);
    this.ttQ.setVisibility(8);
    AppMethodBeat.o(113139);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113140);
    Integer localInteger = (Integer)am.cHx().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.cIb()))
    {
      this.ttQ.setVisibility(0);
      this.ttR.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).HF(10)))
      {
        this.ttR.setVisibility(0);
        this.ttR.setText(((ShareCardInfo)localObject).HF(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.ttS.setVisibility(0);
        this.ttS.setText("");
        AppMethodBeat.o(113140);
        return;
        this.ttR.setVisibility(8);
      }
      this.ttS.setVisibility(8);
      AppMethodBeat.o(113140);
      return;
    }
    this.ttQ.setVisibility(8);
    AppMethodBeat.o(113140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */