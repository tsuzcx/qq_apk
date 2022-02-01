package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class l
  extends com.tencent.mm.bx.a
{
  public int jump_type;
  public String jump_url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267797);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.jump_type);
      if (this.jump_url != null) {
        paramVarArgs.g(2, this.jump_url);
      }
      AppMethodBeat.o(267797);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.jump_type) + 0;
      paramInt = i;
      if (this.jump_url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.jump_url);
      }
      AppMethodBeat.o(267797);
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
      AppMethodBeat.o(267797);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(267797);
        return -1;
      case 1: 
        locall.jump_type = locala.ajGk.aar();
        AppMethodBeat.o(267797);
        return 0;
      }
      locall.jump_url = locala.ajGk.readString();
      AppMethodBeat.o(267797);
      return 0;
    }
    AppMethodBeat.o(267797);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.l
 * JD-Core Version:    0.7.0.1
 */