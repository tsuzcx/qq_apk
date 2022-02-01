package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bw.a
{
  public String Url;
  public String thV;
  public String thW;
  public String thX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.thW == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.thX == null)
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
      if (this.thV != null) {
        paramVarArgs.d(1, this.thV);
      }
      if (this.thW != null) {
        paramVarArgs.d(2, this.thW);
      }
      if (this.thX != null) {
        paramVarArgs.d(3, this.thX);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thV == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.thV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thW);
      }
      i = paramInt;
      if (this.thX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thX);
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
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.thV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.thW == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.thX == null)
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
          localm.thV = locala.LVo.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 2: 
          localm.thW = locala.LVo.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 3: 
          localm.thX = locala.LVo.readString();
          AppMethodBeat.o(41716);
          return 0;
        }
        localm.Url = locala.LVo.readString();
        AppMethodBeat.o(41716);
        return 0;
      }
      AppMethodBeat.o(41716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.m
 * JD-Core Version:    0.7.0.1
 */