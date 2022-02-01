package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public class GetChatroomBaseInfoResponse
  extends dyy
{
  public ChatroomButton chatroom_button;
  public RealtimeControlInfo control_info;
  public ChatroomData current_chatroom_data;
  public ChatroomUserData current_user_data;
  public ChatroomPreloadInfo preload_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194781);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.current_user_data != null)
      {
        paramVarArgs.oE(2, this.current_user_data.computeSize());
        this.current_user_data.writeFields(paramVarArgs);
      }
      if (this.current_chatroom_data != null)
      {
        paramVarArgs.oE(3, this.current_chatroom_data.computeSize());
        this.current_chatroom_data.writeFields(paramVarArgs);
      }
      if (this.chatroom_button != null)
      {
        paramVarArgs.oE(4, this.chatroom_button.computeSize());
        this.chatroom_button.writeFields(paramVarArgs);
      }
      if (this.control_info != null)
      {
        paramVarArgs.oE(5, this.control_info.computeSize());
        this.control_info.writeFields(paramVarArgs);
      }
      if (this.preload_info != null)
      {
        paramVarArgs.oE(6, this.preload_info.computeSize());
        this.preload_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label950;
      }
    }
    label950:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.current_user_data != null) {
        paramInt = i + g.a.a.a.oD(2, this.current_user_data.computeSize());
      }
      i = paramInt;
      if (this.current_chatroom_data != null) {
        i = paramInt + g.a.a.a.oD(3, this.current_chatroom_data.computeSize());
      }
      paramInt = i;
      if (this.chatroom_button != null) {
        paramInt = i + g.a.a.a.oD(4, this.chatroom_button.computeSize());
      }
      i = paramInt;
      if (this.control_info != null) {
        i = paramInt + g.a.a.a.oD(5, this.control_info.computeSize());
      }
      paramInt = i;
      if (this.preload_info != null) {
        paramInt = i + g.a.a.a.oD(6, this.preload_info.computeSize());
      }
      AppMethodBeat.o(194781);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194781);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetChatroomBaseInfoResponse localGetChatroomBaseInfoResponse = (GetChatroomBaseInfoResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194781);
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
            localGetChatroomBaseInfoResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194781);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomUserData();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomUserData)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.current_user_data = ((ChatroomUserData)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194781);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomData();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomData)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.current_chatroom_data = ((ChatroomData)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194781);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomButton();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomButton)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.chatroom_button = ((ChatroomButton)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194781);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new RealtimeControlInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((RealtimeControlInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.control_info = ((RealtimeControlInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(194781);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomPreloadInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomPreloadInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localGetChatroomBaseInfoResponse.preload_info = ((ChatroomPreloadInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(194781);
        return 0;
      }
      AppMethodBeat.o(194781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoResponse
 * JD-Core Version:    0.7.0.1
 */