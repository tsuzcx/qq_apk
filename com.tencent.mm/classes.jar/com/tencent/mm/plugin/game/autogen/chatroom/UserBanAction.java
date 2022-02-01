package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class UserBanAction
  extends com.tencent.mm.bx.a
{
  public LinkedList<BanAction> ban_action_list;
  
  public UserBanAction()
  {
    AppMethodBeat.i(275451);
    this.ban_action_list = new LinkedList();
    AppMethodBeat.o(275451);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275456);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.ban_action_list);
      AppMethodBeat.o(275456);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ban_action_list);
      AppMethodBeat.o(275456);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ban_action_list.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      UserBanAction localUserBanAction = (UserBanAction)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(275456);
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
        localUserBanAction.ban_action_list.add(localBanAction);
        paramInt += 1;
      }
      AppMethodBeat.o(275456);
      return 0;
    }
    AppMethodBeat.o(275456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.UserBanAction
 * JD-Core Version:    0.7.0.1
 */