package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String dfM;
  public String hpl;
  public String hpm;
  public String hpn;
  public String hpo;
  public String hpp;
  public String hpq;
  public String hpr;
  public String hps;
  public String hpt;
  public String hpu;
  public String hpv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.hpl != null) {
        paramVarArgs.d(2, this.hpl);
      }
      if (this.hpm != null) {
        paramVarArgs.d(3, this.hpm);
      }
      if (this.hpn != null) {
        paramVarArgs.d(4, this.hpn);
      }
      if (this.hpo != null) {
        paramVarArgs.d(5, this.hpo);
      }
      if (this.hpp != null) {
        paramVarArgs.d(6, this.hpp);
      }
      if (this.dfM != null) {
        paramVarArgs.d(7, this.dfM);
      }
      if (this.hpq != null) {
        paramVarArgs.d(8, this.hpq);
      }
      if (this.hpr != null) {
        paramVarArgs.d(9, this.hpr);
      }
      if (this.hps != null) {
        paramVarArgs.d(10, this.hps);
      }
      if (this.hpt != null) {
        paramVarArgs.d(11, this.hpt);
      }
      if (this.hpu != null) {
        paramVarArgs.d(12, this.hpu);
      }
      if (this.hpv != null) {
        paramVarArgs.d(13, this.hpv);
      }
      AppMethodBeat.o(150806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.b.b.a.e(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hpl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hpl);
      }
      i = paramInt;
      if (this.hpm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hpm);
      }
      paramInt = i;
      if (this.hpn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hpn);
      }
      i = paramInt;
      if (this.hpo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hpo);
      }
      paramInt = i;
      if (this.hpp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hpp);
      }
      i = paramInt;
      if (this.dfM != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dfM);
      }
      paramInt = i;
      if (this.hpq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hpq);
      }
      i = paramInt;
      if (this.hpr != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hpr);
      }
      paramInt = i;
      if (this.hps != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hps);
      }
      i = paramInt;
      if (this.hpt != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.hpt);
      }
      paramInt = i;
      if (this.hpu != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hpu);
      }
      i = paramInt;
      if (this.hpv != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hpv);
      }
      AppMethodBeat.o(150806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(150806);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(150806);
          return -1;
        case 1: 
          localj.appId = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 2: 
          localj.hpl = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 3: 
          localj.hpm = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 4: 
          localj.hpn = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 5: 
          localj.hpo = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 6: 
          localj.hpp = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 7: 
          localj.dfM = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 8: 
          localj.hpq = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 9: 
          localj.hpr = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 10: 
          localj.hps = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 11: 
          localj.hpt = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 12: 
          localj.hpu = locala.KhF.readString();
          AppMethodBeat.o(150806);
          return 0;
        }
        localj.hpv = locala.KhF.readString();
        AppMethodBeat.o(150806);
        return 0;
      }
      AppMethodBeat.o(150806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.j
 * JD-Core Version:    0.7.0.1
 */