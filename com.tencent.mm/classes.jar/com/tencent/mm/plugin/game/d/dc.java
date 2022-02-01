package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dc
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String rZn;
  public String rZo;
  public int sdL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.rZo != null) {
        paramVarArgs.d(2, this.rZo);
      }
      if (this.rZn != null) {
        paramVarArgs.d(3, this.rZn);
      }
      paramVarArgs.aR(4, this.sdL);
      AppMethodBeat.o(41834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rZo);
      }
      i = paramInt;
      if (this.rZn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rZn);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.sdL);
      AppMethodBeat.o(41834);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41834);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dc localdc = (dc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41834);
          return -1;
        case 1: 
          localdc.Title = locala.KhF.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 2: 
          localdc.rZo = locala.KhF.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 3: 
          localdc.rZn = locala.KhF.readString();
          AppMethodBeat.o(41834);
          return 0;
        }
        localdc.sdL = locala.KhF.xS();
        AppMethodBeat.o(41834);
        return 0;
      }
      AppMethodBeat.o(41834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dc
 * JD-Core Version:    0.7.0.1
 */