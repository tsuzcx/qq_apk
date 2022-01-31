package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private ab hOE = new ab();
  private ac hOF = new ac();
  
  public b(int paramInt)
  {
    this.hOE.hPE = paramInt;
  }
  
  public final a auJ()
  {
    return this.hOF;
  }
  
  public final a auK()
  {
    return this.hOE;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void nF(int paramInt)
  {
    if (this.hOF.hQq == 0)
    {
      j(0, 0, "ok");
      return;
    }
    y.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.hOE.hPE), Integer.valueOf(this.hOF.hQq) });
    j(4, this.hOF.hQq, "fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */