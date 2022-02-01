package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public LinkedList<e> Idq;
  
  public f()
  {
    AppMethodBeat.i(40870);
    this.Idq = new LinkedList();
    AppMethodBeat.o(40870);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40871);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.Idq);
      AppMethodBeat.o(40871);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.Idq);
      AppMethodBeat.o(40871);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Idq.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(40871);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(40871);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        e locale = new e();
        if ((localObject != null) && (localObject.length > 0)) {
          locale.parseFrom((byte[])localObject);
        }
        localf.Idq.add(locale);
        paramInt += 1;
      }
      AppMethodBeat.o(40871);
      return 0;
    }
    AppMethodBeat.o(40871);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.f
 * JD-Core Version:    0.7.0.1
 */