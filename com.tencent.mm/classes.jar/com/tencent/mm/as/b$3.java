package com.tencent.mm.as;

import com.tencent.mm.h.a.u;
import com.tencent.mm.h.a.u.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Stack;

final class b$3
  extends com.tencent.mm.sdk.b.c<u>
{
  b$3(b paramb)
  {
    this.udX = u.class.getName().hashCode();
  }
  
  private boolean a(u arg1)
  {
    this.emZ.emV = ???.bFT.mode;
    y.d("MicroMsg.AutoGetBigImgLogic", "mode = " + this.emZ.emV);
    com.tencent.mm.modelcontrol.c.Ni();
    if (!com.tencent.mm.modelcontrol.c.Nj()) {
      synchronized (this.emZ.emL)
      {
        this.emZ.emL.clear();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.b.3
 * JD-Core Version:    0.7.0.1
 */