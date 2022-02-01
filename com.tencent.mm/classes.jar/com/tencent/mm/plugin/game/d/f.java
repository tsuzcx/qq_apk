package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Name;
  public int Version;
  public String fVC;
  public int mBi;
  public s rZA;
  public int rZB;
  public boolean rZC;
  public LinkedList<String> rZD;
  public boolean rZE;
  public boolean rZF;
  public boolean rZG;
  public boolean rZH;
  public cg rZI;
  public int rZJ;
  public bx rZK;
  public LinkedList<String> rZL;
  public String rZr;
  public String rZt;
  public String rZw;
  public String rZx;
  public String rZy;
  public int rZz;
  
  public f()
  {
    AppMethodBeat.i(41710);
    this.rZD = new LinkedList();
    this.rZL = new LinkedList();
    AppMethodBeat.o(41710);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fVC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.rZw == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(41711);
        throw paramVarArgs;
      }
      if (this.fVC != null) {
        paramVarArgs.d(1, this.fVC);
      }
      if (this.rZw != null) {
        paramVarArgs.d(2, this.rZw);
      }
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.rZx != null) {
        paramVarArgs.d(5, this.rZx);
      }
      if (this.rZr != null) {
        paramVarArgs.d(6, this.rZr);
      }
      if (this.rZy != null) {
        paramVarArgs.d(7, this.rZy);
      }
      paramVarArgs.aR(8, this.rZz);
      if (this.rZA != null)
      {
        paramVarArgs.kX(9, this.rZA.computeSize());
        this.rZA.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.mBi);
      paramVarArgs.aR(11, this.rZB);
      if (this.rZt != null) {
        paramVarArgs.d(12, this.rZt);
      }
      paramVarArgs.bg(13, this.rZC);
      paramVarArgs.e(14, 1, this.rZD);
      paramVarArgs.bg(15, this.rZE);
      paramVarArgs.aR(16, this.Version);
      paramVarArgs.bg(17, this.rZF);
      paramVarArgs.bg(18, this.rZG);
      paramVarArgs.bg(19, this.rZH);
      if (this.rZI != null)
      {
        paramVarArgs.kX(20, this.rZI.computeSize());
        this.rZI.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(21, this.rZJ);
      if (this.rZK != null)
      {
        paramVarArgs.kX(22, this.rZK.computeSize());
        this.rZK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 1, this.rZL);
      AppMethodBeat.o(41711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fVC == null) {
        break label1762;
      }
    }
    label1762:
    for (int i = f.a.a.b.b.a.e(1, this.fVC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rZw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rZw);
      }
      i = paramInt;
      if (this.Name != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Name);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.rZx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.rZx);
      }
      paramInt = i;
      if (this.rZr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rZr);
      }
      i = paramInt;
      if (this.rZy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.rZy);
      }
      i += f.a.a.b.b.a.bA(8, this.rZz);
      paramInt = i;
      if (this.rZA != null) {
        paramInt = i + f.a.a.a.kW(9, this.rZA.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.mBi) + f.a.a.b.b.a.bA(11, this.rZB);
      paramInt = i;
      if (this.rZt != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.rZt);
      }
      i = paramInt + (f.a.a.b.b.a.fY(13) + 1) + f.a.a.a.c(14, 1, this.rZD) + (f.a.a.b.b.a.fY(15) + 1) + f.a.a.b.b.a.bA(16, this.Version) + (f.a.a.b.b.a.fY(17) + 1) + (f.a.a.b.b.a.fY(18) + 1) + (f.a.a.b.b.a.fY(19) + 1);
      paramInt = i;
      if (this.rZI != null) {
        paramInt = i + f.a.a.a.kW(20, this.rZI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(21, this.rZJ);
      paramInt = i;
      if (this.rZK != null) {
        paramInt = i + f.a.a.a.kW(22, this.rZK.computeSize());
      }
      i = f.a.a.a.c(23, 1, this.rZL);
      AppMethodBeat.o(41711);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rZD.clear();
        this.rZL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.fVC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(41711);
          throw paramVarArgs;
        }
        if (this.rZw == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41711);
          return -1;
        case 1: 
          localf.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 2: 
          localf.rZw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 3: 
          localf.Name = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 4: 
          localf.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 5: 
          localf.rZx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 6: 
          localf.rZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 7: 
          localf.rZy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 8: 
          localf.rZz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41711);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new s();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.rZA = ((s)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 10: 
          localf.mBi = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41711);
          return 0;
        case 11: 
          localf.rZB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41711);
          return 0;
        case 12: 
          localf.rZt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41711);
          return 0;
        case 13: 
          localf.rZC = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41711);
          return 0;
        case 14: 
          localf.rZD.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(41711);
          return 0;
        case 15: 
          localf.rZE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41711);
          return 0;
        case 16: 
          localf.Version = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41711);
          return 0;
        case 17: 
          localf.rZF = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41711);
          return 0;
        case 18: 
          localf.rZG = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41711);
          return 0;
        case 19: 
          localf.rZH = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(41711);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.rZI = ((cg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        case 21: 
          localf.rZJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(41711);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localf.rZK = ((bx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41711);
          return 0;
        }
        localf.rZL.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(41711);
        return 0;
      }
      AppMethodBeat.o(41711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.f
 * JD-Core Version:    0.7.0.1
 */