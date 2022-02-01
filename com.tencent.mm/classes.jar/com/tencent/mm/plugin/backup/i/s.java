package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bx.a
{
  public long mBA;
  public long mBB;
  public long mBe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.mBe);
      paramVarArgs.aG(2, this.mBA);
      paramVarArgs.aG(3, this.mBB);
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.mBe);
      int i = f.a.a.b.b.a.q(2, this.mBA);
      int j = f.a.a.b.b.a.q(3, this.mBB);
      AppMethodBeat.o(22124);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22124);
        return -1;
      case 1: 
        locals.mBe = locala.KhF.xT();
        AppMethodBeat.o(22124);
        return 0;
      case 2: 
        locals.mBA = locala.KhF.xT();
        AppMethodBeat.o(22124);
        return 0;
      }
      locals.mBB = locala.KhF.xT();
      AppMethodBeat.o(22124);
      return 0;
    }
    AppMethodBeat.o(22124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.s
 * JD-Core Version:    0.7.0.1
 */