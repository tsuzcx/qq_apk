package com.tencent.mm.plugin.card.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

final class CardGiftReceiveUI$c
  extends BaseAdapter
{
  private LinkedList<CardGiftInfo.AcceptedCardItem> iuA;
  
  CardGiftReceiveUI$c(LinkedList<CardGiftInfo.AcceptedCardItem> paramLinkedList)
  {
    Object localObject;
    this.iuA = localObject;
  }
  
  private CardGiftInfo.AcceptedCardItem pa(int paramInt)
  {
    return (CardGiftInfo.AcceptedCardItem)this.iuA.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.iuA.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CardGiftInfo.AcceptedCardItem localAcceptedCardItem = pa(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(this.iuv, a.e.card_gift_accepter_card_item, null);
      paramView = new CardGiftReceiveUI.d(this.iuv);
      paramView.fcy = ((TextView)localView.findViewById(a.d.tv_card_title));
      paramView.iuz = ((TextView)localView.findViewById(a.d.tv_card_price));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.fcy.setText(localAcceptedCardItem.imo);
      paramViewGroup.iuz.setText(localAcceptedCardItem.imp + this.iuv.mController.uMN.getString(a.g.card_gift_price_rmb_uint));
      return localView;
      paramViewGroup = (CardGiftReceiveUI.d)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.c
 * JD-Core Version:    0.7.0.1
 */