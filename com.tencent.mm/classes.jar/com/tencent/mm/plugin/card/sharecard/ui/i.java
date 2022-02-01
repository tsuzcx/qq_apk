package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.mgr.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i
{
  private View plc;
  MMActivity wry;
  View wyn;
  TextView wyo;
  TextView wyp;
  private boolean wyq = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.wry = paramMMActivity;
    this.plc = paramView;
  }
  
  public final void dlQ()
  {
    AppMethodBeat.i(113139);
    this.wyn.setVisibility(8);
    AppMethodBeat.o(113139);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(113140);
    Integer localInteger = (Integer)am.dkO().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.dls()))
    {
      this.wyn.setVisibility(0);
      this.wyo.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).Ig(10)))
      {
        this.wyo.setVisibility(0);
        this.wyo.setText(((ShareCardInfo)localObject).Ig(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.wyp.setVisibility(0);
        this.wyp.setText("");
        AppMethodBeat.o(113140);
        return;
        this.wyo.setVisibility(8);
      }
      this.wyp.setVisibility(8);
      AppMethodBeat.o(113140);
      return;
    }
    this.wyn.setVisibility(8);
    AppMethodBeat.o(113140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */