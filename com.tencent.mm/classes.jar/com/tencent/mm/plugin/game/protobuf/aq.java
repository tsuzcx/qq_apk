package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class aq
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public String IHI;
  public int IHK;
  public int IHN;
  public cq IIG;
  public eq IIH;
  public dc III;
  public dd IIJ;
  public bi IIK;
  public dm IIL;
  public bg IIM;
  public v IIN;
  public dg IIO;
  public du IIP;
  public u IIQ;
  public u IIR;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41732);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IHN);
      paramVarArgs.bS(2, this.IHK);
      if (this.IHI != null) {
        paramVarArgs.g(3, this.IHI);
      }
      if (this.oOI != null) {
        paramVarArgs.g(4, this.oOI);
      }
      if (this.IGI != null) {
        paramVarArgs.g(17, this.IGI);
      }
      if (this.IIG != null)
      {
        paramVarArgs.qD(5, this.IIG.computeSize());
        this.IIG.writeFields(paramVarArgs);
      }
      if (this.IIH != null)
      {
        paramVarArgs.qD(6, this.IIH.computeSize());
        this.IIH.writeFields(paramVarArgs);
      }
      if (this.III != null)
      {
        paramVarArgs.qD(7, this.III.computeSize());
        this.III.writeFields(paramVarArgs);
      }
      if (this.IIJ != null)
      {
        paramVarArgs.qD(8, this.IIJ.computeSize());
        this.IIJ.writeFields(paramVarArgs);
      }
      if (this.IIK != null)
      {
        paramVarArgs.qD(9, this.IIK.computeSize());
        this.IIK.writeFields(paramVarArgs);
      }
      if (this.IIL != null)
      {
        paramVarArgs.qD(10, this.IIL.computeSize());
        this.IIL.writeFields(paramVarArgs);
      }
      if (this.IIM != null)
      {
        paramVarArgs.qD(11, this.IIM.computeSize());
        this.IIM.writeFields(paramVarArgs);
      }
      if (this.IIN != null)
      {
        paramVarArgs.qD(12, this.IIN.computeSize());
        this.IIN.writeFields(paramVarArgs);
      }
      if (this.IIO != null)
      {
        paramVarArgs.qD(13, this.IIO.computeSize());
        this.IIO.writeFields(paramVarArgs);
      }
      if (this.IIP != null)
      {
        paramVarArgs.qD(14, this.IIP.computeSize());
        this.IIP.writeFields(paramVarArgs);
      }
      if (this.IIQ != null)
      {
        paramVarArgs.qD(15, this.IIQ.computeSize());
        this.IIQ.writeFields(paramVarArgs);
      }
      if (this.IIR != null)
      {
        paramVarArgs.qD(16, this.IIR.computeSize());
        this.IIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.IHN) + 0 + i.a.a.b.b.a.cJ(2, this.IHK);
      paramInt = i;
      if (this.IHI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IHI);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.oOI);
      }
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.IGI);
      }
      i = paramInt;
      if (this.IIG != null) {
        i = paramInt + i.a.a.a.qC(5, this.IIG.computeSize());
      }
      paramInt = i;
      if (this.IIH != null) {
        paramInt = i + i.a.a.a.qC(6, this.IIH.computeSize());
      }
      i = paramInt;
      if (this.III != null) {
        i = paramInt + i.a.a.a.qC(7, this.III.computeSize());
      }
      paramInt = i;
      if (this.IIJ != null) {
        paramInt = i + i.a.a.a.qC(8, this.IIJ.computeSize());
      }
      i = paramInt;
      if (this.IIK != null) {
        i = paramInt + i.a.a.a.qC(9, this.IIK.computeSize());
      }
      paramInt = i;
      if (this.IIL != null) {
        paramInt = i + i.a.a.a.qC(10, this.IIL.computeSize());
      }
      i = paramInt;
      if (this.IIM != null) {
        i = paramInt + i.a.a.a.qC(11, this.IIM.computeSize());
      }
      paramInt = i;
      if (this.IIN != null) {
        paramInt = i + i.a.a.a.qC(12, this.IIN.computeSize());
      }
      i = paramInt;
      if (this.IIO != null) {
        i = paramInt + i.a.a.a.qC(13, this.IIO.computeSize());
      }
      paramInt = i;
      if (this.IIP != null) {
        paramInt = i + i.a.a.a.qC(14, this.IIP.computeSize());
      }
      i = paramInt;
      if (this.IIQ != null) {
        i = paramInt + i.a.a.a.qC(15, this.IIQ.computeSize());
      }
      paramInt = i;
      if (this.IIR != null) {
        paramInt = i + i.a.a.a.qC(16, this.IIR.computeSize());
      }
      AppMethodBeat.o(41732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      aq localaq = (aq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41732);
        return -1;
      case 1: 
        localaq.IHN = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(41732);
        return 0;
      case 2: 
        localaq.IHK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(41732);
        return 0;
      case 3: 
        localaq.IHI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 4: 
        localaq.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 17: 
        localaq.IGI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cq)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIG = ((cq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eq)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIH = ((eq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dc)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.III = ((dc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dd)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIJ = ((dd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bi)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIK = ((bi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dm)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIL = ((dm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bg)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIM = ((bg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 12: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new v();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((v)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIN = ((v)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 13: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dg)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIO = ((dg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 14: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new du();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((du)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIP = ((du)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new u();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((u)localObject2).parseFrom((byte[])localObject1);
          }
          localaq.IIQ = ((u)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new u();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((u)localObject2).parseFrom((byte[])localObject1);
        }
        localaq.IIR = ((u)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    AppMethodBeat.o(41732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.aq
 * JD-Core Version:    0.7.0.1
 */