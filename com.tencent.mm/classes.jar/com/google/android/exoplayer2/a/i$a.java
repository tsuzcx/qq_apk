package com.google.android.exoplayer2.a;

import android.os.Handler;

final class i$a
  implements f.f
{
  private i$a(i parami) {}
  
  public final void cC(int paramInt)
  {
    e.a locala = i.a(this.axQ);
    if (locala.avZ != null) {
      locala.handler.post(new e.a.6(locala, paramInt));
    }
    i.ls();
  }
  
  public final void d(int paramInt, long paramLong1, long paramLong2)
  {
    e.a locala = i.a(this.axQ);
    if (locala.avZ != null) {
      locala.handler.post(new e.a.4(locala, paramInt, paramLong1, paramLong2));
    }
    i.lu();
  }
  
  public final void kT()
  {
    i.lt();
    i.b(this.axQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.a.i.a
 * JD-Core Version:    0.7.0.1
 */