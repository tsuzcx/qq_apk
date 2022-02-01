package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class da
  extends com.tencent.mm.bw.a
{
  public String IconUrl;
  public String thh;
  public String tlz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41832);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlz != null) {
        paramVarArgs.d(1, this.tlz);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.thh != null) {
        paramVarArgs.d(3, this.thh);
      }
      AppMethodBeat.o(41832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlz == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.tlz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thh);
      }
      AppMethodBeat.o(41832);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41832);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        da localda = (da)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41832);
          return -1;
        case 1: 
          localda.tlz = locala.LVo.readString();
          AppMethodBeat.o(41832);
          return 0;
        case 2: 
          localda.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(41832);
          return 0;
        }
        localda.thh = locala.LVo.readString();
        AppMethodBeat.o(41832);
        return 0;
      }
      AppMethodBeat.o(41832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.da
 * JD-Core Version:    0.7.0.1
 */