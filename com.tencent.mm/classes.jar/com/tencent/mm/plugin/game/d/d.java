package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public String ikm;
  public String uqj;
  public String uqk;
  public String uql;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221873);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.uqj != null) {
        paramVarArgs.d(2, this.uqj);
      }
      if (this.uqk != null) {
        paramVarArgs.d(3, this.uqk);
      }
      if (this.uql != null) {
        paramVarArgs.d(4, this.uql);
      }
      AppMethodBeat.o(221873);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.ikm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.uqj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqj);
      }
      i = paramInt;
      if (this.uqk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqk);
      }
      paramInt = i;
      if (this.uql != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uql);
      }
      AppMethodBeat.o(221873);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(221873);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(221873);
          return -1;
        case 1: 
          locald.ikm = locala.OmT.readString();
          AppMethodBeat.o(221873);
          return 0;
        case 2: 
          locald.uqj = locala.OmT.readString();
          AppMethodBeat.o(221873);
          return 0;
        case 3: 
          locald.uqk = locala.OmT.readString();
          AppMethodBeat.o(221873);
          return 0;
        }
        locald.uql = locala.OmT.readString();
        AppMethodBeat.o(221873);
        return 0;
      }
      AppMethodBeat.o(221873);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.d
 * JD-Core Version:    0.7.0.1
 */