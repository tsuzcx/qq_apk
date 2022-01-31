package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ar
  extends com.tencent.mm.bv.a
{
  public String nqY;
  public LinkedList<String> nrP;
  
  public ar()
  {
    AppMethodBeat.i(111585);
    this.nrP = new LinkedList();
    AppMethodBeat.o(111585);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111586);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(111586);
        throw paramVarArgs;
      }
      if (this.nqY != null) {
        paramVarArgs.e(2, this.nqY);
      }
      paramVarArgs.e(3, 1, this.nrP);
      AppMethodBeat.o(111586);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqY == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = e.a.a.b.b.a.f(2, this.nqY) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(3, 1, this.nrP);
      AppMethodBeat.o(111586);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nrP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nqY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(111586);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111586);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ar localar = (ar)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111586);
          return -1;
        case 2: 
          localar.nqY = locala.CLY.readString();
          AppMethodBeat.o(111586);
          return 0;
        }
        localar.nrP.add(locala.CLY.readString());
        AppMethodBeat.o(111586);
        return 0;
      }
      AppMethodBeat.o(111586);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ar
 * JD-Core Version:    0.7.0.1
 */