package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bw.a
{
  public String jTB;
  public String pTL;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153076);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.jTB != null) {
        paramVarArgs.e(2, this.jTB);
      }
      if (this.pTL != null) {
        paramVarArgs.e(3, this.pTL);
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.jTB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.jTB);
      }
      i = paramInt;
      if (this.pTL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.pTL);
      }
      AppMethodBeat.o(153076);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153076);
        return -1;
      case 1: 
        localp.type = locala.UbS.zi();
        AppMethodBeat.o(153076);
        return 0;
      case 2: 
        localp.jTB = locala.UbS.readString();
        AppMethodBeat.o(153076);
        return 0;
      }
      localp.pTL = locala.UbS.readString();
      AppMethodBeat.o(153076);
      return 0;
    }
    AppMethodBeat.o(153076);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.p
 * JD-Core Version:    0.7.0.1
 */