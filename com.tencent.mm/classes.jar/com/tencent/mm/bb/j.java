package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bw.a
{
  public String appId;
  public String dpI;
  public String ilU;
  public String ilV;
  public String ilW;
  public String ilX;
  public String ilY;
  public String ilZ;
  public String ima;
  public String imb;
  public String imc;
  public String imd;
  public String ime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.ilU != null) {
        paramVarArgs.d(2, this.ilU);
      }
      if (this.ilV != null) {
        paramVarArgs.d(3, this.ilV);
      }
      if (this.ilW != null) {
        paramVarArgs.d(4, this.ilW);
      }
      if (this.ilX != null) {
        paramVarArgs.d(5, this.ilX);
      }
      if (this.ilY != null) {
        paramVarArgs.d(6, this.ilY);
      }
      if (this.dpI != null) {
        paramVarArgs.d(7, this.dpI);
      }
      if (this.ilZ != null) {
        paramVarArgs.d(8, this.ilZ);
      }
      if (this.ima != null) {
        paramVarArgs.d(9, this.ima);
      }
      if (this.imb != null) {
        paramVarArgs.d(10, this.imb);
      }
      if (this.imc != null) {
        paramVarArgs.d(11, this.imc);
      }
      if (this.imd != null) {
        paramVarArgs.d(12, this.imd);
      }
      if (this.ime != null) {
        paramVarArgs.d(13, this.ime);
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
      if (this.ilU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ilU);
      }
      i = paramInt;
      if (this.ilV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ilV);
      }
      paramInt = i;
      if (this.ilW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ilW);
      }
      i = paramInt;
      if (this.ilX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ilX);
      }
      paramInt = i;
      if (this.ilY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ilY);
      }
      i = paramInt;
      if (this.dpI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.dpI);
      }
      paramInt = i;
      if (this.ilZ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ilZ);
      }
      i = paramInt;
      if (this.ima != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ima);
      }
      paramInt = i;
      if (this.imb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.imb);
      }
      i = paramInt;
      if (this.imc != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.imc);
      }
      paramInt = i;
      if (this.imd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.imd);
      }
      i = paramInt;
      if (this.ime != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.ime);
      }
      AppMethodBeat.o(150806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localj.appId = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 2: 
          localj.ilU = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 3: 
          localj.ilV = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 4: 
          localj.ilW = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 5: 
          localj.ilX = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 6: 
          localj.ilY = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 7: 
          localj.dpI = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 8: 
          localj.ilZ = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 9: 
          localj.ima = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 10: 
          localj.imb = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 11: 
          localj.imc = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 12: 
          localj.imd = locala.OmT.readString();
          AppMethodBeat.o(150806);
          return 0;
        }
        localj.ime = locala.OmT.readString();
        AppMethodBeat.o(150806);
        return 0;
      }
      AppMethodBeat.o(150806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.j
 * JD-Core Version:    0.7.0.1
 */