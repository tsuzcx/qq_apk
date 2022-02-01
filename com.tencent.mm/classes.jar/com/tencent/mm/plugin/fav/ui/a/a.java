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
  protected Set<Integer> qgK;
  protected w qgL;
  protected a qgM;
  protected int type;
  
  public final void a(w paramw)
  {
    this.qgL = paramw;
  }
  
  public final void a(a parama)
  {
    this.qgM = parama;
  }
  
  public abstract void aJq();
  
  public final long cjo()
  {
    return this.lastUpdateTime;
  }
  
  public final void cjp()
  {
    if (this.qgM != null) {
      this.qgM.cji();
    }
  }
  
  public abstract void cjq();
  
  public final void f(Set<Integer> paramSet)
  {
    this.qgK = paramSet;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
  
  public static abstract interface a
  {
    public abstract void cji();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */