package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends com.tencent.mm.bx.a
{
  public String hAD;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153079);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hAD != null) {
        paramVarArgs.d(1, this.hAD);
      }
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      AppMethodBeat.o(153079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAD == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.hAD) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.value != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.value);
      }
      AppMethodBeat.o(153079);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153079);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153079);
          return -1;
        case 1: 
          localr.hAD = locala.NPN.readString();
          AppMethodBeat.o(153079);
          return 0;
        }
        localr.value = locala.NPN.readString();
        AppMethodBeat.o(153079);
        return 0;
      }
      AppMethodBeat.o(153079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.r
 * JD-Core Version:    0.7.0.1
 */