package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class ReceiveChatroomMsgResponse
  extends esc
{
  public AtInfo at_info;
  public long last_received_seq;
  public LinkedList<ChatroomMsgPack> msg_pack_list;
  public long next_seq;
  public String next_version;
  public LinkedList<NoticeMsg> notice_msg_list;
  public LinkedList<ChatroomMsgPack> refresh_msg_pack_list;
  
  public ReceiveChatroomMsgResponse()
  {
    AppMethodBeat.i(275464);
    this.msg_pack_list = new LinkedList();
    this.notice_msg_list = new LinkedList();
    this.refresh_msg_pack_list = new LinkedList();
    AppMethodBeat.o(275464);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275481);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.msg_pack_list);
      paramVarArgs.bv(3, this.next_seq);
      if (this.at_info != null)
      {
        paramVarArgs.qD(4, this.at_info.computeSize());
        this.at_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.notice_msg_list);
      paramVarArgs.bv(6, this.last_received_seq);
      paramVarArgs.e(7, 8, this.refresh_msg_pack_list);
      if (this.next_version != null) {
        paramVarArgs.g(8, this.next_version);
      }
      AppMethodBeat.o(275481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label920;
      }
    }
    label920:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.msg_pack_list) + i.a.a.b.b.a.q(3, this.next_seq);
      paramInt = i;
      if (this.at_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.at_info.computeSize());
      }
      i = paramInt + i.a.a.a.c(5, 8, this.notice_msg_list) + i.a.a.b.b.a.q(6, this.last_received_seq) + i.a.a.a.c(7, 8, this.refresh_msg_pack_list);
      paramInt = i;
      if (this.next_version != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.next_version);
      }
      AppMethodBeat.o(275481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.msg_pack_list.clear();
        this.notice_msg_list.clear();
        this.refresh_msg_pack_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ReceiveChatroomMsgResponse localReceiveChatroomMsgResponse = (ReceiveChatroomMsgResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275481);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localReceiveChatroomMsgResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275481);
          return 0;
        case 2: 
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
            localReceiveChatroomMsgResponse.msg_pack_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275481);
          return 0;
        case 3: 
          localReceiveChatroomMsgResponse.next_seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(275481);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275481);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new NoticeMsg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((NoticeMsg)localObject2).parseFrom((byte[])localObject1);
            }
            localReceiveChatroomMsgResponse.notice_msg_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275481);
          return 0;
        case 6: 
          localReceiveChatroomMsgResponse.last_received_seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(275481);
          return 0;
        case 7: 
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
            localReceiveChatroomMsgResponse.refresh_msg_pack_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275481);
          return 0;
        }
        localReceiveChatroomMsgResponse.next_version = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(275481);
        return 0;
      }
      AppMethodBeat.o(275481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse
 * JD-Core Version:    0.7.0.1
 */