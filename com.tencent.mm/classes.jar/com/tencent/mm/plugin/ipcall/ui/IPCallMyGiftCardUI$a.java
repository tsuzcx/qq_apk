package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.protocal.c.chn;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;
import junit.framework.Assert;

final class IPCallMyGiftCardUI$a
  extends BaseAdapter
{
  List<chn> kZk = null;
  private IPCallMyGiftCardUI lwP = null;
  amm lwQ = null;
  
  public IPCallMyGiftCardUI$a(IPCallMyGiftCardUI paramIPCallMyGiftCardUI)
  {
    if (paramIPCallMyGiftCardUI != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.lwP = paramIPCallMyGiftCardUI;
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
      paramView = ((LayoutInflater)this.lwP.getSystemService("layout_inflater")).inflate(R.i.ipcall_my_gift_card_item, paramViewGroup, false);
      paramViewGroup = new IPCallMyGiftCardUI.a.a(this, (byte)0);
      paramViewGroup.lwR = ((TextView)paramView.findViewById(R.h.coupon_money_tv));
      paramViewGroup.lwS = ((TextView)paramView.findViewById(R.h.data_wording_tv));
      paramViewGroup.lwT = ((TextView)paramView.findViewById(R.h.expired_wording_tv));
      paramViewGroup.lwU = ((CdnImageView)paramView.findViewById(R.h.header_icon));
      paramViewGroup.lwV = ((ImageView)paramView.findViewById(R.h.default_header_icon));
      paramView.setTag(paramViewGroup);
    }
    chn localchn;
    for (;;)
    {
      localchn = (chn)getItem(paramInt);
      if (localchn != null) {
        break;
      }
      return paramView;
      paramViewGroup = (IPCallMyGiftCardUI.a.a)paramView.getTag();
    }
    if (bk.bl(localchn.tWq))
    {
      paramViewGroup.lwR.setVisibility(0);
      paramViewGroup.lwS.setVisibility(0);
      paramViewGroup.lwT.setVisibility(8);
      paramViewGroup.lwR.setText(localchn.tAh);
      paramViewGroup.lwS.setText(localchn.tWp);
    }
    for (;;)
    {
      a.b.a(paramViewGroup.lwV, "", 0.5F, false);
      if (bk.bl(localchn.kSF)) {
        break;
      }
      paramViewGroup.lwU.setVisibility(0);
      paramViewGroup.lwU.setUrl(localchn.kSF);
      paramViewGroup.lwV.setVisibility(4);
      return paramView;
      paramViewGroup.lwR.setVisibility(8);
      paramViewGroup.lwS.setVisibility(8);
      paramViewGroup.lwT.setVisibility(0);
      paramViewGroup.lwT.setText(localchn.tWq);
    }
    paramViewGroup.lwV.setVisibility(0);
    paramViewGroup.lwU.setVisibility(4);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.a
 * JD-Core Version:    0.7.0.1
 */