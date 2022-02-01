package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bw.a
{
  public String iAA;
  public int iAB;
  public int iAC;
  public String iAD;
  public LinkedList<String> iAE;
  public int iAF;
  public ac iAG;
  public long iAH;
  public String iAm;
  public String iAn;
  public String iAo;
  public String iAp;
  public String iAq;
  public int iAr;
  public int iAs;
  public String iAt;
  public int iAu;
  public String iAv;
  public String iAw;
  public String iAx;
  public String iAy;
  public String iAz;
  public int iwf;
  public long time;
  public String title;
  public int type;
  public String url;
  public String vid;
  public int videoHeight;
  public int videoWidth;
  public String weappPath;
  public int weappVersion;
  
  public v()
  {
    AppMethodBeat.i(116417);
    this.iAE = new LinkedList();
    AppMethodBeat.o(116417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.iAm != null) {
        paramVarArgs.e(3, this.iAm);
      }
      if (this.iAn != null) {
        paramVarArgs.e(4, this.iAn);
      }
      paramVarArgs.bb(5, this.time);
      if (this.iAo != null) {
        paramVarArgs.e(6, this.iAo);
      }
      if (this.iAp != null) {
        paramVarArgs.e(7, this.iAp);
      }
      if (this.iAq != null) {
        paramVarArgs.e(8, this.iAq);
      }
      paramVarArgs.aM(9, this.type);
      paramVarArgs.aM(10, this.iAr);
      paramVarArgs.aM(11, this.iAs);
      if (this.iAt != null) {
        paramVarArgs.e(12, this.iAt);
      }
      if (this.weappPath != null) {
        paramVarArgs.e(13, this.weappPath);
      }
      paramVarArgs.aM(14, this.weappVersion);
      paramVarArgs.aM(15, this.iAu);
      if (this.iAv != null) {
        paramVarArgs.e(16, this.iAv);
      }
      if (this.iAw != null) {
        paramVarArgs.e(17, this.iAw);
      }
      if (this.iAx != null) {
        paramVarArgs.e(18, this.iAx);
      }
      if (this.iAy != null) {
        paramVarArgs.e(19, this.iAy);
      }
      if (this.iAz != null) {
        paramVarArgs.e(20, this.iAz);
      }
      if (this.iAA != null) {
        paramVarArgs.e(21, this.iAA);
      }
      paramVarArgs.aM(22, this.iAB);
      paramVarArgs.aM(23, this.iAC);
      if (this.iAD != null) {
        paramVarArgs.e(24, this.iAD);
      }
      paramVarArgs.aM(25, this.videoWidth);
      paramVarArgs.aM(26, this.videoHeight);
      if (this.vid != null) {
        paramVarArgs.e(27, this.vid);
      }
      paramVarArgs.e(28, 1, this.iAE);
      paramVarArgs.aM(30, this.iwf);
      paramVarArgs.aM(31, this.iAF);
      if (this.iAG != null)
      {
        paramVarArgs.ni(32, this.iAG.computeSize());
        this.iAG.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(33, this.iAH);
      AppMethodBeat.o(116418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label2006;
      }
    }
    label2006:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.iAm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.iAm);
      }
      paramInt = i;
      if (this.iAn != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.iAn);
      }
      i = paramInt + g.a.a.b.b.a.r(5, this.time);
      paramInt = i;
      if (this.iAo != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.iAo);
      }
      i = paramInt;
      if (this.iAp != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.iAp);
      }
      paramInt = i;
      if (this.iAq != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.iAq);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.type) + g.a.a.b.b.a.bu(10, this.iAr) + g.a.a.b.b.a.bu(11, this.iAs);
      paramInt = i;
      if (this.iAt != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.iAt);
      }
      i = paramInt;
      if (this.weappPath != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.weappPath);
      }
      i = i + g.a.a.b.b.a.bu(14, this.weappVersion) + g.a.a.b.b.a.bu(15, this.iAu);
      paramInt = i;
      if (this.iAv != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.iAv);
      }
      i = paramInt;
      if (this.iAw != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.iAw);
      }
      paramInt = i;
      if (this.iAx != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.iAx);
      }
      i = paramInt;
      if (this.iAy != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.iAy);
      }
      paramInt = i;
      if (this.iAz != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.iAz);
      }
      i = paramInt;
      if (this.iAA != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.iAA);
      }
      i = i + g.a.a.b.b.a.bu(22, this.iAB) + g.a.a.b.b.a.bu(23, this.iAC);
      paramInt = i;
      if (this.iAD != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.iAD);
      }
      i = paramInt + g.a.a.b.b.a.bu(25, this.videoWidth) + g.a.a.b.b.a.bu(26, this.videoHeight);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + g.a.a.b.b.a.f(27, this.vid);
      }
      i = paramInt + g.a.a.a.c(28, 1, this.iAE) + g.a.a.b.b.a.bu(30, this.iwf) + g.a.a.b.b.a.bu(31, this.iAF);
      paramInt = i;
      if (this.iAG != null) {
        paramInt = i + g.a.a.a.nh(32, this.iAG.computeSize());
      }
      i = g.a.a.b.b.a.r(33, this.iAH);
      AppMethodBeat.o(116418);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iAE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 29: 
        default: 
          AppMethodBeat.o(116418);
          return -1;
        case 1: 
          localv.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 2: 
          localv.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 3: 
          localv.iAm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 4: 
          localv.iAn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 5: 
          localv.time = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(116418);
          return 0;
        case 6: 
          localv.iAo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 7: 
          localv.iAp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 8: 
          localv.iAq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 9: 
          localv.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 10: 
          localv.iAr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 11: 
          localv.iAs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 12: 
          localv.iAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 13: 
          localv.weappPath = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 14: 
          localv.weappVersion = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 15: 
          localv.iAu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 16: 
          localv.iAv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 17: 
          localv.iAw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 18: 
          localv.iAx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 19: 
          localv.iAy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 20: 
          localv.iAz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 21: 
          localv.iAA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 22: 
          localv.iAB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 23: 
          localv.iAC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 24: 
          localv.iAD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 25: 
          localv.videoWidth = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 26: 
          localv.videoHeight = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 27: 
          localv.vid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 28: 
          localv.iAE.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(116418);
          return 0;
        case 30: 
          localv.iwf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 31: 
          localv.iAF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116418);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ac();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ac)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localv.iAG = ((ac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116418);
          return 0;
        }
        localv.iAH = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(116418);
        return 0;
      }
      AppMethodBeat.o(116418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.v
 * JD-Core Version:    0.7.0.1
 */