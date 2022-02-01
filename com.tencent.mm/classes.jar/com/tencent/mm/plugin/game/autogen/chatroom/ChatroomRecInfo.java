package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomRecInfo
  extends com.tencent.mm.bx.a
{
  public long basic_update_time;
  public ChattingInfo chating_des;
  public ChatroomData chatroom_data;
  public ChatroomMsgPack last_chatroom_msg;
  public int user_chatting_count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275482);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_data != null)
      {
        paramVarArgs.qD(1, this.chatroom_data.computeSize());
        this.chatroom_data.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.basic_update_time);
      if (this.chating_des != null)
      {
        paramVarArgs.qD(3, this.chating_des.computeSize());
        this.chating_des.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.user_chatting_count);
      if (this.last_chatroom_msg != null)
      {
        paramVarArgs.qD(5, this.last_chatroom_msg.computeSize());
        this.last_chatroom_msg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.chatroom_data == null) {
        break label636;
      }
    }
    label636:
    for (paramInt = i.a.a.a.qC(1, this.chatroom_data.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.basic_update_time);
      paramInt = i;
      if (this.chating_des != null) {
        paramInt = i + i.a.a.a.qC(3, this.chating_des.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.user_chatting_count);
      paramInt = i;
      if (this.last_chatroom_msg != null) {
        paramInt = i + i.a.a.a.qC(5, this.last_chatroom_msg.computeSize());
      }
      AppMethodBeat.o(275482);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ChatroomRecInfo localChatroomRecInfo = (ChatroomRecInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275482);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomData();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomData)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomRecInfo.chatroom_data = ((ChatroomData)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275482);
          return 0;
        case 2: 
          localChatroomRecInfo.basic_update_time = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(275482);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChattingInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChattingInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localChatroomRecInfo.chating_des = ((ChattingInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275482);
          return 0;
        case 4: 
          localChatroomRecInfo.user_chatting_count = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(275482);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomMsgPack();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomMsgPack)localObject2).parseFrom((byte[])localObject1);
          }
          localChatroomRecInfo.last_chatroom_msg = ((ChatroomMsgPack)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275482);
        return 0;
      }
      AppMethodBeat.o(275482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomRecInfo
 * JD-Core Version:    0.7.0.1
 */