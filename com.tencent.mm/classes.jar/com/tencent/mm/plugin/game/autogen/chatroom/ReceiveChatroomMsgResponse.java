package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public class ReceiveChatroomMsgResponse
  extends dyy
{
  public AtInfo at_info;
  public LinkedList<ChatroomMsgPack> msg_pack_list;
  public long next_seq;
  
  public ReceiveChatroomMsgResponse()
  {
    AppMethodBeat.i(195079);
    this.msg_pack_list = new LinkedList();
    AppMethodBeat.o(195079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195097);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.msg_pack_list);
      paramVarArgs.bm(3, this.next_seq);
      if (this.at_info != null)
      {
        paramVarArgs.oE(4, this.at_info.computeSize());
        this.at_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.msg_pack_list) + g.a.a.b.b.a.p(3, this.next_seq);
      paramInt = i;
      if (this.at_info != null) {
        paramInt = i + g.a.a.a.oD(4, this.at_info.computeSize());
      }
      AppMethodBeat.o(195097);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.msg_pack_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ReceiveChatroomMsgResponse localReceiveChatroomMsgResponse = (ReceiveChatroomMsgResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195097);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localReceiveChatroomMsgResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195097);
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
            localReceiveChatroomMsgResponse.msg_pack_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195097);
          return 0;
        case 3: 
          localReceiveChatroomMsgResponse.next_seq = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(195097);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new AtInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((AtInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localReceiveChatroomMsgResponse.at_info = ((AtInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(195097);
        return 0;
      }
      AppMethodBeat.o(195097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse
 * JD-Core Version:    0.7.0.1
 */