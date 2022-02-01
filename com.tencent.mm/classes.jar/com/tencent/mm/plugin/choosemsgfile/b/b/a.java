package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.storage.bu;

public abstract class a<T extends RecyclerView.w>
{
  protected int apW;
  protected int fq;
  public bu oRU;
  g oSd;
  protected int oSe = 0;
  
  public a(g paramg)
  {
    this.oSd = paramg;
  }
  
  public a(g paramg, bu parambu)
  {
    this.oSd = paramg;
    this.oRU = parambu;
  }
  
  public void T(T paramT) {}
  
  public void a(T paramT, int paramInt, a parama) {}
  
  public void a(View paramView, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.oSd.a(paramBoolean, parama, paramT);
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.b.d.a bZm()
  {
    return this.oSd.bZx().bZm();
  }
  
  public String bZn()
  {
    return "";
  }
  
  public int bZo()
  {
    return 0;
  }
  
  public final void bZp()
  {
    try
    {
      this.oSe = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bZq()
  {
    try
    {
      this.oSe = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bZr()
  {
    try
    {
      this.oSe = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bZs()
  {
    try
    {
      this.oSe = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bZt()
  {
    try
    {
      this.oSe = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void eY(int paramInt1, int paramInt2)
  {
    try
    {
      this.oSe = 2;
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
    if ((this.oRU != null) && ((paramObject instanceof bu)) && (paramObject != null)) {
      return this.oRU.field_msgId == ((bu)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  protected final Context getContext()
  {
    return this.oSd.bZx().getContext();
  }
  
  public String getFileName()
  {
    return "";
  }
  
  public long getTimeStamp()
  {
    return this.oRU.field_createTime;
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.oSd.bZx().bZm().isInvalid()) || (this.oSd.bZx().bZm().tC(this.oRU.field_msgId));
  }
  
  public final boolean isInvalid()
  {
    return (this.oSe == 4) || (this.oSe == 5);
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.oRU.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.a
 * JD-Core Version:    0.7.0.1
 */