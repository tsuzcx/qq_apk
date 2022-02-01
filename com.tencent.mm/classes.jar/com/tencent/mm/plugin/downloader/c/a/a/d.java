package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.k;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public k pqk;
  public e pql;
  public c pqm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pqk == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(153044);
        throw paramVarArgs;
      }
      if (this.pqk != null)
      {
        paramVarArgs.lJ(1, this.pqk.computeSize());
        this.pqk.writeFields(paramVarArgs);
      }
      if (this.pql != null)
      {
        paramVarArgs.lJ(2, this.pql.computeSize());
        this.pql.writeFields(paramVarArgs);
      }
      if (this.pqm != null)
      {
        paramVarArgs.lJ(3, this.pqm.computeSize());
        this.pqm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pqk == null) {
        break label666;
      }
    }
    label666:
    for (int i = f.a.a.a.lI(1, this.pqk.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pql != null) {
        paramInt = i + f.a.a.a.lI(2, this.pql.computeSize());
      }
      i = paramInt;
      if (this.pqm != null) {
        i = paramInt + f.a.a.a.lI(3, this.pqm.computeSize());
      }
      AppMethodBeat.o(153044);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.pqk == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_info");
          AppMethodBeat.o(153044);
          throw paramVarArgs;
        }
        AppMethodBeat.o(153044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153044);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.pqk = ((k)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
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
            locald.pql = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.pqm = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153044);
        return 0;
      }
      AppMethodBeat.o(153044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */