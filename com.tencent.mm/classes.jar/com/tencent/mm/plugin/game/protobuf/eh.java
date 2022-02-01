package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eh
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public String IHo;
  public String IHp;
  public String ILV;
  public String ILW;
  public String ILX;
  public String ILY;
  public String ILZ;
  public String ILw;
  public String IMa;
  public ef IMb;
  public eg IMc;
  public boolean IMd;
  public int IMe;
  public String hAP;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276897);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(276897);
        throw paramVarArgs;
      }
      if (this.ILw != null) {
        paramVarArgs.g(1, this.ILw);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.ILV != null) {
        paramVarArgs.g(11, this.ILV);
      }
      if (this.ILW != null) {
        paramVarArgs.g(12, this.ILW);
      }
      if (this.ILX != null) {
        paramVarArgs.g(13, this.ILX);
      }
      if (this.ILY != null) {
        paramVarArgs.g(14, this.ILY);
      }
      if (this.IHo != null) {
        paramVarArgs.g(3, this.IHo);
      }
      if (this.ILZ != null) {
        paramVarArgs.g(4, this.ILZ);
      }
      if (this.IHp != null) {
        paramVarArgs.g(9, this.IHp);
      }
      if (this.IMa != null) {
        paramVarArgs.g(10, this.IMa);
      }
      paramVarArgs.bS(5, this.vhJ);
      if (this.IGI != null) {
        paramVarArgs.g(6, this.IGI);
      }
      if (this.IMb != null)
      {
        paramVarArgs.qD(7, this.IMb.computeSize());
        this.IMb.writeFields(paramVarArgs);
      }
      if (this.IMc != null)
      {
        paramVarArgs.qD(8, this.IMc.computeSize());
        this.IMc.writeFields(paramVarArgs);
      }
      paramVarArgs.di(15, this.IMd);
      paramVarArgs.bS(16, this.IMe);
      AppMethodBeat.o(276897);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILw == null) {
        break label1278;
      }
    }
    label1278:
    for (int i = i.a.a.b.b.a.h(1, this.ILw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.ILV != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ILV);
      }
      paramInt = i;
      if (this.ILW != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ILW);
      }
      i = paramInt;
      if (this.ILX != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.ILX);
      }
      paramInt = i;
      if (this.ILY != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ILY);
      }
      i = paramInt;
      if (this.IHo != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IHo);
      }
      paramInt = i;
      if (this.ILZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ILZ);
      }
      i = paramInt;
      if (this.IHp != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.IHp);
      }
      paramInt = i;
      if (this.IMa != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.IMa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.vhJ);
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IGI);
      }
      i = paramInt;
      if (this.IMb != null) {
        i = paramInt + i.a.a.a.qC(7, this.IMb.computeSize());
      }
      paramInt = i;
      if (this.IMc != null) {
        paramInt = i + i.a.a.a.qC(8, this.IMc.computeSize());
      }
      i = i.a.a.b.b.a.ko(15);
      int j = i.a.a.b.b.a.cJ(16, this.IMe);
      AppMethodBeat.o(276897);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ILw == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(276897);
          throw paramVarArgs;
        }
        AppMethodBeat.o(276897);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eh localeh = (eh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(276897);
          return -1;
        case 1: 
          localeh.ILw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 2: 
          localeh.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 11: 
          localeh.ILV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 12: 
          localeh.ILW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 13: 
          localeh.ILX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 14: 
          localeh.ILY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 3: 
          localeh.IHo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 4: 
          localeh.ILZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 9: 
          localeh.IHp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 10: 
          localeh.IMa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 5: 
          localeh.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(276897);
          return 0;
        case 6: 
          localeh.IGI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(276897);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ef();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ef)localObject2).parseFrom((byte[])localObject1);
            }
            localeh.IMb = ((ef)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276897);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eg)localObject2).parseFrom((byte[])localObject1);
            }
            localeh.IMc = ((eg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(276897);
          return 0;
        case 15: 
          localeh.IMd = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(276897);
          return 0;
        }
        localeh.IMe = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(276897);
        return 0;
      }
      AppMethodBeat.o(276897);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eh
 * JD-Core Version:    0.7.0.1
 */