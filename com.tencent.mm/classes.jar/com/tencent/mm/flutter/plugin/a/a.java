package com.tencent.mm.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class a
  extends com.tencent.mm.bx.a
{
  public String headUrl;
  public String nickname;
  public String signature;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(233280);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname == null)
      {
        paramVarArgs = new b("Not all required fields were included: nickname");
        AppMethodBeat.o(233280);
        throw paramVarArgs;
      }
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(233280);
        throw paramVarArgs;
      }
      if (this.headUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: headUrl");
        AppMethodBeat.o(233280);
        throw paramVarArgs;
      }
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.headUrl != null) {
        paramVarArgs.g(3, this.headUrl);
      }
      if (this.signature != null) {
        paramVarArgs.g(4, this.signature);
      }
      AppMethodBeat.o(233280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label534;
      }
    }
    label534:
    for (int i = i.a.a.b.b.a.h(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.headUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.headUrl);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.signature);
      }
      AppMethodBeat.o(233280);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.nickname == null)
        {
          paramVarArgs = new b("Not all required fields were included: nickname");
          AppMethodBeat.o(233280);
          throw paramVarArgs;
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(233280);
          throw paramVarArgs;
        }
        if (this.headUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: headUrl");
          AppMethodBeat.o(233280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(233280);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(233280);
          return -1;
        case 1: 
          locala1.nickname = locala.ajGk.readString();
          AppMethodBeat.o(233280);
          return 0;
        case 2: 
          locala1.username = locala.ajGk.readString();
          AppMethodBeat.o(233280);
          return 0;
        case 3: 
          locala1.headUrl = locala.ajGk.readString();
          AppMethodBeat.o(233280);
          return 0;
        }
        locala1.signature = locala.ajGk.readString();
        AppMethodBeat.o(233280);
        return 0;
      }
      AppMethodBeat.o(233280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */