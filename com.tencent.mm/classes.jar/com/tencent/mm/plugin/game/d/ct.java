package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ct
  extends com.tencent.mm.bw.a
{
  public int uqI;
  public String uqf;
  public int uuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221892);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uuz);
      paramVarArgs.aS(2, this.uqI);
      if (this.uqf != null) {
        paramVarArgs.d(3, this.uqf);
      }
      AppMethodBeat.o(221892);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uuz) + 0 + f.a.a.b.b.a.bz(2, this.uqI);
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uqf);
      }
      AppMethodBeat.o(221892);
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
      AppMethodBeat.o(221892);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ct localct = (ct)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(221892);
        return -1;
      case 1: 
        localct.uuz = locala.OmT.zc();
        AppMethodBeat.o(221892);
        return 0;
      case 2: 
        localct.uqI = locala.OmT.zc();
        AppMethodBeat.o(221892);
        return 0;
      }
      localct.uqf = locala.OmT.readString();
      AppMethodBeat.o(221892);
      return 0;
    }
    AppMethodBeat.o(221892);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ct
 * JD-Core Version:    0.7.0.1
 */