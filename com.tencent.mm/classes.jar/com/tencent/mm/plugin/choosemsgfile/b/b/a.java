package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.f.c.et;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.storage.ca;

public abstract class a<T extends RecyclerView.v>
{
  protected int sL;
  public ca tMi;
  private g tMr;
  protected int tMs = 0;
  protected int zP;
  
  public a(g paramg)
  {
    this.tMr = paramg;
  }
  
  public a(g paramg, ca paramca)
  {
    this.tMr = paramg;
    this.tMi = paramca;
  }
  
  public void V(T paramT) {}
  
  public void a(View paramView, a parama) {}
  
  public void a(T paramT, int paramInt, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.tMr.a(paramBoolean, parama, paramT);
  }
  
  public final g cMM()
  {
    return this.tMr;
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.b.d.a cMN()
  {
    return this.tMr.cMX().cMN();
  }
  
  public int cMO()
  {
    return 0;
  }
  
  public final void cMP()
  {
    try
    {
      this.tMs = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cMQ()
  {
    try
    {
      this.tMs = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cMR()
  {
    try
    {
      this.tMs = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cMS()
  {
    try
    {
      this.tMs = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cMT()
  {
    try
    {
      this.tMs = 0;
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
    if ((this.tMi != null) && ((paramObject instanceof ca)) && (paramObject != null)) {
      return this.tMi.field_msgId == ((ca)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  public final void fJ(int paramInt1, int paramInt2)
  {
    try
    {
      this.tMs = 2;
      this.zP = paramInt1;
      this.sL = paramInt2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final Context getContext()
  {
    return this.tMr.cMX().getContext();
  }
  
  public String getFileExt()
  {
    return "";
  }
  
  public String getFileName()
  {
    return "";
  }
  
  public long getTimeStamp()
  {
    return this.tMi.field_createTime;
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.tMr.cMX().cMN().isInvalid()) || (this.tMr.cMX().cMN().Ih(this.tMi.field_msgId));
  }
  
  public final boolean isInvalid()
  {
    return (this.tMs == 4) || (this.tMs == 5);
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.tMi.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.a
 * JD-Core Version:    0.7.0.1
 */