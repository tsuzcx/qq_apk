package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.tencent.luggage.l.a.a.e;
import com.tencent.mm.plugin.appbrand.widget.input.d.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.List;

final class a
  extends ArrayAdapter<a.b>
  implements g
{
  private final LayoutInflater Lu;
  private b hwC;
  h hwD;
  private boolean hwE = false;
  
  a(Context paramContext, List<a.b> paramList)
  {
    super(paramContext, a.e.app_brand_input_autofill_item, paramList);
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  public final void a(b paramb)
  {
    this.hwC = paramb;
    this.hwC.setOnDismissListener(new a.1(this));
  }
  
  public final void asx()
  {
    this.hwC.setOnDismissListener(null);
    this.hwC = null;
  }
  
  public final Filter getFilter()
  {
    return super.getFilter();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 8;
    View localView = paramView;
    if (paramView == null) {
      localView = this.Lu.inflate(a.e.app_brand_input_autofill_item, paramViewGroup, false);
    }
    paramView = (a.a)localView.getTag();
    if (paramView == null)
    {
      paramView = new a.a(this, localView);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramViewGroup = (a.b)getItem(paramInt);
      paramView.hwJ = paramViewGroup;
      paramView.hwG.setText(paramViewGroup.title);
      paramView.hwH.setText(paramViewGroup.content);
      TextView localTextView = paramView.hwH;
      int i;
      if (bk.bl(paramViewGroup.content))
      {
        i = 8;
        localTextView.setVisibility(i);
        paramView = paramView.eYp;
        if (paramInt != getCount() - 1) {
          break label150;
        }
      }
      label150:
      for (paramInt = j;; paramInt = 0)
      {
        paramView.setVisibility(paramInt);
        return localView;
        i = 0;
        break;
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.a
 * JD-Core Version:    0.7.0.1
 */