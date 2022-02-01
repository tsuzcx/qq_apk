package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cf
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String xIB;
  public String xKd;
  public String xMl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41791);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMl == null)
      {
        paramVarArgs = new b("Not all required fields were included: LogoURL");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.xKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.xIB == null)
      {
        paramVarArgs = new b("Not all required fields were included: WebURL");
        AppMethodBeat.o(41791);
        throw paramVarArgs;
      }
      if (this.xMl != null) {
        paramVarArgs.e(1, this.xMl);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.xKd != null) {
        paramVarArgs.e(3, this.xKd);
      }
      if (this.xIB != null) {
        paramVarArgs.e(4, this.xIB);
      }
      AppMethodBeat.o(41791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMl == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.b.b.a.f(1, this.xMl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.xKd != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xKd);
      }
      paramInt = i;
      if (this.xIB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xIB);
      }
      AppMethodBeat.o(41791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xMl == null)
        {
          paramVarArgs = new b("Not all required fields were included: LogoURL");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.xKd == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        if (this.xIB == null)
        {
          paramVarArgs = new b("Not all required fields were included: WebURL");
          AppMethodBeat.o(41791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41791);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cf localcf = (cf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41791);
          return -1;
        case 1: 
          localcf.xMl = locala.UbS.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 2: 
          localcf.Title = locala.UbS.readString();
          AppMethodBeat.o(41791);
          return 0;
        case 3: 
          localcf.xKd = locala.UbS.readString();
          AppMethodBeat.o(41791);
          return 0;
        }
        localcf.xIB = locala.UbS.readString();
        AppMethodBeat.o(41791);
        return 0;
      }
      AppMethodBeat.o(41791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cf
 * JD-Core Version:    0.7.0.1
 */