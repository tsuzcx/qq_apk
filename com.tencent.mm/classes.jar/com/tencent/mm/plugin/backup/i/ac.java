package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bw.a
{
  public int nIp;
  public q nJS;
  public p nJT;
  public r nJU;
  public s nJV;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22135);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.nIp);
      paramVarArgs.aS(2, this.nJb);
      if (this.nJS != null)
      {
        paramVarArgs.lJ(3, this.nJS.computeSize());
        this.nJS.writeFields(paramVarArgs);
      }
      if (this.nJT != null)
      {
        paramVarArgs.lJ(4, this.nJT.computeSize());
        this.nJT.writeFields(paramVarArgs);
      }
      if (this.nJU != null)
      {
        paramVarArgs.lJ(5, this.nJU.computeSize());
        this.nJU.writeFields(paramVarArgs);
      }
      if (this.nJV != null)
      {
        paramVarArgs.lJ(6, this.nJV.computeSize());
        this.nJV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.nIp) + 0 + f.a.a.b.b.a.bz(2, this.nJb);
      paramInt = i;
      if (this.nJS != null) {
        paramInt = i + f.a.a.a.lI(3, this.nJS.computeSize());
      }
      i = paramInt;
      if (this.nJT != null) {
        i = paramInt + f.a.a.a.lI(4, this.nJT.computeSize());
      }
      paramInt = i;
      if (this.nJU != null) {
        paramInt = i + f.a.a.a.lI(5, this.nJU.computeSize());
      }
      i = paramInt;
      if (this.nJV != null) {
        i = paramInt + f.a.a.a.lI(6, this.nJV.computeSize());
      }
      AppMethodBeat.o(22135);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localac.nIp = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(22135);
        return 0;
      case 2: 
        localac.nJb = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(22135);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nJS = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nJT = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nJU = ((r)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localac.nJV = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    AppMethodBeat.o(22135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */