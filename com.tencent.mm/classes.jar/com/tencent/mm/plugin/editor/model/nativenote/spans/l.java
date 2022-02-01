package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;

public final class l
  extends g
{
  final boolean oTE;
  public final boolean oTF;
  
  public l(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2);
    this.oTE = paramBoolean1;
    this.oTF = paramBoolean2;
  }
  
  public final boolean a(g paramg)
  {
    AppMethodBeat.i(181946);
    if (paramg == null)
    {
      AppMethodBeat.o(181946);
      return false;
    }
    if (paramg.isEmpty())
    {
      int i;
      if ((paramg.atr >= this.atr) && (paramg.MZ < this.MZ))
      {
        i = 1;
        if ((paramg.atr < this.atr) || (paramg.MZ > this.MZ)) {
          break label98;
        }
      }
      label98:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && ((j == 0) || (!this.oTF))) {
          break label103;
        }
        AppMethodBeat.o(181946);
        return true;
        i = 0;
        break;
      }
      label103:
      AppMethodBeat.o(181946);
      return false;
    }
    if (Math.max(this.atr, paramg.atr) < Math.min(this.MZ, paramg.MZ))
    {
      AppMethodBeat.o(181946);
      return true;
    }
    AppMethodBeat.o(181946);
    return false;
  }
  
  public final int caO()
  {
    AppMethodBeat.i(181947);
    int i = Math.abs(this.MZ - this.atr);
    AppMethodBeat.o(181947);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.l
 * JD-Core Version:    0.7.0.1
 */