package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ae
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String UserName;
  public String xIJ;
  public String xKd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41724);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.xKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.xIJ != null) {
        paramVarArgs.e(2, this.xIJ);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.xKd != null) {
        paramVarArgs.e(4, this.xKd);
      }
      AppMethodBeat.o(41724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIJ);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.xKd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xKd);
      }
      AppMethodBeat.o(41724);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        if (this.xKd == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41724);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41724);
          return -1;
        case 1: 
          localae.UserName = locala.UbS.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 2: 
          localae.xIJ = locala.UbS.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 3: 
          localae.Title = locala.UbS.readString();
          AppMethodBeat.o(41724);
          return 0;
        }
        localae.xKd = locala.UbS.readString();
        AppMethodBeat.o(41724);
        return 0;
      }
      AppMethodBeat.o(41724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ae
 * JD-Core Version:    0.7.0.1
 */