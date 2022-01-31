package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.oz;
import java.util.ArrayList;

final class CardShopUI$a
  extends BaseAdapter
{
  private CardShopUI$a(CardShopUI paramCardShopUI) {}
  
  private oz tm(int paramInt)
  {
    AppMethodBeat.i(88636);
    oz localoz = (oz)CardShopUI.a(this.kxT).get(paramInt);
    AppMethodBeat.o(88636);
    return localoz;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(88635);
    int i = CardShopUI.a(this.kxT).size();
    AppMethodBeat.o(88635);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(88637);
    if (paramView == null)
    {
      paramView = View.inflate(this.kxT.getContext(), 2130968994, null);
      paramViewGroup = new a();
      paramViewGroup.kxU = ((TextView)paramView.findViewById(2131822372));
      paramViewGroup.kxV = ((TextView)paramView.findViewById(2131822373));
      paramViewGroup.kxW = ((TextView)paramView.findViewById(2131822374));
      paramViewGroup.kxX = ((ImageView)paramView.findViewById(2131822376));
      paramViewGroup.kxY = paramView.findViewById(2131822375);
      paramView.setTag(paramViewGroup);
    }
    oz localoz;
    for (;;)
    {
      localoz = tm(paramInt);
      if (localoz != null) {
        break;
      }
      paramViewGroup.kxU.setText("");
      paramViewGroup.kxV.setText("");
      paramViewGroup.kxW.setText("");
      AppMethodBeat.o(88637);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    paramViewGroup.kxU.setText(localoz.name);
    if (localoz.rqZ <= 0.0F) {
      paramViewGroup.kxV.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.kxW.setText(localoz.province + localoz.city + localoz.fBq);
      paramViewGroup.kxY.setOnClickListener(CardShopUI.f(this.kxT));
      paramViewGroup.kxY.setTag(localoz);
      AppMethodBeat.o(88637);
      return paramView;
      paramViewGroup.kxV.setText(l.g(this.kxT.getBaseContext(), localoz.rqZ));
      paramViewGroup.kxV.setVisibility(0);
    }
  }
  
  final class a
  {
    public TextView kxU;
    public TextView kxV;
    public TextView kxW;
    public ImageView kxX;
    public View kxY;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardShopUI.a
 * JD-Core Version:    0.7.0.1
 */