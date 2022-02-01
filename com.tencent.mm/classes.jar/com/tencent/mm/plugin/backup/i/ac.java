package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends com.tencent.mm.bw.a
{
  public int ncx;
  public int ndj;
  public q nea;
  public p neb;
  public r nec;
  public s ned;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22135);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ncx);
      paramVarArgs.aR(2, this.ndj);
      if (this.nea != null)
      {
        paramVarArgs.ln(3, this.nea.computeSize());
        this.nea.writeFields(paramVarArgs);
      }
      if (this.neb != null)
      {
        paramVarArgs.ln(4, this.neb.computeSize());
        this.neb.writeFields(paramVarArgs);
      }
      if (this.nec != null)
      {
        paramVarArgs.ln(5, this.nec.computeSize());
        this.nec.writeFields(paramVarArgs);
      }
      if (this.ned != null)
      {
        paramVarArgs.ln(6, this.ned.computeSize());
        this.ned.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ncx) + 0 + f.a.a.b.b.a.bx(2, this.ndj);
      paramInt = i;
      if (this.nea != null) {
        paramInt = i + f.a.a.a.lm(3, this.nea.computeSize());
      }
      i = paramInt;
      if (this.neb != null) {
        i = paramInt + f.a.a.a.lm(4, this.neb.computeSize());
      }
      paramInt = i;
      if (this.nec != null) {
        paramInt = i + f.a.a.a.lm(5, this.nec.computeSize());
      }
      i = paramInt;
      if (this.ned != null) {
        i = paramInt + f.a.a.a.lm(6, this.ned.computeSize());
      }
      AppMethodBeat.o(22135);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localac.ncx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(22135);
        return 0;
      case 2: 
        localac.ndj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(22135);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new q();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((q)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nea = ((q)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new p();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((p)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.neb = ((p)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localac.nec = ((r)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(22135);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new s();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((s)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localac.ned = ((s)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(22135);
      return 0;
    }
    AppMethodBeat.o(22135);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ac
 * JD-Core Version:    0.7.0.1
 */