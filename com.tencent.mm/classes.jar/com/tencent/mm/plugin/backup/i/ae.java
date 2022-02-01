package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b ncy;
  public String ndM;
  public int ndN;
  public int ndP;
  public int ndQ;
  public int ndR;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22137);
        throw paramVarArgs;
      }
      if (this.ndM != null) {
        paramVarArgs.d(1, this.ndM);
      }
      paramVarArgs.aR(2, this.ndN);
      paramVarArgs.aR(3, this.ndP);
      paramVarArgs.aR(4, this.ndQ);
      paramVarArgs.aR(5, this.ndj);
      paramVarArgs.aR(6, this.ndR);
      if (this.ncy != null) {
        paramVarArgs.c(7, this.ncy);
      }
      AppMethodBeat.o(22137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndM == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.b.b.a.e(1, this.ndM) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndN) + f.a.a.b.b.a.bx(3, this.ndP) + f.a.a.b.b.a.bx(4, this.ndQ) + f.a.a.b.b.a.bx(5, this.ndj) + f.a.a.b.b.a.bx(6, this.ndR);
      paramInt = i;
      if (this.ncy != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.ncy);
      }
      AppMethodBeat.o(22137);
      return paramInt;
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
          AppMethodBeat.o(22137);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22137);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22137);
          return -1;
        case 1: 
          localae.ndM = locala.LVo.readString();
          AppMethodBeat.o(22137);
          return 0;
        case 2: 
          localae.ndN = locala.LVo.xF();
          AppMethodBeat.o(22137);
          return 0;
        case 3: 
          localae.ndP = locala.LVo.xF();
          AppMethodBeat.o(22137);
          return 0;
        case 4: 
          localae.ndQ = locala.LVo.xF();
          AppMethodBeat.o(22137);
          return 0;
        case 5: 
          localae.ndj = locala.LVo.xF();
          AppMethodBeat.o(22137);
          return 0;
        case 6: 
          localae.ndR = locala.LVo.xF();
          AppMethodBeat.o(22137);
          return 0;
        }
        localae.ncy = locala.LVo.gfk();
        AppMethodBeat.o(22137);
        return 0;
      }
      AppMethodBeat.o(22137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */