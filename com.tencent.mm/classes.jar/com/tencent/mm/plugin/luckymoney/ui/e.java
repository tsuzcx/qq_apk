package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.model.t;
import java.util.LinkedList;
import java.util.List;

public abstract class e
  extends BaseAdapter
{
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected List<t> vjL = new LinkedList();
  
  public e(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public final t Js(int paramInt)
  {
    return (t)this.vjL.get(paramInt);
  }
  
  public final void a(t paramt)
  {
    this.vjL.remove(paramt);
  }
  
  public final void es(List<t> paramList)
  {
    if (paramList == null) {}
    for (this.vjL = new LinkedList();; this.vjL = paramList)
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getCount()
  {
    return this.vjL.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.e
 * JD-Core Version:    0.7.0.1
 */