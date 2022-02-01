package com.tencent.mm.plugin.choosemsgfile.logic.b;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.choosemsgfile.logic.ui.g;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import com.tencent.mm.storage.cc;

public abstract class a<T extends RecyclerView.v>
{
  protected int Sc;
  protected int tK;
  private g wPH;
  protected int wPI = 0;
  public cc wPy;
  
  public a(g paramg)
  {
    this.wPH = paramg;
  }
  
  public a(g paramg, cc paramcc)
  {
    this.wPH = paramg;
    this.wPy = paramcc;
  }
  
  public void Q(T paramT) {}
  
  public void a(View paramView, a parama) {}
  
  public void a(T paramT, int paramInt, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.wPH.a(paramBoolean, parama, paramT);
  }
  
  public final g dqr()
  {
    return this.wPH;
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.logic.c.a dqs()
  {
    return this.wPH.dqD().dqs();
  }
  
  public int dqt()
  {
    return 0;
  }
  
  public final void dqu()
  {
    try
    {
      this.wPI = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dqv()
  {
    try
    {
      this.wPI = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dqw()
  {
    try
    {
      this.wPI = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dqx()
  {
    try
    {
      this.wPI = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void dqy()
  {
    try
    {
      this.wPI = 0;
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
    if ((this.wPy != null) && ((paramObject instanceof cc)) && (paramObject != null)) {
      return this.wPy.field_msgId == ((cc)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  public final void gB(int paramInt1, int paramInt2)
  {
    try
    {
      this.wPI = 2;
      this.Sc = paramInt1;
      this.tK = paramInt2;
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
    return this.wPH.dqD().getContext();
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
    return this.wPy.getCreateTime();
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.wPH.dqD().dqs().isInvalid()) || (this.wPH.dqD().dqs().kz(this.wPy.field_msgId));
  }
  
  public final boolean isInvalid()
  {
    return (this.wPI == 4) || (this.wPI == 5);
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.wPy.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.a
 * JD-Core Version:    0.7.0.1
 */