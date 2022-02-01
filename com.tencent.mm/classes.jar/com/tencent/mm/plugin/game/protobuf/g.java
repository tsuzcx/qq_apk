package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class g
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Name;
  public int Version;
  public String hik;
  public int oTW;
  public String xIB;
  public String xIG;
  public String xIJ;
  public String xIK;
  public int xIL;
  public w xIM;
  public int xIN;
  public boolean xIO;
  public LinkedList<String> xIP;
  public boolean xIQ;
  public boolean xIR;
  public boolean xIS;
  public boolean xIT;
  public cv xIU;
  public int xIV;
  public cj xIW;
  public LinkedList<String> xIX;
  public String xuk;
  
  public g()
  {
    AppMethodBeat.i(41710);
    this.xIP = new LinkedList();
    this.xIX = new LinkedList();
    AppMethodBeat.o(41710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41711);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hik == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.xIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.hik != null) {
        paramVarArgs.e(1, this.hik);
      }
      if (this.xIJ != null) {
        paramVarArgs.e(2, this.xIJ);
      }
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.xIK != null) {
        paramVarArgs.e(5, this.xIK);
      }
      if (this.xIB != null) {
        paramVarArgs.e(6, this.xIB);
      }
      if (this.xuk != null) {
        paramVarArgs.e(7, this.xuk);
      }
      paramVarArgs.aM(8, this.xIL);
      if (this.xIM != null)
      {
        paramVarArgs.ni(9, this.xIM.computeSize());
        this.xIM.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(10, this.oTW);
      paramVarArgs.aM(11, this.xIN);
      if (this.xIG != null) {
        paramVarArgs.e(12, this.xIG);
      }
      paramVarArgs.cc(13, this.xIO);
      paramVarArgs.e(14, 1, this.xIP);
      paramVarArgs.cc(15, this.xIQ);
      paramVarArgs.aM(16, this.Version);
      paramVarArgs.cc(17, this.xIR);
      paramVarArgs.cc(18, this.xIS);
      paramVarArgs.cc(19, this.xIT);
      if (this.xIU != null)
      {
        paramVarArgs.ni(20, this.xIU.computeSize());
        this.xIU.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(21, this.xIV);
      if (this.xIW != null)
      {
        paramVarArgs.ni(22, this.xIW.computeSize());
        this.xIW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.xIX);
      AppMethodBeat.o(41711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hik == null) {
        break label1762;
      }
    }
    label1762:
    for (int i = g.a.a.b.b.a.f(1, this.hik) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIJ);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Name);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.xIK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.xIK);
      }
      paramInt = i;
      if (this.xIB != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.xIB);
      }
      i = paramInt;
      if (this.xuk != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.xuk);
      }
      i += g.a.a.b.b.a.bu(8, this.xIL);
      paramInt = i;
      if (this.xIM != null) {
        paramInt = i + g.a.a.a.nh(9, this.xIM.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.oTW) + g.a.a.b.b.a.bu(11, this.xIN);
      paramInt = i;
      if (this.xIG != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.xIG);
      }
      i = paramInt + (g.a.a.b.b.a.fS(13) + 1) + g.a.a.a.c(14, 1, this.xIP) + (g.a.a.b.b.a.fS(15) + 1) + g.a.a.b.b.a.bu(16, this.Version) + (g.a.a.b.b.a.fS(17) + 1) + (g.a.a.b.b.a.fS(18) + 1) + (g.a.a.b.b.a.fS(19) + 1);
      paramInt = i;
      if (this.xIU != null) {
        paramInt = i + g.a.a.a.nh(20, this.xIU.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(21, this.xIV);
      paramInt = i;
      if (this.xIW != null) {
        paramInt = i + g.a.a.a.nh(22, this.xIW.computeSize());
      }
      i = g.a.a.a.c(23, 1, this.xIX);
      AppMethodBeat.o(41711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xIP.clear();
        this.xIX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.hik == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        if (this.xIJ == null)
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
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41711);
          return -1;
        case 1: 
          localg.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 2: 
          localg.xIJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 3: 
          localg.Name = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 4: 
          localg.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 5: 
          localg.xIK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 6: 
          localg.xIB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 7: 
          localg.xuk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 8: 
          localg.xIL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41711);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new w();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localg.xIM = ((w)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 10: 
          localg.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41711);
          return 0;
        case 11: 
          localg.xIN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41711);
          return 0;
        case 12: 
          localg.xIG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 13: 
          localg.xIO = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41711);
          return 0;
        case 14: 
          localg.xIP.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(41711);
          return 0;
        case 15: 
          localg.xIQ = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41711);
          return 0;
        case 16: 
          localg.Version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41711);
          return 0;
        case 17: 
          localg.xIR = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41711);
          return 0;
        case 18: 
          localg.xIS = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41711);
          return 0;
        case 19: 
          localg.xIT = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41711);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localg.xIU = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 21: 
          localg.xIV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(41711);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localg.xIW = ((cj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        }
        localg.xIX.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(41711);
        return 0;
      }
      AppMethodBeat.o(41711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.g
 * JD-Core Version:    0.7.0.1
 */