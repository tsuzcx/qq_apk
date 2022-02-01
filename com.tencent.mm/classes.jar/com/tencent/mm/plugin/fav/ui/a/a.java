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
  protected Set<Integer> qPm;
  protected w qPn;
  protected a qPo;
  protected int type;
  
  public final void a(w paramw)
  {
    this.qPn = paramw;
  }
  
  public final void a(a parama)
  {
    this.qPo = parama;
  }
  
  public abstract void aQh();
  
  public final long cqV()
  {
    return this.lastUpdateTime;
  }
  
  public final void cqW()
  {
    if (this.qPo != null) {
      this.qPo.cqP();
    }
  }
  
  public abstract void cqX();
  
  public final void g(Set<Integer> paramSet)
  {
    this.qPm = paramSet;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
  
  public static abstract interface a
  {
    public abstract void cqP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */