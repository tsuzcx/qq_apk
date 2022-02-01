package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.cd.a
{
  public int lls;
  public String lpI;
  public String lpJ;
  public String lpK;
  public String lpL;
  public String lpM;
  public int lpN;
  public int lpO;
  public String lpP;
  public String lpQ;
  public int lpR;
  public int lpS;
  public String lpT;
  public String lpU;
  public String lpV;
  public String lpW;
  public String lpX;
  public String lpY;
  public int lpZ;
  public int lqa;
  public String lqb;
  public LinkedList<String> lqc;
  public int lqd;
  public ac lqe;
  public long lqf;
  public long time;
  public String title;
  public int type;
  public String url;
  public String vid;
  public int videoHeight;
  public int videoWidth;
  
  public v()
  {
    AppMethodBeat.i(116417);
    this.lqc = new LinkedList();
    AppMethodBeat.o(116417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.lpI != null) {
        paramVarArgs.f(3, this.lpI);
      }
      if (this.lpJ != null) {
        paramVarArgs.f(4, this.lpJ);
      }
      paramVarArgs.bm(5, this.time);
      if (this.lpK != null) {
        paramVarArgs.f(6, this.lpK);
      }
      if (this.lpL != null) {
        paramVarArgs.f(7, this.lpL);
      }
      if (this.lpM != null) {
        paramVarArgs.f(8, this.lpM);
      }
      paramVarArgs.aY(9, this.type);
      paramVarArgs.aY(10, this.lpN);
      paramVarArgs.aY(11, this.lpO);
      if (this.lpP != null) {
        paramVarArgs.f(12, this.lpP);
      }
      if (this.lpQ != null) {
        paramVarArgs.f(13, this.lpQ);
      }
      paramVarArgs.aY(14, this.lpR);
      paramVarArgs.aY(15, this.lpS);
      if (this.lpT != null) {
        paramVarArgs.f(16, this.lpT);
      }
      if (this.lpU != null) {
        paramVarArgs.f(17, this.lpU);
      }
      if (this.lpV != null) {
        paramVarArgs.f(18, this.lpV);
      }
      if (this.lpW != null) {
        paramVarArgs.f(19, this.lpW);
      }
      if (this.lpX != null) {
        paramVarArgs.f(20, this.lpX);
      }
      if (this.lpY != null) {
        paramVarArgs.f(21, this.lpY);
      }
      paramVarArgs.aY(22, this.lpZ);
      paramVarArgs.aY(23, this.lqa);
      if (this.lqb != null) {
        paramVarArgs.f(24, this.lqb);
      }
      paramVarArgs.aY(25, this.videoWidth);
      paramVarArgs.aY(26, this.videoHeight);
      if (this.vid != null) {
        paramVarArgs.f(27, this.vid);
      }
      paramVarArgs.e(28, 1, this.lqc);
      paramVarArgs.aY(30, this.lls);
      paramVarArgs.aY(31, this.lqd);
      if (this.lqe != null)
      {
        paramVarArgs.oE(32, this.lqe.computeSize());
        this.lqe.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(33, this.lqf);
      AppMethodBeat.o(116418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1984;
      }
    }
    label1984:
    for (int i = g.a.a.b.b.a.g(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.lpI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.lpI);
      }
      paramInt = i;
      if (this.lpJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lpJ);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.time);
      paramInt = i;
      if (this.lpK != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.lpK);
      }
      i = paramInt;
      if (this.lpL != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.lpL);
      }
      paramInt = i;
      if (this.lpM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.lpM);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.type) + g.a.a.b.b.a.bM(10, this.lpN) + g.a.a.b.b.a.bM(11, this.lpO);
      paramInt = i;
      if (this.lpP != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.lpP);
      }
      i = paramInt;
      if (this.lpQ != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.lpQ);
      }
      i = i + g.a.a.b.b.a.bM(14, this.lpR) + g.a.a.b.b.a.bM(15, this.lpS);
      paramInt = i;
      if (this.lpT != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.lpT);
      }
      i = paramInt;
      if (this.lpU != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.lpU);
      }
      paramInt = i;
      if (this.lpV != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.lpV);
      }
      i = paramInt;
      if (this.lpW != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.lpW);
      }
      paramInt = i;
      if (this.lpX != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.lpX);
      }
      i = paramInt;
      if (this.lpY != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.lpY);
      }
      i = i + g.a.a.b.b.a.bM(22, this.lpZ) + g.a.a.b.b.a.bM(23, this.lqa);
      paramInt = i;
      if (this.lqb != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.lqb);
      }
      i = paramInt + g.a.a.b.b.a.bM(25, this.videoWidth) + g.a.a.b.b.a.bM(26, this.videoHeight);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.vid);
      }
      i = paramInt + g.a.a.a.c(28, 1, this.lqc) + g.a.a.b.b.a.bM(30, this.lls) + g.a.a.b.b.a.bM(31, this.lqd);
      paramInt = i;
      if (this.lqe != null) {
        paramInt = i + g.a.a.a.oD(32, this.lqe.computeSize());
      }
      i = g.a.a.b.b.a.p(33, this.lqf);
      AppMethodBeat.o(116418);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.lqc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(116418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 29: 
        default: 
          AppMethodBeat.o(116418);
          return -1;
        case 1: 
          localv.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 2: 
          localv.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 3: 
          localv.lpI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 4: 
          localv.lpJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 5: 
          localv.time = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(116418);
          return 0;
        case 6: 
          localv.lpK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 7: 
          localv.lpL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 8: 
          localv.lpM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 9: 
          localv.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 10: 
          localv.lpN = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 11: 
          localv.lpO = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 12: 
          localv.lpP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 13: 
          localv.lpQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 14: 
          localv.lpR = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 15: 
          localv.lpS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 16: 
          localv.lpT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 17: 
          localv.lpU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 18: 
          localv.lpV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 19: 
          localv.lpW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 20: 
          localv.lpX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 21: 
          localv.lpY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 22: 
          localv.lpZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 23: 
          localv.lqa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 24: 
          localv.lqb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 25: 
          localv.videoWidth = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 26: 
          localv.videoHeight = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 27: 
          localv.vid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 28: 
          localv.lqc.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(116418);
          return 0;
        case 30: 
          localv.lls = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 31: 
          localv.lqd = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(116418);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ac localac = new ac();
            if ((localObject != null) && (localObject.length > 0)) {
              localac.parseFrom((byte[])localObject);
            }
            localv.lqe = localac;
            paramInt += 1;
          }
          AppMethodBeat.o(116418);
          return 0;
        }
        localv.lqf = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(116418);
        return 0;
      }
      AppMethodBeat.o(116418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.v
 * JD-Core Version:    0.7.0.1
 */