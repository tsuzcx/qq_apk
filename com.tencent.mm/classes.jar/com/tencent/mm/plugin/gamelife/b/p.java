package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class p
  extends cvc
{
  public String session_id;
  public boolean uxk;
  public long uxy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211173);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.session_id == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_id");
        AppMethodBeat.o(211173);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.d(2, this.session_id);
      }
      paramVarArgs.aY(3, this.uxy);
      paramVarArgs.bt(4, this.uxk);
      AppMethodBeat.o(211173);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.session_id);
      }
      paramInt = f.a.a.b.b.a.p(3, this.uxy);
      int j = f.a.a.b.b.a.alV(4);
      AppMethodBeat.o(211173);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.session_id == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_id");
          AppMethodBeat.o(211173);
          throw paramVarArgs;
        }
        AppMethodBeat.o(211173);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211173);
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
            localp.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211173);
          return 0;
        case 2: 
          localp.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(211173);
          return 0;
        case 3: 
          localp.uxy = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(211173);
          return 0;
        }
        localp.uxk = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(211173);
        return 0;
      }
      AppMethodBeat.o(211173);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.p
 * JD-Core Version:    0.7.0.1
 */