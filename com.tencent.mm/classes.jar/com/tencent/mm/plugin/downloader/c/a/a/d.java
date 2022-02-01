package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.k;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public k ocC;
  public e ocD;
  public c ocE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ocC == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(153044);
        throw paramVarArgs;
      }
      if (this.ocC != null)
      {
        paramVarArgs.kX(1, this.ocC.computeSize());
        this.ocC.writeFields(paramVarArgs);
      }
      if (this.ocD != null)
      {
        paramVarArgs.kX(2, this.ocD.computeSize());
        this.ocD.writeFields(paramVarArgs);
      }
      if (this.ocE != null)
      {
        paramVarArgs.kX(3, this.ocE.computeSize());
        this.ocE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ocC == null) {
        break label666;
      }
    }
    label666:
    for (int i = f.a.a.a.kW(1, this.ocC.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ocD != null) {
        paramInt = i + f.a.a.a.kW(2, this.ocD.computeSize());
      }
      i = paramInt;
      if (this.ocE != null) {
        i = paramInt + f.a.a.a.kW(3, this.ocE.computeSize());
      }
      AppMethodBeat.o(153044);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.ocC == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.ocC = ((k)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
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
            locald.ocD = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.ocE = ((c)localObject1);
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