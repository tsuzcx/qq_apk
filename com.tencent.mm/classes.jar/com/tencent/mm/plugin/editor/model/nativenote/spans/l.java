package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.g;

public final class l
  extends g
{
  final boolean pxo;
  public final boolean pxp;
  
  public l(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramInt1, paramInt2);
    this.pxo = paramBoolean1;
    this.pxp = paramBoolean2;
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
      if ((paramg.avj >= this.avj) && (paramg.OQ < this.OQ))
      {
        i = 1;
        if ((paramg.avj < this.avj) || (paramg.OQ > this.OQ)) {
          break label98;
        }
      }
      label98:
      for (int j = 1;; j = 0)
      {
        if ((i == 0) && ((j == 0) || (!this.pxp))) {
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
    if (Math.max(this.avj, paramg.avj) < Math.min(this.OQ, paramg.OQ))
    {
      AppMethodBeat.o(181946);
      return true;
    }
    AppMethodBeat.o(181946);
    return false;
  }
  
  public final int cfs()
  {
    AppMethodBeat.i(181947);
    int i = Math.abs(this.OQ - this.avj);
    AppMethodBeat.o(181947);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.spans.l
 * JD-Core Version:    0.7.0.1
 */