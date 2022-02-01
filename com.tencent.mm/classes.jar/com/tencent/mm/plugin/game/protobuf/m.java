package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bw.a
{
  public LinkedList<bc> xJs;
  public String xJt;
  
  public m()
  {
    AppMethodBeat.i(41712);
    this.xJs = new LinkedList();
    AppMethodBeat.o(41712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.xJs);
      if (this.xJt != null) {
        paramVarArgs.e(2, this.xJt);
      }
      AppMethodBeat.o(41713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.xJs) + 0;
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xJt);
      }
      AppMethodBeat.o(41713);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xJs.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(41713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41713);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localm.xJs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41713);
        return 0;
      }
      localm.xJt = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(41713);
      return 0;
    }
    AppMethodBeat.o(41713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.m
 * JD-Core Version:    0.7.0.1
 */