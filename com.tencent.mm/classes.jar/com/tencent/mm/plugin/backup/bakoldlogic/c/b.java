package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.backup.i.ac;

public final class b
  extends com.tencent.mm.plugin.backup.g.b
{
  private com.tencent.mm.plugin.backup.i.ab jIg;
  private ac jIh;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(17881);
    this.jIg = new com.tencent.mm.plugin.backup.i.ab();
    this.jIh = new ac();
    this.jIg.jJg = paramInt;
    AppMethodBeat.o(17881);
  }
  
  public final a aUl()
  {
    return this.jIh;
  }
  
  public final a aUm()
  {
    return this.jIg;
  }
  
  public final int getType()
  {
    return 3;
  }
  
  public final void rt(int paramInt)
  {
    AppMethodBeat.i(17882);
    if (this.jIh.jJS == 0)
    {
      n(0, 0, "ok");
      AppMethodBeat.o(17882);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", new Object[] { Integer.valueOf(this.jIg.jJg), Integer.valueOf(this.jIh.jJS) });
    n(4, this.jIh.jJS, "fail");
    AppMethodBeat.o(17882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.c.b
 * JD-Core Version:    0.7.0.1
 */