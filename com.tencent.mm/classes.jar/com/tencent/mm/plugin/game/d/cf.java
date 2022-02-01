package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cf
  extends com.tencent.mm.bx.a
{
  public String dDH;
  public String desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dDH != null) {
        paramVarArgs.d(1, this.dDH);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dDH == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.dDH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41798);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cf localcf = (cf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41798);
          return -1;
        case 1: 
          localcf.dDH = locala.NPN.readString();
          AppMethodBeat.o(41798);
          return 0;
        }
        localcf.desc = locala.NPN.readString();
        AppMethodBeat.o(41798);
        return 0;
      }
      AppMethodBeat.o(41798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cf
 * JD-Core Version:    0.7.0.1
 */