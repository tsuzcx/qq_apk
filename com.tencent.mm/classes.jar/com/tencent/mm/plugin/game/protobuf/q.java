package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class q
  extends com.tencent.mm.bx.a
{
  public String IHO;
  public String IHP;
  public String IHQ;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41716);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHO == null)
      {
        paramVarArgs = new b("Not all required fields were included: Message");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.IHP == null)
      {
        paramVarArgs = new b("Not all required fields were included: GotoBtn");
        AppMethodBeat.o(41716);
        throw paramVarArgs;
      }
      if (this.IHQ == null)
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
      if (this.IHO != null) {
        paramVarArgs.g(1, this.IHO);
      }
      if (this.IHP != null) {
        paramVarArgs.g(2, this.IHP);
      }
      if (this.IHQ != null) {
        paramVarArgs.g(3, this.IHQ);
      }
      if (this.Url != null) {
        paramVarArgs.g(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHO == null) {
        break label582;
      }
    }
    label582:
    for (int i = i.a.a.b.b.a.h(1, this.IHO) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IHP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHP);
      }
      i = paramInt;
      if (this.IHQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IHQ);
      }
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Url);
      }
      AppMethodBeat.o(41716);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IHO == null)
        {
          paramVarArgs = new b("Not all required fields were included: Message");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.IHP == null)
        {
          paramVarArgs = new b("Not all required fields were included: GotoBtn");
          AppMethodBeat.o(41716);
          throw paramVarArgs;
        }
        if (this.IHQ == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41716);
          return -1;
        case 1: 
          localq.IHO = locala.ajGk.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 2: 
          localq.IHP = locala.ajGk.readString();
          AppMethodBeat.o(41716);
          return 0;
        case 3: 
          localq.IHQ = locala.ajGk.readString();
          AppMethodBeat.o(41716);
          return 0;
        }
        localq.Url = locala.ajGk.readString();
        AppMethodBeat.o(41716);
        return 0;
      }
      AppMethodBeat.o(41716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.q
 * JD-Core Version:    0.7.0.1
 */