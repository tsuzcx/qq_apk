package com.tencent.mm.plugin.editor.model.nativenote.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.nativenote.manager.c;

public final class d
{
  public int bPt;
  public int endPos;
  public int lPo;
  public int uuu;
  
  public d()
  {
    AppMethodBeat.i(181849);
    this.bPt = -1;
    this.lPo = -1;
    this.endPos = -1;
    this.uuu = -1;
    E(-1, -1, -1, -1);
    AppMethodBeat.o(181849);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181850);
    this.bPt = -1;
    this.lPo = -1;
    this.endPos = -1;
    this.uuu = -1;
    E(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(181850);
  }
  
  public final void E(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.bPt = paramInt1;
    this.lPo = paramInt2;
    this.endPos = paramInt3;
    this.uuu = paramInt4;
  }
  
  public final int getSelectType()
  {
    AppMethodBeat.i(181851);
    if ((this.bPt < 0) || (this.lPo < 0) || (this.endPos < 0) || (this.uuu < 0) || (this.bPt > this.endPos) || ((this.bPt == this.endPos) && (this.lPo > this.uuu)))
    {
      AppMethodBeat.o(181851);
      return 0;
    }
    a locala1 = c.cRT().Jd(this.bPt);
    a locala2 = c.cRT().Jd(this.endPos);
    if ((locala1 == null) || (locala2 == null))
    {
      AppMethodBeat.o(181851);
      return 0;
    }
    if ((this.bPt == this.endPos) && (this.lPo == this.uuu))
    {
      AppMethodBeat.o(181851);
      return 1;
    }
    if ((this.bPt == this.endPos) && (locala1.getType() == 1))
    {
      AppMethodBeat.o(181851);
      return 2;
    }
    AppMethodBeat.o(181851);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.d
 * JD-Core Version:    0.7.0.1
 */