package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import f.a.a.b;
import java.util.LinkedList;

public final class k
  extends cwj
{
  public int oGt;
  public d pqr;
  public int pqv;
  public String pqw;
  
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
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pqr != null)
      {
        paramVarArgs.lJ(2, this.pqr.computeSize());
        this.pqr.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.oGt);
      paramVarArgs.aS(4, this.pqv);
      if (this.pqw != null) {
        paramVarArgs.d(5, this.pqw);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pqr != null) {
        i = paramInt + f.a.a.a.lI(2, this.pqr.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.oGt) + f.a.a.b.b.a.bz(4, this.pqv);
      paramInt = i;
      if (this.pqw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pqw);
      }
      AppMethodBeat.o(153053);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pqr = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153053);
          return 0;
        case 3: 
          localk.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153053);
          return 0;
        case 4: 
          localk.pqv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(153053);
          return 0;
        }
        localk.pqw = ((f.a.a.a.a)localObject1).OmT.readString();
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