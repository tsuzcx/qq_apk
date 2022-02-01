package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public long mwX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22106);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aG(1, this.mwX);
      AppMethodBeat.o(22106);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.mwX);
      AppMethodBeat.o(22106);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(22106);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22106);
        return -1;
      }
      localf.mwX = locala.KhF.xT();
      AppMethodBeat.o(22106);
      return 0;
    }
    AppMethodBeat.o(22106);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.f
 * JD-Core Version:    0.7.0.1
 */