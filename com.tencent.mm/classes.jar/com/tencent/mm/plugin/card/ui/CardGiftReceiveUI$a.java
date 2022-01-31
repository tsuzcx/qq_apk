package com.tencent.mm.plugin.card.ui;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

final class CardGiftReceiveUI$a
  extends BaseAdapter
{
  CardGiftReceiveUI$a(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final int getCount()
  {
    return CardGiftReceiveUI.b(this.iuv).imj.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.b(this.iuv).imj.get(paramInt);
    ImageView localImageView;
    String str;
    if (paramView == null)
    {
      paramView = View.inflate(this.iuv, a.e.card_gift_accepter_item, null);
      paramViewGroup = new CardGiftReceiveUI.b(this.iuv);
      paramViewGroup.iux = ((ImageView)paramView.findViewById(a.d.img_accepter_headimg));
      paramViewGroup.iuy = ((TextView)paramView.findViewById(a.d.tv_accepter_nickName));
      paramViewGroup.fcy = ((TextView)paramView.findViewById(a.d.tv_accepter_title));
      paramViewGroup.iuz = ((TextView)paramView.findViewById(a.d.tv_accepter_price));
      paramView.setTag(paramViewGroup);
      if (localAccepterItem != null) {
        if (localAccepterItem.imr != null)
        {
          localImageView = paramViewGroup.iux;
          str = localAccepterItem.imr;
          paramInt = a.c.my_card_package_defaultlogo;
          if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
            break label232;
          }
        }
      }
    }
    for (;;)
    {
      paramViewGroup.iuy.setText(localAccepterItem.imq);
      paramViewGroup.fcy.setText(localAccepterItem.imo);
      paramViewGroup.iuz.setText(localAccepterItem.imp + this.iuv.mController.uMN.getString(a.g.card_gift_price_rmb_uint));
      return paramView;
      paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
      break;
      label232:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = new c.a();
        ((c.a)localObject).eri = e.bkH;
        o.OO();
        ((c.a)localObject).erB = null;
        ((c.a)localObject).erh = m.yn(str);
        ((c.a)localObject).erf = true;
        ((c.a)localObject).erD = true;
        ((c.a)localObject).erE = 3.0F;
        ((c.a)localObject).erd = true;
        ((c.a)localObject).erm = 34;
        ((c.a)localObject).erl = 34;
        ((c.a)localObject).eru = paramInt;
        localObject = ((c.a)localObject).OV();
        o.ON().a(str, localImageView, (c)localObject);
      }
      else
      {
        localImageView.setImageResource(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.a
 * JD-Core Version:    0.7.0.1
 */