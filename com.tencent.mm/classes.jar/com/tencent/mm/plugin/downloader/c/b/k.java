package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bw.a
{
  public d qGY;
  public e qGZ;
  public g qHa;
  public l qHb;
  public b qHc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153071);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qGY == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: base_info");
        AppMethodBeat.o(153071);
        throw paramVarArgs;
      }
      if (this.qGY != null)
      {
        paramVarArgs.ni(1, this.qGY.computeSize());
        this.qGY.writeFields(paramVarArgs);
      }
      if (this.qGZ != null)
      {
        paramVarArgs.ni(2, this.qGZ.computeSize());
        this.qGZ.writeFields(paramVarArgs);
      }
      if (this.qHa != null)
      {
        paramVarArgs.ni(3, this.qHa.computeSize());
        this.qHa.writeFields(paramVarArgs);
      }
      if (this.qHb != null)
      {
        paramVarArgs.ni(4, this.qHb.computeSize());
        this.qHb.writeFields(paramVarArgs);
      }
      if (this.qHc != null)
      {
        paramVarArgs.ni(5, this.qHc.computeSize());
        this.qHc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qGY == null) {
        break label974;
      }
    }
    label974:
    for (int i = g.a.a.a.nh(1, this.qGY.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qGZ != null) {
        paramInt = i + g.a.a.a.nh(2, this.qGZ.computeSize());
      }
      i = paramInt;
      if (this.qHa != null) {
        i = paramInt + g.a.a.a.nh(3, this.qHa.computeSize());
      }
      paramInt = i;
      if (this.qHb != null) {
        paramInt = i + g.a.a.a.nh(4, this.qHb.computeSize());
      }
      i = paramInt;
      if (this.qHc != null) {
        i = paramInt + g.a.a.a.nh(5, this.qHc.computeSize());
      }
      AppMethodBeat.o(153071);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.qGY == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: base_info");
          AppMethodBeat.o(153071);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localk.qGY = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localk.qGZ = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localk.qHa = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localk.qHb = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localk.qHc = ((b)localObject1);
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