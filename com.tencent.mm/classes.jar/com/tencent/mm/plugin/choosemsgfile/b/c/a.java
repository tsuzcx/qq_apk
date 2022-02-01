package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.List;

public abstract class a
  extends RecyclerView.a
  implements g
{
  static g.b opv;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> myd;
  private c ops;
  private boolean opt;
  g.a opu;
  
  public a(c paramc, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    this.ops = paramc;
    this.myd = paramList;
    this.opt = com.tencent.mm.kernel.g.agR().isSDCardAvailable();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.b.a Aj(int paramInt)
  {
    if ((this.myd == null) || (this.myd.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.b.b.a)this.myd.get(paramInt);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    if (!this.opt)
    {
      ac.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.opt) });
      return;
    }
    Aj(paramInt).a(paramw, paramInt, Aj(paramInt + 1));
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    Aj(paramInt);
    super.a(paramw, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.w paramw)
  {
    if (this.opu != null) {
      this.opu.a(paramBoolean, parama, paramw);
    }
  }
  
  public final c bUS()
  {
    return this.ops;
  }
  
  public boolean bUT()
  {
    return false;
  }
  
  public final int getItemCount()
  {
    return this.myd.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return Aj(paramInt).getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.a
 * JD-Core Version:    0.7.0.1
 */