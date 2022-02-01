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
  protected Set<Integer> rHw;
  protected w rHx;
  protected a rHy;
  protected int type;
  
  public final void a(w paramw)
  {
    this.rHx = paramw;
  }
  
  public final void a(a parama)
  {
    this.rHy = parama;
  }
  
  public abstract void aTS();
  
  public final long cyg()
  {
    return this.lastUpdateTime;
  }
  
  public final void cyh()
  {
    if (this.rHy != null) {
      this.rHy.cya();
    }
  }
  
  public abstract void cyi();
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
  
  public final void k(Set<Integer> paramSet)
  {
    this.rHw = paramSet;
  }
  
  public static abstract interface a
  {
    public abstract void cya();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */