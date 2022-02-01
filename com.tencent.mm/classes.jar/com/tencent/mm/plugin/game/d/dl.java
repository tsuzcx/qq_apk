package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dl
  extends com.tencent.mm.bx.a
{
  public String Name;
  public int uix;
  
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
      paramVarArgs.aS(1, this.uix);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      AppMethodBeat.o(41835);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uix) + 0;
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
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
      dl localdl = (dl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(41835);
        return -1;
      case 1: 
        localdl.uix = locala.NPN.zc();
        AppMethodBeat.o(41835);
        return 0;
      }
      localdl.Name = locala.NPN.readString();
      AppMethodBeat.o(41835);
      return 0;
    }
    AppMethodBeat.o(41835);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dl
 * JD-Core Version:    0.7.0.1
 */