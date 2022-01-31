package com.tencent.mm.plugin.appbrand.widget.recyclerview;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.c;
import java.util.List;

final class a$1
  extends RecyclerView.c
{
  a$1(a parama) {}
  
  public final void al(int paramInt1, int paramInt2)
  {
    if (a.a(this.hDM).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.hDM.ah(i + paramInt1, paramInt2);
      return;
    }
  }
  
  public final void am(int paramInt1, int paramInt2)
  {
    if (a.a(this.hDM).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.hDM.aj(i + paramInt1, paramInt2);
      return;
    }
  }
  
  public final void an(int paramInt1, int paramInt2)
  {
    if (a.a(this.hDM).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.hDM.ak(i + paramInt1, paramInt2);
      return;
    }
  }
  
  public final void ao(int paramInt1, int paramInt2)
  {
    int j = 0;
    a locala = this.hDM;
    int i;
    if (a.a(this.hDM).isEmpty())
    {
      i = 0;
      if (!a.a(this.hDM).isEmpty()) {
        break label59;
      }
    }
    for (;;)
    {
      locala.ai(i + paramInt1, j + paramInt2);
      return;
      i = 1;
      break;
      label59:
      j = 1;
    }
  }
  
  public final void d(int paramInt1, int paramInt2, Object paramObject)
  {
    if (a.a(this.hDM).isEmpty()) {}
    for (int i = 0;; i = 1)
    {
      this.hDM.c(i + paramInt1, paramInt2, paramObject);
      return;
    }
  }
  
  public final void onChanged()
  {
    this.hDM.agL.notifyChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recyclerview.a.1
 * JD-Core Version:    0.7.0.1
 */