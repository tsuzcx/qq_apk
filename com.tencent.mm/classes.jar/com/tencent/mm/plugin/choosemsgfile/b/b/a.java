package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.g.c.du;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.storage.bl;

public abstract class a<T extends RecyclerView.v>
{
  protected int LZ;
  protected int anj;
  g nLI;
  protected int nLJ = 0;
  public bl nLz;
  
  public a(g paramg)
  {
    this.nLI = paramg;
  }
  
  public a(g paramg, bl parambl)
  {
    this.nLI = paramg;
    this.nLz = parambl;
  }
  
  public void T(T paramT) {}
  
  public void a(T paramT, int paramInt, a parama) {}
  
  public void a(View paramView, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.nLI.a(paramBoolean, parama, paramT);
  }
  
  public final void bNA()
  {
    try
    {
      this.nLJ = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bNB()
  {
    try
    {
      this.nLJ = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bNC()
  {
    try
    {
      this.nLJ = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bND()
  {
    try
    {
      this.nLJ = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.b.d.a bNw()
  {
    return this.nLI.bNH().bNw();
  }
  
  public String bNx()
  {
    return "";
  }
  
  public int bNy()
  {
    return 0;
  }
  
  public final void bNz()
  {
    try
    {
      this.nLJ = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bc()
  {
    return (this.nLJ == 4) || (this.nLJ == 5);
  }
  
  public final void eR(int paramInt1, int paramInt2)
  {
    try
    {
      this.nLJ = 2;
      this.LZ = paramInt1;
      this.anj = paramInt2;
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
    if ((this.nLz != null) && ((paramObject instanceof bl)) && (paramObject != null)) {
      return this.nLz.field_msgId == ((bl)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  protected final Context getContext()
  {
    return this.nLI.bNH().getContext();
  }
  
  public String getFileName()
  {
    return "";
  }
  
  public long getTimeStamp()
  {
    return this.nLz.field_createTime;
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.nLI.bNH().bNw().bc()) || (this.nLI.bNH().bNw().nR(this.nLz.field_msgId));
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.nLz.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.a
 * JD-Core Version:    0.7.0.1
 */