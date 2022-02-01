package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dq
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String uqf;
  public String uvg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41832);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uvg != null) {
        paramVarArgs.d(1, this.uvg);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.uqf != null) {
        paramVarArgs.d(3, this.uqf);
      }
      AppMethodBeat.o(41832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvg == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.uvg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqf);
      }
      AppMethodBeat.o(41832);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41832);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dq localdq = (dq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41832);
          return -1;
        case 1: 
          localdq.uvg = locala.OmT.readString();
          AppMethodBeat.o(41832);
          return 0;
        case 2: 
          localdq.IconUrl = locala.OmT.readString();
          AppMethodBeat.o(41832);
          return 0;
        }
        localdq.uqf = locala.OmT.readString();
        AppMethodBeat.o(41832);
        return 0;
      }
      AppMethodBeat.o(41832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dq
 * JD-Core Version:    0.7.0.1
 */