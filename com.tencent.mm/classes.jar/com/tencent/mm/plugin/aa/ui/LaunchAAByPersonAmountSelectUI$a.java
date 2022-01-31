package com.tencent.mm.plugin.aa.ui;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class LaunchAAByPersonAmountSelectUI$a
  extends BaseAdapter
{
  List<LaunchAAByPersonAmountSelectUI.b> dataList = null;
  
  public LaunchAAByPersonAmountSelectUI$a(List<String> paramList, Map<String, Double> paramMap)
  {
    paramMap = paramMap.iterator();
    if (paramMap.hasNext())
    {
      String str = (String)paramMap.next();
      LaunchAAByPersonAmountSelectUI.b localb = new LaunchAAByPersonAmountSelectUI.b(paramList, (byte)0);
      localb.username = str;
      Object localObject;
      if ((localObject != null) && (localObject.containsKey(str))) {}
      for (localb.eYN = paramList.getString(a.i.aa_amount_format, new Object[] { localObject.get(str) });; localb.eYN = "")
      {
        this.dataList.add(localb);
        break;
      }
    }
  }
  
  private LaunchAAByPersonAmountSelectUI.b jR(int paramInt)
  {
    return (LaunchAAByPersonAmountSelectUI.b)this.dataList.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.dataList.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LaunchAAByPersonAmountSelectUI.b localb = jR(paramInt);
    Object localObject = paramView;
    if (localb != null)
    {
      localObject = paramView;
      if (!bk.bl(localb.username))
      {
        View localView = paramView;
        if (paramView == null)
        {
          localView = y.gt(this.eYG).inflate(a.g.launch_aa_by_person_amount_select_row, paramViewGroup, false);
          paramView = new LaunchAAByPersonAmountSelectUI.a.a(this, (byte)0);
          paramView.dpY = ((ImageView)localView.findViewById(a.f.avatar));
          paramView.eYn = ((TextView)localView.findViewById(a.f.username));
          paramView.eYo = ((WalletFormView)localView.findViewById(a.f.money_edit));
          paramView.eYM = new LaunchAAByPersonAmountSelectUI.c(this.eYG, localb.username);
          paramView.eYo.a(paramView.eYM);
          paramView.dpY.setOnTouchListener(new LaunchAAByPersonAmountSelectUI.a.1(this, paramView));
          paramView.eYn.setOnTouchListener(new LaunchAAByPersonAmountSelectUI.a.2(this, paramView));
          localView.setTag(paramView);
          this.eYG.a(paramView.eYo, 2, false, true);
        }
        paramView = (LaunchAAByPersonAmountSelectUI.a.a)localView.getTag();
        if (!bk.bl(localb.username))
        {
          paramView.eYM.username = localb.username;
          a.b.a(paramView.dpY, localb.username);
          paramView.eYn.setText(j.a(this.eYG.mController.uMN, ((b)g.r(b.class)).getDisplayName(localb.username, LaunchAAByPersonAmountSelectUI.n(this.eYG)), paramView.eYn.getTextSize()));
        }
        localObject = localView;
        if (localb.eYN != null)
        {
          localObject = localView;
          if (paramView.eYo.getText() != null)
          {
            localObject = localView;
            if (!localb.eYN.equals(paramView.eYo.getText().toLowerCase()))
            {
              paramViewGroup = paramView.eYo;
              localObject = paramView.eYM;
              if (paramViewGroup.wCS != null) {
                paramViewGroup.wCS.removeTextChangedListener((TextWatcher)localObject);
              }
              paramView.eYo.setText(localb.eYN);
              paramView.eYo.a(paramView.eYM);
              localObject = localView;
            }
          }
        }
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI.a
 * JD-Core Version:    0.7.0.1
 */