package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class AdminInfo
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> admin_username_list;
  public String owner_username;
  
  public AdminInfo()
  {
    AppMethodBeat.i(195591);
    this.admin_username_list = new LinkedList();
    AppMethodBeat.o(195591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195594);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.owner_username != null) {
        paramVarArgs.f(1, this.owner_username);
      }
      paramVarArgs.e(2, 1, this.admin_username_list);
      AppMethodBeat.o(195594);
      return 0;
    }
    if (paramInt == 1) {
      if (this.owner_username == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.owner_username) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 1, this.admin_username_list);
      AppMethodBeat.o(195594);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.admin_username_list.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(195594);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        AdminInfo localAdminInfo = (AdminInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195594);
          return -1;
        case 1: 
          localAdminInfo.owner_username = locala.abFh.readString();
          AppMethodBeat.o(195594);
          return 0;
        }
        localAdminInfo.admin_username_list.add(locala.abFh.readString());
        AppMethodBeat.o(195594);
        return 0;
      }
      AppMethodBeat.o(195594);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.AdminInfo
 * JD-Core Version:    0.7.0.1
 */