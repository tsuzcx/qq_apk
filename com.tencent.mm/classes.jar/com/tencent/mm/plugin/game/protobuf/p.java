package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class p
  extends com.tencent.mm.bw.a
{
  public String Url;
  public String xJA;
  public String xJB;
  public String xJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.xJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.xJB == null)
      {
        paramVarArgs = new b("Not all required fields were included: CancelBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.xJz != null) {
        paramVarArgs.e(1, this.xJz);
      }
      if (this.xJA != null) {
        paramVarArgs.e(2, this.xJA);
      }
      if (this.xJB != null) {
        paramVarArgs.e(3, this.xJB);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJz == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.b.b.a.f(1, this.xJz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xJA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xJA);
      }
      i = paramInt;
      if (this.xJB != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xJB);
      }
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xJz == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.xJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.xJB == null)
        {
          paramVarArgs = new b("Not all required fields were included: CancelBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41716);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41716);
          return -1;
        case 1: 
          localp.xJz = locala.UbS.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 2: 
          localp.xJA = locala.UbS.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 3: 
          localp.xJB = locala.UbS.readString();
          AppMethodBeat.o(41716);
          return 0;
        }
        localp.Url = locala.UbS.readString();
        AppMethodBeat.o(41716);
        return 0;
      }
      AppMethodBeat.o(41716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.p
 * JD-Core Version:    0.7.0.1
 */