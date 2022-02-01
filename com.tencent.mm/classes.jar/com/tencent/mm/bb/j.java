package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bw.a
{
  public String appId;
  public String ddh;
  public String hPN;
  public String hPO;
  public String hPP;
  public String hPQ;
  public String hPR;
  public String hPS;
  public String hPT;
  public String hPU;
  public String hPV;
  public String hPW;
  public String hPX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.hPN != null) {
        paramVarArgs.d(2, this.hPN);
      }
      if (this.hPO != null) {
        paramVarArgs.d(3, this.hPO);
      }
      if (this.hPP != null) {
        paramVarArgs.d(4, this.hPP);
      }
      if (this.hPQ != null) {
        paramVarArgs.d(5, this.hPQ);
      }
      if (this.hPR != null) {
        paramVarArgs.d(6, this.hPR);
      }
      if (this.ddh != null) {
        paramVarArgs.d(7, this.ddh);
      }
      if (this.hPS != null) {
        paramVarArgs.d(8, this.hPS);
      }
      if (this.hPT != null) {
        paramVarArgs.d(9, this.hPT);
      }
      if (this.hPU != null) {
        paramVarArgs.d(10, this.hPU);
      }
      if (this.hPV != null) {
        paramVarArgs.d(11, this.hPV);
      }
      if (this.hPW != null) {
        paramVarArgs.d(12, this.hPW);
      }
      if (this.hPX != null) {
        paramVarArgs.d(13, this.hPX);
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
      if (this.hPN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hPN);
      }
      i = paramInt;
      if (this.hPO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hPO);
      }
      paramInt = i;
      if (this.hPP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hPP);
      }
      i = paramInt;
      if (this.hPQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hPQ);
      }
      paramInt = i;
      if (this.hPR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hPR);
      }
      i = paramInt;
      if (this.ddh != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ddh);
      }
      paramInt = i;
      if (this.hPS != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.hPS);
      }
      i = paramInt;
      if (this.hPT != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hPT);
      }
      paramInt = i;
      if (this.hPU != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.hPU);
      }
      i = paramInt;
      if (this.hPV != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.hPV);
      }
      paramInt = i;
      if (this.hPW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.hPW);
      }
      i = paramInt;
      if (this.hPX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.hPX);
      }
      AppMethodBeat.o(150806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          localj.appId = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 2: 
          localj.hPN = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 3: 
          localj.hPO = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 4: 
          localj.hPP = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 5: 
          localj.hPQ = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 6: 
          localj.hPR = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 7: 
          localj.ddh = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 8: 
          localj.hPS = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 9: 
          localj.hPT = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 10: 
          localj.hPU = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 11: 
          localj.hPV = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 12: 
          localj.hPW = locala.LVo.readString();
          AppMethodBeat.o(150806);
          return 0;
        }
        localj.hPX = locala.LVo.readString();
        AppMethodBeat.o(150806);
        return 0;
      }
      AppMethodBeat.o(150806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.j
 * JD-Core Version:    0.7.0.1
 */