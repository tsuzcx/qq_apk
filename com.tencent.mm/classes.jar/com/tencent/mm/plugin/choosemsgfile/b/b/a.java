package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.storage.ca;

public abstract class a<T extends RecyclerView.v>
{
  protected int aqi;
  protected int fs;
  g qnE;
  protected int qnF = 0;
  public ca qnv;
  
  public a(g paramg)
  {
    this.qnE = paramg;
  }
  
  public a(g paramg, ca paramca)
  {
    this.qnE = paramg;
    this.qnv = paramca;
  }
  
  public void V(T paramT) {}
  
  public void a(T paramT, int paramInt, a parama) {}
  
  public void a(View paramView, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.qnE.a(paramBoolean, parama, paramT);
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.b.d.a cys()
  {
    return this.qnE.cyC().cys();
  }
  
  public int cyt()
  {
    return 0;
  }
  
  public final void cyu()
  {
    try
    {
      this.qnF = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cyv()
  {
    try
    {
      this.qnF = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cyw()
  {
    try
    {
      this.qnF = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cyx()
  {
    try
    {
      this.qnF = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cyy()
  {
    try
    {
      this.qnF = 0;
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
    if ((this.qnv != null) && ((paramObject instanceof ca)) && (paramObject != null)) {
      return this.qnv.field_msgId == ((ca)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  public final void fm(int paramInt1, int paramInt2)
  {
    try
    {
      this.qnF = 2;
      this.fs = paramInt1;
      this.aqi = paramInt2;
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
    return this.qnE.cyC().getContext();
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
    return this.qnv.field_createTime;
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.qnE.cyC().cys().isInvalid()) || (this.qnE.cyC().cys().BY(this.qnv.field_msgId));
  }
  
  public final boolean isInvalid()
  {
    return (this.qnF == 4) || (this.qnF == 5);
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.qnv.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.a
 * JD-Core Version:    0.7.0.1
 */