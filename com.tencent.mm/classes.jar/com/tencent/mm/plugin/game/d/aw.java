package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aw
  extends com.tencent.mm.bx.a
{
  public String ugo;
  public LinkedList<String> uho;
  
  public aw()
  {
    AppMethodBeat.i(41750);
    this.uho = new LinkedList();
    AppMethodBeat.o(41750);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41751);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ugo == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41751);
        throw paramVarArgs;
      }
      if (this.ugo != null) {
        paramVarArgs.d(2, this.ugo);
      }
      paramVarArgs.e(3, 1, this.uho);
      AppMethodBeat.o(41751);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ugo == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(2, this.ugo) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(3, 1, this.uho);
      AppMethodBeat.o(41751);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uho.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ugo == null)
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
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41751);
          return -1;
        case 2: 
          localaw.ugo = locala.NPN.readString();
          AppMethodBeat.o(41751);
          return 0;
        }
        localaw.uho.add(locala.NPN.readString());
        AppMethodBeat.o(41751);
        return 0;
      }
      AppMethodBeat.o(41751);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aw
 * JD-Core Version:    0.7.0.1
 */