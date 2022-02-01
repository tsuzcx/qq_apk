package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

public abstract class a
  extends RecyclerView.a
  implements g
{
  static g.b oSQ;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> mYL;
  private c oSN;
  private boolean oSO;
  g.a oSP;
  
  public a(c paramc, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    this.oSN = paramc;
    this.mYL = paramList;
    this.oSO = com.tencent.mm.kernel.g.ajC().isSDCardAvailable();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.b.a AS(int paramInt)
  {
    if ((this.mYL == null) || (this.mYL.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.b.b.a)this.mYL.get(paramInt);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    if (!this.oSO)
    {
      ad.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.oSO) });
      return;
    }
    AS(paramInt).a(paramw, paramInt, AS(paramInt + 1));
  }
  
  public final void a(RecyclerView.w paramw, int paramInt, List paramList)
  {
    AS(paramInt);
    super.a(paramw, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.w paramw)
  {
    if (this.oSP != null) {
      this.oSP.a(paramBoolean, parama, paramw);
    }
  }
  
  public final c bZx()
  {
    return this.oSN;
  }
  
  public boolean bZy()
  {
    return false;
  }
  
  public final int getItemCount()
  {
    return this.mYL.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return AS(paramInt).getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.a
 * JD-Core Version:    0.7.0.1
 */