package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import java.util.LinkedList;

public final class bm
  extends cwj
{
  public String urb;
  public LinkedList<an> utA;
  public com.tencent.mm.bw.b utB;
  public boolean utC;
  
  public bm()
  {
    AppMethodBeat.i(41763);
    this.utA = new LinkedList();
    AppMethodBeat.o(41763);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41764);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(41764);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.utA);
      if (this.utB != null) {
        paramVarArgs.c(3, this.utB);
      }
      paramVarArgs.bC(4, this.utC);
      if (this.urb != null) {
        paramVarArgs.d(5, this.urb);
      }
      AppMethodBeat.o(41764);
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
      int i = paramInt + f.a.a.a.c(2, 8, this.utA);
      paramInt = i;
      if (this.utB != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.utB);
      }
      i = paramInt + f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.urb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.urb);
      }
      AppMethodBeat.o(41764);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.utA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(41764);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41764);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new an();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((an)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbm.utA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41764);
          return 0;
        case 3: 
          localbm.utB = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(41764);
          return 0;
        case 4: 
          localbm.utC = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(41764);
          return 0;
        }
        localbm.urb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(41764);
        return 0;
      }
      AppMethodBeat.o(41764);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bm
 * JD-Core Version:    0.7.0.1
 */