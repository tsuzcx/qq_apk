package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import java.util.LinkedList;

public final class ab
  extends cpx
{
  public String fZx;
  public com.tencent.mm.bw.b tiA;
  public String tiy;
  public com.tencent.mm.bw.b tiz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41729);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZx == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.tiy == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: GroupID");
        AppMethodBeat.o(41729);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fZx != null) {
        paramVarArgs.d(2, this.fZx);
      }
      if (this.tiy != null) {
        paramVarArgs.d(3, this.tiy);
      }
      if (this.tiz != null) {
        paramVarArgs.c(4, this.tiz);
      }
      if (this.tiA != null) {
        paramVarArgs.c(5, this.tiA);
      }
      AppMethodBeat.o(41729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fZx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fZx);
      }
      i = paramInt;
      if (this.tiy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tiy);
      }
      paramInt = i;
      if (this.tiz != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.tiz);
      }
      i = paramInt;
      if (this.tiA != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.tiA);
      }
      AppMethodBeat.o(41729);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.fZx == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: AppID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        if (this.tiy == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: GroupID");
          AppMethodBeat.o(41729);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41729);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(41729);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localab.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(41729);
          return 0;
        case 2: 
          localab.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 3: 
          localab.tiy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(41729);
          return 0;
        case 4: 
          localab.tiz = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(41729);
          return 0;
        }
        localab.tiA = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(41729);
        return 0;
      }
      AppMethodBeat.o(41729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ab
 * JD-Core Version:    0.7.0.1
 */