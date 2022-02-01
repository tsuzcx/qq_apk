package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b oTm;
  public int oUA;
  public int oUB;
  public int oUC;
  public int oUD;
  public int oUE;
  public int oUF;
  public String oUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22129);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oUz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(22129);
        throw paramVarArgs;
      }
      if (this.oUz != null) {
        paramVarArgs.e(1, this.oUz);
      }
      paramVarArgs.aM(2, this.oUA);
      paramVarArgs.aM(3, this.oUB);
      paramVarArgs.aM(4, this.oUC);
      paramVarArgs.aM(5, this.oUD);
      paramVarArgs.aM(6, this.oUE);
      if (this.oTm != null) {
        paramVarArgs.c(7, this.oTm);
      }
      paramVarArgs.aM(8, this.oUF);
      AppMethodBeat.o(22129);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oUz == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = g.a.a.b.b.a.f(1, this.oUz) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUA) + g.a.a.b.b.a.bu(3, this.oUB) + g.a.a.b.b.a.bu(4, this.oUC) + g.a.a.b.b.a.bu(5, this.oUD) + g.a.a.b.b.a.bu(6, this.oUE);
      paramInt = i;
      if (this.oTm != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.oTm);
      }
      i = g.a.a.b.b.a.bu(8, this.oUF);
      AppMethodBeat.o(22129);
      return paramInt + i;
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
          AppMethodBeat.o(22129);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22129);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22129);
          return -1;
        case 1: 
          localx.oUz = locala.UbS.readString();
          AppMethodBeat.o(22129);
          return 0;
        case 2: 
          localx.oUA = locala.UbS.zi();
          AppMethodBeat.o(22129);
          return 0;
        case 3: 
          localx.oUB = locala.UbS.zi();
          AppMethodBeat.o(22129);
          return 0;
        case 4: 
          localx.oUC = locala.UbS.zi();
          AppMethodBeat.o(22129);
          return 0;
        case 5: 
          localx.oUD = locala.UbS.zi();
          AppMethodBeat.o(22129);
          return 0;
        case 6: 
          localx.oUE = locala.UbS.zi();
          AppMethodBeat.o(22129);
          return 0;
        case 7: 
          localx.oTm = locala.UbS.hPo();
          AppMethodBeat.o(22129);
          return 0;
        }
        localx.oUF = locala.UbS.zi();
        AppMethodBeat.o(22129);
        return 0;
      }
      AppMethodBeat.o(22129);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.x
 * JD-Core Version:    0.7.0.1
 */