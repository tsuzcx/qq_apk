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
  private View ijA;
  MMActivity nTt;
  View oak;
  TextView oal;
  TextView oam;
  private boolean oan = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.nTt = paramMMActivity;
    this.ijA = paramView;
  }
  
  public final void bRn()
  {
    AppMethodBeat.i(113139);
    this.oak.setVisibility(8);
    AppMethodBeat.o(113139);
  }
  
  public final void cL()
  {
    AppMethodBeat.i(113140);
    Integer localInteger = (Integer)am.bQn().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.bQO()))
    {
      this.oak.setVisibility(0);
      this.oal.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).zE(10)))
      {
        this.oal.setVisibility(0);
        this.oal.setText(((ShareCardInfo)localObject).zE(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.oam.setVisibility(0);
        this.oam.setText("");
        AppMethodBeat.o(113140);
        return;
        this.oal.setVisibility(8);
      }
      this.oam.setVisibility(8);
      AppMethodBeat.o(113140);
      return;
    }
    this.oak.setVisibility(8);
    AppMethodBeat.o(113140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */