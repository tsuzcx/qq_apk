package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class h
  extends cvw
{
  public String oBM;
  public String oBN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oBN == null)
      {
        paramVarArgs = new b("Not all required fields were included: to_username");
        AppMethodBeat.o(218205);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oBM != null) {
        paramVarArgs.d(2, this.oBM);
      }
      if (this.oBN != null) {
        paramVarArgs.d(3, this.oBN);
      }
      AppMethodBeat.o(218205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label478;
      }
    }
    label478:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oBM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oBM);
      }
      i = paramInt;
      if (this.oBN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oBN);
      }
      AppMethodBeat.o(218205);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.oBN == null)
        {
          paramVarArgs = new b("Not all required fields were included: to_username");
          AppMethodBeat.o(218205);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218205);
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
            localh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218205);
          return 0;
        case 2: 
          localh.oBM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218205);
          return 0;
        }
        localh.oBN = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218205);
        return 0;
      }
      AppMethodBeat.o(218205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.h
 * JD-Core Version:    0.7.0.1
 */