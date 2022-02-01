package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bx.a
{
  public d pkO;
  public e pkP;
  public g pkQ;
  public l pkR;
  public b pkS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153071);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pkO == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: base_info");
        AppMethodBeat.o(153071);
        throw paramVarArgs;
      }
      if (this.pkO != null)
      {
        paramVarArgs.lC(1, this.pkO.computeSize());
        this.pkO.writeFields(paramVarArgs);
      }
      if (this.pkP != null)
      {
        paramVarArgs.lC(2, this.pkP.computeSize());
        this.pkP.writeFields(paramVarArgs);
      }
      if (this.pkQ != null)
      {
        paramVarArgs.lC(3, this.pkQ.computeSize());
        this.pkQ.writeFields(paramVarArgs);
      }
      if (this.pkR != null)
      {
        paramVarArgs.lC(4, this.pkR.computeSize());
        this.pkR.writeFields(paramVarArgs);
      }
      if (this.pkS != null)
      {
        paramVarArgs.lC(5, this.pkS.computeSize());
        this.pkS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pkO == null) {
        break label974;
      }
    }
    label974:
    for (int i = f.a.a.a.lB(1, this.pkO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pkP != null) {
        paramInt = i + f.a.a.a.lB(2, this.pkP.computeSize());
      }
      i = paramInt;
      if (this.pkQ != null) {
        i = paramInt + f.a.a.a.lB(3, this.pkQ.computeSize());
      }
      paramInt = i;
      if (this.pkR != null) {
        paramInt = i + f.a.a.a.lB(4, this.pkR.computeSize());
      }
      i = paramInt;
      if (this.pkS != null) {
        i = paramInt + f.a.a.a.lB(5, this.pkS.computeSize());
      }
      AppMethodBeat.o(153071);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.pkO == null)
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pkO = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pkP = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pkQ = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new l();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localk.pkR = ((l)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153071);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localk.pkS = ((b)localObject1);
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