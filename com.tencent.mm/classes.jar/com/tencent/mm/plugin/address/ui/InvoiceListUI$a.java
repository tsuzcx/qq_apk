package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import java.util.ArrayList;
import java.util.List;

public final class InvoiceListUI$a
  extends BaseAdapter
{
  private final Context context;
  List<b> items;
  
  public InvoiceListUI$a(InvoiceListUI paramInvoiceListUI, Context paramContext)
  {
    AppMethodBeat.i(16864);
    this.items = new ArrayList();
    this.context = paramContext;
    AppMethodBeat.o(16864);
  }
  
  private b nc(int paramInt)
  {
    AppMethodBeat.i(16867);
    b localb = (b)this.items.get(paramInt);
    AppMethodBeat.o(16867);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(16866);
    int i = this.items.size();
    AppMethodBeat.o(16866);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(16865);
    paramViewGroup = new InvoiceListUI.a.a(this);
    b localb;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, 2130971121, null);
      paramViewGroup.gMq = ((ImageView)paramView.findViewById(2131828918));
      paramViewGroup.gMp = ((TextView)paramView.findViewById(2131828917));
      paramViewGroup.gve = ((TextView)paramView.findViewById(2131828916));
      paramView.setTag(paramViewGroup);
      localb = nc(paramInt);
      if ((localb.type == null) || (!localb.type.equals("0"))) {
        break label189;
      }
      paramViewGroup.gMp.setText(2131300794);
      paramViewGroup.gve.setText(localb.title);
      label123:
      if ((!InvoiceListUI.d(this.gMn)) || (InvoiceListUI.e(this.gMn) == null) || (InvoiceListUI.e(this.gMn).nLm != localb.nLm)) {
        break label234;
      }
      paramViewGroup.gMq.setImageResource(2131231906);
    }
    for (;;)
    {
      AppMethodBeat.o(16865);
      return paramView;
      paramViewGroup = (InvoiceListUI.a.a)paramView.getTag();
      break;
      label189:
      if ((localb.type == null) || (!localb.type.equals("1"))) {
        break label123;
      }
      paramViewGroup.gMp.setText(2131300800);
      paramViewGroup.gve.setText(localb.nLn);
      break label123;
      label234:
      paramViewGroup.gMq.setImageBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.InvoiceListUI.a
 * JD-Core Version:    0.7.0.1
 */