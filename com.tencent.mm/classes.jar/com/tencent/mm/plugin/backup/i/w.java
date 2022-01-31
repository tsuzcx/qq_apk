package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bv.a
{
  public String ID;
  public int Version;
  public int jJS;
  public com.tencent.mm.bv.b jJh;
  public int jKr;
  public int jKs;
  public int jKt;
  public com.tencent.mm.bv.b jKv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18071);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(18071);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.jKr);
      paramVarArgs.aO(2, this.jJS);
      if (this.ID != null) {
        paramVarArgs.e(3, this.ID);
      }
      if (this.jJh != null) {
        paramVarArgs.c(4, this.jJh);
      }
      paramVarArgs.aO(5, this.Version);
      paramVarArgs.aO(6, this.jKs);
      paramVarArgs.aO(7, this.jKt);
      if (this.jKv != null) {
        paramVarArgs.c(8, this.jKv);
      }
      AppMethodBeat.o(18071);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jKr) + 0 + e.a.a.b.b.a.bl(2, this.jJS);
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.ID);
      }
      i = paramInt;
      if (this.jJh != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.jJh);
      }
      i = i + e.a.a.b.b.a.bl(5, this.Version) + e.a.a.b.b.a.bl(6, this.jKs) + e.a.a.b.b.a.bl(7, this.jKt);
      paramInt = i;
      if (this.jKv != null) {
        paramInt = i + e.a.a.b.b.a.b(8, this.jKv);
      }
      AppMethodBeat.o(18071);
      return paramInt;
    }
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
        paramVarArgs = new e.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(18071);
        throw paramVarArgs;
      }
      AppMethodBeat.o(18071);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      w localw = (w)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18071);
        return -1;
      case 1: 
        localw.jKr = locala.CLY.sl();
        AppMethodBeat.o(18071);
        return 0;
      case 2: 
        localw.jJS = locala.CLY.sl();
        AppMethodBeat.o(18071);
        return 0;
      case 3: 
        localw.ID = locala.CLY.readString();
        AppMethodBeat.o(18071);
        return 0;
      case 4: 
        localw.jJh = locala.CLY.eqS();
        AppMethodBeat.o(18071);
        return 0;
      case 5: 
        localw.Version = locala.CLY.sl();
        AppMethodBeat.o(18071);
        return 0;
      case 6: 
        localw.jKs = locala.CLY.sl();
        AppMethodBeat.o(18071);
        return 0;
      case 7: 
        localw.jKt = locala.CLY.sl();
        AppMethodBeat.o(18071);
        return 0;
      }
      localw.jKv = locala.CLY.eqS();
      AppMethodBeat.o(18071);
      return 0;
    }
    AppMethodBeat.o(18071);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.w
 * JD-Core Version:    0.7.0.1
 */