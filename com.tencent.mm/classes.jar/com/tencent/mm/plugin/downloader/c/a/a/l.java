package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import e.a.a.b;
import java.util.LinkedList;

public final class l
  extends buy
{
  public String kWd;
  public o kWe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35521);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kWd == null)
      {
        paramVarArgs = new b("Not all required fields were included: search_key");
        AppMethodBeat.o(35521);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.kWd != null) {
        paramVarArgs.e(2, this.kWd);
      }
      if (this.kWe != null)
      {
        paramVarArgs.iQ(3, this.kWe.computeSize());
        this.kWe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(35521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label574;
      }
    }
    label574:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWd != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kWd);
      }
      i = paramInt;
      if (this.kWe != null) {
        i = paramInt + e.a.a.a.iP(3, this.kWe.computeSize());
      }
      AppMethodBeat.o(35521);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.kWd == null)
        {
          paramVarArgs = new b("Not all required fields were included: search_key");
          AppMethodBeat.o(35521);
          throw paramVarArgs;
        }
        AppMethodBeat.o(35521);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35521);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locall.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35521);
          return 0;
        case 2: 
          locall.kWd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35521);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locall.kWe = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(35521);
        return 0;
      }
      AppMethodBeat.o(35521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.l
 * JD-Core Version:    0.7.0.1
 */