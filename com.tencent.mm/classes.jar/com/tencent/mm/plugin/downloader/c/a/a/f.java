package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String pTL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153047);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.e(1, this.desc);
      }
      if (this.pTL != null) {
        paramVarArgs.e(2, this.pTL);
      }
      AppMethodBeat.o(153047);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pTL != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pTL);
      }
      AppMethodBeat.o(153047);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153047);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153047);
          return -1;
        case 1: 
          localf.desc = locala.UbS.readString();
          AppMethodBeat.o(153047);
          return 0;
        }
        localf.pTL = locala.UbS.readString();
        AppMethodBeat.o(153047);
        return 0;
      }
      AppMethodBeat.o(153047);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.f
 * JD-Core Version:    0.7.0.1
 */