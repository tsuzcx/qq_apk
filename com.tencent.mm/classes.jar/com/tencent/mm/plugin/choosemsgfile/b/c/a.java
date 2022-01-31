package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public abstract class a
  extends RecyclerView.a
  implements g
{
  static g.b kFu;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> jfV;
  private com.tencent.mm.plugin.choosemsgfile.ui.a kFr;
  private boolean kFs;
  g.a kFt;
  
  public a(com.tencent.mm.plugin.choosemsgfile.ui.a parama, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    this.kFr = parama;
    this.jfV = paramList;
    this.kFs = com.tencent.mm.kernel.g.RL().isSDCardAvailable();
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    if (!this.kFs)
    {
      ab.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.kFs) });
      return;
    }
    ty(paramInt).a(paramv, paramInt);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    ty(paramInt);
    super.a(paramv, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv)
  {
    if (this.kFt != null) {
      this.kFt.a(paramBoolean, parama, paramv);
    }
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.ui.a bgw()
  {
    return this.kFr;
  }
  
  public boolean bgx()
  {
    return false;
  }
  
  public final int getItemCount()
  {
    return this.jfV.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ty(paramInt).getType();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.b.a ty(int paramInt)
  {
    if ((this.jfV == null) || (this.jfV.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.b.b.a)this.jfV.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.a
 * JD-Core Version:    0.7.0.1
 */