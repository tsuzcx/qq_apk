package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.cd.a
{
  public String extern_info;
  public int msg_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203924);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.msg_type);
      if (this.extern_info != null) {
        paramVarArgs.f(2, this.extern_info);
      }
      AppMethodBeat.o(203924);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.msg_type) + 0;
      paramInt = i;
      if (this.extern_info != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.extern_info);
      }
      AppMethodBeat.o(203924);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203924);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203924);
        return -1;
      case 1: 
        localm.msg_type = locala.abFh.AK();
        AppMethodBeat.o(203924);
        return 0;
      }
      localm.extern_info = locala.abFh.readString();
      AppMethodBeat.o(203924);
      return 0;
    }
    AppMethodBeat.o(203924);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.m
 * JD-Core Version:    0.7.0.1
 */