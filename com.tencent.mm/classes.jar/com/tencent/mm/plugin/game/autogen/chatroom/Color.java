package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class Color
  extends com.tencent.mm.cd.a
{
  public String dark_color;
  public String light_color;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194731);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.light_color != null) {
        paramVarArgs.f(1, this.light_color);
      }
      if (this.dark_color != null) {
        paramVarArgs.f(2, this.dark_color);
      }
      AppMethodBeat.o(194731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.light_color == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.light_color) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dark_color != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.dark_color);
      }
      AppMethodBeat.o(194731);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(194731);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        Color localColor = (Color)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(194731);
          return -1;
        case 1: 
          localColor.light_color = locala.abFh.readString();
          AppMethodBeat.o(194731);
          return 0;
        }
        localColor.dark_color = locala.abFh.readString();
        AppMethodBeat.o(194731);
        return 0;
      }
      AppMethodBeat.o(194731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.Color
 * JD-Core Version:    0.7.0.1
 */