package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import java.util.LinkedList;

public final class b
  extends dpc
{
  public int Ret;
  public String desc;
  public int pRQ;
  public String rBM;
  public String xuE;
  public boolean xuF = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40865);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40865);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Ret);
      if (this.rBM != null) {
        paramVarArgs.e(3, this.rBM);
      }
      if (this.xuE != null) {
        paramVarArgs.e(4, this.xuE);
      }
      paramVarArgs.cc(5, this.xuF);
      paramVarArgs.aM(6, this.pRQ);
      if (this.desc != null) {
        paramVarArgs.e(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Ret);
      paramInt = i;
      if (this.rBM != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.rBM);
      }
      i = paramInt;
      if (this.xuE != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xuE);
      }
      i = i + (g.a.a.b.b.a.fS(5) + 1) + g.a.a.b.b.a.bu(6, this.pRQ);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.desc);
      }
      AppMethodBeat.o(40865);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40865);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40865);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40865);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40865);
          return 0;
        case 2: 
          localb.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(40865);
          return 0;
        case 3: 
          localb.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 4: 
          localb.xuE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 5: 
          localb.xuF = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(40865);
          return 0;
        case 6: 
          localb.pRQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(40865);
          return 0;
        }
        localb.desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(40865);
        return 0;
      }
      AppMethodBeat.o(40865);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.b
 * JD-Core Version:    0.7.0.1
 */