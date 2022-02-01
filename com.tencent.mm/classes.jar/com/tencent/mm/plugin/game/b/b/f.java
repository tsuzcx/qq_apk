package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public LinkedList<e> udd;
  
  public f()
  {
    AppMethodBeat.i(40870);
    this.udd = new LinkedList();
    AppMethodBeat.o(40870);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40871);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).e(1, 8, this.udd);
      AppMethodBeat.o(40871);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.udd);
      AppMethodBeat.o(40871);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.udd.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(40871);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(40871);
        return -1;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new e();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localf.udd.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(40871);
      return 0;
    }
    AppMethodBeat.o(40871);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.f
 * JD-Core Version:    0.7.0.1
 */