package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.choosemsgfile.ui.c;
import com.tencent.mm.storage.bo;

public abstract class a<T extends RecyclerView.w>
{
  protected int MW;
  protected int aoe;
  g ooI;
  protected int ooJ = 0;
  public bo ooz;
  
  public a(g paramg)
  {
    this.ooI = paramg;
  }
  
  public a(g paramg, bo parambo)
  {
    this.ooI = paramg;
    this.ooz = parambo;
  }
  
  public void T(T paramT) {}
  
  public void a(T paramT, int paramInt, a parama) {}
  
  public void a(View paramView, a parama) {}
  
  public final void a(boolean paramBoolean, a parama, T paramT)
  {
    this.ooI.a(paramBoolean, parama, paramT);
  }
  
  protected final com.tencent.mm.plugin.choosemsgfile.b.d.a bUH()
  {
    return this.ooI.bUS().bUH();
  }
  
  public String bUI()
  {
    return "";
  }
  
  public int bUJ()
  {
    return 0;
  }
  
  public final void bUK()
  {
    try
    {
      this.ooJ = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bUL()
  {
    try
    {
      this.ooJ = 3;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bUM()
  {
    try
    {
      this.ooJ = 4;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bUN()
  {
    try
    {
      this.ooJ = 5;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bUO()
  {
    try
    {
      this.ooJ = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean bj()
  {
    return (this.ooJ == 4) || (this.ooJ == 5);
  }
  
  public final void eU(int paramInt1, int paramInt2)
  {
    try
    {
      this.ooJ = 2;
      this.MW = paramInt1;
      this.aoe = paramInt2;
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
    if ((this.ooz != null) && ((paramObject instanceof bo)) && (paramObject != null)) {
      return this.ooz.field_msgId == ((bo)paramObject).field_msgId;
    }
    return super.equals(paramObject);
  }
  
  protected final Context getContext()
  {
    return this.ooI.bUS().getContext();
  }
  
  public String getFileName()
  {
    return "";
  }
  
  public long getTimeStamp()
  {
    return this.ooz.field_createTime;
  }
  
  public abstract int getType();
  
  public final boolean isEnable()
  {
    return (!this.ooI.bUS().bUH().bj()) || (this.ooI.bUS().bUH().rD(this.ooz.field_msgId));
  }
  
  public String toString()
  {
    return "MsgItem{msgInfo=" + this.ooz.field_msgId + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.a
 * JD-Core Version:    0.7.0.1
 */