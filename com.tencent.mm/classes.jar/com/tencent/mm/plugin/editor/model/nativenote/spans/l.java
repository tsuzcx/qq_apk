package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;

public final class l
  extends g
{
  final boolean qTj;
  public final boolean qTk;
  
  public l(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2);
    this.qTj = paramBoolean1;
    this.qTk = paramBoolean2;
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
      if ((paramg.avh >= this.avh) && (paramg.Pc < this.Pc))
      {
        i = 1;
        if ((paramg.avh < this.avh) || (paramg.Pc > this.Pc)) {
          break label98;
        }
      }
      label98:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && ((j == 0) || (!this.qTk))) {
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
    if (Math.max(this.avh, paramg.avh) < Math.min(this.Pc, paramg.Pc))
    {
      AppMethodBeat.o(181946);
      return true;
    }
    AppMethodBeat.o(181946);
    return false;
  }
  
  public final int getLen()
  {
    AppMethodBeat.i(181947);
    int i = Math.abs(this.Pc - this.avh);
    AppMethodBeat.o(181947);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.l
 * JD-Core Version:    0.7.0.1
 */