package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bw.a
{
  public long nEQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22105);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aZ(1, this.nEQ);
      AppMethodBeat.o(22105);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.nEQ);
      AppMethodBeat.o(22105);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(22105);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22105);
        return -1;
      }
      locale.nEQ = locala.OmT.zd();
      AppMethodBeat.o(22105);
      return 0;
    }
    AppMethodBeat.o(22105);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.e
 * JD-Core Version:    0.7.0.1
 */