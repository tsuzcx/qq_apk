package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.k;
import g.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public k qFP;
  public e qFQ;
  public c qFR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153044);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qFP == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(153044);
        throw paramVarArgs;
      }
      if (this.qFP != null)
      {
        paramVarArgs.ni(1, this.qFP.computeSize());
        this.qFP.writeFields(paramVarArgs);
      }
      if (this.qFQ != null)
      {
        paramVarArgs.ni(2, this.qFQ.computeSize());
        this.qFQ.writeFields(paramVarArgs);
      }
      if (this.qFR != null)
      {
        paramVarArgs.ni(3, this.qFR.computeSize());
        this.qFR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qFP == null) {
        break label666;
      }
    }
    label666:
    for (int i = g.a.a.a.nh(1, this.qFP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qFQ != null) {
        paramInt = i + g.a.a.a.nh(2, this.qFQ.computeSize());
      }
      i = paramInt;
      if (this.qFR != null) {
        i = paramInt + g.a.a.a.nh(3, this.qFR.computeSize());
      }
      AppMethodBeat.o(153044);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.qFP == null)
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locald.qFP = ((k)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
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
            locald.qFQ = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locald.qFR = ((c)localObject1);
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