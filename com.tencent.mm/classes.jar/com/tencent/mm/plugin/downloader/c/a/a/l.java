package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class l
  extends cvc
{
  public String pjS;
  public o pjT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153054);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pjS == null)
      {
        paramVarArgs = new b("Not all required fields were included: search_key");
        AppMethodBeat.o(153054);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.pjS != null) {
        paramVarArgs.d(2, this.pjS);
      }
      if (this.pjT != null)
      {
        paramVarArgs.lC(3, this.pjT.computeSize());
        this.pjT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pjS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pjS);
      }
      i = paramInt;
      if (this.pjT != null) {
        i = paramInt + f.a.a.a.lB(3, this.pjT.computeSize());
      }
      AppMethodBeat.o(153054);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.pjS == null)
        {
          paramVarArgs = new b("Not all required fields were included: search_key");
          AppMethodBeat.o(153054);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153054);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locall.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153054);
          return 0;
        case 2: 
          locall.pjS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153054);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.pjT = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153054);
        return 0;
      }
      AppMethodBeat.o(153054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.l
 * JD-Core Version:    0.7.0.1
 */