package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends com.tencent.mm.bw.a
{
  public String hDr;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153079);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hDr != null) {
        paramVarArgs.d(1, this.hDr);
      }
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      AppMethodBeat.o(153079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hDr == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.hDr) + 0;; paramInt = 0)
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
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localr.hDr = locala.OmT.readString();
          AppMethodBeat.o(153079);
          return 0;
        }
        localr.value = locala.OmT.readString();
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