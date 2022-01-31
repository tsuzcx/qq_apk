package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import e.a.a.b;
import java.util.LinkedList;

public final class j
  extends buy
{
  public String eds;
  public String kWa;
  public String source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35519);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.eds == null)
      {
        paramVarArgs = new b("Not all required fields were included: download_url");
        AppMethodBeat.o(35519);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.eds != null) {
        paramVarArgs.e(2, this.eds);
      }
      if (this.kWa != null) {
        paramVarArgs.e(3, this.kWa);
      }
      if (this.source != null) {
        paramVarArgs.e(4, this.source);
      }
      AppMethodBeat.o(35519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label538;
      }
    }
    label538:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.eds != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.eds);
      }
      i = paramInt;
      if (this.kWa != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kWa);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.source);
      }
      AppMethodBeat.o(35519);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.eds == null)
        {
          paramVarArgs = new b("Not all required fields were included: download_url");
          AppMethodBeat.o(35519);
          throw paramVarArgs;
        }
        AppMethodBeat.o(35519);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35519);
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
            localj.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35519);
          return 0;
        case 2: 
          localj.eds = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35519);
          return 0;
        case 3: 
          localj.kWa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(35519);
          return 0;
        }
        localj.source = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(35519);
        return 0;
      }
      AppMethodBeat.o(35519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.j
 * JD-Core Version:    0.7.0.1
 */