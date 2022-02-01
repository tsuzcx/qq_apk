package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class LocalCacheChatMsg
  extends com.tencent.mm.bx.a
{
  public LinkedList<ChatroomMsgPack> chatroom_msg_list;
  public String host_user_name;
  
  public LocalCacheChatMsg()
  {
    AppMethodBeat.i(275608);
    this.chatroom_msg_list = new LinkedList();
    AppMethodBeat.o(275608);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275613);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.chatroom_msg_list);
      if (this.host_user_name != null) {
        paramVarArgs.g(2, this.host_user_name);
      }
      AppMethodBeat.o(275613);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.chatroom_msg_list) + 0;
      paramInt = i;
      if (this.host_user_name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.host_user_name);
      }
      AppMethodBeat.o(275613);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.chatroom_msg_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275613);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      LocalCacheChatMsg localLocalCacheChatMsg = (LocalCacheChatMsg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275613);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ChatroomMsgPack localChatroomMsgPack = new ChatroomMsgPack();
          if ((localObject != null) && (localObject.length > 0)) {
            localChatroomMsgPack.parseFrom((byte[])localObject);
          }
          localLocalCacheChatMsg.chatroom_msg_list.add(localChatroomMsgPack);
          paramInt += 1;
        }
        AppMethodBeat.o(275613);
        return 0;
      }
      localLocalCacheChatMsg.host_user_name = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(275613);
      return 0;
    }
    AppMethodBeat.o(275613);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.LocalCacheChatMsg
 * JD-Core Version:    0.7.0.1
 */