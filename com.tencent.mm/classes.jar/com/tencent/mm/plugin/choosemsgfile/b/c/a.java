package com.tencent.mm.plugin.choosemsgfile.b.c;

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
  static g.b tMY;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> rEV;
  private e tMV;
  private boolean tMW;
  g.a tMX;
  
  public a(e parame, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    this.tMV = parame;
    this.rEV = paramList;
    this.tMW = h.aHG().isSDCardAvailable();
  }
  
  public final com.tencent.mm.plugin.choosemsgfile.b.b.a It(int paramInt)
  {
    if ((this.rEV == null) || (this.rEV.size() <= paramInt)) {
      return null;
    }
    return (com.tencent.mm.plugin.choosemsgfile.b.b.a)this.rEV.get(paramInt);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt, List paramList)
  {
    It(paramInt);
    super.a(paramv, paramInt, paramList);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.choosemsgfile.b.b.a parama, RecyclerView.v paramv)
  {
    if (this.tMX != null) {
      this.tMX.a(paramBoolean, parama, paramv);
    }
  }
  
  public final e cMX()
  {
    return this.tMV;
  }
  
  public boolean cMY()
  {
    return false;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    if (!this.tMW)
    {
      Log.e("MicroMsg.BaseChooseFileAdapter", "[onBindViewHolder] isSDCardAvailable:%b", new Object[] { Boolean.valueOf(this.tMW) });
      return;
    }
    It(paramInt).a(paramv, paramInt, It(paramInt + 1));
  }
  
  public final int getItemCount()
  {
    return this.rEV.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return It(paramInt).getType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.a
 * JD-Core Version:    0.7.0.1
 */