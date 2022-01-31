package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bvk;
import e.a.a.b;
import java.util.LinkedList;

public final class bm
  extends bvk
{
  public ch nsZ;
  public LinkedList<c> nta;
  public boolean ntb;
  public int ntc;
  
  public bm()
  {
    AppMethodBeat.i(111614);
    this.nta = new LinkedList();
    AppMethodBeat.o(111614);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111615);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(111615);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.nsZ != null)
      {
        paramVarArgs.iQ(2, this.nsZ.computeSize());
        this.nsZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.nta);
      paramVarArgs.aS(4, this.ntb);
      paramVarArgs.aO(5, this.ntc);
      AppMethodBeat.o(111615);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nsZ != null) {
        i = paramInt + e.a.a.a.iP(2, this.nsZ.computeSize());
      }
      paramInt = e.a.a.a.c(3, 8, this.nta);
      int j = e.a.a.b.b.a.eW(4);
      int k = e.a.a.b.b.a.bl(5, this.ntc);
      AppMethodBeat.o(111615);
      return i + paramInt + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nta.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(111615);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111615);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bm localbm = (bm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111615);
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
            localbm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111615);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ch();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ch)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbm.nsZ = ((ch)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111615);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbm.nta.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111615);
          return 0;
        case 4: 
          localbm.ntb = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(111615);
          return 0;
        }
        localbm.ntc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(111615);
        return 0;
      }
      AppMethodBeat.o(111615);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bm
 * JD-Core Version:    0.7.0.1
 */