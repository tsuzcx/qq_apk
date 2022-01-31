package com.tencent.mm.plugin.h;

import com.tencent.mm.h.a.bo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class b$3
  extends c<bo>
{
  b$3(b paramb)
  {
    this.udX = bo.class.getName().hashCode();
  }
  
  private boolean ayM()
  {
    y.i("MicroMsg.CalcWxService", "%s clean wx file index event ", new Object[] { this.ijs.ayL() });
    b.d(this.ijs, true);
    try
    {
      g.DS().O(new b.3.1(this));
      return false;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.CalcWxService", localException, "%s clean wx file error", new Object[] { this.ijs.ayL() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.h.b.3
 * JD-Core Version:    0.7.0.1
 */