package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cw
  extends com.tencent.mm.bw.a
{
  public LinkedList<c> xME;
  public df xMF;
  public LinkedList<q> xMG;
  public db xMH;
  public LinkedList<dt> xMI;
  
  public cw()
  {
    AppMethodBeat.i(41809);
    this.xME = new LinkedList();
    this.xMG = new LinkedList();
    this.xMI = new LinkedList();
    AppMethodBeat.o(41809);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41810);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.xME);
      if (this.xMF != null)
      {
        paramVarArgs.ni(2, this.xMF.computeSize());
        this.xMF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.xMG);
      if (this.xMH != null)
      {
        paramVarArgs.ni(4, this.xMH.computeSize());
        this.xMH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.xMI);
      AppMethodBeat.o(41810);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.xME) + 0;
      paramInt = i;
      if (this.xMF != null) {
        paramInt = i + g.a.a.a.nh(2, this.xMF.computeSize());
      }
      i = paramInt + g.a.a.a.c(3, 8, this.xMG);
      paramInt = i;
      if (this.xMH != null) {
        paramInt = i + g.a.a.a.nh(4, this.xMH.computeSize());
      }
      i = g.a.a.a.c(5, 8, this.xMI);
      AppMethodBeat.o(41810);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xME.clear();
      this.xMG.clear();
      this.xMI.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(41810);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cw localcw = (cw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(41810);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcw.xME.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new df();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((df)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcw.xMF = ((df)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcw.xMG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new db();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((db)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcw.xMH = ((db)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(41810);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dt();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localcw.xMI.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(41810);
      return 0;
    }
    AppMethodBeat.o(41810);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cw
 * JD-Core Version:    0.7.0.1
 */