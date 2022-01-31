package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bv.a
{
  public String eds;
  public int kXj;
  public String kXk;
  public String kXl;
  public String kXm;
  public String kXn;
  public int kXo;
  public String kXp;
  public String kXq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35540);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.kXj);
      if (this.eds != null) {
        paramVarArgs.e(2, this.eds);
      }
      if (this.kXk != null) {
        paramVarArgs.e(3, this.kXk);
      }
      if (this.kXl != null) {
        paramVarArgs.e(4, this.kXl);
      }
      if (this.kXm != null) {
        paramVarArgs.e(5, this.kXm);
      }
      if (this.kXn != null) {
        paramVarArgs.e(6, this.kXn);
      }
      paramVarArgs.aO(7, this.kXo);
      if (this.kXp != null) {
        paramVarArgs.e(8, this.kXp);
      }
      if (this.kXq != null) {
        paramVarArgs.e(9, this.kXq);
      }
      AppMethodBeat.o(35540);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.kXj) + 0;
      paramInt = i;
      if (this.eds != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.eds);
      }
      i = paramInt;
      if (this.kXk != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kXk);
      }
      paramInt = i;
      if (this.kXl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kXl);
      }
      i = paramInt;
      if (this.kXm != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.kXm);
      }
      paramInt = i;
      if (this.kXn != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.kXn);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.kXo);
      paramInt = i;
      if (this.kXp != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.kXp);
      }
      i = paramInt;
      if (this.kXq != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.kXq);
      }
      AppMethodBeat.o(35540);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(35540);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(35540);
        return -1;
      case 1: 
        localn.kXj = locala.CLY.sl();
        AppMethodBeat.o(35540);
        return 0;
      case 2: 
        localn.eds = locala.CLY.readString();
        AppMethodBeat.o(35540);
        return 0;
      case 3: 
        localn.kXk = locala.CLY.readString();
        AppMethodBeat.o(35540);
        return 0;
      case 4: 
        localn.kXl = locala.CLY.readString();
        AppMethodBeat.o(35540);
        return 0;
      case 5: 
        localn.kXm = locala.CLY.readString();
        AppMethodBeat.o(35540);
        return 0;
      case 6: 
        localn.kXn = locala.CLY.readString();
        AppMethodBeat.o(35540);
        return 0;
      case 7: 
        localn.kXo = locala.CLY.sl();
        AppMethodBeat.o(35540);
        return 0;
      case 8: 
        localn.kXp = locala.CLY.readString();
        AppMethodBeat.o(35540);
        return 0;
      }
      localn.kXq = locala.CLY.readString();
      AppMethodBeat.o(35540);
      return 0;
    }
    AppMethodBeat.o(35540);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.n
 * JD-Core Version:    0.7.0.1
 */