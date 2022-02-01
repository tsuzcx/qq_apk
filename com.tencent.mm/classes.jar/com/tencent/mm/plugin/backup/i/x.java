package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b nCV;
  public String nEj;
  public int nEk;
  public int nEl;
  public int nEm;
  public int nEn;
  public int nEo;
  public int nEp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22129);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nEj == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22129);
        throw paramVarArgs;
      }
      if (this.nEj != null) {
        paramVarArgs.d(1, this.nEj);
      }
      paramVarArgs.aS(2, this.nEk);
      paramVarArgs.aS(3, this.nEl);
      paramVarArgs.aS(4, this.nEm);
      paramVarArgs.aS(5, this.nEn);
      paramVarArgs.aS(6, this.nEo);
      if (this.nCV != null) {
        paramVarArgs.c(7, this.nCV);
      }
      paramVarArgs.aS(8, this.nEp);
      AppMethodBeat.o(22129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nEj == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = f.a.a.b.b.a.e(1, this.nEj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEk) + f.a.a.b.b.a.bz(3, this.nEl) + f.a.a.b.b.a.bz(4, this.nEm) + f.a.a.b.b.a.bz(5, this.nEn) + f.a.a.b.b.a.bz(6, this.nEo);
      paramInt = i;
      if (this.nCV != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.nCV);
      }
      i = f.a.a.b.b.a.bz(8, this.nEp);
      AppMethodBeat.o(22129);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.nEj == null)
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
          localx.nEj = locala.NPN.readString();
          AppMethodBeat.o(22129);
          return 0;
        case 2: 
          localx.nEk = locala.NPN.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 3: 
          localx.nEl = locala.NPN.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 4: 
          localx.nEm = locala.NPN.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 5: 
          localx.nEn = locala.NPN.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 6: 
          localx.nEo = locala.NPN.zc();
          AppMethodBeat.o(22129);
          return 0;
        case 7: 
          localx.nCV = locala.NPN.gxI();
          AppMethodBeat.o(22129);
          return 0;
        }
        localx.nEp = locala.NPN.zc();
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