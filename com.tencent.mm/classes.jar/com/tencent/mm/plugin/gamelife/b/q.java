package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class q
  extends cvw
{
  public String session_id;
  public boolean uIK;
  public long uJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218216);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.session_id == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_id");
        AppMethodBeat.o(218216);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.session_id != null) {
        paramVarArgs.d(2, this.session_id);
      }
      paramVarArgs.aZ(3, this.uJb);
      paramVarArgs.bC(4, this.uIK);
      AppMethodBeat.o(218216);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.session_id);
      }
      paramInt = f.a.a.b.b.a.p(3, this.uJb);
      int j = f.a.a.b.b.a.amF(4);
      AppMethodBeat.o(218216);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.session_id == null)
        {
          paramVarArgs = new b("Not all required fields were included: session_id");
          AppMethodBeat.o(218216);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218216);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218216);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218216);
          return 0;
        case 2: 
          localq.session_id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218216);
          return 0;
        case 3: 
          localq.uJb = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(218216);
          return 0;
        }
        localq.uIK = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(218216);
        return 0;
      }
      AppMethodBeat.o(218216);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.q
 * JD-Core Version:    0.7.0.1
 */