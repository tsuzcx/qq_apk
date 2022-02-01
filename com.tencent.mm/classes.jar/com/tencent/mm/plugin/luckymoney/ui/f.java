package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.model.z;
import java.util.LinkedList;
import java.util.List;

public abstract class f
  extends BaseAdapter
{
  protected List<z> Eud = new LinkedList();
  protected Context mContext;
  protected LayoutInflater mInflater;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
  }
  
  public final z Wf(int paramInt)
  {
    return (z)this.Eud.get(paramInt);
  }
  
  public final void a(z paramz)
  {
    this.Eud.remove(paramz);
  }
  
  public final void fS(List<z> paramList)
  {
    if (paramList == null) {}
    for (this.Eud = new LinkedList();; this.Eud = paramList)
    {
      notifyDataSetChanged();
      return;
    }
  }
  
  public int getCount()
  {
    return this.Eud.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.f
 * JD-Core Version:    0.7.0.1
 */