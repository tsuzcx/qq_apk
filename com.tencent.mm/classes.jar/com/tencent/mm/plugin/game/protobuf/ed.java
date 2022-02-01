package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ed
  extends com.tencent.mm.bw.a
{
  public long oUG;
  public long oUH;
  public dy xKg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256654);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(256654);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.oUG);
      paramVarArgs.bb(2, this.oUH);
      if (this.xKg != null)
      {
        paramVarArgs.ni(3, this.xKg.computeSize());
        this.xKg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(256654);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.oUG) + 0 + g.a.a.b.b.a.r(2, this.oUH);
      paramInt = i;
      if (this.xKg != null) {
        paramInt = i + g.a.a.a.nh(3, this.xKg.computeSize());
      }
      AppMethodBeat.o(256654);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.xKg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Tab");
        AppMethodBeat.o(256654);
        throw paramVarArgs;
      }
      AppMethodBeat.o(256654);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ed localed = (ed)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(256654);
        return -1;
      case 1: 
        localed.oUG = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(256654);
        return 0;
      case 2: 
        localed.oUH = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(256654);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dy();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localed.xKg = ((dy)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(256654);
      return 0;
    }
    AppMethodBeat.o(256654);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ed
 * JD-Core Version:    0.7.0.1
 */