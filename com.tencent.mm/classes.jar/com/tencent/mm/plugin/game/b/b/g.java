package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.jc;
import java.util.LinkedList;

public final class g
  extends cvw
{
  public int limit = 20;
  public long offset;
  public String ucP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40872);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.offset);
      paramVarArgs.aS(3, this.limit);
      if (this.ucP != null) {
        paramVarArgs.d(4, this.ucP);
      }
      AppMethodBeat.o(40872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.offset) + f.a.a.b.b.a.bz(3, this.limit);
      paramInt = i;
      if (this.ucP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ucP);
      }
      AppMethodBeat.o(40872);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(40872);
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
          AppMethodBeat.o(40872);
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
            localg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(40872);
          return 0;
        case 2: 
          localg.offset = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(40872);
          return 0;
        case 3: 
          localg.limit = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(40872);
          return 0;
        }
        localg.ucP = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(40872);
        return 0;
      }
      AppMethodBeat.o(40872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.g
 * JD-Core Version:    0.7.0.1
 */