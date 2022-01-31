package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import e.a.a.b;
import java.util.LinkedList;

public final class dj
  extends buy
{
  public String npZ;
  public String nul;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111677);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.npZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppID");
        AppMethodBeat.o(111677);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.npZ != null) {
        paramVarArgs.e(2, this.npZ);
      }
      if (this.nul != null) {
        paramVarArgs.e(3, this.nul);
      }
      AppMethodBeat.o(111677);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.npZ != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.npZ);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nul);
      }
      AppMethodBeat.o(111677);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.npZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppID");
          AppMethodBeat.o(111677);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111677);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        dj localdj = (dj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111677);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localdj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111677);
          return 0;
        case 2: 
          localdj.npZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(111677);
          return 0;
        }
        localdj.nul = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(111677);
        return 0;
      }
      AppMethodBeat.o(111677);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dj
 * JD-Core Version:    0.7.0.1
 */