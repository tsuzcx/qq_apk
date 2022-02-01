package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public d odL;
  public e odM;
  public g odN;
  public l odO;
  public b odP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153071);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.odL == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: base_info");
        AppMethodBeat.o(153071);
        throw paramVarArgs;
      }
      if (this.odL != null)
      {
        paramVarArgs.kX(1, this.odL.computeSize());
        this.odL.writeFields(paramVarArgs);
      }
      if (this.odM != null)
      {
        paramVarArgs.kX(2, this.odM.computeSize());
        this.odM.writeFields(paramVarArgs);
      }
      if (this.odN != null)
      {
        paramVarArgs.kX(3, this.odN.computeSize());
        this.odN.writeFields(paramVarArgs);
      }
      if (this.odO != null)
      {
        paramVarArgs.kX(4, this.odO.computeSize());
        this.odO.writeFields(paramVarArgs);
      }
      if (this.odP != null)
      {
        paramVarArgs.kX(5, this.odP.computeSize());
        this.odP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.odL == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.kW(1, this.odL.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.odM != null) {
        paramInt = i + f.a.a.a.kW(2, this.odM.computeSize());
      }
      i = paramInt;
      if (this.odN != null) {
        i = paramInt + f.a.a.a.kW(3, this.odN.computeSize());
      }
      paramInt = i;
      if (this.odO != null) {
        paramInt = i + f.a.a.a.kW(4, this.odO.computeSize());
      }
      i = paramInt;
      if (this.odP != null) {
        i = paramInt + f.a.a.a.kW(5, this.odP.computeSize());
      }
      AppMethodBeat.o(153071);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.odL == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: base_info");
          AppMethodBeat.o(153071);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153071);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.odL = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.odM = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.odN = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.odO = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localk.odP = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153071);
        return 0;
      }
      AppMethodBeat.o(153071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.k
 * JD-Core Version:    0.7.0.1
 */