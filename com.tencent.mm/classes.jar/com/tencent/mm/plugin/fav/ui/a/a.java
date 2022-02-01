package com.tencent.mm.plugin.fav.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.x;
import java.util.Set;

public abstract class a
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  protected long lastUpdateTime;
  protected int type;
  protected Set<Integer> wNt;
  protected x wNu;
  protected a wNv;
  
  public final void a(x paramx)
  {
    this.wNu = paramx;
  }
  
  public final void a(a parama)
  {
    this.wNv = parama;
  }
  
  public abstract void byN();
  
  public final long dlr()
  {
    return this.lastUpdateTime;
  }
  
  public final void dls()
  {
    if (this.wNv != null) {
      this.wNv.dll();
    }
  }
  
  public abstract void dlt();
  
  public final int getType()
  {
    return this.type;
  }
  
  public abstract boolean isEmpty();
  
  public final void k(Set<Integer> paramSet)
  {
    this.wNt = paramSet;
  }
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public static abstract interface a
  {
    public abstract void dll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.a.a
 * JD-Core Version:    0.7.0.1
 */