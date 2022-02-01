package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public class GetCanJoinChatroomResponse
  extends dyy
{
  public LinkedList<BanAction> ban_action_list;
  public LinkedList<ChatroomRecInfo> chatroom_info_list;
  public JumpInfo create_jump_info;
  public JumpInfo find_more_jump_info;
  public boolean show_entrance;
  
  public GetCanJoinChatroomResponse()
  {
    AppMethodBeat.i(195004);
    this.chatroom_info_list = new LinkedList();
    this.ban_action_list = new LinkedList();
    AppMethodBeat.o(195004);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195021);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.chatroom_info_list);
      if (this.create_jump_info != null)
      {
        paramVarArgs.oE(3, this.create_jump_info.computeSize());
        this.create_jump_info.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.ban_action_list);
      paramVarArgs.co(5, this.show_entrance);
      if (this.find_more_jump_info != null)
      {
        paramVarArgs.oE(6, this.find_more_jump_info.computeSize());
        this.find_more_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.chatroom_info_list);
      paramInt = i;
      if (this.create_jump_info != null) {
        paramInt = i + g.a.a.a.oD(3, this.create_jump_info.computeSize());
      }
      i = paramInt + g.a.a.a.c(4, 8, this.ban_action_list) + (g.a.a.b.b.a.gL(5) + 1);
      paramInt = i;
      if (this.find_more_jump_info != null) {
        paramInt = i + g.a.a.a.oD(6, this.find_more_jump_info.computeSize());
      }
      AppMethodBeat.o(195021);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.chatroom_info_list.clear();
        this.ban_action_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195021);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        GetCanJoinChatroomResponse localGetCanJoinChatroomResponse = (GetCanJoinChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195021);
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
            localGetCanJoinChatroomResponse.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(195021);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195021);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195021);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
          AppMethodBeat.o(195021);
          return 0;
        case 5: 
          localGetCanJoinChatroomResponse.show_entrance = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(195021);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        AppMethodBeat.o(195021);
        return 0;
      }
      AppMethodBeat.o(195021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.GetCanJoinChatroomResponse
 * JD-Core Version:    0.7.0.1
 */