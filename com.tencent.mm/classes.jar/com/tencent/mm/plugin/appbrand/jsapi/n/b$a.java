package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.luggage.l.b.a.b;
import com.tencent.luggage.l.b.a.c;
import java.util.ArrayList;

final class b$a
  extends BaseAdapter
{
  private final ArrayList<String> gAi;
  private final int gAj;
  
  public b$a(ArrayList<String> paramArrayList, int paramInt)
  {
    this.gAi = paramArrayList;
    this.gAj = paramInt;
  }
  
  private String ke(int paramInt)
  {
    return (String)this.gAi.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.gAi.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(paramViewGroup.getContext(), a.c.app_brand_show_action_sheet_item, null);
      paramView = new b.a.a((byte)0);
      paramView.fcy = ((TextView)localView.findViewById(a.b.title));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.fcy.setText(ke(paramInt));
      paramViewGroup.fcy.setTextColor(this.gAj);
      return localView;
      paramViewGroup = (b.a.a)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.b.a
 * JD-Core Version:    0.7.0.1
 */