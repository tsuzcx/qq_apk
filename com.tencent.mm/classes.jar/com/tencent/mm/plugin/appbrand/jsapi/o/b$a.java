package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class b$a
  extends BaseAdapter
{
  private final ArrayList<String> hXv;
  private final int hXw;
  
  public b$a(ArrayList<String> paramArrayList, int paramInt)
  {
    this.hXv = paramArrayList;
    this.hXw = paramInt;
  }
  
  private String getItem(int paramInt)
  {
    AppMethodBeat.i(74785);
    String str = (String)this.hXv.get(paramInt);
    AppMethodBeat.o(74785);
    return str;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(74784);
    int i = this.hXv.size();
    AppMethodBeat.o(74784);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(74786);
    View localView;
    if (paramView == null)
    {
      localView = View.inflate(paramViewGroup.getContext(), 2130968737, null);
      paramView = new a((byte)0);
      paramView.gui = ((TextView)localView.findViewById(2131820680));
      localView.setTag(paramView);
      paramViewGroup = paramView;
    }
    for (;;)
    {
      paramViewGroup.gui.setText(getItem(paramInt));
      paramViewGroup.gui.setTextColor(this.hXw);
      AppMethodBeat.o(74786);
      return localView;
      paramViewGroup = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  static final class a
  {
    TextView gui;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.b.a
 * JD-Core Version:    0.7.0.1
 */