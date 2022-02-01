package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class m
  extends com.tencent.mm.bx.a
{
  public String Url;
  public String sac;
  public String sad;
  public String sae;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sac == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.sad == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.sae == null)
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
      if (this.sac != null) {
        paramVarArgs.d(1, this.sac);
      }
      if (this.sad != null) {
        paramVarArgs.d(2, this.sad);
      }
      if (this.sae != null) {
        paramVarArgs.d(3, this.sae);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sac == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.b.b.a.e(1, this.sac) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sad != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sad);
      }
      i = paramInt;
      if (this.sae != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sae);
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
            paramVarArgs.fMq();
          }
        }
        if (this.sac == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.sad == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.sae == null)
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
          localm.sac = locala.KhF.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 2: 
          localm.sad = locala.KhF.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 3: 
          localm.sae = locala.KhF.readString();
          AppMethodBeat.o(41716);
          return 0;
        }
        localm.Url = locala.KhF.readString();
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