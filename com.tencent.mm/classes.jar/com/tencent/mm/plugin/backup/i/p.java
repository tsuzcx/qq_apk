package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class p
  extends com.tencent.mm.bw.a
{
  public String ID;
  public long oTV;
  public int oTY;
  public int oTZ;
  public int oUa;
  public long oUb;
  public long oUc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22120);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.aM(2, this.oTY);
      paramVarArgs.aM(3, this.oTZ);
      paramVarArgs.aM(4, this.oUa);
      paramVarArgs.bb(5, this.oTV);
      paramVarArgs.bb(6, this.oUb);
      paramVarArgs.bb(7, this.oUc);
      AppMethodBeat.o(22120);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = g.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oTY);
      int j = g.a.a.b.b.a.bu(3, this.oTZ);
      int k = g.a.a.b.b.a.bu(4, this.oUa);
      int m = g.a.a.b.b.a.r(5, this.oTV);
      int n = g.a.a.b.b.a.r(6, this.oUb);
      int i1 = g.a.a.b.b.a.r(7, this.oUc);
      AppMethodBeat.o(22120);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22120);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22120);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22120);
          return -1;
        case 1: 
          localp.ID = locala.UbS.readString();
          AppMethodBeat.o(22120);
          return 0;
        case 2: 
          localp.oTY = locala.UbS.zi();
          AppMethodBeat.o(22120);
          return 0;
        case 3: 
          localp.oTZ = locala.UbS.zi();
          AppMethodBeat.o(22120);
          return 0;
        case 4: 
          localp.oUa = locala.UbS.zi();
          AppMethodBeat.o(22120);
          return 0;
        case 5: 
          localp.oTV = locala.UbS.zl();
          AppMethodBeat.o(22120);
          return 0;
        case 6: 
          localp.oUb = locala.UbS.zl();
          AppMethodBeat.o(22120);
          return 0;
        }
        localp.oUc = locala.UbS.zl();
        AppMethodBeat.o(22120);
        return 0;
      }
      AppMethodBeat.o(22120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.p
 * JD-Core Version:    0.7.0.1
 */