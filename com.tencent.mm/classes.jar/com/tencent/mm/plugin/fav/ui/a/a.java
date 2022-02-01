package com.tencent.mm.plugin.fav.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.w;
import java.util.Set;

public abstract class a
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  protected long lastUpdateTime;
  protected Set<Integer> rzl;
  protected w rzm;
  protected a rzn;
  protected int type;
  
  public final void a(w paramw)
  {
    this.rzm = paramw;
  }
  
  public final void a(a parama)
  {
    this.rzn = parama;
  }
  
  public abstract void aTt();
  
  public final long cwF()
  {
    return this.lastUpdateTime;
  }
  
  public final void cwG()
  {
    if (this.rzn != null) {
      this.rzn.cwz();
    }
  }
  
  public abstract void cwH();
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
  
  public final void k(Set<Integer> paramSet)
  {
    this.rzl = paramSet;
  }
  
  public static abstract interface a
  {
    public abstract void cwz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */