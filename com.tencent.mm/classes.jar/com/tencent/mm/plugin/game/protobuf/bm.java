package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import java.util.LinkedList;

public final class bm
  extends dpc
{
  public String xJu;
  public LinkedList<ao> xLC;
  public com.tencent.mm.bw.b xLD;
  public boolean xLE;
  
  public bm()
  {
    AppMethodBeat.i(41763);
    this.xLC = new LinkedList();
    AppMethodBeat.o(41763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41764);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41764);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xLC);
      if (this.xLD != null) {
        paramVarArgs.c(3, this.xLD);
      }
      paramVarArgs.cc(4, this.xLE);
      if (this.xJu != null) {
        paramVarArgs.e(5, this.xJu);
      }
      AppMethodBeat.o(41764);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.xLC);
      paramInt = i;
      if (this.xLD != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.xLD);
      }
      i = paramInt + (g.a.a.b.b.a.fS(4) + 1);
      paramInt = i;
      if (this.xJu != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xJu);
      }
      AppMethodBeat.o(41764);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41764);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bm localbm = (bm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41764);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ao();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ao)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbm.xLC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 3: 
          localbm.xLD = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(41764);
          return 0;
        case 4: 
          localbm.xLE = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(41764);
          return 0;
        }
        localbm.xJu = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41764);
        return 0;
      }
      AppMethodBeat.o(41764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.bm
 * JD-Core Version:    0.7.0.1
 */