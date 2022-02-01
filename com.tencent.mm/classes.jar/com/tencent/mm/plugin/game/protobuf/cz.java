package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cz
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String xIx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41813);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.xIx != null) {
        paramVarArgs.e(2, this.xIx);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      AppMethodBeat.o(41813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIx);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Desc);
      }
      AppMethodBeat.o(41813);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41813);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cz localcz = (cz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41813);
          return -1;
        case 1: 
          localcz.Title = locala.UbS.readString();
          AppMethodBeat.o(41813);
          return 0;
        case 2: 
          localcz.xIx = locala.UbS.readString();
          AppMethodBeat.o(41813);
          return 0;
        }
        localcz.Desc = locala.UbS.readString();
        AppMethodBeat.o(41813);
        return 0;
      }
      AppMethodBeat.o(41813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cz
 * JD-Core Version:    0.7.0.1
 */