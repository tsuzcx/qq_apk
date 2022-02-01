package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public long fXs;
  public long fXt;
  public long fXu;
  public long fXv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42663);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.fXs);
      paramVarArgs.aZ(2, this.fXt);
      paramVarArgs.aZ(3, this.fXu);
      paramVarArgs.aZ(4, this.fXv);
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.fXs);
      int i = f.a.a.b.b.a.p(2, this.fXt);
      int j = f.a.a.b.b.a.p(3, this.fXu);
      int k = f.a.a.b.b.a.p(4, this.fXv);
      AppMethodBeat.o(42663);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(42663);
        return -1;
      case 1: 
        localc.fXs = locala.OmT.zd();
        AppMethodBeat.o(42663);
        return 0;
      case 2: 
        localc.fXt = locala.OmT.zd();
        AppMethodBeat.o(42663);
        return 0;
      case 3: 
        localc.fXu = locala.OmT.zd();
        AppMethodBeat.o(42663);
        return 0;
      }
      localc.fXv = locala.OmT.zd();
      AppMethodBeat.o(42663);
      return 0;
    }
    AppMethodBeat.o(42663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */