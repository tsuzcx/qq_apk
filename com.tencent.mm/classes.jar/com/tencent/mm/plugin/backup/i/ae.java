package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bw.a
{
  public int oTW;
  public com.tencent.mm.bw.b oTm;
  public int oUA;
  public int oUC;
  public int oUD;
  public int oUE;
  public String oUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22137);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22137);
        throw paramVarArgs;
      }
      if (this.oUz != null) {
        paramVarArgs.e(1, this.oUz);
      }
      paramVarArgs.aM(2, this.oUA);
      paramVarArgs.aM(3, this.oUC);
      paramVarArgs.aM(4, this.oUD);
      paramVarArgs.aM(5, this.oTW);
      paramVarArgs.aM(6, this.oUE);
      if (this.oTm != null) {
        paramVarArgs.c(7, this.oTm);
      }
      AppMethodBeat.o(22137);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUz == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = g.a.a.b.b.a.f(1, this.oUz) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUA) + g.a.a.b.b.a.bu(3, this.oUC) + g.a.a.b.b.a.bu(4, this.oUD) + g.a.a.b.b.a.bu(5, this.oTW) + g.a.a.b.b.a.bu(6, this.oUE);
      paramInt = i;
      if (this.oTm != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.oTm);
      }
      AppMethodBeat.o(22137);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oUz == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: DataID");
          AppMethodBeat.o(22137);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22137);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22137);
          return -1;
        case 1: 
          localae.oUz = locala.UbS.readString();
          AppMethodBeat.o(22137);
          return 0;
        case 2: 
          localae.oUA = locala.UbS.zi();
          AppMethodBeat.o(22137);
          return 0;
        case 3: 
          localae.oUC = locala.UbS.zi();
          AppMethodBeat.o(22137);
          return 0;
        case 4: 
          localae.oUD = locala.UbS.zi();
          AppMethodBeat.o(22137);
          return 0;
        case 5: 
          localae.oTW = locala.UbS.zi();
          AppMethodBeat.o(22137);
          return 0;
        case 6: 
          localae.oUE = locala.UbS.zi();
          AppMethodBeat.o(22137);
          return 0;
        }
        localae.oTm = locala.UbS.hPo();
        AppMethodBeat.o(22137);
        return 0;
      }
      AppMethodBeat.o(22137);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */