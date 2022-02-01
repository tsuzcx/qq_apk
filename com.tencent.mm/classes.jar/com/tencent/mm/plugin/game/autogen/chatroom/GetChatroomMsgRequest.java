package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import i.a.a.b;
import java.util.LinkedList;

public class GetChatroomMsgRequest
  extends erp
{
  public int channel_id;
  public String chatroom_name;
  public long seq_gt;
  public long seq_lt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275492);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.chatroom_name == null)
      {
        paramVarArgs = new b("Not all required fields were included: chatroom_name");
        AppMethodBeat.o(275492);
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
      paramVarArgs.bv(3, this.seq_gt);
      paramVarArgs.bv(4, this.seq_lt);
      paramVarArgs.bS(5, this.channel_id);
      AppMethodBeat.o(275492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label528;
      }
    }
    label528:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.chatroom_name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.chatroom_name);
      }
      paramInt = i.a.a.b.b.a.q(3, this.seq_gt);
      int j = i.a.a.b.b.a.q(4, this.seq_lt);
      int k = i.a.a.b.b.a.cJ(5, this.channel_id);
      AppMethodBeat.o(275492);
      return i + paramInt + j + k;
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
          AppMethodBeat.o(275492);
          throw paramVarArgs;
        }
        AppMethodBeat.o(275492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        GetChatroomMsgRequest localGetChatroomMsgRequest = (GetChatroomMsgRequest)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275492);
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
            localGetChatroomMsgRequest.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(275492);
          return 0;
        case 2: 
          localGetChatroomMsgRequest.chatroom_name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(275492);
          return 0;
        case 3: 
          localGetChatroomMsgRequest.seq_gt = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(275492);
          return 0;
        case 4: 
          localGetChatroomMsgRequest.seq_lt = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(275492);
          return 0;
        }
        localGetChatroomMsgRequest.channel_id = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(275492);
        return 0;
      }
      AppMethodBeat.o(275492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMsgRequest
 * JD-Core Version:    0.7.0.1
 */