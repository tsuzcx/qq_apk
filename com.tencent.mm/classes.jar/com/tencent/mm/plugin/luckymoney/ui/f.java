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
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected List<y> yQe = new LinkedList();
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public final y PT(int paramInt)
  {
    return (y)this.yQe.get(paramInt);
  }
  
  public final void a(y paramy)
  {
    this.yQe.remove(paramy);
  }
  
  public final void fq(List<y> paramList)
  {
    if (paramList == null) {}
    for (this.yQe = new LinkedList();; this.yQe = paramList)
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getCount()
  {
    return this.yQe.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.f
 * JD-Core Version:    0.7.0.1
 */