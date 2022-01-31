package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

final class CardListSelectedUI$a
  extends BaseAdapter
{
  CardListSelectedUI$a(CardListSelectedUI paramCardListSelectedUI) {}
  
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
    Object localObject = pb(paramInt);
    label189:
    label220:
    TextView localTextView;
    if (paramView == null)
    {
      paramView = View.inflate(this.ivL, a.e.card_select_card_item, null);
      paramViewGroup = new CardListSelectedUI.d(this.ivL);
      paramViewGroup.ivS = ((ImageView)paramView.findViewById(a.d.logo));
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.title));
      paramViewGroup.ivO = ((TextView)paramView.findViewById(a.d.sub_title));
      paramViewGroup.ivT = ((TextView)paramView.findViewById(a.d.aux_title));
      paramViewGroup.icl = ((TextView)paramView.findViewById(a.d.catalogTV));
      paramViewGroup.ivU = paramView.findViewById(a.d.body_layout);
      paramViewGroup.ivV = ((ImageView)paramView.findViewById(a.d.card_select_img));
      paramView.setTag(paramViewGroup);
      if (!l.oN(((a)localObject).ilo)) {
        break label389;
      }
      paramViewGroup.fcy.setText(((a)localObject).ilq);
      if (TextUtils.isEmpty(((a)localObject).title)) {
        break label347;
      }
      paramViewGroup.ivO.setVisibility(0);
      paramViewGroup.ivO.setText(((a)localObject).title);
      if (TextUtils.isEmpty(((a)localObject).ilr)) {
        break label359;
      }
      paramViewGroup.ivT.setVisibility(0);
      paramViewGroup.ivT.setText(((a)localObject).ilr);
      localTextView = paramViewGroup.icl;
      if (!bk.bl(((a)localObject).ics)) {
        break label371;
      }
    }
    label347:
    label359:
    label371:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      paramViewGroup.icl.setText(((a)localObject).ics);
      i = this.ivL.getBaseContext().getResources().getDimensionPixelSize(a.b.card_select_list_item_logo_height);
      CardListSelectedUI.a(paramViewGroup.ivS, ((a)localObject).ilp, i);
      localObject = (Boolean)this.ivL.ivy.get(Integer.valueOf(paramInt));
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label377;
      }
      paramViewGroup.ivV.setImageResource(a.c.card_add_selected_btn_bg);
      return paramView;
      paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
      break;
      paramViewGroup.ivO.setVisibility(8);
      break label189;
      paramViewGroup.ivT.setVisibility(8);
      break label220;
    }
    label377:
    paramViewGroup.ivV.setImageResource(a.c.card_add_unselected_btn_bg);
    return paramView;
    label389:
    y.i("MicroMsg.CardListSelectedUI", "not support type");
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.a
 * JD-Core Version:    0.7.0.1
 */