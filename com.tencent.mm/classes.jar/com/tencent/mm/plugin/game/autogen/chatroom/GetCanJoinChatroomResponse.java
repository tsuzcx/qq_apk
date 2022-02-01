package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class GetCanJoinChatroomResponse
  extends esc
{
  public LinkedList<BanAction> ban_action_list;
  public LinkedList<ChatroomRecInfo> chatroom_info_list;
  public ChatroomJumpDetail chatroom_rank_jump_info;
  public JumpInfo create_jump_info;
  public ChatroomJumpDetail find_more_chatroom_jump_info;
  public JumpInfo find_more_jump_info;
  public boolean show_entrance;
  
  public GetCanJoinChatroomResponse()
  {
    AppMethodBeat.i(275542);
    this.chatroom_info_list = new LinkedList();
    this.ban_action_list = new LinkedList();
    AppMethodBeat.o(275542);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275558);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.chatroom_info_list);
      if (this.create_jump_info != null)
      {
        paramVarArgs.qD(3, this.create_jump_info.computeSize());
        this.create_jump_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.ban_action_list);
      paramVarArgs.di(5, this.show_entrance);
      if (this.find_more_jump_info != null)
      {
        paramVarArgs.qD(6, this.find_more_jump_info.computeSize());
        this.find_more_jump_info.writeFields(paramVarArgs);
      }
      if (this.find_more_chatroom_jump_info != null)
      {
        paramVarArgs.qD(7, this.find_more_chatroom_jump_info.computeSize());
        this.find_more_chatroom_jump_info.writeFields(paramVarArgs);
      }
      if (this.chatroom_rank_jump_info != null)
      {
        paramVarArgs.qD(8, this.chatroom_rank_jump_info.computeSize());
        this.chatroom_rank_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1096;
      }
    }
    label1096:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.chatroom_info_list);
      paramInt = i;
      if (this.create_jump_info != null) {
        paramInt = i + i.a.a.a.qC(3, this.create_jump_info.computeSize());
      }
      i = paramInt + i.a.a.a.c(4, 8, this.ban_action_list) + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.find_more_jump_info != null) {
        paramInt = i + i.a.a.a.qC(6, this.find_more_jump_info.computeSize());
      }
      i = paramInt;
      if (this.find_more_chatroom_jump_info != null) {
        i = paramInt + i.a.a.a.qC(7, this.find_more_chatroom_jump_info.computeSize());
      }
      paramInt = i;
      if (this.chatroom_rank_jump_info != null) {
        paramInt = i + i.a.a.a.qC(8, this.chatroom_rank_jump_info.computeSize());
      }
      AppMethodBeat.o(275558);
      return paramInt;
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
        AppMethodBeat.o(275558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        GetCanJoinChatroomResponse localGetCanJoinChatroomResponse = (GetCanJoinChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275558);
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
            localGetCanJoinChatroomResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275558);
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
            localGetCanJoinChatroomResponse.chatroom_info_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275558);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new JumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetCanJoinChatroomResponse.create_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275558);
          return 0;
        case 4: 
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
            localGetCanJoinChatroomResponse.ban_action_list.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275558);
          return 0;
        case 5: 
          localGetCanJoinChatroomResponse.show_entrance = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275558);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new JumpInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((JumpInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localGetCanJoinChatroomResponse.find_more_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275558);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ChatroomJumpDetail();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ChatroomJumpDetail)localObject2).parseFrom((byte[])localObject1);
            }
            localGetCanJoinChatroomResponse.find_more_chatroom_jump_info = ((ChatroomJumpDetail)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275558);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ChatroomJumpDetail();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ChatroomJumpDetail)localObject2).parseFrom((byte[])localObject1);
          }
          localGetCanJoinChatroomResponse.chatroom_rank_jump_info = ((ChatroomJumpDetail)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275558);
        return 0;
      }
      AppMethodBeat.o(275558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomResponse
 * JD-Core Version:    0.7.0.1
 */