package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class bd
  extends cvp
{
  public f ueZ;
  public String uhP;
  public LinkedList<y> uhQ;
  public cl uhR;
  public ca uhS;
  public bx uhT;
  public de uhU;
  public LinkedList<z> uhV;
  public dj uhW;
  public bz uhX;
  public bv uhY;
  
  public bd()
  {
    AppMethodBeat.i(41760);
    this.uhQ = new LinkedList();
    this.uhV = new LinkedList();
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
      if (this.ueZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppItem");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.uhP == null)
      {
        paramVarArgs = new b("Not all required fields were included: BackGroundURL");
        AppMethodBeat.o(41761);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ueZ != null)
      {
        paramVarArgs.lC(2, this.ueZ.computeSize());
        this.ueZ.writeFields(paramVarArgs);
      }
      if (this.uhP != null) {
        paramVarArgs.d(3, this.uhP);
      }
      paramVarArgs.e(4, 8, this.uhQ);
      if (this.uhR != null)
      {
        paramVarArgs.lC(5, this.uhR.computeSize());
        this.uhR.writeFields(paramVarArgs);
      }
      if (this.uhS != null)
      {
        paramVarArgs.lC(7, this.uhS.computeSize());
        this.uhS.writeFields(paramVarArgs);
      }
      if (this.uhT != null)
      {
        paramVarArgs.lC(8, this.uhT.computeSize());
        this.uhT.writeFields(paramVarArgs);
      }
      if (this.uhU != null)
      {
        paramVarArgs.lC(9, this.uhU.computeSize());
        this.uhU.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.uhV);
      if (this.uhW != null)
      {
        paramVarArgs.lC(11, this.uhW.computeSize());
        this.uhW.writeFields(paramVarArgs);
      }
      if (this.uhX != null)
      {
        paramVarArgs.lC(12, this.uhX.computeSize());
        this.uhX.writeFields(paramVarArgs);
      }
      if (this.uhY != null)
      {
        paramVarArgs.lC(13, this.uhY.computeSize());
        this.uhY.writeFields(paramVarArgs);
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
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ueZ != null) {
        paramInt = i + f.a.a.a.lB(2, this.ueZ.computeSize());
      }
      i = paramInt;
      if (this.uhP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uhP);
      }
      i += f.a.a.a.c(4, 8, this.uhQ);
      paramInt = i;
      if (this.uhR != null) {
        paramInt = i + f.a.a.a.lB(5, this.uhR.computeSize());
      }
      i = paramInt;
      if (this.uhS != null) {
        i = paramInt + f.a.a.a.lB(7, this.uhS.computeSize());
      }
      paramInt = i;
      if (this.uhT != null) {
        paramInt = i + f.a.a.a.lB(8, this.uhT.computeSize());
      }
      i = paramInt;
      if (this.uhU != null) {
        i = paramInt + f.a.a.a.lB(9, this.uhU.computeSize());
      }
      i += f.a.a.a.c(10, 8, this.uhV);
      paramInt = i;
      if (this.uhW != null) {
        paramInt = i + f.a.a.a.lB(11, this.uhW.computeSize());
      }
      i = paramInt;
      if (this.uhX != null) {
        i = paramInt + f.a.a.a.lB(12, this.uhX.computeSize());
      }
      paramInt = i;
      if (this.uhY != null) {
        paramInt = i + f.a.a.a.lB(13, this.uhY.computeSize());
      }
      AppMethodBeat.o(41761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.uhQ.clear();
        this.uhV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.ueZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppItem");
          AppMethodBeat.o(41761);
          throw paramVarArgs;
        }
        if (this.uhP == null)
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
        bd localbd = (bd)paramVarArgs[1];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.ueZ = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 3: 
          localbd.uhP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(41761);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new y();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhR = ((cl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhS = ((ca)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhT = ((bx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new de();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((de)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhU = ((de)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new z();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhW = ((dj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbd.uhX = ((bz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41761);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbd.uhY = ((bv)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bd
 * JD-Core Version:    0.7.0.1
 */