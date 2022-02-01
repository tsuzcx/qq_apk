package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eb
  extends com.tencent.mm.bw.a
{
  public String ura;
  public int urc;
  public int uvt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221901);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uvt);
      paramVarArgs.aS(2, this.urc);
      if (this.ura != null) {
        paramVarArgs.d(3, this.ura);
      }
      AppMethodBeat.o(221901);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uvt) + 0 + f.a.a.b.b.a.bz(2, this.urc);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ura);
      }
      AppMethodBeat.o(221901);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(221901);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eb localeb = (eb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(221901);
        return -1;
      case 1: 
        localeb.uvt = locala.OmT.zc();
        AppMethodBeat.o(221901);
        return 0;
      case 2: 
        localeb.urc = locala.OmT.zc();
        AppMethodBeat.o(221901);
        return 0;
      }
      localeb.ura = locala.OmT.readString();
      AppMethodBeat.o(221901);
      return 0;
    }
    AppMethodBeat.o(221901);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.eb
 * JD-Core Version:    0.7.0.1
 */