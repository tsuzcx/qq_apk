package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class GetMyChatroomResponse
  extends esc
{
  public LinkedList<MyChatroomInfo> my_chatroom_info_list;
  public MyChatroomNotice my_chatroom_notice;
  public String next_version;
  
  public GetMyChatroomResponse()
  {
    AppMethodBeat.i(275572);
    this.my_chatroom_info_list = new LinkedList();
    AppMethodBeat.o(275572);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275578);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.next_version != null) {
        paramVarArgs.g(2, this.next_version);
      }
      paramVarArgs.e(3, 8, this.my_chatroom_info_list);
      if (this.my_chatroom_notice != null)
      {
        paramVarArgs.qD(4, this.my_chatroom_notice.computeSize());
        this.my_chatroom_notice.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label596;
      }
    }
    label596:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.next_version != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.next_version);
      }
      i += i.a.a.a.c(3, 8, this.my_chatroom_info_list);
      paramInt = i;
      if (this.my_chatroom_notice != null) {
        paramInt = i + i.a.a.a.qC(4, this.my_chatroom_notice.computeSize());
      }
      AppMethodBeat.o(275578);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.my_chatroom_info_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetMyChatroomResponse localGetMyChatroomResponse = (GetMyChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275578);
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
            localGetMyChatroomResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275578);
          return 0;
        case 2: 
          localGetMyChatroomResponse.next_version = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275578);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new MyChatroomInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((MyChatroomInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetMyChatroomResponse.my_chatroom_info_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275578);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new MyChatroomNotice();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((MyChatroomNotice)localObject2).parseFrom((byte[])localObject1);
          }
          localGetMyChatroomResponse.my_chatroom_notice = ((MyChatroomNotice)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275578);
        return 0;
      }
      AppMethodBeat.o(275578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomResponse
 * JD-Core Version:    0.7.0.1
 */