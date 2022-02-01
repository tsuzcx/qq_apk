package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public class JoinChatroomResponse
  extends esc
{
  public JumpInfo chatroom_full_jump_info;
  public JumpInfo create_account_jump_info;
  public String errmsg;
  public boolean need_jump_create_account;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275541);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.errmsg != null) {
        paramVarArgs.g(2, this.errmsg);
      }
      paramVarArgs.di(3, this.need_jump_create_account);
      if (this.create_account_jump_info != null)
      {
        paramVarArgs.qD(4, this.create_account_jump_info.computeSize());
        this.create_account_jump_info.writeFields(paramVarArgs);
      }
      if (this.chatroom_full_jump_info != null)
      {
        paramVarArgs.qD(5, this.chatroom_full_jump_info.computeSize());
        this.chatroom_full_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.errmsg != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.errmsg);
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.create_account_jump_info != null) {
        paramInt = i + i.a.a.a.qC(4, this.create_account_jump_info.computeSize());
      }
      i = paramInt;
      if (this.chatroom_full_jump_info != null) {
        i = paramInt + i.a.a.a.qC(5, this.chatroom_full_jump_info.computeSize());
      }
      AppMethodBeat.o(275541);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        JoinChatroomResponse localJoinChatroomResponse = (JoinChatroomResponse)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275541);
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
            localJoinChatroomResponse.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275541);
          return 0;
        case 2: 
          localJoinChatroomResponse.errmsg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(275541);
          return 0;
        case 3: 
          localJoinChatroomResponse.need_jump_create_account = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(275541);
          return 0;
        case 4: 
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
            localJoinChatroomResponse.create_account_jump_info = ((JumpInfo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(275541);
          return 0;
        }
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
          localJoinChatroomResponse.chatroom_full_jump_info = ((JumpInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(275541);
        return 0;
      }
      AppMethodBeat.o(275541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.JoinChatroomResponse
 * JD-Core Version:    0.7.0.1
 */