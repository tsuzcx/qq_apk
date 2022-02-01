package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class p
  extends com.tencent.mm.cd.a
{
  public String CNG;
  public String CNH;
  public String CNI;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41716);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.CNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.CNI == null)
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
      if (this.CNG != null) {
        paramVarArgs.f(1, this.CNG);
      }
      if (this.CNH != null) {
        paramVarArgs.f(2, this.CNH);
      }
      if (this.CNI != null) {
        paramVarArgs.f(3, this.CNI);
      }
      if (this.Url != null) {
        paramVarArgs.f(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNG == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.b.b.a.g(1, this.CNG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CNH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CNH);
      }
      i = paramInt;
      if (this.CNI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CNI);
      }
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CNG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.CNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.CNI == null)
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
          localp.CNG = locala.abFh.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 2: 
          localp.CNH = locala.abFh.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 3: 
          localp.CNI = locala.abFh.readString();
          AppMethodBeat.o(41716);
          return 0;
        }
        localp.Url = locala.abFh.readString();
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