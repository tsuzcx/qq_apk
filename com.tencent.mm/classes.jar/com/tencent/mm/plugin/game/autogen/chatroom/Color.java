package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Color
  extends com.tencent.mm.bx.a
{
  public String dark_color;
  public String h5_dark_color;
  public String h5_light_color;
  public String light_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275461);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.light_color != null) {
        paramVarArgs.g(1, this.light_color);
      }
      if (this.dark_color != null) {
        paramVarArgs.g(2, this.dark_color);
      }
      if (this.h5_light_color != null) {
        paramVarArgs.g(3, this.h5_light_color);
      }
      if (this.h5_dark_color != null) {
        paramVarArgs.g(4, this.h5_dark_color);
      }
      AppMethodBeat.o(275461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.light_color == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.light_color) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dark_color != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.dark_color);
      }
      i = paramInt;
      if (this.h5_light_color != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.h5_light_color);
      }
      paramInt = i;
      if (this.h5_dark_color != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.h5_dark_color);
      }
      AppMethodBeat.o(275461);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(275461);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        Color localColor = (Color)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(275461);
          return -1;
        case 1: 
          localColor.light_color = locala.ajGk.readString();
          AppMethodBeat.o(275461);
          return 0;
        case 2: 
          localColor.dark_color = locala.ajGk.readString();
          AppMethodBeat.o(275461);
          return 0;
        case 3: 
          localColor.h5_light_color = locala.ajGk.readString();
          AppMethodBeat.o(275461);
          return 0;
        }
        localColor.h5_dark_color = locala.ajGk.readString();
        AppMethodBeat.o(275461);
        return 0;
      }
      AppMethodBeat.o(275461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Color
 * JD-Core Version:    0.7.0.1
 */