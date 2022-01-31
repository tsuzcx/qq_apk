package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b jJh;
  public int jKA;
  public int jKB;
  public int jKC;
  public String jKw;
  public int jKx;
  public int jKy;
  public int jKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18072);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jKw == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(18072);
        throw paramVarArgs;
      }
      if (this.jKw != null) {
        paramVarArgs.e(1, this.jKw);
      }
      paramVarArgs.aO(2, this.jKx);
      paramVarArgs.aO(3, this.jKy);
      paramVarArgs.aO(4, this.jKz);
      paramVarArgs.aO(5, this.jKA);
      paramVarArgs.aO(6, this.jKB);
      if (this.jJh != null) {
        paramVarArgs.c(7, this.jJh);
      }
      paramVarArgs.aO(8, this.jKC);
      AppMethodBeat.o(18072);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jKw == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = e.a.a.b.b.a.f(1, this.jKw) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKx) + e.a.a.b.b.a.bl(3, this.jKy) + e.a.a.b.b.a.bl(4, this.jKz) + e.a.a.b.b.a.bl(5, this.jKA) + e.a.a.b.b.a.bl(6, this.jKB);
      paramInt = i;
      if (this.jJh != null) {
        paramInt = i + e.a.a.b.b.a.b(7, this.jJh);
      }
      i = e.a.a.b.b.a.bl(8, this.jKC);
      AppMethodBeat.o(18072);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jKw == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: DataID");
          AppMethodBeat.o(18072);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18072);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18072);
          return -1;
        case 1: 
          localx.jKw = locala.CLY.readString();
          AppMethodBeat.o(18072);
          return 0;
        case 2: 
          localx.jKx = locala.CLY.sl();
          AppMethodBeat.o(18072);
          return 0;
        case 3: 
          localx.jKy = locala.CLY.sl();
          AppMethodBeat.o(18072);
          return 0;
        case 4: 
          localx.jKz = locala.CLY.sl();
          AppMethodBeat.o(18072);
          return 0;
        case 5: 
          localx.jKA = locala.CLY.sl();
          AppMethodBeat.o(18072);
          return 0;
        case 6: 
          localx.jKB = locala.CLY.sl();
          AppMethodBeat.o(18072);
          return 0;
        case 7: 
          localx.jJh = locala.CLY.eqS();
          AppMethodBeat.o(18072);
          return 0;
        }
        localx.jKC = locala.CLY.sl();
        AppMethodBeat.o(18072);
        return 0;
      }
      AppMethodBeat.o(18072);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.x
 * JD-Core Version:    0.7.0.1
 */