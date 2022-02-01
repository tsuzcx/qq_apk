package com.tencent.mm.plugin.game.autogen.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class DebugOption
  extends com.tencent.mm.bx.a
{
  public String debug_info;
  public boolean need_debug;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(275498);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.need_debug);
      if (this.debug_info != null) {
        paramVarArgs.g(2, this.debug_info);
      }
      AppMethodBeat.o(275498);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.debug_info != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.debug_info);
      }
      AppMethodBeat.o(275498);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(275498);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      DebugOption localDebugOption = (DebugOption)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(275498);
        return -1;
      case 1: 
        localDebugOption.need_debug = locala.ajGk.aai();
        AppMethodBeat.o(275498);
        return 0;
      }
      localDebugOption.debug_info = locala.ajGk.readString();
      AppMethodBeat.o(275498);
      return 0;
    }
    AppMethodBeat.o(275498);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.chatroom.DebugOption
 * JD-Core Version:    0.7.0.1
 */