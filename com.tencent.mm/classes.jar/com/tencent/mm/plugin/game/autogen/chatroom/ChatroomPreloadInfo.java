package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomPreloadInfo
  extends com.tencent.mm.cd.a
{
  public JumpInfo preload_create_account_jump_info;
  public JumpInfo preload_profile_jump_info;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195520);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.preload_profile_jump_info != null)
      {
        paramVarArgs.oE(1, this.preload_profile_jump_info.computeSize());
        this.preload_profile_jump_info.writeFields(paramVarArgs);
      }
      if (this.preload_create_account_jump_info != null)
      {
        paramVarArgs.oE(2, this.preload_create_account_jump_info.computeSize());
        this.preload_create_account_jump_info.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(195520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.preload_profile_jump_info == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = g.a.a.a.oD(1, this.preload_profile_jump_info.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.preload_create_account_jump_info != null) {
        i = paramInt + g.a.a.a.oD(2, this.preload_create_account_jump_info.computeSize());
      }
      AppMethodBeat.o(195520);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ChatroomPreloadInfo localChatroomPreloadInfo = (ChatroomPreloadInfo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        JumpInfo localJumpInfo;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195520);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
          AppMethodBeat.o(195520);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
        AppMethodBeat.o(195520);
        return 0;
      }
      AppMethodBeat.o(195520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomPreloadInfo
 * JD-Core Version:    0.7.0.1
 */