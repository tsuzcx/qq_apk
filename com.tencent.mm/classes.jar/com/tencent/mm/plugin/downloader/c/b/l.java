package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public boolean oHp;
  public String oHq;
  public String oHr;
  public String oHs;
  public int oHt;
  public boolean oHu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153072);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.oHp);
      if (this.oHq != null) {
        paramVarArgs.d(2, this.oHq);
      }
      if (this.oHr != null) {
        paramVarArgs.d(3, this.oHr);
      }
      if (this.oHs != null) {
        paramVarArgs.d(4, this.oHs);
      }
      paramVarArgs.aR(5, this.oHt);
      paramVarArgs.bl(6, this.oHu);
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0;
      paramInt = i;
      if (this.oHq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oHq);
      }
      i = paramInt;
      if (this.oHr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oHr);
      }
      paramInt = i;
      if (this.oHs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oHs);
      }
      i = f.a.a.b.b.a.bx(5, this.oHt);
      int j = f.a.a.b.b.a.fK(6);
      AppMethodBeat.o(153072);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153072);
        return -1;
      case 1: 
        locall.oHp = locala.LVo.fZX();
        AppMethodBeat.o(153072);
        return 0;
      case 2: 
        locall.oHq = locala.LVo.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 3: 
        locall.oHr = locala.LVo.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 4: 
        locall.oHs = locala.LVo.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 5: 
        locall.oHt = locala.LVo.xF();
        AppMethodBeat.o(153072);
        return 0;
      }
      locall.oHu = locala.LVo.fZX();
      AppMethodBeat.o(153072);
      return 0;
    }
    AppMethodBeat.o(153072);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.l
 * JD-Core Version:    0.7.0.1
 */