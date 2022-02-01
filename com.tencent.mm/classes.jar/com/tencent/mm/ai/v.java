package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bx.a
{
  public int gGA;
  public String gGC;
  public String gKB;
  public String gKC;
  public String gKD;
  public String gKE;
  public String gKF;
  public int gKG;
  public int gKH;
  public String gKI;
  public String gKJ;
  public int gKK;
  public int gKL;
  public String gKM;
  public String gKN;
  public String gKO;
  public String gKP;
  public String gKQ;
  public String gKR;
  public int gKS;
  public int gKT;
  public String gKU;
  public LinkedList<String> gKV;
  public int gKW;
  public long time;
  public String title;
  public int type;
  public String url;
  public int videoHeight;
  public int videoWidth;
  
  public v()
  {
    AppMethodBeat.i(116417);
    this.gKV = new LinkedList();
    AppMethodBeat.o(116417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.gKB != null) {
        paramVarArgs.d(3, this.gKB);
      }
      if (this.gKC != null) {
        paramVarArgs.d(4, this.gKC);
      }
      paramVarArgs.aG(5, this.time);
      if (this.gKD != null) {
        paramVarArgs.d(6, this.gKD);
      }
      if (this.gKE != null) {
        paramVarArgs.d(7, this.gKE);
      }
      if (this.gKF != null) {
        paramVarArgs.d(8, this.gKF);
      }
      paramVarArgs.aR(9, this.type);
      paramVarArgs.aR(10, this.gKG);
      paramVarArgs.aR(11, this.gKH);
      if (this.gKI != null) {
        paramVarArgs.d(12, this.gKI);
      }
      if (this.gKJ != null) {
        paramVarArgs.d(13, this.gKJ);
      }
      paramVarArgs.aR(14, this.gKK);
      paramVarArgs.aR(15, this.gKL);
      if (this.gKM != null) {
        paramVarArgs.d(16, this.gKM);
      }
      if (this.gKN != null) {
        paramVarArgs.d(17, this.gKN);
      }
      if (this.gKO != null) {
        paramVarArgs.d(18, this.gKO);
      }
      if (this.gKP != null) {
        paramVarArgs.d(19, this.gKP);
      }
      if (this.gKQ != null) {
        paramVarArgs.d(20, this.gKQ);
      }
      if (this.gKR != null) {
        paramVarArgs.d(21, this.gKR);
      }
      paramVarArgs.aR(22, this.gKS);
      paramVarArgs.aR(23, this.gKT);
      if (this.gKU != null) {
        paramVarArgs.d(24, this.gKU);
      }
      paramVarArgs.aR(25, this.videoWidth);
      paramVarArgs.aR(26, this.videoHeight);
      if (this.gGC != null) {
        paramVarArgs.d(27, this.gGC);
      }
      paramVarArgs.e(28, 1, this.gKV);
      paramVarArgs.aR(30, this.gGA);
      paramVarArgs.aR(31, this.gKW);
      AppMethodBeat.o(116418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1810;
      }
    }
    label1810:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.gKB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gKB);
      }
      paramInt = i;
      if (this.gKC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gKC);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.time);
      paramInt = i;
      if (this.gKD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.gKD);
      }
      i = paramInt;
      if (this.gKE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.gKE);
      }
      paramInt = i;
      if (this.gKF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gKF);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.type) + f.a.a.b.b.a.bA(10, this.gKG) + f.a.a.b.b.a.bA(11, this.gKH);
      paramInt = i;
      if (this.gKI != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.gKI);
      }
      i = paramInt;
      if (this.gKJ != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.gKJ);
      }
      i = i + f.a.a.b.b.a.bA(14, this.gKK) + f.a.a.b.b.a.bA(15, this.gKL);
      paramInt = i;
      if (this.gKM != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.gKM);
      }
      i = paramInt;
      if (this.gKN != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.gKN);
      }
      paramInt = i;
      if (this.gKO != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.gKO);
      }
      i = paramInt;
      if (this.gKP != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.gKP);
      }
      paramInt = i;
      if (this.gKQ != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.gKQ);
      }
      i = paramInt;
      if (this.gKR != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.gKR);
      }
      i = i + f.a.a.b.b.a.bA(22, this.gKS) + f.a.a.b.b.a.bA(23, this.gKT);
      paramInt = i;
      if (this.gKU != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.gKU);
      }
      i = paramInt + f.a.a.b.b.a.bA(25, this.videoWidth) + f.a.a.b.b.a.bA(26, this.videoHeight);
      paramInt = i;
      if (this.gGC != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.gGC);
      }
      i = f.a.a.a.c(28, 1, this.gKV);
      int j = f.a.a.b.b.a.bA(30, this.gGA);
      int k = f.a.a.b.b.a.bA(31, this.gKW);
      AppMethodBeat.o(116418);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.gKV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116418);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 29: 
        default: 
          AppMethodBeat.o(116418);
          return -1;
        case 1: 
          localv.title = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 2: 
          localv.url = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 3: 
          localv.gKB = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 4: 
          localv.gKC = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 5: 
          localv.time = locala.KhF.xT();
          AppMethodBeat.o(116418);
          return 0;
        case 6: 
          localv.gKD = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 7: 
          localv.gKE = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 8: 
          localv.gKF = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 9: 
          localv.type = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 10: 
          localv.gKG = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 11: 
          localv.gKH = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 12: 
          localv.gKI = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 13: 
          localv.gKJ = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 14: 
          localv.gKK = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 15: 
          localv.gKL = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 16: 
          localv.gKM = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 17: 
          localv.gKN = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 18: 
          localv.gKO = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 19: 
          localv.gKP = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 20: 
          localv.gKQ = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 21: 
          localv.gKR = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 22: 
          localv.gKS = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 23: 
          localv.gKT = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 24: 
          localv.gKU = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 25: 
          localv.videoWidth = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 26: 
          localv.videoHeight = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        case 27: 
          localv.gGC = locala.KhF.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 28: 
          localv.gKV.add(locala.KhF.readString());
          AppMethodBeat.o(116418);
          return 0;
        case 30: 
          localv.gGA = locala.KhF.xS();
          AppMethodBeat.o(116418);
          return 0;
        }
        localv.gKW = locala.KhF.xS();
        AppMethodBeat.o(116418);
        return 0;
      }
      AppMethodBeat.o(116418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.v
 * JD-Core Version:    0.7.0.1
 */