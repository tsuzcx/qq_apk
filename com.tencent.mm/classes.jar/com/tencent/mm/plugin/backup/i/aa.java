package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aa
  extends com.tencent.mm.bw.a
{
  public String ncJ;
  public long ndT;
  public long ndU;
  public String ndV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22133);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22133);
        throw paramVarArgs;
      }
      if (this.ndV == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22133);
        throw paramVarArgs;
      }
      if (this.ncJ != null) {
        paramVarArgs.d(1, this.ncJ);
      }
      paramVarArgs.aO(2, this.ndT);
      paramVarArgs.aO(3, this.ndU);
      if (this.ndV != null) {
        paramVarArgs.d(4, this.ndV);
      }
      AppMethodBeat.o(22133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncJ == null) {
        break label472;
      }
    }
    label472:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.ndT) + f.a.a.b.b.a.p(3, this.ndU);
      paramInt = i;
      if (this.ndV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ndV);
      }
      AppMethodBeat.o(22133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22133);
          throw paramVarArgs;
        }
        if (this.ndV == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aa localaa = (aa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22133);
          return -1;
        case 1: 
          localaa.ncJ = locala.LVo.readString();
          AppMethodBeat.o(22133);
          return 0;
        case 2: 
          localaa.ndT = locala.LVo.xG();
          AppMethodBeat.o(22133);
          return 0;
        case 3: 
          localaa.ndU = locala.LVo.xG();
          AppMethodBeat.o(22133);
          return 0;
        }
        localaa.ndV = locala.LVo.readString();
        AppMethodBeat.o(22133);
        return 0;
      }
      AppMethodBeat.o(22133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.aa
 * JD-Core Version:    0.7.0.1
 */