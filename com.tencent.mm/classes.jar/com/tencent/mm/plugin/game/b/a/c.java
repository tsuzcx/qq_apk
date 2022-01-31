package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class c
  extends bvk
{
  public int Ret;
  public String lGL;
  public String niO;
  public int niP;
  public long niQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151793);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(151793);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Ret);
      if (this.lGL != null) {
        paramVarArgs.e(3, this.lGL);
      }
      if (this.niO != null) {
        paramVarArgs.e(4, this.niO);
      }
      paramVarArgs.aO(5, this.niP);
      paramVarArgs.am(6, this.niQ);
      AppMethodBeat.o(151793);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.Ret);
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.lGL);
      }
      i = paramInt;
      if (this.niO != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.niO);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.niP);
      int j = e.a.a.b.b.a.p(6, this.niQ);
      AppMethodBeat.o(151793);
      return i + paramInt + j;
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
          AppMethodBeat.o(151793);
          throw paramVarArgs;
        }
        AppMethodBeat.o(151793);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151793);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151793);
          return 0;
        case 2: 
          localc.Ret = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151793);
          return 0;
        case 3: 
          localc.lGL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151793);
          return 0;
        case 4: 
          localc.niO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(151793);
          return 0;
        case 5: 
          localc.niP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151793);
          return 0;
        }
        localc.niQ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(151793);
        return 0;
      }
      AppMethodBeat.o(151793);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.c
 * JD-Core Version:    0.7.0.1
 */