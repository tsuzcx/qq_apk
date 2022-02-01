package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class v
  extends com.tencent.mm.bx.a
{
  public int nQp;
  public String nUK;
  public String nUL;
  public String nUM;
  public String nUN;
  public String nUO;
  public int nUP;
  public int nUQ;
  public String nUR;
  public String nUS;
  public int nUT;
  public int nUU;
  public String nUV;
  public String nUW;
  public String nUX;
  public String nUY;
  public String nUZ;
  public String nVa;
  public int nVb;
  public int nVc;
  public String nVd;
  public LinkedList<String> nVe;
  public int nVf;
  public ac nVg;
  public long nVh;
  public String nVi;
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
    this.nVe = new LinkedList();
    AppMethodBeat.o(116417);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116418);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.nUK != null) {
        paramVarArgs.g(3, this.nUK);
      }
      if (this.nUL != null) {
        paramVarArgs.g(4, this.nUL);
      }
      paramVarArgs.bv(5, this.time);
      if (this.nUM != null) {
        paramVarArgs.g(6, this.nUM);
      }
      if (this.nUN != null) {
        paramVarArgs.g(7, this.nUN);
      }
      if (this.nUO != null) {
        paramVarArgs.g(8, this.nUO);
      }
      paramVarArgs.bS(9, this.type);
      paramVarArgs.bS(10, this.nUP);
      paramVarArgs.bS(11, this.nUQ);
      if (this.nUR != null) {
        paramVarArgs.g(12, this.nUR);
      }
      if (this.nUS != null) {
        paramVarArgs.g(13, this.nUS);
      }
      paramVarArgs.bS(14, this.nUT);
      paramVarArgs.bS(15, this.nUU);
      if (this.nUV != null) {
        paramVarArgs.g(16, this.nUV);
      }
      if (this.nUW != null) {
        paramVarArgs.g(17, this.nUW);
      }
      if (this.nUX != null) {
        paramVarArgs.g(18, this.nUX);
      }
      if (this.nUY != null) {
        paramVarArgs.g(19, this.nUY);
      }
      if (this.nUZ != null) {
        paramVarArgs.g(20, this.nUZ);
      }
      if (this.nVa != null) {
        paramVarArgs.g(21, this.nVa);
      }
      paramVarArgs.bS(22, this.nVb);
      paramVarArgs.bS(23, this.nVc);
      if (this.nVd != null) {
        paramVarArgs.g(24, this.nVd);
      }
      paramVarArgs.bS(25, this.videoWidth);
      paramVarArgs.bS(26, this.videoHeight);
      if (this.vid != null) {
        paramVarArgs.g(27, this.vid);
      }
      paramVarArgs.e(28, 1, this.nVe);
      paramVarArgs.bS(30, this.nQp);
      paramVarArgs.bS(31, this.nVf);
      if (this.nVg != null)
      {
        paramVarArgs.qD(32, this.nVg.computeSize());
        this.nVg.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(33, this.nVh);
      if (this.nVi != null) {
        paramVarArgs.g(34, this.nVi);
      }
      AppMethodBeat.o(116418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label2044;
      }
    }
    label2044:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.nUK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUK);
      }
      paramInt = i;
      if (this.nUL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nUL);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.time);
      paramInt = i;
      if (this.nUM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.nUM);
      }
      i = paramInt;
      if (this.nUN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.nUN);
      }
      paramInt = i;
      if (this.nUO != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.nUO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.type) + i.a.a.b.b.a.cJ(10, this.nUP) + i.a.a.b.b.a.cJ(11, this.nUQ);
      paramInt = i;
      if (this.nUR != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.nUR);
      }
      i = paramInt;
      if (this.nUS != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.nUS);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.nUT) + i.a.a.b.b.a.cJ(15, this.nUU);
      paramInt = i;
      if (this.nUV != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.nUV);
      }
      i = paramInt;
      if (this.nUW != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.nUW);
      }
      paramInt = i;
      if (this.nUX != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.nUX);
      }
      i = paramInt;
      if (this.nUY != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.nUY);
      }
      paramInt = i;
      if (this.nUZ != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.nUZ);
      }
      i = paramInt;
      if (this.nVa != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.nVa);
      }
      i = i + i.a.a.b.b.a.cJ(22, this.nVb) + i.a.a.b.b.a.cJ(23, this.nVc);
      paramInt = i;
      if (this.nVd != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.nVd);
      }
      i = paramInt + i.a.a.b.b.a.cJ(25, this.videoWidth) + i.a.a.b.b.a.cJ(26, this.videoHeight);
      paramInt = i;
      if (this.vid != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.vid);
      }
      i = paramInt + i.a.a.a.c(28, 1, this.nVe) + i.a.a.b.b.a.cJ(30, this.nQp) + i.a.a.b.b.a.cJ(31, this.nVf);
      paramInt = i;
      if (this.nVg != null) {
        paramInt = i + i.a.a.a.qC(32, this.nVg.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(33, this.nVh);
      paramInt = i;
      if (this.nVi != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.nVi);
      }
      AppMethodBeat.o(116418);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nVe.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 29: 
        default: 
          AppMethodBeat.o(116418);
          return -1;
        case 1: 
          localv.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 2: 
          localv.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 3: 
          localv.nUK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 4: 
          localv.nUL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 5: 
          localv.time = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(116418);
          return 0;
        case 6: 
          localv.nUM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 7: 
          localv.nUN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 8: 
          localv.nUO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 9: 
          localv.type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 10: 
          localv.nUP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 11: 
          localv.nUQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 12: 
          localv.nUR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 13: 
          localv.nUS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 14: 
          localv.nUT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 15: 
          localv.nUU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 16: 
          localv.nUV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 17: 
          localv.nUW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 18: 
          localv.nUX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 19: 
          localv.nUY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 20: 
          localv.nUZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 21: 
          localv.nVa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 22: 
          localv.nVb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 23: 
          localv.nVc = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 24: 
          localv.nVd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 25: 
          localv.videoWidth = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 26: 
          localv.videoHeight = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 27: 
          localv.vid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116418);
          return 0;
        case 28: 
          localv.nVe.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(116418);
          return 0;
        case 30: 
          localv.nQp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 31: 
          localv.nVf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116418);
          return 0;
        case 32: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ac localac = new ac();
            if ((localObject != null) && (localObject.length > 0)) {
              localac.parseFrom((byte[])localObject);
            }
            localv.nVg = localac;
            paramInt += 1;
          }
          AppMethodBeat.o(116418);
          return 0;
        case 33: 
          localv.nVh = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(116418);
          return 0;
        }
        localv.nVi = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116418);
        return 0;
      }
      AppMethodBeat.o(116418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.message.v
 * JD-Core Version:    0.7.0.1
 */