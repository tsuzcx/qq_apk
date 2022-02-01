package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class af
  extends com.tencent.mm.bx.a
{
  public String hnC;
  public String rZW;
  public int rZY;
  public String rZo;
  public ca saL;
  public do saM;
  public cj saN;
  public ck saO;
  public aw saP;
  public cs saQ;
  public au saR;
  public q saS;
  public cn saT;
  public cz saU;
  public p saV;
  public p saW;
  public int sab;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41732);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.sab);
      paramVarArgs.aR(2, this.rZY);
      if (this.rZW != null) {
        paramVarArgs.d(3, this.rZW);
      }
      if (this.hnC != null) {
        paramVarArgs.d(4, this.hnC);
      }
      if (this.rZo != null) {
        paramVarArgs.d(17, this.rZo);
      }
      if (this.saL != null)
      {
        paramVarArgs.kX(5, this.saL.computeSize());
        this.saL.writeFields(paramVarArgs);
      }
      if (this.saM != null)
      {
        paramVarArgs.kX(6, this.saM.computeSize());
        this.saM.writeFields(paramVarArgs);
      }
      if (this.saN != null)
      {
        paramVarArgs.kX(7, this.saN.computeSize());
        this.saN.writeFields(paramVarArgs);
      }
      if (this.saO != null)
      {
        paramVarArgs.kX(8, this.saO.computeSize());
        this.saO.writeFields(paramVarArgs);
      }
      if (this.saP != null)
      {
        paramVarArgs.kX(9, this.saP.computeSize());
        this.saP.writeFields(paramVarArgs);
      }
      if (this.saQ != null)
      {
        paramVarArgs.kX(10, this.saQ.computeSize());
        this.saQ.writeFields(paramVarArgs);
      }
      if (this.saR != null)
      {
        paramVarArgs.kX(11, this.saR.computeSize());
        this.saR.writeFields(paramVarArgs);
      }
      if (this.saS != null)
      {
        paramVarArgs.kX(12, this.saS.computeSize());
        this.saS.writeFields(paramVarArgs);
      }
      if (this.saT != null)
      {
        paramVarArgs.kX(13, this.saT.computeSize());
        this.saT.writeFields(paramVarArgs);
      }
      if (this.saU != null)
      {
        paramVarArgs.kX(14, this.saU.computeSize());
        this.saU.writeFields(paramVarArgs);
      }
      if (this.saV != null)
      {
        paramVarArgs.kX(15, this.saV.computeSize());
        this.saV.writeFields(paramVarArgs);
      }
      if (this.saW != null)
      {
        paramVarArgs.kX(16, this.saW.computeSize());
        this.saW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.sab) + 0 + f.a.a.b.b.a.bA(2, this.rZY);
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.rZW);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hnC);
      }
      paramInt = i;
      if (this.rZo != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.rZo);
      }
      i = paramInt;
      if (this.saL != null) {
        i = paramInt + f.a.a.a.kW(5, this.saL.computeSize());
      }
      paramInt = i;
      if (this.saM != null) {
        paramInt = i + f.a.a.a.kW(6, this.saM.computeSize());
      }
      i = paramInt;
      if (this.saN != null) {
        i = paramInt + f.a.a.a.kW(7, this.saN.computeSize());
      }
      paramInt = i;
      if (this.saO != null) {
        paramInt = i + f.a.a.a.kW(8, this.saO.computeSize());
      }
      i = paramInt;
      if (this.saP != null) {
        i = paramInt + f.a.a.a.kW(9, this.saP.computeSize());
      }
      paramInt = i;
      if (this.saQ != null) {
        paramInt = i + f.a.a.a.kW(10, this.saQ.computeSize());
      }
      i = paramInt;
      if (this.saR != null) {
        i = paramInt + f.a.a.a.kW(11, this.saR.computeSize());
      }
      paramInt = i;
      if (this.saS != null) {
        paramInt = i + f.a.a.a.kW(12, this.saS.computeSize());
      }
      i = paramInt;
      if (this.saT != null) {
        i = paramInt + f.a.a.a.kW(13, this.saT.computeSize());
      }
      paramInt = i;
      if (this.saU != null) {
        paramInt = i + f.a.a.a.kW(14, this.saU.computeSize());
      }
      i = paramInt;
      if (this.saV != null) {
        i = paramInt + f.a.a.a.kW(15, this.saV.computeSize());
      }
      paramInt = i;
      if (this.saW != null) {
        paramInt = i + f.a.a.a.kW(16, this.saW.computeSize());
      }
      AppMethodBeat.o(41732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      af localaf = (af)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41732);
        return -1;
      case 1: 
        localaf.sab = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(41732);
        return 0;
      case 2: 
        localaf.rZY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(41732);
        return 0;
      case 3: 
        localaf.rZW = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 4: 
        localaf.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 17: 
        localaf.rZo = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ca();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saL = ((ca)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new do();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((do)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saM = ((do)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saN = ((cj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ck();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ck)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saO = ((ck)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saP = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saQ = ((cs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saR = ((au)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saS = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saT = ((cn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saU = ((cz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaf.saV = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new p();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaf.saW = ((p)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    AppMethodBeat.o(41732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.af
 * JD-Core Version:    0.7.0.1
 */