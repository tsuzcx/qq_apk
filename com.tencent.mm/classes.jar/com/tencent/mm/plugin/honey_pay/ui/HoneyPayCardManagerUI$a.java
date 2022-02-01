package com.tencent.mm.plugin.honey_pay.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

final class HoneyPayCardManagerUI$a
  extends BaseAdapter
{
  private HoneyPayCardManagerUI$a(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  private cio Im(int paramInt)
  {
    AppMethodBeat.i(64698);
    cio localcio = (cio)HoneyPayCardManagerUI.j(this.uGB).get(paramInt);
    AppMethodBeat.o(64698);
    return localcio;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64697);
    int i = HoneyPayCardManagerUI.j(this.uGB).size();
    AppMethodBeat.o(64697);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(64700);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.uGB.getContext()).inflate(2131494444, paramViewGroup, false);
      paramView = new HoneyPayCardManagerUI.b(this.uGB, (byte)0);
      paramView.oTF = ((TextView)localView.findViewById(2131300789));
      paramView.uGH = ((WalletTextView)localView.findViewById(2131300787));
      paramView.uGH.setPrefix(ah.fRG());
      paramView.iVT = localView.findViewById(2131300788);
      localView.setTag(paramView);
    }
    paramView = Im(paramInt);
    paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
    paramViewGroup.oTF.setText(paramView.xbO);
    paramViewGroup.uGH.setText(c.xK(paramView.Hcv));
    if (HoneyPayCardManagerUI.j(paramViewGroup.uGB).size() == 1) {
      paramViewGroup.iVT.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(64700);
      return localView;
      paramViewGroup.iVT.setVisibility(0);
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(64699);
    if (!bt.isNullOrNil(Im(paramInt).url))
    {
      AppMethodBeat.o(64699);
      return true;
    }
    AppMethodBeat.o(64699);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.a
 * JD-Core Version:    0.7.0.1
 */