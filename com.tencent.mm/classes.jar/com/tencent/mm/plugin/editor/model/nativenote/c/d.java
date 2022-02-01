package com.tencent.mm.plugin.editor.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;

public final class d
{
  public int dfG;
  public int endPos;
  public int pws;
  public int startOffset;
  
  public d()
  {
    AppMethodBeat.i(181849);
    this.dfG = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.pws = -1;
    set(-1, -1, -1, -1);
    AppMethodBeat.o(181849);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181850);
    this.dfG = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.pws = -1;
    set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(181850);
  }
  
  public final int ceO()
  {
    AppMethodBeat.i(181851);
    if ((this.dfG < 0) || (this.startOffset < 0) || (this.endPos < 0) || (this.pws < 0) || (this.dfG > this.endPos) || ((this.dfG == this.endPos) && (this.startOffset > this.pws)))
    {
      AppMethodBeat.o(181851);
      return 0;
    }
    a locala1 = c.cej().BA(this.dfG);
    a locala2 = c.cej().BA(this.endPos);
    if ((locala1 == null) || (locala2 == null))
    {
      AppMethodBeat.o(181851);
      return 0;
    }
    if ((this.dfG == this.endPos) && (this.startOffset == this.pws))
    {
      AppMethodBeat.o(181851);
      return 1;
    }
    if ((this.dfG == this.endPos) && (locala1.getType() == 1))
    {
      AppMethodBeat.o(181851);
      return 2;
    }
    AppMethodBeat.o(181851);
    return 3;
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.dfG = paramInt1;
    this.startOffset = paramInt2;
    this.endPos = paramInt3;
    this.pws = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */