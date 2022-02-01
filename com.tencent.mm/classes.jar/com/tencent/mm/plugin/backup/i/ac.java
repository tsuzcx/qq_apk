package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bw.a
{
  public int oTW;
  public int oTl;
  public q oUN;
  public p oUO;
  public r oUP;
  public s oUQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22135);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.oTl);
      paramVarArgs.aM(2, this.oTW);
      if (this.oUN != null)
      {
        paramVarArgs.ni(3, this.oUN.computeSize());
        this.oUN.writeFields(paramVarArgs);
      }
      if (this.oUO != null)
      {
        paramVarArgs.ni(4, this.oUO.computeSize());
        this.oUO.writeFields(paramVarArgs);
      }
      if (this.oUP != null)
      {
        paramVarArgs.ni(5, this.oUP.computeSize());
        this.oUP.writeFields(paramVarArgs);
      }
      if (this.oUQ != null)
      {
        paramVarArgs.ni(6, this.oUQ.computeSize());
        this.oUQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.oTl) + 0 + g.a.a.b.b.a.bu(2, this.oTW);
      paramInt = i;
      if (this.oUN != null) {
        paramInt = i + g.a.a.a.nh(3, this.oUN.computeSize());
      }
      i = paramInt;
      if (this.oUO != null) {
        i = paramInt + g.a.a.a.nh(4, this.oUO.computeSize());
      }
      paramInt = i;
      if (this.oUP != null) {
        paramInt = i + g.a.a.a.nh(5, this.oUP.computeSize());
      }
      i = paramInt;
      if (this.oUQ != null) {
        i = paramInt + g.a.a.a.nh(6, this.oUQ.computeSize());
      }
      AppMethodBeat.o(22135);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(22135);
        return -1;
      case 1: 
        localac.oTl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(22135);
        return 0;
      case 2: 
        localac.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(22135);
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
          localac.oUN = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localac.oUO = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localac.oUP = ((r)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localac.oUQ = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    AppMethodBeat.o(22135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */