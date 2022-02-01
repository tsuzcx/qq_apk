package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public abstract class a
  extends RecyclerView.a
  implements g
{
  static g.b nMv;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> lWb;
  private c nMs;
  private boolean nMt;
  g.a nMu;
  
  public a(c paramc, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    this.nMs = paramc;
    this.lWb = paramList;
    this.nMt = com.tencent.mm.kernel.g.afB().isSDCardAvailable();
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    if (!this.nMt)
    {
      ad.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.nMt) });
      return;
    }
    zs(paramInt).a(paramv, paramInt, zs(paramInt + 1));
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    zs(paramInt);
    super.a(paramv, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv)
  {
    if (this.nMu != null) {
      this.nMu.a(paramBoolean, parama, paramv);
    }
  }
  
  public final c bNH()
  {
    return this.nMs;
  }
  
  public boolean bNI()
  {
    return false;
  }
  
  public final int getItemCount()
  {
    return this.lWb.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return zs(paramInt).getType();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.b.a zs(int paramInt)
  {
    if ((this.lWb == null) || (this.lWb.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.b.b.a)this.lWb.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.a
 * JD-Core Version:    0.7.0.1
 */