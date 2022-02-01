package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class GetMoreChatroomResponse
  extends esc
{
  public LinkedList<BanAction> ban_action_list;
  public String chatroom_filter;
  public LinkedList<ChatroomRecInfo> chatroom_info_list;
  public boolean has_next;
  
  public GetMoreChatroomResponse()
  {
    AppMethodBeat.i(275606);
    this.chatroom_info_list = new LinkedList();
    this.ban_action_list = new LinkedList();
    AppMethodBeat.o(275606);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275614);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.chatroom_info_list);
      paramVarArgs.di(3, this.has_next);
      if (this.chatroom_filter != null) {
        paramVarArgs.g(4, this.chatroom_filter);
      }
      paramVarArgs.e(5, 8, this.ban_action_list);
      AppMethodBeat.o(275614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label620;
      }
    }
    label620:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.chatroom_info_list) + (i.a.a.b.b.a.ko(3) + 1);
      paramInt = i;
      if (this.chatroom_filter != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.chatroom_filter);
      }
      i = i.a.a.a.c(5, 8, this.ban_action_list);
      AppMethodBeat.o(275614);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.chatroom_info_list.clear();
        this.ban_action_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275614);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetMoreChatroomResponse localGetMoreChatroomResponse = (GetMoreChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275614);
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
            localGetMoreChatroomResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275614);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomRecInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomRecInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetMoreChatroomResponse.chatroom_info_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275614);
          return 0;
        case 3: 
          localGetMoreChatroomResponse.has_next = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275614);
          return 0;
        case 4: 
          localGetMoreChatroomResponse.chatroom_filter = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275614);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new BanAction();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((BanAction)localObject2).parseFrom((byte[])localObject1);
          }
          localGetMoreChatroomResponse.ban_action_list.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275614);
        return 0;
      }
      AppMethodBeat.o(275614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetMoreChatroomResponse
 * JD-Core Version:    0.7.0.1
 */