package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bw.a
{
  public int qww;
  public String yPA;
  public String yPB;
  public int yPv;
  public double yPw;
  public double yPx;
  public double yPy;
  public double yPz;
  public String yUR;
  public String yUS;
  public int yUT;
  public String yUU;
  public String yUV;
  public String yUW;
  public String yUX;
  public boolean yUY;
  public l yUZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91252);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.yPv);
      paramVarArgs.e(2, this.yPy);
      if (this.yUR != null) {
        paramVarArgs.e(3, this.yUR);
      }
      if (this.yUS != null) {
        paramVarArgs.e(4, this.yUS);
      }
      paramVarArgs.e(5, this.yPw);
      paramVarArgs.e(6, this.yPz);
      paramVarArgs.e(7, this.yPx);
      paramVarArgs.aM(8, this.yUT);
      paramVarArgs.aM(9, this.qww);
      if (this.yPA != null) {
        paramVarArgs.e(10, this.yPA);
      }
      if (this.yPB != null) {
        paramVarArgs.e(11, this.yPB);
      }
      if (this.yUU != null) {
        paramVarArgs.e(12, this.yUU);
      }
      if (this.yUV != null) {
        paramVarArgs.e(13, this.yUV);
      }
      if (this.yUW != null) {
        paramVarArgs.e(14, this.yUW);
      }
      if (this.yUX != null) {
        paramVarArgs.e(15, this.yUX);
      }
      paramVarArgs.cc(16, this.yUY);
      if (this.yUZ != null)
      {
        paramVarArgs.ni(17, this.yUZ.computeSize());
        this.yUZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.yPv) + 0 + (g.a.a.b.b.a.fS(2) + 8);
      paramInt = i;
      if (this.yUR != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.yUR);
      }
      i = paramInt;
      if (this.yUS != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yUS);
      }
      i = i + (g.a.a.b.b.a.fS(5) + 8) + (g.a.a.b.b.a.fS(6) + 8) + (g.a.a.b.b.a.fS(7) + 8) + g.a.a.b.b.a.bu(8, this.yUT) + g.a.a.b.b.a.bu(9, this.qww);
      paramInt = i;
      if (this.yPA != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.yPA);
      }
      i = paramInt;
      if (this.yPB != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.yPB);
      }
      paramInt = i;
      if (this.yUU != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.yUU);
      }
      i = paramInt;
      if (this.yUV != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.yUV);
      }
      paramInt = i;
      if (this.yUW != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.yUW);
      }
      i = paramInt;
      if (this.yUX != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.yUX);
      }
      i += g.a.a.b.b.a.fS(16) + 1;
      paramInt = i;
      if (this.yUZ != null) {
        paramInt = i + g.a.a.a.nh(17, this.yUZ.computeSize());
      }
      AppMethodBeat.o(91252);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91252);
        return -1;
      case 1: 
        localo.yPv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91252);
        return 0;
      case 2: 
        localo.yPy = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91252);
        return 0;
      case 3: 
        localo.yUR = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 4: 
        localo.yUS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 5: 
        localo.yPw = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91252);
        return 0;
      case 6: 
        localo.yPz = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91252);
        return 0;
      case 7: 
        localo.yPx = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91252);
        return 0;
      case 8: 
        localo.yUT = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91252);
        return 0;
      case 9: 
        localo.qww = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91252);
        return 0;
      case 10: 
        localo.yPA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 11: 
        localo.yPB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 12: 
        localo.yUU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 13: 
        localo.yUV = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 14: 
        localo.yUW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 15: 
        localo.yUX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 16: 
        localo.yUY = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(91252);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new l();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localo.yUZ = ((l)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    AppMethodBeat.o(91252);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.o
 * JD-Core Version:    0.7.0.1
 */