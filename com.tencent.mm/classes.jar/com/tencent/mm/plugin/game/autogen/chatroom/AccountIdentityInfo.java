package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountIdentityInfo
  extends com.tencent.mm.cd.a
{
  public String auth_desc;
  public int auth_icon_type;
  public int auth_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195073);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.auth_type);
      if (this.auth_desc != null) {
        paramVarArgs.f(2, this.auth_desc);
      }
      paramVarArgs.aY(3, this.auth_icon_type);
      AppMethodBeat.o(195073);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.auth_type) + 0;
      paramInt = i;
      if (this.auth_desc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.auth_desc);
      }
      i = g.a.a.b.b.a.bM(3, this.auth_icon_type);
      AppMethodBeat.o(195073);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(195073);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      AccountIdentityInfo localAccountIdentityInfo = (AccountIdentityInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195073);
        return -1;
      case 1: 
        localAccountIdentityInfo.auth_type = locala.abFh.AK();
        AppMethodBeat.o(195073);
        return 0;
      case 2: 
        localAccountIdentityInfo.auth_desc = locala.abFh.readString();
        AppMethodBeat.o(195073);
        return 0;
      }
      localAccountIdentityInfo.auth_icon_type = locala.abFh.AK();
      AppMethodBeat.o(195073);
      return 0;
    }
    AppMethodBeat.o(195073);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.AccountIdentityInfo
 * JD-Core Version:    0.7.0.1
 */