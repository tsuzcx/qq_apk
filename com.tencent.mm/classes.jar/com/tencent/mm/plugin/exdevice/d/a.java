package com.tencent.mm.plugin.exdevice.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bv.a
{
  public int lGw;
  public String lGx;
  public String lGy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19415);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.lGw);
      if (this.lGx != null) {
        paramVarArgs.e(2, this.lGx);
      }
      if (this.lGy != null) {
        paramVarArgs.e(3, this.lGy);
      }
      AppMethodBeat.o(19415);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.lGw) + 0;
      paramInt = i;
      if (this.lGx != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.lGx);
      }
      i = paramInt;
      if (this.lGy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.lGy);
      }
      AppMethodBeat.o(19415);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(19415);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19415);
        return -1;
      case 1: 
        locala1.lGw = locala.CLY.sl();
        AppMethodBeat.o(19415);
        return 0;
      case 2: 
        locala1.lGx = locala.CLY.readString();
        AppMethodBeat.o(19415);
        return 0;
      }
      locala1.lGy = locala.CLY.readString();
      AppMethodBeat.o(19415);
      return 0;
    }
    AppMethodBeat.o(19415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.d.a
 * JD-Core Version:    0.7.0.1
 */