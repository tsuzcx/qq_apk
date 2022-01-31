package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.b.j;
import e.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public j kVQ;
  public e kVR;
  public c kVS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35511);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kVQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: app_info");
        AppMethodBeat.o(35511);
        throw paramVarArgs;
      }
      if (this.kVQ != null)
      {
        paramVarArgs.iQ(1, this.kVQ.computeSize());
        this.kVQ.writeFields(paramVarArgs);
      }
      if (this.kVR != null)
      {
        paramVarArgs.iQ(2, this.kVR.computeSize());
        this.kVR.writeFields(paramVarArgs);
      }
      if (this.kVS != null)
      {
        paramVarArgs.iQ(3, this.kVS.computeSize());
        this.kVS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(35511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVQ == null) {
        break label666;
      }
    }
    label666:
    for (int i = e.a.a.a.iP(1, this.kVQ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kVR != null) {
        paramInt = i + e.a.a.a.iP(2, this.kVR.computeSize());
      }
      i = paramInt;
      if (this.kVS != null) {
        i = paramInt + e.a.a.a.iP(3, this.kVS.computeSize());
      }
      AppMethodBeat.o(35511);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.kVQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: app_info");
          AppMethodBeat.o(35511);
          throw paramVarArgs;
        }
        AppMethodBeat.o(35511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35511);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locald.kVQ = ((j)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35511);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locald.kVR = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35511);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new c();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locald.kVS = ((c)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(35511);
        return 0;
      }
      AppMethodBeat.o(35511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.d
 * JD-Core Version:    0.7.0.1
 */