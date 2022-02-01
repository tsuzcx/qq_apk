package com.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s$a
  implements Runnable
{
  final int bZk;
  final float cae;
  final float caf;
  final String cag;
  final float x;
  final float y;
  
  private s$a(s params, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, String paramString)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.cae = paramFloat3;
    this.caf = paramFloat4;
    this.bZk = paramInt;
    this.cag = paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(87999);
    this.cah.a(this.x, this.y, this.cae, this.caf, this.bZk, this.cag);
    AppMethodBeat.o(87999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.s.a
 * JD-Core Version:    0.7.0.1
 */