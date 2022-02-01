package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqk;
import f.a.a.b;
import java.util.LinkedList;

public final class ay
  extends cqk
{
  public ae tjA;
  public g tjB;
  public de tjC;
  public o tjD;
  public dq tjE;
  public u tjF;
  public dp tjG;
  public t tjH;
  public a tjI;
  public i tjJ;
  public boolean tjx;
  public am tjy;
  public String tjz;
  
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
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(2, this.tjx);
      if (this.tjy != null)
      {
        paramVarArgs.ln(3, this.tjy.computeSize());
        this.tjy.writeFields(paramVarArgs);
      }
      if (this.tjz != null) {
        paramVarArgs.d(4, this.tjz);
      }
      if (this.tjA != null)
      {
        paramVarArgs.ln(6, this.tjA.computeSize());
        this.tjA.writeFields(paramVarArgs);
      }
      if (this.tjB != null)
      {
        paramVarArgs.ln(7, this.tjB.computeSize());
        this.tjB.writeFields(paramVarArgs);
      }
      if (this.tjC != null)
      {
        paramVarArgs.ln(8, this.tjC.computeSize());
        this.tjC.writeFields(paramVarArgs);
      }
      if (this.tjD != null)
      {
        paramVarArgs.ln(11, this.tjD.computeSize());
        this.tjD.writeFields(paramVarArgs);
      }
      if (this.tjE != null)
      {
        paramVarArgs.ln(12, this.tjE.computeSize());
        this.tjE.writeFields(paramVarArgs);
      }
      if (this.tjF != null)
      {
        paramVarArgs.ln(13, this.tjF.computeSize());
        this.tjF.writeFields(paramVarArgs);
      }
      if (this.tjG != null)
      {
        paramVarArgs.ln(14, this.tjG.computeSize());
        this.tjG.writeFields(paramVarArgs);
      }
      if (this.tjH != null)
      {
        paramVarArgs.ln(15, this.tjH.computeSize());
        this.tjH.writeFields(paramVarArgs);
      }
      if (this.tjI != null)
      {
        paramVarArgs.ln(16, this.tjI.computeSize());
        this.tjI.writeFields(paramVarArgs);
      }
      if (this.tjJ != null)
      {
        paramVarArgs.ln(17, this.tjJ.computeSize());
        this.tjJ.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.tjy != null) {
        paramInt = i + f.a.a.a.lm(3, this.tjy.computeSize());
      }
      i = paramInt;
      if (this.tjz != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tjz);
      }
      paramInt = i;
      if (this.tjA != null) {
        paramInt = i + f.a.a.a.lm(6, this.tjA.computeSize());
      }
      i = paramInt;
      if (this.tjB != null) {
        i = paramInt + f.a.a.a.lm(7, this.tjB.computeSize());
      }
      paramInt = i;
      if (this.tjC != null) {
        paramInt = i + f.a.a.a.lm(8, this.tjC.computeSize());
      }
      i = paramInt;
      if (this.tjD != null) {
        i = paramInt + f.a.a.a.lm(11, this.tjD.computeSize());
      }
      paramInt = i;
      if (this.tjE != null) {
        paramInt = i + f.a.a.a.lm(12, this.tjE.computeSize());
      }
      i = paramInt;
      if (this.tjF != null) {
        i = paramInt + f.a.a.a.lm(13, this.tjF.computeSize());
      }
      paramInt = i;
      if (this.tjG != null) {
        paramInt = i + f.a.a.a.lm(14, this.tjG.computeSize());
      }
      i = paramInt;
      if (this.tjH != null) {
        i = paramInt + f.a.a.a.lm(15, this.tjH.computeSize());
      }
      paramInt = i;
      if (this.tjI != null) {
        paramInt = i + f.a.a.a.lm(16, this.tjI.computeSize());
      }
      i = paramInt;
      if (this.tjJ != null) {
        i = paramInt + f.a.a.a.lm(17, this.tjJ.computeSize());
      }
      AppMethodBeat.o(149416);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 2: 
          localay.tjx = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(149416);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new am();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((am)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjy = ((am)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 4: 
          localay.tjz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(149416);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ae();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ae)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjA = ((ae)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjB = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjC = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new o();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjD = ((o)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjE = ((dq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjF = ((u)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjG = ((dp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjH = ((t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localay.tjI = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149416);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localay.tjJ = ((i)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ay
 * JD-Core Version:    0.7.0.1
 */