package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class h
  extends cvp
{
  public int Ret;
  public int nuF;
  public int oxF;
  public boolean pjX;
  public String qem;
  public String tRY;
  public String tRZ;
  public long tSn;
  public LinkedList<m> tSo;
  
  public h()
  {
    AppMethodBeat.i(40873);
    this.tSo = new LinkedList();
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Ret);
      if (this.qem != null) {
        paramVarArgs.d(3, this.qem);
      }
      if (this.tRZ != null) {
        paramVarArgs.d(4, this.tRZ);
      }
      paramVarArgs.bt(5, this.pjX);
      paramVarArgs.aY(6, this.tSn);
      paramVarArgs.e(7, 8, this.tSo);
      if (this.tRY != null) {
        paramVarArgs.d(8, this.tRY);
      }
      paramVarArgs.aS(9, this.nuF);
      paramVarArgs.aS(10, this.oxF);
      AppMethodBeat.o(40874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Ret);
      paramInt = i;
      if (this.qem != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qem);
      }
      i = paramInt;
      if (this.tRZ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tRZ);
      }
      i = i + f.a.a.b.b.a.alV(5) + f.a.a.b.b.a.p(6, this.tSn) + f.a.a.a.c(7, 8, this.tSo);
      paramInt = i;
      if (this.tRY != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.tRY);
      }
      i = f.a.a.b.b.a.bz(9, this.nuF);
      int j = f.a.a.b.b.a.bz(10, this.oxF);
      AppMethodBeat.o(40874);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tSo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 2: 
          localh.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(40874);
          return 0;
        case 3: 
          localh.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 4: 
          localh.tRZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 5: 
          localh.pjX = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(40874);
          return 0;
        case 6: 
          localh.tSn = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(40874);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localh.tSo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40874);
          return 0;
        case 8: 
          localh.tRY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40874);
          return 0;
        case 9: 
          localh.nuF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(40874);
          return 0;
        }
        localh.oxF = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(40874);
        return 0;
      }
      AppMethodBeat.o(40874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.h
 * JD-Core Version:    0.7.0.1
 */