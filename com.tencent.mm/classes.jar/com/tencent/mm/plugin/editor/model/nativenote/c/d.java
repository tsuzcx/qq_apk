package com.tencent.mm.plugin.editor.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;

public final class d
{
  public int bNu;
  public int endPos;
  public int qSo;
  public int startOffset;
  
  public d()
  {
    AppMethodBeat.i(181849);
    this.bNu = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.qSo = -1;
    set(-1, -1, -1, -1);
    AppMethodBeat.o(181849);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181850);
    this.bNu = -1;
    this.startOffset = -1;
    this.endPos = -1;
    this.qSo = -1;
    set(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(181850);
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(181851);
    if ((this.bNu < 0) || (this.startOffset < 0) || (this.endPos < 0) || (this.qSo < 0) || (this.bNu > this.endPos) || ((this.bNu == this.endPos) && (this.startOffset > this.qSo)))
    {
      AppMethodBeat.o(181851);
      return 0;
    }
    a locala1 = c.cDo().Fw(this.bNu);
    a locala2 = c.cDo().Fw(this.endPos);
    if ((locala1 == null) || (locala2 == null))
    {
      AppMethodBeat.o(181851);
      return 0;
    }
    if ((this.bNu == this.endPos) && (this.startOffset == this.qSo))
    {
      AppMethodBeat.o(181851);
      return 1;
    }
    if ((this.bNu == this.endPos) && (locala1.getType() == 1))
    {
      AppMethodBeat.o(181851);
      return 2;
    }
    AppMethodBeat.o(181851);
    return 3;
  }
  
  public final void set(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bNu = paramInt1;
    this.startOffset = paramInt2;
    this.endPos = paramInt3;
    this.qSo = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */