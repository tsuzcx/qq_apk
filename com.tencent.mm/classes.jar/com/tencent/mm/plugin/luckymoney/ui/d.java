package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.b.i;
import java.util.LinkedList;
import java.util.List;

public abstract class d
  extends BaseAdapter
{
  protected LayoutInflater Lu;
  protected List<i> lLG = new LinkedList();
  protected Context mContext;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
    this.Lu = LayoutInflater.from(paramContext);
  }
  
  public final void a(i parami)
  {
    this.lLG.remove(parami);
  }
  
  public final void bM(List<i> paramList)
  {
    if (paramList == null) {}
    for (this.lLG = new LinkedList();; this.lLG = paramList)
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getCount()
  {
    return this.lLG.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final i tt(int paramInt)
  {
    return (i)this.lLG.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.d
 * JD-Core Version:    0.7.0.1
 */