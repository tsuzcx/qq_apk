package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ae
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public com.tencent.mm.bv.b jJh;
  public int jKA;
  public int jKB;
  public String jKw;
  public int jKx;
  public int jKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18080);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jKw == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: DataID");
        AppMethodBeat.o(18080);
        throw paramVarArgs;
      }
      if (this.jKw != null) {
        paramVarArgs.e(1, this.jKw);
      }
      paramVarArgs.aO(2, this.jKx);
      paramVarArgs.aO(3, this.jKz);
      paramVarArgs.aO(4, this.jKA);
      paramVarArgs.aO(5, this.jJS);
      paramVarArgs.aO(6, this.jKB);
      if (this.jJh != null) {
        paramVarArgs.c(7, this.jJh);
      }
      AppMethodBeat.o(18080);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jKw == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = e.a.a.b.b.a.f(1, this.jKw) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKx) + e.a.a.b.b.a.bl(3, this.jKz) + e.a.a.b.b.a.bl(4, this.jKA) + e.a.a.b.b.a.bl(5, this.jJS) + e.a.a.b.b.a.bl(6, this.jKB);
      paramInt = i;
      if (this.jJh != null) {
        paramInt = i + e.a.a.b.b.a.b(7, this.jJh);
      }
      AppMethodBeat.o(18080);
      return paramInt;
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
          AppMethodBeat.o(18080);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18080);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18080);
          return -1;
        case 1: 
          localae.jKw = locala.CLY.readString();
          AppMethodBeat.o(18080);
          return 0;
        case 2: 
          localae.jKx = locala.CLY.sl();
          AppMethodBeat.o(18080);
          return 0;
        case 3: 
          localae.jKz = locala.CLY.sl();
          AppMethodBeat.o(18080);
          return 0;
        case 4: 
          localae.jKA = locala.CLY.sl();
          AppMethodBeat.o(18080);
          return 0;
        case 5: 
          localae.jJS = locala.CLY.sl();
          AppMethodBeat.o(18080);
          return 0;
        case 6: 
          localae.jKB = locala.CLY.sl();
          AppMethodBeat.o(18080);
          return 0;
        }
        localae.jJh = locala.CLY.eqS();
        AppMethodBeat.o(18080);
        return 0;
      }
      AppMethodBeat.o(18080);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ae
 * JD-Core Version:    0.7.0.1
 */