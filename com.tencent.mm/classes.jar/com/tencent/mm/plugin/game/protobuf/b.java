package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMC;
  public String CMD;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(41707);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMB != null) {
        paramVarArgs.f(2, this.CMB);
      }
      if (this.CMC != null) {
        paramVarArgs.f(3, this.CMC);
      }
      if (this.CMD != null) {
        paramVarArgs.f(4, this.CMD);
      }
      AppMethodBeat.o(41707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label442;
      }
    }
    label442:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMB);
      }
      i = paramInt;
      if (this.CMC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMC);
      }
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMD);
      }
      AppMethodBeat.o(41707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(41707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41707);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41707);
          return -1;
        case 1: 
          localb.fwr = locala.abFh.readString();
          AppMethodBeat.o(41707);
          return 0;
        case 2: 
          localb.CMB = locala.abFh.readString();
          AppMethodBeat.o(41707);
          return 0;
        case 3: 
          localb.CMC = locala.abFh.readString();
          AppMethodBeat.o(41707);
          return 0;
        }
        localb.CMD = locala.abFh.readString();
        AppMethodBeat.o(41707);
        return 0;
      }
      AppMethodBeat.o(41707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.b
 * JD-Core Version:    0.7.0.1
 */