package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b ncy;
  public String ndM;
  public int ndN;
  public int ndO;
  public int ndP;
  public int ndQ;
  public int ndR;
  public int ndS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22129);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ndM == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22129);
        throw paramVarArgs;
      }
      if (this.ndM != null) {
        paramVarArgs.d(1, this.ndM);
      }
      paramVarArgs.aR(2, this.ndN);
      paramVarArgs.aR(3, this.ndO);
      paramVarArgs.aR(4, this.ndP);
      paramVarArgs.aR(5, this.ndQ);
      paramVarArgs.aR(6, this.ndR);
      if (this.ncy != null) {
        paramVarArgs.c(7, this.ncy);
      }
      paramVarArgs.aR(8, this.ndS);
      AppMethodBeat.o(22129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ndM == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = f.a.a.b.b.a.e(1, this.ndM) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndN) + f.a.a.b.b.a.bx(3, this.ndO) + f.a.a.b.b.a.bx(4, this.ndP) + f.a.a.b.b.a.bx(5, this.ndQ) + f.a.a.b.b.a.bx(6, this.ndR);
      paramInt = i;
      if (this.ncy != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.ncy);
      }
      i = f.a.a.b.b.a.bx(8, this.ndS);
      AppMethodBeat.o(22129);
      return paramInt + i;
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
          AppMethodBeat.o(22129);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22129);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22129);
          return -1;
        case 1: 
          localx.ndM = locala.LVo.readString();
          AppMethodBeat.o(22129);
          return 0;
        case 2: 
          localx.ndN = locala.LVo.xF();
          AppMethodBeat.o(22129);
          return 0;
        case 3: 
          localx.ndO = locala.LVo.xF();
          AppMethodBeat.o(22129);
          return 0;
        case 4: 
          localx.ndP = locala.LVo.xF();
          AppMethodBeat.o(22129);
          return 0;
        case 5: 
          localx.ndQ = locala.LVo.xF();
          AppMethodBeat.o(22129);
          return 0;
        case 6: 
          localx.ndR = locala.LVo.xF();
          AppMethodBeat.o(22129);
          return 0;
        case 7: 
          localx.ncy = locala.LVo.gfk();
          AppMethodBeat.o(22129);
          return 0;
        }
        localx.ndS = locala.LVo.xF();
        AppMethodBeat.o(22129);
        return 0;
      }
      AppMethodBeat.o(22129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.x
 * JD-Core Version:    0.7.0.1
 */