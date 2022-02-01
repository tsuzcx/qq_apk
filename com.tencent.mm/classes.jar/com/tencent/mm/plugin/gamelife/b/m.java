package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bx.a
{
  public String extern_info;
  public int msg_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267789);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.msg_type);
      if (this.extern_info != null) {
        paramVarArgs.g(2, this.extern_info);
      }
      AppMethodBeat.o(267789);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.msg_type) + 0;
      paramInt = i;
      if (this.extern_info != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.extern_info);
      }
      AppMethodBeat.o(267789);
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
      AppMethodBeat.o(267789);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(267789);
        return -1;
      case 1: 
        localm.msg_type = locala.ajGk.aar();
        AppMethodBeat.o(267789);
        return 0;
      }
      localm.extern_info = locala.ajGk.readString();
      AppMethodBeat.o(267789);
      return 0;
    }
    AppMethodBeat.o(267789);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.m
 * JD-Core Version:    0.7.0.1
 */