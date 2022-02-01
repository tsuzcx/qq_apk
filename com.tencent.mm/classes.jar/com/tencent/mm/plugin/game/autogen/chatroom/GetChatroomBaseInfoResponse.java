package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class GetChatroomBaseInfoResponse
  extends esc
{
  public ChannelInfo channel_info;
  public ChatroomButton chatroom_button;
  public ChatroomEnterInfo chatroom_enter_info;
  public RealtimeControlInfo control_info;
  public ChatroomData current_chatroom_data;
  public ChatroomUserData current_user_data;
  public ChatroomExternInfo extern_info;
  public FirstEnterNotify first_enter_notify;
  public ChatroomJumpInfo jump_info;
  public MsgBaseInfo msg_base_info;
  public ChatroomPreloadInfo preload_info;
  public LinkedList<RobotInfo> robot_info_list;
  
  public GetChatroomBaseInfoResponse()
  {
    AppMethodBeat.i(275465);
    this.robot_info_list = new LinkedList();
    AppMethodBeat.o(275465);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275483);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.current_user_data != null)
      {
        paramVarArgs.qD(2, this.current_user_data.computeSize());
        this.current_user_data.writeFields(paramVarArgs);
      }
      if (this.current_chatroom_data != null)
      {
        paramVarArgs.qD(3, this.current_chatroom_data.computeSize());
        this.current_chatroom_data.writeFields(paramVarArgs);
      }
      if (this.chatroom_button != null)
      {
        paramVarArgs.qD(4, this.chatroom_button.computeSize());
        this.chatroom_button.writeFields(paramVarArgs);
      }
      if (this.control_info != null)
      {
        paramVarArgs.qD(5, this.control_info.computeSize());
        this.control_info.writeFields(paramVarArgs);
      }
      if (this.preload_info != null)
      {
        paramVarArgs.qD(6, this.preload_info.computeSize());
        this.preload_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.robot_info_list);
      if (this.jump_info != null)
      {
        paramVarArgs.qD(8, this.jump_info.computeSize());
        this.jump_info.writeFields(paramVarArgs);
      }
      if (this.extern_info != null)
      {
        paramVarArgs.qD(9, this.extern_info.computeSize());
        this.extern_info.writeFields(paramVarArgs);
      }
      if (this.channel_info != null)
      {
        paramVarArgs.qD(10, this.channel_info.computeSize());
        this.channel_info.writeFields(paramVarArgs);
      }
      if (this.msg_base_info != null)
      {
        paramVarArgs.qD(11, this.msg_base_info.computeSize());
        this.msg_base_info.writeFields(paramVarArgs);
      }
      if (this.first_enter_notify != null)
      {
        paramVarArgs.qD(12, this.first_enter_notify.computeSize());
        this.first_enter_notify.writeFields(paramVarArgs);
      }
      if (this.chatroom_enter_info != null)
      {
        paramVarArgs.qD(13, this.chatroom_enter_info.computeSize());
        this.chatroom_enter_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275483);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1872;
      }
    }
    label1872:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.current_user_data != null) {
        paramInt = i + i.a.a.a.qC(2, this.current_user_data.computeSize());
      }
      i = paramInt;
      if (this.current_chatroom_data != null) {
        i = paramInt + i.a.a.a.qC(3, this.current_chatroom_data.computeSize());
      }
      paramInt = i;
      if (this.chatroom_button != null) {
        paramInt = i + i.a.a.a.qC(4, this.chatroom_button.computeSize());
      }
      i = paramInt;
      if (this.control_info != null) {
        i = paramInt + i.a.a.a.qC(5, this.control_info.computeSize());
      }
      paramInt = i;
      if (this.preload_info != null) {
        paramInt = i + i.a.a.a.qC(6, this.preload_info.computeSize());
      }
      i = paramInt + i.a.a.a.c(7, 8, this.robot_info_list);
      paramInt = i;
      if (this.jump_info != null) {
        paramInt = i + i.a.a.a.qC(8, this.jump_info.computeSize());
      }
      i = paramInt;
      if (this.extern_info != null) {
        i = paramInt + i.a.a.a.qC(9, this.extern_info.computeSize());
      }
      paramInt = i;
      if (this.channel_info != null) {
        paramInt = i + i.a.a.a.qC(10, this.channel_info.computeSize());
      }
      i = paramInt;
      if (this.msg_base_info != null) {
        i = paramInt + i.a.a.a.qC(11, this.msg_base_info.computeSize());
      }
      paramInt = i;
      if (this.first_enter_notify != null) {
        paramInt = i + i.a.a.a.qC(12, this.first_enter_notify.computeSize());
      }
      i = paramInt;
      if (this.chatroom_enter_info != null) {
        i = paramInt + i.a.a.a.qC(13, this.chatroom_enter_info.computeSize());
      }
      AppMethodBeat.o(275483);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.robot_info_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275483);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetChatroomBaseInfoResponse localGetChatroomBaseInfoResponse = (GetChatroomBaseInfoResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275483);
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
            localGetChatroomBaseInfoResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        case 2: 
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
            localGetChatroomBaseInfoResponse.current_user_data = ((ChatroomUserData)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275483);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275483);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275483);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
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
          AppMethodBeat.o(275483);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new RobotInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((RobotInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.robot_info_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomJumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomJumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.jump_info = ((ChatroomJumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomExternInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomExternInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.extern_info = ((ChatroomExternInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChannelInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChannelInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.channel_info = ((ChannelInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new MsgBaseInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((MsgBaseInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.msg_base_info = ((MsgBaseInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FirstEnterNotify();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FirstEnterNotify)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomBaseInfoResponse.first_enter_notify = ((FirstEnterNotify)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275483);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomEnterInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomEnterInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localGetChatroomBaseInfoResponse.chatroom_enter_info = ((ChatroomEnterInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275483);
        return 0;
      }
      AppMethodBeat.o(275483);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomBaseInfoResponse
 * JD-Core Version:    0.7.0.1
 */