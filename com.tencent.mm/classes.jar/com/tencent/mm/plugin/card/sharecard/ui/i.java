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
  private View iCk;
  MMActivity jpX;
  View krR;
  TextView krS;
  TextView krT;
  private boolean krU = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.jpX = paramMMActivity;
    this.iCk = paramView;
  }
  
  public final void bJ()
  {
    AppMethodBeat.i(88206);
    Integer localInteger = (Integer)am.bci().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.bcD()))
    {
      this.krR.setVisibility(0);
      this.krS.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).sV(10)))
      {
        this.krS.setVisibility(0);
        this.krS.setText(((ShareCardInfo)localObject).sV(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.krT.setVisibility(0);
        this.krT.setText("");
        AppMethodBeat.o(88206);
        return;
        this.krS.setVisibility(8);
      }
      this.krT.setVisibility(8);
      AppMethodBeat.o(88206);
      return;
    }
    this.krR.setVisibility(8);
    AppMethodBeat.o(88206);
  }
  
  public final void bdc()
  {
    AppMethodBeat.i(88205);
    this.krR.setVisibility(8);
    AppMethodBeat.o(88205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */