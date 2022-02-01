package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ci
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String xIB;
  public String xKd;
  public String xMl;
  public String xMo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41795);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41795);
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
      if (this.xMo != null) {
        paramVarArgs.e(5, this.xMo);
      }
      AppMethodBeat.o(41795);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMl == null) {
        break label502;
      }
    }
    label502:
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
      i = paramInt;
      if (this.xMo != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xMo);
      }
      AppMethodBeat.o(41795);
      return i;
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
          AppMethodBeat.o(41795);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41795);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ci localci = (ci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41795);
          return -1;
        case 1: 
          localci.xMl = locala.UbS.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 2: 
          localci.Title = locala.UbS.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 3: 
          localci.xKd = locala.UbS.readString();
          AppMethodBeat.o(41795);
          return 0;
        case 4: 
          localci.xIB = locala.UbS.readString();
          AppMethodBeat.o(41795);
          return 0;
        }
        localci.xMo = locala.UbS.readString();
        AppMethodBeat.o(41795);
        return 0;
      }
      AppMethodBeat.o(41795);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ci
 * JD-Core Version:    0.7.0.1
 */