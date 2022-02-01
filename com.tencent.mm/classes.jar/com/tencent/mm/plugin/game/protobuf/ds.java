package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ds
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String xIx;
  public String xIy;
  public int xNn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41834);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.xIy != null) {
        paramVarArgs.e(2, this.xIy);
      }
      if (this.xIx != null) {
        paramVarArgs.e(3, this.xIx);
      }
      paramVarArgs.aM(4, this.xNn);
      AppMethodBeat.o(41834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIy);
      }
      i = paramInt;
      if (this.xIx != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xIx);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.xNn);
      AppMethodBeat.o(41834);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41834);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ds localds = (ds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41834);
          return -1;
        case 1: 
          localds.Title = locala.UbS.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 2: 
          localds.xIy = locala.UbS.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 3: 
          localds.xIx = locala.UbS.readString();
          AppMethodBeat.o(41834);
          return 0;
        }
        localds.xNn = locala.UbS.zi();
        AppMethodBeat.o(41834);
        return 0;
      }
      AppMethodBeat.o(41834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ds
 * JD-Core Version:    0.7.0.1
 */