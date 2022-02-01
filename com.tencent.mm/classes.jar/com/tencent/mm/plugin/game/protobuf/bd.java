package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bd
  extends com.tencent.mm.bw.a
{
  public String xKd;
  public LinkedList<String> xLf;
  
  public bd()
  {
    AppMethodBeat.i(41750);
    this.xLf = new LinkedList();
    AppMethodBeat.o(41750);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41751);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41751);
        throw paramVarArgs;
      }
      if (this.xKd != null) {
        paramVarArgs.e(2, this.xKd);
      }
      paramVarArgs.e(3, 1, this.xLf);
      AppMethodBeat.o(41751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKd == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = g.a.a.b.b.a.f(2, this.xKd) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(3, 1, this.xLf);
      AppMethodBeat.o(41751);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLf.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xKd == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41751);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41751);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bd localbd = (bd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41751);
          return -1;
        case 2: 
          localbd.xKd = locala.UbS.readString();
          AppMethodBeat.o(41751);
          return 0;
        }
        localbd.xLf.add(locala.UbS.readString());
        AppMethodBeat.o(41751);
        return 0;
      }
      AppMethodBeat.o(41751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bd
 * JD-Core Version:    0.7.0.1
 */