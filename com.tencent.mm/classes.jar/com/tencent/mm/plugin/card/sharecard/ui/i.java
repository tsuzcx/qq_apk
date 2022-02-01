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
  private View jBN;
  MMActivity pQZ;
  View pXU;
  TextView pXV;
  TextView pXW;
  private boolean pXX = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.pQZ = paramMMActivity;
    this.jBN = paramView;
  }
  
  public final void cuX()
  {
    AppMethodBeat.i(113139);
    this.pXU.setVisibility(8);
    AppMethodBeat.o(113139);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113140);
    Integer localInteger = (Integer)am.ctV().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.cuz()))
    {
      this.pXU.setVisibility(0);
      this.pXV.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).Ee(10)))
      {
        this.pXV.setVisibility(0);
        this.pXV.setText(((ShareCardInfo)localObject).Ee(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.pXW.setVisibility(0);
        this.pXW.setText("");
        AppMethodBeat.o(113140);
        return;
        this.pXV.setVisibility(8);
      }
      this.pXW.setVisibility(8);
      AppMethodBeat.o(113140);
      return;
    }
    this.pXU.setVisibility(8);
    AppMethodBeat.o(113140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */