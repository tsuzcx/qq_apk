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
  private View iCR;
  View oDE;
  TextView oDF;
  TextView oDG;
  private boolean oDH = false;
  MMActivity owO;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.owO = paramMMActivity;
    this.iCR = paramView;
  }
  
  public final void bVS()
  {
    AppMethodBeat.i(113139);
    this.oDE.setVisibility(8);
    AppMethodBeat.o(113139);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113140);
    Integer localInteger = (Integer)am.bUS().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.bVt()))
    {
      this.oDE.setVisibility(0);
      this.oDF.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).An(10)))
      {
        this.oDF.setVisibility(0);
        this.oDF.setText(((ShareCardInfo)localObject).An(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.oDG.setVisibility(0);
        this.oDG.setText("");
        AppMethodBeat.o(113140);
        return;
        this.oDF.setVisibility(8);
      }
      this.oDG.setVisibility(8);
      AppMethodBeat.o(113140);
      return;
    }
    this.oDE.setVisibility(8);
    AppMethodBeat.o(113140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */