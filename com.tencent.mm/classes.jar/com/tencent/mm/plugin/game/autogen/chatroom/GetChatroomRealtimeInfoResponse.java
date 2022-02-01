package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public class GetChatroomRealtimeInfoResponse
  extends dyy
{
  public AtInfo at_info;
  public Broadcast broadcast;
  public RealtimeControlInfo control_info;
  public ChatroomData current_chatroom_data;
  public String next_version;
  public NotificationBar notification_bar;
  public SlotList slot_list;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195387);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.notification_bar != null)
      {
        paramVarArgs.oE(2, this.notification_bar.computeSize());
        this.notification_bar.writeFields(paramVarArgs);
      }
      if (this.slot_list != null)
      {
        paramVarArgs.oE(3, this.slot_list.computeSize());
        this.slot_list.writeFields(paramVarArgs);
      }
      if (this.broadcast != null)
      {
        paramVarArgs.oE(4, this.broadcast.computeSize());
        this.broadcast.writeFields(paramVarArgs);
      }
      if (this.next_version != null) {
        paramVarArgs.f(5, this.next_version);
      }
      if (this.at_info != null)
      {
        paramVarArgs.oE(6, this.at_info.computeSize());
        this.at_info.writeFields(paramVarArgs);
      }
      if (this.current_chatroom_data != null)
      {
        paramVarArgs.oE(7, this.current_chatroom_data.computeSize());
        this.current_chatroom_data.writeFields(paramVarArgs);
      }
      if (this.control_info != null)
      {
        paramVarArgs.oE(8, this.control_info.computeSize());
        this.control_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1148;
      }
    }
    label1148:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.notification_bar != null) {
        paramInt = i + g.a.a.a.oD(2, this.notification_bar.computeSize());
      }
      i = paramInt;
      if (this.slot_list != null) {
        i = paramInt + g.a.a.a.oD(3, this.slot_list.computeSize());
      }
      paramInt = i;
      if (this.broadcast != null) {
        paramInt = i + g.a.a.a.oD(4, this.broadcast.computeSize());
      }
      i = paramInt;
      if (this.next_version != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.next_version);
      }
      paramInt = i;
      if (this.at_info != null) {
        paramInt = i + g.a.a.a.oD(6, this.at_info.computeSize());
      }
      i = paramInt;
      if (this.current_chatroom_data != null) {
        i = paramInt + g.a.a.a.oD(7, this.current_chatroom_data.computeSize());
      }
      paramInt = i;
      if (this.control_info != null) {
        paramInt = i + g.a.a.a.oD(8, this.control_info.computeSize());
      }
      AppMethodBeat.o(195387);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195387);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetChatroomRealtimeInfoResponse localGetChatroomRealtimeInfoResponse = (GetChatroomRealtimeInfoResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195387);
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
            localGetChatroomRealtimeInfoResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195387);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new NotificationBar();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((NotificationBar)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomRealtimeInfoResponse.notification_bar = ((NotificationBar)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195387);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new SlotList();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((SlotList)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomRealtimeInfoResponse.slot_list = ((SlotList)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195387);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new Broadcast();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((Broadcast)localObject2).parseFrom((byte[])localObject1);
            }
            localGetChatroomRealtimeInfoResponse.broadcast = ((Broadcast)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195387);
          return 0;
        case 5: 
          localGetChatroomRealtimeInfoResponse.next_version = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(195387);
          return 0;
        case 6: 
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
            localGetChatroomRealtimeInfoResponse.at_info = ((AtInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195387);
          return 0;
        case 7: 
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
            localGetChatroomRealtimeInfoResponse.current_chatroom_data = ((ChatroomData)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195387);
          return 0;
        }
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
          localGetChatroomRealtimeInfoResponse.control_info = ((RealtimeControlInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(195387);
        return 0;
      }
      AppMethodBeat.o(195387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoResponse
 * JD-Core Version:    0.7.0.1
 */