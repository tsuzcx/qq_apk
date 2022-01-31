package com.tencent.mm.plugin.card.ui;

import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.m;
import java.util.LinkedList;

final class CardGiftReceiveUI$a
  extends BaseAdapter
{
  CardGiftReceiveUI$a(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final int getCount()
  {
    AppMethodBeat.i(88423);
    int i = CardGiftReceiveUI.b(this.kvA).knf.size();
    AppMethodBeat.o(88423);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88424);
    CardGiftInfo.AccepterItem localAccepterItem = (CardGiftInfo.AccepterItem)CardGiftReceiveUI.b(this.kvA).knf.get(paramInt);
    ImageView localImageView;
    String str;
    if (paramView == null)
    {
      paramView = View.inflate(this.kvA, 2130968936, null);
      paramViewGroup = new CardGiftReceiveUI.b(this.kvA);
      paramViewGroup.kvC = ((ImageView)paramView.findViewById(2131822127));
      paramViewGroup.khB = ((TextView)paramView.findViewById(2131822128));
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131822129));
      paramViewGroup.kvD = ((TextView)paramView.findViewById(2131822130));
      paramView.setTag(paramViewGroup);
      if (localAccepterItem != null) {
        if (localAccepterItem.knn != null)
        {
          localImageView = paramViewGroup.kvC;
          str = localAccepterItem.knn;
          if ((localImageView != null) && (!TextUtils.isEmpty(str))) {
            break label229;
          }
        }
      }
    }
    for (;;)
    {
      paramViewGroup.khB.setText(localAccepterItem.knm);
      paramViewGroup.gui.setText(localAccepterItem.knk);
      paramViewGroup.kvD.setText(localAccepterItem.knl + this.kvA.getContext().getString(2131297924));
      AppMethodBeat.o(88424);
      return paramView;
      paramViewGroup = (CardGiftReceiveUI.b)paramView.getTag();
      break;
      label229:
      if (!TextUtils.isEmpty(str))
      {
        Object localObject = new c.a();
        ((c.a)localObject).eNP = e.eQz;
        o.ahH();
        ((c.a)localObject).eOd = null;
        ((c.a)localObject).eNO = m.HO(str);
        ((c.a)localObject).eNM = true;
        ((c.a)localObject).eOk = true;
        ((c.a)localObject).eOl = 3.0F;
        ((c.a)localObject).eNK = true;
        ((c.a)localObject).eNT = 34;
        ((c.a)localObject).eNS = 34;
        ((c.a)localObject).eNY = 2130839758;
        localObject = ((c.a)localObject).ahY();
        o.ahG().a(str, localImageView, (c)localObject);
      }
      else
      {
        localImageView.setImageResource(2130839758);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.a
 * JD-Core Version:    0.7.0.1
 */