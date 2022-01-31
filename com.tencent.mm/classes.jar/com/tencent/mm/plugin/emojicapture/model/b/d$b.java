package com.tencent.mm.plugin.emojicapture.model.b;

import com.tencent.mm.plugin.gif.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class d$b
  implements Runnable
{
  d$b(d paramd, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    long l = bk.UZ();
    boolean bool = d.a(this.jkQ).c(this.jkS, this.jkT);
    y.i(d.b(this.jkQ), "encodeRgbaFrame used " + bk.cp(l) + ", ret:" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.d.b
 * JD-Core Version:    0.7.0.1
 */