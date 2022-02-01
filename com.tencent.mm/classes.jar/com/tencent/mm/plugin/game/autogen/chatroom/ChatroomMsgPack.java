package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgPack
  extends com.tencent.mm.bx.a
{
  public int channel_id;
  public String cli_msg_id;
  public String from_username;
  public MsgContent msg_content;
  public MsgOptions msg_options;
  public int msg_sub_type;
  public int msg_type;
  public long send_time;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275501);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.msg_type);
      if (this.from_username != null) {
        paramVarArgs.g(2, this.from_username);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.g(3, this.cli_msg_id);
      }
      paramVarArgs.bv(4, this.seq);
      paramVarArgs.bv(5, this.send_time);
      if (this.msg_content != null)
      {
        paramVarArgs.qD(6, this.msg_content.computeSize());
        this.msg_content.writeFields(paramVarArgs);
      }
      if (this.msg_options != null)
      {
        paramVarArgs.qD(7, this.msg_options.computeSize());
        this.msg_options.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.msg_sub_type);
      paramVarArgs.bS(9, this.channel_id);
      AppMethodBeat.o(275501);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.msg_type) + 0;
      paramInt = i;
      if (this.from_username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.from_username);
      }
      i = paramInt;
      if (this.cli_msg_id != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.cli_msg_id);
      }
      i = i + i.a.a.b.b.a.q(4, this.seq) + i.a.a.b.b.a.q(5, this.send_time);
      paramInt = i;
      if (this.msg_content != null) {
        paramInt = i + i.a.a.a.qC(6, this.msg_content.computeSize());
      }
      i = paramInt;
      if (this.msg_options != null) {
        i = paramInt + i.a.a.a.qC(7, this.msg_options.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.msg_sub_type);
      int j = i.a.a.b.b.a.cJ(9, this.channel_id);
      AppMethodBeat.o(275501);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275501);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ChatroomMsgPack localChatroomMsgPack = (ChatroomMsgPack)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275501);
        return -1;
      case 1: 
        localChatroomMsgPack.msg_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275501);
        return 0;
      case 2: 
        localChatroomMsgPack.from_username = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275501);
        return 0;
      case 3: 
        localChatroomMsgPack.cli_msg_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275501);
        return 0;
      case 4: 
        localChatroomMsgPack.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(275501);
        return 0;
      case 5: 
        localChatroomMsgPack.send_time = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(275501);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new MsgContent();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((MsgContent)localObject2).parseFrom((byte[])localObject1);
          }
          localChatroomMsgPack.msg_content = ((MsgContent)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275501);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new MsgOptions();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((MsgOptions)localObject2).parseFrom((byte[])localObject1);
          }
          localChatroomMsgPack.msg_options = ((MsgOptions)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275501);
        return 0;
      case 8: 
        localChatroomMsgPack.msg_sub_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(275501);
        return 0;
      }
      localChatroomMsgPack.channel_id = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(275501);
      return 0;
    }
    AppMethodBeat.o(275501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack
 * JD-Core Version:    0.7.0.1
 */