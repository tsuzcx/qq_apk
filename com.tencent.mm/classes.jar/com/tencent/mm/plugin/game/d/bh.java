package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import f.a.a.b;
import java.util.LinkedList;

public final class bh
  extends cvw
{
  public String jge;
  public String usS;
  public int usT;
  public f usU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.usS == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(149415);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.usS != null) {
        paramVarArgs.d(2, this.usS);
      }
      if (this.jge != null) {
        paramVarArgs.d(3, this.jge);
      }
      paramVarArgs.aS(4, this.usT);
      if (this.usU != null)
      {
        paramVarArgs.lJ(5, this.usU.computeSize());
        this.usU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(149415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label678;
      }
    }
    label678:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.usS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.usS);
      }
      i = paramInt;
      if (this.jge != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.jge);
      }
      i += f.a.a.b.b.a.bz(4, this.usT);
      paramInt = i;
      if (this.usU != null) {
        paramInt = i + f.a.a.a.lI(5, this.usU.computeSize());
      }
      AppMethodBeat.o(149415);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.usS == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(149415);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(149415);
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
            localbh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(149415);
          return 0;
        case 2: 
          localbh.usS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 3: 
          localbh.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(149415);
          return 0;
        case 4: 
          localbh.usT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(149415);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbh.usU = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(149415);
        return 0;
      }
      AppMethodBeat.o(149415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bh
 * JD-Core Version:    0.7.0.1
 */