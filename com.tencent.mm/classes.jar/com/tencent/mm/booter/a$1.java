package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  implements at.a
{
  a$1(a parama) {}
  
  public final void fQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      y.v("MicroMsg.BackgroundPlayer", "call end");
      this.dho.vS();
      return;
    }
    y.v("MicroMsg.BackgroundPlayer", "call start");
    this.dho.vT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.a.1
 * JD-Core Version:    0.7.0.1
 */