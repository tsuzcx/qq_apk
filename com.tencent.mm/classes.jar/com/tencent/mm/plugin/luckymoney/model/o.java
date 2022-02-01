package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.cd.a
{
  public String EtA;
  public int Etu;
  public double Etv;
  public double Etw;
  public double Etx;
  public double Ety;
  public String Etz;
  public String EyO;
  public String EyP;
  public int EyQ;
  public String EyR;
  public String EyS;
  public String EyT;
  public String EyU;
  public boolean EyV;
  public l EyW;
  public int tVx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91252);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Etu);
      paramVarArgs.e(2, this.Etx);
      if (this.EyO != null) {
        paramVarArgs.f(3, this.EyO);
      }
      if (this.EyP != null) {
        paramVarArgs.f(4, this.EyP);
      }
      paramVarArgs.e(5, this.Etv);
      paramVarArgs.e(6, this.Ety);
      paramVarArgs.e(7, this.Etw);
      paramVarArgs.aY(8, this.EyQ);
      paramVarArgs.aY(9, this.tVx);
      if (this.Etz != null) {
        paramVarArgs.f(10, this.Etz);
      }
      if (this.EtA != null) {
        paramVarArgs.f(11, this.EtA);
      }
      if (this.EyR != null) {
        paramVarArgs.f(12, this.EyR);
      }
      if (this.EyS != null) {
        paramVarArgs.f(13, this.EyS);
      }
      if (this.EyT != null) {
        paramVarArgs.f(14, this.EyT);
      }
      if (this.EyU != null) {
        paramVarArgs.f(15, this.EyU);
      }
      paramVarArgs.co(16, this.EyV);
      if (this.EyW != null)
      {
        paramVarArgs.oE(17, this.EyW.computeSize());
        this.EyW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.Etu) + 0 + (g.a.a.b.b.a.gL(2) + 8);
      paramInt = i;
      if (this.EyO != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.EyO);
      }
      i = paramInt;
      if (this.EyP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.EyP);
      }
      i = i + (g.a.a.b.b.a.gL(5) + 8) + (g.a.a.b.b.a.gL(6) + 8) + (g.a.a.b.b.a.gL(7) + 8) + g.a.a.b.b.a.bM(8, this.EyQ) + g.a.a.b.b.a.bM(9, this.tVx);
      paramInt = i;
      if (this.Etz != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.Etz);
      }
      i = paramInt;
      if (this.EtA != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.EtA);
      }
      paramInt = i;
      if (this.EyR != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.EyR);
      }
      i = paramInt;
      if (this.EyS != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.EyS);
      }
      paramInt = i;
      if (this.EyT != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.EyT);
      }
      i = paramInt;
      if (this.EyU != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.EyU);
      }
      i += g.a.a.b.b.a.gL(16) + 1;
      paramInt = i;
      if (this.EyW != null) {
        paramInt = i + g.a.a.a.oD(17, this.EyW.computeSize());
      }
      AppMethodBeat.o(91252);
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
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91252);
        return -1;
      case 1: 
        localo.Etu = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91252);
        return 0;
      case 2: 
        localo.Etx = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(91252);
        return 0;
      case 3: 
        localo.EyO = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 4: 
        localo.EyP = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 5: 
        localo.Etv = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(91252);
        return 0;
      case 6: 
        localo.Ety = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(91252);
        return 0;
      case 7: 
        localo.Etw = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
        AppMethodBeat.o(91252);
        return 0;
      case 8: 
        localo.EyQ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91252);
        return 0;
      case 9: 
        localo.tVx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91252);
        return 0;
      case 10: 
        localo.Etz = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 11: 
        localo.EtA = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 12: 
        localo.EyR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 13: 
        localo.EyS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 14: 
        localo.EyT = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 15: 
        localo.EyU = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 16: 
        localo.EyV = ((g.a.a.a.a)localObject).abFh.AB();
        AppMethodBeat.o(91252);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        l locall = new l();
        if ((localObject != null) && (localObject.length > 0)) {
          locall.parseFrom((byte[])localObject);
        }
        localo.EyW = locall;
        paramInt += 1;
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    AppMethodBeat.o(91252);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.o
 * JD-Core Version:    0.7.0.1
 */