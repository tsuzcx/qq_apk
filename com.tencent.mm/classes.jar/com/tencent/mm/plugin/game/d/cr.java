package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cr
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String uqi;
  public String uqq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqq == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41805);
        throw paramVarArgs;
      }
      if (this.uqq != null) {
        paramVarArgs.d(1, this.uqq);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.uqi != null) {
        paramVarArgs.d(3, this.uqi);
      }
      AppMethodBeat.o(41805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqq == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.uqq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.uqi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uqi);
      }
      AppMethodBeat.o(41805);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uqq == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconURL");
          AppMethodBeat.o(41805);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41805);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41805);
          return -1;
        case 1: 
          localcr.uqq = locala.OmT.readString();
          AppMethodBeat.o(41805);
          return 0;
        case 2: 
          localcr.Title = locala.OmT.readString();
          AppMethodBeat.o(41805);
          return 0;
        }
        localcr.uqi = locala.OmT.readString();
        AppMethodBeat.o(41805);
        return 0;
      }
      AppMethodBeat.o(41805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cr
 * JD-Core Version:    0.7.0.1
 */