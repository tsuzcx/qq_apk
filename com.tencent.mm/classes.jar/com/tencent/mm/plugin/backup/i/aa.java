package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class aa
  extends com.tencent.mm.bv.a
{
  public String jJs;
  public long jKD;
  public long jKE;
  public String jKF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18076);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJs == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(18076);
        throw paramVarArgs;
      }
      if (this.jKF == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(18076);
        throw paramVarArgs;
      }
      if (this.jJs != null) {
        paramVarArgs.e(1, this.jJs);
      }
      paramVarArgs.am(2, this.jKD);
      paramVarArgs.am(3, this.jKE);
      if (this.jKF != null) {
        paramVarArgs.e(4, this.jKF);
      }
      AppMethodBeat.o(18076);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJs == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJs) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.jKD) + e.a.a.b.b.a.p(3, this.jKE);
      paramInt = i;
      if (this.jKF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jKF);
      }
      AppMethodBeat.o(18076);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJs == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(18076);
          throw paramVarArgs;
        }
        if (this.jKF == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(18076);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18076);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18076);
          return -1;
        case 1: 
          localaa.jJs = locala.CLY.readString();
          AppMethodBeat.o(18076);
          return 0;
        case 2: 
          localaa.jKD = locala.CLY.sm();
          AppMethodBeat.o(18076);
          return 0;
        case 3: 
          localaa.jKE = locala.CLY.sm();
          AppMethodBeat.o(18076);
          return 0;
        }
        localaa.jKF = locala.CLY.readString();
        AppMethodBeat.o(18076);
        return 0;
      }
      AppMethodBeat.o(18076);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.aa
 * JD-Core Version:    0.7.0.1
 */