package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public long ybb;
  public long ybc;
  public m ybd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225886);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.ybb);
      paramVarArgs.bb(2, this.ybc);
      if (this.ybd != null)
      {
        paramVarArgs.ni(3, this.ybd.computeSize());
        this.ybd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(225886);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.ybb) + 0 + g.a.a.b.b.a.r(2, this.ybc);
      paramInt = i;
      if (this.ybd != null) {
        paramInt = i + g.a.a.a.nh(3, this.ybd.computeSize());
      }
      AppMethodBeat.o(225886);
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
      AppMethodBeat.o(225886);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(225886);
        return -1;
      case 1: 
        localc.ybb = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(225886);
        return 0;
      case 2: 
        localc.ybc = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(225886);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new m();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localc.ybd = ((m)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(225886);
      return 0;
    }
    AppMethodBeat.o(225886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.c
 * JD-Core Version:    0.7.0.1
 */