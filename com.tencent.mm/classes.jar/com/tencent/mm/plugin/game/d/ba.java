package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqk;
import f.a.a.b;
import java.util.LinkedList;

public final class ba
  extends cqk
{
  public f thi;
  public String tjN;
  public LinkedList<x> tjO;
  public cf tjP;
  public bv tjQ;
  public bs tjR;
  public cw tjS;
  public LinkedList<y> tjT;
  public db tjU;
  public bu tjV;
  public br tjW;
  
  public ba()
  {
    AppMethodBeat.i(41760);
    this.tjO = new LinkedList();
    this.tjT = new LinkedList();
    AppMethodBeat.o(41760);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.thi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.tjN == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.thi != null)
      {
        paramVarArgs.ln(2, this.thi.computeSize());
        this.thi.writeFields(paramVarArgs);
      }
      if (this.tjN != null) {
        paramVarArgs.d(3, this.tjN);
      }
      paramVarArgs.e(4, 8, this.tjO);
      if (this.tjP != null)
      {
        paramVarArgs.ln(5, this.tjP.computeSize());
        this.tjP.writeFields(paramVarArgs);
      }
      if (this.tjQ != null)
      {
        paramVarArgs.ln(7, this.tjQ.computeSize());
        this.tjQ.writeFields(paramVarArgs);
      }
      if (this.tjR != null)
      {
        paramVarArgs.ln(8, this.tjR.computeSize());
        this.tjR.writeFields(paramVarArgs);
      }
      if (this.tjS != null)
      {
        paramVarArgs.ln(9, this.tjS.computeSize());
        this.tjS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.tjT);
      if (this.tjU != null)
      {
        paramVarArgs.ln(11, this.tjU.computeSize());
        this.tjU.writeFields(paramVarArgs);
      }
      if (this.tjV != null)
      {
        paramVarArgs.ln(12, this.tjV.computeSize());
        this.tjV.writeFields(paramVarArgs);
      }
      if (this.tjW != null)
      {
        paramVarArgs.ln(13, this.tjW.computeSize());
        this.tjW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2046;
      }
    }
    label2046:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thi != null) {
        paramInt = i + f.a.a.a.lm(2, this.thi.computeSize());
      }
      i = paramInt;
      if (this.tjN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tjN);
      }
      i += f.a.a.a.c(4, 8, this.tjO);
      paramInt = i;
      if (this.tjP != null) {
        paramInt = i + f.a.a.a.lm(5, this.tjP.computeSize());
      }
      i = paramInt;
      if (this.tjQ != null) {
        i = paramInt + f.a.a.a.lm(7, this.tjQ.computeSize());
      }
      paramInt = i;
      if (this.tjR != null) {
        paramInt = i + f.a.a.a.lm(8, this.tjR.computeSize());
      }
      i = paramInt;
      if (this.tjS != null) {
        i = paramInt + f.a.a.a.lm(9, this.tjS.computeSize());
      }
      i += f.a.a.a.c(10, 8, this.tjT);
      paramInt = i;
      if (this.tjU != null) {
        paramInt = i + f.a.a.a.lm(11, this.tjU.computeSize());
      }
      i = paramInt;
      if (this.tjV != null) {
        i = paramInt + f.a.a.a.lm(12, this.tjV.computeSize());
      }
      paramInt = i;
      if (this.tjW != null) {
        paramInt = i + f.a.a.a.lm(13, this.tjW.computeSize());
      }
      AppMethodBeat.o(41761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tjO.clear();
        this.tjT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.thi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.tjN == null)
        {
          paramVarArgs = new b("Not all required fields were included: BackGroundURL");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(41761);
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
            localba.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.thi = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 3: 
          localba.tjN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41761);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new x();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((x)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjP = ((cf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjQ = ((bv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjR = ((bs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjS = ((cw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new y();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new db();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((db)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjU = ((db)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localba.tjV = ((bu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new br();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((br)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localba.tjW = ((br)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41761);
        return 0;
      }
      AppMethodBeat.o(41761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ba
 * JD-Core Version:    0.7.0.1
 */