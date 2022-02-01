package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ad
  extends com.tencent.mm.bx.a
{
  public String vhN;
  public int vhO;
  public int vhQ;
  public int vhR;
  public int vhT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22136);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhN == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22136);
        throw paramVarArgs;
      }
      if (this.vhN != null) {
        paramVarArgs.g(1, this.vhN);
      }
      paramVarArgs.bS(2, this.vhO);
      paramVarArgs.bS(3, this.vhQ);
      paramVarArgs.bS(4, this.vhR);
      paramVarArgs.bS(5, this.vhT);
      AppMethodBeat.o(22136);
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
      int m = i.a.a.b.b.a.cJ(5, this.vhT);
      AppMethodBeat.o(22136);
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
          AppMethodBeat.o(22136);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22136);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22136);
          return -1;
        case 1: 
          localad.vhN = locala.ajGk.readString();
          AppMethodBeat.o(22136);
          return 0;
        case 2: 
          localad.vhO = locala.ajGk.aar();
          AppMethodBeat.o(22136);
          return 0;
        case 3: 
          localad.vhQ = locala.ajGk.aar();
          AppMethodBeat.o(22136);
          return 0;
        case 4: 
          localad.vhR = locala.ajGk.aar();
          AppMethodBeat.o(22136);
          return 0;
        }
        localad.vhT = locala.ajGk.aar();
        AppMethodBeat.o(22136);
        return 0;
      }
      AppMethodBeat.o(22136);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ad
 * JD-Core Version:    0.7.0.1
 */