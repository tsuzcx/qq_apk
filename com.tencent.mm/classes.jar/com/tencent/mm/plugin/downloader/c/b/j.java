package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bv.a
{
  public c kWV;
  public d kWW;
  public f kWX;
  public k kWY;
  public a kWZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35536);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kWV == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_info");
        AppMethodBeat.o(35536);
        throw paramVarArgs;
      }
      if (this.kWV != null)
      {
        paramVarArgs.iQ(1, this.kWV.computeSize());
        this.kWV.writeFields(paramVarArgs);
      }
      if (this.kWW != null)
      {
        paramVarArgs.iQ(2, this.kWW.computeSize());
        this.kWW.writeFields(paramVarArgs);
      }
      if (this.kWX != null)
      {
        paramVarArgs.iQ(3, this.kWX.computeSize());
        this.kWX.writeFields(paramVarArgs);
      }
      if (this.kWY != null)
      {
        paramVarArgs.iQ(4, this.kWY.computeSize());
        this.kWY.writeFields(paramVarArgs);
      }
      if (this.kWZ != null)
      {
        paramVarArgs.iQ(5, this.kWZ.computeSize());
        this.kWZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(35536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWV == null) {
        break label974;
      }
    }
    label974:
    for (int i = e.a.a.a.iP(1, this.kWV.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWW != null) {
        paramInt = i + e.a.a.a.iP(2, this.kWW.computeSize());
      }
      i = paramInt;
      if (this.kWX != null) {
        i = paramInt + e.a.a.a.iP(3, this.kWX.computeSize());
      }
      paramInt = i;
      if (this.kWY != null) {
        paramInt = i + e.a.a.a.iP(4, this.kWY.computeSize());
      }
      i = paramInt;
      if (this.kWZ != null) {
        i = paramInt + e.a.a.a.iP(5, this.kWZ.computeSize());
      }
      AppMethodBeat.o(35536);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.kWV == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_info");
          AppMethodBeat.o(35536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(35536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(35536);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((c)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localj.kWV = ((c)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35536);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localj.kWW = ((d)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35536);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localj.kWX = ((f)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35536);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new k();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localj.kWY = ((k)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(35536);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localj.kWZ = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(35536);
        return 0;
      }
      AppMethodBeat.o(35536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.j
 * JD-Core Version:    0.7.0.1
 */