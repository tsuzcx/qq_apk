package com.tencent.mm.plugin.honey_pay.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

final class HoneyPayCardManagerUI$a
  extends BaseAdapter
{
  private HoneyPayCardManagerUI$a(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  private bkt xs(int paramInt)
  {
    AppMethodBeat.i(41807);
    bkt localbkt = (bkt)HoneyPayCardManagerUI.j(this.nIw).get(paramInt);
    AppMethodBeat.o(41807);
    return localbkt;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(41806);
    int i = HoneyPayCardManagerUI.j(this.nIw).size();
    AppMethodBeat.o(41806);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(41809);
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.nIw.getContext()).inflate(2130969867, paramViewGroup, false);
      paramView = new HoneyPayCardManagerUI.b(this.nIw, (byte)0);
      paramView.kGe = ((TextView)localView.findViewById(2131825026));
      paramView.nIC = ((WalletTextView)localView.findViewById(2131825027));
      paramView.nIC.setPrefix(ae.dSz());
      localView.setTag(paramView);
    }
    paramView = xs(paramInt);
    paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
    paramViewGroup.kGe.setText(paramView.qFq);
    paramViewGroup.nIC.setText(c.kn(paramView.xzu));
    AppMethodBeat.o(41809);
    return localView;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(41808);
    if (!bo.isNullOrNil(xs(paramInt).url))
    {
      AppMethodBeat.o(41808);
      return true;
    }
    AppMethodBeat.o(41808);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.a
 * JD-Core Version:    0.7.0.1
 */