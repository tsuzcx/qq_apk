package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomPreloadInfo
  extends com.tencent.mm.bx.a
{
  public JumpInfo preload_create_account_jump_info;
  public JumpInfo preload_premade_h5_jump_info;
  public JumpInfo preload_profile_jump_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275473);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.preload_profile_jump_info != null)
      {
        paramVarArgs.qD(1, this.preload_profile_jump_info.computeSize());
        this.preload_profile_jump_info.writeFields(paramVarArgs);
      }
      if (this.preload_create_account_jump_info != null)
      {
        paramVarArgs.qD(2, this.preload_create_account_jump_info.computeSize());
        this.preload_create_account_jump_info.writeFields(paramVarArgs);
      }
      if (this.preload_premade_h5_jump_info != null)
      {
        paramVarArgs.qD(3, this.preload_premade_h5_jump_info.computeSize());
        this.preload_premade_h5_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.preload_profile_jump_info == null) {
        break label548;
      }
    }
    label548:
    for (int i = i.a.a.a.qC(1, this.preload_profile_jump_info.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.preload_create_account_jump_info != null) {
        paramInt = i + i.a.a.a.qC(2, this.preload_create_account_jump_info.computeSize());
      }
      i = paramInt;
      if (this.preload_premade_h5_jump_info != null) {
        i = paramInt + i.a.a.a.qC(3, this.preload_premade_h5_jump_info.computeSize());
      }
      AppMethodBeat.o(275473);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ChatroomPreloadInfo localChatroomPreloadInfo = (ChatroomPreloadInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        JumpInfo localJumpInfo;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275473);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localJumpInfo = new JumpInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localJumpInfo.parseFrom((byte[])localObject);
            }
            localChatroomPreloadInfo.preload_profile_jump_info = localJumpInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(275473);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localJumpInfo = new JumpInfo();
            if ((localObject != null) && (localObject.length > 0)) {
              localJumpInfo.parseFrom((byte[])localObject);
            }
            localChatroomPreloadInfo.preload_create_account_jump_info = localJumpInfo;
            paramInt += 1;
          }
          AppMethodBeat.o(275473);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localJumpInfo = new JumpInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localJumpInfo.parseFrom((byte[])localObject);
          }
          localChatroomPreloadInfo.preload_premade_h5_jump_info = localJumpInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(275473);
        return 0;
      }
      AppMethodBeat.o(275473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomPreloadInfo
 * JD-Core Version:    0.7.0.1
 */