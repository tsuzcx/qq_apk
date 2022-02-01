package com.tencent.mm.plugin.groupsolitaire.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;

public final class a
{
  public boolean JiK = false;
  public long JiL = 0L;
  public boolean JiM = false;
  public long JiN = 0L;
  public long lastUpdateTime = 0L;
  
  public final void fJb()
  {
    AppMethodBeat.i(110316);
    this.lastUpdateTime = cn.getSyncServerTimeSecond();
    AppMethodBeat.o(110316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.a
 * JD-Core Version:    0.7.0.1
 */