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
  private View hIZ;
  MMActivity nqt;
  View nxk;
  TextView nxl;
  TextView nxm;
  private boolean nxn = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.nqt = paramMMActivity;
    this.hIZ = paramView;
  }
  
  public final void bKa()
  {
    AppMethodBeat.i(113139);
    this.nxk.setVisibility(8);
    AppMethodBeat.o(113139);
  }
  
  public final void cE()
  {
    AppMethodBeat.i(113140);
    Integer localInteger = (Integer)am.bJa().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.bJB()))
    {
      this.nxk.setVisibility(0);
      this.nxl.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).yO(10)))
      {
        this.nxl.setVisibility(0);
        this.nxl.setText(((ShareCardInfo)localObject).yO(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.nxm.setVisibility(0);
        this.nxm.setText("");
        AppMethodBeat.o(113140);
        return;
        this.nxl.setVisibility(8);
      }
      this.nxm.setVisibility(8);
      AppMethodBeat.o(113140);
      return;
    }
    this.nxk.setVisibility(8);
    AppMethodBeat.o(113140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */