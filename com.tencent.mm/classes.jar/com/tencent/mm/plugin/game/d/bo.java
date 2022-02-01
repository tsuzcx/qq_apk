package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import f.a.a.b;
import java.util.LinkedList;

public final class bo
  extends cwj
{
  public ao utH;
  public ar utI;
  public as utJ;
  public cl utK;
  public eg utL;
  public aw utM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41767);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41767);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.utH != null)
      {
        paramVarArgs.lJ(3, this.utH.computeSize());
        this.utH.writeFields(paramVarArgs);
      }
      if (this.utI != null)
      {
        paramVarArgs.lJ(4, this.utI.computeSize());
        this.utI.writeFields(paramVarArgs);
      }
      if (this.utJ != null)
      {
        paramVarArgs.lJ(5, this.utJ.computeSize());
        this.utJ.writeFields(paramVarArgs);
      }
      if (this.utK != null)
      {
        paramVarArgs.lJ(6, this.utK.computeSize());
        this.utK.writeFields(paramVarArgs);
      }
      if (this.utL != null)
      {
        paramVarArgs.lJ(8, this.utL.computeSize());
        this.utL.writeFields(paramVarArgs);
      }
      if (this.utM != null)
      {
        paramVarArgs.lJ(9, this.utM.computeSize());
        this.utM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(41767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.utH != null) {
        paramInt = i + f.a.a.a.lI(3, this.utH.computeSize());
      }
      i = paramInt;
      if (this.utI != null) {
        i = paramInt + f.a.a.a.lI(4, this.utI.computeSize());
      }
      paramInt = i;
      if (this.utJ != null) {
        paramInt = i + f.a.a.a.lI(5, this.utJ.computeSize());
      }
      i = paramInt;
      if (this.utK != null) {
        i = paramInt + f.a.a.a.lI(6, this.utK.computeSize());
      }
      paramInt = i;
      if (this.utL != null) {
        paramInt = i + f.a.a.a.lI(8, this.utL.computeSize());
      }
      i = paramInt;
      if (this.utM != null) {
        i = paramInt + f.a.a.a.lI(9, this.utM.computeSize());
      }
      AppMethodBeat.o(41767);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41767);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41767);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bo localbo = (bo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(41767);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ao();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ao)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbo.utH = ((ao)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ar();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ar)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbo.utI = ((ar)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new as();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((as)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbo.utJ = ((as)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbo.utK = ((cl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbo.utL = ((eg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41767);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbo.utM = ((aw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41767);
        return 0;
      }
      AppMethodBeat.o(41767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bo
 * JD-Core Version:    0.7.0.1
 */