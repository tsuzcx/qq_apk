package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class ChatroomUserSimpleData
  extends com.tencent.mm.bx.a
{
  public String avatar;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275515);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(275515);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.avatar != null) {
        paramVarArgs.g(3, this.avatar);
      }
      AppMethodBeat.o(275515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label378;
      }
    }
    label378:
    for (int i = i.a.a.b.b.a.h(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.avatar);
      }
      AppMethodBeat.o(275515);
      return i;
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
          AppMethodBeat.o(275515);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275515);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ChatroomUserSimpleData localChatroomUserSimpleData = (ChatroomUserSimpleData)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275515);
          return -1;
        case 1: 
          localChatroomUserSimpleData.username = locala.ajGk.readString();
          AppMethodBeat.o(275515);
          return 0;
        case 2: 
          localChatroomUserSimpleData.nickname = locala.ajGk.readString();
          AppMethodBeat.o(275515);
          return 0;
        }
        localChatroomUserSimpleData.avatar = locala.ajGk.readString();
        AppMethodBeat.o(275515);
        return 0;
      }
      AppMethodBeat.o(275515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserSimpleData
 * JD-Core Version:    0.7.0.1
 */