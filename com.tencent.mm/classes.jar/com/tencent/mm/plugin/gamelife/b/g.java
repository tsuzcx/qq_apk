package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class g
  extends cvc
{
  public String ovl;
  public String ovm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211162);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ovm == null)
      {
        paramVarArgs = new b("Not all required fields were included: to_username");
        AppMethodBeat.o(211162);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ovl != null) {
        paramVarArgs.d(2, this.ovl);
      }
      if (this.ovm != null) {
        paramVarArgs.d(3, this.ovm);
      }
      AppMethodBeat.o(211162);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ovl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ovl);
      }
      i = paramInt;
      if (this.ovm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ovm);
      }
      AppMethodBeat.o(211162);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.ovm == null)
        {
          paramVarArgs = new b("Not all required fields were included: to_username");
          AppMethodBeat.o(211162);
          throw paramVarArgs;
        }
        AppMethodBeat.o(211162);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211162);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211162);
          return 0;
        case 2: 
          localg.ovl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211162);
          return 0;
        }
        localg.ovm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(211162);
        return 0;
      }
      AppMethodBeat.o(211162);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.g
 * JD-Core Version:    0.7.0.1
 */