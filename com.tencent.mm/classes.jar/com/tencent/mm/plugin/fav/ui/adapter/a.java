package com.tencent.mm.plugin.fav.ui.adapter;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.x;
import java.util.Set;

public abstract class a
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  protected Set<Integer> AjW;
  protected x AjX;
  protected a AjY;
  protected long lastUpdateTime;
  protected int type;
  
  public final void a(x paramx)
  {
    this.AjX = paramx;
  }
  
  public final void a(a parama)
  {
    this.AjY = parama;
  }
  
  public abstract void bXB();
  
  public final long dSh()
  {
    return this.lastUpdateTime;
  }
  
  public final void dSi()
  {
    if (this.AjY != null) {
      this.AjY.dSb();
    }
  }
  
  public abstract void dSj();
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public final void r(Set<Integer> paramSet)
  {
    this.AjW = paramSet;
  }
  
  public static abstract interface a
  {
    public abstract void dSb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.adapter.a
 * JD-Core Version:    0.7.0.1
 */