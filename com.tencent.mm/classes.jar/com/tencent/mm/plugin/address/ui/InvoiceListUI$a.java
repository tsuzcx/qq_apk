package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.o.a.b;
import java.util.ArrayList;
import java.util.List;

public final class InvoiceListUI$a
  extends BaseAdapter
{
  private final Context context;
  List<b> items = new ArrayList();
  
  public InvoiceListUI$a(InvoiceListUI paramInvoiceListUI, Context paramContext)
  {
    this.context = paramContext;
  }
  
  private b kk(int paramInt)
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
    paramViewGroup = new InvoiceListUI.a.a(this);
    b localb;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.wallet_addr_select_item, null);
      paramViewGroup.fuO = ((ImageView)paramView.findViewById(R.h.check_state));
      paramViewGroup.fuN = ((TextView)paramView.findViewById(R.h.address_content_tv));
      paramViewGroup.fdt = ((TextView)paramView.findViewById(R.h.address_name_tv));
      paramView.setTag(paramViewGroup);
      localb = kk(paramInt);
      if ((localb.type == null) || (!localb.type.equals("0"))) {
        break label183;
      }
      paramViewGroup.fuN.setText(R.l.invoice_company_type);
      paramViewGroup.fdt.setText(localb.title);
    }
    for (;;)
    {
      if ((!InvoiceListUI.d(this.fuL)) || (InvoiceListUI.e(this.fuL) == null) || (InvoiceListUI.e(this.fuL).lnP != localb.lnP)) {
        break label229;
      }
      paramViewGroup.fuO.setImageResource(R.k.radio_on);
      return paramView;
      paramViewGroup = (InvoiceListUI.a.a)paramView.getTag();
      break;
      label183:
      if ((localb.type != null) && (localb.type.equals("1")))
      {
        paramViewGroup.fuN.setText(R.l.invoice_personal_type);
        paramViewGroup.fdt.setText(localb.lnQ);
      }
    }
    label229:
    paramViewGroup.fuO.setImageBitmap(null);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.a
 * JD-Core Version:    0.7.0.1
 */