package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ChatroomBanAction
  extends com.tencent.mm.cd.a
{
  public BanAction ban_action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194852);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ban_action != null)
      {
        paramVarArgs.oE(1, this.ban_action.computeSize());
        this.ban_action.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(194852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ban_action == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.ban_action.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(194852);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ChatroomBanAction localChatroomBanAction = (ChatroomBanAction)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(194852);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
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
        AppMethodBeat.o(194852);
        return 0;
      }
      AppMethodBeat.o(194852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ChatroomBanAction
 * JD-Core Version:    0.7.0.1
 */