package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import f.a.a.b;
import java.util.LinkedList;

public final class k
  extends cwj
{
  public int Ret;
  public String qkR;
  public String ucQ;
  public int udq;
  public long udr;
  
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Ret);
      if (this.qkR != null) {
        paramVarArgs.d(3, this.qkR);
      }
      if (this.ucQ != null) {
        paramVarArgs.d(4, this.ucQ);
      }
      paramVarArgs.aS(5, this.udq);
      paramVarArgs.aZ(6, this.udr);
      AppMethodBeat.o(40878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Ret);
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qkR);
      }
      i = paramInt;
      if (this.ucQ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ucQ);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.udq);
      int j = f.a.a.b.b.a.p(6, this.udr);
      AppMethodBeat.o(40878);
      return i + paramInt + j;
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40878);
          return 0;
        case 2: 
          localk.Ret = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(40878);
          return 0;
        case 3: 
          localk.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 4: 
          localk.ucQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 5: 
          localk.udq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(40878);
          return 0;
        }
        localk.udr = ((f.a.a.a.a)localObject1).OmT.zd();
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