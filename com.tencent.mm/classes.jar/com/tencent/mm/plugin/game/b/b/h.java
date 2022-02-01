package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cld;
import f.a.a.b;
import java.util.LinkedList;

public final class h
  extends cld
{
  public int Ret;
  public int msg;
  public int nrk;
  public String oXw;
  public boolean ocU;
  public String rNE;
  public String rNF;
  public long rNR;
  public LinkedList<m> rNS;
  
  public h()
  {
    AppMethodBeat.i(40873);
    this.rNS = new LinkedList();
    AppMethodBeat.o(40873);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40874);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40874);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Ret);
      if (this.oXw != null) {
        paramVarArgs.d(3, this.oXw);
      }
      if (this.rNF != null) {
        paramVarArgs.d(4, this.rNF);
      }
      paramVarArgs.bg(5, this.ocU);
      paramVarArgs.aG(6, this.rNR);
      paramVarArgs.e(7, 8, this.rNS);
      if (this.rNE != null) {
        paramVarArgs.d(8, this.rNE);
      }
      paramVarArgs.aR(9, this.msg);
      paramVarArgs.aR(10, this.nrk);
      AppMethodBeat.o(40874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.Ret);
      paramInt = i;
      if (this.oXw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oXw);
      }
      i = paramInt;
      if (this.rNF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.rNF);
      }
      i = i + (f.a.a.b.b.a.fY(5) + 1) + f.a.a.b.b.a.q(6, this.rNR) + f.a.a.a.c(7, 8, this.rNS);
      paramInt = i;
      if (this.rNE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.rNE);
      }
      i = f.a.a.b.b.a.bA(9, this.msg);
      int j = f.a.a.b.b.a.bA(10, this.nrk);
      AppMethodBeat.o(40874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rNS.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 2: 
          localh.Ret = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(40874);
          return 0;
        case 3: 
          localh.oXw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 4: 
          localh.rNF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 5: 
          localh.ocU = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(40874);
          return 0;
        case 6: 
          localh.rNR = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(40874);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.rNS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 8: 
          localh.rNE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 9: 
          localh.msg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(40874);
          return 0;
        }
        localh.nrk = ((f.a.a.a.a)localObject1).KhF.xS();
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