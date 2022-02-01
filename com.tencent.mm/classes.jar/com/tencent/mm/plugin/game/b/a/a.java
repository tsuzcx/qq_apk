package com.tencent.mm.plugin.game.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.iv;
import java.util.LinkedList;

public final class a
  extends cpx
{
  public String hOf;
  public int sVo;
  public String sVp;
  public long sVq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.sVo);
      if (this.sVp != null) {
        paramVarArgs.d(3, this.sVp);
      }
      if (this.hOf != null) {
        paramVarArgs.d(4, this.hOf);
      }
      paramVarArgs.aO(5, this.sVq);
      AppMethodBeat.o(40860);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.sVo);
      paramInt = i;
      if (this.sVp != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.sVp);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hOf);
      }
      paramInt = f.a.a.b.b.a.p(5, this.sVq);
      AppMethodBeat.o(40860);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(40860);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(40860);
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
            locala.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40860);
          return 0;
        case 2: 
          locala.sVo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(40860);
          return 0;
        case 3: 
          locala.sVp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40860);
          return 0;
        case 4: 
          locala.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(40860);
          return 0;
        }
        locala.sVq = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(40860);
        return 0;
      }
      AppMethodBeat.o(40860);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.a.a
 * JD-Core Version:    0.7.0.1
 */