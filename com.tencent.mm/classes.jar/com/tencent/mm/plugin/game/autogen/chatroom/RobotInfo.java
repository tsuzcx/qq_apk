package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class RobotInfo
  extends com.tencent.mm.bx.a
{
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275500);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(275500);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      AppMethodBeat.o(275500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label257;
      }
    }
    label257:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(275500);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(275500);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275500);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        RobotInfo localRobotInfo = (RobotInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275500);
          return -1;
        }
        localRobotInfo.username = locala.ajGk.readString();
        AppMethodBeat.o(275500);
        return 0;
      }
      AppMethodBeat.o(275500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.RobotInfo
 * JD-Core Version:    0.7.0.1
 */