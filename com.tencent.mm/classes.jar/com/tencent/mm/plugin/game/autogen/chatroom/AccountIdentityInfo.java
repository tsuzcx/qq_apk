package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class AccountIdentityInfo
  extends com.tencent.mm.bx.a
{
  public String auth_desc;
  public int auth_icon_type;
  public int auth_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.auth_type);
      if (this.auth_desc != null) {
        paramVarArgs.g(2, this.auth_desc);
      }
      paramVarArgs.bS(3, this.auth_icon_type);
      AppMethodBeat.o(275493);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.auth_type) + 0;
      paramInt = i;
      if (this.auth_desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.auth_desc);
      }
      i = i.a.a.b.b.a.cJ(3, this.auth_icon_type);
      AppMethodBeat.o(275493);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275493);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      AccountIdentityInfo localAccountIdentityInfo = (AccountIdentityInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275493);
        return -1;
      case 1: 
        localAccountIdentityInfo.auth_type = locala.ajGk.aar();
        AppMethodBeat.o(275493);
        return 0;
      case 2: 
        localAccountIdentityInfo.auth_desc = locala.ajGk.readString();
        AppMethodBeat.o(275493);
        return 0;
      }
      localAccountIdentityInfo.auth_icon_type = locala.ajGk.aar();
      AppMethodBeat.o(275493);
      return 0;
    }
    AppMethodBeat.o(275493);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.AccountIdentityInfo
 * JD-Core Version:    0.7.0.1
 */