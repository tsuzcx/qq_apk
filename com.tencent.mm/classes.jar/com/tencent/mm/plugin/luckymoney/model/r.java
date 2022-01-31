package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends com.tencent.mm.bv.a
{
  public int cMP;
  public String ojA;
  public int onK;
  public String ont;
  public long onw;
  public long ony;
  public String onz;
  public String oon;
  public long ooo;
  public String oop;
  public String ooq;
  public String oor;
  public long oos;
  public int oot;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56614);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.oon != null) {
        paramVarArgs.e(1, this.oon);
      }
      if (this.ont != null) {
        paramVarArgs.e(2, this.ont);
      }
      paramVarArgs.am(3, this.ooo);
      if (this.oop != null) {
        paramVarArgs.e(4, this.oop);
      }
      paramVarArgs.aO(5, this.cMP);
      if (this.ooq != null) {
        paramVarArgs.e(6, this.ooq);
      }
      if (this.oor != null) {
        paramVarArgs.e(7, this.oor);
      }
      paramVarArgs.am(8, this.ony);
      paramVarArgs.am(9, this.oos);
      paramVarArgs.am(10, this.onw);
      paramVarArgs.aO(11, this.status);
      paramVarArgs.aO(12, this.oot);
      if (this.onz != null) {
        paramVarArgs.e(13, this.onz);
      }
      if (this.ojA != null) {
        paramVarArgs.e(14, this.ojA);
      }
      paramVarArgs.aO(15, this.onK);
      AppMethodBeat.o(56614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oon == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = e.a.a.b.b.a.f(1, this.oon) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ont != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ont);
      }
      i += e.a.a.b.b.a.p(3, this.ooo);
      paramInt = i;
      if (this.oop != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.oop);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.cMP);
      paramInt = i;
      if (this.ooq != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ooq);
      }
      i = paramInt;
      if (this.oor != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.oor);
      }
      i = i + e.a.a.b.b.a.p(8, this.ony) + e.a.a.b.b.a.p(9, this.oos) + e.a.a.b.b.a.p(10, this.onw) + e.a.a.b.b.a.bl(11, this.status) + e.a.a.b.b.a.bl(12, this.oot);
      paramInt = i;
      if (this.onz != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.onz);
      }
      i = paramInt;
      if (this.ojA != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.ojA);
      }
      paramInt = e.a.a.b.b.a.bl(15, this.onK);
      AppMethodBeat.o(56614);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56614);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56614);
          return -1;
        case 1: 
          localr.oon = locala.CLY.readString();
          AppMethodBeat.o(56614);
          return 0;
        case 2: 
          localr.ont = locala.CLY.readString();
          AppMethodBeat.o(56614);
          return 0;
        case 3: 
          localr.ooo = locala.CLY.sm();
          AppMethodBeat.o(56614);
          return 0;
        case 4: 
          localr.oop = locala.CLY.readString();
          AppMethodBeat.o(56614);
          return 0;
        case 5: 
          localr.cMP = locala.CLY.sl();
          AppMethodBeat.o(56614);
          return 0;
        case 6: 
          localr.ooq = locala.CLY.readString();
          AppMethodBeat.o(56614);
          return 0;
        case 7: 
          localr.oor = locala.CLY.readString();
          AppMethodBeat.o(56614);
          return 0;
        case 8: 
          localr.ony = locala.CLY.sm();
          AppMethodBeat.o(56614);
          return 0;
        case 9: 
          localr.oos = locala.CLY.sm();
          AppMethodBeat.o(56614);
          return 0;
        case 10: 
          localr.onw = locala.CLY.sm();
          AppMethodBeat.o(56614);
          return 0;
        case 11: 
          localr.status = locala.CLY.sl();
          AppMethodBeat.o(56614);
          return 0;
        case 12: 
          localr.oot = locala.CLY.sl();
          AppMethodBeat.o(56614);
          return 0;
        case 13: 
          localr.onz = locala.CLY.readString();
          AppMethodBeat.o(56614);
          return 0;
        case 14: 
          localr.ojA = locala.CLY.readString();
          AppMethodBeat.o(56614);
          return 0;
        }
        localr.onK = locala.CLY.sl();
        AppMethodBeat.o(56614);
        return 0;
      }
      AppMethodBeat.o(56614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.r
 * JD-Core Version:    0.7.0.1
 */