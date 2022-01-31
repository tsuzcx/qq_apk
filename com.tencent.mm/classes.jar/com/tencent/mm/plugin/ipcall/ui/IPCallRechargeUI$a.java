package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.protocal.c.amq;
import com.tencent.mm.protocal.c.chl;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import junit.framework.Assert;

final class IPCallRechargeUI$a
  extends BaseAdapter
{
  List<chl> kZk = null;
  private IPCallRechargeUI lxL = null;
  amq lxM = null;
  
  public IPCallRechargeUI$a(IPCallRechargeUI paramIPCallRechargeUI)
  {
    if (paramIPCallRechargeUI != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.lxL = paramIPCallRechargeUI;
      return;
    }
  }
  
  public final int getCount()
  {
    if (this.kZk == null) {
      return 0;
    }
    return this.kZk.size();
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.kZk != null) {
      return this.kZk.get(paramInt);
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = ((LayoutInflater)this.lxL.getSystemService("layout_inflater")).inflate(R.i.ipcall_recharge_price_item, paramViewGroup, false);
      paramViewGroup = new IPCallRechargeUI.a.a(this, (byte)0);
      paramViewGroup.lwR = ((TextView)paramView.findViewById(R.h.tvPrice));
      paramViewGroup.lxO = ((TextView)paramView.findViewById(R.h.tvCurrency));
      paramViewGroup.lxP = ((TextView)paramView.findViewById(R.h.tvCoupon));
      paramViewGroup.lxQ = ((TextView)paramView.findViewById(R.h.tvCallTime));
      paramViewGroup.lxR = ((Button)paramView.findViewById(R.h.btnBuy));
      paramView.setTag(paramViewGroup);
    }
    chl localchl;
    for (;;)
    {
      localchl = (chl)getItem(paramInt);
      if (localchl != null) {
        break;
      }
      return paramView;
      paramViewGroup = (IPCallRechargeUI.a.a)paramView.getTag();
    }
    paramViewGroup.lwR.setText(localchl.tAh);
    paramViewGroup.lxO.setText(localchl.tWl);
    paramViewGroup.lxP.setText(localchl.tWm);
    if (bk.bl(localchl.tWm)) {
      paramViewGroup.lxP.setVisibility(8);
    }
    for (;;)
    {
      if (this.lxM != null) {
        paramViewGroup.lxQ.setText(String.format(this.lxL.getString(R.l.ip_call_recharge_price_time_tip), new Object[] { a.FX(this.lxM.tiu), String.valueOf(localchl.tWj) }));
      }
      paramViewGroup.lxR.setTag(Integer.valueOf(paramInt));
      paramViewGroup.lxR.setOnClickListener(new IPCallRechargeUI.a.1(this));
      return paramView;
      paramViewGroup.lxP.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallRechargeUI.a
 * JD-Core Version:    0.7.0.1
 */