package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.model.r;
import java.util.LinkedList;
import java.util.List;

public abstract class e
  extends BaseAdapter
{
  protected Context mContext;
  protected LayoutInflater mInflater;
  protected List<r> oja = new LinkedList();
  
  public e(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public final void a(r paramr)
  {
    this.oja.remove(paramr);
  }
  
  public final void ci(List<r> paramList)
  {
    if (paramList == null) {}
    for (this.oja = new LinkedList();; this.oja = paramList)
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getCount()
  {
    return this.oja.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final r yz(int paramInt)
  {
    return (r)this.oja.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.e
 * JD-Core Version:    0.7.0.1
 */