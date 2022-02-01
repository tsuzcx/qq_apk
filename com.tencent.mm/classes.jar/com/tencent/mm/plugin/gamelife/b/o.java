package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class o
  extends cvw
{
  public a uIP;
  public boolean uJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218214);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uIP == null)
      {
        paramVarArgs = new b("Not all required fields were included: black_list_info");
        AppMethodBeat.o(218214);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uIP != null)
      {
        paramVarArgs.lJ(2, this.uIP.computeSize());
        this.uIP.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(3, this.uJa);
      AppMethodBeat.o(218214);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uIP != null) {
        i = paramInt + f.a.a.a.lI(2, this.uIP.computeSize());
      }
      paramInt = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(218214);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uIP == null)
        {
          paramVarArgs = new b("Not all required fields were included: black_list_info");
          AppMethodBeat.o(218214);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218214);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218214);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218214);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localo.uIP = ((a)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218214);
          return 0;
        }
        localo.uJa = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(218214);
        return 0;
      }
      AppMethodBeat.o(218214);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.o
 * JD-Core Version:    0.7.0.1
 */