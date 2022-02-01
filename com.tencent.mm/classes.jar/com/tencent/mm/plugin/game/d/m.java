package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bx.a
{
  public String Url;
  public String ufM;
  public String ufN;
  public String ufO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.ufN == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.ufO == null)
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
      if (this.ufM != null) {
        paramVarArgs.d(1, this.ufM);
      }
      if (this.ufN != null) {
        paramVarArgs.d(2, this.ufN);
      }
      if (this.ufO != null) {
        paramVarArgs.d(3, this.ufO);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufM == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.ufM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufN);
      }
      i = paramInt;
      if (this.ufO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ufO);
      }
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ufM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.ufN == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.ufO == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41716);
          return -1;
        case 1: 
          localm.ufM = locala.NPN.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 2: 
          localm.ufN = locala.NPN.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 3: 
          localm.ufO = locala.NPN.readString();
          AppMethodBeat.o(41716);
          return 0;
        }
        localm.Url = locala.NPN.readString();
        AppMethodBeat.o(41716);
        return 0;
      }
      AppMethodBeat.o(41716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.m
 * JD-Core Version:    0.7.0.1
 */