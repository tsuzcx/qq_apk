package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ad
  extends com.tencent.mm.bw.a
{
  public String ndM;
  public int ndN;
  public int ndP;
  public int ndQ;
  public int ndS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22136);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndM == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22136);
        throw paramVarArgs;
      }
      if (this.ndM != null) {
        paramVarArgs.d(1, this.ndM);
      }
      paramVarArgs.aR(2, this.ndN);
      paramVarArgs.aR(3, this.ndP);
      paramVarArgs.aR(4, this.ndQ);
      paramVarArgs.aR(5, this.ndS);
      AppMethodBeat.o(22136);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndM == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = f.a.a.b.b.a.e(1, this.ndM) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.ndN);
      int j = f.a.a.b.b.a.bx(3, this.ndP);
      int k = f.a.a.b.b.a.bx(4, this.ndQ);
      int m = f.a.a.b.b.a.bx(5, this.ndS);
      AppMethodBeat.o(22136);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ndM == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataID");
          AppMethodBeat.o(22136);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22136);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22136);
          return -1;
        case 1: 
          localad.ndM = locala.LVo.readString();
          AppMethodBeat.o(22136);
          return 0;
        case 2: 
          localad.ndN = locala.LVo.xF();
          AppMethodBeat.o(22136);
          return 0;
        case 3: 
          localad.ndP = locala.LVo.xF();
          AppMethodBeat.o(22136);
          return 0;
        case 4: 
          localad.ndQ = locala.LVo.xF();
          AppMethodBeat.o(22136);
          return 0;
        }
        localad.ndS = locala.LVo.xF();
        AppMethodBeat.o(22136);
        return 0;
      }
      AppMethodBeat.o(22136);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ad
 * JD-Core Version:    0.7.0.1
 */