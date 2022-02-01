package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.cd.a
{
  public int rVU;
  public com.tencent.mm.cd.b rVk;
  public int rWB;
  public int rWC;
  public int rWD;
  public String rWy;
  public int rWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22137);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22137);
        throw paramVarArgs;
      }
      if (this.rWy != null) {
        paramVarArgs.f(1, this.rWy);
      }
      paramVarArgs.aY(2, this.rWz);
      paramVarArgs.aY(3, this.rWB);
      paramVarArgs.aY(4, this.rWC);
      paramVarArgs.aY(5, this.rVU);
      paramVarArgs.aY(6, this.rWD);
      if (this.rVk != null) {
        paramVarArgs.c(7, this.rVk);
      }
      AppMethodBeat.o(22137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWy == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = g.a.a.b.b.a.g(1, this.rWy) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWz) + g.a.a.b.b.a.bM(3, this.rWB) + g.a.a.b.b.a.bM(4, this.rWC) + g.a.a.b.b.a.bM(5, this.rVU) + g.a.a.b.b.a.bM(6, this.rWD);
      paramInt = i;
      if (this.rVk != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.rVk);
      }
      AppMethodBeat.o(22137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.rWy == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: DataID");
          AppMethodBeat.o(22137);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22137);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22137);
          return -1;
        case 1: 
          localae.rWy = locala.abFh.readString();
          AppMethodBeat.o(22137);
          return 0;
        case 2: 
          localae.rWz = locala.abFh.AK();
          AppMethodBeat.o(22137);
          return 0;
        case 3: 
          localae.rWB = locala.abFh.AK();
          AppMethodBeat.o(22137);
          return 0;
        case 4: 
          localae.rWC = locala.abFh.AK();
          AppMethodBeat.o(22137);
          return 0;
        case 5: 
          localae.rVU = locala.abFh.AK();
          AppMethodBeat.o(22137);
          return 0;
        case 6: 
          localae.rWD = locala.abFh.AK();
          AppMethodBeat.o(22137);
          return 0;
        }
        localae.rVk = locala.abFh.iUw();
        AppMethodBeat.o(22137);
        return 0;
      }
      AppMethodBeat.o(22137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */