package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.plugin.address.d.b;
import java.util.ArrayList;
import java.util.List;

public final class WalletSelectAddrUI$a
  extends BaseAdapter
{
  private final Context context;
  List<b> items = new ArrayList();
  
  public WalletSelectAddrUI$a(WalletSelectAddrUI paramWalletSelectAddrUI, Context paramContext)
  {
    this.context = paramContext;
  }
  
  private b km(int paramInt)
  {
    return (b)this.items.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.items.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = new WalletSelectAddrUI.a.a(this);
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.wallet_addr_select_item, null);
      paramViewGroup.fuO = ((ImageView)paramView.findViewById(R.h.check_state));
      paramViewGroup.fuN = ((TextView)paramView.findViewById(R.h.address_content_tv));
      paramViewGroup.fdt = ((TextView)paramView.findViewById(R.h.address_name_tv));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      b localb = km(paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(localb.ftC)) {
        localStringBuilder.append(localb.ftC);
      }
      if (!TextUtils.isEmpty(localb.ftD))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localb.ftD);
      }
      if (!TextUtils.isEmpty(localb.ftE))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localb.ftE);
      }
      if (!TextUtils.isEmpty(localb.ftG))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(localb.ftG);
      }
      paramViewGroup.fuN.setText(localStringBuilder.toString());
      paramViewGroup.fdt.setText(localb.ftH + "，" + localb.ftI);
      if ((!WalletSelectAddrUI.e(this.fvI)) || (WalletSelectAddrUI.f(this.fvI) == null) || (WalletSelectAddrUI.f(this.fvI).id != localb.id)) {
        break;
      }
      paramViewGroup.fuO.setImageResource(R.k.radio_on);
      return paramView;
      paramViewGroup = (WalletSelectAddrUI.a.a)paramView.getTag();
    }
    paramViewGroup.fuO.setImageBitmap(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.WalletSelectAddrUI.a
 * JD-Core Version:    0.7.0.1
 */