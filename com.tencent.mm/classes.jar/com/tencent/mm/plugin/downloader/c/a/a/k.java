package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class k
  extends bvk
{
  public d kVX;
  public int kWb;
  public String kWc;
  public int koj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35520);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(35520);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.kVX != null)
      {
        paramVarArgs.iQ(2, this.kVX.computeSize());
        this.kVX.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.koj);
      paramVarArgs.aO(4, this.kWb);
      if (this.kWc != null) {
        paramVarArgs.e(5, this.kWc);
      }
      AppMethodBeat.o(35520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kVX != null) {
        i = paramInt + e.a.a.a.iP(2, this.kVX.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(3, this.koj) + e.a.a.b.b.a.bl(4, this.kWb);
      paramInt = i;
      if (this.kWc != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.kWc);
      }
      AppMethodBeat.o(35520);
      return paramInt;
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
          AppMethodBeat.o(35520);
          throw paramVarArgs;
        }
        AppMethodBeat.o(35520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35520);
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
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35520);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localk.kVX = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35520);
          return 0;
        case 3: 
          localk.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(35520);
          return 0;
        case 4: 
          localk.kWb = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(35520);
          return 0;
        }
        localk.kWc = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(35520);
        return 0;
      }
      AppMethodBeat.o(35520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.k
 * JD-Core Version:    0.7.0.1
 */