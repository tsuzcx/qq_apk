package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dc
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41816);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Desc != null) {
        paramVarArgs.d(1, this.Desc);
      }
      if (this.uqf != null) {
        paramVarArgs.d(2, this.uqf);
      }
      AppMethodBeat.o(41816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uqf);
      }
      AppMethodBeat.o(41816);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41816);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dc localdc = (dc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41816);
          return -1;
        case 1: 
          localdc.Desc = locala.OmT.readString();
          AppMethodBeat.o(41816);
          return 0;
        }
        localdc.uqf = locala.OmT.readString();
        AppMethodBeat.o(41816);
        return 0;
      }
      AppMethodBeat.o(41816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dc
 * JD-Core Version:    0.7.0.1
 */