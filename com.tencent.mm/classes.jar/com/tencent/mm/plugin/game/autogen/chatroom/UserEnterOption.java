package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UserEnterOption
  extends com.tencent.mm.bx.a
{
  public String avatar;
  public String option_desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275584);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.avatar != null) {
        paramVarArgs.g(1, this.avatar);
      }
      if (this.option_desc != null) {
        paramVarArgs.g(2, this.option_desc);
      }
      AppMethodBeat.o(275584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.avatar == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.avatar) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.option_desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.option_desc);
      }
      AppMethodBeat.o(275584);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275584);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        UserEnterOption localUserEnterOption = (UserEnterOption)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275584);
          return -1;
        case 1: 
          localUserEnterOption.avatar = locala.ajGk.readString();
          AppMethodBeat.o(275584);
          return 0;
        }
        localUserEnterOption.option_desc = locala.ajGk.readString();
        AppMethodBeat.o(275584);
        return 0;
      }
      AppMethodBeat.o(275584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.UserEnterOption
 * JD-Core Version:    0.7.0.1
 */