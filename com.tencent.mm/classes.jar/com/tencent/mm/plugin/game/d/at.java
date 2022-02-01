package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class at
  extends com.tencent.mm.bx.a
{
  public String saB;
  public LinkedList<String> sbu;
  
  public at()
  {
    AppMethodBeat.i(41750);
    this.sbu = new LinkedList();
    AppMethodBeat.o(41750);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41751);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.saB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41751);
        throw paramVarArgs;
      }
      if (this.saB != null) {
        paramVarArgs.d(2, this.saB);
      }
      paramVarArgs.e(3, 1, this.sbu);
      AppMethodBeat.o(41751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.saB == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(2, this.saB) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(3, 1, this.sbu);
      AppMethodBeat.o(41751);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sbu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.saB == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        at localat = (at)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41751);
          return -1;
        case 2: 
          localat.saB = locala.KhF.readString();
          AppMethodBeat.o(41751);
          return 0;
        }
        localat.sbu.add(locala.KhF.readString());
        AppMethodBeat.o(41751);
        return 0;
      }
      AppMethodBeat.o(41751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.at
 * JD-Core Version:    0.7.0.1
 */