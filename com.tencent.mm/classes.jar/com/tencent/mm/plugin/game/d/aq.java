package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ip;
import java.util.LinkedList;

public final class aq
  extends ckq
{
  public String fVC;
  public String saE;
  public com.tencent.mm.bx.b saG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fVC == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41746);
        throw paramVarArgs;
      }
      if (this.saE == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41746);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fVC != null) {
        paramVarArgs.d(2, this.fVC);
      }
      if (this.saE != null) {
        paramVarArgs.d(3, this.saE);
      }
      if (this.saG != null) {
        paramVarArgs.c(4, this.saG);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fVC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fVC);
      }
      i = paramInt;
      if (this.saE != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.saE);
      }
      paramInt = i;
      if (this.saG != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.saG);
      }
      AppMethodBeat.o(41746);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.fVC == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41746);
          throw paramVarArgs;
        }
        if (this.saE == null)
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
        aq localaq = (aq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41746);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41746);
          return 0;
        case 2: 
          localaq.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41746);
          return 0;
        case 3: 
          localaq.saE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(41746);
          return 0;
        }
        localaq.saG = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(41746);
        return 0;
      }
      AppMethodBeat.o(41746);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aq
 * JD-Core Version:    0.7.0.1
 */