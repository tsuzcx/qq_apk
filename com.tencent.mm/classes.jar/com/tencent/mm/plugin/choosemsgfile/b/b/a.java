package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.storage.bi;

public abstract class a<T extends RecyclerView.v>
{
  protected int Fb;
  protected int agc;
  g kEI;
  protected int kEJ = 0;
  public bi kEz;
  
  public a(g paramg)
  {
    this.kEI = paramg;
  }
  
  public a(g paramg, bi parambi)
  {
    this.kEI = paramg;
    this.kEz = parambi;
  }
  
  public void T(T paramT) {}
  
  public void a(T paramT, int paramInt) {}
  
  public void a(View paramView, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.kEI.a(paramBoolean, parama, paramT);
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.b.d.a bgl()
  {
    return this.kEI.bgw().bgl();
  }
  
  public String bgm()
  {
    return "";
  }
  
  public int bgn()
  {
    return 0;
  }
  
  public final void bgo()
  {
    try
    {
      this.kEJ = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bgp()
  {
    try
    {
      this.kEJ = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bgq()
  {
    try
    {
      this.kEJ = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bgr()
  {
    try
    {
      this.kEJ = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bgs()
  {
    try
    {
      this.kEJ = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dV(int paramInt1, int paramInt2)
  {
    try
    {
      this.kEJ = 2;
      this.Fb = paramInt1;
      this.agc = paramInt2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((this.kEz != null) && ((paramObject instanceof bi)) && (paramObject != null)) {
      return this.kEz.field_msgId == ((bi)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  protected final Context getContext()
  {
    return this.kEI.bgw().getContext();
  }
  
  public String getFileName()
  {
    return "";
  }
  
  public long getTimeStamp()
  {
    return this.kEz.field_createTime;
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.kEI.bgw().bgl().jU()) || (this.kEI.bgw().bgl().ij(this.kEz.field_msgId));
  }
  
  public final boolean jU()
  {
    return (this.kEJ == 4) || (this.kEJ == 5);
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.kEz.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.a
 * JD-Core Version:    0.7.0.1
 */