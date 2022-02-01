package com.tencent.mm.plugin.choosemsgfile.logic.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public abstract class a
  extends RecyclerView.a
  implements g
{
  protected List<com.tencent.mm.plugin.choosemsgfile.logic.b.a> uQh;
  private e wQl;
  private boolean wQm;
  g.a wQn;
  g.b wQo;
  
  public a(e parame, List<com.tencent.mm.plugin.choosemsgfile.logic.b.a> paramList)
  {
    this.wQl = parame;
    this.uQh = paramList;
    this.wQm = h.baE().isSDCardAvailable();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.logic.b.a IW(int paramInt)
  {
    if ((this.uQh == null) || (this.uQh.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.logic.b.a)this.uQh.get(paramInt);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    IW(paramInt);
    super.a(paramv, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.logic.b.a parama, RecyclerView.v paramv)
  {
    if (this.wQn != null) {
      this.wQn.a(paramBoolean, parama, paramv);
    }
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    if (!this.wQm)
    {
      Log.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.wQm) });
      return;
    }
    IW(paramInt).a(paramv, paramInt, IW(paramInt + 1));
  }
  
  public final e dqD()
  {
    return this.wQl;
  }
  
  public boolean dqE()
  {
    return false;
  }
  
  public final int getItemCount()
  {
    return this.uQh.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return IW(paramInt).getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.ui.a
 * JD-Core Version:    0.7.0.1
 */