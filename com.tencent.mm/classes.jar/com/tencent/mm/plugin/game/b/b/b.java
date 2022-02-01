package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import java.util.LinkedList;

public final class b
  extends cvp
{
  public int Ret;
  public String desc;
  public int oxF;
  public String qem;
  public String tRZ;
  public boolean tSa = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40865);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(40865);
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
      paramVarArgs.bt(5, this.tSa);
      paramVarArgs.aS(6, this.oxF);
      if (this.desc != null) {
        paramVarArgs.d(7, this.desc);
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
      i = i + f.a.a.b.b.a.alV(5) + f.a.a.b.b.a.bz(6, this.oxF);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.desc);
      }
      AppMethodBeat.o(40865);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(40865);
          throw paramVarArgs;
        }
        AppMethodBeat.o(40865);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40865);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40865);
          return 0;
        case 2: 
          localb.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(40865);
          return 0;
        case 3: 
          localb.qem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 4: 
          localb.tRZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(40865);
          return 0;
        case 5: 
          localb.tSa = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(40865);
          return 0;
        case 6: 
          localb.oxF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(40865);
          return 0;
        }
        localb.desc = ((f.a.a.a.a)localObject1).NPN.readString();
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