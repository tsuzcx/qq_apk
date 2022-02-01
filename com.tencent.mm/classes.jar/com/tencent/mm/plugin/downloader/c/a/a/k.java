package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public final class k
  extends dpc
{
  public int pTZ;
  public d qFW;
  public int qGa;
  public String qGb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153053);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153053);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.qFW != null)
      {
        paramVarArgs.ni(2, this.qFW.computeSize());
        this.qFW.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.pTZ);
      paramVarArgs.aM(4, this.qGa);
      if (this.qGb != null) {
        paramVarArgs.e(5, this.qGb);
      }
      AppMethodBeat.o(153053);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qFW != null) {
        i = paramInt + g.a.a.a.nh(2, this.qFW.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.pTZ) + g.a.a.b.b.a.bu(4, this.qGa);
      paramInt = i;
      if (this.qGb != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.qGb);
      }
      AppMethodBeat.o(153053);
      return paramInt;
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
          AppMethodBeat.o(153053);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153053);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153053);
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
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localk.qFW = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 3: 
          localk.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153053);
          return 0;
        case 4: 
          localk.qGa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(153053);
          return 0;
        }
        localk.qGb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(153053);
        return 0;
      }
      AppMethodBeat.o(153053);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.k
 * JD-Core Version:    0.7.0.1
 */