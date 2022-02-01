package com.tencent.mm.plugin.honey_pay.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.protocal.protobuf.czq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

final class HoneyPayCardManagerUI$a
  extends BaseAdapter
{
  private HoneyPayCardManagerUI$a(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  private czq ON(int paramInt)
  {
    AppMethodBeat.i(64698);
    czq localczq = (czq)HoneyPayCardManagerUI.j(this.ykR).get(paramInt);
    AppMethodBeat.o(64698);
    return localczq;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(64697);
    int i = HoneyPayCardManagerUI.j(this.ykR).size();
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
      localView = LayoutInflater.from(this.ykR.getContext()).inflate(2131495022, paramViewGroup, false);
      paramView = new HoneyPayCardManagerUI.b(this.ykR, (byte)0);
      paramView.qpf = ((TextView)localView.findViewById(2131302383));
      paramView.ykX = ((WalletTextView)localView.findViewById(2131302381));
      paramView.ykX.setPrefix(ah.hhz());
      paramView.jWr = localView.findViewById(2131302382);
      localView.setTag(paramView);
    }
    paramView = ON(paramInt);
    paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
    paramViewGroup.qpf.setText(paramView.BrH);
    paramViewGroup.ykX.setText(c.GO(paramView.MEU));
    if (HoneyPayCardManagerUI.j(paramViewGroup.ykR).size() == 1) {
      paramViewGroup.jWr.setVisibility(8);
    }
    for (;;)
    {
      AppMethodBeat.o(64700);
      return localView;
      paramViewGroup.jWr.setVisibility(0);
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(64699);
    if (!Util.isNullOrNil(ON(paramInt).url))
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