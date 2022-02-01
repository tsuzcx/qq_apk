package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String icon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41798);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.icon != null) {
        paramVarArgs.e(1, this.icon);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.icon == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.icon) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41798);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41798);
          return -1;
        case 1: 
          localcm.icon = locala.UbS.readString();
          AppMethodBeat.o(41798);
          return 0;
        }
        localcm.desc = locala.UbS.readString();
        AppMethodBeat.o(41798);
        return 0;
      }
      AppMethodBeat.o(41798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cm
 * JD-Core Version:    0.7.0.1
 */