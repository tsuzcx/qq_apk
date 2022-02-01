package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ct
  extends com.tencent.mm.bx.a
{
  public String ufb;
  public String ujo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ujo != null) {
        paramVarArgs.d(1, this.ujo);
      }
      if (this.ufb != null) {
        paramVarArgs.d(2, this.ufb);
      }
      AppMethodBeat.o(41815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ujo == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.ujo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ufb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ufb);
      }
      AppMethodBeat.o(41815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41815);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ct localct = (ct)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41815);
          return -1;
        case 1: 
          localct.ujo = locala.NPN.readString();
          AppMethodBeat.o(41815);
          return 0;
        }
        localct.ufb = locala.NPN.readString();
        AppMethodBeat.o(41815);
        return 0;
      }
      AppMethodBeat.o(41815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ct
 * JD-Core Version:    0.7.0.1
 */