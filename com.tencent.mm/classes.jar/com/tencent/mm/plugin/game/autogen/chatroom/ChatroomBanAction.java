package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomBanAction
  extends com.tencent.mm.bx.a
{
  public BanAction ban_action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275559);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ban_action != null)
      {
        paramVarArgs.qD(1, this.ban_action.computeSize());
        this.ban_action.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(275559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ban_action == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.ban_action.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(275559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ChatroomBanAction localChatroomBanAction = (ChatroomBanAction)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(275559);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          BanAction localBanAction = new BanAction();
          if ((localObject != null) && (localObject.length > 0)) {
            localBanAction.parseFrom((byte[])localObject);
          }
          localChatroomBanAction.ban_action = localBanAction;
          paramInt += 1;
        }
        AppMethodBeat.o(275559);
        return 0;
      }
      AppMethodBeat.o(275559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomBanAction
 * JD-Core Version:    0.7.0.1
 */