package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class y
  extends com.tencent.mm.bw.a
{
  public int oTW;
  public int oUA;
  public int oUC;
  public int oUD;
  public String oUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22130);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUz == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22130);
        throw paramVarArgs;
      }
      if (this.oUz != null) {
        paramVarArgs.e(1, this.oUz);
      }
      paramVarArgs.aM(2, this.oUA);
      paramVarArgs.aM(3, this.oUC);
      paramVarArgs.aM(4, this.oUD);
      paramVarArgs.aM(5, this.oTW);
      AppMethodBeat.o(22130);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUz == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = g.a.a.b.b.a.f(1, this.oUz) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oUA);
      int j = g.a.a.b.b.a.bu(3, this.oUC);
      int k = g.a.a.b.b.a.bu(4, this.oUD);
      int m = g.a.a.b.b.a.bu(5, this.oTW);
      AppMethodBeat.o(22130);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oUz == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22130);
          return -1;
        case 1: 
          localy.oUz = locala.UbS.readString();
          AppMethodBeat.o(22130);
          return 0;
        case 2: 
          localy.oUA = locala.UbS.zi();
          AppMethodBeat.o(22130);
          return 0;
        case 3: 
          localy.oUC = locala.UbS.zi();
          AppMethodBeat.o(22130);
          return 0;
        case 4: 
          localy.oUD = locala.UbS.zi();
          AppMethodBeat.o(22130);
          return 0;
        }
        localy.oTW = locala.UbS.zi();
        AppMethodBeat.o(22130);
        return 0;
      }
      AppMethodBeat.o(22130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.y
 * JD-Core Version:    0.7.0.1
 */