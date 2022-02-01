package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cj
  extends com.tencent.mm.cd.a
{
  public String CMG;
  public String COk;
  public String CQu;
  public String CQx;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41795);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41795);
        throw paramVarArgs;
      }
      if (this.CQu != null) {
        paramVarArgs.f(1, this.CQu);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.COk != null) {
        paramVarArgs.f(3, this.COk);
      }
      if (this.CMG != null) {
        paramVarArgs.f(4, this.CMG);
      }
      if (this.CQx != null) {
        paramVarArgs.f(5, this.CQx);
      }
      AppMethodBeat.o(41795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CQu == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.g(1, this.CQu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.COk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.COk);
      }
      paramInt = i;
      if (this.CMG != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMG);
      }
      i = paramInt;
      if (this.CQx != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CQx);
      }
      AppMethodBeat.o(41795);
      return i;
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
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41795);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41795);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cj localcj = (cj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41795);
          return -1;
        case 1: 
          localcj.CQu = locala.abFh.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 2: 
          localcj.fwr = locala.abFh.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 3: 
          localcj.COk = locala.abFh.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 4: 
          localcj.CMG = locala.abFh.readString();
          AppMethodBeat.o(41795);
          return 0;
        }
        localcj.CQx = locala.abFh.readString();
        AppMethodBeat.o(41795);
        return 0;
      }
      AppMethodBeat.o(41795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cj
 * JD-Core Version:    0.7.0.1
 */