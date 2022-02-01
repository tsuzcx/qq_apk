package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class k
  extends com.tencent.mm.bx.a
{
  public int nDm;
  public int nDn;
  public String nDo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.nDm);
      paramVarArgs.aS(2, this.nDn);
      if (this.nDo != null) {
        paramVarArgs.d(3, this.nDo);
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.nDm) + 0 + f.a.a.b.b.a.bz(2, this.nDn);
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nDo);
      }
      AppMethodBeat.o(22114);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.nDo == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(22114);
        throw paramVarArgs;
      }
      AppMethodBeat.o(22114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22114);
        return -1;
      case 1: 
        localk.nDm = locala.NPN.zc();
        AppMethodBeat.o(22114);
        return 0;
      case 2: 
        localk.nDn = locala.NPN.zc();
        AppMethodBeat.o(22114);
        return 0;
      }
      localk.nDo = locala.NPN.readString();
      AppMethodBeat.o(22114);
      return 0;
    }
    AppMethodBeat.o(22114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.k
 * JD-Core Version:    0.7.0.1
 */