package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bw.a
{
  public d prt;
  public e pru;
  public g prv;
  public l prw;
  public b prx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153071);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.prt == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: base_info");
        AppMethodBeat.o(153071);
        throw paramVarArgs;
      }
      if (this.prt != null)
      {
        paramVarArgs.lJ(1, this.prt.computeSize());
        this.prt.writeFields(paramVarArgs);
      }
      if (this.pru != null)
      {
        paramVarArgs.lJ(2, this.pru.computeSize());
        this.pru.writeFields(paramVarArgs);
      }
      if (this.prv != null)
      {
        paramVarArgs.lJ(3, this.prv.computeSize());
        this.prv.writeFields(paramVarArgs);
      }
      if (this.prw != null)
      {
        paramVarArgs.lJ(4, this.prw.computeSize());
        this.prw.writeFields(paramVarArgs);
      }
      if (this.prx != null)
      {
        paramVarArgs.lJ(5, this.prx.computeSize());
        this.prx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.prt == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.lI(1, this.prt.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pru != null) {
        paramInt = i + f.a.a.a.lI(2, this.pru.computeSize());
      }
      i = paramInt;
      if (this.prv != null) {
        i = paramInt + f.a.a.a.lI(3, this.prv.computeSize());
      }
      paramInt = i;
      if (this.prw != null) {
        paramInt = i + f.a.a.a.lI(4, this.prw.computeSize());
      }
      i = paramInt;
      if (this.prx != null) {
        i = paramInt + f.a.a.a.lI(5, this.prx.computeSize());
      }
      AppMethodBeat.o(153071);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.prt == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.prt = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pru = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.prv = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.prw = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localk.prx = ((b)localObject1);
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