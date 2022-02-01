package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ck
  extends com.tencent.mm.bx.a
{
  public String Title;
  public String ufb;
  public String ufg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufg == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41805);
        throw paramVarArgs;
      }
      if (this.ufg != null) {
        paramVarArgs.d(1, this.ufg);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.ufb != null) {
        paramVarArgs.d(3, this.ufb);
      }
      AppMethodBeat.o(41805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufg == null) {
        break label382;
      }
    }
    label382:
    for (int i = f.a.a.b.b.a.e(1, this.ufg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.ufb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ufb);
      }
      AppMethodBeat.o(41805);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ufg == null)
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
        ck localck = (ck)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41805);
          return -1;
        case 1: 
          localck.ufg = locala.NPN.readString();
          AppMethodBeat.o(41805);
          return 0;
        case 2: 
          localck.Title = locala.NPN.readString();
          AppMethodBeat.o(41805);
          return 0;
        }
        localck.ufb = locala.NPN.readString();
        AppMethodBeat.o(41805);
        return 0;
      }
      AppMethodBeat.o(41805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ck
 * JD-Core Version:    0.7.0.1
 */