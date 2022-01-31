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
  protected Set<Integer> mzh;
  protected w mzi;
  protected a.a mzj;
  protected int type;
  
  public final void a(w paramw)
  {
    this.mzi = paramw;
  }
  
  public final void a(a.a parama)
  {
    this.mzj = parama;
  }
  
  public final long bxM()
  {
    return this.lastUpdateTime;
  }
  
  public final void bxN()
  {
    if (this.mzj != null) {
      this.mzj.bxL();
    }
  }
  
  public abstract void bxO();
  
  public abstract void bxP();
  
  public final void e(Set<Integer> paramSet)
  {
    this.mzh = paramSet;
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