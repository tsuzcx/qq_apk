package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c
  extends BaseAdapter
  implements Filterable
{
  private List<String> fkW;
  private ArrayList<String> fkX;
  private c.a fkY;
  private String fkZ;
  private Context mContext;
  private final Object mLock = new Object();
  
  public c(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    this.mContext = paramContext;
    this.fkW = Arrays.asList(paramArrayOfString);
    this.fkZ = paramString;
  }
  
  private String ke(int paramInt)
  {
    return (String)this.fkW.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.fkW.size();
  }
  
  public final Filter getFilter()
  {
    if (this.fkY == null) {
      this.fkY = new c.a(this, (byte)0);
    }
    return this.fkY;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, q.g.auto_complete_dropdown_item, null);
      paramViewGroup = new c.b();
      paramViewGroup.flb = ((TextView)paramView.findViewById(q.f.textview1));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = ke(paramInt);
      paramViewGroup.flb.setText(str);
      paramView.setBackgroundResource(q.e.comm_list_item_selector);
      return paramView;
      paramViewGroup = (c.b)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.c
 * JD-Core Version:    0.7.0.1
 */