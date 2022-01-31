package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;

final class CardShopUI$a
  extends BaseAdapter
{
  private CardShopUI$a(CardShopUI paramCardShopUI) {}
  
  private mb pc(int paramInt)
  {
    return (mb)CardShopUI.a(this.iwP).get(paramInt);
  }
  
  public final int getCount()
  {
    return CardShopUI.a(this.iwP).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.iwP.mController.uMN, a.e.card_shop_item, null);
      paramViewGroup = new a();
      paramViewGroup.iwQ = ((TextView)paramView.findViewById(a.d.shop_name_tv));
      paramViewGroup.iwR = ((TextView)paramView.findViewById(a.d.shop_distance_tv));
      paramViewGroup.iwS = ((TextView)paramView.findViewById(a.d.shop_address_tv));
      paramViewGroup.iwT = ((ImageView)paramView.findViewById(a.d.shop_poi));
      paramViewGroup.iwU = paramView.findViewById(a.d.shop_poi_layout);
      paramView.setTag(paramViewGroup);
    }
    mb localmb;
    for (;;)
    {
      localmb = pc(paramInt);
      if (localmb != null) {
        break;
      }
      paramViewGroup.iwQ.setText("");
      paramViewGroup.iwR.setText("");
      paramViewGroup.iwS.setText("");
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.iwQ.setText(localmb.name);
    if (localmb.sIe <= 0.0F) {
      paramViewGroup.iwR.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.iwS.setText(localmb.cCA + localmb.cCB + localmb.ekZ);
      paramViewGroup.iwU.setOnClickListener(CardShopUI.f(this.iwP));
      paramViewGroup.iwU.setTag(localmb);
      return paramView;
      paramViewGroup.iwR.setText(l.f(this.iwP.getBaseContext(), localmb.sIe));
      paramViewGroup.iwR.setVisibility(0);
    }
  }
  
  final class a
  {
    public TextView iwQ;
    public TextView iwR;
    public TextView iwS;
    public ImageView iwT;
    public View iwU;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI.a
 * JD-Core Version:    0.7.0.1
 */