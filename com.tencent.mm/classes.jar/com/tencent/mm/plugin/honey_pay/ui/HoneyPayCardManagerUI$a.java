package com.tencent.mm.plugin.honey_pay.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.protocal.c.bda;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.util.List;

final class HoneyPayCardManagerUI$a
  extends BaseAdapter
{
  private HoneyPayCardManagerUI$a(HoneyPayCardManagerUI paramHoneyPayCardManagerUI) {}
  
  private bda ss(int paramInt)
  {
    return (bda)HoneyPayCardManagerUI.i(this.lla).get(paramInt);
  }
  
  public final int getCount()
  {
    return HoneyPayCardManagerUI.i(this.lla).size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.lla.mController.uMN).inflate(a.g.honey_pay_card_setting_item_layout, paramViewGroup, false);
      paramView = new HoneyPayCardManagerUI.b(this.lla, (byte)0);
      paramView.iJR = ((TextView)localView.findViewById(a.f.hpci_date_tv));
      paramView.llg = ((WalletTextView)localView.findViewById(a.f.hpci_amt_tv));
      paramView.llg.setPrefix(ab.cML());
      localView.setTag(paramView);
    }
    paramView = ss(paramInt);
    paramViewGroup = (HoneyPayCardManagerUI.b)localView.getTag();
    paramViewGroup.iJR.setText(paramView.nRs);
    paramViewGroup.llg.setText(c.eR(paramView.tyr));
    return localView;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return !bk.bl(ss(paramInt).url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.a
 * JD-Core Version:    0.7.0.1
 */