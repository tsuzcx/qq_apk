package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class p
  extends com.tencent.mm.bv.a
{
  public String ID;
  public long jJR;
  public int jJU;
  public int jJV;
  public int jJW;
  public long jJX;
  public long jJY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18063);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(18063);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.aO(2, this.jJU);
      paramVarArgs.aO(3, this.jJV);
      paramVarArgs.aO(4, this.jJW);
      paramVarArgs.am(5, this.jJR);
      paramVarArgs.am(6, this.jJX);
      paramVarArgs.am(7, this.jJY);
      AppMethodBeat.o(18063);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = e.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jJU);
      int j = e.a.a.b.b.a.bl(3, this.jJV);
      int k = e.a.a.b.b.a.bl(4, this.jJW);
      int m = e.a.a.b.b.a.p(5, this.jJR);
      int n = e.a.a.b.b.a.p(6, this.jJX);
      int i1 = e.a.a.b.b.a.p(7, this.jJY);
      AppMethodBeat.o(18063);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(18063);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18063);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18063);
          return -1;
        case 1: 
          localp.ID = locala.CLY.readString();
          AppMethodBeat.o(18063);
          return 0;
        case 2: 
          localp.jJU = locala.CLY.sl();
          AppMethodBeat.o(18063);
          return 0;
        case 3: 
          localp.jJV = locala.CLY.sl();
          AppMethodBeat.o(18063);
          return 0;
        case 4: 
          localp.jJW = locala.CLY.sl();
          AppMethodBeat.o(18063);
          return 0;
        case 5: 
          localp.jJR = locala.CLY.sm();
          AppMethodBeat.o(18063);
          return 0;
        case 6: 
          localp.jJX = locala.CLY.sm();
          AppMethodBeat.o(18063);
          return 0;
        }
        localp.jJY = locala.CLY.sm();
        AppMethodBeat.o(18063);
        return 0;
      }
      AppMethodBeat.o(18063);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.p
 * JD-Core Version:    0.7.0.1
 */