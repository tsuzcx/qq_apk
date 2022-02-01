package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGL;
  public String IGQ;
  public String IGT;
  public String IGU;
  public String IGV;
  public int IGW;
  public y IGX;
  public int IGY;
  public boolean IGZ;
  public LinkedList<String> IHa;
  public boolean IHb;
  public boolean IHc;
  public boolean IHd;
  public boolean IHe;
  public cz IHf;
  public int IHg;
  public cl IHh;
  public LinkedList<String> IHi;
  public String IcK;
  public int crz;
  public String muA;
  public int vhk;
  
  public g()
  {
    AppMethodBeat.i(41710);
    this.IHa = new LinkedList();
    this.IHi = new LinkedList();
    AppMethodBeat.o(41710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41711);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.IGT == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.muA != null) {
        paramVarArgs.g(1, this.muA);
      }
      if (this.IGT != null) {
        paramVarArgs.g(2, this.IGT);
      }
      if (this.IGU != null) {
        paramVarArgs.g(3, this.IGU);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      if (this.IGV != null) {
        paramVarArgs.g(5, this.IGV);
      }
      if (this.IGL != null) {
        paramVarArgs.g(6, this.IGL);
      }
      if (this.IcK != null) {
        paramVarArgs.g(7, this.IcK);
      }
      paramVarArgs.bS(8, this.IGW);
      if (this.IGX != null)
      {
        paramVarArgs.qD(9, this.IGX.computeSize());
        this.IGX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.vhk);
      paramVarArgs.bS(11, this.IGY);
      if (this.IGQ != null) {
        paramVarArgs.g(12, this.IGQ);
      }
      paramVarArgs.di(13, this.IGZ);
      paramVarArgs.e(14, 1, this.IHa);
      paramVarArgs.di(15, this.IHb);
      paramVarArgs.bS(16, this.crz);
      paramVarArgs.di(17, this.IHc);
      paramVarArgs.di(18, this.IHd);
      paramVarArgs.di(19, this.IHe);
      if (this.IHf != null)
      {
        paramVarArgs.qD(20, this.IHf.computeSize());
        this.IHf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(21, this.IHg);
      if (this.IHh != null)
      {
        paramVarArgs.qD(22, this.IHh.computeSize());
        this.IHh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.IHi);
      AppMethodBeat.o(41711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muA == null) {
        break label1692;
      }
    }
    label1692:
    for (int i = i.a.a.b.b.a.h(1, this.muA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGT);
      }
      i = paramInt;
      if (this.IGU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGU);
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      i = paramInt;
      if (this.IGV != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IGV);
      }
      paramInt = i;
      if (this.IGL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IGL);
      }
      i = paramInt;
      if (this.IcK != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.IcK);
      }
      i += i.a.a.b.b.a.cJ(8, this.IGW);
      paramInt = i;
      if (this.IGX != null) {
        paramInt = i + i.a.a.a.qC(9, this.IGX.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.vhk) + i.a.a.b.b.a.cJ(11, this.IGY);
      paramInt = i;
      if (this.IGQ != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.IGQ);
      }
      i = paramInt + (i.a.a.b.b.a.ko(13) + 1) + i.a.a.a.c(14, 1, this.IHa) + (i.a.a.b.b.a.ko(15) + 1) + i.a.a.b.b.a.cJ(16, this.crz) + (i.a.a.b.b.a.ko(17) + 1) + (i.a.a.b.b.a.ko(18) + 1) + (i.a.a.b.b.a.ko(19) + 1);
      paramInt = i;
      if (this.IHf != null) {
        paramInt = i + i.a.a.a.qC(20, this.IHf.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(21, this.IHg);
      paramInt = i;
      if (this.IHh != null) {
        paramInt = i + i.a.a.a.qC(22, this.IHh.computeSize());
      }
      i = i.a.a.a.c(23, 1, this.IHi);
      AppMethodBeat.o(41711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IHa.clear();
        this.IHi.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.muA == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        if (this.IGT == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41711);
          return -1;
        case 1: 
          localg.muA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 2: 
          localg.IGT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 3: 
          localg.IGU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 4: 
          localg.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 5: 
          localg.IGV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 6: 
          localg.IGL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 7: 
          localg.IcK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 8: 
          localg.IGW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41711);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new y();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((y)localObject2).parseFrom((byte[])localObject1);
            }
            localg.IGX = ((y)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 10: 
          localg.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41711);
          return 0;
        case 11: 
          localg.IGY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41711);
          return 0;
        case 12: 
          localg.IGQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 13: 
          localg.IGZ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41711);
          return 0;
        case 14: 
          localg.IHa.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(41711);
          return 0;
        case 15: 
          localg.IHb = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41711);
          return 0;
        case 16: 
          localg.crz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41711);
          return 0;
        case 17: 
          localg.IHc = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41711);
          return 0;
        case 18: 
          localg.IHd = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41711);
          return 0;
        case 19: 
          localg.IHe = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(41711);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cz)localObject2).parseFrom((byte[])localObject1);
            }
            localg.IHf = ((cz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 21: 
          localg.IHg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(41711);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cl)localObject2).parseFrom((byte[])localObject1);
            }
            localg.IHh = ((cl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        }
        localg.IHi.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(41711);
        return 0;
      }
      AppMethodBeat.o(41711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.g
 * JD-Core Version:    0.7.0.1
 */