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
  private View iFK;
  MMActivity oDq;
  View oKg;
  TextView oKh;
  TextView oKi;
  private boolean oKj = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.oDq = paramMMActivity;
    this.iFK = paramView;
  }
  
  public final void bXh()
  {
    AppMethodBeat.i(113139);
    this.oKg.setVisibility(8);
    AppMethodBeat.o(113139);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113140);
    Integer localInteger = (Integer)am.bWh().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.bWI()))
    {
      this.oKg.setVisibility(0);
      this.oKh.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).Az(10)))
      {
        this.oKh.setVisibility(0);
        this.oKh.setText(((ShareCardInfo)localObject).Az(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.oKi.setVisibility(0);
        this.oKi.setText("");
        AppMethodBeat.o(113140);
        return;
        this.oKh.setVisibility(8);
      }
      this.oKi.setVisibility(8);
      AppMethodBeat.o(113140);
      return;
    }
    this.oKg.setVisibility(8);
    AppMethodBeat.o(113140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */