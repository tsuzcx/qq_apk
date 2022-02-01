package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.model.y;
import java.util.LinkedList;
import java.util.List;

public abstract class f
  extends BaseAdapter
{
  protected List<y> KmK = new LinkedList();
  protected Context mContext;
  protected LayoutInflater mInflater;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public final void a(y paramy)
  {
    this.KmK.remove(paramy);
  }
  
  public final y aab(int paramInt)
  {
    return (y)this.KmK.get(paramInt);
  }
  
  public int getCount()
  {
    return this.KmK.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final void iQ(List<y> paramList)
  {
    if (paramList == null) {}
    for (this.KmK = new LinkedList();; this.KmK = paramList)
    {
      notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.f
 * JD-Core Version:    0.7.0.1
 */