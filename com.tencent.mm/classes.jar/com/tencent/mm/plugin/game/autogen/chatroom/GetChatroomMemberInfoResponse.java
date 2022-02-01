package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class GetChatroomMemberInfoResponse
  extends esc
{
  public LinkedList<ChatroomUserData> user_data_list;
  
  public GetChatroomMemberInfoResponse()
  {
    AppMethodBeat.i(275576);
    this.user_data_list = new LinkedList();
    AppMethodBeat.o(275576);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275585);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.user_data_list);
      AppMethodBeat.o(275585);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.user_data_list);
      AppMethodBeat.o(275585);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.user_data_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275585);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetChatroomMemberInfoResponse localGetChatroomMemberInfoResponse = (GetChatroomMemberInfoResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275585);
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
            localGetChatroomMemberInfoResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275585);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomUserData();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomUserData)localObject2).parseFrom((byte[])localObject1);
          }
          localGetChatroomMemberInfoResponse.user_data_list.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275585);
        return 0;
      }
      AppMethodBeat.o(275585);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomMemberInfoResponse
 * JD-Core Version:    0.7.0.1
 */