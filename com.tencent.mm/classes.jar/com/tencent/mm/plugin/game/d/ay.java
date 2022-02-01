package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cld;
import f.a.a.b;
import java.util.LinkedList;

public final class ay
  extends cld
{
  public boolean sbD;
  public am sbE;
  public String sbF;
  public ae sbG;
  public g sbH;
  public de sbI;
  public o sbJ;
  public dq sbK;
  public u sbL;
  public dp sbM;
  public t sbN;
  public a sbO;
  public i sbP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(149416);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(2, this.sbD);
      if (this.sbE != null)
      {
        paramVarArgs.kX(3, this.sbE.computeSize());
        this.sbE.writeFields(paramVarArgs);
      }
      if (this.sbF != null) {
        paramVarArgs.d(4, this.sbF);
      }
      if (this.sbG != null)
      {
        paramVarArgs.kX(6, this.sbG.computeSize());
        this.sbG.writeFields(paramVarArgs);
      }
      if (this.sbH != null)
      {
        paramVarArgs.kX(7, this.sbH.computeSize());
        this.sbH.writeFields(paramVarArgs);
      }
      if (this.sbI != null)
      {
        paramVarArgs.kX(8, this.sbI.computeSize());
        this.sbI.writeFields(paramVarArgs);
      }
      if (this.sbJ != null)
      {
        paramVarArgs.kX(11, this.sbJ.computeSize());
        this.sbJ.writeFields(paramVarArgs);
      }
      if (this.sbK != null)
      {
        paramVarArgs.kX(12, this.sbK.computeSize());
        this.sbK.writeFields(paramVarArgs);
      }
      if (this.sbL != null)
      {
        paramVarArgs.kX(13, this.sbL.computeSize());
        this.sbL.writeFields(paramVarArgs);
      }
      if (this.sbM != null)
      {
        paramVarArgs.kX(14, this.sbM.computeSize());
        this.sbM.writeFields(paramVarArgs);
      }
      if (this.sbN != null)
      {
        paramVarArgs.kX(15, this.sbN.computeSize());
        this.sbN.writeFields(paramVarArgs);
      }
      if (this.sbO != null)
      {
        paramVarArgs.kX(16, this.sbO.computeSize());
        this.sbO.writeFields(paramVarArgs);
      }
      if (this.sbP != null)
      {
        paramVarArgs.kX(17, this.sbP.computeSize());
        this.sbP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2186;
      }
    }
    label2186:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fY(2) + 1);
      paramInt = i;
      if (this.sbE != null) {
        paramInt = i + f.a.a.a.kW(3, this.sbE.computeSize());
      }
      i = paramInt;
      if (this.sbF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.sbF);
      }
      paramInt = i;
      if (this.sbG != null) {
        paramInt = i + f.a.a.a.kW(6, this.sbG.computeSize());
      }
      i = paramInt;
      if (this.sbH != null) {
        i = paramInt + f.a.a.a.kW(7, this.sbH.computeSize());
      }
      paramInt = i;
      if (this.sbI != null) {
        paramInt = i + f.a.a.a.kW(8, this.sbI.computeSize());
      }
      i = paramInt;
      if (this.sbJ != null) {
        i = paramInt + f.a.a.a.kW(11, this.sbJ.computeSize());
      }
      paramInt = i;
      if (this.sbK != null) {
        paramInt = i + f.a.a.a.kW(12, this.sbK.computeSize());
      }
      i = paramInt;
      if (this.sbL != null) {
        i = paramInt + f.a.a.a.kW(13, this.sbL.computeSize());
      }
      paramInt = i;
      if (this.sbM != null) {
        paramInt = i + f.a.a.a.kW(14, this.sbM.computeSize());
      }
      i = paramInt;
      if (this.sbN != null) {
        i = paramInt + f.a.a.a.kW(15, this.sbN.computeSize());
      }
      paramInt = i;
      if (this.sbO != null) {
        paramInt = i + f.a.a.a.kW(16, this.sbO.computeSize());
      }
      i = paramInt;
      if (this.sbP != null) {
        i = paramInt + f.a.a.a.kW(17, this.sbP.computeSize());
      }
      AppMethodBeat.o(149416);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(149416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(149416);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 2: 
          localay.sbD = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(149416);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new am();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((am)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbE = ((am)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 4: 
          localay.sbF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(149416);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ae();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ae)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbG = ((ae)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbH = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbI = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbJ = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbK = ((dq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbL = ((u)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbM = ((dp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbN = ((t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.sbO = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localay.sbP = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(149416);
        return 0;
      }
      AppMethodBeat.o(149416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ay
 * JD-Core Version:    0.7.0.1
 */