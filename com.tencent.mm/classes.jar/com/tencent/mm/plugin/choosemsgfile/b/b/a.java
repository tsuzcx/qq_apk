package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.storage.bv;

public abstract class a<T extends RecyclerView.w>
{
  protected int apW;
  protected int fq;
  g oYF;
  protected int oYG = 0;
  public bv oYw;
  
  public a(g paramg)
  {
    this.oYF = paramg;
  }
  
  public a(g paramg, bv parambv)
  {
    this.oYF = paramg;
    this.oYw = parambv;
  }
  
  public void T(T paramT) {}
  
  public void a(T paramT, int paramInt, a parama) {}
  
  public void a(View paramView, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.oYF.a(paramBoolean, parama, paramT);
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.b.d.a caB()
  {
    return this.oYF.caM().caB();
  }
  
  public String caC()
  {
    return "";
  }
  
  public int caD()
  {
    return 0;
  }
  
  public final void caE()
  {
    try
    {
      this.oYG = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void caF()
  {
    try
    {
      this.oYG = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void caG()
  {
    try
    {
      this.oYG = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void caH()
  {
    try
    {
      this.oYG = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void caI()
  {
    try
    {
      this.oYG = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void eZ(int paramInt1, int paramInt2)
  {
    try
    {
      this.oYG = 2;
      this.fq = paramInt1;
      this.apW = paramInt2;
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
    if ((this.oYw != null) && ((paramObject instanceof bv)) && (paramObject != null)) {
      return this.oYw.field_msgId == ((bv)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  protected final Context getContext()
  {
    return this.oYF.caM().getContext();
  }
  
  public String getFileName()
  {
    return "";
  }
  
  public long getTimeStamp()
  {
    return this.oYw.field_createTime;
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.oYF.caM().caB().isInvalid()) || (this.oYF.caM().caB().tT(this.oYw.field_msgId));
  }
  
  public final boolean isInvalid()
  {
    return (this.oYG == 4) || (this.oYG == 5);
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.oYw.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.a
 * JD-Core Version:    0.7.0.1
 */