package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public String Idh;
  public String Idi;
  public int xlL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40867);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Idh != null) {
        paramVarArgs.g(1, this.Idh);
      }
      if (this.Idi != null) {
        paramVarArgs.g(2, this.Idi);
      }
      paramVarArgs.bS(3, this.xlL);
      AppMethodBeat.o(40867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Idh == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.Idh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Idi != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Idi);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.xlL);
      AppMethodBeat.o(40867);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(40867);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40867);
          return -1;
        case 1: 
          locald.Idh = locala.ajGk.readString();
          AppMethodBeat.o(40867);
          return 0;
        case 2: 
          locald.Idi = locala.ajGk.readString();
          AppMethodBeat.o(40867);
          return 0;
        }
        locald.xlL = locala.ajGk.aar();
        AppMethodBeat.o(40867);
        return 0;
      }
      AppMethodBeat.o(40867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.d
 * JD-Core Version:    0.7.0.1
 */