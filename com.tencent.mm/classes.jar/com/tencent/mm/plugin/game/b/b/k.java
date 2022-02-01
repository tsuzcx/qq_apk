package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public final class k
  extends dpc
{
  public int Ret;
  public String rBM;
  public String xuE;
  public int xvc;
  public long xvd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40878);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Ret);
      if (this.rBM != null) {
        paramVarArgs.e(3, this.rBM);
      }
      if (this.xuE != null) {
        paramVarArgs.e(4, this.xuE);
      }
      paramVarArgs.aM(5, this.xvc);
      paramVarArgs.bb(6, this.xvd);
      AppMethodBeat.o(40878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Ret);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.rBM);
      }
      i = paramInt;
      if (this.xuE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xuE);
      }
      paramInt = g.a.a.b.b.a.bu(5, this.xvc);
      int j = g.a.a.b.b.a.r(6, this.xvd);
      AppMethodBeat.o(40878);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40878);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40878);
          return 0;
        case 2: 
          localk.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(40878);
          return 0;
        case 3: 
          localk.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 4: 
          localk.xuE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 5: 
          localk.xvc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(40878);
          return 0;
        }
        localk.xvd = ((g.a.a.a.a)localObject1).UbS.zl();
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