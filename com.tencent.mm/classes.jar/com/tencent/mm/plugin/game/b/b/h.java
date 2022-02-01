package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import java.util.LinkedList;

public final class h
  extends dpc
{
  public int Ret;
  public int oKY;
  public int pRQ;
  public boolean qGh;
  public String rBM;
  public String xuD;
  public String xuE;
  public long xuR;
  public LinkedList<m> xuS;
  
  public h()
  {
    AppMethodBeat.i(40873);
    this.xuS = new LinkedList();
    AppMethodBeat.o(40873);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40874);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40874);
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
      paramVarArgs.cc(5, this.qGh);
      paramVarArgs.bb(6, this.xuR);
      paramVarArgs.e(7, 8, this.xuS);
      if (this.xuD != null) {
        paramVarArgs.e(8, this.xuD);
      }
      paramVarArgs.aM(9, this.oKY);
      paramVarArgs.aM(10, this.pRQ);
      AppMethodBeat.o(40874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label906;
      }
    }
    label906:
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
      i = i + (g.a.a.b.b.a.fS(5) + 1) + g.a.a.b.b.a.r(6, this.xuR) + g.a.a.a.c(7, 8, this.xuS);
      paramInt = i;
      if (this.xuD != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.xuD);
      }
      i = g.a.a.b.b.a.bu(9, this.oKY);
      int j = g.a.a.b.b.a.bu(10, this.pRQ);
      AppMethodBeat.o(40874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xuS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40874);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40874);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40874);
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
            localh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 2: 
          localh.Ret = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(40874);
          return 0;
        case 3: 
          localh.rBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 4: 
          localh.xuE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 5: 
          localh.qGh = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(40874);
          return 0;
        case 6: 
          localh.xuR = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(40874);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localh.xuS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 8: 
          localh.xuD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 9: 
          localh.oKY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(40874);
          return 0;
        }
        localh.pRQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(40874);
        return 0;
      }
      AppMethodBeat.o(40874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.h
 * JD-Core Version:    0.7.0.1
 */