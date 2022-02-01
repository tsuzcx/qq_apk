package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class k
  extends com.tencent.mm.bw.a
{
  public String UserName;
  public int oTD;
  public int oTE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22114);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.oTD);
      paramVarArgs.aM(2, this.oTE);
      if (this.UserName != null) {
        paramVarArgs.e(3, this.UserName);
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.oTD) + 0 + g.a.a.b.b.a.bu(2, this.oTE);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.UserName);
      }
      AppMethodBeat.o(22114);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22114);
        return -1;
      case 1: 
        localk.oTD = locala.UbS.zi();
        AppMethodBeat.o(22114);
        return 0;
      case 2: 
        localk.oTE = locala.UbS.zi();
        AppMethodBeat.o(22114);
        return 0;
      }
      localk.UserName = locala.UbS.readString();
      AppMethodBeat.o(22114);
      return 0;
    }
    AppMethodBeat.o(22114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.k
 * JD-Core Version:    0.7.0.1
 */