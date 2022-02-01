package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b nCV;
  public int nDG;
  public String nEj;
  public int nEk;
  public int nEm;
  public int nEn;
  public int nEo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22137);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nEj == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22137);
        throw paramVarArgs;
      }
      if (this.nEj != null) {
        paramVarArgs.d(1, this.nEj);
      }
      paramVarArgs.aS(2, this.nEk);
      paramVarArgs.aS(3, this.nEm);
      paramVarArgs.aS(4, this.nEn);
      paramVarArgs.aS(5, this.nDG);
      paramVarArgs.aS(6, this.nEo);
      if (this.nCV != null) {
        paramVarArgs.c(7, this.nCV);
      }
      AppMethodBeat.o(22137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nEj == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = f.a.a.b.b.a.e(1, this.nEj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEk) + f.a.a.b.b.a.bz(3, this.nEm) + f.a.a.b.b.a.bz(4, this.nEn) + f.a.a.b.b.a.bz(5, this.nDG) + f.a.a.b.b.a.bz(6, this.nEo);
      paramInt = i;
      if (this.nCV != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.nCV);
      }
      AppMethodBeat.o(22137);
      return paramInt;
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
          localae.nEj = locala.NPN.readString();
          AppMethodBeat.o(22137);
          return 0;
        case 2: 
          localae.nEk = locala.NPN.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 3: 
          localae.nEm = locala.NPN.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 4: 
          localae.nEn = locala.NPN.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 5: 
          localae.nDG = locala.NPN.zc();
          AppMethodBeat.o(22137);
          return 0;
        case 6: 
          localae.nEo = locala.NPN.zc();
          AppMethodBeat.o(22137);
          return 0;
        }
        localae.nCV = locala.NPN.gxI();
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