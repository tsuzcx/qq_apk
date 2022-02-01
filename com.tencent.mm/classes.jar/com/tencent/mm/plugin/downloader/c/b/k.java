package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bw.a
{
  public d oHk;
  public e oHl;
  public g oHm;
  public l oHn;
  public b oHo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153071);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oHk == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: base_info");
        AppMethodBeat.o(153071);
        throw paramVarArgs;
      }
      if (this.oHk != null)
      {
        paramVarArgs.ln(1, this.oHk.computeSize());
        this.oHk.writeFields(paramVarArgs);
      }
      if (this.oHl != null)
      {
        paramVarArgs.ln(2, this.oHl.computeSize());
        this.oHl.writeFields(paramVarArgs);
      }
      if (this.oHm != null)
      {
        paramVarArgs.ln(3, this.oHm.computeSize());
        this.oHm.writeFields(paramVarArgs);
      }
      if (this.oHn != null)
      {
        paramVarArgs.ln(4, this.oHn.computeSize());
        this.oHn.writeFields(paramVarArgs);
      }
      if (this.oHo != null)
      {
        paramVarArgs.ln(5, this.oHo.computeSize());
        this.oHo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oHk == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.lm(1, this.oHk.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oHl != null) {
        paramInt = i + f.a.a.a.lm(2, this.oHl.computeSize());
      }
      i = paramInt;
      if (this.oHm != null) {
        i = paramInt + f.a.a.a.lm(3, this.oHm.computeSize());
      }
      paramInt = i;
      if (this.oHn != null) {
        paramInt = i + f.a.a.a.lm(4, this.oHn.computeSize());
      }
      i = paramInt;
      if (this.oHo != null) {
        i = paramInt + f.a.a.a.lm(5, this.oHo.computeSize());
      }
      AppMethodBeat.o(153071);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.oHk == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.oHk = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.oHl = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.oHm = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.oHn = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localk.oHo = ((b)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.k
 * JD-Core Version:    0.7.0.1
 */