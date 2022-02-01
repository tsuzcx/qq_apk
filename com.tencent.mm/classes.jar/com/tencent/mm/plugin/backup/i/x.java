package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.cd.a
{
  public com.tencent.mm.cd.b rVk;
  public int rWA;
  public int rWB;
  public int rWC;
  public int rWD;
  public int rWE;
  public String rWy;
  public int rWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22129);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22129);
        throw paramVarArgs;
      }
      if (this.rWy != null) {
        paramVarArgs.f(1, this.rWy);
      }
      paramVarArgs.aY(2, this.rWz);
      paramVarArgs.aY(3, this.rWA);
      paramVarArgs.aY(4, this.rWB);
      paramVarArgs.aY(5, this.rWC);
      paramVarArgs.aY(6, this.rWD);
      if (this.rVk != null) {
        paramVarArgs.c(7, this.rVk);
      }
      paramVarArgs.aY(8, this.rWE);
      AppMethodBeat.o(22129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWy == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = g.a.a.b.b.a.g(1, this.rWy) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWz) + g.a.a.b.b.a.bM(3, this.rWA) + g.a.a.b.b.a.bM(4, this.rWB) + g.a.a.b.b.a.bM(5, this.rWC) + g.a.a.b.b.a.bM(6, this.rWD);
      paramInt = i;
      if (this.rVk != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.rVk);
      }
      i = g.a.a.b.b.a.bM(8, this.rWE);
      AppMethodBeat.o(22129);
      return paramInt + i;
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
          AppMethodBeat.o(22129);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22129);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22129);
          return -1;
        case 1: 
          localx.rWy = locala.abFh.readString();
          AppMethodBeat.o(22129);
          return 0;
        case 2: 
          localx.rWz = locala.abFh.AK();
          AppMethodBeat.o(22129);
          return 0;
        case 3: 
          localx.rWA = locala.abFh.AK();
          AppMethodBeat.o(22129);
          return 0;
        case 4: 
          localx.rWB = locala.abFh.AK();
          AppMethodBeat.o(22129);
          return 0;
        case 5: 
          localx.rWC = locala.abFh.AK();
          AppMethodBeat.o(22129);
          return 0;
        case 6: 
          localx.rWD = locala.abFh.AK();
          AppMethodBeat.o(22129);
          return 0;
        case 7: 
          localx.rVk = locala.abFh.iUw();
          AppMethodBeat.o(22129);
          return 0;
        }
        localx.rWE = locala.abFh.AK();
        AppMethodBeat.o(22129);
        return 0;
      }
      AppMethodBeat.o(22129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.x
 * JD-Core Version:    0.7.0.1
 */