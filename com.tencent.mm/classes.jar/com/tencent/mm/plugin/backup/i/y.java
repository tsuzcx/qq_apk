package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class y
  extends com.tencent.mm.bx.a
{
  public String vhN;
  public int vhO;
  public int vhQ;
  public int vhR;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22130);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhN == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22130);
        throw paramVarArgs;
      }
      if (this.vhN != null) {
        paramVarArgs.g(1, this.vhN);
      }
      paramVarArgs.bS(2, this.vhO);
      paramVarArgs.bS(3, this.vhQ);
      paramVarArgs.bS(4, this.vhR);
      paramVarArgs.bS(5, this.vhk);
      AppMethodBeat.o(22130);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhN == null) {
        break label453;
      }
    }
    label453:
    for (paramInt = i.a.a.b.b.a.h(1, this.vhN) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vhO);
      int j = i.a.a.b.b.a.cJ(3, this.vhQ);
      int k = i.a.a.b.b.a.cJ(4, this.vhR);
      int m = i.a.a.b.b.a.cJ(5, this.vhk);
      AppMethodBeat.o(22130);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vhN == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataID");
          AppMethodBeat.o(22130);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22130);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22130);
          return -1;
        case 1: 
          localy.vhN = locala.ajGk.readString();
          AppMethodBeat.o(22130);
          return 0;
        case 2: 
          localy.vhO = locala.ajGk.aar();
          AppMethodBeat.o(22130);
          return 0;
        case 3: 
          localy.vhQ = locala.ajGk.aar();
          AppMethodBeat.o(22130);
          return 0;
        case 4: 
          localy.vhR = locala.ajGk.aar();
          AppMethodBeat.o(22130);
          return 0;
        }
        localy.vhk = locala.ajGk.aar();
        AppMethodBeat.o(22130);
        return 0;
      }
      AppMethodBeat.o(22130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.y
 * JD-Core Version:    0.7.0.1
 */