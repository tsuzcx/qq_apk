package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v
  extends com.tencent.mm.bv.a
{
  public String ID;
  public int Version;
  public com.tencent.mm.bv.b jJh;
  public int jKr;
  public int jKs;
  public int jKt;
  public int jKu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18070);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: ID");
        AppMethodBeat.o(18070);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.jKr);
      if (this.ID != null) {
        paramVarArgs.e(2, this.ID);
      }
      if (this.jJh != null) {
        paramVarArgs.c(3, this.jJh);
      }
      paramVarArgs.aO(4, this.Version);
      paramVarArgs.aO(5, this.jKs);
      paramVarArgs.aO(6, this.jKt);
      paramVarArgs.aO(7, this.jKu);
      AppMethodBeat.o(18070);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.jKr) + 0;
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ID);
      }
      i = paramInt;
      if (this.jJh != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.jJh);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.Version);
      int j = e.a.a.b.b.a.bl(5, this.jKs);
      int k = e.a.a.b.b.a.bl(6, this.jKt);
      int m = e.a.a.b.b.a.bl(7, this.jKu);
      AppMethodBeat.o(18070);
      return i + paramInt + j + k + m;
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
        AppMethodBeat.o(18070);
        throw paramVarArgs;
      }
      AppMethodBeat.o(18070);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      v localv = (v)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18070);
        return -1;
      case 1: 
        localv.jKr = locala.CLY.sl();
        AppMethodBeat.o(18070);
        return 0;
      case 2: 
        localv.ID = locala.CLY.readString();
        AppMethodBeat.o(18070);
        return 0;
      case 3: 
        localv.jJh = locala.CLY.eqS();
        AppMethodBeat.o(18070);
        return 0;
      case 4: 
        localv.Version = locala.CLY.sl();
        AppMethodBeat.o(18070);
        return 0;
      case 5: 
        localv.jKs = locala.CLY.sl();
        AppMethodBeat.o(18070);
        return 0;
      case 6: 
        localv.jKt = locala.CLY.sl();
        AppMethodBeat.o(18070);
        return 0;
      }
      localv.jKu = locala.CLY.sl();
      AppMethodBeat.o(18070);
      return 0;
    }
    AppMethodBeat.o(18070);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.v
 * JD-Core Version:    0.7.0.1
 */