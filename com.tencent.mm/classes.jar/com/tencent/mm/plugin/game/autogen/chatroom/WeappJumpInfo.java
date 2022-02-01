package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class WeappJumpInfo
  extends com.tencent.mm.bx.a
{
  public String appid;
  public String path;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275520);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid == null)
      {
        paramVarArgs = new b("Not all required fields were included: appid");
        AppMethodBeat.o(275520);
        throw paramVarArgs;
      }
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(275520);
        throw paramVarArgs;
      }
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.path != null) {
        paramVarArgs.g(2, this.path);
      }
      AppMethodBeat.o(275520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.path);
      }
      AppMethodBeat.o(275520);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.appid == null)
        {
          paramVarArgs = new b("Not all required fields were included: appid");
          AppMethodBeat.o(275520);
          throw paramVarArgs;
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(275520);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275520);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        WeappJumpInfo localWeappJumpInfo = (WeappJumpInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275520);
          return -1;
        case 1: 
          localWeappJumpInfo.appid = locala.ajGk.readString();
          AppMethodBeat.o(275520);
          return 0;
        }
        localWeappJumpInfo.path = locala.ajGk.readString();
        AppMethodBeat.o(275520);
        return 0;
      }
      AppMethodBeat.o(275520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.WeappJumpInfo
 * JD-Core Version:    0.7.0.1
 */