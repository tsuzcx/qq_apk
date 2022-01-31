package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class bo
  extends bvk
{
  public boolean ntb;
  public int ntc;
  public LinkedList<e> ntf;
  
  public bo()
  {
    AppMethodBeat.i(111617);
    this.ntf = new LinkedList();
    AppMethodBeat.o(111617);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111618);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(111618);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ntf);
      paramVarArgs.aS(3, this.ntb);
      paramVarArgs.aO(4, this.ntc);
      AppMethodBeat.o(111618);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.a.c(2, 8, this.ntf);
      int j = e.a.a.b.b.a.eW(3);
      int k = e.a.a.b.b.a.bl(4, this.ntc);
      AppMethodBeat.o(111618);
      return paramInt + i + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ntf.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(111618);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111618);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bo localbo = (bo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111618);
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
            localbo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111618);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbo.ntf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111618);
          return 0;
        case 3: 
          localbo.ntb = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111618);
          return 0;
        }
        localbo.ntc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(111618);
        return 0;
      }
      AppMethodBeat.o(111618);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bo
 * JD-Core Version:    0.7.0.1
 */