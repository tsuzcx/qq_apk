package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cld;
import f.a.a.b;
import java.util.LinkedList;

public final class k
  extends cld
{
  public int Ret;
  public String oXw;
  public String rNF;
  public int rOd;
  public long rOe;
  
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
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ret);
      if (this.oXw != null) {
        paramVarArgs.d(3, this.oXw);
      }
      if (this.rNF != null) {
        paramVarArgs.d(4, this.rNF);
      }
      paramVarArgs.aR(5, this.rOd);
      paramVarArgs.aG(6, this.rOe);
      AppMethodBeat.o(40878);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ret);
      paramInt = i;
      if (this.oXw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oXw);
      }
      i = paramInt;
      if (this.rNF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rNF);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.rOd);
      int j = f.a.a.b.b.a.q(6, this.rOe);
      AppMethodBeat.o(40878);
      return i + paramInt + j;
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40878);
          return 0;
        case 2: 
          localk.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(40878);
          return 0;
        case 3: 
          localk.oXw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 4: 
          localk.rNF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40878);
          return 0;
        case 5: 
          localk.rOd = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(40878);
          return 0;
        }
        localk.rOe = ((f.a.a.a.a)localObject1).KhF.xT();
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