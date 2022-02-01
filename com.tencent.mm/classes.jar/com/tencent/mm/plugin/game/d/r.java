package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends com.tencent.mm.bx.a
{
  public String sak;
  public String sal;
  public String sam;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41720);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sak != null) {
        paramVarArgs.d(1, this.sak);
      }
      if (this.sal != null) {
        paramVarArgs.d(2, this.sal);
      }
      if (this.sam != null) {
        paramVarArgs.d(3, this.sam);
      }
      AppMethodBeat.o(41720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sak == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.sak) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sal != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sal);
      }
      i = paramInt;
      if (this.sam != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sam);
      }
      AppMethodBeat.o(41720);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41720);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41720);
          return -1;
        case 1: 
          localr.sak = locala.KhF.readString();
          AppMethodBeat.o(41720);
          return 0;
        case 2: 
          localr.sal = locala.KhF.readString();
          AppMethodBeat.o(41720);
          return 0;
        }
        localr.sam = locala.KhF.readString();
        AppMethodBeat.o(41720);
        return 0;
      }
      AppMethodBeat.o(41720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.r
 * JD-Core Version:    0.7.0.1
 */