package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public int odq;
  public String rNH;
  public String rNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40867);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rNH != null) {
        paramVarArgs.d(1, this.rNH);
      }
      if (this.rNI != null) {
        paramVarArgs.d(2, this.rNI);
      }
      paramVarArgs.aR(3, this.odq);
      AppMethodBeat.o(40867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rNH == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.rNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rNI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rNI);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.odq);
      AppMethodBeat.o(40867);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(40867);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40867);
          return -1;
        case 1: 
          locald.rNH = locala.KhF.readString();
          AppMethodBeat.o(40867);
          return 0;
        case 2: 
          locald.rNI = locala.KhF.readString();
          AppMethodBeat.o(40867);
          return 0;
        }
        locald.odq = locala.KhF.xS();
        AppMethodBeat.o(40867);
        return 0;
      }
      AppMethodBeat.o(40867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.d
 * JD-Core Version:    0.7.0.1
 */