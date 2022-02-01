package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bx.a
{
  public int Kmb;
  public double Kmc;
  public double Kmd;
  public double Kme;
  public double Kmf;
  public String Kmg;
  public String Kmh;
  public String KrB;
  public String KrC;
  public int KrD;
  public String KrE;
  public String KrF;
  public String KrG;
  public String KrH;
  public boolean KrI;
  public m KrJ;
  public int wYR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91252);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Kmb);
      paramVarArgs.d(2, this.Kme);
      if (this.KrB != null) {
        paramVarArgs.g(3, this.KrB);
      }
      if (this.KrC != null) {
        paramVarArgs.g(4, this.KrC);
      }
      paramVarArgs.d(5, this.Kmc);
      paramVarArgs.d(6, this.Kmf);
      paramVarArgs.d(7, this.Kmd);
      paramVarArgs.bS(8, this.KrD);
      paramVarArgs.bS(9, this.wYR);
      if (this.Kmg != null) {
        paramVarArgs.g(10, this.Kmg);
      }
      if (this.Kmh != null) {
        paramVarArgs.g(11, this.Kmh);
      }
      if (this.KrE != null) {
        paramVarArgs.g(12, this.KrE);
      }
      if (this.KrF != null) {
        paramVarArgs.g(13, this.KrF);
      }
      if (this.KrG != null) {
        paramVarArgs.g(14, this.KrG);
      }
      if (this.KrH != null) {
        paramVarArgs.g(15, this.KrH);
      }
      paramVarArgs.di(16, this.KrI);
      if (this.KrJ != null)
      {
        paramVarArgs.qD(17, this.KrJ.computeSize());
        this.KrJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Kmb) + 0 + (i.a.a.b.b.a.ko(2) + 8);
      paramInt = i;
      if (this.KrB != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.KrB);
      }
      i = paramInt;
      if (this.KrC != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.KrC);
      }
      i = i + (i.a.a.b.b.a.ko(5) + 8) + (i.a.a.b.b.a.ko(6) + 8) + (i.a.a.b.b.a.ko(7) + 8) + i.a.a.b.b.a.cJ(8, this.KrD) + i.a.a.b.b.a.cJ(9, this.wYR);
      paramInt = i;
      if (this.Kmg != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Kmg);
      }
      i = paramInt;
      if (this.Kmh != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Kmh);
      }
      paramInt = i;
      if (this.KrE != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.KrE);
      }
      i = paramInt;
      if (this.KrF != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.KrF);
      }
      paramInt = i;
      if (this.KrG != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.KrG);
      }
      i = paramInt;
      if (this.KrH != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.KrH);
      }
      i += i.a.a.b.b.a.ko(16) + 1;
      paramInt = i;
      if (this.KrJ != null) {
        paramInt = i + i.a.a.a.qC(17, this.KrJ.computeSize());
      }
      AppMethodBeat.o(91252);
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
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91252);
        return -1;
      case 1: 
        localo.Kmb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91252);
        return 0;
      case 2: 
        localo.Kme = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(91252);
        return 0;
      case 3: 
        localo.KrB = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 4: 
        localo.KrC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 5: 
        localo.Kmc = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(91252);
        return 0;
      case 6: 
        localo.Kmf = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(91252);
        return 0;
      case 7: 
        localo.Kmd = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
        AppMethodBeat.o(91252);
        return 0;
      case 8: 
        localo.KrD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91252);
        return 0;
      case 9: 
        localo.wYR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91252);
        return 0;
      case 10: 
        localo.Kmg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 11: 
        localo.Kmh = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 12: 
        localo.KrE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 13: 
        localo.KrF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 14: 
        localo.KrG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 15: 
        localo.KrH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 16: 
        localo.KrI = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(91252);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        m localm = new m();
        if ((localObject != null) && (localObject.length > 0)) {
          localm.parseFrom((byte[])localObject);
        }
        localo.KrJ = localm;
        paramInt += 1;
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    AppMethodBeat.o(91252);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.o
 * JD-Core Version:    0.7.0.1
 */