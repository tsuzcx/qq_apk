package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bv.a
{
  public String fgl;
  public String fjH;
  public String fjI;
  public String fjJ;
  public String fjK;
  public String fjL;
  public int fjM;
  public int fjN;
  public String fjO;
  public String fjP;
  public int fjQ;
  public int fjR;
  public String fjS;
  public String fjT;
  public String fjU;
  public String fjV;
  public String fjW;
  public String fjX;
  public int fjY;
  public int fjZ;
  public String fka;
  public LinkedList<String> fkb;
  public long time;
  public String title;
  public int type;
  public String url;
  public int videoHeight;
  public int videoWidth;
  
  public q()
  {
    AppMethodBeat.i(141567);
    this.fkb = new LinkedList();
    AppMethodBeat.o(141567);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(105479);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.fjH != null) {
        paramVarArgs.e(3, this.fjH);
      }
      if (this.fjI != null) {
        paramVarArgs.e(4, this.fjI);
      }
      paramVarArgs.am(5, this.time);
      if (this.fjJ != null) {
        paramVarArgs.e(6, this.fjJ);
      }
      if (this.fjK != null) {
        paramVarArgs.e(7, this.fjK);
      }
      if (this.fjL != null) {
        paramVarArgs.e(8, this.fjL);
      }
      paramVarArgs.aO(9, this.type);
      paramVarArgs.aO(10, this.fjM);
      paramVarArgs.aO(11, this.fjN);
      if (this.fjO != null) {
        paramVarArgs.e(12, this.fjO);
      }
      if (this.fjP != null) {
        paramVarArgs.e(13, this.fjP);
      }
      paramVarArgs.aO(14, this.fjQ);
      paramVarArgs.aO(15, this.fjR);
      if (this.fjS != null) {
        paramVarArgs.e(16, this.fjS);
      }
      if (this.fjT != null) {
        paramVarArgs.e(17, this.fjT);
      }
      if (this.fjU != null) {
        paramVarArgs.e(18, this.fjU);
      }
      if (this.fjV != null) {
        paramVarArgs.e(19, this.fjV);
      }
      if (this.fjW != null) {
        paramVarArgs.e(20, this.fjW);
      }
      if (this.fjX != null) {
        paramVarArgs.e(21, this.fjX);
      }
      paramVarArgs.aO(22, this.fjY);
      paramVarArgs.aO(23, this.fjZ);
      if (this.fka != null) {
        paramVarArgs.e(24, this.fka);
      }
      paramVarArgs.aO(25, this.videoWidth);
      paramVarArgs.aO(26, this.videoHeight);
      if (this.fgl != null) {
        paramVarArgs.e(27, this.fgl);
      }
      paramVarArgs.e(28, 1, this.fkb);
      AppMethodBeat.o(105479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1710;
      }
    }
    label1710:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.fjH != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.fjH);
      }
      paramInt = i;
      if (this.fjI != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.fjI);
      }
      i = paramInt + e.a.a.b.b.a.p(5, this.time);
      paramInt = i;
      if (this.fjJ != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.fjJ);
      }
      i = paramInt;
      if (this.fjK != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.fjK);
      }
      paramInt = i;
      if (this.fjL != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.fjL);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.type) + e.a.a.b.b.a.bl(10, this.fjM) + e.a.a.b.b.a.bl(11, this.fjN);
      paramInt = i;
      if (this.fjO != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.fjO);
      }
      i = paramInt;
      if (this.fjP != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.fjP);
      }
      i = i + e.a.a.b.b.a.bl(14, this.fjQ) + e.a.a.b.b.a.bl(15, this.fjR);
      paramInt = i;
      if (this.fjS != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.fjS);
      }
      i = paramInt;
      if (this.fjT != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.fjT);
      }
      paramInt = i;
      if (this.fjU != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.fjU);
      }
      i = paramInt;
      if (this.fjV != null) {
        i = paramInt + e.a.a.b.b.a.f(19, this.fjV);
      }
      paramInt = i;
      if (this.fjW != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.fjW);
      }
      i = paramInt;
      if (this.fjX != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.fjX);
      }
      i = i + e.a.a.b.b.a.bl(22, this.fjY) + e.a.a.b.b.a.bl(23, this.fjZ);
      paramInt = i;
      if (this.fka != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.fka);
      }
      i = paramInt + e.a.a.b.b.a.bl(25, this.videoWidth) + e.a.a.b.b.a.bl(26, this.videoHeight);
      paramInt = i;
      if (this.fgl != null) {
        paramInt = i + e.a.a.b.b.a.f(27, this.fgl);
      }
      i = e.a.a.a.c(28, 1, this.fkb);
      AppMethodBeat.o(105479);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.fkb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(105479);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(105479);
          return -1;
        case 1: 
          localq.title = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 2: 
          localq.url = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 3: 
          localq.fjH = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 4: 
          localq.fjI = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 5: 
          localq.time = locala.CLY.sm();
          AppMethodBeat.o(105479);
          return 0;
        case 6: 
          localq.fjJ = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 7: 
          localq.fjK = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 8: 
          localq.fjL = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 9: 
          localq.type = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 10: 
          localq.fjM = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 11: 
          localq.fjN = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 12: 
          localq.fjO = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 13: 
          localq.fjP = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 14: 
          localq.fjQ = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 15: 
          localq.fjR = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 16: 
          localq.fjS = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 17: 
          localq.fjT = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 18: 
          localq.fjU = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 19: 
          localq.fjV = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 20: 
          localq.fjW = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 21: 
          localq.fjX = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 22: 
          localq.fjY = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 23: 
          localq.fjZ = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 24: 
          localq.fka = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        case 25: 
          localq.videoWidth = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 26: 
          localq.videoHeight = locala.CLY.sl();
          AppMethodBeat.o(105479);
          return 0;
        case 27: 
          localq.fgl = locala.CLY.readString();
          AppMethodBeat.o(105479);
          return 0;
        }
        localq.fkb.add(locala.CLY.readString());
        AppMethodBeat.o(105479);
        return 0;
      }
      AppMethodBeat.o(105479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.af.q
 * JD-Core Version:    0.7.0.1
 */