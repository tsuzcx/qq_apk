package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.hq;
import java.util.LinkedList;

public final class bb
  extends buy
{
  public b nsB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111597);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nsB != null) {
        paramVarArgs.c(2, this.nsB);
      }
      AppMethodBeat.o(111597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nsB != null) {
        i = paramInt + e.a.a.b.b.a.b(2, this.nsB);
      }
      AppMethodBeat.o(111597);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(111597);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbb.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(111597);
          return 0;
        }
        localbb.nsB = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(111597);
        return 0;
      }
      AppMethodBeat.o(111597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bb
 * JD-Core Version:    0.7.0.1
 */