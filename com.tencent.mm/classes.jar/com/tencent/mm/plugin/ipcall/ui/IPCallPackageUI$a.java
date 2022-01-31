package com.tencent.mm.plugin.ipcall.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.chp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.List;

final class IPCallPackageUI$a
  extends BaseAdapter
{
  List<chp> kZk = null;
  private IPCallPackageUI lxg = null;
  
  public IPCallPackageUI$a(IPCallPackageUI paramIPCallPackageUI)
  {
    this.lxg = paramIPCallPackageUI;
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
      paramView = ((LayoutInflater)this.lxg.getSystemService("layout_inflater")).inflate(R.i.ipcall_package_item, paramViewGroup, false);
      paramViewGroup = new IPCallPackageUI.a.a(this, (byte)0);
      paramViewGroup.lxk = ((CdnImageView)paramView.findViewById(R.h.package_image_iv));
      paramViewGroup.fdt = ((TextView)paramView.findViewById(R.h.package_name_tv));
      paramViewGroup.lxl = ((TextView)paramView.findViewById(R.h.package_price_tv));
      paramViewGroup.lxm = ((TextView)paramView.findViewById(R.h.package_count_tv));
      paramViewGroup.gaI = ((TextView)paramView.findViewById(R.h.package_desc_tv));
      paramViewGroup.lxn = ((Button)paramView.findViewById(R.h.package_buy_btn));
      paramView.setTag(paramViewGroup);
    }
    chp localchp;
    for (;;)
    {
      localchp = (chp)getItem(paramInt);
      if (localchp != null) {
        break;
      }
      return paramView;
      paramViewGroup = (IPCallPackageUI.a.a)paramView.getTag();
    }
    paramViewGroup.fdt.setText(localchp.bGw);
    paramViewGroup.lxl.setText(localchp.tAh);
    paramViewGroup.gaI.setText(localchp.kRN);
    paramViewGroup.lxm.setText(localchp.lsL);
    paramViewGroup.lxk.setVisibility(0);
    paramViewGroup.lxk.setUrl(localchp.tWt);
    if (localchp.svx == 0) {
      paramViewGroup.lxn.setEnabled(true);
    }
    for (;;)
    {
      paramViewGroup.lxn.setTag(Integer.valueOf(paramInt));
      paramViewGroup.lxn.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = (chp)IPCallPackageUI.a.this.getItem(((Integer)paramAnonymousView.getTag()).intValue());
          if ((paramAnonymousView == null) || (bk.bl(paramAnonymousView.syc)))
          {
            y.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
            return;
          }
          IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this)).start();
          f localf = IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this));
          localf.lsb += 1;
          IPCallPackageUI.b(IPCallPackageUI.a.a(IPCallPackageUI.a.this)).lsg = paramAnonymousView.syc;
          h.a(IPCallPackageUI.a.a(IPCallPackageUI.a.this), IPCallPackageUI.a.a(IPCallPackageUI.a.this).getString(R.l.ipcall_purchase_confirm_desc, new Object[] { paramAnonymousView.tAh, paramAnonymousView.bGw }), IPCallPackageUI.a.a(IPCallPackageUI.a.this).getString(R.l.ipcall_purchase_confirm_title), IPCallPackageUI.a.a(IPCallPackageUI.a.this).getString(R.l.ipcall_purchase), IPCallPackageUI.a.a(IPCallPackageUI.a.this).getString(R.l.ipcall_purchase_cancel), false, new IPCallPackageUI.a.1.1(this, paramAnonymousView), new IPCallPackageUI.a.1.2(this));
        }
      });
      return paramView;
      paramViewGroup.lxn.setEnabled(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallPackageUI.a
 * JD-Core Version:    0.7.0.1
 */