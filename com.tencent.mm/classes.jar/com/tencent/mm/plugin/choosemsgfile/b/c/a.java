package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public abstract class a
  extends RecyclerView.a
  implements g
{
  static g.b qoq;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> opg;
  private c qon;
  private boolean qoo;
  g.a qop;
  
  public a(c paramc, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    this.qon = paramc;
    this.opg = paramList;
    this.qoo = com.tencent.mm.kernel.g.aAh().isSDCardAvailable();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.b.a EM(int paramInt)
  {
    if ((this.opg == null) || (this.opg.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.b.b.a)this.opg.get(paramInt);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    if (!this.qoo)
    {
      Log.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.qoo) });
      return;
    }
    EM(paramInt).a(paramv, paramInt, EM(paramInt + 1));
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    EM(paramInt);
    super.a(paramv, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv)
  {
    if (this.qop != null) {
      this.qop.a(paramBoolean, parama, paramv);
    }
  }
  
  public final c cyC()
  {
    return this.qon;
  }
  
  public boolean cyD()
  {
    return false;
  }
  
  public final int getItemCount()
  {
    return this.opg.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return EM(paramInt).getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.a
 * JD-Core Version:    0.7.0.1
 */