package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ap
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public String CNA;
  public int CNC;
  public int CNF;
  public bh COA;
  public di COB;
  public bf COC;
  public u COD;
  public dd COE;
  public dq COF;
  public t COG;
  public t COH;
  public co COw;
  public em COx;
  public cz COy;
  public da COz;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41732);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CNF);
      paramVarArgs.aY(2, this.CNC);
      if (this.CNA != null) {
        paramVarArgs.f(3, this.CNA);
      }
      if (this.lVG != null) {
        paramVarArgs.f(4, this.lVG);
      }
      if (this.CMD != null) {
        paramVarArgs.f(17, this.CMD);
      }
      if (this.COw != null)
      {
        paramVarArgs.oE(5, this.COw.computeSize());
        this.COw.writeFields(paramVarArgs);
      }
      if (this.COx != null)
      {
        paramVarArgs.oE(6, this.COx.computeSize());
        this.COx.writeFields(paramVarArgs);
      }
      if (this.COy != null)
      {
        paramVarArgs.oE(7, this.COy.computeSize());
        this.COy.writeFields(paramVarArgs);
      }
      if (this.COz != null)
      {
        paramVarArgs.oE(8, this.COz.computeSize());
        this.COz.writeFields(paramVarArgs);
      }
      if (this.COA != null)
      {
        paramVarArgs.oE(9, this.COA.computeSize());
        this.COA.writeFields(paramVarArgs);
      }
      if (this.COB != null)
      {
        paramVarArgs.oE(10, this.COB.computeSize());
        this.COB.writeFields(paramVarArgs);
      }
      if (this.COC != null)
      {
        paramVarArgs.oE(11, this.COC.computeSize());
        this.COC.writeFields(paramVarArgs);
      }
      if (this.COD != null)
      {
        paramVarArgs.oE(12, this.COD.computeSize());
        this.COD.writeFields(paramVarArgs);
      }
      if (this.COE != null)
      {
        paramVarArgs.oE(13, this.COE.computeSize());
        this.COE.writeFields(paramVarArgs);
      }
      if (this.COF != null)
      {
        paramVarArgs.oE(14, this.COF.computeSize());
        this.COF.writeFields(paramVarArgs);
      }
      if (this.COG != null)
      {
        paramVarArgs.oE(15, this.COG.computeSize());
        this.COG.writeFields(paramVarArgs);
      }
      if (this.COH != null)
      {
        paramVarArgs.oE(16, this.COH.computeSize());
        this.COH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CNF) + 0 + g.a.a.b.b.a.bM(2, this.CNC);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CNA);
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.lVG);
      }
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.CMD);
      }
      i = paramInt;
      if (this.COw != null) {
        i = paramInt + g.a.a.a.oD(5, this.COw.computeSize());
      }
      paramInt = i;
      if (this.COx != null) {
        paramInt = i + g.a.a.a.oD(6, this.COx.computeSize());
      }
      i = paramInt;
      if (this.COy != null) {
        i = paramInt + g.a.a.a.oD(7, this.COy.computeSize());
      }
      paramInt = i;
      if (this.COz != null) {
        paramInt = i + g.a.a.a.oD(8, this.COz.computeSize());
      }
      i = paramInt;
      if (this.COA != null) {
        i = paramInt + g.a.a.a.oD(9, this.COA.computeSize());
      }
      paramInt = i;
      if (this.COB != null) {
        paramInt = i + g.a.a.a.oD(10, this.COB.computeSize());
      }
      i = paramInt;
      if (this.COC != null) {
        i = paramInt + g.a.a.a.oD(11, this.COC.computeSize());
      }
      paramInt = i;
      if (this.COD != null) {
        paramInt = i + g.a.a.a.oD(12, this.COD.computeSize());
      }
      i = paramInt;
      if (this.COE != null) {
        i = paramInt + g.a.a.a.oD(13, this.COE.computeSize());
      }
      paramInt = i;
      if (this.COF != null) {
        paramInt = i + g.a.a.a.oD(14, this.COF.computeSize());
      }
      i = paramInt;
      if (this.COG != null) {
        i = paramInt + g.a.a.a.oD(15, this.COG.computeSize());
      }
      paramInt = i;
      if (this.COH != null) {
        paramInt = i + g.a.a.a.oD(16, this.COH.computeSize());
      }
      AppMethodBeat.o(41732);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ap localap = (ap)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41732);
        return -1;
      case 1: 
        localap.CNF = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(41732);
        return 0;
      case 2: 
        localap.CNC = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(41732);
        return 0;
      case 3: 
        localap.CNA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 4: 
        localap.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 17: 
        localap.CMD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(41732);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new co();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((co)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COw = ((co)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new em();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((em)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COx = ((em)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cz)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COy = ((cz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new da();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((da)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COz = ((da)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bh)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COA = ((bh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new di();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((di)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COB = ((di)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bf)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COC = ((bf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 12: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new u();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((u)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COD = ((u)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 13: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dd)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COE = ((dd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dq)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COF = ((dq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new t();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((t)localObject2).parseFrom((byte[])localObject1);
          }
          localap.COG = ((t)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(41732);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new t();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((t)localObject2).parseFrom((byte[])localObject1);
        }
        localap.COH = ((t)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(41732);
      return 0;
    }
    AppMethodBeat.o(41732);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ap
 * JD-Core Version:    0.7.0.1
 */