package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public int jJg;
  public q jKK;
  public p jKL;
  public r jKM;
  public s jKN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18078);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jJg);
      paramVarArgs.aO(2, this.jJS);
      if (this.jKK != null)
      {
        paramVarArgs.iQ(3, this.jKK.computeSize());
        this.jKK.writeFields(paramVarArgs);
      }
      if (this.jKL != null)
      {
        paramVarArgs.iQ(4, this.jKL.computeSize());
        this.jKL.writeFields(paramVarArgs);
      }
      if (this.jKM != null)
      {
        paramVarArgs.iQ(5, this.jKM.computeSize());
        this.jKM.writeFields(paramVarArgs);
      }
      if (this.jKN != null)
      {
        paramVarArgs.iQ(6, this.jKN.computeSize());
        this.jKN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(18078);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.jJg) + 0 + e.a.a.b.b.a.bl(2, this.jJS);
      paramInt = i;
      if (this.jKK != null) {
        paramInt = i + e.a.a.a.iP(3, this.jKK.computeSize());
      }
      i = paramInt;
      if (this.jKL != null) {
        i = paramInt + e.a.a.a.iP(4, this.jKL.computeSize());
      }
      paramInt = i;
      if (this.jKM != null) {
        paramInt = i + e.a.a.a.iP(5, this.jKM.computeSize());
      }
      i = paramInt;
      if (this.jKN != null) {
        i = paramInt + e.a.a.a.iP(6, this.jKN.computeSize());
      }
      AppMethodBeat.o(18078);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(18078);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      ac localac = (ac)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(18078);
        return -1;
      case 1: 
        localac.jJg = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(18078);
        return 0;
      case 2: 
        localac.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(18078);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localac.jKK = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(18078);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localac.jKL = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(18078);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localac.jKM = ((r)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(18078);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localac.jKN = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(18078);
      return 0;
    }
    AppMethodBeat.o(18078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */