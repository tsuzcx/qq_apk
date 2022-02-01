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
  protected Set<Integer> thd;
  protected w the;
  protected a thf;
  protected int type;
  
  public final void a(w paramw)
  {
    this.the = paramw;
  }
  
  public final void a(a parama)
  {
    this.thf = parama;
  }
  
  public abstract void boE();
  
  public final long cWk()
  {
    return this.lastUpdateTime;
  }
  
  public final void cWl()
  {
    if (this.thf != null) {
      this.thf.cWe();
    }
  }
  
  public abstract void cWm();
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
  
  public final void k(Set<Integer> paramSet)
  {
    this.thd = paramSet;
  }
  
  public static abstract interface a
  {
    public abstract void cWe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */