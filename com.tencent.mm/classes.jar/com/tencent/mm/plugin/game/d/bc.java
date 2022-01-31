package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import java.util.LinkedList;

public final class bc
  extends bvk
{
  public String nqu;
  public LinkedList<ad> nsC;
  public com.tencent.mm.bv.b nsD;
  public boolean nsE;
  
  public bc()
  {
    AppMethodBeat.i(111598);
    this.nsC = new LinkedList();
    AppMethodBeat.o(111598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111599);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(111599);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nsC);
      if (this.nsD != null) {
        paramVarArgs.c(3, this.nsD);
      }
      paramVarArgs.aS(4, this.nsE);
      if (this.nqu != null) {
        paramVarArgs.e(5, this.nqu);
      }
      AppMethodBeat.o(111599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.nsC);
      paramInt = i;
      if (this.nsD != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.nsD);
      }
      i = paramInt + (e.a.a.b.b.a.eW(4) + 1);
      paramInt = i;
      if (this.nqu != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.nqu);
      }
      AppMethodBeat.o(111599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nsC.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(111599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111599);
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
            localbc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111599);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ad();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ad)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbc.nsC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111599);
          return 0;
        case 3: 
          localbc.nsD = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(111599);
          return 0;
        case 4: 
          localbc.nsE = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111599);
          return 0;
        }
        localbc.nqu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111599);
        return 0;
      }
      AppMethodBeat.o(111599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bc
 * JD-Core Version:    0.7.0.1
 */