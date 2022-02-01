package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class em
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMC;
  public String CRS;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41845);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.CRS != null) {
        paramVarArgs.f(3, this.CRS);
      }
      if (this.CMC != null) {
        paramVarArgs.f(4, this.CMC);
      }
      AppMethodBeat.o(41845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.CRS != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CRS);
      }
      paramInt = i;
      if (this.CMC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMC);
      }
      AppMethodBeat.o(41845);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41845);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        em localem = (em)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41845);
          return -1;
        case 1: 
          localem.fwr = locala.abFh.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 2: 
          localem.CMB = locala.abFh.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 3: 
          localem.CRS = locala.abFh.readString();
          AppMethodBeat.o(41845);
          return 0;
        }
        localem.CMC = locala.abFh.readString();
        AppMethodBeat.o(41845);
        return 0;
      }
      AppMethodBeat.o(41845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.em
 * JD-Core Version:    0.7.0.1
 */