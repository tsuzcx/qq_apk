package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class db
  extends com.tencent.mm.bw.a
{
  public String xIB;
  public String xMN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41815);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMN != null) {
        paramVarArgs.e(1, this.xMN);
      }
      if (this.xIB != null) {
        paramVarArgs.e(2, this.xIB);
      }
      AppMethodBeat.o(41815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMN == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.xMN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xIB != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xIB);
      }
      AppMethodBeat.o(41815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41815);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        db localdb = (db)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41815);
          return -1;
        case 1: 
          localdb.xMN = locala.UbS.readString();
          AppMethodBeat.o(41815);
          return 0;
        }
        localdb.xIB = locala.UbS.readString();
        AppMethodBeat.o(41815);
        return 0;
      }
      AppMethodBeat.o(41815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.db
 * JD-Core Version:    0.7.0.1
 */