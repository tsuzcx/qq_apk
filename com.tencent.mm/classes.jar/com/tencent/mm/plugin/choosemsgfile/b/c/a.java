package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

public abstract class a
  extends RecyclerView.a
  implements g
{
  static g.b oZs;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> ndS;
  private c oZp;
  private boolean oZq;
  g.a oZr;
  
  public a(c paramc, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    this.oZp = paramc;
    this.ndS = paramList;
    this.oZq = com.tencent.mm.kernel.g.ajR().isSDCardAvailable();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.b.a Be(int paramInt)
  {
    if ((this.ndS == null) || (this.ndS.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.b.b.a)this.ndS.get(paramInt);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    if (!this.oZq)
    {
      ae.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.oZq) });
      return;
    }
    Be(paramInt).a(paramw, paramInt, Be(paramInt + 1));
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    Be(paramInt);
    super.a(paramw, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.w paramw)
  {
    if (this.oZr != null) {
      this.oZr.a(paramBoolean, parama, paramw);
    }
  }
  
  public final c caM()
  {
    return this.oZp;
  }
  
  public boolean caN()
  {
    return false;
  }
  
  public final int getItemCount()
  {
    return this.ndS.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return Be(paramInt).getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.a
 * JD-Core Version:    0.7.0.1
 */