package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import g.a.a.b;
import java.util.LinkedList;

public class SendChatroomMsgRequest
  extends dyl
{
  public String chatroom_name;
  public ChatroomMsgPack msg_pack;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194789);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.msg_pack == null)
      {
        paramVarArgs = new b("Not all required fields were included: msg_pack");
        AppMethodBeat.o(194789);
        throw paramVarArgs;
      }
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(194789);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.msg_pack != null)
      {
        paramVarArgs.oE(2, this.msg_pack.computeSize());
        this.msg_pack.writeFields(paramVarArgs);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.f(3, this.chatroom_name);
      }
      AppMethodBeat.o(194789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.msg_pack != null) {
        paramInt = i + g.a.a.a.oD(2, this.msg_pack.computeSize());
      }
      i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.chatroom_name);
      }
      AppMethodBeat.o(194789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.msg_pack == null)
        {
          paramVarArgs = new b("Not all required fields were included: msg_pack");
          AppMethodBeat.o(194789);
          throw paramVarArgs;
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(194789);
          throw paramVarArgs;
        }
        AppMethodBeat.o(194789);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        SendChatroomMsgRequest localSendChatroomMsgRequest = (SendChatroomMsgRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194789);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localSendChatroomMsgRequest.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194789);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomMsgPack();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomMsgPack)localObject2).parseFrom((byte[])localObject1);
            }
            localSendChatroomMsgRequest.msg_pack = ((ChatroomMsgPack)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194789);
          return 0;
        }
        localSendChatroomMsgRequest.chatroom_name = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(194789);
        return 0;
      }
      AppMethodBeat.o(194789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.SendChatroomMsgRequest
 * JD-Core Version:    0.7.0.1
 */