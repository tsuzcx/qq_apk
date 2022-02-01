package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String hEy;
  public String oQD;
  public String oQE;
  public String oQF;
  public String oQG;
  public String oQH;
  public String oQI;
  public String oQJ;
  public String oQK;
  public String oQL;
  public String oQM;
  public String oQN;
  public String oQO;
  public String oQP;
  public String oQQ;
  public String oQR;
  public n oQS;
  public int oQT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150806);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.g(1, this.appId);
      }
      if (this.oQD != null) {
        paramVarArgs.g(2, this.oQD);
      }
      if (this.oQE != null) {
        paramVarArgs.g(3, this.oQE);
      }
      if (this.oQF != null) {
        paramVarArgs.g(4, this.oQF);
      }
      if (this.oQG != null) {
        paramVarArgs.g(5, this.oQG);
      }
      if (this.oQH != null) {
        paramVarArgs.g(6, this.oQH);
      }
      if (this.hEy != null) {
        paramVarArgs.g(7, this.hEy);
      }
      if (this.oQI != null) {
        paramVarArgs.g(8, this.oQI);
      }
      if (this.oQJ != null) {
        paramVarArgs.g(9, this.oQJ);
      }
      if (this.oQK != null) {
        paramVarArgs.g(10, this.oQK);
      }
      if (this.oQL != null) {
        paramVarArgs.g(11, this.oQL);
      }
      if (this.oQM != null) {
        paramVarArgs.g(12, this.oQM);
      }
      if (this.oQN != null) {
        paramVarArgs.g(13, this.oQN);
      }
      if (this.oQO != null) {
        paramVarArgs.g(14, this.oQO);
      }
      if (this.oQP != null) {
        paramVarArgs.g(16, this.oQP);
      }
      if (this.oQQ != null) {
        paramVarArgs.g(17, this.oQQ);
      }
      if (this.oQR != null) {
        paramVarArgs.g(18, this.oQR);
      }
      if (this.oQS != null)
      {
        paramVarArgs.qD(19, this.oQS.computeSize());
        this.oQS.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(20, this.oQT);
      AppMethodBeat.o(150806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label1380;
      }
    }
    label1380:
    for (int i = i.a.a.b.b.a.h(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oQD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oQD);
      }
      i = paramInt;
      if (this.oQE != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oQE);
      }
      paramInt = i;
      if (this.oQF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.oQF);
      }
      i = paramInt;
      if (this.oQG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.oQG);
      }
      paramInt = i;
      if (this.oQH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.oQH);
      }
      i = paramInt;
      if (this.hEy != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hEy);
      }
      paramInt = i;
      if (this.oQI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.oQI);
      }
      i = paramInt;
      if (this.oQJ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.oQJ);
      }
      paramInt = i;
      if (this.oQK != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.oQK);
      }
      i = paramInt;
      if (this.oQL != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.oQL);
      }
      paramInt = i;
      if (this.oQM != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.oQM);
      }
      i = paramInt;
      if (this.oQN != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.oQN);
      }
      paramInt = i;
      if (this.oQO != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.oQO);
      }
      i = paramInt;
      if (this.oQP != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.oQP);
      }
      paramInt = i;
      if (this.oQQ != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.oQQ);
      }
      i = paramInt;
      if (this.oQR != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.oQR);
      }
      paramInt = i;
      if (this.oQS != null) {
        paramInt = i + i.a.a.a.qC(19, this.oQS.computeSize());
      }
      i = i.a.a.b.b.a.cJ(20, this.oQT);
      AppMethodBeat.o(150806);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(150806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 15: 
        default: 
          AppMethodBeat.o(150806);
          return -1;
        case 1: 
          localm.appId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 2: 
          localm.oQD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 3: 
          localm.oQE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 4: 
          localm.oQF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 5: 
          localm.oQG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 6: 
          localm.oQH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 7: 
          localm.hEy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 8: 
          localm.oQI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 9: 
          localm.oQJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 10: 
          localm.oQK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 11: 
          localm.oQL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 12: 
          localm.oQM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 13: 
          localm.oQN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 14: 
          localm.oQO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 16: 
          localm.oQP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 17: 
          localm.oQQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 18: 
          localm.oQR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(150806);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            n localn = new n();
            if ((localObject != null) && (localObject.length > 0)) {
              localn.parseFrom((byte[])localObject);
            }
            localm.oQS = localn;
            paramInt += 1;
          }
          AppMethodBeat.o(150806);
          return 0;
        }
        localm.oQT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(150806);
        return 0;
      }
      AppMethodBeat.o(150806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.modelpackage.m
 * JD-Core Version:    0.7.0.1
 */