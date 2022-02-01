package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class AdminInfo
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> admin_username_list;
  public String owner_username;
  
  public AdminInfo()
  {
    AppMethodBeat.i(275467);
    this.admin_username_list = new LinkedList();
    AppMethodBeat.o(275467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275472);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.owner_username != null) {
        paramVarArgs.g(1, this.owner_username);
      }
      paramVarArgs.e(2, 1, this.admin_username_list);
      AppMethodBeat.o(275472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.owner_username == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.owner_username) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.admin_username_list);
      AppMethodBeat.o(275472);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.admin_username_list.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275472);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        AdminInfo localAdminInfo = (AdminInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275472);
          return -1;
        case 1: 
          localAdminInfo.owner_username = locala.ajGk.readString();
          AppMethodBeat.o(275472);
          return 0;
        }
        localAdminInfo.admin_username_list.add(locala.ajGk.readString());
        AppMethodBeat.o(275472);
        return 0;
      }
      AppMethodBeat.o(275472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.AdminInfo
 * JD-Core Version:    0.7.0.1
 */