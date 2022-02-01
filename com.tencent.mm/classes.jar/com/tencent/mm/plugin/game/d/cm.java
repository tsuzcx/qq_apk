package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cm
  extends com.tencent.mm.bx.a
{
  public String iht;
  public String ujc;
  public int ujd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199583);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(199583);
        throw paramVarArgs;
      }
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      if (this.ujc != null) {
        paramVarArgs.d(2, this.ujc);
      }
      paramVarArgs.aS(3, this.ujd);
      AppMethodBeat.o(199583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.iht) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ujc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ujc);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.ujd);
      AppMethodBeat.o(199583);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.iht == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(199583);
          throw paramVarArgs;
        }
        AppMethodBeat.o(199583);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(199583);
          return -1;
        case 1: 
          localcm.iht = locala.NPN.readString();
          AppMethodBeat.o(199583);
          return 0;
        case 2: 
          localcm.ujc = locala.NPN.readString();
          AppMethodBeat.o(199583);
          return 0;
        }
        localcm.ujd = locala.NPN.zc();
        AppMethodBeat.o(199583);
        return 0;
      }
      AppMethodBeat.o(199583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cm
 * JD-Core Version:    0.7.0.1
 */