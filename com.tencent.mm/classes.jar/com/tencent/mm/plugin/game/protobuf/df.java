package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class df
  extends com.tencent.mm.bw.a
{
  public LinkedList<dg> xMT;
  public String xMU;
  public String xMk;
  
  public df()
  {
    AppMethodBeat.i(41819);
    this.xMT = new LinkedList();
    AppMethodBeat.o(41819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41820);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.xMT);
      if (this.xMk != null) {
        paramVarArgs.e(2, this.xMk);
      }
      if (this.xMU != null) {
        paramVarArgs.e(3, this.xMU);
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.xMT) + 0;
      paramInt = i;
      if (this.xMk != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xMk);
      }
      i = paramInt;
      if (this.xMU != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xMU);
      }
      AppMethodBeat.o(41820);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xMT.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(41820);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      df localdf = (df)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41820);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdf.xMT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41820);
        return 0;
      case 2: 
        localdf.xMk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(41820);
        return 0;
      }
      localdf.xMU = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(41820);
      return 0;
    }
    AppMethodBeat.o(41820);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.df
 * JD-Core Version:    0.7.0.1
 */