package com.tencent.mm.plugin.card.ui;

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

final class CardListSelectedUI$b
  extends BaseAdapter
{
  CardListSelectedUI$b(CardListSelectedUI paramCardListSelectedUI) {}
  
  private a tl(int paramInt)
  {
    AppMethodBeat.i(88566);
    a locala = (a)this.kwP.eyN.get(paramInt);
    AppMethodBeat.o(88566);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(88565);
    int i = this.kwP.eyN.size();
    AppMethodBeat.o(88565);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88567);
    a locala = tl(paramInt);
    if (paramView == null)
    {
      paramView = View.inflate(this.kwP, 2130968988, null);
      paramViewGroup = new CardListSelectedUI.c(this.kwP);
      paramViewGroup.kwQ = ((ImageView)paramView.findViewById(2131822349));
      paramViewGroup.kwR = ((TextView)paramView.findViewById(2131822350));
      paramViewGroup.gui = ((TextView)paramView.findViewById(2131820680));
      paramViewGroup.kwS = ((TextView)paramView.findViewById(2131821272));
      paramViewGroup.kwT = paramView.findViewById(2131822157);
      paramViewGroup.kwU = ((TextView)paramView.findViewById(2131822351));
      paramViewGroup.kwV = ((TextView)paramView.findViewById(2131822352));
      paramView.setTag(paramViewGroup);
      if (!l.sX(locala.iFL)) {
        break label549;
      }
      if (TextUtils.isEmpty(locala.title)) {
        break label387;
      }
      paramViewGroup.gui.setVisibility(0);
      paramViewGroup.gui.setText(locala.title);
      label174:
      if (TextUtils.isEmpty(locala.kmn)) {
        break label399;
      }
      paramViewGroup.kwS.setVisibility(0);
      paramViewGroup.kwS.setText(locala.kmn);
      label205:
      if (locala.kms != 0) {
        break label423;
      }
      paramView.setAlpha(1.0F);
      paramViewGroup.kwQ.setVisibility(0);
      paramViewGroup.kwR.setVisibility(8);
      Boolean localBoolean = (Boolean)this.kwP.kwC.get(Integer.valueOf(paramInt));
      if ((localBoolean == null) || (!localBoolean.booleanValue())) {
        break label411;
      }
      paramViewGroup.kwQ.setImageResource(2130838096);
      label276:
      if (bo.isNullOrNil(locala.kmt)) {
        break label514;
      }
      paramViewGroup.kwU.setVisibility(0);
      paramViewGroup.kwU.setText(locala.kmt);
      label307:
      if (bo.isNullOrNil(locala.kmu)) {
        break label526;
      }
      paramViewGroup.kwV.setVisibility(0);
      paramViewGroup.kwV.setText(locala.kmu);
      label338:
      if ((!bo.isNullOrNil(locala.kmt)) || (!bo.isNullOrNil(locala.kmu))) {
        break label538;
      }
      paramViewGroup.kwT.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(88567);
      return paramView;
      paramViewGroup = (CardListSelectedUI.c)paramView.getTag();
      break;
      label387:
      paramViewGroup.gui.setVisibility(8);
      break label174;
      label399:
      paramViewGroup.kwS.setVisibility(8);
      break label205;
      label411:
      paramViewGroup.kwQ.setImageResource(2130838097);
      break label276;
      label423:
      if (locala.kms == 1)
      {
        paramView.setAlpha(0.2F);
        paramViewGroup.kwQ.setVisibility(8);
        if (!bo.isNullOrNil(locala.kmv))
        {
          paramViewGroup.kwR.setVisibility(0);
          paramViewGroup.kwR.setText(locala.kmv);
          break label276;
        }
        paramViewGroup.kwR.setVisibility(8);
        break label276;
      }
      paramViewGroup.kwQ.setVisibility(8);
      paramViewGroup.kwR.setVisibility(8);
      break label276;
      label514:
      paramViewGroup.kwU.setVisibility(8);
      break label307;
      label526:
      paramViewGroup.kwV.setVisibility(8);
      break label338;
      label538:
      paramViewGroup.kwT.setVisibility(0);
      continue;
      label549:
      ab.i("MicroMsg.CardListSelectedUI", "not support type");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.b
 * JD-Core Version:    0.7.0.1
 */