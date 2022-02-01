package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dt
  extends com.tencent.mm.bw.a
{
  public String Name;
  public int utV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41835);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41835);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.utV);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      AppMethodBeat.o(41835);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.utV) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      AppMethodBeat.o(41835);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41835);
        throw paramVarArgs;
      }
      AppMethodBeat.o(41835);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dt localdt = (dt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41835);
        return -1;
      case 1: 
        localdt.utV = locala.OmT.zc();
        AppMethodBeat.o(41835);
        return 0;
      }
      localdt.Name = locala.OmT.readString();
      AppMethodBeat.o(41835);
      return 0;
    }
    AppMethodBeat.o(41835);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dt
 * JD-Core Version:    0.7.0.1
 */