package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.k;
import f.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public k oGb;
  public e oGc;
  public c oGd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oGb == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(153044);
        throw paramVarArgs;
      }
      if (this.oGb != null)
      {
        paramVarArgs.ln(1, this.oGb.computeSize());
        this.oGb.writeFields(paramVarArgs);
      }
      if (this.oGc != null)
      {
        paramVarArgs.ln(2, this.oGc.computeSize());
        this.oGc.writeFields(paramVarArgs);
      }
      if (this.oGd != null)
      {
        paramVarArgs.ln(3, this.oGd.computeSize());
        this.oGd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oGb == null) {
        break label666;
      }
    }
    label666:
    for (int i = f.a.a.a.lm(1, this.oGb.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oGc != null) {
        paramInt = i + f.a.a.a.lm(2, this.oGc.computeSize());
      }
      i = paramInt;
      if (this.oGd != null) {
        i = paramInt + f.a.a.a.lm(3, this.oGd.computeSize());
      }
      AppMethodBeat.o(153044);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.oGb == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locald.oGb = ((k)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
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
            locald.oGc = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153044);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.oGd = ((c)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */