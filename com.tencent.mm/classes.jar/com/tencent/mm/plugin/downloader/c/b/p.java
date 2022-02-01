package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bw.a
{
  public String iWE;
  public String oGf;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153076);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.iWE != null) {
        paramVarArgs.d(2, this.iWE);
      }
      if (this.oGf != null) {
        paramVarArgs.d(3, this.oGf);
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.iWE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iWE);
      }
      i = paramInt;
      if (this.oGf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oGf);
      }
      AppMethodBeat.o(153076);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153076);
        return -1;
      case 1: 
        localp.type = locala.OmT.zc();
        AppMethodBeat.o(153076);
        return 0;
      case 2: 
        localp.iWE = locala.OmT.readString();
        AppMethodBeat.o(153076);
        return 0;
      }
      localp.oGf = locala.OmT.readString();
      AppMethodBeat.o(153076);
      return 0;
    }
    AppMethodBeat.o(153076);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.p
 * JD-Core Version:    0.7.0.1
 */