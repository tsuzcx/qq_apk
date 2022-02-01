package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.cd.a
{
  public String appId;
  public String fzM;
  public String lXA;
  public String lXB;
  public String lXC;
  public String lXD;
  public String lXE;
  public String lXF;
  public String lXG;
  public String lXH;
  public String lXI;
  public String lXJ;
  public String lXK;
  public String lXL;
  public String lXM;
  public String lXN;
  public m lXO;
  public int lXP;
  public String lXz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150806);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.lXz != null) {
        paramVarArgs.f(2, this.lXz);
      }
      if (this.lXA != null) {
        paramVarArgs.f(3, this.lXA);
      }
      if (this.lXB != null) {
        paramVarArgs.f(4, this.lXB);
      }
      if (this.lXC != null) {
        paramVarArgs.f(5, this.lXC);
      }
      if (this.lXD != null) {
        paramVarArgs.f(6, this.lXD);
      }
      if (this.fzM != null) {
        paramVarArgs.f(7, this.fzM);
      }
      if (this.lXE != null) {
        paramVarArgs.f(8, this.lXE);
      }
      if (this.lXF != null) {
        paramVarArgs.f(9, this.lXF);
      }
      if (this.lXG != null) {
        paramVarArgs.f(10, this.lXG);
      }
      if (this.lXH != null) {
        paramVarArgs.f(11, this.lXH);
      }
      if (this.lXI != null) {
        paramVarArgs.f(12, this.lXI);
      }
      if (this.lXJ != null) {
        paramVarArgs.f(13, this.lXJ);
      }
      if (this.lXK != null) {
        paramVarArgs.f(14, this.lXK);
      }
      if (this.lXL != null) {
        paramVarArgs.f(16, this.lXL);
      }
      if (this.lXM != null) {
        paramVarArgs.f(17, this.lXM);
      }
      if (this.lXN != null) {
        paramVarArgs.f(18, this.lXN);
      }
      if (this.lXO != null)
      {
        paramVarArgs.oE(19, this.lXO.computeSize());
        this.lXO.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(20, this.lXP);
      AppMethodBeat.o(150806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label1384;
      }
    }
    label1384:
    for (int i = g.a.a.b.b.a.g(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lXz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lXz);
      }
      i = paramInt;
      if (this.lXA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lXA);
      }
      paramInt = i;
      if (this.lXB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lXB);
      }
      i = paramInt;
      if (this.lXC != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.lXC);
      }
      paramInt = i;
      if (this.lXD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.lXD);
      }
      i = paramInt;
      if (this.fzM != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.fzM);
      }
      paramInt = i;
      if (this.lXE != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.lXE);
      }
      i = paramInt;
      if (this.lXF != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.lXF);
      }
      paramInt = i;
      if (this.lXG != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.lXG);
      }
      i = paramInt;
      if (this.lXH != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.lXH);
      }
      paramInt = i;
      if (this.lXI != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.lXI);
      }
      i = paramInt;
      if (this.lXJ != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.lXJ);
      }
      paramInt = i;
      if (this.lXK != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.lXK);
      }
      i = paramInt;
      if (this.lXL != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.lXL);
      }
      paramInt = i;
      if (this.lXM != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.lXM);
      }
      i = paramInt;
      if (this.lXN != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.lXN);
      }
      paramInt = i;
      if (this.lXO != null) {
        paramInt = i + g.a.a.a.oD(19, this.lXO.computeSize());
      }
      i = g.a.a.b.b.a.bM(20, this.lXP);
      AppMethodBeat.o(150806);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(150806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        default: 
          AppMethodBeat.o(150806);
          return -1;
        case 1: 
          locall.appId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 2: 
          locall.lXz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 3: 
          locall.lXA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 4: 
          locall.lXB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 5: 
          locall.lXC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 6: 
          locall.lXD = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 7: 
          locall.fzM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 8: 
          locall.lXE = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 9: 
          locall.lXF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 10: 
          locall.lXG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 11: 
          locall.lXH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 12: 
          locall.lXI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 13: 
          locall.lXJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 14: 
          locall.lXK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 16: 
          locall.lXL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 17: 
          locall.lXM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 18: 
          locall.lXN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            m localm = new m();
            if ((localObject != null) && (localObject.length > 0)) {
              localm.parseFrom((byte[])localObject);
            }
            locall.lXO = localm;
            paramInt += 1;
          }
          AppMethodBeat.o(150806);
          return 0;
        }
        locall.lXP = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(150806);
        return 0;
      }
      AppMethodBeat.o(150806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.be.l
 * JD-Core Version:    0.7.0.1
 */