package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class k
  extends cvp
{
  public int ozR;
  public d pjM;
  public int pjQ;
  public String pjR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153053);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(153053);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pjM != null)
      {
        paramVarArgs.lC(2, this.pjM.computeSize());
        this.pjM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.ozR);
      paramVarArgs.aS(4, this.pjQ);
      if (this.pjR != null) {
        paramVarArgs.d(5, this.pjR);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pjM != null) {
        i = paramInt + f.a.a.a.lB(2, this.pjM.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.ozR) + f.a.a.b.b.a.bz(4, this.pjQ);
      paramInt = i;
      if (this.pjR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pjR);
      }
      AppMethodBeat.o(153053);
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(153053);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153053);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pjM = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 3: 
          localk.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153053);
          return 0;
        case 4: 
          localk.pjQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153053);
          return 0;
        }
        localk.pjR = ((f.a.a.a.a)localObject1).NPN.readString();
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