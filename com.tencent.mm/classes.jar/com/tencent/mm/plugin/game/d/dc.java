package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class dc
  extends com.tencent.mm.bv.a
{
  public String Name;
  public int nsX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111670);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(111670);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.nsX);
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      AppMethodBeat.o(111670);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nsX) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Name);
      }
      AppMethodBeat.o(111670);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(111670);
        throw paramVarArgs;
      }
      AppMethodBeat.o(111670);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dc localdc = (dc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111670);
        return -1;
      case 1: 
        localdc.nsX = locala.CLY.sl();
        AppMethodBeat.o(111670);
        return 0;
      }
      localdc.Name = locala.CLY.readString();
      AppMethodBeat.o(111670);
      return 0;
    }
    AppMethodBeat.o(111670);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dc
 * JD-Core Version:    0.7.0.1
 */