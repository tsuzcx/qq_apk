package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class y
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String nDo;
  public String ufg;
  public String ugo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.ugo == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41724);
        throw paramVarArgs;
      }
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.ufg != null) {
        paramVarArgs.d(2, this.ufg);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.ugo != null) {
        paramVarArgs.d(4, this.ugo);
      }
      AppMethodBeat.o(41724);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufg);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.ugo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ugo);
      }
      AppMethodBeat.o(41724);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(41724);
          throw paramVarArgs;
        }
        if (this.ugo == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41724);
          return -1;
        case 1: 
          localy.nDo = locala.NPN.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 2: 
          localy.ufg = locala.NPN.readString();
          AppMethodBeat.o(41724);
          return 0;
        case 3: 
          localy.Title = locala.NPN.readString();
          AppMethodBeat.o(41724);
          return 0;
        }
        localy.ugo = locala.NPN.readString();
        AppMethodBeat.o(41724);
        return 0;
      }
      AppMethodBeat.o(41724);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.y
 * JD-Core Version:    0.7.0.1
 */