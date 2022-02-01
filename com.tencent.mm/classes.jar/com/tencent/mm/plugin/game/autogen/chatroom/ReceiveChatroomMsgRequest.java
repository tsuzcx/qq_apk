package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public class ReceiveChatroomMsgRequest
  extends erp
{
  public String chatroom_name;
  public long seq;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275603);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275603);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.chatroom_name != null) {
        paramVarArgs.g(2, this.chatroom_name);
      }
      paramVarArgs.bv(3, this.seq);
      if (this.version != null) {
        paramVarArgs.g(4, this.version);
      }
      AppMethodBeat.o(275603);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.chatroom_name);
      }
      i += i.a.a.b.b.a.q(3, this.seq);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.version);
      }
      AppMethodBeat.o(275603);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.chatroom_name == null)
        {
          paramVarArgs = new b("Not all required fields were included: chatroom_name");
          AppMethodBeat.o(275603);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275603);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ReceiveChatroomMsgRequest localReceiveChatroomMsgRequest = (ReceiveChatroomMsgRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275603);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localReceiveChatroomMsgRequest.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275603);
          return 0;
        case 2: 
          localReceiveChatroomMsgRequest.chatroom_name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275603);
          return 0;
        case 3: 
          localReceiveChatroomMsgRequest.seq = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(275603);
          return 0;
        }
        localReceiveChatroomMsgRequest.version = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(275603);
        return 0;
      }
      AppMethodBeat.o(275603);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgRequest
 * JD-Core Version:    0.7.0.1
 */