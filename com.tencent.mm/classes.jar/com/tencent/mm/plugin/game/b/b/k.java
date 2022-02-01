package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class k
  extends cvp
{
  public int Ret;
  public String qem;
  public String tRZ;
  public long tSA;
  public int tSz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40878);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40878);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Ret);
      if (this.qem != null) {
        paramVarArgs.d(3, this.qem);
      }
      if (this.tRZ != null) {
        paramVarArgs.d(4, this.tRZ);
      }
      paramVarArgs.aS(5, this.tSz);
      paramVarArgs.aY(6, this.tSA);
      AppMethodBeat.o(40878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Ret);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qem);
      }
      i = paramInt;
      if (this.tRZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tRZ);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.tSz);
      int j = f.a.a.b.b.a.p(6, this.tSA);
      AppMethodBeat.o(40878);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40878);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40878);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40878);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40878);
          return 0;
        case 2: 
          localk.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(40878);
          return 0;
        case 3: 
          localk.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 4: 
          localk.tRZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 5: 
          localk.tSz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(40878);
          return 0;
        }
        localk.tSA = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(40878);
        return 0;
      }
      AppMethodBeat.o(40878);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.k
 * JD-Core Version:    0.7.0.1
 */