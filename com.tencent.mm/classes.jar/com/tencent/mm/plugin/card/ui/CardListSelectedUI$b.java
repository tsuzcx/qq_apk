package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

final class CardListSelectedUI$b
  extends BaseAdapter
{
  CardListSelectedUI$b(CardListSelectedUI paramCardListSelectedUI) {}
  
  private a pb(int paramInt)
  {
    return (a)this.ivL.dBw.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.ivL.dBw.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = pb(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.ivL, a.e.card_select_card_invoice_item, null);
      paramViewGroup = new CardListSelectedUI.c(this.ivL);
      paramViewGroup.ivM = ((ImageView)paramView.findViewById(a.d.card_select_img));
      paramViewGroup.ivN = ((TextView)paramView.findViewById(a.d.invoice_status));
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.title));
      paramViewGroup.ivO = ((TextView)paramView.findViewById(a.d.sub_title));
      paramViewGroup.ivP = paramView.findViewById(a.d.v_line);
      paramViewGroup.ivQ = ((TextView)paramView.findViewById(a.d.invoice_title));
      paramViewGroup.ivR = ((TextView)paramView.findViewById(a.d.invoice_item));
      paramView.setTag(paramViewGroup);
      if (!l.oN(locala.ilo)) {
        break label548;
      }
      if (TextUtils.isEmpty(locala.title)) {
        break label386;
      }
      paramViewGroup.fcy.setVisibility(0);
      paramViewGroup.fcy.setText(locala.title);
      label177:
      if (TextUtils.isEmpty(locala.ilq)) {
        break label398;
      }
      paramViewGroup.ivO.setVisibility(0);
      paramViewGroup.ivO.setText(locala.ilq);
      label208:
      if (locala.ilu != 0) {
        break label423;
      }
      paramView.setAlpha(1.0F);
      paramViewGroup.ivM.setVisibility(0);
      paramViewGroup.ivN.setVisibility(8);
      Boolean localBoolean = (Boolean)this.ivL.ivy.get(Integer.valueOf(paramInt));
      if ((localBoolean == null) || (!localBoolean.booleanValue())) {
        break label410;
      }
      paramViewGroup.ivM.setImageResource(a.c.card_add_selected_btn_bg);
      label280:
      if (bk.bl(locala.ilv)) {
        break label514;
      }
      paramViewGroup.ivQ.setVisibility(0);
      paramViewGroup.ivQ.setText(locala.ilv);
      label311:
      if (bk.bl(locala.ilw)) {
        break label526;
      }
      paramViewGroup.ivR.setVisibility(0);
      paramViewGroup.ivR.setText(locala.ilw);
    }
    for (;;)
    {
      if ((!bk.bl(locala.ilv)) || (!bk.bl(locala.ilw))) {
        break label538;
      }
      paramViewGroup.ivP.setVisibility(8);
      return paramView;
      paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
      break;
      label386:
      paramViewGroup.fcy.setVisibility(8);
      break label177;
      label398:
      paramViewGroup.ivO.setVisibility(8);
      break label208;
      label410:
      paramViewGroup.ivM.setImageResource(a.c.card_add_unselected_btn_bg);
      break label280;
      label423:
      if (locala.ilu == 1)
      {
        paramView.setAlpha(0.2F);
        paramViewGroup.ivM.setVisibility(8);
        if (!bk.bl(locala.ilx))
        {
          paramViewGroup.ivN.setVisibility(0);
          paramViewGroup.ivN.setText(locala.ilx);
          break label280;
        }
        paramViewGroup.ivN.setVisibility(8);
        break label280;
      }
      paramViewGroup.ivM.setVisibility(8);
      paramViewGroup.ivN.setVisibility(8);
      break label280;
      label514:
      paramViewGroup.ivQ.setVisibility(8);
      break label311;
      label526:
      paramViewGroup.ivR.setVisibility(8);
    }
    label538:
    paramViewGroup.ivP.setVisibility(0);
    return paramView;
    label548:
    y.i("MicroMsg.CardListSelectedUI", "not support type");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.b
 * JD-Core Version:    0.7.0.1
 */