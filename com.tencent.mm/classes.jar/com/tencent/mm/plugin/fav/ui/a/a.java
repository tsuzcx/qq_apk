package com.tencent.mm.plugin.fav.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.w;
import java.util.Set;

public abstract class a
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  protected a.a keA;
  protected Set<Integer> kex;
  protected w kez;
  protected long lastUpdateTime;
  protected int type;
  
  public final void a(w paramw)
  {
    this.kez = paramw;
  }
  
  public final void a(a.a parama)
  {
    this.keA = parama;
  }
  
  public abstract void aRA();
  
  public final long aRx()
  {
    return this.lastUpdateTime;
  }
  
  public final void aRy()
  {
    if (this.keA != null) {
      this.keA.aRw();
    }
  }
  
  public abstract void aRz();
  
  public final void f(Set<Integer> paramSet)
  {
    this.kex = paramSet;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */