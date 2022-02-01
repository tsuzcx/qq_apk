package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String lwO;
  public boolean xlA;
  public LinkedList<a> xlB;
  public String xlC;
  public String xlD;
  public long xlE;
  public String xlF;
  public String xlG;
  public String xlH;
  public String xlI;
  public String xlr;
  public long xls;
  public String xlt;
  public int xlu;
  public int xlv;
  public String xlw;
  public o xlx;
  public String xly;
  public String xlz;
  
  public c()
  {
    AppMethodBeat.i(153060);
    this.xlB = new LinkedList();
    AppMethodBeat.o(153060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153061);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.lwO != null) {
        paramVarArgs.g(1, this.lwO);
      }
      if (this.xlr != null) {
        paramVarArgs.g(2, this.xlr);
      }
      paramVarArgs.bv(3, this.xls);
      if (this.xlt != null) {
        paramVarArgs.g(4, this.xlt);
      }
      paramVarArgs.bS(6, this.xlu);
      paramVarArgs.bS(7, this.xlv);
      if (this.xlw != null) {
        paramVarArgs.g(8, this.xlw);
      }
      if (this.xlx != null)
      {
        paramVarArgs.qD(9, this.xlx.computeSize());
        this.xlx.writeFields(paramVarArgs);
      }
      if (this.xly != null) {
        paramVarArgs.g(10, this.xly);
      }
      if (this.xlz != null) {
        paramVarArgs.g(11, this.xlz);
      }
      paramVarArgs.di(12, this.xlA);
      paramVarArgs.e(13, 8, this.xlB);
      if (this.xlC != null) {
        paramVarArgs.g(14, this.xlC);
      }
      if (this.xlD != null) {
        paramVarArgs.g(15, this.xlD);
      }
      paramVarArgs.bv(16, this.xlE);
      if (this.xlF != null) {
        paramVarArgs.g(17, this.xlF);
      }
      if (this.xlG != null) {
        paramVarArgs.g(19, this.xlG);
      }
      if (this.xlH != null) {
        paramVarArgs.g(20, this.xlH);
      }
      if (this.xlI != null) {
        paramVarArgs.g(21, this.xlI);
      }
      AppMethodBeat.o(153061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lwO == null) {
        break label1378;
      }
    }
    label1378:
    for (paramInt = i.a.a.b.b.a.h(1, this.lwO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xlr != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.xlr);
      }
      i += i.a.a.b.b.a.q(3, this.xls);
      paramInt = i;
      if (this.xlt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xlt);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.xlu) + i.a.a.b.b.a.cJ(7, this.xlv);
      paramInt = i;
      if (this.xlw != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.xlw);
      }
      i = paramInt;
      if (this.xlx != null) {
        i = paramInt + i.a.a.a.qC(9, this.xlx.computeSize());
      }
      paramInt = i;
      if (this.xly != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.xly);
      }
      i = paramInt;
      if (this.xlz != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.xlz);
      }
      i = i + (i.a.a.b.b.a.ko(12) + 1) + i.a.a.a.c(13, 8, this.xlB);
      paramInt = i;
      if (this.xlC != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.xlC);
      }
      i = paramInt;
      if (this.xlD != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.xlD);
      }
      i += i.a.a.b.b.a.q(16, this.xlE);
      paramInt = i;
      if (this.xlF != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.xlF);
      }
      i = paramInt;
      if (this.xlG != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.xlG);
      }
      paramInt = i;
      if (this.xlH != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.xlH);
      }
      i = paramInt;
      if (this.xlI != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.xlI);
      }
      AppMethodBeat.o(153061);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xlB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 18: 
        default: 
          AppMethodBeat.o(153061);
          return -1;
        case 1: 
          localc.lwO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 2: 
          localc.xlr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 3: 
          localc.xls = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153061);
          return 0;
        case 4: 
          localc.xlt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 6: 
          localc.xlu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153061);
          return 0;
        case 7: 
          localc.xlv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(153061);
          return 0;
        case 8: 
          localc.xlw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new o();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((o)localObject2).parseFrom((byte[])localObject1);
            }
            localc.xlx = ((o)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 10: 
          localc.xly = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 11: 
          localc.xlz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 12: 
          localc.xlA = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(153061);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localc.xlB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153061);
          return 0;
        case 14: 
          localc.xlC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 15: 
          localc.xlD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 16: 
          localc.xlE = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(153061);
          return 0;
        case 17: 
          localc.xlF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 19: 
          localc.xlG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        case 20: 
          localc.xlH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(153061);
          return 0;
        }
        localc.xlI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(153061);
        return 0;
      }
      AppMethodBeat.o(153061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.c
 * JD-Core Version:    0.7.0.1
 */