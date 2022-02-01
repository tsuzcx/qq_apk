package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class ay
  extends cvw
{
  public String gvv;
  public String urR;
  public com.tencent.mm.bw.b urT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gvv == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41746);
        throw paramVarArgs;
      }
      if (this.urR == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41746);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gvv != null) {
        paramVarArgs.d(2, this.gvv);
      }
      if (this.urR != null) {
        paramVarArgs.d(3, this.urR);
      }
      if (this.urT != null) {
        paramVarArgs.c(4, this.urT);
      }
      AppMethodBeat.o(41746);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gvv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gvv);
      }
      i = paramInt;
      if (this.urR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.urR);
      }
      paramInt = i;
      if (this.urT != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.urT);
      }
      AppMethodBeat.o(41746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.gvv == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41746);
          throw paramVarArgs;
        }
        if (this.urR == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: GroupID");
          AppMethodBeat.o(41746);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41746);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41746);
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
            localay.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41746);
          return 0;
        case 2: 
          localay.gvv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41746);
          return 0;
        case 3: 
          localay.urR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(41746);
          return 0;
        }
        localay.urT = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(41746);
        return 0;
      }
      AppMethodBeat.o(41746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ay
 * JD-Core Version:    0.7.0.1
 */