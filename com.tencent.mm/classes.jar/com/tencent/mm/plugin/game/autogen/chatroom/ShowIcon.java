package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShowIcon
  extends com.tencent.mm.bx.a
{
  public String dark_icon;
  public String light_icon;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275567);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.light_icon != null) {
        paramVarArgs.g(1, this.light_icon);
      }
      if (this.dark_icon != null) {
        paramVarArgs.g(2, this.dark_icon);
      }
      AppMethodBeat.o(275567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.light_icon == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.light_icon) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dark_icon != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.dark_icon);
      }
      AppMethodBeat.o(275567);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275567);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ShowIcon localShowIcon = (ShowIcon)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275567);
          return -1;
        case 1: 
          localShowIcon.light_icon = locala.ajGk.readString();
          AppMethodBeat.o(275567);
          return 0;
        }
        localShowIcon.dark_icon = locala.ajGk.readString();
        AppMethodBeat.o(275567);
        return 0;
      }
      AppMethodBeat.o(275567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.ShowIcon
 * JD-Core Version:    0.7.0.1
 */