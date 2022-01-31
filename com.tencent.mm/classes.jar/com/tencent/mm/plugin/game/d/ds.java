package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ds
  extends com.tencent.mm.bv.a
{
  public String nqK;
  public String nuA;
  public int nuB;
  public String nuC;
  public String nuD;
  public String nux;
  public String nuy;
  public String nuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111683);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqK != null) {
        paramVarArgs.e(1, this.nqK);
      }
      if (this.nux != null) {
        paramVarArgs.e(2, this.nux);
      }
      if (this.nuy != null) {
        paramVarArgs.e(3, this.nuy);
      }
      if (this.nuz != null) {
        paramVarArgs.e(4, this.nuz);
      }
      if (this.nuA != null) {
        paramVarArgs.e(5, this.nuA);
      }
      paramVarArgs.aO(6, this.nuB);
      if (this.nuC != null) {
        paramVarArgs.e(7, this.nuC);
      }
      if (this.nuD != null) {
        paramVarArgs.e(8, this.nuD);
      }
      AppMethodBeat.o(111683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqK == null) {
        break label626;
      }
    }
    label626:
    for (int i = e.a.a.b.b.a.f(1, this.nqK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nux != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nux);
      }
      i = paramInt;
      if (this.nuy != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nuy);
      }
      paramInt = i;
      if (this.nuz != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nuz);
      }
      i = paramInt;
      if (this.nuA != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.nuA);
      }
      i += e.a.a.b.b.a.bl(6, this.nuB);
      paramInt = i;
      if (this.nuC != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.nuC);
      }
      i = paramInt;
      if (this.nuD != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.nuD);
      }
      AppMethodBeat.o(111683);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111683);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ds localds = (ds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111683);
          return -1;
        case 1: 
          localds.nqK = locala.CLY.readString();
          AppMethodBeat.o(111683);
          return 0;
        case 2: 
          localds.nux = locala.CLY.readString();
          AppMethodBeat.o(111683);
          return 0;
        case 3: 
          localds.nuy = locala.CLY.readString();
          AppMethodBeat.o(111683);
          return 0;
        case 4: 
          localds.nuz = locala.CLY.readString();
          AppMethodBeat.o(111683);
          return 0;
        case 5: 
          localds.nuA = locala.CLY.readString();
          AppMethodBeat.o(111683);
          return 0;
        case 6: 
          localds.nuB = locala.CLY.sl();
          AppMethodBeat.o(111683);
          return 0;
        case 7: 
          localds.nuC = locala.CLY.readString();
          AppMethodBeat.o(111683);
          return 0;
        }
        localds.nuD = locala.CLY.readString();
        AppMethodBeat.o(111683);
        return 0;
      }
      AppMethodBeat.o(111683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ds
 * JD-Core Version:    0.7.0.1
 */