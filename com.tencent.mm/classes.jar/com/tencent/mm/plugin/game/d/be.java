package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class be
  extends bvk
{
  public ae nsJ;
  public ah nsK;
  public ai nsL;
  public by nsM;
  public di nsN;
  public am nsO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111602);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(111602);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.nsJ != null)
      {
        paramVarArgs.iQ(3, this.nsJ.computeSize());
        this.nsJ.writeFields(paramVarArgs);
      }
      if (this.nsK != null)
      {
        paramVarArgs.iQ(4, this.nsK.computeSize());
        this.nsK.writeFields(paramVarArgs);
      }
      if (this.nsL != null)
      {
        paramVarArgs.iQ(5, this.nsL.computeSize());
        this.nsL.writeFields(paramVarArgs);
      }
      if (this.nsM != null)
      {
        paramVarArgs.iQ(6, this.nsM.computeSize());
        this.nsM.writeFields(paramVarArgs);
      }
      if (this.nsN != null)
      {
        paramVarArgs.iQ(8, this.nsN.computeSize());
        this.nsN.writeFields(paramVarArgs);
      }
      if (this.nsO != null)
      {
        paramVarArgs.iQ(9, this.nsO.computeSize());
        this.nsO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(111602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1298;
      }
    }
    label1298:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nsJ != null) {
        paramInt = i + e.a.a.a.iP(3, this.nsJ.computeSize());
      }
      i = paramInt;
      if (this.nsK != null) {
        i = paramInt + e.a.a.a.iP(4, this.nsK.computeSize());
      }
      paramInt = i;
      if (this.nsL != null) {
        paramInt = i + e.a.a.a.iP(5, this.nsL.computeSize());
      }
      i = paramInt;
      if (this.nsM != null) {
        i = paramInt + e.a.a.a.iP(6, this.nsM.computeSize());
      }
      paramInt = i;
      if (this.nsN != null) {
        paramInt = i + e.a.a.a.iP(8, this.nsN.computeSize());
      }
      i = paramInt;
      if (this.nsO != null) {
        i = paramInt + e.a.a.a.iP(9, this.nsO.computeSize());
      }
      AppMethodBeat.o(111602);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(111602);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        be localbe = (be)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(111602);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111602);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ae();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ae)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbe.nsJ = ((ae)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111602);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ah();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ah)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbe.nsK = ((ah)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111602);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ai();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ai)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbe.nsL = ((ai)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111602);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new by();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((by)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbe.nsM = ((by)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111602);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new di();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((di)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbe.nsN = ((di)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111602);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new am();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((am)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbe.nsO = ((am)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(111602);
        return 0;
      }
      AppMethodBeat.o(111602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.be
 * JD-Core Version:    0.7.0.1
 */