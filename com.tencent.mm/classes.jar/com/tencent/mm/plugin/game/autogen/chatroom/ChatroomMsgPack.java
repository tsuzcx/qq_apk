package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomMsgPack
  extends com.tencent.mm.cd.a
{
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
    AppMethodBeat.i(194868);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.msg_type);
      if (this.from_username != null) {
        paramVarArgs.f(2, this.from_username);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.f(3, this.cli_msg_id);
      }
      paramVarArgs.bm(4, this.seq);
      paramVarArgs.bm(5, this.send_time);
      if (this.msg_content != null)
      {
        paramVarArgs.oE(6, this.msg_content.computeSize());
        this.msg_content.writeFields(paramVarArgs);
      }
      if (this.msg_options != null)
      {
        paramVarArgs.oE(7, this.msg_options.computeSize());
        this.msg_options.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.msg_sub_type);
      AppMethodBeat.o(194868);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.msg_type) + 0;
      paramInt = i;
      if (this.from_username != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.from_username);
      }
      i = paramInt;
      if (this.cli_msg_id != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.cli_msg_id);
      }
      i = i + g.a.a.b.b.a.p(4, this.seq) + g.a.a.b.b.a.p(5, this.send_time);
      paramInt = i;
      if (this.msg_content != null) {
        paramInt = i + g.a.a.a.oD(6, this.msg_content.computeSize());
      }
      i = paramInt;
      if (this.msg_options != null) {
        i = paramInt + g.a.a.a.oD(7, this.msg_options.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(8, this.msg_sub_type);
      AppMethodBeat.o(194868);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(194868);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ChatroomMsgPack localChatroomMsgPack = (ChatroomMsgPack)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194868);
        return -1;
      case 1: 
        localChatroomMsgPack.msg_type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(194868);
        return 0;
      case 2: 
        localChatroomMsgPack.from_username = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(194868);
        return 0;
      case 3: 
        localChatroomMsgPack.cli_msg_id = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(194868);
        return 0;
      case 4: 
        localChatroomMsgPack.seq = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(194868);
        return 0;
      case 5: 
        localChatroomMsgPack.send_time = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(194868);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        AppMethodBeat.o(194868);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        AppMethodBeat.o(194868);
        return 0;
      }
      localChatroomMsgPack.msg_sub_type = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(194868);
      return 0;
    }
    AppMethodBeat.o(194868);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomMsgPack
 * JD-Core Version:    0.7.0.1
 */