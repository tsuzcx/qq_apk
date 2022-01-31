package com.tencent.liteav.beauty.a.a;

import android.view.Surface;

public class c
  extends b
{
  private Surface b;
  private boolean c;
  
  public c(a parama, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(parama);
    a(paramInt1, paramInt2);
    this.c = paramBoolean;
  }
  
  public void c()
  {
    a();
    if (this.b != null)
    {
      if (this.c) {
        this.b.release();
      }
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.a.a.c
 * JD-Core Version:    0.7.0.1
 */