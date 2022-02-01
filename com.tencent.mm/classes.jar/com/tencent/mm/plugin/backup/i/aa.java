package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class aa
  extends com.tencent.mm.bw.a
{
  public String oTx;
  public long oUG;
  public long oUH;
  public String oUI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22133);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oTx == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22133);
        throw paramVarArgs;
      }
      if (this.oUI == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22133);
        throw paramVarArgs;
      }
      if (this.oTx != null) {
        paramVarArgs.e(1, this.oTx);
      }
      paramVarArgs.bb(2, this.oUG);
      paramVarArgs.bb(3, this.oUH);
      if (this.oUI != null) {
        paramVarArgs.e(4, this.oUI);
      }
      AppMethodBeat.o(22133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oTx == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = g.a.a.b.b.a.f(1, this.oTx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.oUG) + g.a.a.b.b.a.r(3, this.oUH);
      paramInt = i;
      if (this.oUI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.oUI);
      }
      AppMethodBeat.o(22133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oTx == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22133);
          throw paramVarArgs;
        }
        if (this.oUI == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22133);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22133);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22133);
          return -1;
        case 1: 
          localaa.oTx = locala.UbS.readString();
          AppMethodBeat.o(22133);
          return 0;
        case 2: 
          localaa.oUG = locala.UbS.zl();
          AppMethodBeat.o(22133);
          return 0;
        case 3: 
          localaa.oUH = locala.UbS.zl();
          AppMethodBeat.o(22133);
          return 0;
        }
        localaa.oUI = locala.UbS.readString();
        AppMethodBeat.o(22133);
        return 0;
      }
      AppMethodBeat.o(22133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.aa
 * JD-Core Version:    0.7.0.1
 */