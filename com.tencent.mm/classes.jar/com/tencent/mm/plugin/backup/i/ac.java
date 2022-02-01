package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bx.a
{
  public int nCU;
  public int nDG;
  public s nEA;
  public q nEx;
  public p nEy;
  public r nEz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22135);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nCU);
      paramVarArgs.aS(2, this.nDG);
      if (this.nEx != null)
      {
        paramVarArgs.lC(3, this.nEx.computeSize());
        this.nEx.writeFields(paramVarArgs);
      }
      if (this.nEy != null)
      {
        paramVarArgs.lC(4, this.nEy.computeSize());
        this.nEy.writeFields(paramVarArgs);
      }
      if (this.nEz != null)
      {
        paramVarArgs.lC(5, this.nEz.computeSize());
        this.nEz.writeFields(paramVarArgs);
      }
      if (this.nEA != null)
      {
        paramVarArgs.lC(6, this.nEA.computeSize());
        this.nEA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nCU) + 0 + f.a.a.b.b.a.bz(2, this.nDG);
      paramInt = i;
      if (this.nEx != null) {
        paramInt = i + f.a.a.a.lB(3, this.nEx.computeSize());
      }
      i = paramInt;
      if (this.nEy != null) {
        i = paramInt + f.a.a.a.lB(4, this.nEy.computeSize());
      }
      paramInt = i;
      if (this.nEz != null) {
        paramInt = i + f.a.a.a.lB(5, this.nEz.computeSize());
      }
      i = paramInt;
      if (this.nEA != null) {
        i = paramInt + f.a.a.a.lB(6, this.nEA.computeSize());
      }
      AppMethodBeat.o(22135);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
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
        localac.nCU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(22135);
        return 0;
      case 2: 
        localac.nDG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(22135);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nEx = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nEy = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nEz = ((r)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localac.nEA = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    AppMethodBeat.o(22135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */