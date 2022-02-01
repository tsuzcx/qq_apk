package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMG;
  public String CML;
  public String CMO;
  public String CMP;
  public String CMQ;
  public int CMR;
  public x CMS;
  public int CMT;
  public boolean CMU;
  public LinkedList<String> CMV;
  public boolean CMW;
  public boolean CMX;
  public boolean CMY;
  public boolean CMZ;
  public cw CNa;
  public int CNb;
  public ck CNc;
  public LinkedList<String> CNd;
  public String CqB;
  public String jUi;
  public int rVU;
  public int rWt;
  
  public g()
  {
    AppMethodBeat.i(41710);
    this.CMV = new LinkedList();
    this.CNd = new LinkedList();
    AppMethodBeat.o(41710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41711);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jUi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.CMO == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.jUi != null) {
        paramVarArgs.f(1, this.jUi);
      }
      if (this.CMO != null) {
        paramVarArgs.f(2, this.CMO);
      }
      if (this.CMP != null) {
        paramVarArgs.f(3, this.CMP);
      }
      if (this.CMB != null) {
        paramVarArgs.f(4, this.CMB);
      }
      if (this.CMQ != null) {
        paramVarArgs.f(5, this.CMQ);
      }
      if (this.CMG != null) {
        paramVarArgs.f(6, this.CMG);
      }
      if (this.CqB != null) {
        paramVarArgs.f(7, this.CqB);
      }
      paramVarArgs.aY(8, this.CMR);
      if (this.CMS != null)
      {
        paramVarArgs.oE(9, this.CMS.computeSize());
        this.CMS.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.rVU);
      paramVarArgs.aY(11, this.CMT);
      if (this.CML != null) {
        paramVarArgs.f(12, this.CML);
      }
      paramVarArgs.co(13, this.CMU);
      paramVarArgs.e(14, 1, this.CMV);
      paramVarArgs.co(15, this.CMW);
      paramVarArgs.aY(16, this.rWt);
      paramVarArgs.co(17, this.CMX);
      paramVarArgs.co(18, this.CMY);
      paramVarArgs.co(19, this.CMZ);
      if (this.CNa != null)
      {
        paramVarArgs.oE(20, this.CNa.computeSize());
        this.CNa.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(21, this.CNb);
      if (this.CNc != null)
      {
        paramVarArgs.oE(22, this.CNc.computeSize());
        this.CNc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.CNd);
      AppMethodBeat.o(41711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jUi == null) {
        break label1696;
      }
    }
    label1696:
    for (int i = g.a.a.b.b.a.g(1, this.jUi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMO);
      }
      i = paramInt;
      if (this.CMP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMP);
      }
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMB);
      }
      i = paramInt;
      if (this.CMQ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CMQ);
      }
      paramInt = i;
      if (this.CMG != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.CMG);
      }
      i = paramInt;
      if (this.CqB != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.CqB);
      }
      i += g.a.a.b.b.a.bM(8, this.CMR);
      paramInt = i;
      if (this.CMS != null) {
        paramInt = i + g.a.a.a.oD(9, this.CMS.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.rVU) + g.a.a.b.b.a.bM(11, this.CMT);
      paramInt = i;
      if (this.CML != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.CML);
      }
      i = paramInt + (g.a.a.b.b.a.gL(13) + 1) + g.a.a.a.c(14, 1, this.CMV) + (g.a.a.b.b.a.gL(15) + 1) + g.a.a.b.b.a.bM(16, this.rWt) + (g.a.a.b.b.a.gL(17) + 1) + (g.a.a.b.b.a.gL(18) + 1) + (g.a.a.b.b.a.gL(19) + 1);
      paramInt = i;
      if (this.CNa != null) {
        paramInt = i + g.a.a.a.oD(20, this.CNa.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(21, this.CNb);
      paramInt = i;
      if (this.CNc != null) {
        paramInt = i + g.a.a.a.oD(22, this.CNc.computeSize());
      }
      i = g.a.a.a.c(23, 1, this.CNd);
      AppMethodBeat.o(41711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CMV.clear();
        this.CNd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.jUi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        if (this.CMO == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconURL");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41711);
          return -1;
        case 1: 
          localg.jUi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 2: 
          localg.CMO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 3: 
          localg.CMP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 4: 
          localg.CMB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 5: 
          localg.CMQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 6: 
          localg.CMG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 7: 
          localg.CqB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 8: 
          localg.CMR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41711);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new x();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((x)localObject2).parseFrom((byte[])localObject1);
            }
            localg.CMS = ((x)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 10: 
          localg.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41711);
          return 0;
        case 11: 
          localg.CMT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41711);
          return 0;
        case 12: 
          localg.CML = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 13: 
          localg.CMU = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(41711);
          return 0;
        case 14: 
          localg.CMV.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(41711);
          return 0;
        case 15: 
          localg.CMW = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(41711);
          return 0;
        case 16: 
          localg.rWt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41711);
          return 0;
        case 17: 
          localg.CMX = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(41711);
          return 0;
        case 18: 
          localg.CMY = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(41711);
          return 0;
        case 19: 
          localg.CMZ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(41711);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cw)localObject2).parseFrom((byte[])localObject1);
            }
            localg.CNa = ((cw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 21: 
          localg.CNb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(41711);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ck();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ck)localObject2).parseFrom((byte[])localObject1);
            }
            localg.CNc = ((ck)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        }
        localg.CNd.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(41711);
        return 0;
      }
      AppMethodBeat.o(41711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.g
 * JD-Core Version:    0.7.0.1
 */