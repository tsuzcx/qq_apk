package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dv
  extends com.tencent.mm.bw.a
{
  public String hDr;
  public String uph;
  public String uvn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hDr != null) {
        paramVarArgs.d(1, this.hDr);
      }
      if (this.uph != null) {
        paramVarArgs.d(2, this.uph);
      }
      if (this.uvn != null) {
        paramVarArgs.d(3, this.uvn);
      }
      AppMethodBeat.o(149418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hDr == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.hDr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uph != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uph);
      }
      i = paramInt;
      if (this.uvn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvn);
      }
      AppMethodBeat.o(149418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(149418);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149418);
          return -1;
        case 1: 
          localdv.hDr = locala.OmT.readString();
          AppMethodBeat.o(149418);
          return 0;
        case 2: 
          localdv.uph = locala.OmT.readString();
          AppMethodBeat.o(149418);
          return 0;
        }
        localdv.uvn = locala.OmT.readString();
        AppMethodBeat.o(149418);
        return 0;
      }
      AppMethodBeat.o(149418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dv
 * JD-Core Version:    0.7.0.1
 */