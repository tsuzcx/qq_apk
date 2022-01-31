package com.tencent.mm.plugin.card.sharecard.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.ui.MMActivity;

public final class i
{
  MMActivity hxN;
  private View ipf;
  View iqJ;
  TextView iqK;
  TextView iqL;
  private boolean iqM = false;
  
  public i(MMActivity paramMMActivity, View paramView)
  {
    this.hxN = paramMMActivity;
    this.ipf = paramView;
  }
  
  public final void aZ()
  {
    Integer localInteger = (Integer)am.aAx().getValue("key_share_card_show_type");
    Object localObject = localInteger;
    if (localInteger == null) {
      localObject = Integer.valueOf(0);
    }
    if ((((Integer)localObject).intValue() != 0) && (!b.aAS()))
    {
      this.iqJ.setVisibility(0);
      this.iqK.setVisibility(0);
      localObject = new ShareCardInfo();
      if (!TextUtils.isEmpty(((ShareCardInfo)localObject).oL(10)))
      {
        this.iqK.setVisibility(0);
        this.iqK.setText(((ShareCardInfo)localObject).oL(10));
      }
      while (!TextUtils.isEmpty(""))
      {
        this.iqL.setVisibility(0);
        this.iqL.setText("");
        return;
        this.iqK.setVisibility(8);
      }
      this.iqL.setVisibility(8);
      return;
    }
    this.iqJ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.i
 * JD-Core Version:    0.7.0.1
 */