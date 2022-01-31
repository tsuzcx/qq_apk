package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

final class CardListSelectedUI$a
  extends BaseAdapter
{
  CardListSelectedUI$a(CardListSelectedUI paramCardListSelectedUI) {}
  
  private a tl(int paramInt)
  {
    AppMethodBeat.i(88562);
    a locala = (a)this.kwP.eyN.get(paramInt);
    AppMethodBeat.o(88562);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(88561);
    int i = this.kwP.eyN.size();
    AppMethodBeat.o(88561);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88563);
    Object localObject = tl(paramInt);
    label186:
    label217:
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.kwP, 2130968989, null);
      paramViewGroup = new CardListSelectedUI.d(this.kwP);
      paramViewGroup.kwW = ((ImageView)paramView.findViewById(2131822294));
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131820680));
      paramViewGroup.kwS = ((TextView)paramView.findViewById(2131821272));
      paramViewGroup.kwX = ((TextView)paramView.findViewById(2131822353));
      paramViewGroup.jTb = ((TextView)paramView.findViewById(2131821732));
      paramViewGroup.kwY = paramView.findViewById(2131821247);
      paramViewGroup.kwZ = ((ImageView)paramView.findViewById(2131822349));
      paramView.setTag(paramViewGroup);
      if (!l.sX(((a)localObject).iFL)) {
        break label389;
      }
      paramViewGroup.gui.setText(((a)localObject).kmn);
      if (TextUtils.isEmpty(((a)localObject).title)) {
        break label347;
      }
      paramViewGroup.kwS.setVisibility(0);
      paramViewGroup.kwS.setText(((a)localObject).title);
      if (TextUtils.isEmpty(((a)localObject).kmo)) {
        break label359;
      }
      paramViewGroup.kwX.setVisibility(0);
      paramViewGroup.kwX.setText(((a)localObject).kmo);
      TextView localTextView = paramViewGroup.jTb;
      if (!bo.isNullOrNil(((a)localObject).jTi)) {
        break label371;
      }
      i = 8;
      label238:
      localTextView.setVisibility(i);
      paramViewGroup.jTb.setText(((a)localObject).jTi);
      i = this.kwP.getBaseContext().getResources().getDimensionPixelSize(2131428197);
      CardListSelectedUI.a(paramViewGroup.kwW, ((a)localObject).kmm, i);
      localObject = (Boolean)this.kwP.kwC.get(Integer.valueOf(paramInt));
      if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
        break label377;
      }
      paramViewGroup.kwZ.setImageResource(2130838096);
    }
    for (;;)
    {
      AppMethodBeat.o(88563);
      return paramView;
      paramViewGroup = (CardListSelectedUI.d)paramView.getTag();
      break;
      label347:
      paramViewGroup.kwS.setVisibility(8);
      break label186;
      label359:
      paramViewGroup.kwX.setVisibility(8);
      break label217;
      label371:
      i = 0;
      break label238;
      label377:
      paramViewGroup.kwZ.setImageResource(2130838097);
      continue;
      label389:
      ab.i("MicroMsg.CardListSelectedUI", "not support type");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.a
 * JD-Core Version:    0.7.0.1
 */