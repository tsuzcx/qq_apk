package com.tencent.d.e.a;

import android.content.Context;
import com.tencent.d.e.a.a.f;

public final class d$a
{
  int action = 0;
  Context context;
  int requestType = 0;
  long ugs = 0L;
  int wMX = 0;
  public long wMY = f.wNq * 12L;
  
  private d$a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("scenes invalid: " + paramInt1);
    }
    this.context = paramContext.getApplicationContext();
    this.wMX = paramInt1;
    this.action = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.d.e.a.d.a
 * JD-Core Version:    0.7.0.1
 */