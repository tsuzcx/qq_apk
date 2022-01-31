package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bv.a
{
  public String onz;
  public String ooB;
  public String ooC;
  public String ooD;
  public String ooE;
  public long ooo;
  public String oop;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56615);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ooB != null) {
        paramVarArgs.e(1, this.ooB);
      }
      if (this.ooC != null) {
        paramVarArgs.e(2, this.ooC);
      }
      paramVarArgs.am(3, this.ooo);
      if (this.oop != null) {
        paramVarArgs.e(4, this.oop);
      }
      if (this.ooD != null) {
        paramVarArgs.e(5, this.ooD);
      }
      if (this.onz != null) {
        paramVarArgs.e(6, this.onz);
      }
      if (this.ooE != null) {
        paramVarArgs.e(7, this.ooE);
      }
      if (this.userName != null) {
        paramVarArgs.e(8, this.userName);
      }
      AppMethodBeat.o(56615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ooB == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = e.a.a.b.b.a.f(1, this.ooB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ooC != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ooC);
      }
      i += e.a.a.b.b.a.p(3, this.ooo);
      paramInt = i;
      if (this.oop != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.oop);
      }
      i = paramInt;
      if (this.ooD != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.ooD);
      }
      paramInt = i;
      if (this.onz != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.onz);
      }
      i = paramInt;
      if (this.ooE != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.ooE);
      }
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.userName);
      }
      AppMethodBeat.o(56615);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56615);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56615);
          return -1;
        case 1: 
          localw.ooB = locala.CLY.readString();
          AppMethodBeat.o(56615);
          return 0;
        case 2: 
          localw.ooC = locala.CLY.readString();
          AppMethodBeat.o(56615);
          return 0;
        case 3: 
          localw.ooo = locala.CLY.sm();
          AppMethodBeat.o(56615);
          return 0;
        case 4: 
          localw.oop = locala.CLY.readString();
          AppMethodBeat.o(56615);
          return 0;
        case 5: 
          localw.ooD = locala.CLY.readString();
          AppMethodBeat.o(56615);
          return 0;
        case 6: 
          localw.onz = locala.CLY.readString();
          AppMethodBeat.o(56615);
          return 0;
        case 7: 
          localw.ooE = locala.CLY.readString();
          AppMethodBeat.o(56615);
          return 0;
        }
        localw.userName = locala.CLY.readString();
        AppMethodBeat.o(56615);
        return 0;
      }
      AppMethodBeat.o(56615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.w
 * JD-Core Version:    0.7.0.1
 */